package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonBusiInsureServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 商业保险模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-06 21:03:04
*/

@Controller("HrPersonBusiInsurePageController")
@RequestMapping(PersonBusiInsurePageController.prefix)
public class PersonBusiInsurePageController extends ViewController {

	public static final String prefix="business/hr/person_busi_insure";

	private PersonBusiInsureServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonBusiInsureServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonBusiInsureServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 商业保险 功能主页面
	 */
	@RequestMapping("/person_busi_insure_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_busi_insure_list");
	}

	/**
	 * 商业保险 表单页面
	 */
	@RequestMapping("/person_busi_insure_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_busi_insure_form");
	}
}