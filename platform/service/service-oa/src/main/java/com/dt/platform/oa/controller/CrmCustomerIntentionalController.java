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


import com.dt.platform.proxy.oa.CrmCustomerIntentionalServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerIntentionalVOMeta;
import com.dt.platform.domain.oa.CrmCustomerIntentional;
import com.dt.platform.domain.oa.CrmCustomerIntentionalVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerIntentionalMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerIntentionalService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 客户意向接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:32:22
*/

@InDoc
@Api(tags = "客户意向")
@RestController("OaCrmCustomerIntentionalController")
public class CrmCustomerIntentionalController extends SuperController {

	@Autowired
	private ICrmCustomerIntentionalService crmCustomerIntentionalService;

	/**
	 * 添加客户意向
	*/
	@ApiOperation(value = "添加客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.INSERT)
	public Result insert(CrmCustomerIntentionalVO crmCustomerIntentionalVO) {
		
		Result result=crmCustomerIntentionalService.insert(crmCustomerIntentionalVO,false);
		return result;
	}



	/**
	 * 删除客户意向
	*/
	@ApiOperation(value = "删除客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerIntentionalService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerIntentionalService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除客户意向 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerIntentionalService.hasRefers(ids);
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
			Result result=crmCustomerIntentionalService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerIntentionalService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新客户意向
	*/
	@ApiOperation(value = "更新客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerIntentionalVOMeta.PAGE_INDEX , CrmCustomerIntentionalVOMeta.PAGE_SIZE , CrmCustomerIntentionalVOMeta.SEARCH_FIELD , CrmCustomerIntentionalVOMeta.FUZZY_FIELD , CrmCustomerIntentionalVOMeta.SEARCH_VALUE , CrmCustomerIntentionalVOMeta.DIRTY_FIELDS , CrmCustomerIntentionalVOMeta.SORT_FIELD , CrmCustomerIntentionalVOMeta.SORT_TYPE , CrmCustomerIntentionalVOMeta.DATA_ORIGIN , CrmCustomerIntentionalVOMeta.QUERY_LOGIC , CrmCustomerIntentionalVOMeta.REQUEST_ACTION , CrmCustomerIntentionalVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.UPDATE)
	public Result update(CrmCustomerIntentionalVO crmCustomerIntentionalVO) {
		
		Result result=crmCustomerIntentionalService.update(crmCustomerIntentionalVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存客户意向
	*/
	@ApiOperation(value = "保存客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerIntentionalVOMeta.PAGE_INDEX , CrmCustomerIntentionalVOMeta.PAGE_SIZE , CrmCustomerIntentionalVOMeta.SEARCH_FIELD , CrmCustomerIntentionalVOMeta.FUZZY_FIELD , CrmCustomerIntentionalVOMeta.SEARCH_VALUE , CrmCustomerIntentionalVOMeta.DIRTY_FIELDS , CrmCustomerIntentionalVOMeta.SORT_FIELD , CrmCustomerIntentionalVOMeta.SORT_TYPE , CrmCustomerIntentionalVOMeta.DATA_ORIGIN , CrmCustomerIntentionalVOMeta.QUERY_LOGIC , CrmCustomerIntentionalVOMeta.REQUEST_ACTION , CrmCustomerIntentionalVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.SAVE)
	public Result save(CrmCustomerIntentionalVO crmCustomerIntentionalVO) {
		
		Result result=crmCustomerIntentionalService.save(crmCustomerIntentionalVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取客户意向
	*/
	@ApiOperation(value = "获取客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.GET_BY_ID)
	public Result<CrmCustomerIntentional> getById(String id) {
		
		Result<CrmCustomerIntentional> result=new Result<>();
		CrmCustomerIntentional crmCustomerIntentional=crmCustomerIntentionalService.getById(id);
		result.success(true).data(crmCustomerIntentional);
		return result;
	}


	/**
	 * 批量获取客户意向 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取客户意向")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerIntentionalServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerIntentional>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerIntentional>> result=new Result<>();
		List<CrmCustomerIntentional> list=crmCustomerIntentionalService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询客户意向
	*/
	@ApiOperation(value = "查询客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerIntentionalVOMeta.PAGE_INDEX , CrmCustomerIntentionalVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerIntentional>> queryList(CrmCustomerIntentionalVO sample) {
		
		Result<List<CrmCustomerIntentional>> result=new Result<>();
		List<CrmCustomerIntentional> list=crmCustomerIntentionalService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询客户意向
	*/
	@ApiOperation(value = "分页查询客户意向")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIntentionalVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIntentionalServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIntentionalServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerIntentional>> queryPagedList(CrmCustomerIntentionalVO sample) {
		
		Result<PagedList<CrmCustomerIntentional>> result=new Result<>();
		PagedList<CrmCustomerIntentional> list=crmCustomerIntentionalService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}