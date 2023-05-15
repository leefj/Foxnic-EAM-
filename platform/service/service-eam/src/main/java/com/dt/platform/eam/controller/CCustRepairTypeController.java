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


import com.dt.platform.proxy.eam.CCustRepairTypeServiceProxy;
import com.dt.platform.domain.eam.meta.CCustRepairTypeVOMeta;
import com.dt.platform.domain.eam.CCustRepairType;
import com.dt.platform.domain.eam.CCustRepairTypeVO;
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
import com.dt.platform.domain.eam.meta.CCustRepairTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustRepairTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 报修类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-14 08:57:14
*/

@InDoc
@Api(tags = "报修类型")
@RestController("EamCCustRepairTypeController")
public class CCustRepairTypeController extends SuperController {

	@Autowired
	private ICCustRepairTypeService cCustRepairTypeService;

	/**
	 * 添加报修类型
	*/
	@ApiOperation(value = "添加报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepairTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.INSERT)
	public Result insert(CCustRepairTypeVO cCustRepairTypeVO) {
		
		Result result=cCustRepairTypeService.insert(cCustRepairTypeVO,false);
		return result;
	}



	/**
	 * 删除报修类型
	*/
	@ApiOperation(value = "删除报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepairTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustRepairTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustRepairTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除报修类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustRepairTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustRepairTypeService.hasRefers(ids);
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
			Result result=cCustRepairTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustRepairTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新报修类型
	*/
	@ApiOperation(value = "更新报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustRepairTypeVOMeta.PAGE_INDEX , CCustRepairTypeVOMeta.PAGE_SIZE , CCustRepairTypeVOMeta.SEARCH_FIELD , CCustRepairTypeVOMeta.FUZZY_FIELD , CCustRepairTypeVOMeta.SEARCH_VALUE , CCustRepairTypeVOMeta.DIRTY_FIELDS , CCustRepairTypeVOMeta.SORT_FIELD , CCustRepairTypeVOMeta.SORT_TYPE , CCustRepairTypeVOMeta.DATA_ORIGIN , CCustRepairTypeVOMeta.QUERY_LOGIC , CCustRepairTypeVOMeta.REQUEST_ACTION , CCustRepairTypeVOMeta.IDS } )
	@SentinelResource(value = CCustRepairTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.UPDATE)
	public Result update(CCustRepairTypeVO cCustRepairTypeVO) {
		
		Result result=cCustRepairTypeService.update(cCustRepairTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存报修类型
	*/
	@ApiOperation(value = "保存报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustRepairTypeVOMeta.PAGE_INDEX , CCustRepairTypeVOMeta.PAGE_SIZE , CCustRepairTypeVOMeta.SEARCH_FIELD , CCustRepairTypeVOMeta.FUZZY_FIELD , CCustRepairTypeVOMeta.SEARCH_VALUE , CCustRepairTypeVOMeta.DIRTY_FIELDS , CCustRepairTypeVOMeta.SORT_FIELD , CCustRepairTypeVOMeta.SORT_TYPE , CCustRepairTypeVOMeta.DATA_ORIGIN , CCustRepairTypeVOMeta.QUERY_LOGIC , CCustRepairTypeVOMeta.REQUEST_ACTION , CCustRepairTypeVOMeta.IDS } )
	@SentinelResource(value = CCustRepairTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.SAVE)
	public Result save(CCustRepairTypeVO cCustRepairTypeVO) {
		
		Result result=cCustRepairTypeService.save(cCustRepairTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取报修类型
	*/
	@ApiOperation(value = "获取报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepairTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.GET_BY_ID)
	public Result<CCustRepairType> getById(String id) {
		
		Result<CCustRepairType> result=new Result<>();
		CCustRepairType cCustRepairType=cCustRepairTypeService.getById(id);
		result.success(true).data(cCustRepairType);
		return result;
	}


	/**
	 * 批量获取报修类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取报修类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustRepairTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustRepairTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.GET_BY_IDS)
	public Result<List<CCustRepairType>> getByIds(List<String> ids) {
		
		Result<List<CCustRepairType>> result=new Result<>();
		List<CCustRepairType> list=cCustRepairTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询报修类型
	*/
	@ApiOperation(value = "查询报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustRepairTypeVOMeta.PAGE_INDEX , CCustRepairTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustRepairTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.QUERY_LIST)
	public Result<List<CCustRepairType>> queryList(CCustRepairTypeVO sample) {
		
		Result<List<CCustRepairType>> result=new Result<>();
		List<CCustRepairType> list=cCustRepairTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询报修类型
	*/
	@ApiOperation(value = "分页查询报修类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustRepairTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepairTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepairTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustRepairType>> queryPagedList(CCustRepairTypeVO sample) {
		
		Result<PagedList<CCustRepairType>> result=new Result<>();
		PagedList<CCustRepairType> list=cCustRepairTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}