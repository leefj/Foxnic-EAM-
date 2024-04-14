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


import com.dt.platform.proxy.eam.EquipmentServiceProxy;
import com.dt.platform.domain.eam.meta.EquipmentVOMeta;
import com.dt.platform.domain.eam.Equipment;
import com.dt.platform.domain.eam.EquipmentVO;
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
import com.dt.platform.domain.eam.meta.EquipmentMeta;
import com.dt.platform.domain.eam.Product;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IEquipmentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 设备列接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:36:19
*/

@InDoc
@Api(tags = "设备列")
@RestController("IotEquipmentController")
public class EquipmentController extends SuperController {

	@Autowired
	private IEquipmentService equipmentService;

	/**
	 * 添加设备列
	*/
	@ApiOperation(value = "添加设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082820319117312"),
		@ApiImplicitParam(name = EquipmentVOMeta.PRODUCT_ID , value = "产品" , required = false , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = EquipmentVOMeta.DN , value = "设备DN" , required = false , dataTypeClass=String.class , example = "123456"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_CODE , value = "设备编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.GROUP_CODE , value = "分组" , required = false , dataTypeClass=String.class , example = "group1"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_KEY , value = "设备密钥" , required = false , dataTypeClass=String.class , example = "设备"),
		@ApiImplicitParam(name = EquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.INSERT)
	public Result insert(EquipmentVO equipmentVO) {
		
		Result result=equipmentService.insert(equipmentVO,false);
		return result;
	}



	/**
	 * 删除设备列
	*/
	@ApiOperation(value = "删除设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082820319117312")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  equipmentService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=equipmentService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除设备列 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = EquipmentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = equipmentService.hasRefers(ids);
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
			Result result=equipmentService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=equipmentService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新设备列
	*/
	@ApiOperation(value = "更新设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082820319117312"),
		@ApiImplicitParam(name = EquipmentVOMeta.PRODUCT_ID , value = "产品" , required = false , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = EquipmentVOMeta.DN , value = "设备DN" , required = false , dataTypeClass=String.class , example = "123456"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_CODE , value = "设备编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.GROUP_CODE , value = "分组" , required = false , dataTypeClass=String.class , example = "group1"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_KEY , value = "设备密钥" , required = false , dataTypeClass=String.class , example = "设备"),
		@ApiImplicitParam(name = EquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { EquipmentVOMeta.PAGE_INDEX , EquipmentVOMeta.PAGE_SIZE , EquipmentVOMeta.SEARCH_FIELD , EquipmentVOMeta.FUZZY_FIELD , EquipmentVOMeta.SEARCH_VALUE , EquipmentVOMeta.DIRTY_FIELDS , EquipmentVOMeta.SORT_FIELD , EquipmentVOMeta.SORT_TYPE , EquipmentVOMeta.DATA_ORIGIN , EquipmentVOMeta.QUERY_LOGIC , EquipmentVOMeta.REQUEST_ACTION , EquipmentVOMeta.IDS } )
	@SentinelResource(value = EquipmentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.UPDATE)
	public Result update(EquipmentVO equipmentVO) {
		
		Result result=equipmentService.update(equipmentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存设备列
	*/
	@ApiOperation(value = "保存设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082820319117312"),
		@ApiImplicitParam(name = EquipmentVOMeta.PRODUCT_ID , value = "产品" , required = false , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = EquipmentVOMeta.DN , value = "设备DN" , required = false , dataTypeClass=String.class , example = "123456"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_CODE , value = "设备编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.GROUP_CODE , value = "分组" , required = false , dataTypeClass=String.class , example = "group1"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_KEY , value = "设备密钥" , required = false , dataTypeClass=String.class , example = "设备"),
		@ApiImplicitParam(name = EquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EquipmentVOMeta.PAGE_INDEX , EquipmentVOMeta.PAGE_SIZE , EquipmentVOMeta.SEARCH_FIELD , EquipmentVOMeta.FUZZY_FIELD , EquipmentVOMeta.SEARCH_VALUE , EquipmentVOMeta.DIRTY_FIELDS , EquipmentVOMeta.SORT_FIELD , EquipmentVOMeta.SORT_TYPE , EquipmentVOMeta.DATA_ORIGIN , EquipmentVOMeta.QUERY_LOGIC , EquipmentVOMeta.REQUEST_ACTION , EquipmentVOMeta.IDS } )
	@SentinelResource(value = EquipmentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.SAVE)
	public Result save(EquipmentVO equipmentVO) {
		
		Result result=equipmentService.save(equipmentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取设备列
	*/
	@ApiOperation(value = "获取设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.GET_BY_ID)
	public Result<Equipment> getById(String id) {
		
		Result<Equipment> result=new Result<>();
		Equipment equipment=equipmentService.getById(id);
		// join 关联的对象
		equipmentService.dao().fill(equipment)
			.with(EquipmentMeta.IOT_PRODUCT)
			.with(EquipmentMeta.GROUP)
			.execute();
		result.success(true).data(equipment);
		return result;
	}


	/**
	 * 批量获取设备列 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取设备列")
		@ApiImplicitParams({
				@ApiImplicitParam(name = EquipmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = EquipmentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.GET_BY_IDS)
	public Result<List<Equipment>> getByIds(List<String> ids) {
		
		Result<List<Equipment>> result=new Result<>();
		List<Equipment> list=equipmentService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询设备列
	*/
	@ApiOperation(value = "查询设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082820319117312"),
		@ApiImplicitParam(name = EquipmentVOMeta.PRODUCT_ID , value = "产品" , required = false , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = EquipmentVOMeta.DN , value = "设备DN" , required = false , dataTypeClass=String.class , example = "123456"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_CODE , value = "设备编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.GROUP_CODE , value = "分组" , required = false , dataTypeClass=String.class , example = "group1"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_KEY , value = "设备密钥" , required = false , dataTypeClass=String.class , example = "设备"),
		@ApiImplicitParam(name = EquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { EquipmentVOMeta.PAGE_INDEX , EquipmentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = EquipmentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.QUERY_LIST)
	public Result<List<Equipment>> queryList(EquipmentVO sample) {
		
		Result<List<Equipment>> result=new Result<>();
		List<Equipment> list=equipmentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询设备列
	*/
	@ApiOperation(value = "分页查询设备列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082820319117312"),
		@ApiImplicitParam(name = EquipmentVOMeta.PRODUCT_ID , value = "产品" , required = false , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = EquipmentVOMeta.DN , value = "设备DN" , required = false , dataTypeClass=String.class , example = "123456"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_CODE , value = "设备编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.GROUP_CODE , value = "分组" , required = false , dataTypeClass=String.class , example = "group1"),
		@ApiImplicitParam(name = EquipmentVOMeta.EQUIPMENT_KEY , value = "设备密钥" , required = false , dataTypeClass=String.class , example = "设备"),
		@ApiImplicitParam(name = EquipmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Equipment>> queryPagedList(EquipmentVO sample) {
		
		Result<PagedList<Equipment>> result=new Result<>();
		PagedList<Equipment> list=equipmentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		equipmentService.dao().fill(list)
			.with(EquipmentMeta.IOT_PRODUCT)
			.with(EquipmentMeta.GROUP)
			.execute();
		result.success(true).data(list);
		return result;
	}





}