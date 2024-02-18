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


import com.dt.platform.proxy.hr.TrainingInstructorServiceProxy;
import com.dt.platform.domain.hr.meta.TrainingInstructorVOMeta;
import com.dt.platform.domain.hr.TrainingInstructor;
import com.dt.platform.domain.hr.TrainingInstructorVO;
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
import com.dt.platform.domain.hr.meta.TrainingInstructorMeta;
import com.dt.platform.domain.hr.TrainingInstitution;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ITrainingInstructorService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 培训讲师接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:15:31
*/

@InDoc
@Api(tags = "培训讲师")
@RestController("HrTrainingInstructorController")
public class TrainingInstructorController extends SuperController {

	@Autowired
	private ITrainingInstructorService trainingInstructorService;

	/**
	 * 添加培训讲师
	*/
	@ApiOperation(value = "添加培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ORG_ID , value = "工作单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.TITLE , value = "社会头衔" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstructorServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.INSERT)
	public Result insert(TrainingInstructorVO trainingInstructorVO) {
		
		Result result=trainingInstructorService.insert(trainingInstructorVO,false);
		return result;
	}



	/**
	 * 删除培训讲师
	*/
	@ApiOperation(value = "删除培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstructorServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  trainingInstructorService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=trainingInstructorService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除培训讲师 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = TrainingInstructorServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = trainingInstructorService.hasRefers(ids);
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
			Result result=trainingInstructorService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=trainingInstructorService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新培训讲师
	*/
	@ApiOperation(value = "更新培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ORG_ID , value = "工作单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.TITLE , value = "社会头衔" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TrainingInstructorVOMeta.PAGE_INDEX , TrainingInstructorVOMeta.PAGE_SIZE , TrainingInstructorVOMeta.SEARCH_FIELD , TrainingInstructorVOMeta.FUZZY_FIELD , TrainingInstructorVOMeta.SEARCH_VALUE , TrainingInstructorVOMeta.DIRTY_FIELDS , TrainingInstructorVOMeta.SORT_FIELD , TrainingInstructorVOMeta.SORT_TYPE , TrainingInstructorVOMeta.DATA_ORIGIN , TrainingInstructorVOMeta.QUERY_LOGIC , TrainingInstructorVOMeta.REQUEST_ACTION , TrainingInstructorVOMeta.IDS } )
	@SentinelResource(value = TrainingInstructorServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.UPDATE)
	public Result update(TrainingInstructorVO trainingInstructorVO) {
		
		Result result=trainingInstructorService.update(trainingInstructorVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存培训讲师
	*/
	@ApiOperation(value = "保存培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ORG_ID , value = "工作单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.TITLE , value = "社会头衔" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TrainingInstructorVOMeta.PAGE_INDEX , TrainingInstructorVOMeta.PAGE_SIZE , TrainingInstructorVOMeta.SEARCH_FIELD , TrainingInstructorVOMeta.FUZZY_FIELD , TrainingInstructorVOMeta.SEARCH_VALUE , TrainingInstructorVOMeta.DIRTY_FIELDS , TrainingInstructorVOMeta.SORT_FIELD , TrainingInstructorVOMeta.SORT_TYPE , TrainingInstructorVOMeta.DATA_ORIGIN , TrainingInstructorVOMeta.QUERY_LOGIC , TrainingInstructorVOMeta.REQUEST_ACTION , TrainingInstructorVOMeta.IDS } )
	@SentinelResource(value = TrainingInstructorServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.SAVE)
	public Result save(TrainingInstructorVO trainingInstructorVO) {
		
		Result result=trainingInstructorService.save(trainingInstructorVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取培训讲师
	*/
	@ApiOperation(value = "获取培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstructorServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.GET_BY_ID)
	public Result<TrainingInstructor> getById(String id) {
		
		Result<TrainingInstructor> result=new Result<>();
		TrainingInstructor trainingInstructor=trainingInstructorService.getById(id);
		// join 关联的对象
		trainingInstructorService.dao().fill(trainingInstructor)
			.with(TrainingInstructorMeta.TRAINING_INSTITUTION)
			.execute();
		result.success(true).data(trainingInstructor);
		return result;
	}


	/**
	 * 批量获取培训讲师 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取培训讲师")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TrainingInstructorVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = TrainingInstructorServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.GET_BY_IDS)
	public Result<List<TrainingInstructor>> getByIds(List<String> ids) {
		
		Result<List<TrainingInstructor>> result=new Result<>();
		List<TrainingInstructor> list=trainingInstructorService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询培训讲师
	*/
	@ApiOperation(value = "查询培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ORG_ID , value = "工作单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.TITLE , value = "社会头衔" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TrainingInstructorVOMeta.PAGE_INDEX , TrainingInstructorVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TrainingInstructorServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.QUERY_LIST)
	public Result<List<TrainingInstructor>> queryList(TrainingInstructorVO sample) {
		
		Result<List<TrainingInstructor>> result=new Result<>();
		List<TrainingInstructor> list=trainingInstructorService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询培训讲师
	*/
	@ApiOperation(value = "分页查询培训讲师")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.ORG_ID , value = "工作单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.TITLE , value = "社会头衔" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TrainingInstructorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TrainingInstructorServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TrainingInstructorServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<TrainingInstructor>> queryPagedList(TrainingInstructorVO sample) {
		
		Result<PagedList<TrainingInstructor>> result=new Result<>();
		PagedList<TrainingInstructor> list=trainingInstructorService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		trainingInstructorService.dao().fill(list)
			.with(TrainingInstructorMeta.TRAINING_INSTITUTION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}