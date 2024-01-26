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


import com.dt.platform.proxy.hr.SalaryProjectTimeServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryProjectTimeVOMeta;
import com.dt.platform.domain.hr.SalaryProjectTime;
import com.dt.platform.domain.hr.SalaryProjectTimeVO;
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
import com.dt.platform.domain.hr.meta.SalaryProjectTimeMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryProjectTimeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 计时项目接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 14:49:23
*/

@InDoc
@Api(tags = "计时项目")
@RestController("HrSalaryProjectTimeController")
public class SalaryProjectTimeController extends SuperController {

	@Autowired
	private ISalaryProjectTimeService salaryProjectTimeService;

	/**
	 * 添加计时项目
	*/
	@ApiOperation(value = "添加计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803274955268554752"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "C01"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "安装费"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.MONEY , value = "计时单价" , required = false , dataTypeClass=BigDecimal.class , example = "10.00"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectTimeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.INSERT)
	public Result insert(SalaryProjectTimeVO salaryProjectTimeVO) {
		
		Result result=salaryProjectTimeService.insert(salaryProjectTimeVO,false);
		return result;
	}



	/**
	 * 删除计时项目
	*/
	@ApiOperation(value = "删除计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803274955268554752")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectTimeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryProjectTimeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryProjectTimeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除计时项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryProjectTimeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryProjectTimeService.hasRefers(ids);
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
			Result result=salaryProjectTimeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryProjectTimeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新计时项目
	*/
	@ApiOperation(value = "更新计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803274955268554752"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "C01"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "安装费"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.MONEY , value = "计时单价" , required = false , dataTypeClass=BigDecimal.class , example = "10.00"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryProjectTimeVOMeta.PAGE_INDEX , SalaryProjectTimeVOMeta.PAGE_SIZE , SalaryProjectTimeVOMeta.SEARCH_FIELD , SalaryProjectTimeVOMeta.FUZZY_FIELD , SalaryProjectTimeVOMeta.SEARCH_VALUE , SalaryProjectTimeVOMeta.DIRTY_FIELDS , SalaryProjectTimeVOMeta.SORT_FIELD , SalaryProjectTimeVOMeta.SORT_TYPE , SalaryProjectTimeVOMeta.DATA_ORIGIN , SalaryProjectTimeVOMeta.QUERY_LOGIC , SalaryProjectTimeVOMeta.REQUEST_ACTION , SalaryProjectTimeVOMeta.IDS } )
	@SentinelResource(value = SalaryProjectTimeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.UPDATE)
	public Result update(SalaryProjectTimeVO salaryProjectTimeVO) {
		
		Result result=salaryProjectTimeService.update(salaryProjectTimeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存计时项目
	*/
	@ApiOperation(value = "保存计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803274955268554752"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "C01"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "安装费"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.MONEY , value = "计时单价" , required = false , dataTypeClass=BigDecimal.class , example = "10.00"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryProjectTimeVOMeta.PAGE_INDEX , SalaryProjectTimeVOMeta.PAGE_SIZE , SalaryProjectTimeVOMeta.SEARCH_FIELD , SalaryProjectTimeVOMeta.FUZZY_FIELD , SalaryProjectTimeVOMeta.SEARCH_VALUE , SalaryProjectTimeVOMeta.DIRTY_FIELDS , SalaryProjectTimeVOMeta.SORT_FIELD , SalaryProjectTimeVOMeta.SORT_TYPE , SalaryProjectTimeVOMeta.DATA_ORIGIN , SalaryProjectTimeVOMeta.QUERY_LOGIC , SalaryProjectTimeVOMeta.REQUEST_ACTION , SalaryProjectTimeVOMeta.IDS } )
	@SentinelResource(value = SalaryProjectTimeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.SAVE)
	public Result save(SalaryProjectTimeVO salaryProjectTimeVO) {
		
		Result result=salaryProjectTimeService.save(salaryProjectTimeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取计时项目
	*/
	@ApiOperation(value = "获取计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectTimeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.GET_BY_ID)
	public Result<SalaryProjectTime> getById(String id) {
		
		Result<SalaryProjectTime> result=new Result<>();
		SalaryProjectTime salaryProjectTime=salaryProjectTimeService.getById(id);
		result.success(true).data(salaryProjectTime);
		return result;
	}


	/**
	 * 批量获取计时项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取计时项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryProjectTimeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryProjectTimeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.GET_BY_IDS)
	public Result<List<SalaryProjectTime>> getByIds(List<String> ids) {
		
		Result<List<SalaryProjectTime>> result=new Result<>();
		List<SalaryProjectTime> list=salaryProjectTimeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询计时项目
	*/
	@ApiOperation(value = "查询计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803274955268554752"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "C01"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "安装费"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.MONEY , value = "计时单价" , required = false , dataTypeClass=BigDecimal.class , example = "10.00"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryProjectTimeVOMeta.PAGE_INDEX , SalaryProjectTimeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryProjectTimeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.QUERY_LIST)
	public Result<List<SalaryProjectTime>> queryList(SalaryProjectTimeVO sample) {
		
		Result<List<SalaryProjectTime>> result=new Result<>();
		List<SalaryProjectTime> list=salaryProjectTimeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询计时项目
	*/
	@ApiOperation(value = "分页查询计时项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "803274955268554752"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.CODE , value = "项目编码" , required = false , dataTypeClass=String.class , example = "C01"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "安装费"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.MONEY , value = "计时单价" , required = false , dataTypeClass=BigDecimal.class , example = "10.00"),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryProjectTimeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryProjectTimeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryProjectTimeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryProjectTime>> queryPagedList(SalaryProjectTimeVO sample) {
		
		Result<PagedList<SalaryProjectTime>> result=new Result<>();
		PagedList<SalaryProjectTime> list=salaryProjectTimeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}