package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerIntentionalServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 客户意向模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:32:22
*/

@Controller("OaCrmCustomerIntentionalPageController")
@RequestMapping(CrmCustomerIntentionalPageController.prefix)
public class CrmCustomerIntentionalPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_intentional";

	private CrmCustomerIntentionalServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerIntentionalServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerIntentionalServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 客户意向 功能主页面
	 */
	@RequestMapping("/crm_customer_intentional_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"crm_customer_intentional_list");
	}

	/**
	 * 客户意向 表单页面
	 */
	@RequestMapping("/crm_customer_intentional_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"crm_customer_intentional_form");
	}
}