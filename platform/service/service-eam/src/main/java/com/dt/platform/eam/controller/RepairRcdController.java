package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.RepairRcdServiceProxy;
import com.dt.platform.domain.eam.meta.RepairRcdVOMeta;
import com.dt.platform.domain.eam.RepairRcd;
import com.dt.platform.domain.eam.RepairRcdVO;
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
import com.dt.platform.domain.eam.meta.RepairRcdMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维修记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-24 08:15:59
*/

@InDoc
@Api(tags = "维修记录")
@RestController("EamRepairRcdController")
public class RepairRcdController extends SuperController {

	@Autowired
	private IRepairRcdService repairRcdService;

	/**
	 * 添加维修记录
	*/
	@ApiOperation(value = "添加维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "742720220023488512"),
		@ApiImplicitParam(name = RepairRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class , example = "ROD202324121224375"),
		@ApiImplicitParam(name = RepairRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class , example = "703902227277807616"),
		@ApiImplicitParam(name = RepairRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "完成维修"),
		@ApiImplicitParam(name = RepairRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class , example = "2023-08-12 12:25:00"),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.INSERT)
	public Result insert(RepairRcdVO repairRcdVO) {
		
		Result result=repairRcdService.insert(repairRcdVO,false);
		return result;
	}



	/**
	 * 删除维修记录
	*/
	@ApiOperation(value = "删除维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "742720220023488512")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  repairRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=repairRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除维修记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RepairRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = repairRcdService.hasRefers(ids);
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
			Result result=repairRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=repairRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新维修记录
	*/
	@ApiOperation(value = "更新维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "742720220023488512"),
		@ApiImplicitParam(name = RepairRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class , example = "ROD202324121224375"),
		@ApiImplicitParam(name = RepairRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class , example = "703902227277807616"),
		@ApiImplicitParam(name = RepairRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "完成维修"),
		@ApiImplicitParam(name = RepairRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class , example = "2023-08-12 12:25:00"),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RepairRcdVOMeta.PAGE_INDEX , RepairRcdVOMeta.PAGE_SIZE , RepairRcdVOMeta.SEARCH_FIELD , RepairRcdVOMeta.FUZZY_FIELD , RepairRcdVOMeta.SEARCH_VALUE , RepairRcdVOMeta.DIRTY_FIELDS , RepairRcdVOMeta.SORT_FIELD , RepairRcdVOMeta.SORT_TYPE , RepairRcdVOMeta.DATA_ORIGIN , RepairRcdVOMeta.QUERY_LOGIC , RepairRcdVOMeta.REQUEST_ACTION , RepairRcdVOMeta.IDS } )
	@SentinelResource(value = RepairRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.UPDATE)
	public Result update(RepairRcdVO repairRcdVO) {
		
		Result result=repairRcdService.update(repairRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存维修记录
	*/
	@ApiOperation(value = "保存维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "742720220023488512"),
		@ApiImplicitParam(name = RepairRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class , example = "ROD202324121224375"),
		@ApiImplicitParam(name = RepairRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class , example = "703902227277807616"),
		@ApiImplicitParam(name = RepairRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "完成维修"),
		@ApiImplicitParam(name = RepairRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class , example = "2023-08-12 12:25:00"),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairRcdVOMeta.PAGE_INDEX , RepairRcdVOMeta.PAGE_SIZE , RepairRcdVOMeta.SEARCH_FIELD , RepairRcdVOMeta.FUZZY_FIELD , RepairRcdVOMeta.SEARCH_VALUE , RepairRcdVOMeta.DIRTY_FIELDS , RepairRcdVOMeta.SORT_FIELD , RepairRcdVOMeta.SORT_TYPE , RepairRcdVOMeta.DATA_ORIGIN , RepairRcdVOMeta.QUERY_LOGIC , RepairRcdVOMeta.REQUEST_ACTION , RepairRcdVOMeta.IDS } )
	@SentinelResource(value = RepairRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.SAVE)
	public Result save(RepairRcdVO repairRcdVO) {
		
		Result result=repairRcdService.save(repairRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取维修记录
	*/
	@ApiOperation(value = "获取维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.GET_BY_ID)
	public Result<RepairRcd> getById(String id) {
		
		Result<RepairRcd> result=new Result<>();
		RepairRcd repairRcd=repairRcdService.getById(id);
		result.success(true).data(repairRcd);
		return result;
	}


	/**
	 * 批量获取维修记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取维修记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RepairRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.GET_BY_IDS)
	public Result<List<RepairRcd>> getByIds(List<String> ids) {
		
		Result<List<RepairRcd>> result=new Result<>();
		List<RepairRcd> list=repairRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询维修记录
	*/
	@ApiOperation(value = "查询维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "742720220023488512"),
		@ApiImplicitParam(name = RepairRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class , example = "ROD202324121224375"),
		@ApiImplicitParam(name = RepairRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class , example = "703902227277807616"),
		@ApiImplicitParam(name = RepairRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "完成维修"),
		@ApiImplicitParam(name = RepairRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class , example = "2023-08-12 12:25:00"),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RepairRcdVOMeta.PAGE_INDEX , RepairRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.QUERY_LIST)
	public Result<List<RepairRcd>> queryList(RepairRcdVO sample) {
		
		Result<List<RepairRcd>> result=new Result<>();
		List<RepairRcd> list=repairRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询维修记录
	*/
	@ApiOperation(value = "分页查询维修记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "742720220023488512"),
		@ApiImplicitParam(name = RepairRcdVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class , example = "ROD202324121224375"),
		@ApiImplicitParam(name = RepairRcdVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class , example = "703902227277807616"),
		@ApiImplicitParam(name = RepairRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "完成维修"),
		@ApiImplicitParam(name = RepairRcdVOMeta.RCD_TIME , value = "操作日期" , required = false , dataTypeClass=Date.class , example = "2023-08-12 12:25:00"),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_ID , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.OPER_USER_NAME , value = "操作人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairRcd>> queryPagedList(RepairRcdVO sample) {
		
		Result<PagedList<RepairRcd>> result=new Result<>();
		PagedList<RepairRcd> list=repairRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}