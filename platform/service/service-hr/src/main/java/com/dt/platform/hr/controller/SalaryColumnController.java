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


import com.dt.platform.proxy.hr.SalaryColumnServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryColumnVOMeta;
import com.dt.platform.domain.hr.SalaryColumn;
import com.dt.platform.domain.hr.SalaryColumnVO;
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
import com.dt.platform.domain.hr.meta.SalaryColumnMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryColumnService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬字段接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 15:51:04
*/

@InDoc
@Api(tags = "薪酬字段")
@RestController("HrSalaryColumnController")
public class SalaryColumnController extends SuperController {

	@Autowired
	private ISalaryColumnService salaryColumnService;

	/**
	 * 添加薪酬字段
	*/
	@ApiOperation(value = "添加薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801820025651462144"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "baseSalary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "基本工资"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "constant"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_VALUE , value = "值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.DS_SOURCE , value = "数据来源" , required = false , dataTypeClass=String.class , example = "salary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.CAL_METHOD , value = "计算方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.BUSI_TYPE , value = "业务分类" , required = false , dataTypeClass=String.class , example = "base"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryColumnServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.INSERT)
	public Result insert(SalaryColumnVO salaryColumnVO) {
		
		Result result=salaryColumnService.insert(salaryColumnVO,false);
		return result;
	}



	/**
	 * 删除薪酬字段
	*/
	@ApiOperation(value = "删除薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801820025651462144")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryColumnServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryColumnService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryColumnService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除薪酬字段 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryColumnServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryColumnService.hasRefers(ids);
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
			Result result=salaryColumnService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryColumnService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新薪酬字段
	*/
	@ApiOperation(value = "更新薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801820025651462144"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "baseSalary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "基本工资"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "constant"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_VALUE , value = "值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.DS_SOURCE , value = "数据来源" , required = false , dataTypeClass=String.class , example = "salary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.CAL_METHOD , value = "计算方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.BUSI_TYPE , value = "业务分类" , required = false , dataTypeClass=String.class , example = "base"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryColumnVOMeta.PAGE_INDEX , SalaryColumnVOMeta.PAGE_SIZE , SalaryColumnVOMeta.SEARCH_FIELD , SalaryColumnVOMeta.FUZZY_FIELD , SalaryColumnVOMeta.SEARCH_VALUE , SalaryColumnVOMeta.DIRTY_FIELDS , SalaryColumnVOMeta.SORT_FIELD , SalaryColumnVOMeta.SORT_TYPE , SalaryColumnVOMeta.DATA_ORIGIN , SalaryColumnVOMeta.QUERY_LOGIC , SalaryColumnVOMeta.REQUEST_ACTION , SalaryColumnVOMeta.IDS } )
	@SentinelResource(value = SalaryColumnServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.UPDATE)
	public Result update(SalaryColumnVO salaryColumnVO) {
		
		Result result=salaryColumnService.update(salaryColumnVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存薪酬字段
	*/
	@ApiOperation(value = "保存薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801820025651462144"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "baseSalary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "基本工资"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "constant"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_VALUE , value = "值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.DS_SOURCE , value = "数据来源" , required = false , dataTypeClass=String.class , example = "salary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.CAL_METHOD , value = "计算方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.BUSI_TYPE , value = "业务分类" , required = false , dataTypeClass=String.class , example = "base"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryColumnVOMeta.PAGE_INDEX , SalaryColumnVOMeta.PAGE_SIZE , SalaryColumnVOMeta.SEARCH_FIELD , SalaryColumnVOMeta.FUZZY_FIELD , SalaryColumnVOMeta.SEARCH_VALUE , SalaryColumnVOMeta.DIRTY_FIELDS , SalaryColumnVOMeta.SORT_FIELD , SalaryColumnVOMeta.SORT_TYPE , SalaryColumnVOMeta.DATA_ORIGIN , SalaryColumnVOMeta.QUERY_LOGIC , SalaryColumnVOMeta.REQUEST_ACTION , SalaryColumnVOMeta.IDS } )
	@SentinelResource(value = SalaryColumnServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.SAVE)
	public Result save(SalaryColumnVO salaryColumnVO) {
		
		Result result=salaryColumnService.save(salaryColumnVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取薪酬字段
	*/
	@ApiOperation(value = "获取薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryColumnServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.GET_BY_ID)
	public Result<SalaryColumn> getById(String id) {
		
		Result<SalaryColumn> result=new Result<>();
		SalaryColumn salaryColumn=salaryColumnService.getById(id);
		result.success(true).data(salaryColumn);
		return result;
	}


	/**
	 * 批量获取薪酬字段 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取薪酬字段")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryColumnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryColumnServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.GET_BY_IDS)
	public Result<List<SalaryColumn>> getByIds(List<String> ids) {
		
		Result<List<SalaryColumn>> result=new Result<>();
		List<SalaryColumn> list=salaryColumnService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询薪酬字段
	*/
	@ApiOperation(value = "查询薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801820025651462144"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "baseSalary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "基本工资"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "constant"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_VALUE , value = "值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.DS_SOURCE , value = "数据来源" , required = false , dataTypeClass=String.class , example = "salary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.CAL_METHOD , value = "计算方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.BUSI_TYPE , value = "业务分类" , required = false , dataTypeClass=String.class , example = "base"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryColumnVOMeta.PAGE_INDEX , SalaryColumnVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryColumnServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.QUERY_LIST)
	public Result<List<SalaryColumn>> queryList(SalaryColumnVO sample) {
		
		Result<List<SalaryColumn>> result=new Result<>();
		List<SalaryColumn> list=salaryColumnService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询薪酬字段
	*/
	@ApiOperation(value = "分页查询薪酬字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryColumnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801820025651462144"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "baseSalary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "基本工资"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "constant"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.COL_VALUE , value = "值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.DS_SOURCE , value = "数据来源" , required = false , dataTypeClass=String.class , example = "salary"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.CAL_METHOD , value = "计算方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.BUSI_TYPE , value = "业务分类" , required = false , dataTypeClass=String.class , example = "base"),
		@ApiImplicitParam(name = SalaryColumnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryColumnVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryColumnServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryColumnServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryColumn>> queryPagedList(SalaryColumnVO sample) {
		
		Result<PagedList<SalaryColumn>> result=new Result<>();
		PagedList<SalaryColumn> list=salaryColumnService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}