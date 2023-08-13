package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维修记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-12 10:19:51
*/

@Controller("EamRepairRcdPageController")
@RequestMapping(RepairRcdPageController.prefix)
public class RepairRcdPageController extends ViewController {

	public static final String prefix="business/eam/repair_rcd";

	private RepairRcdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RepairRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairRcdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 维修记录 功能主页面
	 */
	@RequestMapping("/repair_rcd_list.html")
	public String list(Model model,HttpServletRequest request,String assetId) {
		model.addAttribute("assetId",assetId);
		return getTemplatePath(prefix,"repair_rcd_list");
	}

	/**
	 * 维修记录 表单页面
	 */
	@RequestMapping("/repair_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"repair_rcd_form");
	}
}