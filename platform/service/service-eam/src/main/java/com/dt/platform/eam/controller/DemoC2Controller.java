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


import com.dt.platform.proxy.eam.DemoC2ServiceProxy;
import com.dt.platform.domain.eam.meta.DemoC2VOMeta;
import com.dt.platform.domain.eam.DemoC2;
import com.dt.platform.domain.eam.DemoC2VO;
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
import com.dt.platform.domain.eam.meta.DemoC2Meta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IDemoC2Service;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * demo接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-08 08:04:40
*/

@InDoc
@Api(tags = "demo")
@RestController("EamDemoC2Controller")
public class DemoC2Controller extends SuperController {

	@Autowired
	private IDemoC2Service demoC2Service;

	/**
	 * 添加demo
	*/
	@ApiOperation(value = "添加demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.PRICE , value = "价格" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DemoC2VOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoC2ServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.INSERT)
	public Result insert(DemoC2VO demoC2VO) {
		
		Result result=demoC2Service.insert(demoC2VO,false);
		return result;
	}



	/**
	 * 删除demo
	*/
	@ApiOperation(value = "删除demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoC2ServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  demoC2Service.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=demoC2Service.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除demo <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DemoC2ServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = demoC2Service.hasRefers(ids);
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
			Result result=demoC2Service.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=demoC2Service.deleteByIdsLogical(canDeleteIds);
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
	 * 更新demo
	*/
	@ApiOperation(value = "更新demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.PRICE , value = "价格" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DemoC2VOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DemoC2VOMeta.PAGE_INDEX , DemoC2VOMeta.PAGE_SIZE , DemoC2VOMeta.SEARCH_FIELD , DemoC2VOMeta.FUZZY_FIELD , DemoC2VOMeta.SEARCH_VALUE , DemoC2VOMeta.DIRTY_FIELDS , DemoC2VOMeta.SORT_FIELD , DemoC2VOMeta.SORT_TYPE , DemoC2VOMeta.DATA_ORIGIN , DemoC2VOMeta.QUERY_LOGIC , DemoC2VOMeta.REQUEST_ACTION , DemoC2VOMeta.IDS } )
	@SentinelResource(value = DemoC2ServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.UPDATE)
	public Result update(DemoC2VO demoC2VO) {
		
		Result result=demoC2Service.update(demoC2VO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存demo
	*/
	@ApiOperation(value = "保存demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.PRICE , value = "价格" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DemoC2VOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DemoC2VOMeta.PAGE_INDEX , DemoC2VOMeta.PAGE_SIZE , DemoC2VOMeta.SEARCH_FIELD , DemoC2VOMeta.FUZZY_FIELD , DemoC2VOMeta.SEARCH_VALUE , DemoC2VOMeta.DIRTY_FIELDS , DemoC2VOMeta.SORT_FIELD , DemoC2VOMeta.SORT_TYPE , DemoC2VOMeta.DATA_ORIGIN , DemoC2VOMeta.QUERY_LOGIC , DemoC2VOMeta.REQUEST_ACTION , DemoC2VOMeta.IDS } )
	@SentinelResource(value = DemoC2ServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.SAVE)
	public Result save(DemoC2VO demoC2VO) {
		
		Result result=demoC2Service.save(demoC2VO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取demo
	*/
	@ApiOperation(value = "获取demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoC2ServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.GET_BY_ID)
	public Result<DemoC2> getById(String id) {
		
		Result<DemoC2> result=new Result<>();
		DemoC2 demoC2=demoC2Service.getById(id);
		result.success(true).data(demoC2);
		return result;
	}


	/**
	 * 批量获取demo <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取demo")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DemoC2VOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DemoC2ServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.GET_BY_IDS)
	public Result<List<DemoC2>> getByIds(List<String> ids) {
		
		Result<List<DemoC2>> result=new Result<>();
		List<DemoC2> list=demoC2Service.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询demo
	*/
	@ApiOperation(value = "查询demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.PRICE , value = "价格" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DemoC2VOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DemoC2VOMeta.PAGE_INDEX , DemoC2VOMeta.PAGE_SIZE } )
	@SentinelResource(value = DemoC2ServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.QUERY_LIST)
	public Result<List<DemoC2>> queryList(DemoC2VO sample) {
		
		Result<List<DemoC2>> result=new Result<>();
		List<DemoC2> list=demoC2Service.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询demo
	*/
	@ApiOperation(value = "分页查询demo")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoC2VOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoC2VOMeta.PRICE , value = "价格" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DemoC2VOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoC2ServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoC2ServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DemoC2>> queryPagedList(DemoC2VO sample) {
		
		Result<PagedList<DemoC2>> result=new Result<>();
		PagedList<DemoC2> list=demoC2Service.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}