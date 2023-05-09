package com.dt.platform.vehicle.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.vehicle.LePositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 车辆位置模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:44:56
*/

@Controller("OaVehiclePositionPageController")
@RequestMapping(LePositionPageController.prefix)
public class LePositionPageController extends ViewController {

	public static final String prefix="business/vehicle/le_position";

	private LePositionServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public LePositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=LePositionServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 车辆位置 功能主页面
	 */
	@RequestMapping("/le_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"le_position_list");
	}

	/**
	 * 车辆位置 表单页面
	 */
	@RequestMapping("/le_position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"le_position_form");
	}
}