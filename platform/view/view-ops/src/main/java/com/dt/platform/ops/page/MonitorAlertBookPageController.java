package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorAlertBookServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 告警订阅模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 17:54:02
*/

@Controller("OpsMonitorAlertBookPageController")
@RequestMapping(MonitorAlertBookPageController.prefix)
public class MonitorAlertBookPageController extends ViewController {

	public static final String prefix="business/ops/monitor_alert_book";

	private MonitorAlertBookServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MonitorAlertBookServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorAlertBookServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 告警订阅 功能主页面
	 */
	@RequestMapping("/monitor_alert_book_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"monitor_alert_book_list");
	}

	/**
	 * 告警订阅 表单页面
	 */
	@RequestMapping("/monitor_alert_book_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"monitor_alert_book_form");
	}
}