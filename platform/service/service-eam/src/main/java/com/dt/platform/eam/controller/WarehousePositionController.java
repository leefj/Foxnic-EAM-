package com.dt.platform.eam.controller;

import java.util.*;
import com.alibaba.fastjson.JSONArray;
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
import com.dt.platform.proxy.eam.WarehousePositionServiceProxy;
import com.dt.platform.domain.eam.meta.WarehousePositionVOMeta;
import com.dt.platform.domain.eam.WarehousePosition;
import com.dt.platform.domain.eam.WarehousePositionVO;
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
import com.dt.platform.domain.eam.meta.WarehousePositionMeta;
import com.dt.platform.domain.eam.Warehouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IWarehousePositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 仓库库位接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-18 07:22:00
 */
@InDoc
@Api(tags = "仓库库位")
@RestController("EamWarehousePositionController")
public class WarehousePositionController extends SuperController {

    @Autowired
    private IWarehousePositionService warehousePositionService;

    /**
     * 添加仓库库位
     */
    @ApiOperation(value = "添加仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.WAREHOUSE_ID, value = "仓库", required = false, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "def"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NAME, value = "库位", required = false, dataTypeClass = String.class, example = "默认库存"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.MAXIMUM_CAPACITY, value = "最大容量", required = false, dataTypeClass = Integer.class, example = "2000")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.INSERT)
    public Result insert(WarehousePositionVO warehousePositionVO) {
        Result result = warehousePositionService.insert(warehousePositionVO, false);
        return result;
    }

    /**
     * 删除仓库库位
     */
    @ApiOperation(value = "删除仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "558599358870716416")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = warehousePositionService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = warehousePositionService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除仓库库位 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = warehousePositionService.hasRefers(ids);
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
            Result result = warehousePositionService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = warehousePositionService.deleteByIdsLogical(canDeleteIds);
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
     * 更新仓库库位
     */
    @ApiOperation(value = "更新仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.WAREHOUSE_ID, value = "仓库", required = false, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "def"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NAME, value = "库位", required = false, dataTypeClass = String.class, example = "默认库存"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.MAXIMUM_CAPACITY, value = "最大容量", required = false, dataTypeClass = Integer.class, example = "2000")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { WarehousePositionVOMeta.PAGE_INDEX, WarehousePositionVOMeta.PAGE_SIZE, WarehousePositionVOMeta.SEARCH_FIELD, WarehousePositionVOMeta.FUZZY_FIELD, WarehousePositionVOMeta.SEARCH_VALUE, WarehousePositionVOMeta.DIRTY_FIELDS, WarehousePositionVOMeta.SORT_FIELD, WarehousePositionVOMeta.SORT_TYPE, WarehousePositionVOMeta.DATA_ORIGIN, WarehousePositionVOMeta.QUERY_LOGIC, WarehousePositionVOMeta.REQUEST_ACTION, WarehousePositionVOMeta.IDS })
    @SentinelResource(value = WarehousePositionServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.UPDATE)
    public Result update(WarehousePositionVO warehousePositionVO) {
        Result result = warehousePositionService.update(warehousePositionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存仓库库位
     */
    @ApiOperation(value = "保存仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.WAREHOUSE_ID, value = "仓库", required = false, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "def"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NAME, value = "库位", required = false, dataTypeClass = String.class, example = "默认库存"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.MAXIMUM_CAPACITY, value = "最大容量", required = false, dataTypeClass = Integer.class, example = "2000")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { WarehousePositionVOMeta.PAGE_INDEX, WarehousePositionVOMeta.PAGE_SIZE, WarehousePositionVOMeta.SEARCH_FIELD, WarehousePositionVOMeta.FUZZY_FIELD, WarehousePositionVOMeta.SEARCH_VALUE, WarehousePositionVOMeta.DIRTY_FIELDS, WarehousePositionVOMeta.SORT_FIELD, WarehousePositionVOMeta.SORT_TYPE, WarehousePositionVOMeta.DATA_ORIGIN, WarehousePositionVOMeta.QUERY_LOGIC, WarehousePositionVOMeta.REQUEST_ACTION, WarehousePositionVOMeta.IDS })
    @SentinelResource(value = WarehousePositionServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.SAVE)
    public Result save(WarehousePositionVO warehousePositionVO) {
        Result result = warehousePositionService.save(warehousePositionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取仓库库位
     */
    @ApiOperation(value = "获取仓库库位")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.QUERY_TREE_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.QUERY_TREE_DATA)
    public JSONArray queryTreeData(String id, String method) {
        return warehousePositionService.queryTreeData(id, method);
    }

    /**
     * 获取仓库库位
     */
    @ApiOperation(value = "获取仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.GET_BY_ID)
    public Result<WarehousePosition> getById(String id) {
        Result<WarehousePosition> result = new Result<>();
        WarehousePosition warehousePosition = warehousePositionService.getById(id);
        // join 关联的对象
        warehousePositionService.dao().fill(warehousePosition).with(WarehousePositionMeta.WAREHOUSE).execute();
        result.success(true).data(warehousePosition);
        return result;
    }

    /**
     * 批量获取仓库库位 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.GET_BY_IDS)
    public Result<List<WarehousePosition>> getByIds(List<String> ids) {
        Result<List<WarehousePosition>> result = new Result<>();
        List<WarehousePosition> list = warehousePositionService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询仓库库位
     */
    @ApiOperation(value = "查询仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.WAREHOUSE_ID, value = "仓库", required = false, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "def"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NAME, value = "库位", required = false, dataTypeClass = String.class, example = "默认库存"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.MAXIMUM_CAPACITY, value = "最大容量", required = false, dataTypeClass = Integer.class, example = "2000")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { WarehousePositionVOMeta.PAGE_INDEX, WarehousePositionVOMeta.PAGE_SIZE })
    @SentinelResource(value = WarehousePositionServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.QUERY_LIST)
    public Result<List<WarehousePosition>> queryList(WarehousePositionVO sample) {
        Result<List<WarehousePosition>> result = new Result<>();
        List<WarehousePosition> list = warehousePositionService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询仓库库位
     */
    @ApiOperation(value = "分页查询仓库库位")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WarehousePositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.WAREHOUSE_ID, value = "仓库", required = false, dataTypeClass = String.class, example = "558599358870716416"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "def"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NAME, value = "库位", required = false, dataTypeClass = String.class, example = "默认库存"),
		@ApiImplicitParam(name = WarehousePositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WarehousePositionVOMeta.MAXIMUM_CAPACITY, value = "最大容量", required = false, dataTypeClass = Integer.class, example = "2000")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WarehousePositionServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WarehousePositionServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<WarehousePosition>> queryPagedList(WarehousePositionVO sample) {
        Result<PagedList<WarehousePosition>> result = new Result<>();
        PagedList<WarehousePosition> list = warehousePositionService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        warehousePositionService.dao().fill(list).with(WarehousePositionMeta.WAREHOUSE).execute();
        result.success(true).data(list);
        return result;
    }
}
