package com.dt.platform.ops.controller;

import java.util.*;

import com.dt.platform.ops.service.IDbApplyExecuteService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.sql.expr.ConditionExpr;
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
import com.dt.platform.proxy.ops.DbInfoApplyServiceProxy;
import com.dt.platform.domain.ops.meta.DbInfoApplyVOMeta;
import com.dt.platform.domain.ops.DbInfoApply;
import com.dt.platform.domain.ops.DbInfoApplyVO;
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
import com.dt.platform.domain.ops.meta.DbInfoApplyMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbInfoApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更数据库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:11:46
 */
@InDoc
@Api(tags = "变更数据库")
@RestController("OpsDbInfoApplyController")
public class DbInfoApplyController extends SuperController {



    @Autowired
    private IDbApplyExecuteService dbApplyExecuteService;

    @Autowired
    private IDbInfoApplyService dbInfoApplyService;

    /**
     * 添加变更数据库
     */
    @ApiOperation(value = "添加变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_FULL_NAME, value = "数据库全名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.INSERT)
    public Result insert(DbInfoApplyVO dbInfoApplyVO) {
        Result result = dbInfoApplyService.insert(dbInfoApplyVO, false);
        return result;
    }

    /**
     * 删除变更数据库
     */
    @ApiOperation(value = "删除变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = dbInfoApplyService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = dbInfoApplyService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除变更数据库 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = dbInfoApplyService.hasRefers(ids);
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
            Result result = dbInfoApplyService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = dbInfoApplyService.deleteByIdsLogical(canDeleteIds);
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
     * 更新变更数据库
     */
    @ApiOperation(value = "更新变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_FULL_NAME, value = "数据库全名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { DbInfoApplyVOMeta.PAGE_INDEX, DbInfoApplyVOMeta.PAGE_SIZE, DbInfoApplyVOMeta.SEARCH_FIELD, DbInfoApplyVOMeta.FUZZY_FIELD, DbInfoApplyVOMeta.SEARCH_VALUE, DbInfoApplyVOMeta.DIRTY_FIELDS, DbInfoApplyVOMeta.SORT_FIELD, DbInfoApplyVOMeta.SORT_TYPE, DbInfoApplyVOMeta.DATA_ORIGIN, DbInfoApplyVOMeta.QUERY_LOGIC, DbInfoApplyVOMeta.REQUEST_ACTION, DbInfoApplyVOMeta.IDS })
    @SentinelResource(value = DbInfoApplyServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.UPDATE)
    public Result update(DbInfoApplyVO dbInfoApplyVO) {
        Result result = dbInfoApplyService.update(dbInfoApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存变更数据库
     */
    @ApiOperation(value = "保存变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_FULL_NAME, value = "数据库全名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { DbInfoApplyVOMeta.PAGE_INDEX, DbInfoApplyVOMeta.PAGE_SIZE, DbInfoApplyVOMeta.SEARCH_FIELD, DbInfoApplyVOMeta.FUZZY_FIELD, DbInfoApplyVOMeta.SEARCH_VALUE, DbInfoApplyVOMeta.DIRTY_FIELDS, DbInfoApplyVOMeta.SORT_FIELD, DbInfoApplyVOMeta.SORT_TYPE, DbInfoApplyVOMeta.DATA_ORIGIN, DbInfoApplyVOMeta.QUERY_LOGIC, DbInfoApplyVOMeta.REQUEST_ACTION, DbInfoApplyVOMeta.IDS })
    @SentinelResource(value = DbInfoApplyServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.SAVE)
    public Result save(DbInfoApplyVO dbInfoApplyVO) {
        Result result = dbInfoApplyService.save(dbInfoApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取变更数据库
     */
    @ApiOperation(value = "获取变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.GET_BY_ID)
    public Result<DbInfoApply> getById(String id) {
        Result<DbInfoApply> result = new Result<>();
        DbInfoApply dbInfoApply = dbInfoApplyService.getById(id);
        result.success(true).data(dbInfoApply);
        return result;
    }

    /**
     * 批量获取变更数据库 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.GET_BY_IDS)
    public Result<List<DbInfoApply>> getByIds(List<String> ids) {
        Result<List<DbInfoApply>> result = new Result<>();
        List<DbInfoApply> list = dbInfoApplyService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询变更数据库
     */
    @ApiOperation(value = "查询变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_FULL_NAME, value = "数据库全名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { DbInfoApplyVOMeta.PAGE_INDEX, DbInfoApplyVOMeta.PAGE_SIZE })
    @SentinelResource(value = DbInfoApplyServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.QUERY_LIST)
    public Result<List<DbInfoApply>> queryList(DbInfoApplyVO sample) {
        Result<List<DbInfoApply>> result = new Result<>();
        List<DbInfoApply> list = dbInfoApplyService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询变更数据库
     */
    @ApiOperation(value = "分页查询变更数据库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_FULL_NAME, value = "数据库全名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInfoApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DbInfoApply>> queryPagedList(DbInfoApplyVO sample) {
        Result<PagedList<DbInfoApply>> result = new Result<>();
        PagedList<DbInfoApply> list = dbInfoApplyService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询变更数据库
     */
    @ApiOperation(value = "分页查询变更数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = DbInfoApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.DB_FULL_NAME, value = "数据库全名", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.DB_NAME, value = "数据库", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.DB_IP, value = "数据库IP", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.DB_PORT, value = "端口", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.ASSOCIATED_SYSTEM, value = "关联系统", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = DbInfoApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
    })
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbInfoApplyServiceProxy.QUERY_EXECUTE_DB_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInfoApplyServiceProxy.QUERY_EXECUTE_DB_PAGED_LIST)
    public Result<PagedList<DbInfoApply>> queryExecuteDbPagedList(DbInfoApplyVO sample) {

        sample.setAssociatedSystem(dbApplyExecuteService.queryCurAssociatedSystem());

        String business=sample.getBusiness();
        String roleCode="db_none";
        if(!StringUtil.isBlank(business)){
            if("change".equals(business)){
                roleCode="ops_db_change_apply_bill";
            }else if("exe".equals(business)){
                roleCode="ops_db_extract_apply_bill";
            }
        }
        String curUserId= SessionUser.getCurrent().getActivatedEmployeeId();
        String sql="select 1 from sys_busi_role a,sys_busi_role_member b where a.id=b.role_id and a.deleted=0 and member_type='employee' and b.member_id=? and a.code=?";
        Rcd userCk=dbInfoApplyService.dao().queryRecord(sql,curUserId,roleCode);
        ConditionExpr expr=new ConditionExpr();
        if(userCk==null){
            expr.and("id='123'");
        }else{
            expr.and("1=1");
        }
        Result<PagedList<DbInfoApply>> result = new Result<>();
        PagedList<DbInfoApply> list = dbInfoApplyService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

}
