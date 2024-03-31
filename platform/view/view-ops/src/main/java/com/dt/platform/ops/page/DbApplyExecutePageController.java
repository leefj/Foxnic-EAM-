package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbApplyExecuteServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库操作执行模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 14:54:26
*/

@Controller("OpsDbApplyExecutePageController")
@RequestMapping(DbApplyExecutePageController.prefix)
public class DbApplyExecutePageController extends ViewController {

	public static final String prefix="business/ops/db_apply_execute";

	private DbApplyExecuteServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbApplyExecuteServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbApplyExecuteServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据库操作执行 功能主页面
	 */
	@RequestMapping("/db_apply_execute_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"db_apply_execute_list");
	}

	/**
	 * 数据库操作执行 表单页面
	 */
	@RequestMapping("/db_apply_execute_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"db_apply_execute_form");
	}
}