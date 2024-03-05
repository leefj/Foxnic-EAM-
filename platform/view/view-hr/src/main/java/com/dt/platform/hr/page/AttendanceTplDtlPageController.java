package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AttendanceTplDtlServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考勤组模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-25 19:29:07
*/

@Controller("HrAttendanceTplDtlPageController")
@RequestMapping(AttendanceTplDtlPageController.prefix)
public class AttendanceTplDtlPageController extends ViewController {

	public static final String prefix="business/hr/attendance_tpl_dtl";

	private AttendanceTplDtlServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AttendanceTplDtlServiceProxy proxy() {
		if(proxy==null) {
			proxy=AttendanceTplDtlServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考勤组 功能主页面
	 */
	@RequestMapping("/attendance_tpl_dtl_list.html")
	public String list(Model model,HttpServletRequest request,String ownerId,String action) {
		model.addAttribute("action",action);
		model.addAttribute("ownerId",ownerId);
		return getTemplatePath(prefix,"attendance_tpl_dtl_list");
	}

	/**
	 * 考勤组 表单页面
	 */
	@RequestMapping("/attendance_tpl_dtl_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerId) {
		model.addAttribute("ownerId",ownerId);
		return getTemplatePath(prefix,"attendance_tpl_dtl_form");
	}
}