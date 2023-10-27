package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ScreenDsDataServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据源模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-27 13:03:15
*/

@Controller("SysScreenDsDataPageController")
@RequestMapping(ScreenDsDataPageController.prefix)
public class ScreenDsDataPageController extends ViewController {

	public static final String prefix="business/common/screen_ds_data";

	private ScreenDsDataServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScreenDsDataServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScreenDsDataServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据源 功能主页面
	 */
	@RequestMapping("/screen_ds_data_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"screen_ds_data_list");
	}

	/**
	 * 数据源 表单页面
	 */
	@RequestMapping("/screen_ds_data_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"screen_ds_data_form");
	}
}