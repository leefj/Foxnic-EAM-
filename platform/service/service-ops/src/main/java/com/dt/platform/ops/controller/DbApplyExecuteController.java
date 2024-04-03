package com.dt.platform.ops.controller;

import java.util.*;

import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.ops.service.IDbInfoApplyService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.ops.DbApplyExecuteServiceProxy;
import com.dt.platform.domain.ops.meta.DbApplyExecuteVOMeta;
import com.dt.platform.domain.ops.DbApplyExecute;
import com.dt.platform.domain.ops.DbApplyExecuteVO;
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
import com.dt.platform.domain.ops.meta.DbApplyExecuteMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbApplyExecuteService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库操作执行接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:04:12
 */
@InDoc
@Api(tags = "数据库操作执行")
@RestController("OpsDbApplyExecuteController")
public class DbApplyExecuteController extends SuperController {


    @Autowired
    private IDbApplyExecuteService dbApplyExecuteService;

    /**
     * 添加数据库操作执行
     */
    @ApiOperation(value = "添加数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OWNER_ID, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.RESULT, value = "操作结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.INSERT)
    public Result insert(DbApplyExecuteVO dbApplyExecuteVO) {
        Result result = dbApplyExecuteService.insert(dbApplyExecuteVO, false);
        return result;
    }

    /**
     * 删除数据库操作执行
     */
    @ApiOperation(value = "删除数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = dbApplyExecuteService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = dbApplyExecuteService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除数据库操作执行 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = dbApplyExecuteService.hasRefers(ids);
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
            Result result = dbApplyExecuteService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = dbApplyExecuteService.deleteByIdsLogical(canDeleteIds);
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
     * 更新数据库操作执行
     */
    @ApiOperation(value = "更新数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OWNER_ID, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.RESULT, value = "操作结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { DbApplyExecuteVOMeta.PAGE_INDEX, DbApplyExecuteVOMeta.PAGE_SIZE, DbApplyExecuteVOMeta.SEARCH_FIELD, DbApplyExecuteVOMeta.FUZZY_FIELD, DbApplyExecuteVOMeta.SEARCH_VALUE, DbApplyExecuteVOMeta.DIRTY_FIELDS, DbApplyExecuteVOMeta.SORT_FIELD, DbApplyExecuteVOMeta.SORT_TYPE, DbApplyExecuteVOMeta.DATA_ORIGIN, DbApplyExecuteVOMeta.QUERY_LOGIC, DbApplyExecuteVOMeta.REQUEST_ACTION, DbApplyExecuteVOMeta.IDS })
    @SentinelResource(value = DbApplyExecuteServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.UPDATE)
    public Result update(DbApplyExecuteVO dbApplyExecuteVO) {
        Result result = dbApplyExecuteService.update(dbApplyExecuteVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存数据库操作执行
     */
    @ApiOperation(value = "保存数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OWNER_ID, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.RESULT, value = "操作结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { DbApplyExecuteVOMeta.PAGE_INDEX, DbApplyExecuteVOMeta.PAGE_SIZE, DbApplyExecuteVOMeta.SEARCH_FIELD, DbApplyExecuteVOMeta.FUZZY_FIELD, DbApplyExecuteVOMeta.SEARCH_VALUE, DbApplyExecuteVOMeta.DIRTY_FIELDS, DbApplyExecuteVOMeta.SORT_FIELD, DbApplyExecuteVOMeta.SORT_TYPE, DbApplyExecuteVOMeta.DATA_ORIGIN, DbApplyExecuteVOMeta.QUERY_LOGIC, DbApplyExecuteVOMeta.REQUEST_ACTION, DbApplyExecuteVOMeta.IDS })
    @SentinelResource(value = DbApplyExecuteServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.SAVE)
    public Result save(DbApplyExecuteVO dbApplyExecuteVO) {
        Result result = dbApplyExecuteService.save(dbApplyExecuteVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取数据库操作执行
     */
    @ApiOperation(value = "获取数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.GET_BY_ID)
    public Result<DbApplyExecute> getById(String id) {
        Result<DbApplyExecute> result = new Result<>();
        DbApplyExecute dbApplyExecute = dbApplyExecuteService.getById(id);
        // join 关联的对象
        dbApplyExecuteService.dao().fill(dbApplyExecute).with("operUser").execute();
        result.success(true).data(dbApplyExecute);
        return result;
    }

    /**
     * 批量获取数据库操作执行 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.GET_BY_IDS)
    public Result<List<DbApplyExecute>> getByIds(List<String> ids) {
        Result<List<DbApplyExecute>> result = new Result<>();
        List<DbApplyExecute> list = dbApplyExecuteService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询数据库操作执行
     */
    @ApiOperation(value = "查询数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OWNER_ID, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.RESULT, value = "操作结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { DbApplyExecuteVOMeta.PAGE_INDEX, DbApplyExecuteVOMeta.PAGE_SIZE })
    @SentinelResource(value = DbApplyExecuteServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.QUERY_LIST)
    public Result<List<DbApplyExecute>> queryList(DbApplyExecuteVO sample) {
        Result<List<DbApplyExecute>> result = new Result<>();
        List<DbApplyExecute> list = dbApplyExecuteService.queryList(sample);
        result.success(true).data(list);
        return result;
    }


    @ApiOperation(value = "查询")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.QUERY_CUR_ASSOCIATED_SYSTEM, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.QUERY_CUR_ASSOCIATED_SYSTEM)
    public String queryCurAssociatedSystem() {
        return dbApplyExecuteService.queryCurAssociatedSystem();
    }


    @ApiOperation(value = "验证SQL")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.VALID_CONTENT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.VALID_CONTENT)
    public Result validContent() {
        return ErrorDesc.success();
    }

    @ApiOperation(value = "备份")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.CREATE_RB, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.CREATE_RB)
    public Result createRb() {
        return ErrorDesc.success();
    }

    @ApiOperation(value = "数据库用户")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.QUERY_DB_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.QUERY_DB_LIST)
    public Result queryDbList(String code,String business) {

        return ErrorDesc.success();
    }

    @ApiOperation(value = "查询数据库用户")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.QUERY_DB_USER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.QUERY_DB_USER)
    public Result queryDbUser(String code) {
        //连接第三方系统，查询当前可用的数据库用户
        return ErrorDesc.success();

    }

    /**
     * 分页查询数据库操作执行
     */
    @ApiOperation(value = "分页查询数据库操作执行")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OWNER_ID, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.RESULT, value = "操作结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbApplyExecuteVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbApplyExecuteServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbApplyExecuteServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DbApplyExecute>> queryPagedList(DbApplyExecuteVO sample) {
        Result<PagedList<DbApplyExecute>> result = new Result<>();
        PagedList<DbApplyExecute> list = dbApplyExecuteService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        dbApplyExecuteService.dao().fill(list).with("operUser").execute();

        List<Employee> users = CollectorUtil.collectList(list, DbApplyExecute::getOperUser);
        dbApplyExecuteService.dao().join(users, Person.class);


        result.success(true).data(list);
        return result;
    }
}
