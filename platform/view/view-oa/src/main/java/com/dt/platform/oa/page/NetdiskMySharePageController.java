package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskMyShareServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 我的分享模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:20:32
*/

@Controller("OaNetdiskMySharePageController")
@RequestMapping(NetdiskMySharePageController.prefix)
public class NetdiskMySharePageController extends ViewController {

	public static final String prefix="business/oa/netdisk_my_share";

	private NetdiskMyShareServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskMyShareServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskMyShareServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 我的分享 功能主页面
	 */
	@RequestMapping("/netdisk_share_member_list.html")
	public String memberList(Model model,HttpServletRequest request,String shareId,String fdId) {
		model.addAttribute("shareId",shareId);
		model.addAttribute("fdId",fdId);
		return getTemplatePath(prefix,"netdisk_share_member_list");
	}


	/**
	 * 我的分享 功能主页面
	 */
	@RequestMapping("/netdisk_my_share_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_my_share_list");
	}

	/**
	 * 我的分享 表单页面
	 */
	@RequestMapping("/netdisk_my_share_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_my_share_form");
	}
}