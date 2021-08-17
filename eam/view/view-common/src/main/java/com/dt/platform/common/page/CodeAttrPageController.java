package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.CodeAttrServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 编码属性 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-17 16:25:12
*/

@Controller("SysCodeAttrPageController")
@RequestMapping(CodeAttrPageController.prefix)
public class CodeAttrPageController extends ViewController {
	
	public static final String prefix="business/common/code_attr";

	private CodeAttrServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodeAttrServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodeAttrServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 编码属性 功能主页面
	 */
	@RequestMapping("/code_attr_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_attr_list";
	}

	/**
	 * 编码属性 表单页面
	 */
	@RequestMapping("/code_attr_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/code_attr_form";
	}
}