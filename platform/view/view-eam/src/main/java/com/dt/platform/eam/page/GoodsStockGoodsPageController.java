package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetAttributeItemOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetPcmCodeEnum;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;

import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 库存物品 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 20:41:09
*/

@Controller("EamGoodsStockGoodsPageController")
@RequestMapping(GoodsStockGoodsPageController.prefix)
public class GoodsStockGoodsPageController extends ViewController {
	
	public static final String prefix="business/eam/goods_stock_goods";

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




	//物品档案子设备
	@RequestMapping("/selected_rel_goods_stock.html")
	public String selectedSubGoodsStock(Model model,HttpServletRequest request,String pageType,String ownerId,String selectedCode) {
		model.addAttribute("pageType",pageType);
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);

		return prefix+"/selected_rel_goods_stock";
	}

	@RequestMapping("/asset_part_goods_list.html")
	public String selectedSubGoodsStock(Model model,HttpServletRequest request,String assetId,String ownerCode) {
		model.addAttribute("assetId",assetId);
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/asset_part_goods_list";
	}


	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_tree.html")
	public String tree(Model model,HttpServletRequest request,String ownerCode,String ownerType,String categoryCode) {
		model.addAttribute("categoryCode",categoryCode);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);

		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_STOCK_GOODS.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		Result idResult= AssetCategoryServiceProxy.api().queryNodesByCode(AssetPcmCodeEnum.ASSET_STOCK_GOODS.code());
		model.addAttribute("categoryParentId",idResult.getData());
		return prefix+"/goods_stock_tree";
	}

	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_t_list.html")
	public String listTree(Model model,HttpServletRequest request,String ownerCode,String ownerType,String categoryCode) {

		model.addAttribute("categoryCode",categoryCode);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);
		return prefix+"/goods_stock_t_list";
	}


	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode,String ownerType,String categoryCode) {

		model.addAttribute("categoryCode",categoryCode);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);
		return prefix+"/goods_stock_list";
	}


	/**
	 * 库存物品 表单页面
	 */
	@RequestMapping("/goods_stock_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerCode,String ownerType,String categoryCode) {
		List<ZTreeNode> list=new ArrayList<>();
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);
		if(StringUtil.isBlank(categoryCode)){
			categoryCode="asset,asset_stock_goods,asset_consumables";
		}
		String[] categoryCodeArr=categoryCode.split(",");
		for(int i=0;i<categoryCodeArr.length;i++){
			if(!StringUtil.isBlank(categoryCode)){
				CatalogVO catalog=new CatalogVO();
				catalog.setCode(categoryCodeArr[i]);
				Result<List<Catalog>> catalogListResult= CatalogServiceProxy.api().queryList(catalog);
				String categoryId="";
				if(catalogListResult.isSuccess()){
					List<Catalog> catalogList=catalogListResult.getData();
					if(catalogList.size()>0){
						categoryId=catalogList.get(0).getId();
						list.addAll(queryZtreeNode(categoryId));
					}
				}
			}
		}
		model.addAttribute("assetCategoryData",list);
		return prefix+"/goods_stock_form";
	}


	private List<ZTreeNode> queryZtreeNode(String categoryId){
		CatalogVO catalog2=new CatalogVO();
		catalog2.setParentId(categoryId);
		catalog2.setIsLoadAllDescendants(1);
		Result<List<org.github.foxnic.web.misc.ztree.ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
		return treeResult.getData();
	}

}