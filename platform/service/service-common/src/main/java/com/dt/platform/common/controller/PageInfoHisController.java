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


import com.dt.platform.proxy.common.PageInfoHisServiceProxy;
import com.dt.platform.domain.common.meta.PageInfoHisVOMeta;
import com.dt.platform.domain.common.PageInfoHis;
import com.dt.platform.domain.common.PageInfoHisVO;
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
import com.dt.platform.domain.common.meta.PageInfoHisMeta;
import com.dt.platform.domain.common.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPageInfoHisService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 页面历史接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-12 10:49:06
*/

@InDoc
@Api(tags = "页面历史")
@RestController("SysPageInfoHisController")
public class PageInfoHisController extends SuperController {

	@Autowired
	private IPageInfoHisService pageInfoHisService;

	/**
	 * 添加页面历史
	*/
	@ApiOperation(value = "添加页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.PAGE_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoHisServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.INSERT)
	public Result insert(PageInfoHisVO pageInfoHisVO) {
		
		Result result=pageInfoHisService.insert(pageInfoHisVO,false);
		return result;
	}



	/**
	 * 删除页面历史
	*/
	@ApiOperation(value = "删除页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoHisServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  pageInfoHisService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=pageInfoHisService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除页面历史 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PageInfoHisServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = pageInfoHisService.hasRefers(ids);
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
			Result result=pageInfoHisService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=pageInfoHisService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新页面历史
	*/
	@ApiOperation(value = "更新页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.PAGE_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PageInfoHisVOMeta.PAGE_INDEX , PageInfoHisVOMeta.PAGE_SIZE , PageInfoHisVOMeta.SEARCH_FIELD , PageInfoHisVOMeta.FUZZY_FIELD , PageInfoHisVOMeta.SEARCH_VALUE , PageInfoHisVOMeta.DIRTY_FIELDS , PageInfoHisVOMeta.SORT_FIELD , PageInfoHisVOMeta.SORT_TYPE , PageInfoHisVOMeta.DATA_ORIGIN , PageInfoHisVOMeta.QUERY_LOGIC , PageInfoHisVOMeta.REQUEST_ACTION , PageInfoHisVOMeta.IDS } )
	@SentinelResource(value = PageInfoHisServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.UPDATE)
	public Result update(PageInfoHisVO pageInfoHisVO) {
		
		Result result=pageInfoHisService.update(pageInfoHisVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存页面历史
	*/
	@ApiOperation(value = "保存页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.PAGE_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PageInfoHisVOMeta.PAGE_INDEX , PageInfoHisVOMeta.PAGE_SIZE , PageInfoHisVOMeta.SEARCH_FIELD , PageInfoHisVOMeta.FUZZY_FIELD , PageInfoHisVOMeta.SEARCH_VALUE , PageInfoHisVOMeta.DIRTY_FIELDS , PageInfoHisVOMeta.SORT_FIELD , PageInfoHisVOMeta.SORT_TYPE , PageInfoHisVOMeta.DATA_ORIGIN , PageInfoHisVOMeta.QUERY_LOGIC , PageInfoHisVOMeta.REQUEST_ACTION , PageInfoHisVOMeta.IDS } )
	@SentinelResource(value = PageInfoHisServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.SAVE)
	public Result save(PageInfoHisVO pageInfoHisVO) {
		
		Result result=pageInfoHisService.save(pageInfoHisVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取页面历史
	*/
	@ApiOperation(value = "获取页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoHisServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.GET_BY_ID)
	public Result<PageInfoHis> getById(String id) {
		
		Result<PageInfoHis> result=new Result<>();
		PageInfoHis pageInfoHis=pageInfoHisService.getById(id);
		result.success(true).data(pageInfoHis);
		return result;
	}


	/**
	 * 批量获取页面历史 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取页面历史")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PageInfoHisVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PageInfoHisServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.GET_BY_IDS)
	public Result<List<PageInfoHis>> getByIds(List<String> ids) {
		
		Result<List<PageInfoHis>> result=new Result<>();
		List<PageInfoHis> list=pageInfoHisService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询页面历史
	*/
	@ApiOperation(value = "查询页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.PAGE_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PageInfoHisVOMeta.PAGE_INDEX , PageInfoHisVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PageInfoHisServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.QUERY_LIST)
	public Result<List<PageInfoHis>> queryList(PageInfoHisVO sample) {
		
		Result<List<PageInfoHis>> result=new Result<>();
		List<PageInfoHis> list=pageInfoHisService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询页面历史
	*/
	@ApiOperation(value = "分页查询页面历史")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoHisVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.PAGE_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoHisVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoHisServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoHisServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PageInfoHis>> queryPagedList(PageInfoHisVO sample) {
		
		Result<PagedList<PageInfoHis>> result=new Result<>();
		PagedList<PageInfoHis> list=pageInfoHisService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}