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


import com.dt.platform.proxy.hr.SalaryTplServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryTplVOMeta;
import com.dt.platform.domain.hr.SalaryTpl;
import com.dt.platform.domain.hr.SalaryTplVO;
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
import com.dt.platform.domain.hr.meta.SalaryTplMeta;
import com.dt.platform.domain.hr.SalaryTplItem;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬模版接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 22:29:54
*/

@InDoc
@Api(tags = "薪酬模版")
@RestController("HrSalaryTplController")
public class SalaryTplController extends SuperController {

	@Autowired
	private ISalaryTplService salaryTplService;

	/**
	 * 添加薪酬模版
	*/
	@ApiOperation(value = "添加薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717722780455403520"),
		@ApiImplicitParam(name = SalaryTplVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "all"),
		@ApiImplicitParam(name = SalaryTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.START_M_DAY , value = "开始上月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.END_M_DAY , value = "结束本月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD_SCRIPT , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.INSERT)
	public Result insert(SalaryTplVO salaryTplVO) {
		
		Result result=salaryTplService.insert(salaryTplVO,false);
		return result;
	}



	/**
	 * 删除薪酬模版
	*/
	@ApiOperation(value = "删除薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717722780455403520")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  salaryTplService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=salaryTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除薪酬模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SalaryTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = salaryTplService.hasRefers(ids);
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
			Result result=salaryTplService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=salaryTplService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新薪酬模版
	*/
	@ApiOperation(value = "更新薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717722780455403520"),
		@ApiImplicitParam(name = SalaryTplVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "all"),
		@ApiImplicitParam(name = SalaryTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.START_M_DAY , value = "开始上月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.END_M_DAY , value = "结束本月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD_SCRIPT , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTplVOMeta.PAGE_INDEX , SalaryTplVOMeta.PAGE_SIZE , SalaryTplVOMeta.SEARCH_FIELD , SalaryTplVOMeta.FUZZY_FIELD , SalaryTplVOMeta.SEARCH_VALUE , SalaryTplVOMeta.DIRTY_FIELDS , SalaryTplVOMeta.SORT_FIELD , SalaryTplVOMeta.SORT_TYPE , SalaryTplVOMeta.DATA_ORIGIN , SalaryTplVOMeta.QUERY_LOGIC , SalaryTplVOMeta.REQUEST_ACTION , SalaryTplVOMeta.IDS } )
	@SentinelResource(value = SalaryTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.UPDATE)
	public Result update(SalaryTplVO salaryTplVO) {
		
		Result result=salaryTplService.update(salaryTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存薪酬模版
	*/
	@ApiOperation(value = "保存薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717722780455403520"),
		@ApiImplicitParam(name = SalaryTplVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "all"),
		@ApiImplicitParam(name = SalaryTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.START_M_DAY , value = "开始上月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.END_M_DAY , value = "结束本月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD_SCRIPT , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SalaryTplVOMeta.PAGE_INDEX , SalaryTplVOMeta.PAGE_SIZE , SalaryTplVOMeta.SEARCH_FIELD , SalaryTplVOMeta.FUZZY_FIELD , SalaryTplVOMeta.SEARCH_VALUE , SalaryTplVOMeta.DIRTY_FIELDS , SalaryTplVOMeta.SORT_FIELD , SalaryTplVOMeta.SORT_TYPE , SalaryTplVOMeta.DATA_ORIGIN , SalaryTplVOMeta.QUERY_LOGIC , SalaryTplVOMeta.REQUEST_ACTION , SalaryTplVOMeta.IDS } )
	@SentinelResource(value = SalaryTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.SAVE)
	public Result save(SalaryTplVO salaryTplVO) {
		
		Result result=salaryTplService.save(salaryTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取薪酬模版
	*/
	@ApiOperation(value = "获取薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.GET_BY_ID)
	public Result<SalaryTpl> getById(String id) {
		
		Result<SalaryTpl> result=new Result<>();
		SalaryTpl salaryTpl=salaryTplService.getById(id);
		result.success(true).data(salaryTpl);
		return result;
	}


	/**
	 * 批量获取薪酬模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取薪酬模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SalaryTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SalaryTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.GET_BY_IDS)
	public Result<List<SalaryTpl>> getByIds(List<String> ids) {
		
		Result<List<SalaryTpl>> result=new Result<>();
		List<SalaryTpl> list=salaryTplService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询薪酬模版
	*/
	@ApiOperation(value = "查询薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717722780455403520"),
		@ApiImplicitParam(name = SalaryTplVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "all"),
		@ApiImplicitParam(name = SalaryTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.START_M_DAY , value = "开始上月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.END_M_DAY , value = "结束本月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD_SCRIPT , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SalaryTplVOMeta.PAGE_INDEX , SalaryTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SalaryTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.QUERY_LIST)
	public Result<List<SalaryTpl>> queryList(SalaryTplVO sample) {
		
		Result<List<SalaryTpl>> result=new Result<>();
		List<SalaryTpl> list=salaryTplService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询薪酬模版
	*/
	@ApiOperation(value = "分页查询薪酬模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SalaryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717722780455403520"),
		@ApiImplicitParam(name = SalaryTplVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "all"),
		@ApiImplicitParam(name = SalaryTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.START_M_DAY , value = "开始上月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.END_M_DAY , value = "结束本月" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.METHOD_SCRIPT , value = "计算公式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SalaryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "全员人员"),
		@ApiImplicitParam(name = SalaryTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SalaryTpl>> queryPagedList(SalaryTplVO sample) {
		
		Result<PagedList<SalaryTpl>> result=new Result<>();
		PagedList<SalaryTpl> list=salaryTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}