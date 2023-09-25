/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 18:13:53
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;
	const moduleURL="/service-eam/eam-asset-item";
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;
	const bpmIntegrateMode="none";
	var isInProcess=QueryString.get("isInProcess");

	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		action=admin.getTempData('eam-asset-item-form-data-form-action');
		//如果没有修改和保存权限
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(action=="view") {
			disableModify=true;
		}

		if(bpmIntegrateMode=="front" && isInProcess==1) {
			$(".model-form-footer").hide();
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-asset-item-form-data'));
		}

		//渲染表单组件
		renderFormFields();


		//调整窗口的高度与位置
		adjustPopup();

		$('#attach-button').on('click', function() {
			// 1. 将 jQuery 对象转化为 DOM 对象，并获取选中的文件列表
			//var data=form.val("data-form");
			var ids=$("#fileId").attr("fileids");
			var ps={fileIds:ids,fdId:FD_ID}
			if(ids&&ids.length>0){
				admin.post("/service-oa/oa-netdisk-file/upload-files-info", ps, function (data) {
					if (data.success) {
						fox.showMessage(data);
						admin.finishPopupCenterById('oa-netdisk-upload-file-form-data-win');
					} else {
						fox.showMessage(data);
					}
				}, {delayLoading:1000,elms:[$("#attach-button")]});
			}else{
				alert("请选择需要上传的文件");

			}
		})
	}
	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup() {
		if(window.pageExt.form.beforeAdjustPopup) {
			var doNext=window.pageExt.form.beforeAdjustPopup();
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
					setTimeout(adjustPopup,1000);
				}
				prevBodyHeight = bodyHeight;
				return;
			}
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-asset-item-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-asset-item-form-area', area);
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

	/**
	 * 渲染表单组件
	 */
	function renderFormFields() {
		fox.renderFormInputs(form);

		//渲染图片字段
		foxup.render({
			el:"fileId",
			url:"/service-oa/oa-netdisk-virtual-fd/upload-file",
			maxFileCount: 16,
			displayFileName: true,
			accept: "file",
			afterPreview:function(elId,index,fileId,upload,fileName,fileType){
				adjustPopup();
				window.pageExt.form.onUploadEvent &&  window.pageExt.form.onUploadEvent({event:"afterPreview",elId:elId,index:index,fileId:fileId,upload:upload,fileName:fileName,fileType:fileType});
			},
			afterUpload:function (elId,result,index,upload) {
				console.log("文件上传后回调");
				window.pageExt.form.onUploadEvent &&  window.pageExt.form.onUploadEvent({event:"afterUpload",elId:elId,index:index,upload:upload});
			},
			beforeRemove:function (elId,fileId,index,upload) {
				console.log("文件删除前回调");
				if(window.pageExt.form.onUploadEvent) {
					return window.pageExt.form.onUploadEvent({event:"beforeRemove",elId:elId,index:index,fileId:fileId,upload:upload});
				}
				return true;
			},
			afterRemove:function (elId,fileId,index,upload) {
				adjustPopup();
				window.pageExt.form.onUploadEvent &&  window.pageExt.form.onUploadEvent({event:"afterRemove",elId:elId,index:index,upload:upload});
			}
		});
	}

	// /**
	//  * 根据id填充表单
	//  * */
	// function fillFormDataByIds(ids) {
	// 	if(!ids) return;
	// 	if(ids.length==0) return;
	// 	var id=ids[0];
	// 	if(!id) return;
	// 	admin.post(moduleURL+"/get-by-id", { id : id }, function (r) {
	// 		if (r.success) {
	// 			fillFormData(r.data)
	// 		} else {
	// 			fox.showMessage(r);
	// 		}
	// 	});
	// }

	/**
	 * 在流程提交前处理表单数据
	 * */
	function processFormData4Bpm (processInstanceId,param,cb) {
		window.pageExt.form.processFormData4Bpm && window.pageExt.form.processFormData4Bpm(processInstanceId,param,cb);
	}

	/**
	 * 填充表单数据
	 */
	// function fillFormData(formData) {
	// 	if(!formData) {
	// 		formData = admin.getTempData('eam-asset-item-form-data');
	// 	}
	//
	// 	window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);
	//
	// 	var hasData=true;
	// 	//如果是新建
	// 	if(!formData || !formData.id) {
	// 		adjustPopup();
	// 		hasData=false;
	// 	}
	// 	var fm=$('#data-form');
	// 	if (hasData) {
	// 		fm[0].reset();
	// 		form.val('data-form', formData);
	//
	//
	//
	// 		//处理fillBy
	//
	// 		//
	// 		fm.attr('method', 'POST');
	// 		fox.fillDialogButtons();
	// 		renderFormFields();
	//
	// 		window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);
	//
	// 	}
	//
	// 	//渐显效果
	// 	fm.css("opacity","0.0");
	// 	fm.css("display","");
	// 	setTimeout(function (){
	// 		fm.animate({
	// 			opacity:'1.0'
	// 		},100,null,function (){
	// 			fm.css("opacity","1.0");});
	// 	},1);
	//
	// 	//禁用编辑
	// 	if((hasData && disableModify) || (!hasData &&disableCreateNew)) {
	// 		fox.lockForm($("#data-form"),true);
	// 		$("#submit-button").hide();
	// 		$("#cancel-button").css("margin-right","15px")
	// 	} else {
	// 		$("#submit-button").show();
	// 		$("#cancel-button").css("margin-right","0px")
	// 	}
	//
	// 	//调用 iframe 加载过程
	// 	var formIfrs=$(".form-iframe");
	// 	for (var i = 0; i < formIfrs.length; i++) {
	// 		var jsFn=$(formIfrs[i]).attr("js-fn");
	// 		if(window.pageExt.form){
	// 			jsFn=window.pageExt.form[jsFn];
	// 			jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,formData);
	// 		}
	// 	}
	//
	// 	dataBeforeEdit=getFormData();
	//
	// }

	// function getFormData() {
	// 	var data=form.val("data-form");
	//
	// 	return data;
	// }

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	// function saveForm(param,callback) {
	//
	// 	if(window.pageExt.form.beforeSubmit) {
	// 		var doNext=window.pageExt.form.beforeSubmit(param);
	// 		if(!doNext) return ;
	// 	}
	//
	// 	param.dirtyFields=fox.compareDirtyFields(dataBeforeEdit,param);
	// 	var action=param.id?"edit":"create";
	// 	var api=moduleURL+"/"+(param.id?"update":"insert");
	// 	admin.post(api, param, function (data) {
	// 		if (data.success) {
	// 			var doNext=true;
	// 			var pkValues=data.data;
	// 			if(pkValues) {
	// 				for (var key in pkValues) {
	// 					$("#"+key).val(pkValues[key]);
	// 				}
	// 			}
	// 			if(window.pageExt.form.betweenFormSubmitAndClose) {
	// 				doNext=window.pageExt.form.betweenFormSubmitAndClose(param,data);
	// 			}
	//
	// 			if(callback) {
	// 				doNext = callback(data,action);
	// 			}
	//
	// 			if(doNext) {
	// 				admin.finishPopupCenterById('eam-asset-item-form-data-win');
	// 			}
	//
	// 			// 调整状态为编辑
	// 			action="edit";
	//
	// 		} else {
	// 			fox.showMessage(data);
	// 		}
	// 		window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
	// 	}, {delayLoading:1000,elms:[$("#submit-button")]});
	// }

	// function verifyAndSaveForm(data) {
	// 	if(!data) data={};
	// 	//debugger;
	// 	data.field = getFormData();
	// 	//校验表单
	// 	if(!verifyForm(data.field)) return;
	// 	saveForm(data.field);
	// 	return false;
	// }

	/**
	 * 保存数据，表单提交事件
	 */
	// function bindButtonEvent() {
	//
	// 	form.on('submit(submit-button)', verifyAndSaveForm);
	//
	//
	// 	//关闭窗口
	// 	$("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-asset-item-form-data-win',this); });
	//
	// }

	window.module={
		adjustPopup: adjustPopup
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});