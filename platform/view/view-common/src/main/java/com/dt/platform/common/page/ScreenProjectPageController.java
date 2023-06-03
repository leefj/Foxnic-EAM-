package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ScreenProjectServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 项目模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:56:14
*/

@Controller("SysScreenProjectPageController")
@RequestMapping(ScreenProjectPageController.prefix)
public class ScreenProjectPageController extends ViewController {

	public static final String prefix="business/common/screen_project";

	private ScreenProjectServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScreenProjectServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScreenProjectServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 项目 功能主页面
	 */
	@RequestMapping("/screen_project_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"screen_project_list");
	}

	/**
	 * 项目 表单页面
	 */
	@RequestMapping("/screen_project_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"screen_project_form");
	}
}