package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.MeetingRoomServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 会议室模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 22:10:53
*/

@Controller("OaMeetingRoomPageController")
@RequestMapping(MeetingRoomPageController.prefix)
public class MeetingRoomPageController extends ViewController {

	public static final String prefix="business/oa/meeting_room";

	private MeetingRoomServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MeetingRoomServiceProxy proxy() {
		if(proxy==null) {
			proxy=MeetingRoomServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 会议室 功能主页面
	 */
	@RequestMapping("/meeting_room_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"meeting_room_list");
	}

	/**
	 * 会议室 表单页面
	 */
	@RequestMapping("/meeting_room_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"meeting_room_form");
	}
}