package com.dt.platform.oa.controller;

import java.util.*;
import com.alibaba.fastjson.JSONArray;
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
import com.dt.platform.proxy.oa.SchedulePlanServiceProxy;
import com.dt.platform.domain.oa.meta.SchedulePlanVOMeta;
import com.dt.platform.domain.oa.SchedulePlan;
import com.dt.platform.domain.oa.SchedulePlanVO;
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
import com.dt.platform.domain.oa.meta.SchedulePlanMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ISchedulePlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 日程安排接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-25 10:32:46
 */
@InDoc
@Api(tags = "日程安排")
@RestController("OaSchedulePlanController")
public class SchedulePlanController extends SuperController {

    @Autowired
    private ISchedulePlanService schedulePlanService;

    /**
     * 添加日程安排
     */
    @ApiOperation(value = "添加日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "725047309544456192"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.RANK, value = "优先级", required = false, dataTypeClass = String.class, example = "important"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2023-06-19 12:01:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND, value = "提醒", required = false, dataTypeClass = String.class, example = "time_5"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND_TIME, value = "提醒时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SchedulePlanVOMeta.CONTENT, value = "日程内容", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.DETAIL, value = "详细描述", required = false, dataTypeClass = String.class, example = "kjn"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SchedulePlanServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.INSERT)
    public Result insert(SchedulePlanVO schedulePlanVO) {
        Result result = schedulePlanService.insert(schedulePlanVO, false);
        return result;
    }

    /**
     * 删除日程安排
     */
    @ApiOperation(value = "删除日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "725047309544456192")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SchedulePlanServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = schedulePlanService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = schedulePlanService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除日程安排 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SchedulePlanServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = schedulePlanService.hasRefers(ids);
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
            Result result = schedulePlanService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = schedulePlanService.deleteByIdsLogical(canDeleteIds);
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
     * 更新日程安排
     */
    @ApiOperation(value = "更新日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "725047309544456192"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.RANK, value = "优先级", required = false, dataTypeClass = String.class, example = "important"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2023-06-19 12:01:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND, value = "提醒", required = false, dataTypeClass = String.class, example = "time_5"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND_TIME, value = "提醒时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SchedulePlanVOMeta.CONTENT, value = "日程内容", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.DETAIL, value = "详细描述", required = false, dataTypeClass = String.class, example = "kjn"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { SchedulePlanVOMeta.PAGE_INDEX, SchedulePlanVOMeta.PAGE_SIZE, SchedulePlanVOMeta.SEARCH_FIELD, SchedulePlanVOMeta.FUZZY_FIELD, SchedulePlanVOMeta.SEARCH_VALUE, SchedulePlanVOMeta.DIRTY_FIELDS, SchedulePlanVOMeta.SORT_FIELD, SchedulePlanVOMeta.SORT_TYPE, SchedulePlanVOMeta.DATA_ORIGIN, SchedulePlanVOMeta.QUERY_LOGIC, SchedulePlanVOMeta.REQUEST_ACTION, SchedulePlanVOMeta.IDS })
    @SentinelResource(value = SchedulePlanServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.UPDATE)
    public Result update(SchedulePlanVO schedulePlanVO) {
        Result result = schedulePlanService.update(schedulePlanVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存日程安排
     */
    @ApiOperation(value = "保存日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "725047309544456192"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.RANK, value = "优先级", required = false, dataTypeClass = String.class, example = "important"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2023-06-19 12:01:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND, value = "提醒", required = false, dataTypeClass = String.class, example = "time_5"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND_TIME, value = "提醒时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SchedulePlanVOMeta.CONTENT, value = "日程内容", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.DETAIL, value = "详细描述", required = false, dataTypeClass = String.class, example = "kjn"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { SchedulePlanVOMeta.PAGE_INDEX, SchedulePlanVOMeta.PAGE_SIZE, SchedulePlanVOMeta.SEARCH_FIELD, SchedulePlanVOMeta.FUZZY_FIELD, SchedulePlanVOMeta.SEARCH_VALUE, SchedulePlanVOMeta.DIRTY_FIELDS, SchedulePlanVOMeta.SORT_FIELD, SchedulePlanVOMeta.SORT_TYPE, SchedulePlanVOMeta.DATA_ORIGIN, SchedulePlanVOMeta.QUERY_LOGIC, SchedulePlanVOMeta.REQUEST_ACTION, SchedulePlanVOMeta.IDS })
    @SentinelResource(value = SchedulePlanServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.SAVE)
    public Result save(SchedulePlanVO schedulePlanVO) {
        Result result = schedulePlanService.save(schedulePlanVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取日程安排
     */
    @ApiOperation(value = "获取日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SchedulePlanServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.GET_BY_ID)
    public Result<SchedulePlan> getById(String id) {
        Result<SchedulePlan> result = new Result<>();
        SchedulePlan schedulePlan = schedulePlanService.getById(id);
        // join 关联的对象
        schedulePlanService.dao().fill(schedulePlan).with(SchedulePlanMeta.SCHEDULE_REMIND).execute();
        result.success(true).data(schedulePlan);
        return result;
    }

    /**
     * 批量获取日程安排 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SchedulePlanServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.GET_BY_IDS)
    public Result<List<SchedulePlan>> getByIds(List<String> ids) {
        Result<List<SchedulePlan>> result = new Result<>();
        List<SchedulePlan> list = schedulePlanService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询日程安排
     */
    @ApiOperation(value = "查询日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "725047309544456192"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.RANK, value = "优先级", required = false, dataTypeClass = String.class, example = "important"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2023-06-19 12:01:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND, value = "提醒", required = false, dataTypeClass = String.class, example = "time_5"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND_TIME, value = "提醒时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SchedulePlanVOMeta.CONTENT, value = "日程内容", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.DETAIL, value = "详细描述", required = false, dataTypeClass = String.class, example = "kjn"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { SchedulePlanVOMeta.PAGE_INDEX, SchedulePlanVOMeta.PAGE_SIZE })
    @SentinelResource(value = SchedulePlanServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.QUERY_LIST)
    public Result<List<SchedulePlan>> queryList(SchedulePlanVO sample) {
        Result<List<SchedulePlan>> result = new Result<>();
        List<SchedulePlan> list = schedulePlanService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询日程安排
     */
    @ApiOperation(value = "分页查询日程安排")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SchedulePlanVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "725047309544456192"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.RANK, value = "优先级", required = false, dataTypeClass = String.class, example = "important"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2023-06-19 12:01:00"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND, value = "提醒", required = false, dataTypeClass = String.class, example = "time_5"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.REMIND_TIME, value = "提醒时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SchedulePlanVOMeta.CONTENT, value = "日程内容", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.DETAIL, value = "详细描述", required = false, dataTypeClass = String.class, example = "kjn"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = SchedulePlanVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SchedulePlanServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SchedulePlan>> queryPagedList(SchedulePlanVO sample) {
        sample.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
        Result<PagedList<SchedulePlan>> result = new Result<>();
        PagedList<SchedulePlan> list = schedulePlanService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        schedulePlanService.dao().fill(list).with(SchedulePlanMeta.SCHEDULE_REMIND).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询日程安排
     */
    @ApiOperation(value = "分页查询日程安排")
    @SentinelResource(value = SchedulePlanServiceProxy.QUERY_PLAN, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SchedulePlanServiceProxy.QUERY_PLAN)
    public Result<JSONArray> queryPlan(String startStr, String endStr) {
        return schedulePlanService.queryPlan(startStr, endStr);
    }
}
