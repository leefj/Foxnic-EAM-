package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbCapacityRptServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库容量模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-17 16:14:55
*/

@Controller("OpsDbCapacityRptPageController")
@RequestMapping(DbCapacityRptPageController.prefix)
public class DbCapacityRptPageController extends ViewController {

	public static final String prefix="business/ops/db_capacity_rpt";

	private DbCapacityRptServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbCapacityRptServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbCapacityRptServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据库容量 功能主页面
	 */
	@RequestMapping("/db_capacity_rpt_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"db_capacity_rpt_list");
	}

	/**
	 * 数据库容量 表单页面
	 */
	@RequestMapping("/db_capacity_rpt_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"db_capacity_rpt_form");
	}
}