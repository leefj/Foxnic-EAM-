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


import com.dt.platform.proxy.eam.EquipmentLabelServiceProxy;
import com.dt.platform.domain.eam.meta.EquipmentLabelVOMeta;
import com.dt.platform.domain.eam.EquipmentLabel;
import com.dt.platform.domain.eam.EquipmentLabelVO;
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
import com.dt.platform.domain.eam.meta.EquipmentLabelMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IEquipmentLabelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 设备标签接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:36:30
*/

@InDoc
@Api(tags = "设备标签")
@RestController("IotEquipmentLabelController")
public class EquipmentLabelController extends SuperController {

	@Autowired
	private IEquipmentLabelService equipmentLabelService;

	/**
	 * 添加设备标签
	*/
	@ApiOperation(value = "添加设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.NAME , value = "标签名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.VALUE , value = "标签值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLabelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.INSERT)
	public Result insert(EquipmentLabelVO equipmentLabelVO) {
		
		Result result=equipmentLabelService.insert(equipmentLabelVO,false);
		return result;
	}



	/**
	 * 删除设备标签
	*/
	@ApiOperation(value = "删除设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLabelServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  equipmentLabelService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=equipmentLabelService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除设备标签 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = EquipmentLabelServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = equipmentLabelService.hasRefers(ids);
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
			Result result=equipmentLabelService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=equipmentLabelService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新设备标签
	*/
	@ApiOperation(value = "更新设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.NAME , value = "标签名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.VALUE , value = "标签值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { EquipmentLabelVOMeta.PAGE_INDEX , EquipmentLabelVOMeta.PAGE_SIZE , EquipmentLabelVOMeta.SEARCH_FIELD , EquipmentLabelVOMeta.FUZZY_FIELD , EquipmentLabelVOMeta.SEARCH_VALUE , EquipmentLabelVOMeta.DIRTY_FIELDS , EquipmentLabelVOMeta.SORT_FIELD , EquipmentLabelVOMeta.SORT_TYPE , EquipmentLabelVOMeta.DATA_ORIGIN , EquipmentLabelVOMeta.QUERY_LOGIC , EquipmentLabelVOMeta.REQUEST_ACTION , EquipmentLabelVOMeta.IDS } )
	@SentinelResource(value = EquipmentLabelServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.UPDATE)
	public Result update(EquipmentLabelVO equipmentLabelVO) {
		
		Result result=equipmentLabelService.update(equipmentLabelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存设备标签
	*/
	@ApiOperation(value = "保存设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.NAME , value = "标签名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.VALUE , value = "标签值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EquipmentLabelVOMeta.PAGE_INDEX , EquipmentLabelVOMeta.PAGE_SIZE , EquipmentLabelVOMeta.SEARCH_FIELD , EquipmentLabelVOMeta.FUZZY_FIELD , EquipmentLabelVOMeta.SEARCH_VALUE , EquipmentLabelVOMeta.DIRTY_FIELDS , EquipmentLabelVOMeta.SORT_FIELD , EquipmentLabelVOMeta.SORT_TYPE , EquipmentLabelVOMeta.DATA_ORIGIN , EquipmentLabelVOMeta.QUERY_LOGIC , EquipmentLabelVOMeta.REQUEST_ACTION , EquipmentLabelVOMeta.IDS } )
	@SentinelResource(value = EquipmentLabelServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.SAVE)
	public Result save(EquipmentLabelVO equipmentLabelVO) {
		
		Result result=equipmentLabelService.save(equipmentLabelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取设备标签
	*/
	@ApiOperation(value = "获取设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLabelServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.GET_BY_ID)
	public Result<EquipmentLabel> getById(String id) {
		
		Result<EquipmentLabel> result=new Result<>();
		EquipmentLabel equipmentLabel=equipmentLabelService.getById(id);
		result.success(true).data(equipmentLabel);
		return result;
	}


	/**
	 * 批量获取设备标签 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取设备标签")
		@ApiImplicitParams({
				@ApiImplicitParam(name = EquipmentLabelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = EquipmentLabelServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.GET_BY_IDS)
	public Result<List<EquipmentLabel>> getByIds(List<String> ids) {
		
		Result<List<EquipmentLabel>> result=new Result<>();
		List<EquipmentLabel> list=equipmentLabelService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询设备标签
	*/
	@ApiOperation(value = "查询设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.NAME , value = "标签名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.VALUE , value = "标签值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { EquipmentLabelVOMeta.PAGE_INDEX , EquipmentLabelVOMeta.PAGE_SIZE } )
	@SentinelResource(value = EquipmentLabelServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.QUERY_LIST)
	public Result<List<EquipmentLabel>> queryList(EquipmentLabelVO sample) {
		
		Result<List<EquipmentLabel>> result=new Result<>();
		List<EquipmentLabel> list=equipmentLabelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询设备标签
	*/
	@ApiOperation(value = "分页查询设备标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLabelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.NAME , value = "标签名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.VALUE , value = "标签值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLabelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLabelServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLabelServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<EquipmentLabel>> queryPagedList(EquipmentLabelVO sample) {
		
		Result<PagedList<EquipmentLabel>> result=new Result<>();
		PagedList<EquipmentLabel> list=equipmentLabelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}