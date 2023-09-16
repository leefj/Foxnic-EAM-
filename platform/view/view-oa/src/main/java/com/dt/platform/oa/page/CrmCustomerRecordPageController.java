package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerRecordServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 历史记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-15 14:15:26
*/

@Controller("OaCrmCustomerRecordPageController")
@RequestMapping(CrmCustomerRecordPageController.prefix)
public class CrmCustomerRecordPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_record";

	private CrmCustomerRecordServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerRecordServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerRecordServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/form_show_list.html")
	public String formList(Model model,HttpServletRequest request,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"form_show_list");
	}


	/**
	 * 历史记录 功能主页面
	 */
	@RequestMapping("/crm_customer_record_list.html")
	public String list(Model model,HttpServletRequest request,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"crm_customer_record_list");
	}

	/**
	 * 历史记录 表单页面
	 */
	@RequestMapping("/crm_customer_record_form.html")
	public String form(Model model,HttpServletRequest request , String id,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"crm_customer_record_form");
	}
}