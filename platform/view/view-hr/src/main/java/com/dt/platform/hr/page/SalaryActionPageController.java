package com.dt.platform.hr.page;

import com.dt.platform.domain.hr.SalaryAction;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryActionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 薪酬发放模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:19:32
*/

@Controller("HrSalaryActionPageController")
@RequestMapping(SalaryActionPageController.prefix)
public class SalaryActionPageController extends ViewController {

	public static final String prefix="business/hr/salary_action";

	private SalaryActionServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryActionServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryActionServiceProxy.api();
		}
		return proxy;
	}



	@RequestMapping("/person_list.html")
	public String personList(Model model,HttpServletRequest request,String tplId) {
		model.addAttribute("tplId",tplId);
		return getTemplatePath(prefix,"/person_list");
	}

	@RequestMapping("/salary_import_form.html")
	public String importForm(Model model,HttpServletRequest request,String tplId) {

		return getTemplatePath(prefix,"/salary_import_form");
	}

	@RequestMapping("/salary_detail_list2.html")
	public String salaryDetailList3(Model model,HttpServletRequest request,String actionId) {
		model.addAttribute("actionId",actionId);
		Result<SalaryAction> salaryActionRes=SalaryActionServiceProxy.api().getById(actionId);
		if(salaryActionRes.isSuccess()){
			model.addAttribute("actionStatus",salaryActionRes.getData().getStatus());
		}else{
			model.addAttribute("actionStatus","none");
		}
		return getTemplatePath(prefix,"salary_detail_list2");
	}


	@RequestMapping("/salary_action_list.html")
	public String salaryActionList2(Model model,HttpServletRequest request,String actionId) {
		model.addAttribute("actionId",actionId);
		return getTemplatePath(prefix,"/salary_action_list");
	}


	/**
	 * 薪酬发放 表单页面
	 */
	@RequestMapping("/salary_action_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_action_form");
	}
}