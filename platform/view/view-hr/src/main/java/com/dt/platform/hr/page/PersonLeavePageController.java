package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonLeaveServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 员工离职模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:03:43
*/

@Controller("HrPersonLeavePageController")
@RequestMapping(PersonLeavePageController.prefix)
public class PersonLeavePageController extends ViewController {

	public static final String prefix="business/hr/person_leave";

	private PersonLeaveServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonLeaveServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonLeaveServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 员工离职 功能主页面
	 */
	@RequestMapping("/person_leave_list.html")
	public String list(Model model,HttpServletRequest request,String code) {
		model.addAttribute("code",code);
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		model.addAttribute("curEmpId",empId);
		return getTemplatePath(prefix,"person_leave_list");
	}

	/**
	 * 员工离职 表单页面
	 */
	@RequestMapping("/person_leave_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		SessionUser user=SessionUser.getCurrent();
		String userName=user.getUser().getActivatedEmployeeName();
		model.addAttribute("curEmpId",empId);
		model.addAttribute("curUserName",userName);
		return getTemplatePath(prefix,"person_leave_form");
	}
}