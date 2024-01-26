package com.dt.platform.hr.controller;

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


import com.dt.platform.proxy.hr.SalaryTplItemServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryTplItemVOMeta;
import com.dt.platform.domain.hr.SalaryTplItem;
import com.dt.platform.domain.hr.SalaryTplItemVO;
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
import com.dt.platform.domain.hr.meta.SalaryTplItemMeta;
import com.dt.platform.domain.hr.SalaryColumn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryTplItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 计算项目接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 15:47:24
*/

@InDoc
@Api(tags = "计算项目")
@RestController("HrSalaryTplItemController")
public class SalaryTplItemController extends SuperController {

	@Autowired
	private ISalaryTplItemService salaryTplItemService;

	/**
	 * 添加计算项目
	*/
	@ApiOperation(value = "添加计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_VALUE , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_SHOW , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.INCLUDE_EXPRESSION , value = "包含公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.INSERT)
	public Result insert(SalaryTplItemVO salaryTplItemVO) {
		
		Result result=salaryTplItemService.insert(salaryTplItemVO,false);
		return result;
	}



	/**
	 * 删除计算项目
	*/
	@ApiOperation(value = "删除计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryTplItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryTplItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除计算项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryTplItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryTplItemService.hasRefers(ids);
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
			Result result=salaryTplItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryTplItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新计算项目
	*/
	@ApiOperation(value = "更新计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_VALUE , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_SHOW , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.INCLUDE_EXPRESSION , value = "包含公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTplItemVOMeta.PAGE_INDEX , SalaryTplItemVOMeta.PAGE_SIZE , SalaryTplItemVOMeta.SEARCH_FIELD , SalaryTplItemVOMeta.FUZZY_FIELD , SalaryTplItemVOMeta.SEARCH_VALUE , SalaryTplItemVOMeta.DIRTY_FIELDS , SalaryTplItemVOMeta.SORT_FIELD , SalaryTplItemVOMeta.SORT_TYPE , SalaryTplItemVOMeta.DATA_ORIGIN , SalaryTplItemVOMeta.QUERY_LOGIC , SalaryTplItemVOMeta.REQUEST_ACTION , SalaryTplItemVOMeta.IDS } )
	@SentinelResource(value = SalaryTplItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.UPDATE)
	public Result update(SalaryTplItemVO salaryTplItemVO) {
		
		Result result=salaryTplItemService.update(salaryTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存计算项目
	*/
	@ApiOperation(value = "保存计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_VALUE , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_SHOW , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.INCLUDE_EXPRESSION , value = "包含公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryTplItemVOMeta.PAGE_INDEX , SalaryTplItemVOMeta.PAGE_SIZE , SalaryTplItemVOMeta.SEARCH_FIELD , SalaryTplItemVOMeta.FUZZY_FIELD , SalaryTplItemVOMeta.SEARCH_VALUE , SalaryTplItemVOMeta.DIRTY_FIELDS , SalaryTplItemVOMeta.SORT_FIELD , SalaryTplItemVOMeta.SORT_TYPE , SalaryTplItemVOMeta.DATA_ORIGIN , SalaryTplItemVOMeta.QUERY_LOGIC , SalaryTplItemVOMeta.REQUEST_ACTION , SalaryTplItemVOMeta.IDS } )
	@SentinelResource(value = SalaryTplItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.SAVE)
	public Result save(SalaryTplItemVO salaryTplItemVO) {
		
		Result result=salaryTplItemService.save(salaryTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取计算项目
	*/
	@ApiOperation(value = "获取计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.GET_BY_ID)
	public Result<SalaryTplItem> getById(String id) {
		
		Result<SalaryTplItem> result=new Result<>();
		SalaryTplItem salaryTplItem=salaryTplItemService.getById(id);
		// join 关联的对象
		salaryTplItemService.dao().fill(salaryTplItem)
			.with(SalaryTplItemMeta.SALARY_COLUMN)
			.execute();
		result.success(true).data(salaryTplItem);
		return result;
	}


	/**
	 * 批量获取计算项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取计算项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryTplItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.GET_BY_IDS)
	public Result<List<SalaryTplItem>> getByIds(List<String> ids) {
		
		Result<List<SalaryTplItem>> result=new Result<>();
		List<SalaryTplItem> list=salaryTplItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询计算项目
	*/
	@ApiOperation(value = "查询计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_VALUE , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_SHOW , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.INCLUDE_EXPRESSION , value = "包含公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTplItemVOMeta.PAGE_INDEX , SalaryTplItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryTplItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.QUERY_LIST)
	public Result<List<SalaryTplItem>> queryList(SalaryTplItemVO sample) {
		
		Result<List<SalaryTplItem>> result=new Result<>();
		List<SalaryTplItem> list=salaryTplItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询计算项目
	*/
	@ApiOperation(value = "分页查询计算项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_VALUE , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.EXPRESSION_SHOW , value = "公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.INCLUDE_EXPRESSION , value = "包含公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryTplItem>> queryPagedList(SalaryTplItemVO sample) {
		
		Result<PagedList<SalaryTplItem>> result=new Result<>();
		PagedList<SalaryTplItem> list=salaryTplItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		salaryTplItemService.dao().fill(list)
			.with(SalaryTplItemMeta.SALARY_COLUMN)
			.execute();
		result.success(true).data(list);
		return result;
	}





}