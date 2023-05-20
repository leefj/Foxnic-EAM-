package com.dt.platform.common.controller;

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
import com.dt.platform.proxy.common.ReportUDefServiceProxy;
import com.dt.platform.domain.common.meta.ReportUDefVOMeta;
import com.dt.platform.domain.common.ReportUDef;
import com.dt.platform.domain.common.ReportUDefVO;
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
import com.dt.platform.domain.common.meta.ReportUDefMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IReportUDefService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 报表定义接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-20 09:03:31
 */
@InDoc
@Api(tags = "报表定义")
@RestController("SysReportUDefController")
public class ReportUDefController extends SuperController {

    @Autowired
    private IReportUDefService reportUDefService;

    /**
     * 添加报表定义
     */
    @ApiOperation(value = "添加报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "712226160926261248"),
		@ApiImplicitParam(name = ReportUDefVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12345.ureport.xml"),
		@ApiImplicitParam(name = ReportUDefVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = ReportUDefVOMeta.OWNER_TYPE, value = "所属类型", required = false, dataTypeClass = String.class, example = "inst")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportUDefServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.INSERT)
    public Result insert(ReportUDefVO reportUDefVO) {
        Result result = reportUDefService.insert(reportUDefVO, false);
        return result;
    }

    /**
     * 删除报表定义
     */
    @ApiOperation(value = "删除报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "712226160926261248")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportUDefServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = reportUDefService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = reportUDefService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除报表定义 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportUDefServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = reportUDefService.hasRefers(ids);
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
            Result result = reportUDefService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = reportUDefService.deleteByIdsLogical(canDeleteIds);
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
     * 更新报表定义
     */
    @ApiOperation(value = "更新报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "712226160926261248"),
		@ApiImplicitParam(name = ReportUDefVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12345.ureport.xml"),
		@ApiImplicitParam(name = ReportUDefVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = ReportUDefVOMeta.OWNER_TYPE, value = "所属类型", required = false, dataTypeClass = String.class, example = "inst")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { ReportUDefVOMeta.PAGE_INDEX, ReportUDefVOMeta.PAGE_SIZE, ReportUDefVOMeta.SEARCH_FIELD, ReportUDefVOMeta.FUZZY_FIELD, ReportUDefVOMeta.SEARCH_VALUE, ReportUDefVOMeta.DIRTY_FIELDS, ReportUDefVOMeta.SORT_FIELD, ReportUDefVOMeta.SORT_TYPE, ReportUDefVOMeta.DATA_ORIGIN, ReportUDefVOMeta.QUERY_LOGIC, ReportUDefVOMeta.REQUEST_ACTION, ReportUDefVOMeta.IDS })
    @SentinelResource(value = ReportUDefServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.UPDATE)
    public Result update(ReportUDefVO reportUDefVO) {
        Result result = reportUDefService.update(reportUDefVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存报表定义
     */
    @ApiOperation(value = "保存报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "712226160926261248"),
		@ApiImplicitParam(name = ReportUDefVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12345.ureport.xml"),
		@ApiImplicitParam(name = ReportUDefVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = ReportUDefVOMeta.OWNER_TYPE, value = "所属类型", required = false, dataTypeClass = String.class, example = "inst")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { ReportUDefVOMeta.PAGE_INDEX, ReportUDefVOMeta.PAGE_SIZE, ReportUDefVOMeta.SEARCH_FIELD, ReportUDefVOMeta.FUZZY_FIELD, ReportUDefVOMeta.SEARCH_VALUE, ReportUDefVOMeta.DIRTY_FIELDS, ReportUDefVOMeta.SORT_FIELD, ReportUDefVOMeta.SORT_TYPE, ReportUDefVOMeta.DATA_ORIGIN, ReportUDefVOMeta.QUERY_LOGIC, ReportUDefVOMeta.REQUEST_ACTION, ReportUDefVOMeta.IDS })
    @SentinelResource(value = ReportUDefServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.SAVE)
    public Result save(ReportUDefVO reportUDefVO) {
        Result result = reportUDefService.save(reportUDefVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取报表定义
     */
    @ApiOperation(value = "获取报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportUDefServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.GET_BY_ID)
    public Result<ReportUDef> getById(String id) {
        Result<ReportUDef> result = new Result<>();
        ReportUDef reportUDef = reportUDefService.getById(id);
        result.success(true).data(reportUDef);
        return result;
    }

    /**
     * 批量获取报表定义 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportUDefServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.GET_BY_IDS)
    public Result<List<ReportUDef>> getByIds(List<String> ids) {
        Result<List<ReportUDef>> result = new Result<>();
        List<ReportUDef> list = reportUDefService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询报表定义
     */
    @ApiOperation(value = "查询报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "712226160926261248"),
		@ApiImplicitParam(name = ReportUDefVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12345.ureport.xml"),
		@ApiImplicitParam(name = ReportUDefVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = ReportUDefVOMeta.OWNER_TYPE, value = "所属类型", required = false, dataTypeClass = String.class, example = "inst")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { ReportUDefVOMeta.PAGE_INDEX, ReportUDefVOMeta.PAGE_SIZE })
    @SentinelResource(value = ReportUDefServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.QUERY_LIST)
    public Result<List<ReportUDef>> queryList(ReportUDefVO sample) {
        Result<List<ReportUDef>> result = new Result<>();
        List<ReportUDef> list = reportUDefService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询报表定义
     */
    @ApiOperation(value = "分页查询报表定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportUDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "712226160926261248"),
		@ApiImplicitParam(name = ReportUDefVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12345.ureport.xml"),
		@ApiImplicitParam(name = ReportUDefVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = ""),
		@ApiImplicitParam(name = ReportUDefVOMeta.OWNER_TYPE, value = "所属类型", required = false, dataTypeClass = String.class, example = "inst")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportUDefServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportUDefServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ReportUDef>> queryPagedList(ReportUDefVO sample) {
        Result<PagedList<ReportUDef>> result = new Result<>();
        PagedList<ReportUDef> list = reportUDefService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
