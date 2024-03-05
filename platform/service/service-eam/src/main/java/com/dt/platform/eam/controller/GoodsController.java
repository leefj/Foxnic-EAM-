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


import com.dt.platform.proxy.eam.GoodsServiceProxy;
import com.dt.platform.domain.eam.meta.GoodsVOMeta;
import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.GoodsVO;
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
import com.dt.platform.domain.eam.meta.GoodsMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.Manufacturer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IGoodsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 物品档案接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-21 10:02:51
*/

@InDoc
@Api(tags = "物品档案")
@RestController("EamGoodsController")
public class GoodsController extends SuperController {

	@Autowired
	private IGoodsService goodsService;

	/**
	 * 添加物品档案
	*/
	@ApiOperation(value = "添加物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.REFERENCE_PRICE , value = "参考单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = GoodsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.INSERT)
	public Result insert(GoodsVO goodsVO) {
		
		Result result=goodsService.insert(goodsVO,false);
		return result;
	}



	/**
	 * 删除物品档案
	*/
	@ApiOperation(value = "删除物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = GoodsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  goodsService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=goodsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除物品档案 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = GoodsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = goodsService.hasRefers(ids);
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
			Result result=goodsService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=goodsService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新物品档案
	*/
	@ApiOperation(value = "更新物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.REFERENCE_PRICE , value = "参考单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.FUZZY_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.DIRTY_FIELDS , GoodsVOMeta.SORT_FIELD , GoodsVOMeta.SORT_TYPE , GoodsVOMeta.DATA_ORIGIN , GoodsVOMeta.QUERY_LOGIC , GoodsVOMeta.REQUEST_ACTION , GoodsVOMeta.IDS } )
	@SentinelResource(value = GoodsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.UPDATE)
	public Result update(GoodsVO goodsVO) {
		
		Result result=goodsService.update(goodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存物品档案
	*/
	@ApiOperation(value = "保存物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.REFERENCE_PRICE , value = "参考单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.FUZZY_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.DIRTY_FIELDS , GoodsVOMeta.SORT_FIELD , GoodsVOMeta.SORT_TYPE , GoodsVOMeta.DATA_ORIGIN , GoodsVOMeta.QUERY_LOGIC , GoodsVOMeta.REQUEST_ACTION , GoodsVOMeta.IDS } )
	@SentinelResource(value = GoodsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.SAVE)
	public Result save(GoodsVO goodsVO) {
		
		Result result=goodsService.save(goodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取物品档案
	*/
	@ApiOperation(value = "获取物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = GoodsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.GET_BY_ID)
	public Result<Goods> getById(String id) {
		
		Result<Goods> result=new Result<>();
		Goods goods=goodsService.getById(id);
		// join 关联的对象
		goodsService.dao().fill(goods)
			.with(GoodsMeta.CATEGORY)
			.with(GoodsMeta.MANUFACTURER)
			.execute();
		result.success(true).data(goods);
		return result;
	}


	/**
	 * 批量获取物品档案 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取物品档案")
		@ApiImplicitParams({
				@ApiImplicitParam(name = GoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = GoodsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.GET_BY_IDS)
	public Result<List<Goods>> getByIds(List<String> ids) {
		
		Result<List<Goods>> result=new Result<>();
		List<Goods> list=goodsService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询物品档案
	*/
	@ApiOperation(value = "查询物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.REFERENCE_PRICE , value = "参考单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GoodsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.QUERY_LIST)
	public Result<List<Goods>> queryList(GoodsVO sample) {
		
		Result<List<Goods>> result=new Result<>();
		List<Goods> list=goodsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询物品档案
	*/
	@ApiOperation(value = "分页查询物品档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.REFERENCE_PRICE , value = "参考单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = GoodsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Goods>> queryPagedList(GoodsVO sample) {
		
		Result<PagedList<Goods>> result=new Result<>();
		PagedList<Goods> list=goodsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		goodsService.dao().fill(list)
			.with(GoodsMeta.CATEGORY)
			.with(GoodsMeta.MANUFACTURER)
			.execute();
		result.success(true).data(list);
		return result;
	}





}