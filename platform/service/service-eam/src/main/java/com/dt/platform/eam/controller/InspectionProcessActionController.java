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


import com.dt.platform.proxy.eam.InspectionProcessActionServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionProcessActionVOMeta;
import com.dt.platform.domain.eam.InspectionProcessAction;
import com.dt.platform.domain.eam.InspectionProcessActionVO;
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
import com.dt.platform.domain.eam.meta.InspectionProcessActionMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionProcessActionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 处理方式接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-05 10:15:22
*/

@InDoc
@Api(tags = "处理方式")
@RestController("EamInspectionProcessActionController")
public class InspectionProcessActionController extends SuperController {

	@Autowired
	private IInspectionProcessActionService inspectionProcessActionService;

	/**
	 * 添加处理方式
	*/
	@ApiOperation(value = "添加处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NAME , value = "方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CLASS_VALUE , value = "处理类" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionProcessActionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.INSERT)
	public Result insert(InspectionProcessActionVO inspectionProcessActionVO) {
		
		Result result=inspectionProcessActionService.insert(inspectionProcessActionVO,false);
		return result;
	}



	/**
	 * 删除处理方式
	*/
	@ApiOperation(value = "删除处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionProcessActionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionProcessActionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionProcessActionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除处理方式 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionProcessActionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionProcessActionService.hasRefers(ids);
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
			Result result=inspectionProcessActionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionProcessActionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新处理方式
	*/
	@ApiOperation(value = "更新处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NAME , value = "方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CLASS_VALUE , value = "处理类" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionProcessActionVOMeta.PAGE_INDEX , InspectionProcessActionVOMeta.PAGE_SIZE , InspectionProcessActionVOMeta.SEARCH_FIELD , InspectionProcessActionVOMeta.FUZZY_FIELD , InspectionProcessActionVOMeta.SEARCH_VALUE , InspectionProcessActionVOMeta.DIRTY_FIELDS , InspectionProcessActionVOMeta.SORT_FIELD , InspectionProcessActionVOMeta.SORT_TYPE , InspectionProcessActionVOMeta.DATA_ORIGIN , InspectionProcessActionVOMeta.QUERY_LOGIC , InspectionProcessActionVOMeta.REQUEST_ACTION , InspectionProcessActionVOMeta.IDS } )
	@SentinelResource(value = InspectionProcessActionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.UPDATE)
	public Result update(InspectionProcessActionVO inspectionProcessActionVO) {
		
		Result result=inspectionProcessActionService.update(inspectionProcessActionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存处理方式
	*/
	@ApiOperation(value = "保存处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NAME , value = "方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CLASS_VALUE , value = "处理类" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionProcessActionVOMeta.PAGE_INDEX , InspectionProcessActionVOMeta.PAGE_SIZE , InspectionProcessActionVOMeta.SEARCH_FIELD , InspectionProcessActionVOMeta.FUZZY_FIELD , InspectionProcessActionVOMeta.SEARCH_VALUE , InspectionProcessActionVOMeta.DIRTY_FIELDS , InspectionProcessActionVOMeta.SORT_FIELD , InspectionProcessActionVOMeta.SORT_TYPE , InspectionProcessActionVOMeta.DATA_ORIGIN , InspectionProcessActionVOMeta.QUERY_LOGIC , InspectionProcessActionVOMeta.REQUEST_ACTION , InspectionProcessActionVOMeta.IDS } )
	@SentinelResource(value = InspectionProcessActionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.SAVE)
	public Result save(InspectionProcessActionVO inspectionProcessActionVO) {
		
		Result result=inspectionProcessActionService.save(inspectionProcessActionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取处理方式
	*/
	@ApiOperation(value = "获取处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionProcessActionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.GET_BY_ID)
	public Result<InspectionProcessAction> getById(String id) {
		
		Result<InspectionProcessAction> result=new Result<>();
		InspectionProcessAction inspectionProcessAction=inspectionProcessActionService.getById(id);
		result.success(true).data(inspectionProcessAction);
		return result;
	}


	/**
	 * 批量获取处理方式 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取处理方式")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionProcessActionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionProcessActionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.GET_BY_IDS)
	public Result<List<InspectionProcessAction>> getByIds(List<String> ids) {
		
		Result<List<InspectionProcessAction>> result=new Result<>();
		List<InspectionProcessAction> list=inspectionProcessActionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询处理方式
	*/
	@ApiOperation(value = "查询处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NAME , value = "方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CLASS_VALUE , value = "处理类" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionProcessActionVOMeta.PAGE_INDEX , InspectionProcessActionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionProcessActionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.QUERY_LIST)
	public Result<List<InspectionProcessAction>> queryList(InspectionProcessActionVO sample) {
		
		Result<List<InspectionProcessAction>> result=new Result<>();
		List<InspectionProcessAction> list=inspectionProcessActionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询处理方式
	*/
	@ApiOperation(value = "分页查询处理方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NAME , value = "方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.CLASS_VALUE , value = "处理类" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionProcessActionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionProcessActionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionProcessActionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionProcessAction>> queryPagedList(InspectionProcessActionVO sample) {
		
		Result<PagedList<InspectionProcessAction>> result=new Result<>();
		PagedList<InspectionProcessAction> list=inspectionProcessActionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}