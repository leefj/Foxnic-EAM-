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


import com.dt.platform.proxy.oa.CrmCustomerCareServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerCareVOMeta;
import com.dt.platform.domain.oa.CrmCustomerCare;
import com.dt.platform.domain.oa.CrmCustomerCareVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerCareMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerCareService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 我的关注接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 12:56:44
*/

@InDoc
@Api(tags = "我的关注")
@RestController("OaCrmCustomerCareController")
public class CrmCustomerCareController extends SuperController {

	@Autowired
	private ICrmCustomerCareService crmCustomerCareService;

	/**
	 * 添加我的关注
	*/
	@ApiOperation(value = "添加我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerCareServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.INSERT)
	public Result insert(CrmCustomerCareVO crmCustomerCareVO) {
		
		Result result=crmCustomerCareService.insert(crmCustomerCareVO,false);
		return result;
	}



	/**
	 * 删除我的关注
	*/
	@ApiOperation(value = "删除我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerCareServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerCareService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerCareService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除我的关注 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerCareServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerCareService.hasRefers(ids);
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
			Result result=crmCustomerCareService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerCareService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新我的关注
	*/
	@ApiOperation(value = "更新我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerCareVOMeta.PAGE_INDEX , CrmCustomerCareVOMeta.PAGE_SIZE , CrmCustomerCareVOMeta.SEARCH_FIELD , CrmCustomerCareVOMeta.FUZZY_FIELD , CrmCustomerCareVOMeta.SEARCH_VALUE , CrmCustomerCareVOMeta.DIRTY_FIELDS , CrmCustomerCareVOMeta.SORT_FIELD , CrmCustomerCareVOMeta.SORT_TYPE , CrmCustomerCareVOMeta.DATA_ORIGIN , CrmCustomerCareVOMeta.QUERY_LOGIC , CrmCustomerCareVOMeta.REQUEST_ACTION , CrmCustomerCareVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerCareServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.UPDATE)
	public Result update(CrmCustomerCareVO crmCustomerCareVO) {
		
		Result result=crmCustomerCareService.update(crmCustomerCareVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存我的关注
	*/
	@ApiOperation(value = "保存我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerCareVOMeta.PAGE_INDEX , CrmCustomerCareVOMeta.PAGE_SIZE , CrmCustomerCareVOMeta.SEARCH_FIELD , CrmCustomerCareVOMeta.FUZZY_FIELD , CrmCustomerCareVOMeta.SEARCH_VALUE , CrmCustomerCareVOMeta.DIRTY_FIELDS , CrmCustomerCareVOMeta.SORT_FIELD , CrmCustomerCareVOMeta.SORT_TYPE , CrmCustomerCareVOMeta.DATA_ORIGIN , CrmCustomerCareVOMeta.QUERY_LOGIC , CrmCustomerCareVOMeta.REQUEST_ACTION , CrmCustomerCareVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerCareServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.SAVE)
	public Result save(CrmCustomerCareVO crmCustomerCareVO) {
		
		Result result=crmCustomerCareService.save(crmCustomerCareVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取我的关注
	*/
	@ApiOperation(value = "获取我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerCareServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.GET_BY_ID)
	public Result<CrmCustomerCare> getById(String id) {
		
		Result<CrmCustomerCare> result=new Result<>();
		CrmCustomerCare crmCustomerCare=crmCustomerCareService.getById(id);
		// join 关联的对象
		crmCustomerCareService.dao().fill(crmCustomerCare)
			.with("user")
			.execute();
		result.success(true).data(crmCustomerCare);
		return result;
	}


	/**
	 * 批量获取我的关注 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取我的关注")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerCareVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerCareServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerCare>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerCare>> result=new Result<>();
		List<CrmCustomerCare> list=crmCustomerCareService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询我的关注
	*/
	@ApiOperation(value = "查询我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerCareVOMeta.PAGE_INDEX , CrmCustomerCareVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerCareServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerCare>> queryList(CrmCustomerCareVO sample) {
		
		Result<List<CrmCustomerCare>> result=new Result<>();
		List<CrmCustomerCare> list=crmCustomerCareService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询我的关注
	*/
	@ApiOperation(value = "分页查询我的关注")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerCareVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerCareServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerCareServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerCare>> queryPagedList(CrmCustomerCareVO sample) {
		
		Result<PagedList<CrmCustomerCare>> result=new Result<>();
		PagedList<CrmCustomerCare> list=crmCustomerCareService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		crmCustomerCareService.dao().fill(list)
			.with("user")
			.execute();
		result.success(true).data(list);
		return result;
	}





}