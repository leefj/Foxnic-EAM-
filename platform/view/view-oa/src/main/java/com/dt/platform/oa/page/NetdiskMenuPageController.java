package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskMenuServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 网盘菜单模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-17 17:52:47
*/

@Controller("OaNetdiskMenuPageController")
@RequestMapping(NetdiskMenuPageController.prefix)
public class NetdiskMenuPageController extends ViewController {

	public static final String prefix="business/oa/netdisk_menu";

	private NetdiskMenuServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskMenuServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskMenuServiceProxy.api();
		}
		return proxy;
	}


	/**
	 * 网盘菜单 功能主页面
	 */
	@RequestMapping("/netdisk_myspace_list.html")
	public String myspaceList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_myspace_list");
	}

	/**
	 * 网盘菜单 功能主页面
	 */
	@RequestMapping("/netdisk_recycle_list.html")
	public String recycleList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_recycle_list");
	}


	/**
	 * 网盘菜单 功能主页面
	 */
	@RequestMapping("/netdisk_list.html")
	public String netdiskList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_list");
	}

	/**
	 * 网盘菜单 功能主页面
	 */
	@RequestMapping("/netdisk_menu_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_menu_list");
	}

	/**
	 * 网盘菜单 表单页面
	 */
	@RequestMapping("/netdisk_menu_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_menu_form");
	}

}