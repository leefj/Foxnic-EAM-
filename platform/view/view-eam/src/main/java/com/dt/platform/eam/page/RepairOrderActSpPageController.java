package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairOrderActSpServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维修备件模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 15:16:56
*/

@Controller("EamRepairOrderActSpPageController")
@RequestMapping(RepairOrderActSpPageController.prefix)
public class RepairOrderActSpPageController extends ViewController {

	public static final String prefix="business/eam/repair_order_act_sp";

	private RepairOrderActSpServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RepairOrderActSpServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairOrderActSpServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 维修备件 功能主页面
	 */
	@RequestMapping("/repair_order_act_sp_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"repair_order_act_sp_list");
	}

	@RequestMapping("/repair_sp_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,
					   String ownerId,String ownerType,String selectedCode,String pageType) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("pageType",pageType);
		return getTemplatePath(prefix,"repair_sp_selected_list");
	}

	/**
	 * 维修备件 表单页面
	 */
	@RequestMapping("/repair_order_act_sp_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"repair_order_act_sp_form");
	}
}