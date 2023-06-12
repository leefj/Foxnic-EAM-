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


import com.dt.platform.proxy.common.TestServiceProxy;
import com.dt.platform.domain.common.meta.TestVOMeta;
import com.dt.platform.domain.common.Test;
import com.dt.platform.domain.common.TestVO;
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
import com.dt.platform.domain.common.meta.TestMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ITestService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆保险公司接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:27:09
*/

@InDoc
@Api(tags = "车辆保险公司")
@RestController("SysTestController")
public class TestController extends SuperController {

	@Autowired
	private ITestService testService;

	/**
	 * 添加车辆保险公司
	*/
	@ApiOperation(value = "添加车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TestServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.INSERT)
	public Result insert(TestVO testVO) {
		
		Result result=testService.insert(testVO,false);
		return result;
	}



	/**
	 * 删除车辆保险公司
	*/
	@ApiOperation(value = "删除车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TestServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  testService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=testService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆保险公司 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = TestServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = testService.hasRefers(ids);
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
			Result result=testService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=testService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆保险公司
	*/
	@ApiOperation(value = "更新车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TestVOMeta.PAGE_INDEX , TestVOMeta.PAGE_SIZE , TestVOMeta.SEARCH_FIELD , TestVOMeta.FUZZY_FIELD , TestVOMeta.SEARCH_VALUE , TestVOMeta.DIRTY_FIELDS , TestVOMeta.SORT_FIELD , TestVOMeta.SORT_TYPE , TestVOMeta.DATA_ORIGIN , TestVOMeta.QUERY_LOGIC , TestVOMeta.REQUEST_ACTION , TestVOMeta.IDS } )
	@SentinelResource(value = TestServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.UPDATE)
	public Result update(TestVO testVO) {
		
		Result result=testService.update(testVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆保险公司
	*/
	@ApiOperation(value = "保存车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TestVOMeta.PAGE_INDEX , TestVOMeta.PAGE_SIZE , TestVOMeta.SEARCH_FIELD , TestVOMeta.FUZZY_FIELD , TestVOMeta.SEARCH_VALUE , TestVOMeta.DIRTY_FIELDS , TestVOMeta.SORT_FIELD , TestVOMeta.SORT_TYPE , TestVOMeta.DATA_ORIGIN , TestVOMeta.QUERY_LOGIC , TestVOMeta.REQUEST_ACTION , TestVOMeta.IDS } )
	@SentinelResource(value = TestServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.SAVE)
	public Result save(TestVO testVO) {
		
		Result result=testService.save(testVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆保险公司
	*/
	@ApiOperation(value = "获取车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TestServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.GET_BY_ID)
	public Result<Test> getById(String id) {
		
		Result<Test> result=new Result<>();
		Test test=testService.getById(id);
		result.success(true).data(test);
		return result;
	}


	/**
	 * 批量获取车辆保险公司 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆保险公司")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TestVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = TestServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.GET_BY_IDS)
	public Result<List<Test>> getByIds(List<String> ids) {
		
		Result<List<Test>> result=new Result<>();
		List<Test> list=testService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆保险公司
	*/
	@ApiOperation(value = "查询车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TestVOMeta.PAGE_INDEX , TestVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TestServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.QUERY_LIST)
	public Result<List<Test>> queryList(TestVO sample) {
		
		Result<List<Test>> result=new Result<>();
		List<Test> list=testService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆保险公司
	*/
	@ApiOperation(value = "分页查询车辆保险公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TestServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TestServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Test>> queryPagedList(TestVO sample) {
		
		Result<PagedList<Test>> result=new Result<>();
		PagedList<Test> list=testService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}