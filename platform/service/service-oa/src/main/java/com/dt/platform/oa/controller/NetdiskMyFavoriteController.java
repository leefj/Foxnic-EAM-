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


import com.dt.platform.proxy.oa.NetdiskMyFavoriteServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskMyFavoriteVOMeta;
import com.dt.platform.domain.oa.NetdiskMyFavorite;
import com.dt.platform.domain.oa.NetdiskMyFavoriteVO;
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
import com.dt.platform.domain.oa.meta.NetdiskMyFavoriteMeta;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskMyFavoriteService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 我的收藏接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:20:21
*/

@InDoc
@Api(tags = "我的收藏")
@RestController("OaNetdiskMyFavoriteController")
public class NetdiskMyFavoriteController extends SuperController {

	@Autowired
	private INetdiskMyFavoriteService netdiskMyFavoriteService;

	/**
	 * 添加我的收藏
	*/
	@ApiOperation(value = "添加我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.INSERT)
	public Result insert(NetdiskMyFavoriteVO netdiskMyFavoriteVO) {
		
		Result result=netdiskMyFavoriteService.insert(netdiskMyFavoriteVO,false);
		return result;
	}



	/**
	 * 删除我的收藏
	*/
	@ApiOperation(value = "删除我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  netdiskMyFavoriteService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=netdiskMyFavoriteService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除我的收藏 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = netdiskMyFavoriteService.hasRefers(ids);
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
			Result result=netdiskMyFavoriteService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=netdiskMyFavoriteService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新我的收藏
	*/
	@ApiOperation(value = "更新我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskMyFavoriteVOMeta.PAGE_INDEX , NetdiskMyFavoriteVOMeta.PAGE_SIZE , NetdiskMyFavoriteVOMeta.SEARCH_FIELD , NetdiskMyFavoriteVOMeta.FUZZY_FIELD , NetdiskMyFavoriteVOMeta.SEARCH_VALUE , NetdiskMyFavoriteVOMeta.DIRTY_FIELDS , NetdiskMyFavoriteVOMeta.SORT_FIELD , NetdiskMyFavoriteVOMeta.SORT_TYPE , NetdiskMyFavoriteVOMeta.DATA_ORIGIN , NetdiskMyFavoriteVOMeta.QUERY_LOGIC , NetdiskMyFavoriteVOMeta.REQUEST_ACTION , NetdiskMyFavoriteVOMeta.IDS } )
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.UPDATE)
	public Result update(NetdiskMyFavoriteVO netdiskMyFavoriteVO) {
		
		Result result=netdiskMyFavoriteService.update(netdiskMyFavoriteVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存我的收藏
	*/
	@ApiOperation(value = "保存我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NetdiskMyFavoriteVOMeta.PAGE_INDEX , NetdiskMyFavoriteVOMeta.PAGE_SIZE , NetdiskMyFavoriteVOMeta.SEARCH_FIELD , NetdiskMyFavoriteVOMeta.FUZZY_FIELD , NetdiskMyFavoriteVOMeta.SEARCH_VALUE , NetdiskMyFavoriteVOMeta.DIRTY_FIELDS , NetdiskMyFavoriteVOMeta.SORT_FIELD , NetdiskMyFavoriteVOMeta.SORT_TYPE , NetdiskMyFavoriteVOMeta.DATA_ORIGIN , NetdiskMyFavoriteVOMeta.QUERY_LOGIC , NetdiskMyFavoriteVOMeta.REQUEST_ACTION , NetdiskMyFavoriteVOMeta.IDS } )
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.SAVE)
	public Result save(NetdiskMyFavoriteVO netdiskMyFavoriteVO) {
		
		Result result=netdiskMyFavoriteService.save(netdiskMyFavoriteVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取我的收藏
	*/
	@ApiOperation(value = "获取我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.GET_BY_ID)
	public Result<NetdiskMyFavorite> getById(String id) {
		
		Result<NetdiskMyFavorite> result=new Result<>();
		NetdiskMyFavorite netdiskMyFavorite=netdiskMyFavoriteService.getById(id);
		// join 关联的对象
		netdiskMyFavoriteService.dao().fill(netdiskMyFavorite)
			.with("ownerUser")
			.execute();
		result.success(true).data(netdiskMyFavorite);
		return result;
	}


	/**
	 * 批量获取我的收藏 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取我的收藏")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = NetdiskMyFavoriteServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.GET_BY_IDS)
	public Result<List<NetdiskMyFavorite>> getByIds(List<String> ids) {
		
		Result<List<NetdiskMyFavorite>> result=new Result<>();
		List<NetdiskMyFavorite> list=netdiskMyFavoriteService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询我的收藏
	*/
	@ApiOperation(value = "查询我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskMyFavoriteVOMeta.PAGE_INDEX , NetdiskMyFavoriteVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.QUERY_LIST)
	public Result<List<NetdiskMyFavorite>> queryList(NetdiskMyFavoriteVO sample) {
		
		Result<List<NetdiskMyFavorite>> result=new Result<>();
		List<NetdiskMyFavorite> list=netdiskMyFavoriteService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询我的收藏
	*/
	@ApiOperation(value = "分页查询我的收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMyFavoriteVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMyFavoriteServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMyFavoriteServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<NetdiskMyFavorite>> queryPagedList(NetdiskMyFavoriteVO sample) {
		
		Result<PagedList<NetdiskMyFavorite>> result=new Result<>();
		PagedList<NetdiskMyFavorite> list=netdiskMyFavoriteService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		netdiskMyFavoriteService.dao().fill(list)
			.with("ownerUser")
			.execute();
		result.success(true).data(list);
		return result;
	}





}