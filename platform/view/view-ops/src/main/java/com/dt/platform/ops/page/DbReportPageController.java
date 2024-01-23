package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbReportServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 性能报模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-23 11:34:08
*/

@Controller("OpsDbReportPageController")
@RequestMapping(DbReportPageController.prefix)
public class DbReportPageController extends ViewController {

	public static final String prefix="business/ops/db_report";

	private DbReportServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbReportServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbReportServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 性能报 功能主页面
	 */
	@RequestMapping("/db_report_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"db_report_list");
	}

	/**
	 * 性能报 表单页面
	 */
	@RequestMapping("/db_report_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"db_report_form");
	}
}