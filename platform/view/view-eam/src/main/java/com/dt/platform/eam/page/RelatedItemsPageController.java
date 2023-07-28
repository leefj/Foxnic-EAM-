package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RelatedItemsServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 关联项模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-27 07:24:06
*/

@Controller("EamRelatedItemsPageController")
@RequestMapping(RelatedItemsPageController.prefix)
public class RelatedItemsPageController extends ViewController {

	public static final String prefix="business/eam/related_items";

	private RelatedItemsServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RelatedItemsServiceProxy proxy() {
		if(proxy==null) {
			proxy=RelatedItemsServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 关联项 功能主页面
	 */
	@RequestMapping("/related_items_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"related_items_list");
	}

	/**
	 * 关联项 表单页面
	 */
	@RequestMapping("/related_items_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"related_items_form");
	}
}