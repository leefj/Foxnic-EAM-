package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.TestServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 车辆保险公司模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:31:26
*/

@Controller("OaTestPageController")
@RequestMapping(TestPageController.prefix)
public class TestPageController extends ViewController {

	public static final String prefix="business/oa/test";

	private TestServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public TestServiceProxy proxy() {
		if(proxy==null) {
			proxy=TestServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 车辆保险公司 功能主页面
	 */
	@RequestMapping("/test_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"test_list");
	}

	/**
	 * 车辆保险公司 表单页面
	 */
	@RequestMapping("/test_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"test_form");
	}
}