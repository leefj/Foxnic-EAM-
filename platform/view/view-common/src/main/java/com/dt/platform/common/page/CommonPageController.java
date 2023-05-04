package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("CommonPublicPageController")
@RequestMapping(CommonPageController.prefix)
public class CommonPageController extends ViewController {

	public static final String prefix="";

	/**
	 * 主页面
	 */
	@RequestMapping("/back_to_portal.html")
	public String backToPortal(Model model,HttpServletRequest request) {

		String IN_URL= ConfigServiceProxy.api().getByCode("app.portal.IN_URL").data().getValue();
		model.addAttribute("IN_URL",IN_URL);

		String PC_IN_CAM_PORTAL_URL= ConfigServiceProxy.api().getByCode("app.portal.PC_IN_CAM_PORTAL_URL").data().getValue();
		model.addAttribute("PC_IN_CAM_PORTAL_URL",PC_IN_CAM_PORTAL_URL);

		String PC_OUT_CAM_PORTAL_URL= ConfigServiceProxy.api().getByCode("app.portal.PC_OUT_CAM_PORTAL_URL").data().getValue();
		model.addAttribute("PC_OUT_CAM_PORTAL_URL",PC_OUT_CAM_PORTAL_URL);


		return prefix+"back_to_portal.html";
	}


}
