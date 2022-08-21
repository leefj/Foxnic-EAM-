package com.dt.platform.ops.controller;


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


import com.dt.platform.proxy.ops.AutoGroupNodeServiceProxy;
import com.dt.platform.domain.ops.meta.AutoGroupNodeVOMeta;
import com.dt.platform.domain.ops.AutoGroupNode;
import com.dt.platform.domain.ops.AutoGroupNodeVO;
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
import com.dt.platform.domain.ops.meta.AutoGroupNodeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoGroupNodeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 分组节点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 09:09:25
*/

@Api(tags = "分组节点")
@ApiSort(0)
@RestController("OpsAutoGroupNodeController")
public class AutoGroupNodeController extends SuperController {

	@Autowired
	private IAutoGroupNodeService autoGroupNodeService;


	/**
	 * 添加分组节点
	*/
	@ApiOperation(value = "添加分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AutoGroupNodeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.INSERT)
	public Result insert(AutoGroupNodeVO autoGroupNodeVO) {
		Result result=autoGroupNodeService.insert(autoGroupNodeVO,false);
		return result;
	}



	/**
	 * 删除分组节点
	*/
	@ApiOperation(value = "删除分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AutoGroupNodeVOMeta.ID)
	@SentinelResource(value = AutoGroupNodeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = autoGroupNodeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=autoGroupNodeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除分组节点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AutoGroupNodeVOMeta.IDS)
	@SentinelResource(value = AutoGroupNodeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = autoGroupNodeService.hasRefers(ids);
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
			Result result=autoGroupNodeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=autoGroupNodeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新分组节点
	*/
	@ApiOperation(value = "更新分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AutoGroupNodeVOMeta.PAGE_INDEX , AutoGroupNodeVOMeta.PAGE_SIZE , AutoGroupNodeVOMeta.SEARCH_FIELD , AutoGroupNodeVOMeta.FUZZY_FIELD , AutoGroupNodeVOMeta.SEARCH_VALUE , AutoGroupNodeVOMeta.DIRTY_FIELDS , AutoGroupNodeVOMeta.SORT_FIELD , AutoGroupNodeVOMeta.SORT_TYPE , AutoGroupNodeVOMeta.IDS } )
	@SentinelResource(value = AutoGroupNodeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.UPDATE)
	public Result update(AutoGroupNodeVO autoGroupNodeVO) {
		Result result=autoGroupNodeService.update(autoGroupNodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存分组节点
	*/
	@ApiOperation(value = "保存分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AutoGroupNodeVOMeta.PAGE_INDEX , AutoGroupNodeVOMeta.PAGE_SIZE , AutoGroupNodeVOMeta.SEARCH_FIELD , AutoGroupNodeVOMeta.FUZZY_FIELD , AutoGroupNodeVOMeta.SEARCH_VALUE , AutoGroupNodeVOMeta.DIRTY_FIELDS , AutoGroupNodeVOMeta.SORT_FIELD , AutoGroupNodeVOMeta.SORT_TYPE , AutoGroupNodeVOMeta.IDS } )
	@NotNull(name = AutoGroupNodeVOMeta.ID)
	@SentinelResource(value = AutoGroupNodeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.SAVE)
	public Result save(AutoGroupNodeVO autoGroupNodeVO) {
		Result result=autoGroupNodeService.save(autoGroupNodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取分组节点
	*/
	@ApiOperation(value = "获取分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AutoGroupNodeVOMeta.ID)
	@SentinelResource(value = AutoGroupNodeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.GET_BY_ID)
	public Result<AutoGroupNode> getById(String id) {
		Result<AutoGroupNode> result=new Result<>();
		AutoGroupNode autoGroupNode=autoGroupNodeService.getById(id);
		result.success(true).data(autoGroupNode);
		return result;
	}


	/**
	 * 批量获取分组节点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取分组节点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AutoGroupNodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AutoGroupNodeVOMeta.IDS)
		@SentinelResource(value = AutoGroupNodeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.GET_BY_IDS)
	public Result<List<AutoGroupNode>> getByIds(List<String> ids) {
		Result<List<AutoGroupNode>> result=new Result<>();
		List<AutoGroupNode> list=autoGroupNodeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询分组节点
	*/
	@ApiOperation(value = "查询分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AutoGroupNodeVOMeta.PAGE_INDEX , AutoGroupNodeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AutoGroupNodeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.QUERY_LIST)
	public Result<List<AutoGroupNode>> queryList(AutoGroupNodeVO sample) {
		Result<List<AutoGroupNode>> result=new Result<>();
		List<AutoGroupNode> list=autoGroupNodeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询分组节点
	*/
	@ApiOperation(value = "分页查询分组节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AutoGroupNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AutoGroupNodeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoGroupNodeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AutoGroupNode>> queryPagedList(AutoGroupNodeVO sample) {
		Result<PagedList<AutoGroupNode>> result=new Result<>();
		PagedList<AutoGroupNode> list=autoGroupNodeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}