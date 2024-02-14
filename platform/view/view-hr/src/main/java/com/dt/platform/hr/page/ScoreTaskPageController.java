package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.ScoreTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 任务单模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:01:41
*/

@Controller("HrScoreTaskPageController")
@RequestMapping(ScoreTaskPageController.prefix)
public class ScoreTaskPageController extends ViewController {

	public static final String prefix="business/hr/score_task";

	private ScoreTaskServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScoreTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScoreTaskServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 任务单 功能主页面
	 */
	@RequestMapping("/score_task_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"score_task_list");
	}

	/**
	 * 任务单 表单页面
	 */
	@RequestMapping("/score_task_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"score_task_form");
	}
}