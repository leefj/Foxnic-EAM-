package com.dt.platform.common.page;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.common.FormData;
import com.dt.platform.proxy.common.FormDataServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("ScreenPageController")
@RequestMapping(ScreenPageController.prefix)
public class ScreenPageController extends ViewController {


	public static final String prefix="business/common/screen";



	@RequestMapping("/goview/dist/index.html")
	public String screenDesigner(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/goview/dist/index";
	}


}
