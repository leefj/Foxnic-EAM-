package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonTransferRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 员工调动记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:35:14
*/

@Controller("HrPersonTransferRcdPageController")
@RequestMapping(PersonTransferRcdPageController.prefix)
public class PersonTransferRcdPageController extends ViewController {

	public static final String prefix="business/hr/person_transfer_rcd";

	private PersonTransferRcdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonTransferRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonTransferRcdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 员工调动记录 功能主页面
	 */
	@RequestMapping("/person_transfer_rcd_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"person_transfer_rcd_list");
	}

	/**
	 * 员工调动记录 表单页面
	 */
	@RequestMapping("/person_transfer_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"person_transfer_rcd_form");
	}
}