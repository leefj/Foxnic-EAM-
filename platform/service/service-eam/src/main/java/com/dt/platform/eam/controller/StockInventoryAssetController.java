package com.dt.platform.eam.controller;

import java.util.*;
import com.dt.platform.domain.eam.StockInventoryTask;
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
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
import com.dt.platform.proxy.eam.StockInventoryAssetServiceProxy;
import com.dt.platform.domain.eam.meta.StockInventoryAssetVOMeta;
import com.dt.platform.domain.eam.StockInventoryAsset;
import com.dt.platform.domain.eam.StockInventoryAssetVO;
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
import com.dt.platform.domain.eam.meta.StockInventoryAssetMeta;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IStockInventoryAssetService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存资产接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-05 20:02:47
 */
@InDoc
@Api(tags = "库存资产")
@RestController("EamStockInventoryAssetController")
public class StockInventoryAssetController extends SuperController {

    @Autowired
    private IStockInventoryAssetService stockInventoryAssetService;

    /**
     * 添加库存资产
     */
    @ApiOperation(value = "添加库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_NOTES, value = "盘点备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_NUMBER, value = "差异数量", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_ID, value = "盘点人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_TIME, value = "盘点时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.INSERT)
    public Result insert(StockInventoryAssetVO stockInventoryAssetVO) {
        Result result = stockInventoryAssetService.insert(stockInventoryAssetVO, false);
        return result;
    }

