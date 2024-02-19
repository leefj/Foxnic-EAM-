package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonIncomeCertificateApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 收入证明申请模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 16:01:42
*/

@Controller("HrPersonIncomeCertificateApplyPageController")
@RequestMapping(PersonIncomeCertificateApplyPageController.prefix)
public class PersonIncomeCertificateApplyPageController extends ViewController {

	public static final String prefix="business/hr/person_income_certificate_apply";

	private PersonIncomeCertificateApplyServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonIncomeCertificateApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonIncomeCertificateApplyServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 收入证明申请 功能主页面
	 */
	@RequestMapping("/person_income_certificate_apply_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_income_certificate_apply_list");
	}

	/**
	 * 收入证明申请 表单页面
	 */
	@RequestMapping("/person_income_certificate_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_income_certificate_apply_form");
	}
}