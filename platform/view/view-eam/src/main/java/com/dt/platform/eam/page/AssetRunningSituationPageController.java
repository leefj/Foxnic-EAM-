package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetRunningSituationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 运行情况模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-11 19:57:54
*/

@Controller("EamAssetRunningSituationPageController")
@RequestMapping(AssetRunningSituationPageController.prefix)
public class AssetRunningSituationPageController extends ViewController {

	public static final String prefix="business/eam/asset_running_situation";

	private AssetRunningSituationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssetRunningSituationServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetRunningSituationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 运行情况 功能主页面
	 */
	@RequestMapping("/asset_running_situation_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"asset_running_situation_list");
	}

	/**
	 * 运行情况 表单页面
	 */
	@RequestMapping("/asset_running_situation_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"asset_running_situation_form");
	}
}