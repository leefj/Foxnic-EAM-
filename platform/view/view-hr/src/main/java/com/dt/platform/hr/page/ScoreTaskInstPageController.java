package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.ScoreTaskInstServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 任务配置记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:35:35
*/

@Controller("HrScoreTaskInstPageController")
@RequestMapping(ScoreTaskInstPageController.prefix)
public class ScoreTaskInstPageController extends ViewController {

	public static final String prefix="business/hr/score_task_inst";

	private ScoreTaskInstServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScoreTaskInstServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScoreTaskInstServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 任务配置记录 功能主页面
	 */
	@RequestMapping("/score_task_inst_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"score_task_inst_list");
	}

	/**
	 * 任务配置记录 功能主页面
	 */
	@RequestMapping("/score_task_list.html")
	public String list2(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"score_task_list");
	}

	/**
	 * 任务配置记录 表单页面
	 */
	@RequestMapping("/score_task_inst_form.html")
	public String form(Model model,HttpServletRequest request , String id,String confId) {
		model.addAttribute("confId",confId);
		return getTemplatePath(prefix,"score_task_inst_form");
	}
}