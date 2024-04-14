package com.dt.platform.eam.page;

import com.dt.platform.domain.eam.Product;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ProductContentServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 设备内容模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-07 12:44:06
*/

@Controller("IotProductContentPageController")
@RequestMapping(ProductContentPageController.prefix)
public class ProductContentPageController extends ViewController {

	public static final String prefix="business/eam/product_content";

	private ProductContentServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ProductContentServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProductContentServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 设备内容 功能主页面
	 */
	@RequestMapping("/product_content_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"product_content_list");
	}


	@RequestMapping("/product_tsl_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerId,String ctType) {
		model.addAttribute("ownerId", ownerId);
		model.addAttribute("ctType", ctType);
		return getTemplatePath(prefix,"product_tsl_form");
	}

	/**
	 * 设备内容 表单页面
	 */
	@RequestMapping("/product_content_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"product_content_form");
	}
}

