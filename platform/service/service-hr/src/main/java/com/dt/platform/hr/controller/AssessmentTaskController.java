package com.dt.platform.hr.controller;

import java.util.*;
import com.dt.platform.domain.hr.meta.AssessmentTplMeta;
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
import com.dt.platform.proxy.hr.AssessmentTaskServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentTaskVOMeta;
import com.dt.platform.domain.hr.AssessmentTask;
import com.dt.platform.domain.hr.AssessmentTaskVO;
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
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.AssessmentIndicator;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.hr.Position;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核任务接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-09 16:34:53
 */
@InDoc
@Api(tags = "考核任务")
@RestController("HrAssessmentTaskController")
public class AssessmentTaskController extends SuperController {

    @Autowired
    private IAssessmentTaskService assessmentTaskService;

    /**
     * 添加考核任务
     */
    @ApiOperation(value = "添加考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "816383435982503936"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NAME, value = "考核名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.STATUS, value = "任务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.CYCLE, value = "周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IS_ALL_PERSON, value = "全部人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ASSESSMEN_METHOD, value = "考核方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT, value = "自评评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT, value = "互评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT, value = "直接领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT, value = "上上级领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_HR_CONFIRM, value = "HR是否复核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TPL_ID, value = "绩效模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.INSERT)
    public Result insert(AssessmentTaskVO assessmentTaskVO) {
        Result result = assessmentTaskService.insert(assessmentTaskVO, false);
        return result;
    }

    /**
     * 创建考核任务
     */
    @ApiOperation(value = "考核任务")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.CREATE_TASK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.CREATE_TASK)
    public Result createTask(String taskId, String billId) {
        return assessmentTaskService.createTask(taskId, billId);
    }

    /**
     * 删除考核任务
     */
    @ApiOperation(value = "删除考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "816383435982503936")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentTaskService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentTaskService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考核任务 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentTaskService.hasRefers(ids);
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
            Result result = assessmentTaskService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentTaskService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考核任务
     */
    @ApiOperation(value = "更新考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "816383435982503936"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NAME, value = "考核名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.STATUS, value = "任务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.CYCLE, value = "周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IS_ALL_PERSON, value = "全部人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ASSESSMEN_METHOD, value = "考核方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT, value = "自评评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT, value = "互评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT, value = "直接领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT, value = "上上级领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_HR_CONFIRM, value = "HR是否复核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TPL_ID, value = "绩效模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentTaskVOMeta.PAGE_INDEX, AssessmentTaskVOMeta.PAGE_SIZE, AssessmentTaskVOMeta.SEARCH_FIELD, AssessmentTaskVOMeta.FUZZY_FIELD, AssessmentTaskVOMeta.SEARCH_VALUE, AssessmentTaskVOMeta.DIRTY_FIELDS, AssessmentTaskVOMeta.SORT_FIELD, AssessmentTaskVOMeta.SORT_TYPE, AssessmentTaskVOMeta.DATA_ORIGIN, AssessmentTaskVOMeta.QUERY_LOGIC, AssessmentTaskVOMeta.REQUEST_ACTION, AssessmentTaskVOMeta.IDS })
    @SentinelResource(value = AssessmentTaskServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.UPDATE)
    public Result update(AssessmentTaskVO assessmentTaskVO) {
        Result result = assessmentTaskService.update(assessmentTaskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考核任务
     */
    @ApiOperation(value = "保存考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "816383435982503936"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NAME, value = "考核名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.STATUS, value = "任务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.CYCLE, value = "周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IS_ALL_PERSON, value = "全部人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ASSESSMEN_METHOD, value = "考核方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT, value = "自评评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT, value = "互评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT, value = "直接领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT, value = "上上级领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_HR_CONFIRM, value = "HR是否复核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TPL_ID, value = "绩效模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentTaskVOMeta.PAGE_INDEX, AssessmentTaskVOMeta.PAGE_SIZE, AssessmentTaskVOMeta.SEARCH_FIELD, AssessmentTaskVOMeta.FUZZY_FIELD, AssessmentTaskVOMeta.SEARCH_VALUE, AssessmentTaskVOMeta.DIRTY_FIELDS, AssessmentTaskVOMeta.SORT_FIELD, AssessmentTaskVOMeta.SORT_TYPE, AssessmentTaskVOMeta.DATA_ORIGIN, AssessmentTaskVOMeta.QUERY_LOGIC, AssessmentTaskVOMeta.REQUEST_ACTION, AssessmentTaskVOMeta.IDS })
    @SentinelResource(value = AssessmentTaskServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.SAVE)
    public Result save(AssessmentTaskVO assessmentTaskVO) {
        Result result = assessmentTaskService.save(assessmentTaskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考核任务
     */
    @ApiOperation(value = "获取考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.GET_BY_ID)
    public Result<AssessmentTask> getById(String id) {
        Result<AssessmentTask> result = new Result<>();
        AssessmentTask assessmentTask = assessmentTaskService.getById(id);
        // join 关联的对象
        assessmentTaskService.dao().fill(assessmentTask).with("hrUser").with(AssessmentTaskMeta.TYPE_DICT).with(AssessmentTaskMeta.ASSESSMENT_TPL).with(AssessmentTaskMeta.ORGANIZATION_LIST).with(AssessmentTaskMeta.PERSON_LIST).with(AssessmentTaskMeta.EXCLUDE_PERSON_LIST).execute();
        result.success(true).data(assessmentTask);
        return result;
    }

    /**
     * 批量获取考核任务 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentTask>> getByIds(List<String> ids) {
        Result<List<AssessmentTask>> result = new Result<>();
        List<AssessmentTask> list = assessmentTaskService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考核任务
     */
    @ApiOperation(value = "查询考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "816383435982503936"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NAME, value = "考核名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.STATUS, value = "任务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.CYCLE, value = "周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IS_ALL_PERSON, value = "全部人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ASSESSMEN_METHOD, value = "考核方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT, value = "自评评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT, value = "互评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT, value = "直接领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT, value = "上上级领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_HR_CONFIRM, value = "HR是否复核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TPL_ID, value = "绩效模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentTaskVOMeta.PAGE_INDEX, AssessmentTaskVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentTaskServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.QUERY_LIST)
    public Result<List<AssessmentTask>> queryList(AssessmentTaskVO sample) {
        Result<List<AssessmentTask>> result = new Result<>();
        List<AssessmentTask> list = assessmentTaskService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考核任务
     */
    @ApiOperation(value = "分页查询考核任务")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "816383435982503936"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NAME, value = "考核名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.STATUS, value = "任务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.CYCLE, value = "周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.IS_ALL_PERSON, value = "全部人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.ASSESSMEN_METHOD, value = "考核方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT, value = "自评评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT, value = "互评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT, value = "直接领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT, value = "上上级领导评分", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HAS_HR_CONFIRM, value = "HR是否复核", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TPL_ID, value = "绩效模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentTaskVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTaskServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTaskServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentTask>> queryPagedList(AssessmentTaskVO sample) {
        Result<PagedList<AssessmentTask>> result = new Result<>();
        PagedList<AssessmentTask> list = assessmentTaskService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assessmentTaskService.dao().fill(list).with(AssessmentTaskMeta.TYPE_DICT).with("hrUser").with(AssessmentTaskMeta.ASSESSMENT_TPL).execute();
        result.success(true).data(list);
        return result;
    }
}
