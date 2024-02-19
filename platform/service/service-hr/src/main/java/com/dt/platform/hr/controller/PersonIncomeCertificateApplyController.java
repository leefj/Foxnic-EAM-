package com.dt.platform.hr.controller;

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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.dt.platform.proxy.hr.PersonIncomeCertificateApplyServiceProxy;
import com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyVOMeta;
import com.dt.platform.domain.hr.PersonIncomeCertificateApply;
import com.dt.platform.domain.hr.PersonIncomeCertificateApplyVO;
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
import com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonIncomeCertificateApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 收入证明申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 16:01:41
*/

@InDoc
@Api(tags = "收入证明申请")
@RestController("HrPersonIncomeCertificateApplyController")
public class PersonIncomeCertificateApplyController extends SuperController implements BpmCallbackController{

	@Autowired
	private IPersonIncomeCertificateApplyService personIncomeCertificateApplyService;

	/**
	 * 添加收入证明申请
	*/
	@ApiOperation(value = "添加收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE , value = "申请日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERIOD , value = "证明有效期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.INSERT)
	public Result insert(PersonIncomeCertificateApplyVO personIncomeCertificateApplyVO) {
		
		Result result=personIncomeCertificateApplyService.insert(personIncomeCertificateApplyVO,false);
		return result;
	}



	/**
	 * 删除收入证明申请
	*/
	@ApiOperation(value = "删除收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personIncomeCertificateApplyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personIncomeCertificateApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除收入证明申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personIncomeCertificateApplyService.hasRefers(ids);
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
			Result result=personIncomeCertificateApplyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personIncomeCertificateApplyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新收入证明申请
	*/
	@ApiOperation(value = "更新收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE , value = "申请日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERIOD , value = "证明有效期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonIncomeCertificateApplyVOMeta.PAGE_INDEX , PersonIncomeCertificateApplyVOMeta.PAGE_SIZE , PersonIncomeCertificateApplyVOMeta.SEARCH_FIELD , PersonIncomeCertificateApplyVOMeta.FUZZY_FIELD , PersonIncomeCertificateApplyVOMeta.SEARCH_VALUE , PersonIncomeCertificateApplyVOMeta.DIRTY_FIELDS , PersonIncomeCertificateApplyVOMeta.SORT_FIELD , PersonIncomeCertificateApplyVOMeta.SORT_TYPE , PersonIncomeCertificateApplyVOMeta.DATA_ORIGIN , PersonIncomeCertificateApplyVOMeta.QUERY_LOGIC , PersonIncomeCertificateApplyVOMeta.REQUEST_ACTION , PersonIncomeCertificateApplyVOMeta.IDS } )
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.UPDATE)
	public Result update(PersonIncomeCertificateApplyVO personIncomeCertificateApplyVO) {
		
		Result result=personIncomeCertificateApplyService.update(personIncomeCertificateApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存收入证明申请
	*/
	@ApiOperation(value = "保存收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE , value = "申请日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERIOD , value = "证明有效期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonIncomeCertificateApplyVOMeta.PAGE_INDEX , PersonIncomeCertificateApplyVOMeta.PAGE_SIZE , PersonIncomeCertificateApplyVOMeta.SEARCH_FIELD , PersonIncomeCertificateApplyVOMeta.FUZZY_FIELD , PersonIncomeCertificateApplyVOMeta.SEARCH_VALUE , PersonIncomeCertificateApplyVOMeta.DIRTY_FIELDS , PersonIncomeCertificateApplyVOMeta.SORT_FIELD , PersonIncomeCertificateApplyVOMeta.SORT_TYPE , PersonIncomeCertificateApplyVOMeta.DATA_ORIGIN , PersonIncomeCertificateApplyVOMeta.QUERY_LOGIC , PersonIncomeCertificateApplyVOMeta.REQUEST_ACTION , PersonIncomeCertificateApplyVOMeta.IDS } )
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.SAVE)
	public Result save(PersonIncomeCertificateApplyVO personIncomeCertificateApplyVO) {
		
		Result result=personIncomeCertificateApplyService.save(personIncomeCertificateApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取收入证明申请
	*/
	@ApiOperation(value = "获取收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.GET_BY_ID)
	public Result<PersonIncomeCertificateApply> getById(String id) {
		
		Result<PersonIncomeCertificateApply> result=new Result<>();
		PersonIncomeCertificateApply personIncomeCertificateApply=personIncomeCertificateApplyService.getById(id);
		// join 关联的对象
		personIncomeCertificateApplyService.dao().fill(personIncomeCertificateApply)
			.with("organization")
			.with("person")
			.execute();
		// 填充流程相关的属性
		personIncomeCertificateApplyService.dao().join(personIncomeCertificateApply.getPerson(), Person.class);

		personIncomeCertificateApplyService.joinProcess(personIncomeCertificateApply);
		result.success(true).data(personIncomeCertificateApply);
		return result;
	}


	/**
	 * 批量获取收入证明申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取收入证明申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.GET_BY_IDS)
	public Result<List<PersonIncomeCertificateApply>> getByIds(List<String> ids) {
		
		Result<List<PersonIncomeCertificateApply>> result=new Result<>();
		List<PersonIncomeCertificateApply> list=personIncomeCertificateApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询收入证明申请
	*/
	@ApiOperation(value = "查询收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE , value = "申请日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERIOD , value = "证明有效期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonIncomeCertificateApplyVOMeta.PAGE_INDEX , PersonIncomeCertificateApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.QUERY_LIST)
	public Result<List<PersonIncomeCertificateApply>> queryList(PersonIncomeCertificateApplyVO sample) {
		
		Result<List<PersonIncomeCertificateApply>> result=new Result<>();
		List<PersonIncomeCertificateApply> list=personIncomeCertificateApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询收入证明申请
	*/
	@ApiOperation(value = "分页查询收入证明申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE , value = "申请日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.PERIOD , value = "证明有效期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonIncomeCertificateApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonIncomeCertificateApply>> queryPagedList(PersonIncomeCertificateApplyVO sample) {
		
		Result<PagedList<PersonIncomeCertificateApply>> result=new Result<>();
		PagedList<PersonIncomeCertificateApply> list=personIncomeCertificateApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personIncomeCertificateApplyService.dao().fill(list)
			.with("organization")
			.with("person")
			.execute();
		// 填充流程相关的属性
		List<Employee> employees = CollectorUtil.collectList(list, PersonIncomeCertificateApply::getPerson);
		personIncomeCertificateApplyService.dao().join(employees, Person.class);


		personIncomeCertificateApplyService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = PersonIncomeCertificateApplyServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonIncomeCertificateApplyServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return personIncomeCertificateApplyService.onProcessCallback(event);
	}



}