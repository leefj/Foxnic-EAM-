package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryTaxPctServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 薪酬税率模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:41:55
*/

@Controller("HrSalaryTaxPctPageController")
@RequestMapping(SalaryTaxPctPageController.prefix)
public class SalaryTaxPctPageController extends ViewController {

	public static final String prefix="business/hr/salary_tax_pct";

	private SalaryTaxPctServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryTaxPctServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryTaxPctServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 薪酬税率 功能主页面
	 */
	@RequestMapping("/salary_tax_pct_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_tax_pct_list");
	}

	/**
	 * 薪酬税率 表单页面
	 */
	@RequestMapping("/salary_tax_pct_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_tax_pct_form");
	}
}