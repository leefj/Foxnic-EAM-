package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.FormDataColServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据字段模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:45
*/

@Controller("SysFormDataColPageController")
@RequestMapping(FormDataColPageController.prefix)
public class FormDataColPageController extends ViewController {

	public static final String prefix="business/common/form_data_col";

	private FormDataColServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public FormDataColServiceProxy proxy() {
		if(proxy==null) {
			proxy=FormDataColServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据字段 功能主页面
	 */
	@RequestMapping("/form_data_col_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"form_data_col_list");
	}

	/**
	 * 数据字段 表单页面
	 */
	@RequestMapping("/form_data_col_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"form_data_col_form");
	}
}