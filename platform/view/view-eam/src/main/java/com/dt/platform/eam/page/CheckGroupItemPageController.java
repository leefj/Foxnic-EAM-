package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CheckGroupItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 检查项内容模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 09:44:04
*/

@Controller("EamCheckGroupItemPageController")
@RequestMapping(CheckGroupItemPageController.prefix)
public class CheckGroupItemPageController extends ViewController {

	public static final String prefix="business/eam/check_group_item";

	private CheckGroupItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CheckGroupItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=CheckGroupItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 检查项内容 功能主页面
	 */
	@RequestMapping("/check_group_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"check_group_item_list");
	}

	/**
	 * 检查项内容 表单页面
	 */
	@RequestMapping("/check_group_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"check_group_item_form");
	}
}