package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentBillServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考核单据模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-08 20:54:09
*/

@Controller("HrAssessmentBillPageController")
@RequestMapping(AssessmentBillPageController.prefix)
public class AssessmentBillPageController extends ViewController {

	public static final String prefix="business/hr/assessment_bill";

	private AssessmentBillServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentBillServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentBillServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考核单据 功能主页面
	 */

	@RequestMapping("/assessment_bill_show_list.html")
	public String assessment_bill_show_list(Model model,HttpServletRequest request,String taskId) {
		model.addAttribute("taskId",taskId);
		return getTemplatePath(prefix,"assessment_bill_show_list");
	}

	@RequestMapping("/assessment_bill_list.html")
	public String list(Model model,HttpServletRequest request,String taskId) {
		model.addAttribute("taskId",taskId);
		return getTemplatePath(prefix,"assessment_bill_list");
	}

	/**
	 * 考核单据 表单页面
	 */
	@RequestMapping("/assessment_bill_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"assessment_bill_form");
	}
}