package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ReportServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 报表列模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-19 11:53:25
*/

@Controller("SysReportPageController")
@RequestMapping(ReportPageController.prefix)
public class ReportPageController extends ViewController {

	public static final String prefix="business/common/report";

	private ReportServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ReportServiceProxy proxy() {
		if(proxy==null) {
			proxy=ReportServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 报表列 功能主页面
	 */
	@RequestMapping("/report_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"report_list");
	}

	@RequestMapping("/report_designer.html")
	public String designer(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"report_designer");
	}


	/**
	 * 报表列 表单页面
	 */
	@RequestMapping("/report_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"report_form");
	}
}