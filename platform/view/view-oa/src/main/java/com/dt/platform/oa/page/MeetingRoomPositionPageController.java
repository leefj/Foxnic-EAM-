package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.MeetingRoomPositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 会议室位置模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 23:01:15
*/

@Controller("OaMeetingRoomPositionPageController")
@RequestMapping(MeetingRoomPositionPageController.prefix)
public class MeetingRoomPositionPageController extends ViewController {

	public static final String prefix="business/oa/meeting_room_position";

	private MeetingRoomPositionServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MeetingRoomPositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=MeetingRoomPositionServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 会议室位置 功能主页面
	 */
	@RequestMapping("/meeting_room_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"meeting_room_position_list");
	}

	/**
	 * 会议室位置 表单页面
	 */
	@RequestMapping("/meeting_room_position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"meeting_room_position_form");
	}
}