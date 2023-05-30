package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.DownloadLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 下载日志模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-28 22:03:10
*/

@Controller("OaDownloadLogPageController")
@RequestMapping(DownloadLogPageController.prefix)
public class DownloadLogPageController extends ViewController {

	public static final String prefix="business/oa/download_log";

	private DownloadLogServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DownloadLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=DownloadLogServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 下载日志 功能主页面
	 */
	@RequestMapping("/download_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"download_log_list");
	}

	/**
	 * 下载日志 表单页面
	 */
	@RequestMapping("/download_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"download_log_form");
	}
}