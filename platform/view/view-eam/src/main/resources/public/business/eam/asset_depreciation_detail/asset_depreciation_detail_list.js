/**
 * 折旧明细 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-24 19:55:18
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	const languageContext='eam_asset_dep_detail'; 
	//模块基础路径
	const moduleURL="/service-eam/eam-asset-depreciation-detail";
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
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键',null,languageContext) , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'depreciationMethod', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('折旧方式',null,languageContext), templet:function (d){ return templet('depreciationMethod',fox.getEnumText(SELECT_DEPRECIATIONMETHOD_DATA,d.depreciationMethod,'','depreciationMethod'),d);}}
					,{ field: 'result', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('折旧结果',null,languageContext), templet:function (d){ return templet('result',fox.getEnumText(SELECT_RESULT_DATA,d.result,'','result'),d);}}
					,{ field: 'resultDetail', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('折旧结果明细',null,languageContext) , templet: function (d) { return templet('resultDetail',d.resultDetail,d);}  }
					,{ field: 'assetCategoryName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产类别',null,languageContext) , templet: function (d) { return templet('assetCategoryName',d.assetCategoryName,d);}  }
					,{ field: 'assetCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产编码',null,languageContext) , templet: function (d) { return templet('assetCode',d.assetCode,d);}  }
					,{ field: 'assetName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产名称',null,languageContext) , templet: function (d) { return templet('assetName',d.assetName,d);}  }
					,{ field: 'assetModel', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产型号',null,languageContext) , templet: function (d) { return templet('assetModel',d.assetModel,d);}  }
					,{ field: 'assetStatusName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产状态',null,languageContext) , templet: function (d) { return templet('assetStatusName',d.assetStatusName,d);}  }
					,{ field: 'purchaseDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('采购日期',null,languageContext) ,templet: function (d) { return templet('purchaseDate',fox.dateFormat(d.purchaseDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'registerDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('启用日期',null,languageContext) ,templet: function (d) { return templet('registerDate',fox.dateFormat(d.registerDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'businessDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('业务日期',null,languageContext) ,templet: function (d) { return templet('businessDate',fox.dateFormat(d.businessDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'originalUnitPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('资产原值',null,languageContext) , templet: function (d) { return templet('originalUnitPrice',d.originalUnitPrice,d);}  }
					,{ field: 'serviceLife', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('使用寿命',null,languageContext) , templet: function (d) { return templet('serviceLife',d.serviceLife,d);}  }
					,{ field: 'usedServiceLife', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('已用寿命',null,languageContext) , templet: function (d) { return templet('usedServiceLife',d.usedServiceLife,d);}  }
					,{ field: 'residualRate', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('本期残值率',null,languageContext) , templet: function (d) { return templet('residualRate',d.residualRate,d);}  }
					,{ field: 'redidualPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('本期残值',null,languageContext) , templet: function (d) { return templet('redidualPrice',d.redidualPrice,d);}  }
					,{ field: 'sOriginalPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期初)期初原值',null,languageContext) , templet: function (d) { return templet('sOriginalPrice',d.sOriginalPrice,d);}  }
					,{ field: 'sDepreciationAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期初)期初累计折旧',null,languageContext) , templet: function (d) { return templet('sDepreciationAmount',d.sDepreciationAmount,d);}  }
					,{ field: 'sNavAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期初)期初净值',null,languageContext) , templet: function (d) { return templet('sNavAmount',d.sNavAmount,d);}  }
					,{ field: 'sRecoverableAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期初)期初可回收净额',null,languageContext) , templet: function (d) { return templet('sRecoverableAmount',d.sRecoverableAmount,d);}  }
					,{ field: 'cOriginalPriceIncrease', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(本期发生)原值增加',null,languageContext) , templet: function (d) { return templet('cOriginalPriceIncrease',d.cOriginalPriceIncrease,d);}  }
					,{ field: 'cDepreciationAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(本期发生)本期折旧额',null,languageContext) , templet: function (d) { return templet('cDepreciationAmount',d.cDepreciationAmount,d);}  }
					,{ field: 'cYearDepreciationAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(本期发生)本年累计折旧额',null,languageContext) , templet: function (d) { return templet('cYearDepreciationAmount',d.cYearDepreciationAmount,d);}  }
					,{ field: 'eOriginalPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期末)期末原值',null,languageContext) , templet: function (d) { return templet('eOriginalPrice',d.eOriginalPrice,d);}  }
					,{ field: 'eDepreciationAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期末)期末累计折旧',null,languageContext) , templet: function (d) { return templet('eDepreciationAmount',d.eDepreciationAmount,d);}  }
					,{ field: 'eNavAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期末)期末净值',null,languageContext) , templet: function (d) { return templet('eNavAmount',d.eNavAmount,d);}  }
					,{ field: 'eRecoverableAmount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('(期末)期末可回收金额',null,languageContext) , templet: function (d) { return templet('eRecoverableAmount',d.eRecoverableAmount,d);}  }
					,{ field: 'useOrgName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('使用部门',null,languageContext) , templet: function (d) { return templet('useOrgName',d.useOrgName,d);}  }
					,{ field: 'financialOptionName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('财务选项',null,languageContext) , templet: function (d) { return templet('financialOptionName',d.financialOptionName,d);}  }
					,{ field: 'expenseItemName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('费用项目',null,languageContext) , templet: function (d) { return templet('expenseItemName',d.expenseItemName,d);}  }
					,{ field: 'customerInfo', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('客户情况',null,languageContext) , templet: function (d) { return templet('customerInfo',d.customerInfo,d);}  }
					,{ field: 'purchaseUnitPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('采购价格',null,languageContext) , templet: function (d) { return templet('purchaseUnitPrice',d.purchaseUnitPrice,d);}  }
					,{ field: 'depreciationPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('本期折旧',null,languageContext) , templet: function (d) { return templet('depreciationPrice',d.depreciationPrice,d);}  }
					,{ field: 'curPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('当前净值',null,languageContext) , templet: function (d) { return templet('curPrice',d.curPrice,d);}  }
					,{ field: 'beforePrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('折旧前净值',null,languageContext) , templet: function (d) { return templet('beforePrice',d.beforePrice,d);}  }
					,{ field: 'afterPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('折旧后净值',null,languageContext) , templet: function (d) { return templet('afterPrice',d.afterPrice,d);}  }
					,{ field: fox.translate('空白列','','cmp:table'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作','','cmp:table'), width: 160 }
				]],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
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
			admin.post(moduleURL+"/get-by-id", { id : data.id }, function (r) {
				if (r.success) {
					data = r.data;
					context.update(data);
					fox.renderFormInputs(form);
				} else {
					fox.showMessage(data);
				}
			});
		} else {
			context.update(data);
			fox.renderFormInputs(form);
		}
	}

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.result={ inputType:"select_box", value: getSelectedValue("#result","value"), label:getSelectedValue("#result","nameStr") };
		value.assetCategoryName={ inputType:"button",value: $("#assetCategoryName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.assetCode={ inputType:"button",value: $("#assetCode").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.assetName={ inputType:"button",value: $("#assetName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.assetModel={ inputType:"button",value: $("#assetModel").val()};
		value.assetStatusName={ inputType:"button",value: $("#assetStatusName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() ,matchType:"auto" };
		value.registerDate={ inputType:"date_input", begin: $("#registerDate-begin").val(), end: $("#registerDate-end").val() ,matchType:"auto" };
		value.financialOptionName={ inputType:"button",value: $("#financialOptionName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.expenseItemName={ inputType:"button",value: $("#expenseItemName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.customerInfo={ inputType:"button",value: $("#customerInfo").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
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

		//渲染 result 下拉字段
		fox.renderSelectBox({
			el: "result",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("result",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({data:data[i],name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#purchaseDate-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("purchaseDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#purchaseDate-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("purchaseDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#registerDate-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("registerDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#registerDate-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("registerDate",value, date, endDate);
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
					admin.putTempData('eam-asset-depreciation-detail-form-data', {});
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'tool-depreciation-start':
					window.pageExt.list.depreciationStart && window.pageExt.list.depreciationStart(selected,obj);
					break;
				case 'tool-depreciation-execute':
					window.pageExt.list.depreciationExecute && window.pageExt.list.depreciationExecute(selected,obj);
					break;
				case 'tool-depreciation-sync':
					window.pageExt.list.depreciationSync && window.pageExt.list.depreciationSync(selected,obj);
					break;
				case 'tool-depreciation-export':
					window.pageExt.list.depreciationExport && window.pageExt.list.depreciationExport(selected,obj);
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
			admin.putTempData('eam-asset-depreciation-detail-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的'+'折旧明细'+"!",null,languageContext));
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的'+'折旧明细'+'吗？',null,languageContext), function (i) {
                top.layer.close(i);
				admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
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

			admin.putTempData('eam-asset-depreciation-detail-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-asset-depreciation-detail-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 fox.showMessage(data);
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-asset-depreciation-detail-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此'+'折旧明细'+'吗？',null,languageContext), function (i) {
					top.layer.close(i);
					admin.post(moduleURL+"/delete", { id : data.id }, function (data) {
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
		var action=admin.getTempData('eam-asset-depreciation-detail-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('eam-asset-depreciation-detail-form-data', data);
		var area=admin.getTempData('eam-asset-depreciation-detail-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('折旧明细',null,languageContext);
		if(action=="create") title=fox.translate('添加','','cmp:table')+title;
		else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
		else if(action=="view") title=fox.translate('查看','','cmp:table')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-asset-depreciation-detail-form-data-win",
			content: '/business/eam/asset_depreciation_detail/asset_depreciation_detail_form.html' + (queryString?("?"+queryString):""),
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