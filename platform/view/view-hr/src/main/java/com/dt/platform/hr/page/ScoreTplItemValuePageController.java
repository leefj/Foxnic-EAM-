package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.ScoreTplItemValueServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 评分明细模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-11 23:55:07
*/

@Controller("HrScoreTplItemValuePageController")
@RequestMapping(ScoreTplItemValuePageController.prefix)
public class ScoreTplItemValuePageController extends ViewController {

	public static final String prefix="business/hr/score_tpl_item_value";

	private ScoreTplItemValueServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScoreTplItemValueServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScoreTplItemValueServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 评分明细 功能主页面
	 */
	@RequestMapping("/score_tpl_item_value_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"score_tpl_item_value_list");
	}

	/**
	 * 评分明细 表单页面
	 */
	@RequestMapping("/score_tpl_item_value_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"score_tpl_item_value_form");
	}
}