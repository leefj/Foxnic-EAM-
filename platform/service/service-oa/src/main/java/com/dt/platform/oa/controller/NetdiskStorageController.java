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


import com.dt.platform.proxy.oa.NetdiskStorageServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskStorageVOMeta;
import com.dt.platform.domain.oa.NetdiskStorage;
import com.dt.platform.domain.oa.NetdiskStorageVO;
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
import com.dt.platform.domain.oa.meta.NetdiskStorageMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskStorageService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 存储方式接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:21:10
*/

@InDoc
@Api(tags = "存储方式")
@RestController("OaNetdiskStorageController")
public class NetdiskStorageController extends SuperController {

	@Autowired
	private INetdiskStorageService netdiskStorageService;

	/**
	 * 添加存储方式
	*/
	@ApiOperation(value = "添加存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ENCRYPTED , value = "是否加密" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskStorageServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.INSERT)
	public Result insert(NetdiskStorageVO netdiskStorageVO) {
		
		Result result=netdiskStorageService.insert(netdiskStorageVO,false);
		return result;
	}



	/**
	 * 删除存储方式
	*/
	@ApiOperation(value = "删除存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskStorageServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  netdiskStorageService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=netdiskStorageService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除存储方式 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = NetdiskStorageServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = netdiskStorageService.hasRefers(ids);
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
			Result result=netdiskStorageService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=netdiskStorageService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新存储方式
	*/
	@ApiOperation(value = "更新存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ENCRYPTED , value = "是否加密" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskStorageVOMeta.PAGE_INDEX , NetdiskStorageVOMeta.PAGE_SIZE , NetdiskStorageVOMeta.SEARCH_FIELD , NetdiskStorageVOMeta.FUZZY_FIELD , NetdiskStorageVOMeta.SEARCH_VALUE , NetdiskStorageVOMeta.DIRTY_FIELDS , NetdiskStorageVOMeta.SORT_FIELD , NetdiskStorageVOMeta.SORT_TYPE , NetdiskStorageVOMeta.DATA_ORIGIN , NetdiskStorageVOMeta.QUERY_LOGIC , NetdiskStorageVOMeta.REQUEST_ACTION , NetdiskStorageVOMeta.IDS } )
	@SentinelResource(value = NetdiskStorageServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.UPDATE)
	public Result update(NetdiskStorageVO netdiskStorageVO) {
		
		Result result=netdiskStorageService.update(netdiskStorageVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存存储方式
	*/
	@ApiOperation(value = "保存存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ENCRYPTED , value = "是否加密" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NetdiskStorageVOMeta.PAGE_INDEX , NetdiskStorageVOMeta.PAGE_SIZE , NetdiskStorageVOMeta.SEARCH_FIELD , NetdiskStorageVOMeta.FUZZY_FIELD , NetdiskStorageVOMeta.SEARCH_VALUE , NetdiskStorageVOMeta.DIRTY_FIELDS , NetdiskStorageVOMeta.SORT_FIELD , NetdiskStorageVOMeta.SORT_TYPE , NetdiskStorageVOMeta.DATA_ORIGIN , NetdiskStorageVOMeta.QUERY_LOGIC , NetdiskStorageVOMeta.REQUEST_ACTION , NetdiskStorageVOMeta.IDS } )
	@SentinelResource(value = NetdiskStorageServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.SAVE)
	public Result save(NetdiskStorageVO netdiskStorageVO) {
		
		Result result=netdiskStorageService.save(netdiskStorageVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取存储方式
	*/
	@ApiOperation(value = "获取存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskStorageServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.GET_BY_ID)
	public Result<NetdiskStorage> getById(String id) {
		
		Result<NetdiskStorage> result=new Result<>();
		NetdiskStorage netdiskStorage=netdiskStorageService.getById(id);
		result.success(true).data(netdiskStorage);
		return result;
	}


	/**
	 * 批量获取存储方式 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取存储方式")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NetdiskStorageVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = NetdiskStorageServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.GET_BY_IDS)
	public Result<List<NetdiskStorage>> getByIds(List<String> ids) {
		
		Result<List<NetdiskStorage>> result=new Result<>();
		List<NetdiskStorage> list=netdiskStorageService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询存储方式
	*/
	@ApiOperation(value = "查询存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ENCRYPTED , value = "是否加密" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskStorageVOMeta.PAGE_INDEX , NetdiskStorageVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NetdiskStorageServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.QUERY_LIST)
	public Result<List<NetdiskStorage>> queryList(NetdiskStorageVO sample) {
		
		Result<List<NetdiskStorage>> result=new Result<>();
		List<NetdiskStorage> list=netdiskStorageService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询存储方式
	*/
	@ApiOperation(value = "分页查询存储方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskStorageVOMeta.ENCRYPTED , value = "是否加密" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskStorageServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskStorageServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<NetdiskStorage>> queryPagedList(NetdiskStorageVO sample) {
		
		Result<PagedList<NetdiskStorage>> result=new Result<>();
		PagedList<NetdiskStorage> list=netdiskStorageService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}