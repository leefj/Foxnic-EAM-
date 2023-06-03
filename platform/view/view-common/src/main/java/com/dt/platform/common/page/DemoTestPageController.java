package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.DemoTestServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 测试模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:41
*/

@Controller("SysDemoTestPageController")
@RequestMapping(DemoTestPageController.prefix)
public class DemoTestPageController extends ViewController {

	public static final String prefix="business/common/demo_test";

	private DemoTestServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DemoTestServiceProxy proxy() {
		if(proxy==null) {
			proxy=DemoTestServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 测试 功能主页面
	 */
	@RequestMapping("/demo_test_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"demo_test_list");
	}

	/**
	 * 测试 表单页面
	 */
	@RequestMapping("/demo_test_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"demo_test_form");
	}
}