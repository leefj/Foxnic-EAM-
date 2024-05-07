package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.StockInventoryAssetServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 库存资产模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-05 18:27:00
*/

@Controller("EamStockInventoryAssetPageController")
@RequestMapping(StockInventoryAssetPageController.prefix)
public class StockInventoryAssetPageController extends ViewController {

	public static final String prefix="business/eam/stock_inventory_asset";

	private StockInventoryAssetServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public StockInventoryAssetServiceProxy proxy() {
		if(proxy==null) {
			proxy=StockInventoryAssetServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 库存资产 功能主页面
	 */
	@RequestMapping("/stock_inventory_asset_list.html")
	public String list(Model model,HttpServletRequest request,String taskId) {
		model.addAttribute("taskId", taskId);
		return getTemplatePath(prefix,"stock_inventory_asset_list");
	}

	/**
	 * 库存资产 表单页面
	 */
	@RequestMapping("/stock_inventory_asset_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"stock_inventory_asset_form");
	}
}