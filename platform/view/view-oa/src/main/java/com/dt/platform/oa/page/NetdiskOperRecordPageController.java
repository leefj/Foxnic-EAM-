package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskOperRecordServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 操作记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-30 10:52:18
*/

@Controller("OaNetdiskOperRecordPageController")
@RequestMapping(NetdiskOperRecordPageController.prefix)
public class NetdiskOperRecordPageController extends ViewController {

	public static final String prefix="business/oa/netdisk_oper_record";

	private NetdiskOperRecordServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskOperRecordServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskOperRecordServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 操作记录 功能主页面
	 */
	@RequestMapping("/netdisk_oper_record_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"netdisk_oper_record_list");
	}

	/**
	 * 操作记录 表单页面
	 */
	@RequestMapping("/netdisk_oper_record_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_oper_record_form");
	}
}