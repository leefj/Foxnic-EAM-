package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.StockInventoryTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 盘点任务2模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 08:33:49
*/

@Controller("EamStockInventoryTaskPageController")
@RequestMapping(StockInventoryTaskPageController.prefix)
public class StockInventoryTaskPageController extends ViewController {

	public static final String prefix="business/eam/stock_inventory_task";

	private StockInventoryTaskServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public StockInventoryTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=StockInventoryTaskServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 盘点任务2 功能主页面
	 */
	@RequestMapping("/stock_asset_list.html")
	public String assetList(Model model,HttpServletRequest request,String taskId) {
		model.addAttribute("taskId", taskId);
		return getTemplatePath(prefix,"stock_asset_list.html");
	}

	/**
	 * 盘点任务2 功能主页面
	 */
	@RequestMapping("/stock_inventory_task_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode,String planId) {
		model.addAttribute("ownerCode", request.getParameter("ownerCode"));
		model.addAttribute("planId", request.getParameter("planId"));
		return getTemplatePath(prefix,"stock_inventory_task_list");
	}

	/**
	 * 盘点任务2 表单页面
	 */
	@RequestMapping("/stock_inventory_task_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerCode,String planId) {
		model.addAttribute("ownerCode", request.getParameter("ownerCode"));
		model.addAttribute("planId", request.getParameter("planId"));
		return getTemplatePath(prefix,"stock_inventory_task_form");
	}
}