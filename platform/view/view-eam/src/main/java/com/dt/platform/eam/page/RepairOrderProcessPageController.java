package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairOrderProcessServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 流转过程模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-04 06:54:32
*/

@Controller("EamRepairOrderProcessPageController")
@RequestMapping(RepairOrderProcessPageController.prefix)
public class RepairOrderProcessPageController extends ViewController {

	public static final String prefix="business/eam/repair_order_process";

	private RepairOrderProcessServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RepairOrderProcessServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairOrderProcessServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 流转过程 功能主页面
	 */
	@RequestMapping("/repair_order_process_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"repair_order_process_list");
	}

	/**
	 * 流转过程 表单页面
	 */
	@RequestMapping("/repair_order_process_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"repair_order_process_form");
	}
}