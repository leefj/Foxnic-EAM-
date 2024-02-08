package com.dt.platform.hr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetDataExportColumnEnum;
import com.dt.platform.constants.enums.eam.AssetEquipmentStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta;
import com.dt.platform.hr.service.IPersonService;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectUnitRcdServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
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
import com.dt.platform.proxy.hr.SalaryServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryVOMeta;
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
import com.dt.platform.domain.hr.meta.SalaryMeta;
import java.math.BigDecimal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryService;
import com.github.foxnic.api.validate.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 人员薪酬接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 13:01:02
 */
@InDoc
@Api(tags = "人员薪酬")
@RestController("HrSalaryController")
public class SalaryController extends SuperController {

    @Autowired
    private ISalaryService salaryService;

    @Autowired
    private IPersonService personService;

    /**
     * 添加人员薪酬
     */
    @ApiOperation(value = "添加人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DUDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_STATUS, value = "企业专项扣除", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY_NOTES, value = "子女教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY_NOTES, value = "继续教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL_NOTES, value = "大病医疗备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK_NOTES, value = "住房贷款备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ_NOTES, value = "住房租金备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR_NOTES, value = "赡养老人备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH_NOTES, value = "幼儿照护备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.INSERT)
    public Result insert(SalaryVO salaryVO) {
        Result result = salaryService.insert(salaryVO, false);
        return result;
    }

