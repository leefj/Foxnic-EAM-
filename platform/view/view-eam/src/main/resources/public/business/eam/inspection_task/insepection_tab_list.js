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
		//调用 iframe 加载过程
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(i==0) {
				if(window.pageExt.list){
					jsFn=window.pageExt.list[jsFn];
					jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,'idle');
				}
			}
		}
		queryTabData("none");
		$("#wait_count_tab").on('click', function(){
			queryTabData("none","waitFunc");
		});
		$("#acting_count_tab").on('click', function(){
			queryTabData("none","actingFunc");
		});
		$("#all_data_tab").on('click', function(){
			queryTabData("none","allFunc");
		});
	}
	function queryTabData(label,elId){

		console.log("elId",elId);
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(jsFn==elId){
				jsFn=window.pageExt.list[jsFn];
				jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,'idle');
			}
		}
		admin.post("/service-eam/eam-inspection-task/query-status-count-data", { label :label }, function (r) {
			if (r.success) {
				var data=r.data;
				$("#wait_count").html(data.waitCount);
				$("#acting_count").html(data.actingCount);
			} else {
				fox.showMessage(r);
			}
		});
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