package com.dt.platform.eam.controller;

import java.util.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.proxy.eam.PurchaseImportServiceProxy;
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
import com.dt.platform.proxy.eam.StockImportServiceProxy;
import com.dt.platform.domain.eam.meta.StockImportVOMeta;
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
import com.dt.platform.domain.eam.meta.StockImportMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.meta.PurchaseImportMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IStockImportService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存导入资产接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-28 09:07:16
 */
@InDoc
@Api(tags = "库存导入资产")
@RestController("EamStockImportController")
public class StockImportController extends SuperController {

    @Autowired
    private IStockImportService stockImportService;

    /**
     * 添加库存导入资产
     */
    @ApiOperation(value = "添加库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_ID, value = "库存单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.INSERT)
    public Result insert(StockImportVO stockImportVO) {
        Result result = stockImportService.insert(stockImportVO, false);
        return result;
    }

    /**
     * 删除库存导入资产
     */
    @ApiOperation(value = "删除库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = stockImportService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = stockImportService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除库存导入资产 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = stockImportService.hasRefers(ids);
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
            Result result = stockImportService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = stockImportService.deleteByIdsLogical(canDeleteIds);
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
     * 更新库存导入资产
     */
    @ApiOperation(value = "更新库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_ID, value = "库存单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { StockImportVOMeta.PAGE_INDEX, StockImportVOMeta.PAGE_SIZE, StockImportVOMeta.SEARCH_FIELD, StockImportVOMeta.FUZZY_FIELD, StockImportVOMeta.SEARCH_VALUE, StockImportVOMeta.DIRTY_FIELDS, StockImportVOMeta.SORT_FIELD, StockImportVOMeta.SORT_TYPE, StockImportVOMeta.DATA_ORIGIN, StockImportVOMeta.QUERY_LOGIC, StockImportVOMeta.REQUEST_ACTION, StockImportVOMeta.IDS })
    @SentinelResource(value = StockImportServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.UPDATE)
    public Result update(StockImportVO stockImportVO) {
        Result result = stockImportService.update(stockImportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存库存导入资产
     */
    @ApiOperation(value = "保存库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_ID, value = "库存单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { StockImportVOMeta.PAGE_INDEX, StockImportVOMeta.PAGE_SIZE, StockImportVOMeta.SEARCH_FIELD, StockImportVOMeta.FUZZY_FIELD, StockImportVOMeta.SEARCH_VALUE, StockImportVOMeta.DIRTY_FIELDS, StockImportVOMeta.SORT_FIELD, StockImportVOMeta.SORT_TYPE, StockImportVOMeta.DATA_ORIGIN, StockImportVOMeta.QUERY_LOGIC, StockImportVOMeta.REQUEST_ACTION, StockImportVOMeta.IDS })
    @SentinelResource(value = StockImportServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.SAVE)
    public Result save(StockImportVO stockImportVO) {
        Result result = stockImportService.save(stockImportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取库存导入资产
     */
    @ApiOperation(value = "获取库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.GET_BY_ID)
    public Result<StockImport> getById(String id) {
        Result<StockImport> result = new Result<>();
        StockImport stockImport = stockImportService.getById(id);
        // join 关联的对象
        stockImportService.dao().fill(stockImport).with(StockImportMeta.STOCK_GOODS_OUT).with("ownerCompany").with("ownerCompany").with("useOrganization").with("useUser").with("manager").with("operUser").with(PurchaseImportMeta.POSITION).execute();
        result.success(true).data(stockImport);
        return result;
    }

    /**
     * 批量获取库存导入资产 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.GET_BY_IDS)
    public Result<List<StockImport>> getByIds(List<String> ids) {
        Result<List<StockImport>> result = new Result<>();
        List<StockImport> list = stockImportService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询库存导入资产
     */
    @ApiOperation(value = "查询库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_ID, value = "库存单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { StockImportVOMeta.PAGE_INDEX, StockImportVOMeta.PAGE_SIZE })
    @SentinelResource(value = StockImportServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.QUERY_LIST)
    public Result<List<StockImport>> queryList(StockImportVO sample) {
        Result<List<StockImport>> result = new Result<>();
        List<StockImport> list = stockImportService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询库存导入资产
     */
    @ApiOperation(value = "分页查询库存导入资产")
    @ApiImplicitParams({
		@ApiImplicitParam(name = StockImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_ID, value = "库存单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = StockImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<StockImport>> queryPagedList(StockImportVO sample) {
        Result<PagedList<StockImport>> result = new Result<>();
        PagedList<StockImport> list = stockImportService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        stockImportService.dao().fill(list).with(StockImportMeta.STOCK_GOODS_OUT).with("ownerCompany").with("useOrganization").with("useUser").with("manager").with("operUser").with(PurchaseImportMeta.POSITION).execute();
        result.success(true).data(list);
        return result;
    }

    @ApiOperation(value = "从采购单导入资产")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.LOAD_ASSET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.LOAD_ASSET)
    public Result roadAsset(String id) {
        Result result = stockImportService.loadAsset(id);
        return result;
    }

    @ApiOperation(value = "取消")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.CANCEL)
    public Result cancel(String id) {
        Result result = stockImportService.cancel(id);
        return result;
    }

    @ApiOperation(value = "确认")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.SURE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.SURE)
    public Result sure(String id) {
        Result result = stockImportService.sure(id);
        return result;
    }

    @ApiOperation(value = "填充")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = StockImportServiceProxy.FILL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(StockImportServiceProxy.FILL)
    public Result fill(StockImportVO stockImportVO) {
        Result result = stockImportService.fill(stockImportVO);
        return result;
    }
}
