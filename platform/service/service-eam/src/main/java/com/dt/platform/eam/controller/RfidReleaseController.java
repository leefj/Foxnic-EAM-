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
import com.dt.platform.proxy.eam.RfidReleaseServiceProxy;
import com.dt.platform.domain.eam.meta.RfidReleaseVOMeta;
import com.dt.platform.domain.eam.RfidRelease;
import com.dt.platform.domain.eam.RfidReleaseVO;
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
import com.dt.platform.domain.eam.meta.RfidReleaseMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRfidReleaseService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * RFID发卡接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 18:17:32
 */
@InDoc
@Api(tags = "RFID发卡")
@RestController("EamRfidReleaseController")
public class RfidReleaseController extends SuperController {

    @Autowired
    private IRfidReleaseService rfidReleaseService;

    /**
     * 添加RFID发卡
     */
    @ApiOperation(value = "添加RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.INSERT)
    public Result insert(RfidReleaseVO rfidReleaseVO) {
        Result result = rfidReleaseService.insert(rfidReleaseVO, false);
        return result;
    }

    /**
     * 删除RFID发卡
     */
    @ApiOperation(value = "删除RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = rfidReleaseService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = rfidReleaseService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除RFID发卡 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = rfidReleaseService.hasRefers(ids);
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
            Result result = rfidReleaseService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = rfidReleaseService.deleteByIdsLogical(canDeleteIds);
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
     * 更新RFID发卡
     */
    @ApiOperation(value = "更新RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { RfidReleaseVOMeta.PAGE_INDEX, RfidReleaseVOMeta.PAGE_SIZE, RfidReleaseVOMeta.SEARCH_FIELD, RfidReleaseVOMeta.FUZZY_FIELD, RfidReleaseVOMeta.SEARCH_VALUE, RfidReleaseVOMeta.DIRTY_FIELDS, RfidReleaseVOMeta.SORT_FIELD, RfidReleaseVOMeta.SORT_TYPE, RfidReleaseVOMeta.DATA_ORIGIN, RfidReleaseVOMeta.QUERY_LOGIC, RfidReleaseVOMeta.REQUEST_ACTION, RfidReleaseVOMeta.IDS })
    @SentinelResource(value = RfidReleaseServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.UPDATE)
    public Result update(RfidReleaseVO rfidReleaseVO) {
        Result result = rfidReleaseService.update(rfidReleaseVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存RFID发卡
     */
    @ApiOperation(value = "保存RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { RfidReleaseVOMeta.PAGE_INDEX, RfidReleaseVOMeta.PAGE_SIZE, RfidReleaseVOMeta.SEARCH_FIELD, RfidReleaseVOMeta.FUZZY_FIELD, RfidReleaseVOMeta.SEARCH_VALUE, RfidReleaseVOMeta.DIRTY_FIELDS, RfidReleaseVOMeta.SORT_FIELD, RfidReleaseVOMeta.SORT_TYPE, RfidReleaseVOMeta.DATA_ORIGIN, RfidReleaseVOMeta.QUERY_LOGIC, RfidReleaseVOMeta.REQUEST_ACTION, RfidReleaseVOMeta.IDS })
    @SentinelResource(value = RfidReleaseServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.SAVE)
    public Result save(RfidReleaseVO rfidReleaseVO) {
        Result result = rfidReleaseService.save(rfidReleaseVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取RFID发卡
     */
    @ApiOperation(value = "获取RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.GET_BY_ID)
    public Result<RfidRelease> getById(String id) {
        Result<RfidRelease> result = new Result<>();
        RfidRelease rfidRelease = rfidReleaseService.getById(id);
        result.success(true).data(rfidRelease);
        return result;
    }

    /**
     * 批量获取RFID发卡 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.GET_BY_IDS)
    public Result<List<RfidRelease>> getByIds(List<String> ids) {
        Result<List<RfidRelease>> result = new Result<>();
        List<RfidRelease> list = rfidReleaseService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * RFID发卡 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "RFID发卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.RELEASE_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.RELEASE_DATA)
    public Result releaseData(String id) {
        return rfidReleaseService.releaseData(id);
    }


    /**
     * 查询RFID发卡
     */
    @ApiOperation(value = "查询RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { RfidReleaseVOMeta.PAGE_INDEX, RfidReleaseVOMeta.PAGE_SIZE })
    @SentinelResource(value = RfidReleaseServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.QUERY_LIST)
    public Result<List<RfidRelease>> queryList(RfidReleaseVO sample) {
        Result<List<RfidRelease>> result = new Result<>();
        List<RfidRelease> list = rfidReleaseService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询RFID发卡
     */
    @ApiOperation(value = "分页查询RFID发卡")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidReleaseVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidReleaseVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidReleaseServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidReleaseServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<RfidRelease>> queryPagedList(RfidReleaseVO sample) {
        Result<PagedList<RfidRelease>> result = new Result<>();
        PagedList<RfidRelease> list = rfidReleaseService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
