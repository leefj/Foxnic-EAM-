/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 16:11:55
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset";
	var dataTable=null;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

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
		function renderTableInternal() {

			var ps={};
			var contitions={};
			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions);
			}
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}
			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					return value;
				}
			}
			var h=$(".search-bar").height();
			dataTable=fox.renderTable({
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox' }
					,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('分类'), templet: function (d) { return templet('categoryId',fox.joinLabel(d.category,"name"),d);}}
					,{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
					,{ field: 'procId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('流程') , templet: function (d) { return templet('procId',d.procId,d);}  }
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('办理状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}}
					,{ field: 'batchCode', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('批次编码') , templet: function (d) { return templet('batchCode',d.batchCode,d);}  }
					,{ field: 'assetStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产状态') , templet: function (d) { return templet('assetStatus',d.assetStatus,d);}  }
					,{ field: 'goodsId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('物品档案'), templet: function (d) { return templet('goodsId',fox.joinLabel(d.goods,"name"),d);}}
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'manufacturerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('厂商'), templet: function (d) { return templet('manufacturerId',fox.joinLabel(d.manufacturer,"manufacturerName"),d);}}
					,{ field: 'model', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('规格型号') , templet: function (d) { return templet('model',d.model,d);}  }
					,{ field: 'unit', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('计量单位') , templet: function (d) { return templet('unit',d.unit,d);}  }
					,{ field: 'serviceLife', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('使用期限') , templet: function (d) { return templet('serviceLife',d.serviceLife,d);}  }
					,{ field: 'serialNumber', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('序列号') , templet: function (d) { return templet('serialNumber',d.serialNumber,d);}  }
					,{ field: 'ownCompanyId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所属公司') , templet: function (d) { return templet('ownCompanyId',d.ownCompanyId,d);}  }
					,{ field: 'managerId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('管理人员') , templet: function (d) { return templet('managerId',d.managerId,d);}  }
					,{ field: 'useOrganizationId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用公司/部门') , templet: function (d) { return templet('useOrganizationId',d.useOrganizationId,d);}  }
					,{ field: 'useUserId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用人员') , templet: function (d) { return templet('useUserId',d.useUserId,d);}  }
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('位置'), templet: function (d) { return templet('positionId',fox.joinLabel(d.position,"name"),d);}}
					,{ field: 'positionDetail', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('详细位置') , templet: function (d) { return templet('positionDetail',d.positionDetail,d);}  }
					,{ field: 'warehouseId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('仓库'), templet: function (d) { return templet('warehouseId',fox.joinLabel(d.warehouse,"warehouseName"),d);}}
					,{ field: 'sourceId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('来源'), templet:function (d){ return templet('sourceId',fox.getDictText(SELECT_SOURCEID_DATA,d.sourceId),d);}}
					,{ field: 'purchaseDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('采购日期'), templet: function (d) { return templet('purchaseDate',fox.dateFormat(d.purchaseDate),d); }}
					,{ field: 'assetNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产备注') , templet: function (d) { return templet('assetNotes',d.assetNotes,d);}  }
					,{ field: 'maintainerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保商'), templet: function (d) { return templet('maintainerId',fox.joinLabel(d.maintnainer,"maintainerName"),d);}}
					,{ field: 'maintainerName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保厂商') , templet: function (d) { return templet('maintainerName',d.maintainerName,d);}  }
					,{ field: 'contacts', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('联系人') , templet: function (d) { return templet('contacts',d.contacts,d);}  }
					,{ field: 'contactInformation', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('联系方式') , templet: function (d) { return templet('contactInformation',d.contactInformation,d);}  }
					,{ field: 'director', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('负责人') , templet: function (d) { return templet('director',d.director,d);}  }
					,{ field: 'maintenanceStartDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('维保开始时间'), templet: function (d) { return templet('maintenanceStartDate',fox.dateFormat(d.maintenanceStartDate),d); }}
					,{ field: 'maintenanceEndDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('维保到期时间'), templet: function (d) { return templet('maintenanceEndDate',fox.dateFormat(d.maintenanceEndDate),d); }}
					,{ field: 'maintenanceNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保备注') , templet: function (d) { return templet('maintenanceNotes',d.maintenanceNotes,d);}  }
					,{ field: 'financialCategoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('财务分类') , templet: function (d) { return templet('financialCategoryId',d.financialCategoryId,d);}  }
					,{ field: 'financialCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('财务编号') , templet: function (d) { return templet('financialCode',d.financialCode,d);}  }
					,{ field: 'supplierId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('供应商'), templet: function (d) { return templet('supplierId',fox.joinLabel(d.supplier,"supplierName"),d);}}
					,{ field: 'taxamountRate', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('税额') , templet: function (d) { return templet('taxamountRate',d.taxamountRate,d);}  }
					,{ field: 'taxamountPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('含税金额') , templet: function (d) { return templet('taxamountPrice',d.taxamountPrice,d);}  }
					,{ field: 'originalUnitPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('资产原值(单价)') , templet: function (d) { return templet('originalUnitPrice',d.originalUnitPrice,d);}  }
					,{ field: 'accumulatedDepreciation', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('累计折旧') , templet: function (d) { return templet('accumulatedDepreciation',d.accumulatedDepreciation,d);}  }
					,{ field: 'residualsRate', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('残值率') , templet: function (d) { return templet('residualsRate',d.residualsRate,d);}  }
					,{ field: 'navPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('资产净值') , templet: function (d) { return templet('navPrice',d.navPrice,d);}  }
					,{ field: 'purchaseUnitPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('采购单价') , templet: function (d) { return templet('purchaseUnitPrice',d.purchaseUnitPrice,d);}  }
					,{ field: 'entryTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('入账时间'), templet: function (d) { return templet('entryTime',fox.dateFormat(d.entryTime),d); }}
					,{ field: 'financialNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('财务备注') , templet: function (d) { return templet('financialNotes',d.financialNotes,d);}  }
					,{ field: 'label', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('标签') , templet: function (d) { return templet('label',d.label,d);}  }
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
				]],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
				footer : {
					exportExcel : admin.checkAuth(AUTH_PREFIX+":export"),
					importExcel : admin.checkAuth(AUTH_PREFIX+":import")?{
						params : {} ,
						callback : function(r) {
							if(r.success) {
								layer.msg(fox.translate('数据导入成功')+"!");
							} else {
								layer.msg(fox.translate('数据导入失败')+"!");
							}
						}
					}:false
				}
			});
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
			  refreshTableData(obj.field,obj.type);
			});
		}
		setTimeout(renderTableInternal,1);
    };

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType) {
		var value = {};
		value.categoryId={ value: xmSelect.get("#categoryId",true).getValue("value"), fillBy:"category",field:"id", label:xmSelect.get("#categoryId",true).getValue("nameStr") };
		value.status={ value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
		value.assetCode={ value: $("#assetCode").val()};
		value.name={ value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.manufacturerId={ value: xmSelect.get("#manufacturerId",true).getValue("value"), fillBy:"manufacturer",field:"id", label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
		value.model={ value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.serialNumber={ value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.assetNotes={ value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value)) return;
		}
		var ps={searchField: "$composite", searchValue: JSON.stringify(value)};
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
		}
		table.reload('data-table', { where : ps });
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

		//渲染 categoryId 下拉字段
		fox.renderSelectBox({
			el: "categoryId",
			radio: false,
			size: "small",
			filterable: true,
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
					opts.push({name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 status 下拉字段
		fox.renderSelectBox({
			el: "status",
			radio: false,
			size: "small",
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 manufacturerId 下拉字段
		fox.renderSelectBox({
			el: "manufacturerId",
			radio: false,
			size: "small",
			filterable: true,
			//转换数据
			searchField: "manufacturerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].manufacturerName,value:data[i].id});
				}
				return opts;
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
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#search-button').click(function () {
           refreshTableData();
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
			switch(obj.event){
				case 'create':
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
			admin.putTempData('eam-asset-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产')+fox.translate('吗？'), function (i) {
				top.layer.close(i);
				top.layer.load(2);
                admin.request(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
					top.layer.closeAll('loading');
                    if (data.success) {
						if(window.pageExt.list.afterBatchDelete) {
							var doNext=window.pageExt.list.afterBatchDelete(data);
							if(!doNext) return;
						}
                    	top.layer.msg(data.message, {icon: 1, time: 500});
                        refreshTableData();
                    } else {
						top.layer.msg(data.message, {icon: 2, time: 1500});
                    }
                });

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
			admin.putTempData('eam-asset-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产')+fox.translate('吗？'), function (i) {
					top.layer.close(i);

					top.layer.load(2);
					admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
						top.layer.closeAll('loading');
						if (data.success) {
							if(window.pageExt.list.afterSingleDelete) {
								var doNext=window.pageExt.list.afterSingleDelete(data);
								if(!doNext) return;
							}
							top.layer.msg(data.message, {icon: 1, time: 500});
							refreshTableData();
						} else {
							top.layer.msg(data.message, {icon: 2, time: 1500});
						}
					});
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
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('eam-asset-form-data', data);
		var area=admin.getTempData('eam-asset-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('资产')) : (fox.translate('添加')+fox.translate('资产'));
		height=800;
		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["95%",height+"px"],
			type: 2,
			id:"eam-asset-form-data-win",
			content: '/business/eam/asset/asset_info_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('eam-asset-form-data-popup-index', index);
	};

	window.module={
		refreshTableData: refreshTableData,
		getCheckedList: getCheckedList
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