package com.dt.platform.eam.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CheckItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 检查项模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 15:25:23
*/

@Controller("EamCheckItemPageController")
@RequestMapping(CheckItemPageController.prefix)
public class CheckItemPageController extends ViewController {

	public static final String prefix="business/eam/check_item";

	private CheckItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CheckItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=CheckItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 检查项 功能主页面
	 */
	@RequestMapping("/check_item_select_list.html")
	public String list1(Model model,HttpServletRequest request,String ownerId,String selectCode) {
		model.addAttribute("ownerId", ownerId);
		model.addAttribute("selectCode", selectCode);
		return getTemplatePath(prefix,"check_item_select_list");
	}

	@RequestMapping("/check_item_selected_list.html")
	public String list2(Model model,HttpServletRequest request,String ownerId,String selectCode,String pageType) {
		model.addAttribute("ownerId", ownerId);
		model.addAttribute("selectCode", selectCode);
		model.addAttribute("pageType", pageType);
		return getTemplatePath(prefix,"check_item_selected_list");
	}

	@RequestMapping("/check_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"check_item_list");
	}

	/**
	 * 检查项 表单页面
	 */
	@RequestMapping("/check_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"check_item_form");
	}
}