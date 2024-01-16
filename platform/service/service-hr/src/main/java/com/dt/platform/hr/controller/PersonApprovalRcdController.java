package com.dt.platform.hr.controller;

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
import com.dt.platform.proxy.hr.PersonApprovalRcdServiceProxy;
import com.dt.platform.domain.hr.meta.PersonApprovalRcdVOMeta;
import com.dt.platform.domain.hr.PersonApprovalRcd;
import com.dt.platform.domain.hr.PersonApprovalRcdVO;
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
import com.dt.platform.domain.hr.meta.PersonApprovalRcdMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonApprovalRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 审批记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 22:04:51
 */
@InDoc
@Api(tags = "审批记录")
@RestController("HrPersonApprovalRcdController")
public class PersonApprovalRcdController extends SuperController {

    @Autowired
    private IPersonApprovalRcdService personApprovalRcdService;



    /**
     * 添加审批记录
     */
    @ApiOperation(value = "添加审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.PID, value = "信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonApprovalRcdServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.INSERT)
    public Result insert(PersonApprovalRcdVO personApprovalRcdVO) {
        Result result = personApprovalRcdService.insert(personApprovalRcdVO, false);
        return result;
    }

    /**
     * 删除审批记录
     */
    @ApiOperation(value = "删除审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonApprovalRcdServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personApprovalRcdService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personApprovalRcdService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除审批记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonApprovalRcdServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personApprovalRcdService.hasRefers(ids);
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
            Result result = personApprovalRcdService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personApprovalRcdService.deleteByIdsLogical(canDeleteIds);
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
     * 更新审批记录
     */
    @ApiOperation(value = "更新审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.PID, value = "信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonApprovalRcdVOMeta.PAGE_INDEX, PersonApprovalRcdVOMeta.PAGE_SIZE, PersonApprovalRcdVOMeta.SEARCH_FIELD, PersonApprovalRcdVOMeta.FUZZY_FIELD, PersonApprovalRcdVOMeta.SEARCH_VALUE, PersonApprovalRcdVOMeta.DIRTY_FIELDS, PersonApprovalRcdVOMeta.SORT_FIELD, PersonApprovalRcdVOMeta.SORT_TYPE, PersonApprovalRcdVOMeta.DATA_ORIGIN, PersonApprovalRcdVOMeta.QUERY_LOGIC, PersonApprovalRcdVOMeta.REQUEST_ACTION, PersonApprovalRcdVOMeta.IDS })
    @SentinelResource(value = PersonApprovalRcdServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.UPDATE)
    public Result update(PersonApprovalRcdVO personApprovalRcdVO) {
        Result result = personApprovalRcdService.update(personApprovalRcdVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存审批记录
     */
    @ApiOperation(value = "保存审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.PID, value = "信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonApprovalRcdVOMeta.PAGE_INDEX, PersonApprovalRcdVOMeta.PAGE_SIZE, PersonApprovalRcdVOMeta.SEARCH_FIELD, PersonApprovalRcdVOMeta.FUZZY_FIELD, PersonApprovalRcdVOMeta.SEARCH_VALUE, PersonApprovalRcdVOMeta.DIRTY_FIELDS, PersonApprovalRcdVOMeta.SORT_FIELD, PersonApprovalRcdVOMeta.SORT_TYPE, PersonApprovalRcdVOMeta.DATA_ORIGIN, PersonApprovalRcdVOMeta.QUERY_LOGIC, PersonApprovalRcdVOMeta.REQUEST_ACTION, PersonApprovalRcdVOMeta.IDS })
    @SentinelResource(value = PersonApprovalRcdServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.SAVE)
    public Result save(PersonApprovalRcdVO personApprovalRcdVO) {
        Result result = personApprovalRcdService.save(personApprovalRcdVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取审批记录
     */
    @ApiOperation(value = "获取审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonApprovalRcdServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.GET_BY_ID)
    public Result<PersonApprovalRcd> getById(String id) {
        Result<PersonApprovalRcd> result = new Result<>();
        PersonApprovalRcd personApprovalRcd = personApprovalRcdService.getById(id);
        // join 关联的对象
        personApprovalRcdService.dao().fill(personApprovalRcd).with("operUser").execute();
        result.success(true).data(personApprovalRcd);
        return result;
    }

    /**
     * 批量获取审批记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonApprovalRcdServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.GET_BY_IDS)
    public Result<List<PersonApprovalRcd>> getByIds(List<String> ids) {
        Result<List<PersonApprovalRcd>> result = new Result<>();
        List<PersonApprovalRcd> list = personApprovalRcdService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询审批记录
     */
    @ApiOperation(value = "查询审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.PID, value = "信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonApprovalRcdVOMeta.PAGE_INDEX, PersonApprovalRcdVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonApprovalRcdServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.QUERY_LIST)
    public Result<List<PersonApprovalRcd>> queryList(PersonApprovalRcdVO sample) {
        Result<List<PersonApprovalRcd>> result = new Result<>();
        List<PersonApprovalRcd> list = personApprovalRcdService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询审批记录
     */
    @ApiOperation(value = "分页查询审批记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.PID, value = "信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonApprovalRcdVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonApprovalRcdServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonApprovalRcdServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonApprovalRcd>> queryPagedList(PersonApprovalRcdVO sample) {
        Result<PagedList<PersonApprovalRcd>> result = new Result<>();
        PagedList<PersonApprovalRcd> list = personApprovalRcdService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personApprovalRcdService.dao().fill(list).with("operUser").execute();
        result.success(true).data(list);
        return result;
    }
}
