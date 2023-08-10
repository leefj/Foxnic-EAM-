package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.NetworkNatMapServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 地址映射模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 09:03:14
*/

@Controller("OpsNetworkNatMapPageController")
@RequestMapping(NetworkNatMapPageController.prefix)
public class NetworkNatMapPageController extends ViewController {

	public static final String prefix="business/ops/network_nat_map";

	private NetworkNatMapServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetworkNatMapServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetworkNatMapServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 地址映射 功能主页面
	 */
	@RequestMapping("/network_nat_map_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"network_nat_map_list");
	}

	/**
	 * 地址映射 表单页面
	 */
	@RequestMapping("/network_nat_map_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"network_nat_map_form");
	}
}