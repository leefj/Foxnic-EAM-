package com.dt.platform.common.controller;

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


import com.dt.platform.proxy.common.ScreenProjectServiceProxy;
import com.dt.platform.domain.common.meta.ScreenProjectVOMeta;
import com.dt.platform.domain.common.ScreenProject;
import com.dt.platform.domain.common.ScreenProjectVO;
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
import com.dt.platform.domain.common.meta.ScreenProjectMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IScreenProjectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 项目接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:12:24
*/

@InDoc
@Api(tags = "项目")
@RestController("SysScreenProjectController")
public class ScreenProjectController extends SuperController {

	@Autowired
	private IScreenProjectService screenProjectService;

	/**
	 * 添加项目
	*/
	@ApiOperation(value = "添加项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.PROJECT_NAME , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.STATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.INDEX_IMAGE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.REMARKS , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.INSERT)
	public Result insert(ScreenProjectVO screenProjectVO) {
		
		Result result=screenProjectService.insert(screenProjectVO,false);
		return result;
	}



	/**
	 * 删除项目
	*/
	@ApiOperation(value = "删除项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  screenProjectService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=screenProjectService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScreenProjectServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = screenProjectService.hasRefers(ids);
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
			Result result=screenProjectService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=screenProjectService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新项目
	*/
	@ApiOperation(value = "更新项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.PROJECT_NAME , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.STATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.INDEX_IMAGE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.REMARKS , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenProjectVOMeta.PAGE_INDEX , ScreenProjectVOMeta.PAGE_SIZE , ScreenProjectVOMeta.SEARCH_FIELD , ScreenProjectVOMeta.FUZZY_FIELD , ScreenProjectVOMeta.SEARCH_VALUE , ScreenProjectVOMeta.DIRTY_FIELDS , ScreenProjectVOMeta.SORT_FIELD , ScreenProjectVOMeta.SORT_TYPE , ScreenProjectVOMeta.DATA_ORIGIN , ScreenProjectVOMeta.QUERY_LOGIC , ScreenProjectVOMeta.REQUEST_ACTION , ScreenProjectVOMeta.IDS } )
	@SentinelResource(value = ScreenProjectServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.UPDATE)
	public Result update(ScreenProjectVO screenProjectVO) {
		
		Result result=screenProjectService.update(screenProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存项目
	*/
	@ApiOperation(value = "保存项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.PROJECT_NAME , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.STATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.INDEX_IMAGE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.REMARKS , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScreenProjectVOMeta.PAGE_INDEX , ScreenProjectVOMeta.PAGE_SIZE , ScreenProjectVOMeta.SEARCH_FIELD , ScreenProjectVOMeta.FUZZY_FIELD , ScreenProjectVOMeta.SEARCH_VALUE , ScreenProjectVOMeta.DIRTY_FIELDS , ScreenProjectVOMeta.SORT_FIELD , ScreenProjectVOMeta.SORT_TYPE , ScreenProjectVOMeta.DATA_ORIGIN , ScreenProjectVOMeta.QUERY_LOGIC , ScreenProjectVOMeta.REQUEST_ACTION , ScreenProjectVOMeta.IDS } )
	@SentinelResource(value = ScreenProjectServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.SAVE)
	public Result save(ScreenProjectVO screenProjectVO) {
		
		Result result=screenProjectService.save(screenProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取项目
	*/
	@ApiOperation(value = "获取项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.GET_BY_ID)
	public Result<ScreenProject> getById(String id) {
		
		Result<ScreenProject> result=new Result<>();
		ScreenProject screenProject=screenProjectService.getById(id);
		result.success(true).data(screenProject);
		return result;
	}


	/**
	 * 批量获取项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScreenProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScreenProjectServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.GET_BY_IDS)
	public Result<List<ScreenProject>> getByIds(List<String> ids) {
		
		Result<List<ScreenProject>> result=new Result<>();
		List<ScreenProject> list=screenProjectService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询项目
	*/
	@ApiOperation(value = "查询项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.PROJECT_NAME , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.STATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.INDEX_IMAGE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.REMARKS , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenProjectVOMeta.PAGE_INDEX , ScreenProjectVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScreenProjectServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.QUERY_LIST)
	public Result<List<ScreenProject>> queryList(ScreenProjectVO sample) {
		
		Result<List<ScreenProject>> result=new Result<>();
		List<ScreenProject> list=screenProjectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询项目
	*/
	@ApiOperation(value = "分页查询项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.PROJECT_NAME , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.STATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.INDEX_IMAGE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectVOMeta.REMARKS , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScreenProject>> queryPagedList(ScreenProjectVO sample) {
		
		Result<PagedList<ScreenProject>> result=new Result<>();
		PagedList<ScreenProject> list=screenProjectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}