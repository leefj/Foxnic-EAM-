package com.dt.platform.hr.page;

import com.dt.platform.proxy.hr.PersonServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonEducationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 教育信息模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 15:44:11
*/

@Controller("HrPersonEducationPageController")
@RequestMapping(PersonEducationPageController.prefix)
public class PersonEducationPageController extends ViewController {

	public static final String prefix="business/hr/person_education";

	private PersonEducationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonEducationServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonEducationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 教育信息 功能主页面
	 */
	@RequestMapping("/person_education_list.html")
	public String list(Model model,HttpServletRequest request) {

		model.addAttribute("modifyPerm", PersonServiceProxy.api().queryOperParameterValue("hr.personEducation"));
		return getTemplatePath(prefix,"person_education_list");
	}

	/**
	 * 教育信息 功能主页面
	 */
	@RequestMapping("/person_education_a_list.html")
	public String alist(Model model,HttpServletRequest request,String role,String personId) {
		model.addAttribute("role",role);
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_education_a_list");
	}


	/**
	 * 教育信息 表单页面
	 */
	@RequestMapping("/person_education_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_education_form");
	}

	/**
	 * 教育信息 表单页面
	 */
	@RequestMapping("/person_edu_a_form.html")
	public String aform(Model model,HttpServletRequest request , String id,String personId) {
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_edu_a_form");
	}
}