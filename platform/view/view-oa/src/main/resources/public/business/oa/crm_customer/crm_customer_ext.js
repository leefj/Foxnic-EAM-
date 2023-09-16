/**
 * 客户 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:50
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
    const moduleURL="/service-oa/oa-crm-customer";
    var formAction=admin.getTempData('oa-crm-customer-form-data-form-action');

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
            console.log("tabStatus:",TAB_STATUS)


                if(TAB_STATUS=="myCustomer"){
                    //我的客户

                    var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                    toolHtml=toolHtml.replace(/lay-event="tool-batch-allocate"/i, "style=\"display:none\"")
                    document.getElementById("toolbarTemplate").innerHTML=toolHtml;


                    var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                    operHtml=operHtml.replace(/lay-event="cancel-care"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="collect"/i, "style=\"display:none\"")
                    document.getElementById("tableOperationTemplate").innerHTML=operHtml;


                }else if(TAB_STATUS=="mySubordinates"){
                    //我的下属

                    var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                    toolHtml=toolHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
                    toolHtml=toolHtml.replace(/lay-event="tool-batch-allocate"/i, "style=\"display:none\"")
                    document.getElementById("toolbarTemplate").innerHTML=toolHtml;



                    var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                    operHtml=operHtml.replace(/lay-event="cancel-care"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="del"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="ops-more"/i, "style=\"display:none\"")
                    document.getElementById("tableOperationTemplate").innerHTML=operHtml;
                }else if(TAB_STATUS=="shareToMe"){
                    //分享给我的
                    var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                    toolHtml=toolHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
                    toolHtml=toolHtml.replace(/lay-event="tool-batch-allocate"/i, "style=\"display:none\"")
                    document.getElementById("toolbarTemplate").innerHTML=toolHtml;

                    var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                    operHtml=operHtml.replace(/lay-event="cancel-care"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="del"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="ops-more"/i, "style=\"display:none\"")
                    document.getElementById("tableOperationTemplate").innerHTML=operHtml;
                }else if(TAB_STATUS=="myCare"){

                    //分享给我的
                    var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                    toolHtml=toolHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
                    toolHtml=toolHtml.replace(/lay-event="tool-batch-allocate"/i, "style=\"display:none\"")
                    document.getElementById("toolbarTemplate").innerHTML=toolHtml;

                    var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                    operHtml=operHtml.replace(/lay-event="followup"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="del"/i, "style=\"display:none\"")
                    operHtml=operHtml.replace(/lay-event="ops-more"/i, "style=\"display:none\"")
                    document.getElementById("tableOperationTemplate").innerHTML=operHtml;
                }else{
                    var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                    toolHtml=toolHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
                    toolHtml=toolHtml.replace(/lay-event="tool-batch-allocate"/i, "style=\"display:none\"")
                    document.getElementById("toolbarTemplate").innerHTML=toolHtml;

                    var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                    operHtml=operHtml.replace(/lay-event="cancel-care"/i, "style=\"display:none\"")
                    document.getElementById("tableOperationTemplate").innerHTML=operHtml;
                }


            var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
            toolHtml=toolHtml.replace(/lay-event="tool-batch-allocate"/i, "style=\"display:none\"")
            document.getElementById("toolbarTemplate").innerHTML=toolHtml;

            var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
            operHtml=operHtml.replace(/lay-event="view"/i, "style=\"display:none\"")
            operHtml=operHtml.replace(/lay-event="collect"/i, "style=\"display:none\"")
            document.getElementById("tableOperationTemplate").innerHTML=operHtml;

        },
        /**
         * 按事件名称移除表格按钮栏的按钮
         * */
        removeOperationButtonByEvent(event) {
            var template=$("#tableOperationTemplate");
            var content=template.text();
            content=content.split("\n");
            var buttons=[]
            for (let i = 0; i < content.length ; i++) {
                if(content[i] && content[i].indexOf("lay-event=\""+event+"\"")==-1) {
                    buttons.push(content[i]);
                }
            }
            template.text(buttons.join("\n"))
        },

        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            console.log("list:beforeTableRender",cfg);
            var cols=cfg.cols[0];
            for(var i=0;i<cols.length;i++){
                if(cols[i]&&cols[i].field=="name"){
                    cfg.cols[0][i].event="eventName"
                    break;
                }
            }
            console.log("after",cfg);
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
            param.searchCustomerType=TAB_STATUS;
            console.log('beforeQuery',conditions,param,location);
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {
            for(var i=0;i<data.length;i++){
                //处理领用按钮
                if(data[i].rolePos=="open_sea"){
                    console.log("can collect")
                }else{
                    fox.disableButton($('.collect-button').filter("[data-id='" + data[i].id + "']"), true);
                }

                //处理删除按钮
                if(data[i].transactionStatus=="deal"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                }
            }
        },
        /**
         * 单行数据刷新后调用
         * */
        afterRefreshRowData: function (data,remote,context) {

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {

            if(field=="name"){
                var html="<span style='color: #0052cc!important'>"+value+" </span>"
                return html
            }


            if(value==null) return "";
            return value;
        },
        /**
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {
            var rolePos="";
            if(TAB_STATUS=="myCustomer"){
                rolePos="collected"
            }else{
                rolePos="open_sea";
            }
            if(data&&data.id){
                //edit
                queryString=queryString+"&rolePos="+rolePos;
            }else{
                //new
                queryString="rolePos="+rolePos;
            }
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
        viewCustomerDetail:function(data){
            var action="view"
            var queryString="id="+data.id;
            admin.putTempData('oa-crm-customer-form-data', data);
            admin.putTempData('oa-crm-customer-form-data-form-action', "view",true);
            var title = fox.translate('查看客户信息');
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [15,null],
                area: ["90%","90%"],
                type: 2,
                id:"oa-crm-customer-form-data-win",
                content: '/business/oa/crm_customer/crm_view_customer_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        },
        beforeRowOperationEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            if(obj.event&&obj.event=="eventName"){
                window.pageExt.list.viewCustomerDetail(data);
            }
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
            if(menu.id=="care"){
                window.pageExt.list.care(data,it);
            } else if(menu.id=="review"){
                window.pageExt.list.review(data,it);
            }else if(menu.id=="business"){
                window.pageExt.list.business(data,it);
            }else if(menu.id=="deal"){
                window.pageExt.list.deal(data,it);
            }else if(menu.id=="lock"){
                window.pageExt.list.lock(data,it);
            }else if(menu.id=="unlock"){
                window.pageExt.list.unlock(data,it);
            }else if(menu.id=="toinvalid"){
                window.pageExt.list.toInvalid(data,it);
            }else if(menu.id=="opensean"){
                window.pageExt.list.toOpenSea(data,it);
            }else if(menu.id=="shareuser"){
                window.pageExt.list.shareUser(data,it);
            }else if(menu.id=="transfer"){
                window.pageExt.list.transfer(data,it);
            }
        },
        toOpenSea:function(data,obj){
            var api=moduleURL+"/to-open-sea";
            var ps={customerId:data.id}
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, ps, function (r) {
                    if (r.success) {
                        top.layer.msg(r.message, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        top.layer.msg(r.message, {time: 1000});
                    }
                });
            });
        },
        shareUser:function(data,obj){

            var action="create"
            admin.putTempData('oa-crm-customer-leader-form-data-form-action', "create",true);
            var queryString="";
            queryString="?customerId="+data.id;
            admin.putTempData('oa-crm-customer-leader-form-data', {});
            var area=admin.getTempData('oa-crm-customer-leader-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('共享');
            title=fox.translate('添加','','cmp:table')+title;
            admin.putTempData('oa-crm-customer-leader-form-customer-id', data.id,true);
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["50%",height+"px"],
                type: 2,
                id:"oa-crm-customer-leader-form-data-win",
                content: '/business/oa/crm_customer/share_user_form.html' +queryString,
                finish: function () {
                    window.module.refreshTableData();
                }
            });
        },
        toInvalid:function(data,obj){
            var btn=$('#to-invalid');
            var api=moduleURL+"/to-invalid";
            var ps={customerId:data.id}
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, ps, function (r) {
                    if (r.success) {
                        top.layer.msg(r.message, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        top.layer.msg(r.message, {time: 1000});
                    }
                }, {delayLoading: 1000, elms: [btn]});
            });
        },
        //分配
        allocate:function(data,obj){

            var action="create"
            admin.putTempData('oa-crm-customer-leader-form-data-form-action', "create",true);
            var queryString="";
            queryString="?customerId="+data.id;
            admin.putTempData('oa-crm-customer-leader-form-data', {});
            var area=admin.getTempData('oa-crm-customer-leader-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('分配');
            title=fox.translate('添加','','cmp:table')+title;
            admin.putTempData('oa-crm-customer-leader-form-customer-ids', data.id,true);
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["50%",height+"px"],
                type: 2,
                id:"oa-crm-customer-leader-form-data-win",
                content: '/business/oa/crm_customer_leader/crm_customer_leader_form.html' +queryString,
                finish: function () {
                    window.module.refreshTableData();
                }
            });
        },
        transfer:function(data,obj){
            var action="create"
            admin.putTempData('oa-crm-customer-leader-form-data-form-action', "create",true);
            var queryString="";
            queryString="?customerId="+data.id
            admin.putTempData('oa-crm-customer-leader-form-data', {});
            var area=admin.getTempData('oa-crm-customer-leader-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('转移客户');
            admin.putTempData('oa-crm-customer-leader-form-customer-id', data.id,true);
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["50%",height+"px"],
                type: 2,
                id:"oa-crm-customer-leader-form-data-win",
                content: '/business/oa/crm_customer/customer_transfer_form.html' +queryString,
                finish: function () {
                    window.module.refreshTableData();
                }
            });
        },
        followup:function(data,it){
            var action="create";
            var queryString="customer_id="+data.id;
            admin.putTempData('oa-crm-customer-follow-form-data-form-action', "create",true);
            admin.putTempData('oa-crm-customer-follow-form-data', {});
            var area=admin.getTempData('oa-crm-customer-follow-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('添加跟进记录');
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"oa-crm-customer-follow-form-data-win",
                content: '/business/oa/crm_customer_follow/crm_customer_follow_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        },
        review:function(data,it){
            admin.putTempData('oa-crm-customer-review-form-data-form-action', "create",true);
            var queryString="customerId="+data.id;
            admin.putTempData('oa-crm-customer-review-form-data', {});
            var area=admin.getTempData('oa-crm-customer-review-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('添加回访记录');
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"oa-crm-customer-review-form-data-win",
                content: '/business/oa/crm_customer_review/crm_customer_review_form.html' + (queryString?("?"+queryString):""),
                finish: function () {

                }
            });
        },
        business:function(data,it){
            admin.putTempData('oa-crm-customer-business-form-data-form-action', "create",true);
            var action=admin.getTempData('oa-crm-customer-business-form-data-form-action');
            var queryString="customerId="+data.id;
            admin.putTempData('oa-crm-customer-business-form-data', {});
            var area=admin.getTempData('oa-crm-customer-business-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('添加商机');
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"oa-crm-customer-business-form-data-win",
                content: '/business/oa/crm_customer_business/crm_customer_business_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        },
        deal:function(data,it){
            top.layer.confirm(fox.translate('确定将客户交易状态修为完成吗？'), function (i) {
                top.layer.close(i);
                admin.post(moduleURL+"/deal", {customerId:data.id}, function (r) {
                    if (r.success) {
                        top.layer.msg(r.message, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        top.layer.msg(r.message, {time: 1000});
                    }
                });

            });
        },
        lock:function(data,it){
            admin.post(moduleURL+"/lock", {customerId:data.id}, function (r) {
                if (r.success) {
                    top.layer.msg(r.message, {time: 1000});
                    window.module.refreshTableData();
                } else {
                    top.layer.msg(r.message, {time: 1000});
                }
            });
        },
        unlock:function(data,it){
            admin.post(moduleURL+"/unlock", {customerId:data.id}, function (r) {
                if (r.success) {
                    top.layer.msg(r.message, {time: 1000});
                    window.module.refreshTableData();
                } else {
                    top.layer.msg(r.message, {time: 1000});
                }
            });
        },
        care:function(data,it){
            admin.post(moduleURL+"/care", {customerId:data.id}, function (r) {
                if (r.success) {
                    top.layer.msg(r.message, {time: 1000});
                } else {
                    top.layer.msg(r.message, {time: 1000});
                }
            });
        },
        cancelCare:function(data,it){
            admin.post(moduleURL+"/care-cancel", {customerId:data.id}, function (r) {
                if (r.success) {
                    top.layer.msg(r.message, {time: 1000});
                    window.module.refreshTableData();
                } else {
                    top.layer.msg(r.message, {time: 1000});
                }
            });
        },
        collect:function(ps,it){
            var btnClass="collect-button"
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api=moduleURL+"/collect";
            var ps={customerId:ps.id}
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, ps, function (r) {
                    if (r.success) {
                        top.layer.msg(r.message, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        top.layer.msg(r.message, {time: 1000});
                    }
                }, {delayLoading: 1000, elms: [btn]});
            });
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
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")

            if(formAction=="create"){
                //默认填充报修人员
                if($("#ownerId")){
                    $("#ownerId").val(CUR_EMP_ID);
                }
                if($("#ownerId-button")){
                    var html="<i class=\"layui-icon layui-icon-search\"></i><span default-label=\"负责人\">"+CUR_USER_NAME+"</span>"
                    $("#ownerId-button").html(html);
                }

            }

        },
        /**
         * 窗口调节前
         * */
        beforeAdjustPopup:function (arg) {
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
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        onRadioBoxChanged:function(id,data,checked) {
            console.log('onRadioChanged',id,data,checked);
        },
        onCheckBoxChanged:function(id,data,checked) {
            console.log('onCheckBoxChanged',id,data,checked);
        },

        /**
         * 在流程提交前处理表单数据
         * */
        processFormData4Bpm:function(processInstanceId,param,callback) {
            // 设置流程变量，并通过回调返回
            var variables={};
            // 此回调是必须的，否则流程提交会被中断
            callback(variables);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
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