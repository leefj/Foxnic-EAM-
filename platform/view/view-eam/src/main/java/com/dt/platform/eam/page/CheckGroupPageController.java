package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CheckGroupServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 检查项组模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 13:58:57
*/

@Controller("EamCheckGroupPageController")
@RequestMapping(CheckGroupPageController.prefix)
public class CheckGroupPageController extends ViewController {

	public static final String prefix="business/eam/check_group";

	private CheckGroupServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CheckGroupServiceProxy proxy() {
		if(proxy==null) {
			proxy=CheckGroupServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 检查项组 功能主页面
	 */
	@RequestMapping("/check_group_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"check_group_list");
	}

	/**
	 * 检查项组 表单页面
	 */
	@RequestMapping("/check_group_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"check_group_form");
	}
}