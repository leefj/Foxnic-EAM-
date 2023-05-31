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


import com.dt.platform.proxy.common.ScreenProjectDataServiceProxy;
import com.dt.platform.domain.common.meta.ScreenProjectDataVOMeta;
import com.dt.platform.domain.common.ScreenProjectData;
import com.dt.platform.domain.common.ScreenProjectDataVO;
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
import com.dt.platform.domain.common.meta.ScreenProjectDataMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IScreenProjectDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 项目数据接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:10:29
*/

@InDoc
@Api(tags = "项目数据")
@RestController("SysScreenProjectDataController")
public class ScreenProjectDataController extends SuperController {

	@Autowired
	private IScreenProjectDataService screenProjectDataService;

	/**
	 * 添加项目数据
	*/
	@ApiOperation(value = "添加项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.CONTENT_DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.INSERT)
	public Result insert(ScreenProjectDataVO screenProjectDataVO) {
		
		Result result=screenProjectDataService.insert(screenProjectDataVO,false);
		return result;
	}



	/**
	 * 删除项目数据
	*/
	@ApiOperation(value = "删除项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  screenProjectDataService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=screenProjectDataService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除项目数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScreenProjectDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = screenProjectDataService.hasRefers(ids);
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
			Result result=screenProjectDataService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=screenProjectDataService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新项目数据
	*/
	@ApiOperation(value = "更新项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.CONTENT_DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenProjectDataVOMeta.PAGE_INDEX , ScreenProjectDataVOMeta.PAGE_SIZE , ScreenProjectDataVOMeta.SEARCH_FIELD , ScreenProjectDataVOMeta.FUZZY_FIELD , ScreenProjectDataVOMeta.SEARCH_VALUE , ScreenProjectDataVOMeta.DIRTY_FIELDS , ScreenProjectDataVOMeta.SORT_FIELD , ScreenProjectDataVOMeta.SORT_TYPE , ScreenProjectDataVOMeta.DATA_ORIGIN , ScreenProjectDataVOMeta.QUERY_LOGIC , ScreenProjectDataVOMeta.REQUEST_ACTION , ScreenProjectDataVOMeta.IDS } )
	@SentinelResource(value = ScreenProjectDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.UPDATE)
	public Result update(ScreenProjectDataVO screenProjectDataVO) {
		
		Result result=screenProjectDataService.update(screenProjectDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存项目数据
	*/
	@ApiOperation(value = "保存项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.CONTENT_DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScreenProjectDataVOMeta.PAGE_INDEX , ScreenProjectDataVOMeta.PAGE_SIZE , ScreenProjectDataVOMeta.SEARCH_FIELD , ScreenProjectDataVOMeta.FUZZY_FIELD , ScreenProjectDataVOMeta.SEARCH_VALUE , ScreenProjectDataVOMeta.DIRTY_FIELDS , ScreenProjectDataVOMeta.SORT_FIELD , ScreenProjectDataVOMeta.SORT_TYPE , ScreenProjectDataVOMeta.DATA_ORIGIN , ScreenProjectDataVOMeta.QUERY_LOGIC , ScreenProjectDataVOMeta.REQUEST_ACTION , ScreenProjectDataVOMeta.IDS } )
	@SentinelResource(value = ScreenProjectDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.SAVE)
	public Result save(ScreenProjectDataVO screenProjectDataVO) {
		
		Result result=screenProjectDataService.save(screenProjectDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取项目数据
	*/
	@ApiOperation(value = "获取项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.GET_BY_ID)
	public Result<ScreenProjectData> getById(String id) {
		
		Result<ScreenProjectData> result=new Result<>();
		ScreenProjectData screenProjectData=screenProjectDataService.getById(id);
		result.success(true).data(screenProjectData);
		return result;
	}


	/**
	 * 批量获取项目数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取项目数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScreenProjectDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScreenProjectDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.GET_BY_IDS)
	public Result<List<ScreenProjectData>> getByIds(List<String> ids) {
		
		Result<List<ScreenProjectData>> result=new Result<>();
		List<ScreenProjectData> list=screenProjectDataService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询项目数据
	*/
	@ApiOperation(value = "查询项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.CONTENT_DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenProjectDataVOMeta.PAGE_INDEX , ScreenProjectDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScreenProjectDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.QUERY_LIST)
	public Result<List<ScreenProjectData>> queryList(ScreenProjectDataVO sample) {
		
		Result<List<ScreenProjectData>> result=new Result<>();
		List<ScreenProjectData> list=screenProjectDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询项目数据
	*/
	@ApiOperation(value = "分页查询项目数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenProjectDataVOMeta.CONTENT_DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenProjectDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenProjectDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScreenProjectData>> queryPagedList(ScreenProjectDataVO sample) {
		
		Result<PagedList<ScreenProjectData>> result=new Result<>();
		PagedList<ScreenProjectData> list=screenProjectDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}