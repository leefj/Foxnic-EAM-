package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.IndicatorLibServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 指标库模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 16:32:19
*/

@Controller("HrIndicatorLibPageController")
@RequestMapping(IndicatorLibPageController.prefix)
public class IndicatorLibPageController extends ViewController {

	public static final String prefix="business/hr/indicator_lib";

	private IndicatorLibServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public IndicatorLibServiceProxy proxy() {
		if(proxy==null) {
			proxy=IndicatorLibServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 指标库 功能主页面
	 */
	@RequestMapping("/indicator_lib_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"indicator_lib_list");
	}

	/**
	 * 指标库 表单页面
	 */
	@RequestMapping("/indicator_lib_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"indicator_lib_form");
	}
}