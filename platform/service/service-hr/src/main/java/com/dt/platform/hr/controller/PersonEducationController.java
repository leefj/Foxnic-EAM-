package com.dt.platform.hr.controller;

import java.util.*;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.PersonSocialRelation;
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
import com.dt.platform.proxy.hr.PersonEducationServiceProxy;
import com.dt.platform.domain.hr.meta.PersonEducationVOMeta;
import com.dt.platform.domain.hr.PersonEducation;
import com.dt.platform.domain.hr.PersonEducationVO;
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
import com.dt.platform.domain.hr.meta.PersonEducationMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonEducationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 教育信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 18:00:23
 */
@InDoc
@Api(tags = "教育信息")
@RestController("HrPersonEducationController")
public class PersonEducationController extends SuperController {

    @Autowired
    private IPersonEducationService personEducationService;

    /**
     * 添加教育信息
     */
    @ApiOperation(value = "添加教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.INSERT)
    public Result insert(PersonEducationVO personEducationVO) {
        Result result = personEducationService.insert(personEducationVO, false);
        return result;
    }

    @ApiOperation(value = "添加教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.DIRECT_INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.DIRECT_INSERT)
    public Result directInsert(PersonEducationVO personEducationVO) {
        Result result = personEducationService.directInsert(personEducationVO, false);
        return result;
    }

    /**
     * 删除教育信息
     */
    @ApiOperation(value = "删除教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personEducationService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personEducationService.deleteByIdLogical(id);
        return result;
    }

    /**
     *     审批
     */
    @ApiOperation(value = "审批")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.APPROVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.APPROVE)
    public Result approve(List<String> ids, String act, String msg) {
        return personEducationService.approve(ids, act, msg);
    }

    /**
     * 批量删除教育信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personEducationService.hasRefers(ids);
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
            Result result = personEducationService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personEducationService.deleteByIdsLogical(canDeleteIds);
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
     * 更新教育信息
     */
    @ApiOperation(value = "更新教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonEducationVOMeta.PAGE_INDEX, PersonEducationVOMeta.PAGE_SIZE, PersonEducationVOMeta.SEARCH_FIELD, PersonEducationVOMeta.FUZZY_FIELD, PersonEducationVOMeta.SEARCH_VALUE, PersonEducationVOMeta.DIRTY_FIELDS, PersonEducationVOMeta.SORT_FIELD, PersonEducationVOMeta.SORT_TYPE, PersonEducationVOMeta.DATA_ORIGIN, PersonEducationVOMeta.QUERY_LOGIC, PersonEducationVOMeta.REQUEST_ACTION, PersonEducationVOMeta.IDS })
    @SentinelResource(value = PersonEducationServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.UPDATE)
    public Result update(PersonEducationVO personEducationVO) {
        Result result = personEducationService.update(personEducationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 更新教育信息
     */
    @ApiOperation(value = "更新教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonEducationVOMeta.PAGE_INDEX, PersonEducationVOMeta.PAGE_SIZE, PersonEducationVOMeta.SEARCH_FIELD, PersonEducationVOMeta.FUZZY_FIELD, PersonEducationVOMeta.SEARCH_VALUE, PersonEducationVOMeta.DIRTY_FIELDS, PersonEducationVOMeta.SORT_FIELD, PersonEducationVOMeta.SORT_TYPE, PersonEducationVOMeta.DATA_ORIGIN, PersonEducationVOMeta.QUERY_LOGIC, PersonEducationVOMeta.REQUEST_ACTION, PersonEducationVOMeta.IDS })
    @SentinelResource(value = PersonEducationServiceProxy.DIRECT_UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.DIRECT_UPDATE)
    public Result directUpdate(PersonEducationVO personEducationVO) {
        Result result = personEducationService.directUpdate(personEducationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存教育信息
     */
    @ApiOperation(value = "保存教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonEducationVOMeta.PAGE_INDEX, PersonEducationVOMeta.PAGE_SIZE, PersonEducationVOMeta.SEARCH_FIELD, PersonEducationVOMeta.FUZZY_FIELD, PersonEducationVOMeta.SEARCH_VALUE, PersonEducationVOMeta.DIRTY_FIELDS, PersonEducationVOMeta.SORT_FIELD, PersonEducationVOMeta.SORT_TYPE, PersonEducationVOMeta.DATA_ORIGIN, PersonEducationVOMeta.QUERY_LOGIC, PersonEducationVOMeta.REQUEST_ACTION, PersonEducationVOMeta.IDS })
    @SentinelResource(value = PersonEducationServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.SAVE)
    public Result save(PersonEducationVO personEducationVO) {
        Result result = personEducationService.save(personEducationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取教育信息
     */
    @ApiOperation(value = "获取教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.GET_BY_ID)
    public Result<PersonEducation> getById(String id) {
        Result<PersonEducation> result = new Result<>();
        PersonEducation personEducation = personEducationService.getById(id);
        // join 关联的对象
        personEducationService.dao().fill(personEducation).with("person").with("user").with(PersonEducationMeta.EDUCATION_INFO).execute();
        result.success(true).data(personEducation);
        return result;
    }

    /**
     * 批量获取教育信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.GET_BY_IDS)
    public Result<List<PersonEducation>> getByIds(List<String> ids) {
        Result<List<PersonEducation>> result = new Result<>();
        List<PersonEducation> list = personEducationService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询教育信息
     */
    @ApiOperation(value = "查询教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonEducationVOMeta.PAGE_INDEX, PersonEducationVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonEducationServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.QUERY_LIST)
    public Result<List<PersonEducation>> queryList(PersonEducationVO sample) {
        Result<List<PersonEducation>> result = new Result<>();
        List<PersonEducation> list = personEducationService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询教育信息
     */
    @ApiOperation(value = "分页查询教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonEducation>> queryPagedList(PersonEducationVO sample) {
        Result<PagedList<PersonEducation>> result = new Result<>();
        sample.setEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
        PagedList<PersonEducation> list = personEducationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personEducationService.dao().fill(list).with("person").with("user").with(PersonEducationMeta.EDUCATION_INFO).execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonEducation::getPerson);
        personEducationService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询教育信息
     */
    @ApiOperation(value = "分页查询教育信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonEducationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATION, value = "学历", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.EDUCATIONAL_INSTITUTIONS, value = "毕业院校", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.MAJOY_STUDIED, value = "所学专业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonEducationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonEducationServiceProxy.QUERY_DATA_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonEducationServiceProxy.QUERY_DATA_PAGED_LIST)
    public Result<PagedList<PersonEducation>> queryDataPagedList(PersonEducationVO sample) {

        if("admin".equals(sample.getRole())||"view".equals(sample.getRole())){
            Logger.info("role:"+sample.getRole());
        }else if("approval".equals(sample.getRole())){
            String curId = SessionUser.getCurrent().getActivatedEmployeeId();
            String sql = "select 1 from sys_busi_role a,sys_busi_role_member b where a.id=b.role_id and a.deleted=0 and member_type='employee' and member_id=? and code='hr_person_certificate'";
            sample.setStatus(ApprovalStatusEnum.WAIT.code());
            if (personEducationService.dao().queryRecord(sql, curId) == null) {
                sample.setId("-1");
            }
        }



        Result<PagedList<PersonEducation>> result = new Result<>();
        PagedList<PersonEducation> list = personEducationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personEducationService.dao().fill(list).with("person").with("user").with(PersonEducationMeta.EDUCATION_INFO).execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonEducation::getPerson);
        personEducationService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
