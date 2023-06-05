package com.dt.platform.hr.controller;

import java.util.*;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.dt.platform.domain.hr.meta.SalaryActionVOMeta;
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
import com.dt.platform.proxy.hr.SalaryDetailServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryDetailVOMeta;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.SalaryDetailVO;
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
import com.dt.platform.domain.hr.meta.SalaryDetailMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬明细接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 13:01:46
 */
@InDoc
@Api(tags = "薪酬明细")
@RestController("HrSalaryDetailController")
public class SalaryDetailController extends SuperController {

    @Autowired
    private ISalaryDetailService salaryDetailService;

    /**
     * 添加薪酬明细
     */
    @ApiOperation(value = "添加薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK, value = "银行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK_ACCOUNT, value = "账户账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OPER_MSG, value = "操作说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.INSERT)
    public Result insert(SalaryDetailVO salaryDetailVO) {
        Result result = salaryDetailService.insert(salaryDetailVO, false);
        return result;
    }

    /**
     * 删除薪酬明细
     */
    @ApiOperation(value = "删除薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = salaryDetailService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = salaryDetailService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除薪酬明细 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = salaryDetailService.hasRefers(ids);
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
            Result result = salaryDetailService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = salaryDetailService.deleteByIdsLogical(canDeleteIds);
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
     * 更新薪酬明细
     */
    @ApiOperation(value = "更新薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK, value = "银行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK_ACCOUNT, value = "账户账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OPER_MSG, value = "操作说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryDetailVOMeta.PAGE_INDEX, SalaryDetailVOMeta.PAGE_SIZE, SalaryDetailVOMeta.SEARCH_FIELD, SalaryDetailVOMeta.FUZZY_FIELD, SalaryDetailVOMeta.SEARCH_VALUE, SalaryDetailVOMeta.DIRTY_FIELDS, SalaryDetailVOMeta.SORT_FIELD, SalaryDetailVOMeta.SORT_TYPE, SalaryDetailVOMeta.DATA_ORIGIN, SalaryDetailVOMeta.QUERY_LOGIC, SalaryDetailVOMeta.REQUEST_ACTION, SalaryDetailVOMeta.IDS })
    @SentinelResource(value = SalaryDetailServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.UPDATE)
    public Result update(SalaryDetailVO salaryDetailVO) {
        Result result = salaryDetailService.update(salaryDetailVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存薪酬明细
     */
    @ApiOperation(value = "保存薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK, value = "银行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK_ACCOUNT, value = "账户账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OPER_MSG, value = "操作说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { SalaryDetailVOMeta.PAGE_INDEX, SalaryDetailVOMeta.PAGE_SIZE, SalaryDetailVOMeta.SEARCH_FIELD, SalaryDetailVOMeta.FUZZY_FIELD, SalaryDetailVOMeta.SEARCH_VALUE, SalaryDetailVOMeta.DIRTY_FIELDS, SalaryDetailVOMeta.SORT_FIELD, SalaryDetailVOMeta.SORT_TYPE, SalaryDetailVOMeta.DATA_ORIGIN, SalaryDetailVOMeta.QUERY_LOGIC, SalaryDetailVOMeta.REQUEST_ACTION, SalaryDetailVOMeta.IDS })
    @SentinelResource(value = SalaryDetailServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.SAVE)
    public Result save(SalaryDetailVO salaryDetailVO) {
        Result result = salaryDetailService.save(salaryDetailVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取薪酬明细
     */
    @ApiOperation(value = "获取薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.GET_BY_ID)
    public Result<SalaryDetail> getById(String id) {
        Result<SalaryDetail> result = new Result<>();
        SalaryDetail salaryDetail = salaryDetailService.getById(id);
        // join 关联的对象
        salaryDetailService.dao().fill(salaryDetail).with("person").execute();
        result.success(true).data(salaryDetail);
        return result;
    }

    /**
     * 重置
     */
    @ApiOperation(value = "重置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.RESET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.RESET)
    public Result reset(String id) {
        return salaryDetailService.reset(id);
    }

    /**
     * 重置
     */
    @ApiOperation(value = "生效")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.VALID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.VALID)
    public Result valid(String actionId) {
        return salaryDetailService.valid(actionId);
    }

    /**
     * 批量获取薪酬明细 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.GET_BY_IDS)
    public Result<List<SalaryDetail>> getByIds(List<String> ids) {
        Result<List<SalaryDetail>> result = new Result<>();
        List<SalaryDetail> list = salaryDetailService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询薪酬明细
     */
    @ApiOperation(value = "查询薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK, value = "银行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK_ACCOUNT, value = "账户账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OPER_MSG, value = "操作说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryDetailVOMeta.PAGE_INDEX, SalaryDetailVOMeta.PAGE_SIZE })
    @SentinelResource(value = SalaryDetailServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.QUERY_LIST)
    public Result<List<SalaryDetail>> queryList(SalaryDetailVO sample) {
        Result<List<SalaryDetail>> result = new Result<>();
        List<SalaryDetail> list = salaryDetailService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询薪酬明细
     */
    @ApiOperation(value = "分页查询薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK, value = "银行", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BANK_ACCOUNT, value = "账户账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OPER_MSG, value = "操作说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SalaryDetail>> queryPagedList(SalaryDetailVO sample) {
        Result<PagedList<SalaryDetail>> result = new Result<>();
        PagedList<SalaryDetail> list = salaryDetailService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryDetailService.dao().fill(list).with("person").execute();
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "分页查询薪酬明细")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryDetailServiceProxy.MY_QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryDetailServiceProxy.MY_QUERY_PAGED_LIST)
    public Result<PagedList<SalaryDetail>> myQueryPagedList(SalaryDetailVO sample) {
        Result<PagedList<SalaryDetail>> result = new Result<>();
        PagedList<SalaryDetail> list = salaryDetailService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryDetailService.dao().fill(list).with("person").execute();
        result.success(true).data(list);
        return result;
    }

	@ApiOperation(value = "分页查询薪酬明细")
	@ApiImplicitParams({
			@ApiImplicitParam(name = SalaryDetailVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.DEDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PT_DKJS, value = "抵扣基数", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PT_SL_PCT, value = "税率", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PT_GRSDS, value = "个人所得税", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.TOTAL_AMOUNT, value = "合计金额", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.PAY_AMOUNT, value = "应发金额", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.ISSUED_AMOUNT, value = "实发金额", required = false, dataTypeClass = BigDecimal.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.EFFECT_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
			@ApiImplicitParam(name = SalaryDetailVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
	@ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
	@SentinelResource(value = SalaryDetailServiceProxy.ACTION_QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(SalaryDetailServiceProxy.ACTION_QUERY_PAGED_LIST)
	public Result<PagedList<SalaryDetail>> actionQueryPagedList(SalaryDetailVO sample) {

    	if(StringUtil.isBlank(sample.getActionId())){
			sample.setActionId("none");
		}
		Result<PagedList<SalaryDetail>> result = new Result<>();
		PagedList<SalaryDetail> list = salaryDetailService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
		// join 关联的对象
		salaryDetailService.dao().fill(list).with("person").execute();
		result.success(true).data(list);
		return result;
	}
}
