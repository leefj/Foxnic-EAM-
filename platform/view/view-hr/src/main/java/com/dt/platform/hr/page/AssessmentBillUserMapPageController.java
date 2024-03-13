package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.AssessmentBillUserMapServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员映射模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 08:13:16
*/

@Controller("HrAssessmentBillUserMapPageController")
@RequestMapping(AssessmentBillUserMapPageController.prefix)
public class AssessmentBillUserMapPageController extends ViewController {

	public static final String prefix="business/hr/assessment_bill_user_map";

	private AssessmentBillUserMapServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssessmentBillUserMapServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssessmentBillUserMapServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/bill_user_map_list.html")
	public String bill_user_map_list(Model model,HttpServletRequest request,String ownerId,String billId) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("billId",billId);
		return getTemplatePath(prefix,"bill_user_map_list");
	}


	@RequestMapping("/tree_user_map_list.html")
	public String tree_bill_user_map_list(Model model,HttpServletRequest request,String billId) {
		model.addAttribute("billId",billId);
		model.addAttribute("url","/business/hr/assessment_bill_user_map/bill_user_map_list.html?t=123456&billId="+billId);
		return getTemplatePath(prefix,"tree_user_map_list.html");
	}


	/**
	 * 人员映射 功能主页面
	 */
	@RequestMapping("/assessment_bill_user_map_list.html")
	public String list(Model model,HttpServletRequest request,String ownerId,String billId) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("billId",billId);
		return getTemplatePath(prefix,"assessment_bill_user_map_list");
	}

	/**
	 * 人员映射 表单页面
	 */
	@RequestMapping("/assessment_bill_user_map_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerId,String billId) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("billId",billId);
		return getTemplatePath(prefix,"assessment_bill_user_map_form");
	}
}