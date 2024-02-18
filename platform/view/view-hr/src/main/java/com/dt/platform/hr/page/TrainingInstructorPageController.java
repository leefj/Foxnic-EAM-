package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.TrainingInstructorServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 培训讲师模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:15:32
*/

@Controller("HrTrainingInstructorPageController")
@RequestMapping(TrainingInstructorPageController.prefix)
public class TrainingInstructorPageController extends ViewController {

	public static final String prefix="business/hr/training_instructor";

	private TrainingInstructorServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public TrainingInstructorServiceProxy proxy() {
		if(proxy==null) {
			proxy=TrainingInstructorServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 培训讲师 功能主页面
	 */
	@RequestMapping("/training_instructor_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"training_instructor_list");
	}

	/**
	 * 培训讲师 表单页面
	 */
	@RequestMapping("/training_instructor_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"training_instructor_form");
	}
}