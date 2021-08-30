package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ApproveConfigureServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产审批配置 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-29 12:15:18
*/

@Controller("EamApproveConfigurePageController")
@RequestMapping(ApproveConfigurePageController.prefix)
public class ApproveConfigurePageController extends ViewController {
	
	public static final String prefix="business/eam/approve_configure";

	private ApproveConfigureServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ApproveConfigureServiceProxy proxy() {
		if(proxy==null) {
			proxy=ApproveConfigureServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产审批配置 功能主页面
	 */
	@RequestMapping("/approve_configure_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/approve_configure_list";
	}

	/**
	 * 资产审批配置 表单页面
	 */
	@RequestMapping("/approve_configure_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/approve_configure_form";
	}
}