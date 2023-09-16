package com.dt.platform.oa.controller;

import java.util.*;

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


import com.dt.platform.proxy.oa.CrmCustomerTeamServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerTeamVOMeta;
import com.dt.platform.domain.oa.CrmCustomerTeam;
import com.dt.platform.domain.oa.CrmCustomerTeamVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerTeamMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.oa.meta.CrmCustomerLeaderMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerTeamService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 团队成员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 19:07:58
*/

@InDoc
@Api(tags = "团队成员")
@RestController("OaCrmCustomerTeamController")
public class CrmCustomerTeamController extends SuperController {

	@Autowired
	private ICrmCustomerTeamService crmCustomerTeamService;

	/**
	 * 添加团队成员
	*/
	@ApiOperation(value = "添加团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ROLE , value = "团队角色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerTeamServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.INSERT)
	public Result insert(CrmCustomerTeamVO crmCustomerTeamVO) {
		
		Result result=crmCustomerTeamService.insert(crmCustomerTeamVO,false);
		return result;
	}



	/**
	 * 删除团队成员
	*/
	@ApiOperation(value = "删除团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerTeamServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerTeamService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerTeamService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除团队成员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerTeamServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerTeamService.hasRefers(ids);
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
			Result result=crmCustomerTeamService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerTeamService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新团队成员
	*/
	@ApiOperation(value = "更新团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ROLE , value = "团队角色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerTeamVOMeta.PAGE_INDEX , CrmCustomerTeamVOMeta.PAGE_SIZE , CrmCustomerTeamVOMeta.SEARCH_FIELD , CrmCustomerTeamVOMeta.FUZZY_FIELD , CrmCustomerTeamVOMeta.SEARCH_VALUE , CrmCustomerTeamVOMeta.DIRTY_FIELDS , CrmCustomerTeamVOMeta.SORT_FIELD , CrmCustomerTeamVOMeta.SORT_TYPE , CrmCustomerTeamVOMeta.DATA_ORIGIN , CrmCustomerTeamVOMeta.QUERY_LOGIC , CrmCustomerTeamVOMeta.REQUEST_ACTION , CrmCustomerTeamVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerTeamServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.UPDATE)
	public Result update(CrmCustomerTeamVO crmCustomerTeamVO) {
		
		Result result=crmCustomerTeamService.update(crmCustomerTeamVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存团队成员
	*/
	@ApiOperation(value = "保存团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ROLE , value = "团队角色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerTeamVOMeta.PAGE_INDEX , CrmCustomerTeamVOMeta.PAGE_SIZE , CrmCustomerTeamVOMeta.SEARCH_FIELD , CrmCustomerTeamVOMeta.FUZZY_FIELD , CrmCustomerTeamVOMeta.SEARCH_VALUE , CrmCustomerTeamVOMeta.DIRTY_FIELDS , CrmCustomerTeamVOMeta.SORT_FIELD , CrmCustomerTeamVOMeta.SORT_TYPE , CrmCustomerTeamVOMeta.DATA_ORIGIN , CrmCustomerTeamVOMeta.QUERY_LOGIC , CrmCustomerTeamVOMeta.REQUEST_ACTION , CrmCustomerTeamVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerTeamServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.SAVE)
	public Result save(CrmCustomerTeamVO crmCustomerTeamVO) {
		
		Result result=crmCustomerTeamService.save(crmCustomerTeamVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取团队成员
	*/
	@ApiOperation(value = "获取团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerTeamServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.GET_BY_ID)
	public Result<CrmCustomerTeam> getById(String id) {
		
		Result<CrmCustomerTeam> result=new Result<>();
		CrmCustomerTeam crmCustomerTeam=crmCustomerTeamService.getById(id);
		// join 关联的对象
		crmCustomerTeamService.dao().fill(crmCustomerTeam)
			.with("user")
			.execute();

		crmCustomerTeamService.dao().join(crmCustomerTeam.getUser(), Person.class);
		result.success(true).data(crmCustomerTeam);
		return result;
	}


	/**
	 * 批量获取团队成员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取团队成员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerTeamVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerTeamServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerTeam>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerTeam>> result=new Result<>();
		List<CrmCustomerTeam> list=crmCustomerTeamService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询团队成员
	*/
	@ApiOperation(value = "查询团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ROLE , value = "团队角色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerTeamVOMeta.PAGE_INDEX , CrmCustomerTeamVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerTeamServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerTeam>> queryList(CrmCustomerTeamVO sample) {
		
		Result<List<CrmCustomerTeam>> result=new Result<>();
		List<CrmCustomerTeam> list=crmCustomerTeamService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询团队成员
	*/
	@ApiOperation(value = "分页查询团队成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.USER_ROLE , value = "团队角色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerTeamVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerTeamServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerTeamServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerTeam>> queryPagedList(CrmCustomerTeamVO sample) {
		
		Result<PagedList<CrmCustomerTeam>> result=new Result<>();
		PagedList<CrmCustomerTeam> list=crmCustomerTeamService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		crmCustomerTeamService.dao().fill(list)
			.with("user")
			.execute();

		List<Employee> owners = CollectorUtil.collectList(list, CrmCustomerTeam::getUser);
		crmCustomerTeamService.dao().join(owners, Person.class);

		result.success(true).data(list);
		return result;
	}





}