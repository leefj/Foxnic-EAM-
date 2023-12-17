package com.dt.platform.eam.controller;

import java.util.*;


import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.GoodsStockRelated;
import com.dt.platform.domain.eam.GoodsStockRelatedVO;
import com.dt.platform.domain.eam.GoodsStockVO;
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import com.dt.platform.domain.eam.meta.GoodsStockRelatedVOMeta;
import org.github.foxnic.web.domain.hrm.Employee;
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
import com.dt.platform.proxy.eam.GoodsStockRelatedServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.api.error.ErrorDesc;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.dt.platform.eam.service.IGoodsStockRelatedService;

/**
 * <p>
 * 父子关联接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-17 09:50:48
 */
@InDoc
@Api(tags = "父子关联")
@RestController("EamGoodsStockRelatedController")
public class GoodsStockRelatedController extends SuperController {

    @Autowired
    private IGoodsStockRelatedService goodsStockRelatedService;

    /**
     * 添加父子关联
     */
    @ApiOperation(value = "添加父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.GOODS_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.PARENT_GOODS_ID, value = "父物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.SELECT_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.INSERT)
    public Result insert(GoodsStockRelatedVO goodsStockRelatedVO) {
        Result result = goodsStockRelatedService.insert(goodsStockRelatedVO, false);
        return result;
    }

