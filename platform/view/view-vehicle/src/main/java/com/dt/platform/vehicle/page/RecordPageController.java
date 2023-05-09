package com.dt.platform.vehicle.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.vehicle.RecordServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 使用记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:47:55
*/

@Controller("OaRoomRecordPageController")
@RequestMapping(RecordPageController.prefix)
public class RecordPageController extends ViewController {

	public static final String prefix="business/vehicle/record";

	private RecordServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RecordServiceProxy proxy() {
		if(proxy==null) {
			proxy=RecordServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 使用记录 功能主页面
	 */
	@RequestMapping("/record_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"record_list");
	}

	/**
	 * 使用记录 表单页面
	 */
	@RequestMapping("/record_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"record_form");
	}
}