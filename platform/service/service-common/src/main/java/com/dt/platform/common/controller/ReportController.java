package com.dt.platform.common.controller;

import java.util.*;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
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
import com.dt.platform.proxy.common.ReportServiceProxy;
import com.dt.platform.domain.common.meta.ReportVOMeta;
import com.dt.platform.domain.common.Report;
import com.dt.platform.domain.common.ReportVO;
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
import com.dt.platform.domain.common.meta.ReportMeta;
import com.dt.platform.domain.common.ReportCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IReportService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 报表列接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-19 13:01:27
 */
@InDoc
@Api(tags = "报表列")
@RestController("SysReportController")
public class ReportController extends SuperController {

    @Autowired
    private IReportService reportService;

    /**
     * 添加报表列
     */
    @ApiOperation(value = "添加报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "711914370904358912"),
		@ApiImplicitParam(name = ReportVOMeta.CATALOG_ID, value = "分类", required = false, dataTypeClass = String.class, example = "681879879808974848"),
		@ApiImplicitParam(name = ReportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ReportVOMeta.ROUTE, value = "路径", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_DEF_ID, value = "报表设计", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.INSERT)
    public Result insert(ReportVO reportVO) {
        if (StringUtil.isBlank(reportVO.getCode())) {
            reportVO.setCode(IDGenerator.getSnowflakeIdString());
        }
        Result result = reportService.insert(reportVO, false);
        return result;
    }

    /**
     * 删除报表列
     */
    @ApiOperation(value = "删除报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "711914370904358912")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = reportService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = reportService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除报表列 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = reportService.hasRefers(ids);
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
            Result result = reportService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = reportService.deleteByIdsLogical(canDeleteIds);
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
     * 更新报表列
     */
    @ApiOperation(value = "更新报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "711914370904358912"),
		@ApiImplicitParam(name = ReportVOMeta.CATALOG_ID, value = "分类", required = false, dataTypeClass = String.class, example = "681879879808974848"),
		@ApiImplicitParam(name = ReportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ReportVOMeta.ROUTE, value = "路径", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_DEF_ID, value = "报表设计", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { ReportVOMeta.PAGE_INDEX, ReportVOMeta.PAGE_SIZE, ReportVOMeta.SEARCH_FIELD, ReportVOMeta.FUZZY_FIELD, ReportVOMeta.SEARCH_VALUE, ReportVOMeta.DIRTY_FIELDS, ReportVOMeta.SORT_FIELD, ReportVOMeta.SORT_TYPE, ReportVOMeta.DATA_ORIGIN, ReportVOMeta.QUERY_LOGIC, ReportVOMeta.REQUEST_ACTION, ReportVOMeta.IDS })
    @SentinelResource(value = ReportServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.UPDATE)
    public Result update(ReportVO reportVO) {
        if (StringUtil.isBlank(reportVO.getCode())) {
            reportVO.setCode(IDGenerator.getSnowflakeIdString());
        }
        Result result = reportService.update(reportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存报表列
     */
    @ApiOperation(value = "保存报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "711914370904358912"),
		@ApiImplicitParam(name = ReportVOMeta.CATALOG_ID, value = "分类", required = false, dataTypeClass = String.class, example = "681879879808974848"),
		@ApiImplicitParam(name = ReportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ReportVOMeta.ROUTE, value = "路径", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_DEF_ID, value = "报表设计", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { ReportVOMeta.PAGE_INDEX, ReportVOMeta.PAGE_SIZE, ReportVOMeta.SEARCH_FIELD, ReportVOMeta.FUZZY_FIELD, ReportVOMeta.SEARCH_VALUE, ReportVOMeta.DIRTY_FIELDS, ReportVOMeta.SORT_FIELD, ReportVOMeta.SORT_TYPE, ReportVOMeta.DATA_ORIGIN, ReportVOMeta.QUERY_LOGIC, ReportVOMeta.REQUEST_ACTION, ReportVOMeta.IDS })
    @SentinelResource(value = ReportServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.SAVE)
    public Result save(ReportVO reportVO) {
        Result result = reportService.save(reportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取报表列
     */
    @ApiOperation(value = "获取报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.GET_BY_ID)
    public Result<Report> getById(String id) {
        Result<Report> result = new Result<>();
        Report report = reportService.getById(id);
        // join 关联的对象
        reportService.dao().fill(report).with(ReportMeta.REPORT_CATEGORY).with(ReportMeta.REPORT_TPL).execute();
        result.success(true).data(report);
        return result;
    }

    /**
     * 批量获取报表列 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.GET_BY_IDS)
    public Result<List<Report>> getByIds(List<String> ids) {
        Result<List<Report>> result = new Result<>();
        List<Report> list = reportService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询报表列
     */
    @ApiOperation(value = "查询报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "711914370904358912"),
		@ApiImplicitParam(name = ReportVOMeta.CATALOG_ID, value = "分类", required = false, dataTypeClass = String.class, example = "681879879808974848"),
		@ApiImplicitParam(name = ReportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ReportVOMeta.ROUTE, value = "路径", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_DEF_ID, value = "报表设计", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { ReportVOMeta.PAGE_INDEX, ReportVOMeta.PAGE_SIZE })
    @SentinelResource(value = ReportServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.QUERY_LIST)
    public Result<List<Report>> queryList(ReportVO sample) {
        Result<List<Report>> result = new Result<>();
        List<Report> list = reportService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询报表列
     */
    @ApiOperation(value = "分页查询报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "711914370904358912"),
		@ApiImplicitParam(name = ReportVOMeta.CATALOG_ID, value = "分类", required = false, dataTypeClass = String.class, example = "681879879808974848"),
		@ApiImplicitParam(name = ReportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ReportVOMeta.ROUTE, value = "路径", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = ReportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.REPORT_TPL_DEF_ID, value = "报表设计", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class, example = "110588348101165911")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Report>> queryPagedList(ReportVO sample) {
        Result<PagedList<Report>> result = new Result<>();
        PagedList<Report> list = reportService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        reportService.dao().fill(list).with(ReportMeta.REPORT_CATEGORY).with(ReportMeta.REPORT_TPL).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 获取报表列
     */
    @ApiOperation(value = "获取报表列")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportServiceProxy.COPY_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportServiceProxy.COPY_DATA)
    public Result copyData(String id) {
        return reportService.copyData(id);
    }
}
