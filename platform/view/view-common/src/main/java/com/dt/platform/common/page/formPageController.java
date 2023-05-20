package com.dt.platform.common.page;

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


}
