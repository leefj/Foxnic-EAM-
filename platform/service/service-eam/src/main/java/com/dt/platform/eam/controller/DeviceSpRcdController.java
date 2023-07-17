package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.domain.eam.meta.DeviceSpMeta;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.DeviceSpRcdServiceProxy;
import com.dt.platform.domain.eam.meta.DeviceSpRcdVOMeta;
import com.dt.platform.domain.eam.DeviceSpRcd;
import com.dt.platform.domain.eam.DeviceSpRcdVO;
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
import com.dt.platform.domain.eam.meta.DeviceSpRcdMeta;
import com.dt.platform.domain.eam.DeviceSp;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IDeviceSpRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 备件记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:53:23
*/

@InDoc
@Api(tags = "备件记录")
@RestController("EamDeviceSpRcdController")
public class DeviceSpRcdController extends SuperController {

	@Autowired
	private IDeviceSpRcdService deviceSpRcdService;

	/**
	 * 添加备件记录
	*/
	@ApiOperation(value = "添加备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.INSERT)
	public Result insert(DeviceSpRcdVO deviceSpRcdVO) {
		
		Result result=deviceSpRcdService.insert(deviceSpRcdVO,false);
		return result;
	}



	/**
	 * 删除备件记录
	*/
	@ApiOperation(value = "删除备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  deviceSpRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=deviceSpRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除备件记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DeviceSpRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = deviceSpRcdService.hasRefers(ids);
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
			Result result=deviceSpRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=deviceSpRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新备件记录
	*/
	@ApiOperation(value = "更新备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceSpRcdVOMeta.PAGE_INDEX , DeviceSpRcdVOMeta.PAGE_SIZE , DeviceSpRcdVOMeta.SEARCH_FIELD , DeviceSpRcdVOMeta.FUZZY_FIELD , DeviceSpRcdVOMeta.SEARCH_VALUE , DeviceSpRcdVOMeta.DIRTY_FIELDS , DeviceSpRcdVOMeta.SORT_FIELD , DeviceSpRcdVOMeta.SORT_TYPE , DeviceSpRcdVOMeta.DATA_ORIGIN , DeviceSpRcdVOMeta.QUERY_LOGIC , DeviceSpRcdVOMeta.REQUEST_ACTION , DeviceSpRcdVOMeta.IDS } )
	@SentinelResource(value = DeviceSpRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.UPDATE)
	public Result update(DeviceSpRcdVO deviceSpRcdVO) {
		
		Result result=deviceSpRcdService.update(deviceSpRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存备件记录
	*/
	@ApiOperation(value = "保存备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DeviceSpRcdVOMeta.PAGE_INDEX , DeviceSpRcdVOMeta.PAGE_SIZE , DeviceSpRcdVOMeta.SEARCH_FIELD , DeviceSpRcdVOMeta.FUZZY_FIELD , DeviceSpRcdVOMeta.SEARCH_VALUE , DeviceSpRcdVOMeta.DIRTY_FIELDS , DeviceSpRcdVOMeta.SORT_FIELD , DeviceSpRcdVOMeta.SORT_TYPE , DeviceSpRcdVOMeta.DATA_ORIGIN , DeviceSpRcdVOMeta.QUERY_LOGIC , DeviceSpRcdVOMeta.REQUEST_ACTION , DeviceSpRcdVOMeta.IDS } )
	@SentinelResource(value = DeviceSpRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.SAVE)
	public Result save(DeviceSpRcdVO deviceSpRcdVO) {
		
		Result result=deviceSpRcdService.save(deviceSpRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取备件记录
	*/
	@ApiOperation(value = "获取备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.GET_BY_ID)
	public Result<DeviceSpRcd> getById(String id) {
		
		Result<DeviceSpRcd> result=new Result<>();
		DeviceSpRcd deviceSpRcd=deviceSpRcdService.getById(id);
		// join 关联的对象
		deviceSpRcdService.dao().fill(deviceSpRcd)
			.with("operUser")
			.with(DeviceSpRcdMeta.DEVICE_SP)
			.execute();
		result.success(true).data(deviceSpRcd);
		return result;
	}


	/**
	 * 批量获取备件记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取备件记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DeviceSpRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DeviceSpRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.GET_BY_IDS)
	public Result<List<DeviceSpRcd>> getByIds(List<String> ids) {
		
		Result<List<DeviceSpRcd>> result=new Result<>();
		List<DeviceSpRcd> list=deviceSpRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询备件记录
	*/
	@ApiOperation(value = "查询备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceSpRcdVOMeta.PAGE_INDEX , DeviceSpRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DeviceSpRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.QUERY_LIST)
	public Result<List<DeviceSpRcd>> queryList(DeviceSpRcdVO sample) {
		
		Result<List<DeviceSpRcd>> result=new Result<>();
		List<DeviceSpRcd> list=deviceSpRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询备件记录
	*/
	@ApiOperation(value = "分页查询备件记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.SP_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DeviceSpRcdVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DeviceSpRcd>> queryPagedList(DeviceSpRcdVO sample) {
		
		Result<PagedList<DeviceSpRcd>> result=new Result<>();
		PagedList<DeviceSpRcd> list=deviceSpRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		deviceSpRcdService.dao().fill(list)
			.with("operUser")
			.with(DeviceSpRcdMeta.DEVICE_SP)
			.execute();

		deviceSpRcdService.join(list, DeviceSpRcdMeta.OPER_USER);
		List<Employee> managerList = CollectorUtil.collectList(list, DeviceSpRcd::getOperUser);
		deviceSpRcdService.dao().join(managerList, Person.class);

		result.success(true).data(list);
		return result;
	}





}