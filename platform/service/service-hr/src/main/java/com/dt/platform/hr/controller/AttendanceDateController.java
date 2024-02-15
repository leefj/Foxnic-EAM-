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
import com.dt.platform.proxy.hr.AttendanceDateServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceDateVOMeta;
import com.dt.platform.domain.hr.AttendanceDate;
import com.dt.platform.domain.hr.AttendanceDateVO;
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
import com.dt.platform.domain.hr.meta.AttendanceDateMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceDateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤日期接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 09:11:25
 */
@InDoc
@Api(tags = "考勤日期")
@RestController("HrAttendanceDateController")
public class AttendanceDateController extends SuperController {

    @Autowired
    private IAttendanceDateService attendanceDateService;

    /**
     * 添加考勤日期
     */
    @ApiOperation(value = "添加考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "810437906505138176"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.YEAR, value = "年份", required = false, dataTypeClass = String.class, example = "2024"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.DATE_STR, value = "日期", required = false, dataTypeClass = String.class, example = "2024-01-02"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.WEEK, value = "周", required = false, dataTypeClass = String.class, example = "w1"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.HOLIDAY, value = "节日", required = false, dataTypeClass = String.class, example = "春节"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.ATTENDANC_SIGN, value = "考勤签到", required = false, dataTypeClass = String.class, example = "yes"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDateVOMeta.STATUTORY_HOLIDAY, value = "法定假日", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDateServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.INSERT)
    public Result insert(AttendanceDateVO attendanceDateVO) {
        Result result = attendanceDateService.insert(attendanceDateVO, false);
        return result;
    }

    /**
     * 删除考勤日期
     */
    @ApiOperation(value = "删除考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "810437906505138176")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDateServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = attendanceDateService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = attendanceDateService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考勤日期 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDateServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = attendanceDateService.hasRefers(ids);
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
            Result result = attendanceDateService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = attendanceDateService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考勤日期
     */
    @ApiOperation(value = "更新考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "810437906505138176"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.YEAR, value = "年份", required = false, dataTypeClass = String.class, example = "2024"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.DATE_STR, value = "日期", required = false, dataTypeClass = String.class, example = "2024-01-02"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.WEEK, value = "周", required = false, dataTypeClass = String.class, example = "w1"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.HOLIDAY, value = "节日", required = false, dataTypeClass = String.class, example = "春节"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.ATTENDANC_SIGN, value = "考勤签到", required = false, dataTypeClass = String.class, example = "yes"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDateVOMeta.STATUTORY_HOLIDAY, value = "法定假日", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceDateVOMeta.PAGE_INDEX, AttendanceDateVOMeta.PAGE_SIZE, AttendanceDateVOMeta.SEARCH_FIELD, AttendanceDateVOMeta.FUZZY_FIELD, AttendanceDateVOMeta.SEARCH_VALUE, AttendanceDateVOMeta.DIRTY_FIELDS, AttendanceDateVOMeta.SORT_FIELD, AttendanceDateVOMeta.SORT_TYPE, AttendanceDateVOMeta.DATA_ORIGIN, AttendanceDateVOMeta.QUERY_LOGIC, AttendanceDateVOMeta.REQUEST_ACTION, AttendanceDateVOMeta.IDS })
    @SentinelResource(value = AttendanceDateServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.UPDATE)
    public Result update(AttendanceDateVO attendanceDateVO) {
        Result result = attendanceDateService.update(attendanceDateVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考勤日期
     */
    @ApiOperation(value = "保存考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "810437906505138176"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.YEAR, value = "年份", required = false, dataTypeClass = String.class, example = "2024"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.DATE_STR, value = "日期", required = false, dataTypeClass = String.class, example = "2024-01-02"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.WEEK, value = "周", required = false, dataTypeClass = String.class, example = "w1"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.HOLIDAY, value = "节日", required = false, dataTypeClass = String.class, example = "春节"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.ATTENDANC_SIGN, value = "考勤签到", required = false, dataTypeClass = String.class, example = "yes"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDateVOMeta.STATUTORY_HOLIDAY, value = "法定假日", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AttendanceDateVOMeta.PAGE_INDEX, AttendanceDateVOMeta.PAGE_SIZE, AttendanceDateVOMeta.SEARCH_FIELD, AttendanceDateVOMeta.FUZZY_FIELD, AttendanceDateVOMeta.SEARCH_VALUE, AttendanceDateVOMeta.DIRTY_FIELDS, AttendanceDateVOMeta.SORT_FIELD, AttendanceDateVOMeta.SORT_TYPE, AttendanceDateVOMeta.DATA_ORIGIN, AttendanceDateVOMeta.QUERY_LOGIC, AttendanceDateVOMeta.REQUEST_ACTION, AttendanceDateVOMeta.IDS })
    @SentinelResource(value = AttendanceDateServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.SAVE)
    public Result save(AttendanceDateVO attendanceDateVO) {
        Result result = attendanceDateService.save(attendanceDateVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考勤日期
     */
    @ApiOperation(value = "获取考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDateServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.GET_BY_ID)
    public Result<AttendanceDate> getById(String id) {
        Result<AttendanceDate> result = new Result<>();
        AttendanceDate attendanceDate = attendanceDateService.getById(id);
        result.success(true).data(attendanceDate);
        return result;
    }

    /**
     * 批量获取考勤日期 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDateServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.GET_BY_IDS)
    public Result<List<AttendanceDate>> getByIds(List<String> ids) {
        Result<List<AttendanceDate>> result = new Result<>();
        List<AttendanceDate> list = attendanceDateService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考勤日期
     */
    @ApiOperation(value = "查询考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "810437906505138176"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.YEAR, value = "年份", required = false, dataTypeClass = String.class, example = "2024"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.DATE_STR, value = "日期", required = false, dataTypeClass = String.class, example = "2024-01-02"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.WEEK, value = "周", required = false, dataTypeClass = String.class, example = "w1"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.HOLIDAY, value = "节日", required = false, dataTypeClass = String.class, example = "春节"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.ATTENDANC_SIGN, value = "考勤签到", required = false, dataTypeClass = String.class, example = "yes"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDateVOMeta.STATUTORY_HOLIDAY, value = "法定假日", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceDateVOMeta.PAGE_INDEX, AttendanceDateVOMeta.PAGE_SIZE })
    @SentinelResource(value = AttendanceDateServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.QUERY_LIST)
    public Result<List<AttendanceDate>> queryList(AttendanceDateVO sample) {
        Result<List<AttendanceDate>> result = new Result<>();
        List<AttendanceDate> list = attendanceDateService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考勤日期
     */
    @ApiOperation(value = "分页查询考勤日期")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "810437906505138176"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.YEAR, value = "年份", required = false, dataTypeClass = String.class, example = "2024"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.DATE_STR, value = "日期", required = false, dataTypeClass = String.class, example = "2024-01-02"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.WEEK, value = "周", required = false, dataTypeClass = String.class, example = "w1"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.HOLIDAY, value = "节日", required = false, dataTypeClass = String.class, example = "春节"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.ATTENDANC_SIGN, value = "考勤签到", required = false, dataTypeClass = String.class, example = "yes"),
		@ApiImplicitParam(name = AttendanceDateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceDateVOMeta.STATUTORY_HOLIDAY, value = "法定假日", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceDateServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceDateServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AttendanceDate>> queryPagedList(AttendanceDateVO sample) {
        Result<PagedList<AttendanceDate>> result = new Result<>();
        PagedList<AttendanceDate> list = attendanceDateService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
