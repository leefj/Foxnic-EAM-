package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.FormInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 表单信息模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 09:06:11
*/

@Controller("SysFormInfoPageController")
@RequestMapping(FormInfoPageController.prefix)
public class FormInfoPageController extends ViewController {

	public static final String prefix="business/common/form_info";

	private FormInfoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public FormInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=FormInfoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 表单信息 功能主页面
	 */
	@RequestMapping("/form_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"form_info_list");
	}

	/**
	 * 表单信息 表单页面
	 */
	@RequestMapping("/form_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"form_info_form");
	}
}