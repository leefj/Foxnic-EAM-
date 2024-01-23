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


import com.dt.platform.proxy.hr.PersonTransferRcdServiceProxy;
import com.dt.platform.domain.hr.meta.PersonTransferRcdVOMeta;
import com.dt.platform.domain.hr.PersonTransferRcd;
import com.dt.platform.domain.hr.PersonTransferRcdVO;
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
import com.dt.platform.domain.hr.meta.PersonTransferRcdMeta;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonTransferRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 员工调动记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:35:13
*/

@InDoc
@Api(tags = "员工调动记录")
@RestController("HrPersonTransferRcdController")
public class PersonTransferRcdController extends SuperController {

	@Autowired
	private IPersonTransferRcdService personTransferRcdService;

	/**
	 * 添加员工调动记录
	*/
	@ApiOperation(value = "添加员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_ID , value = "调动单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.INSERT)
	public Result insert(PersonTransferRcdVO personTransferRcdVO) {
		
		Result result=personTransferRcdService.insert(personTransferRcdVO,false);
		return result;
	}



	/**
	 * 删除员工调动记录
	*/
	@ApiOperation(value = "删除员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personTransferRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personTransferRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除员工调动记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonTransferRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personTransferRcdService.hasRefers(ids);
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
			Result result=personTransferRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personTransferRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新员工调动记录
	*/
	@ApiOperation(value = "更新员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_ID , value = "调动单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonTransferRcdVOMeta.PAGE_INDEX , PersonTransferRcdVOMeta.PAGE_SIZE , PersonTransferRcdVOMeta.SEARCH_FIELD , PersonTransferRcdVOMeta.FUZZY_FIELD , PersonTransferRcdVOMeta.SEARCH_VALUE , PersonTransferRcdVOMeta.DIRTY_FIELDS , PersonTransferRcdVOMeta.SORT_FIELD , PersonTransferRcdVOMeta.SORT_TYPE , PersonTransferRcdVOMeta.DATA_ORIGIN , PersonTransferRcdVOMeta.QUERY_LOGIC , PersonTransferRcdVOMeta.REQUEST_ACTION , PersonTransferRcdVOMeta.IDS } )
	@SentinelResource(value = PersonTransferRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.UPDATE)
	public Result update(PersonTransferRcdVO personTransferRcdVO) {
		
		Result result=personTransferRcdService.update(personTransferRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存员工调动记录
	*/
	@ApiOperation(value = "保存员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_ID , value = "调动单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonTransferRcdVOMeta.PAGE_INDEX , PersonTransferRcdVOMeta.PAGE_SIZE , PersonTransferRcdVOMeta.SEARCH_FIELD , PersonTransferRcdVOMeta.FUZZY_FIELD , PersonTransferRcdVOMeta.SEARCH_VALUE , PersonTransferRcdVOMeta.DIRTY_FIELDS , PersonTransferRcdVOMeta.SORT_FIELD , PersonTransferRcdVOMeta.SORT_TYPE , PersonTransferRcdVOMeta.DATA_ORIGIN , PersonTransferRcdVOMeta.QUERY_LOGIC , PersonTransferRcdVOMeta.REQUEST_ACTION , PersonTransferRcdVOMeta.IDS } )
	@SentinelResource(value = PersonTransferRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.SAVE)
	public Result save(PersonTransferRcdVO personTransferRcdVO) {
		
		Result result=personTransferRcdService.save(personTransferRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取员工调动记录
	*/
	@ApiOperation(value = "获取员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.GET_BY_ID)
	public Result<PersonTransferRcd> getById(String id) {
		
		Result<PersonTransferRcd> result=new Result<>();
		PersonTransferRcd personTransferRcd=personTransferRcdService.getById(id);
		// join 关联的对象
		personTransferRcdService.dao().fill(personTransferRcd)
			.with("person")
			.execute();
		result.success(true).data(personTransferRcd);
		return result;
	}


	/**
	 * 批量获取员工调动记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取员工调动记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonTransferRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonTransferRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.GET_BY_IDS)
	public Result<List<PersonTransferRcd>> getByIds(List<String> ids) {
		
		Result<List<PersonTransferRcd>> result=new Result<>();
		List<PersonTransferRcd> list=personTransferRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询员工调动记录
	*/
	@ApiOperation(value = "查询员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_ID , value = "调动单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonTransferRcdVOMeta.PAGE_INDEX , PersonTransferRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonTransferRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.QUERY_LIST)
	public Result<List<PersonTransferRcd>> queryList(PersonTransferRcdVO sample) {
		
		Result<List<PersonTransferRcd>> result=new Result<>();
		List<PersonTransferRcd> list=personTransferRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询员工调动记录
	*/
	@ApiOperation(value = "分页查询员工调动记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_ID , value = "调动单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.PERSON_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.OPER_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonTransferRcdVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonTransferRcd>> queryPagedList(PersonTransferRcdVO sample) {
		
		Result<PagedList<PersonTransferRcd>> result=new Result<>();
		PagedList<PersonTransferRcd> list=personTransferRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personTransferRcdService.dao().fill(list)
			.with("person")
			.execute();
		result.success(true).data(list);
		return result;
	}





}