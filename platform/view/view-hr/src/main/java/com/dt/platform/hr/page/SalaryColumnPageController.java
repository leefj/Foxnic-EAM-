package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryColumnServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 薪酬字段模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 14:09:26
*/

@Controller("HrSalaryColumnPageController")
@RequestMapping(SalaryColumnPageController.prefix)
public class SalaryColumnPageController extends ViewController {

	public static final String prefix="business/hr/salary_column";

	private SalaryColumnServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryColumnServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryColumnServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 薪酬字段 功能主页面
	 */
	@RequestMapping("/salary_column_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_column_list");
	}

	/**
	 * 薪酬字段 表单页面
	 */
	@RequestMapping("/salary_column_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"salary_column_form");
	}
}