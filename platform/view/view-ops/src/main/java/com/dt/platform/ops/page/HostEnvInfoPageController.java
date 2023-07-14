package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostEnvInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 主机环境模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:34:44
*/

@Controller("OpsHostEnvInfoPageController")
@RequestMapping(HostEnvInfoPageController.prefix)
public class HostEnvInfoPageController extends ViewController {

	public static final String prefix="business/ops/host_env_info";

	private HostEnvInfoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public HostEnvInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostEnvInfoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 主机环境 功能主页面
	 */
	@RequestMapping("/host_env_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"host_env_info_list");
	}

	/**
	 * 主机环境 表单页面
	 */
	@RequestMapping("/host_env_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"host_env_info_form");
	}
}