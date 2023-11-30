/**
 * 库存领用 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-30 22:09:02
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown,bpm;
	
	// 接口地址
	const moduleURL="/service-eam/eam-asset-stock-goods-use";
	const queryURL=moduleURL+"/get-by-id";
	const insertURL=moduleURL+"/insert";
	const updateURL=moduleURL+"/update";

	var rawFormData=null;
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;
	const bpmIntegrateMode="front";
	var isInProcess=QueryString.get("isInProcess");
	var processId=QueryString.get("processId");
	var processInstance=null;

	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,bpm=layui.bpm;

		action=admin.getTempData('eam-asset-stock-goods-use-form-data-form-action');
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
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-asset-stock-goods-use-form-data'));
		}

		//渲染表单组件
		renderFormFields();

		//填充表单数据
		fillFormData();

		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();
		//取流程数据
		fetchProcessInstance();


	}




	//取流程数据
	function fetchProcessInstance() {
		if(!processId) return;
		bpm.getProcessInstance(processId,function (r){
			if(r.success) {
				processInstance=r.data;
				window.pageExt.form.onProcessInstanceReady && window.pageExt.form.onProcessInstanceReady(r);
			} else {
				if(window.pageExt.form.onProcessInstanceError) {
					var next=window.pageExt.form.onProcessInstanceError(r);
					if(!next) return;
				}
				fox.showMessage(r);
			}
		})
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
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-asset-stock-goods-use-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-asset-stock-goods-use-form-area', area);
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

		//渲染 status 下拉字段
		fox.renderSelectBox({
			el: "status",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("办理状态",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("status",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(window.pageExt.form.selectBoxDataTransform) {
						opts.push(window.pageExt.form.selectBoxDataTransform("status",{data:data[i],name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#businessDate',
			type:"date",
			format:"yyyy-MM-dd",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("businessDate",value, date, endDate);
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

	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('eam-asset-stock-goods-use-form-data');
		}
		rawFormData=formData;

		window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);

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




			//设置 业务日期 显示复选框勾选
			if(formData["businessDate"]) {
				$("#businessDate").val(fox.dateFormat(formData["businessDate"],"yyyy-MM-dd"));
			}



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
		if(action=="view" || (action=="edit" && disableModify) || (action=="create" && disableCreateNew)) {
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

	/**
	 * 获得从服务器请求的原始表单数据
	 * */
	function getRawFormData() {
		if(!rawFormData) {
			rawFormData = admin.getTempData('eam-asset-stock-goods-use-form-data');
		}
		return rawFormData;
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
					admin.finishPopupCenterById('eam-asset-stock-goods-use-form-data-win');
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

		// 请选择人员对话框
		$("#originatorId-button").click(function(){
				var originatorIdDialogOptions={
				field:"originatorId",
				formData:getFormData(),
				inputEl:$("#originatorId"),
				buttonEl:$(this),
				single:true,
				autoWidth:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseEmployee(originatorIdDialogOptions);
		});

	    //关闭窗口
	    $("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-asset-stock-goods-use-form-data-win',this); });

    }

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		getRawFormData:getRawFormData,
		verifyAndSaveForm:verifyAndSaveForm,
		renderFormFields:renderFormFields,
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

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate','dropdown','bpm'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});