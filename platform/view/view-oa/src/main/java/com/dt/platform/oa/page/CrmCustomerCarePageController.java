package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerCareServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 我的关注模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 12:56:45
*/

@Controller("OaCrmCustomerCarePageController")
@RequestMapping(CrmCustomerCarePageController.prefix)
public class CrmCustomerCarePageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_care";

	private CrmCustomerCareServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerCareServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerCareServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 我的关注 功能主页面
	 */
	@RequestMapping("/crm_customer_care_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"crm_customer_care_list");
	}

	/**
	 * 我的关注 表单页面
	 */
	@RequestMapping("/crm_customer_care_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"crm_customer_care_form");
	}
}