package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionProcessActionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 处理方式模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-05 10:15:23
*/

@Controller("EamInspectionProcessActionPageController")
@RequestMapping(InspectionProcessActionPageController.prefix)
public class InspectionProcessActionPageController extends ViewController {

	public static final String prefix="business/eam/inspection_process_action";

	private InspectionProcessActionServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public InspectionProcessActionServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionProcessActionServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 处理方式 功能主页面
	 */
	@RequestMapping("/inspection_process_action_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"inspection_process_action_list");
	}

	/**
	 * 处理方式 表单页面
	 */
	@RequestMapping("/inspection_process_action_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"inspection_process_action_form");
	}
}