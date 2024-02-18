/**
 * 休假管理 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-16 20:49:27
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	
	//模块基础路径
	const moduleURL="/service-hr/hr-attendance-holiday";
	const queryURL=moduleURL+'/query-paged-list';
	const deleteURL=moduleURL+'/delete';
	const batchDeleteURL=moduleURL+'/delete-by-ids';
	const getByIdURL=moduleURL+'/get-by-id';
	//
	var searchContent_orgId;
	var dataTable=null;
	var sort=null;

	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;

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
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'personId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('人员'), templet: function (d) { return templet('personId' ,fox.joinLabel(d.person,"name",',','','personId'),d);}}
					,{ field: 'actionType', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('休假类型'), templet: function (d) { return templet('actionType' ,fox.joinLabel(d.typeDict,"label",',','','actionType'),d);}}
					,{ field: 'actionDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('休假日期') ,templet: function (d) { return templet('actionDate',fox.dateFormat(d.actionDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'actionSTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('开始时间') ,templet: function (d) { return templet('actionSTime',fox.dateFormat(d.actionSTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'actionETime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('结束时间') ,templet: function (d) { return templet('actionETime',fox.dateFormat(d.actionETime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'actionDays', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('休假天数') , templet: function (d) { return templet('actionDays',d.actionDays,d);}  }
					,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('休假备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
					,{ field: 'batchCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('批次号') , templet: function (d) { return templet('batchCode',d.batchCode,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:true, sort: true   ,title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'personJobNumber', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('工号') , templet: function (d) { return templet('personJobNumber',fox.getProperty(d,["person","jobNumber"],0,'','personJobNumber'),d);} }
					,{ field: fox.translate('空白列','','cmp:table'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作','','cmp:table'), width: 160 }
				]],
				done: function (data) {
					lockSwitchInputs();
					window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data);
				},
				footer : {
					exportExcel :  admin.checkAuth(AUTH_PREFIX+":export") ,
					importExcel :  admin.checkAuth(AUTH_PREFIX+":import")?{
						params : {} ,
						callback : function(r) {
							if(r.success) {
								layer.msg(fox.translate('数据导入成功','','cmp:table')+"!");
							} else {
								layer.msg(fox.translate('数据导入失败','','cmp:table')+"!");
							}
							// 是否执行后续逻辑：错误提示
							return false;
						}
					}:false 
				}
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			dataTable=fox.renderTable(tableConfig);
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
			  refreshTableData(obj.sortField,obj.type);
			});
			window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
		}
		setTimeout(renderTableInternal,1);
    };

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
		value.personId={ inputType:"select_box", value: getSelectedValue("#personId","value") ,fillBy:["person"]  , label:getSelectedValue("#personId","nameStr") };
		value.actionType={ inputType:"select_box", value: getSelectedValue("#actionType","value") ,fillBy:["typeDict"]  , label:getSelectedValue("#actionType","nameStr") };
		value.actionDate={ inputType:"date_input", begin: $("#actionDate-begin").val(), end: $("#actionDate-end").val() ,matchType:"auto" };
		value.actionSTime={ inputType:"date_input", begin: $("#actionSTime-begin").val(), end: $("#actionSTime-end").val() ,matchType:"auto" };
		value.batchCode={ inputType:"button",value: $("#batchCode").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.personJobNumber={ inputType:"button",value: $("#personJobNumber").val(),fillBy:["person","jobNumber"] };

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
		if($("#personJobNumber").val()&&$("#personJobNumber").val().length>0){
			ps.personJobNumber=$("#personJobNumber").val();
		}
		if(reset) {
			table.reload('data-table', { where : ps , page:{ curr:1 } });
		} else {
			table.reload('data-table', { where : ps });
		}
	}


	function searchOrg(orgId){
		searchContent_orgId=orgId;
		refreshTableData()
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

		fox.switchSearchRow(2);

		//渲染 personId 下拉字段
		fox.renderSelectBox({
			el: "personId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("personId",data.arr,data.change,data.isAdd);
				},1);
			},
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					if(window.pageExt.list.selectBoxDataTransform) {
						opts.push(window.pageExt.list.selectBoxDataTransform("personId",{data:data[i],name:data[i].name,value:data[i].id},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id});
					}
				}
				return opts;
			}
		});
		//渲染 actionType 下拉字段
		fox.renderSelectBox({
			el: "actionType",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("actionType",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					if(window.pageExt.list.selectBoxDataTransform) {
						opts.push(window.pageExt.list.selectBoxDataTransform("actionType",{data:data[i],name:data[i].label,value:data[i].code},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code});
					}
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#actionDate-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("actionDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#actionDate-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("actionDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#actionSTime-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("actionSTime",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#actionSTime-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("actionSTime",value, date, endDate);
				},1);
			}
		});
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
			fox.switchSearchRow(2,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
		});

	}

	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {

		//头工具栏事件
		table.on('toolbar(data-table)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
			var selected=getCheckedList("id");
			if(window.pageExt.list.beforeToolBarButtonEvent) {
				var doNext=window.pageExt.list.beforeToolBarButtonEvent(selected,obj);
				if(!doNext) return;
			}
			switch(obj.event){
				case 'create':
					admin.putTempData('hr-attendance-holiday-form-data', {});
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'tool-import-data':
					window.pageExt.list.importData && window.pageExt.list.importData(selected,obj);
					break;
				case 'tool-export-data':
					window.pageExt.list.exportData && window.pageExt.list.exportData(selected,obj);
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
			admin.putTempData('hr-attendance-holiday-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的'+'休假管理'+"!"));
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的'+'休假管理'+'吗？'), function (i) {
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
		// 工具条点击事件
		table.on('tool(data-table)', function (obj) {
			var data = obj.data;
			var layEvent = obj.event;

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('hr-attendance-holiday-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				top.layer.load(2);
				top.layer.load(2);
				admin.post(getByIdURL, { id : data.id }, function (data) {
					top.layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('hr-attendance-holiday-form-data-form-action', "edit",true);
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
						admin.putTempData('hr-attendance-holiday-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						fox.showMessage(data);
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}

				top.layer.confirm(fox.translate('确定删除此'+'休假管理'+'吗？'), function (i) {
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
		var action=admin.getTempData('hr-attendance-holiday-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('hr-attendance-holiday-form-data', data);
		var area=admin.getTempData('hr-attendance-holiday-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('休假管理');
		if(action=="create") title=fox.translate('添加','','cmp:table')+title;
		else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
		else if(action=="view") title=fox.translate('查看','','cmp:table')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["75%",height+"px"],
			type: 2,
			id:"hr-attendance-holiday-form-data-win",
			content: '/business/hr/attendance_holiday/attendance_holiday_form.html' + (queryString?("?"+queryString):""),
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