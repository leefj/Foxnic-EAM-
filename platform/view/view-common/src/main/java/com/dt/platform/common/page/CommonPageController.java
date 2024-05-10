package com.dt.platform.common.page;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.common.*;
import com.dt.platform.proxy.common.ReportAclServiceProxy;
import com.dt.platform.proxy.common.ReportServiceProxy;
import com.dt.platform.proxy.common.ScreenServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.SSOConstants;
import org.github.foxnic.web.constants.enums.system.SSOResponseFormat;
import org.github.foxnic.web.constants.enums.system.VersionType;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
	public static String getClientIP(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Forwarded-For");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	@RequestMapping("/iframe_acl.html")
	public String iframeAcl(Model model,HttpServletRequest request,String code) {
		//code优先
		String result="0";
		String message="";
		String route="";
		String id="none";
		String ip="none";
		if(StringUtil.isBlank(code)){
			ReportVO vo=new ReportVO();
			vo.setCode(code);
			Result<List<Report>> res= ReportServiceProxy.api().queryList(vo);
			if(res.isSuccess()){
				List<Report> list=new ArrayList<>();
				if(list.size()==0){
					result="1";
					message="当前使用code寻找，没有找到对应的访问路径";
				}else if(list.size()>1){
					result="1";
					message="当前使用code寻找，存在相同的访问路径";
				}
				route=list.get(0).getRoute();
				id=list.get(0).getId();
				ip=getClientIP(request);
			}
		}else{
		}
		Logger.info("route:"+route+",ip:"+ip);
		model.addAttribute("message",message);
		model.addAttribute("result",result);
		model.addAttribute("path",route);
		model.addAttribute("code",code);
		model.addAttribute("ip",ip);
		model.addAttribute("id",id);
		return prefix+"/iframe_acl";
	}

	@RequestMapping("/iframe_dashboard.html")
	public String iframe2(Model model,HttpServletRequest request,String code,String path) {
		if(!StringUtil.isBlank(code)){
			ScreenVO vo=new ScreenVO();
			vo.setCode(code);
			Result<List<Screen>> res= ScreenServiceProxy.api().queryList(vo);
			if(res.isSuccess()){
				if(res.getData().size()>0){
					path="/business/common/screen/dataview/dist/index.html#/chart/preview/"+res.getData().get(0).getId();
				}
			}
		}
		model.addAttribute("code",code);
		model.addAttribute("path",path);
		return prefix+"/iframe_dashboard";
	}

	@RequestMapping("/magic_api.html")
	public String magicApi(Model model,HttpServletRequest request) {
		return prefix+"/magic_api";
		
	}

	@RequestMapping("/iframe.html")
	public String iframe(Model model,HttpServletRequest request,String code,String path,String page) {
		String result="0";
		String message="";
		String route="";
		String id="";
		String ip="";
		ip=getClientIP(request);
		if(!StringUtil.isBlank(code)){
			ReportVO vo=new ReportVO();
			vo.setCode(code);
			Result<List<Report>> res= ReportServiceProxy.api().queryList(vo);
			if(res.isSuccess()){
				List<Report> list=res.getData();
				if(list.size()==0){
					result="1";
					message="当前使用code寻找，没有找到对应的访问路径";
				}else if(list.size()>1){
					result="1";
					message="当前使用code寻找，存在相同的访问路径";
				}else{
					route=list.get(0).getRoute();
					id=list.get(0).getId();
					ip=getClientIP(request);
					ReportAclVO aclVo=new ReportAclVO();
					aclVo.setReportId(id);
					if(ReportAclServiceProxy.api().queryList(aclVo).data().size()>0){
						//如果存在ACL,则必须匹配
						ReportAclVO aclIpVo=new ReportAclVO();
						aclVo.setReportId(id);
						aclVo.setIp(ip);
						if(ReportAclServiceProxy.api().queryList(aclVo).data().size()==0){
							result="1";
							message="当前Ip:"+ip+"没有权限访问";
							route="none";
						}
					}
				}
			}
		}else{
			route=path;
			result="0";
			message="可以访问";
		}
		Logger.info("route:"+route+",ip:"+ip);
		model.addAttribute("message",message);
		model.addAttribute("result",result);
		model.addAttribute("path",route);
		model.addAttribute("ip",ip);
		model.addAttribute("id",id);
		model.addAttribute("code",code);
		model.addAttribute("page",page);
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
