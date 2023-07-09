package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 应用模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:38:07
*/

@Controller("SysPayAppPageController")
@RequestMapping(PayAppPageController.prefix)
public class PayAppPageController extends ViewController {

	public static final String prefix="business/common/pay_app";

	private PayAppServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PayAppServiceProxy proxy() {
		if(proxy==null) {
			proxy=PayAppServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 应用 功能主页面
	 */
	@RequestMapping("/pay_app_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"pay_app_list");
	}

	/**
	 * 应用 表单页面
	 */
	@RequestMapping("/pay_app_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"pay_app_form");
	}
}