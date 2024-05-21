
function PortalPage() {
    var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown,element,bpm;

    this.init=function (layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
        layer = layui.layer,util = layui.util,fox = layui.foxnic,element=layui.element,bpm=layui.bpm;

        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
        var parHeight=350;
        if(getUrlParam("height")){
            parHeight=getUrlParam("height");
        }
        $("#card").css("height",parHeight+"px");
        // 请求统计信息
        admin.post("/service-bpm/portal/query-summary",{},function (r){
            for(var n in r.data) {
                $("#" + n).text(r.data[n]);
            }
        });
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
