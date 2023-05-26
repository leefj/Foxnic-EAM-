package com.dt.platform.common.page;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.common.FormData;
import com.dt.platform.proxy.common.FormDataServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("formPageController")
@RequestMapping(formPageController.prefix)
public class formPageController extends ViewController {


	public static final String prefix="business/common/form";

	@RequestMapping("/form_designer.html")
	public String vformDesigner(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/form_designer";
	}


	@RequestMapping("/vform/dist/build/index.html")
	public String vform(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/vform/dist/build/index";
	}

	@RequestMapping("/form_render.html")
	public String formRender(Model model,HttpServletRequest request,String id,String action,String pageType,String approvalStatus) {
		model.addAttribute("id",id);
		model.addAttribute("action",action);
		Result<FormData> result= FormDataServiceProxy.api().getById(id);
		JSONObject formJson=new JSONObject();
		JSONObject formData=new JSONObject();
		if(result.success()){
			String formJsonStr=result.getData().getDesignerData();
			formJson=JSONObject.parseObject(formJsonStr);
			System.out.println(formJsonStr);

			String formDataStr=result.getData().getData();
			if(!StringUtil.isBlank(result.getData().getData())){
				formData=JSONObject.parseObject(formDataStr);
			}
		}
		model.addAttribute("formJson",formJson);
		model.addAttribute("formData",formData);
		model.addAttribute("pageType",pageType);
		model.addAttribute("approvalStatus",approvalStatus);
		return prefix+"/form_render";
	}


}
