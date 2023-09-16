package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerLevelServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 客户等级模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:31:33
*/

@Controller("OaCrmCustomerLevelPageController")
@RequestMapping(CrmCustomerLevelPageController.prefix)
public class CrmCustomerLevelPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_level";

	private CrmCustomerLevelServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerLevelServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerLevelServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 客户等级 功能主页面
	 */
	@RequestMapping("/crm_customer_level_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"crm_customer_level_list");
	}

	/**
	 * 客户等级 表单页面
	 */
	@RequestMapping("/crm_customer_level_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"crm_customer_level_form");
	}
}