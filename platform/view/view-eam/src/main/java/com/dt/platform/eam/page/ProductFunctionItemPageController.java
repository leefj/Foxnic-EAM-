package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ProductFunctionItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 内容模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-07 12:49:25
*/

@Controller("IotProductFunctionItemPageController")
@RequestMapping(ProductFunctionItemPageController.prefix)
public class ProductFunctionItemPageController extends ViewController {

	public static final String prefix="business/eam/product_function_item";

	private ProductFunctionItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ProductFunctionItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProductFunctionItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 内容 功能主页面
	 */
	@RequestMapping("/product_function_item_list.html")
	public String list(Model model,HttpServletRequest request,String ownerId) {
		model.addAttribute("ownerId",ownerId);
		return getTemplatePath(prefix,"product_function_item_list");
	}

	/**
	 * 内容 表单页面
	 */
	@RequestMapping("/product_function_item_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerId) {
		model.addAttribute("ownerId",ownerId);
		return getTemplatePath(prefix,"product_function_item_form");
	}
}