package com.dt.platform.hr.controller;

import java.util.*;

import org.github.foxnic.web.domain.hrm.Employee;
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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import com.dt.platform.proxy.hr.PersonConfirmApplyServiceProxy;
import com.dt.platform.domain.hr.meta.PersonConfirmApplyVOMeta;
import com.dt.platform.domain.hr.PersonConfirmApply;
import com.dt.platform.domain.hr.PersonConfirmApplyVO;
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
import com.dt.platform.domain.hr.meta.PersonConfirmApplyMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonConfirmApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 转正申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:05:19
 */
@InDoc
@Api(tags = "转正申请")
@RestController("HrPersonConfirmApplyController")
public class PersonConfirmApplyController extends SuperController implements BpmCallbackController {

    @Autowired
    private IPersonConfirmApplyService personConfirmApplyService;

    /**
     * 添加转正申请
     */
    @ApiOperation(value = "添加转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.BUSINESS_CODE, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.PERSON_ID, value = "申请人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonConfirmApplyServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.INSERT)
    public Result insert(PersonConfirmApplyVO personConfirmApplyVO) {
        Result result = personConfirmApplyService.insert(personConfirmApplyVO, false);
        return result;
    }

    /**
     * 删除转正申请
     */
    @ApiOperation(value = "删除转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonConfirmApplyServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personConfirmApplyService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personConfirmApplyService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除转正申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonConfirmApplyServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personConfirmApplyService.hasRefers(ids);
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
            Result result = personConfirmApplyService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personConfirmApplyService.deleteByIdsLogical(canDeleteIds);
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
     * 更新转正申请
     */
    @ApiOperation(value = "更新转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.BUSINESS_CODE, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.PERSON_ID, value = "申请人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonConfirmApplyVOMeta.PAGE_INDEX, PersonConfirmApplyVOMeta.PAGE_SIZE, PersonConfirmApplyVOMeta.SEARCH_FIELD, PersonConfirmApplyVOMeta.FUZZY_FIELD, PersonConfirmApplyVOMeta.SEARCH_VALUE, PersonConfirmApplyVOMeta.DIRTY_FIELDS, PersonConfirmApplyVOMeta.SORT_FIELD, PersonConfirmApplyVOMeta.SORT_TYPE, PersonConfirmApplyVOMeta.DATA_ORIGIN, PersonConfirmApplyVOMeta.QUERY_LOGIC, PersonConfirmApplyVOMeta.REQUEST_ACTION, PersonConfirmApplyVOMeta.IDS })
    @SentinelResource(value = PersonConfirmApplyServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.UPDATE)
    public Result update(PersonConfirmApplyVO personConfirmApplyVO) {
        Result result = personConfirmApplyService.update(personConfirmApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存转正申请
     */
    @ApiOperation(value = "保存转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.BUSINESS_CODE, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.PERSON_ID, value = "申请人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonConfirmApplyVOMeta.PAGE_INDEX, PersonConfirmApplyVOMeta.PAGE_SIZE, PersonConfirmApplyVOMeta.SEARCH_FIELD, PersonConfirmApplyVOMeta.FUZZY_FIELD, PersonConfirmApplyVOMeta.SEARCH_VALUE, PersonConfirmApplyVOMeta.DIRTY_FIELDS, PersonConfirmApplyVOMeta.SORT_FIELD, PersonConfirmApplyVOMeta.SORT_TYPE, PersonConfirmApplyVOMeta.DATA_ORIGIN, PersonConfirmApplyVOMeta.QUERY_LOGIC, PersonConfirmApplyVOMeta.REQUEST_ACTION, PersonConfirmApplyVOMeta.IDS })
    @SentinelResource(value = PersonConfirmApplyServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.SAVE)
    public Result save(PersonConfirmApplyVO personConfirmApplyVO) {
        Result result = personConfirmApplyService.save(personConfirmApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取转正申请
     */
    @ApiOperation(value = "获取转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonConfirmApplyServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.GET_BY_ID)
    public Result<PersonConfirmApply> getById(String id) {
        Result<PersonConfirmApply> result = new Result<>();
        PersonConfirmApply personConfirmApply = personConfirmApplyService.getById(id);
        // join 关联的对象
        personConfirmApplyService.dao().fill(personConfirmApply).with("person").execute();

        personConfirmApplyService.dao().join(personConfirmApply.getPerson(), Person.class);

        // 填充流程相关的属性
        personConfirmApplyService.joinProcess(personConfirmApply);
        result.success(true).data(personConfirmApply);
        return result;
    }

    /**
     * 批量获取转正申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonConfirmApplyServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.GET_BY_IDS)
    public Result<List<PersonConfirmApply>> getByIds(List<String> ids) {
        Result<List<PersonConfirmApply>> result = new Result<>();
        List<PersonConfirmApply> list = personConfirmApplyService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询转正申请
     */
    @ApiOperation(value = "查询转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.BUSINESS_CODE, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.PERSON_ID, value = "申请人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonConfirmApplyVOMeta.PAGE_INDEX, PersonConfirmApplyVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonConfirmApplyServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.QUERY_LIST)
    public Result<List<PersonConfirmApply>> queryList(PersonConfirmApplyVO sample) {
        Result<List<PersonConfirmApply>> result = new Result<>();
        List<PersonConfirmApply> list = personConfirmApplyService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询转正申请
     */
    @ApiOperation(value = "分页查询转正申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.BUSINESS_CODE, value = "编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.PERSON_ID, value = "申请人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONFIRM_DATE, value = "转正日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.OPER_USER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonConfirmApplyVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonConfirmApplyServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonConfirmApply>> queryPagedList(PersonConfirmApplyVO sample) {
        Result<PagedList<PersonConfirmApply>> result = new Result<>();
        PagedList<PersonConfirmApply> list = personConfirmApplyService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personConfirmApplyService.dao().fill(list).with("person").execute();

        List<Employee> employees = CollectorUtil.collectList(list, PersonConfirmApply::getPerson);
        personConfirmApplyService.dao().join(employees, Person.class);

        // 填充流程相关的属性
        personConfirmApplyService.joinProcess(list);
        result.success(true).data(list);
        return result;
    }

    /**
     *  流程回调处理
     */
    @SentinelResource(value = PersonConfirmApplyServiceProxy.BPM_CALLBACK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonConfirmApplyServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event) {
        return personConfirmApplyService.onProcessCallback(event);
    }
}
