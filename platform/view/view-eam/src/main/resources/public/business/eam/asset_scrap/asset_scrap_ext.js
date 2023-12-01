/**
 * 资产报废 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-24 15:31:14
 */

layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown','bpm'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload,bpm=layui.bpm;

    const moduleURL="/service-eam/eam-asset-scrap";


    var processId=QueryString.get("processId");
    var processInstance=null;


    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            var toolbarHtml=document.getElementById("toolbarTemplate").innerHTML;
            var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
            if(APPROVAL_REQUIRED){
                operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
                // operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
                // document.getElementById("tableOperationTemplate").innerHTML=operHtml;
            }else{
                operHtml=operHtml.replace(/lay-event="revoke-data"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="for-approval"/i, "style=\"display:none\"")
            }

            // if(PAGE_TYPE&&PAGE_TYPE=="approval"){
            //     $("#status-search-unit").hide();
            //     toolbarHtml=toolbarHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="revoke-data"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="for-approval"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="del"/i, "style=\"display:none\"")
            //
            //     operHtml=operHtml.replace(/lay-event="clean-out"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="download-bill"/i, "style=\"display:none\"")
            //
            // }else if( PAGE_TYPE&&PAGE_TYPE=="asset_scrap"){
            //     operHtml=operHtml.replace(/lay-event="agree"/i, "style=\"display:none\"")
            //     operHtml=operHtml.replace(/lay-event="deny"/i, "style=\"display:none\"")
            // }

            document.getElementById("toolbarTemplate").innerHTML=toolbarHtml;
            document.getElementById("tableOperationTemplate").innerHTML=operHtml;
            console.log("list:beforeInit");
        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        makeFormQueryString:function(data,queryString,action) {
            return queryString;
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        getBpmViewConfig:function (act) {
            return {
                title:"设备报废申请",
                priority:"normal", // priority 的可选值 urgency，normal
                labelWidth:77, // 标签宽度，用于对齐
                displayTitle:true,  // 是否显示标题与优先级
                displayPriority:true, // 是否显示优先级
                displayDraftComment:true, // 是否显示起草节点的流程说明
                displayApprovalComment:true, // 是否显示签字意见
                displayDraftAttachment:true, // 是否使用起草附件
                displayApprovalAttachment:true // 是否使用审批附件
            }
        },
        handleNoProcessBill:function(idValue) {
            top.layer.msg('当前业务单据尚未关联流程', {icon: 2, time: 1500});
        },
        beforeDialog:function (param){
            param.title="组织/人员选择对话框";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {

            console.log('dialog',param,result);
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * @param location 调用的代码位置
         * */
        beforeQuery:function (conditions,param,location) {
            // console.log('beforeQuery',conditions,param,location);
            // if(PAGE_TYPE=="approval"){
            //     param.status="approval";
            // }
            // param.pageType=PAGE_TYPE;
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {
            for (var i = 0; i < data.length; i++) {
                //如果审批中或审批通过的不允许编辑
                if(data[i].status=="complete") {
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    //fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="incomplete"){
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="deny"){
                    fox.disableButton($('.clean-out-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="approval"){
                    fox.disableButton($('.clean-out-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="cancel"){
                    fox.disableButton($('.clean-out-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }

                if(data[i].cleanStatus=="complete"){
                    fox.disableButton($('.clean-out-button').filter("[data-id='" + data[i].id + "']"), true);
                }

            }

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(value==null) return "";
            return value;
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
        beforeRowOperationEvent:function (data,obj) {
            // if(obj.event=="edit") {
            //     if(data.status=="complete"||data.status=="approval"){
            //         layer.msg("当前状态不允许修改", {icon: 2, time: 1000});
            //         return false;
            //     }
            // }
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        downloadBill:function (data){
            console.log('downloadBill',data);
            var downloadUrl="/service-eam/eam-asset-bill/query-scrap-bill";
            fox.submit(downloadUrl,{id:data.id});
        },
        billOper:function(url,btnClass,ps,successMessage){
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api=moduleURL+"/"+url;

            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, ps, function (r) {
                    if (r.success) {
                        top.layer.msg(successMessage, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        var errs = [];
                        if(r.errors&&r.errors.length>0){
                            for (var i = 0; i < r.errors.length; i++) {
                                if (errs.indexOf(r.errors[i].message) == -1) {
                                    errs.push(r.errors[i].message);
                                }
                            }
                            top.layer.msg(errs.join("<br>"), {time: 2000});
                        } else {
                            top.layer.msg(r.message, {time: 2000});
                        }
                    }
                }, {delayLoading: 1000, elms: [btn]});
            });
        },
        confirmData:function (item){
            list.billOper("confirm-operation","confirm-data-button",{id:item.id},"已确认");
        },
        forApproval:function (item){
            list.billOper("for-approval","for-approval-button",{id:item.id},"已送审");
        },
        revokeData:function (item){
            list.billOper("revoke-operation","revoke-data-button",{id:item.id},"已撤销");
        },
        cleanOut:function (item){
            list.billOper("clean-out","clean-out-button",{id:item.id},"已清理");
        },
        agreeData:function(data){
            console.log("agreeData:",data);
            var api=moduleURL+"/approve";
            var successMessage="审批结束"
            var ps={};
            ps.instanceIds=[];
            ps.instanceIds.push(data.changeInstanceId);
            ps.opinion="";
            ps.action="agree"
            var btn=$('.agree-button').filter("[data-id='" +data.id + "']");
            layer.prompt({
                formType: 2,
                value: "同意 ",
                title: '请输入审批意见',
                area: ['320px', '150px'] //自定义文本域宽高
            }, function(value, index, elem){
                ps.opinion=value;
                admin.post(api, ps, function (r) {
                    layer.close(index);
                    if (r.success) {
                        top.layer.msg(successMessage, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        var errs = [];
                        if(r.errors&&r.errors.length>0){
                            for (var i = 0; i < r.errors.length; i++) {
                                if (errs.indexOf(r.errors[i].message) == -1) {
                                    errs.push(r.errors[i].message);
                                }
                            }
                            top.layer.msg(errs.join("<br>"), {time: 2000});
                        } else {
                            top.layer.msg(r.message, {time: 2000});
                        }
                    }
                }, {delayLoading: 1000, elms: [btn]});
            });

        },
        denyData:function(data){

            var api=moduleURL+"/approve";
            var ps={};
            var successMessage="审批结束"
            ps.instanceIds=[];
            ps.instanceIds.push(data.changeInstanceId);
            ps.opinion="";
            ps.action="reject"
            var btn=$('.deny-button').filter("[data-id='" +data.id + "']");
            layer.prompt({
                formType: 2,
                value: "拒绝 ",
                title: '请输入审批意见',
                area: ['320px', '150px'] //自定义文本域宽高
            }, function(value, index, elem){
                ps.opinion=value;
                admin.post(api, ps, function (r) {
                    layer.close(index);
                    if (r.success) {
                        top.layer.msg(successMessage, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        var errs = [];
                        if(r.errors&&r.errors.length>0){
                            for (var i = 0; i < r.errors.length; i++) {
                                if (errs.indexOf(r.errors[i].message) == -1) {
                                    errs.push(r.errors[i].message);
                                }
                            }
                            top.layer.msg(errs.join("<br>"), {time: 2000});
                        } else {
                            top.layer.msg(r.message, {time: 2000});
                        }
                    }
                }, {delayLoading: 1000, elms: [btn]});
            });


        },
        /**
         *
         * 末尾执行
         */
        ending:function() {

        }
    }

    var timestamp = Date.parse(new Date());
    var formAction=admin.getTempData('eam-asset-scrap-form-data-form-action');


    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {
            $("#originatorUserName").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#originatorUserName").attr("placeholder","自动填充")
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        onProcessInstanceReady:function (result) {
            // 可根据流程状态、当前审批节点判断和控制表单页面
            console.log("onProcessInstanceReady")
            processInstance=result.data;
            console.log("processInstance",processInstance)
            // 非起草状态不允许修改表单
            if(processInstance && processInstance.approvalStatus!="drafting") {
                fox.lockForm($("#data-form"),true);
            }
            // 获得所有待办节点
            var todoNodes=bpm.getTodoNodes(processInstance);
            console.log("todoNodes",todoNodes);
            // 判断是否为待办节点
            var isTodoNode=bpm.isTodoNodes(processInstance,"N1");
            console.log("isTodoNode:N1",isTodoNode);
            // 判断是否为当前账户的待办节点
            var isMyTodoNode=bpm.isCurrentUserTodoNode(processInstance,"N1");
            console.log("isMyTodoNode:N1",isMyTodoNode);
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
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            if(data&&data.id){
                console.log(1);
            }else{
                setTimeout(function(){
                    var now = new Date();
                    var day = ("0" + now.getDate()).slice(-2);
                    var month = ("0" + (now.getMonth() + 1)).slice(-2);
                    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
                    $('#scrapDate').val(today);

                },100)
            }

        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            if(data&&data.id){
                window.module.adjustPopup();
            }
            console.log('afterDataFill',data);
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="组织/人员选择对话框";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            var dataListSize=$(".form-iframe")[0].contentWindow.module.getDataListSize();
            if(dataListSize==0){
                layer.msg("请选择资产数据", {icon: 2, time: 1000});
                return false;
            }
            data.selectedCode=timestamp;
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },
        /**
         *  加载 资产列表
         */
        assetSelectList:function (ifr,win,data) {
            console.log("assetSelectList",ifr,data);
            //设置地址
            if(INSTANCE_DATA){
                if(INSTANCE_DATA.approvalStatus=="drafting"){
                    console.log("processInstance",INSTANCE_DATA.approvalStatus,"edit");
                    formAction="edit"
                }else if(INSTANCE_DATA.approvalStatus=="complete"){
                    console.log("processInstance",INSTANCE_DATA.approvalStatus,"view");
                    formAction="view"
                }else{
                    console.log("processInstance",INSTANCE_DATA.approvalStatus,"view");
                    formAction="view"
                }
            }else{
                formAction="create";
            }
            console.log("assetSelectList data",formAction,processInstance)
            ifr.height("450px");
            //设置地址
            var data={};
            data.searchContent={};
            data.assetSelectedCode=timestamp;
            data.assetBusinessType="eam_asset_scrap"
            data.action=formAction;
            data.ownerCode="asset";
            if(BILL_ID==null)BILL_ID="";
            data.assetOwnerId=BILL_ID;
            admin.putTempData('eam-asset-selected-data'+timestamp,data,true);
            admin.putTempData('eam-asset-selected-action'+timestamp,formAction,true);
            win.location="/business/eam/asset/asset_selected_list.html?assetSelectedCode="+timestamp+"&pageType="+formAction;
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