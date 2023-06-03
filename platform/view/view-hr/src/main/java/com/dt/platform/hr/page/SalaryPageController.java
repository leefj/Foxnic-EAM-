package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员薪酬模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 23:11:09
*/

@Controller("HrSalaryPageController")
@RequestMapping(SalaryPageController.prefix)
public class SalaryPageController extends ViewController {

	public static final String prefix="business/hr/salary";

	private SalaryServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 人员薪酬 功能主页面
	 */
	@RequestMapping("/salary_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_list");
	}

	/**
	 * 人员薪酬 表单页面
	 */
	@RequestMapping("/salary_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"salary_form");
	}
}