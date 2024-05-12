package com.dt.platform.common.controller;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.common.PageInfoServiceProxy;
import com.dt.platform.domain.common.meta.PageInfoVOMeta;
import com.dt.platform.domain.common.PageInfo;
import com.dt.platform.domain.common.PageInfoVO;
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
import com.dt.platform.domain.common.meta.PageInfoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPageInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 页面开发接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-12 10:48:42
*/

@InDoc
@Api(tags = "页面开发")
@RestController("SysPageInfoController")
public class PageInfoController extends SuperController {

	@Autowired
	private IPageInfoService pageInfoService;

	/**
	 * 添加页面开发
	*/
	@ApiOperation(value = "添加页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.INSERT)
	public Result insert(PageInfoVO pageInfoVO) {
		Result result=pageInfoService.insert(pageInfoVO,false);
		return result;
	}



	/**
	 * 删除页面开发
	*/


	@ApiOperation(value = "")
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoServiceProxy.GET_PAGE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@GetMapping(PageInfoServiceProxy.GET_PAGE)
	public Result<JSONObject> getPageInfo(String id) {
	 	return pageInfoService.getPageInfo(id);
	}

	@ApiOperation(value = "")
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoServiceProxy.SAVE_PAGE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.SAVE_PAGE)
	public Result savePageInfo(String id,String pageschema) {
		return pageInfoService.savePageInfo(id,pageschema);
	}

	/**
	 * 批量删除页面开发 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PageInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = pageInfoService.hasRefers(ids);
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
			Result result=pageInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=pageInfoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新页面开发
	*/
	@ApiOperation(value = "更新页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PageInfoVOMeta.PAGE_INDEX , PageInfoVOMeta.PAGE_SIZE , PageInfoVOMeta.SEARCH_FIELD , PageInfoVOMeta.FUZZY_FIELD , PageInfoVOMeta.SEARCH_VALUE , PageInfoVOMeta.DIRTY_FIELDS , PageInfoVOMeta.SORT_FIELD , PageInfoVOMeta.SORT_TYPE , PageInfoVOMeta.DATA_ORIGIN , PageInfoVOMeta.QUERY_LOGIC , PageInfoVOMeta.REQUEST_ACTION , PageInfoVOMeta.IDS } )
	@SentinelResource(value = PageInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.UPDATE)
	public Result update(PageInfoVO pageInfoVO) {
		
		Result result=pageInfoService.update(pageInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存页面开发
	*/
	@ApiOperation(value = "保存页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PageInfoVOMeta.PAGE_INDEX , PageInfoVOMeta.PAGE_SIZE , PageInfoVOMeta.SEARCH_FIELD , PageInfoVOMeta.FUZZY_FIELD , PageInfoVOMeta.SEARCH_VALUE , PageInfoVOMeta.DIRTY_FIELDS , PageInfoVOMeta.SORT_FIELD , PageInfoVOMeta.SORT_TYPE , PageInfoVOMeta.DATA_ORIGIN , PageInfoVOMeta.QUERY_LOGIC , PageInfoVOMeta.REQUEST_ACTION , PageInfoVOMeta.IDS } )
	@SentinelResource(value = PageInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.SAVE)
	public Result save(PageInfoVO pageInfoVO) {
		
		Result result=pageInfoService.save(pageInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取页面开发
	*/
	@ApiOperation(value = "获取页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.GET_BY_ID)
	public Result<PageInfo> getById(String id) {
		
		Result<PageInfo> result=new Result<>();
		PageInfo pageInfo=pageInfoService.getById(id);
		result.success(true).data(pageInfo);
		return result;
	}


	/**
	 * 批量获取页面开发 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取页面开发")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PageInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PageInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.GET_BY_IDS)
	public Result<List<PageInfo>> getByIds(List<String> ids) {
		
		Result<List<PageInfo>> result=new Result<>();
		List<PageInfo> list=pageInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询页面开发
	*/
	@ApiOperation(value = "查询页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PageInfoVOMeta.PAGE_INDEX , PageInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PageInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.QUERY_LIST)
	public Result<List<PageInfo>> queryList(PageInfoVO sample) {
		
		Result<List<PageInfo>> result=new Result<>();
		List<PageInfo> list=pageInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询页面开发
	*/
	@ApiOperation(value = "分页查询页面开发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PageInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.DEF_JSON , value = "定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PageInfoVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PageInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PageInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PageInfo>> queryPagedList(PageInfoVO sample) {
		
		Result<PagedList<PageInfo>> result=new Result<>();
		PagedList<PageInfo> list=pageInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}