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


import com.dt.platform.proxy.eam.InspectionRcdServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionRcdVOMeta;
import com.dt.platform.domain.eam.InspectionRcd;
import com.dt.platform.domain.eam.InspectionRcdVO;
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
import com.dt.platform.domain.eam.meta.InspectionRcdMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-12 12:14:48
*/

@InDoc
@Api(tags = "巡检记录")
@RestController("EamInspectionRcdController")
public class InspectionRcdController extends SuperController {

	@Autowired
	private IInspectionRcdService inspectionRcdService;

	/**
	 * 添加巡检记录
	*/
	@ApiOperation(value = "添加巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.INSERT)
	public Result insert(InspectionRcdVO inspectionRcdVO) {
		
		Result result=inspectionRcdService.insert(inspectionRcdVO,false);
		return result;
	}



	/**
	 * 删除巡检记录
	*/
	@ApiOperation(value = "删除巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionRcdService.hasRefers(ids);
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
			Result result=inspectionRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检记录
	*/
	@ApiOperation(value = "更新巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionRcdVOMeta.PAGE_INDEX , InspectionRcdVOMeta.PAGE_SIZE , InspectionRcdVOMeta.SEARCH_FIELD , InspectionRcdVOMeta.FUZZY_FIELD , InspectionRcdVOMeta.SEARCH_VALUE , InspectionRcdVOMeta.DIRTY_FIELDS , InspectionRcdVOMeta.SORT_FIELD , InspectionRcdVOMeta.SORT_TYPE , InspectionRcdVOMeta.DATA_ORIGIN , InspectionRcdVOMeta.QUERY_LOGIC , InspectionRcdVOMeta.REQUEST_ACTION , InspectionRcdVOMeta.IDS } )
	@SentinelResource(value = InspectionRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.UPDATE)
	public Result update(InspectionRcdVO inspectionRcdVO) {
		
		Result result=inspectionRcdService.update(inspectionRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检记录
	*/
	@ApiOperation(value = "保存巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionRcdVOMeta.PAGE_INDEX , InspectionRcdVOMeta.PAGE_SIZE , InspectionRcdVOMeta.SEARCH_FIELD , InspectionRcdVOMeta.FUZZY_FIELD , InspectionRcdVOMeta.SEARCH_VALUE , InspectionRcdVOMeta.DIRTY_FIELDS , InspectionRcdVOMeta.SORT_FIELD , InspectionRcdVOMeta.SORT_TYPE , InspectionRcdVOMeta.DATA_ORIGIN , InspectionRcdVOMeta.QUERY_LOGIC , InspectionRcdVOMeta.REQUEST_ACTION , InspectionRcdVOMeta.IDS } )
	@SentinelResource(value = InspectionRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.SAVE)
	public Result save(InspectionRcdVO inspectionRcdVO) {
		
		Result result=inspectionRcdService.save(inspectionRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检记录
	*/
	@ApiOperation(value = "获取巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.GET_BY_ID)
	public Result<InspectionRcd> getById(String id) {
		
		Result<InspectionRcd> result=new Result<>();
		InspectionRcd inspectionRcd=inspectionRcdService.getById(id);
		result.success(true).data(inspectionRcd);
		return result;
	}


	/**
	 * 批量获取巡检记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.GET_BY_IDS)
	public Result<List<InspectionRcd>> getByIds(List<String> ids) {
		
		Result<List<InspectionRcd>> result=new Result<>();
		List<InspectionRcd> list=inspectionRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检记录
	*/
	@ApiOperation(value = "查询巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionRcdVOMeta.PAGE_INDEX , InspectionRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.QUERY_LIST)
	public Result<List<InspectionRcd>> queryList(InspectionRcdVO sample) {
		
		Result<List<InspectionRcd>> result=new Result<>();
		List<InspectionRcd> list=inspectionRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检记录
	*/
	@ApiOperation(value = "分页查询巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionRcd>> queryPagedList(InspectionRcdVO sample) {
		
		Result<PagedList<InspectionRcd>> result=new Result<>();
		PagedList<InspectionRcd> list=inspectionRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}