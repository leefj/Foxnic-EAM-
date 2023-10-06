package com.dt.platform.oa.controller;

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


import com.dt.platform.proxy.oa.NetdiskOperRecordServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskOperRecordVOMeta;
import com.dt.platform.domain.oa.NetdiskOperRecord;
import com.dt.platform.domain.oa.NetdiskOperRecordVO;
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
import com.dt.platform.domain.oa.meta.NetdiskOperRecordMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskOperRecordService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 操作记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-30 10:52:17
*/

@InDoc
@Api(tags = "操作记录")
@RestController("OaNetdiskOperRecordController")
public class NetdiskOperRecordController extends SuperController {

	@Autowired
	private INetdiskOperRecordService netdiskOperRecordService;

	/**
	 * 添加操作记录
	*/
	@ApiOperation(value = "添加操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_TYPE , value = "对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskOperRecordServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.INSERT)
	public Result insert(NetdiskOperRecordVO netdiskOperRecordVO) {
		
		Result result=netdiskOperRecordService.insert(netdiskOperRecordVO,false);
		return result;
	}



	/**
	 * 删除操作记录
	*/
	@ApiOperation(value = "删除操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskOperRecordServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  netdiskOperRecordService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=netdiskOperRecordService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除操作记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = NetdiskOperRecordServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = netdiskOperRecordService.hasRefers(ids);
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
			Result result=netdiskOperRecordService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=netdiskOperRecordService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新操作记录
	*/
	@ApiOperation(value = "更新操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_TYPE , value = "对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskOperRecordVOMeta.PAGE_INDEX , NetdiskOperRecordVOMeta.PAGE_SIZE , NetdiskOperRecordVOMeta.SEARCH_FIELD , NetdiskOperRecordVOMeta.FUZZY_FIELD , NetdiskOperRecordVOMeta.SEARCH_VALUE , NetdiskOperRecordVOMeta.DIRTY_FIELDS , NetdiskOperRecordVOMeta.SORT_FIELD , NetdiskOperRecordVOMeta.SORT_TYPE , NetdiskOperRecordVOMeta.DATA_ORIGIN , NetdiskOperRecordVOMeta.QUERY_LOGIC , NetdiskOperRecordVOMeta.REQUEST_ACTION , NetdiskOperRecordVOMeta.IDS } )
	@SentinelResource(value = NetdiskOperRecordServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.UPDATE)
	public Result update(NetdiskOperRecordVO netdiskOperRecordVO) {
		
		Result result=netdiskOperRecordService.update(netdiskOperRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存操作记录
	*/
	@ApiOperation(value = "保存操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_TYPE , value = "对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NetdiskOperRecordVOMeta.PAGE_INDEX , NetdiskOperRecordVOMeta.PAGE_SIZE , NetdiskOperRecordVOMeta.SEARCH_FIELD , NetdiskOperRecordVOMeta.FUZZY_FIELD , NetdiskOperRecordVOMeta.SEARCH_VALUE , NetdiskOperRecordVOMeta.DIRTY_FIELDS , NetdiskOperRecordVOMeta.SORT_FIELD , NetdiskOperRecordVOMeta.SORT_TYPE , NetdiskOperRecordVOMeta.DATA_ORIGIN , NetdiskOperRecordVOMeta.QUERY_LOGIC , NetdiskOperRecordVOMeta.REQUEST_ACTION , NetdiskOperRecordVOMeta.IDS } )
	@SentinelResource(value = NetdiskOperRecordServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.SAVE)
	public Result save(NetdiskOperRecordVO netdiskOperRecordVO) {
		
		Result result=netdiskOperRecordService.save(netdiskOperRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取操作记录
	*/
	@ApiOperation(value = "获取操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskOperRecordServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.GET_BY_ID)
	public Result<NetdiskOperRecord> getById(String id) {
		
		Result<NetdiskOperRecord> result=new Result<>();
		NetdiskOperRecord netdiskOperRecord=netdiskOperRecordService.getById(id);
		// join 关联的对象
		netdiskOperRecordService.dao().fill(netdiskOperRecord)
			.with("user")
			.execute();
		result.success(true).data(netdiskOperRecord);
		return result;
	}


	/**
	 * 批量获取操作记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取操作记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NetdiskOperRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = NetdiskOperRecordServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.GET_BY_IDS)
	public Result<List<NetdiskOperRecord>> getByIds(List<String> ids) {
		
		Result<List<NetdiskOperRecord>> result=new Result<>();
		List<NetdiskOperRecord> list=netdiskOperRecordService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询操作记录
	*/
	@ApiOperation(value = "查询操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_TYPE , value = "对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetdiskOperRecordVOMeta.PAGE_INDEX , NetdiskOperRecordVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NetdiskOperRecordServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.QUERY_LIST)
	public Result<List<NetdiskOperRecord>> queryList(NetdiskOperRecordVO sample) {
		
		Result<List<NetdiskOperRecord>> result=new Result<>();
		List<NetdiskOperRecord> list=netdiskOperRecordService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询操作记录
	*/
	@ApiOperation(value = "分页查询操作记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.FD_TYPE , value = "对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NetdiskOperRecordVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetdiskOperRecordServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetdiskOperRecordServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<NetdiskOperRecord>> queryPagedList(NetdiskOperRecordVO sample) {
		
		Result<PagedList<NetdiskOperRecord>> result=new Result<>();
		PagedList<NetdiskOperRecord> list=netdiskOperRecordService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		netdiskOperRecordService.dao().fill(list)
			.with("user")
			.execute();
		result.success(true).data(list);
		return result;
	}





}