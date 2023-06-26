package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.UserImportServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 员工导入模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 14:09:13
*/

@Controller("SysUserImportPageController")
@RequestMapping(UserImportPageController.prefix)
public class UserImportPageController extends ViewController {

	public static final String prefix="business/common/user_import";

	private UserImportServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public UserImportServiceProxy proxy() {
		if(proxy==null) {
			proxy=UserImportServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/import_list.html")
	public String importList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"import_list");
	}


	/**
	 * 员工导入 功能主页面
	 */
	@RequestMapping("/user_import_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"user_import_list");
	}


	/**
	 * 员工导入 表单页面
	 */
	@RequestMapping("/user_import_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"user_import_form");
	}
}