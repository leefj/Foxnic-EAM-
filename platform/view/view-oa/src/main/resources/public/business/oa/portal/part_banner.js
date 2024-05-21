function PortalPage() {
    var settings,admin,util;
    this.init=function (layui) {
        admin = layui.admin, settings = layui.settings,  util = layui.util;
         function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
         }
         var parHeight=400;
         if(getUrlParam("height")){
             parHeight=getUrlParam("height");
         }
        var carousel = layui.carousel;
        //建造实例
        console.log("parHeight:",parHeight);
        carousel.render({
            elem: '#carousel'
            , width: '100%' //设置容器宽度
            , height: parHeight+"px"
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    }
    window.module={
    }
}
layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
});
layui.define(['carousel', 'util','settings', 'admin', 'foxnic'],function () {});
layui.use(['carousel', 'util', 'settings', 'admin', 'foxnic'],function() {
    var task=setInterval(function (){
        clearInterval(task);
        (new PortalPage()).init(layui);
    },1);
});
