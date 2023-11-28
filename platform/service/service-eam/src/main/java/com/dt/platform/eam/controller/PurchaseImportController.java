package com.dt.platform.eam.controller;

import java.util.*;
import com.dt.platform.domain.eam.*;
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
import com.dt.platform.proxy.eam.PurchaseImportServiceProxy;
import com.dt.platform.domain.eam.meta.PurchaseImportVOMeta;
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
import com.dt.platform.domain.eam.meta.PurchaseImportMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPurchaseImportService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 采购单导入接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-25 21:35:08
 */
@InDoc
@Api(tags = "采购单导入")
@RestController("EamPurchaseImportController")
public class PurchaseImportController extends SuperController {

    @Autowired
    private IPurchaseImportService purchaseImportService;

    /**
     * 添加采购单导入
     */
    @ApiOperation(value = "添加采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_ID, value = "采购单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.INSERT)
    public Result insert(PurchaseImportVO purchaseImportVO) {
        Result result = purchaseImportService.insert(purchaseImportVO, false);
        return result;
    }

    @ApiOperation(value = "从采购单导入资产")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.LOAD_ASSET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.LOAD_ASSET)
    public Result roadAsset(String id) {
        Result result = purchaseImportService.loadAsset(id);
        return result;
    }

    @ApiOperation(value = "取消")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.CANCEL)
    public Result cancel(String id) {
        Result result = purchaseImportService.cancel(id);
        return result;
    }

    @ApiOperation(value = "确认")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.SURE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.SURE)
    public Result sure(String id) {
        Result result = purchaseImportService.sure(id);
        return result;
    }

    @ApiOperation(value = "填充")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.FILL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.FILL)
    public Result fill(PurchaseImportVO purchaseImportVO) {
        Result result = purchaseImportService.fill(purchaseImportVO);
        return result;
    }

    /**
     * 删除采购单导入
     */
    @ApiOperation(value = "删除采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = purchaseImportService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = purchaseImportService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除采购单导入 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = purchaseImportService.hasRefers(ids);
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
            Result result = purchaseImportService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = purchaseImportService.deleteByIdsLogical(canDeleteIds);
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
     * 更新采购单导入
     */
    @ApiOperation(value = "更新采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_ID, value = "采购单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PurchaseImportVOMeta.PAGE_INDEX, PurchaseImportVOMeta.PAGE_SIZE, PurchaseImportVOMeta.SEARCH_FIELD, PurchaseImportVOMeta.FUZZY_FIELD, PurchaseImportVOMeta.SEARCH_VALUE, PurchaseImportVOMeta.DIRTY_FIELDS, PurchaseImportVOMeta.SORT_FIELD, PurchaseImportVOMeta.SORT_TYPE, PurchaseImportVOMeta.DATA_ORIGIN, PurchaseImportVOMeta.QUERY_LOGIC, PurchaseImportVOMeta.REQUEST_ACTION, PurchaseImportVOMeta.IDS })
    @SentinelResource(value = PurchaseImportServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.UPDATE)
    public Result update(PurchaseImportVO purchaseImportVO) {
        Result result = purchaseImportService.update(purchaseImportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存采购单导入
     */
    @ApiOperation(value = "保存采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_ID, value = "采购单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PurchaseImportVOMeta.PAGE_INDEX, PurchaseImportVOMeta.PAGE_SIZE, PurchaseImportVOMeta.SEARCH_FIELD, PurchaseImportVOMeta.FUZZY_FIELD, PurchaseImportVOMeta.SEARCH_VALUE, PurchaseImportVOMeta.DIRTY_FIELDS, PurchaseImportVOMeta.SORT_FIELD, PurchaseImportVOMeta.SORT_TYPE, PurchaseImportVOMeta.DATA_ORIGIN, PurchaseImportVOMeta.QUERY_LOGIC, PurchaseImportVOMeta.REQUEST_ACTION, PurchaseImportVOMeta.IDS })
    @SentinelResource(value = PurchaseImportServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.SAVE)
    public Result save(PurchaseImportVO purchaseImportVO) {
        Result result = purchaseImportService.save(purchaseImportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取采购单导入
     */
    @ApiOperation(value = "获取采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.GET_BY_ID)
    public Result<PurchaseImport> getById(String id) {
        Result<PurchaseImport> result = new Result<>();
        PurchaseImport purchaseImport = purchaseImportService.getById(id);
        // join 关联的对象
        purchaseImportService.dao().fill(purchaseImport).with("operUser").with(PurchaseImportMeta.MANAGER).with(PurchaseImportMeta.USE_USER).with(PurchaseImportMeta.OWNER_COMPANY).with(PurchaseImportMeta.USE_ORGANIZATION).with(PurchaseImportMeta.PURCHASE_APPLY).with(PurchaseImportMeta.POSITION).execute();
        purchaseImportService.dao().join(purchaseImport.getUseUser(), Person.class);
        purchaseImportService.dao().join(purchaseImport.getManager(), Person.class);
        purchaseImportService.dao().join(purchaseImport.getOperUser(), Person.class);
        result.success(true).data(purchaseImport);
        return result;
    }

    /**
     * 批量获取采购单导入 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.GET_BY_IDS)
    public Result<List<PurchaseImport>> getByIds(List<String> ids) {
        Result<List<PurchaseImport>> result = new Result<>();
        List<PurchaseImport> list = purchaseImportService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询采购单导入
     */
    @ApiOperation(value = "查询采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_ID, value = "采购单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PurchaseImportVOMeta.PAGE_INDEX, PurchaseImportVOMeta.PAGE_SIZE })
    @SentinelResource(value = PurchaseImportServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.QUERY_LIST)
    public Result<List<PurchaseImport>> queryList(PurchaseImportVO sample) {
        Result<List<PurchaseImport>> result = new Result<>();
        List<PurchaseImport> list = purchaseImportService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询采购单导入
     */
    @ApiOperation(value = "分页查询采购单导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_ID, value = "采购单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_CODE, value = "订单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.IMPORT_TO_TYPE, value = "导入类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.MANAGER_ID, value = "管理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.POSITION_ID, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.PURCHASE_DATE, value = "采购日期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ORDER_NAME, value = "订单名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseImportVOMeta.ASSET_NOTES, value = "资产备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PurchaseImportServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseImportServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PurchaseImport>> queryPagedList(PurchaseImportVO sample) {
        Result<PagedList<PurchaseImport>> result = new Result<>();
        PagedList<PurchaseImport> list = purchaseImportService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        purchaseImportService.dao().fill(list).with("operUser").with(PurchaseImportMeta.MANAGER).with(PurchaseImportMeta.USE_USER).with(PurchaseImportMeta.OWNER_COMPANY).with(PurchaseImportMeta.USE_ORGANIZATION).with(PurchaseImportMeta.PURCHASE_APPLY).with(PurchaseImportMeta.POSITION).execute();
        List<Employee> ususers = CollectorUtil.collectList(list, PurchaseImport::getUseUser);
        purchaseImportService.dao().join(ususers, Person.class);
        List<Employee> managers = CollectorUtil.collectList(list, PurchaseImport::getManager);
        purchaseImportService.dao().join(managers, Person.class);
        List<Employee> operUsers = CollectorUtil.collectList(list, PurchaseImport::getOperUser);
        purchaseImportService.dao().join(operUsers, Person.class);
        result.success(true).data(list);
        return result;
    }
}
