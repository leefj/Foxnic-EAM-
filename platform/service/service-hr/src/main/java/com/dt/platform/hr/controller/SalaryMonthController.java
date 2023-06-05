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


import com.dt.platform.proxy.hr.SalaryMonthServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryMonthVOMeta;
import com.dt.platform.domain.hr.SalaryMonth;
import com.dt.platform.domain.hr.SalaryMonthVO;
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
import com.dt.platform.domain.hr.meta.SalaryMonthMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryMonthService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬月份接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 13:47:32
*/

@InDoc
@Api(tags = "薪酬月份")
@RestController("HrSalaryMonthController")
public class SalaryMonthController extends SuperController {

	@Autowired
	private ISalaryMonthService salaryMonthService;

	/**
	 * 添加薪酬月份
	*/
	@ApiOperation(value = "添加薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryMonthServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.INSERT)
	public Result insert(SalaryMonthVO salaryMonthVO) {
		
		Result result=salaryMonthService.insert(salaryMonthVO,false);
		return result;
	}



	/**
	 * 删除薪酬月份
	*/
	@ApiOperation(value = "删除薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryMonthServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryMonthService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryMonthService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除薪酬月份 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryMonthServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryMonthService.hasRefers(ids);
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
			Result result=salaryMonthService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryMonthService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新薪酬月份
	*/
	@ApiOperation(value = "更新薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryMonthVOMeta.PAGE_INDEX , SalaryMonthVOMeta.PAGE_SIZE , SalaryMonthVOMeta.SEARCH_FIELD , SalaryMonthVOMeta.FUZZY_FIELD , SalaryMonthVOMeta.SEARCH_VALUE , SalaryMonthVOMeta.DIRTY_FIELDS , SalaryMonthVOMeta.SORT_FIELD , SalaryMonthVOMeta.SORT_TYPE , SalaryMonthVOMeta.DATA_ORIGIN , SalaryMonthVOMeta.QUERY_LOGIC , SalaryMonthVOMeta.REQUEST_ACTION , SalaryMonthVOMeta.IDS } )
	@SentinelResource(value = SalaryMonthServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.UPDATE)
	public Result update(SalaryMonthVO salaryMonthVO) {
		
		Result result=salaryMonthService.update(salaryMonthVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存薪酬月份
	*/
	@ApiOperation(value = "保存薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryMonthVOMeta.PAGE_INDEX , SalaryMonthVOMeta.PAGE_SIZE , SalaryMonthVOMeta.SEARCH_FIELD , SalaryMonthVOMeta.FUZZY_FIELD , SalaryMonthVOMeta.SEARCH_VALUE , SalaryMonthVOMeta.DIRTY_FIELDS , SalaryMonthVOMeta.SORT_FIELD , SalaryMonthVOMeta.SORT_TYPE , SalaryMonthVOMeta.DATA_ORIGIN , SalaryMonthVOMeta.QUERY_LOGIC , SalaryMonthVOMeta.REQUEST_ACTION , SalaryMonthVOMeta.IDS } )
	@SentinelResource(value = SalaryMonthServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.SAVE)
	public Result save(SalaryMonthVO salaryMonthVO) {
		
		Result result=salaryMonthService.save(salaryMonthVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取薪酬月份
	*/
	@ApiOperation(value = "获取薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryMonthServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.GET_BY_ID)
	public Result<SalaryMonth> getById(String id) {
		
		Result<SalaryMonth> result=new Result<>();
		SalaryMonth salaryMonth=salaryMonthService.getById(id);
		result.success(true).data(salaryMonth);
		return result;
	}


	/**
	 * 批量获取薪酬月份 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取薪酬月份")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryMonthVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryMonthServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.GET_BY_IDS)
	public Result<List<SalaryMonth>> getByIds(List<String> ids) {
		
		Result<List<SalaryMonth>> result=new Result<>();
		List<SalaryMonth> list=salaryMonthService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询薪酬月份
	*/
	@ApiOperation(value = "查询薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryMonthVOMeta.PAGE_INDEX , SalaryMonthVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryMonthServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.QUERY_LIST)
	public Result<List<SalaryMonth>> queryList(SalaryMonthVO sample) {
		
		Result<List<SalaryMonth>> result=new Result<>();
		List<SalaryMonth> list=salaryMonthService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询薪酬月份
	*/
	@ApiOperation(value = "分页查询薪酬月份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryMonthVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryMonthVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryMonthServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryMonthServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryMonth>> queryPagedList(SalaryMonthVO sample) {
		
		Result<PagedList<SalaryMonth>> result=new Result<>();
		PagedList<SalaryMonth> list=salaryMonthService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}