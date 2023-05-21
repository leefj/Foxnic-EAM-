package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.FormCategoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 表单类型模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 08:15:49
*/

@Controller("SysFormCategoryPageController")
@RequestMapping(FormCategoryPageController.prefix)
public class FormCategoryPageController extends ViewController {

	public static final String prefix="business/common/form_category";

	private FormCategoryServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public FormCategoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=FormCategoryServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 表单类型 功能主页面
	 */
	@RequestMapping("/form_category_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"form_category_list");
	}

	/**
	 * 表单类型 表单页面
	 */
	@RequestMapping("/form_category_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"form_category_form");
	}
}