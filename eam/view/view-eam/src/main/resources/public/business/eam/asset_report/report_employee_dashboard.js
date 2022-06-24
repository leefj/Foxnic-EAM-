/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
    var settings,admin,table,layer,util,fox,upload,xmSelect,echarts;

    const moduleURL="/service-eam/eam-asset-report";
    //模块基础路径
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;


        $("#myasset").click(function(){

            admin.popupCenter({
                title: "我的资产",
                resize: false,
                offset: [top,null],
                area: ["85%","500px"],
                type: 2,
                id:"eam-asset-employee-myasset-form-data-win",
                content: '/business/eam/daily_management/myAsset_list.html',
                finish: function () {
                }
            });
        })


        $("#zcly").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-employee-apply-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;
            admin.putTempData('eam-asset-employee-apply-form-data', data);
            var area=admin.getTempData('eam-asset-employee-apply-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('领用申请');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["85%",height+"px"],
                type: 2,
                id:"eam-asset-employee-apply-form-data-win",
                content: '/business/eam/asset_employee_apply/asset_employee_apply_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        })


        $("#zcly").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-employee-apply-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;
            admin.putTempData('eam-asset-employee-apply-form-data', data);
            var area=admin.getTempData('eam-asset-employee-apply-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('领用申请');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["85%",height+"px"],
                type: 2,
                id:"eam-asset-employee-apply-form-data-win",
                content: '/business/eam/asset_employee_apply/asset_employee_apply_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        })


        $("#zcjj").click(function(){
            var data={}
            var action=admin.getTempData('eam-asset-employee-handover-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;
            admin.putTempData('eam-asset-employee-handover-form-data', data);
            var area=admin.getTempData('eam-asset-employee-handover-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产交接');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["85%",height+"px"],
                type: 2,
                id:"eam-asset-employee-handover-form-data-win",
                content: '/business/eam/asset_employee_handover/asset_employee_handover_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        })


        $("#zcbs").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-employee-loss-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;
            admin.putTempData('eam-asset-employee-loss-form-data', data);
            var area=admin.getTempData('eam-asset-employee-loss-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产报失');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["85%",height+"px"],
                type: 2,
                id:"eam-asset-employee-loss-form-data-win",
                content: '/business/eam/asset_employee_loss/asset_employee_loss_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        })




        $("#zcbx").click(function(){

            var data={};
            var action=admin.getTempData('eam-asset-employee-repair-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;

            admin.putTempData('eam-asset-employee-repair-form-data', data);
            var area=admin.getTempData('eam-asset-employee-repair-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产报修');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["85%",height+"px"],
                type: 2,
                id:"eam-asset-employee-repair-form-data-win",
                content: '/business/eam/asset_employee_repair/asset_employee_repair_form.html' + (queryString?("?"+queryString):""),
                finish: function () {

                }
            });
        })




    }



};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
    var task=setInterval(function (){
        if(!window["pageExt"]) return;
        clearInterval(task);
        (new ListPage()).init(layui);
    },1);
});