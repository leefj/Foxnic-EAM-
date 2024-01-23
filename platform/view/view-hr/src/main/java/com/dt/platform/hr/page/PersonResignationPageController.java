package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonResignationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 员工离职模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 07:34:30
*/

@Controller("HrPersonResignationPageController")
@RequestMapping(PersonResignationPageController.prefix)
public class PersonResignationPageController extends ViewController {

	public static final String prefix="business/hr/person_resignation";

	private PersonResignationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonResignationServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonResignationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 员工离职 功能主页面
	 */
	@RequestMapping("/person_resignation_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_resignation_list");
	}

	/**
	 * 员工离职 表单页面
	 */
	@RequestMapping("/person_resignation_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_resignation_form");
	}
}