package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.MeetingRoomBookRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 会议室预定模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 21:40:42
*/

@Controller("OaMeetingRoomBookRcdPageController")
@RequestMapping(MeetingRoomBookRcdPageController.prefix)
public class MeetingRoomBookRcdPageController extends ViewController {

	public static final String prefix="business/oa/meeting_room_book_rcd";

	private MeetingRoomBookRcdServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MeetingRoomBookRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=MeetingRoomBookRcdServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 会议室预定 功能主页面
	 */
	@RequestMapping("/meeting_room_book_rcd_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"meeting_room_book_rcd_list");
	}

	/**
	 * 会议室预定 功能主页面
	 */
	@RequestMapping("/meeting_room_book_dashboard.html")
	public String dashboard(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"meeting_room_book_dashboard");
	}

	/**
	 * 会议室预定 表单页面
	 */
	@RequestMapping("/meeting_room_book_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"meeting_room_book_rcd_form");
	}
}