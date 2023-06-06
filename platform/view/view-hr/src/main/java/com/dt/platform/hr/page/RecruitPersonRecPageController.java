package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.RecruitPersonRecServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 招聘记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 09:29:49
*/

@Controller("HrRecruitPersonRecPageController")
@RequestMapping(RecruitPersonRecPageController.prefix)
public class RecruitPersonRecPageController extends ViewController {

	public static final String prefix="business/hr/recruit_person_rec";

	private RecruitPersonRecServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RecruitPersonRecServiceProxy proxy() {
		if(proxy==null) {
			proxy=RecruitPersonRecServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 招聘记录 功能主页面
	 */
	@RequestMapping("/recruit_person_rec_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"recruit_person_rec_list");
	}

	/**
	 * 招聘记录 表单页面
	 */
	@RequestMapping("/recruit_person_rec_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"recruit_person_rec_form");
	}
}