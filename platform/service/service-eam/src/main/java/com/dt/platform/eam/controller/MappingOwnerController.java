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


import com.dt.platform.proxy.eam.MappingOwnerServiceProxy;
import com.dt.platform.domain.eam.meta.MappingOwnerVOMeta;
import com.dt.platform.domain.eam.MappingOwner;
import com.dt.platform.domain.eam.MappingOwnerVO;
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
import com.dt.platform.domain.eam.meta.MappingOwnerMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMappingOwnerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 归属接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 18:26:18
*/

@InDoc
@Api(tags = "归属")
@RestController("EamMappingOwnerController")
public class MappingOwnerController extends SuperController {

	@Autowired
	private IMappingOwnerService mappingOwnerService;

	/**
	 * 添加归属
	*/
	@ApiOperation(value = "添加归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MappingOwnerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.INSERT)
	public Result insert(MappingOwnerVO mappingOwnerVO) {
		
		Result result=mappingOwnerService.insert(mappingOwnerVO,false);
		return result;
	}



	/**
	 * 删除归属
	*/
	@ApiOperation(value = "删除归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MappingOwnerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  mappingOwnerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=mappingOwnerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除归属 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MappingOwnerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = mappingOwnerService.hasRefers(ids);
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
			Result result=mappingOwnerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=mappingOwnerService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新归属
	*/
	@ApiOperation(value = "更新归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MappingOwnerVOMeta.PAGE_INDEX , MappingOwnerVOMeta.PAGE_SIZE , MappingOwnerVOMeta.SEARCH_FIELD , MappingOwnerVOMeta.FUZZY_FIELD , MappingOwnerVOMeta.SEARCH_VALUE , MappingOwnerVOMeta.DIRTY_FIELDS , MappingOwnerVOMeta.SORT_FIELD , MappingOwnerVOMeta.SORT_TYPE , MappingOwnerVOMeta.DATA_ORIGIN , MappingOwnerVOMeta.QUERY_LOGIC , MappingOwnerVOMeta.REQUEST_ACTION , MappingOwnerVOMeta.IDS } )
	@SentinelResource(value = MappingOwnerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.UPDATE)
	public Result update(MappingOwnerVO mappingOwnerVO) {
		
		Result result=mappingOwnerService.update(mappingOwnerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存归属
	*/
	@ApiOperation(value = "保存归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MappingOwnerVOMeta.PAGE_INDEX , MappingOwnerVOMeta.PAGE_SIZE , MappingOwnerVOMeta.SEARCH_FIELD , MappingOwnerVOMeta.FUZZY_FIELD , MappingOwnerVOMeta.SEARCH_VALUE , MappingOwnerVOMeta.DIRTY_FIELDS , MappingOwnerVOMeta.SORT_FIELD , MappingOwnerVOMeta.SORT_TYPE , MappingOwnerVOMeta.DATA_ORIGIN , MappingOwnerVOMeta.QUERY_LOGIC , MappingOwnerVOMeta.REQUEST_ACTION , MappingOwnerVOMeta.IDS } )
	@SentinelResource(value = MappingOwnerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.SAVE)
	public Result save(MappingOwnerVO mappingOwnerVO) {
		
		Result result=mappingOwnerService.save(mappingOwnerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取归属
	*/
	@ApiOperation(value = "获取归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MappingOwnerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.GET_BY_ID)
	public Result<MappingOwner> getById(String id) {
		
		Result<MappingOwner> result=new Result<>();
		MappingOwner mappingOwner=mappingOwnerService.getById(id);
		result.success(true).data(mappingOwner);
		return result;
	}


	/**
	 * 批量获取归属 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取归属")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MappingOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MappingOwnerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.GET_BY_IDS)
	public Result<List<MappingOwner>> getByIds(List<String> ids) {
		
		Result<List<MappingOwner>> result=new Result<>();
		List<MappingOwner> list=mappingOwnerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询归属
	*/
	@ApiOperation(value = "查询归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MappingOwnerVOMeta.PAGE_INDEX , MappingOwnerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MappingOwnerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.QUERY_LIST)
	public Result<List<MappingOwner>> queryList(MappingOwnerVO sample) {
		
		Result<List<MappingOwner>> result=new Result<>();
		List<MappingOwner> list=mappingOwnerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询归属
	*/
	@ApiOperation(value = "分页查询归属")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MappingOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MappingOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MappingOwnerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MappingOwnerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MappingOwner>> queryPagedList(MappingOwnerVO sample) {
		
		Result<PagedList<MappingOwner>> result=new Result<>();
		PagedList<MappingOwner> list=mappingOwnerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}