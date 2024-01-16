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


import com.dt.platform.proxy.eam.WorkOrderMsgServiceProxy;
import com.dt.platform.domain.eam.meta.WorkOrderMsgVOMeta;
import com.dt.platform.domain.eam.WorkOrderMsg;
import com.dt.platform.domain.eam.WorkOrderMsgVO;
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
import com.dt.platform.domain.eam.meta.WorkOrderMsgMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IWorkOrderMsgService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 工单消息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 10:36:56
*/

@InDoc
@Api(tags = "工单消息")
@RestController("EamWorkOrderMsgController")
public class WorkOrderMsgController extends SuperController {

	@Autowired
	private IWorkOrderMsgService workOrderMsgService;

	/**
	 * 添加工单消息
	*/
	@ApiOperation(value = "添加工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.CONTENT , value = "问题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkOrderMsgServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.INSERT)
	public Result insert(WorkOrderMsgVO workOrderMsgVO) {
		
		Result result=workOrderMsgService.insert(workOrderMsgVO,false);
		return result;
	}



	/**
	 * 删除工单消息
	*/
	@ApiOperation(value = "删除工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkOrderMsgServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  workOrderMsgService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=workOrderMsgService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除工单消息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = WorkOrderMsgServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = workOrderMsgService.hasRefers(ids);
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
			Result result=workOrderMsgService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=workOrderMsgService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新工单消息
	*/
	@ApiOperation(value = "更新工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.CONTENT , value = "问题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { WorkOrderMsgVOMeta.PAGE_INDEX , WorkOrderMsgVOMeta.PAGE_SIZE , WorkOrderMsgVOMeta.SEARCH_FIELD , WorkOrderMsgVOMeta.FUZZY_FIELD , WorkOrderMsgVOMeta.SEARCH_VALUE , WorkOrderMsgVOMeta.DIRTY_FIELDS , WorkOrderMsgVOMeta.SORT_FIELD , WorkOrderMsgVOMeta.SORT_TYPE , WorkOrderMsgVOMeta.DATA_ORIGIN , WorkOrderMsgVOMeta.QUERY_LOGIC , WorkOrderMsgVOMeta.REQUEST_ACTION , WorkOrderMsgVOMeta.IDS } )
	@SentinelResource(value = WorkOrderMsgServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.UPDATE)
	public Result update(WorkOrderMsgVO workOrderMsgVO) {
		
		Result result=workOrderMsgService.update(workOrderMsgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存工单消息
	*/
	@ApiOperation(value = "保存工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.CONTENT , value = "问题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WorkOrderMsgVOMeta.PAGE_INDEX , WorkOrderMsgVOMeta.PAGE_SIZE , WorkOrderMsgVOMeta.SEARCH_FIELD , WorkOrderMsgVOMeta.FUZZY_FIELD , WorkOrderMsgVOMeta.SEARCH_VALUE , WorkOrderMsgVOMeta.DIRTY_FIELDS , WorkOrderMsgVOMeta.SORT_FIELD , WorkOrderMsgVOMeta.SORT_TYPE , WorkOrderMsgVOMeta.DATA_ORIGIN , WorkOrderMsgVOMeta.QUERY_LOGIC , WorkOrderMsgVOMeta.REQUEST_ACTION , WorkOrderMsgVOMeta.IDS } )
	@SentinelResource(value = WorkOrderMsgServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.SAVE)
	public Result save(WorkOrderMsgVO workOrderMsgVO) {
		
		Result result=workOrderMsgService.save(workOrderMsgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取工单消息
	*/
	@ApiOperation(value = "获取工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkOrderMsgServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.GET_BY_ID)
	public Result<WorkOrderMsg> getById(String id) {
		
		Result<WorkOrderMsg> result=new Result<>();
		WorkOrderMsg workOrderMsg=workOrderMsgService.getById(id);
		// join 关联的对象
		workOrderMsgService.dao().fill(workOrderMsg)
			.with("user")
			.execute();
		result.success(true).data(workOrderMsg);
		return result;
	}


	/**
	 * 批量获取工单消息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取工单消息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = WorkOrderMsgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = WorkOrderMsgServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.GET_BY_IDS)
	public Result<List<WorkOrderMsg>> getByIds(List<String> ids) {
		
		Result<List<WorkOrderMsg>> result=new Result<>();
		List<WorkOrderMsg> list=workOrderMsgService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询工单消息
	*/
	@ApiOperation(value = "查询工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.CONTENT , value = "问题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { WorkOrderMsgVOMeta.PAGE_INDEX , WorkOrderMsgVOMeta.PAGE_SIZE } )
	@SentinelResource(value = WorkOrderMsgServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.QUERY_LIST)
	public Result<List<WorkOrderMsg>> queryList(WorkOrderMsgVO sample) {
		
		Result<List<WorkOrderMsg>> result=new Result<>();
		List<WorkOrderMsg> list=workOrderMsgService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询工单消息
	*/
	@ApiOperation(value = "分页查询工单消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.CONTENT , value = "问题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkOrderMsgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkOrderMsgServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkOrderMsgServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<WorkOrderMsg>> queryPagedList(WorkOrderMsgVO sample) {
		
		Result<PagedList<WorkOrderMsg>> result=new Result<>();
		PagedList<WorkOrderMsg> list=workOrderMsgService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		workOrderMsgService.dao().fill(list)
			.with("user")
			.execute();
		result.success(true).data(list);
		return result;
	}





}