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
import com.dt.platform.proxy.ops.MonitorAlertMethodServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorAlertMethodVOMeta;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import com.dt.platform.domain.ops.MonitorAlertMethodVO;
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
import com.dt.platform.domain.ops.meta.MonitorAlertMethodMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorAlertMethodService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 告警方式接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 07:43:20
 */
@InDoc
@Api(tags = "告警方式")
@RestController("OpsMonitorAlertMethodController")
public class MonitorAlertMethodController extends SuperController {

    @Autowired
    private IMonitorAlertMethodService monitorAlertMethodService;

    /**
     * 添加告警方式
     */
    @ApiOperation(value = "添加告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "脚本"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.PS, value = "参数", required = false, dataTypeClass = String.class, example = "{}"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.CMD, value = "命令", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.BODY, value = "内容", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NAME, value = "name", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertMethodServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.INSERT)
    public Result insert(MonitorAlertMethodVO monitorAlertMethodVO) {
        Result result = monitorAlertMethodService.insert(monitorAlertMethodVO, false);
        return result;
    }

    /**
     * 删除告警方式
     */
    @ApiOperation(value = "删除告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertMethodServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = monitorAlertMethodService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = monitorAlertMethodService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除告警方式 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertMethodServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorAlertMethodService.hasRefers(ids);
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
            Result result = monitorAlertMethodService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorAlertMethodService.deleteByIdsLogical(canDeleteIds);
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
     * 更新告警方式
     */
    @ApiOperation(value = "更新告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "脚本"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.PS, value = "参数", required = false, dataTypeClass = String.class, example = "{}"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.CMD, value = "命令", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.BODY, value = "内容", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NAME, value = "name", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorAlertMethodVOMeta.PAGE_INDEX, MonitorAlertMethodVOMeta.PAGE_SIZE, MonitorAlertMethodVOMeta.SEARCH_FIELD, MonitorAlertMethodVOMeta.FUZZY_FIELD, MonitorAlertMethodVOMeta.SEARCH_VALUE, MonitorAlertMethodVOMeta.DIRTY_FIELDS, MonitorAlertMethodVOMeta.SORT_FIELD, MonitorAlertMethodVOMeta.SORT_TYPE, MonitorAlertMethodVOMeta.DATA_ORIGIN, MonitorAlertMethodVOMeta.QUERY_LOGIC, MonitorAlertMethodVOMeta.REQUEST_ACTION, MonitorAlertMethodVOMeta.IDS })
    @SentinelResource(value = MonitorAlertMethodServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.UPDATE)
    public Result update(MonitorAlertMethodVO monitorAlertMethodVO) {
        Result result = monitorAlertMethodService.update(monitorAlertMethodVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存告警方式
     */
    @ApiOperation(value = "保存告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "脚本"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.PS, value = "参数", required = false, dataTypeClass = String.class, example = "{}"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.CMD, value = "命令", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.BODY, value = "内容", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NAME, value = "name", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorAlertMethodVOMeta.PAGE_INDEX, MonitorAlertMethodVOMeta.PAGE_SIZE, MonitorAlertMethodVOMeta.SEARCH_FIELD, MonitorAlertMethodVOMeta.FUZZY_FIELD, MonitorAlertMethodVOMeta.SEARCH_VALUE, MonitorAlertMethodVOMeta.DIRTY_FIELDS, MonitorAlertMethodVOMeta.SORT_FIELD, MonitorAlertMethodVOMeta.SORT_TYPE, MonitorAlertMethodVOMeta.DATA_ORIGIN, MonitorAlertMethodVOMeta.QUERY_LOGIC, MonitorAlertMethodVOMeta.REQUEST_ACTION, MonitorAlertMethodVOMeta.IDS })
    @SentinelResource(value = MonitorAlertMethodServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.SAVE)
    public Result save(MonitorAlertMethodVO monitorAlertMethodVO) {
        Result result = monitorAlertMethodService.save(monitorAlertMethodVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取告警方式
     */
    @ApiOperation(value = "获取告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertMethodServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.GET_BY_ID)
    public Result<MonitorAlertMethod> getById(String id) {
        Result<MonitorAlertMethod> result = new Result<>();
        MonitorAlertMethod monitorAlertMethod = monitorAlertMethodService.getById(id);
        result.success(true).data(monitorAlertMethod);
        return result;
    }

    /**
     * 批量获取告警方式 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertMethodServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.GET_BY_IDS)
    public Result<List<MonitorAlertMethod>> getByIds(List<String> ids) {
        Result<List<MonitorAlertMethod>> result = new Result<>();
        List<MonitorAlertMethod> list = monitorAlertMethodService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询告警方式
     */
    @ApiOperation(value = "查询告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "脚本"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.PS, value = "参数", required = false, dataTypeClass = String.class, example = "{}"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.CMD, value = "命令", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.BODY, value = "内容", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NAME, value = "name", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { MonitorAlertMethodVOMeta.PAGE_INDEX, MonitorAlertMethodVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorAlertMethodServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.QUERY_LIST)
    public Result<List<MonitorAlertMethod>> queryList(MonitorAlertMethodVO sample) {
        Result<List<MonitorAlertMethod>> result = new Result<>();
        List<MonitorAlertMethod> list = monitorAlertMethodService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询告警方式
     */
    @ApiOperation(value = "分页查询告警方式")
    @ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "脚本"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.PS, value = "参数", required = false, dataTypeClass = String.class, example = "{}"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.CMD, value = "命令", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.BODY, value = "内容", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "#<content># #<rcdTime># #<warnLevel># "),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = MonitorAlertMethodVOMeta.NAME, value = "name", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = MonitorAlertMethodServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorAlertMethodServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorAlertMethod>> queryPagedList(MonitorAlertMethodVO sample) {
        Result<PagedList<MonitorAlertMethod>> result = new Result<>();
        PagedList<MonitorAlertMethod> list = monitorAlertMethodService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
