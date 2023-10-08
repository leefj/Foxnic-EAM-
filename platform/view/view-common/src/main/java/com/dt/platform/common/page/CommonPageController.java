package com.dt.platform.common.page;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.SSOConstants;
import org.github.foxnic.web.constants.enums.system.SSOResponseFormat;
import org.github.foxnic.web.constants.enums.system.VersionType;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("CommonPageController")
@RequestMapping(CommonPageController.prefix)
public class CommonPageController extends ViewController {


	public static final String prefix="business/common/common";

	/**
	 * 主页面
	 */
	@RequestMapping("/back_to_portal.html")
	public String backToPortal(Model model,HttpServletRequest request) {

		String IN_URL= ConfigServiceProxy.api().getByCode("app.portal.IN_URL").data().getValue();
		model.addAttribute("IN_URL",IN_URL);

		String PC_IN_CAM_PORTAL_URL= ConfigServiceProxy.api().getByCode("app.portal.PC_IN_CAM_PORTAL_URL").data().getValue();
		model.addAttribute("PC_IN_CAM_PORTAL_URL",PC_IN_CAM_PORTAL_URL);

		String PC_OUT_CAM_PORTAL_URL= ConfigServiceProxy.api().getByCode("app.portal.PC_OUT_CAM_PORTAL_URL").data().getValue();
		model.addAttribute("PC_OUT_CAM_PORTAL_URL",PC_OUT_CAM_PORTAL_URL);


		return prefix+"back_to_portal.html";
	}

	@RequestMapping("/iframe.html")
	public String iframe(Model model,HttpServletRequest request,String path) {
		model.addAttribute("path",path);
		return prefix+"/iframe";
	}


	@RequestMapping("/sso_login.html")
	public String ssoLogin(Model model, HttpServletRequest request) {

		//format
		//redirect
		System.out.println("SessionUser.USER_LOGIN_JSON"+SessionUser.USER_LOGIN_JSON);
		SSOResponseFormat responseFormat= SSOResponseFormat.parseByCode(request.getParameter(SSOConstants.PARAMETER_FORMAT_NAME));
		String redirect=request.getParameter(SSOConstants.PARAMETER_REDIRECT_NAME);
		if(StringUtil.isBlank(redirect)) {
			redirect=SSOConstants.DEFAULT_SSO_REDIRECT_PAGE;
		}

		// 暂不考虑非单体应用情况
		JSONObject userLoginJson=(JSONObject) request.getAttribute(SessionUser.USER_LOGIN_JSON);
		String shortTitle= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		String versionCode= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_CODE);
		String versionName= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_NAME);
		VersionType versionType=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_VERSION_TYPE,VersionType.class);
		String fullTitle=shortTitle;

		System.out.println("versionType:"+versionType.text());


		if(versionType!=VersionType.PROD) {
			fullTitle+="("+versionName+"_"+versionCode+")";
		}

		model.addAttribute("responseFormat", responseFormat.code());
		model.addAttribute("redirect", redirect);
		model.addAttribute("shortTitle", shortTitle);
		model.addAttribute("fullTitle", fullTitle);
		model.addAttribute("userLoginJson", userLoginJson);
//		versionType:生产版
//		responseFormat:/index.html
//		redirect:/index.html
//		shortTitle:Foxnic-Web
//		fullTitle:Foxnic-Web
//		userLoginJson:null

		System.out.println("responseFormat:"+redirect);
		System.out.println("redirect:"+redirect);
		System.out.println("shortTitle:"+shortTitle);
		System.out.println("fullTitle:"+fullTitle);
		System.out.println("userLoginJson:"+userLoginJson);

		return prefix+"/sso_login";
	}


}
