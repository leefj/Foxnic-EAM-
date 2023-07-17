package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.DeviceSpStatusServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 修改状态模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 11:17:08
*/

@Controller("EamDeviceSpStatusPageController")
@RequestMapping(DeviceSpStatusPageController.prefix)
public class DeviceSpStatusPageController extends ViewController {

	public static final String prefix="business/eam/device_sp_status";

	private DeviceSpStatusServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DeviceSpStatusServiceProxy proxy() {
		if(proxy==null) {
			proxy=DeviceSpStatusServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 修改状态 功能主页面
	 */
	@RequestMapping("/device_sp_status_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"device_sp_status_list");
	}

	/**
	 * 修改状态 表单页面
	 */
	@RequestMapping("/device_sp_status_form.html")
	public String form(Model model,HttpServletRequest request , String id,String spId) {
		model.addAttribute("spId",spId);
		return getTemplatePath(prefix,"device_sp_status_form");
	}
}