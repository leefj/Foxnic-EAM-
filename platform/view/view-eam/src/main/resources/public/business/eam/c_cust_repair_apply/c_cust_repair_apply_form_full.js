/**
 * 报修申请 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 14:55:16
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;

	var BILL_DATA;
	// 接口地址
	const moduleURL="/service-eam/eam-c-cust-repair-apply";
	const queryURL=moduleURL+"/get-by-id";
	const insertURL=moduleURL+"/insert";
	const updateURL=moduleURL+"/update";

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

		action=admin.getTempData('eam-c-cust-repair-apply-form-data-form-action');
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
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-c-cust-repair-apply-form-data'));
		}

		//渲染表单组件
		renderFormFields();

		//填充表单数据
		fillFormData();

		//绑定提交事件
		bindButtonEvent();




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
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-c-cust-repair-apply-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-c-cust-repair-apply-form-area', area);
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

		form.on('radio(status)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=status]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("status",data,checked);
		});
		laydate.render({
			elem: '#planFinishDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("planFinishDate",value, date, endDate);
			}
		});
	    //渲染图片字段
		foxup.render({
			el:"pictureId",
			maxFileCount: 1,
			displayFileName: false,
			accept: "image",
			acceptMime:'image/*',
			exts:'png|jpg|bmp|gif|jpeg',
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
		laydate.render({
			elem: '#startDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("startDate",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#finishDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("finishDate",value, date, endDate);
			}
		});


		//渲染 assetIds 下拉字段
		fox.renderSelectBox({
			el: "assetIds",
			radio: false,
			filterable: false,
			paging: true,
			pageRemote: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("assetIds",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					if(window.pageExt.form.selectBoxDataTransform) {
						opts.push(window.pageExt.form.selectBoxDataTransform("assetIds",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						//opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});

	}

	/**
	 * 根据id填充表单
	 * */
	function fillFormDataByIds(ids) {
		if(!ids) return;
		if(ids.length==0) return;
		var id=ids[0];
		if(!id) return;
		admin.post(queryURL, { id : id }, function (r) {
			if (r.success) {
				fillFormData(r.data)
			} else {
				fox.showMessage(r);
			}
		});
	}

	/**
	 * 在流程提交前处理表单数据
	 * */
	function processFormData4Bpm (processInstanceId,param,cb) {
		window.pageExt.form.processFormData4Bpm && window.pageExt.form.processFormData4Bpm(processInstanceId,param,cb);
	}

	function messageFill(messageList){
		console.log("messageList:",messageList);
		if(messageList&&messageList.length>0){
			//显示处理记录
			$("#messageList").show();
			var html="";
			for(var i=0;i<messageList.length;i++){
				var rUser="";
				if(messageList[i].processUser&&messageList[i].processUser.name){
					rUser=messageList[i].processUser.name;
				}
				var e=" <li class=\"layui-timeline-item\">\n" +
					"                    <div class=\"layui-timeline-content layui-text\">\n" +
					"                        <div class=\"layui-timeline-title\">\n" +
					"                            <span style=\"color: #666;font-style: italic\"> 处理人:"+rUser+"  记录时间:"+messageList[i].recordTime+" </span>\n" +
					"                        </div>\n" +
					"                        <span style=\"color: #333;\"> "+messageList[i].ct+"  </span>\n" +
					"                    </div>\n" +
					"                </li>";
				html=html+e;
			}
			$("#messageData").html(html);
		}else{
			$("#messageList").hide();
		}
	}
	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('eam-c-cust-repair-apply-form-data');
		}
		BILL_DATA=formData;
		console.log("BILL_DATA",BILL_DATA);
		//////////////添加回复部分
		var bill_status=BILL_DATA.status;
		if(bill_status=="processing"){
			//显示完成和回复按钮
			$("#answer-button").css('display','');
			$("#finish-button").css('display','');
		}else{
		}
		var messageList=BILL_DATA.repiarItemData;
		messageFill(messageList);
		//////////////添加回复部分结束
		var hasData=true;
		//如果是新建
		if(!formData || !formData.id) {
			adjustPopup();
			hasData=false;
		}
		var fm=$('#data-form');
		if (hasData) {
			fm[0].reset();
			form.val('data-form', formData);




			//设置 预期日期 显示复选框勾选
			if(formData["planFinishDate"]) {
				$("#planFinishDate").val(fox.dateFormat(formData["planFinishDate"],"yyyy-MM-dd HH:mm:ss"));
			}

			//设置  资产 设置下拉框勾选
			fox.setSelectValue4QueryApi("#assetIds",formData.assetList);


			//处理fillBy

			//
	     	fm.attr('method', 'POST');
	     	fox.fillDialogButtons();
	     	renderFormFields();

			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

		}

		//渐显效果
		fm.css("opacity","0.0");
        fm.css("display","");
        setTimeout(function (){
            fm.animate({
                opacity:'1.0'
            },100,null,function (){
				fm.css("opacity","1.0");});
        },1);

        //禁用编辑
		if((hasData && disableModify) || (!hasData &&disableCreateNew)) {
			fox.lockForm($("#data-form"),true);
			$("#submit-button").hide();
			$("#cancel-button").css("margin-right","15px")
		} else {
			$("#submit-button").show();
			$("#cancel-button").css("margin-right","0px")
		}

		//调用 iframe 加载过程
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(window.pageExt.form){
				jsFn=window.pageExt.form[jsFn];
				jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,formData);
			}
		}

		dataBeforeEdit=getFormData();

	}

	function getFormData() {
		var data=form.val("data-form");




		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param,callback) {

		if(window.pageExt.form.beforeSubmit) {
			var doNext=window.pageExt.form.beforeSubmit(param);
			if(!doNext) return ;
		}

		param.dirtyFields=fox.compareDirtyFields(dataBeforeEdit,param);
		var action=param.id?"edit":"create";
		var api=param.id?updateURL:insertURL;
		admin.post(api, param, function (data) {
			if (data.success) {
				var doNext=true;
				var pkValues=data.data;
				if(pkValues) {
					for (var key in pkValues) {
						$("#"+key).val(pkValues[key]);
					}
				}
				if(window.pageExt.form.betweenFormSubmitAndClose) {
					doNext=window.pageExt.form.betweenFormSubmitAndClose(param,data);
				}

				if(callback) {
					doNext = callback(data,action);
				}

				if(doNext) {
					admin.finishPopupCenterById('eam-c-cust-repair-apply-form-data-win');
				}

				// 调整状态为编辑
				action="edit";

			} else {
				fox.showMessage(data);
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, {delayLoading:1000,elms:[$("#submit-button")]});
	}

	function verifyAndSaveForm(data) {
		if(!data) data={};
		//debugger;
		data.field = getFormData();
		//校验表单
		if(!verifyForm(data.field)) return;
		saveForm(data.field);
		return false;
	}

	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {

	    form.on('submit(submit-button)', verifyAndSaveForm);
	    //关闭窗口
	    $("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-c-cust-repair-apply-form-data-win',this); });
		$("#finish-button").click(function(){
			top.layer.confirm(fox.translate('是否确认完成本次任务'), function (i) {
				top.layer.close(i);

				console.log("result:",$("#result").val());
				var bill_result=$("#result").val();
				admin.post("/service-eam/eam-c-cust-repair-apply/finish", {id:BILL_DATA.id,ct:bill_result}, function (data) {
					if (data.success) {
						admin.finishPopupCenterById('eam-c-cust-repair-apply-form-data-win');
					} else {
					}
					fox.showMessage(data);
				}, {delayLoading:1000,elms:[$("#submit-button")]});


			});
		});

		$("#answer-button").click(function(){
			var action="create";
			admin.putTempData('eam-c-cust-repiar-item-form-data-form-action', "create",true);
			admin.putTempData('eam-c-cust-repiar-item-form-data', {});
			var area=admin.getTempData('eam-c-cust-repiar-item-form-area');
			var height= (area && area.height) ? area.height : ($(window).height()*0.6);
			var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
			var title = fox.translate('回复内容');
			if(action=="create") title=fox.translate('添加','','cmp:table')+title;
			else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
			else if(action=="view") title=fox.translate('查看','','cmp:table')+title;
			admin.popupCenter({
				title: title,
				resize: false,
				offset: [top,null],
				area: ["500px",height+"px"],
				type: 2,
				id:"eam-c-cust-repiar-item-form-data-win",
				content: '/business/eam/c_cust_repiar_item/c_cust_repiar_item_form.html?repairId='+BILL_DATA.id,
				finish: function () {
					admin.post('/service-eam/eam-c-cust-repair-apply/get-by-id', { id : BILL_DATA.id }, function (data) {
						if(data.success) {
							var d=data.data;
							var messageList=d.repiarItemData;
							messageFill(messageList);
						} else {
							fox.showMessage(data);
						}
					});
				}
			});
		});

	}

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		verifyAndSaveForm:verifyAndSaveForm,
		fillFormData: fillFormData,
		fillFormDataByIds:fillFormDataByIds,
		processFormData4Bpm:processFormData4Bpm,
		adjustPopup: adjustPopup,
		action: action,
		setAction: function (act) {
			action = act;
		}
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