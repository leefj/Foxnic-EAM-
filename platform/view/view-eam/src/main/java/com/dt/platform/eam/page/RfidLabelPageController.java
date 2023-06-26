package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RfidLabelServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * RFID标签模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 19:42:24
*/

@Controller("EamRfidLabelPageController")
@RequestMapping(RfidLabelPageController.prefix)
public class RfidLabelPageController extends ViewController {

	public static final String prefix="business/eam/rfid_label";

	private RfidLabelServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RfidLabelServiceProxy proxy() {
		if(proxy==null) {
			proxy=RfidLabelServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * RFID标签 功能主页面
	 */
	@RequestMapping("/rfid_label_list.html")
	public String list(Model model,HttpServletRequest request,String releaseId,String status) {
		model.addAttribute("releaseId",releaseId);
		model.addAttribute("status",status);
		return getTemplatePath(prefix,"rfid_label_list");
	}

	/**
	 * RFID标签 表单页面
	 */
	@RequestMapping("/rfid_label_form.html")
	public String form(Model model,HttpServletRequest request , String id,String releaseId) {
		model.addAttribute("releaseId",releaseId);
		return getTemplatePath(prefix,"rfid_label_form");
	}
}