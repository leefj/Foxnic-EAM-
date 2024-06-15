/**
 * 文件 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-23 07:46:36
 */


function ListPage() {
    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-oa/oa-netdisk-file";
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;
    }
    window.module={
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