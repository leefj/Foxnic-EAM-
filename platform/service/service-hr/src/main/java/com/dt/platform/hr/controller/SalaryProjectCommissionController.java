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


import com.dt.platform.proxy.hr.SalaryProjectCommissionServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryProjectCommissionVOMeta;
import com.dt.platform.domain.hr.SalaryProjectCommission;
import com.dt.platform.domain.hr.SalaryProjectCommissionVO;
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
import com.dt.platform.domain.hr.meta.SalaryProjectCommissionMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryProjectCommissionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 项目提成接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 14:05:13
*/

@InDoc
@Api(tags = "项目提成")
@RestController("HrSalaryProjectCommissionController")
public class SalaryProjectCommissionController extends SuperController {

	@Autowired
	private ISalaryProjectCommissionService salaryProjectCommissionService;

	/**
	 * 添加项目提成
	*/
	@ApiOperation(value = "添加项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.COMMISSION_RATIO , value = "提成比例" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.INSERT)
	public Result insert(SalaryProjectCommissionVO salaryProjectCommissionVO) {
		
		Result result=salaryProjectCommissionService.insert(salaryProjectCommissionVO,false);
		return result;
	}



	/**
	 * 删除项目提成
	*/
	@ApiOperation(value = "删除项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryProjectCommissionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryProjectCommissionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除项目提成 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryProjectCommissionService.hasRefers(ids);
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
			Result result=salaryProjectCommissionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryProjectCommissionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新项目提成
	*/
	@ApiOperation(value = "更新项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.COMMISSION_RATIO , value = "提成比例" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryProjectCommissionVOMeta.PAGE_INDEX , SalaryProjectCommissionVOMeta.PAGE_SIZE , SalaryProjectCommissionVOMeta.SEARCH_FIELD , SalaryProjectCommissionVOMeta.FUZZY_FIELD , SalaryProjectCommissionVOMeta.SEARCH_VALUE , SalaryProjectCommissionVOMeta.DIRTY_FIELDS , SalaryProjectCommissionVOMeta.SORT_FIELD , SalaryProjectCommissionVOMeta.SORT_TYPE , SalaryProjectCommissionVOMeta.DATA_ORIGIN , SalaryProjectCommissionVOMeta.QUERY_LOGIC , SalaryProjectCommissionVOMeta.REQUEST_ACTION , SalaryProjectCommissionVOMeta.IDS } )
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.UPDATE)
	public Result update(SalaryProjectCommissionVO salaryProjectCommissionVO) {
		
		Result result=salaryProjectCommissionService.update(salaryProjectCommissionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存项目提成
	*/
	@ApiOperation(value = "保存项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.COMMISSION_RATIO , value = "提成比例" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryProjectCommissionVOMeta.PAGE_INDEX , SalaryProjectCommissionVOMeta.PAGE_SIZE , SalaryProjectCommissionVOMeta.SEARCH_FIELD , SalaryProjectCommissionVOMeta.FUZZY_FIELD , SalaryProjectCommissionVOMeta.SEARCH_VALUE , SalaryProjectCommissionVOMeta.DIRTY_FIELDS , SalaryProjectCommissionVOMeta.SORT_FIELD , SalaryProjectCommissionVOMeta.SORT_TYPE , SalaryProjectCommissionVOMeta.DATA_ORIGIN , SalaryProjectCommissionVOMeta.QUERY_LOGIC , SalaryProjectCommissionVOMeta.REQUEST_ACTION , SalaryProjectCommissionVOMeta.IDS } )
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.SAVE)
	public Result save(SalaryProjectCommissionVO salaryProjectCommissionVO) {
		
		Result result=salaryProjectCommissionService.save(salaryProjectCommissionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取项目提成
	*/
	@ApiOperation(value = "获取项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.GET_BY_ID)
	public Result<SalaryProjectCommission> getById(String id) {
		
		Result<SalaryProjectCommission> result=new Result<>();
		SalaryProjectCommission salaryProjectCommission=salaryProjectCommissionService.getById(id);
		result.success(true).data(salaryProjectCommission);
		return result;
	}


	/**
	 * 批量获取项目提成 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取项目提成")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryProjectCommissionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.GET_BY_IDS)
	public Result<List<SalaryProjectCommission>> getByIds(List<String> ids) {
		
		Result<List<SalaryProjectCommission>> result=new Result<>();
		List<SalaryProjectCommission> list=salaryProjectCommissionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询项目提成
	*/
	@ApiOperation(value = "查询项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.COMMISSION_RATIO , value = "提成比例" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryProjectCommissionVOMeta.PAGE_INDEX , SalaryProjectCommissionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.QUERY_LIST)
	public Result<List<SalaryProjectCommission>> queryList(SalaryProjectCommissionVO sample) {
		
		Result<List<SalaryProjectCommission>> result=new Result<>();
		List<SalaryProjectCommission> list=salaryProjectCommissionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询项目提成
	*/
	@ApiOperation(value = "分页查询项目提成")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.COMMISSION_RATIO , value = "提成比例" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectCommissionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectCommissionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryProjectCommission>> queryPagedList(SalaryProjectCommissionVO sample) {
		
		Result<PagedList<SalaryProjectCommission>> result=new Result<>();
		PagedList<SalaryProjectCommission> list=salaryProjectCommissionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}