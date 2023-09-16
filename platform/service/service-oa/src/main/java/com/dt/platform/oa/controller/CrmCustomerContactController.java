package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.CrmCustomerBusiness;
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


import com.dt.platform.proxy.oa.CrmCustomerContactServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerContactVOMeta;
import com.dt.platform.domain.oa.CrmCustomerContact;
import com.dt.platform.domain.oa.CrmCustomerContactVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerContactMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerContactService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 联系人接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 10:56:31
*/

@InDoc
@Api(tags = "联系人")
@RestController("OaCrmCustomerContactController")
public class CrmCustomerContactController extends SuperController {

	@Autowired
	private ICrmCustomerContactService crmCustomerContactService;

	/**
	 * 添加联系人
	*/
	@ApiOperation(value = "添加联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "754655709462790144"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class , example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "阿斯顿"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MOBILE , value = "手机" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MAIL , value = "邮箱" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.WEXIN , value = "微信" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.JOB , value = "职位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "male"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ROLE , value = "角色" , required = false , dataTypeClass=String.class , example = "first_contact"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerContactServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.INSERT)
	public Result insert(CrmCustomerContactVO crmCustomerContactVO) {
		
		Result result=crmCustomerContactService.insert(crmCustomerContactVO,false);
		return result;
	}



	/**
	 * 删除联系人
	*/
	@ApiOperation(value = "删除联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "754655709462790144")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerContactServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerContactService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerContactService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除联系人 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerContactServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerContactService.hasRefers(ids);
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
			Result result=crmCustomerContactService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerContactService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新联系人
	*/
	@ApiOperation(value = "更新联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "754655709462790144"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class , example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "阿斯顿"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MOBILE , value = "手机" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MAIL , value = "邮箱" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.WEXIN , value = "微信" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.JOB , value = "职位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "male"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ROLE , value = "角色" , required = false , dataTypeClass=String.class , example = "first_contact"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerContactVOMeta.PAGE_INDEX , CrmCustomerContactVOMeta.PAGE_SIZE , CrmCustomerContactVOMeta.SEARCH_FIELD , CrmCustomerContactVOMeta.FUZZY_FIELD , CrmCustomerContactVOMeta.SEARCH_VALUE , CrmCustomerContactVOMeta.DIRTY_FIELDS , CrmCustomerContactVOMeta.SORT_FIELD , CrmCustomerContactVOMeta.SORT_TYPE , CrmCustomerContactVOMeta.DATA_ORIGIN , CrmCustomerContactVOMeta.QUERY_LOGIC , CrmCustomerContactVOMeta.REQUEST_ACTION , CrmCustomerContactVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerContactServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.UPDATE)
	public Result update(CrmCustomerContactVO crmCustomerContactVO) {
		
		Result result=crmCustomerContactService.update(crmCustomerContactVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存联系人
	*/
	@ApiOperation(value = "保存联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "754655709462790144"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class , example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "阿斯顿"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MOBILE , value = "手机" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MAIL , value = "邮箱" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.WEXIN , value = "微信" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.JOB , value = "职位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "male"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ROLE , value = "角色" , required = false , dataTypeClass=String.class , example = "first_contact"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerContactVOMeta.PAGE_INDEX , CrmCustomerContactVOMeta.PAGE_SIZE , CrmCustomerContactVOMeta.SEARCH_FIELD , CrmCustomerContactVOMeta.FUZZY_FIELD , CrmCustomerContactVOMeta.SEARCH_VALUE , CrmCustomerContactVOMeta.DIRTY_FIELDS , CrmCustomerContactVOMeta.SORT_FIELD , CrmCustomerContactVOMeta.SORT_TYPE , CrmCustomerContactVOMeta.DATA_ORIGIN , CrmCustomerContactVOMeta.QUERY_LOGIC , CrmCustomerContactVOMeta.REQUEST_ACTION , CrmCustomerContactVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerContactServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.SAVE)
	public Result save(CrmCustomerContactVO crmCustomerContactVO) {
		
		Result result=crmCustomerContactService.save(crmCustomerContactVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取联系人
	*/
	@ApiOperation(value = "获取联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerContactServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.GET_BY_ID)
	public Result<CrmCustomerContact> getById(String id) {
		
		Result<CrmCustomerContact> result=new Result<>();
		CrmCustomerContact crmCustomerContact=crmCustomerContactService.getById(id);
		// join 关联的对象
		crmCustomerContactService.dao().fill(crmCustomerContact)
			.with("originator")
			.with(CrmCustomerContactMeta.CRM_CUSTOMER)
			.execute();

		crmCustomerContactService.dao().join(crmCustomerContact.getOriginator(), Person.class);
		result.success(true).data(crmCustomerContact);
		return result;
	}


	/**
	 * 批量获取联系人 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取联系人")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerContactVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerContactServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerContact>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerContact>> result=new Result<>();
		List<CrmCustomerContact> list=crmCustomerContactService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询联系人
	*/
	@ApiOperation(value = "查询联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "754655709462790144"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class , example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "阿斯顿"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MOBILE , value = "手机" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MAIL , value = "邮箱" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.WEXIN , value = "微信" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.JOB , value = "职位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "male"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ROLE , value = "角色" , required = false , dataTypeClass=String.class , example = "first_contact"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerContactVOMeta.PAGE_INDEX , CrmCustomerContactVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerContactServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerContact>> queryList(CrmCustomerContactVO sample) {
		
		Result<List<CrmCustomerContact>> result=new Result<>();
		List<CrmCustomerContact> list=crmCustomerContactService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询联系人
	*/
	@ApiOperation(value = "分页查询联系人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "754655709462790144"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class , example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "阿斯顿"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MOBILE , value = "手机" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.MAIL , value = "邮箱" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.WEXIN , value = "微信" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.JOB , value = "职位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "male"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ROLE , value = "角色" , required = false , dataTypeClass=String.class , example = "first_contact"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = CrmCustomerContactVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerContactServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerContactServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerContact>> queryPagedList(CrmCustomerContactVO sample) {
		
		Result<PagedList<CrmCustomerContact>> result=new Result<>();
		PagedList<CrmCustomerContact> list=crmCustomerContactService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		crmCustomerContactService.dao().fill(list)
			.with("originator")
			.with(CrmCustomerContactMeta.CRM_CUSTOMER)
			.execute();

		List<Employee> employees = CollectorUtil.collectList(list, CrmCustomerContact::getOriginator);
		crmCustomerContactService.dao().join(employees, Person.class);

		result.success(true).data(list);


		return result;
	}





}