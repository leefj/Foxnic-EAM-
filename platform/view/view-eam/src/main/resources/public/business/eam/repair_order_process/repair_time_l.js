/**
 * 维修验收 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-05 09:01:10
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;
	const bpmIntegrateMode="none";
	var isInProcess=QueryString.get("isInProcess");

	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;


		var ps={orderId:ORDER_ID};
		admin.post("/service-eam/eam-repair-order-process/query-list", ps, function (r) {
			if (r.success) {
				var html="";
				var d=r.data;
				if(d&&d.length>0){

					for(var i=0;i<d.length;i++){
						console.log("ddddd",d);
						var t="<li class=\"layui-timeline-item\">\n" +
							"\t\t\t<i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>\n" +
							"\t\t\t<div class=\"layui-timeline-content layui-text\">\n" +
							"\t\t\t\t<h3 class=\"layui-timeline-title\">"+d[i].rcdTime+"</h3>\n" +
							"\t\t\t\t<div>\n" +
							"\t\t\t\t\t<br>" +d[i].userName +
							"\t\t\t\t\t<br>" +d[i].processContent+
							"\t\t\t\t</div>\n" +
							"\t\t\t</div>\n" +
							"\t\t</li>"
						html=html+t;
					}
				}
				$("#lineData").html(html)
			} else {
				fox.showMessage(data);
			}
		});


		//调整窗口的高度与位置
		adjustPopup();







	}





	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup(arg) {
		if(window.pageExt.form.beforeAdjustPopup) {
			var doNext=window.pageExt.form.beforeAdjustPopup(arg);
			if(!doNext) return;
		}



		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		var prevBodyHeight=-1;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			if(bpmIntegrateMode=="front" && isInProcess==1) {
				var updateFormIframeHeight=admin.getVar("updateFormIframeHeight");
				if(bodyHeight>0 && bodyHeight!=prevBodyHeight) {
					updateFormIframeHeight && updateFormIframeHeight(bodyHeight);
				} else {
					setTimeout(function() {adjustPopup(arg);},1000);
				}
				prevBodyHeight = bodyHeight;
				return;
			}
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-repair-order-acceptance-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-repair-order-acceptance-form-area', area);
			window.adjustPopup=adjustPopup;
			if(area.tooHeigh) {
				var windowHeight=area.iframeHeight;
				var finalHeight=windowHeight-footerHeight-16;
				//console.log("windowHeight="+windowHeight+',bodyHeight='+bodyHeight+",footerHeight="+footerHeight+",finalHeight="+finalHeight);
				$(".form-container").css("display","");
				$(".form-container").css("overflow-y","scroll");
				$(".form-container").css("height",finalHeight+"px");
				$(".form-container").attr("scroll","yes");
			}
		},250);
	}



}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});