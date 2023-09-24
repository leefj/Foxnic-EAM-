package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskShareMeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 分享给我模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:21:06
*/

@Controller("OaNetdiskShareMePageController")
@RequestMapping(NetdiskShareMePageController.prefix)
public class NetdiskShareMePageController extends ViewController {

	public static final String prefix="business/oa/netdisk_share_me";

	private NetdiskShareMeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskShareMeServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskShareMeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 分享给我 功能主页面
	 */
	@RequestMapping("/netdisk_share_me_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_share_me_list");
	}

	/**
	 * 分享给我 表单页面
	 */
	@RequestMapping("/netdisk_share_me_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_share_me_form");
	}
}