package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryTplServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 薪酬模版模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 21:46:44
*/

@Controller("HrSalaryTplPageController")
@RequestMapping(SalaryTplPageController.prefix)
public class SalaryTplPageController extends ViewController {

	public static final String prefix="business/hr/salary_tpl";

	private SalaryTplServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryTplServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryTplServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 薪酬模版 功能主页面
	 */
	@RequestMapping("/salary_tpl_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_tpl_list");
	}

	/**
	 * 薪酬模版 表单页面
	 */
	@RequestMapping("/salary_tpl_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"salary_tpl_form");
	}
}