package com.dt.platform.hr.page;

import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.Salary;
import com.dt.platform.domain.hr.SalaryVO;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.SalaryServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 人员薪酬模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 13:01:03
*/

@Controller("HrSalaryPageController")
@RequestMapping(SalaryPageController.prefix)
public class SalaryPageController extends ViewController {

	public static final String prefix="business/hr/salary";

	private SalaryServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SalaryServiceProxy proxy() {
		if(proxy==null) {
			proxy=SalaryServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/my_salary_list.html")
	public String mylist(Model model,HttpServletRequest request,String personId) {
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"/my_salary_list");
	}

	@RequestMapping("/my_salary_dtl_list.html")
	public String mylistDtl(Model model,HttpServletRequest request,String personId) {
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"/my_salary_dtl_list");
	}


	@RequestMapping("person_list.html")
	public String personList(Model model,HttpServletRequest request,String code) {
		model.addAttribute("code",code);
		return getTemplatePath(prefix,"/person_list");
	}

	/**
	 * 人员薪酬 功能主页面
	 */
	@RequestMapping("/salary_person_list.html")
	public String personlist(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"/salary_person_list");
	}

	/**
	 * 人员薪酬 表单页面
	 */
	@RequestMapping("/salary_person_form.html")
	public String personform(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_person_form");
	}

	/**
	 * 人员薪酬 功能主页面
	 */
	@RequestMapping("/salary_51_list.html")
	public String person51list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"/salary_51_list");
	}

	/**
	 * 人员薪酬 表单页面
	 */
	@RequestMapping("/salary_51_form.html")
	public String person51form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_51_form");
	}


	/**
	 * 人员薪酬 功能主页面
	 */
	@RequestMapping("/salary_welfaer_s_list.html")
	public String welfaerlist(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"/salary_welfaer_s_list");
	}

	/**
	 * 人员薪酬 表单页面
	 */
	@RequestMapping("/salary_welfaer_s_form.html")
	public String welfaerform(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_welfaer_s_form");
	}

	/**
	 * 人员薪酬 功能主页面
	 */
	@RequestMapping("/salary_welfaer_gjj_list.html")
	public String welfaerlistGjj(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"/salary_welfaer_gjj_list");
	}


	/**
	 * 人员薪酬 表单页面
	 */
	@RequestMapping("/salary_welfaer_gjj_form.html")
	public String welfaerformGjj(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"/salary_welfaer_gjj_form");
	}


	/**
	 * 人员薪酬 表单页面
	 */
	@RequestMapping("/salary_a_form.html")
	public String aform(Model model,HttpServletRequest request,String id,String personId) {
		String tId=id;
		if(!StringUtil.isBlank(personId)){
			SalaryVO q=new SalaryVO();
			q.setPersonId(personId);
			Result<List<Salary>> res=SalaryServiceProxy.api().queryList(q);
			if(res.isSuccess()){
				if(res.getData().size()>0){
					tId=res.getData().get(0).getId();
				}
			}
		}else{
			tId=id;
		}
		model.addAttribute("id",tId);
		return getTemplatePath(prefix,"/salary_a_form");
	}
}