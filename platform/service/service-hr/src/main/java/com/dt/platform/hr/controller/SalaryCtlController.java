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


import com.dt.platform.proxy.hr.SalaryCtlServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryCtlVOMeta;
import com.dt.platform.domain.hr.SalaryCtl;
import com.dt.platform.domain.hr.SalaryCtlVO;
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
import com.dt.platform.domain.hr.meta.SalaryCtlMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryCtlService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬控制接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-27 18:33:34
*/

@InDoc
@Api(tags = "薪酬控制")
@RestController("HrSalaryCtlController")
public class SalaryCtlController extends SuperController {

	@Autowired
	private ISalaryCtlService salaryCtlService;

	/**
	 * 添加薪酬控制
	*/
	@ApiOperation(value = "添加薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "抵扣基数"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "type_double"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_EN , value = "是否参与" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_STR , value = "字符串数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_D , value = "浮点数值" , required = false , dataTypeClass=BigDecimal.class , example = "5000.00"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryCtlServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.INSERT)
	public Result insert(SalaryCtlVO salaryCtlVO) {
		
		Result result=salaryCtlService.insert(salaryCtlVO,false);
		return result;
	}



	/**
	 * 删除薪酬控制
	*/
	@ApiOperation(value = "删除薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "deduction_base")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryCtlServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryCtlService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryCtlService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除薪酬控制 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryCtlServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryCtlService.hasRefers(ids);
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
			Result result=salaryCtlService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryCtlService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新薪酬控制
	*/
	@ApiOperation(value = "更新薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "抵扣基数"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "type_double"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_EN , value = "是否参与" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_STR , value = "字符串数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_D , value = "浮点数值" , required = false , dataTypeClass=BigDecimal.class , example = "5000.00"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryCtlVOMeta.PAGE_INDEX , SalaryCtlVOMeta.PAGE_SIZE , SalaryCtlVOMeta.SEARCH_FIELD , SalaryCtlVOMeta.FUZZY_FIELD , SalaryCtlVOMeta.SEARCH_VALUE , SalaryCtlVOMeta.DIRTY_FIELDS , SalaryCtlVOMeta.SORT_FIELD , SalaryCtlVOMeta.SORT_TYPE , SalaryCtlVOMeta.DATA_ORIGIN , SalaryCtlVOMeta.QUERY_LOGIC , SalaryCtlVOMeta.REQUEST_ACTION , SalaryCtlVOMeta.IDS } )
	@SentinelResource(value = SalaryCtlServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.UPDATE)
	public Result update(SalaryCtlVO salaryCtlVO) {
		
		Result result=salaryCtlService.update(salaryCtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存薪酬控制
	*/
	@ApiOperation(value = "保存薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "抵扣基数"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "type_double"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_EN , value = "是否参与" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_STR , value = "字符串数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_D , value = "浮点数值" , required = false , dataTypeClass=BigDecimal.class , example = "5000.00"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryCtlVOMeta.PAGE_INDEX , SalaryCtlVOMeta.PAGE_SIZE , SalaryCtlVOMeta.SEARCH_FIELD , SalaryCtlVOMeta.FUZZY_FIELD , SalaryCtlVOMeta.SEARCH_VALUE , SalaryCtlVOMeta.DIRTY_FIELDS , SalaryCtlVOMeta.SORT_FIELD , SalaryCtlVOMeta.SORT_TYPE , SalaryCtlVOMeta.DATA_ORIGIN , SalaryCtlVOMeta.QUERY_LOGIC , SalaryCtlVOMeta.REQUEST_ACTION , SalaryCtlVOMeta.IDS } )
	@SentinelResource(value = SalaryCtlServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.SAVE)
	public Result save(SalaryCtlVO salaryCtlVO) {
		
		Result result=salaryCtlService.save(salaryCtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取薪酬控制
	*/
	@ApiOperation(value = "获取薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryCtlServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.GET_BY_ID)
	public Result<SalaryCtl> getById(String id) {
		
		Result<SalaryCtl> result=new Result<>();
		SalaryCtl salaryCtl=salaryCtlService.getById(id);
		result.success(true).data(salaryCtl);
		return result;
	}


	/**
	 * 批量获取薪酬控制 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取薪酬控制")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryCtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryCtlServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.GET_BY_IDS)
	public Result<List<SalaryCtl>> getByIds(List<String> ids) {
		
		Result<List<SalaryCtl>> result=new Result<>();
		List<SalaryCtl> list=salaryCtlService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询薪酬控制
	*/
	@ApiOperation(value = "查询薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "抵扣基数"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "type_double"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_EN , value = "是否参与" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_STR , value = "字符串数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_D , value = "浮点数值" , required = false , dataTypeClass=BigDecimal.class , example = "5000.00"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryCtlVOMeta.PAGE_INDEX , SalaryCtlVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryCtlServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.QUERY_LIST)
	public Result<List<SalaryCtl>> queryList(SalaryCtlVO sample) {
		
		Result<List<SalaryCtl>> result=new Result<>();
		List<SalaryCtl> list=salaryCtlService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询薪酬控制
	*/
	@ApiOperation(value = "分页查询薪酬控制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryCtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "deduction_base"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "抵扣基数"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "type_double"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_EN , value = "是否参与" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_STR , value = "字符串数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.VALUE_D , value = "浮点数值" , required = false , dataTypeClass=BigDecimal.class , example = "5000.00"),
		@ApiImplicitParam(name = SalaryCtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryCtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryCtlServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryCtlServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryCtl>> queryPagedList(SalaryCtlVO sample) {
		
		Result<PagedList<SalaryCtl>> result=new Result<>();
		PagedList<SalaryCtl> list=salaryCtlService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}