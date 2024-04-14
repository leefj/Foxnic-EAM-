package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.VirtEquipmentServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 虚拟设备模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-06 19:37:43
*/

@Controller("IotVirtEquipmentPageController")
@RequestMapping(VirtEquipmentPageController.prefix)
public class VirtEquipmentPageController extends ViewController {

	public static final String prefix="business/eam/virt_equipment";

	private VirtEquipmentServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public VirtEquipmentServiceProxy proxy() {
		if(proxy==null) {
			proxy=VirtEquipmentServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 虚拟设备 功能主页面
	 */
	@RequestMapping("/virt_equipment_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"virt_equipment_list");
	}

	/**
	 * 虚拟设备 表单页面
	 */
	@RequestMapping("/virt_equipment_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"virt_equipment_form");
	}
}