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


import com.dt.platform.proxy.oa.VehiclePositionServiceProxy;
import com.dt.platform.domain.oa.meta.VehiclePositionVOMeta;
import com.dt.platform.domain.oa.VehiclePosition;
import com.dt.platform.domain.oa.VehiclePositionVO;
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
import com.dt.platform.domain.oa.meta.VehiclePositionMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehiclePositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆位置接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:44:22
*/

@InDoc
@Api(tags = "车辆位置")
@RestController("OaVehiclePositionController")
public class VehiclePositionController extends SuperController {

	@Autowired
	private IVehiclePositionService vehiclePositionService;

	/**
	 * 添加车辆位置
	*/
	@ApiOperation(value = "添加车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY_NAME , value = "路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehiclePositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.INSERT)
	public Result insert(VehiclePositionVO vehiclePositionVO) {
		
		Result result=vehiclePositionService.insert(vehiclePositionVO,false);
		return result;
	}



	/**
	 * 删除车辆位置
	*/
	@ApiOperation(value = "删除车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehiclePositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  vehiclePositionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=vehiclePositionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆位置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VehiclePositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = vehiclePositionService.hasRefers(ids);
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
			Result result=vehiclePositionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=vehiclePositionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆位置
	*/
	@ApiOperation(value = "更新车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY_NAME , value = "路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehiclePositionVOMeta.PAGE_INDEX , VehiclePositionVOMeta.PAGE_SIZE , VehiclePositionVOMeta.SEARCH_FIELD , VehiclePositionVOMeta.FUZZY_FIELD , VehiclePositionVOMeta.SEARCH_VALUE , VehiclePositionVOMeta.DIRTY_FIELDS , VehiclePositionVOMeta.SORT_FIELD , VehiclePositionVOMeta.SORT_TYPE , VehiclePositionVOMeta.DATA_ORIGIN , VehiclePositionVOMeta.QUERY_LOGIC , VehiclePositionVOMeta.REQUEST_ACTION , VehiclePositionVOMeta.IDS } )
	@SentinelResource(value = VehiclePositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.UPDATE)
	public Result update(VehiclePositionVO vehiclePositionVO) {
		
		Result result=vehiclePositionService.update(vehiclePositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆位置
	*/
	@ApiOperation(value = "保存车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY_NAME , value = "路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VehiclePositionVOMeta.PAGE_INDEX , VehiclePositionVOMeta.PAGE_SIZE , VehiclePositionVOMeta.SEARCH_FIELD , VehiclePositionVOMeta.FUZZY_FIELD , VehiclePositionVOMeta.SEARCH_VALUE , VehiclePositionVOMeta.DIRTY_FIELDS , VehiclePositionVOMeta.SORT_FIELD , VehiclePositionVOMeta.SORT_TYPE , VehiclePositionVOMeta.DATA_ORIGIN , VehiclePositionVOMeta.QUERY_LOGIC , VehiclePositionVOMeta.REQUEST_ACTION , VehiclePositionVOMeta.IDS } )
	@SentinelResource(value = VehiclePositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.SAVE)
	public Result save(VehiclePositionVO vehiclePositionVO) {
		
		Result result=vehiclePositionService.save(vehiclePositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆位置
	*/
	@ApiOperation(value = "获取车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehiclePositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.GET_BY_ID)
	public Result<VehiclePosition> getById(String id) {
		
		Result<VehiclePosition> result=new Result<>();
		VehiclePosition vehiclePosition=vehiclePositionService.getById(id);
		result.success(true).data(vehiclePosition);
		return result;
	}


	/**
	 * 批量获取车辆位置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆位置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VehiclePositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VehiclePositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.GET_BY_IDS)
	public Result<List<VehiclePosition>> getByIds(List<String> ids) {
		
		Result<List<VehiclePosition>> result=new Result<>();
		List<VehiclePosition> list=vehiclePositionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆位置
	*/
	@ApiOperation(value = "查询车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY_NAME , value = "路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehiclePositionVOMeta.PAGE_INDEX , VehiclePositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VehiclePositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.QUERY_LIST)
	public Result<List<VehiclePosition>> queryList(VehiclePositionVO sample) {
		
		Result<List<VehiclePosition>> result=new Result<>();
		List<VehiclePosition> list=vehiclePositionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆位置
	*/
	@ApiOperation(value = "分页查询车辆位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehiclePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.HIERARCHY_NAME , value = "路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VehiclePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehiclePositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehiclePositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VehiclePosition>> queryPagedList(VehiclePositionVO sample) {
		
		Result<PagedList<VehiclePosition>> result=new Result<>();
		PagedList<VehiclePosition> list=vehiclePositionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}