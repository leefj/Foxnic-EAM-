package com.dt.platform.hr.page;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonContractServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员合同模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-18 12:48:13
*/

@Controller("HrPersonContractPageController")
@RequestMapping(PersonContractPageController.prefix)
public class PersonContractPageController extends ViewController {

	public static final String prefix="business/hr/person_contract";

	private PersonContractServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonContractServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonContractServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 人员合同 功能主页面
	 */
	@RequestMapping("/person_contract_list.html")
	public String list(Model model,HttpServletRequest request,String personId) {
		if(!StringUtil.isBlank(personId)){
			model.addAttribute("personId",personId);
		}
		return getTemplatePath(prefix,"person_contract_list");
	}


	/**
	 * 人员合同 功能主页面
	 */
	@RequestMapping("/jc_contract_list.html")
	public String jc_contract_list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"jc_contract_list");
	}

	@RequestMapping("/try_contract_list.html")
	public String try_contract_list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"try_contract_list");
	}

	@RequestMapping("/xq_contract_list.html")
	public String xq_contract_list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"xq_contract_list");
	}

	@RequestMapping("/zz_contract_list.html")
	public String zz_contract_list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"zz_contract_list");
	}


	/**
	 * 人员合同 功能主页面
	 */
	@RequestMapping("/person_list.html")
	public String list2(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_list");
	}


	/**
	 * 人员合同 功能主页面
	 */
	@RequestMapping("/person_tree.html")
	public String tree(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_tree");
	}



	/**
	 * 人员合同 表单页面
	 */
	@RequestMapping("/person_contract_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_contract_form");
	}
}