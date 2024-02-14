package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.ScoreTplItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 评分项目模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-11 20:49:09
*/

@Controller("HrScoreTplItemPageController")
@RequestMapping(ScoreTplItemPageController.prefix)
public class ScoreTplItemPageController extends ViewController {

	public static final String prefix="business/hr/score_tpl_item";

	private ScoreTplItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScoreTplItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScoreTplItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 评分项目 功能主页面
	 */
	@RequestMapping("/score_tpl_item_list.html")
	public String list(Model model,HttpServletRequest request,String tplId) {
		model.addAttribute("tplId",tplId);
		return getTemplatePath(prefix,"score_tpl_item_list");
	}

	/**
	 * 评分项目 表单页面
	 */
	@RequestMapping("/score_tpl_item_form.html")
	public String form(Model model,HttpServletRequest request , String id,String tplId) {
		model.addAttribute("tplId",tplId);
		return getTemplatePath(prefix,"score_tpl_item_form");
	}
}