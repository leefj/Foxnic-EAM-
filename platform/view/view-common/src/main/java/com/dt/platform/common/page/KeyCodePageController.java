package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.KeyCodeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 菜单键值模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 09:50:22
*/

@Controller("SysKeyCodePageController")
@RequestMapping(KeyCodePageController.prefix)
public class KeyCodePageController extends ViewController {

	public static final String prefix="business/common/key_code";

	private KeyCodeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public KeyCodeServiceProxy proxy() {
		if(proxy==null) {
			proxy=KeyCodeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 菜单键值 功能主页面
	 */
	@RequestMapping("/key_code_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"key_code_list");
	}

	/**
	 * 菜单键值 表单页面
	 */
	@RequestMapping("/key_code_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"key_code_form");
	}
}