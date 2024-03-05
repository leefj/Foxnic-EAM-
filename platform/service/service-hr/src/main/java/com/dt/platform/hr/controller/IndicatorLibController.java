package com.dt.platform.hr.controller;

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


import com.dt.platform.proxy.hr.IndicatorLibServiceProxy;
import com.dt.platform.domain.hr.meta.IndicatorLibVOMeta;
import com.dt.platform.domain.hr.IndicatorLib;
import com.dt.platform.domain.hr.IndicatorLibVO;
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
import com.dt.platform.domain.hr.meta.IndicatorLibMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IIndicatorLibService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 指标库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 16:32:19
*/

@InDoc
@Api(tags = "指标库")
@RestController("HrIndicatorLibController")
public class IndicatorLibController extends SuperController {

	@Autowired
	private IIndicatorLibService indicatorLibService;

	/**
	 * 添加指标库
	*/
	@ApiOperation(value = "添加指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "815199131050967040"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.TYPE_CODE , value = "指标分类" , required = false , dataTypeClass=String.class , example = "rs"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.NAME , value = "指标名称" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.PROPERTY , value = "定性/定量指标" , required = false , dataTypeClass=String.class , example = "定量"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "%"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.DEF , value = "指标定义" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BASE , value = "评分标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BY , value = "评分依据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = IndicatorLibServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.INSERT)
	public Result insert(IndicatorLibVO indicatorLibVO) {
		
		Result result=indicatorLibService.insert(indicatorLibVO,false);
		return result;
	}



	/**
	 * 删除指标库
	*/
	@ApiOperation(value = "删除指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "815199131050967040")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = IndicatorLibServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  indicatorLibService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=indicatorLibService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除指标库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = IndicatorLibServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = indicatorLibService.hasRefers(ids);
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
			Result result=indicatorLibService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=indicatorLibService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新指标库
	*/
	@ApiOperation(value = "更新指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "815199131050967040"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.TYPE_CODE , value = "指标分类" , required = false , dataTypeClass=String.class , example = "rs"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.NAME , value = "指标名称" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.PROPERTY , value = "定性/定量指标" , required = false , dataTypeClass=String.class , example = "定量"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "%"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.DEF , value = "指标定义" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BASE , value = "评分标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BY , value = "评分依据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { IndicatorLibVOMeta.PAGE_INDEX , IndicatorLibVOMeta.PAGE_SIZE , IndicatorLibVOMeta.SEARCH_FIELD , IndicatorLibVOMeta.FUZZY_FIELD , IndicatorLibVOMeta.SEARCH_VALUE , IndicatorLibVOMeta.DIRTY_FIELDS , IndicatorLibVOMeta.SORT_FIELD , IndicatorLibVOMeta.SORT_TYPE , IndicatorLibVOMeta.DATA_ORIGIN , IndicatorLibVOMeta.QUERY_LOGIC , IndicatorLibVOMeta.REQUEST_ACTION , IndicatorLibVOMeta.IDS } )
	@SentinelResource(value = IndicatorLibServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.UPDATE)
	public Result update(IndicatorLibVO indicatorLibVO) {
		
		Result result=indicatorLibService.update(indicatorLibVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存指标库
	*/
	@ApiOperation(value = "保存指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "815199131050967040"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.TYPE_CODE , value = "指标分类" , required = false , dataTypeClass=String.class , example = "rs"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.NAME , value = "指标名称" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.PROPERTY , value = "定性/定量指标" , required = false , dataTypeClass=String.class , example = "定量"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "%"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.DEF , value = "指标定义" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BASE , value = "评分标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BY , value = "评分依据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { IndicatorLibVOMeta.PAGE_INDEX , IndicatorLibVOMeta.PAGE_SIZE , IndicatorLibVOMeta.SEARCH_FIELD , IndicatorLibVOMeta.FUZZY_FIELD , IndicatorLibVOMeta.SEARCH_VALUE , IndicatorLibVOMeta.DIRTY_FIELDS , IndicatorLibVOMeta.SORT_FIELD , IndicatorLibVOMeta.SORT_TYPE , IndicatorLibVOMeta.DATA_ORIGIN , IndicatorLibVOMeta.QUERY_LOGIC , IndicatorLibVOMeta.REQUEST_ACTION , IndicatorLibVOMeta.IDS } )
	@SentinelResource(value = IndicatorLibServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.SAVE)
	public Result save(IndicatorLibVO indicatorLibVO) {
		
		Result result=indicatorLibService.save(indicatorLibVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取指标库
	*/
	@ApiOperation(value = "获取指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = IndicatorLibServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.GET_BY_ID)
	public Result<IndicatorLib> getById(String id) {
		
		Result<IndicatorLib> result=new Result<>();
		IndicatorLib indicatorLib=indicatorLibService.getById(id);
		// join 关联的对象
		indicatorLibService.dao().fill(indicatorLib)
			.with(IndicatorLibMeta.TYPE_DICT)
			.execute();
		result.success(true).data(indicatorLib);
		return result;
	}


	/**
	 * 批量获取指标库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取指标库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = IndicatorLibVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = IndicatorLibServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.GET_BY_IDS)
	public Result<List<IndicatorLib>> getByIds(List<String> ids) {
		
		Result<List<IndicatorLib>> result=new Result<>();
		List<IndicatorLib> list=indicatorLibService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询指标库
	*/
	@ApiOperation(value = "查询指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "815199131050967040"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.TYPE_CODE , value = "指标分类" , required = false , dataTypeClass=String.class , example = "rs"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.NAME , value = "指标名称" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.PROPERTY , value = "定性/定量指标" , required = false , dataTypeClass=String.class , example = "定量"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "%"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.DEF , value = "指标定义" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BASE , value = "评分标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BY , value = "评分依据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { IndicatorLibVOMeta.PAGE_INDEX , IndicatorLibVOMeta.PAGE_SIZE } )
	@SentinelResource(value = IndicatorLibServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.QUERY_LIST)
	public Result<List<IndicatorLib>> queryList(IndicatorLibVO sample) {
		
		Result<List<IndicatorLib>> result=new Result<>();
		List<IndicatorLib> list=indicatorLibService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询指标库
	*/
	@ApiOperation(value = "分页查询指标库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = IndicatorLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "815199131050967040"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.TYPE_CODE , value = "指标分类" , required = false , dataTypeClass=String.class , example = "rs"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.NAME , value = "指标名称" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.PROPERTY , value = "定性/定量指标" , required = false , dataTypeClass=String.class , example = "定量"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "%"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.DEF , value = "指标定义" , required = false , dataTypeClass=String.class , example = "采购达成率"),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BASE , value = "评分标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.SCORING_BY , value = "评分依据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = IndicatorLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = IndicatorLibServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(IndicatorLibServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<IndicatorLib>> queryPagedList(IndicatorLibVO sample) {
		
		Result<PagedList<IndicatorLib>> result=new Result<>();
		PagedList<IndicatorLib> list=indicatorLibService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		indicatorLibService.dao().fill(list)
			.with(IndicatorLibMeta.TYPE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}