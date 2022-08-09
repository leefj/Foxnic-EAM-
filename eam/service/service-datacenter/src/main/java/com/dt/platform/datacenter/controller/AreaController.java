package com.dt.platform.datacenter.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.domain.datacenter.meta.AreaVOMeta;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.AreaVO;
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
import com.dt.platform.domain.datacenter.meta.AreaMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.IAreaService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 区域 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-22 21:40:43
*/

@Api(tags = "区域")
@ApiSort(0)
@RestController("DcAreaController")
public class AreaController extends SuperController {

	@Autowired
	private IAreaService areaService;


	/**
	 * 添加区域
	*/
	@ApiOperation(value = "添加区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = AreaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "datacenter"),
		@ApiImplicitParam(name = AreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据中心A"),
		@ApiImplicitParam(name = AreaVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AreaServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.INSERT)
	public Result insert(AreaVO areaVO) {
		Result result=areaService.insert(areaVO,false);
		return result;
	}



	/**
	 * 删除区域
	*/
	@ApiOperation(value = "删除区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565457749140312064")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = areaService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireInList("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=areaService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除区域 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AreaVOMeta.IDS)
	@SentinelResource(value = AreaServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = areaService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=areaService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=areaService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新区域
	*/
	@ApiOperation(value = "更新区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = AreaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "datacenter"),
		@ApiImplicitParam(name = AreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据中心A"),
		@ApiImplicitParam(name = AreaVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE , AreaVOMeta.SEARCH_FIELD , AreaVOMeta.FUZZY_FIELD , AreaVOMeta.SEARCH_VALUE , AreaVOMeta.DIRTY_FIELDS , AreaVOMeta.SORT_FIELD , AreaVOMeta.SORT_TYPE , AreaVOMeta.IDS } )
	@SentinelResource(value = AreaServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.UPDATE)
	public Result update(AreaVO areaVO) {
		Result result=areaService.update(areaVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存区域
	*/
	@ApiOperation(value = "保存区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = AreaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "datacenter"),
		@ApiImplicitParam(name = AreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据中心A"),
		@ApiImplicitParam(name = AreaVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE , AreaVOMeta.SEARCH_FIELD , AreaVOMeta.FUZZY_FIELD , AreaVOMeta.SEARCH_VALUE , AreaVOMeta.DIRTY_FIELDS , AreaVOMeta.SORT_FIELD , AreaVOMeta.SORT_TYPE , AreaVOMeta.IDS } )
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.SAVE)
	public Result save(AreaVO areaVO) {
		Result result=areaService.save(areaVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取区域
	*/
	@ApiOperation(value = "获取区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.GET_BY_ID)
	public Result<Area> getById(String id) {
		Result<Area> result=new Result<>();
		Area area=areaService.getById(id);
		result.success(true).data(area);
		return result;
	}


	/**
	 * 批量获取区域 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取区域")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AreaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AreaVOMeta.IDS)
		@SentinelResource(value = AreaServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.GET_BY_IDS)
	public Result<List<Area>> getByIds(List<String> ids) {
		Result<List<Area>> result=new Result<>();
		List<Area> list=areaService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询区域
	*/
	@ApiOperation(value = "查询区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = AreaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "datacenter"),
		@ApiImplicitParam(name = AreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据中心A"),
		@ApiImplicitParam(name = AreaVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AreaServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.QUERY_LIST)
	public Result<List<Area>> queryList(AreaVO sample) {
		Result<List<Area>> result=new Result<>();
		List<Area> list=areaService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询区域
	*/
	@ApiOperation(value = "分页查询区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = AreaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "datacenter"),
		@ApiImplicitParam(name = AreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据中心A"),
		@ApiImplicitParam(name = AreaVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AreaServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Area>> queryPagedList(AreaVO sample) {
		Result<PagedList<Area>> result=new Result<>();
		PagedList<Area> list=areaService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}
