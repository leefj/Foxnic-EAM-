package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.EquipmentLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 设备日志模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-07 12:41:36
*/

@Controller("IotEquipmentLogPageController")
@RequestMapping(EquipmentLogPageController.prefix)
public class EquipmentLogPageController extends ViewController {

	public static final String prefix="business/eam/equipment_log";

	private EquipmentLogServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public EquipmentLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=EquipmentLogServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 设备日志 功能主页面
	 */
	@RequestMapping("/equipment_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"equipment_log_list");
	}

	/**
	 * 设备日志 表单页面
	 */
	@RequestMapping("/equipment_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"equipment_log_form");
	}
}