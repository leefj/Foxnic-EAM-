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


import com.dt.platform.proxy.common.KeyCodeServiceProxy;
import com.dt.platform.domain.common.meta.KeyCodeVOMeta;
import com.dt.platform.domain.common.KeyCode;
import com.dt.platform.domain.common.KeyCodeVO;
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
import com.dt.platform.domain.common.meta.KeyCodeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IKeyCodeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 菜单键值接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 19:37:06
*/

@InDoc
@Api(tags = "菜单键值")
@RestController("SysKeyCodeController")
public class KeyCodeController extends SuperController {

	@Autowired
	private IKeyCodeService keyCodeService;

	/**
	 * 添加菜单键值
	*/
	@ApiOperation(value = "添加菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.KEY , value = "键值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = KeyCodeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.INSERT)
	public Result insert(KeyCodeVO keyCodeVO) {
		
		Result result=keyCodeService.insert(keyCodeVO,false);
		return result;
	}



	/**
	 * 删除菜单键值
	*/
	@ApiOperation(value = "删除菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = KeyCodeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  keyCodeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=keyCodeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除菜单键值 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = KeyCodeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = keyCodeService.hasRefers(ids);
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
			Result result=keyCodeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=keyCodeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新菜单键值
	*/
	@ApiOperation(value = "更新菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.KEY , value = "键值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { KeyCodeVOMeta.PAGE_INDEX , KeyCodeVOMeta.PAGE_SIZE , KeyCodeVOMeta.SEARCH_FIELD , KeyCodeVOMeta.FUZZY_FIELD , KeyCodeVOMeta.SEARCH_VALUE , KeyCodeVOMeta.DIRTY_FIELDS , KeyCodeVOMeta.SORT_FIELD , KeyCodeVOMeta.SORT_TYPE , KeyCodeVOMeta.DATA_ORIGIN , KeyCodeVOMeta.QUERY_LOGIC , KeyCodeVOMeta.REQUEST_ACTION , KeyCodeVOMeta.IDS } )
	@SentinelResource(value = KeyCodeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.UPDATE)
	public Result update(KeyCodeVO keyCodeVO) {
		
		Result result=keyCodeService.update(keyCodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存菜单键值
	*/
	@ApiOperation(value = "保存菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.KEY , value = "键值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { KeyCodeVOMeta.PAGE_INDEX , KeyCodeVOMeta.PAGE_SIZE , KeyCodeVOMeta.SEARCH_FIELD , KeyCodeVOMeta.FUZZY_FIELD , KeyCodeVOMeta.SEARCH_VALUE , KeyCodeVOMeta.DIRTY_FIELDS , KeyCodeVOMeta.SORT_FIELD , KeyCodeVOMeta.SORT_TYPE , KeyCodeVOMeta.DATA_ORIGIN , KeyCodeVOMeta.QUERY_LOGIC , KeyCodeVOMeta.REQUEST_ACTION , KeyCodeVOMeta.IDS } )
	@SentinelResource(value = KeyCodeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.SAVE)
	public Result save(KeyCodeVO keyCodeVO) {
		
		Result result=keyCodeService.save(keyCodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取菜单键值
	*/
	@ApiOperation(value = "获取菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = KeyCodeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.GET_BY_ID)
	public Result<KeyCode> getById(String id) {
		
		Result<KeyCode> result=new Result<>();
		KeyCode keyCode=keyCodeService.getById(id);
		result.success(true).data(keyCode);
		return result;
	}


	/**
	 * 批量获取菜单键值 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取菜单键值")
		@ApiImplicitParams({
				@ApiImplicitParam(name = KeyCodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = KeyCodeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.GET_BY_IDS)
	public Result<List<KeyCode>> getByIds(List<String> ids) {
		
		Result<List<KeyCode>> result=new Result<>();
		List<KeyCode> list=keyCodeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询菜单键值
	*/
	@ApiOperation(value = "查询菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.KEY , value = "键值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { KeyCodeVOMeta.PAGE_INDEX , KeyCodeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = KeyCodeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.QUERY_LIST)
	public Result<List<KeyCode>> queryList(KeyCodeVO sample) {
		
		Result<List<KeyCode>> result=new Result<>();
		List<KeyCode> list=keyCodeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询菜单键值
	*/
	@ApiOperation(value = "分页查询菜单键值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = KeyCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.KEY , value = "键值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = KeyCodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = KeyCodeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(KeyCodeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<KeyCode>> queryPagedList(KeyCodeVO sample) {
		
		Result<PagedList<KeyCode>> result=new Result<>();
		PagedList<KeyCode> list=keyCodeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}