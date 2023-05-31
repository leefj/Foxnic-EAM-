package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("ScreenDesignerPageController")
@RequestMapping(ScreenDesignerPageController.prefix)
public class ScreenDesignerPageController extends ViewController {


	public static final String prefix="business/common/screen";



	@RequestMapping("/goview/dist/index.html")
	public String screenDesignerIndex(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/goview/dist/index";
	}

	@RequestMapping("/screenDesinger.html")
	public String screenDesinger(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/screenDesinger";
	}


	@RequestMapping("/screenDesingerDashboard.html")
	public String screenDesingerDashboard(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/screenDesingerDashboard";
	}

	@RequestMapping("/screenDashBoard.html")
	public String screenDashBoard(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/screenDashBoard";
	}




}
