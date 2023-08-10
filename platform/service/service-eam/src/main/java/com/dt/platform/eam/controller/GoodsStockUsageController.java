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
import com.dt.platform.proxy.eam.GoodsStockUsageServiceProxy;
import com.dt.platform.domain.eam.meta.GoodsStockUsageVOMeta;
import com.dt.platform.domain.eam.GoodsStockUsage;
import com.dt.platform.domain.eam.GoodsStockUsageVO;
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
import com.dt.platform.domain.eam.meta.GoodsStockUsageMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IGoodsStockUsageService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 使用情况接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 14:57:00
 */
@InDoc
@Api(tags = "使用情况")
@RestController("EamGoodsStockUsageController")
public class GoodsStockUsageController extends SuperController {

    @Autowired
    private IGoodsStockUsageService goodsStockUsageService;

    /**
     * 添加使用情况
     */
    @ApiOperation(value = "添加使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.LABEL, value = "操作标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_NAME, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.BILL_CODE, value = "单据编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER, value = "操作", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockUsageServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.INSERT)
    public Result insert(GoodsStockUsageVO goodsStockUsageVO) {
        Result result = goodsStockUsageService.insert(goodsStockUsageVO, false);
        return result;
    }

    /**
     * 删除使用情况
     */
    @ApiOperation(value = "删除使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockUsageServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = goodsStockUsageService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = goodsStockUsageService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除使用情况 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockUsageServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = goodsStockUsageService.hasRefers(ids);
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
            Result result = goodsStockUsageService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = goodsStockUsageService.deleteByIdsLogical(canDeleteIds);
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
     * 更新使用情况
     */
    @ApiOperation(value = "更新使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.LABEL, value = "操作标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_NAME, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.BILL_CODE, value = "单据编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER, value = "操作", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { GoodsStockUsageVOMeta.PAGE_INDEX, GoodsStockUsageVOMeta.PAGE_SIZE, GoodsStockUsageVOMeta.SEARCH_FIELD, GoodsStockUsageVOMeta.FUZZY_FIELD, GoodsStockUsageVOMeta.SEARCH_VALUE, GoodsStockUsageVOMeta.DIRTY_FIELDS, GoodsStockUsageVOMeta.SORT_FIELD, GoodsStockUsageVOMeta.SORT_TYPE, GoodsStockUsageVOMeta.DATA_ORIGIN, GoodsStockUsageVOMeta.QUERY_LOGIC, GoodsStockUsageVOMeta.REQUEST_ACTION, GoodsStockUsageVOMeta.IDS })
    @SentinelResource(value = GoodsStockUsageServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.UPDATE)
    public Result update(GoodsStockUsageVO goodsStockUsageVO) {
        Result result = goodsStockUsageService.update(goodsStockUsageVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存使用情况
     */
    @ApiOperation(value = "保存使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.LABEL, value = "操作标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_NAME, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.BILL_CODE, value = "单据编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER, value = "操作", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { GoodsStockUsageVOMeta.PAGE_INDEX, GoodsStockUsageVOMeta.PAGE_SIZE, GoodsStockUsageVOMeta.SEARCH_FIELD, GoodsStockUsageVOMeta.FUZZY_FIELD, GoodsStockUsageVOMeta.SEARCH_VALUE, GoodsStockUsageVOMeta.DIRTY_FIELDS, GoodsStockUsageVOMeta.SORT_FIELD, GoodsStockUsageVOMeta.SORT_TYPE, GoodsStockUsageVOMeta.DATA_ORIGIN, GoodsStockUsageVOMeta.QUERY_LOGIC, GoodsStockUsageVOMeta.REQUEST_ACTION, GoodsStockUsageVOMeta.IDS })
    @SentinelResource(value = GoodsStockUsageServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.SAVE)
    public Result save(GoodsStockUsageVO goodsStockUsageVO) {
        Result result = goodsStockUsageService.save(goodsStockUsageVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取使用情况
     */
    @ApiOperation(value = "获取使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockUsageServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.GET_BY_ID)
    public Result<GoodsStockUsage> getById(String id) {
        Result<GoodsStockUsage> result = new Result<>();
        GoodsStockUsage goodsStockUsage = goodsStockUsageService.getById(id);
        // join 关联的对象
        goodsStockUsageService.dao().fill(goodsStockUsage).with("opsUser").execute();
        result.success(true).data(goodsStockUsage);
        return result;
    }

    /**
     * 批量获取使用情况 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockUsageServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.GET_BY_IDS)
    public Result<List<GoodsStockUsage>> getByIds(List<String> ids) {
        Result<List<GoodsStockUsage>> result = new Result<>();
        List<GoodsStockUsage> list = goodsStockUsageService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询使用情况
     */
    @ApiOperation(value = "查询使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.LABEL, value = "操作标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_NAME, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.BILL_CODE, value = "单据编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER, value = "操作", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { GoodsStockUsageVOMeta.PAGE_INDEX, GoodsStockUsageVOMeta.PAGE_SIZE })
    @SentinelResource(value = GoodsStockUsageServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.QUERY_LIST)
    public Result<List<GoodsStockUsage>> queryList(GoodsStockUsageVO sample) {
        Result<List<GoodsStockUsage>> result = new Result<>();
        List<GoodsStockUsage> list = goodsStockUsageService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询使用情况
     */
    @ApiOperation(value = "分页查询使用情况")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.LABEL, value = "操作标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_USER_NAME, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.BILL_CODE, value = "单据编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = GoodsStockUsageVOMeta.OPER, value = "操作", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockUsageServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockUsageServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<GoodsStockUsage>> queryPagedList(GoodsStockUsageVO sample) {
        Result<PagedList<GoodsStockUsage>> result = new Result<>();
        PagedList<GoodsStockUsage> list = goodsStockUsageService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        goodsStockUsageService.dao().fill(list).with("opsUser").execute();
        result.success(true).data(list);
        return result;
    }
}
