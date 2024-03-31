package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbApplyFileServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 附件模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-29 22:49:32
*/

@Controller("OpsDbApplyFilePageController")
@RequestMapping(DbApplyFilePageController.prefix)
public class DbApplyFilePageController extends ViewController {

	public static final String prefix="business/ops/db_apply_file";

	private DbApplyFileServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbApplyFileServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbApplyFileServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 附件 功能主页面
	 */
	@RequestMapping("/db_apply_file_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"db_apply_file_list");
	}

	/**
	 * 附件 表单页面
	 */
	@RequestMapping("/db_apply_file_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"db_apply_file_form");
	}
}