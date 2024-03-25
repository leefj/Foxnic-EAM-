package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.MaintainRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 保养记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-12 10:21:43
*/

@Controller("EamMaintainRcdPageController")
@RequestMapping(MaintainRcdPageController.prefix)
public class MaintainRcdPageController extends ViewController {

	public static final String prefix="business/eam/maintain_rcd";

	private MaintainRcdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MaintainRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintainRcdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 保养记录 功能主页面
	 */
	@RequestMapping("/maintain_rcd_list.html")
	public String list(Model model,HttpServletRequest request,String assetId,String source) {
		model.addAttribute("source",source);
		model.addAttribute("assetId",assetId);
		return getTemplatePath(prefix,"maintain_rcd_list");
	}

	/**
	 * 保养记录 表单页面
	 */
	@RequestMapping("/maintain_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"maintain_rcd_form");
	}
}