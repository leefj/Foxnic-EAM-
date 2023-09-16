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


import com.dt.platform.proxy.oa.CrmCustomerLevelServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerLevelVOMeta;
import com.dt.platform.domain.oa.CrmCustomerLevel;
import com.dt.platform.domain.oa.CrmCustomerLevelVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerLevelMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerLevelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 客户等级接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:31:32
*/

@InDoc
@Api(tags = "客户等级")
@RestController("OaCrmCustomerLevelController")
public class CrmCustomerLevelController extends SuperController {

	@Autowired
	private ICrmCustomerLevelService crmCustomerLevelService;

	/**
	 * 添加客户等级
	*/
	@ApiOperation(value = "添加客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerLevelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.INSERT)
	public Result insert(CrmCustomerLevelVO crmCustomerLevelVO) {
		
		Result result=crmCustomerLevelService.insert(crmCustomerLevelVO,false);
		return result;
	}



	/**
	 * 删除客户等级
	*/
	@ApiOperation(value = "删除客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerLevelServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerLevelService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerLevelService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除客户等级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerLevelServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerLevelService.hasRefers(ids);
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
			Result result=crmCustomerLevelService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerLevelService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新客户等级
	*/
	@ApiOperation(value = "更新客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerLevelVOMeta.PAGE_INDEX , CrmCustomerLevelVOMeta.PAGE_SIZE , CrmCustomerLevelVOMeta.SEARCH_FIELD , CrmCustomerLevelVOMeta.FUZZY_FIELD , CrmCustomerLevelVOMeta.SEARCH_VALUE , CrmCustomerLevelVOMeta.DIRTY_FIELDS , CrmCustomerLevelVOMeta.SORT_FIELD , CrmCustomerLevelVOMeta.SORT_TYPE , CrmCustomerLevelVOMeta.DATA_ORIGIN , CrmCustomerLevelVOMeta.QUERY_LOGIC , CrmCustomerLevelVOMeta.REQUEST_ACTION , CrmCustomerLevelVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerLevelServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.UPDATE)
	public Result update(CrmCustomerLevelVO crmCustomerLevelVO) {
		
		Result result=crmCustomerLevelService.update(crmCustomerLevelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存客户等级
	*/
	@ApiOperation(value = "保存客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerLevelVOMeta.PAGE_INDEX , CrmCustomerLevelVOMeta.PAGE_SIZE , CrmCustomerLevelVOMeta.SEARCH_FIELD , CrmCustomerLevelVOMeta.FUZZY_FIELD , CrmCustomerLevelVOMeta.SEARCH_VALUE , CrmCustomerLevelVOMeta.DIRTY_FIELDS , CrmCustomerLevelVOMeta.SORT_FIELD , CrmCustomerLevelVOMeta.SORT_TYPE , CrmCustomerLevelVOMeta.DATA_ORIGIN , CrmCustomerLevelVOMeta.QUERY_LOGIC , CrmCustomerLevelVOMeta.REQUEST_ACTION , CrmCustomerLevelVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerLevelServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.SAVE)
	public Result save(CrmCustomerLevelVO crmCustomerLevelVO) {
		
		Result result=crmCustomerLevelService.save(crmCustomerLevelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取客户等级
	*/
	@ApiOperation(value = "获取客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerLevelServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.GET_BY_ID)
	public Result<CrmCustomerLevel> getById(String id) {
		
		Result<CrmCustomerLevel> result=new Result<>();
		CrmCustomerLevel crmCustomerLevel=crmCustomerLevelService.getById(id);
		result.success(true).data(crmCustomerLevel);
		return result;
	}


	/**
	 * 批量获取客户等级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取客户等级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerLevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerLevelServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerLevel>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerLevel>> result=new Result<>();
		List<CrmCustomerLevel> list=crmCustomerLevelService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询客户等级
	*/
	@ApiOperation(value = "查询客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerLevelVOMeta.PAGE_INDEX , CrmCustomerLevelVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerLevelServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerLevel>> queryList(CrmCustomerLevelVO sample) {
		
		Result<List<CrmCustomerLevel>> result=new Result<>();
		List<CrmCustomerLevel> list=crmCustomerLevelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询客户等级
	*/
	@ApiOperation(value = "分页查询客户等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerLevelServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerLevelServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerLevel>> queryPagedList(CrmCustomerLevelVO sample) {
		
		Result<PagedList<CrmCustomerLevel>> result=new Result<>();
		PagedList<CrmCustomerLevel> list=crmCustomerLevelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}