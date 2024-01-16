package com.dt.platform.hr.page;

import com.dt.platform.proxy.hr.PersonServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonSocialRelationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 社会关系模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 15:44:30
*/

@Controller("HrPersonSocialRelationPageController")
@RequestMapping(PersonSocialRelationPageController.prefix)
public class PersonSocialRelationPageController extends ViewController {

	public static final String prefix="business/hr/person_social_relation";

	private PersonSocialRelationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonSocialRelationServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonSocialRelationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 社会关系 功能主页面
	 */
	@RequestMapping("/person_social_relation_list.html")
	public String list(Model model,HttpServletRequest request) {
		model.addAttribute("modifyPerm", PersonServiceProxy.api().queryOperParameterValue("hr.personSocialRelation"));
		return getTemplatePath(prefix,"person_social_relation_list");
	}

	/**
	 * 社会关系 功能主页面
	 */
	@RequestMapping("/person_social_relation_a_list.html")
	public String alist(Model model,HttpServletRequest request,String role,String personId) {
		model.addAttribute("role",role);
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_social_relation_a_list");
	}

	/**
	 * 社会关系 功能主页面
	 */
	@RequestMapping("/person_social_relation_form.html")
	public String form(Model model,HttpServletRequest request,String id) {
		return getTemplatePath(prefix,"person_social_relation_form");
	}

	/**
	 * 社会关系 功能主页面
	 */
	@RequestMapping("/person_social_a_form.html")
	public String aform(Model model,HttpServletRequest request,String id,String personId) {
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_social_a_form");
	}


}