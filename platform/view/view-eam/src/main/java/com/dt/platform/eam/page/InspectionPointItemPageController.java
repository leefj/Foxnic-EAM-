package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionPointItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检点项模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-06 07:50:25
*/

@Controller("EamInspectionPointItemPageController")
@RequestMapping(InspectionPointItemPageController.prefix)
public class InspectionPointItemPageController extends ViewController {

	public static final String prefix="business/eam/inspection_point_item";

	private InspectionPointItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public InspectionPointItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionPointItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 巡检点项 功能主页面
	 */
	@RequestMapping("/inspection_point_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"inspection_point_item_list");
	}

	/**
	 * 巡检点项 表单页面
	 */
	@RequestMapping("/inspection_point_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"inspection_point_item_form");
	}
}