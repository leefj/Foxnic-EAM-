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


import com.dt.platform.proxy.eam.MaintainRcdServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainRcdVOMeta;
import com.dt.platform.domain.eam.MaintainRcd;
import com.dt.platform.domain.eam.MaintainRcdVO;
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
import com.dt.platform.domain.eam.meta.MaintainRcdMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 保养记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-12 12:15:32
*/

@InDoc
@Api(tags = "保养记录")
@RestController("EamMaintainRcdController")
public class MaintainRcdController extends SuperController {

	@Autowired
	private IMaintainRcdService maintainRcdService;

	/**
	 * 添加保养记录
	*/
	@ApiOperation(value = "添加保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.INSERT)
	public Result insert(MaintainRcdVO maintainRcdVO) {
		
		Result result=maintainRcdService.insert(maintainRcdVO,false);
		return result;
	}



	/**
	 * 删除保养记录
	*/
	@ApiOperation(value = "删除保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  maintainRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=maintainRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除保养记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MaintainRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = maintainRcdService.hasRefers(ids);
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
			Result result=maintainRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=maintainRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新保养记录
	*/
	@ApiOperation(value = "更新保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaintainRcdVOMeta.PAGE_INDEX , MaintainRcdVOMeta.PAGE_SIZE , MaintainRcdVOMeta.SEARCH_FIELD , MaintainRcdVOMeta.FUZZY_FIELD , MaintainRcdVOMeta.SEARCH_VALUE , MaintainRcdVOMeta.DIRTY_FIELDS , MaintainRcdVOMeta.SORT_FIELD , MaintainRcdVOMeta.SORT_TYPE , MaintainRcdVOMeta.DATA_ORIGIN , MaintainRcdVOMeta.QUERY_LOGIC , MaintainRcdVOMeta.REQUEST_ACTION , MaintainRcdVOMeta.IDS } )
	@SentinelResource(value = MaintainRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.UPDATE)
	public Result update(MaintainRcdVO maintainRcdVO) {
		
		Result result=maintainRcdService.update(maintainRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存保养记录
	*/
	@ApiOperation(value = "保存保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainRcdVOMeta.PAGE_INDEX , MaintainRcdVOMeta.PAGE_SIZE , MaintainRcdVOMeta.SEARCH_FIELD , MaintainRcdVOMeta.FUZZY_FIELD , MaintainRcdVOMeta.SEARCH_VALUE , MaintainRcdVOMeta.DIRTY_FIELDS , MaintainRcdVOMeta.SORT_FIELD , MaintainRcdVOMeta.SORT_TYPE , MaintainRcdVOMeta.DATA_ORIGIN , MaintainRcdVOMeta.QUERY_LOGIC , MaintainRcdVOMeta.REQUEST_ACTION , MaintainRcdVOMeta.IDS } )
	@SentinelResource(value = MaintainRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.SAVE)
	public Result save(MaintainRcdVO maintainRcdVO) {
		
		Result result=maintainRcdService.save(maintainRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取保养记录
	*/
	@ApiOperation(value = "获取保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.GET_BY_ID)
	public Result<MaintainRcd> getById(String id) {
		
		Result<MaintainRcd> result=new Result<>();
		MaintainRcd maintainRcd=maintainRcdService.getById(id);
		result.success(true).data(maintainRcd);
		return result;
	}


	/**
	 * 批量获取保养记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取保养记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MaintainRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.GET_BY_IDS)
	public Result<List<MaintainRcd>> getByIds(List<String> ids) {
		
		Result<List<MaintainRcd>> result=new Result<>();
		List<MaintainRcd> list=maintainRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询保养记录
	*/
	@ApiOperation(value = "查询保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaintainRcdVOMeta.PAGE_INDEX , MaintainRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.QUERY_LIST)
	public Result<List<MaintainRcd>> queryList(MaintainRcdVO sample) {
		
		Result<List<MaintainRcd>> result=new Result<>();
		List<MaintainRcd> list=maintainRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询保养记录
	*/
	@ApiOperation(value = "分页查询保养记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainRcd>> queryPagedList(MaintainRcdVO sample) {
		
		Result<PagedList<MaintainRcd>> result=new Result<>();
		PagedList<MaintainRcd> list=maintainRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}