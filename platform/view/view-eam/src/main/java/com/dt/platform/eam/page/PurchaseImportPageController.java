package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.PurchaseImportServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 采购单导入模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-25 20:43:44
*/

@Controller("EamPurchaseImportPageController")
@RequestMapping(PurchaseImportPageController.prefix)
public class PurchaseImportPageController extends ViewController {

	public static final String prefix="business/eam/purchase_import";

	private PurchaseImportServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PurchaseImportServiceProxy proxy() {
		if(proxy==null) {
			proxy=PurchaseImportServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 采购单导入 功能主页面
	 */
	@RequestMapping("/purchase_import_list.html")
	public String list(Model model,HttpServletRequest request,String importType) {
		model.addAttribute("importType",importType);
		return getTemplatePath(prefix,"purchase_import_list");
	}

	@RequestMapping("/import_asset_list.html")
	public String importList(Model model,HttpServletRequest request,String importId,String pageType) {
		model.addAttribute("importId",importId);
		model.addAttribute("pageType",pageType);
		return getTemplatePath(prefix,"import_asset_list");
	}

	/**
	 * 采购单导入 表单页面
	 */
	@RequestMapping("/purchase_import_form.html")
	public String form(Model model,HttpServletRequest request , String id,String importType) {
		model.addAttribute("importType",importType);
		return getTemplatePath(prefix,"purchase_import_form");
	}
}