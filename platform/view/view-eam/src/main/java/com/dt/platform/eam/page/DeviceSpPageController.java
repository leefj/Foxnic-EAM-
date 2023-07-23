package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetAttributeItemOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetPcmCodeEnum;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.DeviceSpServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 备件清单模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:59:14
*/

@Controller("EamDeviceSpPageController")
@RequestMapping(DeviceSpPageController.prefix)
public class DeviceSpPageController extends ViewController {

	public static final String prefix="business/eam/device_sp";

	private DeviceSpServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DeviceSpServiceProxy proxy() {
		if(proxy==null) {
			proxy=DeviceSpServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/device_sp_book_tree.html")
	public String bookTree(Model model,HttpServletRequest request) {
		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_STOCK_GOODS.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		Result idResult= AssetCategoryServiceProxy.api().queryNodesByCode(AssetPcmCodeEnum.ASSET_STOCK_GOODS.code());
		model.addAttribute("categoryParentId",idResult.getData());
		return getTemplatePath(prefix,"device_sp_book_tree");
	}

	@RequestMapping("/device_sp_book_list.html")
	public String bookList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"device_sp_book_list");
	}
	/**
	 * 备件清单 功能主页面
	 */
	@RequestMapping("/device_sp_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"device_sp_list");
	}

	@RequestMapping("/device_sp_select_list.html")
	public String selectList(Model model,HttpServletRequest request, String ownerId,String ownerType,String selectedCode) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		return getTemplatePath(prefix,"device_sp_select_list");
	}

	@RequestMapping("/device_sp_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request, String ownerId,String ownerType,String selectedCode) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		return getTemplatePath(prefix,"device_sp_selected_list");
	}


	/**
	 * 备件清单 表单页面
	 */
	@RequestMapping("/device_sp_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"device_sp_form");
	}
}