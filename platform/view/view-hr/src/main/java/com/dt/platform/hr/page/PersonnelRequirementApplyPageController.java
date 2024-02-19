package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonnelRequirementApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员需求申请模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 15:59:07
*/

@Controller("HrPersonnelRequirementApplyPageController")
@RequestMapping(PersonnelRequirementApplyPageController.prefix)
public class PersonnelRequirementApplyPageController extends ViewController {

	public static final String prefix="business/hr/personnel_requirement_apply";

	private PersonnelRequirementApplyServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonnelRequirementApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonnelRequirementApplyServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 人员需求申请 功能主页面
	 */
	@RequestMapping("/personnel_requirement_apply_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"personnel_requirement_apply_list");
	}

	/**
	 * 人员需求申请 表单页面
	 */
	@RequestMapping("/personnel_requirement_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"personnel_requirement_apply_form");
	}
}