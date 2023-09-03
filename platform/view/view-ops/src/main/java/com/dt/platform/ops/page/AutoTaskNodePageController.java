package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoTaskNodeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 作业节点模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:23:01
*/

@Controller("OpsAutoTaskNodePageController")
@RequestMapping(AutoTaskNodePageController.prefix)
public class AutoTaskNodePageController extends ViewController {

	public static final String prefix="business/ops/auto_task_node";

	private AutoTaskNodeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AutoTaskNodeServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoTaskNodeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 作业节点 功能主页面
	 */
	@RequestMapping("/auto_task_node_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"auto_task_node_list");
	}

	/**
	 * 作业节点 表单页面
	 */
	@RequestMapping("/auto_task_node_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"auto_task_node_form");
	}
}