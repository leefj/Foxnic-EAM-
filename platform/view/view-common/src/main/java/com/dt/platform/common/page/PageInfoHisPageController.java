package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.PageInfoHisServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 页面历史模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-12 10:49:07
*/

@Controller("SysPageInfoHisPageController")
@RequestMapping(PageInfoHisPageController.prefix)
public class PageInfoHisPageController extends ViewController {

	public static final String prefix="business/common/page_info_his";

	private PageInfoHisServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PageInfoHisServiceProxy proxy() {
		if(proxy==null) {
			proxy=PageInfoHisServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 页面历史 功能主页面
	 */
	@RequestMapping("/page_info_his_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"page_info_his_list");
	}

	/**
	 * 页面历史 表单页面
	 */
	@RequestMapping("/page_info_his_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"page_info_his_form");
	}
}