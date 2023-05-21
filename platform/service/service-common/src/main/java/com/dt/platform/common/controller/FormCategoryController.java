package com.dt.platform.common.controller;

import java.util.*;

import com.dt.platform.domain.common.ReportCategory;
import com.github.foxnic.commons.lang.StringUtil;
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


import com.dt.platform.proxy.common.FormCategoryServiceProxy;
import com.dt.platform.domain.common.meta.FormCategoryVOMeta;
import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.FormCategoryVO;
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
import com.dt.platform.domain.common.meta.FormCategoryMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IFormCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 表单类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 08:15:49
*/

@InDoc
@Api(tags = "表单类型")
@RestController("SysFormCategoryController")
public class FormCategoryController extends SuperController {

	@Autowired
	private IFormCategoryService formCategoryService;

	/**
	 * 添加表单类型
	*/
	@ApiOperation(value = "添加表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.INSERT)
	public Result insert(FormCategoryVO formCategoryVO) {

		formCategoryVO.setSort(9999);
		if (StringUtil.isBlank(formCategoryVO.getParentId())) {
			formCategoryVO.setParentId("0");
		}
		Result result = formCategoryService.insert(formCategoryVO, false);
		if (result.success()) {
			FormCategory currentPosition = new FormCategory();
			currentPosition.setId(formCategoryVO.getId());
			if ("0".equals(formCategoryVO.getParentId())) {
				currentPosition.setHierarchy(formCategoryVO.getId());
				currentPosition.setHierarchyName(formCategoryVO.getName());
			} else {
				FormCategory parentPosition = formCategoryService.getById(formCategoryVO.getParentId());
				currentPosition.setHierarchy(parentPosition.getHierarchy() + "/" + formCategoryVO.getId());
				currentPosition.setHierarchyName(parentPosition.getHierarchyName() + "/" + formCategoryVO.getName());
			}
			formCategoryService.update(currentPosition, SaveMode.NOT_NULL_FIELDS);
			formCategoryVO.setHierarchy(currentPosition.getHierarchy());
			formCategoryVO.setHierarchyName(currentPosition.getHierarchyName());
			result.data(formCategoryVO);
		}
		return result;
	}



	/**
	 * 删除表单类型
	*/
	@ApiOperation(value = "删除表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {

		List<FormCategory> list = formCategoryService.queryList(FormCategory.create().setParentId(id));
		if (list.size() > 0) {
			Result<FormCategory> result = new Result<>();
			result.success(false).message("请先删除下级节点");
			return result;
		}

		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  formCategoryService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=formCategoryService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除表单类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = FormCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = formCategoryService.hasRefers(ids);
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
			Result result=formCategoryService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=formCategoryService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新表单类型
	*/
	@ApiOperation(value = "更新表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormCategoryVOMeta.PAGE_INDEX , FormCategoryVOMeta.PAGE_SIZE , FormCategoryVOMeta.SEARCH_FIELD , FormCategoryVOMeta.FUZZY_FIELD , FormCategoryVOMeta.SEARCH_VALUE , FormCategoryVOMeta.DIRTY_FIELDS , FormCategoryVOMeta.SORT_FIELD , FormCategoryVOMeta.SORT_TYPE , FormCategoryVOMeta.DATA_ORIGIN , FormCategoryVOMeta.QUERY_LOGIC , FormCategoryVOMeta.REQUEST_ACTION , FormCategoryVOMeta.IDS } )
	@SentinelResource(value = FormCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.UPDATE)
	public Result update(FormCategoryVO formCategoryVO) {

		Result result = formCategoryService.update(formCategoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
		if (result.isSuccess()) {
			// 更新分类名称
			return formCategoryService.updateHierarchy(formCategoryVO.getId());
		}
		 return result;
	}


	/**
	 * 保存表单类型
	*/
	@ApiOperation(value = "保存表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FormCategoryVOMeta.PAGE_INDEX , FormCategoryVOMeta.PAGE_SIZE , FormCategoryVOMeta.SEARCH_FIELD , FormCategoryVOMeta.FUZZY_FIELD , FormCategoryVOMeta.SEARCH_VALUE , FormCategoryVOMeta.DIRTY_FIELDS , FormCategoryVOMeta.SORT_FIELD , FormCategoryVOMeta.SORT_TYPE , FormCategoryVOMeta.DATA_ORIGIN , FormCategoryVOMeta.QUERY_LOGIC , FormCategoryVOMeta.REQUEST_ACTION , FormCategoryVOMeta.IDS } )
	@SentinelResource(value = FormCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.SAVE)
	public Result save(FormCategoryVO formCategoryVO) {
		
		Result result=formCategoryService.save(formCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取表单类型
	*/
	@ApiOperation(value = "获取表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.GET_BY_ID)
	public Result<FormCategory> getById(String id) {
		
		Result<FormCategory> result=new Result<>();
		FormCategory formCategory=formCategoryService.getById(id);
		result.success(true).data(formCategory);
		return result;
	}


	/**
	 * 批量获取表单类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取表单类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FormCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = FormCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.GET_BY_IDS)
	public Result<List<FormCategory>> getByIds(List<String> ids) {
		
		Result<List<FormCategory>> result=new Result<>();
		List<FormCategory> list=formCategoryService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询表单类型
	*/
	@ApiOperation(value = "查询表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormCategoryVOMeta.PAGE_INDEX , FormCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FormCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.QUERY_LIST)
	public Result<List<FormCategory>> queryList(FormCategoryVO sample) {
		
		Result<List<FormCategory>> result=new Result<>();
		List<FormCategory> list=formCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询表单类型
	*/
	@ApiOperation(value = "分页查询表单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FormCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<FormCategory>> queryPagedList(FormCategoryVO sample) {
		
		Result<PagedList<FormCategory>> result=new Result<>();
		PagedList<FormCategory> list=formCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}