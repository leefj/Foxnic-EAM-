package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NoticeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 通知公告模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-10 19:29:44
*/

@Controller("OaNoticePageController")
@RequestMapping(NoticePageController.prefix)
public class NoticePageController extends ViewController {

	public static final String prefix="business/oa/notice";

	private NoticeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NoticeServiceProxy proxy() {
		if(proxy==null) {
			proxy=NoticeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 通知公告 功能主页面
	 */
	@RequestMapping("/notice_list.html")
	public String list(Model model,HttpServletRequest request) {


		return getTemplatePath(prefix,"notice_list");
	}


	/**
	 * 通知公告 功能主页面
	 */
	@RequestMapping("/notice_view.html")
	public String listView(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return getTemplatePath(prefix,"notice_view");
	}

	/**
	 * 通知公告 功能主页面
	 */
	@RequestMapping("/notice_list_public.html")
	public String listPublic(Model model,HttpServletRequest request,String type) {

		model.addAttribute("type",type);
		return getTemplatePath(prefix,"notice_list_public");
	}



	/**
	 * 通知公告 表单页面
	 */
	@RequestMapping("/notice_form.html")
	public String form(Model model,HttpServletRequest request , String id) {

		return getTemplatePath(prefix,"notice_form");
	}
}