package com.dt.platform.hr.controller;

import java.util.*;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.PersonEducation;
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
import com.dt.platform.proxy.hr.PersonCertificateServiceProxy;
import com.dt.platform.domain.hr.meta.PersonCertificateVOMeta;
import com.dt.platform.domain.hr.PersonCertificate;
import com.dt.platform.domain.hr.PersonCertificateVO;
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

import com.dt.platform.domain.hr.meta.PersonCertificateMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonCertificateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 17:07:10
 */
@InDoc
@Api(tags = "证书信息")
@RestController("HrPersonCertificateController")
public class PersonCertificateController extends SuperController {

    @Autowired
    private IPersonCertificateService personCertificateService;

    /**
     * 添加证书信息
     */
    @ApiOperation(value = "添加证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.INSERT)
    public Result insert(PersonCertificateVO personCertificateVO) {
        Result result = personCertificateService.insert(personCertificateVO, false);
        return result;
    }

    /**
     * 添加证书信息
     */
    @ApiOperation(value = "添加证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.DIRECT_INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.DIRECT_INSERT)
    public Result directInsert(PersonCertificateVO personCertificateVO) {
        Result result = personCertificateService.directInsert(personCertificateVO, false);
        return result;
    }

    /**
     * 删除证书信息
     */
    @ApiOperation(value = "删除证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personCertificateService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personCertificateService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除证书信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personCertificateService.hasRefers(ids);
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
            Result result = personCertificateService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personCertificateService.deleteByIdsLogical(canDeleteIds);
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
     * 更新证书信息
     */
    @ApiOperation(value = "更新证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonCertificateVOMeta.PAGE_INDEX, PersonCertificateVOMeta.PAGE_SIZE, PersonCertificateVOMeta.SEARCH_FIELD, PersonCertificateVOMeta.FUZZY_FIELD, PersonCertificateVOMeta.SEARCH_VALUE, PersonCertificateVOMeta.DIRTY_FIELDS, PersonCertificateVOMeta.SORT_FIELD, PersonCertificateVOMeta.SORT_TYPE, PersonCertificateVOMeta.DATA_ORIGIN, PersonCertificateVOMeta.QUERY_LOGIC, PersonCertificateVOMeta.REQUEST_ACTION, PersonCertificateVOMeta.IDS })
    @SentinelResource(value = PersonCertificateServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.UPDATE)
    public Result update(PersonCertificateVO personCertificateVO) {
        Result result = personCertificateService.update(personCertificateVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    @ApiOperation(value = "更新证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonCertificateVOMeta.PAGE_INDEX, PersonCertificateVOMeta.PAGE_SIZE, PersonCertificateVOMeta.SEARCH_FIELD, PersonCertificateVOMeta.FUZZY_FIELD, PersonCertificateVOMeta.SEARCH_VALUE, PersonCertificateVOMeta.DIRTY_FIELDS, PersonCertificateVOMeta.SORT_FIELD, PersonCertificateVOMeta.SORT_TYPE, PersonCertificateVOMeta.DATA_ORIGIN, PersonCertificateVOMeta.QUERY_LOGIC, PersonCertificateVOMeta.REQUEST_ACTION, PersonCertificateVOMeta.IDS })
    @SentinelResource(value = PersonCertificateServiceProxy.DIRECT_UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.DIRECT_UPDATE)
    public Result directUpdate(PersonCertificateVO personCertificateVO) {
        Result result = personCertificateService.directUpdate(personCertificateVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存证书信息
     */
    @ApiOperation(value = "保存证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonCertificateVOMeta.PAGE_INDEX, PersonCertificateVOMeta.PAGE_SIZE, PersonCertificateVOMeta.SEARCH_FIELD, PersonCertificateVOMeta.FUZZY_FIELD, PersonCertificateVOMeta.SEARCH_VALUE, PersonCertificateVOMeta.DIRTY_FIELDS, PersonCertificateVOMeta.SORT_FIELD, PersonCertificateVOMeta.SORT_TYPE, PersonCertificateVOMeta.DATA_ORIGIN, PersonCertificateVOMeta.QUERY_LOGIC, PersonCertificateVOMeta.REQUEST_ACTION, PersonCertificateVOMeta.IDS })
    @SentinelResource(value = PersonCertificateServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.SAVE)
    public Result save(PersonCertificateVO personCertificateVO) {
        Result result = personCertificateService.save(personCertificateVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取证书信息
     */
    @ApiOperation(value = "获取证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.GET_BY_ID)
    public Result<PersonCertificate> getById(String id) {
        Result<PersonCertificate> result = new Result<>();
        PersonCertificate personCertificate = personCertificateService.getById(id);
        // join 关联的对象
        personCertificateService.dao().fill(personCertificate).with("person").with("user").execute();
        result.success(true).data(personCertificate);
        return result;
    }

    /**
     *     审批
     */
    @ApiOperation(value = "审批")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.APPROVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.APPROVE)
    public Result approve(List<String> ids, String act, String msg) {
        return personCertificateService.approve(ids, act, msg);
    }

    /**
     * 批量获取证书信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.GET_BY_IDS)
    public Result<List<PersonCertificate>> getByIds(List<String> ids) {
        Result<List<PersonCertificate>> result = new Result<>();
        List<PersonCertificate> list = personCertificateService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询证书信息
     */
    @ApiOperation(value = "查询证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonCertificateVOMeta.PAGE_INDEX, PersonCertificateVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonCertificateServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.QUERY_LIST)
    public Result<List<PersonCertificate>> queryList(PersonCertificateVO sample) {
        Result<List<PersonCertificate>> result = new Result<>();
        List<PersonCertificate> list = personCertificateService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询证书信息
     */
    @ApiOperation(value = "分页查询证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonCertificate>> queryPagedList(PersonCertificateVO sample) {
        Result<PagedList<PersonCertificate>> result = new Result<>();
        sample.setEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
        PagedList<PersonCertificate> list = personCertificateService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personCertificateService.dao().fill(list).with("person").with("user").execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonCertificate::getPerson);
        personCertificateService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询证书信息
     */
    @ApiOperation(value = "分页查询证书信息")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertificateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.STATUS, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NAME, value = "证书名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.GET_TIME, value = "获得时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonCertificateVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonCertificateServiceProxy.QUERY_DATA_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonCertificateServiceProxy.QUERY_DATA_PAGED_LIST)
    public Result<PagedList<PersonCertificate>> queryDataPagedList(PersonCertificateVO sample) {

        if("admin".equals(sample.getRole())||"view".equals(sample.getRole())){
            Logger.info("role:"+sample.getRole());
        }else if("approval".equals(sample.getRole())){
            String curId = SessionUser.getCurrent().getActivatedEmployeeId();
            String sql = "select 1 from sys_busi_role a,sys_busi_role_member b where a.id=b.role_id and a.deleted=0 and member_type='employee' and member_id=? and code='hr_person_certificate'";
            sample.setStatus(ApprovalStatusEnum.WAIT.code());
            if (personCertificateService.dao().queryRecord(sql, curId) == null) {
                sample.setId("-1");
            }
        }
        // 如果不是在业务角色中，则返回空
        Result<PagedList<PersonCertificate>> result = new Result<>();
        PagedList<PersonCertificate> list = personCertificateService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personCertificateService.dao().fill(list).with("person").with("user").execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonCertificate::getPerson);
        personCertificateService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
