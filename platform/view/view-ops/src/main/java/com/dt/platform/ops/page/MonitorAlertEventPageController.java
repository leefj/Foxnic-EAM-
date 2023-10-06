package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorAlertEventServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 告警事件模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-06 09:10:57
*/

@Controller("OpsMonitorAlertEventPageController")
@RequestMapping(MonitorAlertEventPageController.prefix)
public class MonitorAlertEventPageController extends ViewController {

	public static final String prefix="business/ops/monitor_alert_event";

	private MonitorAlertEventServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MonitorAlertEventServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorAlertEventServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 告警事件 功能主页面
	 */
	@RequestMapping("/monitor_alert_event_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"monitor_alert_event_list");
	}

	/**
	 * 告警事件 表单页面
	 */
	@RequestMapping("/monitor_alert_event_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"monitor_alert_event_form");
	}
}