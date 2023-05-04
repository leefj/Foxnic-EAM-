/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-04 15:07:39
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;
	
	// 接口地址
	const moduleURL="/service-eam/eam-asset";
	const queryURL=moduleURL+"/get-by-id";
	const insertURL=moduleURL+"/insert";
	const updateURL=moduleURL+"/update";

	var rawFormData=null;
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

		action=admin.getTempData('eam-asset-form-data-form-action');
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
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-asset-form-data'));
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
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-asset-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-asset-form-area', area);
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

		//渲染 categoryId 下拉字段
		fox.renderSelectBox({
			el: "categoryId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("资产分类",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("categoryId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("categoryId",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
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
		//渲染 assetStatus 下拉字段
		fox.renderSelectBox({
			el: "assetStatus",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("资产状态",'','cmp:form'),
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("assetStatus",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.form.selectBoxDataTransform("assetStatus",{data:data[i],name:data[i].name,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 goodsId 下拉字段
		fox.renderSelectBox({
			el: "goodsId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("物品档案",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("goodsId",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.form.selectBoxDataTransform("goodsId",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 manufacturerId 下拉字段
		fox.renderSelectBox({
			el: "manufacturerId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("厂商",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("manufacturerId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "manufacturerName", //请自行调整用于搜索的字段名称
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
						opts.push(window.pageExt.form.selectBoxDataTransform("manufacturerId",{data:data[i],name:data[i].manufacturerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].manufacturerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
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
		//渲染 safetyLevelCode 下拉字段
		fox.renderSelectBox({
			el: "safetyLevelCode",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("安全等级",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("safetyLevelCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("safetyLevelCode",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 positionId 下拉字段
		fox.renderSelectBox({
			el: "positionId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("位置",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("positionId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "hierarchyName", //请自行调整用于搜索的字段名称
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
						opts.push(window.pageExt.form.selectBoxDataTransform("positionId",{data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 warehouseId 下拉字段
		fox.renderSelectBox({
			el: "warehouseId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("仓库",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("warehouseId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "warehouseName", //请自行调整用于搜索的字段名称
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
						opts.push(window.pageExt.form.selectBoxDataTransform("warehouseId",{data:data[i],name:data[i].warehouseName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].warehouseName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 goodsStockId 下拉字段
		fox.renderSelectBox({
			el: "goodsStockId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("库存物品",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("goodsStockId",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.form.selectBoxDataTransform("goodsStockId",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 sourceId 下拉字段
		fox.renderSelectBox({
			el: "sourceId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("来源",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("sourceId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "purchase".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					if(window.pageExt.form.selectBoxDataTransform) {
						opts.push(window.pageExt.form.selectBoxDataTransform("sourceId",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#purchaseDate',
			format:"yyyy-MM-dd",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("purchaseDate",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#productionDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("productionDate",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#registerDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("registerDate",value, date, endDate);
			}
		});
	    //渲染图片字段
		foxup.render({
			el:"attach",
			maxFileCount: 1,
			displayFileName: false,
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
		laydate.render({
			elem: '#lastVerificationDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("lastVerificationDate",value, date, endDate);
			}
		});
		//渲染 maintainerId 下拉字段
		fox.renderSelectBox({
			el: "maintainerId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("维保商",'','cmp:form'),
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("maintainerId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "maintainerName", //请自行调整用于搜索的字段名称
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
						opts.push(window.pageExt.form.selectBoxDataTransform("maintainerId",{data:data[i],name:data[i].maintainerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].maintainerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 maintenanceStatus 下拉字段
		fox.renderSelectBox({
			el: "maintenanceStatus",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("维保状态",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("maintenanceStatus",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("maintenanceStatus",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 maintenanceMethod 下拉字段
		fox.renderSelectBox({
			el: "maintenanceMethod",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("维保方式",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("maintenanceMethod",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("maintenanceMethod",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 suggestMaintenanceMethod 下拉字段
		fox.renderSelectBox({
			el: "suggestMaintenanceMethod",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("建议维保方式",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("suggestMaintenanceMethod",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("suggestMaintenanceMethod",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#maintenanceStartDate',
			format:"yyyy-MM-dd",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("maintenanceStartDate",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#maintenanceEndDate',
			format:"yyyy-MM-dd",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("maintenanceEndDate",value, date, endDate);
			}
		});
		//渲染 financialCategoryId 下拉字段
		fox.renderSelectBox({
			el: "financialCategoryId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("财务分类",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("financialCategoryId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "hierarchyName", //请自行调整用于搜索的字段名称
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
						opts.push(window.pageExt.form.selectBoxDataTransform("financialCategoryId",{data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 financialOption 下拉字段
		fox.renderSelectBox({
			el: "financialOption",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("财务选项",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("financialOption",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("financialOption",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 expenseItem 下拉字段
		fox.renderSelectBox({
			el: "expenseItem",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("费用项目",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("expenseItem",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("expenseItem",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 supplierId 下拉字段
		fox.renderSelectBox({
			el: "supplierId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("供应商",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("supplierId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "supplierName", //请自行调整用于搜索的字段名称
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
						opts.push(window.pageExt.form.selectBoxDataTransform("supplierId",{data:data[i],name:data[i].supplierName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].supplierName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#depreciationOperTime',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("depreciationOperTime",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#entryTime',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("entryTime",value, date, endDate);
			}
		});
		//渲染 equipmentStatus 下拉字段
		fox.renderSelectBox({
			el: "equipmentStatus",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("设备状态",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("equipmentStatus",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.form.selectBoxDataTransform("equipmentStatus",{data:data[i],name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 equipmentEnvironmentCode 下拉字段
		fox.renderSelectBox({
			el: "equipmentEnvironmentCode",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("运行环境",'','cmp:form'),
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("equipmentEnvironmentCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
						opts.push(window.pageExt.form.selectBoxDataTransform("equipmentEnvironmentCode",{data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
					}
				}
				return opts;
			}
		});
		//渲染 rackId 下拉字段
		fox.renderSelectBox({
			el: "rackId",
			radio: true,
			tips: fox.translate("请选择",'','cmp:form')+fox.translate("机柜",'','cmp:form'),
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("rackId",data.arr,data.change,data.isAdd);
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
						opts.push(window.pageExt.form.selectBoxDataTransform("rackId",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
					} else {
						opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
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

	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('eam-asset-form-data');
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




			//设置 采购日期 显示复选框勾选
			if(formData["purchaseDate"]) {
				$("#purchaseDate").val(fox.dateFormat(formData["purchaseDate"],"yyyy-MM-dd"));
			}


			//设置  资产分类 设置下拉框勾选
			fox.setSelectValue4QueryApi("#categoryId",formData.category);
			//设置  物品档案 设置下拉框勾选
			fox.setSelectValue4QueryApi("#goodsId",formData.goods);
			//设置  厂商 设置下拉框勾选
			fox.setSelectValue4QueryApi("#manufacturerId",formData.manufacturer);
			//设置  位置 设置下拉框勾选
			fox.setSelectValue4QueryApi("#positionId",formData.position);
			//设置  仓库 设置下拉框勾选
			fox.setSelectValue4QueryApi("#warehouseId",formData.warehouse);
			//设置  来源 设置下拉框勾选
			fox.setSelectValue4QueryApi("#sourceId",formData.source);

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

	/**
	 * 获得从服务器请求的原始表单数据
	 * */
	function getRawFormData() {
		if(!rawFormData) {
			rawFormData = admin.getTempData('eam-asset-form-data');
		}
		return rawFormData;
	}

	function getFormData() {
		var data=form.val("data-form");



		//获取 资产分类 下拉框的值
		data["categoryId"]=fox.getSelectedValue("categoryId",false);
		//获取 物品档案 下拉框的值
		data["goodsId"]=fox.getSelectedValue("goodsId",false);
		//获取 厂商 下拉框的值
		data["manufacturerId"]=fox.getSelectedValue("manufacturerId",false);
		//获取 位置 下拉框的值
		data["positionId"]=fox.getSelectedValue("positionId",false);
		//获取 仓库 下拉框的值
		data["warehouseId"]=fox.getSelectedValue("warehouseId",false);
		//获取 来源 下拉框的值
		data["sourceId"]=fox.getSelectedValue("sourceId",false);

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
					admin.finishPopupCenterById('eam-asset-form-data-win');
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

		// 请选择公司对话框
		$("#ownCompanyId-button").click(function(){
			var ownCompanyIdDialogOptions={
				field:"ownCompanyId",
				formData:getFormData(),
				inputEl:$("#ownCompanyId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseOrgNode(ownCompanyIdDialogOptions);
		});
		// 请选择人员对话框
		$("#managerId-button").click(function(){
				var managerIdDialogOptions={
				field:"managerId",
				formData:getFormData(),
				inputEl:$("#managerId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseEmployee(managerIdDialogOptions);
		});
		// 请选择组织节点对话框
		$("#useOrganizationId-button").click(function(){
			var useOrganizationIdDialogOptions={
				field:"useOrganizationId",
				formData:getFormData(),
				inputEl:$("#useOrganizationId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseOrgNode(useOrganizationIdDialogOptions);
		});
		// 请选择人员对话框
		$("#useUserId-button").click(function(){
				var useUserIdDialogOptions={
				field:"useUserId",
				formData:getFormData(),
				inputEl:$("#useUserId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseEmployee(useUserIdDialogOptions);
		});

	    //关闭窗口
	    $("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-asset-form-data-win',this); });

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

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});