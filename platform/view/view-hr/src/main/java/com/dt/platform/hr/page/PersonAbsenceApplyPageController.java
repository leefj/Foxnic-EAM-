package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonAbsenceApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 请假申请模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:44:06
*/

@Controller("HrPersonAbsenceApplyPageController")
@RequestMapping(PersonAbsenceApplyPageController.prefix)
public class PersonAbsenceApplyPageController extends ViewController {

	public static final String prefix="business/hr/person_absence_apply";

	private PersonAbsenceApplyServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonAbsenceApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonAbsenceApplyServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 请假申请 功能主页面
	 */
	@RequestMapping("/person_absence_apply_list.html")
	public String list(Model model,HttpServletRequest request,String code) {
		model.addAttribute("code",code);
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		model.addAttribute("curEmpId",empId);
		return getTemplatePath(prefix,"person_absence_apply_list");
	}

	/**
	 * 请假申请 表单页面
	 */
	@RequestMapping("/person_absence_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		String empId= SessionUser.getCurrent().getActivatedEmployeeId();
		SessionUser user=SessionUser.getCurrent();
		String userName=user.getUser().getActivatedEmployeeName();
		model.addAttribute("curEmpId",empId);
		model.addAttribute("curUserName",userName);
		return getTemplatePath(prefix,"person_absence_apply_form");
	}
}