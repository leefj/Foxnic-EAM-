package com.dt.platform.hr.page;

import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonVO;
import com.github.foxnic.api.transter.Result;
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
}