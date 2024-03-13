package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentBillTaskPaperServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考核试卷模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 17:23:38
*/

@Controller("HrAssessmentBillTaskPaperPageController")
@RequestMapping(AssessmentBillTaskPaperPageController.prefix)
public class AssessmentBillTaskPaperPageController extends ViewController {

	public static final String prefix="business/hr/assessment_bill_task_paper";

	private AssessmentBillTaskPaperServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentBillTaskPaperServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentBillTaskPaperServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考核试卷 功能主页面
	 */
	@RequestMapping("/bill_task_paper_list.html")
	public String bill_task_paper_list(Model model,HttpServletRequest request,String billTaskDtlId,String relationship) {
		model.addAttribute("billTaskDtlId",billTaskDtlId);
		model.addAttribute("relationship",relationship);
		return getTemplatePath(prefix,"bill_task_paper_list");
	}


	/**
	 * 考核试卷 功能主页面
	 */
	@RequestMapping("/assessment_bill_task_paper_list.html")
	public String list(Model model,HttpServletRequest request,String billTaskDtlId) {
		model.addAttribute("billTaskDtlId",billTaskDtlId);
		return getTemplatePath(prefix,"assessment_bill_task_paper_list");
	}

	/**
	 * 考核试卷 表单页面
	 */
	@RequestMapping("/assessment_bill_task_paper_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"assessment_bill_task_paper_form");
	}
}