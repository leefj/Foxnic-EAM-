package com.dt.platform.hr.controller;

import java.math.BigDecimal;
import java.util.*;
import com.dt.platform.domain.eam.AssetBorrow;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.domain.hrm.Employee;
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
import com.dt.platform.proxy.hr.AssessmentBillUserMapServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapVOMeta;
import com.dt.platform.domain.hr.AssessmentBillUserMap;
import com.dt.platform.domain.hr.AssessmentBillUserMapVO;
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
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta;
import com.dt.platform.domain.hr.AssessmentTask;
import org.github.foxnic.web.domain.hrm.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentBillUserMapService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员映射接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 08:13:16
 */
@InDoc
@Api(tags = "人员映射")
@RestController("HrAssessmentBillUserMapController")
public class AssessmentBillUserMapController extends SuperController {

    @Autowired
    private IAssessmentBillUserMapService assessmentBillUserMapService;

    /**
     * 添加人员映射
     */
    @ApiOperation(value = "添加人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_ID, value = "直属领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_ID, value = "上上级领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.RESULT, value = "生成状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.MESSAGE, value = "生成结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.BILL_ID, value = "单据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class, example = "590511680593592320"),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SELF_SCORE, value = "自评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SAME_SCORE, value = "互评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_SCORE, value = "直属领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE, value = "上上级别领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IS_CONFIRM, value = "复核情况", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.INSERT)
    public Result insert(AssessmentBillUserMapVO assessmentBillUserMapVO) {
        Result result = assessmentBillUserMapService.insert(assessmentBillUserMapVO, false);
        return result;
    }

    /**
     * 映射
     */
    @ApiOperation(value = "映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.APPEND_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.APPEND_DATA)
    public Result appendData(String billId) {
        return assessmentBillUserMapService.appendData(billId);
    }

    @ApiOperation(value = "映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.RESET_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.RESET_DATA)
    public Result resetData(String billId) {
        return assessmentBillUserMapService.resetData(billId);
    }

    /**
     * 删除人员映射
     */
    @ApiOperation(value = "删除人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentBillUserMapService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentBillUserMapService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除人员映射 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentBillUserMapService.hasRefers(ids);
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
            Result result = assessmentBillUserMapService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentBillUserMapService.deleteByIdsLogical(canDeleteIds);
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
     * 更新人员映射
     */
    @ApiOperation(value = "更新人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_ID, value = "直属领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_ID, value = "上上级领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.RESULT, value = "生成状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.MESSAGE, value = "生成结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.BILL_ID, value = "单据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class, example = "590511680593592320"),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SELF_SCORE, value = "自评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SAME_SCORE, value = "互评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_SCORE, value = "直属领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE, value = "上上级别领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IS_CONFIRM, value = "复核情况", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentBillUserMapVOMeta.PAGE_INDEX, AssessmentBillUserMapVOMeta.PAGE_SIZE, AssessmentBillUserMapVOMeta.SEARCH_FIELD, AssessmentBillUserMapVOMeta.FUZZY_FIELD, AssessmentBillUserMapVOMeta.SEARCH_VALUE, AssessmentBillUserMapVOMeta.DIRTY_FIELDS, AssessmentBillUserMapVOMeta.SORT_FIELD, AssessmentBillUserMapVOMeta.SORT_TYPE, AssessmentBillUserMapVOMeta.DATA_ORIGIN, AssessmentBillUserMapVOMeta.QUERY_LOGIC, AssessmentBillUserMapVOMeta.REQUEST_ACTION, AssessmentBillUserMapVOMeta.IDS })
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.UPDATE)
    public Result update(AssessmentBillUserMapVO assessmentBillUserMapVO) {
        Result result = assessmentBillUserMapService.update(assessmentBillUserMapVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存人员映射
     */
    @ApiOperation(value = "保存人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_ID, value = "直属领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_ID, value = "上上级领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.RESULT, value = "生成状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.MESSAGE, value = "生成结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.BILL_ID, value = "单据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class, example = "590511680593592320"),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SELF_SCORE, value = "自评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SAME_SCORE, value = "互评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_SCORE, value = "直属领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE, value = "上上级别领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IS_CONFIRM, value = "复核情况", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentBillUserMapVOMeta.PAGE_INDEX, AssessmentBillUserMapVOMeta.PAGE_SIZE, AssessmentBillUserMapVOMeta.SEARCH_FIELD, AssessmentBillUserMapVOMeta.FUZZY_FIELD, AssessmentBillUserMapVOMeta.SEARCH_VALUE, AssessmentBillUserMapVOMeta.DIRTY_FIELDS, AssessmentBillUserMapVOMeta.SORT_FIELD, AssessmentBillUserMapVOMeta.SORT_TYPE, AssessmentBillUserMapVOMeta.DATA_ORIGIN, AssessmentBillUserMapVOMeta.QUERY_LOGIC, AssessmentBillUserMapVOMeta.REQUEST_ACTION, AssessmentBillUserMapVOMeta.IDS })
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.SAVE)
    public Result save(AssessmentBillUserMapVO assessmentBillUserMapVO) {
        Result result = assessmentBillUserMapService.save(assessmentBillUserMapVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取人员映射
     */
    @ApiOperation(value = "获取人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.GET_BY_ID)
    public Result<AssessmentBillUserMap> getById(String id) {
        Result<AssessmentBillUserMap> result = new Result<>();
        AssessmentBillUserMap assessmentBillUserMap = assessmentBillUserMapService.getById(id);
        // join 关联的对象
        assessmentBillUserMapService.dao().fill(assessmentBillUserMap).with("assesseeUser").with("leaderUser").with("secondLeaderUser").with("sameUserList").execute();
        assessmentBillUserMapService.dao().join(assessmentBillUserMap.getAssesseeUser(), Person.class);
        assessmentBillUserMapService.dao().join(assessmentBillUserMap.getHrUser(), Person.class);
        assessmentBillUserMapService.dao().join(assessmentBillUserMap.getLeaderUser(), Person.class);
        assessmentBillUserMapService.dao().join(assessmentBillUserMap.getSecondLeaderUser(), Person.class);
        assessmentBillUserMapService.dao().join(assessmentBillUserMap.getSameUserList(), Person.class);
        result.success(true).data(assessmentBillUserMap);
        return result;
    }

    /**
     * 批量获取人员映射 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentBillUserMap>> getByIds(List<String> ids) {
        Result<List<AssessmentBillUserMap>> result = new Result<>();
        List<AssessmentBillUserMap> list = assessmentBillUserMapService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询人员映射
     */
    @ApiOperation(value = "查询人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_ID, value = "直属领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_ID, value = "上上级领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.RESULT, value = "生成状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.MESSAGE, value = "生成结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.BILL_ID, value = "单据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class, example = "590511680593592320"),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SELF_SCORE, value = "自评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SAME_SCORE, value = "互评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_SCORE, value = "直属领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE, value = "上上级别领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IS_CONFIRM, value = "复核情况", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentBillUserMapVOMeta.PAGE_INDEX, AssessmentBillUserMapVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.QUERY_LIST)
    public Result<List<AssessmentBillUserMap>> queryList(AssessmentBillUserMapVO sample) {
        Result<List<AssessmentBillUserMap>> result = new Result<>();
        List<AssessmentBillUserMap> list = assessmentBillUserMapService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员映射
     */
    @ApiOperation(value = "分页查询人员映射")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_ID, value = "直属领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_ID, value = "上上级领导", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.RESULT, value = "生成状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.MESSAGE, value = "生成结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.BILL_ID, value = "单据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.HR_USER_ID, value = "HR复核人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.ASSESSEE_ID, value = "被考核人", required = false, dataTypeClass = String.class, example = "590511680593592320"),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SELF_SCORE, value = "自评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SAME_SCORE, value = "互评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.LEADER_SCORE, value = "直属领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE, value = "上上级别领导评分", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssessmentBillUserMapVOMeta.IS_CONFIRM, value = "复核情况", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentBillUserMapServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentBillUserMapServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentBillUserMap>> queryPagedList(AssessmentBillUserMapVO sample) {
        Result<PagedList<AssessmentBillUserMap>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("1=1");
        if (!StringUtil.isBlank(sample.getSOrgId())) {
            expr.and("assessee_id in (select distinct b.employee_id from hrm_position a,hrm_employee_position b where a.id=b.position_id and a.deleted=0 and b.deleted=0 and a.org_id in  (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/" + sample.getSOrgId() + "/%' or id=?)))", sample.getSOrgId());
        }
        PagedList<AssessmentBillUserMap> list = assessmentBillUserMapService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assessmentBillUserMapService.dao().fill(list).with(AssessmentBillUserMapMeta.LEADER_SCORE_PAPER)
                .with(AssessmentBillUserMapMeta.INCOMPLETE_PAPER)
                .with(AssessmentBillUserMapMeta.LEADER_SCORE_PAPER)
                .with(AssessmentBillUserMapMeta.SECOND_LEADER_SCORE_PAPER)
                .with(AssessmentBillUserMapMeta.SELF_SCORE_PAPER)
                .with(AssessmentBillUserMapMeta.SAME_SCORE_PAPER_LIST)
                .with("hrUser").with("assesseeUser").with("leaderUser").with("secondLeaderUser").with("sameUserList").execute();

        assessmentBillUserMapService.dao().fill(list)
                .with(AssessmentBillUserMapMeta.INCOMPLETE_PAPER)
                .with(AssessmentBillUserMapMeta.SECOND_LEADER_SCORE_PAPER).execute();


        List<Employee> assessorList = CollectorUtil.collectList(list, AssessmentBillUserMap::getAssesseeUser);
        assessmentBillUserMapService.dao().join(assessorList, Person.class);
        List<Employee> leaderList = CollectorUtil.collectList(list, AssessmentBillUserMap::getLeaderUser);
        assessmentBillUserMapService.dao().join(leaderList, Person.class);
        List<Employee> secondLeaderList = CollectorUtil.collectList(list, AssessmentBillUserMap::getSecondLeaderUser);
        assessmentBillUserMapService.dao().join(secondLeaderList, Person.class);
        List<Employee> hrList = CollectorUtil.collectList(list, AssessmentBillUserMap::getHrUser);
        assessmentBillUserMapService.dao().join(hrList, Person.class);
        List<List<Employee>> sameListList = CollectorUtil.collectList(list, AssessmentBillUserMap::getSameUserList);
        List<Employee> sameList = sameListList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        assessmentBillUserMapService.dao().join(sameList, Person.class);
        result.success(true).data(list);
        return result;
    }
}
