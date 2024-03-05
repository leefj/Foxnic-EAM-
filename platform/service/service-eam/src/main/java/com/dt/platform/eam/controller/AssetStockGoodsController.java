package com.dt.platform.eam.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.eam.AssetStockGoodsServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockGoodsVOMeta;
import com.dt.platform.domain.eam.AssetStockGoods;
import com.dt.platform.domain.eam.AssetStockGoodsVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.eam.meta.AssetStockGoodsMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存物品单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-21 09:53:04
*/

@InDoc
@Api(tags = "库存物品单")
@RestController("EamAssetStockGoodsController")
public class AssetStockGoodsController extends SuperController {

	@Autowired
	private IAssetStockGoodsService assetStockGoodsService;

	/**
	 * 添加库存物品单
	*/
	@ApiOperation(value = "添加库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UNIT_PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.USE_ORG_ID , value = "所属组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetStockGoodsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.INSERT)
	public Result insert(AssetStockGoodsVO assetStockGoodsVO) {
		
		Result result=assetStockGoodsService.insert(assetStockGoodsVO,false);
		return result;
	}



	/**
	 * 删除库存物品单
	*/
	@ApiOperation(value = "删除库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetStockGoodsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetStockGoodsService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetStockGoodsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存物品单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetStockGoodsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetStockGoodsService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=assetStockGoodsService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetStockGoodsService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新库存物品单
	*/
	@ApiOperation(value = "更新库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UNIT_PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.USE_ORG_ID , value = "所属组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetStockGoodsVOMeta.PAGE_INDEX , AssetStockGoodsVOMeta.PAGE_SIZE , AssetStockGoodsVOMeta.SEARCH_FIELD , AssetStockGoodsVOMeta.FUZZY_FIELD , AssetStockGoodsVOMeta.SEARCH_VALUE , AssetStockGoodsVOMeta.DIRTY_FIELDS , AssetStockGoodsVOMeta.SORT_FIELD , AssetStockGoodsVOMeta.SORT_TYPE , AssetStockGoodsVOMeta.DATA_ORIGIN , AssetStockGoodsVOMeta.QUERY_LOGIC , AssetStockGoodsVOMeta.REQUEST_ACTION , AssetStockGoodsVOMeta.IDS } )
	@SentinelResource(value = AssetStockGoodsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.UPDATE)
	public Result update(AssetStockGoodsVO assetStockGoodsVO) {
		
		Result result=assetStockGoodsService.update(assetStockGoodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存物品单
	*/
	@ApiOperation(value = "保存库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UNIT_PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.USE_ORG_ID , value = "所属组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsVOMeta.PAGE_INDEX , AssetStockGoodsVOMeta.PAGE_SIZE , AssetStockGoodsVOMeta.SEARCH_FIELD , AssetStockGoodsVOMeta.FUZZY_FIELD , AssetStockGoodsVOMeta.SEARCH_VALUE , AssetStockGoodsVOMeta.DIRTY_FIELDS , AssetStockGoodsVOMeta.SORT_FIELD , AssetStockGoodsVOMeta.SORT_TYPE , AssetStockGoodsVOMeta.DATA_ORIGIN , AssetStockGoodsVOMeta.QUERY_LOGIC , AssetStockGoodsVOMeta.REQUEST_ACTION , AssetStockGoodsVOMeta.IDS } )
	@SentinelResource(value = AssetStockGoodsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.SAVE)
	public Result save(AssetStockGoodsVO assetStockGoodsVO) {
		
		Result result=assetStockGoodsService.save(assetStockGoodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存物品单
	*/
	@ApiOperation(value = "获取库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetStockGoodsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.GET_BY_ID)
	public Result<AssetStockGoods> getById(String id) {
		
		Result<AssetStockGoods> result=new Result<>();
		AssetStockGoods assetStockGoods=assetStockGoodsService.getById(id);
		// join 关联的对象
		assetStockGoodsService.dao().fill(assetStockGoods)
			.with("ownerCompany")
			.with("useOrganization")
			.with(AssetStockGoodsMeta.GOODS)
			.with(AssetStockGoodsMeta.SUPPLIER)
			.with(AssetStockGoodsMeta.WAREHOUSE)
			.with(AssetStockGoodsMeta.SOURCE)
			.execute();
		result.success(true).data(assetStockGoods);
		return result;
	}


	/**
	 * 批量获取库存物品单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存物品单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetStockGoodsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoods>> getByIds(List<String> ids) {
		
		Result<List<AssetStockGoods>> result=new Result<>();
		List<AssetStockGoods> list=assetStockGoodsService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存物品单
	*/
	@ApiOperation(value = "查询库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UNIT_PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.USE_ORG_ID , value = "所属组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetStockGoodsVOMeta.PAGE_INDEX , AssetStockGoodsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoods>> queryList(AssetStockGoodsVO sample) {
		
		Result<List<AssetStockGoods>> result=new Result<>();
		List<AssetStockGoods> list=assetStockGoodsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存物品单
	*/
	@ApiOperation(value = "分页查询库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UNIT_PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.USE_ORG_ID , value = "所属组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetStockGoodsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoods>> queryPagedList(AssetStockGoodsVO sample) {
		
		Result<PagedList<AssetStockGoods>> result=new Result<>();
		PagedList<AssetStockGoods> list=assetStockGoodsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStockGoodsService.dao().fill(list)
			.with("ownerCompany")
			.with("useOrganization")
			.with(AssetStockGoodsMeta.GOODS)
			.with(AssetStockGoodsMeta.SUPPLIER)
			.with(AssetStockGoodsMeta.WAREHOUSE)
			.with(AssetStockGoodsMeta.SOURCE)
			.execute();
		result.success(true).data(list);
		return result;
	}





}