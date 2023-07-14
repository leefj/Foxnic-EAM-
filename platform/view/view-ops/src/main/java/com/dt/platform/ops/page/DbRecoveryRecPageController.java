package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbRecoveryRecServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库恢复模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:47:36
*/

@Controller("OpsDbRecoveryRecPageController")
@RequestMapping(DbRecoveryRecPageController.prefix)
public class DbRecoveryRecPageController extends ViewController {

	public static final String prefix="business/ops/db_recovery_rec";

	private DbRecoveryRecServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbRecoveryRecServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbRecoveryRecServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据库恢复 功能主页面
	 */
	@RequestMapping("/db_recovery_rec_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"db_recovery_rec_list");
	}

	/**
	 * 数据库恢复 表单页面
	 */
	@RequestMapping("/db_recovery_rec_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"db_recovery_rec_form");
	}
}