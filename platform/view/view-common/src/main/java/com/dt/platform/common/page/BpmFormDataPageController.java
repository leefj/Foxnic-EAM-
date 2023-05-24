package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.BpmFormDataServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 流程表单模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-24 19:36:00
*/

@Controller("SysBpmFormDataPageController")
@RequestMapping(BpmFormDataPageController.prefix)
public class BpmFormDataPageController extends ViewController {

	public static final String prefix="business/common/bpm_form_data";

	private BpmFormDataServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public BpmFormDataServiceProxy proxy() {
		if(proxy==null) {
			proxy=BpmFormDataServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 流程表单 功能主页面
	 */
	@RequestMapping("/bpm_form_data_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"bpm_form_data_list");
	}

	/**
	 * 流程表单 表单页面
	 */
	@RequestMapping("/bpm_form_data_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		String code="123";
		System.out.println("code========="+code);
		model.addAttribute("code",code);
		model.addAttribute("formId","1");
		return getTemplatePath(prefix,"bpm_form_data_form");
	}
}