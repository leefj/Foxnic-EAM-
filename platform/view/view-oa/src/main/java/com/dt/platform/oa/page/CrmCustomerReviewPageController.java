package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.CrmCustomerReviewServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 回访模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 15:35:52
*/

@Controller("OaCrmCustomerReviewPageController")
@RequestMapping(CrmCustomerReviewPageController.prefix)
public class CrmCustomerReviewPageController extends ViewController {

	public static final String prefix="business/oa/crm_customer_review";

	private CrmCustomerReviewServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CrmCustomerReviewServiceProxy proxy() {
		if(proxy==null) {
			proxy=CrmCustomerReviewServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/form_show_list.html")
	public String formList(Model model,HttpServletRequest request,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"form_show_list");
	}


	/**
	 * 回访 功能主页面
	 */
	@RequestMapping("/crm_customer_review_list.html")
	public String list(Model model,HttpServletRequest request,String customerId) {
		model.addAttribute("customerId",customerId);
		return getTemplatePath(prefix,"crm_customer_review_list");
	}

	/**
	 * 回访 表单页面
	 */
	@RequestMapping("/crm_customer_review_form.html")
	public String form(Model model,HttpServletRequest request , String id,String customerId) {

		model.addAttribute("customerId",customerId);
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		SessionUser user=SessionUser.getCurrent();
		String userName=user.getUser().getActivatedEmployeeName();
		model.addAttribute("curEmpId",empId);
		model.addAttribute("curUserName",userName);

		return getTemplatePath(prefix,"crm_customer_review_form");
	}
}