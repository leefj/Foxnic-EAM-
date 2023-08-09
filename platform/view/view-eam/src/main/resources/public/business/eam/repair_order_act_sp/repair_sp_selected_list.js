/**
 * 维修备件 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-18 12:04:28
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;

    //模块基础路径
    const moduleURL="/service-eam/eam-goods-stock";
    const queryURL=moduleURL+'/query-selected-paged-list';
    const deleteURL=moduleURL+'/delete';
    const batchDeleteURL=moduleURL+'/delete-by-ids';
    const getByIdURL=moduleURL+'/get-by-id';
    //
    var dataTable=null;
    var sort=null;
    var DATA_TYPE="reset";
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

            if(OWNER_TMP_ID&&OWNER_TMP_ID.length>5){
                //修改操作
                ps.ownerTmpId=OWNER_TMP_ID;
            }else{
                //新增操作
                ps.selectedCode=SELECTED_CODE
            }

            ps.dataType=DATA_TYPE;
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
                url: moduleURL +'/query-paged-list-by-selected',
                height: 'full-'+(h+28),
                limit: 50,
                where: ps,
                cols: [[
                    { fixed: 'left',type: 'numbers' },
                    { fixed: 'left',type:'checkbox'}
                    ,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
                    ,{ field: 'warehouseId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('仓库'), templet: function (d) { return templet('warehouseId' ,fox.joinLabel(d.warehouse,"warehouseName"),d);}}
                    ,{ field: 'goodsId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('物品'), templet: function (d) { return templet('goodsId' ,fox.joinLabel(d.goods,"name"),d);}}
                    ,{ field: 'goodsCode', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('物品编码'), templet: function (d) { return templet('goodsCode' ,fox.joinLabel(d.goods,"code"),d);}}
                    ,{ field: 'goodsBarCode', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('物品条码'), templet: function (d) { return templet('goodsBarCode' ,fox.joinLabel(d.goods,"barCode"),d);}}
                    ,{ field: 'stockInNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('物品数量') , templet: function (d) { return templet('stockInNumber',d.stockInNumber,d);}  }
               //     ,{ field: 'amount', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('总金额') , templet: function (d) { return templet('amount',d.amount,d);}  }
                 //   ,{ field: 'goodsModel', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('物品型号'), templet: function (d) { return templet('goodsModel' ,fox.joinLabel(d.goods,"model"),d);}}
                    ,{ field: 'goodsUnit', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('计量单位'), templet: function (d) { return templet('goodsUnit' ,fox.joinLabel(d.goods,"unit"),d);}}
                    //    ,{ field: 'stockCurNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('当前数量') , templet: function (d) { return templet('stockCurNumber',d.stockCurNumber,d);}  }
                //    ,{ field: 'goodsStockMax', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('库存上限'), templet: function (d) { return templet('goodsStockMax' ,fox.joinLabel(d.goods,"stockMax"),d);}}
                 //   ,{ field: 'goodsStockMin', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('库存下限'), templet: function (d) { return templet('goodsStockMin' ,fox.joinLabel(d.goods,"stockMin"),d);}}
               //     ,{ field: 'goodsStockSecurity', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('安全库存'), templet: function (d) { return templet('goodsStockSecurity' ,fox.joinLabel(d.goods,"stockSecurity"),d);}}
                    ,{ field: 'notes', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('备注'), templet: function (d) { return templet('notes' ,d.notes,d);}}
                    ,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
                    ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
                done: function (data) {
                    lockSwitchInputs();
                    DATA_TYPE="noreset";
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
        value.spName={ inputType:"button",value: $("#spName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        var ps={searchField:"$composite"};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
        }
        ps.searchValue=JSON.stringify(value);
        if(OWNER_TMP_ID&&OWNER_TMP_ID.length>5){
            //修改操作
            ps.ownerTmpId=OWNER_TMP_ID;
        }else{
            //新增操作
            ps.selectedCode=SELECTED_CODE
        }


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
                    // var queryString="?selectedCode="+SELECTED_CODE+"&ownerId="+OWNER_ID+"&ownerType="+OWNER_TYPE;
                    // admin.popupCenter({
                    //     title: "备件清单",
                    //     resize: false,
                    //     offset: [2,null],
                    //     area: ["80%","85%"],
                    //     type: 2,
                    //     id:"eam-repiar-order-sp-select-list-data-win",
                    //     content: '/business/eam/device_sp/device_sp_select_list.html' + queryString,
                    //     finish: function () {
                    //         refreshTableData();
                    //     }
                    // });

                    //设置新增是初始化数据
                    var data={};
                    admin.putTempData('eam-goods-stock-form-data-form-action', PAGE_TYPE,true);
                    var queryString="?ownerType=part&selectedCode="+SELECTED_CODE+"&ownerCode=part&ownerTmpId="+OWNER_TMP_ID+"&operType=eam_asset_part_goods_repair_out&pageType="+PAGE_TYPE;
                    var formTop=2
                    var index=admin.popupCenter({
                        title: "选择备件",
                        resize: false,
                        offset: [formTop,null],
                        area: ["80%","90%"],
                        type: 2,
                        id:"eam-asset-select-data-win",
                        content: '/business/eam/goods_stock/goods_stock_select_tree.html'+queryString,
                        finish: function () {
                            console.log("select form finish,");
                            refreshTableData();
                        }
                    });
                    admin.putTempData('eam-asset-select-data-popup-index', index);
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
            admin.putTempData('eam-repair-order-act-sp-form-data-form-action', "create",true);
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
                top.layer.msg(fox.translate('请选择需要删除的'+'维修备件'+"!"));
                return;
            }
            //调用批量删除接口
            top.layer.confirm(fox.translate('确定删除已选中的'+'维修备件'+'吗？'), function (i) {
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

            admin.putTempData('eam-repair-order-act-sp-form-data-form-action', "",true);
            if (layEvent === 'edit') { // 修改
                admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    if(data.success) {
                        admin.putTempData('eam-goods-stock-form-data-form-action', "edit",true);
                        showEditForm(data.data);
                    } else {
                        fox.showMessage(data);
                    }
                });
            } else if (layEvent === 'view') { // 查看
                // top.layer.load(2);
                // admin.post(getByIdURL, { id : data.id }, function (data) {
                //     top.layer.closeAll('loading');
                //     if(data.success) {
                //         admin.putTempData('eam-repair-order-act-sp-form-data-form-action', "view",true);
                //         showEditForm(data.data);
                //     } else {
                //         fox.showMessage(data);
                //     }
                // });
            }
            else if (layEvent === 'del') { // 删除

                if(window.pageExt.list.beforeSingleDelete) {
                    var doNext=window.pageExt.list.beforeSingleDelete(data);
                    if(!doNext) return;
                }

                top.layer.confirm(fox.translate('确定删除此'+'维修备件'+'吗？'), function (i) {
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
        var action=admin.getTempData('eam-goods-stock-form-data-form-action');
        var queryString="";
        if(data && data.id) queryString='id=' + data.id;
        if(window.pageExt.list.makeFormQueryString) {
            queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
        }
        admin.putTempData('eam-goods-stock-form-data', data);
        var area=admin.getTempData('eam-goods-stock-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('库存物品');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;

        admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["80%",height+"px"],
            type: 2,
            id:"eam-goods-stock-form-data-win",
            content: '/business/eam/goods_stock/goods_stock_selected_form.html' + (queryString?("?"+queryString):""),
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