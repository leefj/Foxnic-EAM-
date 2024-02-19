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


import com.dt.platform.proxy.hr.PersonInterviewServiceProxy;
import com.dt.platform.domain.hr.meta.PersonInterviewVOMeta;
import com.dt.platform.domain.hr.PersonInterview;
import com.dt.platform.domain.hr.PersonInterviewVO;
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
import com.dt.platform.domain.hr.meta.PersonInterviewMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.hr.Interview;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonInterviewService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 初选人员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 19:53:48
*/

@InDoc
@Api(tags = "初选人员")
@RestController("HrPersonInterviewController")
public class PersonInterviewController extends SuperController {

	@Autowired
	private IPersonInterviewService personInterviewService;

	/**
	 * 添加初选人员
	*/
	@ApiOperation(value = "添加初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812048953112526848"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_ID , value = "面试" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "access"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class , example = "2024-02-06 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "本科"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class , example = "2024-02-08 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_METHOD , value = "面试方式" , required = false , dataTypeClass=String.class , example = "scene"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.POS , value = "应聘岗位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SOURCE , value = "简历来源" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.RESULT , value = "面试结论" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.FILE_ID , value = "简历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonInterviewServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.INSERT)
	public Result insert(PersonInterviewVO personInterviewVO) {
		
		Result result=personInterviewService.insert(personInterviewVO,false);
		return result;
	}



	/**
	 * 删除初选人员
	*/
	@ApiOperation(value = "删除初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812048953112526848")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonInterviewServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personInterviewService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personInterviewService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除初选人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonInterviewServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personInterviewService.hasRefers(ids);
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
			Result result=personInterviewService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personInterviewService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新初选人员
	*/
	@ApiOperation(value = "更新初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812048953112526848"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_ID , value = "面试" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "access"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class , example = "2024-02-06 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "本科"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class , example = "2024-02-08 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_METHOD , value = "面试方式" , required = false , dataTypeClass=String.class , example = "scene"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.POS , value = "应聘岗位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SOURCE , value = "简历来源" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.RESULT , value = "面试结论" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.FILE_ID , value = "简历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonInterviewVOMeta.PAGE_INDEX , PersonInterviewVOMeta.PAGE_SIZE , PersonInterviewVOMeta.SEARCH_FIELD , PersonInterviewVOMeta.FUZZY_FIELD , PersonInterviewVOMeta.SEARCH_VALUE , PersonInterviewVOMeta.DIRTY_FIELDS , PersonInterviewVOMeta.SORT_FIELD , PersonInterviewVOMeta.SORT_TYPE , PersonInterviewVOMeta.DATA_ORIGIN , PersonInterviewVOMeta.QUERY_LOGIC , PersonInterviewVOMeta.REQUEST_ACTION , PersonInterviewVOMeta.IDS } )
	@SentinelResource(value = PersonInterviewServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.UPDATE)
	public Result update(PersonInterviewVO personInterviewVO) {
		
		Result result=personInterviewService.update(personInterviewVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存初选人员
	*/
	@ApiOperation(value = "保存初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812048953112526848"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_ID , value = "面试" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "access"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class , example = "2024-02-06 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "本科"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class , example = "2024-02-08 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_METHOD , value = "面试方式" , required = false , dataTypeClass=String.class , example = "scene"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.POS , value = "应聘岗位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SOURCE , value = "简历来源" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.RESULT , value = "面试结论" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.FILE_ID , value = "简历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonInterviewVOMeta.PAGE_INDEX , PersonInterviewVOMeta.PAGE_SIZE , PersonInterviewVOMeta.SEARCH_FIELD , PersonInterviewVOMeta.FUZZY_FIELD , PersonInterviewVOMeta.SEARCH_VALUE , PersonInterviewVOMeta.DIRTY_FIELDS , PersonInterviewVOMeta.SORT_FIELD , PersonInterviewVOMeta.SORT_TYPE , PersonInterviewVOMeta.DATA_ORIGIN , PersonInterviewVOMeta.QUERY_LOGIC , PersonInterviewVOMeta.REQUEST_ACTION , PersonInterviewVOMeta.IDS } )
	@SentinelResource(value = PersonInterviewServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.SAVE)
	public Result save(PersonInterviewVO personInterviewVO) {
		
		Result result=personInterviewService.save(personInterviewVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取初选人员
	*/
	@ApiOperation(value = "获取初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonInterviewServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.GET_BY_ID)
	public Result<PersonInterview> getById(String id) {
		
		Result<PersonInterview> result=new Result<>();
		PersonInterview personInterview=personInterviewService.getById(id);
		// join 关联的对象
		personInterviewService.dao().fill(personInterview)
			.with("organization")
			.with(PersonInterviewMeta.INTERVIEW)
			.with(PersonInterviewMeta.SEX_DICT)
			.with(PersonInterviewMeta.INTERVIEW_METHOD_DICT)
			.with(PersonInterviewMeta.SOURCE_DICT)
			.execute();
		result.success(true).data(personInterview);
		return result;
	}


	/**
	 * 批量获取初选人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取初选人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonInterviewVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonInterviewServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.GET_BY_IDS)
	public Result<List<PersonInterview>> getByIds(List<String> ids) {
		
		Result<List<PersonInterview>> result=new Result<>();
		List<PersonInterview> list=personInterviewService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询初选人员
	*/
	@ApiOperation(value = "查询初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812048953112526848"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_ID , value = "面试" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "access"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class , example = "2024-02-06 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "本科"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class , example = "2024-02-08 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_METHOD , value = "面试方式" , required = false , dataTypeClass=String.class , example = "scene"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.POS , value = "应聘岗位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SOURCE , value = "简历来源" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.RESULT , value = "面试结论" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.FILE_ID , value = "简历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonInterviewVOMeta.PAGE_INDEX , PersonInterviewVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonInterviewServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.QUERY_LIST)
	public Result<List<PersonInterview>> queryList(PersonInterviewVO sample) {
		
		Result<List<PersonInterview>> result=new Result<>();
		List<PersonInterview> list=personInterviewService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询初选人员
	*/
	@ApiOperation(value = "分页查询初选人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonInterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812048953112526848"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_ID , value = "面试" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "access"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class , example = "2024-02-06 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "本科"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class , example = "2024-02-08 12:00:00"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.INTERVIEW_METHOD , value = "面试方式" , required = false , dataTypeClass=String.class , example = "scene"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.POS , value = "应聘岗位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.SOURCE , value = "简历来源" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.RESULT , value = "面试结论" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.FILE_ID , value = "简历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonInterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = PersonInterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonInterviewServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonInterviewServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonInterview>> queryPagedList(PersonInterviewVO sample) {
		
		Result<PagedList<PersonInterview>> result=new Result<>();
		PagedList<PersonInterview> list=personInterviewService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personInterviewService.dao().fill(list)
			.with("organization")
			.with(PersonInterviewMeta.INTERVIEW)
			.with(PersonInterviewMeta.SEX_DICT)
			.with(PersonInterviewMeta.INTERVIEW_METHOD_DICT)
			.with(PersonInterviewMeta.SOURCE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}