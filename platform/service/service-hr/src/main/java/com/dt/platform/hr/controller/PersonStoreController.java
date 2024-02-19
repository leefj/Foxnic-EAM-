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


import com.dt.platform.proxy.hr.PersonStoreServiceProxy;
import com.dt.platform.domain.hr.meta.PersonStoreVOMeta;
import com.dt.platform.domain.hr.PersonStore;
import com.dt.platform.domain.hr.PersonStoreVO;
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
import com.dt.platform.domain.hr.meta.PersonStoreMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.meta.PersonMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonStoreService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 19:55:04
*/

@InDoc
@Api(tags = "人员信息")
@RestController("HrPersonStoreController")
public class PersonStoreController extends SuperController {

	@Autowired
	private IPersonStoreService personStoreService;

	/**
	 * 添加人员信息
	*/
	@ApiOperation(value = "添加人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812049443456024576"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = PersonStoreVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "junior_college"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class , example = "2024-02-16 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CERTIFICATE , value = "所获证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class , example = "2024-02-23 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.SPECIAL_SKILL , value = "特长" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOB_REQUIREMENT , value = "对工作要求" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOW_SALARY , value = "目前月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOR_SALARY , value = "期望月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SOURCE , value = "招聘来源" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.REVIEW_RESULT , value = "评审结果" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POSITION , value = "应聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "bad"),
		@ApiImplicitParam(name = PersonStoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonStoreServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.INSERT)
	public Result insert(PersonStoreVO personStoreVO) {
		
		Result result=personStoreService.insert(personStoreVO,false);
		return result;
	}



