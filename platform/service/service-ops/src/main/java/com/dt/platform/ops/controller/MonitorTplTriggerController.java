package com.dt.platform.ops.controller;

import java.util.*;
import com.dt.platform.proxy.ops.MonitorDataProcessCalculateServerServiceProxy;
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
import com.dt.platform.proxy.ops.MonitorTplTriggerServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplTriggerVOMeta;
import com.dt.platform.domain.ops.MonitorTplTrigger;
import com.dt.platform.domain.ops.MonitorTplTriggerVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplTriggerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 触发器接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 20:49:27
 */
@InDoc
@Api(tags = "触发器")
@RestController("OpsMonitorTplTriggerController")
public class MonitorTplTriggerController extends SuperController {

    @Autowired
    private IMonitorTplTriggerService monitorTplTriggerService;

    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "收集数据")
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorTplTriggerServiceProxy.COLLECT_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.COLLECT_DATA)
    public Result collectData() {
        return monitorTplTriggerService.collectData();
    }

    /**
     * 添加触发器
     */
    @ApiOperation(value = "添加触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "762338625135312896"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NAME, value = "触发器", required = false, dataTypeClass = String.class, example = "q w"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.RULE, value = "告警规则", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.CONTENT_VALUE, value = "告警内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorTplTriggerServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.INSERT)
    public Result insert(MonitorTplTriggerVO monitorTplTriggerVO) {
        Result result = monitorTplTriggerService.insert(monitorTplTriggerVO, false);
        return result;
    }

    /**
     * 删除触发器
     */
    @ApiOperation(value = "删除触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "762338625135312896")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorTplTriggerServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = monitorTplTriggerService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = monitorTplTriggerService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除触发器 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorTplTriggerServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorTplTriggerService.hasRefers(ids);
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
            Result result = monitorTplTriggerService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorTplTriggerService.deleteByIdsLogical(canDeleteIds);
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
     * 更新触发器
     */
    @ApiOperation(value = "更新触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "762338625135312896"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NAME, value = "触发器", required = false, dataTypeClass = String.class, example = "q w"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.RULE, value = "告警规则", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.CONTENT_VALUE, value = "告警内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorTplTriggerVOMeta.PAGE_INDEX, MonitorTplTriggerVOMeta.PAGE_SIZE, MonitorTplTriggerVOMeta.SEARCH_FIELD, MonitorTplTriggerVOMeta.FUZZY_FIELD, MonitorTplTriggerVOMeta.SEARCH_VALUE, MonitorTplTriggerVOMeta.DIRTY_FIELDS, MonitorTplTriggerVOMeta.SORT_FIELD, MonitorTplTriggerVOMeta.SORT_TYPE, MonitorTplTriggerVOMeta.DATA_ORIGIN, MonitorTplTriggerVOMeta.QUERY_LOGIC, MonitorTplTriggerVOMeta.REQUEST_ACTION, MonitorTplTriggerVOMeta.IDS })
    @SentinelResource(value = MonitorTplTriggerServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.UPDATE)
    public Result update(MonitorTplTriggerVO monitorTplTriggerVO) {
        Result result = monitorTplTriggerService.update(monitorTplTriggerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存触发器
     */
    @ApiOperation(value = "保存触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "762338625135312896"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NAME, value = "触发器", required = false, dataTypeClass = String.class, example = "q w"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.RULE, value = "告警规则", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.CONTENT_VALUE, value = "告警内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplTriggerVOMeta.PAGE_INDEX, MonitorTplTriggerVOMeta.PAGE_SIZE, MonitorTplTriggerVOMeta.SEARCH_FIELD, MonitorTplTriggerVOMeta.FUZZY_FIELD, MonitorTplTriggerVOMeta.SEARCH_VALUE, MonitorTplTriggerVOMeta.DIRTY_FIELDS, MonitorTplTriggerVOMeta.SORT_FIELD, MonitorTplTriggerVOMeta.SORT_TYPE, MonitorTplTriggerVOMeta.DATA_ORIGIN, MonitorTplTriggerVOMeta.QUERY_LOGIC, MonitorTplTriggerVOMeta.REQUEST_ACTION, MonitorTplTriggerVOMeta.IDS })
    @SentinelResource(value = MonitorTplTriggerServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.SAVE)
    public Result save(MonitorTplTriggerVO monitorTplTriggerVO) {
        Result result = monitorTplTriggerService.save(monitorTplTriggerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取触发器
     */
    @ApiOperation(value = "获取触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorTplTriggerServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.GET_BY_ID)
    public Result<MonitorTplTrigger> getById(String id) {
        Result<MonitorTplTrigger> result = new Result<>();
        MonitorTplTrigger monitorTplTrigger = monitorTplTriggerService.getById(id);
        // join 关联的对象
        monitorTplTriggerService.dao().fill(monitorTplTrigger).with(MonitorTplTriggerMeta.TPL).execute();
        result.success(true).data(monitorTplTrigger);
        return result;
    }

    /**
     * 批量获取触发器 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorTplTriggerServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.GET_BY_IDS)
    public Result<List<MonitorTplTrigger>> getByIds(List<String> ids) {
        Result<List<MonitorTplTrigger>> result = new Result<>();
        List<MonitorTplTrigger> list = monitorTplTriggerService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询触发器
     */
    @ApiOperation(value = "查询触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "762338625135312896"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NAME, value = "触发器", required = false, dataTypeClass = String.class, example = "q w"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.RULE, value = "告警规则", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.CONTENT_VALUE, value = "告警内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorTplTriggerVOMeta.PAGE_INDEX, MonitorTplTriggerVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorTplTriggerServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.QUERY_LIST)
    public Result<List<MonitorTplTrigger>> queryList(MonitorTplTriggerVO sample) {
        Result<List<MonitorTplTrigger>> result = new Result<>();
        List<MonitorTplTrigger> list = monitorTplTriggerService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询触发器
     */
    @ApiOperation(value = "分页查询触发器")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "762338625135312896"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NAME, value = "触发器", required = false, dataTypeClass = String.class, example = "q w"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.WARN_LEVEL, value = "告警等级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.RULE, value = "告警规则", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.CONTENT_VALUE, value = "告警内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplTriggerVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorTplTriggerServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTriggerServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorTplTrigger>> queryPagedList(MonitorTplTriggerVO sample) {
        Result<PagedList<MonitorTplTrigger>> result = new Result<>();
        PagedList<MonitorTplTrigger> list = monitorTplTriggerService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorTplTriggerService.dao().fill(list).with(MonitorTplTriggerMeta.TPL).execute();
        result.success(true).data(list);
        return result;
    }
}
