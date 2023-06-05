package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryMonthServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 薪酬月份模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 13:47:32
*/

@Controller("HrSalaryMonthPageController")
@RequestMapping(SalaryMonthPageController.prefix)
public class SalaryMonthPageController extends ViewController {

	public static final String prefix="business/hr/salary_month";

	private SalaryMonthServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryMonthServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryMonthServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 薪酬月份 功能主页面
	 */
	@RequestMapping("/salary_month_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"/salary_month_list");
	}

	/**
	 * 薪酬月份 表单页面
	 */
	@RequestMapping("/salary_month_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_month_form");
	}
}