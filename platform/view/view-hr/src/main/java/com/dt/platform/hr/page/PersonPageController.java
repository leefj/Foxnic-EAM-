package com.dt.platform.hr.page;

import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 人员信息模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-02 15:28:03
*/

@Controller("HrPersonPageController")
@RequestMapping(PersonPageController.prefix)
public class PersonPageController extends ViewController {

	public static final String prefix="business/hr/person";

	private PersonServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 人员信息 功能主页面
	 */
	@RequestMapping("/person_search_list.html")
	public String searchList(Model model,HttpServletRequest request,String code) {
		model.addAttribute("code",code);
		return getTemplatePath(prefix,"person_search_list");
	}

	/**
	 * 人员信息 功能主页面
	 */
	@RequestMapping("/my_info.html")
	public String myInfo(Model model,HttpServletRequest request) {
		String employId=SessionUser.getCurrent().getActivatedEmployeeId();
		String personId="none";
		PersonVO vo=new PersonVO();
		vo.setEmployeeId(employId);
		Result<List<Person>> listRes=PersonServiceProxy.api().queryList(vo);
		if(listRes.success()&&listRes.data().size()>0){
			personId=listRes.data().get(0).getId();
		}
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"my_info");
	}

	/**
	 * 人员信息 功能主页面
	 */
	@RequestMapping("/person_file_not_list.html")
	public String fileNotList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_file_not_list");
	}

	/**
	 * 人员信息
	 */
	@RequestMapping("/person_dashboard.html")
	public String dashboard(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_dashboard");
	}


	/**
	 * 人员信息 功能主页面
	 */
	@RequestMapping("/person_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_list");
	}

	/**
	 * 人员信息 表单页面
	 */
	@RequestMapping("/person_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_form");
	}

	/**
	 * 人员信息 表单页面
	 */
	@RequestMapping("/person_a_form.html")
	public String aform(Model model,HttpServletRequest request , String personId,String role) {
		model.addAttribute("role",role);
		model.addAttribute("personId",personId);
		return getTemplatePath(prefix,"person_a_form");
	}

	/**
	 * 人员信息 表单页面
	 */
	@RequestMapping("/person_info.html")
	public String infoForm(Model model,HttpServletRequest request,String role,String personId) {
		//role view,admin
		if("self".equals(personId)){
			role="view";
			model.addAttribute("employeeId",SessionUser.getCurrent().getActivatedCompanyId());
			personId=PersonServiceProxy.api().queryPersonIdByEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
			if(StringUtil.isBlank(personId)){
				personId="";
			}
			model.addAttribute("personId",personId);
		}else if("".equals(role)){
			model.addAttribute("personId",personId);
		}

		model.addAttribute("role",role);
		String personSocialRelationUrl="/business/hr/person_social_relation/person_social_relation_a_list.html?role="+role+"&personId="+personId;
		String personCertificateUrl="/business/hr/person_certificate/person_certificate_a_list.html?role="+role+"&personId="+personId;
		String personWorkUrl="/business/hr/person_work_experience/person_work_experience_a_list.html?role="+role+"&personId="+personId;
		String personEducationUrl="/business/hr/person_education/person_education_a_list.html?role="+role+"&personId="+personId;
		String baseInfoUrl="/business/hr/person/person_a_form.html?role="+role+"&personId="+personId;
		String salaryUrl="/business/hr/salary/salary_a_form.html?role="+role+"&personId="+personId;

		model.addAttribute("salaryUrl",salaryUrl);
		model.addAttribute("baseInfoUrl",baseInfoUrl);
		model.addAttribute("personEducationUrl",personEducationUrl);
		model.addAttribute("personWorkUrl",personWorkUrl);
		model.addAttribute("personCertificateUrl",personCertificateUrl);
		model.addAttribute("personSocialRelationUrl",personSocialRelationUrl);
		return getTemplatePath(prefix,"person_info");
	}

}

