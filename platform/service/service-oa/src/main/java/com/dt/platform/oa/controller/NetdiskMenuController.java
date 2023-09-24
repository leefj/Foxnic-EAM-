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


import com.dt.platform.proxy.oa.NetdiskMenuServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskMenuVOMeta;
import com.dt.platform.domain.oa.NetdiskMenu;
import com.dt.platform.domain.oa.NetdiskMenuVO;
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
import com.dt.platform.domain.oa.meta.NetdiskMenuMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskMenuService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 网盘菜单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-17 17:52:47
*/

@InDoc
@Api(tags = "网盘菜单")
@RestController("OaNetdiskMenuController")
public class NetdiskMenuController extends SuperController {

	@Autowired
	private INetdiskMenuService netdiskMenuService;

	/**
	 * 添加网盘菜单
	*/
	@ApiOperation(value = "添加网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "root"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "位置"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ICON_CODE , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SHOW_VALUE , value = "是否显示" , required = false , dataTypeClass=String.class , example = "show"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SORT_VALUE , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.PARENT_ID , value = "上一级" , required = false , dataTypeClass=String.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMenuServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.INSERT)
	public Result insert(NetdiskMenuVO netdiskMenuVO) {
		
		Result result=netdiskMenuService.insert(netdiskMenuVO,false);
		return result;
	}



	/**
	 * 删除网盘菜单
	*/
	@ApiOperation(value = "删除网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMenuServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  netdiskMenuService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=netdiskMenuService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除网盘菜单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = NetdiskMenuServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = netdiskMenuService.hasRefers(ids);
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
			Result result=netdiskMenuService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=netdiskMenuService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新网盘菜单
	*/
	@ApiOperation(value = "更新网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "root"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "位置"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ICON_CODE , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SHOW_VALUE , value = "是否显示" , required = false , dataTypeClass=String.class , example = "show"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SORT_VALUE , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.PARENT_ID , value = "上一级" , required = false , dataTypeClass=String.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskMenuVOMeta.PAGE_INDEX , NetdiskMenuVOMeta.PAGE_SIZE , NetdiskMenuVOMeta.SEARCH_FIELD , NetdiskMenuVOMeta.FUZZY_FIELD , NetdiskMenuVOMeta.SEARCH_VALUE , NetdiskMenuVOMeta.DIRTY_FIELDS , NetdiskMenuVOMeta.SORT_FIELD , NetdiskMenuVOMeta.SORT_TYPE , NetdiskMenuVOMeta.DATA_ORIGIN , NetdiskMenuVOMeta.QUERY_LOGIC , NetdiskMenuVOMeta.REQUEST_ACTION , NetdiskMenuVOMeta.IDS } )
	@SentinelResource(value = NetdiskMenuServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.UPDATE)
	public Result update(NetdiskMenuVO netdiskMenuVO) {
		
		Result result=netdiskMenuService.update(netdiskMenuVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存网盘菜单
	*/
	@ApiOperation(value = "保存网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "root"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "位置"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ICON_CODE , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SHOW_VALUE , value = "是否显示" , required = false , dataTypeClass=String.class , example = "show"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SORT_VALUE , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.PARENT_ID , value = "上一级" , required = false , dataTypeClass=String.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NetdiskMenuVOMeta.PAGE_INDEX , NetdiskMenuVOMeta.PAGE_SIZE , NetdiskMenuVOMeta.SEARCH_FIELD , NetdiskMenuVOMeta.FUZZY_FIELD , NetdiskMenuVOMeta.SEARCH_VALUE , NetdiskMenuVOMeta.DIRTY_FIELDS , NetdiskMenuVOMeta.SORT_FIELD , NetdiskMenuVOMeta.SORT_TYPE , NetdiskMenuVOMeta.DATA_ORIGIN , NetdiskMenuVOMeta.QUERY_LOGIC , NetdiskMenuVOMeta.REQUEST_ACTION , NetdiskMenuVOMeta.IDS } )
	@SentinelResource(value = NetdiskMenuServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.SAVE)
	public Result save(NetdiskMenuVO netdiskMenuVO) {
		
		Result result=netdiskMenuService.save(netdiskMenuVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取网盘菜单
	*/
	@ApiOperation(value = "获取网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMenuServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.GET_BY_ID)
	public Result<NetdiskMenu> getById(String id) {
		
		Result<NetdiskMenu> result=new Result<>();
		NetdiskMenu netdiskMenu=netdiskMenuService.getById(id);
		result.success(true).data(netdiskMenu);
		return result;
	}


	/**
	 * 批量获取网盘菜单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取网盘菜单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NetdiskMenuVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = NetdiskMenuServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.GET_BY_IDS)
	public Result<List<NetdiskMenu>> getByIds(List<String> ids) {
		
		Result<List<NetdiskMenu>> result=new Result<>();
		List<NetdiskMenu> list=netdiskMenuService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询网盘菜单
	*/
	@ApiOperation(value = "查询网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "root"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "位置"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ICON_CODE , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SHOW_VALUE , value = "是否显示" , required = false , dataTypeClass=String.class , example = "show"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SORT_VALUE , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.PARENT_ID , value = "上一级" , required = false , dataTypeClass=String.class , example = "0"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskMenuVOMeta.PAGE_INDEX , NetdiskMenuVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NetdiskMenuServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.QUERY_LIST)
	public Result<List<NetdiskMenu>> queryList(NetdiskMenuVO sample) {
		
		Result<List<NetdiskMenu>> result=new Result<>();
		List<NetdiskMenu> list=netdiskMenuService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询网盘菜单
	*/
	@ApiOperation(value = "分页查询网盘菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "root"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "位置"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.ICON_CODE , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SHOW_VALUE , value = "是否显示" , required = false , dataTypeClass=String.class , example = "show"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.SORT_VALUE , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = NetdiskMenuVOMeta.PARENT_ID , value = "上一级" , required = false , dataTypeClass=String.class , example = "0"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskMenuServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskMenuServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<NetdiskMenu>> queryPagedList(NetdiskMenuVO sample) {
		
		Result<PagedList<NetdiskMenu>> result=new Result<>();
		PagedList<NetdiskMenu> list=netdiskMenuService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}