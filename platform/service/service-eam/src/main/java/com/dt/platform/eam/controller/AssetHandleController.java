package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
import org.github.foxnic.web.domain.hrm.Person;
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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.dt.platform.proxy.eam.AssetHandleServiceProxy;
import com.dt.platform.domain.eam.meta.AssetHandleVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetHandleMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetHandleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产处置接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-30 12:55:54
*/

@InDoc
@Api(tags = "资产处置")
@RestController("EamAssetHandleController")
public class AssetHandleController extends SuperController implements BpmCallbackController{

	@Autowired
	private IAssetHandleService assetHandleService;

	/**
	 * 添加资产处置
	*/
	@ApiOperation(value = "添加资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.INSERT)
	public Result insert(AssetHandleVO assetHandleVO) {
		
		Result result=assetHandleService.insert(assetHandleVO,false);
		return result;
	}



	/**
	 * 删除资产处置
	*/
	@ApiOperation(value = "删除资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetHandleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetHandleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产处置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetHandleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetHandleService.hasRefers(ids);
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
			Result result=assetHandleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetHandleService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新资产处置
	*/
	@ApiOperation(value = "更新资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetHandleVOMeta.PAGE_INDEX , AssetHandleVOMeta.PAGE_SIZE , AssetHandleVOMeta.SEARCH_FIELD , AssetHandleVOMeta.FUZZY_FIELD , AssetHandleVOMeta.SEARCH_VALUE , AssetHandleVOMeta.DIRTY_FIELDS , AssetHandleVOMeta.SORT_FIELD , AssetHandleVOMeta.SORT_TYPE , AssetHandleVOMeta.DATA_ORIGIN , AssetHandleVOMeta.QUERY_LOGIC , AssetHandleVOMeta.REQUEST_ACTION , AssetHandleVOMeta.IDS } )
	@SentinelResource(value = AssetHandleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.UPDATE)
	public Result update(AssetHandleVO assetHandleVO) {
		
		Result result=assetHandleService.update(assetHandleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产处置
	*/
	@ApiOperation(value = "保存资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetHandleVOMeta.PAGE_INDEX , AssetHandleVOMeta.PAGE_SIZE , AssetHandleVOMeta.SEARCH_FIELD , AssetHandleVOMeta.FUZZY_FIELD , AssetHandleVOMeta.SEARCH_VALUE , AssetHandleVOMeta.DIRTY_FIELDS , AssetHandleVOMeta.SORT_FIELD , AssetHandleVOMeta.SORT_TYPE , AssetHandleVOMeta.DATA_ORIGIN , AssetHandleVOMeta.QUERY_LOGIC , AssetHandleVOMeta.REQUEST_ACTION , AssetHandleVOMeta.IDS } )
	@SentinelResource(value = AssetHandleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.SAVE)
	public Result save(AssetHandleVO assetHandleVO) {
		
		Result result=assetHandleService.save(assetHandleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产处置
	*/
	@ApiOperation(value = "获取资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.GET_BY_ID)
	public Result<AssetHandle> getById(String id) {
		
		Result<AssetHandle> result=new Result<>();
		AssetHandle assetHandle=assetHandleService.getById(id);
		// join 关联的对象
		assetHandleService.dao().fill(assetHandle)
			.with("originator")
			.with(AssetHandleMeta.ASSET_HANDLE_TYPE)
			.execute();
		// 填充流程相关的属性
		assetHandleService.joinProcess(assetHandle);

		//assetHandleService.dao().join(assetHandle.getOriginator(), Person.class);
		result.success(true).data(assetHandle);
		return result;
	}


	/**
	 * 批量获取资产处置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产处置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetHandleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetHandleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.GET_BY_IDS)
	public Result<List<AssetHandle>> getByIds(List<String> ids) {
		
		Result<List<AssetHandle>> result=new Result<>();
		List<AssetHandle> list=assetHandleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产处置
	*/
	@ApiOperation(value = "查询资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetHandleVOMeta.PAGE_INDEX , AssetHandleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetHandleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.QUERY_LIST)
	public Result<List<AssetHandle>> queryList(AssetHandleVO sample) {
		
		Result<List<AssetHandle>> result=new Result<>();
		List<AssetHandle> list=assetHandleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产处置
	*/
	@ApiOperation(value = "分页查询资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetHandle>> queryPagedList(AssetHandleVO sample) {
		
		Result<PagedList<AssetHandle>> result=new Result<>();
		PagedList<AssetHandle> list=assetHandleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetHandleService.dao().fill(list)
			.with("originator")
			.with(AssetHandleMeta.ASSET_HANDLE_TYPE)
			.execute();
		// 填充流程相关的属性
		assetHandleService.joinProcess(list);

		List<Employee> employees = CollectorUtil.collectList(list, AssetHandle::getOriginator);
		assetHandleService.dao().join(employees, Person.class);

		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = AssetHandleServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		System.out.println("onProcessCallback ");

		return assetHandleService.onProcessCallback(event);
	}



}