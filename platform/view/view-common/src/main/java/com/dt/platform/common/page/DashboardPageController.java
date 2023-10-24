package com.dt.platform.common.page;

import com.dt.platform.domain.common.DashboardLayer;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.DashboardServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 面板模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-22 20:42:09
*/

@Controller("SysDashboardPageController")
@RequestMapping(DashboardPageController.prefix)
public class DashboardPageController extends ViewController {

	public static final String prefix="business/common/dashboard";

	private DashboardServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DashboardServiceProxy proxy() {
		if(proxy==null) {
			proxy=DashboardServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/dashboard_show.html")
	public String list(Model model,HttpServletRequest request,String code) {
		Result<List<DashboardLayer>> res= DashboardServiceProxy.api().queryByCode(code);
		if(res.success()){
			model.addAttribute("data",res.data());
		}else{
			model.addAttribute("data",null);
		}
		return getTemplatePath(prefix,"dashboard_show");
	}
	/**
	 * 面板 功能主页面
	 */
	@RequestMapping("/dashboard_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"dashboard_list");
	}

	/**
	 * 面板 表单页面
	 */
	@RequestMapping("/dashboard_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"dashboard_form");
	}
}