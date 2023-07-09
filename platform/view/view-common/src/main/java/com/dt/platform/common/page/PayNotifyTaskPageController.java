package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.PayNotifyTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 任务通知模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 14:01:11
*/

@Controller("SysPayNotifyTaskPageController")
@RequestMapping(PayNotifyTaskPageController.prefix)
public class PayNotifyTaskPageController extends ViewController {

	public static final String prefix="business/common/pay_notify_task";

	private PayNotifyTaskServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PayNotifyTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=PayNotifyTaskServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 任务通知 功能主页面
	 */
	@RequestMapping("/pay_notify_task_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"pay_notify_task_list");
	}

	/**
	 * 任务通知 表单页面
	 */
	@RequestMapping("/pay_notify_task_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"pay_notify_task_form");
	}
}