package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStockGoodsUseServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 库存领用模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-29 07:43:59
*/

@Controller("EamAssetStockGoodsUsePageController")
@RequestMapping(AssetStockGoodsUsePageController.prefix)
public class AssetStockGoodsUsePageController extends ViewController {

	public static final String prefix="business/eam/asset_stock_goods_use";

	private AssetStockGoodsUseServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AssetStockGoodsUseServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStockGoodsUseServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 库存领用 功能主页面
	 */
	@RequestMapping("/asset_stock_goods_use_list.html")
	public String list(Model model,HttpServletRequest request,String ownerType) {

		String operCode="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(ownerType)){
			operCode= AssetOperateEnum.EAM_ASSET_STOCK_GOODS_USE.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_USE.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_PART_GOODS_USE.code();
		}

		model.addAttribute("ownerType",ownerType);
		model.addAttribute("operType",operCode);

		return getTemplatePath(prefix,"asset_stock_goods_use_list");
	}

	/**
	 * 库存领用 表单页面
	 */
	@RequestMapping("/asset_stock_goods_use_form.html")
	public String form(Model model,HttpServletRequest request , String ownerType) {
		//只支持库存物品
		String operCode="";
		if(StringUtil.isBlank(ownerType)){
			ownerType=AssetStockGoodsTypeEnum.STOCK.code();
		}
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_STOCK_GOODS_USE.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_USE.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(ownerType)){
			operCode=AssetOperateEnum.EAM_ASSET_PART_GOODS_USE.code();
		}

		model.addAttribute("ownerType",ownerType);
		model.addAttribute("operType",operCode);
		return getTemplatePath(prefix,"asset_stock_goods_use_form");
	}
}