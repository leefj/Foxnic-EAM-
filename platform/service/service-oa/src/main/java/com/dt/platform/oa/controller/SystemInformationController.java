package com.dt.platform.oa.controller;

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


import com.dt.platform.proxy.oa.SystemInformationServiceProxy;
import com.dt.platform.domain.oa.meta.SystemInformationVOMeta;
import com.dt.platform.domain.oa.SystemInformation;
import com.dt.platform.domain.oa.SystemInformationVO;
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
import com.dt.platform.domain.oa.meta.SystemInformationMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ISystemInformationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 外部系统接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 20:48:08
*/

@InDoc
@Api(tags = "外部系统")
@RestController("OaSystemInformationController")
public class SystemInformationController extends SuperController {

	@Autowired
	private ISystemInformationService systemInformationService;

	/**
	 * 添加外部系统
	*/
	@ApiOperation(value = "添加外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SystemInformationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.INSERT)
	public Result insert(SystemInformationVO systemInformationVO) {
		
		Result result=systemInformationService.insert(systemInformationVO,false);
		return result;
	}



	/**
	 * 删除外部系统
	*/
	@ApiOperation(value = "删除外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SystemInformationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  systemInformationService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=systemInformationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除外部系统 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SystemInformationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = systemInformationService.hasRefers(ids);
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
			Result result=systemInformationService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=systemInformationService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新外部系统
	*/
	@ApiOperation(value = "更新外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SystemInformationVOMeta.PAGE_INDEX , SystemInformationVOMeta.PAGE_SIZE , SystemInformationVOMeta.SEARCH_FIELD , SystemInformationVOMeta.FUZZY_FIELD , SystemInformationVOMeta.SEARCH_VALUE , SystemInformationVOMeta.DIRTY_FIELDS , SystemInformationVOMeta.SORT_FIELD , SystemInformationVOMeta.SORT_TYPE , SystemInformationVOMeta.DATA_ORIGIN , SystemInformationVOMeta.QUERY_LOGIC , SystemInformationVOMeta.REQUEST_ACTION , SystemInformationVOMeta.IDS } )
	@SentinelResource(value = SystemInformationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.UPDATE)
	public Result update(SystemInformationVO systemInformationVO) {
		
		Result result=systemInformationService.update(systemInformationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存外部系统
	*/
	@ApiOperation(value = "保存外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SystemInformationVOMeta.PAGE_INDEX , SystemInformationVOMeta.PAGE_SIZE , SystemInformationVOMeta.SEARCH_FIELD , SystemInformationVOMeta.FUZZY_FIELD , SystemInformationVOMeta.SEARCH_VALUE , SystemInformationVOMeta.DIRTY_FIELDS , SystemInformationVOMeta.SORT_FIELD , SystemInformationVOMeta.SORT_TYPE , SystemInformationVOMeta.DATA_ORIGIN , SystemInformationVOMeta.QUERY_LOGIC , SystemInformationVOMeta.REQUEST_ACTION , SystemInformationVOMeta.IDS } )
	@SentinelResource(value = SystemInformationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.SAVE)
	public Result save(SystemInformationVO systemInformationVO) {
		
		Result result=systemInformationService.save(systemInformationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取外部系统
	*/
	@ApiOperation(value = "获取外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SystemInformationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.GET_BY_ID)
	public Result<SystemInformation> getById(String id) {
		
		Result<SystemInformation> result=new Result<>();
		SystemInformation systemInformation=systemInformationService.getById(id);
		// join 关联的对象
		systemInformationService.dao().fill(systemInformation)
			.with(SystemInformationMeta.TYPE_DATA)
			.execute();
		result.success(true).data(systemInformation);
		return result;
	}


	/**
	 * 批量获取外部系统 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取外部系统")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SystemInformationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SystemInformationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.GET_BY_IDS)
	public Result<List<SystemInformation>> getByIds(List<String> ids) {
		
		Result<List<SystemInformation>> result=new Result<>();
		List<SystemInformation> list=systemInformationService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询外部系统
	*/
	@ApiOperation(value = "查询外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SystemInformationVOMeta.PAGE_INDEX , SystemInformationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SystemInformationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.QUERY_LIST)
	public Result<List<SystemInformation>> queryList(SystemInformationVO sample) {
		
		Result<List<SystemInformation>> result=new Result<>();
		List<SystemInformation> list=systemInformationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询外部系统
	*/
	@ApiOperation(value = "分页查询外部系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SystemInformationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SystemInformationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SystemInformationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SystemInformationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SystemInformation>> queryPagedList(SystemInformationVO sample) {
		
		Result<PagedList<SystemInformation>> result=new Result<>();
		PagedList<SystemInformation> list=systemInformationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		systemInformationService.dao().fill(list)
			.with(SystemInformationMeta.TYPE_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}





}