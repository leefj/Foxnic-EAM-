package com.dt.platform.hr.page;

import com.dt.platform.proxy.hr.PersonServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonWorkExperienceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 工作经历模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 15:21:16
*/

@Controller("HrPersonWorkExperiencePageController")
@RequestMapping(PersonWorkExperiencePageController.prefix)
public class PersonWorkExperiencePageController extends ViewController {

	public static final String prefix="business/hr/person_work_experience";

	private PersonWorkExperienceServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonWorkExperienceServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonWorkExperienceServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 工作经历 功能主页面
	 */
	@RequestMapping("/person_work_experience_list.html")
	public String list(Model model,HttpServletRequest request) {
		model.addAttribute("modifyPerm", PersonServiceProxy.api().queryOperParameterValue("hr.personWork"));
		return getTemplatePath(prefix,"person_work_experience_list");
	}


	/**
	 * 工作经历 功能主页面
	 */
	@RequestMapping("/person_work_experience_a_list.html")
	public String alist(Model model,HttpServletRequest request,String role,String personId) {
		model.addAttribute("role",role);
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_work_experience_a_list");
	}

	/**
	 * 工作经历 表单页面
	 */
	@RequestMapping("/person_work_experience_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_work_experience_form");
	}

	/**
	 * 工作经历 表单页面
	 */
	@RequestMapping("/person_work_a_form.html")
	public String aform(Model model,HttpServletRequest request , String id,String personId) {
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_work_a_form");
	}

}