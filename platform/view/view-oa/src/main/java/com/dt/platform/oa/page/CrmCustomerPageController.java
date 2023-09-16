package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 客户模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:50
*/

@Controller("OaCrmCustomerPageController")
@RequestMapping(CrmCustomerPageController.prefix)
public class CrmCustomerPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer";

	private CrmCustomerServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerServiceProxy.api();
		}
		return proxy;
	}


	/**
	 * 客户 功能主页面
	 */
	@RequestMapping("/crm_my_customer_list.html")
	public String myList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"crm_my_customer_list");
	}

	/**
	 * 客户 功能主页面
	 */
	@RequestMapping("/crm_customer_list.html")
	public String list(Model model,HttpServletRequest request,String tabStatus) {
		model.addAttribute("tabStatus",tabStatus);
		return getTemplatePath(prefix,"crm_customer_list");
	}

	@RequestMapping("/crm_invalid_customer_list.html")
	public String invalidlist(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"crm_invalid_customer_list");
	}

	@RequestMapping("/share_user_form.html")
	public String shareUser(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"share_user_form");
	}

	@RequestMapping("/customer_transfer_form.html")
	public String transferForm(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"customer_transfer_list");
	}


	@RequestMapping("/crm_sea_customer_list.html")
	public String sealist(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"crm_sea_customer_list");
	}

	/**
	 * 客户 表单页面
	 */
	@RequestMapping("/crm_view_customer_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		SessionUser user=SessionUser.getCurrent();
		String userName=user.getUser().getActivatedEmployeeName();
		model.addAttribute("customerId",id);
		model.addAttribute("curEmpId",empId);
		model.addAttribute("curUserName",userName);
		return getTemplatePath(prefix,"crm_view_customer_form");
	}

	/**
	 * 客户 表单页面
	 */
	@RequestMapping("/crm_customer_form.html")
	public String form(Model model,HttpServletRequest request , String id,String rolePos) {
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		SessionUser user=SessionUser.getCurrent();
		String userName=user.getUser().getActivatedEmployeeName();
		model.addAttribute("curEmpId",empId);
		model.addAttribute("rolePos",rolePos);
		model.addAttribute("curUserName",userName);
		return getTemplatePath(prefix,"crm_customer_form");
	}
}