/**
 * 维修工单 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 21:56:16
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


    var browserVersion = window.navigator.userAgent.toUpperCase();
    var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
    var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
    var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
    var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
    var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
    var isIE9More = (! -[1,] == false);


    //模块基础路径
    const moduleURL="/service-eam/eam-repair-order-act";
    var timestamp = Date.parse(new Date());
    //列表页的扩展
    var list={

        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            $("#data-table").css("width", "100%");
            console.log("list:beforeInit");
            var operHtml=document.getElementById("toolbarTemplate").innerHTML;
            operHtml=operHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
            document.getElementById("toolbarTemplate").innerHTML=operHtml;



            if(REPAIR_STATUS){
                 if(REPAIR_STATUS=="dispatched"){

                    var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                    operHtml=operHtml.replace(/lay-event="acceptance"/i, "style=\"display:none\"");
                    operHtml=operHtml.replace(/lay-event="finish"/i, "style=\"display:none\"");
                    document.getElementById("tableOperationTemplate").innerHTML=operHtml;

                }else if(REPAIR_STATUS=="wait_repair"){
                     var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                     operHtml=operHtml.replace(/lay-event="acceptance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="maintenance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="finish"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="cancel"/i, "style=\"display:none\"");
                     document.getElementById("tableOperationTemplate").innerHTML=operHtml;

                }else if(REPAIR_STATUS=="repairing"){
                     var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                     operHtml=operHtml.replace(/lay-event="acceptance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="start"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                     operHtml=operHtml.replace(/lay-event="cancel"/i, "style=\"display:none\"");
                     document.getElementById("tableOperationTemplate").innerHTML=operHtml;

                }else if(REPAIR_STATUS=="wait_acceptance"){
                     var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                     operHtml=operHtml.replace(/lay-event="maintenance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="finish"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="start"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="cancel"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                     document.getElementById("tableOperationTemplate").innerHTML=operHtml;


                }else if(REPAIR_STATUS=="finish"){

                     var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                     operHtml=operHtml.replace(/lay-event="maintenance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="acceptance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="finish"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="cancel"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="start"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                     document.getElementById("tableOperationTemplate").innerHTML=operHtml;


                 }else if(REPAIR_STATUS=="cancel"){
                     var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                     operHtml=operHtml.replace(/lay-event="maintenance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="acceptance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="finish"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="start"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="cancel"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                     document.getElementById("tableOperationTemplate").innerHTML=operHtml;
                }else if(REPAIR_STATUS=="all"){
                     var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                     operHtml=operHtml.replace(/lay-event="maintenance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="acceptance"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="finish"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="start"/i, "style=\"display:none\"");
                     operHtml=operHtml.replace(/lay-event="cancel"/i, "style=\"display:none\"");
                     document.getElementById("tableOperationTemplate").innerHTML=operHtml;
                 }

            }

    },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            cfg.cellMinWidth=200;;
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
            if(REPAIR_STATUS){
                if(REPAIR_STATUS=="all"){
                    console.log("none")
                }else{
                    param.status=REPAIR_STATUS;
                }
            }
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {


            for (var i = 0; i < data.length; i++) {
                //如果审批中或审批通过的不允许编辑
                console.log(data[i]);
                var status=data[i].status;
                if(status=="finish") {
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.start-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.acceptance-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.maintenance-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(status=="cancel"){
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.start-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.acceptance-button').filter("[data-id='" + data[i].id + "']"), true);

                    fox.disableButton($('.maintenance-button').filter("[data-id='" + data[i].id + "']"), true);

                }
                else if(status=="wait_repair"){
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.start-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.acceptance-button').filter("[data-id='" + data[i].id + "']"), true);

                }
                else if(status=="dispatched"){
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.start-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-button').filter("[data-id='" + data[i].id + "']"), true);
                    //   fox.disableButton($('.cancel-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.acceptance-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(status=="repairing"){
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.start-button').filter("[data-id='" + data[i].id + "']"), true);
                    //   fox.disableButton($('.finish-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.acceptance-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(status=="wait_acceptance"){
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.start-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-button').filter("[data-id='" + data[i].id + "']"), true);


                    //  fox.disableButton($('.acceptance-button').filter("[data-id='" + data[i].id + "']"), true);
                }
                // if(data[i].order&&data[i].order.repairStatus){
                //     var status=data[i].order.repairStatus;
                //     console.log("####",status);
                //
                // }
            }

        },
        /**
         * 进一步转换 list 数据
         * */

        templet:function (field,value,r) {
            if(field=="orderRepairStatus"){
                if(value){
                    if(value=="repairing"){
                        return "维修中"
                    }else if (value=="wait_acceptance"){
                        return "待验收"
                    }else if (value=="finish"){
                        return "维修结束"
                    }
                }
            }

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
        start:function(item,it){
            list.billOper("start","start-button",{id:item.id},"开始维修");
        },
        finish:function(item,it){
            list.billOper("finish","finish-button",{id:item.id},"结束维修");
        },
        cancel:function(item,it){
            list.billOper("cancel","cancel-button",{id:item.id},"取消成功");
        },
        maintenance:function(item,it){
            admin.post(moduleURL+"/get-by-id", { id : item.id }, function (res) {
                if(res.success) {
                    admin.putTempData('eam-repair-order-act-form-data-form-action', "edit",true);
                    var queryString="?id="+item.id;
                    admin.putTempData('eam-repair-order-act-form-data', res.data);
                    var area=admin.getTempData('eam-repair-order-act-form-area');
                    var height= (area && area.height) ? area.height : ($(window).height()*0.6);
                    var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
                    admin.popupCenter({
                        title: "维修工单",
                        resize: false,
                        offset: [top,null],
                        area: ["80%",height+"px"],
                        type: 2,
                        id:"eam-repair-order-act-form-data-win",
                        content: '/business/eam/repair_order_act/repair_order_act_form.html' +queryString,
                        finish: function () {
                            window.module.refreshTableData();
                        }
                    });
                } else {
                    fox.showMessage(res);
                }
            });




        },
        acceptance:function(data,it){

            function openForm(bill_action,bill_data){
                var action=bill_action;
                admin.putTempData('eam-repair-order-acceptance-form-data-form-action', action,true);
                admin.putTempData('eam-repair-order-acceptance-form-data', bill_data);
                var queryString="";
                if(action=="create"){
                    queryString="?orderActId="+bill_data.orderActId;
                }else{
                    queryString="?id="+bill_data.id+"&orderActId="+bill_data.orderActId;
                }
                var area=admin.getTempData('eam-repair-order-acceptance-form-area');
                var height= (area && area.height) ? area.height : ($(window).height()*0.6);
                var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
                var title = fox.translate('维修工单');
                if(action=="create") title=fox.translate('添加')+title;
                else if(action=="edit") title=fox.translate('修改')+title;
                else if(action=="view") title=fox.translate('查看')+title;
                admin.popupCenter({
                    title: title,
                    resize: false,
                    offset: [top,null],
                    area: ["80%",height+"px"],
                    type: 2,
                    id:"eam-repair-order-acceptance-form-data-win",
                    content: '/business/eam/repair_order_acceptance/repair_order_acceptance_form.html' + queryString,
                    finish: function () {
                        window.module.refreshTableData();
                    }
                });
            }
            var ps={};
            ps.orderActId=data.id;
            ps.pageIndex=1;
            ps.pageSize=50;
            ps.searchField="$composite";
            admin.post("/service-eam/eam-repair-order-acceptance/query-paged-list", ps, function (r) {
                if (r.success) {
                    if(r.data&&r.data.list){
                        var list=r.data.list;
                        if(list.length==0){
                            openForm("create",{orderActId:data.id})
                        }else if(list.length==1){
                            openForm("edit",list[0])
                        }else{
                            alert("表单错误")
                        }
                    }
                } else {
                    fox.showMessage(data);
                }
            });


            //  var queryString=""

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


            $("#orderName").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#orderBusinessCode").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#businessCode").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#groupId").attr("disabled","disabled").css("background-color","#e6e6e6");



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
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
            //isAdd, 此次操作是新增还是删除
            if(id=="groupId"){
                if(isAdd&&changes.length>0){
                    var userSelect= xmSelect.get('#executorId',true);
                    console.log("userSelect",userSelect);
                    var item=changes[0];
                    admin.post("/service-eam/eam-group-user/query-employee-person", { groupId : item.data.id }, function (r) {
                        if (r.success) {
                            var d=[];
                            for (var i = 0; i < r.data.length; i++) {
                                d.push({name:r.data[i].name,value:r.data[i].employeeId});
                            }
                            userSelect.update({data:d})
                        } else {
                            fox.showMessage(r);
                        }
                    });
                }
            }


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
            data.orderId=ORDER_ID;
            data.selectedCode=timestamp;
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
         *  加载 资产列表
         */
        deviceSpList:function(ifr,win,data){
                var  action=admin.getTempData('eam-repair-order-act-form-data-form-action');
                //设置 iframe 高度
                ifr.height("400px");

                var selectCode=timestamp;
                var pageType=action;
                var ownerId="";
                var ownerType="eam_repair_act_sp";
                if(pageType=="create"){
                    ownerId=timestamp;
                }else{
                    ownerId=data.id;
                }
                //设置地址
                win.location="/business/eam/repair_order_act_sp/repair_sp_selected_list.html?ownerType="+ownerType+"&ownerId="+ownerId+"&pageType="+pageType+"&selectedCode="+selectCode


        },
        assetSelectList:function(ifr,win,item){
            console.log("assetSelectList",ifr,item);
            //设置 iframe 高度
            ifr.height("150px");

            //设置地址
            var data={};
            data.searchContent={};
            data.assetSelectedCode=timestamp;
            data.assetBusinessType="eam_asset_repair_order";
            data.action="view";
            data.ownerCode="asset";
            data.assetOwnerId=item.orderId
            admin.putTempData('eam-asset-selected-data'+timestamp,data,true);
            admin.putTempData('eam-asset-selected-action'+timestamp,"view",true);
            // win.location="/business/eam/asset/asset_selected_list.html?pageType=view&assetSelectedCode="+timestamp
            win.location="/business/eam/repair_order_act/repair_asset_form.html?orderId="+item.orderId

        },
        reinitIframe:function(iframeId, minHeight) {
        try {
            var iframe = document.getElementById(iframeId);
            var bHeight = 0;
            if (isChrome == false && isSafari == false) {
                try {
                    bHeight = iframe.contentWindow.document.body.scrollHeight;
                } catch (ex) {
                }
            }
            var dHeight = 0;
            if (isFireFox == true)
                dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;//如果火狐浏览器高度不断增加删除+2
            else if (isIE == false && isOpera == false && iframe.contentWindow) {
                try {
                    dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                } catch (ex) {
                }
            }
            else if (isIE == true && isIE9More) {//ie9+
                var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
                if (heightDeviation == 0) {
                    bHeight += 3;
                } else if (heightDeviation != 3) {
                    eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                    bHeight += 3;
                }
            }
            else//ie[6-8]、OPERA
                bHeight += 3;

            var height = Math.max(bHeight, dHeight);
            if (height < minHeight) height = minHeight;
            //alert(iframe.contentWindow.document.body.scrollHeight + "~" + iframe.contentWindow.document.documentElement.scrollHeight);
            iframe.style.height = height + "px";
        } catch (ex) { }
    },
        timeLineList:function(ifr,win,item){
            function startInit(iframeId, minHeight) {
                //  eval("window.IE9MoreRealHeight" + iframeId + "=0");
                window.setInterval("window.pageExt.form.reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
            }
            console.log("timeLineList",ifr,item);
            var url ="/business/eam/repair_order_process/repair_time_line.html?orderId="+item.orderId+"&t="+timestamp
            $("#timeLineList-iframe").attr("src", url);
            $("#timeLineList-iframe").attr("scrolling", "no");
            startInit('timeLineList-iframe', 300);
        },
        repairOrderApply:function (ifr,win,data) {
            console.log("repairOrderApply",ifr,data);
            //设置 iframe 高度
            ifr.height("450px");
            //设置地址
            win.location="/business/eam/repair_order/repair_order_form.html?id="+data.orderId;
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