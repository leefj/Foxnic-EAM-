package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.domain.eam.CategoryFinance;
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


import com.dt.platform.proxy.eam.DeviceSpTypeServiceProxy;
import com.dt.platform.domain.eam.meta.DeviceSpTypeVOMeta;
import com.dt.platform.domain.eam.DeviceSpType;
import com.dt.platform.domain.eam.DeviceSpTypeVO;
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
import com.dt.platform.domain.eam.meta.DeviceSpTypeMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IDeviceSpTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 备件分类接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 07:49:22
*/

@InDoc
@Api(tags = "备件分类")
@RestController("EamDeviceSpTypeController")
public class DeviceSpTypeController extends SuperController {

	@Autowired
	private IDeviceSpTypeService deviceSpTypeService;

	/**
	 * 添加备件分类
	*/
	@ApiOperation(value = "添加备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.INSERT)
	public Result insert(DeviceSpTypeVO deviceSpTypeVO) {

		deviceSpTypeVO.setSort(9999);
		if (StringUtil.isBlank(deviceSpTypeVO.getParentId())) {
			deviceSpTypeVO.setParentId("0");
		}
		Result result = deviceSpTypeService.insert(deviceSpTypeVO);
		if (result.success()) {
			DeviceSpType currentCategory = new DeviceSpType();
			currentCategory.setId(deviceSpTypeVO.getId());
			if ("0".equals(deviceSpTypeVO.getParentId())) {
				currentCategory.setHierarchy(deviceSpTypeVO.getId());
				currentCategory.setHierarchyName(deviceSpTypeVO.getCategoryName());
			} else {
				DeviceSpType parentCategory = deviceSpTypeService.getById(deviceSpTypeVO.getParentId());
				currentCategory.setHierarchy(parentCategory.getHierarchy() + "/" + deviceSpTypeVO.getId());
				currentCategory.setHierarchyName(parentCategory.getHierarchyName() + "/" + deviceSpTypeVO.getCategoryName());
			}
			deviceSpTypeService.update(currentCategory, SaveMode.NOT_NULL_FIELDS,true);
			deviceSpTypeVO.setHierarchy(currentCategory.getHierarchy());
			deviceSpTypeVO.setHierarchyName(currentCategory.getHierarchyName());
			result.data(deviceSpTypeVO);
		}
		return result;
	}



	/**
	 * 删除备件分类
	*/
	@ApiOperation(value = "删除备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.DELETE)
	public Result deleteById(String id) {

		Result<DeviceSpType> result = new Result<>();
		List<DeviceSpType> list = deviceSpTypeService.queryList(DeviceSpType.create().setParentId(id));
		if (list.size() > 0) {
			result.success(false).message("请先删除下级节点");
		} else {
			return deviceSpTypeService.deleteByIdLogical(id);
		}

		return result;
	}


	/**
	 * 批量删除备件分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DeviceSpTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = deviceSpTypeService.hasRefers(ids);
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
			Result result=deviceSpTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=deviceSpTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新备件分类
	*/
	@ApiOperation(value = "更新备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceSpTypeVOMeta.PAGE_INDEX , DeviceSpTypeVOMeta.PAGE_SIZE , DeviceSpTypeVOMeta.SEARCH_FIELD , DeviceSpTypeVOMeta.FUZZY_FIELD , DeviceSpTypeVOMeta.SEARCH_VALUE , DeviceSpTypeVOMeta.DIRTY_FIELDS , DeviceSpTypeVOMeta.SORT_FIELD , DeviceSpTypeVOMeta.SORT_TYPE , DeviceSpTypeVOMeta.DATA_ORIGIN , DeviceSpTypeVOMeta.QUERY_LOGIC , DeviceSpTypeVOMeta.REQUEST_ACTION , DeviceSpTypeVOMeta.IDS } )
	@SentinelResource(value = DeviceSpTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.UPDATE)
	public Result update(DeviceSpTypeVO deviceSpTypeVO) {

		Result result = deviceSpTypeService.update(deviceSpTypeVO, SaveMode.NOT_NULL_FIELDS);
		if (result.isSuccess()) {
			// 更新分类名称
			return deviceSpTypeService.updateHierarchy(deviceSpTypeVO.getId());
		}
		return result;
	}


	/**
	 * 保存备件分类
	*/
	@ApiOperation(value = "保存备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DeviceSpTypeVOMeta.PAGE_INDEX , DeviceSpTypeVOMeta.PAGE_SIZE , DeviceSpTypeVOMeta.SEARCH_FIELD , DeviceSpTypeVOMeta.FUZZY_FIELD , DeviceSpTypeVOMeta.SEARCH_VALUE , DeviceSpTypeVOMeta.DIRTY_FIELDS , DeviceSpTypeVOMeta.SORT_FIELD , DeviceSpTypeVOMeta.SORT_TYPE , DeviceSpTypeVOMeta.DATA_ORIGIN , DeviceSpTypeVOMeta.QUERY_LOGIC , DeviceSpTypeVOMeta.REQUEST_ACTION , DeviceSpTypeVOMeta.IDS } )
	@SentinelResource(value = DeviceSpTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.SAVE)
	public Result save(DeviceSpTypeVO deviceSpTypeVO) {

		Result result = deviceSpTypeService.update(deviceSpTypeVO, SaveMode.NOT_NULL_FIELDS);
		if (result.isSuccess()) {
			// 更新分类名称
			return deviceSpTypeService.updateHierarchy(deviceSpTypeVO.getId());
		}
		return result;
	}


	/**
	 * 获取备件分类
	*/
	@ApiOperation(value = "获取备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.GET_BY_ID)
	public Result<DeviceSpType> getById(String id) {
		
		Result<DeviceSpType> result=new Result<>();
		DeviceSpType deviceSpType=deviceSpTypeService.getById(id);
		result.success(true).data(deviceSpType);
		return result;
	}


	/**
	 * 批量获取备件分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取备件分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DeviceSpTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DeviceSpTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.GET_BY_IDS)
	public Result<List<DeviceSpType>> getByIds(List<String> ids) {
		
		Result<List<DeviceSpType>> result=new Result<>();
		List<DeviceSpType> list=deviceSpTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询备件分类
	*/
	@ApiOperation(value = "查询备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceSpTypeVOMeta.PAGE_INDEX , DeviceSpTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DeviceSpTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.QUERY_LIST)
	public Result<List<DeviceSpType>> queryList(DeviceSpTypeVO sample) {
		
		Result<List<DeviceSpType>> result=new Result<>();
		List<DeviceSpType> list=deviceSpTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询备件分类
	*/
	@ApiOperation(value = "分页查询备件分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DeviceSpType>> queryPagedList(DeviceSpTypeVO sample) {
		
		Result<PagedList<DeviceSpType>> result=new Result<>();
		PagedList<DeviceSpType> list=deviceSpTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}