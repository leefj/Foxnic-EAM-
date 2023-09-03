package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoTaskLogDtlServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 明细日志模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:48:22
*/

@Controller("OpsAutoTaskLogDtlPageController")
@RequestMapping(AutoTaskLogDtlPageController.prefix)
public class AutoTaskLogDtlPageController extends ViewController {

	public static final String prefix="business/ops/auto_task_log_dtl";

	private AutoTaskLogDtlServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AutoTaskLogDtlServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoTaskLogDtlServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 明细日志 功能主页面
	 */
	@RequestMapping("/auto_task_log_dtl_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"auto_task_log_dtl_list");
	}

	/**
	 * 明细日志 表单页面
	 */
	@RequestMapping("/auto_task_log_dtl_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"auto_task_log_dtl_form");
	}
}