package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryDetailServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 薪酬明细模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 23:33:41
*/

@Controller("HrSalaryDetailPageController")
@RequestMapping(SalaryDetailPageController.prefix)
public class SalaryDetailPageController extends ViewController {

	public static final String prefix="business/hr/salary_detail";

	private SalaryDetailServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryDetailServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryDetailServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 薪酬明细 功能主页面
	 */
	@RequestMapping("/salary_detail_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_detail_list");
	}

	/**
	 * 薪酬明细 表单页面
	 */
	@RequestMapping("/salary_detail_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"salary_detail_form");
	}
}