package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairOrderTransferServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 工单转派模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-18 06:39:31
*/

@Controller("EamRepairOrderTransferPageController")
@RequestMapping(RepairOrderTransferPageController.prefix)
public class RepairOrderTransferPageController extends ViewController {

	public static final String prefix="business/eam/repair_order_transfer";

	private RepairOrderTransferServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RepairOrderTransferServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairOrderTransferServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 工单转派 功能主页面
	 */
	@RequestMapping("/repair_order_transfer_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"repair_order_transfer_list");
	}

	/**
	 * 工单转派 表单页面
	 */
	@RequestMapping("/repair_order_transfer_form.html")
	public String form(Model model,HttpServletRequest request , String id,String orderId) {
		model.addAttribute("orderId",orderId);
		return getTemplatePath(prefix,"repair_order_transfer_form");
	}
}