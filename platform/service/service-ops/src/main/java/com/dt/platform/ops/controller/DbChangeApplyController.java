package com.dt.platform.ops.controller;

import java.util.*;
import com.dt.platform.domain.ops.DbApplyExecute;
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
import com.dt.platform.proxy.ops.DbChangeApplyServiceProxy;
import com.dt.platform.domain.ops.meta.DbChangeApplyVOMeta;
import com.dt.platform.domain.ops.DbChangeApply;
import com.dt.platform.domain.ops.DbChangeApplyVO;
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
import com.dt.platform.domain.ops.meta.DbChangeApplyMeta;
import com.dt.platform.domain.ops.DbInfoApply;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbChangeApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库变更申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:10:36
 */
@InDoc
@Api(tags = "数据库变更申请")
@RestController("OpsDbChangeApplyController")
public class DbChangeApplyController extends SuperController {

    @Autowired
    private IDbChangeApplyService dbChangeApplyService;

    /**
     * 添加数据库变更申请
     */
    @ApiOperation(value = "添加数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_CODE, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_NAME, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_FULL_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_ID, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CONTENT, value = "原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SQL_AREA, value = "SQL文本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CHECK_RESULT, value = "验证结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.RB_RESULT, value = "回滚/备份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_ORDER_STATUS, value = "推送工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_RESULT, value = "返回信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ORDER_ID, value = "工单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.APPLY_USER_ID, value = "申请人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_USER, value = "数据库用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.INSERT)
    public Result insert(DbChangeApplyVO dbChangeApplyVO) {
        Result result = dbChangeApplyService.insert(dbChangeApplyVO, false);
        return result;
    }

