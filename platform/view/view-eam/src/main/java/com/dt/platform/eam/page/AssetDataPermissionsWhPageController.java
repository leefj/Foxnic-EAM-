package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetDataPermissionsWhServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 仓库模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-26 07:46:41
*/

@Controller("EamAssetDataPermissionsWhPageController")
@RequestMapping(AssetDataPermissionsWhPageController.prefix)
public class AssetDataPermissionsWhPageController extends ViewController {

	public static final String prefix="business/eam/asset_data_permissions_wh";

	private AssetDataPermissionsWhServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssetDataPermissionsWhServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDataPermissionsWhServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 仓库 功能主页面
	 */
	@RequestMapping("/asset_data_permissions_wh_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"asset_data_permissions_wh_list");
	}

	/**
	 * 仓库 表单页面
	 */
	@RequestMapping("/asset_data_permissions_wh_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"asset_data_permissions_wh_form");
	}
}