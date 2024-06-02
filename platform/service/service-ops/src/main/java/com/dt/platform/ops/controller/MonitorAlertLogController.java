package com.dt.platform.ops.controller;

import java.util.*;

import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.meta.AssetMeta;
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
import com.dt.platform.proxy.ops.MonitorAlertLogServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorAlertLogVOMeta;
import com.dt.platform.domain.ops.MonitorAlertLog;
import com.dt.platform.domain.ops.MonitorAlertLogVO;
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
import com.dt.platform.domain.ops.meta.MonitorAlertLogMeta;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorAlertLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 告警日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 06:58:37
 */
@InDoc
@Api(tags = "告警日志")
@RestController("OpsMonitorAlertLogController")
public class MonitorAlertLogController extends SuperController {

    @Autowired
    private IMonitorAlertLogService monitorAlertLogService;

    /**
     * 添加告警日志
     */
    @ApiOperation(value = "添加告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_METHOD, value = "通知方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.MSG, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT, value = "结果明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT_STATUS, value = "通知结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_ID, value = "告警事件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertLogServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.INSERT)
    public Result insert(MonitorAlertLogVO monitorAlertLogVO) {
        Result result = monitorAlertLogService.insert(monitorAlertLogVO, false);
        return result;
    }

    /**
     * 删除告警日志
     */
    @ApiOperation(value = "删除告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertLogServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = monitorAlertLogService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = monitorAlertLogService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除告警日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertLogServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorAlertLogService.hasRefers(ids);
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
            Result result = monitorAlertLogService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorAlertLogService.deleteByIdsLogical(canDeleteIds);
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
     * 更新告警日志
     */
    @ApiOperation(value = "更新告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_METHOD, value = "通知方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.MSG, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT, value = "结果明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT_STATUS, value = "通知结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_ID, value = "告警事件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorAlertLogVOMeta.PAGE_INDEX, MonitorAlertLogVOMeta.PAGE_SIZE, MonitorAlertLogVOMeta.SEARCH_FIELD, MonitorAlertLogVOMeta.FUZZY_FIELD, MonitorAlertLogVOMeta.SEARCH_VALUE, MonitorAlertLogVOMeta.DIRTY_FIELDS, MonitorAlertLogVOMeta.SORT_FIELD, MonitorAlertLogVOMeta.SORT_TYPE, MonitorAlertLogVOMeta.DATA_ORIGIN, MonitorAlertLogVOMeta.QUERY_LOGIC, MonitorAlertLogVOMeta.REQUEST_ACTION, MonitorAlertLogVOMeta.IDS })
    @SentinelResource(value = MonitorAlertLogServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.UPDATE)
    public Result update(MonitorAlertLogVO monitorAlertLogVO) {
        Result result = monitorAlertLogService.update(monitorAlertLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存告警日志
     */
    @ApiOperation(value = "保存告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_METHOD, value = "通知方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.MSG, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT, value = "结果明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT_STATUS, value = "通知结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_ID, value = "告警事件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorAlertLogVOMeta.PAGE_INDEX, MonitorAlertLogVOMeta.PAGE_SIZE, MonitorAlertLogVOMeta.SEARCH_FIELD, MonitorAlertLogVOMeta.FUZZY_FIELD, MonitorAlertLogVOMeta.SEARCH_VALUE, MonitorAlertLogVOMeta.DIRTY_FIELDS, MonitorAlertLogVOMeta.SORT_FIELD, MonitorAlertLogVOMeta.SORT_TYPE, MonitorAlertLogVOMeta.DATA_ORIGIN, MonitorAlertLogVOMeta.QUERY_LOGIC, MonitorAlertLogVOMeta.REQUEST_ACTION, MonitorAlertLogVOMeta.IDS })
    @SentinelResource(value = MonitorAlertLogServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.SAVE)
    public Result save(MonitorAlertLogVO monitorAlertLogVO) {
        Result result = monitorAlertLogService.save(monitorAlertLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取告警日志
     */
    @ApiOperation(value = "获取告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertLogServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.GET_BY_ID)
    public Result<MonitorAlertLog> getById(String id) {
        Result<MonitorAlertLog> result = new Result<>();
        MonitorAlertLog monitorAlertLog = monitorAlertLogService.getById(id);

        monitorAlertLogService.dao().fill(monitorAlertLog).with(MonitorAlertLogMeta.SEND_USER).execute();
        monitorAlertLogService.dao().join(monitorAlertLog.getSendUser(), Person.class);
        result.success(true).data(monitorAlertLog);
        return result;
    }

    /**
     * 批量获取告警日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertLogServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.GET_BY_IDS)
    public Result<List<MonitorAlertLog>> getByIds(List<String> ids) {
        Result<List<MonitorAlertLog>> result = new Result<>();
        List<MonitorAlertLog> list = monitorAlertLogService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询告警日志
     */
    @ApiOperation(value = "查询告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_METHOD, value = "通知方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.MSG, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT, value = "结果明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT_STATUS, value = "通知结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_ID, value = "告警事件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorAlertLogVOMeta.PAGE_INDEX, MonitorAlertLogVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorAlertLogServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.QUERY_LIST)
    public Result<List<MonitorAlertLog>> queryList(MonitorAlertLogVO sample) {
        Result<List<MonitorAlertLog>> result = new Result<>();
        List<MonitorAlertLog> list = monitorAlertLogService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询告警日志
     */
    @ApiOperation(value = "分页查询告警日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_METHOD, value = "通知方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.MSG, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT, value = "结果明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.RCD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ACTION_RESULT_STATUS, value = "通知结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertLogVOMeta.ALERT_ID, value = "告警事件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertLogServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertLogServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorAlertLog>> queryPagedList(MonitorAlertLogVO sample) {
        Result<PagedList<MonitorAlertLog>> result = new Result<>();
        PagedList<MonitorAlertLog> list = monitorAlertLogService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        monitorAlertLogService.dao().fill(list).with(MonitorAlertLogMeta.SEND_USER).execute();
        List<Employee> employees = CollectorUtil.collectList(list, MonitorAlertLog::getSendUser);
        monitorAlertLogService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }
}
