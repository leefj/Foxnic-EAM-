package com.dt.platform.ops.controller;

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


import com.dt.platform.proxy.ops.HostEnvInfoServiceProxy;
import com.dt.platform.domain.ops.meta.HostEnvInfoVOMeta;
import com.dt.platform.domain.ops.HostEnvInfo;
import com.dt.platform.domain.ops.HostEnvInfoVO;
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
import com.dt.platform.domain.ops.meta.HostEnvInfoMeta;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.InformationSystem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IHostEnvInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 主机环境接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:34:43
*/

@InDoc
@Api(tags = "主机环境")
@RestController("OpsHostEnvInfoController")
public class HostEnvInfoController extends SuperController {

	@Autowired
	private IHostEnvInfoService hostEnvInfoService;

	/**
	 * 添加主机环境
	*/
	@ApiOperation(value = "添加主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732138067581730816"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "other"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class , example = "732137971578306560"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "A数据库"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IP , value = "物理IP" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IPV6 , value = "IPv6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOST_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212121212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = HostEnvInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.INSERT)
	public Result insert(HostEnvInfoVO hostEnvInfoVO) {
		
		Result result=hostEnvInfoService.insert(hostEnvInfoVO,false);
		return result;
	}



	/**
	 * 删除主机环境
	*/
	@ApiOperation(value = "删除主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732138067581730816")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = HostEnvInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  hostEnvInfoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=hostEnvInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除主机环境 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = HostEnvInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = hostEnvInfoService.hasRefers(ids);
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
			Result result=hostEnvInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=hostEnvInfoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新主机环境
	*/
	@ApiOperation(value = "更新主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732138067581730816"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "other"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class , example = "732137971578306560"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "A数据库"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IP , value = "物理IP" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IPV6 , value = "IPv6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOST_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212121212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { HostEnvInfoVOMeta.PAGE_INDEX , HostEnvInfoVOMeta.PAGE_SIZE , HostEnvInfoVOMeta.SEARCH_FIELD , HostEnvInfoVOMeta.FUZZY_FIELD , HostEnvInfoVOMeta.SEARCH_VALUE , HostEnvInfoVOMeta.DIRTY_FIELDS , HostEnvInfoVOMeta.SORT_FIELD , HostEnvInfoVOMeta.SORT_TYPE , HostEnvInfoVOMeta.DATA_ORIGIN , HostEnvInfoVOMeta.QUERY_LOGIC , HostEnvInfoVOMeta.REQUEST_ACTION , HostEnvInfoVOMeta.IDS } )
	@SentinelResource(value = HostEnvInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.UPDATE)
	public Result update(HostEnvInfoVO hostEnvInfoVO) {
		
		Result result=hostEnvInfoService.update(hostEnvInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存主机环境
	*/
	@ApiOperation(value = "保存主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732138067581730816"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "other"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class , example = "732137971578306560"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "A数据库"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IP , value = "物理IP" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IPV6 , value = "IPv6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOST_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212121212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostEnvInfoVOMeta.PAGE_INDEX , HostEnvInfoVOMeta.PAGE_SIZE , HostEnvInfoVOMeta.SEARCH_FIELD , HostEnvInfoVOMeta.FUZZY_FIELD , HostEnvInfoVOMeta.SEARCH_VALUE , HostEnvInfoVOMeta.DIRTY_FIELDS , HostEnvInfoVOMeta.SORT_FIELD , HostEnvInfoVOMeta.SORT_TYPE , HostEnvInfoVOMeta.DATA_ORIGIN , HostEnvInfoVOMeta.QUERY_LOGIC , HostEnvInfoVOMeta.REQUEST_ACTION , HostEnvInfoVOMeta.IDS } )
	@SentinelResource(value = HostEnvInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.SAVE)
	public Result save(HostEnvInfoVO hostEnvInfoVO) {
		
		Result result=hostEnvInfoService.save(hostEnvInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取主机环境
	*/
	@ApiOperation(value = "获取主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = HostEnvInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.GET_BY_ID)
	public Result<HostEnvInfo> getById(String id) {
		
		Result<HostEnvInfo> result=new Result<>();
		HostEnvInfo hostEnvInfo=hostEnvInfoService.getById(id);
		// join 关联的对象
		hostEnvInfoService.dao().fill(hostEnvInfo)
			.with(HostEnvInfoMeta.INFO_SYSTEM)
			.execute();
		result.success(true).data(hostEnvInfo);
		return result;
	}


	/**
	 * 批量获取主机环境 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取主机环境")
		@ApiImplicitParams({
				@ApiImplicitParam(name = HostEnvInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = HostEnvInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.GET_BY_IDS)
	public Result<List<HostEnvInfo>> getByIds(List<String> ids) {
		
		Result<List<HostEnvInfo>> result=new Result<>();
		List<HostEnvInfo> list=hostEnvInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询主机环境
	*/
	@ApiOperation(value = "查询主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732138067581730816"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "other"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class , example = "732137971578306560"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "A数据库"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IP , value = "物理IP" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IPV6 , value = "IPv6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOST_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212121212"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { HostEnvInfoVOMeta.PAGE_INDEX , HostEnvInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = HostEnvInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.QUERY_LIST)
	public Result<List<HostEnvInfo>> queryList(HostEnvInfoVO sample) {
		
		Result<List<HostEnvInfo>> result=new Result<>();
		List<HostEnvInfo> list=hostEnvInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询主机环境
	*/
	@ApiOperation(value = "分页查询主机环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732138067581730816"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "other"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class , example = "732137971578306560"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "A数据库"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IP , value = "物理IP" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.IPV6 , value = "IPv6" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.HOST_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212121212"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = HostEnvInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostEnvInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<HostEnvInfo>> queryPagedList(HostEnvInfoVO sample) {
		
		Result<PagedList<HostEnvInfo>> result=new Result<>();
		PagedList<HostEnvInfo> list=hostEnvInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		hostEnvInfoService.dao().fill(list)
			.with(HostEnvInfoMeta.INFO_SYSTEM)
			.execute();
		result.success(true).data(list);
		return result;
	}





}