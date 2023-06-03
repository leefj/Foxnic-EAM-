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


import com.dt.platform.proxy.common.DemoTestServiceProxy;
import com.dt.platform.domain.common.meta.DemoTestVOMeta;
import com.dt.platform.domain.common.DemoTest;
import com.dt.platform.domain.common.DemoTestVO;
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
import com.dt.platform.domain.common.meta.DemoTestMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IDemoTestService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 测试接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:40
*/

@InDoc
@Api(tags = "测试")
@RestController("SysDemoTestController")
public class DemoTestController extends SuperController {

	@Autowired
	private IDemoTestService demoTestService;

	/**
	 * 添加测试
	*/
	@ApiOperation(value = "添加测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "716916808019345408"),
		@ApiImplicitParam(name = DemoTestVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = DemoTestVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoTestServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.INSERT)
	public Result insert(DemoTestVO demoTestVO) {
		
		Result result=demoTestService.insert(demoTestVO,false);
		return result;
	}



	/**
	 * 删除测试
	*/
	@ApiOperation(value = "删除测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "716916808019345408")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoTestServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  demoTestService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=demoTestService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除测试 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DemoTestServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = demoTestService.hasRefers(ids);
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
			Result result=demoTestService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=demoTestService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新测试
	*/
	@ApiOperation(value = "更新测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "716916808019345408"),
		@ApiImplicitParam(name = DemoTestVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = DemoTestVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DemoTestVOMeta.PAGE_INDEX , DemoTestVOMeta.PAGE_SIZE , DemoTestVOMeta.SEARCH_FIELD , DemoTestVOMeta.FUZZY_FIELD , DemoTestVOMeta.SEARCH_VALUE , DemoTestVOMeta.DIRTY_FIELDS , DemoTestVOMeta.SORT_FIELD , DemoTestVOMeta.SORT_TYPE , DemoTestVOMeta.DATA_ORIGIN , DemoTestVOMeta.QUERY_LOGIC , DemoTestVOMeta.REQUEST_ACTION , DemoTestVOMeta.IDS } )
	@SentinelResource(value = DemoTestServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.UPDATE)
	public Result update(DemoTestVO demoTestVO) {
		
		Result result=demoTestService.update(demoTestVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存测试
	*/
	@ApiOperation(value = "保存测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "716916808019345408"),
		@ApiImplicitParam(name = DemoTestVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = DemoTestVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DemoTestVOMeta.PAGE_INDEX , DemoTestVOMeta.PAGE_SIZE , DemoTestVOMeta.SEARCH_FIELD , DemoTestVOMeta.FUZZY_FIELD , DemoTestVOMeta.SEARCH_VALUE , DemoTestVOMeta.DIRTY_FIELDS , DemoTestVOMeta.SORT_FIELD , DemoTestVOMeta.SORT_TYPE , DemoTestVOMeta.DATA_ORIGIN , DemoTestVOMeta.QUERY_LOGIC , DemoTestVOMeta.REQUEST_ACTION , DemoTestVOMeta.IDS } )
	@SentinelResource(value = DemoTestServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.SAVE)
	public Result save(DemoTestVO demoTestVO) {
		
		Result result=demoTestService.save(demoTestVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取测试
	*/
	@ApiOperation(value = "获取测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoTestServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.GET_BY_ID)
	public Result<DemoTest> getById(String id) {
		
		Result<DemoTest> result=new Result<>();
		DemoTest demoTest=demoTestService.getById(id);
		result.success(true).data(demoTest);
		return result;
	}


	/**
	 * 批量获取测试 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取测试")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DemoTestVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DemoTestServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.GET_BY_IDS)
	public Result<List<DemoTest>> getByIds(List<String> ids) {
		
		Result<List<DemoTest>> result=new Result<>();
		List<DemoTest> list=demoTestService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询测试
	*/
	@ApiOperation(value = "查询测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "716916808019345408"),
		@ApiImplicitParam(name = DemoTestVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = DemoTestVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DemoTestVOMeta.PAGE_INDEX , DemoTestVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DemoTestServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.QUERY_LIST)
	public Result<List<DemoTest>> queryList(DemoTestVO sample) {
		
		Result<List<DemoTest>> result=new Result<>();
		List<DemoTest> list=demoTestService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询测试
	*/
	@ApiOperation(value = "分页查询测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DemoTestVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "716916808019345408"),
		@ApiImplicitParam(name = DemoTestVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = DemoTestVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DemoTestVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DemoTestServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DemoTestServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DemoTest>> queryPagedList(DemoTestVO sample) {
		
		Result<PagedList<DemoTest>> result=new Result<>();
		PagedList<DemoTest> list=demoTestService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}