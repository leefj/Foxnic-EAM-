package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonApprovalRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 审批记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 22:04:52
*/

@Controller("HrPersonApprovalRcdPageController")
@RequestMapping(PersonApprovalRcdPageController.prefix)
public class PersonApprovalRcdPageController extends ViewController {

	public static final String prefix="business/hr/person_approval_rcd";

	private PersonApprovalRcdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonApprovalRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonApprovalRcdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 审批记录 功能主页面
	 */
	@RequestMapping("/person_approval_rcd_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_approval_rcd_list");
	}

	/**
	 * 审批记录 表单页面
	 */
	@RequestMapping("/person_approval_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id,String itemIds,String type,String itemFlag) {
		model.addAttribute("itemIds",itemIds);
		model.addAttribute("type",type);
		model.addAttribute("itemFlag",itemFlag);
		return getTemplatePath(prefix,"person_approval_rcd_form");
	}
}