	/**
	 * 删除人员信息
	*/
	@ApiOperation(value = "删除人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812049443456024576")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonStoreServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personStoreService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personStoreService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonStoreServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personStoreService.hasRefers(ids);
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
			Result result=personStoreService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personStoreService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新人员信息
	*/
	@ApiOperation(value = "更新人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812049443456024576"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = PersonStoreVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "junior_college"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class , example = "2024-02-16 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CERTIFICATE , value = "所获证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class , example = "2024-02-23 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.SPECIAL_SKILL , value = "特长" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOB_REQUIREMENT , value = "对工作要求" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOW_SALARY , value = "目前月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOR_SALARY , value = "期望月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SOURCE , value = "招聘来源" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.REVIEW_RESULT , value = "评审结果" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POSITION , value = "应聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "bad"),
		@ApiImplicitParam(name = PersonStoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonStoreVOMeta.PAGE_INDEX , PersonStoreVOMeta.PAGE_SIZE , PersonStoreVOMeta.SEARCH_FIELD , PersonStoreVOMeta.FUZZY_FIELD , PersonStoreVOMeta.SEARCH_VALUE , PersonStoreVOMeta.DIRTY_FIELDS , PersonStoreVOMeta.SORT_FIELD , PersonStoreVOMeta.SORT_TYPE , PersonStoreVOMeta.DATA_ORIGIN , PersonStoreVOMeta.QUERY_LOGIC , PersonStoreVOMeta.REQUEST_ACTION , PersonStoreVOMeta.IDS } )
	@SentinelResource(value = PersonStoreServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.UPDATE)
	public Result update(PersonStoreVO personStoreVO) {
		
		Result result=personStoreService.update(personStoreVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员信息
	*/
	@ApiOperation(value = "保存人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812049443456024576"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = PersonStoreVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "junior_college"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class , example = "2024-02-16 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CERTIFICATE , value = "所获证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class , example = "2024-02-23 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.SPECIAL_SKILL , value = "特长" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOB_REQUIREMENT , value = "对工作要求" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOW_SALARY , value = "目前月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOR_SALARY , value = "期望月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SOURCE , value = "招聘来源" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.REVIEW_RESULT , value = "评审结果" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POSITION , value = "应聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "bad"),
		@ApiImplicitParam(name = PersonStoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonStoreVOMeta.PAGE_INDEX , PersonStoreVOMeta.PAGE_SIZE , PersonStoreVOMeta.SEARCH_FIELD , PersonStoreVOMeta.FUZZY_FIELD , PersonStoreVOMeta.SEARCH_VALUE , PersonStoreVOMeta.DIRTY_FIELDS , PersonStoreVOMeta.SORT_FIELD , PersonStoreVOMeta.SORT_TYPE , PersonStoreVOMeta.DATA_ORIGIN , PersonStoreVOMeta.QUERY_LOGIC , PersonStoreVOMeta.REQUEST_ACTION , PersonStoreVOMeta.IDS } )
	@SentinelResource(value = PersonStoreServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.SAVE)
	public Result save(PersonStoreVO personStoreVO) {
		
		Result result=personStoreService.save(personStoreVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员信息
	*/
	@ApiOperation(value = "获取人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonStoreServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.GET_BY_ID)
	public Result<PersonStore> getById(String id) {
		
		Result<PersonStore> result=new Result<>();
		PersonStore personStore=personStoreService.getById(id);
		// join 关联的对象
		personStoreService.dao().fill(personStore)
			.with(PersonMeta.EDUCATION_DATA)
			.with(PersonMeta.SEX_DICT)
			.with(PersonMeta.MARITAL_STATUS_DICT)
			.with(PersonMeta.POLITIC_COUNTENANCE_DATA)
			.execute();
		result.success(true).data(personStore);
		return result;
	}


	/**
	 * 批量获取人员信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonStoreVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonStoreServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.GET_BY_IDS)
	public Result<List<PersonStore>> getByIds(List<String> ids) {
		
		Result<List<PersonStore>> result=new Result<>();
		List<PersonStore> list=personStoreService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员信息
	*/
	@ApiOperation(value = "查询人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812049443456024576"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = PersonStoreVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "junior_college"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class , example = "2024-02-16 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CERTIFICATE , value = "所获证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class , example = "2024-02-23 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.SPECIAL_SKILL , value = "特长" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOB_REQUIREMENT , value = "对工作要求" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOW_SALARY , value = "目前月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOR_SALARY , value = "期望月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SOURCE , value = "招聘来源" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.REVIEW_RESULT , value = "评审结果" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POSITION , value = "应聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "bad"),
		@ApiImplicitParam(name = PersonStoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonStoreVOMeta.PAGE_INDEX , PersonStoreVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonStoreServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.QUERY_LIST)
	public Result<List<PersonStore>> queryList(PersonStoreVO sample) {
		
		Result<List<PersonStore>> result=new Result<>();
		List<PersonStore> list=personStoreService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员信息
	*/
	@ApiOperation(value = "分页查询人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonStoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "812049443456024576"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = PersonStoreVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class , example = "junior_college"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class , example = "2024-02-16 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.CERTIFICATE , value = "所获证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class , example = "2024-02-23 12:00:00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.SPECIAL_SKILL , value = "特长" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.JOB_REQUIREMENT , value = "对工作要求" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOW_SALARY , value = "目前月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.FOR_SALARY , value = "期望月薪" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = PersonStoreVOMeta.SOURCE , value = "招聘来源" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.REVIEW_RESULT , value = "评审结果" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonStoreVOMeta.POSITION , value = "应聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonStoreVOMeta.STATUS , value = "面试结果" , required = false , dataTypeClass=String.class , example = "bad"),
		@ApiImplicitParam(name = PersonStoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonStoreServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonStoreServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonStore>> queryPagedList(PersonStoreVO sample) {
		
		Result<PagedList<PersonStore>> result=new Result<>();
		PagedList<PersonStore> list=personStoreService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personStoreService.dao().fill(list)
			.with(PersonMeta.EDUCATION_DATA)
			.with(PersonMeta.SEX_DICT)
			.with(PersonMeta.MARITAL_STATUS_DICT)
			.with(PersonMeta.POLITIC_COUNTENANCE_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}





}