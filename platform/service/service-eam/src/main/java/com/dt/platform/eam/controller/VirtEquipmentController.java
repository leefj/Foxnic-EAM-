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


import com.dt.platform.proxy.eam.VirtEquipmentServiceProxy;
import com.dt.platform.domain.eam.meta.VirtEquipmentVOMeta;
import com.dt.platform.domain.eam.VirtEquipment;
import com.dt.platform.domain.eam.VirtEquipmentVO;
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
import com.dt.platform.domain.eam.meta.VirtEquipmentMeta;
import com.dt.platform.domain.eam.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IVirtEquipmentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 虚拟设备接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-06 19:37:42
*/

@InDoc
@Api(tags = "虚拟设备")
@RestController("IotVirtEquipmentController")
public class VirtEquipmentController extends SuperController {

	@Autowired
	private IVirtEquipmentService virtEquipmentService;

	/**
	 * 添加虚拟设备
	*/
	@ApiOperation(value = "添加虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.OWNER_ID , value = "所属产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TRIGGER_TYPE , value = "触发方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.CRONTAB_VALUE , value = "crontab表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VirtEquipmentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.INSERT)
	public Result insert(VirtEquipmentVO virtEquipmentVO) {
		
		Result result=virtEquipmentService.insert(virtEquipmentVO,false);
		return result;
	}



	/**
	 * 删除虚拟设备
	*/
	@ApiOperation(value = "删除虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VirtEquipmentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  virtEquipmentService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=virtEquipmentService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除虚拟设备 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VirtEquipmentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = virtEquipmentService.hasRefers(ids);
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
			Result result=virtEquipmentService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=virtEquipmentService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新虚拟设备
	*/
	@ApiOperation(value = "更新虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.OWNER_ID , value = "所属产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TRIGGER_TYPE , value = "触发方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.CRONTAB_VALUE , value = "crontab表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VirtEquipmentVOMeta.PAGE_INDEX , VirtEquipmentVOMeta.PAGE_SIZE , VirtEquipmentVOMeta.SEARCH_FIELD , VirtEquipmentVOMeta.FUZZY_FIELD , VirtEquipmentVOMeta.SEARCH_VALUE , VirtEquipmentVOMeta.DIRTY_FIELDS , VirtEquipmentVOMeta.SORT_FIELD , VirtEquipmentVOMeta.SORT_TYPE , VirtEquipmentVOMeta.DATA_ORIGIN , VirtEquipmentVOMeta.QUERY_LOGIC , VirtEquipmentVOMeta.REQUEST_ACTION , VirtEquipmentVOMeta.IDS } )
	@SentinelResource(value = VirtEquipmentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.UPDATE)
	public Result update(VirtEquipmentVO virtEquipmentVO) {
		
		Result result=virtEquipmentService.update(virtEquipmentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存虚拟设备
	*/
	@ApiOperation(value = "保存虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.OWNER_ID , value = "所属产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TRIGGER_TYPE , value = "触发方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.CRONTAB_VALUE , value = "crontab表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VirtEquipmentVOMeta.PAGE_INDEX , VirtEquipmentVOMeta.PAGE_SIZE , VirtEquipmentVOMeta.SEARCH_FIELD , VirtEquipmentVOMeta.FUZZY_FIELD , VirtEquipmentVOMeta.SEARCH_VALUE , VirtEquipmentVOMeta.DIRTY_FIELDS , VirtEquipmentVOMeta.SORT_FIELD , VirtEquipmentVOMeta.SORT_TYPE , VirtEquipmentVOMeta.DATA_ORIGIN , VirtEquipmentVOMeta.QUERY_LOGIC , VirtEquipmentVOMeta.REQUEST_ACTION , VirtEquipmentVOMeta.IDS } )
	@SentinelResource(value = VirtEquipmentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.SAVE)
	public Result save(VirtEquipmentVO virtEquipmentVO) {
		
		Result result=virtEquipmentService.save(virtEquipmentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取虚拟设备
	*/
	@ApiOperation(value = "获取虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VirtEquipmentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.GET_BY_ID)
	public Result<VirtEquipment> getById(String id) {
		
		Result<VirtEquipment> result=new Result<>();
		VirtEquipment virtEquipment=virtEquipmentService.getById(id);
		// join 关联的对象
		virtEquipmentService.dao().fill(virtEquipment)
			.with(VirtEquipmentMeta.IOT_PRODUCT)
			.execute();
		result.success(true).data(virtEquipment);
		return result;
	}


	/**
	 * 批量获取虚拟设备 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取虚拟设备")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VirtEquipmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VirtEquipmentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.GET_BY_IDS)
	public Result<List<VirtEquipment>> getByIds(List<String> ids) {
		
		Result<List<VirtEquipment>> result=new Result<>();
		List<VirtEquipment> list=virtEquipmentService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询虚拟设备
	*/
	@ApiOperation(value = "查询虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.OWNER_ID , value = "所属产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TRIGGER_TYPE , value = "触发方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.CRONTAB_VALUE , value = "crontab表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VirtEquipmentVOMeta.PAGE_INDEX , VirtEquipmentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VirtEquipmentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.QUERY_LIST)
	public Result<List<VirtEquipment>> queryList(VirtEquipmentVO sample) {
		
		Result<List<VirtEquipment>> result=new Result<>();
		List<VirtEquipment> list=virtEquipmentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询虚拟设备
	*/
	@ApiOperation(value = "分页查询虚拟设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.OWNER_ID , value = "所属产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.TRIGGER_TYPE , value = "触发方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.CRONTAB_VALUE , value = "crontab表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtEquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VirtEquipmentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VirtEquipmentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VirtEquipment>> queryPagedList(VirtEquipmentVO sample) {
		
		Result<PagedList<VirtEquipment>> result=new Result<>();
		PagedList<VirtEquipment> list=virtEquipmentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		virtEquipmentService.dao().fill(list)
			.with(VirtEquipmentMeta.IOT_PRODUCT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}