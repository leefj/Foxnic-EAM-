package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.StockInventoryPlanServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 盘点计划2模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 07:52:49
*/

@Controller("EamStockInventoryPlanPageController")
@RequestMapping(StockInventoryPlanPageController.prefix)
public class StockInventoryPlanPageController extends ViewController {

	public static final String prefix="business/eam/stock_inventory_plan";

	private StockInventoryPlanServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public StockInventoryPlanServiceProxy proxy() {
		if(proxy==null) {
			proxy=StockInventoryPlanServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 盘点计划2 功能主页面
	 */
	@RequestMapping("/stock_inventory_plan_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"stock_inventory_plan_list");
	}

	/**
	 * 盘点计划2 表单页面
	 */
	@RequestMapping("/stock_inventory_plan_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"stock_inventory_plan_form");
	}
}