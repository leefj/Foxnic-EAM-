package com.dt.platform.common.page;

import com.dt.platform.domain.common.Screen;
import com.dt.platform.domain.common.ScreenVO;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.ScreenServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 大屏模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:45:55
 */

@Controller("SysScreenPageController")
@RequestMapping(ScreenPageController.prefix)
public class ScreenPageController extends ViewController {

	public static final String prefix="business/common/screen";

	private ScreenServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ScreenServiceProxy proxy() {
		if(proxy==null) {
			proxy=ScreenServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/screenDashBoard.html")
	public String screenDashBoard(Model model,HttpServletRequest request,String code) {
		Screen screen=null;
		ScreenVO screenVO=new ScreenVO();
		screenVO.setCode(code);
		Result<List<Screen>> result= ScreenServiceProxy.api().queryList(screenVO);
		if(result.success()){
			if(result.getData().size()>0){
				screen=result.getData().get(0);
			}
		}
		model.addAttribute("screen",screen);
		return getTemplatePath(prefix,"screenDashBoard");
	}

	/**
	 * 大屏 功能主页面
	 */
	@RequestMapping("/screen_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"screen_list");
	}

	/**
	 * 大屏 表单页面
	 */
	@RequestMapping("/screen_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"screen_form");
	}
}