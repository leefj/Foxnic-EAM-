package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.WorkOrderServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 问题工单模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-13 20:51:41
*/

@Controller("EamWorkOrderPageController")
@RequestMapping(WorkOrderPageController.prefix)
public class WorkOrderPageController extends ViewController {

	public static final String prefix="business/eam/work_order";

	private WorkOrderServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public WorkOrderServiceProxy proxy() {
		if(proxy==null) {
			proxy=WorkOrderServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 问题工单 功能主页面
	 */
	@RequestMapping("/work_order_list.html")
	public String list(Model model,HttpServletRequest request,String role) {
		model.addAttribute("role",role);
		return getTemplatePath(prefix,"work_order_list");
	}

	/**
	 * 问题工单 表单页面
	 */
	@RequestMapping("/work_order_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"work_order_form");
	}

	/**
	 * 问题工单 表单页面
	 */
	@RequestMapping("/work_order_p_form.html")
	public String form(Model model,HttpServletRequest request , String id,String role) {
		model.addAttribute("role",role);
		return getTemplatePath(prefix,"work_order_p_form");
	}


}