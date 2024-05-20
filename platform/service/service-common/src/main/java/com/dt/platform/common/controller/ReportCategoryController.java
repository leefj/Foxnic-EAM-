package com.dt.platform.common.controller;

import java.util.*;
import com.dt.platform.domain.eam.Position;
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
import com.dt.platform.proxy.common.ReportCategoryServiceProxy;
import com.dt.platform.domain.common.meta.ReportCategoryVOMeta;
import com.dt.platform.domain.common.ReportCategory;
import com.dt.platform.domain.common.ReportCategoryVO;
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
import com.dt.platform.domain.common.meta.ReportCategoryMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IReportCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 报表分类接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-19 12:06:29
 */
@InDoc
@Api(tags = "报表分类")
@RestController("SysReportCategoryController")
public class ReportCategoryController extends SuperController {

    @Autowired
    private IReportCategoryService reportCategoryService;

    /**
     * 添加报表分类
     */
    @ApiOperation(value = "添加报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
	 @ApiImplicitParam(name = ReportCategoryVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportCategoryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.INSERT)
    public Result insert(ReportCategoryVO reportCategoryVO) {
        reportCategoryVO.setSort(9999);
        if (StringUtil.isBlank(reportCategoryVO.getParentId())) {
            reportCategoryVO.setParentId("0");
        }
        Result result = reportCategoryService.insert(reportCategoryVO, false);
        if (result.success()) {
            ReportCategory currentPosition = new ReportCategory();
            currentPosition.setId(reportCategoryVO.getId());
            if ("0".equals(reportCategoryVO.getParentId())) {
                currentPosition.setHierarchy(reportCategoryVO.getId());
                currentPosition.setHierarchyName(reportCategoryVO.getName());
            } else {
                ReportCategory parentPosition = reportCategoryService.getById(reportCategoryVO.getParentId());
                currentPosition.setHierarchy(parentPosition.getHierarchy() + "/" + reportCategoryVO.getId());
                currentPosition.setHierarchyName(parentPosition.getHierarchyName() + "/" + reportCategoryVO.getName());
            }
            reportCategoryService.update(currentPosition, SaveMode.NOT_NULL_FIELDS);
            reportCategoryVO.setHierarchy(currentPosition.getHierarchy());
            reportCategoryVO.setHierarchyName(currentPosition.getHierarchyName());
            result.data(reportCategoryVO);
        }
        return result;
    }

    /**
     * 删除报表分类
     */
    @ApiOperation(value = "删除报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportCategoryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.DELETE)
    public Result deleteById(String id) {
        List<ReportCategory> list = reportCategoryService.queryList(ReportCategory.create().setParentId(id));
        if (list.size() > 0) {
            Result<ReportCategory> result = new Result<>();
            result.success(false).message("请先删除下级节点");
            return result;
        }
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = reportCategoryService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = reportCategoryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除报表分类 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportCategoryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = reportCategoryService.hasRefers(ids);
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
            Result result = reportCategoryService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = reportCategoryService.deleteByIdsLogical(canDeleteIds);
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
     * 更新报表分类
     */
    @ApiOperation(value = "更新报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = ReportCategoryVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { ReportCategoryVOMeta.PAGE_INDEX, ReportCategoryVOMeta.PAGE_SIZE, ReportCategoryVOMeta.SEARCH_FIELD, ReportCategoryVOMeta.FUZZY_FIELD, ReportCategoryVOMeta.SEARCH_VALUE, ReportCategoryVOMeta.DIRTY_FIELDS, ReportCategoryVOMeta.SORT_FIELD, ReportCategoryVOMeta.SORT_TYPE, ReportCategoryVOMeta.DATA_ORIGIN, ReportCategoryVOMeta.QUERY_LOGIC, ReportCategoryVOMeta.REQUEST_ACTION, ReportCategoryVOMeta.IDS })
    @SentinelResource(value = ReportCategoryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.UPDATE)
    public Result update(ReportCategoryVO reportCategoryVO) {
        Result result = reportCategoryService.update(reportCategoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            // 更新分类名称
            return reportCategoryService.updateHierarchy(reportCategoryVO.getId());
        }
        return result;
    }

    /**
     * 保存报表分类
     */
    @ApiOperation(value = "保存报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = ReportCategoryVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { ReportCategoryVOMeta.PAGE_INDEX, ReportCategoryVOMeta.PAGE_SIZE, ReportCategoryVOMeta.SEARCH_FIELD, ReportCategoryVOMeta.FUZZY_FIELD, ReportCategoryVOMeta.SEARCH_VALUE, ReportCategoryVOMeta.DIRTY_FIELDS, ReportCategoryVOMeta.SORT_FIELD, ReportCategoryVOMeta.SORT_TYPE, ReportCategoryVOMeta.DATA_ORIGIN, ReportCategoryVOMeta.QUERY_LOGIC, ReportCategoryVOMeta.REQUEST_ACTION, ReportCategoryVOMeta.IDS })
    @SentinelResource(value = ReportCategoryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.SAVE)
    public Result save(ReportCategoryVO reportCategoryVO) {
        Result result = reportCategoryService.save(reportCategoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取报表分类
     */
    @ApiOperation(value = "获取报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportCategoryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.GET_BY_ID)
    public Result<ReportCategory> getById(String id) {
        Result<ReportCategory> result = new Result<>();
        ReportCategory reportCategory = reportCategoryService.getById(id);

        result.success(true).data(reportCategory);
        return result;
    }

    /**
     * 批量获取报表分类 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportCategoryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.GET_BY_IDS)
    public Result<List<ReportCategory>> getByIds(List<String> ids) {
        Result<List<ReportCategory>> result = new Result<>();
        List<ReportCategory> list = reportCategoryService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询报表分类
     */
    @ApiOperation(value = "查询报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = ReportCategoryVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { ReportCategoryVOMeta.PAGE_INDEX, ReportCategoryVOMeta.PAGE_SIZE })
    @SentinelResource(value = ReportCategoryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.QUERY_LIST)
    public Result<List<ReportCategory>> queryList(ReportCategoryVO sample) {
        Result<List<ReportCategory>> result = new Result<>();
        List<ReportCategory> list = reportCategoryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询报表分类
     */
    @ApiOperation(value = "分页查询报表分类")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ReportCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
	 @ApiImplicitParam(name = ReportCategoryVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ReportCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ReportCategoryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ReportCategoryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ReportCategory>> queryPagedList(ReportCategoryVO sample) {
        Result<PagedList<ReportCategory>> result = new Result<>();
        PagedList<ReportCategory> list = reportCategoryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
