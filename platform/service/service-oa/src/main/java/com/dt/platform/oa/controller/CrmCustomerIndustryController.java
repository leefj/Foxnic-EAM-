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


import com.dt.platform.proxy.oa.CrmCustomerIndustryServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerIndustryVOMeta;
import com.dt.platform.domain.oa.CrmCustomerIndustry;
import com.dt.platform.domain.oa.CrmCustomerIndustryVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerIndustryMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerIndustryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 客户行业接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:32:40
*/

@InDoc
@Api(tags = "客户行业")
@RestController("OaCrmCustomerIndustryController")
public class CrmCustomerIndustryController extends SuperController {

	@Autowired
	private ICrmCustomerIndustryService crmCustomerIndustryService;

	/**
	 * 添加客户行业
	*/
	@ApiOperation(value = "添加客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.INSERT)
	public Result insert(CrmCustomerIndustryVO crmCustomerIndustryVO) {
		
		Result result=crmCustomerIndustryService.insert(crmCustomerIndustryVO,false);
		return result;
	}



	/**
	 * 删除客户行业
	*/
	@ApiOperation(value = "删除客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerIndustryService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerIndustryService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除客户行业 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerIndustryService.hasRefers(ids);
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
			Result result=crmCustomerIndustryService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerIndustryService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新客户行业
	*/
	@ApiOperation(value = "更新客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerIndustryVOMeta.PAGE_INDEX , CrmCustomerIndustryVOMeta.PAGE_SIZE , CrmCustomerIndustryVOMeta.SEARCH_FIELD , CrmCustomerIndustryVOMeta.FUZZY_FIELD , CrmCustomerIndustryVOMeta.SEARCH_VALUE , CrmCustomerIndustryVOMeta.DIRTY_FIELDS , CrmCustomerIndustryVOMeta.SORT_FIELD , CrmCustomerIndustryVOMeta.SORT_TYPE , CrmCustomerIndustryVOMeta.DATA_ORIGIN , CrmCustomerIndustryVOMeta.QUERY_LOGIC , CrmCustomerIndustryVOMeta.REQUEST_ACTION , CrmCustomerIndustryVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.UPDATE)
	public Result update(CrmCustomerIndustryVO crmCustomerIndustryVO) {
		
		Result result=crmCustomerIndustryService.update(crmCustomerIndustryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存客户行业
	*/
	@ApiOperation(value = "保存客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerIndustryVOMeta.PAGE_INDEX , CrmCustomerIndustryVOMeta.PAGE_SIZE , CrmCustomerIndustryVOMeta.SEARCH_FIELD , CrmCustomerIndustryVOMeta.FUZZY_FIELD , CrmCustomerIndustryVOMeta.SEARCH_VALUE , CrmCustomerIndustryVOMeta.DIRTY_FIELDS , CrmCustomerIndustryVOMeta.SORT_FIELD , CrmCustomerIndustryVOMeta.SORT_TYPE , CrmCustomerIndustryVOMeta.DATA_ORIGIN , CrmCustomerIndustryVOMeta.QUERY_LOGIC , CrmCustomerIndustryVOMeta.REQUEST_ACTION , CrmCustomerIndustryVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.SAVE)
	public Result save(CrmCustomerIndustryVO crmCustomerIndustryVO) {
		
		Result result=crmCustomerIndustryService.save(crmCustomerIndustryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取客户行业
	*/
	@ApiOperation(value = "获取客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.GET_BY_ID)
	public Result<CrmCustomerIndustry> getById(String id) {
		
		Result<CrmCustomerIndustry> result=new Result<>();
		CrmCustomerIndustry crmCustomerIndustry=crmCustomerIndustryService.getById(id);
		result.success(true).data(crmCustomerIndustry);
		return result;
	}


	/**
	 * 批量获取客户行业 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取客户行业")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerIndustryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerIndustry>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerIndustry>> result=new Result<>();
		List<CrmCustomerIndustry> list=crmCustomerIndustryService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询客户行业
	*/
	@ApiOperation(value = "查询客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerIndustryVOMeta.PAGE_INDEX , CrmCustomerIndustryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerIndustry>> queryList(CrmCustomerIndustryVO sample) {
		
		Result<List<CrmCustomerIndustry>> result=new Result<>();
		List<CrmCustomerIndustry> list=crmCustomerIndustryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询客户行业
	*/
	@ApiOperation(value = "分页查询客户行业")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerIndustryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerIndustryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerIndustryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerIndustry>> queryPagedList(CrmCustomerIndustryVO sample) {
		
		Result<PagedList<CrmCustomerIndustry>> result=new Result<>();
		PagedList<CrmCustomerIndustry> list=crmCustomerIndustryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}