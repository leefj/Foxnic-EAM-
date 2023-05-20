package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ReportUDefServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 报表定义模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-20 20:46:53
*/

@Controller("SysReportUDefPageController")
@RequestMapping(ReportUDefPageController.prefix)
public class ReportUDefPageController extends ViewController {

	public static final String prefix="business/common/report_u_def";

	private ReportUDefServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ReportUDefServiceProxy proxy() {
		if(proxy==null) {
			proxy=ReportUDefServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 报表定义 功能主页面
	 */
	@RequestMapping("/report_u_def_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"report_u_def_list");
	}

	/**
	 * 报表定义 表单页面
	 */
	@RequestMapping("/report_u_def_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"report_u_def_form");
	}
}