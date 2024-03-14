package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentBillTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 单据任务模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-11 14:43:17
*/

@Controller("HrAssessmentBillTaskPageController")
@RequestMapping(AssessmentBillTaskPageController.prefix)
public class AssessmentBillTaskPageController extends ViewController {

	public static final String prefix="business/hr/assessment_bill_task";

	private AssessmentBillTaskServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentBillTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentBillTaskServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 单据任务 功能主页面
	 */
	@RequestMapping("/assessment_bill_task_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"assessment_bill_task_list");
	}

	@RequestMapping("/tree_bill_task_list.html")
	public String tree_bill_task_list(Model model,HttpServletRequest request,String billId) {
		model.addAttribute("billId",billId);
		model.addAttribute("url","/business/hr/assessment_bill_task/bill_task_list.html?role=admin&t=123456&billId="+billId);
		return getTemplatePath(prefix,"tree_bill_task_list");
	}

	//role my self
	@RequestMapping("/bill_task_list.html")
	public String bill_task_list(Model model,HttpServletRequest request,String billId,String role) {
		model.addAttribute("billId",billId);
		model.addAttribute("operUserId", SessionUser.getCurrent().getActivatedEmployeeId());
		model.addAttribute("role",role);
		boolean spread=false;
		if("self".equals(role)){
			spread=true;
		}
		model.addAttribute("spread",spread);
		return getTemplatePath(prefix,"bill_task_list");
	}


	/**
	 * 单据任务 表单页面
	 */
	@RequestMapping("/assessment_bill_task_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"assessment_bill_task_form");
	}
}