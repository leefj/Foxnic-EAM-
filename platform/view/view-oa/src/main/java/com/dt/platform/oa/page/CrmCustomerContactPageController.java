package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerContactServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 联系人模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 10:56:31
*/

@Controller("OaCrmCustomerContactPageController")
@RequestMapping(CrmCustomerContactPageController.prefix)
public class CrmCustomerContactPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_contact";

	private CrmCustomerContactServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerContactServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerContactServiceProxy.api();
		}
		return proxy;
	}


	@RequestMapping("/form_show_list.html")
	public String formList(Model model,HttpServletRequest request,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"form_show_list");
	}


	/**
	 * 联系人 功能主页面
	 */
	@RequestMapping("/crm_customer_contact_list.html")
	public String list(Model model,HttpServletRequest request,String customerId,String dataRangeType) {
		model.addAttribute("customerId",customerId);
		model.addAttribute("dataRangeType",dataRangeType);
		return getTemplatePath(prefix,"crm_customer_contact_list");
	}

	/**
	 * 联系人 表单页面
	 */
	@RequestMapping("/crm_customer_contact_form.html")
	public String form(Model model,HttpServletRequest request , String id,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"crm_customer_contact_form");
	}
}