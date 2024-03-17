package com.dt.platform.hr.controller;

import java.util.*;
import com.dt.platform.domain.hr.*;
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
import com.dt.platform.proxy.hr.AssessmentBillTaskPaperServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperVOMeta;
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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentBillTaskPaperService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核试卷接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 17:23:38
 */
@InDoc
@Api(tags = "考核试卷")
@RestController("HrAssessmentBillTaskPaperController")
public class AssessmentBillTaskPaperController extends SuperController {

    @Autowired
    private IAssessmentBillTaskPaperService assessmentBillTaskPaperService;

    /**
     * 添加考核试卷
     */
    @ApiOperation(value = "添加考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSOR_ID, value = "考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.SCORE_VALUE, value = "综合得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT, value = "综合评价", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.CONTENT, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.RELATIONSHIP, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.USER_MAP_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.INSERT)
    public Result insert(AssessmentBillTaskPaperVO assessmentBillTaskPaperVO) {
        Result result = assessmentBillTaskPaperService.insert(assessmentBillTaskPaperVO, false);
        return result;
    }

    /**
     * 删除考核试卷
     */
    @ApiOperation(value = "删除考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentBillTaskPaperService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentBillTaskPaperService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考核试卷 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentBillTaskPaperService.hasRefers(ids);
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
            Result result = assessmentBillTaskPaperService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentBillTaskPaperService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考核试卷
     */
    @ApiOperation(value = "更新考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSOR_ID, value = "考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.SCORE_VALUE, value = "综合得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT, value = "综合评价", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.CONTENT, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.RELATIONSHIP, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.USER_MAP_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentBillTaskPaperVOMeta.PAGE_INDEX, AssessmentBillTaskPaperVOMeta.PAGE_SIZE, AssessmentBillTaskPaperVOMeta.SEARCH_FIELD, AssessmentBillTaskPaperVOMeta.FUZZY_FIELD, AssessmentBillTaskPaperVOMeta.SEARCH_VALUE, AssessmentBillTaskPaperVOMeta.DIRTY_FIELDS, AssessmentBillTaskPaperVOMeta.SORT_FIELD, AssessmentBillTaskPaperVOMeta.SORT_TYPE, AssessmentBillTaskPaperVOMeta.DATA_ORIGIN, AssessmentBillTaskPaperVOMeta.QUERY_LOGIC, AssessmentBillTaskPaperVOMeta.REQUEST_ACTION, AssessmentBillTaskPaperVOMeta.IDS })
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.UPDATE)
    public Result update(AssessmentBillTaskPaperVO assessmentBillTaskPaperVO) {
        Result result = assessmentBillTaskPaperService.update(assessmentBillTaskPaperVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考核试卷
     */
    @ApiOperation(value = "保存考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSOR_ID, value = "考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.SCORE_VALUE, value = "综合得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT, value = "综合评价", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.CONTENT, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.RELATIONSHIP, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.USER_MAP_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentBillTaskPaperVOMeta.PAGE_INDEX, AssessmentBillTaskPaperVOMeta.PAGE_SIZE, AssessmentBillTaskPaperVOMeta.SEARCH_FIELD, AssessmentBillTaskPaperVOMeta.FUZZY_FIELD, AssessmentBillTaskPaperVOMeta.SEARCH_VALUE, AssessmentBillTaskPaperVOMeta.DIRTY_FIELDS, AssessmentBillTaskPaperVOMeta.SORT_FIELD, AssessmentBillTaskPaperVOMeta.SORT_TYPE, AssessmentBillTaskPaperVOMeta.DATA_ORIGIN, AssessmentBillTaskPaperVOMeta.QUERY_LOGIC, AssessmentBillTaskPaperVOMeta.REQUEST_ACTION, AssessmentBillTaskPaperVOMeta.IDS })
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.SAVE)
    public Result save(AssessmentBillTaskPaperVO assessmentBillTaskPaperVO) {
        Result result = assessmentBillTaskPaperService.save(assessmentBillTaskPaperVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考核试卷
     */
    @ApiOperation(value = "获取考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.GET_BY_ID)
    public Result<AssessmentBillTaskPaper> getById(String id) {
        Result<AssessmentBillTaskPaper> result = new Result<>();
        AssessmentBillTaskPaper assessmentBillTaskPaper = assessmentBillTaskPaperService.getById(id);
        // join 关联的对象
        assessmentBillTaskPaperService.dao().fill(assessmentBillTaskPaper).with("assessee").with("assessor").execute();
        result.success(true).data(assessmentBillTaskPaper);
        return result;
    }

    /**
     * 批量获取考核试卷 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentBillTaskPaper>> getByIds(List<String> ids) {
        Result<List<AssessmentBillTaskPaper>> result = new Result<>();
        List<AssessmentBillTaskPaper> list = assessmentBillTaskPaperService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考核试卷
     */
    @ApiOperation(value = "查询考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSOR_ID, value = "考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.SCORE_VALUE, value = "综合得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT, value = "综合评价", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.CONTENT, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.RELATIONSHIP, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.USER_MAP_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentBillTaskPaperVOMeta.PAGE_INDEX, AssessmentBillTaskPaperVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.QUERY_LIST)
    public Result<List<AssessmentBillTaskPaper>> queryList(AssessmentBillTaskPaperVO sample) {
        Result<List<AssessmentBillTaskPaper>> result = new Result<>();
        List<AssessmentBillTaskPaper> list = assessmentBillTaskPaperService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考核试卷
     */
    @ApiOperation(value = "分页查询考核试卷")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSOR_ID, value = "考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.SCORE_VALUE, value = "综合得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT, value = "综合评价", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.CONTENT, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.BILL_TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.RELATIONSHIP, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillTaskPaperVOMeta.USER_MAP_ID, value = "用户", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillTaskPaperServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillTaskPaperServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentBillTaskPaper>> queryPagedList(AssessmentBillTaskPaperVO sample) {
        Result<PagedList<AssessmentBillTaskPaper>> result = new Result<>();
        PagedList<AssessmentBillTaskPaper> list = assessmentBillTaskPaperService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assessmentBillTaskPaperService.dao().fill(list).with("assessee").with("assessor").execute();
        List<Employee> employeeList = CollectorUtil.collectList(list, AssessmentBillTaskPaper::getAssessor);
        assessmentBillTaskPaperService.dao().join(employeeList, Person.class);
        List<Employee> employeeList2 = CollectorUtil.collectList(list, AssessmentBillTaskPaper::getAssessee);
        assessmentBillTaskPaperService.dao().join(employeeList2, Person.class);
        result.success(true).data(list);
        return result;
    }
}
