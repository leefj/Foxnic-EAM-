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


import com.dt.platform.proxy.hr.SalaryTaxPctServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryTaxPctVOMeta;
import com.dt.platform.domain.hr.SalaryTaxPct;
import com.dt.platform.domain.hr.SalaryTaxPctVO;
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
import com.dt.platform.domain.hr.meta.SalaryTaxPctMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryTaxPctService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬税率接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:41:55
*/

@InDoc
@Api(tags = "薪酬税率")
@RestController("HrSalaryTaxPctController")
public class SalaryTaxPctController extends SuperController {

	@Autowired
	private ISalaryTaxPctService salaryTaxPctService;

	/**
	 * 添加薪酬税率
	*/
	@ApiOperation(value = "添加薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN , value = "最小" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN_INCLUDE , value = "最小包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX , value = "最大" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX_INCLUDE , value = "最大包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTaxPctServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.INSERT)
	public Result insert(SalaryTaxPctVO salaryTaxPctVO) {
		
		Result result=salaryTaxPctService.insert(salaryTaxPctVO,false);
		return result;
	}



	/**
	 * 删除薪酬税率
	*/
	@ApiOperation(value = "删除薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTaxPctServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryTaxPctService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryTaxPctService.deleteByIdPhysical(id);
		return result;
	}


	/**
	 * 批量删除薪酬税率 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryTaxPctServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryTaxPctService.hasRefers(ids);
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
			Result result=salaryTaxPctService.deleteByIdsPhysical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryTaxPctService.deleteByIdsPhysical(canDeleteIds);
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
	 * 更新薪酬税率
	*/
	@ApiOperation(value = "更新薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN , value = "最小" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN_INCLUDE , value = "最小包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX , value = "最大" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX_INCLUDE , value = "最大包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTaxPctVOMeta.PAGE_INDEX , SalaryTaxPctVOMeta.PAGE_SIZE , SalaryTaxPctVOMeta.SEARCH_FIELD , SalaryTaxPctVOMeta.FUZZY_FIELD , SalaryTaxPctVOMeta.SEARCH_VALUE , SalaryTaxPctVOMeta.DIRTY_FIELDS , SalaryTaxPctVOMeta.SORT_FIELD , SalaryTaxPctVOMeta.SORT_TYPE , SalaryTaxPctVOMeta.DATA_ORIGIN , SalaryTaxPctVOMeta.QUERY_LOGIC , SalaryTaxPctVOMeta.REQUEST_ACTION , SalaryTaxPctVOMeta.IDS } )
	@SentinelResource(value = SalaryTaxPctServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.UPDATE)
	public Result update(SalaryTaxPctVO salaryTaxPctVO) {
		
		Result result=salaryTaxPctService.update(salaryTaxPctVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存薪酬税率
	*/
	@ApiOperation(value = "保存薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN , value = "最小" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN_INCLUDE , value = "最小包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX , value = "最大" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX_INCLUDE , value = "最大包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryTaxPctVOMeta.PAGE_INDEX , SalaryTaxPctVOMeta.PAGE_SIZE , SalaryTaxPctVOMeta.SEARCH_FIELD , SalaryTaxPctVOMeta.FUZZY_FIELD , SalaryTaxPctVOMeta.SEARCH_VALUE , SalaryTaxPctVOMeta.DIRTY_FIELDS , SalaryTaxPctVOMeta.SORT_FIELD , SalaryTaxPctVOMeta.SORT_TYPE , SalaryTaxPctVOMeta.DATA_ORIGIN , SalaryTaxPctVOMeta.QUERY_LOGIC , SalaryTaxPctVOMeta.REQUEST_ACTION , SalaryTaxPctVOMeta.IDS } )
	@SentinelResource(value = SalaryTaxPctServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.SAVE)
	public Result save(SalaryTaxPctVO salaryTaxPctVO) {
		
		Result result=salaryTaxPctService.save(salaryTaxPctVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取薪酬税率
	*/
	@ApiOperation(value = "获取薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTaxPctServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.GET_BY_ID)
	public Result<SalaryTaxPct> getById(String id) {
		
		Result<SalaryTaxPct> result=new Result<>();
		SalaryTaxPct salaryTaxPct=salaryTaxPctService.getById(id);
		result.success(true).data(salaryTaxPct);
		return result;
	}


	/**
	 * 批量获取薪酬税率 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取薪酬税率")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryTaxPctVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryTaxPctServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.GET_BY_IDS)
	public Result<List<SalaryTaxPct>> getByIds(List<String> ids) {
		
		Result<List<SalaryTaxPct>> result=new Result<>();
		List<SalaryTaxPct> list=salaryTaxPctService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询薪酬税率
	*/
	@ApiOperation(value = "查询薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN , value = "最小" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN_INCLUDE , value = "最小包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX , value = "最大" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX_INCLUDE , value = "最大包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTaxPctVOMeta.PAGE_INDEX , SalaryTaxPctVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryTaxPctServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.QUERY_LIST)
	public Result<List<SalaryTaxPct>> queryList(SalaryTaxPctVO sample) {
		
		Result<List<SalaryTaxPct>> result=new Result<>();
		List<SalaryTaxPct> list=salaryTaxPctService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询薪酬税率
	*/
	@ApiOperation(value = "分页查询薪酬税率")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN , value = "最小" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MIN_INCLUDE , value = "最小包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX , value = "最大" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.MAX_INCLUDE , value = "最大包含" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTaxPctVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTaxPctServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTaxPctServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryTaxPct>> queryPagedList(SalaryTaxPctVO sample) {
		
		Result<PagedList<SalaryTaxPct>> result=new Result<>();
		PagedList<SalaryTaxPct> list=salaryTaxPctService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}