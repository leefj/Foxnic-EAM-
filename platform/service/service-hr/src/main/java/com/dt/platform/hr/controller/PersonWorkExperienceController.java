package com.dt.platform.hr.controller;

import java.util.*;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.proxy.hr.PersonCertificateServiceProxy;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.hrm.Employee;
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
import com.dt.platform.proxy.hr.PersonWorkExperienceServiceProxy;
import com.dt.platform.domain.hr.meta.PersonWorkExperienceVOMeta;
import com.dt.platform.domain.hr.PersonWorkExperience;
import com.dt.platform.domain.hr.PersonWorkExperienceVO;
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
import com.dt.platform.domain.hr.meta.PersonWorkExperienceMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonWorkExperienceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 工作经历接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 16:02:17
 */
@InDoc
@Api(tags = "工作经历")
@RestController("HrPersonWorkExperienceController")
public class PersonWorkExperienceController extends SuperController {

    @Autowired
    private IPersonWorkExperienceService personWorkExperienceService;

    /**
     * 添加工作经历
     */
    @ApiOperation(value = "添加工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.INSERT)
    public Result insert(PersonWorkExperienceVO personWorkExperienceVO) {
        Result result = personWorkExperienceService.insert(personWorkExperienceVO, false);
        return result;
    }

    @ApiOperation(value = "添加工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.DIRECT_INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.DIRECT_INSERT)
    public Result directInsert(PersonWorkExperienceVO personWorkExperienceVO) {
        Result result = personWorkExperienceService.directInsert(personWorkExperienceVO, false);
        return result;
    }

    /**
     * 删除工作经历
     */
    @ApiOperation(value = "删除工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personWorkExperienceService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personWorkExperienceService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除工作经历 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personWorkExperienceService.hasRefers(ids);
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
            Result result = personWorkExperienceService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personWorkExperienceService.deleteByIdsLogical(canDeleteIds);
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
     * 更新工作经历
     */
    @ApiOperation(value = "更新工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonWorkExperienceVOMeta.PAGE_INDEX, PersonWorkExperienceVOMeta.PAGE_SIZE, PersonWorkExperienceVOMeta.SEARCH_FIELD, PersonWorkExperienceVOMeta.FUZZY_FIELD, PersonWorkExperienceVOMeta.SEARCH_VALUE, PersonWorkExperienceVOMeta.DIRTY_FIELDS, PersonWorkExperienceVOMeta.SORT_FIELD, PersonWorkExperienceVOMeta.SORT_TYPE, PersonWorkExperienceVOMeta.DATA_ORIGIN, PersonWorkExperienceVOMeta.QUERY_LOGIC, PersonWorkExperienceVOMeta.REQUEST_ACTION, PersonWorkExperienceVOMeta.IDS })
    @SentinelResource(value = PersonWorkExperienceServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.UPDATE)
    public Result update(PersonWorkExperienceVO personWorkExperienceVO) {
        Result result = personWorkExperienceService.update(personWorkExperienceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 更新工作经历
     */
    @ApiOperation(value = "更新工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonWorkExperienceVOMeta.PAGE_INDEX, PersonWorkExperienceVOMeta.PAGE_SIZE, PersonWorkExperienceVOMeta.SEARCH_FIELD, PersonWorkExperienceVOMeta.FUZZY_FIELD, PersonWorkExperienceVOMeta.SEARCH_VALUE, PersonWorkExperienceVOMeta.DIRTY_FIELDS, PersonWorkExperienceVOMeta.SORT_FIELD, PersonWorkExperienceVOMeta.SORT_TYPE, PersonWorkExperienceVOMeta.DATA_ORIGIN, PersonWorkExperienceVOMeta.QUERY_LOGIC, PersonWorkExperienceVOMeta.REQUEST_ACTION, PersonWorkExperienceVOMeta.IDS })
    @SentinelResource(value = PersonWorkExperienceServiceProxy.DIRECT_UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.DIRECT_UPDATE)
    public Result directUpdate(PersonWorkExperienceVO personWorkExperienceVO) {
        Result result = personWorkExperienceService.directUpdate(personWorkExperienceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存工作经历
     */
    @ApiOperation(value = "保存工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonWorkExperienceVOMeta.PAGE_INDEX, PersonWorkExperienceVOMeta.PAGE_SIZE, PersonWorkExperienceVOMeta.SEARCH_FIELD, PersonWorkExperienceVOMeta.FUZZY_FIELD, PersonWorkExperienceVOMeta.SEARCH_VALUE, PersonWorkExperienceVOMeta.DIRTY_FIELDS, PersonWorkExperienceVOMeta.SORT_FIELD, PersonWorkExperienceVOMeta.SORT_TYPE, PersonWorkExperienceVOMeta.DATA_ORIGIN, PersonWorkExperienceVOMeta.QUERY_LOGIC, PersonWorkExperienceVOMeta.REQUEST_ACTION, PersonWorkExperienceVOMeta.IDS })
    @SentinelResource(value = PersonWorkExperienceServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.SAVE)
    public Result save(PersonWorkExperienceVO personWorkExperienceVO) {
        Result result = personWorkExperienceService.save(personWorkExperienceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取工作经历
     */
    @ApiOperation(value = "获取工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.GET_BY_ID)
    public Result<PersonWorkExperience> getById(String id) {
        Result<PersonWorkExperience> result = new Result<>();
        PersonWorkExperience personWorkExperience = personWorkExperienceService.getById(id);
        // join 关联的对象
        personWorkExperienceService.dao().fill(personWorkExperience).with("person").with("user").execute();
        result.success(true).data(personWorkExperience);
        return result;
    }

    /**
     * 批量获取工作经历 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.GET_BY_IDS)
    public Result<List<PersonWorkExperience>> getByIds(List<String> ids) {
        Result<List<PersonWorkExperience>> result = new Result<>();
        List<PersonWorkExperience> list = personWorkExperienceService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询工作经历
     */
    @ApiOperation(value = "查询工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonWorkExperienceVOMeta.PAGE_INDEX, PersonWorkExperienceVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonWorkExperienceServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.QUERY_LIST)
    public Result<List<PersonWorkExperience>> queryList(PersonWorkExperienceVO sample) {
        Result<List<PersonWorkExperience>> result = new Result<>();
        List<PersonWorkExperience> list = personWorkExperienceService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询工作经历
     */
    @ApiOperation(value = "分页查询工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonWorkExperience>> queryPagedList(PersonWorkExperienceVO sample) {
        sample.setEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
        Result<PagedList<PersonWorkExperience>> result = new Result<>();
        PagedList<PersonWorkExperience> list = personWorkExperienceService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personWorkExperienceService.dao().fill(list).with("user").with("person").execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonWorkExperience::getPerson);
        personWorkExperienceService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     *     审批
     */
    @ApiOperation(value = "审批")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.APPROVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.APPROVE)
    public Result approve(List<String> ids, String act, String msg) {
        return personWorkExperienceService.approve(ids, act, msg);
    }

    /**
     * 分页查询工作经历
     */
    @ApiOperation(value = "分页查询工作经历")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.NAME, value = "公司名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.POST, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.WORK_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonWorkExperienceVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonWorkExperienceServiceProxy.QUERY_DATA_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonWorkExperienceServiceProxy.QUERY_DATA_PAGED_LIST)
    public Result<PagedList<PersonWorkExperience>> queryDataPagedList(PersonWorkExperienceVO sample) {


        if("admin".equals(sample.getRole())||"view".equals(sample.getRole())){
            Logger.info("role:"+sample.getRole());
        }else if("approval".equals(sample.getRole())){
            String curId = SessionUser.getCurrent().getActivatedEmployeeId();
            String sql = "select 1 from sys_busi_role a,sys_busi_role_member b where a.id=b.role_id and a.deleted=0 and member_type='employee' and member_id=? and code='hr_person_certificate'";
            sample.setStatus(ApprovalStatusEnum.WAIT.code());
            if (personWorkExperienceService.dao().queryRecord(sql, curId) == null) {
                sample.setId("-1");
            }
        }


        Result<PagedList<PersonWorkExperience>> result = new Result<>();
        PagedList<PersonWorkExperience> list = personWorkExperienceService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personWorkExperienceService.dao().fill(list).with("user").with("person").execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonWorkExperience::getPerson);
        personWorkExperienceService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
