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


import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionRouteVOMeta;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.InspectionRouteVO;
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
import com.dt.platform.domain.eam.meta.InspectionRouteMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionRouteService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检路径接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-11 07:43:03
*/

@InDoc
@Api(tags = "巡检路径")
@RestController("EamInspectionRouteController")
public class InspectionRouteController extends SuperController {

	@Autowired
	private IInspectionRouteService inspectionRouteService;

	/**
	 * 添加巡检路径
	*/
	@ApiOperation(value = "添加巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "697560681343352832"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "路线1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRouteServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.INSERT)
	public Result insert(InspectionRouteVO inspectionRouteVO) {
		
		Result result=inspectionRouteService.insert(inspectionRouteVO,false);
		return result;
	}



	/**
	 * 删除巡检路径
	*/
	@ApiOperation(value = "删除巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "697560681343352832")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRouteServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionRouteService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionRouteService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检路径 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionRouteServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionRouteService.hasRefers(ids);
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
			Result result=inspectionRouteService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionRouteService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检路径
	*/
	@ApiOperation(value = "更新巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "697560681343352832"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "路线1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionRouteVOMeta.PAGE_INDEX , InspectionRouteVOMeta.PAGE_SIZE , InspectionRouteVOMeta.SEARCH_FIELD , InspectionRouteVOMeta.FUZZY_FIELD , InspectionRouteVOMeta.SEARCH_VALUE , InspectionRouteVOMeta.DIRTY_FIELDS , InspectionRouteVOMeta.SORT_FIELD , InspectionRouteVOMeta.SORT_TYPE , InspectionRouteVOMeta.DATA_ORIGIN , InspectionRouteVOMeta.QUERY_LOGIC , InspectionRouteVOMeta.REQUEST_ACTION , InspectionRouteVOMeta.IDS } )
	@SentinelResource(value = InspectionRouteServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.UPDATE)
	public Result update(InspectionRouteVO inspectionRouteVO) {
		
		Result result=inspectionRouteService.update(inspectionRouteVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检路径
	*/
	@ApiOperation(value = "保存巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "697560681343352832"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "路线1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionRouteVOMeta.PAGE_INDEX , InspectionRouteVOMeta.PAGE_SIZE , InspectionRouteVOMeta.SEARCH_FIELD , InspectionRouteVOMeta.FUZZY_FIELD , InspectionRouteVOMeta.SEARCH_VALUE , InspectionRouteVOMeta.DIRTY_FIELDS , InspectionRouteVOMeta.SORT_FIELD , InspectionRouteVOMeta.SORT_TYPE , InspectionRouteVOMeta.DATA_ORIGIN , InspectionRouteVOMeta.QUERY_LOGIC , InspectionRouteVOMeta.REQUEST_ACTION , InspectionRouteVOMeta.IDS } )
	@SentinelResource(value = InspectionRouteServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.SAVE)
	public Result save(InspectionRouteVO inspectionRouteVO) {
		
		Result result=inspectionRouteService.save(inspectionRouteVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检路径
	*/
	@ApiOperation(value = "获取巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRouteServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.GET_BY_ID)
	public Result<InspectionRoute> getById(String id) {
		
		Result<InspectionRoute> result=new Result<>();
		InspectionRoute inspectionRoute=inspectionRouteService.getById(id);
		result.success(true).data(inspectionRoute);
		return result;
	}


	/**
	 * 批量获取巡检路径 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检路径")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionRouteVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionRouteServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.GET_BY_IDS)
	public Result<List<InspectionRoute>> getByIds(List<String> ids) {
		
		Result<List<InspectionRoute>> result=new Result<>();
		List<InspectionRoute> list=inspectionRouteService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检路径
	*/
	@ApiOperation(value = "查询巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "697560681343352832"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "路线1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionRouteVOMeta.PAGE_INDEX , InspectionRouteVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionRouteServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.QUERY_LIST)
	public Result<List<InspectionRoute>> queryList(InspectionRouteVO sample) {
		
		Result<List<InspectionRoute>> result=new Result<>();
		List<InspectionRoute> list=inspectionRouteService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检路径
	*/
	@ApiOperation(value = "分页查询巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "697560681343352832"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "路线1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionRouteServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionRoute>> queryPagedList(InspectionRouteVO sample) {
		
		Result<PagedList<InspectionRoute>> result=new Result<>();
		PagedList<InspectionRoute> list=inspectionRouteService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}