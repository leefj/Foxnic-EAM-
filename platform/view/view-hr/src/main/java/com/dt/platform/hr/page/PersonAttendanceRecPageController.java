package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonAttendanceRecServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员考勤模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 10:58:37
*/

@Controller("HrPersonAttendanceRecPageController")
@RequestMapping(PersonAttendanceRecPageController.prefix)
public class PersonAttendanceRecPageController extends ViewController {

	public static final String prefix="business/hr/person_attendance_rec";

	private PersonAttendanceRecServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonAttendanceRecServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonAttendanceRecServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 人员考勤 功能主页面
	 */
	@RequestMapping("/person_attendance_rec_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_attendance_rec_list");
	}

	/**
	 * 人员考勤 表单页面
	 */
	@RequestMapping("/person_attendance_rec_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_attendance_rec_form");
	}
}