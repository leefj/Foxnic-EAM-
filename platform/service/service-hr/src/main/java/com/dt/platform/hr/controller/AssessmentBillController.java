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
import com.dt.platform.proxy.hr.AssessmentBillServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentBillVOMeta;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentBillVO;
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
import com.dt.platform.domain.hr.meta.AssessmentBillMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentBillService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核单据接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-08 20:54:09
 */
@InDoc
@Api(tags = "考核单据")
@RestController("HrAssessmentBillController")
public class AssessmentBillController extends SuperController {

    @Autowired
    private IAssessmentBillService assessmentBillService;

    /**
     * 添加考核单据
     */
    @ApiOperation(value = "添加考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_ID, value = "考核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_NAME, value = "考核名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_DATA_ID, value = "考核任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.IS_SHOW, value = "是否可见", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.INSERT)
    public Result insert(AssessmentBillVO assessmentBillVO) {
        Result result = assessmentBillService.insert(assessmentBillVO, false);
        return result;
    }

    /**
     * 删除考核单据
     */
    @ApiOperation(value = "删除考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentBillService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentBillService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 考核单据
     */
    @ApiOperation(value = "考核单据")

    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.CANCEL)
    public Result cancel(String id) {
        return assessmentBillService.cancel(id);
    }

    /**
     * 考核单据
     */
    @ApiOperation(value = "考核单据")

    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.RESET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.RESET)
    public Result reset(String billId) {
        return assessmentBillService.reset(billId);
    }

    @ApiOperation(value = "考核单据")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.CREATE_PAPER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.CREATE_PAPER)
    public Result createPaperDataAll(String billId) {
        return assessmentBillService.createPaperDataAll(billId);
    }

    @ApiOperation(value = "考核单据")

    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.COPY, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.COPY)
    public Result copy(String billId) {
        return assessmentBillService.copy(billId);
    }

    @ApiOperation(value = "考核单据")

    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.COPY, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.RELEASE)
    public Result release(String billId) {
        return assessmentBillService.release(billId);
    }

    /**
     * 批量删除考核单据 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentBillService.hasRefers(ids);
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
            Result result = assessmentBillService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentBillService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考核单据
     */
    @ApiOperation(value = "更新考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_ID, value = "考核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_NAME, value = "考核名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_DATA_ID, value = "考核任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.IS_SHOW, value = "是否可见", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentBillVOMeta.PAGE_INDEX, AssessmentBillVOMeta.PAGE_SIZE, AssessmentBillVOMeta.SEARCH_FIELD, AssessmentBillVOMeta.FUZZY_FIELD, AssessmentBillVOMeta.SEARCH_VALUE, AssessmentBillVOMeta.DIRTY_FIELDS, AssessmentBillVOMeta.SORT_FIELD, AssessmentBillVOMeta.SORT_TYPE, AssessmentBillVOMeta.DATA_ORIGIN, AssessmentBillVOMeta.QUERY_LOGIC, AssessmentBillVOMeta.REQUEST_ACTION, AssessmentBillVOMeta.IDS })
    @SentinelResource(value = AssessmentBillServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.UPDATE)
    public Result update(AssessmentBillVO assessmentBillVO) {
        Result result = assessmentBillService.update(assessmentBillVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考核单据
     */
    @ApiOperation(value = "保存考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_ID, value = "考核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_NAME, value = "考核名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_DATA_ID, value = "考核任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.IS_SHOW, value = "是否可见", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentBillVOMeta.PAGE_INDEX, AssessmentBillVOMeta.PAGE_SIZE, AssessmentBillVOMeta.SEARCH_FIELD, AssessmentBillVOMeta.FUZZY_FIELD, AssessmentBillVOMeta.SEARCH_VALUE, AssessmentBillVOMeta.DIRTY_FIELDS, AssessmentBillVOMeta.SORT_FIELD, AssessmentBillVOMeta.SORT_TYPE, AssessmentBillVOMeta.DATA_ORIGIN, AssessmentBillVOMeta.QUERY_LOGIC, AssessmentBillVOMeta.REQUEST_ACTION, AssessmentBillVOMeta.IDS })
    @SentinelResource(value = AssessmentBillServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.SAVE)
    public Result save(AssessmentBillVO assessmentBillVO) {
        Result result = assessmentBillService.save(assessmentBillVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考核单据
     */
    @ApiOperation(value = "获取考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.GET_BY_ID)
    public Result<AssessmentBill> getById(String id) {
        Result<AssessmentBill> result = new Result<>();
        AssessmentBill assessmentBill = assessmentBillService.getById(id);
        assessmentBillService.dao().fill(assessmentBill).with(AssessmentBillMeta.ASSESSMENT_TASK).execute();
        result.success(true).data(assessmentBill);
        return result;
    }

    /**
     *
     * 批量获取考核单据 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentBill>> getByIds(List<String> ids) {
        Result<List<AssessmentBill>> result = new Result<>();
        List<AssessmentBill> list = assessmentBillService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考核单据
     */
    @ApiOperation(value = "查询考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_ID, value = "考核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_NAME, value = "考核名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_DATA_ID, value = "考核任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.IS_SHOW, value = "是否可见", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentBillVOMeta.PAGE_INDEX, AssessmentBillVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentBillServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.QUERY_LIST)
    public Result<List<AssessmentBill>> queryList(AssessmentBillVO sample) {
        Result<List<AssessmentBill>> result = new Result<>();
        List<AssessmentBill> list = assessmentBillService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考核单据
     */
    @ApiOperation(value = "分页查询考核单据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_ID, value = "考核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_NAME, value = "考核名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.TASK_DATA_ID, value = "考核任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillVOMeta.IS_SHOW, value = "是否可见", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentBill>> queryPagedList(AssessmentBillVO sample) {
        Result<PagedList<AssessmentBill>> result = new Result<>();
        PagedList<AssessmentBill> list = assessmentBillService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        assessmentBillService.dao().fill(list).with(AssessmentBillMeta.ASSESSMENT_TASK).execute();
        result.success(true).data(list);
        return result;
    }
}
