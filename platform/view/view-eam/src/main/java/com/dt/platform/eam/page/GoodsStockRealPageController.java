package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetStockGoodsOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.constants.enums.eam.AssetStockTypeEnum;
import com.dt.platform.proxy.eam.GoodsStockServiceProxy;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 库存物品 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 20:41:09
*/

@Controller("GoodsStockRealPageController")
@RequestMapping(GoodsStockRealPageController.prefix)
public class GoodsStockRealPageController extends ViewController {
	
	public static final String prefix="business/eam/goods_stock_real";

	private GoodsStockServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public GoodsStockServiceProxy proxy() {
		if(proxy==null) {
			proxy=GoodsStockServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/stock_real_form.html")
	public String bookForm(Model model,HttpServletRequest request,String ownerCode,String id) {
		model.addAttribute("ownerCode", ownerCode);
		model.addAttribute("id", id);
		return prefix+"/stock_real_form";
	}

	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_list.html")
	public String list(Model model,HttpServletRequest request,String ownerType) {

		String ownerCode="blank";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(ownerType)){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_STOCK.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(ownerType)){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_CONSUMABLES.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(ownerType)){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_PART.code();
		}
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("ownerCode",ownerCode);

		return prefix+"/goods_stock_list";
	}

	@RequestMapping("/goods_in_dtl_list.html")
	public String inList(Model model,HttpServletRequest request,String ownerType,String ownerCode) {
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/goods_in_dtl_list";
	}

	@RequestMapping("/goods_stock_rel.html")
	public String relList(Model model,HttpServletRequest request,String ownerType,String ownerCode,String ownerId,String relType) {
		model.addAttribute("relType",relType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerId",ownerId);
		return prefix+"/goods_stock_rel";
	}

	@RequestMapping("/goods_stock_rel_tab.html")
	public String relTabList(Model model,HttpServletRequest request,String ownerType,String ownerCode,String ownerId) {
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerId",ownerId);
		return prefix+"/goods_stock_rel_tab";
	}


	@RequestMapping("/goods_out_dtl_list.html")
	public String outList(Model model,HttpServletRequest request,String ownerType,String ownerCode) {
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/goods_out_dtl_list";
	}


}