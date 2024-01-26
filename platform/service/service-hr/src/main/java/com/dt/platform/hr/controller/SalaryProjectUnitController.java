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


import com.dt.platform.proxy.hr.SalaryProjectUnitServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryProjectUnitVOMeta;
import com.dt.platform.domain.hr.SalaryProjectUnit;
import com.dt.platform.domain.hr.SalaryProjectUnitVO;
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
import com.dt.platform.domain.hr.meta.SalaryProjectUnitMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryProjectUnitService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 计件项目接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 14:49:35
*/

@InDoc
@Api(tags = "计件项目")
@RestController("HrSalaryProjectUnitController")
public class SalaryProjectUnitController extends SuperController {

	@Autowired
	private ISalaryProjectUnitService salaryProjectUnitService;

	/**
	 * 添加计件项目
	*/
	@ApiOperation(value = "添加计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803273629130293248"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "A01"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "搬运费"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.MONEY , value = "计件单价" , required = false , dataTypeClass=BigDecimal.class , example = "20.00"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectUnitServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.INSERT)
	public Result insert(SalaryProjectUnitVO salaryProjectUnitVO) {
		
		Result result=salaryProjectUnitService.insert(salaryProjectUnitVO,false);
		return result;
	}



	/**
	 * 删除计件项目
	*/
	@ApiOperation(value = "删除计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803273629130293248")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectUnitServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryProjectUnitService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryProjectUnitService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除计件项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryProjectUnitServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryProjectUnitService.hasRefers(ids);
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
			Result result=salaryProjectUnitService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryProjectUnitService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新计件项目
	*/
	@ApiOperation(value = "更新计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803273629130293248"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "A01"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "搬运费"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.MONEY , value = "计件单价" , required = false , dataTypeClass=BigDecimal.class , example = "20.00"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryProjectUnitVOMeta.PAGE_INDEX , SalaryProjectUnitVOMeta.PAGE_SIZE , SalaryProjectUnitVOMeta.SEARCH_FIELD , SalaryProjectUnitVOMeta.FUZZY_FIELD , SalaryProjectUnitVOMeta.SEARCH_VALUE , SalaryProjectUnitVOMeta.DIRTY_FIELDS , SalaryProjectUnitVOMeta.SORT_FIELD , SalaryProjectUnitVOMeta.SORT_TYPE , SalaryProjectUnitVOMeta.DATA_ORIGIN , SalaryProjectUnitVOMeta.QUERY_LOGIC , SalaryProjectUnitVOMeta.REQUEST_ACTION , SalaryProjectUnitVOMeta.IDS } )
	@SentinelResource(value = SalaryProjectUnitServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.UPDATE)
	public Result update(SalaryProjectUnitVO salaryProjectUnitVO) {
		
		Result result=salaryProjectUnitService.update(salaryProjectUnitVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存计件项目
	*/
	@ApiOperation(value = "保存计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803273629130293248"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "A01"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "搬运费"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.MONEY , value = "计件单价" , required = false , dataTypeClass=BigDecimal.class , example = "20.00"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryProjectUnitVOMeta.PAGE_INDEX , SalaryProjectUnitVOMeta.PAGE_SIZE , SalaryProjectUnitVOMeta.SEARCH_FIELD , SalaryProjectUnitVOMeta.FUZZY_FIELD , SalaryProjectUnitVOMeta.SEARCH_VALUE , SalaryProjectUnitVOMeta.DIRTY_FIELDS , SalaryProjectUnitVOMeta.SORT_FIELD , SalaryProjectUnitVOMeta.SORT_TYPE , SalaryProjectUnitVOMeta.DATA_ORIGIN , SalaryProjectUnitVOMeta.QUERY_LOGIC , SalaryProjectUnitVOMeta.REQUEST_ACTION , SalaryProjectUnitVOMeta.IDS } )
	@SentinelResource(value = SalaryProjectUnitServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.SAVE)
	public Result save(SalaryProjectUnitVO salaryProjectUnitVO) {
		
		Result result=salaryProjectUnitService.save(salaryProjectUnitVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取计件项目
	*/
	@ApiOperation(value = "获取计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectUnitServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.GET_BY_ID)
	public Result<SalaryProjectUnit> getById(String id) {
		
		Result<SalaryProjectUnit> result=new Result<>();
		SalaryProjectUnit salaryProjectUnit=salaryProjectUnitService.getById(id);
		result.success(true).data(salaryProjectUnit);
		return result;
	}


	/**
	 * 批量获取计件项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取计件项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryProjectUnitVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryProjectUnitServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.GET_BY_IDS)
	public Result<List<SalaryProjectUnit>> getByIds(List<String> ids) {
		
		Result<List<SalaryProjectUnit>> result=new Result<>();
		List<SalaryProjectUnit> list=salaryProjectUnitService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询计件项目
	*/
	@ApiOperation(value = "查询计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803273629130293248"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "A01"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "搬运费"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.MONEY , value = "计件单价" , required = false , dataTypeClass=BigDecimal.class , example = "20.00"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryProjectUnitVOMeta.PAGE_INDEX , SalaryProjectUnitVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryProjectUnitServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.QUERY_LIST)
	public Result<List<SalaryProjectUnit>> queryList(SalaryProjectUnitVO sample) {
		
		Result<List<SalaryProjectUnit>> result=new Result<>();
		List<SalaryProjectUnit> list=salaryProjectUnitService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询计件项目
	*/
	@ApiOperation(value = "分页查询计件项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803273629130293248"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "A01"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "搬运费"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.MONEY , value = "计件单价" , required = false , dataTypeClass=BigDecimal.class , example = "20.00"),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectUnitVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectUnitServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectUnitServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryProjectUnit>> queryPagedList(SalaryProjectUnitVO sample) {
		
		Result<PagedList<SalaryProjectUnit>> result=new Result<>();
		PagedList<SalaryProjectUnit> list=salaryProjectUnitService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}