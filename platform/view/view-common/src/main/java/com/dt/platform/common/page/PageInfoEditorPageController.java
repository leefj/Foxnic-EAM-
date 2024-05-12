package com.dt.platform.common.page;

import com.dt.platform.proxy.common.PageInfoServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 页面开发模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-12 10:48:42
*/

@Controller("SysPageInfoEditorPageController")
@RequestMapping(PageInfoEditorPageController.prefix)
public class PageInfoEditorPageController extends ViewController {

	public static final String prefix="business/common/page_ui_editor";

	private PageInfoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PageInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=PageInfoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 页面开发 功能主页面
	 */
	@RequestMapping("/ph_pages/index.html")
	public String page(Model model,HttpServletRequest request) {

		return getTemplatePath(prefix,"/ph_pages/index");
	}

}