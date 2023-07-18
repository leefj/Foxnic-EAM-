package com.dt.platform.eam.controller;

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
import com.dt.platform.proxy.eam.RepairOrderTransferServiceProxy;
import com.dt.platform.domain.eam.meta.RepairOrderTransferVOMeta;
import com.dt.platform.domain.eam.RepairOrderTransfer;
import com.dt.platform.domain.eam.RepairOrderTransferVO;
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
import com.dt.platform.domain.eam.meta.RepairOrderTransferMeta;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.RepairOrder;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.RepairGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairOrderTransferService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 工单转派接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-18 06:39:30
 */
@InDoc
@Api(tags = "工单转派")
@RestController("EamRepairOrderTransferController")
public class RepairOrderTransferController extends SuperController {

    @Autowired
    private IRepairOrderTransferService repairOrderTransferService;

    /**
     * 添加工单转派
     */
    @ApiOperation(value = "添加工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ID, value = "申请工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.GROUP_ID, value = "维修班组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.EXECUTOR_ID, value = "维修人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.RULE, value = "规则", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderTransferServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.INSERT)
    public Result insert(RepairOrderTransferVO repairOrderTransferVO) {
        Result result = repairOrderTransferService.insert(repairOrderTransferVO, false);
        return result;
    }

    /**
     * 删除工单转派
     */
    @ApiOperation(value = "删除工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderTransferServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = repairOrderTransferService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = repairOrderTransferService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除工单转派 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderTransferServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = repairOrderTransferService.hasRefers(ids);
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
            Result result = repairOrderTransferService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = repairOrderTransferService.deleteByIdsLogical(canDeleteIds);
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
     * 更新工单转派
     */
    @ApiOperation(value = "更新工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ID, value = "申请工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.GROUP_ID, value = "维修班组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.EXECUTOR_ID, value = "维修人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.RULE, value = "规则", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { RepairOrderTransferVOMeta.PAGE_INDEX, RepairOrderTransferVOMeta.PAGE_SIZE, RepairOrderTransferVOMeta.SEARCH_FIELD, RepairOrderTransferVOMeta.FUZZY_FIELD, RepairOrderTransferVOMeta.SEARCH_VALUE, RepairOrderTransferVOMeta.DIRTY_FIELDS, RepairOrderTransferVOMeta.SORT_FIELD, RepairOrderTransferVOMeta.SORT_TYPE, RepairOrderTransferVOMeta.DATA_ORIGIN, RepairOrderTransferVOMeta.QUERY_LOGIC, RepairOrderTransferVOMeta.REQUEST_ACTION, RepairOrderTransferVOMeta.IDS })
    @SentinelResource(value = RepairOrderTransferServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.UPDATE)
    public Result update(RepairOrderTransferVO repairOrderTransferVO) {
        Result result = repairOrderTransferService.update(repairOrderTransferVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存工单转派
     */
    @ApiOperation(value = "保存工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ID, value = "申请工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.GROUP_ID, value = "维修班组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.EXECUTOR_ID, value = "维修人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.RULE, value = "规则", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { RepairOrderTransferVOMeta.PAGE_INDEX, RepairOrderTransferVOMeta.PAGE_SIZE, RepairOrderTransferVOMeta.SEARCH_FIELD, RepairOrderTransferVOMeta.FUZZY_FIELD, RepairOrderTransferVOMeta.SEARCH_VALUE, RepairOrderTransferVOMeta.DIRTY_FIELDS, RepairOrderTransferVOMeta.SORT_FIELD, RepairOrderTransferVOMeta.SORT_TYPE, RepairOrderTransferVOMeta.DATA_ORIGIN, RepairOrderTransferVOMeta.QUERY_LOGIC, RepairOrderTransferVOMeta.REQUEST_ACTION, RepairOrderTransferVOMeta.IDS })
    @SentinelResource(value = RepairOrderTransferServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.SAVE)
    public Result save(RepairOrderTransferVO repairOrderTransferVO) {
        Result result = repairOrderTransferService.save(repairOrderTransferVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取工单转派
     */
    @ApiOperation(value = "获取工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderTransferServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.GET_BY_ID)
    public Result<RepairOrderTransfer> getById(String id) {
        Result<RepairOrderTransfer> result = new Result<>();
        RepairOrderTransfer repairOrderTransfer = repairOrderTransferService.getById(id);
        // join 关联的对象
        repairOrderTransferService.dao().fill(repairOrderTransfer).with(RepairOrderTransferMeta.REPAIR_GROUP).with(RepairOrderTransferMeta.ORDER).with(RepairOrderTransferMeta.ORDER_ACT).with(RepairOrderTransferMeta.EXECUTOR).execute();
        result.success(true).data(repairOrderTransfer);
        return result;
    }

    /**
     * 批量获取工单转派 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderTransferServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.GET_BY_IDS)
    public Result<List<RepairOrderTransfer>> getByIds(List<String> ids) {
        Result<List<RepairOrderTransfer>> result = new Result<>();
        List<RepairOrderTransfer> list = repairOrderTransferService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询工单转派
     */
    @ApiOperation(value = "查询工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ID, value = "申请工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.GROUP_ID, value = "维修班组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.EXECUTOR_ID, value = "维修人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.RULE, value = "规则", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { RepairOrderTransferVOMeta.PAGE_INDEX, RepairOrderTransferVOMeta.PAGE_SIZE })
    @SentinelResource(value = RepairOrderTransferServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.QUERY_LIST)
    public Result<List<RepairOrderTransfer>> queryList(RepairOrderTransferVO sample) {
        Result<List<RepairOrderTransfer>> result = new Result<>();
        List<RepairOrderTransfer> list = repairOrderTransferService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询工单转派
     */
    @ApiOperation(value = "分页查询工单转派")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.ORDER_ID, value = "申请工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.GROUP_ID, value = "维修班组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.EXECUTOR_ID, value = "维修人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.RULE, value = "规则", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderTransferVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderTransferServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderTransferServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<RepairOrderTransfer>> queryPagedList(RepairOrderTransferVO sample) {
        Result<PagedList<RepairOrderTransfer>> result = new Result<>();
        PagedList<RepairOrderTransfer> list = repairOrderTransferService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        repairOrderTransferService.dao().fill(list).with(RepairOrderTransferMeta.REPAIR_GROUP).with(RepairOrderTransferMeta.ORDER).with(RepairOrderTransferMeta.ORDER_ACT).with(RepairOrderTransferMeta.EXECUTOR).execute();
        result.success(true).data(list);
        return result;
    }
}
