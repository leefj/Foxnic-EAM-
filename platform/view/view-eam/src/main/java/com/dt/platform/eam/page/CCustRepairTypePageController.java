package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CCustRepairTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 报修类型模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-14 08:57:14
*/

@Controller("EamCCustRepairTypePageController")
@RequestMapping(CCustRepairTypePageController.prefix)
public class CCustRepairTypePageController extends ViewController {

	public static final String prefix="business/eam/c_cust_repair_type";

	private CCustRepairTypeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CCustRepairTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=CCustRepairTypeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 报修类型 功能主页面
	 */
	@RequestMapping("/c_cust_repair_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"c_cust_repair_type_list");
	}

	/**
	 * 报修类型 表单页面
	 */
	@RequestMapping("/c_cust_repair_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_repair_type_form");
	}
}