    /**
     * 删除人员薪酬
     */
    @ApiOperation(value = "删除人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = salaryService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = salaryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除人员薪酬 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = salaryService.hasRefers(ids);
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
            Result result = salaryService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = salaryService.deleteByIdsLogical(canDeleteIds);
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
     * 更新人员薪酬
     */
    @ApiOperation(value = "更新人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DUDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_STATUS, value = "企业专项扣除", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY_NOTES, value = "子女教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY_NOTES, value = "继续教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL_NOTES, value = "大病医疗备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK_NOTES, value = "住房贷款备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ_NOTES, value = "住房租金备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR_NOTES, value = "赡养老人备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH_NOTES, value = "幼儿照护备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryVOMeta.PAGE_INDEX, SalaryVOMeta.PAGE_SIZE, SalaryVOMeta.SEARCH_FIELD, SalaryVOMeta.FUZZY_FIELD, SalaryVOMeta.SEARCH_VALUE, SalaryVOMeta.DIRTY_FIELDS, SalaryVOMeta.SORT_FIELD, SalaryVOMeta.SORT_TYPE, SalaryVOMeta.DATA_ORIGIN, SalaryVOMeta.QUERY_LOGIC, SalaryVOMeta.REQUEST_ACTION, SalaryVOMeta.IDS })
    @SentinelResource(value = SalaryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.UPDATE)
    public Result update(SalaryVO salaryVO) {
        Result result = salaryService.update(salaryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存人员薪酬
     */
    @ApiOperation(value = "保存人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DUDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_STATUS, value = "企业专项扣除", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY_NOTES, value = "子女教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY_NOTES, value = "继续教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL_NOTES, value = "大病医疗备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK_NOTES, value = "住房贷款备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ_NOTES, value = "住房租金备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR_NOTES, value = "赡养老人备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH_NOTES, value = "幼儿照护备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { SalaryVOMeta.PAGE_INDEX, SalaryVOMeta.PAGE_SIZE, SalaryVOMeta.SEARCH_FIELD, SalaryVOMeta.FUZZY_FIELD, SalaryVOMeta.SEARCH_VALUE, SalaryVOMeta.DIRTY_FIELDS, SalaryVOMeta.SORT_FIELD, SalaryVOMeta.SORT_TYPE, SalaryVOMeta.DATA_ORIGIN, SalaryVOMeta.QUERY_LOGIC, SalaryVOMeta.REQUEST_ACTION, SalaryVOMeta.IDS })
    @SentinelResource(value = SalaryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.SAVE)
    public Result save(SalaryVO salaryVO) {
        Result result = salaryService.save(salaryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取人员薪酬
     */
    @ApiOperation(value = "获取人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.GET_BY_ID)
    public Result<Salary> getById(String id) {
        Result<Salary> result = new Result<>();
        Salary salary = salaryService.getById(id);
        // join 关联的对象
        salaryService.dao().fill(salary).with("person").execute();
        result.success(true).data(salary);
        return result;
    }

    /**
     * 获取人员薪酬
     */
    @ApiOperation(value = "获取人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.GET_BY_PERSON_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.GET_BY_PERSON_ID)
    public Result<Salary> getByPersonId(String personId) {
        String id = "";
        SalaryVO vo = new SalaryVO();
        vo.setPersonId(personId);
        List<Salary> list = salaryService.queryList(vo);
        if (list.size() == 0) {
            // 创建一个
            Salary newObj = new Salary();
            id = IDGenerator.getSnowflakeIdString();
            newObj.setId(id);
            newObj.setPersonId(personId);
            salaryService.insert(newObj, true);
        } else if (list.size() == 1) {
            id = list.get(0).getId();
        } else {
            return ErrorDesc.failureMessage("有重复的数据。");
        }
        Result<Salary> result = new Result<>();
        Salary salary = salaryService.getById(id);
        // join 关联的对象
        salaryService.dao().fill(salary).with("person").execute();
        result.success(true).data(salary);
        return result;
    }

    /**
     * 获取人员薪酬
     */
    @ApiOperation(value = "获取人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.MY_GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.MY_GET_BY_ID)
    public Result<Salary> myGetById(String id) {
        Result<Salary> result = new Result<>();
        Salary salary = salaryService.getById(id);
        // join 关联的对象
        salaryService.dao().fill(salary).with("person").execute();
        result.success(true).data(salary);
        return result;
    }

    /**
     * 批量获取人员薪酬 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.GET_BY_IDS)
    public Result<List<Salary>> getByIds(List<String> ids) {
        Result<List<Salary>> result = new Result<>();
        List<Salary> list = salaryService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询人员薪酬
     */
    @ApiOperation(value = "查询人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DUDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_STATUS, value = "企业专项扣除", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY_NOTES, value = "子女教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY_NOTES, value = "继续教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL_NOTES, value = "大病医疗备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK_NOTES, value = "住房贷款备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ_NOTES, value = "住房租金备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR_NOTES, value = "赡养老人备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH_NOTES, value = "幼儿照护备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryVOMeta.PAGE_INDEX, SalaryVOMeta.PAGE_SIZE })
    @SentinelResource(value = SalaryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.QUERY_LIST)
    public Result<List<Salary>> queryList(SalaryVO sample) {
        Result<List<Salary>> result = new Result<>();
        List<Salary> list = salaryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员薪酬
     */
    @ApiOperation(value = "分页查询人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DUDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_STATUS, value = "企业专项扣除", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY_NOTES, value = "子女教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY_NOTES, value = "继续教育备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL_NOTES, value = "大病医疗备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK_NOTES, value = "住房贷款备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ_NOTES, value = "住房租金备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR_NOTES, value = "赡养老人备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH_NOTES, value = "幼儿照护备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Salary>> queryPagedList(SalaryVO sample) {
        Result<PagedList<Salary>> result = new Result<>();
        PagedList<Salary> list = salaryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryService.dao().fill(list).with("person").execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员薪酬
     */
    @ApiOperation(value = "分页查询人员薪酬")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryVOMeta.BASE_SALARY, value = "基本工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.POST_SALARY, value = "岗位工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WORKING_YEARS_SALARY, value = "工龄工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.FIXED_SALARY, value = "固定补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.ACHIEVEMENT_SALARY, value = "绩效补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OVERTIME_SALARY, value = "加班补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.OTHER_SALARY, value = "其他补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMUNICATION_SALARY, value = "通讯补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.TRAFFIC_SALARY, value = "交通补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HOUSING_SALARY, value = "住房补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.COMMISSION_SALARY, value = "提成工资", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.HIGH_TEMPERATURE_SALARY, value = "高温补贴", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_BASE, value = "住房公积金基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_PERSON, value = "住房公积金个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFARE_ZFGJJ_COMPANY, value = "住房公积金公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_BASE, value = "养老保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_PERSON, value = "养老保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YLBX_COMPANY, value = "养老保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_BASE, value = "工伤保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_PERSON, value = "工伤保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_GSBX_COMPANY, value = "工伤保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_BASE, value = "医疗保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_PERSON, value = "医疗保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_YRBX_COMPANY, value = "医疗保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_BASE, value = "生育保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_PERSON, value = "生育保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYBX_COMPANY, value = "生育保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_BASE, value = "失业保险基数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_PERSON, value = "失业保险个人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.WELFAER_SYEBX_COMPANY, value = "失业保险公司", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED, value = "个税抵扣", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_KQ, value = "扣除考勤", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DEDUCT_GH, value = "扣除工会", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.DUDUCT_OTHER, value = "扣除其他", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZNJY, value = "子女教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_JXJY, value = "继续教育", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_DBYL, value = "大病医疗", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFDK, value = "住房贷款", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ZFZJ, value = "住房租金", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_SYLR, value = "赡养老人", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryVOMeta.PERSONAL_TAX_ERZH, value = "幼儿照护", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryServiceProxy.MY_QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryServiceProxy.MY_QUERY_PAGED_LIST)
    public Result<PagedList<Salary>> queryPagedList2(SalaryVO sample) {
        String empId = SessionUser.getCurrent().getActivatedEmployeeId();
        String personId = "none";
        PersonVO vo = new PersonVO();
        vo.setEmployeeId(empId);
        List<Person> personList = personService.queryList(vo);
        if (personList.size() > 1) {
            return ErrorDesc.failureMessage("找到重复的员工配置");
        } else if (personList.size() == 1) {
            personId = personList.get(0).getId();
        }
        sample.setPersonId(personId);
        Result<PagedList<Salary>> result = new Result<>();
        PagedList<Salary> list = salaryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryService.dao().fill(list).with("person").execute();
        result.success(true).data(list);
        return result;
    }

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SalaryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SalaryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SalaryVO sample, HttpServletResponse response, String code) throws Exception {
		InputStream inputstream = salaryService.buildExcelTemplate(code);
		try{
			File f =  TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_"+code+".xls");
			SalaryVO q=new SalaryVO();
			List<Salary> list= salaryService.queryList(sample);
			salaryService.dao().fill(list).with(SalaryProjectUnitRcdMeta.PERSON).execute();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			for(int i=0;i<list.size();i++){
				Salary item=list.get(i);
				Map<String, Object> assetMap= BeanUtil.toMap(item);
				if(!StringUtil.isBlank(item.getPerson())){
					assetMap.put("userName",item.getPerson().getName());
				}
				if(!StringUtil.isBlank(item.getPerson())){
					assetMap.put("jobNumber",item.getPerson().getJobNumber());
				}
				//设备状态
				CodeTextEnum personalStatus= EnumUtil.parseByCode(StatusEnableEnum.class,item.getPersonalStatus());
				assetMap.put("personalStatusName",personalStatus==null?"":personalStatus.text());
				listMap.add(assetMap);
			}
			Map<String,Object> map=new HashMap<>();
			map.put("dataList", listMap);
			TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
			templateExportParams.setScanAllsheet(true);
			Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
			DownloadUtil.writeToOutput(response, workbook, "薪酬信息.xls");
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}

	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SalaryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SalaryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=salaryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}

	@SentinelResource(value = SalaryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SalaryServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response, String code) throws Exception {

		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors = salaryService.importExcel(input, 0, code);
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
