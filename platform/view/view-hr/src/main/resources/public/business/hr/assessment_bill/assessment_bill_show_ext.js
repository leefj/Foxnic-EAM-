/**
 * 考核单据 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 08:31:58
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
    const moduleURL="/service-hr/hr-assessment-bill";


    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");

            var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
            toolHtml=toolHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
            document.getElementById("toolbarTemplate").innerHTML=toolHtml;

            if(!TASK_ID){
                var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                toolHtml=toolHtml.replace(/lay-event="tool-create-bill-task"/i, "style=\"display:none\"")
                document.getElementById("toolbarTemplate").innerHTML=toolHtml;
            }
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
            param.taskId=TASK_ID;
            console.log('beforeQuery',conditions,param,location);
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
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
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
            if(value==null) return "";
            return value;
        },
        /**
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {
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
        beforeRowOperationEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        moreActionMenu (items,data, it){
            console.log('moreActionMenu',items,data,it);
            return items;
        },
        createBillTask:function (selected,it){
            var btnClass="create-bill-task";
            var ps={};
            ps.taskId=TASK_ID;
            var btn=$('.'+btnClass)
            var api="/service-hr/hr-assessment-task/create-task";
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

        BillTaskCopy:function (data){
            console.log('createBilCopt',data);
            var btnClass="bill-task-copy";
            var ps={};
            ps.id=data.id;
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api="/service-hr/hr-assessment-bill/copy";
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
        BillTaskReset:function (data){
            console.log('createBillTask',data);
            var btnClass="bill-task-reset";
            var ps={};
            ps.id=data.id;
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api="/service-hr/hr-assessment-bill/reset";
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


        BillTaskCancel:function (data){
            console.log('BillTaskCancel',data);
            var btnClass="create-bill-cancel";
            var ps={};
            ps.id=data.id;
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api="/service-hr/hr-assessment-bill/cancel";
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
        BillTaskDown:function (data){
            console.log('BillTaskDown',data);
            var btnClass="create-bill-down";
            var ps={};
            ps.id=data.id;
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api="/service-hr/hr-assessment-bill/release";
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
        pfrData:function (data){
            admin.popupCenter({
                title: "评分人列表",
                resize: false,
                offset: [10,null],
                area: ["95%","95%"],
                type: 2,
                id:"hr-assessment-person2-form-data-win",
                content: '/business/hr/assessment_bill_task/tree_bill_task_list.html.html?billId='+data.id,
                finish: function () {
                }
            });
        },
        BillDtl:function (data){
            console.log('BillDtl',data);
            admin.popupCenter({
                title: "下发列表",
                resize: false,
                offset: [10,null],
                area: ["90%","90%"],
                type: 2,
                id:"hr-assessment-bill-form-data-win",
                content: '/business/hr/assessment_bill_task/assessment_bill_task_list.html?billId='+data.id,
                finish: function () {
                }
            });
        },
        personData:function (data){
            console.log('personData',data);
            admin.popupCenter({
                title: "人员列表",
                resize: false,
                offset: [10,null],
                area: ["95%","95%"],
                type: 2,
                id:"hr-assessment-person-form-data-win",
                content: '/business/hr/assessment_bill_user_map/assessment_bill_user_map_list.html?billId='+data.id,
                finish: function () {
                }
            });
        },
        /**
         * 末尾执行
         */
        ending:function() {

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