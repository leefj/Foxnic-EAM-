package com.dt.platform.eam.controller;

import java.util.*;
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
import com.dt.platform.proxy.eam.InspectionTaskAbnormalServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionTaskAbnormalVOMeta;
import com.dt.platform.domain.eam.InspectionTaskAbnormal;
import com.dt.platform.domain.eam.InspectionTaskAbnormalVO;
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
import com.dt.platform.domain.eam.meta.InspectionTaskAbnormalMeta;
import com.dt.platform.domain.eam.InspectionTask;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionTaskAbnormalService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 异常巡检任务单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-22 21:58:40
 */
@InDoc
@Api(tags = "异常巡检任务单")
@RestController("EamInspectionTaskAbnormalController")
public class InspectionTaskAbnormalController extends SuperController {

    @Autowired
    private IInspectionTaskAbnormalService inspectionTaskAbnormalService;

    /**
     * 添加异常巡检任务单
     */
    @ApiOperation(value = "添加异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ID, value = "任务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ABNORMAL_INFO, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_ID, value = "处理人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.CONTENT, value = "处理方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.FILE_IDS, value = "图片", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.INSERT)
    public Result insert(InspectionTaskAbnormalVO inspectionTaskAbnormalVO) {
        Result result = inspectionTaskAbnormalService.insert(inspectionTaskAbnormalVO, false);
        return result;
    }

    /**
     * 删除异常巡检任务单
     */
    @ApiOperation(value = "删除异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = inspectionTaskAbnormalService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = inspectionTaskAbnormalService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除异常巡检任务单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = inspectionTaskAbnormalService.hasRefers(ids);
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
            Result result = inspectionTaskAbnormalService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = inspectionTaskAbnormalService.deleteByIdsLogical(canDeleteIds);
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
     * 更新异常巡检任务单
     */
    @ApiOperation(value = "更新异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ID, value = "任务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ABNORMAL_INFO, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_ID, value = "处理人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.CONTENT, value = "处理方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.FILE_IDS, value = "图片", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { InspectionTaskAbnormalVOMeta.PAGE_INDEX, InspectionTaskAbnormalVOMeta.PAGE_SIZE, InspectionTaskAbnormalVOMeta.SEARCH_FIELD, InspectionTaskAbnormalVOMeta.FUZZY_FIELD, InspectionTaskAbnormalVOMeta.SEARCH_VALUE, InspectionTaskAbnormalVOMeta.DIRTY_FIELDS, InspectionTaskAbnormalVOMeta.SORT_FIELD, InspectionTaskAbnormalVOMeta.SORT_TYPE, InspectionTaskAbnormalVOMeta.DATA_ORIGIN, InspectionTaskAbnormalVOMeta.QUERY_LOGIC, InspectionTaskAbnormalVOMeta.REQUEST_ACTION, InspectionTaskAbnormalVOMeta.IDS })
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.UPDATE)
    public Result update(InspectionTaskAbnormalVO inspectionTaskAbnormalVO) {
        Result result = inspectionTaskAbnormalService.update(inspectionTaskAbnormalVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存异常巡检任务单
     */
    @ApiOperation(value = "保存异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ID, value = "任务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ABNORMAL_INFO, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_ID, value = "处理人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.CONTENT, value = "处理方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.FILE_IDS, value = "图片", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { InspectionTaskAbnormalVOMeta.PAGE_INDEX, InspectionTaskAbnormalVOMeta.PAGE_SIZE, InspectionTaskAbnormalVOMeta.SEARCH_FIELD, InspectionTaskAbnormalVOMeta.FUZZY_FIELD, InspectionTaskAbnormalVOMeta.SEARCH_VALUE, InspectionTaskAbnormalVOMeta.DIRTY_FIELDS, InspectionTaskAbnormalVOMeta.SORT_FIELD, InspectionTaskAbnormalVOMeta.SORT_TYPE, InspectionTaskAbnormalVOMeta.DATA_ORIGIN, InspectionTaskAbnormalVOMeta.QUERY_LOGIC, InspectionTaskAbnormalVOMeta.REQUEST_ACTION, InspectionTaskAbnormalVOMeta.IDS })
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.SAVE)
    public Result save(InspectionTaskAbnormalVO inspectionTaskAbnormalVO) {
        Result result = inspectionTaskAbnormalService.save(inspectionTaskAbnormalVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取异常巡检任务单
     */
    @ApiOperation(value = "获取异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.GET_BY_ID)
    public Result<InspectionTaskAbnormal> getById(String id) {
        Result<InspectionTaskAbnormal> result = new Result<>();
        InspectionTaskAbnormal inspectionTaskAbnormal = inspectionTaskAbnormalService.getById(id);
        // join 关联的对象
        inspectionTaskAbnormalService.dao().fill(inspectionTaskAbnormal).with("operUser").with(InspectionTaskAbnormalMeta.TASK).execute();
        inspectionTaskAbnormalService.dao().join(inspectionTaskAbnormal, Person.class);
        result.success(true).data(inspectionTaskAbnormal);
        return result;
    }

    /**
     * 批量获取异常巡检任务单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.GET_BY_IDS)
    public Result<List<InspectionTaskAbnormal>> getByIds(List<String> ids) {
        Result<List<InspectionTaskAbnormal>> result = new Result<>();
        List<InspectionTaskAbnormal> list = inspectionTaskAbnormalService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询异常巡检任务单
     */
    @ApiOperation(value = "查询异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ID, value = "任务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ABNORMAL_INFO, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_ID, value = "处理人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.CONTENT, value = "处理方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.FILE_IDS, value = "图片", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { InspectionTaskAbnormalVOMeta.PAGE_INDEX, InspectionTaskAbnormalVOMeta.PAGE_SIZE })
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.QUERY_LIST)
    public Result<List<InspectionTaskAbnormal>> queryList(InspectionTaskAbnormalVO sample) {
        Result<List<InspectionTaskAbnormal>> result = new Result<>();
        List<InspectionTaskAbnormal> list = inspectionTaskAbnormalService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询异常巡检任务单
     */
    @ApiOperation(value = "分页查询异常巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ID, value = "任务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.TASK_ABNORMAL_INFO, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.STATUS, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_TIME, value = "处理时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.OPER_ID, value = "处理人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.CONTENT, value = "处理方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskAbnormalVOMeta.FILE_IDS, value = "图片", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = InspectionTaskAbnormalServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskAbnormalServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<InspectionTaskAbnormal>> queryPagedList(InspectionTaskAbnormalVO sample) {
        Result<PagedList<InspectionTaskAbnormal>> result = new Result<>();
        PagedList<InspectionTaskAbnormal> list = inspectionTaskAbnormalService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        inspectionTaskAbnormalService.dao().fill(list).with("operUser").with(InspectionTaskAbnormalMeta.TASK).execute();
        List<Employee> user2 = CollectorUtil.collectList(list, InspectionTaskAbnormal::getOperUser);
        inspectionTaskAbnormalService.dao().join(user2, Person.class);
        result.success(true).data(list);
        return result;
    }
}
