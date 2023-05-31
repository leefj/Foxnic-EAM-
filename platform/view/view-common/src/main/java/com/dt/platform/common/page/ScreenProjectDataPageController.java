package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ScreenProjectDataServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 项目数据模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:10:29
*/

@Controller("SysScreenProjectDataPageController")
@RequestMapping(ScreenProjectDataPageController.prefix)
public class ScreenProjectDataPageController extends ViewController {

	public static final String prefix="business/common/screen_project_data";

	private ScreenProjectDataServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScreenProjectDataServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScreenProjectDataServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 项目数据 功能主页面
	 */
	@RequestMapping("/screen_project_data_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"screen_project_data_list");
	}

	/**
	 * 项目数据 表单页面
	 */
	@RequestMapping("/screen_project_data_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"screen_project_data_form");
	}
}