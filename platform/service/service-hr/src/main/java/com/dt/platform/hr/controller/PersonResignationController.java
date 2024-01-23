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


import com.dt.platform.proxy.hr.PersonResignationServiceProxy;
import com.dt.platform.domain.hr.meta.PersonResignationVOMeta;
import com.dt.platform.domain.hr.PersonResignation;
import com.dt.platform.domain.hr.PersonResignationVO;
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
import com.dt.platform.domain.hr.meta.PersonResignationMeta;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.Position;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonResignationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 员工离职接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:03
*/

@InDoc
@Api(tags = "员工离职")
@RestController("HrPersonResignationController")
public class PersonResignationController extends SuperController {

	@Autowired
	private IPersonResignationService personResignationService;

	/**
	 * 添加员工离职
	*/
	@ApiOperation(value = "添加员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.RESIGNATION_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonResignationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.INSERT)
	public Result insert(PersonResignationVO personResignationVO) {
		
		Result result=personResignationService.insert(personResignationVO,false);
		return result;
	}



	/**
	 * 删除员工离职
	*/
	@ApiOperation(value = "删除员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonResignationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personResignationService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personResignationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除员工离职 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonResignationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personResignationService.hasRefers(ids);
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
			Result result=personResignationService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personResignationService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新员工离职
	*/
	@ApiOperation(value = "更新员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.RESIGNATION_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonResignationVOMeta.PAGE_INDEX , PersonResignationVOMeta.PAGE_SIZE , PersonResignationVOMeta.SEARCH_FIELD , PersonResignationVOMeta.FUZZY_FIELD , PersonResignationVOMeta.SEARCH_VALUE , PersonResignationVOMeta.DIRTY_FIELDS , PersonResignationVOMeta.SORT_FIELD , PersonResignationVOMeta.SORT_TYPE , PersonResignationVOMeta.DATA_ORIGIN , PersonResignationVOMeta.QUERY_LOGIC , PersonResignationVOMeta.REQUEST_ACTION , PersonResignationVOMeta.IDS } )
	@SentinelResource(value = PersonResignationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.UPDATE)
	public Result update(PersonResignationVO personResignationVO) {
		
		Result result=personResignationService.update(personResignationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存员工离职
	*/
	@ApiOperation(value = "保存员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.RESIGNATION_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonResignationVOMeta.PAGE_INDEX , PersonResignationVOMeta.PAGE_SIZE , PersonResignationVOMeta.SEARCH_FIELD , PersonResignationVOMeta.FUZZY_FIELD , PersonResignationVOMeta.SEARCH_VALUE , PersonResignationVOMeta.DIRTY_FIELDS , PersonResignationVOMeta.SORT_FIELD , PersonResignationVOMeta.SORT_TYPE , PersonResignationVOMeta.DATA_ORIGIN , PersonResignationVOMeta.QUERY_LOGIC , PersonResignationVOMeta.REQUEST_ACTION , PersonResignationVOMeta.IDS } )
	@SentinelResource(value = PersonResignationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.SAVE)
	public Result save(PersonResignationVO personResignationVO) {
		
		Result result=personResignationService.save(personResignationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取员工离职
	*/
	@ApiOperation(value = "获取员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonResignationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.GET_BY_ID)
	public Result<PersonResignation> getById(String id) {
		
		Result<PersonResignation> result=new Result<>();
		PersonResignation personResignation=personResignationService.getById(id);
		// join 关联的对象
		personResignationService.dao().fill(personResignation)
			.with("person")
			.execute();
		result.success(true).data(personResignation);
		return result;
	}


	/**
	 * 批量获取员工离职 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取员工离职")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonResignationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonResignationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.GET_BY_IDS)
	public Result<List<PersonResignation>> getByIds(List<String> ids) {
		
		Result<List<PersonResignation>> result=new Result<>();
		List<PersonResignation> list=personResignationService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询员工离职
	*/
	@ApiOperation(value = "查询员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.RESIGNATION_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonResignationVOMeta.PAGE_INDEX , PersonResignationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonResignationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.QUERY_LIST)
	public Result<List<PersonResignation>> queryList(PersonResignationVO sample) {
		
		Result<List<PersonResignation>> result=new Result<>();
		List<PersonResignation> list=personResignationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询员工离职
	*/
	@ApiOperation(value = "分页查询员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonResignationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.RESIGNATION_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonResignationVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonResignationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonResignationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonResignation>> queryPagedList(PersonResignationVO sample) {
		
		Result<PagedList<PersonResignation>> result=new Result<>();
		PagedList<PersonResignation> list=personResignationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personResignationService.dao().fill(list)
			.with("person")
			.execute();
		result.success(true).data(list);
		return result;
	}





}