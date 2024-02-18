package com.dt.platform.hr.controller;

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


import com.dt.platform.proxy.hr.TrainingInstitutionServiceProxy;
import com.dt.platform.domain.hr.meta.TrainingInstitutionVOMeta;
import com.dt.platform.domain.hr.TrainingInstitution;
import com.dt.platform.domain.hr.TrainingInstitutionVO;
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
import com.dt.platform.domain.hr.meta.TrainingInstitutionMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ITrainingInstitutionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 培训机构接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:16:24
*/

@InDoc
@Api(tags = "培训机构")
@RestController("HrTrainingInstitutionController")
public class TrainingInstitutionController extends SuperController {

	@Autowired
	private ITrainingInstitutionService trainingInstitutionService;

	/**
	 * 添加培训机构
	*/
	@ApiOperation(value = "添加培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NAME , value = "机构名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.PROFILE , value = "机构介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.WEBSITE , value = "网址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTENT , value = "培训经历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstitutionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.INSERT)
	public Result insert(TrainingInstitutionVO trainingInstitutionVO) {
		
		Result result=trainingInstitutionService.insert(trainingInstitutionVO,false);
		return result;
	}



	/**
	 * 删除培训机构
	*/
	@ApiOperation(value = "删除培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstitutionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  trainingInstitutionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=trainingInstitutionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除培训机构 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = TrainingInstitutionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = trainingInstitutionService.hasRefers(ids);
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
			Result result=trainingInstitutionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=trainingInstitutionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新培训机构
	*/
	@ApiOperation(value = "更新培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NAME , value = "机构名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.PROFILE , value = "机构介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.WEBSITE , value = "网址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTENT , value = "培训经历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TrainingInstitutionVOMeta.PAGE_INDEX , TrainingInstitutionVOMeta.PAGE_SIZE , TrainingInstitutionVOMeta.SEARCH_FIELD , TrainingInstitutionVOMeta.FUZZY_FIELD , TrainingInstitutionVOMeta.SEARCH_VALUE , TrainingInstitutionVOMeta.DIRTY_FIELDS , TrainingInstitutionVOMeta.SORT_FIELD , TrainingInstitutionVOMeta.SORT_TYPE , TrainingInstitutionVOMeta.DATA_ORIGIN , TrainingInstitutionVOMeta.QUERY_LOGIC , TrainingInstitutionVOMeta.REQUEST_ACTION , TrainingInstitutionVOMeta.IDS } )
	@SentinelResource(value = TrainingInstitutionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.UPDATE)
	public Result update(TrainingInstitutionVO trainingInstitutionVO) {
		
		Result result=trainingInstitutionService.update(trainingInstitutionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存培训机构
	*/
	@ApiOperation(value = "保存培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NAME , value = "机构名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.PROFILE , value = "机构介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.WEBSITE , value = "网址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTENT , value = "培训经历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TrainingInstitutionVOMeta.PAGE_INDEX , TrainingInstitutionVOMeta.PAGE_SIZE , TrainingInstitutionVOMeta.SEARCH_FIELD , TrainingInstitutionVOMeta.FUZZY_FIELD , TrainingInstitutionVOMeta.SEARCH_VALUE , TrainingInstitutionVOMeta.DIRTY_FIELDS , TrainingInstitutionVOMeta.SORT_FIELD , TrainingInstitutionVOMeta.SORT_TYPE , TrainingInstitutionVOMeta.DATA_ORIGIN , TrainingInstitutionVOMeta.QUERY_LOGIC , TrainingInstitutionVOMeta.REQUEST_ACTION , TrainingInstitutionVOMeta.IDS } )
	@SentinelResource(value = TrainingInstitutionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.SAVE)
	public Result save(TrainingInstitutionVO trainingInstitutionVO) {
		
		Result result=trainingInstitutionService.save(trainingInstitutionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取培训机构
	*/
	@ApiOperation(value = "获取培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstitutionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.GET_BY_ID)
	public Result<TrainingInstitution> getById(String id) {
		
		Result<TrainingInstitution> result=new Result<>();
		TrainingInstitution trainingInstitution=trainingInstitutionService.getById(id);
		result.success(true).data(trainingInstitution);
		return result;
	}


	/**
	 * 批量获取培训机构 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取培训机构")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TrainingInstitutionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = TrainingInstitutionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.GET_BY_IDS)
	public Result<List<TrainingInstitution>> getByIds(List<String> ids) {
		
		Result<List<TrainingInstitution>> result=new Result<>();
		List<TrainingInstitution> list=trainingInstitutionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询培训机构
	*/
	@ApiOperation(value = "查询培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NAME , value = "机构名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.PROFILE , value = "机构介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.WEBSITE , value = "网址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTENT , value = "培训经历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TrainingInstitutionVOMeta.PAGE_INDEX , TrainingInstitutionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TrainingInstitutionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.QUERY_LIST)
	public Result<List<TrainingInstitution>> queryList(TrainingInstitutionVO sample) {
		
		Result<List<TrainingInstitution>> result=new Result<>();
		List<TrainingInstitution> list=trainingInstitutionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询培训机构
	*/
	@ApiOperation(value = "分页查询培训机构")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NAME , value = "机构名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.PROFILE , value = "机构介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.WEBSITE , value = "网址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.CONTENT , value = "培训经历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstitutionVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstitutionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstitutionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<TrainingInstitution>> queryPagedList(TrainingInstitutionVO sample) {
		
		Result<PagedList<TrainingInstitution>> result=new Result<>();
		PagedList<TrainingInstitution> list=trainingInstitutionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}