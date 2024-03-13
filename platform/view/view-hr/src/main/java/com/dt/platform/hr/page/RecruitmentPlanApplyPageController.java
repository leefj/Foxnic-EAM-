package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.RecruitmentPlanApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 招聘计划申请模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 15:58:50
*/

@Controller("HrRecruitmentPlanApplyPageController")
@RequestMapping(RecruitmentPlanApplyPageController.prefix)
public class RecruitmentPlanApplyPageController extends ViewController {

	public static final String prefix="business/hr/recruitment_plan_apply";

	private RecruitmentPlanApplyServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RecruitmentPlanApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=RecruitmentPlanApplyServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 招聘计划申请 功能主页面
	 */
	@RequestMapping("/recruitment_plan_apply_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"recruitment_plan_apply_list");
	}

	/**
	 * 招聘计划申请 表单页面
	 */
	@RequestMapping("/recruitment_plan_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"recruitment_plan_apply_form");
	}
}