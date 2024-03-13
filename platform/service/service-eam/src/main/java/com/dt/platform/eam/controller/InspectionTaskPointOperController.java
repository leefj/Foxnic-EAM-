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


import com.dt.platform.proxy.eam.InspectionTaskPointOperServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionTaskPointOperVOMeta;
import com.dt.platform.domain.eam.InspectionTaskPointOper;
import com.dt.platform.domain.eam.InspectionTaskPointOperVO;
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
import com.dt.platform.domain.eam.meta.InspectionTaskPointOperMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.InspectionProcessAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionTaskPointOperService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点批量操作接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 13:59:44
*/

@InDoc
@Api(tags = "巡检点批量操作")
@RestController("EamInspectionTaskPointOperController")
public class InspectionTaskPointOperController extends SuperController {

	@Autowired
	private IInspectionTaskPointOperService inspectionTaskPointOperService;

	/**
	 * 添加巡检点批量操作
	*/
	@ApiOperation(value = "添加巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.INSERT)
	public Result insert(InspectionTaskPointOperVO inspectionTaskPointOperVO) {
		
		Result result=inspectionTaskPointOperService.insert(inspectionTaskPointOperVO,false);
		return result;
	}



	/**
	 * 删除巡检点批量操作
	*/
	@ApiOperation(value = "删除巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionTaskPointOperService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionTaskPointOperService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点批量操作 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionTaskPointOperService.hasRefers(ids);
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
			Result result=inspectionTaskPointOperService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionTaskPointOperService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检点批量操作
	*/
	@ApiOperation(value = "更新巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionTaskPointOperVOMeta.PAGE_INDEX , InspectionTaskPointOperVOMeta.PAGE_SIZE , InspectionTaskPointOperVOMeta.SEARCH_FIELD , InspectionTaskPointOperVOMeta.FUZZY_FIELD , InspectionTaskPointOperVOMeta.SEARCH_VALUE , InspectionTaskPointOperVOMeta.DIRTY_FIELDS , InspectionTaskPointOperVOMeta.SORT_FIELD , InspectionTaskPointOperVOMeta.SORT_TYPE , InspectionTaskPointOperVOMeta.DATA_ORIGIN , InspectionTaskPointOperVOMeta.QUERY_LOGIC , InspectionTaskPointOperVOMeta.REQUEST_ACTION , InspectionTaskPointOperVOMeta.IDS } )
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.UPDATE)
	public Result update(InspectionTaskPointOperVO inspectionTaskPointOperVO) {
		
		Result result=inspectionTaskPointOperService.update(inspectionTaskPointOperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点批量操作
	*/
	@ApiOperation(value = "保存巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionTaskPointOperVOMeta.PAGE_INDEX , InspectionTaskPointOperVOMeta.PAGE_SIZE , InspectionTaskPointOperVOMeta.SEARCH_FIELD , InspectionTaskPointOperVOMeta.FUZZY_FIELD , InspectionTaskPointOperVOMeta.SEARCH_VALUE , InspectionTaskPointOperVOMeta.DIRTY_FIELDS , InspectionTaskPointOperVOMeta.SORT_FIELD , InspectionTaskPointOperVOMeta.SORT_TYPE , InspectionTaskPointOperVOMeta.DATA_ORIGIN , InspectionTaskPointOperVOMeta.QUERY_LOGIC , InspectionTaskPointOperVOMeta.REQUEST_ACTION , InspectionTaskPointOperVOMeta.IDS } )
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.SAVE)
	public Result save(InspectionTaskPointOperVO inspectionTaskPointOperVO) {
		
		Result result=inspectionTaskPointOperService.save(inspectionTaskPointOperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点批量操作
	*/
	@ApiOperation(value = "获取巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.GET_BY_ID)
	public Result<InspectionTaskPointOper> getById(String id) {
		
		Result<InspectionTaskPointOper> result=new Result<>();
		InspectionTaskPointOper inspectionTaskPointOper=inspectionTaskPointOperService.getById(id);
		// join 关联的对象
		inspectionTaskPointOperService.dao().fill(inspectionTaskPointOper)
			.with("inspector")
			.with("operUser")
			.with(InspectionTaskPointOperMeta.INSPECTION_PROCESS_ACTION)
			.execute();
		result.success(true).data(inspectionTaskPointOper);
		return result;
	}


	/**
	 * 批量获取巡检点批量操作 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点批量操作")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionTaskPointOperServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.GET_BY_IDS)
	public Result<List<InspectionTaskPointOper>> getByIds(List<String> ids) {
		
		Result<List<InspectionTaskPointOper>> result=new Result<>();
		List<InspectionTaskPointOper> list=inspectionTaskPointOperService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点批量操作
	*/
	@ApiOperation(value = "查询巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionTaskPointOperVOMeta.PAGE_INDEX , InspectionTaskPointOperVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.QUERY_LIST)
	public Result<List<InspectionTaskPointOper>> queryList(InspectionTaskPointOperVO sample) {
		
		Result<List<InspectionTaskPointOper>> result=new Result<>();
		List<InspectionTaskPointOper> list=inspectionTaskPointOperService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点批量操作
	*/
	@ApiOperation(value = "分页查询巡检点批量操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.POINT_STATUS , value = "巡检状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.ACTION_LABEL , value = "处理动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.INSPECTOR_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.IS_CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.CONTENT , value = "巡检结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointOperVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionTaskPointOperServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointOperServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionTaskPointOper>> queryPagedList(InspectionTaskPointOperVO sample) {
		
		Result<PagedList<InspectionTaskPointOper>> result=new Result<>();
		PagedList<InspectionTaskPointOper> list=inspectionTaskPointOperService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inspectionTaskPointOperService.dao().fill(list)
			.with("inspector")
			.with("operUser")
			.with(InspectionTaskPointOperMeta.INSPECTION_PROCESS_ACTION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}