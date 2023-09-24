package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskStorageServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 存储方式模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:21:10
*/

@Controller("OaNetdiskStoragePageController")
@RequestMapping(NetdiskStoragePageController.prefix)
public class NetdiskStoragePageController extends ViewController {

	public static final String prefix="business/oa/netdisk_storage";

	private NetdiskStorageServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskStorageServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskStorageServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 存储方式 功能主页面
	 */
	@RequestMapping("/netdisk_storage_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_storage_list");
	}

	/**
	 * 存储方式 表单页面
	 */
	@RequestMapping("/netdisk_storage_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_storage_form");
	}
}