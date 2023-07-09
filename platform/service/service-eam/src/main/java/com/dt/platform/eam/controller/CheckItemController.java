package com.dt.platform.eam.controller;

import java.util.*;
import com.github.foxnic.sql.expr.ConditionExpr;
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
import com.dt.platform.proxy.eam.CheckItemServiceProxy;
import com.dt.platform.domain.eam.meta.CheckItemVOMeta;
import com.dt.platform.domain.eam.CheckItem;
import com.dt.platform.domain.eam.CheckItemVO;
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
import com.dt.platform.domain.eam.meta.CheckItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICheckItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 检查项接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 15:25:23
 */
@InDoc
@Api(tags = "检查项")
@RestController("EamCheckItemController")
public class CheckItemController extends SuperController {

    @Autowired
    private ICheckItemService checkItemService;

    /**
     * 添加检查项
     */
    @ApiOperation(value = "添加检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = CheckItemVOMeta.CHECK_DESC, value = "描述", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.INSERT)
    public Result insert(CheckItemVO checkItemVO) {
        Result result = checkItemService.insert(checkItemVO, false);
        return result;
    }

    /**
     * 删除检查项
     */
    @ApiOperation(value = "删除检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = checkItemService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = checkItemService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除检查项 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = checkItemService.hasRefers(ids);
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
            Result result = checkItemService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = checkItemService.deleteByIdsLogical(canDeleteIds);
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
     * 更新检查项
     */
    @ApiOperation(value = "更新检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = CheckItemVOMeta.CHECK_DESC, value = "描述", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CheckItemVOMeta.PAGE_INDEX, CheckItemVOMeta.PAGE_SIZE, CheckItemVOMeta.SEARCH_FIELD, CheckItemVOMeta.FUZZY_FIELD, CheckItemVOMeta.SEARCH_VALUE, CheckItemVOMeta.DIRTY_FIELDS, CheckItemVOMeta.SORT_FIELD, CheckItemVOMeta.SORT_TYPE, CheckItemVOMeta.DATA_ORIGIN, CheckItemVOMeta.QUERY_LOGIC, CheckItemVOMeta.REQUEST_ACTION, CheckItemVOMeta.IDS })
    @SentinelResource(value = CheckItemServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.UPDATE)
    public Result update(CheckItemVO checkItemVO) {
        Result result = checkItemService.update(checkItemVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存检查项
     */
    @ApiOperation(value = "保存检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = CheckItemVOMeta.CHECK_DESC, value = "描述", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CheckItemVOMeta.PAGE_INDEX, CheckItemVOMeta.PAGE_SIZE, CheckItemVOMeta.SEARCH_FIELD, CheckItemVOMeta.FUZZY_FIELD, CheckItemVOMeta.SEARCH_VALUE, CheckItemVOMeta.DIRTY_FIELDS, CheckItemVOMeta.SORT_FIELD, CheckItemVOMeta.SORT_TYPE, CheckItemVOMeta.DATA_ORIGIN, CheckItemVOMeta.QUERY_LOGIC, CheckItemVOMeta.REQUEST_ACTION, CheckItemVOMeta.IDS })
    @SentinelResource(value = CheckItemServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.SAVE)
    public Result save(CheckItemVO checkItemVO) {
        Result result = checkItemService.save(checkItemVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取检查项
     */
    @ApiOperation(value = "获取检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.GET_BY_ID)
    public Result<CheckItem> getById(String id) {
        Result<CheckItem> result = new Result<>();
        CheckItem checkItem = checkItemService.getById(id);
        result.success(true).data(checkItem);
        return result;
    }

    /**
     * 批量获取检查项 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.GET_BY_IDS)
    public Result<List<CheckItem>> getByIds(List<String> ids) {
        Result<List<CheckItem>> result = new Result<>();
        List<CheckItem> list = checkItemService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询检查项
     */
    @ApiOperation(value = "查询检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = CheckItemVOMeta.CHECK_DESC, value = "描述", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CheckItemVOMeta.PAGE_INDEX, CheckItemVOMeta.PAGE_SIZE })
    @SentinelResource(value = CheckItemServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.QUERY_LIST)
    public Result<List<CheckItem>> queryList(CheckItemVO sample) {
        Result<List<CheckItem>> result = new Result<>();
        List<CheckItem> list = checkItemService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),

		@ApiImplicitParam(name = CheckItemVOMeta.CHECK_DESC, value = "描述", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CheckItem>> queryPagedList(CheckItemVO sample) {
        Result<PagedList<CheckItem>> result = new Result<>();
        PagedList<CheckItem> list = checkItemService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.QUERY_SELECT_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.QUERY_SELECT_PAGED_LIST)
    public Result<PagedList<CheckItem>> querySelectPagedList(CheckItemVO sample, String ownerId, String selectCode) {
        Result<PagedList<CheckItem>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        expr.and("id not in (select item_id from eam_inspection_point_item where deleted=0 and point_id=? and select_code=?)", ownerId, selectCode);
        PagedList<CheckItem> list = checkItemService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CheckItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "728972909854326784"),
		@ApiImplicitParam(name = CheckItemVOMeta.OWNER, value = "归属", required = false, dataTypeClass = String.class, example = "INSPECT"),
		@ApiImplicitParam(name = CheckItemVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CheckItemVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "检查项目1"),
		@ApiImplicitParam(name = CheckItemVOMeta.TYPE, value = "组件类型", required = false, dataTypeClass = String.class, example = "input"),
		@ApiImplicitParam(name = CheckItemVOMeta.CONFIG, value = "配置项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CheckItemVOMeta.DEF_VALUE, value = "默认内容", required = false, dataTypeClass = String.class, example = "正常"),
		@ApiImplicitParam(name = CheckItemVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.QUERY_SELECTED_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.QUERY_SELECTED_PAGED_LIST)
    public Result<PagedList<CheckItem>> querySelectedPagedList(CheckItemVO sample, String ownerId, String selectCode) {
        Result<PagedList<CheckItem>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        if (checkItemService.dao().queryRecord("select count(1) cnt from eam_inspection_point_item where deleted=0 and point_id=? and select_code=?", ownerId, selectCode).getInteger("cnt") == 0) {
            // 做一份转
            String sql = "insert into eam_inspection_point_item(id,point_id,item_id,deleted,select_code)  select uuid(),point_id,item_id,0,'" + selectCode + "' from eam_inspection_point_item where deleted=0 and point_id=? and (select_code='' or select_code is null)  ";
            checkItemService.dao().execute(sql, ownerId);
        }
        expr.and("id in (select item_id from eam_inspection_point_item where deleted=0 and point_id=? and select_code=?)", ownerId, selectCode);
        PagedList<CheckItem> list = checkItemService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.SELECT_SAVE_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.SELECT_SAVE_IDS)
    public Result selectSaveIds(String ownerId, String ids, String selectCode) {
        return checkItemService.selectSaveIds(ownerId, ids, selectCode);
    }

    /**
     * 分页查询检查项
     */
    @ApiOperation(value = "分页查询检查项")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CheckItemServiceProxy.SELECT_DELETE_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CheckItemServiceProxy.SELECT_DELETE_BY_ID)
    public Result selectDeleteById(String ownerId, String id, String selectCode) {
        return checkItemService.selectDeleteById(ownerId, id, selectCode);
    }
}
