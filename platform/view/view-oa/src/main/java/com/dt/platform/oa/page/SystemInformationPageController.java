package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.SystemInformationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 外部系统模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 20:48:09
*/

@Controller("OaSystemInformationPageController")
@RequestMapping(SystemInformationPageController.prefix)
public class SystemInformationPageController extends ViewController {

	public static final String prefix="business/oa/system_information";

	private SystemInformationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SystemInformationServiceProxy proxy() {
		if(proxy==null) {
			proxy=SystemInformationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 外部系统 功能主页面
	 */
	@RequestMapping("/system_information_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"system_information_list");
	}

	/**
	 * 外部系统 表单页面
	 */
	@RequestMapping("/system_information_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"system_information_form");
	}
}