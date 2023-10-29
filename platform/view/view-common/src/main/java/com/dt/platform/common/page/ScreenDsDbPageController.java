package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ScreenDsDbServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:56:45
*/

@Controller("SysScreenDsDbPageController")
@RequestMapping(ScreenDsDbPageController.prefix)
public class ScreenDsDbPageController extends ViewController {

	public static final String prefix="business/common/screen_ds_db";

	private ScreenDsDbServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScreenDsDbServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScreenDsDbServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据库 功能主页面
	 */
	@RequestMapping("/screen_ds_db_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"screen_ds_db_list");
	}

	/**
	 * 数据库 表单页面
	 */
	@RequestMapping("/screen_ds_db_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"screen_ds_db_form");
	}
}