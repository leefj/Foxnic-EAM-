package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskVirtualFdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 虚拟文件模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 21:00:46
*/

@Controller("OaNetdiskVirtualFdPageController")
@RequestMapping(NetdiskVirtualFdPageController.prefix)
public class NetdiskVirtualFdPageController extends ViewController {

	public static final String prefix="business/oa/netdisk_virtual_fd";

	private NetdiskVirtualFdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskVirtualFdServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskVirtualFdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 虚拟文件 功能主页面
	 */
	@RequestMapping("/netdisk_virtual_fd_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_virtual_fd_list");
	}

	@RequestMapping("/upload_folder_list.html")
	public String folder(Model model,HttpServletRequest request,String fdId) {
		model.addAttribute("fdId",fdId);
		return getTemplatePath(prefix,"upload_folder_list");
	}

	@RequestMapping("/upload_file_list.html")
	public String file(Model model,HttpServletRequest request,String fdId) {
		model.addAttribute("fdId",fdId);
		return getTemplatePath(prefix,"upload_file_list");
	}


	/**
	 * 虚拟文件 表单页面
	 */
	@RequestMapping("/netdisk_virtual_fd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_virtual_fd_form");
	}
}