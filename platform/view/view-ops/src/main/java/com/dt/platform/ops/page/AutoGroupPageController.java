package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoGroupServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 节点分组模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:21:32
*/

@Controller("OpsAutoGroupPageController")
@RequestMapping(AutoGroupPageController.prefix)
public class AutoGroupPageController extends ViewController {

	public static final String prefix="business/ops/auto_group";

	private AutoGroupServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AutoGroupServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoGroupServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 节点分组 功能主页面
	 */
	@RequestMapping("/auto_group_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"auto_group_list");
	}

	/**
	 * 节点分组 表单页面
	 */
	@RequestMapping("/auto_group_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"auto_group_form");
	}
}