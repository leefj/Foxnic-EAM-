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


import com.dt.platform.proxy.eam.RepairOrderProcessServiceProxy;
import com.dt.platform.domain.eam.meta.RepairOrderProcessVOMeta;
import com.dt.platform.domain.eam.RepairOrderProcess;
import com.dt.platform.domain.eam.RepairOrderProcessVO;
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
import com.dt.platform.domain.eam.meta.RepairOrderProcessMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairOrderProcessService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 流转过程接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-04 06:54:32
*/

@InDoc
@Api(tags = "流转过程")
@RestController("EamRepairOrderProcessController")
public class RepairOrderProcessController extends SuperController {

	@Autowired
	private IRepairOrderProcessService repairOrderProcessService;

	/**
	 * 添加流转过程
	*/
	@ApiOperation(value = "添加流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_NAME , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.PROCESS_CONTENT , value = "执行过程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairOrderProcessServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.INSERT)
	public Result insert(RepairOrderProcessVO repairOrderProcessVO) {
		
		Result result=repairOrderProcessService.insert(repairOrderProcessVO,false);
		return result;
	}



	/**
	 * 删除流转过程
	*/
	@ApiOperation(value = "删除流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairOrderProcessServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  repairOrderProcessService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=repairOrderProcessService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除流转过程 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RepairOrderProcessServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = repairOrderProcessService.hasRefers(ids);
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
			Result result=repairOrderProcessService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=repairOrderProcessService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新流转过程
	*/
	@ApiOperation(value = "更新流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_NAME , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.PROCESS_CONTENT , value = "执行过程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RepairOrderProcessVOMeta.PAGE_INDEX , RepairOrderProcessVOMeta.PAGE_SIZE , RepairOrderProcessVOMeta.SEARCH_FIELD , RepairOrderProcessVOMeta.FUZZY_FIELD , RepairOrderProcessVOMeta.SEARCH_VALUE , RepairOrderProcessVOMeta.DIRTY_FIELDS , RepairOrderProcessVOMeta.SORT_FIELD , RepairOrderProcessVOMeta.SORT_TYPE , RepairOrderProcessVOMeta.DATA_ORIGIN , RepairOrderProcessVOMeta.QUERY_LOGIC , RepairOrderProcessVOMeta.REQUEST_ACTION , RepairOrderProcessVOMeta.IDS } )
	@SentinelResource(value = RepairOrderProcessServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.UPDATE)
	public Result update(RepairOrderProcessVO repairOrderProcessVO) {
		
		Result result=repairOrderProcessService.update(repairOrderProcessVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存流转过程
	*/
	@ApiOperation(value = "保存流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_NAME , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.PROCESS_CONTENT , value = "执行过程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderProcessVOMeta.PAGE_INDEX , RepairOrderProcessVOMeta.PAGE_SIZE , RepairOrderProcessVOMeta.SEARCH_FIELD , RepairOrderProcessVOMeta.FUZZY_FIELD , RepairOrderProcessVOMeta.SEARCH_VALUE , RepairOrderProcessVOMeta.DIRTY_FIELDS , RepairOrderProcessVOMeta.SORT_FIELD , RepairOrderProcessVOMeta.SORT_TYPE , RepairOrderProcessVOMeta.DATA_ORIGIN , RepairOrderProcessVOMeta.QUERY_LOGIC , RepairOrderProcessVOMeta.REQUEST_ACTION , RepairOrderProcessVOMeta.IDS } )
	@SentinelResource(value = RepairOrderProcessServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.SAVE)
	public Result save(RepairOrderProcessVO repairOrderProcessVO) {
		
		Result result=repairOrderProcessService.save(repairOrderProcessVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取流转过程
	*/
	@ApiOperation(value = "获取流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairOrderProcessServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.GET_BY_ID)
	public Result<RepairOrderProcess> getById(String id) {
		
		Result<RepairOrderProcess> result=new Result<>();
		RepairOrderProcess repairOrderProcess=repairOrderProcessService.getById(id);
		result.success(true).data(repairOrderProcess);
		return result;
	}


	/**
	 * 批量获取流转过程 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取流转过程")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairOrderProcessVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RepairOrderProcessServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.GET_BY_IDS)
	public Result<List<RepairOrderProcess>> getByIds(List<String> ids) {
		
		Result<List<RepairOrderProcess>> result=new Result<>();
		List<RepairOrderProcess> list=repairOrderProcessService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询流转过程
	*/
	@ApiOperation(value = "查询流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_NAME , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.PROCESS_CONTENT , value = "执行过程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RepairOrderProcessVOMeta.PAGE_INDEX , RepairOrderProcessVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairOrderProcessServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.QUERY_LIST)
	public Result<List<RepairOrderProcess>> queryList(RepairOrderProcessVO sample) {
		
		Result<List<RepairOrderProcess>> result=new Result<>();
		List<RepairOrderProcess> list=repairOrderProcessService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询流转过程
	*/
	@ApiOperation(value = "分页查询流转过程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ORDER_ID , value = "工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.USER_NAME , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.PROCESS_CONTENT , value = "执行过程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepairOrderProcessServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderProcessServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairOrderProcess>> queryPagedList(RepairOrderProcessVO sample) {
		
		Result<PagedList<RepairOrderProcess>> result=new Result<>();
		PagedList<RepairOrderProcess> list=repairOrderProcessService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}