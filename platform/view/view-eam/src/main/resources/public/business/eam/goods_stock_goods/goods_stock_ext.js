/**
 * 库存物品 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 20:25:42
 */

layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    //模块基础路径
    const moduleURL="/service-eam/eam-goods-stock";
    var timestamp = Date.parse(new Date());
    var formAction=admin.getTempData('eam-goods-stock-form-data-form-action');
    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            cfg.cellMinWidth=160;
            var cols=cfg.cols[0];
            for(var i=0;i<cols.length;i++){
                if(cols[i]&&cols[i].field=="relatedAssetCount"){
                    cfg.cols[0][i].event="eventRelatedAssetCount"
                   // break;
                }
                if(cols[i]&&cols[i].field=="relatedGoodsStockCount"){
                    cfg.cols[0][i].event="eventRelatedGoodsStockCount"
                   // break;
                }
            }
        },
        /**
         * 表格渲染后调用
         * */
        afterTableRender :function (){

        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * @param location 调用的代码位置
         * */
        beforeQuery:function (conditions,param,location) {
            console.log('beforeQuery',conditions,param,location);
            conditions.ownerCode={ inputType:"button",value: "goods" ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {

            if(field=="relatedGoodsStockCount"){
                var html="<span style='color: #0052cc!important'>"+value+" </span>"
                return html
            }

            if(field=="relatedAssetCount"){
                var html="<span style='color: #0052cc!important'>"+value+" </span>"
                return html
            }


            if(field=="parentGoodsStockIds"){
                var res="";
                if(r.parentGoodsStockList&&r.parentGoodsStockList.length>0){
                    var num=r.parentGoodsStockList.length;
                    if(num>5){
                        num=5
                    }
                    for(var i=0;i<num;i++){
                        if(i==0){
                            res=r.parentGoodsStockList[i].name+"【"+r.parentGoodsStockList[i].model+"】-【"+r.parentGoodsStockList[i].code+"】";
                        }else{
                            var obj=","+r.parentGoodsStockList[i].name+"【"+r.parentGoodsStockList[i].model+"】-【"+r.parentGoodsStockList[i].code+"】";
                            res=res+obj
                        }
                    }
                    if(num>5){
                        res=res+"..."
                    }
                   value=res;
                }
                return value;
            }

            if(field=="subGoodsStockIds"){
                var res="";
                if(r.subGoodsStockList&&r.subGoodsStockList.length>0){
                    var num=r.subGoodsStockList.length;
                    if(num>5){
                        num=5
                    }
                    for(var i=0;i<num;i++){
                        if(i==0){
                            res=r.subGoodsStockList[i].name+"【"+r.subGoodsStockList[i].model+"】-【"+r.subGoodsStockList[i].code+"】";
                        }else{
                            var obj=","+r.subGoodsStockList[i].name+"【"+r.subGoodsStockList[i].model+"】-【"+r.subGoodsStockList[i].code+"】";
                            res=res+obj
                        }
                    }
                    if(num>5){
                        res=res+"..."
                    }
                    value=res;
                }
                return value;
            }

            if(field==""){

            }
            if(value==null) return "";
            return value;
        },
        /**
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {
            if(data.id){
                queryString=queryString+"&categoryCode="+CATEGORY_CODE;
            }else{
                queryString="categoryCode="+CATEGORY_CODE;
            }
            admin.putTempData('eam-goods-stock-form-data-form-categoryCode', CATEGORY_CODE);
            return queryString;
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            console.log('beforeEdit',data);
            return true;
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            return true;
        },
        afterSingleDelete:function (data){
            console.log('beforeSingleDelete',data);
            return true;
        },
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        /**
         * 批量删除后调用，若返回false则不执行后续操作
         * */
        afterBatchDelete:function (data) {
            console.log('afterBatchDelete',data);
            return true;
        },
        /**
         * 工具栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeToolBarButtonEvent:function (selected,obj) {
            console.log('beforeToolBarButtonEvent',selected,obj);
            return true;
        },
        /**
         * 列表操作栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        viewRelatedAsset:function(data){
            var q="?goodsId="+data.id;
            admin.popupCenter({
                title: "关联资产",
                resize: false,
                offset: [2,null],
                area: ["90%","90%"],
                type: 2,
                id:"eam-goods-asset-list-data-win",
                content: '/business/eam/goods_stock_goods/related_asset_list.html'+q,
                finish: function () {
                }
            });
        },
        viewRelatedStock:function(data){
            var q="?goodsId="+data.id;
            admin.popupCenter({
                title: "关联库存",
                resize: false,
                offset: [2,null],
                area: ["90%","90%"],
                type: 2,
                id:"eam-goods-stock-list-data-win",
                content: '/business/eam/goods_stock_goods/related_stock_list.html'+q,
                finish: function () {
                }
            });
        },
        beforeRowOperationEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            if(obj.event&&obj.event=="eventRelatedAssetCount"){
                window.pageExt.list.viewRelatedAsset(data);
            }

            if(obj.event&&obj.event=="eventRelatedGoodsStockCount"){
                window.pageExt.list.viewRelatedStock(data);
            }

            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        /**
         * 末尾执行
         */
        ending:function() {
            table.on('row(data-table)',function(obj){
                console.log('row(data-table)');
            });
        }
    }

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用 , 并传入表单数据
         * */
        beforeInit:function (action,data) {
            CATEGORY_CODE=admin.getTempData('eam-goods-stock-form-data-form-categoryCode');
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        /**
         * 窗口调节前
         * */
        beforeAdjustPopup:function () {
            console.log('beforeAdjustPopup');
            return true;
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */

        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            data.ownerCode="goods"
            data.selectedCode=timestamp;
            console.log("######beforeSubmit",data);
            return true;
        },
        /**
         * 数据提交后窗口关闭前，如果返回 false，停止后续步骤的执行
         * */
        betweenFormSubmitAndClose:function (param,result) {
            console.log("betweenFormSubmitAndClose",result);
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },
        /**
         *  加载 关联设备配件
         */
        relGoods:function (ifr,win,data) {
            // debugger
            console.log("relGoods",ifr,data);
            //设置 iframe 高度
            var parentGoodsStockId="";
            var pageType=formAction
            if(data&&data.id){
                parentGoodsStockId=data.id
            }else{
                parentGoodsStockId=timestamp;
            }
            ifr.height("400px");
            var q="?pageType="+pageType+"&ownerId="+parentGoodsStockId+"&selectedCode="+timestamp;
            //设置地址
            win.location="/business/eam/goods_stock_goods/selected_rel_goods_stock.html"+q
        },
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);

        },
        selectBoxDataTransform:function(id,obj,item,data,i){
            console.log("selectBoxDataTransform");
            console.log("id ",id)
            console.log("data[i] ",item)
            console.log("data ",data)
            console.log("i ",i)
          //  opts.push(window.pageExt.form.selectBoxDataTransform("parentGoodsStockIds",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
            if(id=="parentGoodsStockIds"){
                obj.name=item.name+"【"+item.model+"】-【"+item.code+"】";
            }
            console.log("obj ",obj)
            return obj;
        },

        /**
         * 文件上传组件回调
         *  event 类型包括：
         *  afterPreview ：文件选择后，未上传前触发；
         *  afterUpload ：文件上传后触发
         *  beforeRemove ：文件删除前触发
         *  afterRemove ：文件删除后触发
         * */
        onUploadEvent: function(e) {
            console.log("onUploadEvent",e);
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    //
    window.pageExt={form:form,list:list};
});