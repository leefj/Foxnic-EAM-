package com.dt.platform.oa.controller;

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


import com.dt.platform.proxy.oa.VehicleInsuranceCompanyServiceProxy;
import com.dt.platform.domain.oa.meta.VehicleInsuranceCompanyVOMeta;
import com.dt.platform.domain.oa.VehicleInsuranceCompany;
import com.dt.platform.domain.oa.VehicleInsuranceCompanyVO;
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
import com.dt.platform.domain.oa.meta.VehicleInsuranceCompanyMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehicleInsuranceCompanyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆保险公司接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-26 07:44:20
*/

@InDoc
@Api(tags = "车辆保险公司")
@RestController("OaVehicleInsuranceCompanyController")
public class VehicleInsuranceCompanyController extends SuperController {

	@Autowired
	private IVehicleInsuranceCompanyService vehicleInsuranceCompanyService;

	/**
	 * 添加车辆保险公司
	*/
	@ApiOperation(value = "添加车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "719916205728595968"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "公司B"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "公司B"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.INSERT)
	public Result insert(VehicleInsuranceCompanyVO vehicleInsuranceCompanyVO) {
		
		Result result=vehicleInsuranceCompanyService.insert(vehicleInsuranceCompanyVO,false);
		return result;
	}



	/**
	 * 删除车辆保险公司
	*/
	@ApiOperation(value = "删除车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "719916205728595968")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  vehicleInsuranceCompanyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=vehicleInsuranceCompanyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆保险公司 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = vehicleInsuranceCompanyService.hasRefers(ids);
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
			Result result=vehicleInsuranceCompanyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=vehicleInsuranceCompanyService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "719916205728595968"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "公司B"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "公司B"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleInsuranceCompanyVOMeta.PAGE_INDEX , VehicleInsuranceCompanyVOMeta.PAGE_SIZE , VehicleInsuranceCompanyVOMeta.SEARCH_FIELD , VehicleInsuranceCompanyVOMeta.FUZZY_FIELD , VehicleInsuranceCompanyVOMeta.SEARCH_VALUE , VehicleInsuranceCompanyVOMeta.DIRTY_FIELDS , VehicleInsuranceCompanyVOMeta.SORT_FIELD , VehicleInsuranceCompanyVOMeta.SORT_TYPE , VehicleInsuranceCompanyVOMeta.DATA_ORIGIN , VehicleInsuranceCompanyVOMeta.QUERY_LOGIC , VehicleInsuranceCompanyVOMeta.REQUEST_ACTION , VehicleInsuranceCompanyVOMeta.IDS } )
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.UPDATE)
	public Result update(VehicleInsuranceCompanyVO vehicleInsuranceCompanyVO) {
		
		Result result=vehicleInsuranceCompanyService.update(vehicleInsuranceCompanyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆保险公司
	*/
	@ApiOperation(value = "保存车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "719916205728595968"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "公司B"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "公司B"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VehicleInsuranceCompanyVOMeta.PAGE_INDEX , VehicleInsuranceCompanyVOMeta.PAGE_SIZE , VehicleInsuranceCompanyVOMeta.SEARCH_FIELD , VehicleInsuranceCompanyVOMeta.FUZZY_FIELD , VehicleInsuranceCompanyVOMeta.SEARCH_VALUE , VehicleInsuranceCompanyVOMeta.DIRTY_FIELDS , VehicleInsuranceCompanyVOMeta.SORT_FIELD , VehicleInsuranceCompanyVOMeta.SORT_TYPE , VehicleInsuranceCompanyVOMeta.DATA_ORIGIN , VehicleInsuranceCompanyVOMeta.QUERY_LOGIC , VehicleInsuranceCompanyVOMeta.REQUEST_ACTION , VehicleInsuranceCompanyVOMeta.IDS } )
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.SAVE)
	public Result save(VehicleInsuranceCompanyVO vehicleInsuranceCompanyVO) {
		
		Result result=vehicleInsuranceCompanyService.save(vehicleInsuranceCompanyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆保险公司
	*/
	@ApiOperation(value = "获取车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.GET_BY_ID)
	public Result<VehicleInsuranceCompany> getById(String id) {
		
		Result<VehicleInsuranceCompany> result=new Result<>();
		VehicleInsuranceCompany vehicleInsuranceCompany=vehicleInsuranceCompanyService.getById(id);
		result.success(true).data(vehicleInsuranceCompany);
		return result;
	}


	/**
	 * 批量获取车辆保险公司 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆保险公司")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.GET_BY_IDS)
	public Result<List<VehicleInsuranceCompany>> getByIds(List<String> ids) {
		
		Result<List<VehicleInsuranceCompany>> result=new Result<>();
		List<VehicleInsuranceCompany> list=vehicleInsuranceCompanyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆保险公司
	*/
	@ApiOperation(value = "查询车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "719916205728595968"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "公司B"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "公司B"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleInsuranceCompanyVOMeta.PAGE_INDEX , VehicleInsuranceCompanyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.QUERY_LIST)
	public Result<List<VehicleInsuranceCompany>> queryList(VehicleInsuranceCompanyVO sample) {
		
		Result<List<VehicleInsuranceCompany>> result=new Result<>();
		List<VehicleInsuranceCompany> list=vehicleInsuranceCompanyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆保险公司
	*/
	@ApiOperation(value = "分页查询车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "719916205728595968"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "公司B"),
		@ApiImplicitParam(name = VehicleInsuranceCompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "公司B"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceCompanyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceCompanyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VehicleInsuranceCompany>> queryPagedList(VehicleInsuranceCompanyVO sample) {
		
		Result<PagedList<VehicleInsuranceCompany>> result=new Result<>();
		PagedList<VehicleInsuranceCompany> list=vehicleInsuranceCompanyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}