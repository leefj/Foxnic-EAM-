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


import com.dt.platform.proxy.oa.CrmCustomerSourceServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerSourceVOMeta;
import com.dt.platform.domain.oa.CrmCustomerSource;
import com.dt.platform.domain.oa.CrmCustomerSourceVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerSourceMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerSourceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 客户渠道接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:30:49
*/

@InDoc
@Api(tags = "客户渠道")
@RestController("OaCrmCustomerSourceController")
public class CrmCustomerSourceController extends SuperController {

	@Autowired
	private ICrmCustomerSourceService crmCustomerSourceService;

	/**
	 * 添加客户渠道
	*/
	@ApiOperation(value = "添加客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerSourceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.INSERT)
	public Result insert(CrmCustomerSourceVO crmCustomerSourceVO) {
		
		Result result=crmCustomerSourceService.insert(crmCustomerSourceVO,false);
		return result;
	}



	/**
	 * 删除客户渠道
	*/
	@ApiOperation(value = "删除客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerSourceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerSourceService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerSourceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除客户渠道 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerSourceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerSourceService.hasRefers(ids);
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
			Result result=crmCustomerSourceService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerSourceService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新客户渠道
	*/
	@ApiOperation(value = "更新客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerSourceVOMeta.PAGE_INDEX , CrmCustomerSourceVOMeta.PAGE_SIZE , CrmCustomerSourceVOMeta.SEARCH_FIELD , CrmCustomerSourceVOMeta.FUZZY_FIELD , CrmCustomerSourceVOMeta.SEARCH_VALUE , CrmCustomerSourceVOMeta.DIRTY_FIELDS , CrmCustomerSourceVOMeta.SORT_FIELD , CrmCustomerSourceVOMeta.SORT_TYPE , CrmCustomerSourceVOMeta.DATA_ORIGIN , CrmCustomerSourceVOMeta.QUERY_LOGIC , CrmCustomerSourceVOMeta.REQUEST_ACTION , CrmCustomerSourceVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerSourceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.UPDATE)
	public Result update(CrmCustomerSourceVO crmCustomerSourceVO) {
		
		Result result=crmCustomerSourceService.update(crmCustomerSourceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存客户渠道
	*/
	@ApiOperation(value = "保存客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerSourceVOMeta.PAGE_INDEX , CrmCustomerSourceVOMeta.PAGE_SIZE , CrmCustomerSourceVOMeta.SEARCH_FIELD , CrmCustomerSourceVOMeta.FUZZY_FIELD , CrmCustomerSourceVOMeta.SEARCH_VALUE , CrmCustomerSourceVOMeta.DIRTY_FIELDS , CrmCustomerSourceVOMeta.SORT_FIELD , CrmCustomerSourceVOMeta.SORT_TYPE , CrmCustomerSourceVOMeta.DATA_ORIGIN , CrmCustomerSourceVOMeta.QUERY_LOGIC , CrmCustomerSourceVOMeta.REQUEST_ACTION , CrmCustomerSourceVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerSourceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.SAVE)
	public Result save(CrmCustomerSourceVO crmCustomerSourceVO) {
		
		Result result=crmCustomerSourceService.save(crmCustomerSourceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取客户渠道
	*/
	@ApiOperation(value = "获取客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerSourceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.GET_BY_ID)
	public Result<CrmCustomerSource> getById(String id) {
		
		Result<CrmCustomerSource> result=new Result<>();
		CrmCustomerSource crmCustomerSource=crmCustomerSourceService.getById(id);
		result.success(true).data(crmCustomerSource);
		return result;
	}


	/**
	 * 批量获取客户渠道 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取客户渠道")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerSourceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerSourceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerSource>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerSource>> result=new Result<>();
		List<CrmCustomerSource> list=crmCustomerSourceService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询客户渠道
	*/
	@ApiOperation(value = "查询客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerSourceVOMeta.PAGE_INDEX , CrmCustomerSourceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerSourceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerSource>> queryList(CrmCustomerSourceVO sample) {
		
		Result<List<CrmCustomerSource>> result=new Result<>();
		List<CrmCustomerSource> list=crmCustomerSourceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询客户渠道
	*/
	@ApiOperation(value = "分页查询客户渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerSourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerSourceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerSourceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerSource>> queryPagedList(CrmCustomerSourceVO sample) {
		
		Result<PagedList<CrmCustomerSource>> result=new Result<>();
		PagedList<CrmCustomerSource> list=crmCustomerSourceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}