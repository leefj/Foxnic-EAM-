package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryProjectUnitRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 计件项目记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 19:53:09
*/

@Controller("HrSalaryProjectUnitRcdPageController")
@RequestMapping(SalaryProjectUnitRcdPageController.prefix)
public class SalaryProjectUnitRcdPageController extends ViewController {

	public static final String prefix="business/hr/salary_project_unit_rcd";

	private SalaryProjectUnitRcdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryProjectUnitRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryProjectUnitRcdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 计件项目记录 功能主页面
	 */
	@RequestMapping("/salary_project_unit_rcd_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"salary_project_unit_rcd_list");
	}

	/**
	 * 计件项目记录 表单页面
	 */
	@RequestMapping("/salary_project_unit_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"salary_project_unit_rcd_form");
	}
}