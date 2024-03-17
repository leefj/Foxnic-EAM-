package com.dt.platform.hr.controller;

import java.util.*;

import com.github.foxnic.sql.expr.OrderBy;
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
import com.dt.platform.proxy.hr.AssessmentIndicatorValueServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentIndicatorValueVOMeta;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import com.dt.platform.domain.hr.AssessmentIndicatorValueVO;
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
import com.dt.platform.domain.hr.meta.AssessmentIndicatorValueMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.AssessmentIndicator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentIndicatorValueService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核结果接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 07:20:12
 */
@InDoc
@Api(tags = "考核结果")
@RestController("HrAssessmentIndicatorValueController")
public class AssessmentIndicatorValueController extends SuperController {

    @Autowired
    private IAssessmentIndicatorValueService assessmentIndicatorValueService;

    /**
     * 添加考核结果
     */
    @ApiOperation(value = "添加考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.TASK_PAPER_ID, value = "评分表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.INDICATOR_ID, value = "指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.VALUE, value = "得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.SN, value = "顺序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.INSERT)
    public Result insert(AssessmentIndicatorValueVO assessmentIndicatorValueVO) {
        Result result = assessmentIndicatorValueService.insert(assessmentIndicatorValueVO, false);
        return result;
    }

    /**
     * 删除考核结果
     */
    @ApiOperation(value = "删除考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentIndicatorValueService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentIndicatorValueService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考核结果 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentIndicatorValueService.hasRefers(ids);
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
            Result result = assessmentIndicatorValueService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentIndicatorValueService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考核结果
     */
    @ApiOperation(value = "更新考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.TASK_PAPER_ID, value = "评分表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.INDICATOR_ID, value = "指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.VALUE, value = "得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.SN, value = "顺序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentIndicatorValueVOMeta.PAGE_INDEX, AssessmentIndicatorValueVOMeta.PAGE_SIZE, AssessmentIndicatorValueVOMeta.SEARCH_FIELD, AssessmentIndicatorValueVOMeta.FUZZY_FIELD, AssessmentIndicatorValueVOMeta.SEARCH_VALUE, AssessmentIndicatorValueVOMeta.DIRTY_FIELDS, AssessmentIndicatorValueVOMeta.SORT_FIELD, AssessmentIndicatorValueVOMeta.SORT_TYPE, AssessmentIndicatorValueVOMeta.DATA_ORIGIN, AssessmentIndicatorValueVOMeta.QUERY_LOGIC, AssessmentIndicatorValueVOMeta.REQUEST_ACTION, AssessmentIndicatorValueVOMeta.IDS })
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.UPDATE)
    public Result update(AssessmentIndicatorValueVO assessmentIndicatorValueVO) {
        Result result = assessmentIndicatorValueService.update(assessmentIndicatorValueVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考核结果
     */
    @ApiOperation(value = "保存考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.TASK_PAPER_ID, value = "评分表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.INDICATOR_ID, value = "指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.VALUE, value = "得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.SN, value = "顺序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentIndicatorValueVOMeta.PAGE_INDEX, AssessmentIndicatorValueVOMeta.PAGE_SIZE, AssessmentIndicatorValueVOMeta.SEARCH_FIELD, AssessmentIndicatorValueVOMeta.FUZZY_FIELD, AssessmentIndicatorValueVOMeta.SEARCH_VALUE, AssessmentIndicatorValueVOMeta.DIRTY_FIELDS, AssessmentIndicatorValueVOMeta.SORT_FIELD, AssessmentIndicatorValueVOMeta.SORT_TYPE, AssessmentIndicatorValueVOMeta.DATA_ORIGIN, AssessmentIndicatorValueVOMeta.QUERY_LOGIC, AssessmentIndicatorValueVOMeta.REQUEST_ACTION, AssessmentIndicatorValueVOMeta.IDS })
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.SAVE)
    public Result save(AssessmentIndicatorValueVO assessmentIndicatorValueVO) {
        Result result = assessmentIndicatorValueService.save(assessmentIndicatorValueVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考核结果
     */
    @ApiOperation(value = "获取考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.GET_BY_ID)
    public Result<AssessmentIndicatorValue> getById(String id) {
        Result<AssessmentIndicatorValue> result = new Result<>();
        AssessmentIndicatorValue assessmentIndicatorValue = assessmentIndicatorValueService.getById(id);
        assessmentIndicatorValueService.dao().fill(assessmentIndicatorValue).with(AssessmentIndicatorValueMeta.ASSESSMENT_INDICATOR).execute();

        result.success(true).data(assessmentIndicatorValue);
        return result;
    }

    /**
     * 批量获取考核结果 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentIndicatorValue>> getByIds(List<String> ids) {
        Result<List<AssessmentIndicatorValue>> result = new Result<>();
        List<AssessmentIndicatorValue> list = assessmentIndicatorValueService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考核结果
     */
    @ApiOperation(value = "查询考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.TASK_PAPER_ID, value = "评分表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.INDICATOR_ID, value = "指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.VALUE, value = "得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.SN, value = "顺序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentIndicatorValueVOMeta.PAGE_INDEX, AssessmentIndicatorValueVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.QUERY_LIST)
    public Result<List<AssessmentIndicatorValue>> queryList(AssessmentIndicatorValueVO sample) {
        Result<List<AssessmentIndicatorValue>> result = new Result<>();
        List<AssessmentIndicatorValue> list = assessmentIndicatorValueService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考核结果
     */
    @ApiOperation(value = "分页查询考核结果")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.TASK_PAPER_ID, value = "评分表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.INDICATOR_ID, value = "指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.VALUE, value = "得分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorValueVOMeta.SN, value = "顺序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorValueServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorValueServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentIndicatorValue>> queryPagedList(AssessmentIndicatorValueVO sample) {
        Result<PagedList<AssessmentIndicatorValue>> result = new Result<>();

        OrderBy orderBy=new OrderBy();
        orderBy.asc("sn");
        PagedList<AssessmentIndicatorValue> list = assessmentIndicatorValueService.queryPagedList(sample, orderBy,sample.getPageSize(), sample.getPageIndex());

        assessmentIndicatorValueService.dao().fill(list).with(AssessmentIndicatorValueMeta.ASSESSMENT_INDICATOR).execute();
        result.success(true).data(list);
        return result;
    }
}
