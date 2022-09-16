package com.dt.platform.hr.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.dt.platform.domain.hr.meta.PersonVOMeta;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonVO;
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
import com.dt.platform.domain.hr.meta.PersonMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员信息 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-17 07:13:42
*/

@Api(tags = "人员信息")
@ApiSort(0)
@RestController("HrPersonController")
public class PersonController extends SuperController {

	@Autowired
	private IPersonService personService;


	/**
	 * 添加人员信息
	*/
	@ApiOperation(value = "添加人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOY_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS , value = "员工状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE , value = "人员类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT , value = "紧急联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO , value = "紧急人电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS , value = "家庭地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID , value = "微信号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL , value = "计算机等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE , value = "血型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT , value = "身高" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT , value = "体重" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE , value = "入职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE , value = "转正日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE , value = "初次日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID , value = "员工部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE , value = "员工岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE , value = "员工职称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE , value = "员工职级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE , value = "员工工种" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON , value = "离职原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE , value = "工资卡开户行" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD , value = "工资卡帐号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = PersonServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.INSERT)
	public Result insert(PersonVO personVO) {
		Result result=personService.insert(personVO,false);
		return result;
	}



	/**
	 * 删除人员信息
	*/
	@ApiOperation(value = "删除人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PersonVOMeta.ID)
	@SentinelResource(value = PersonServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = personService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=personService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = PersonVOMeta.IDS)
	@SentinelResource(value = PersonServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = personService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=personService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
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
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOY_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS , value = "员工状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE , value = "人员类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT , value = "紧急联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO , value = "紧急人电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS , value = "家庭地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID , value = "微信号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL , value = "计算机等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE , value = "血型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT , value = "身高" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT , value = "体重" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE , value = "入职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE , value = "转正日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE , value = "初次日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID , value = "员工部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE , value = "员工岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE , value = "员工职称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE , value = "员工职级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE , value = "员工工种" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON , value = "离职原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE , value = "工资卡开户行" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD , value = "工资卡帐号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE , PersonVOMeta.SEARCH_FIELD , PersonVOMeta.FUZZY_FIELD , PersonVOMeta.SEARCH_VALUE , PersonVOMeta.DIRTY_FIELDS , PersonVOMeta.SORT_FIELD , PersonVOMeta.SORT_TYPE , PersonVOMeta.IDS } )
	@SentinelResource(value = PersonServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.UPDATE)
	public Result update(PersonVO personVO) {
		Result result=personService.update(personVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员信息
	*/
	@ApiOperation(value = "保存人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOY_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS , value = "员工状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE , value = "人员类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT , value = "紧急联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO , value = "紧急人电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS , value = "家庭地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID , value = "微信号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL , value = "计算机等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE , value = "血型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT , value = "身高" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT , value = "体重" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE , value = "入职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE , value = "转正日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE , value = "初次日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID , value = "员工部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE , value = "员工岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE , value = "员工职称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE , value = "员工职级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE , value = "员工工种" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON , value = "离职原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE , value = "工资卡开户行" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD , value = "工资卡帐号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE , PersonVOMeta.SEARCH_FIELD , PersonVOMeta.FUZZY_FIELD , PersonVOMeta.SEARCH_VALUE , PersonVOMeta.DIRTY_FIELDS , PersonVOMeta.SORT_FIELD , PersonVOMeta.SORT_TYPE , PersonVOMeta.IDS } )
	@NotNull(name = PersonVOMeta.ID)
	@SentinelResource(value = PersonServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.SAVE)
	public Result save(PersonVO personVO) {
		Result result=personService.save(personVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员信息
	*/
	@ApiOperation(value = "获取人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PersonVOMeta.ID)
	@SentinelResource(value = PersonServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.GET_BY_ID)
	public Result<Person> getById(String id) {
		Result<Person> result=new Result<>();
		Person person=personService.getById(id);
		result.success(true).data(person);
		return result;
	}


	/**
	 * 批量获取人员信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = PersonVOMeta.IDS)
		@SentinelResource(value = PersonServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.GET_BY_IDS)
	public Result<List<Person>> getByIds(List<String> ids) {
		Result<List<Person>> result=new Result<>();
		List<Person> list=personService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员信息
	*/
	@ApiOperation(value = "查询人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOY_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS , value = "员工状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE , value = "人员类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT , value = "紧急联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO , value = "紧急人电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS , value = "家庭地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID , value = "微信号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL , value = "计算机等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE , value = "血型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT , value = "身高" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT , value = "体重" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE , value = "入职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE , value = "转正日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE , value = "初次日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID , value = "员工部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE , value = "员工岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE , value = "员工职称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE , value = "员工职级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE , value = "员工工种" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON , value = "离职原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE , value = "工资卡开户行" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD , value = "工资卡帐号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.QUERY_LIST)
	public Result<List<Person>> queryList(PersonVO sample) {
		Result<List<Person>> result=new Result<>();
		List<Person> list=personService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员信息
	*/
	@ApiOperation(value = "分页查询人员信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOY_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER , value = "工号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY , value = "出生日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE , value = "籍贯" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE , value = "民族" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS , value = "婚姻状况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS , value = "员工状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE , value = "人员类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD , value = "身份证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL , value = "电子邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT , value = "紧急联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO , value = "紧急人电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS , value = "家庭地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID , value = "微信号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE , value = "学历" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL , value = "毕业院校" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR , value = "所学专业" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE , value = "毕业时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE , value = "所学外语" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL , value = "外语证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY , value = "计算机能力" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL , value = "计算机等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE , value = "政治面貌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE , value = "入党时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE , value = "血型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT , value = "身高" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT , value = "体重" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE , value = "入职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE , value = "转正日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE , value = "初次日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE , value = "参加工作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID , value = "员工部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE , value = "员工岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE , value = "员工职称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE , value = "员工职级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE , value = "员工工种" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE , value = "离职日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON , value = "离职原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE , value = "工资卡开户行" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD , value = "工资卡帐号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PersonServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Person>> queryPagedList(PersonVO sample) {
		Result<PagedList<Person>> result=new Result<>();
		PagedList<Person> list=personService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}