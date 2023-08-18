package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.proxy.bpm.ProcessInstanceServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 资产报废 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:04:21
*/

@Controller("EamAssetScrapPageController")
@RequestMapping(AssetScrapPageController.prefix)
public class AssetScrapPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_scrap";

	private AssetScrapServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetScrapServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetScrapServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产报废 功能主页面
	 */
	@RequestMapping("/asset_scrap_list.html")
	public String list(Model model,HttpServletRequest request,String status) {
		boolean approvalRequired=true;
//		Result approvalResult=OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_SCRAP.code());
//		if(approvalResult.isSuccess()){
//			approvalRequired= (boolean) approvalResult.getData();
//		}
		model.addAttribute("status",status);
		model.addAttribute("approvalRequired",approvalRequired);
		return prefix+"/asset_scrap_list";
	}

	@RequestMapping("/scrap_tab_list.html")
	public String tabList(Model model,HttpServletRequest request) {
		return prefix+"/scrap_tab_list";
	}

	/**
	 * 资产报废 表单页面
	 */
	@RequestMapping("/asset_scrap_form.html")
	public String form(Model model,HttpServletRequest request , String id,String processId) {

		ProcessInstance instanceData=null;
		model.addAttribute("billType", AssetOperateEnum.EAM_ASSET_SCRAP.code());
		//打印流程数据
		if(!StringUtil.isBlank(processId)){
			Result<ProcessInstance> res= ProcessInstanceServiceProxy.api().getById(processId);
			List<String> billList=res.getData().getBillIds();
			model.addAttribute("billId",billList.get(0));
			model.addAttribute("instanceData",res.getData());
		}

		return prefix+"/asset_scrap_form";
	}
}