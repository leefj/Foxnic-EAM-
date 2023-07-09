package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.DemoC2ServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * demo模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-08 08:04:40
*/

@Controller("EamDemoC2PageController")
@RequestMapping(DemoC2PageController.prefix)
public class DemoC2PageController extends ViewController {

	public static final String prefix="business/eam/demo_c2";

	private DemoC2ServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DemoC2ServiceProxy proxy() {
		if(proxy==null) {
			proxy=DemoC2ServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * demo 功能主页面
	 */
	@RequestMapping("/demo_c2_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"demo_c2_list");
	}

	/**
	 * demo 表单页面
	 */
	@RequestMapping("/demo_c2_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"demo_c2_form");
	}
}