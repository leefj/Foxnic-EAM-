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
import com.dt.platform.proxy.hr.AssessmentIndicatorServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentIndicatorVOMeta;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.AssessmentIndicatorVO;
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
import com.dt.platform.domain.hr.meta.AssessmentIndicatorMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentIndicatorService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核指标接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-28 12:51:35
 */
@InDoc
@Api(tags = "考核指标")
@RestController("HrAssessmentIndicatorController")
public class AssessmentIndicatorController extends SuperController {

    @Autowired
    private IAssessmentIndicatorService assessmentIndicatorService;

    /**
     * 添加考核指标
     */
    @ApiOperation(value = "添加考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ASSESSMENT_ID, value = "考核主题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TPL_INDICATOR_ID, value = "指标库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.NAME, value = "指标名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.WEIGHT, value = "权重", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MIN_VALUE, value = "最小评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MAX_VALUE, value = "最大评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEFAULT_VALUE, value = "默认评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.PROPERTY, value = "定性/定量指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UNIT, value = "计量单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEF, value = "指标定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BASE, value = "评分标准", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BY, value = "评分依据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SN, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.INSERT)
    public Result insert(AssessmentIndicatorVO assessmentIndicatorVO) {
        Result result = assessmentIndicatorService.insert(assessmentIndicatorVO, false);
        return result;
    }

    /**
     * 删除考核指标
     */
    @ApiOperation(value = "删除考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentIndicatorService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentIndicatorService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考核指标 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentIndicatorService.hasRefers(ids);
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
            Result result = assessmentIndicatorService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentIndicatorService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考核指标
     */
    @ApiOperation(value = "更新考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ASSESSMENT_ID, value = "考核主题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TPL_INDICATOR_ID, value = "指标库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.NAME, value = "指标名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.WEIGHT, value = "权重", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MIN_VALUE, value = "最小评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MAX_VALUE, value = "最大评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEFAULT_VALUE, value = "默认评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.PROPERTY, value = "定性/定量指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UNIT, value = "计量单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEF, value = "指标定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BASE, value = "评分标准", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BY, value = "评分依据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SN, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentIndicatorVOMeta.PAGE_INDEX, AssessmentIndicatorVOMeta.PAGE_SIZE, AssessmentIndicatorVOMeta.SEARCH_FIELD, AssessmentIndicatorVOMeta.FUZZY_FIELD, AssessmentIndicatorVOMeta.SEARCH_VALUE, AssessmentIndicatorVOMeta.DIRTY_FIELDS, AssessmentIndicatorVOMeta.SORT_FIELD, AssessmentIndicatorVOMeta.SORT_TYPE, AssessmentIndicatorVOMeta.DATA_ORIGIN, AssessmentIndicatorVOMeta.QUERY_LOGIC, AssessmentIndicatorVOMeta.REQUEST_ACTION, AssessmentIndicatorVOMeta.IDS })
    @SentinelResource(value = AssessmentIndicatorServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.UPDATE)
    public Result update(AssessmentIndicatorVO assessmentIndicatorVO) {
        Result result = assessmentIndicatorService.update(assessmentIndicatorVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考核指标
     */
    @ApiOperation(value = "保存考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ASSESSMENT_ID, value = "考核主题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TPL_INDICATOR_ID, value = "指标库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.NAME, value = "指标名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.WEIGHT, value = "权重", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MIN_VALUE, value = "最小评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MAX_VALUE, value = "最大评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEFAULT_VALUE, value = "默认评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.PROPERTY, value = "定性/定量指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UNIT, value = "计量单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEF, value = "指标定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BASE, value = "评分标准", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BY, value = "评分依据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SN, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentIndicatorVOMeta.PAGE_INDEX, AssessmentIndicatorVOMeta.PAGE_SIZE, AssessmentIndicatorVOMeta.SEARCH_FIELD, AssessmentIndicatorVOMeta.FUZZY_FIELD, AssessmentIndicatorVOMeta.SEARCH_VALUE, AssessmentIndicatorVOMeta.DIRTY_FIELDS, AssessmentIndicatorVOMeta.SORT_FIELD, AssessmentIndicatorVOMeta.SORT_TYPE, AssessmentIndicatorVOMeta.DATA_ORIGIN, AssessmentIndicatorVOMeta.QUERY_LOGIC, AssessmentIndicatorVOMeta.REQUEST_ACTION, AssessmentIndicatorVOMeta.IDS })
    @SentinelResource(value = AssessmentIndicatorServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.SAVE)
    public Result save(AssessmentIndicatorVO assessmentIndicatorVO) {
        Result result = assessmentIndicatorService.save(assessmentIndicatorVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考核指标
     */
    @ApiOperation(value = "获取考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.GET_BY_ID)
    public Result<AssessmentIndicator> getById(String id) {
        Result<AssessmentIndicator> result = new Result<>();
        AssessmentIndicator assessmentIndicator = assessmentIndicatorService.getById(id);
        result.success(true).data(assessmentIndicator);
        return result;
    }

    /**
     * 批量获取考核指标 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentIndicator>> getByIds(List<String> ids) {
        Result<List<AssessmentIndicator>> result = new Result<>();
        List<AssessmentIndicator> list = assessmentIndicatorService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考核指标
     */
    @ApiOperation(value = "查询考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ASSESSMENT_ID, value = "考核主题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TPL_INDICATOR_ID, value = "指标库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.NAME, value = "指标名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.WEIGHT, value = "权重", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MIN_VALUE, value = "最小评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MAX_VALUE, value = "最大评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEFAULT_VALUE, value = "默认评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.PROPERTY, value = "定性/定量指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UNIT, value = "计量单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEF, value = "指标定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BASE, value = "评分标准", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BY, value = "评分依据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SN, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentIndicatorVOMeta.PAGE_INDEX, AssessmentIndicatorVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentIndicatorServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.QUERY_LIST)
    public Result<List<AssessmentIndicator>> queryList(AssessmentIndicatorVO sample) {
        Result<List<AssessmentIndicator>> result = new Result<>();
        List<AssessmentIndicator> list = assessmentIndicatorService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考核指标
     */
    @ApiOperation(value = "分页查询考核指标")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.ASSESSMENT_ID, value = "考核主题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TPL_INDICATOR_ID, value = "指标库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.NAME, value = "指标名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.WEIGHT, value = "权重", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MIN_VALUE, value = "最小评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.TARGET_MAX_VALUE, value = "最大评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEFAULT_VALUE, value = "默认评分值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.PROPERTY, value = "定性/定量指标", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UNIT, value = "计量单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.DEF, value = "指标定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BASE, value = "评分标准", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SCORING_BY, value = "评分依据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentIndicatorVOMeta.SN, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentIndicatorServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentIndicatorServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentIndicator>> queryPagedList(AssessmentIndicatorVO sample) {
        Result<PagedList<AssessmentIndicator>> result = new Result<>();
        PagedList<AssessmentIndicator> list = assessmentIndicatorService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
