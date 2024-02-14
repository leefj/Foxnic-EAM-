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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.dt.platform.proxy.hr.PersonLeaveServiceProxy;
import com.dt.platform.domain.hr.meta.PersonLeaveVOMeta;
import com.dt.platform.domain.hr.PersonLeave;
import com.dt.platform.domain.hr.PersonLeaveVO;
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
import com.dt.platform.domain.hr.meta.PersonLeaveMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonLeaveService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 员工离职接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:03:42
*/

@InDoc
@Api(tags = "员工离职")
@RestController("HrPersonLeaveController")
public class PersonLeaveController extends SuperController implements BpmCallbackController{

	@Autowired
	private IPersonLeaveService personLeaveService;

	/**
	 * 添加员工离职
	*/
	@ApiOperation(value = "添加员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.PERSON_ID , value = "离职人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.HANDOVER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonLeaveServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.INSERT)
	public Result insert(PersonLeaveVO personLeaveVO) {
		
		Result result=personLeaveService.insert(personLeaveVO,false);
		return result;
	}



	/**
	 * 删除员工离职
	*/
	@ApiOperation(value = "删除员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonLeaveServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personLeaveService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personLeaveService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除员工离职 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonLeaveServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personLeaveService.hasRefers(ids);
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
			Result result=personLeaveService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personLeaveService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.PERSON_ID , value = "离职人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.HANDOVER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonLeaveVOMeta.PAGE_INDEX , PersonLeaveVOMeta.PAGE_SIZE , PersonLeaveVOMeta.SEARCH_FIELD , PersonLeaveVOMeta.FUZZY_FIELD , PersonLeaveVOMeta.SEARCH_VALUE , PersonLeaveVOMeta.DIRTY_FIELDS , PersonLeaveVOMeta.SORT_FIELD , PersonLeaveVOMeta.SORT_TYPE , PersonLeaveVOMeta.DATA_ORIGIN , PersonLeaveVOMeta.QUERY_LOGIC , PersonLeaveVOMeta.REQUEST_ACTION , PersonLeaveVOMeta.IDS } )
	@SentinelResource(value = PersonLeaveServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.UPDATE)
	public Result update(PersonLeaveVO personLeaveVO) {
		
		Result result=personLeaveService.update(personLeaveVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存员工离职
	*/
	@ApiOperation(value = "保存员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.PERSON_ID , value = "离职人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.HANDOVER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonLeaveVOMeta.PAGE_INDEX , PersonLeaveVOMeta.PAGE_SIZE , PersonLeaveVOMeta.SEARCH_FIELD , PersonLeaveVOMeta.FUZZY_FIELD , PersonLeaveVOMeta.SEARCH_VALUE , PersonLeaveVOMeta.DIRTY_FIELDS , PersonLeaveVOMeta.SORT_FIELD , PersonLeaveVOMeta.SORT_TYPE , PersonLeaveVOMeta.DATA_ORIGIN , PersonLeaveVOMeta.QUERY_LOGIC , PersonLeaveVOMeta.REQUEST_ACTION , PersonLeaveVOMeta.IDS } )
	@SentinelResource(value = PersonLeaveServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.SAVE)
	public Result save(PersonLeaveVO personLeaveVO) {
		
		Result result=personLeaveService.save(personLeaveVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取员工离职
	*/
	@ApiOperation(value = "获取员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonLeaveServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.GET_BY_ID)
	public Result<PersonLeave> getById(String id) {
		
		Result<PersonLeave> result=new Result<>();
		PersonLeave personLeave=personLeaveService.getById(id);
		// join 关联的对象
		personLeaveService.dao().fill(personLeave)
			.with("person")
			.with("handover")
			.execute();
		// 填充流程相关的属性
		personLeaveService.joinProcess(personLeave);
		result.success(true).data(personLeave);
		return result;
	}


	/**
	 * 批量获取员工离职 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取员工离职")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonLeaveVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonLeaveServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.GET_BY_IDS)
	public Result<List<PersonLeave>> getByIds(List<String> ids) {
		
		Result<List<PersonLeave>> result=new Result<>();
		List<PersonLeave> list=personLeaveService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询员工离职
	*/
	@ApiOperation(value = "查询员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.PERSON_ID , value = "离职人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.HANDOVER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonLeaveVOMeta.PAGE_INDEX , PersonLeaveVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonLeaveServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.QUERY_LIST)
	public Result<List<PersonLeave>> queryList(PersonLeaveVO sample) {
		
		Result<List<PersonLeave>> result=new Result<>();
		List<PersonLeave> list=personLeaveService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询员工离职
	*/
	@ApiOperation(value = "分页查询员工离职")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonLeaveVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.PERSON_ID , value = "离职人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.HANDOVER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonLeaveVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonLeaveServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonLeave>> queryPagedList(PersonLeaveVO sample) {
		
		Result<PagedList<PersonLeave>> result=new Result<>();
		PagedList<PersonLeave> list=personLeaveService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personLeaveService.dao().fill(list)
			.with("person")
			.with("handover")
			.execute();
		// 填充流程相关的属性
		personLeaveService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = PersonLeaveServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonLeaveServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return personLeaveService.onProcessCallback(event);
	}



}