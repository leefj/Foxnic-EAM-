package com.dt.platform.hr.controller;

import java.io.File;
import java.math.BigDecimal;

import java.util.*;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.hr.EmployeeStatusEnum;
import com.dt.platform.domain.eam.AssetCollection;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.hr.SalaryServiceProxy;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.dt.platform.domain.hr.meta.PersonVOMeta;
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
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonService;
import com.github.foxnic.api.validate.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 人员信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:01
 */
@InDoc
@Api(tags = "人员信息")
@RestController("HrPersonController")
public class PersonController extends SuperController {

    @Autowired
    private IPersonService personService;

    /**
     * 添加人员信息
     */
    @ApiOperation(value = "添加人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_TPL_ID, value = "薪酬模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_PAY_OUT, value = "是否发放", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_NOTES, value = "薪酬备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = PersonVOMeta.SCORE, value = "积分", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.YEAR_DAYS, value = "年假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonVOMeta.ATTENDANCE_TPL_CODE, value = "考勤模版", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.INSERT)
    public Result insert(PersonVO personVO) {
        Result result = personService.insert(personVO, false);
        return result;
    }

    /**
     * 删除人员信息
     */
    @ApiOperation(value = "删除人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除人员信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personService.hasRefers(ids);
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
            return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0).addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(), (e) -> {
                return e.hasRefer();
            }), ReferCause::message, String.class)).messageLevel4Confirm();
        } else if (canDeleteIds.size() == ids.size()) {
            // 如果全部可以删除
            Result result = personService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personService.deleteByIdsLogical(canDeleteIds);
            if (result.failure()) {
                return result;
            } else {
                return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size()).addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(), (e) -> {
                    return e.hasRefer();
                }), ReferCause::message, String.class)).messageLevel4Confirm();
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
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_TPL_ID, value = "薪酬模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_PAY_OUT, value = "是否发放", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_NOTES, value = "薪酬备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = PersonVOMeta.SCORE, value = "积分", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.YEAR_DAYS, value = "年假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonVOMeta.ATTENDANCE_TPL_CODE, value = "考勤模版", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonVOMeta.PAGE_INDEX, PersonVOMeta.PAGE_SIZE, PersonVOMeta.SEARCH_FIELD, PersonVOMeta.FUZZY_FIELD, PersonVOMeta.SEARCH_VALUE, PersonVOMeta.DIRTY_FIELDS, PersonVOMeta.SORT_FIELD, PersonVOMeta.SORT_TYPE, PersonVOMeta.DATA_ORIGIN, PersonVOMeta.QUERY_LOGIC, PersonVOMeta.REQUEST_ACTION, PersonVOMeta.IDS })
    @SentinelResource(value = PersonServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.UPDATE)
    public Result update(PersonVO personVO) {
        Result result = personService.update(personVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存人员信息
     */
    @ApiOperation(value = "保存人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_TPL_ID, value = "薪酬模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_PAY_OUT, value = "是否发放", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_NOTES, value = "薪酬备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = PersonVOMeta.SCORE, value = "积分", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.YEAR_DAYS, value = "年假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonVOMeta.ATTENDANCE_TPL_CODE, value = "考勤模版", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonVOMeta.PAGE_INDEX, PersonVOMeta.PAGE_SIZE, PersonVOMeta.SEARCH_FIELD, PersonVOMeta.FUZZY_FIELD, PersonVOMeta.SEARCH_VALUE, PersonVOMeta.DIRTY_FIELDS, PersonVOMeta.SORT_FIELD, PersonVOMeta.SORT_TYPE, PersonVOMeta.DATA_ORIGIN, PersonVOMeta.QUERY_LOGIC, PersonVOMeta.REQUEST_ACTION, PersonVOMeta.IDS })
    @SentinelResource(value = PersonServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.SAVE)
    public Result save(PersonVO personVO) {
        Result result = personService.save(personVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取人员信息
     */
    @ApiOperation(value = "获取人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.GET_BY_ID)
    public Result<Person> getById(String id) {
        Result<Person> result = new Result<>();
        Person person = personService.getById(id);
        // join 关联的对象
        personService.dao().fill(person).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        result.success(true).data(person);
        return result;
    }

    /**
     * 获取人员ID
     */
    @ApiOperation(value = "获取人员ID")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.QUERY_PERSON_ID_BY_EMPLOYEE_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_PERSON_ID_BY_EMPLOYEE_ID)
    public String queryPersonIdByEmployeeId(String employeeId) {
        return personService.queryPersonIdByEmployeeId(employeeId);
    }

    /**
     * 获取人员报表数据
     */
    @ApiOperation(value = "获取人员报表数据")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.QUERY_REPORT_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_REPORT_DATA)
    public Result<JSONObject> queryReportData(String labels) {
        return personService.queryReportData(labels);
    }

    /**
     * 批量获取人员信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.GET_BY_IDS)
    public Result<List<Person>> getByIds(List<String> ids) {
        Result<List<Person>> result = new Result<>();
        List<Person> list = personService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询人员信息
     */
    @ApiOperation(value = "查询人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_TPL_ID, value = "薪酬模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_PAY_OUT, value = "是否发放", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_NOTES, value = "薪酬备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = PersonVOMeta.SCORE, value = "积分", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.YEAR_DAYS, value = "年假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonVOMeta.ATTENDANCE_TPL_CODE, value = "考勤模版", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonVOMeta.PAGE_INDEX, PersonVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_LIST)
    public Result<List<Person>> queryList(PersonVO sample) {
        Result<List<Person>> result = new Result<>();
        List<Person> list = personService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员信息
     */
    @ApiOperation(value = "分页查询人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_TPL_ID, value = "薪酬模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_PAY_OUT, value = "是否发放", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_NOTES, value = "薪酬备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = PersonVOMeta.SCORE, value = "积分", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.YEAR_DAYS, value = "年假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonVOMeta.ATTENDANCE_TPL_CODE, value = "考勤模版", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Person>> queryPagedList(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        PagedList<Person> list = personService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "查询参数")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.QUERY_OPER_PARAMETER_VALUE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_OPER_PARAMETER_VALUE)
    public String queryOperParameterValue(String code) {
        return personService.queryOperParameterValue(code);
    }

    @ApiOperation(value = "分页查询人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_TPL_ID, value = "薪酬模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_PAY_OUT, value = "是否发放", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.SALARY_NOTES, value = "薪酬备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.JOBNUMBER_DIFF_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.JOBNUMBER_DIFF_LIST)
    public Result<PagedList<Person>> jobnumber_diff_list(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("job_number in (select a.job_number from hr_person a,hrm_employee b where a.employee_id=b.id and a.job_number<>b.badge)");
        PagedList<Person> list = personService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "分页查询人员信息")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.PERSON_ACCOUNT_REPEAT_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.PERSON_ACCOUNT_REPEAT_LIST)
    public Result<PagedList<Person>> person_account_repeat_list(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("employee_id not in (select employee_id from (select employee_id,count(1) cnt from hr_person a where deleted=0 and employee_id is not null group by employee_id having cnt>1) ti)");
        PagedList<Person> list = personService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "分页查询人员信息")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.PERSON_JN_REPEAT_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.PERSON_JN_REPEAT_LIST)
    public Result<PagedList<Person>> person_jn_repeat_list(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("job_number in ( select job_number from (select job_number,count(1) cnt from hr_person where deleted=0 group by job_number having cnt>1) ti )");
        PagedList<Person> list = personService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "分页查询人员信息")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.PERSON_NO_SALARY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.PERSON_NO_SALARY_LIST)
    public Result<PagedList<Person>> person_no_salary_list(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("salary_tpl_id not in (select id from hr_salary_tpl where deleted=0)");
        PagedList<Person> list = personService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "分页查询人员信息")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.PERSON_NOT_ACCOUNT_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.PERSON_NOT_ACCOUNT_LIST)
    public Result<PagedList<Person>> person_not_account_list(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("employee_id is null ");
        PagedList<Person> list = personService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员信息
     */
    @ApiOperation(value = "分页查询人员信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717036378466025472"),
		@ApiImplicitParam(name = PersonVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PersonVOMeta.SEX_CODE, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BIRTHDAY, value = "出生日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NATIVE_PLACE_CODE, value = "籍贯", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NATION_CODE, value = "民族", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MARITAL_STATUS, value = "婚姻状况", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_STATUS, value = "员工状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_IDENTITY_STATUS, value = "员工标记", required = false, dataTypeClass = String.class, example = "formal"),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TYPE_CODE, value = "人员类型", required = false, dataTypeClass = String.class, example = "contract_worker"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY_CARD, value = "身份证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMAIL, value = "电子邮件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMERGENCY_CONTACT_NO, value = "紧急人电话", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.HOME_ADDRESS, value = "家庭地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WEIXIN_ID, value = "微信号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EDUCATION_CODE, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_SCHOOL, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.MAJOR, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.GRADUATION_DATE, value = "毕业时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE, value = "所学外语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.FOREIGN_LANGUAGE_LEVEL, value = "外语证书", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_ABILITY, value = "计算机能力", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.COMPUTER_LEVEL, value = "计算机等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POLITIC_COUNTENANCE_CODE, value = "政治面貌", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.JOIN_PART_DATE, value = "入党时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.BLOOD_TYPE, value = "血型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_HEIGHT, value = "身高", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.BODY_WEIGHT, value = "体重", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_DATE, value = "入职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYMENT_CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_EMPLOYMENT_DATE, value = "初次日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.FIRST_WORK_DATE, value = "参加工作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.ORG_ID, value = "员工部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.POSITION_CODE, value = "员工岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_TITLE_CODE, value = "员工职称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.RANK_CODE, value = "员工职级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.WORK_KIND_CODE, value = "员工工种", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_DATE, value = "离职日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.LEAVE_RESON, value = "离职原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD_BANK_CODE, value = "工资卡开户行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PAYROLL_CARD, value = "工资卡帐号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_PICTURE_ID, value = "照片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.EMPLOYEE_ID, value = "员工", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = PersonVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_DURATION, value = "合同周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_START_DATE, value = "合同开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.CONTRACT_FINISH_DATE, value = "合同结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonServiceProxy.EMPLOYEE_FILE_NOT_QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.EMPLOYEE_FILE_NOT_QUERY_PAGED_LIST)
    public Result<PagedList<Person>> queryPagedList2(PersonVO sample) {
        String empId = SessionUser.getCurrent().getActivatedEmployeeId();
        String personId = "none";
        PersonVO vo = new PersonVO();
        vo.setEmployeeId(empId);
        List<Person> personList = personService.queryList(vo);
        if (personList.size() > 1) {
            return ErrorDesc.failureMessage("员工配置重复");
        } else if (personList.size() == 1) {
            personId = personList.get(0).getId();
        }
        sample.setId(personId);
        Result<PagedList<Person>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("id not in (select user_id from hr_person_file where deleted=0 and status='using')");
        sample.setEmployeeStatus(EmployeeStatusEnum.ONLINE.code());
        PagedList<Person> list = personService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with("employee").with(PersonMeta.ATTENDANCE_TPL).with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
        List<Employee> employee = CollectorUtil.collectList(list, Person::getEmployee);
        personService.dao().join(employee, org.github.foxnic.web.domain.hrm.Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = PersonServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(PersonServiceProxy.EXPORT_EXCEL)
    public void exportExcel(PersonVO sample, HttpServletResponse response, String code) throws Exception {
        InputStream inputstream = personService.buildExcelTemplate(code);
        try {
            File f = TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_" + code + ".xls");
            PersonVO q = new PersonVO();
            List<Person> list = personService.queryList(sample);
            personService.dao().fill(list).with("employee").with(PersonMeta.SALARY).with(PersonMeta.BANK).with(PersonMeta.SALARY_TPL).with(PersonMeta.POSITION).with(PersonMeta.PROFESSIONAL_LEVEL).with(PersonMeta.RANK).with(PersonMeta.EMPLOYEE_IDENTITY).with(PersonMeta.EDUCATION_DATA).with(PersonMeta.BLOOD_TYPE_DICT).with(PersonMeta.SEX_DICT).with(PersonMeta.MARITAL_STATUS_DICT).with(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT).with(PersonMeta.POLITIC_COUNTENANCE_DATA).execute();
            Map<String, Object> map = personService.queryPersonMap(list);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            DownloadUtil.writeToOutput(response, workbook, "人员信息.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = PersonServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(PersonServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = personService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = PersonServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response, String code) throws Exception {
        // 获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input = null;
        for (MultipartFile mf : map.values()) {
            input = StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if (input == null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = personService.importExcel(input, 0, code);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            Logger.info("import Result:");
            String msg = "导入失败";
            for (int i = 0; i < errors.size(); i++) {
                Logger.info(i + ":" + errors.get(i).message);
                msg = errors.get(i).message;
            }
            return ErrorDesc.failure().message(msg).data(errors);
        }
    }
}
