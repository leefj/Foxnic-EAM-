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


import com.dt.platform.proxy.eam.DeviceAssociateServiceProxy;
import com.dt.platform.domain.eam.meta.DeviceAssociateVOMeta;
import com.dt.platform.domain.eam.DeviceAssociate;
import com.dt.platform.domain.eam.DeviceAssociateVO;
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
import com.dt.platform.domain.eam.meta.DeviceAssociateMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IDeviceAssociateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 备件关联接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:44:08
*/

@InDoc
@Api(tags = "备件关联")
@RestController("EamDeviceAssociateController")
public class DeviceAssociateController extends SuperController {

	@Autowired
	private IDeviceAssociateService deviceAssociateService;

	/**
	 * 添加备件关联
	*/
	@ApiOperation(value = "添加备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ASSOCIATE_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceAssociateServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.INSERT)
	public Result insert(DeviceAssociateVO deviceAssociateVO) {
		
		Result result=deviceAssociateService.insert(deviceAssociateVO,false);
		return result;
	}



	/**
	 * 删除备件关联
	*/
	@ApiOperation(value = "删除备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceAssociateServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  deviceAssociateService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=deviceAssociateService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除备件关联 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DeviceAssociateServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = deviceAssociateService.hasRefers(ids);
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
			Result result=deviceAssociateService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=deviceAssociateService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新备件关联
	*/
	@ApiOperation(value = "更新备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ASSOCIATE_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceAssociateVOMeta.PAGE_INDEX , DeviceAssociateVOMeta.PAGE_SIZE , DeviceAssociateVOMeta.SEARCH_FIELD , DeviceAssociateVOMeta.FUZZY_FIELD , DeviceAssociateVOMeta.SEARCH_VALUE , DeviceAssociateVOMeta.DIRTY_FIELDS , DeviceAssociateVOMeta.SORT_FIELD , DeviceAssociateVOMeta.SORT_TYPE , DeviceAssociateVOMeta.DATA_ORIGIN , DeviceAssociateVOMeta.QUERY_LOGIC , DeviceAssociateVOMeta.REQUEST_ACTION , DeviceAssociateVOMeta.IDS } )
	@SentinelResource(value = DeviceAssociateServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.UPDATE)
	public Result update(DeviceAssociateVO deviceAssociateVO) {
		
		Result result=deviceAssociateService.update(deviceAssociateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存备件关联
	*/
	@ApiOperation(value = "保存备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ASSOCIATE_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DeviceAssociateVOMeta.PAGE_INDEX , DeviceAssociateVOMeta.PAGE_SIZE , DeviceAssociateVOMeta.SEARCH_FIELD , DeviceAssociateVOMeta.FUZZY_FIELD , DeviceAssociateVOMeta.SEARCH_VALUE , DeviceAssociateVOMeta.DIRTY_FIELDS , DeviceAssociateVOMeta.SORT_FIELD , DeviceAssociateVOMeta.SORT_TYPE , DeviceAssociateVOMeta.DATA_ORIGIN , DeviceAssociateVOMeta.QUERY_LOGIC , DeviceAssociateVOMeta.REQUEST_ACTION , DeviceAssociateVOMeta.IDS } )
	@SentinelResource(value = DeviceAssociateServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.SAVE)
	public Result save(DeviceAssociateVO deviceAssociateVO) {
		
		Result result=deviceAssociateService.save(deviceAssociateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取备件关联
	*/
	@ApiOperation(value = "获取备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceAssociateServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.GET_BY_ID)
	public Result<DeviceAssociate> getById(String id) {
		
		Result<DeviceAssociate> result=new Result<>();
		DeviceAssociate deviceAssociate=deviceAssociateService.getById(id);
		result.success(true).data(deviceAssociate);
		return result;
	}


	/**
	 * 批量获取备件关联 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取备件关联")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DeviceAssociateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DeviceAssociateServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.GET_BY_IDS)
	public Result<List<DeviceAssociate>> getByIds(List<String> ids) {
		
		Result<List<DeviceAssociate>> result=new Result<>();
		List<DeviceAssociate> list=deviceAssociateService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询备件关联
	*/
	@ApiOperation(value = "查询备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ASSOCIATE_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceAssociateVOMeta.PAGE_INDEX , DeviceAssociateVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DeviceAssociateServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.QUERY_LIST)
	public Result<List<DeviceAssociate>> queryList(DeviceAssociateVO sample) {
		
		Result<List<DeviceAssociate>> result=new Result<>();
		List<DeviceAssociate> list=deviceAssociateService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询备件关联
	*/
	@ApiOperation(value = "分页查询备件关联")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.ASSOCIATE_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceAssociateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceAssociateServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceAssociateServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DeviceAssociate>> queryPagedList(DeviceAssociateVO sample) {
		
		Result<PagedList<DeviceAssociate>> result=new Result<>();
		PagedList<DeviceAssociate> list=deviceAssociateService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}