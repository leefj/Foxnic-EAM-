package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考核任务模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-09 14:46:37
*/

@Controller("HrAssessmentTaskPageController")
@RequestMapping(AssessmentTaskPageController.prefix)
public class AssessmentTaskPageController extends ViewController {

	public static final String prefix="business/hr/assessment_task";

	private AssessmentTaskServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentTaskServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考核任务 功能主页面
	 */
	@RequestMapping("/assessment_task_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"assessment_task_list");
	}

	/**
	 * 考核任务 表单页面
	 */
	@RequestMapping("/assessment_task_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"assessment_task_form");
	}
}