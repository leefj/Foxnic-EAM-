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
import com.dt.platform.proxy.hr.AssessmentTplServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentTplVOMeta;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.AssessmentTplVO;
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
import com.dt.platform.domain.hr.meta.AssessmentTplMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.AssessmentIndicator;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.hr.Position;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核模版接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 15:23:34
 */
@InDoc
@Api(tags = "考核模版")
@RestController("HrAssessmentTplController")
public class AssessmentTplController extends SuperController {

    @Autowired
    private IAssessmentTplService assessmentTplService;

    /**
     * 添加考核模版
     */
    @ApiOperation(value = "添加考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "815575524477763584"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NAME, value = "模版名称", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "100.00"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTplServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.INSERT)
    public Result insert(AssessmentTplVO assessmentTplVO) {
        Result result = assessmentTplService.insert(assessmentTplVO, false);
        return result;
    }

    /**
     * 删除考核模版
     */
    @ApiOperation(value = "删除考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "815575524477763584")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTplServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = assessmentTplService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = assessmentTplService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考核模版 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTplServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assessmentTplService.hasRefers(ids);
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
            Result result = assessmentTplService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assessmentTplService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考核模版
     */
    @ApiOperation(value = "更新考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "815575524477763584"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NAME, value = "模版名称", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "100.00"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentTplVOMeta.PAGE_INDEX, AssessmentTplVOMeta.PAGE_SIZE, AssessmentTplVOMeta.SEARCH_FIELD, AssessmentTplVOMeta.FUZZY_FIELD, AssessmentTplVOMeta.SEARCH_VALUE, AssessmentTplVOMeta.DIRTY_FIELDS, AssessmentTplVOMeta.SORT_FIELD, AssessmentTplVOMeta.SORT_TYPE, AssessmentTplVOMeta.DATA_ORIGIN, AssessmentTplVOMeta.QUERY_LOGIC, AssessmentTplVOMeta.REQUEST_ACTION, AssessmentTplVOMeta.IDS })
    @SentinelResource(value = AssessmentTplServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.UPDATE)
    public Result update(AssessmentTplVO assessmentTplVO) {
        Result result = assessmentTplService.update(assessmentTplVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考核模版
     */
    @ApiOperation(value = "保存考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "815575524477763584"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NAME, value = "模版名称", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "100.00"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssessmentTplVOMeta.PAGE_INDEX, AssessmentTplVOMeta.PAGE_SIZE, AssessmentTplVOMeta.SEARCH_FIELD, AssessmentTplVOMeta.FUZZY_FIELD, AssessmentTplVOMeta.SEARCH_VALUE, AssessmentTplVOMeta.DIRTY_FIELDS, AssessmentTplVOMeta.SORT_FIELD, AssessmentTplVOMeta.SORT_TYPE, AssessmentTplVOMeta.DATA_ORIGIN, AssessmentTplVOMeta.QUERY_LOGIC, AssessmentTplVOMeta.REQUEST_ACTION, AssessmentTplVOMeta.IDS })
    @SentinelResource(value = AssessmentTplServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.SAVE)
    public Result save(AssessmentTplVO assessmentTplVO) {
        Result result = assessmentTplService.save(assessmentTplVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考核模版
     */
    @ApiOperation(value = "获取考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTplServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.GET_BY_ID)
    public Result<AssessmentTpl> getById(String id) {
        Result<AssessmentTpl> result = new Result<>();
        AssessmentTpl assessmentTpl = assessmentTplService.getById(id);
        // join 关联的对象
        assessmentTplService.dao().fill(assessmentTpl).with(AssessmentTplMeta.POSITION_LIST).execute();
        result.success(true).data(assessmentTpl);
        return result;
    }

    /**
     * 批量获取考核模版 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTplServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.GET_BY_IDS)
    public Result<List<AssessmentTpl>> getByIds(List<String> ids) {
        Result<List<AssessmentTpl>> result = new Result<>();
        List<AssessmentTpl> list = assessmentTplService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询考核模版
     */
    @ApiOperation(value = "查询考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "815575524477763584"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NAME, value = "模版名称", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "100.00"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssessmentTplVOMeta.PAGE_INDEX, AssessmentTplVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssessmentTplServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.QUERY_LIST)
    public Result<List<AssessmentTpl>> queryList(AssessmentTplVO sample) {
        Result<List<AssessmentTpl>> result = new Result<>();
        List<AssessmentTpl> list = assessmentTplService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考核模版
     */
    @ApiOperation(value = "分页查询考核模版")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "815575524477763584"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NAME, value = "模版名称", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.TOTAL_WEIGHT, value = "指标总权重", required = false, dataTypeClass = BigDecimal.class, example = "100.00"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "科技项目绩效模版"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911"),
		@ApiImplicitParam(name = AssessmentTplVOMeta.ORG_ID, value = "部门", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssessmentTplServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssessmentTplServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssessmentTpl>> queryPagedList(AssessmentTplVO sample) {
        Result<PagedList<AssessmentTpl>> result = new Result<>();
        PagedList<AssessmentTpl> list = assessmentTplService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assessmentTplService.dao().fill(list).with(AssessmentTplMeta.POSITION_LIST).execute();
        result.success(true).data(list);
        return result;
    }
}
