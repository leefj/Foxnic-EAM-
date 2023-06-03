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


import com.dt.platform.proxy.hr.SalaryTplPersonServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryTplPersonVOMeta;
import com.dt.platform.domain.hr.SalaryTplPerson;
import com.dt.platform.domain.hr.SalaryTplPersonVO;
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
import com.dt.platform.domain.hr.meta.SalaryTplPersonMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryTplPersonService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬人员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 23:36:05
*/

@InDoc
@Api(tags = "薪酬人员")
@RestController("HrSalaryTplPersonController")
public class SalaryTplPersonController extends SuperController {

	@Autowired
	private ISalaryTplPersonService salaryTplPersonService;

	/**
	 * 添加薪酬人员
	*/
	@ApiOperation(value = "添加薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplPersonServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.INSERT)
	public Result insert(SalaryTplPersonVO salaryTplPersonVO) {
		
		Result result=salaryTplPersonService.insert(salaryTplPersonVO,false);
		return result;
	}



	/**
	 * 删除薪酬人员
	*/
	@ApiOperation(value = "删除薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplPersonServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryTplPersonService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryTplPersonService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除薪酬人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryTplPersonServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryTplPersonService.hasRefers(ids);
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
			Result result=salaryTplPersonService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryTplPersonService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新薪酬人员
	*/
	@ApiOperation(value = "更新薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTplPersonVOMeta.PAGE_INDEX , SalaryTplPersonVOMeta.PAGE_SIZE , SalaryTplPersonVOMeta.SEARCH_FIELD , SalaryTplPersonVOMeta.FUZZY_FIELD , SalaryTplPersonVOMeta.SEARCH_VALUE , SalaryTplPersonVOMeta.DIRTY_FIELDS , SalaryTplPersonVOMeta.SORT_FIELD , SalaryTplPersonVOMeta.SORT_TYPE , SalaryTplPersonVOMeta.DATA_ORIGIN , SalaryTplPersonVOMeta.QUERY_LOGIC , SalaryTplPersonVOMeta.REQUEST_ACTION , SalaryTplPersonVOMeta.IDS } )
	@SentinelResource(value = SalaryTplPersonServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.UPDATE)
	public Result update(SalaryTplPersonVO salaryTplPersonVO) {
		
		Result result=salaryTplPersonService.update(salaryTplPersonVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存薪酬人员
	*/
	@ApiOperation(value = "保存薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryTplPersonVOMeta.PAGE_INDEX , SalaryTplPersonVOMeta.PAGE_SIZE , SalaryTplPersonVOMeta.SEARCH_FIELD , SalaryTplPersonVOMeta.FUZZY_FIELD , SalaryTplPersonVOMeta.SEARCH_VALUE , SalaryTplPersonVOMeta.DIRTY_FIELDS , SalaryTplPersonVOMeta.SORT_FIELD , SalaryTplPersonVOMeta.SORT_TYPE , SalaryTplPersonVOMeta.DATA_ORIGIN , SalaryTplPersonVOMeta.QUERY_LOGIC , SalaryTplPersonVOMeta.REQUEST_ACTION , SalaryTplPersonVOMeta.IDS } )
	@SentinelResource(value = SalaryTplPersonServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.SAVE)
	public Result save(SalaryTplPersonVO salaryTplPersonVO) {
		
		Result result=salaryTplPersonService.save(salaryTplPersonVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取薪酬人员
	*/
	@ApiOperation(value = "获取薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplPersonServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.GET_BY_ID)
	public Result<SalaryTplPerson> getById(String id) {
		
		Result<SalaryTplPerson> result=new Result<>();
		SalaryTplPerson salaryTplPerson=salaryTplPersonService.getById(id);
		result.success(true).data(salaryTplPerson);
		return result;
	}


	/**
	 * 批量获取薪酬人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取薪酬人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryTplPersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryTplPersonServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.GET_BY_IDS)
	public Result<List<SalaryTplPerson>> getByIds(List<String> ids) {
		
		Result<List<SalaryTplPerson>> result=new Result<>();
		List<SalaryTplPerson> list=salaryTplPersonService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询薪酬人员
	*/
	@ApiOperation(value = "查询薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTplPersonVOMeta.PAGE_INDEX , SalaryTplPersonVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryTplPersonServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.QUERY_LIST)
	public Result<List<SalaryTplPerson>> queryList(SalaryTplPersonVO sample) {
		
		Result<List<SalaryTplPerson>> result=new Result<>();
		List<SalaryTplPerson> list=salaryTplPersonService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询薪酬人员
	*/
	@ApiOperation(value = "分页查询薪酬人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplPersonVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplPersonServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplPersonServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryTplPerson>> queryPagedList(SalaryTplPersonVO sample) {
		
		Result<PagedList<SalaryTplPerson>> result=new Result<>();
		PagedList<SalaryTplPerson> list=salaryTplPersonService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}