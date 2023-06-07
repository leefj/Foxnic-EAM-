package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbDocServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库文档模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-07 19:53:57
*/

@Controller("OpsDbDocPageController")
@RequestMapping(DbDocPageController.prefix)
public class DbDocPageController extends ViewController {

	public static final String prefix="business/ops/db_doc";

	private DbDocServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbDocServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbDocServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据库文档 功能主页面
	 */
	@RequestMapping("/db_doc_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"db_doc_list");
	}

	/**
	 * 数据库文档 表单页面
	 */
	@RequestMapping("/db_doc_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"db_doc_form");
	}
}