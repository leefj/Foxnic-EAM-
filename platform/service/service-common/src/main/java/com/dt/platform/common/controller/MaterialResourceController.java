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


import com.dt.platform.proxy.common.MaterialResourceServiceProxy;
import com.dt.platform.domain.common.meta.MaterialResourceVOMeta;
import com.dt.platform.domain.common.MaterialResource;
import com.dt.platform.domain.common.MaterialResourceVO;
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
import com.dt.platform.domain.common.meta.MaterialResourceMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IMaterialResourceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 素材资源接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-02 15:29:00
*/

@InDoc
@Api(tags = "素材资源")
@RestController("SysMaterialResourceController")
public class MaterialResourceController extends SuperController {

	@Autowired
	private IMaterialResourceService materialResourceService;

	/**
	 * 添加素材资源
	*/
	@ApiOperation(value = "添加素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.ACCESS_URL , value = "访问地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaterialResourceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.INSERT)
	public Result insert(MaterialResourceVO materialResourceVO) {
		
		Result result=materialResourceService.insert(materialResourceVO,false);
		return result;
	}



	/**
	 * 删除素材资源
	*/
	@ApiOperation(value = "删除素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaterialResourceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  materialResourceService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=materialResourceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除素材资源 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MaterialResourceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = materialResourceService.hasRefers(ids);
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
			Result result=materialResourceService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=materialResourceService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新素材资源
	*/
	@ApiOperation(value = "更新素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.ACCESS_URL , value = "访问地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaterialResourceVOMeta.PAGE_INDEX , MaterialResourceVOMeta.PAGE_SIZE , MaterialResourceVOMeta.SEARCH_FIELD , MaterialResourceVOMeta.FUZZY_FIELD , MaterialResourceVOMeta.SEARCH_VALUE , MaterialResourceVOMeta.DIRTY_FIELDS , MaterialResourceVOMeta.SORT_FIELD , MaterialResourceVOMeta.SORT_TYPE , MaterialResourceVOMeta.DATA_ORIGIN , MaterialResourceVOMeta.QUERY_LOGIC , MaterialResourceVOMeta.REQUEST_ACTION , MaterialResourceVOMeta.IDS } )
	@SentinelResource(value = MaterialResourceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.UPDATE)
	public Result update(MaterialResourceVO materialResourceVO) {
		
		Result result=materialResourceService.update(materialResourceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存素材资源
	*/
	@ApiOperation(value = "保存素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.ACCESS_URL , value = "访问地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaterialResourceVOMeta.PAGE_INDEX , MaterialResourceVOMeta.PAGE_SIZE , MaterialResourceVOMeta.SEARCH_FIELD , MaterialResourceVOMeta.FUZZY_FIELD , MaterialResourceVOMeta.SEARCH_VALUE , MaterialResourceVOMeta.DIRTY_FIELDS , MaterialResourceVOMeta.SORT_FIELD , MaterialResourceVOMeta.SORT_TYPE , MaterialResourceVOMeta.DATA_ORIGIN , MaterialResourceVOMeta.QUERY_LOGIC , MaterialResourceVOMeta.REQUEST_ACTION , MaterialResourceVOMeta.IDS } )
	@SentinelResource(value = MaterialResourceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.SAVE)
	public Result save(MaterialResourceVO materialResourceVO) {
		
		Result result=materialResourceService.save(materialResourceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取素材资源
	*/
	@ApiOperation(value = "获取素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaterialResourceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.GET_BY_ID)
	public Result<MaterialResource> getById(String id) {
		
		Result<MaterialResource> result=new Result<>();
		MaterialResource materialResource=materialResourceService.getById(id);
		result.success(true).data(materialResource);
		return result;
	}


	/**
	 * 批量获取素材资源 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取素材资源")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaterialResourceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MaterialResourceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.GET_BY_IDS)
	public Result<List<MaterialResource>> getByIds(List<String> ids) {
		
		Result<List<MaterialResource>> result=new Result<>();
		List<MaterialResource> list=materialResourceService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询素材资源
	*/
	@ApiOperation(value = "查询素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.ACCESS_URL , value = "访问地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaterialResourceVOMeta.PAGE_INDEX , MaterialResourceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaterialResourceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.QUERY_LIST)
	public Result<List<MaterialResource>> queryList(MaterialResourceVO sample) {
		
		Result<List<MaterialResource>> result=new Result<>();
		List<MaterialResource> list=materialResourceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询素材资源
	*/
	@ApiOperation(value = "分页查询素材资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaterialResourceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.ACCESS_URL , value = "访问地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaterialResourceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaterialResourceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaterialResourceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaterialResource>> queryPagedList(MaterialResourceVO sample) {
		
		Result<PagedList<MaterialResource>> result=new Result<>();
		PagedList<MaterialResource> list=materialResourceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}