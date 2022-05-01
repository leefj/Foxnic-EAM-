package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStockGoodsInServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 库存物品单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 08:49:01
*/

@Controller("EamAssetStockGoodsInPageController")
@RequestMapping(AssetStockGoodsInPageController.prefix)
public class AssetStockGoodsInPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_stock_goods_in";

	private AssetStockGoodsInServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetStockGoodsInServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStockGoodsInServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 库存物品单 功能主页面
	 */
	@RequestMapping("/asset_stock_goods_in_list.html")
	public String list(Model model,HttpServletRequest request,String ownerType) {


		String operCode="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_STOCK_GOODS_IN.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_PART_GOODS_IN.code();
		}

		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(operCode);
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("operType",operCode);
		return prefix+"/asset_stock_goods_in_list";
	}

	/**
	 * 库存物品单 表单页面
	 */
	@RequestMapping("/asset_stock_goods_in_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerType,String operType) {

		model.addAttribute("ownerType",ownerType);
		model.addAttribute("operType",operType);
		return prefix+"/asset_stock_goods_in_form";
	}
}