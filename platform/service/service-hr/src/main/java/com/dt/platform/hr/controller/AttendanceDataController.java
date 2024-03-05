package com.dt.platform.hr.controller;

import java.math.BigDecimal;
import java.util.*;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.hr.AttendanceDataServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceDataVOMeta;
import com.dt.platform.domain.hr.AttendanceData;
import com.dt.platform.domain.hr.AttendanceDataVO;
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
import com.dt.platform.domain.hr.meta.AttendanceDataMeta;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.AttendanceTpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤汇总接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 15:02:21
 */
@InDoc
@Api(tags = "考勤汇总")
@RestController("HrAttendanceDataController")
public class AttendanceDataController extends SuperController {

    @Autowired
    private IAttendanceDataService attendanceDataService;

    /**
     * 添加考勤汇总
     */
    @ApiOperation(value = "添加考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_TPL_CODE, value = "考勤组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE, value = "考勤日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME, value = "上班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME2, value = "最早打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME, value = "下班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME2, value = "最晚打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY, value = "迟到", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE, value = "早退", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.CC, value = "出差", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY_TIME, value = "迟到", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE_TIME, value = "早退", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_PROCESS, value = "缺卡处理", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_GZR, value = "工作日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_XXR, value = "休息日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_JJR, value = "节假日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_NJ, value = "年假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_GSJ, value = "工伤假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_CJ, value = "产假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_HJ, value = "婚假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_BJ, value = "病假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_SJ, value = "事假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_PLJ, value = "哺乳假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_TXJ, value = "调休假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.IS_WORK_DAY, value = "是否工作日", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.DAY_INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE_STR, value = "考勤日期", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_EARLY, value = "上班缺卡", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_LATE, value = "下班却卡", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NORMAL_DAY, value = "上班天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NEED_DAY, value = "应上班天数", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.INSERT)
    public Result insert(AttendanceDataVO attendanceDataVO) {
        Result result = attendanceDataService.insert(attendanceDataVO, false);
        return result;
    }

    /**
     * 删除考勤汇总
     */
    @ApiOperation(value = "删除考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = attendanceDataService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = attendanceDataService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考勤汇总 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = attendanceDataService.hasRefers(ids);
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
            Result result = attendanceDataService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = attendanceDataService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考勤汇总
     */
    @ApiOperation(value = "更新考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_TPL_CODE, value = "考勤组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE, value = "考勤日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME, value = "上班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME2, value = "最早打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME, value = "下班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME2, value = "最晚打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY, value = "迟到", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE, value = "早退", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.CC, value = "出差", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY_TIME, value = "迟到", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE_TIME, value = "早退", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_PROCESS, value = "缺卡处理", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_GZR, value = "工作日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_XXR, value = "休息日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_JJR, value = "节假日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_NJ, value = "年假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_GSJ, value = "工伤假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_CJ, value = "产假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_HJ, value = "婚假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_BJ, value = "病假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_SJ, value = "事假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_PLJ, value = "哺乳假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_TXJ, value = "调休假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.IS_WORK_DAY, value = "是否工作日", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.DAY_INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE_STR, value = "考勤日期", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_EARLY, value = "上班缺卡", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_LATE, value = "下班却卡", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NORMAL_DAY, value = "上班天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NEED_DAY, value = "应上班天数", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceDataVOMeta.PAGE_INDEX, AttendanceDataVOMeta.PAGE_SIZE, AttendanceDataVOMeta.SEARCH_FIELD, AttendanceDataVOMeta.FUZZY_FIELD, AttendanceDataVOMeta.SEARCH_VALUE, AttendanceDataVOMeta.DIRTY_FIELDS, AttendanceDataVOMeta.SORT_FIELD, AttendanceDataVOMeta.SORT_TYPE, AttendanceDataVOMeta.DATA_ORIGIN, AttendanceDataVOMeta.QUERY_LOGIC, AttendanceDataVOMeta.REQUEST_ACTION, AttendanceDataVOMeta.IDS })
    @SentinelResource(value = AttendanceDataServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.UPDATE)
    public Result update(AttendanceDataVO attendanceDataVO) {
        Result result = attendanceDataService.update(attendanceDataVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考勤汇总
     */
    @ApiOperation(value = "保存考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_TPL_CODE, value = "考勤组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE, value = "考勤日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME, value = "上班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME2, value = "最早打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME, value = "下班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME2, value = "最晚打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY, value = "迟到", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE, value = "早退", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.CC, value = "出差", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY_TIME, value = "迟到", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE_TIME, value = "早退", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_PROCESS, value = "缺卡处理", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_GZR, value = "工作日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_XXR, value = "休息日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_JJR, value = "节假日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_NJ, value = "年假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_GSJ, value = "工伤假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_CJ, value = "产假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_HJ, value = "婚假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_BJ, value = "病假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_SJ, value = "事假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_PLJ, value = "哺乳假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_TXJ, value = "调休假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.IS_WORK_DAY, value = "是否工作日", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.DAY_INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE_STR, value = "考勤日期", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_EARLY, value = "上班缺卡", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_LATE, value = "下班却卡", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NORMAL_DAY, value = "上班天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NEED_DAY, value = "应上班天数", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AttendanceDataVOMeta.PAGE_INDEX, AttendanceDataVOMeta.PAGE_SIZE, AttendanceDataVOMeta.SEARCH_FIELD, AttendanceDataVOMeta.FUZZY_FIELD, AttendanceDataVOMeta.SEARCH_VALUE, AttendanceDataVOMeta.DIRTY_FIELDS, AttendanceDataVOMeta.SORT_FIELD, AttendanceDataVOMeta.SORT_TYPE, AttendanceDataVOMeta.DATA_ORIGIN, AttendanceDataVOMeta.QUERY_LOGIC, AttendanceDataVOMeta.REQUEST_ACTION, AttendanceDataVOMeta.IDS })
    @SentinelResource(value = AttendanceDataServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.SAVE)
    public Result save(AttendanceDataVO attendanceDataVO) {
        Result result = attendanceDataService.save(attendanceDataVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考勤汇总
     */
    @ApiOperation(value = "获取考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.GET_BY_ID)
    public Result<AttendanceData> getById(String id) {
        Result<AttendanceData> result = new Result<>();
        AttendanceData attendanceData = attendanceDataService.getById(id);
        // join 关联的对象
        attendanceDataService.dao().fill(attendanceData).with(AttendanceDataMeta.PERSON).with(AttendanceDataMeta.ATTENDANCE_TPL).execute();
        result.success(true).data(attendanceData);
        return result;
    }

    /**
     * 批量获取考勤汇总 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.GET_BY_IDS)
    public Result<List<AttendanceData>> getByIds(List<String> ids) {
        Result<List<AttendanceData>> result = new Result<>();
        List<AttendanceData> list = attendanceDataService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考勤汇总
     */
    @ApiOperation(value = "查询考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_TPL_CODE, value = "考勤组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE, value = "考勤日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME, value = "上班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME2, value = "最早打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME, value = "下班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME2, value = "最晚打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY, value = "迟到", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE, value = "早退", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.CC, value = "出差", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY_TIME, value = "迟到", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE_TIME, value = "早退", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_PROCESS, value = "缺卡处理", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_GZR, value = "工作日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_XXR, value = "休息日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_JJR, value = "节假日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_NJ, value = "年假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_GSJ, value = "工伤假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_CJ, value = "产假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_HJ, value = "婚假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_BJ, value = "病假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_SJ, value = "事假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_PLJ, value = "哺乳假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_TXJ, value = "调休假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.IS_WORK_DAY, value = "是否工作日", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.DAY_INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE_STR, value = "考勤日期", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_EARLY, value = "上班缺卡", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_LATE, value = "下班却卡", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NORMAL_DAY, value = "上班天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NEED_DAY, value = "应上班天数", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceDataVOMeta.PAGE_INDEX, AttendanceDataVOMeta.PAGE_SIZE })
    @SentinelResource(value = AttendanceDataServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.QUERY_LIST)
    public Result<List<AttendanceData>> queryList(AttendanceDataVO sample) {
        Result<List<AttendanceData>> result = new Result<>();
        List<AttendanceData> list = attendanceDataService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考勤汇总
     */
    @ApiOperation(value = "分页查询考勤汇总")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_TPL_CODE, value = "考勤组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE, value = "考勤日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME, value = "上班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ON_WORK_TIME2, value = "最早打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME, value = "下班打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.OFF_WORK_TIME2, value = "最晚打卡", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY, value = "迟到", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE, value = "早退", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.CC, value = "出差", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_EARLY_TIME, value = "迟到", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LEAVE_LATE_TIME, value = "早退", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_PROCESS, value = "缺卡处理", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_GZR, value = "工作日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_XXR, value = "休息日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.JB_JJR, value = "节假日加班", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_NJ, value = "年假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_GSJ, value = "工伤假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_CJ, value = "产假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_HJ, value = "婚假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_BJ, value = "病假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_SJ, value = "事假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_PLJ, value = "哺乳假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.QJ_TXJ, value = "调休假", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.IS_WORK_DAY, value = "是否工作日", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.DAY_INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.ATTENDANCE_DATE_STR, value = "考勤日期", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_EARLY, value = "上班缺卡", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AttendanceDataVOMeta.LOSS_LATE, value = "下班却卡", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NORMAL_DAY, value = "上班天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceDataVOMeta.NEED_DAY, value = "应上班天数", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AttendanceData>> queryPagedList(AttendanceDataVO sample) {
        Result<PagedList<AttendanceData>> result = new Result<>();
        PagedList<AttendanceData> list = attendanceDataService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        attendanceDataService.dao().fill(list).with(AttendanceDataMeta.PERSON).with(AttendanceDataMeta.ATTENDANCE_TPL).execute();
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "按月查询考勤数据")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.QUERY_ABNORMAL_DATA_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.QUERY_ABNORMAL_DATA_PAGED_LIST)
    public Result<PagedList<AttendanceData>> queryAbnormalPagedList(AttendanceDataVO sample) {
		Result<PagedList<AttendanceData>> result = new Result<>();
		ConditionExpr expr=new ConditionExpr();
		expr.and("normal_day<>need_day");
		PagedList<AttendanceData> list = attendanceDataService.queryPagedList(sample, expr,sample.getPageSize(), sample.getPageIndex());
		// join 关联的对象
		attendanceDataService.dao().fill(list).with(AttendanceDataMeta.PERSON).with(AttendanceDataMeta.ATTENDANCE_TPL).execute();
		result.success(true).data(list);
		return result;
    }

    @ApiOperation(value = "查询考勤日历")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.QUERY_DATA_FOR_CAL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.QUERY_DATA_FOR_CAL)
    public Result queryDataForCal(String type, String startStr, String endStr) {
        String userId = SessionUser.getCurrent().getActivatedEmployeeId();
        String personId = PersonServiceProxy.api().queryPersonIdByEmployeeId(userId);
        return attendanceDataService.queryDataForCal(type, personId, startStr, endStr);
    }

    @ApiOperation(value = "查询考勤异常数据")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.QUERY_MONTH_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.QUERY_MONTH_PAGED_LIST)
    public Result<PagedList<AttendanceData>> queryMonthPagedList(String type, AttendanceDataVO sample) {
        Result<PagedList<AttendanceData>> result = new Result<>();
        PagedList<AttendanceData> list = attendanceDataService.queryMonthPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        attendanceDataService.dao().fill(list).with(AttendanceDataMeta.PERSON).with(AttendanceDataMeta.ATTENDANCE_TPL).execute();
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "处理原始考勤数据")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDataServiceProxy.PROCESS_SOURCE_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDataServiceProxy.PROCESS_SOURCE_DATA)
    public Result processSourceData(String datestr, String groupCode) {
        return attendanceDataService.processSourceData(datestr,groupCode);
    }
}
