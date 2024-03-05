package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentIndicatorValueServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考核结果模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-28 10:43:19
*/

@Controller("HrAssessmentIndicatorValuePageController")
@RequestMapping(AssessmentIndicatorValuePageController.prefix)
public class AssessmentIndicatorValuePageController extends ViewController {

	public static final String prefix="business/hr/assessment_indicator_value";

	private AssessmentIndicatorValueServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentIndicatorValueServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentIndicatorValueServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考核结果 功能主页面
	 */
	@RequestMapping("/assessment_indicator_value_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"assessment_indicator_value_list");
	}

	/**
	 * 考核结果 表单页面
	 */
	@RequestMapping("/assessment_indicator_value_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"assessment_indicator_value_form");
	}
}