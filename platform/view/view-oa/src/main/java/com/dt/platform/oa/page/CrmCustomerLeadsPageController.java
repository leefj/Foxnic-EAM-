package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerLeadsServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 线索模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:39
*/

@Controller("OaCrmCustomerLeadsPageController")
@RequestMapping(CrmCustomerLeadsPageController.prefix)
public class CrmCustomerLeadsPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_leads";

	private CrmCustomerLeadsServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerLeadsServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerLeadsServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 线索 功能主页面
	 */
	@RequestMapping("/crm_customer_leads_list.html")
	public String list(Model model,HttpServletRequest request) {

		return getTemplatePath(prefix,"crm_customer_leads_list");
	}

	/**
	 * 线索 表单页面
	 */
	@RequestMapping("/crm_customer_leads_form.html")
	public String form(Model model,HttpServletRequest request , String id) {

		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		SessionUser user=SessionUser.getCurrent();
		String userName=user.getUser().getActivatedEmployeeName();
		model.addAttribute("curEmpId",empId);
		model.addAttribute("curUserName",userName);

		return getTemplatePath(prefix,"crm_customer_leads_form");
	}
}