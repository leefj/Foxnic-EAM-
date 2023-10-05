package com.dt.platform.ops.controller;

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
import com.dt.platform.proxy.ops.MonitorAlertServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorAlertVOMeta;
import com.dt.platform.domain.ops.MonitorAlert;
import com.dt.platform.domain.ops.MonitorAlertVO;
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
import com.dt.platform.domain.ops.meta.MonitorAlertMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplTrigger;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorAlertService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 监控告警接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 15:45:56
 */
@InDoc
@Api(tags = "监控告警")
@RestController("OpsMonitorAlertController")
public class MonitorAlertController extends SuperController {

    @Autowired
    private IMonitorAlertService monitorAlertService;

    /**
     * 添加监控告警
     */
    @ApiOperation(value = "添加监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_ID, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_NAME, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_RULE_DESC, value = "规则描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.ALERT_VALUE, value = "监控数值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_TIME, value = "告警时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.HANDLED_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.PROCESS_MESSAGE, value = "处理内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_SHOW_NAME, value = "节点", required = false, dataTypeClass = String.class, example = "Demo_MySQL(121.43.103.102)")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.INSERT)
    public Result insert(MonitorAlertVO monitorAlertVO) {
        Result result = monitorAlertService.insert(monitorAlertVO, false);
        return result;
    }

    /**
     * 删除监控告警
     */
    @ApiOperation(value = "删除监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = monitorAlertService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = monitorAlertService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除监控告警 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorAlertService.hasRefers(ids);
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
            Result result = monitorAlertService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorAlertService.deleteByIdsLogical(canDeleteIds);
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
     * 更新监控告警
     */
    @ApiOperation(value = "更新监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_ID, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_NAME, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_RULE_DESC, value = "规则描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.ALERT_VALUE, value = "监控数值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_TIME, value = "告警时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.HANDLED_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.PROCESS_MESSAGE, value = "处理内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_SHOW_NAME, value = "节点", required = false, dataTypeClass = String.class, example = "Demo_MySQL(121.43.103.102)")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorAlertVOMeta.PAGE_INDEX, MonitorAlertVOMeta.PAGE_SIZE, MonitorAlertVOMeta.SEARCH_FIELD, MonitorAlertVOMeta.FUZZY_FIELD, MonitorAlertVOMeta.SEARCH_VALUE, MonitorAlertVOMeta.DIRTY_FIELDS, MonitorAlertVOMeta.SORT_FIELD, MonitorAlertVOMeta.SORT_TYPE, MonitorAlertVOMeta.DATA_ORIGIN, MonitorAlertVOMeta.QUERY_LOGIC, MonitorAlertVOMeta.REQUEST_ACTION, MonitorAlertVOMeta.IDS })
    @SentinelResource(value = MonitorAlertServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.UPDATE)
    public Result update(MonitorAlertVO monitorAlertVO) {
        Result result = monitorAlertService.update(monitorAlertVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存监控告警
     */
    @ApiOperation(value = "保存监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_ID, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_NAME, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_RULE_DESC, value = "规则描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.ALERT_VALUE, value = "监控数值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_TIME, value = "告警时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.HANDLED_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.PROCESS_MESSAGE, value = "处理内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_SHOW_NAME, value = "节点", required = false, dataTypeClass = String.class, example = "Demo_MySQL(121.43.103.102)")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorAlertVOMeta.PAGE_INDEX, MonitorAlertVOMeta.PAGE_SIZE, MonitorAlertVOMeta.SEARCH_FIELD, MonitorAlertVOMeta.FUZZY_FIELD, MonitorAlertVOMeta.SEARCH_VALUE, MonitorAlertVOMeta.DIRTY_FIELDS, MonitorAlertVOMeta.SORT_FIELD, MonitorAlertVOMeta.SORT_TYPE, MonitorAlertVOMeta.DATA_ORIGIN, MonitorAlertVOMeta.QUERY_LOGIC, MonitorAlertVOMeta.REQUEST_ACTION, MonitorAlertVOMeta.IDS })
    @SentinelResource(value = MonitorAlertServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.SAVE)
    public Result save(MonitorAlertVO monitorAlertVO) {
        Result result = monitorAlertService.save(monitorAlertVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取监控告警
     */
    @ApiOperation(value = "获取监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.GET_BY_ID)
    public Result<MonitorAlert> getById(String id) {
        Result<MonitorAlert> result = new Result<>();
        MonitorAlert monitorAlert = monitorAlertService.getById(id);
        // join 关联的对象
        monitorAlertService.dao().fill(monitorAlert).with("user").execute();
        result.success(true).data(monitorAlert);
        return result;
    }

    /**
     * 批量获取监控告警 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.GET_BY_IDS)
    public Result<List<MonitorAlert>> getByIds(List<String> ids) {
        Result<List<MonitorAlert>> result = new Result<>();
        List<MonitorAlert> list = monitorAlertService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询监控告警
     */
    @ApiOperation(value = "查询监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_ID, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_NAME, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_RULE_DESC, value = "规则描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.ALERT_VALUE, value = "监控数值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_TIME, value = "告警时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.HANDLED_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.PROCESS_MESSAGE, value = "处理内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_SHOW_NAME, value = "节点", required = false, dataTypeClass = String.class, example = "Demo_MySQL(121.43.103.102)")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorAlertVOMeta.PAGE_INDEX, MonitorAlertVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorAlertServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.QUERY_LIST)
    public Result<List<MonitorAlert>> queryList(MonitorAlertVO sample) {
        Result<List<MonitorAlert>> result = new Result<>();
        List<MonitorAlert> list = monitorAlertService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询监控告警
     */
    @ApiOperation(value = "分页查询监控告警")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_ID, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_NAME, value = "触发器", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.TRIGGER_RULE_DESC, value = "规则描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.ALERT_VALUE, value = "监控数值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.WARN_TIME, value = "告警时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.HANDLED_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.PROCESS_MESSAGE, value = "处理内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertVOMeta.NODE_SHOW_NAME, value = "节点", required = false, dataTypeClass = String.class, example = "Demo_MySQL(121.43.103.102)")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorAlert>> queryPagedList(MonitorAlertVO sample) {
        Result<PagedList<MonitorAlert>> result = new Result<>();
        PagedList<MonitorAlert> list = monitorAlertService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorAlertService.dao().fill(list).with("user").execute();
        result.success(true).data(list);
        return result;
    }
}