    /**
     * 删除数据库变更申请
     */
    @ApiOperation(value = "删除数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = dbChangeApplyService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = dbChangeApplyService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除数据库变更申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = dbChangeApplyService.hasRefers(ids);
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
            Result result = dbChangeApplyService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = dbChangeApplyService.deleteByIdsLogical(canDeleteIds);
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
     * 更新数据库变更申请
     */
    @ApiOperation(value = "更新数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_CODE, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_NAME, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_FULL_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_ID, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CONTENT, value = "原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SQL_AREA, value = "SQL文本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CHECK_RESULT, value = "验证结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.RB_RESULT, value = "回滚/备份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_ORDER_STATUS, value = "推送工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_RESULT, value = "返回信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ORDER_ID, value = "工单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.APPLY_USER_ID, value = "申请人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_USER, value = "数据库用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { DbChangeApplyVOMeta.PAGE_INDEX, DbChangeApplyVOMeta.PAGE_SIZE, DbChangeApplyVOMeta.SEARCH_FIELD, DbChangeApplyVOMeta.FUZZY_FIELD, DbChangeApplyVOMeta.SEARCH_VALUE, DbChangeApplyVOMeta.DIRTY_FIELDS, DbChangeApplyVOMeta.SORT_FIELD, DbChangeApplyVOMeta.SORT_TYPE, DbChangeApplyVOMeta.DATA_ORIGIN, DbChangeApplyVOMeta.QUERY_LOGIC, DbChangeApplyVOMeta.REQUEST_ACTION, DbChangeApplyVOMeta.IDS })
    @SentinelResource(value = DbChangeApplyServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.UPDATE)
    public Result update(DbChangeApplyVO dbChangeApplyVO) {
        Result result = dbChangeApplyService.update(dbChangeApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存数据库变更申请
     */
    @ApiOperation(value = "保存数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_CODE, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_NAME, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_FULL_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_ID, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CONTENT, value = "原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SQL_AREA, value = "SQL文本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CHECK_RESULT, value = "验证结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.RB_RESULT, value = "回滚/备份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_ORDER_STATUS, value = "推送工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_RESULT, value = "返回信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ORDER_ID, value = "工单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.APPLY_USER_ID, value = "申请人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_USER, value = "数据库用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { DbChangeApplyVOMeta.PAGE_INDEX, DbChangeApplyVOMeta.PAGE_SIZE, DbChangeApplyVOMeta.SEARCH_FIELD, DbChangeApplyVOMeta.FUZZY_FIELD, DbChangeApplyVOMeta.SEARCH_VALUE, DbChangeApplyVOMeta.DIRTY_FIELDS, DbChangeApplyVOMeta.SORT_FIELD, DbChangeApplyVOMeta.SORT_TYPE, DbChangeApplyVOMeta.DATA_ORIGIN, DbChangeApplyVOMeta.QUERY_LOGIC, DbChangeApplyVOMeta.REQUEST_ACTION, DbChangeApplyVOMeta.IDS })
    @SentinelResource(value = DbChangeApplyServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.SAVE)
    public Result save(DbChangeApplyVO dbChangeApplyVO) {
        Result result = dbChangeApplyService.save(dbChangeApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取数据库变更申请
     */
    @ApiOperation(value = "获取数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.GET_BY_ID)
    public Result<DbChangeApply> getById(String id) {
        Result<DbChangeApply> result = new Result<>();
        DbChangeApply dbChangeApply = dbChangeApplyService.getById(id);
        // join 关联的对象
        dbChangeApplyService.dao().fill(dbChangeApply).with("applyUser").with(DbChangeApplyMeta.DB_INFO_APPLY).with(DbChangeApplyMeta.REQUEST_ORDER).execute();
        result.success(true).data(dbChangeApply);
        return result;
    }

    /**
     * 获取数据库变更申请
     */
    @ApiOperation(value = "获取数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.SUBMIT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.SUBMIT)
    public Result submit(String id) {
        return dbChangeApplyService.submit(id);
    }

    /**
     * 获取数据库变更申请
     */
    @ApiOperation(value = "获取数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.VALID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.VALID)
    public Result valid(String code, String method, String sqlArea, String fileIds) {
        return dbChangeApplyService.valid(code, method, sqlArea, fileIds);
    }

    /**
     * 获取数据库变更申请
     */
    @ApiOperation(value = "获取数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.CREATE_RB, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.CREATE_RB)
    public Result createRb(String code, String method, String sqlArea, String fileIds) {
        return dbChangeApplyService.createRb(code, method, sqlArea, fileIds);
    }

    /**
     * 批量获取数据库变更申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.GET_BY_IDS)
    public Result<List<DbChangeApply>> getByIds(List<String> ids) {
        Result<List<DbChangeApply>> result = new Result<>();
        List<DbChangeApply> list = dbChangeApplyService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询数据库变更申请
     */
    @ApiOperation(value = "查询数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_CODE, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_NAME, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_FULL_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_ID, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CONTENT, value = "原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SQL_AREA, value = "SQL文本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CHECK_RESULT, value = "验证结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.RB_RESULT, value = "回滚/备份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_ORDER_STATUS, value = "推送工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_RESULT, value = "返回信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ORDER_ID, value = "工单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.APPLY_USER_ID, value = "申请人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_USER, value = "数据库用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { DbChangeApplyVOMeta.PAGE_INDEX, DbChangeApplyVOMeta.PAGE_SIZE })
    @SentinelResource(value = DbChangeApplyServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.QUERY_LIST)
    public Result<List<DbChangeApply>> queryList(DbChangeApplyVO sample) {
        Result<List<DbChangeApply>> result = new Result<>();
        List<DbChangeApply> list = dbChangeApplyService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询数据库变更申请
     */
    @ApiOperation(value = "分页查询数据库变更申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_CODE, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ITEM_NAME, value = "关联工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_FULL_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_ID, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CONTENT, value = "原因", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SQL_AREA, value = "SQL文本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.CHECK_RESULT, value = "验证结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.RB_RESULT, value = "回滚/备份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_ORDER_STATUS, value = "推送工单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.PUSH_RESULT, value = "返回信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ORDER_ID, value = "工单编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.APPLY_USER_ID, value = "申请人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.DB_USER, value = "数据库用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbChangeApplyVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbChangeApplyServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbChangeApplyServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DbChangeApply>> queryPagedList(DbChangeApplyVO sample) {
        Result<PagedList<DbChangeApply>> result = new Result<>();
        PagedList<DbChangeApply> list = dbChangeApplyService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        dbChangeApplyService.dao().fill(list).with("applyUser").with(DbChangeApplyMeta.DB_INFO_APPLY).with(DbChangeApplyMeta.REQUEST_ORDER).execute();
        List<Employee> users = CollectorUtil.collectList(list, DbChangeApply::getApplyUser);
        dbChangeApplyService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
