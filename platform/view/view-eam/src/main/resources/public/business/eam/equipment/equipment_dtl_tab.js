/**
 * 分单规则 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 09:38:41
 */
function ListPage() {
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

		//调用 iframe 加载过程
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(i==0){
				if(window.pageExt.list){
					jsFn=window.pageExt.list[jsFn];
					jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,'idle');
				}
			}
		}
	//	queryTabData("none","baseInfo");
		$("#base_info_tab").on('click', function(){
			queryTabData("none","baseInfo");
		});
		$("#data_property_tab").on('click', function(){
			queryTabData("none","dataProperty");
		});
		$("#data_service_tab").on('click', function(){
			queryTabData("none","dataService");
		});
		$("#data_log_tab").on('click', function(){
			queryTabData("none","dataLog");
		});
		$("#data_conf_tab").on('click', function(){
			queryTabData("none","dataConf");
		});
		$("#mn_report_tab").on('click', function(){
			queryTabData("none","mnReport");
		});
		$("#mn_eq_tab").on('click', function(){
			queryTabData("none","mnEq");
		});

	}

	function queryTabData(label,elId){
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