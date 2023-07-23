package com.dt.platform.eam.controller;

import java.util.*;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.domain.hrm.Person;
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
import com.dt.platform.proxy.eam.DeviceSpServiceProxy;
import com.dt.platform.domain.eam.meta.DeviceSpVOMeta;
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
import com.dt.platform.domain.eam.meta.DeviceSpMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IDeviceSpService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 备件清单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:59:13
 */
@InDoc
@Api(tags = "备件清单")
@RestController("EamDeviceSpController")
public class DeviceSpController extends SuperController {

    @Autowired
    private IDeviceSpService deviceSpService;

    /**
     * 添加备件清单
     */
    @ApiOperation(value = "添加备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.GOOD_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MODEL, value = "规格型号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.INSERT)
    public Result insert(DeviceSpVO deviceSpVO) {
        Result result = deviceSpService.insert(deviceSpVO, false);
        return result;
    }

    /**
     * 删除备件清单
     */
    @ApiOperation(value = "删除备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = deviceSpService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = deviceSpService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除备件清单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = deviceSpService.hasRefers(ids);
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
            Result result = deviceSpService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = deviceSpService.deleteByIdsLogical(canDeleteIds);
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
     * 更新备件清单
     */
    @ApiOperation(value = "更新备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.GOOD_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MODEL, value = "规格型号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { DeviceSpVOMeta.PAGE_INDEX, DeviceSpVOMeta.PAGE_SIZE, DeviceSpVOMeta.SEARCH_FIELD, DeviceSpVOMeta.FUZZY_FIELD, DeviceSpVOMeta.SEARCH_VALUE, DeviceSpVOMeta.DIRTY_FIELDS, DeviceSpVOMeta.SORT_FIELD, DeviceSpVOMeta.SORT_TYPE, DeviceSpVOMeta.DATA_ORIGIN, DeviceSpVOMeta.QUERY_LOGIC, DeviceSpVOMeta.REQUEST_ACTION, DeviceSpVOMeta.IDS })
    @SentinelResource(value = DeviceSpServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.UPDATE)
    public Result update(DeviceSpVO deviceSpVO) {
        Result result = deviceSpService.update(deviceSpVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存备件清单
     */
    @ApiOperation(value = "保存备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.GOOD_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MODEL, value = "规格型号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { DeviceSpVOMeta.PAGE_INDEX, DeviceSpVOMeta.PAGE_SIZE, DeviceSpVOMeta.SEARCH_FIELD, DeviceSpVOMeta.FUZZY_FIELD, DeviceSpVOMeta.SEARCH_VALUE, DeviceSpVOMeta.DIRTY_FIELDS, DeviceSpVOMeta.SORT_FIELD, DeviceSpVOMeta.SORT_TYPE, DeviceSpVOMeta.DATA_ORIGIN, DeviceSpVOMeta.QUERY_LOGIC, DeviceSpVOMeta.REQUEST_ACTION, DeviceSpVOMeta.IDS })
    @SentinelResource(value = DeviceSpServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.SAVE)
    public Result save(DeviceSpVO deviceSpVO) {
        Result result = deviceSpService.save(deviceSpVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取备件清单
     */
    @ApiOperation(value = "获取备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.GET_BY_ID)
    public Result<DeviceSp> getById(String id) {
        Result<DeviceSp> result = new Result<>();
        DeviceSp deviceSp = deviceSpService.getById(id);
        // join 关联的对象
        deviceSpService.dao().fill(deviceSp).with("manager").with(DeviceSpMeta.GOODS).with(DeviceSpMeta.USAGE).with(DeviceSpMeta.DEVICE_SP_TYPE).with(DeviceSpMeta.POSITION).execute();
        result.success(true).data(deviceSp);
        return result;
    }

    /**
     * 获取备件清单
     */
    @ApiOperation(value = "批量确认")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.BATCH_SURE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.BATCH_SURE)
    public Result batchSure(String ids) {
        return deviceSpService.batchSure(ids);
    }

    /**
     * 批量获取备件清单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.GET_BY_IDS)
    public Result<List<DeviceSp>> getByIds(List<String> ids) {
        Result<List<DeviceSp>> result = new Result<>();
        List<DeviceSp> list = deviceSpService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "保存ids")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.SAVE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.SAVE_BY_IDS)
    public Result saveByIds(String ownerId, String ownerType, String ids, String selectedCode) {
        return deviceSpService.saveByIds(ownerId, ownerType, ids, selectedCode);
    }

    /**
     * 查询备件清单
     */
    @ApiOperation(value = "查询备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.GOOD_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MODEL, value = "规格型号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { DeviceSpVOMeta.PAGE_INDEX, DeviceSpVOMeta.PAGE_SIZE })
    @SentinelResource(value = DeviceSpServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.QUERY_LIST)
    public Result<List<DeviceSp>> queryList(DeviceSpVO sample) {
        Result<List<DeviceSp>> result = new Result<>();
        List<DeviceSp> list = deviceSpService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询备件清单
     */
    @ApiOperation(value = "分页查询备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.GOOD_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MODEL, value = "规格型号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DeviceSp>> queryPagedList(DeviceSpVO sample) {
        Result<PagedList<DeviceSp>> result = new Result<>();
        PagedList<DeviceSp> list=null;
        ConditionExpr expr=new ConditionExpr();
        expr.and("1=1");
        if(!StringUtil.isBlank(sample.getPsCategoryId())){
            expr.and("good_id in (select id from eam_goods_stock where category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%"+sample.getPsCategoryId()+"%' or id=?)) )",sample.getPsCategoryId());
        }

        list= deviceSpService.queryPagedList(sample,expr, sample.getPageSize(), sample.getPageIndex());

        // join 关联的对象
        deviceSpService.dao().fill(list).with("manager").with(DeviceSpMeta.GOODS).with(DeviceSpMeta.USAGE).with(DeviceSpMeta.DEVICE_SP_TYPE).with(DeviceSpMeta.POSITION).execute();
        deviceSpService.join(list, DeviceSpMeta.MANAGER);
        List<Employee> managerList = CollectorUtil.collectList(list, DeviceSp::getManager);
        deviceSpService.dao().join(managerList, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询备件清单
     */
    @ApiOperation(value = "分页查询备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.QUERY_SELECT_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.QUERY_SELECT_PAGED_LIST)
    public Result<PagedList<DeviceSp>> querySelectPagedList(DeviceSpVO sample) {
        Result<PagedList<DeviceSp>> result = new Result<>();
        PagedList<DeviceSp> list = deviceSpService.querySelectPagedList(sample);
        // join 关联的对象
        deviceSpService.dao().fill(list).with(DeviceSpMeta.GOODS).with(DeviceSpMeta.USAGE).with(DeviceSpMeta.DEVICE_SP_TYPE).with(DeviceSpMeta.POSITION).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询备件清单
     */
    @ApiOperation(value = "分页查询备件清单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.CODE, value = "备件编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.TYPE, value = "备件分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.STATUS, value = "备件状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NAME, value = "备件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SN, value = "备件序列", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SOURCE_DESC, value = "来源描述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOC_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.MANAGER_USER_ID, value = "保管人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.INSERT_TIME, value = "入库时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.USAGE_RANGE, value = "使用场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.SUPPLIER, value = "供应厂商", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DeviceSpVOMeta.ADAPTING_DEVICE, value = "适配设备", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DeviceSpServiceProxy.QUERY_SELECTED_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DeviceSpServiceProxy.QUERY_SELECTED_PAGED_LIST)
    public Result<PagedList<DeviceSp>> querySelectedPagedList(DeviceSpVO sample) {
        Result<PagedList<DeviceSp>> result = new Result<>();
        PagedList<DeviceSp> list = deviceSpService.querySelectedPagedList(sample);
        // join 关联的对象
        deviceSpService.dao().fill(list).with("manager").with(DeviceSpMeta.GOODS).with(DeviceSpMeta.USAGE).with(DeviceSpMeta.DEVICE_SP_TYPE).with(DeviceSpMeta.POSITION).execute();
        deviceSpService.join(list, DeviceSpMeta.MANAGER);
        List<Employee> managerList = CollectorUtil.collectList(list, DeviceSp::getManager);
        deviceSpService.dao().join(managerList, Person.class);
        result.success(true).data(list);
        return result;
    }
}
