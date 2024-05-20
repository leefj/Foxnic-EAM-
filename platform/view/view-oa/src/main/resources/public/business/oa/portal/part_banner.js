
function PortalPage() {
    var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown,element,bpm;


    this.init=function (layui) {
        admin = layui.admin, settings = layui.settings, form = layui.form, upload = layui.upload, foxup = layui.foxnicUpload, dropdown = layui.dropdown;
        layer = layui.layer, util = layui.util, fox = layui.foxnic, element = layui.element, bpm = layui.bpm;

        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#carousel'
            , width: '100%' //设置容器宽度
            , height: "265px"
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });


    }

    window.module={
        refreshRowData:function (){
            // debugger
            // bpm.closeProcessView();
        },
        refreshTableData:function () {
            // debugger
            //bpm.closeProcessView();
        }
    }

}




layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
});

layui.define(['carousel','form', 'table', 'util', 'settings', 'admin', 'foxnic','bpm'],function () {});

layui.use(['carousel','form', 'table', 'util', 'settings', 'admin', 'foxnic','bpm'],function() {
    var task=setInterval(function (){
        clearInterval(task);
        (new PortalPage()).init(layui);
    },1);
});
