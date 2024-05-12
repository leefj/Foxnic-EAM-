package com.dt.platform.common.page;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.common.PageInfo;
import com.dt.platform.domain.common.PageInfoVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.PageInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 页面开发模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-12 10:48:42
*/

@Controller("SysPageInfoPageController")
@RequestMapping(PageInfoPageController.prefix)
public class PageInfoPageController extends ViewController {

	public static final String prefix="business/common/page_info";

	private PageInfoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PageInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=PageInfoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 页面开发 功能主页面
	 */
	@RequestMapping("/ui_editor/ph-pages/index.html")
	public String page(Model model,HttpServletRequest request) {

		return getTemplatePath(prefix,"/ui_editor/ph-pages/index");
	}


	@RequestMapping("/page_info_apply.html")
	public String apply(Model model,HttpServletRequest request,String code,String id,String type) {
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("type", type);
		PageInfo info=null;
		if(!StringUtil.isBlank(code)){
			PageInfoVO infoQuery=new PageInfoVO();
			infoQuery.setCode(code);
			Result<List<PageInfo>> r= PageInfoServiceProxy.api().queryList(infoQuery);
			if(r.isSuccess() && r.getData().size()>0){
				model.addAttribute("id",  r.getData().get(0).getId());
				info=r.getData().get(0);
			}
		}
		if(info!=null){
			model.addAttribute("jsonStr", info.getDefJson());
			//model.addAttribute("json", JSONObject.parseObject(info.getDefJson()));
		}else{
			Result<PageInfo>  objRes= PageInfoServiceProxy.api().getById(id);
			if(objRes.isSuccess()&&objRes.getData()!=null){
				model.addAttribute("jsonStr",objRes.getData().getDefJson() );
			//	model.addAttribute("json", JSONObject.parseObject(objRes.getData().getDefJson()));
			}
		}
		return getTemplatePath(prefix,"page_info_apply");
	}




	/**
	 * 页面开发 功能主页面
	 */
	@RequestMapping("/page_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"page_info_list");
	}

	/**
	 * 页面开发 表单页面
	 */
	@RequestMapping("/page_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"page_info_form");
	}
}