package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonFileOutServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 档案调出模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 08:57:33
*/

@Controller("HrPersonFileOutPageController")
@RequestMapping(PersonFileOutPageController.prefix)
public class PersonFileOutPageController extends ViewController {

	public static final String prefix="business/hr/person_file_out";

	private PersonFileOutServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonFileOutServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonFileOutServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 档案调出 功能主页面
	 */
	@RequestMapping("/person_file_out_list.html")
	public String list(Model model,HttpServletRequest request,String fileId) {
		model.addAttribute("fileId",fileId);
		return getTemplatePath(prefix,"person_file_out_list");
	}

	/**
	 * 档案调出 表单页面
	 */
	@RequestMapping("/person_file_out_form.html")
	public String form(Model model,HttpServletRequest request , String id,String fileId) {
		model.addAttribute("fileId",fileId);
		return getTemplatePath(prefix,"person_file_out_form");
	}
}