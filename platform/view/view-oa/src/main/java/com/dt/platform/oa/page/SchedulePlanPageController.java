package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.SchedulePlanServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 日程安排模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-24 17:28:32
*/

@Controller("OaSchedulePlanPageController")
@RequestMapping(SchedulePlanPageController.prefix)
public class SchedulePlanPageController extends ViewController {

	public static final String prefix="business/oa/schedule_plan";

	private SchedulePlanServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SchedulePlanServiceProxy proxy() {
		if(proxy==null) {
			proxy=SchedulePlanServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 日程安排 功能主页面
	 */
	@RequestMapping("/schedule_plan_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"schedule_plan_list");
	}


	/**
	 * 日程安排 功能主页面
	 */
	@RequestMapping("/schedule_plan_cal.html")
	public String cal(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"schedule_plan_cal");
	}


	/**
	 * 日程安排 表单页面
	 */
	@RequestMapping("/schedule_plan_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"schedule_plan_form");
	}
}