    /**
     * 删除父子关联
     */
    @ApiOperation(value = "删除父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = goodsStockRelatedService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = goodsStockRelatedService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除父子关联 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = goodsStockRelatedService.hasRefers(ids);
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
            Result result = goodsStockRelatedService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = goodsStockRelatedService.deleteByIdsLogical(canDeleteIds);
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
     * 更新父子关联
     */
    @ApiOperation(value = "更新父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.GOODS_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.PARENT_GOODS_ID, value = "父物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.SELECT_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { GoodsStockRelatedVOMeta.PAGE_INDEX, GoodsStockRelatedVOMeta.PAGE_SIZE, GoodsStockRelatedVOMeta.SEARCH_FIELD, GoodsStockRelatedVOMeta.FUZZY_FIELD, GoodsStockRelatedVOMeta.SEARCH_VALUE, GoodsStockRelatedVOMeta.DIRTY_FIELDS, GoodsStockRelatedVOMeta.SORT_FIELD, GoodsStockRelatedVOMeta.SORT_TYPE, GoodsStockRelatedVOMeta.DATA_ORIGIN, GoodsStockRelatedVOMeta.QUERY_LOGIC, GoodsStockRelatedVOMeta.REQUEST_ACTION, GoodsStockRelatedVOMeta.IDS })
    @SentinelResource(value = GoodsStockRelatedServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.UPDATE)
    public Result update(GoodsStockRelatedVO goodsStockRelatedVO) {
        Result result = goodsStockRelatedService.update(goodsStockRelatedVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存父子关联
     */
    @ApiOperation(value = "保存父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.GOODS_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.PARENT_GOODS_ID, value = "父物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.SELECT_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { GoodsStockRelatedVOMeta.PAGE_INDEX, GoodsStockRelatedVOMeta.PAGE_SIZE, GoodsStockRelatedVOMeta.SEARCH_FIELD, GoodsStockRelatedVOMeta.FUZZY_FIELD, GoodsStockRelatedVOMeta.SEARCH_VALUE, GoodsStockRelatedVOMeta.DIRTY_FIELDS, GoodsStockRelatedVOMeta.SORT_FIELD, GoodsStockRelatedVOMeta.SORT_TYPE, GoodsStockRelatedVOMeta.DATA_ORIGIN, GoodsStockRelatedVOMeta.QUERY_LOGIC, GoodsStockRelatedVOMeta.REQUEST_ACTION, GoodsStockRelatedVOMeta.IDS })
    @SentinelResource(value = GoodsStockRelatedServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.SAVE)
    public Result save(GoodsStockRelatedVO goodsStockRelatedVO) {
        Result result = goodsStockRelatedService.save(goodsStockRelatedVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取父子关联
     */
    @ApiOperation(value = "获取父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.GET_BY_ID)
    public Result<GoodsStockRelated> getById(String id) {
        Result<GoodsStockRelated> result = new Result<>();
        GoodsStockRelated goodsStockRelated = goodsStockRelatedService.getById(id);
        result.success(true).data(goodsStockRelated);
        return result;
    }

    /**
     * 批量获取父子关联 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.GET_BY_IDS)
    public Result<List<GoodsStockRelated>> getByIds(List<String> ids) {
        Result<List<GoodsStockRelated>> result = new Result<>();
        List<GoodsStockRelated> list = goodsStockRelatedService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询父子关联
     */
    @ApiOperation(value = "查询父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.GOODS_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.PARENT_GOODS_ID, value = "父物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.SELECT_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { GoodsStockRelatedVOMeta.PAGE_INDEX, GoodsStockRelatedVOMeta.PAGE_SIZE })
    @SentinelResource(value = GoodsStockRelatedServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.QUERY_LIST)
    public Result<List<GoodsStockRelated>> queryList(GoodsStockRelatedVO sample) {
        Result<List<GoodsStockRelated>> result = new Result<>();
        List<GoodsStockRelated> list = goodsStockRelatedService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询父子关联
     */
    @ApiOperation(value = "分页查询父子关联")
    @ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.GOODS_ID, value = "物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.PARENT_GOODS_ID, value = "父物品", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = GoodsStockRelatedVOMeta.SELECT_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<GoodsStockRelated>> queryPagedList(GoodsStockRelatedVO sample) {
        Result<PagedList<GoodsStockRelated>> result = new Result<>();
        PagedList<GoodsStockRelated> list = goodsStockRelatedService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = GoodsStockRelatedServiceProxy.SELECT_DELETE_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.SELECT_DELETE_BY_ID)
    public Result selectDeleteById(String ownerId, String id, String selectCode) {
        return goodsStockRelatedService.selectDeleteById(ownerId, id, selectCode);
    }

    /**
     * 分页查询保养项目
     */
    @ApiOperation(value = "分页查询项目")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 10)
    @SentinelResource(value = GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST_BY_SELECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST_BY_SELECT)
    public Result<PagedList<GoodsStock>> queryPagedListBySelect(GoodsStockVO sample) {
        Result<PagedList<GoodsStock>> result = new Result<>();
        PagedList<GoodsStock> list = goodsStockRelatedService.queryPagedListBySelect(sample);

       // join 关联的对象
        goodsStockRelatedService.dao().fill(list).with("ownerCompany").with("useOrganization").with("manager").with("originator").with(GoodsStockMeta.SUB_GOODS_STOCK_LIST).with(GoodsStockMeta.PARENT_GOODS_STOCK_LIST).with(GoodsStockMeta.CATEGORY).with(GoodsStockMeta.GOODS).with(GoodsStockMeta.SOURCE).with(GoodsStockMeta.WAREHOUSE).with(GoodsStockMeta.BRAND).with(GoodsStockMeta.MANUFACTURER).execute();
        List<Employee> originatorList = CollectorUtil.collectList(list, GoodsStock::getOriginator);
        goodsStockRelatedService.dao().join(originatorList, Person.class);

        List<Employee> managerList = CollectorUtil.collectList(list, GoodsStock::getManager);
        goodsStockRelatedService.dao().join(managerList, Person.class);
        result.success(true).data(list);

        return result;
    }

    /**
     * 分页查询保养项目
     */
    @ApiOperation(value = "分页查询项目")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 11)
    @SentinelResource(value = GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST_BY_SELECTED, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST_BY_SELECTED)
    public Result<PagedList<GoodsStock>> queryPagedListBySelected(GoodsStockVO sample) {
        Result<PagedList<GoodsStock>> result = new Result<>();
        PagedList<GoodsStock> list = goodsStockRelatedService.queryPagedListBySelected(sample);
        // join 关联的对象
        goodsStockRelatedService.dao().fill(list).with("ownerCompany").with("useOrganization").with("manager").with("originator").with(GoodsStockMeta.SUB_GOODS_STOCK_LIST).with(GoodsStockMeta.PARENT_GOODS_STOCK_LIST).with(GoodsStockMeta.CATEGORY).with(GoodsStockMeta.GOODS).with(GoodsStockMeta.SOURCE).with(GoodsStockMeta.WAREHOUSE).with(GoodsStockMeta.BRAND).with(GoodsStockMeta.MANUFACTURER).execute();
        List<Employee> originatorList = CollectorUtil.collectList(list, GoodsStock::getOriginator);
        goodsStockRelatedService.dao().join(originatorList, Person.class);

        List<Employee> managerList = CollectorUtil.collectList(list, GoodsStock::getManager);
        goodsStockRelatedService.dao().join(managerList, Person.class);
        result.success(true).data(list);
        return result;
    }


}
