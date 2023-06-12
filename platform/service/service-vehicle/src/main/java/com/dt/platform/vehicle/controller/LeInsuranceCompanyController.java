package com.dt.platform.vehicle.controller;

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


import com.dt.platform.proxy.vehicle.LeInsuranceCompanyServiceProxy;
import com.dt.platform.domain.vehicle.meta.LeInsuranceCompanyVOMeta;
import com.dt.platform.domain.vehicle.LeInsuranceCompany;
import com.dt.platform.domain.vehicle.LeInsuranceCompanyVO;
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
import com.dt.platform.domain.vehicle.meta.LeInsuranceCompanyMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.ILeInsuranceCompanyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆保险公司接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 11:21:08
*/

@InDoc
@Api(tags = "车辆保险公司")
@RestController("O1212aVehicleInsuranceCompanyController")
public class LeInsuranceCompanyController extends SuperController {

	@Autowired
	private ILeInsuranceCompanyService leInsuranceCompanyService;

	/**
	 * 添加车辆保险公司
	*/
	@ApiOperation(value = "添加车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.INSERT)
	public Result insert(LeInsuranceCompanyVO leInsuranceCompanyVO) {
		
		Result result=leInsuranceCompanyService.insert(leInsuranceCompanyVO,false);
		return result;
	}



	/**
	 * 删除车辆保险公司
	*/
	@ApiOperation(value = "删除车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  leInsuranceCompanyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=leInsuranceCompanyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆保险公司 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = leInsuranceCompanyService.hasRefers(ids);
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
			Result result=leInsuranceCompanyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=leInsuranceCompanyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆保险公司
	*/
	@ApiOperation(value = "更新车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LeInsuranceCompanyVOMeta.PAGE_INDEX , LeInsuranceCompanyVOMeta.PAGE_SIZE , LeInsuranceCompanyVOMeta.SEARCH_FIELD , LeInsuranceCompanyVOMeta.FUZZY_FIELD , LeInsuranceCompanyVOMeta.SEARCH_VALUE , LeInsuranceCompanyVOMeta.DIRTY_FIELDS , LeInsuranceCompanyVOMeta.SORT_FIELD , LeInsuranceCompanyVOMeta.SORT_TYPE , LeInsuranceCompanyVOMeta.DATA_ORIGIN , LeInsuranceCompanyVOMeta.QUERY_LOGIC , LeInsuranceCompanyVOMeta.REQUEST_ACTION , LeInsuranceCompanyVOMeta.IDS } )
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.UPDATE)
	public Result update(LeInsuranceCompanyVO leInsuranceCompanyVO) {
		
		Result result=leInsuranceCompanyService.update(leInsuranceCompanyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆保险公司
	*/
	@ApiOperation(value = "保存车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LeInsuranceCompanyVOMeta.PAGE_INDEX , LeInsuranceCompanyVOMeta.PAGE_SIZE , LeInsuranceCompanyVOMeta.SEARCH_FIELD , LeInsuranceCompanyVOMeta.FUZZY_FIELD , LeInsuranceCompanyVOMeta.SEARCH_VALUE , LeInsuranceCompanyVOMeta.DIRTY_FIELDS , LeInsuranceCompanyVOMeta.SORT_FIELD , LeInsuranceCompanyVOMeta.SORT_TYPE , LeInsuranceCompanyVOMeta.DATA_ORIGIN , LeInsuranceCompanyVOMeta.QUERY_LOGIC , LeInsuranceCompanyVOMeta.REQUEST_ACTION , LeInsuranceCompanyVOMeta.IDS } )
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.SAVE)
	public Result save(LeInsuranceCompanyVO leInsuranceCompanyVO) {
		
		Result result=leInsuranceCompanyService.save(leInsuranceCompanyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆保险公司
	*/
	@ApiOperation(value = "获取车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.GET_BY_ID)
	public Result<LeInsuranceCompany> getById(String id) {
		
		Result<LeInsuranceCompany> result=new Result<>();
		LeInsuranceCompany leInsuranceCompany=leInsuranceCompanyService.getById(id);
		result.success(true).data(leInsuranceCompany);
		return result;
	}


	/**
	 * 批量获取车辆保险公司 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆保险公司")
		@ApiImplicitParams({
				@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = LeInsuranceCompanyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.GET_BY_IDS)
	public Result<List<LeInsuranceCompany>> getByIds(List<String> ids) {
		
		Result<List<LeInsuranceCompany>> result=new Result<>();
		List<LeInsuranceCompany> list=leInsuranceCompanyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆保险公司
	*/
	@ApiOperation(value = "查询车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LeInsuranceCompanyVOMeta.PAGE_INDEX , LeInsuranceCompanyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.QUERY_LIST)
	public Result<List<LeInsuranceCompany>> queryList(LeInsuranceCompanyVO sample) {
		
		Result<List<LeInsuranceCompany>> result=new Result<>();
		List<LeInsuranceCompany> list=leInsuranceCompanyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆保险公司
	*/
	@ApiOperation(value = "分页查询车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceCompanyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceCompanyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<LeInsuranceCompany>> queryPagedList(LeInsuranceCompanyVO sample) {
		
		Result<PagedList<LeInsuranceCompany>> result=new Result<>();
		PagedList<LeInsuranceCompany> list=leInsuranceCompanyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}