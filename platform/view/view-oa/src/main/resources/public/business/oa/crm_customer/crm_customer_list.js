/**
 * 客户 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 20:34:51
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	
	//模块基础路径
	const moduleURL="/service-oa/oa-crm-customer";
	const queryURL=moduleURL+'/query-paged-list';
	const deleteURL=moduleURL+'/delete';
	const batchDeleteURL=moduleURL+'/delete-by-ids';
	const getByIdURL=moduleURL+'/get-by-id';
	//
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
					,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('客户编码') , templet: function (d) { return templet('code',d.code,d);}  }
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('客户名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'level', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('客户等级'), templet: function (d) { return templet('level' ,fox.joinLabel(d.crmCustomerLevel,"name",',','','level'),d);}}
					,{ field: 'ownerId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('负责人') , templet: function (d) { return templet('ownerId',fox.getProperty(d,["owner","name"],0,'','ownerId'),d);} }
					,{ field: 'contacts', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('联系人') , templet: function (d) { return templet('contacts',d.contacts,d);}  }
					,{ field: 'contactInfo', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('联系方式') , templet: function (d) { return templet('contactInfo',d.contactInfo,d);}  }
					,{ field: 'industryId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('所在行业'), templet: function (d) { return templet('industryId' ,fox.joinLabel(d.crmCustomerIndustry,"name",',','','industryId'),d);}}
					,{ field: 'sourceId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('客户来源'), templet: function (d) { return templet('sourceId' ,fox.joinLabel(d.crmCustomerSource,"name",',','','sourceId'),d);}}
					,{ field: 'recentFollowTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('最近跟进') ,templet: function (d) { return templet('recentFollowTime',fox.dateFormat(d.recentFollowTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'nextFollowTime', align:"right", fixed:false, hide:true, sort: true   ,title: fox.translate('下次跟进') ,templet: function (d) { return templet('nextFollowTime',fox.dateFormat(d.nextFollowTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'transactionStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('成交状态'), templet:function (d){ return templet('transactionStatus',fox.getEnumText(RADIO_TRANSACTIONSTATUS_DATA,d.transactionStatus,'','transactionStatus'),d);}}
					,{ field: 'locked', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('是否锁定'), templet:function (d){ return templet('locked',fox.getEnumText(RADIO_LOCKED_DATA,d.locked,'','locked'),d);}}
					,{ field: 'originatorId', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',fox.getProperty(d,["originator","name"],0,'','originatorId'),d);} }
					,{ field: fox.translate('空白列','','cmp:table'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作','','cmp:table'), width: 160 }
				]],
				done: function (data) {
					lockSwitchInputs();
					window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data);
				},
				footer : {
					exportExcel : false ,
					importExcel : false 
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
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.level={ inputType:"select_box", value: getSelectedValue("#level","value") ,fillBy:["crmCustomerLevel"]  , label:getSelectedValue("#level","nameStr") };
		value.ownerId={ inputType:"button",value: $("#ownerId").val(),fillBy:["owner","name"] ,label:$("#ownerId-button").text() };
		value.intentionalState={ inputType:"select_box", value: getSelectedValue("#intentionalState","value") ,fillBy:["crmCustomerIntentional"]  , label:getSelectedValue("#intentionalState","nameStr") };
		value.industryId={ inputType:"select_box", value: getSelectedValue("#industryId","value") ,fillBy:["crmCustomerIndustry"]  , label:getSelectedValue("#industryId","nameStr") };
		value.sourceId={ inputType:"select_box", value: getSelectedValue("#sourceId","value") ,fillBy:["crmCustomerSource"]  , label:getSelectedValue("#sourceId","nameStr") };
		value.recentFollowTime={ inputType:"date_input", begin: $("#recentFollowTime-begin").val(), end: $("#recentFollowTime-end").val() ,matchType:"auto" };
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

		//渲染 level 下拉字段
		fox.renderSelectBox({
			el: "level",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("level",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.list.selectBoxDataTransform("level",{data:data[i],name:data[i].name,value:data[i].id},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id});
					}
				}
				return opts;
			}
		});
		//渲染 intentionalState 下拉字段
		fox.renderSelectBox({
			el: "intentionalState",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("intentionalState",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.list.selectBoxDataTransform("intentionalState",{data:data[i],name:data[i].name,value:data[i].id},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id});
					}
				}
				return opts;
			}
		});
		//渲染 industryId 下拉字段
		fox.renderSelectBox({
			el: "industryId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("industryId",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.list.selectBoxDataTransform("industryId",{data:data[i],name:data[i].name,value:data[i].id},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id});
					}
				}
				return opts;
			}
		});
		//渲染 sourceId 下拉字段
		fox.renderSelectBox({
			el: "sourceId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("sourceId",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.list.selectBoxDataTransform("sourceId",{data:data[i],name:data[i].name,value:data[i].id},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id});
					}
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#recentFollowTime-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("recentFollowTime",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#recentFollowTime-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("recentFollowTime",value, date, endDate);
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
			fox.switchSearchRow(1,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
		});

		// 请选择人员对话框
		$("#ownerId-button").click(function(){
				var ownerIdDialogOptions={
				field:"ownerId",
				inputEl:$("#ownerId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseEmployee(ownerIdDialogOptions);
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
					admin.putTempData('oa-crm-customer-form-data', {});
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'tool-batch-allocate':
					window.pageExt.list.batchAllocate && window.pageExt.list.batchAllocate(selected,obj);
					break;
				case 'tool-batch-transfer':
					window.pageExt.list.batchTransfer && window.pageExt.list.batchTransfer(selected,obj);
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
			admin.putTempData('oa-crm-customer-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的'+'客户'+"!"));
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的'+'客户'+'吗？'), function (i) {
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

			admin.putTempData('oa-crm-customer-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				top.layer.load(2);
				top.layer.load(2);
				admin.post(getByIdURL, { id : data.id }, function (data) {
					top.layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('oa-crm-customer-form-data-form-action', "edit",true);
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
						admin.putTempData('oa-crm-customer-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此'+'客户'+'吗？'), function (i) {
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
			else if (layEvent === 'followup') { // 跟进
				window.pageExt.list.followup(data,this);
			}
			else if (layEvent === 'collect') { // 领用
				window.pageExt.list.collect(data,this);
			}
			else if (layEvent === 'cancel-care') { // 取消关注
				window.pageExt.list.cancelCare(data,this);
			}
			else if(obj.event === 'ops-more'){
				//更多下拉菜单
				var  items = [{"perm":"oa_crm_customer:review","id":"review","title":"回访"},{"perm":"oa_crm_customer:business","id":"business","title":"商机"},{"perm":"oa_crm_customer:deal","id":"deal","title":"成交"},{"perm":"oa_crm_customer:lock","id":"lock","title":"锁定"},{"perm":"oa_crm_customer:unlock","id":"unlock","title":"解锁"},{"perm":"oa_crm_customer:transfer","id":"transfer","title":"移交"},{"perm":"oa_crm_customer:shareuser","id":"shareuser","title":"共享成员"},{"id":"care","title":"关注"},{"perm":"oa_crm_customer:invalid","id":"toinvalid","title":"转无效客户"},{"perm":"oa_crm_customer:opensea","id":"opensean","title":"转入公海"}];
				items=items.filter(function (item,i,arr){
					if(!item.perm) return true;
					else return admin.checkAuth(item.perm);
				});
				dropdown.render({
					elem: this
					,show: true //外部事件触发即显示
					,data: items
					,click: function(menu, othis){
						if(menu.perm && !admin.checkAuth(menu.perm)) {
							top.layer.msg(fox.translate('缺少操作权限','','cmp:table'), {icon: 2, time: 1500});
							return;
						}
						window.pageExt.list.moreAction && window.pageExt.list.moreAction(menu,data, othis);
					}
					,align: 'right'
					,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);'
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
		var action=admin.getTempData('oa-crm-customer-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('oa-crm-customer-form-data', data);
		var area=admin.getTempData('oa-crm-customer-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('客户');
		if(action=="create") title=fox.translate('添加','','cmp:table')+title;
		else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
		else if(action=="view") title=fox.translate('查看','','cmp:table')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"oa-crm-customer-form-data-win",
			content: '/business/oa/crm_customer/crm_customer_form.html' + (queryString?("?"+queryString):""),
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