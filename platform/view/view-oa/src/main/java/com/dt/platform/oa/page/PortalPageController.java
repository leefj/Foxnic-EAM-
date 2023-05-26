package com.dt.platform.oa.page;

import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.oa.Banner;
import com.dt.platform.domain.oa.BannerVO;
import com.dt.platform.proxy.oa.BannerServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.PortalServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 门户模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 22:13:14
*/

@Controller("OaPortalPageController")
@RequestMapping(PortalPageController.prefix)
public class PortalPageController extends ViewController {

	public static final String prefix="business/oa/portal";

	private PortalServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PortalServiceProxy proxy() {
		if(proxy==null) {
			proxy=PortalServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 门户 功能主页面
	 */
	@RequestMapping("/portal_board.html")
	public String portalList(Model model,HttpServletRequest request) {
		BannerVO q=new BannerVO();
		q.setStatus(StatusEnableEnum.ENABLE.code());
		List<Banner> list=new ArrayList<>();
		Result<List<Banner>> res=BannerServiceProxy.api().queryList(q);
		if(res.success()){
			if(res.getData()!=null&&res.getData().size()>0){
				list=res.getData();
			}
		}
		model.addAttribute("bannerList",list.toArray());
		return getTemplatePath(prefix,"portal_board");
	}

	/**
	 * 门户 功能主页面
	 */
	@RequestMapping("/portal_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"portal_list");
	}

	/**
	 * 门户 表单页面
	 */
	@RequestMapping("/portal_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"portal_form");
	}
}