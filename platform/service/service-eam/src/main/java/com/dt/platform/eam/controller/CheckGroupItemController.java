package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.CheckGroupItemServiceProxy;
import com.dt.platform.domain.eam.meta.CheckGroupItemVOMeta;
import com.dt.platform.domain.eam.CheckGroupItem;
import com.dt.platform.domain.eam.CheckGroupItemVO;
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
import com.dt.platform.domain.eam.meta.CheckGroupItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICheckGroupItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 检查项内容接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 09:44:04
*/

@InDoc
@Api(tags = "检查项内容")
@RestController("EamCheckGroupItemController")
public class CheckGroupItemController extends SuperController {

	@Autowired
	private ICheckGroupItemService checkGroupItemService;

	/**
	 * 添加检查项内容
	*/
	@ApiOperation(value = "添加检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.GROUP_ID , value = "组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ITEM_ID , value = "检查项" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.INSERT)
	public Result insert(CheckGroupItemVO checkGroupItemVO) {
		
		Result result=checkGroupItemService.insert(checkGroupItemVO,false);
		return result;
	}



	/**
	 * 删除检查项内容
	*/
	@ApiOperation(value = "删除检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  checkGroupItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=checkGroupItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除检查项内容 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CheckGroupItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = checkGroupItemService.hasRefers(ids);
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
			Result result=checkGroupItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=checkGroupItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新检查项内容
	*/
	@ApiOperation(value = "更新检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.GROUP_ID , value = "组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ITEM_ID , value = "检查项" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CheckGroupItemVOMeta.PAGE_INDEX , CheckGroupItemVOMeta.PAGE_SIZE , CheckGroupItemVOMeta.SEARCH_FIELD , CheckGroupItemVOMeta.FUZZY_FIELD , CheckGroupItemVOMeta.SEARCH_VALUE , CheckGroupItemVOMeta.DIRTY_FIELDS , CheckGroupItemVOMeta.SORT_FIELD , CheckGroupItemVOMeta.SORT_TYPE , CheckGroupItemVOMeta.DATA_ORIGIN , CheckGroupItemVOMeta.QUERY_LOGIC , CheckGroupItemVOMeta.REQUEST_ACTION , CheckGroupItemVOMeta.IDS } )
	@SentinelResource(value = CheckGroupItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.UPDATE)
	public Result update(CheckGroupItemVO checkGroupItemVO) {
		
		Result result=checkGroupItemService.update(checkGroupItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存检查项内容
	*/
	@ApiOperation(value = "保存检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.GROUP_ID , value = "组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ITEM_ID , value = "检查项" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CheckGroupItemVOMeta.PAGE_INDEX , CheckGroupItemVOMeta.PAGE_SIZE , CheckGroupItemVOMeta.SEARCH_FIELD , CheckGroupItemVOMeta.FUZZY_FIELD , CheckGroupItemVOMeta.SEARCH_VALUE , CheckGroupItemVOMeta.DIRTY_FIELDS , CheckGroupItemVOMeta.SORT_FIELD , CheckGroupItemVOMeta.SORT_TYPE , CheckGroupItemVOMeta.DATA_ORIGIN , CheckGroupItemVOMeta.QUERY_LOGIC , CheckGroupItemVOMeta.REQUEST_ACTION , CheckGroupItemVOMeta.IDS } )
	@SentinelResource(value = CheckGroupItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.SAVE)
	public Result save(CheckGroupItemVO checkGroupItemVO) {
		
		Result result=checkGroupItemService.save(checkGroupItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取检查项内容
	*/
	@ApiOperation(value = "获取检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.GET_BY_ID)
	public Result<CheckGroupItem> getById(String id) {
		
		Result<CheckGroupItem> result=new Result<>();
		CheckGroupItem checkGroupItem=checkGroupItemService.getById(id);
		result.success(true).data(checkGroupItem);
		return result;
	}


	/**
	 * 批量获取检查项内容 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取检查项内容")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CheckGroupItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CheckGroupItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.GET_BY_IDS)
	public Result<List<CheckGroupItem>> getByIds(List<String> ids) {
		
		Result<List<CheckGroupItem>> result=new Result<>();
		List<CheckGroupItem> list=checkGroupItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询检查项内容
	*/
	@ApiOperation(value = "查询检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.GROUP_ID , value = "组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ITEM_ID , value = "检查项" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CheckGroupItemVOMeta.PAGE_INDEX , CheckGroupItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CheckGroupItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.QUERY_LIST)
	public Result<List<CheckGroupItem>> queryList(CheckGroupItemVO sample) {
		
		Result<List<CheckGroupItem>> result=new Result<>();
		List<CheckGroupItem> list=checkGroupItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询检查项内容
	*/
	@ApiOperation(value = "分页查询检查项内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.GROUP_ID , value = "组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupItemVOMeta.ITEM_ID , value = "检查项" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CheckGroupItem>> queryPagedList(CheckGroupItemVO sample) {
		
		Result<PagedList<CheckGroupItem>> result=new Result<>();
		PagedList<CheckGroupItem> list=checkGroupItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}