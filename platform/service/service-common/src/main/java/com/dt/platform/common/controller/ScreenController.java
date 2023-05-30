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


import com.dt.platform.proxy.common.ScreenServiceProxy;
import com.dt.platform.domain.common.meta.ScreenVOMeta;
import com.dt.platform.domain.common.Screen;
import com.dt.platform.domain.common.ScreenVO;
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
import com.dt.platform.domain.common.meta.ScreenMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IScreenService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 大屏接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 13:57:57
*/

@InDoc
@Api(tags = "大屏")
@RestController("SysScreenController")
public class ScreenController extends SuperController {

	@Autowired
	private IScreenService screenService;

	/**
	 * 添加大屏
	*/
	@ApiOperation(value = "添加大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.INSERT)
	public Result insert(ScreenVO screenVO) {
		
		Result result=screenService.insert(screenVO,false);
		return result;
	}



	/**
	 * 删除大屏
	*/
	@ApiOperation(value = "删除大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  screenService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=screenService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除大屏 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScreenServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = screenService.hasRefers(ids);
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
			Result result=screenService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=screenService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新大屏
	*/
	@ApiOperation(value = "更新大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenVOMeta.PAGE_INDEX , ScreenVOMeta.PAGE_SIZE , ScreenVOMeta.SEARCH_FIELD , ScreenVOMeta.FUZZY_FIELD , ScreenVOMeta.SEARCH_VALUE , ScreenVOMeta.DIRTY_FIELDS , ScreenVOMeta.SORT_FIELD , ScreenVOMeta.SORT_TYPE , ScreenVOMeta.DATA_ORIGIN , ScreenVOMeta.QUERY_LOGIC , ScreenVOMeta.REQUEST_ACTION , ScreenVOMeta.IDS } )
	@SentinelResource(value = ScreenServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.UPDATE)
	public Result update(ScreenVO screenVO) {
		
		Result result=screenService.update(screenVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存大屏
	*/
	@ApiOperation(value = "保存大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScreenVOMeta.PAGE_INDEX , ScreenVOMeta.PAGE_SIZE , ScreenVOMeta.SEARCH_FIELD , ScreenVOMeta.FUZZY_FIELD , ScreenVOMeta.SEARCH_VALUE , ScreenVOMeta.DIRTY_FIELDS , ScreenVOMeta.SORT_FIELD , ScreenVOMeta.SORT_TYPE , ScreenVOMeta.DATA_ORIGIN , ScreenVOMeta.QUERY_LOGIC , ScreenVOMeta.REQUEST_ACTION , ScreenVOMeta.IDS } )
	@SentinelResource(value = ScreenServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.SAVE)
	public Result save(ScreenVO screenVO) {
		
		Result result=screenService.save(screenVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取大屏
	*/
	@ApiOperation(value = "获取大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.GET_BY_ID)
	public Result<Screen> getById(String id) {
		
		Result<Screen> result=new Result<>();
		Screen screen=screenService.getById(id);
		result.success(true).data(screen);
		return result;
	}


	/**
	 * 批量获取大屏 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取大屏")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScreenVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScreenServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.GET_BY_IDS)
	public Result<List<Screen>> getByIds(List<String> ids) {
		
		Result<List<Screen>> result=new Result<>();
		List<Screen> list=screenService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询大屏
	*/
	@ApiOperation(value = "查询大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenVOMeta.PAGE_INDEX , ScreenVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScreenServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.QUERY_LIST)
	public Result<List<Screen>> queryList(ScreenVO sample) {
		
		Result<List<Screen>> result=new Result<>();
		List<Screen> list=screenService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询大屏
	*/
	@ApiOperation(value = "分页查询大屏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Screen>> queryPagedList(ScreenVO sample) {
		
		Result<PagedList<Screen>> result=new Result<>();
		PagedList<Screen> list=screenService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}