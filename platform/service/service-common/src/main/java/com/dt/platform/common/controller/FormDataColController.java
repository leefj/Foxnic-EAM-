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


import com.dt.platform.proxy.common.FormDataColServiceProxy;
import com.dt.platform.domain.common.meta.FormDataColVOMeta;
import com.dt.platform.domain.common.FormDataCol;
import com.dt.platform.domain.common.FormDataColVO;
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
import com.dt.platform.domain.common.meta.FormDataColMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IFormDataColService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据字段接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-29 19:34:00
*/

@InDoc
@Api(tags = "数据字段")
@RestController("SysFormDataColController")
public class FormDataColController extends SuperController {

	@Autowired
	private IFormDataColService formDataColService;

	/**
	 * 添加数据字段
	*/
	@ApiOperation(value = "添加数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL , value = "字段" , required = false , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL_TYPE , value = "字段类型" , required = false , dataTypeClass=String.class , example = "datetime"),
		@ApiImplicitParam(name = FormDataColVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataColServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.INSERT)
	public Result insert(FormDataColVO formDataColVO) {
		
		Result result=formDataColService.insert(formDataColVO,false);
		return result;
	}



	/**
	 * 删除数据字段
	*/
	@ApiOperation(value = "删除数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "d1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataColServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  formDataColService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=formDataColService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据字段 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = FormDataColServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = formDataColService.hasRefers(ids);
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
			Result result=formDataColService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=formDataColService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据字段
	*/
	@ApiOperation(value = "更新数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL , value = "字段" , required = false , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL_TYPE , value = "字段类型" , required = false , dataTypeClass=String.class , example = "datetime"),
		@ApiImplicitParam(name = FormDataColVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormDataColVOMeta.PAGE_INDEX , FormDataColVOMeta.PAGE_SIZE , FormDataColVOMeta.SEARCH_FIELD , FormDataColVOMeta.FUZZY_FIELD , FormDataColVOMeta.SEARCH_VALUE , FormDataColVOMeta.DIRTY_FIELDS , FormDataColVOMeta.SORT_FIELD , FormDataColVOMeta.SORT_TYPE , FormDataColVOMeta.DATA_ORIGIN , FormDataColVOMeta.QUERY_LOGIC , FormDataColVOMeta.REQUEST_ACTION , FormDataColVOMeta.IDS } )
	@SentinelResource(value = FormDataColServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.UPDATE)
	public Result update(FormDataColVO formDataColVO) {
		
		Result result=formDataColService.update(formDataColVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据字段
	*/
	@ApiOperation(value = "保存数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL , value = "字段" , required = false , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL_TYPE , value = "字段类型" , required = false , dataTypeClass=String.class , example = "datetime"),
		@ApiImplicitParam(name = FormDataColVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FormDataColVOMeta.PAGE_INDEX , FormDataColVOMeta.PAGE_SIZE , FormDataColVOMeta.SEARCH_FIELD , FormDataColVOMeta.FUZZY_FIELD , FormDataColVOMeta.SEARCH_VALUE , FormDataColVOMeta.DIRTY_FIELDS , FormDataColVOMeta.SORT_FIELD , FormDataColVOMeta.SORT_TYPE , FormDataColVOMeta.DATA_ORIGIN , FormDataColVOMeta.QUERY_LOGIC , FormDataColVOMeta.REQUEST_ACTION , FormDataColVOMeta.IDS } )
	@SentinelResource(value = FormDataColServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.SAVE)
	public Result save(FormDataColVO formDataColVO) {
		
		Result result=formDataColService.save(formDataColVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据字段
	*/
	@ApiOperation(value = "获取数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataColServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.GET_BY_ID)
	public Result<FormDataCol> getById(String id) {
		
		Result<FormDataCol> result=new Result<>();
		FormDataCol formDataCol=formDataColService.getById(id);
		result.success(true).data(formDataCol);
		return result;
	}


	/**
	 * 批量获取数据字段 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据字段")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FormDataColVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = FormDataColServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.GET_BY_IDS)
	public Result<List<FormDataCol>> getByIds(List<String> ids) {
		
		Result<List<FormDataCol>> result=new Result<>();
		List<FormDataCol> list=formDataColService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据字段
	*/
	@ApiOperation(value = "查询数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL , value = "字段" , required = false , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL_TYPE , value = "字段类型" , required = false , dataTypeClass=String.class , example = "datetime"),
		@ApiImplicitParam(name = FormDataColVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormDataColVOMeta.PAGE_INDEX , FormDataColVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FormDataColServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.QUERY_LIST)
	public Result<List<FormDataCol>> queryList(FormDataColVO sample) {
		
		Result<List<FormDataCol>> result=new Result<>();
		List<FormDataCol> list=formDataColService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据字段
	*/
	@ApiOperation(value = "分页查询数据字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormDataColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL , value = "字段" , required = false , dataTypeClass=String.class , example = "d1"),
		@ApiImplicitParam(name = FormDataColVOMeta.COL_TYPE , value = "字段类型" , required = false , dataTypeClass=String.class , example = "datetime"),
		@ApiImplicitParam(name = FormDataColVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormDataColServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormDataColServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<FormDataCol>> queryPagedList(FormDataColVO sample) {
		
		Result<PagedList<FormDataCol>> result=new Result<>();
		PagedList<FormDataCol> list=formDataColService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}