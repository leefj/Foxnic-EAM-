/**
 * 单据任务 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 12:50:50
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,tableChild,tableMerge;

	//模块基础路径
	const moduleURL="/service-hr/hr-assessment-bill-task";
	const queryURL=moduleURL+'/query-paged-list';
	const deleteURL=moduleURL+'/delete';
	const batchDeleteURL=moduleURL+'/delete-by-ids';
	const getByIdURL=moduleURL+'/get-by-id';
	//
	var dataTable=null;
	var sort=null;

	var searchContent_orgId;

	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {


		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;
		tableMerge = layui.tableMerge;
		tableChild=layui.tableChild;

		if(window.pageExt.list.beforeInit) {
			window.pageExt.list.beforeInit();
		}
		//渲染表格
		renderTable();
		//初始化搜索输入框组件
		initSearchFields();
		//绑定搜索框事件
		bindSearchEvent();
		//绑定按钮事件
		bindButtonEvent();
		//绑定行操作按钮事件
		bindRowOperationEvent();

		$('.task-Action').click(function(){
			console.log("12345");
		})
	}


	/**
	 * 渲染表格
	 */
	function renderTable() {
		$(window).resize(function() {
			fox.adjustSearchElement();
		});
		fox.adjustSearchElement();
		//
		var marginTop=$(".search-bar").height()+$(".search-bar").css("padding-top")+$(".search-bar").css("padding-bottom")
		$("#table-area").css("margin-top",marginTop+"px");
		//
		function renderTableInternal() {

			var ps={searchField: "$composite"};
			var contitions={};

			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			}
			ps.searchValue=JSON.stringify(contitions);

			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			var tableConfig={
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: fox.translate('刷新数据','','cmp:table'),layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: queryURL,
				method:"post",
				height: 'full-'+(h+28),
				limit: 50,
				page:true,
				where: ps,
				cols: [[
					{title: '#', width: 50,hide:false, spread: false,children:function(row){
							return [
								{
									title: '任务明细',
									url: '/service-hr/hr-assessment-bill-task-dtl/query-paged-list',
									method:"post",
									page:false,
								//	toolbar: '#toolbarTemplate2',
									// ,height: 300
								toolEvent: function (obj, pobj) {
								// obj 子表当前行对象
								// pobj 父表当前行对象

								var childId = this.id; // 通过 this 对象获取当前子表的id

								if (obj.event === 'childPf') {
									admin.popupCenter({
										title: "评分",
										resize: false,
										offset: [10,null],
										area: ["95%","95%"],
										type: 2,
										id:"hr-assessment-bill-task-paper-list-data-win",
										content: '/business/hr/assessment_bill_task_paper/bill_task_paper_list.html?billTaskDtlId='+obj.data.id,
										finish: function () {
											admin.post("/service-hr/hr-assessment-bill-task-paper/get-by-id", { id : obj.data.id }, function (r) {
												if (r.success) {
													var contextdata = r.data;
													obj.update(contextdata);
												}
											});

										}
									});
								}
							}
									,cols: [[
										{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
										,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('状态'), templet:function (d){ return templet('status',fox.getEnumText(RADIO_STATUS_DATA,d.status,'','status'),d);}}
										,{ field: 'relationship', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('考核方式'), templet:function (d){ return templet('relationship',fox.getEnumText(RADIO_RELATIONSHIP_DATA,d.relationship,'','relationship'),d);}}
										,{ field: 'assesseeStr', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('被考核人') , templet: function (d) { return templet('assesseeStr',d.assesseeStr,d);}  }
								//		,{ field: 'rcdTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('操作时间') ,templet: function (d) { return templet('rcdTime',fox.dateFormat(d.rcdTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
										,{ field: fox.translate('空白列','','cmp:table'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
										,{ field: 'row-ops1', fixed: 'right', align: 'center',title: fox.translate('操作','','cmp:table'), width: 160, templet:
												function(r) {
													return '<a class="layui-btn layui-btn-xs" lay-event="childPf">评分表</a>'
												}
											}
									]]
									,where: {"billTaskId":row.id}

									,parseData: function(res){ //res 即为原始返回的数据
										console.log("res",res);
										return {
											"code": res.code, //解析接口状态
											"msg": res.message, //解析提示文本
											"count": res.totalRowCount, //解析数据长度
											"data": res.data.list //解析数据列表
										};
									}
									,done: function () {
										tableChild.render(this);
									}
								}
							]

						}
							}
					,
					{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'assessorId',align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('考核人') , templet: function (d) { return templet('assessorId',fox.getProperty(d,["assessor","name"],0,'','assessorId'),d);} }
					,{ field: 'nameStr',align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('名称') , templet: function (d) { return templet('nameStr',fox.getProperty(d,["assessmentBill","nameStr"],0,'','nameStr'),d);} }
					,{ field: 'stimeStr', align:"", fixed:false, hide:false, sort: false   ,title: fox.translate('开始时间')  ,templet: function (d) { return templet('stimeStr',fox.dateFormat(fox.getProperty(d,["assessmentBill","stimeStr"],0,'','stimeStr'),"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'etimeStr', align:"", fixed:false, hide:false, sort: false   ,title: fox.translate('结束时间')  ,templet: function (d) { return templet('etimeStr',fox.dateFormat(fox.getProperty(d,["assessmentBill","etimeStr"],0,'','etimeStr'),"yyyy-MM-dd HH:mm:ss"),d); }  }
				//	,{ field: 'rcdTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('记录时间') ,templet: function (d) { return templet('rcdTime',fox.dateFormat(d.rcdTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'row-ops', fixed: 'right', align: 'center', templet:function(r) {
							return '    <button  id="add-button" class="layui-btn icon-btn layui-btn-sm tj-new-button "  data-id="{{d.id}}"  lay-event="tj" ><span>提交</span></button>'
						}, title: fox.translate('操作','','cmp:table'), width: 160 }
				]]
				,toolEvent: function (obj) {
					if (obj.event === 'tj') {
						top.layer.confirm(fox.translate('确定是否提交所有任务？'), function (i) {
							top.layer.close(i);
							admin.post("/service-hr/hr-assessment-bill-task/submit", {id:obj.data.id}, function (r) {
								if (r.success) {
								}
								fox.showMessage(r);
							},{delayLoading:100, elms:[]});
						});
					}

					if (obj.event === 'pfb') {
						admin.popupCenter({
							title: "评分表",
							resize: false,
							offset: [20,null],
							area: ["75%","75%"],
							type: 2,
							id:"hr-assessment-bill-task-list-data-win",
							content: '/business/hr/assessment_bill_task_dtl/assessment_bill_task_dtl_list.html?billId='+BILL_ID ,
							finish: function () {

							}
						});
					}


				}
				,parseData: function(res){ //res 即为原始返回的数据
					console.log("res",res);
					return {
						"code": res.code, //解析接口状态
						"msg": res.message, //解析提示文本
						"count": res.totalRowCount, //解析数据长度
						"data": res.data.list //解析数据列表
					};
				},
				done: function (data) {
					console.log(data);
					lockSwitchInputs();
					window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data);
					tableChild.render(this);
				},
				footer : {
					exportExcel : false ,
					importExcel : false
				}
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			dataTable=table.render(tableConfig);
			table.on('toolbar(data-table)', function(obj){
				switch(obj.event){
					case 'pfb':
						admin.popupCenter({
							title: "评分表",
							resize: false,
							offset: [20,null],
							area: ["75%","75%"],
							type: 2,
							id:"hr-assessment-bill-task-list-data-win",
							content: '/business/hr/assessment_bill_task_dtl/assessment_bill_task_dtl_list.html?billId='+BILL_ID ,
							finish: function () {
							}
						});
						break;

				};
			});

			//绑定排序事件
			table.on('sort(data-table)', function(obj){
				refreshTableData(obj.sortField,obj.type);
			});
			window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
		}
		setTimeout(renderTableInternal,1);
	};



	function searchOrg(orgId){
		searchContent_orgId=orgId;
		refreshTableData()
	}


	/**
	 * 刷新单号数据
	 * */
	function refreshRowData(data,remote) {
		var context=dataTable.getDataRowContext( { id : data.id } );
		if(context==null) return;
		if(remote) {
			admin.post(getByIdURL, { id : data.id }, function (r) {
				if (r.success) {
					data = r.data;
					context.update(data);
					fox.renderFormInputs(form);
					lockSwitchInputs();
					window.pageExt.list.afterRefreshRowData && window.pageExt.list.afterRefreshRowData(data,remote,context);
				} else {
					fox.showMessage(data);
				}
			});
		} else {
			context.update(data);
			fox.renderFormInputs(form);
			lockSwitchInputs();
			window.pageExt.list.afterRefreshRowData && window.pageExt.list.afterRefreshRowData(data,remote,context);
		}
	}



	function lockSwitchInputs() {
	}

	function lockSwitchInput(field) {
		var inputs=$("[lay-id=data-table]").find("td[data-field='"+field+"']").find("input");
		var switchs=$("[lay-id=data-table]").find("td[data-field='"+field+"']").find(".layui-form-switch");
		inputs.attr("readonly", "yes");
		inputs.attr("disabled", "yes");
		switchs.addClass("layui-disabled");
		switchs.addClass("layui-checkbox-disabled");
		switchs.addClass("layui-form-switch-disabled");
	}

	/**
	 * 刷新表格数据
	 */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.assessorId={ inputType:"button",value: $("#assessorId").val(),fillBy:["assessor","name"] ,label:$("#assessorId-button").text() };
		var ps={searchField:"$composite"};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
		}
		ps.searchValue=JSON.stringify(value);
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
			sort={ field : sortField,type : sortType} ;
		} else {
			if(sort) {
				ps.sortField=sort.field;
				ps.sortType=sort.type;
			} 		}
		if(searchContent_orgId){
			if(value.sOrgId){
				delete value.sOrgId ;
			}
			ps.sOrgId=searchContent_orgId;
		}

		if(reset) {
			table.reload('data-table', { where : ps , page:{ curr:1 } });
		} else {
			table.reload('data-table', { where : ps });
		}
	}


	/**
	 * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	 */
	function getCheckedList(field) {
		var checkStatus = table.checkStatus('data-table');
		var data = checkStatus.data;
		if(!field) return data;
		for(var i=0;i<data.length;i++) data[i]=data[i][field];
		return data;
	}

	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {
		$('#search-field').val("");
		$('#search-input').val("");
		layui.form.render();
	}

	function initSearchFields() {

		fox.switchSearchRow(1);

		fox.renderSearchInputs();
		window.pageExt.list.afterSearchInputReady && window.pageExt.list.afterSearchInputReady();
	}

	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {
		//回车键查询
		$(".search-input").keydown(function(event) {
			if(event.keyCode !=13) return;
			refreshTableData(null,null,true);
		});

		// 搜索按钮点击事件
		$('#search-button').click(function () {
			refreshTableData(null,null,true);
		});

		// 搜索按钮点击事件
		$('#search-button-advance').click(function () {
			fox.switchSearchRow(1,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
		});

		// 请选择人员对话框
		$("#assessorId-button").click(function(){
			var assessorIdDialogOptions={
				field:"assessorId",
				inputEl:$("#assessorId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseEmployee(assessorIdDialogOptions);
		});
	}

	/**
	 * 绑定按钮事件
	 */
	function bindButtonEvent() {


		table.on('toolbar(data-table)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
			var selected=getCheckedList("id");
			if(window.pageExt.list.beforeToolBarButtonEvent) {
				var doNext=window.pageExt.list.beforeToolBarButtonEvent(selected,obj);
				if(!doNext) return;
			}
			switch(obj.event){
				case 'pfb':
					admin.popupCenter({
						title: "评分表",
						resize: false,
						offset: [20,null],
						area: ["75%","75%"],
						type: 2,
						id:"hr-assessment-bill-task-list-data-win",
						content: '/business/hr/assessment_bill_task_dtl/assessment_bill_task_dtl_list.html?billId='+BILL_ID ,
						finish: function () {

						}
					});
					break;
				case 'create':
					admin.putTempData('hr-assessment-bill-task-form-data', {});
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'refresh-data':
					refreshTableData();
					break;
				case 'other':
					break;
			};
		});


		//添加按钮点击事件
		function openCreateFrom() {
			//设置新增是初始化数据
			var data={};
			admin.putTempData('hr-assessment-bill-task-form-data-form-action', "create",true);
			showEditForm(data);
		};

		//批量删除按钮点击事件
		function batchDelete(selected) {

			if(window.pageExt.list.beforeBatchDelete) {
				var doNext=window.pageExt.list.beforeBatchDelete(selected);
				if(!doNext) return;
			}

			var ids=getCheckedList("id");
			if(ids.length==0) {
				top.layer.msg(fox.translate('请选择需要删除的'+'单据任务'+"!"));
				return;
			}
			//调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的'+'单据任务'+'吗？'), function (i) {
				top.layer.close(i);
				admin.post(batchDeleteURL, { ids: ids }, function (data) {
					if (data.success) {
						if(window.pageExt.list.afterBatchDelete) {
							var doNext=window.pageExt.list.afterBatchDelete(data);
							if(!doNext) return;
						}
						fox.showMessage(data);
						refreshTableData();
					} else {
						if(data.data>0) {
							refreshTableData();
						}
						fox.showMessage(data);
					}
				},{delayLoading:200,elms:[$("#delete-button")]});
			});
		}
	}

	/**
	 * 绑定行操作按钮事件
	 */
	function bindRowOperationEvent() {

		table.on('toolbar(data-table)', function (obj) {

			console.log("########################################")

			var data = obj.data;
			var layEvent = obj.event;

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('hr-assessment-bill-task-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				top.layer.load(2);
				top.layer.load(2);
				admin.post(getByIdURL, { id : data.id }, function (data) {
					top.layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('hr-assessment-bill-task-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						fox.showMessage(data);
					}
				});
			} else if (layEvent === 'view') { // 查看
				top.layer.load(2);
				admin.post(getByIdURL, { id : data.id }, function (data) {
					top.layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('hr-assessment-bill-task-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						fox.showMessage(data);
					}
				});
			}
			else if (layEvent === 'tj') { // 删除
				top.layer.confirm(fox.translate('确定是否提交所有任务？'), function (i) {
					top.layer.close(i);
					admin.post("/service-hr/hr-assessment-bill-task/submit", {id:data.id}, function (r) {
						if (r.success) {
							fox.showMessage(r);
						}
					},{delayLoading:100, elms:[$(".tj-new-button[data-id='"+data.id+"']")]});
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}

				top.layer.confirm(fox.translate('确定删除此'+'单据任务'+'吗？'), function (i) {
					top.layer.close(i);
					admin.post(deleteURL, { id : data.id }, function (data) {
						top.layer.closeAll('loading');
						if (data.success) {
							if(window.pageExt.list.afterSingleDelete) {
								var doNext=window.pageExt.list.afterSingleDelete(data);
								if(!doNext) return;
							}
							fox.showMessage(data);
							refreshTableData();
						} else {
							fox.showMessage(data);
						}
					},{delayLoading:100, elms:[$(".ops-delete-button[data-id='"+data.id+"']")]});
				});
			}
			else if (layEvent === 'task-action') { // 任务单
				console.log("123");
			}

		});

	};

	/**
	 * 打开编辑窗口
	 */
	function showEditForm(data) {
		if(window.pageExt.list.beforeEdit) {
			var doNext=window.pageExt.list.beforeEdit(data);
			if(!doNext) return;
		}
		var action=admin.getTempData('hr-assessment-bill-task-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('hr-assessment-bill-task-form-data', data);
		var area=admin.getTempData('hr-assessment-bill-task-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('单据任务');
		if(action=="create") title=fox.translate('添加','','cmp:table')+title;
		else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
		else if(action=="view") title=fox.translate('查看','','cmp:table')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["75%",height+"px"],
			type: 2,
			id:"hr-assessment-bill-task-form-data-win",
			content: '/business/hr/assessment_bill_task/assessment_bill_task_form.html' + (queryString?("?"+queryString):""),
			finish: function () {
				if(action=="create") {
					refreshTableData();
				}
				if(action=="edit") {
					false?refreshTableData():refreshRowData(data,true);
				}
			}
		});
	};

	window.module={
		searchOrg:searchOrg,
		refreshTableData: refreshTableData,
		refreshRowData: refreshRowData,
		getCheckedList: getCheckedList,
		showEditForm: showEditForm
	};

	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {

	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});