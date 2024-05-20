
function PortalPage() {
	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown,element,bpm;

	var APPROVAL_CATALOG={
		drafting:{
			menuId:"684486522925219840"
		},
		drafted:{
			menuId:"684483349707751424"
		},
		approving:{
			menuId:"581774422726148097"
		},
		approved:{
			menuId:"600316565472149504"
		},
	};
	var CURRENT_PROCESS_INSTANCE_CATALOG ="approving";

	var PROCESS_INSTANCES={};
	var PROCESS_DEFINITIONS={};

	this.init=function (layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		layer = layui.layer,util = layui.util,fox = layui.foxnic,element=layui.element,bpm=layui.bpm;

		var carousel = layui.carousel;
		//建造实例
		carousel.render({
			elem: '#carousel'
			,width: '100%' //设置容器宽度
			,height:"265px"
			,arrow: 'always' //始终显示箭头
			//,anim: 'updown' //切换动画方式
		});

		// 请求统计信息
		admin.post("/service-bpm/portal/query-summary",{},function (r){
			for(var n in r.data) {
				$("#" + n).text(r.data[n]);
			}
		});

		// 按审批状态请求流程实例
		for (var catalog in APPROVAL_CATALOG) {
			requestProcessInstances(6,catalog);
		}

		// 监听流程实例的tab事件
		element.on('tab(process-instances-tab)', function(data){
			var el=$(data.elem);
			el=el.find("li");
			el=$(el[data.index]);
			CURRENT_PROCESS_INSTANCE_CATALOG=el.attr("catalog")
		});



		// requestUserProcessDefinitions("/service-bpm/portal/query-commonly-used",15,"commonly-used");
		requestUserProcessDefinitions("/service-bpm/portal/query-latest-used",15,"latest-used");
		requestProcessDefinitionCatalogs("/service-bpm/portal/query-latest-used",15,"latest-used");



		var ps={}
		ps.pageIndex=1;
		ps.pageSize=50;
		ps.status="enable";
		var systemData = $("#system-data");
		admin.post("/service-oa/oa-system-information/query-paged-list",ps,function (r){
				if(r.success){
					var html="";
					if(r.data&&r.data.list&&r.data.list.length>0){
						var list=r.data.list;
						for(var i=0;i<list.length;i++){
							html=html+"<div class=\"item-div\">\n" +
								"<image style=\"height:25px;width:25px\" src=\"/service-storage/sys-file/image?id="+list[i].pictureId+"\"></image>\n" +
								"<span class=\"item-info\"><a  href=\"javascript:openSystem('"+list[i].url+"')\" class=\"item-info-a\" >"+list[i].name+"</a></span>\n" +
								"</div>"
						}

						systemData.html(html);
					}else{
						systemData.html("无");

					}
				}
		});

		//notice
		var ps1={}
		ps1.pageIndex=1;
		ps1.pageSize=5;
		ps1.status="enable";
		ps1.type="notice"
		admin.post("/service-oa/oa-notice/query-paged-data",ps1,function (r){
			if(r.success){
				fillNoticeData(r.data.list);
			}
		});


		//public
		var ps2={}
		ps2.pageIndex=1;
		ps2.pageSize=5;
		ps2.status="enable";
		ps2.type="public"
		admin.post("/service-oa/oa-notice/query-paged-data",ps2,function (r){
			if(r.success){
				fillPublicData(r.data.list);
			}
		});


		fillDownfile();
	}

	function fillDownfile(){
		var ps2={}
		ps2.pageIndex=1;
		ps2.pageSize=5;
		ps2.status="enable";
		admin.post("/service-oa/oa-download-file/query-paged-data",ps2,function (r){
			if(r.success){
				var downfileE=$("#downfile-data")
				var data=r.data.list;
				if(data.length>0){
					var html=""
					for(var i=0;i<data.length;i++){
						var e=data[i];
						var zd="";
						var title=e.name;
						html=html+"    <div class=\"oa-portal-card-item\">\n" +
							"             <a class=\"oa-portal-card-item-title\" href=\"javascript:openDownloadFile('"+data[i].fileId+"')\" > "+zd+title+"</a>\n" +
							"      <span class=\"oa-portal-card-item-desc\">"+data[i].createTime+"</span>\n" +
							"            </div>"
					}
					console.log("html:"+html);
					downfileE.html(html);
				}else{
					downfileE.html("无数据")
				}


			}
		});
	}


	function fillNoticeData(data){
		fillNPData(data,'notice-data');
	}

	function fillPublicData(data){
		fillNPData(data,'public-data')
	}


	function fillNPData(data,type){


		var noticeC=$("#"+type)
		if(data.length>0){
			var html=""
			for(var i=0;i<data.length;i++){
				var e=data[i];
				var zd="";
				if(e.iftop=="Y"){
					zd="<image style=\"width:11px;height: 11px;margin-right:5px;margin-bottom: 2px;\" src='./zd.png'></image>"
				}
				var title="";
				if(e.title.length>36){
					title=e.title.slice(0,35)+"...";
				}else{
					title=e.title;
				}
				html=html+"    <div class=\"oa-portal-card-item\">\n" +
					"                            <a class=\"oa-portal-card-item-title\" href=\"javascript:openNotice('"+data[i].id+"')\" > "+zd+title+"</a>\n" +
					"                            <span class=\"oa-portal-card-item-desc\">"+data[i].createTime+"</span>\n" +
					"                        </div>"
			}
			noticeC.html(html);
		}else{
			noticeC.html("无数据")
		}

	}


	function requestProcessDefinitionCatalogs() {
		admin.post("/service-bpm/portal/query-catalog",{},function (r){
			refreshProcessDefinitionCatalogs(r.data)
		});
	}

	function refreshProcessDefinitionCatalogs(data) {
		var container = $(".catalog-row");
		// container.empty();
		var html=[];
		for (var c=0;c<data.length;c++) {
			var cata=data[c];
			if(!cata.processDefinitionList || cata.processDefinitionList.length==0) continue;

			html.push('<div class="catalog-unit">');
			html.push('<div class="catalog-title">');
			html.push('<img src="/service-storage/sys-file/image?id='+cata.iconFilePc+'" style="width: 28px;float: left;">');
			html.push('<div>'+cata.name+'</div>');
			html.push('</div>');
			html.push('<div class="process-definition-items">');
			// debugger
			for (var i=0;i<cata.processDefinitionList.length;i++) {
				var def = cata.processDefinitionList[i];
				PROCESS_DEFINITIONS[def.id]=def;
				html.push([
					'<div class="process-definition-item" id="'+def.id+'">',
					'	<img src="/service-storage/sys-file/image?id='+def.iconFilePc+'" style="height: 42px;margin-top: 6px;margin-left: 6px">',
					'	<div style="margin: 8px 10px;">',
					'		<span class="process-definition-name">'+def.name+'</span><br>',
					'		<span class="process-definition-desc">'+(def.notes?def.notes:"无")+'</span>',
					'	</div>',
					'</div>'
				].join("\n"));
			}
			html.push('</div>');
			html.push('</div>');
		}

		container.append(html.join("\n"));

		$(".process-definition-item").off("click");
		$(".process-definition-item").click(function (it) {
			var id=$(this).attr("id");
			var def=PROCESS_DEFINITIONS[id];
			if(!def) return;
			debugger;
			// bpm.openProcessView(null,null,false,{"formDefinitionCode":def.formDefinition.code},null,null,"bill", {});
			bpm.openProcessView(null,null,false,{"formDefinitionCode":def.formDefinition.code},window.module.refreshTableData,window.module.refreshRowData,"process");
		});

		$("#start-process-button").click(function () {

		});


	}



	function requestUserProcessDefinitions(url,limit,el) {
		admin.post(url,{limit:limit},function (r){
			refreshUserProcessDefinitions(r.data,el)
		});
	}



	function refreshUserProcessDefinitions(data,el) {
		var container = $("."+el);
		container.empty();
		console.log("data:",data);
		if(data&&data.length>0){
			for (var i=0;i<data.length;i++) {
				var def = data[i];
				PROCESS_DEFINITIONS[def.id]=def;
				container.append([
					'<div class="process-definition-item" id="'+def.id+'">',
					'	<img src="/service-storage/sys-file/image?id='+def.iconFilePc+'" style="height: 42px;margin-top: 6px;margin-left: 6px">',
					'	<div style="margin: 8px 10px;">',
					'		<span class="process-definition-name">'+def.name+'</span><br>',
					'		<span class="process-definition-desc">'+(def.notes?def.notes:"无")+'</span>',
					'	</div>',
					'</div>'
				].join("\n"));
			}
		}
		$(".process-definition-item").off("click");
		$(".process-definition-item").click(function (it) {
			var id=$(this).attr("id");
			var def=PROCESS_DEFINITIONS[id];
			if(!def) return;
			bpm.openProcessView(null,null,false,{"formDefinitionCode":def.formDefinition.code},window.module.refreshTableData,window.module.refreshRowData,"process");
		});


	}

	function requestProcessInstances(limit,approvalCatalog) {
		admin.post("/service-bpm/portal/query-my-process",{limit:limit,approvalCatalog:approvalCatalog},function (r){
			refreshProcessInstances(r.data,approvalCatalog)
		});
	}

	function refreshProcessInstances(data,approvalCatalog) {
		var usr=settings.getUser();
		console.log("usr:",usr);
		var userId=usr.user.id;
		var container = $(".process-instances-list-"+approvalCatalog);
		container.empty();
		var titleEl=$("#tab-"+approvalCatalog);
		//debugger
		titleEl.text(titleEl.text()+"("+data.totalRowCount+")");
		data=data.list;
		for (var i=0;i<data.length;i++) {
			var inst=data[i];
			PROCESS_INSTANCES[inst.id]=inst;
			var title=inst.title
			var time="";
			var name="";
			if(approvalCatalog=="drafting") {
				time = inst.createTime;
				name = "";
				// debugger
			} else if(approvalCatalog=="drafted") {
				time = inst.commitTime;
				name = inst.drafterName;
				if(inst.todoTasks &&  inst.todoTasks.length>0) {
					name = inst.todoTasks[0].nodeName;
				}
				// debugger
			} else if(approvalCatalog=="approving") {
				time = inst.commitTime;
				name = inst.drafterName;
			} else if(approvalCatalog=="approved") {
				// time = inst.commitTime;
				name = inst.drafterName;
				var approvals=inst.taskApprovals;
				for (var j = approvals.length-1; j >=0 ; j --) {
					if(approvals[j].approvalUserId==userId) {
						time = approvals[j].approvalTime;
						break;
					}
				}
			}
			container.append([
				'<div class="process-instance-item">',
				'	<a class="process-instance-item-title" href="javascript:openView(\''+inst.id+'\')">'+title+'</a><span class="process-instance-item-desc">'+name+'&nbsp;'+time+'</span>',
				'</div>'
			].join("\n"));
		}
	}




	window.openView=function(id) {
		var inst=PROCESS_INSTANCES[id];
		if(!inst) return;
		debugger
		admin.putTempData('bpm-process-instance-form-data', {});
		bpm.openProcessView(inst.id,null,false,{},window.module.refreshTableData,window.module.refreshRowData,"process");
	}



	window.openNotice=function(id) {
		console.log(id);
		var url="/business/oa/notice/notice_view.html?id="+id;
		let win = window.open(url, "_blank");
	}

	window.openDownloadFile=function(id) {
		console.log(id);
		window.open("/service-storage/sys-file/download?id="+id,"_blank")
	}

	window.openMore=function(type) {
		window.open("/business/oa/notice/notice_list_public.html?type="+type,"","left=100,top=100,width=800,height=600")
	}
	window.openDownFileMore=function() {
		window.open("/business/oa/download_file/download_file_list_public.html","","left=100,top=100,width=800,height=600")
	}






	window.openSystem=function(url) {
		console.log(url);
		let win = window.open(url, "_blank");
	}


	$(".process-instances-more").click(function () {
		var id=APPROVAL_CATALOG[CURRENT_PROCESS_INSTANCE_CATALOG].menuId;
		admin.openInTab(id);
	})

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
