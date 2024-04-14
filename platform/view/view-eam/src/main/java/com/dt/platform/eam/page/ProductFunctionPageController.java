package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ProductFunctionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 功能模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-07 12:59:57
*/

@Controller("IotProductFunctionPageController")
@RequestMapping(ProductFunctionPageController.prefix)
public class ProductFunctionPageController extends ViewController {

	public static final String prefix="business/eam/product_function";

	private ProductFunctionServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ProductFunctionServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProductFunctionServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 功能 功能主页面
	 */
	@RequestMapping("/product_function_list.html")
	public String list(Model model,HttpServletRequest request,String productId) {
		model.addAttribute("productId",productId);
		return getTemplatePath(prefix,"product_function_list");
	}

	/**
	 * 功能 表单页面
	 */
	@RequestMapping("/product_function_form.html")
	public String form(Model model,HttpServletRequest request , String id,String productId) {
		model.addAttribute("productId",productId);
		return getTemplatePath(prefix,"product_function_form");
	}
}