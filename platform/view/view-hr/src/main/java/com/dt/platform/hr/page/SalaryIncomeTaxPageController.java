package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryIncomeTaxServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 所得税设置模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 07:40:19
*/

@Controller("HrSalaryIncomeTaxPageController")
@RequestMapping(SalaryIncomeTaxPageController.prefix)
public class SalaryIncomeTaxPageController extends ViewController {

	public static final String prefix="business/hr/salary_income_tax";

	private SalaryIncomeTaxServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryIncomeTaxServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryIncomeTaxServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 所得税设置 功能主页面
	 */
	@RequestMapping("/salary_income_tax_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_income_tax_list");
	}

	/**
	 * 所得税设置 表单页面
	 */
	@RequestMapping("/salary_income_tax_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"salary_income_tax_form");
	}
}