package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.ScoreUserServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 考评用户模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:36:11
*/

@Controller("HrScoreUserPageController")
@RequestMapping(ScoreUserPageController.prefix)
public class ScoreUserPageController extends ViewController {

	public static final String prefix="business/hr/score_user";

	private ScoreUserServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScoreUserServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScoreUserServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 考评用户 功能主页面
	 */
	@RequestMapping("/score_user_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"score_user_list");
	}

	/**
	 * 考评用户 表单页面
	 */
	@RequestMapping("/score_user_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"score_user_form");
	}
}