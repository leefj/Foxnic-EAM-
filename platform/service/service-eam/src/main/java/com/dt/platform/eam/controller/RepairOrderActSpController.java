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
import com.dt.platform.proxy.eam.RepairOrderActSpServiceProxy;
import com.dt.platform.domain.eam.meta.RepairOrderActSpVOMeta;
import com.dt.platform.domain.eam.RepairOrderActSp;
import com.dt.platform.domain.eam.RepairOrderActSpVO;
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
import com.dt.platform.domain.eam.meta.RepairOrderActSpMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairOrderActSpService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维修备件接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 15:16:56
 */
@InDoc
@Api(tags = "维修备件")
@RestController("EamRepairOrderActSpController")
public class RepairOrderActSpController extends SuperController {

    @Autowired
    private IRepairOrderActSpService repairOrderActSpService;

    /**
     * 添加维修备件
     */
    @ApiOperation(value = "添加维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_ID, value = "设备备件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_CODE, value = "备件编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NUMBER, value = "sp_number", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.INSERT)
    public Result insert(RepairOrderActSpVO repairOrderActSpVO) {
        Result result = repairOrderActSpService.insert(repairOrderActSpVO, false);
        return result;
    }

    /**
     * 删除维修备件
     */
    @ApiOperation(value = "删除维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = repairOrderActSpService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = repairOrderActSpService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除维修备件 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = repairOrderActSpService.hasRefers(ids);
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
            Result result = repairOrderActSpService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = repairOrderActSpService.deleteByIdsLogical(canDeleteIds);
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
     * 更新维修备件
     */
    @ApiOperation(value = "更新维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_ID, value = "设备备件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_CODE, value = "备件编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NUMBER, value = "sp_number", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { RepairOrderActSpVOMeta.PAGE_INDEX, RepairOrderActSpVOMeta.PAGE_SIZE, RepairOrderActSpVOMeta.SEARCH_FIELD, RepairOrderActSpVOMeta.FUZZY_FIELD, RepairOrderActSpVOMeta.SEARCH_VALUE, RepairOrderActSpVOMeta.DIRTY_FIELDS, RepairOrderActSpVOMeta.SORT_FIELD, RepairOrderActSpVOMeta.SORT_TYPE, RepairOrderActSpVOMeta.DATA_ORIGIN, RepairOrderActSpVOMeta.QUERY_LOGIC, RepairOrderActSpVOMeta.REQUEST_ACTION, RepairOrderActSpVOMeta.IDS })
    @SentinelResource(value = RepairOrderActSpServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.UPDATE)
    public Result update(RepairOrderActSpVO repairOrderActSpVO) {
        Result result = repairOrderActSpService.update(repairOrderActSpVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存维修备件
     */
    @ApiOperation(value = "保存维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_ID, value = "设备备件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_CODE, value = "备件编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NUMBER, value = "sp_number", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { RepairOrderActSpVOMeta.PAGE_INDEX, RepairOrderActSpVOMeta.PAGE_SIZE, RepairOrderActSpVOMeta.SEARCH_FIELD, RepairOrderActSpVOMeta.FUZZY_FIELD, RepairOrderActSpVOMeta.SEARCH_VALUE, RepairOrderActSpVOMeta.DIRTY_FIELDS, RepairOrderActSpVOMeta.SORT_FIELD, RepairOrderActSpVOMeta.SORT_TYPE, RepairOrderActSpVOMeta.DATA_ORIGIN, RepairOrderActSpVOMeta.QUERY_LOGIC, RepairOrderActSpVOMeta.REQUEST_ACTION, RepairOrderActSpVOMeta.IDS })
    @SentinelResource(value = RepairOrderActSpServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.SAVE)
    public Result save(RepairOrderActSpVO repairOrderActSpVO) {
        Result result = repairOrderActSpService.save(repairOrderActSpVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取维修备件
     */
    @ApiOperation(value = "获取维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.GET_BY_ID)
    public Result<RepairOrderActSp> getById(String id) {
        Result<RepairOrderActSp> result = new Result<>();
        RepairOrderActSp repairOrderActSp = repairOrderActSpService.getById(id);
        result.success(true).data(repairOrderActSp);
        return result;
    }

    /**
     * 批量获取维修备件 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.GET_BY_IDS)
    public Result<List<RepairOrderActSp>> getByIds(List<String> ids) {
        Result<List<RepairOrderActSp>> result = new Result<>();
        List<RepairOrderActSp> list = repairOrderActSpService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询维修备件
     */
    @ApiOperation(value = "查询维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_ID, value = "设备备件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_CODE, value = "备件编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NUMBER, value = "sp_number", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { RepairOrderActSpVOMeta.PAGE_INDEX, RepairOrderActSpVOMeta.PAGE_SIZE })
    @SentinelResource(value = RepairOrderActSpServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.QUERY_LIST)
    public Result<List<RepairOrderActSp>> queryList(RepairOrderActSpVO sample) {
        Result<List<RepairOrderActSp>> result = new Result<>();
        List<RepairOrderActSp> list = repairOrderActSpService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询维修备件
     */
    @ApiOperation(value = "分页查询维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_ID, value = "设备备件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_CODE, value = "备件编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NUMBER, value = "sp_number", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<RepairOrderActSp>> queryPagedList(RepairOrderActSpVO sample) {
        Result<PagedList<RepairOrderActSp>> result = new Result<>();
        PagedList<RepairOrderActSp> list = repairOrderActSpService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询维修备件
     */
    @ApiOperation(value = "分页查询维修备件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.ACT_ID, value = "维修工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_ID, value = "备件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_CODE, value = "备件编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SP_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RepairOrderActSpVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RepairOrderActSpServiceProxy.QUERY_SELECTED_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RepairOrderActSpServiceProxy.QUERY_SELECTED_PAGED_LIST)
    public Result<PagedList<RepairOrderActSp>> querySelectedPagedList(RepairOrderActSpVO sample) {
        Result<PagedList<RepairOrderActSp>> result = new Result<>();
        PagedList<RepairOrderActSp> list = repairOrderActSpService.querySelectedPagedList(sample);
        result.success(true).data(list);
        return result;
    }
}
