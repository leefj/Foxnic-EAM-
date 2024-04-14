package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ProductServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 产品管理模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-07 13:01:44
*/

@Controller("IotProductPageController")
@RequestMapping(ProductPageController.prefix)
public class ProductPageController extends ViewController {

	public static final String prefix="business/eam/product";

	private ProductServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ProductServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProductServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 产品管理 功能主页面
	 */
	@RequestMapping("/product_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"product_list");
	}

	@RequestMapping("/product_model_tab.html")
	public String list(Model model,HttpServletRequest request,String productId) {
		model.addAttribute("productId",productId);
		return getTemplatePath(prefix,"product_model_tab");
	}


	/**
	 * 产品管理 表单页面
	 */
	@RequestMapping("/product_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"product_form");
	}
}