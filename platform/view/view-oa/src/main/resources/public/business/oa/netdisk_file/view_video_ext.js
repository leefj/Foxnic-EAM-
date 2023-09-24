/**
 * 文件 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:19:48
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
    const moduleURL="/service-oa/oa-netdisk-file";
    //列表页的扩展
    var list={
        ending:function() {
        }
    }
    //表单页的扩展
    var form={
        ending:function() {
        }
    }
    window.pageExt={form:form,list:list};
});