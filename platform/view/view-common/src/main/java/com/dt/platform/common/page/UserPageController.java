package com.dt.platform.common.page;

import com.dt.platform.proxy.common.CommonServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 车辆保险公司模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:27:10
*/

@Controller("CustUserPageController")
@RequestMapping(UserPageController.prefix)
public class UserPageController extends ViewController {

	public static final String prefix="business/common/user";

	private CommonServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CommonServiceProxy proxy() {
		if(proxy==null) {
			proxy= CommonServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 车辆保险公司 功能主页面
	 */
	@RequestMapping("/import_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"import_list");
	}


}