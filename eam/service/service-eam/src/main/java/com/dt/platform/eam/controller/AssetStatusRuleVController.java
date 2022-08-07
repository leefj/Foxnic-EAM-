package com.dt.platform.eam.controller;


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


import com.dt.platform.proxy.eam.AssetStatusRuleVServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStatusRuleVVOMeta;
import com.dt.platform.domain.eam.AssetStatusRuleV;
import com.dt.platform.domain.eam.AssetStatusRuleVVO;
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
import com.dt.platform.domain.eam.meta.AssetStatusRuleVMeta;
import com.dt.platform.domain.eam.AssetStatus;
import com.dt.platform.domain.eam.meta.AssetMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStatusRuleVService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 状态规则值 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-07 07:24:55
*/

@Api(tags = "状态规则值")
@ApiSort(0)
@RestController("EamAssetStatusRuleVController")
public class AssetStatusRuleVController extends SuperController {

	@Autowired
	private IAssetStatusRuleVService assetStatusRuleVService;


	/**
	 * 添加状态规则值
	*/
	@ApiOperation(value = "添加状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.OPER_CODE , value = "操作编码" , required = false , dataTypeClass=String.class , example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.STATUS_CODE , value = "状态编码" , required = false , dataTypeClass=String.class , example = "borrow"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStatusRuleVServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.INSERT)
	public Result insert(AssetStatusRuleVVO assetStatusRuleVVO) {
		Result result=assetStatusRuleVService.insert(assetStatusRuleVVO,false);
		return result;
	}



	/**
	 * 删除状态规则值
	*/
	@ApiOperation(value = "删除状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStatusRuleVVOMeta.ID)
	@SentinelResource(value = AssetStatusRuleVServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = assetStatusRuleVService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).mustInList("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=assetStatusRuleVService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除状态规则值 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStatusRuleVVOMeta.IDS)
	@SentinelResource(value = AssetStatusRuleVServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = assetStatusRuleVService.hasRefers(ids);
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
			Result result=assetStatusRuleVService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetStatusRuleVService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新状态规则值
	*/
	@ApiOperation(value = "更新状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.OPER_CODE , value = "操作编码" , required = false , dataTypeClass=String.class , example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.STATUS_CODE , value = "状态编码" , required = false , dataTypeClass=String.class , example = "borrow"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStatusRuleVVOMeta.PAGE_INDEX , AssetStatusRuleVVOMeta.PAGE_SIZE , AssetStatusRuleVVOMeta.SEARCH_FIELD , AssetStatusRuleVVOMeta.FUZZY_FIELD , AssetStatusRuleVVOMeta.SEARCH_VALUE , AssetStatusRuleVVOMeta.DIRTY_FIELDS , AssetStatusRuleVVOMeta.SORT_FIELD , AssetStatusRuleVVOMeta.SORT_TYPE , AssetStatusRuleVVOMeta.IDS } )
	@SentinelResource(value = AssetStatusRuleVServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.UPDATE)
	public Result update(AssetStatusRuleVVO assetStatusRuleVVO) {
		Result result=assetStatusRuleVService.update(assetStatusRuleVVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存状态规则值
	*/
	@ApiOperation(value = "保存状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.OPER_CODE , value = "操作编码" , required = false , dataTypeClass=String.class , example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.STATUS_CODE , value = "状态编码" , required = false , dataTypeClass=String.class , example = "borrow"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStatusRuleVVOMeta.PAGE_INDEX , AssetStatusRuleVVOMeta.PAGE_SIZE , AssetStatusRuleVVOMeta.SEARCH_FIELD , AssetStatusRuleVVOMeta.FUZZY_FIELD , AssetStatusRuleVVOMeta.SEARCH_VALUE , AssetStatusRuleVVOMeta.DIRTY_FIELDS , AssetStatusRuleVVOMeta.SORT_FIELD , AssetStatusRuleVVOMeta.SORT_TYPE , AssetStatusRuleVVOMeta.IDS } )
	@NotNull(name = AssetStatusRuleVVOMeta.ID)
	@SentinelResource(value = AssetStatusRuleVServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.SAVE)
	public Result save(AssetStatusRuleVVO assetStatusRuleVVO) {
		Result result=assetStatusRuleVService.save(assetStatusRuleVVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取状态规则值
	*/
	@ApiOperation(value = "获取状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStatusRuleVVOMeta.ID)
	@SentinelResource(value = AssetStatusRuleVServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.GET_BY_ID)
	public Result<AssetStatusRuleV> getById(String id) {
		Result<AssetStatusRuleV> result=new Result<>();
		AssetStatusRuleV assetStatusRuleV=assetStatusRuleVService.getById(id);
		// join 关联的对象
		assetStatusRuleVService.dao().fill(assetStatusRuleV)
			.with(AssetMeta.ASSET_CYCLE_STATUS)
			.execute();
		result.success(true).data(assetStatusRuleV);
		return result;
	}


	/**
	 * 批量获取状态规则值 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取状态规则值")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStatusRuleVVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStatusRuleVVOMeta.IDS)
		@SentinelResource(value = AssetStatusRuleVServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.GET_BY_IDS)
	public Result<List<AssetStatusRuleV>> getByIds(List<String> ids) {
		Result<List<AssetStatusRuleV>> result=new Result<>();
		List<AssetStatusRuleV> list=assetStatusRuleVService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询状态规则值
	*/
	@ApiOperation(value = "查询状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.OPER_CODE , value = "操作编码" , required = false , dataTypeClass=String.class , example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.STATUS_CODE , value = "状态编码" , required = false , dataTypeClass=String.class , example = "borrow"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStatusRuleVVOMeta.PAGE_INDEX , AssetStatusRuleVVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStatusRuleVServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.QUERY_LIST)
	public Result<List<AssetStatusRuleV>> queryList(AssetStatusRuleVVO sample) {
		Result<List<AssetStatusRuleV>> result=new Result<>();
		List<AssetStatusRuleV> list=assetStatusRuleVService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询状态规则值
	*/
	@ApiOperation(value = "分页查询状态规则值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.OPER_CODE , value = "操作编码" , required = false , dataTypeClass=String.class , example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVVOMeta.STATUS_CODE , value = "状态编码" , required = false , dataTypeClass=String.class , example = "borrow"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStatusRuleVServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStatusRuleVServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStatusRuleV>> queryPagedList(AssetStatusRuleVVO sample) {
		Result<PagedList<AssetStatusRuleV>> result=new Result<>();
		PagedList<AssetStatusRuleV> list=assetStatusRuleVService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStatusRuleVService.dao().fill(list)
			.with(AssetMeta.ASSET_CYCLE_STATUS)
			.execute();
		result.success(true).data(list);
		return result;
	}






}