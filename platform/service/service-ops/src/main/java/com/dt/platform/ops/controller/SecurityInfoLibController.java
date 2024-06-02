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


import com.dt.platform.proxy.ops.SecurityInfoLibServiceProxy;
import com.dt.platform.domain.ops.meta.SecurityInfoLibVOMeta;
import com.dt.platform.domain.ops.SecurityInfoLib;
import com.dt.platform.domain.ops.SecurityInfoLibVO;
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
import com.dt.platform.domain.ops.meta.SecurityInfoLibMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ISecurityInfoLibService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 安全漏洞信息库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-31 09:59:02
*/

@InDoc
@Api(tags = "安全漏洞信息库")
@RestController("OpsSecurityInfoLibController")
public class SecurityInfoLibController extends SuperController {

	@Autowired
	private ISecurityInfoLibService securityInfoLibService;

	/**
	 * 添加安全漏洞信息库
	*/
	@ApiOperation(value = "添加安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "848577244291923968"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE_NAME , value = "来源说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SEC_LEVEL , value = "风险等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.DATA_SCORE , value = "影响范围" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.PROCESS_CT , value = "处理方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.BUSINESS_DATA , value = "发现时间" , required = false , dataTypeClass=Date.class , example = "2024-05-15 12:00:00"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SecurityInfoLibServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.INSERT)
	public Result insert(SecurityInfoLibVO securityInfoLibVO) {
		
		Result result=securityInfoLibService.insert(securityInfoLibVO,false);
		return result;
	}



	/**
	 * 删除安全漏洞信息库
	*/
	@ApiOperation(value = "删除安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "848577244291923968")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SecurityInfoLibServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  securityInfoLibService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=securityInfoLibService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除安全漏洞信息库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SecurityInfoLibServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = securityInfoLibService.hasRefers(ids);
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
			Result result=securityInfoLibService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=securityInfoLibService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新安全漏洞信息库
	*/
	@ApiOperation(value = "更新安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "848577244291923968"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE_NAME , value = "来源说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SEC_LEVEL , value = "风险等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.DATA_SCORE , value = "影响范围" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.PROCESS_CT , value = "处理方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.BUSINESS_DATA , value = "发现时间" , required = false , dataTypeClass=Date.class , example = "2024-05-15 12:00:00"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SecurityInfoLibVOMeta.PAGE_INDEX , SecurityInfoLibVOMeta.PAGE_SIZE , SecurityInfoLibVOMeta.SEARCH_FIELD , SecurityInfoLibVOMeta.FUZZY_FIELD , SecurityInfoLibVOMeta.SEARCH_VALUE , SecurityInfoLibVOMeta.DIRTY_FIELDS , SecurityInfoLibVOMeta.SORT_FIELD , SecurityInfoLibVOMeta.SORT_TYPE , SecurityInfoLibVOMeta.DATA_ORIGIN , SecurityInfoLibVOMeta.QUERY_LOGIC , SecurityInfoLibVOMeta.REQUEST_ACTION , SecurityInfoLibVOMeta.IDS } )
	@SentinelResource(value = SecurityInfoLibServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.UPDATE)
	public Result update(SecurityInfoLibVO securityInfoLibVO) {
		
		Result result=securityInfoLibService.update(securityInfoLibVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存安全漏洞信息库
	*/
	@ApiOperation(value = "保存安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "848577244291923968"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE_NAME , value = "来源说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SEC_LEVEL , value = "风险等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.DATA_SCORE , value = "影响范围" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.PROCESS_CT , value = "处理方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.BUSINESS_DATA , value = "发现时间" , required = false , dataTypeClass=Date.class , example = "2024-05-15 12:00:00"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SecurityInfoLibVOMeta.PAGE_INDEX , SecurityInfoLibVOMeta.PAGE_SIZE , SecurityInfoLibVOMeta.SEARCH_FIELD , SecurityInfoLibVOMeta.FUZZY_FIELD , SecurityInfoLibVOMeta.SEARCH_VALUE , SecurityInfoLibVOMeta.DIRTY_FIELDS , SecurityInfoLibVOMeta.SORT_FIELD , SecurityInfoLibVOMeta.SORT_TYPE , SecurityInfoLibVOMeta.DATA_ORIGIN , SecurityInfoLibVOMeta.QUERY_LOGIC , SecurityInfoLibVOMeta.REQUEST_ACTION , SecurityInfoLibVOMeta.IDS } )
	@SentinelResource(value = SecurityInfoLibServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.SAVE)
	public Result save(SecurityInfoLibVO securityInfoLibVO) {
		
		Result result=securityInfoLibService.save(securityInfoLibVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取安全漏洞信息库
	*/
	@ApiOperation(value = "获取安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SecurityInfoLibServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.GET_BY_ID)
	public Result<SecurityInfoLib> getById(String id) {
		
		Result<SecurityInfoLib> result=new Result<>();
		SecurityInfoLib securityInfoLib=securityInfoLibService.getById(id);
		// join 关联的对象
		securityInfoLibService.dao().fill(securityInfoLib)
			.with(SecurityInfoLibMeta.TYPE_DICT)
			.with(SecurityInfoLibMeta.SOURCE_DICT)
			.with(SecurityInfoLibMeta.LEVEL_DICT)
			.execute();
		result.success(true).data(securityInfoLib);
		return result;
	}


	/**
	 * 批量获取安全漏洞信息库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取安全漏洞信息库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SecurityInfoLibVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SecurityInfoLibServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.GET_BY_IDS)
	public Result<List<SecurityInfoLib>> getByIds(List<String> ids) {
		
		Result<List<SecurityInfoLib>> result=new Result<>();
		List<SecurityInfoLib> list=securityInfoLibService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询安全漏洞信息库
	*/
	@ApiOperation(value = "查询安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "848577244291923968"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE_NAME , value = "来源说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SEC_LEVEL , value = "风险等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.DATA_SCORE , value = "影响范围" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.PROCESS_CT , value = "处理方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.BUSINESS_DATA , value = "发现时间" , required = false , dataTypeClass=Date.class , example = "2024-05-15 12:00:00"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SecurityInfoLibVOMeta.PAGE_INDEX , SecurityInfoLibVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SecurityInfoLibServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.QUERY_LIST)
	public Result<List<SecurityInfoLib>> queryList(SecurityInfoLibVO sample) {
		
		Result<List<SecurityInfoLib>> result=new Result<>();
		List<SecurityInfoLib> list=securityInfoLibService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询安全漏洞信息库
	*/
	@ApiOperation(value = "分页查询安全漏洞信息库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "848577244291923968"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SOURCE_NAME , value = "来源说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.SEC_LEVEL , value = "风险等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.DATA_SCORE , value = "影响范围" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.PROCESS_CT , value = "处理方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.BUSINESS_DATA , value = "发现时间" , required = false , dataTypeClass=Date.class , example = "2024-05-15 12:00:00"),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SecurityInfoLibVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SecurityInfoLibServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SecurityInfoLibServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SecurityInfoLib>> queryPagedList(SecurityInfoLibVO sample) {
		
		Result<PagedList<SecurityInfoLib>> result=new Result<>();
		PagedList<SecurityInfoLib> list=securityInfoLibService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		securityInfoLibService.dao().fill(list)
			.with(SecurityInfoLibMeta.TYPE_DICT)
			.with(SecurityInfoLibMeta.SOURCE_DICT)
			.with(SecurityInfoLibMeta.LEVEL_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}