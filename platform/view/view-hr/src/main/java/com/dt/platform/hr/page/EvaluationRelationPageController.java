package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.EvaluationRelationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 评价关系模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 18:46:23
*/

@Controller("HrEvaluationRelationPageController")
@RequestMapping(EvaluationRelationPageController.prefix)
public class EvaluationRelationPageController extends ViewController {

	public static final String prefix="business/hr/evaluation_relation";

	private EvaluationRelationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public EvaluationRelationServiceProxy proxy() {
		if(proxy==null) {
			proxy=EvaluationRelationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 评价关系 功能主页面
	 */
	@RequestMapping("/evaluation_relation_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"evaluation_relation_list");
	}

	/**
	 * 评价关系 表单页面
	 */
	@RequestMapping("/evaluation_relation_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"evaluation_relation_form");
	}
}