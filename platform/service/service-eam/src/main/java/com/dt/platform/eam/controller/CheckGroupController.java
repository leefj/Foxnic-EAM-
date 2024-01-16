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


import com.dt.platform.proxy.eam.CheckGroupServiceProxy;
import com.dt.platform.domain.eam.meta.CheckGroupVOMeta;
import com.dt.platform.domain.eam.CheckGroup;
import com.dt.platform.domain.eam.CheckGroupVO;
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
import com.dt.platform.domain.eam.meta.CheckGroupMeta;
import com.dt.platform.domain.eam.CheckGroupItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICheckGroupService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 检查模版接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-13 13:02:54
*/

@InDoc
@Api(tags = "检查模版")
@RestController("EamCheckGroupController")
public class CheckGroupController extends SuperController {

	@Autowired
	private ICheckGroupService checkGroupService;

	/**
	 * 添加检查模版
	*/
	@ApiOperation(value = "添加检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728920300598591488"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "检查组"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.INSERT)
	public Result insert(CheckGroupVO checkGroupVO) {
		
		Result result=checkGroupService.insert(checkGroupVO,false);
		return result;
	}



	/**
	 * 删除检查模版
	*/
	@ApiOperation(value = "删除检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728920300598591488")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  checkGroupService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=checkGroupService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除检查模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CheckGroupServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = checkGroupService.hasRefers(ids);
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
			Result result=checkGroupService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=checkGroupService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新检查模版
	*/
	@ApiOperation(value = "更新检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728920300598591488"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "检查组"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CheckGroupVOMeta.PAGE_INDEX , CheckGroupVOMeta.PAGE_SIZE , CheckGroupVOMeta.SEARCH_FIELD , CheckGroupVOMeta.FUZZY_FIELD , CheckGroupVOMeta.SEARCH_VALUE , CheckGroupVOMeta.DIRTY_FIELDS , CheckGroupVOMeta.SORT_FIELD , CheckGroupVOMeta.SORT_TYPE , CheckGroupVOMeta.DATA_ORIGIN , CheckGroupVOMeta.QUERY_LOGIC , CheckGroupVOMeta.REQUEST_ACTION , CheckGroupVOMeta.IDS } )
	@SentinelResource(value = CheckGroupServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.UPDATE)
	public Result update(CheckGroupVO checkGroupVO) {
		
		Result result=checkGroupService.update(checkGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存检查模版
	*/
	@ApiOperation(value = "保存检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728920300598591488"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "检查组"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CheckGroupVOMeta.PAGE_INDEX , CheckGroupVOMeta.PAGE_SIZE , CheckGroupVOMeta.SEARCH_FIELD , CheckGroupVOMeta.FUZZY_FIELD , CheckGroupVOMeta.SEARCH_VALUE , CheckGroupVOMeta.DIRTY_FIELDS , CheckGroupVOMeta.SORT_FIELD , CheckGroupVOMeta.SORT_TYPE , CheckGroupVOMeta.DATA_ORIGIN , CheckGroupVOMeta.QUERY_LOGIC , CheckGroupVOMeta.REQUEST_ACTION , CheckGroupVOMeta.IDS } )
	@SentinelResource(value = CheckGroupServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.SAVE)
	public Result save(CheckGroupVO checkGroupVO) {
		
		Result result=checkGroupService.save(checkGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取检查模版
	*/
	@ApiOperation(value = "获取检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.GET_BY_ID)
	public Result<CheckGroup> getById(String id) {
		
		Result<CheckGroup> result=new Result<>();
		CheckGroup checkGroup=checkGroupService.getById(id);
		result.success(true).data(checkGroup);
		return result;
	}


	/**
	 * 批量获取检查模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取检查模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CheckGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CheckGroupServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.GET_BY_IDS)
	public Result<List<CheckGroup>> getByIds(List<String> ids) {
		
		Result<List<CheckGroup>> result=new Result<>();
		List<CheckGroup> list=checkGroupService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询检查模版
	*/
	@ApiOperation(value = "查询检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728920300598591488"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "检查组"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CheckGroupVOMeta.PAGE_INDEX , CheckGroupVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CheckGroupServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.QUERY_LIST)
	public Result<List<CheckGroup>> queryList(CheckGroupVO sample) {
		
		Result<List<CheckGroup>> result=new Result<>();
		List<CheckGroup> list=checkGroupService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询检查模版
	*/
	@ApiOperation(value = "分页查询检查模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CheckGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728920300598591488"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "检查组"),
		@ApiImplicitParam(name = CheckGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CheckGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CheckGroupServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CheckGroupServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CheckGroup>> queryPagedList(CheckGroupVO sample) {
		
		Result<PagedList<CheckGroup>> result=new Result<>();
		PagedList<CheckGroup> list=checkGroupService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}