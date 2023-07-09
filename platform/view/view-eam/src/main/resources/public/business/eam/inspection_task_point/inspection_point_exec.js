/**
 * 巡检点 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-07 21:55:18
 */

function FormPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;

    // 接口地址
    const moduleURL="/service-eam/eam-inspection-task-point";
    const queryURL=moduleURL+"/get-by-id";
    const insertURL=moduleURL+"/insert";
    const updateURL=moduleURL+"/update";
    var ids=[];

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

        action=admin.getTempData('eam-inspection-task-point-form-data-form-action');
        //如果没有修改和保存权限

        console.log("action:"+action)
        if(action=="view") {
            disableModify=true;
        }

        if(bpmIntegrateMode=="front" && isInProcess==1) {
            $(".model-form-footer").hide();
        }

        if(window.pageExt.form.beforeInit) {
            window.pageExt.form.beforeInit(action,admin.getTempData('eam-inspection-task-point-form-data'));
        }

        //渲染表单组件
        renderFormFields();


        renderFormFields2()

        //填充表单数据
        fillFormData();

        //绑定提交事件
        bindButtonEvent();

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
            var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-inspection-task-point-form-data-win');
            if(area==null) return;
            admin.putTempData('eam-inspection-task-point-form-area', area);
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

        form.on('radio(pointStatus)', function(data){
            var checked=[];
            $('input[type=radio][lay-filter=pointStatus]:checked').each(function() {
                checked.push($(this).val());
            });
            window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("pointStatus",data,checked);
        });
        laydate.render({
            elem: '#operTime',
            type:"date",
            format:"yyyy-MM-dd HH:mm:ss",
            value:$('#operTime').val()?$('#operTime').val():new Date(),
            trigger:"click",
            done: function(value, date, endDate){
                window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("operTime",value, date, endDate);
            }
        });
        //渲染 pointRouteId 下拉字段
        fox.renderSelectBox({
            el: "pointRouteId",
            radio: true,
            tips: fox.translate("请选择",'','cmp:form')+fox.translate("巡检路线",'','cmp:form'),
            filterable: true,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("pointRouteId",data.arr,data.change,data.isAdd);
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
                    defaultIndexs = "0".split(",");
                }
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    if(window.pageExt.form.selectBoxDataTransform) {
                        opts.push(window.pageExt.form.selectBoxDataTransform("pointRouteId",{data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
                    } else {
                        opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
                    }
                }
                return opts;
            }
        });
        //渲染 pointPosId 下拉字段
        fox.renderSelectBox({
            el: "pointPosId",
            radio: true,
            tips: fox.translate("请选择",'','cmp:form')+fox.translate("位置",'','cmp:form'),
            filterable: true,
            paging: true,
            pageRemote: true,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("pointPosId",data.arr,data.change,data.isAdd);
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
                        opts.push(window.pageExt.form.selectBoxDataTransform("pointPosId",{data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)},data[i],data,i));
                    } else {
                        opts.push({data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
                    }
                }
                return opts;
            }
        });
    }


    function renderFormFields2() {
        var formData2 = admin.getTempData('eam-inspection-task-point-form-data');
        console.log("formData2",formData2);
        var checkSelectList=formData2.checkSelectList;
        var html="";
        if(checkSelectList&&checkSelectList.length>0){
            for(var i=0;i<checkSelectList.length;i++){
                var checkSelect=checkSelectList[i];
                ids.push("id_"+checkSelect.id);
                var desc="";
                var cur="";
                if(checkSelect.resultMetaData){
                    if(checkSelect.resultMetaData=="null"){
                        cur=""
                    }
                    cur=checkSelect.resultMetaData;
                }
                if(checkSelect.itemDesc){
                    if(checkSelect.itemDesc=="null"){
                        desc=""
                    }
                    desc=checkSelect.itemDesc;
                }
                if(checkSelect.type=="input"){
                    html=html+"     <div class=\"layui-col-xs12 form-column\" >\n" +
                        "<div style='margin-left:30px;margin-bottom:8px;font-size: 14px;color: red'>"+desc+"</div>"+
                        "                <div class=\"layui-form-item\" inlines=\"\"  inline-delta=\"0\" input-width=\"\">\n" +
                        "                    <div class=\"layui-form-label \"><div>"+checkSelect.itemName+"</div></div>\n" +
                        "                    <div class=\"layui-input-block \">\n" +
                        "                        <input  value=\""+cur+"\"  lay-filter=\"notes\" id=\"id_"+checkSelect.id+"\" name=\"id_"+checkSelect.id+"\" placeholder=\"请输入内容\" type=\"text\" class=\"layui-input\"  />\n"+
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div> <hr>"
                }else if(checkSelect.type=="radiobox"){
                    var conf=checkSelect.config;
                    var confArr=eval("(" + conf + ")");
                    console.log("confArr",confArr);
                    html=html+"<div class=\"layui-col-xs12 form-column\">\n" +
                        "<div style='margin-left:30px;margin-bottom:8px;font-size: 14px;color: red'>"+desc+"</div>"+
                        "<div class=\"layui-form-item\" inlines=\"\" inline-delta=\"0\" input-width=\"\">\n" +
                        "              <div class=\"layui-form-label \"><div>"+checkSelect.itemName+"</div></div>\n" +
                        "                    <div class=\"layui-input-block \">\n";
                    for(var j=0;j<confArr.length;j++){
                        var item=confArr[j];
                        var checked=""
                        if (cur==item.code){
                            checked="checked=\"checked\" ";
                        }
                        html=html+"<input  "+checked+" readonly=\"\" input-type=\"radio\" type=\"radio\" name=\"id_"+checkSelect.id+"\" lay-filter=\" "+checkSelect.id+" \" value=\""+item.code+"\" title=\""+item.label+"\">" +
                            "<div value=\""+item.code+"\" class=\"layui-unselect layui-form-radio\"><i class=\"layui-anim layui-icon\"></i><div>"+item.label+"</div></div>"
                    }
                    html=html+"         </div>\n" +
                        "</div>" +
                        "<hr>"

                }else if (checkSelect.type=="number_range"){
                    console.log("checkSelect",checkSelect);
                    console.log("checkSelect2",checkSelect.config);
                    var conf=checkSelect.config;
                    var confObj=eval("(" + conf + ")");
                    var max=confObj.max;
                    var min=confObj.min;
                    html=html+"<div class=\"layui-col-xs12 form-column\">\n" +
                        "<div style='margin-left:30px;margin-bottom:10px;font-size: 14px;color: red'>"+desc+"</div>"+
                        "   <div class=\"layui-form-item\" inlines=\"\"  inline-delta=\"0\" input-width=\"\">\n" +
                        "                    <div class=\"layui-form-label \"><div>"+checkSelect.itemName+"</div></div>\n" +
                        "                    <div class=\"layui-input-block\">\n" +
                        "                        <input lay-filter=\"value\" id=\"id_"+checkSelect.id+"\" name=\"id_"+checkSelect.id+"\" placeholder=\"请输入\" type=\"text\" class=\"layui-input\"   autocomplete=\"off\" input-type=\"number_input\" integer=\"false\" decimal=\"true\" allow-negative=\"true\" step=\"1.0\"   min-value=\""+min+"\"  max-value=\""+max+"\"  scale=\"2\"  value=\""+cur+"\" />\n" +
                        "                    </div>\n" +
                        "                </div>\n"+
                        "</div><hr>"
                }
            }
            $("#defcontent").html(html);
        }





        //设置


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
            formData = admin.getTempData('eam-inspection-task-point-form-data');
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



            //设置  巡检路线 设置下拉框勾选
            fox.setSelectValue4QueryApi("#pointRouteId",formData.route);

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
            rawFormData = admin.getTempData('eam-inspection-task-point-form-data');
        }
        return rawFormData;
    }

    function getFormData() {
        var data=form.val("data-form");



        //获取 巡检路线 下拉框的值
        data["pointRouteId"]=fox.getSelectedValue("pointRouteId",false);

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
        console.log("param:",param);
        var postIdsObj={};
        if(ids.length>0){
            for(var i=0;i<ids.length;i++){
                var key=ids[i];
                var rkey=key.replace(/id_/g,"");
                var obj={"id":rkey,value:""};
                if(param[key]&&param[key]!=undefined){
                    obj.value=param[key];
                }
                postIdsObj[rkey]=obj;
            }
        }
        param.itemData=JSON.stringify(postIdsObj);

        admin.post(moduleURL+"/finish", param, function (data) {
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
                    admin.finishPopupCenterById('eam-inspection-task-point-form-data-win');
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
        $("#operId-button").click(function(){
            var operIdDialogOptions={
                field:"operId",
                formData:getFormData(),
                inputEl:$("#operId"),
                buttonEl:$(this),
                single:true,
                autoWidth:false,
                //限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
                root: "",
                targetType:"emp",
                prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
                callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
            };
            fox.chooseEmployee(operIdDialogOptions);
        });

        //关闭窗口
        $("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-inspection-task-point-form-data-win',this); });

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