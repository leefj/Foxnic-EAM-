package com.dt.platform.eam.controller;

import java.util.*;
import com.dt.platform.proxy.eam.CheckItemServiceProxy;
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
import com.dt.platform.proxy.eam.CheckSelectServiceProxy;
import com.dt.platform.domain.eam.meta.CheckSelectVOMeta;
import com.dt.platform.domain.eam.CheckSelect;
import com.dt.platform.domain.eam.CheckSelectVO;
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
import com.dt.platform.domain.eam.meta.CheckSelectMeta;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.CheckItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICheckSelectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 检查项选择接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 13:51:58
 */
@InDoc
@Api(tags = "检查项选择")
@RestController("EamCheckSelectController")
public class CheckSelectController extends SuperController {

    @Autowired
    private ICheckSelectService checkSelectService;

    /**
     * 添加检查项选择
     */
    @ApiOperation(value = "添加检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_ID, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_NAME, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT, value = "检查结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.IF_CHECK, value = "是否检查", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT_META_DATA, value = "内容元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG_DEF_VALUE, value = "默认值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_CODE, value = "检查项编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_DESC, value = "检查项描述", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckSelectServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.INSERT)
    public Result insert(CheckSelectVO checkSelectVO) {
        Result result = checkSelectService.insert(checkSelectVO, false);
        return result;
    }

    /**
     * 删除检查项选择
     */
    @ApiOperation(value = "删除检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckSelectServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = checkSelectService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = checkSelectService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除检查项选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckSelectServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = checkSelectService.hasRefers(ids);
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
            Result result = checkSelectService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = checkSelectService.deleteByIdsLogical(canDeleteIds);
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
     * 更新检查项选择
     */
    @ApiOperation(value = "更新检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_ID, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_NAME, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT, value = "检查结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.IF_CHECK, value = "是否检查", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT_META_DATA, value = "内容元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG_DEF_VALUE, value = "默认值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_CODE, value = "检查项编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_DESC, value = "检查项描述", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CheckSelectVOMeta.PAGE_INDEX, CheckSelectVOMeta.PAGE_SIZE, CheckSelectVOMeta.SEARCH_FIELD, CheckSelectVOMeta.FUZZY_FIELD, CheckSelectVOMeta.SEARCH_VALUE, CheckSelectVOMeta.DIRTY_FIELDS, CheckSelectVOMeta.SORT_FIELD, CheckSelectVOMeta.SORT_TYPE, CheckSelectVOMeta.DATA_ORIGIN, CheckSelectVOMeta.QUERY_LOGIC, CheckSelectVOMeta.REQUEST_ACTION, CheckSelectVOMeta.IDS })
    @SentinelResource(value = CheckSelectServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.UPDATE)
    public Result update(CheckSelectVO checkSelectVO) {
        Result result = checkSelectService.update(checkSelectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存检查项选择
     */
    @ApiOperation(value = "保存检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_ID, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_NAME, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT, value = "检查结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.IF_CHECK, value = "是否检查", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT_META_DATA, value = "内容元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG_DEF_VALUE, value = "默认值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_CODE, value = "检查项编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_DESC, value = "检查项描述", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CheckSelectVOMeta.PAGE_INDEX, CheckSelectVOMeta.PAGE_SIZE, CheckSelectVOMeta.SEARCH_FIELD, CheckSelectVOMeta.FUZZY_FIELD, CheckSelectVOMeta.SEARCH_VALUE, CheckSelectVOMeta.DIRTY_FIELDS, CheckSelectVOMeta.SORT_FIELD, CheckSelectVOMeta.SORT_TYPE, CheckSelectVOMeta.DATA_ORIGIN, CheckSelectVOMeta.QUERY_LOGIC, CheckSelectVOMeta.REQUEST_ACTION, CheckSelectVOMeta.IDS })
    @SentinelResource(value = CheckSelectServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.SAVE)
    public Result save(CheckSelectVO checkSelectVO) {
        Result result = checkSelectService.save(checkSelectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取检查项选择
     */
    @ApiOperation(value = "获取检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckSelectServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.GET_BY_ID)
    public Result<CheckSelect> getById(String id) {
        Result<CheckSelect> result = new Result<>();
        CheckSelect checkSelect = checkSelectService.getById(id);
        // join 关联的对象
        checkSelectService.dao().fill(checkSelect).with(CheckSelectMeta.CHECK_ITEM).execute();
        result.success(true).data(checkSelect);
        return result;
    }

    /**
     * 批量获取检查项选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckSelectServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.GET_BY_IDS)
    public Result<List<CheckSelect>> getByIds(List<String> ids) {
        Result<List<CheckSelect>> result = new Result<>();
        List<CheckSelect> list = checkSelectService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询检查项选择
     */
    @ApiOperation(value = "查询检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_ID, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_NAME, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT, value = "检查结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.IF_CHECK, value = "是否检查", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT_META_DATA, value = "内容元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG_DEF_VALUE, value = "默认值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_CODE, value = "检查项编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_DESC, value = "检查项描述", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CheckSelectVOMeta.PAGE_INDEX, CheckSelectVOMeta.PAGE_SIZE })
    @SentinelResource(value = CheckSelectServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.QUERY_LIST)
    public Result<List<CheckSelect>> queryList(CheckSelectVO sample) {
        Result<List<CheckSelect>> result = new Result<>();
        List<CheckSelect> list = checkSelectService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询检查项选择
     */
    @ApiOperation(value = "分页查询检查项选择")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_ID, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_NAME, value = "检查项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT, value = "检查结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.IF_CHECK, value = "是否检查", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TASK_POINT_ID, value = "巡检点位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.RESULT_META_DATA, value = "内容元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.CONFIG_DEF_VALUE, value = "默认值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_CODE, value = "检查项编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckSelectVOMeta.ITEM_DESC, value = "检查项描述", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckSelectServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckSelectServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CheckSelect>> queryPagedList(CheckSelectVO sample) {
        Result<PagedList<CheckSelect>> result = new Result<>();
        PagedList<CheckSelect> list = checkSelectService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        checkSelectService.dao().fill(list).with(CheckSelectMeta.CHECK_ITEM).execute();
        result.success(true).data(list);
        return result;
    }
}
