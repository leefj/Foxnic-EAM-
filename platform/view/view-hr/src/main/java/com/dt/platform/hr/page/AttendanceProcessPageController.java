package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AttendanceProcessServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考勤跑批模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-26 08:21:39
*/

@Controller("HrAttendanceProcessPageController")
@RequestMapping(AttendanceProcessPageController.prefix)
public class AttendanceProcessPageController extends ViewController {

	public static final String prefix="business/hr/attendance_process";

	private AttendanceProcessServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AttendanceProcessServiceProxy proxy() {
		if(proxy==null) {
			proxy=AttendanceProcessServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考勤跑批 功能主页面
	 */
	@RequestMapping("/attendance_process_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"attendance_process_list");
	}

	/**
	 * 考勤跑批 表单页面
	 */
	@RequestMapping("/attendance_process_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"attendance_process_form");
	}
}