package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.DeviceSpTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 备件分类模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 07:49:22
*/

@Controller("EamDeviceSpTypePageController")
@RequestMapping(DeviceSpTypePageController.prefix)
public class DeviceSpTypePageController extends ViewController {

	public static final String prefix="business/eam/device_sp_type";

	private DeviceSpTypeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DeviceSpTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=DeviceSpTypeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 备件分类 功能主页面
	 */
	@RequestMapping("/device_sp_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"device_sp_type_list");
	}

	/**
	 * 备件分类 表单页面
	 */
	@RequestMapping("/device_sp_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"device_sp_type_form");
	}
}