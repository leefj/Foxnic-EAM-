package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ScreenDsApiSServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * API选择模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:30:08
*/

@Controller("SysScreenDsApiSPageController")
@RequestMapping(ScreenDsApiSPageController.prefix)
public class ScreenDsApiSPageController extends ViewController {

	public static final String prefix="business/common/screen_ds_api_s";

	private ScreenDsApiSServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScreenDsApiSServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScreenDsApiSServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * API选择 功能主页面
	 */
	@RequestMapping("/screen_ds_api_s_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"screen_ds_api_s_list");
	}

	/**
	 * API选择 表单页面
	 */
	@RequestMapping("/screen_ds_api_s_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"screen_ds_api_s_form");
	}
}