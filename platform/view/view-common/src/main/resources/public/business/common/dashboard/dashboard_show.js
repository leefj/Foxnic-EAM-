/**
 * 面板 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 06:45:59
 */


function ListPage() {
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;
		if(window.pageExt.list.beforeInit) {
			window.pageExt.list.beforeInit();
		}
     	//渲染表格
		var html="";
		if(DATA){
			for(var i=0;i<DATA.length;i++){
				var layerHtml="<div class=\"layui-fluid\"><div class=\"layui-row layui-col-space12\">";
				var dlayer=DATA[i];
				var space="12";
				if(dlayer.colType=="one"){
					space="12"
				}else if(dlayer.colType=="two"){
					space="6"
				}else if(dlayer.colType=="three"){
					space="4"
				}else if(dlayer.colType=="four"){
					space="3"
				}else if(dlayer.colType=="six"){
					space="2"
				}
			 	if(dlayer.dashboardLayerEleValid&&dlayer.dashboardLayerEleValid.length>0){
					console.log("dlayer.dashboardLayerEleValid.length",dlayer.dashboardLayerEleValid);
			 		for(var j=0;j<dlayer.dashboardLayerEleValid.length;j++){
						var eleHtml="";
			 			var ele=dlayer.dashboardLayerEleValid[j];
						var reportChart=ele.reportChart;
						var ctlJson=JSON.parse(ele.json);
						var ctl={};
						ctl.height="350px";
						ctl.iframe_scrolling="no";
						ctl.url="";
						if(ctlJson&&ctlJson.height){
							ctl.height=ctlJson.height;
						}
						if(ctlJson&&ctlJson.iframe_scrolling){
							ctl.iframe_scrolling=ctlJson.iframe_scrolling;
						}
						if(ctlJson&&ctlJson.url&&ctlJson.url.length>2){
							ctl.url=ctlJson.url;
						}else{
							if(reportChart){
								ctl.url=ele.reportChart.route;
							}
						}
						console.log("ctlJson:",ctlJson);
						console.log("ctl:",ctl);
						eleHtml=eleHtml+"<div class=\"layui-col-md"+space+"\">"
						if(ele.type=="card"){
							eleHtml=eleHtml+" <div class=\"panel\">\n" +
								"                <div class=\"panel-body\">\n" +
								"                    <iframe src=\""+ctl.url+"&_t=0\" width=\"100%\" height=\"80%\" allowtransparency=\"yes\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\"  frameborder=\"no\" border=\"no\" style=\"overflow:hidden\"></iframe>\n" +
								"                </div>\n" +
								"            </div>"
						}else if(ele.type=="chart"){
							eleHtml=eleHtml+" <div class=\"layui-card\">\n" +
								"                <div class=\"layui-card-header\">"+ele.title+"</div>\n" +
								"                <div class=\"layui-card-body\">\n" +
								"                    <div class=\"layui-row layui-col-space10\">\n" +
								"                        <div style=\"height:"+ctl.height+"!important;\">\n" +
								"                            <iframe src=\""+ctl.url+"&_t=0\" width=\"100%\" height=\"100%\" allowtransparency=\"yes\" marginwidth=\"0\" marginheight=\"0\" scrolling=\""+ctl.iframe_scrolling+"\"  frameborder=\"no\" border=\"no\" style=\"overflow:hidden\"></iframe>\n" +
								"                        </div>\n" +
								"                    </div>\n" +
								"                </div>\n" +
								"            </div>"
						}
						eleHtml=eleHtml+"</div>"
						layerHtml=layerHtml+eleHtml
					}
					layerHtml=layerHtml+"</div></div>";
					html=html+layerHtml;
				}
			}
		}
		$("#dashboard").html(html);
     }
	window.module={};
	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});