    /**
     * 删除库存资产
     */
    @ApiOperation(value = "删除库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = stockInventoryAssetService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = stockInventoryAssetService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除库存资产 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = stockInventoryAssetService.hasRefers(ids);
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
            Result result = stockInventoryAssetService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = stockInventoryAssetService.deleteByIdsLogical(canDeleteIds);
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
     * 更新库存资产
     */
    @ApiOperation(value = "更新库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_NOTES, value = "盘点备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_NUMBER, value = "差异数量", required = false, dataTypeClass =Integer.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_ID, value = "盘点人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_TIME, value = "盘点时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { StockInventoryAssetVOMeta.PAGE_INDEX, StockInventoryAssetVOMeta.PAGE_SIZE, StockInventoryAssetVOMeta.SEARCH_FIELD, StockInventoryAssetVOMeta.FUZZY_FIELD, StockInventoryAssetVOMeta.SEARCH_VALUE, StockInventoryAssetVOMeta.DIRTY_FIELDS, StockInventoryAssetVOMeta.SORT_FIELD, StockInventoryAssetVOMeta.SORT_TYPE, StockInventoryAssetVOMeta.DATA_ORIGIN, StockInventoryAssetVOMeta.QUERY_LOGIC, StockInventoryAssetVOMeta.REQUEST_ACTION, StockInventoryAssetVOMeta.IDS })
    @SentinelResource(value = StockInventoryAssetServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.UPDATE)
    public Result update(StockInventoryAssetVO stockInventoryAssetVO) {
        Result result = stockInventoryAssetService.update(stockInventoryAssetVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存库存资产
     */
    @ApiOperation(value = "保存库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_NOTES, value = "盘点备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_NUMBER, value = "差异数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_ID, value = "盘点人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_TIME, value = "盘点时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { StockInventoryAssetVOMeta.PAGE_INDEX, StockInventoryAssetVOMeta.PAGE_SIZE, StockInventoryAssetVOMeta.SEARCH_FIELD, StockInventoryAssetVOMeta.FUZZY_FIELD, StockInventoryAssetVOMeta.SEARCH_VALUE, StockInventoryAssetVOMeta.DIRTY_FIELDS, StockInventoryAssetVOMeta.SORT_FIELD, StockInventoryAssetVOMeta.SORT_TYPE, StockInventoryAssetVOMeta.DATA_ORIGIN, StockInventoryAssetVOMeta.QUERY_LOGIC, StockInventoryAssetVOMeta.REQUEST_ACTION, StockInventoryAssetVOMeta.IDS })
    @SentinelResource(value = StockInventoryAssetServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.SAVE)
    public Result save(StockInventoryAssetVO stockInventoryAssetVO) {
        Result result = stockInventoryAssetService.save(stockInventoryAssetVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取库存资产
     */
    @ApiOperation(value = "获取库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.GET_BY_ID)
    public Result<StockInventoryAsset> getById(String id) {
        Result<StockInventoryAsset> result = new Result<>();
        StockInventoryAsset stockInventoryAsset = stockInventoryAssetService.getById(id);
        // join 关联的对象
        stockInventoryAssetService.dao().fill(stockInventoryAsset).with("operUser").with(StockInventoryAssetMeta.GOODS_STOCK_ASSET).execute();
        stockInventoryAssetService.dao().join(stockInventoryAsset.getOperUser(), Person.class);
        stockInventoryAssetService.dao().fill(stockInventoryAsset.getGoodsStockAsset()).with("ownerCompany").with("useOrganization").with("manager").with("originator").with(GoodsStockMeta.COST_DICT).with(GoodsStockMeta.GOODS_BY_BRAND).with(GoodsStockMeta.GOODS_BY_MANUFACTURER).with(GoodsStockMeta.WAREHOUSE_POSITION).with(GoodsStockMeta.PARENT_GOODS_STOCK_LIST).with(GoodsStockMeta.SUB_GOODS_STOCK_LIST).with(GoodsStockMeta.CATEGORY).with(GoodsStockMeta.GOODS).with(GoodsStockMeta.SOURCE).with(GoodsStockMeta.WAREHOUSE).with(GoodsStockMeta.BRAND).with(GoodsStockMeta.MANUFACTURER).execute();
        if (stockInventoryAsset.getGoodsStockAsset() != null && stockInventoryAsset.getGoodsStockAsset().getGoods() != null) {
            stockInventoryAssetService.dao().fill(stockInventoryAsset.getGoodsStockAsset().getGoods()).with("brand").with("manufacturer").execute();
        }
        result.success(true).data(stockInventoryAsset);
        return result;
    }

    /**
     * 批量获取库存资产 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.GET_BY_IDS)
    public Result<List<StockInventoryAsset>> getByIds(List<String> ids) {
        Result<List<StockInventoryAsset>> result = new Result<>();
        List<StockInventoryAsset> list = stockInventoryAssetService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 批量获取库存资产 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取库存资产")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.QUERY_ASSET_BY_GOODS_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.QUERY_ASSET_BY_GOODS_ID)
    public Result<StockInventoryAsset> queryAssetByGoodsId(String taskId,String goodsId) {
        return stockInventoryAssetService.queryAssetByGoodsId(taskId,goodsId);
    }

    /**
     * 查询库存资产
     */
    @ApiOperation(value = "查询库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_NOTES, value = "盘点备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_NUMBER, value = "差异数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_ID, value = "盘点人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_TIME, value = "盘点时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { StockInventoryAssetVOMeta.PAGE_INDEX, StockInventoryAssetVOMeta.PAGE_SIZE })
    @SentinelResource(value = StockInventoryAssetServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.QUERY_LIST)
    public Result<List<StockInventoryAsset>> queryList(StockInventoryAssetVO sample) {
        Result<List<StockInventoryAsset>> result = new Result<>();
        List<StockInventoryAsset> list = stockInventoryAssetService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询库存资产
     */
    @ApiOperation(value = "分页查询库存资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.INVENTORY_NOTES, value = "盘点备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.ASSET_NUMBER, value = "差异数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_ID, value = "盘点人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.OPER_TIME, value = "盘点时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = StockInventoryAssetVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockInventoryAssetServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockInventoryAssetServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<StockInventoryAsset>> queryPagedList(StockInventoryAssetVO sample) {
        Result<PagedList<StockInventoryAsset>> result = new Result<>();
        PagedList<StockInventoryAsset> list = stockInventoryAssetService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        stockInventoryAssetService.dao().fill(list).with("operUser").with(StockInventoryAssetMeta.GOODS_STOCK_ASSET).execute();
        List<Employee> oUserList = CollectorUtil.collectList(list.getList(), StockInventoryAsset::getOperUser);
        stockInventoryAssetService.dao().join(oUserList, Person.class);

        List<GoodsStock> goodsStockList = CollectorUtil.collectList(list.getList(), StockInventoryAsset::getGoodsStockAsset);
        stockInventoryAssetService.dao().fill(goodsStockList).with("ownerCompany").with("useOrganization").with("manager").with("originator").with(GoodsStockMeta.COST_DICT).with(GoodsStockMeta.GOODS_BY_BRAND).with(GoodsStockMeta.GOODS_BY_MANUFACTURER).with(GoodsStockMeta.WAREHOUSE_POSITION).with(GoodsStockMeta.PARENT_GOODS_STOCK_LIST).with(GoodsStockMeta.SUB_GOODS_STOCK_LIST).with(GoodsStockMeta.CATEGORY).with(GoodsStockMeta.GOODS).with(GoodsStockMeta.SOURCE).with(GoodsStockMeta.WAREHOUSE).with(GoodsStockMeta.BRAND).with(GoodsStockMeta.MANUFACTURER).execute();
        List<GoodsStock> goodsList = CollectorUtil.collectList(goodsStockList, GoodsStock::getGoods);
        stockInventoryAssetService.dao().fill(goodsList).with("brand").with("manufacturer").execute();
        result.success(true).data(list);
        return result;
    }
}
