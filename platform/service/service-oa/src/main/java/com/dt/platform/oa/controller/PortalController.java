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


import com.dt.platform.proxy.oa.PortalServiceProxy;
import com.dt.platform.domain.oa.meta.PortalVOMeta;
import com.dt.platform.domain.oa.Portal;
import com.dt.platform.domain.oa.PortalVO;
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
import com.dt.platform.domain.oa.meta.PortalMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IPortalService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 门户接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 22:18:39
*/

@InDoc
@Api(tags = "门户")
@RestController("OaPortalController")
public class PortalController extends SuperController {

	@Autowired
	private IPortalService portalService;

	/**
	 * 添加门户
	*/
	@ApiOperation(value = "添加门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PortalServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.INSERT)
	public Result insert(PortalVO portalVO) {
		
		Result result=portalService.insert(portalVO,false);
		return result;
	}



	/**
	 * 删除门户
	*/
	@ApiOperation(value = "删除门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PortalServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  portalService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=portalService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除门户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PortalServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = portalService.hasRefers(ids);
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
			Result result=portalService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=portalService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新门户
	*/
	@ApiOperation(value = "更新门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PortalVOMeta.PAGE_INDEX , PortalVOMeta.PAGE_SIZE , PortalVOMeta.SEARCH_FIELD , PortalVOMeta.FUZZY_FIELD , PortalVOMeta.SEARCH_VALUE , PortalVOMeta.DIRTY_FIELDS , PortalVOMeta.SORT_FIELD , PortalVOMeta.SORT_TYPE , PortalVOMeta.DATA_ORIGIN , PortalVOMeta.QUERY_LOGIC , PortalVOMeta.REQUEST_ACTION , PortalVOMeta.IDS } )
	@SentinelResource(value = PortalServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.UPDATE)
	public Result update(PortalVO portalVO) {
		
		Result result=portalService.update(portalVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存门户
	*/
	@ApiOperation(value = "保存门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PortalVOMeta.PAGE_INDEX , PortalVOMeta.PAGE_SIZE , PortalVOMeta.SEARCH_FIELD , PortalVOMeta.FUZZY_FIELD , PortalVOMeta.SEARCH_VALUE , PortalVOMeta.DIRTY_FIELDS , PortalVOMeta.SORT_FIELD , PortalVOMeta.SORT_TYPE , PortalVOMeta.DATA_ORIGIN , PortalVOMeta.QUERY_LOGIC , PortalVOMeta.REQUEST_ACTION , PortalVOMeta.IDS } )
	@SentinelResource(value = PortalServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.SAVE)
	public Result save(PortalVO portalVO) {
		
		Result result=portalService.save(portalVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取门户
	*/
	@ApiOperation(value = "获取门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PortalServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.GET_BY_ID)
	public Result<Portal> getById(String id) {
		
		Result<Portal> result=new Result<>();
		Portal portal=portalService.getById(id);
		result.success(true).data(portal);
		return result;
	}


	/**
	 * 批量获取门户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取门户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PortalVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PortalServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.GET_BY_IDS)
	public Result<List<Portal>> getByIds(List<String> ids) {
		
		Result<List<Portal>> result=new Result<>();
		List<Portal> list=portalService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询门户
	*/
	@ApiOperation(value = "查询门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PortalVOMeta.PAGE_INDEX , PortalVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PortalServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.QUERY_LIST)
	public Result<List<Portal>> queryList(PortalVO sample) {
		
		Result<List<Portal>> result=new Result<>();
		List<Portal> list=portalService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询门户
	*/
	@ApiOperation(value = "分页查询门户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PortalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PortalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PortalServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PortalServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Portal>> queryPagedList(PortalVO sample) {
		
		Result<PagedList<Portal>> result=new Result<>();
		PagedList<Portal> list=portalService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}