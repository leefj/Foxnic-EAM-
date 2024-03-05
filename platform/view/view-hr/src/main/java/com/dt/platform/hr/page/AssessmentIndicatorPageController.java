package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentIndicatorServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考核指标模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-28 12:51:35
*/

@Controller("HrAssessmentIndicatorPageController")
@RequestMapping(AssessmentIndicatorPageController.prefix)
public class AssessmentIndicatorPageController extends ViewController {

	public static final String prefix="business/hr/assessment_indicator";

	private AssessmentIndicatorServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentIndicatorServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentIndicatorServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考核指标 功能主页面
	 */
	@RequestMapping("/assessment_indicator_list.html")
	public String list(Model model,HttpServletRequest request,String assessmentId) {
		model.addAttribute("assessmentId",assessmentId);
		return getTemplatePath(prefix,"assessment_indicator_list");
	}

	@RequestMapping("/tpl_indicator_list.html")
	public String tpllist(Model model,HttpServletRequest request,String assessmentId,String action) {
		model.addAttribute("assessmentId",assessmentId);
		model.addAttribute("action",action);
		return getTemplatePath(prefix,"tpl_indicator_list");
	}




	/**
	 * 考核指标 表单页面
	 */
	@RequestMapping("/assessment_indicator_form.html")
	public String form(Model model,HttpServletRequest request , String id,String assessmentId) {
		model.addAttribute("assessmentId",assessmentId);
		return getTemplatePath(prefix,"assessment_indicator_form");
	}
}