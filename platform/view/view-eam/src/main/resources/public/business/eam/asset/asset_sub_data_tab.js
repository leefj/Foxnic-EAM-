/**
 * 分单规则 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 09:38:41
 */
function ListPage() {
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn = $(formIfrs[i]).attr("js-fn");
			if (jsFn == "stockFunc"){
				if (window.pageExt.list) {
					jsFn = window.pageExt.list[jsFn];
					jsFn && jsFn($(formIfrs[i]), $(formIfrs[i])[0].contentWindow, 'idle');
				}
				break;
			}
		}

		if(window.pageExt.list){
			jsFn=window.pageExt.list[jsFn];
			jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,'idle');
		}

		$("#asset_data_tab").on('click', function(){
			queryTabData("none","assetFunc","stock_data");
		});
		$("#goods_data_tab").on('click', function(){
			queryTabData("none","goodsFunc","goods_data");
		});
		$("#stock_data_tab").on('click', function(){
			queryTabData("none","stockFunc","stock_data");

		});

	}
	function queryTabData(label,elId,frameId){
		$("#"+frameId).show();
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(jsFn==elId){
				jsFn=window.pageExt.list[jsFn];
				jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,'idle');
			}
		}
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