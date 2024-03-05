package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.MappingOwnerServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 归属模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-25 13:37:15
*/

@Controller("SysMappingOwnerPageController")
@RequestMapping(MappingOwnerPageController.prefix)
public class MappingOwnerPageController extends ViewController {

	public static final String prefix="business/common/mapping_owner";

	private MappingOwnerServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MappingOwnerServiceProxy proxy() {
		if(proxy==null) {
			proxy=MappingOwnerServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 归属 功能主页面
	 */
	@RequestMapping("/mapping_owner_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"mapping_owner_list");
	}

	/**
	 * 归属 表单页面
	 */
	@RequestMapping("/mapping_owner_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"mapping_owner_form");
	}
}