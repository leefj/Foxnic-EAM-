package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.DashboardLayerEleServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 组件模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 06:37:05
*/

@Controller("SysDashboardLayerElePageController")
@RequestMapping(DashboardLayerElePageController.prefix)
public class DashboardLayerElePageController extends ViewController {

	public static final String prefix="business/common/dashboard_layer_ele";

	private DashboardLayerEleServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DashboardLayerEleServiceProxy proxy() {
		if(proxy==null) {
			proxy=DashboardLayerEleServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 组件 功能主页面
	 */
	@RequestMapping("/dashboard_layer_ele_list.html")
	public String list(Model model,HttpServletRequest request,String dashBoardId) {
		model.addAttribute("dashBoardId",dashBoardId);
		return getTemplatePath(prefix,"dashboard_layer_ele_list");
	}

	/**
	 * 组件 表单页面
	 */
	@RequestMapping("/dashboard_layer_ele_form.html")
	public String form(Model model,HttpServletRequest request , String id,String dashBoardId) {
		model.addAttribute("layerQueryApi","/service-common/sys-dashboard-layer/query-list?dashboardId="+dashBoardId);
		model.addAttribute("dashBoardId",dashBoardId);
		return getTemplatePath(prefix,"dashboard_layer_ele_form");
	}
}