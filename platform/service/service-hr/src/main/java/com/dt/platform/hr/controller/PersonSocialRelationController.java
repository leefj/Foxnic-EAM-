package com.dt.platform.hr.controller;

import java.util.*;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.PersonWorkExperience;
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
import com.dt.platform.proxy.hr.PersonSocialRelationServiceProxy;
import com.dt.platform.domain.hr.meta.PersonSocialRelationVOMeta;
import com.dt.platform.domain.hr.PersonSocialRelation;
import com.dt.platform.domain.hr.PersonSocialRelationVO;
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
import com.dt.platform.domain.hr.meta.PersonSocialRelationMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonSocialRelationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 社会关系接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 16:05:43
 */
@InDoc
@Api(tags = "社会关系")
@RestController("HrPersonSocialRelationController")
public class PersonSocialRelationController extends SuperController {

    @Autowired
    private IPersonSocialRelationService personSocialRelationService;

    /**
     * 添加社会关系
     */
    @ApiOperation(value = "添加社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.INSERT)
    public Result insert(PersonSocialRelationVO personSocialRelationVO) {
        Result result = personSocialRelationService.insert(personSocialRelationVO, false);
        return result;
    }

    /**
     * 添加社会关系
     */
    @ApiOperation(value = "添加社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.DIRECT_INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.DIRECT_INSERT)
    public Result directInsert(PersonSocialRelationVO personSocialRelationVO) {
        Result result = personSocialRelationService.directInsert(personSocialRelationVO, false);
        return result;
    }

    /**
     * 删除社会关系
     */
    @ApiOperation(value = "删除社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personSocialRelationService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personSocialRelationService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除社会关系 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personSocialRelationService.hasRefers(ids);
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
            Result result = personSocialRelationService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personSocialRelationService.deleteByIdsLogical(canDeleteIds);
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
     * 更新社会关系
     */
    @ApiOperation(value = "更新社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonSocialRelationVOMeta.PAGE_INDEX, PersonSocialRelationVOMeta.PAGE_SIZE, PersonSocialRelationVOMeta.SEARCH_FIELD, PersonSocialRelationVOMeta.FUZZY_FIELD, PersonSocialRelationVOMeta.SEARCH_VALUE, PersonSocialRelationVOMeta.DIRTY_FIELDS, PersonSocialRelationVOMeta.SORT_FIELD, PersonSocialRelationVOMeta.SORT_TYPE, PersonSocialRelationVOMeta.DATA_ORIGIN, PersonSocialRelationVOMeta.QUERY_LOGIC, PersonSocialRelationVOMeta.REQUEST_ACTION, PersonSocialRelationVOMeta.IDS })
    @SentinelResource(value = PersonSocialRelationServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.UPDATE)
    public Result update(PersonSocialRelationVO personSocialRelationVO) {
        Result result = personSocialRelationService.update(personSocialRelationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 更新社会关系
     */
    @ApiOperation(value = "更新社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonSocialRelationVOMeta.PAGE_INDEX, PersonSocialRelationVOMeta.PAGE_SIZE, PersonSocialRelationVOMeta.SEARCH_FIELD, PersonSocialRelationVOMeta.FUZZY_FIELD, PersonSocialRelationVOMeta.SEARCH_VALUE, PersonSocialRelationVOMeta.DIRTY_FIELDS, PersonSocialRelationVOMeta.SORT_FIELD, PersonSocialRelationVOMeta.SORT_TYPE, PersonSocialRelationVOMeta.DATA_ORIGIN, PersonSocialRelationVOMeta.QUERY_LOGIC, PersonSocialRelationVOMeta.REQUEST_ACTION, PersonSocialRelationVOMeta.IDS })
    @SentinelResource(value = PersonSocialRelationServiceProxy.DIRECT_UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.DIRECT_UPDATE)
    public Result directUpdate(PersonSocialRelationVO personSocialRelationVO) {
        Result result = personSocialRelationService.directUpdate(personSocialRelationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存社会关系
     */
    @ApiOperation(value = "保存社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonSocialRelationVOMeta.PAGE_INDEX, PersonSocialRelationVOMeta.PAGE_SIZE, PersonSocialRelationVOMeta.SEARCH_FIELD, PersonSocialRelationVOMeta.FUZZY_FIELD, PersonSocialRelationVOMeta.SEARCH_VALUE, PersonSocialRelationVOMeta.DIRTY_FIELDS, PersonSocialRelationVOMeta.SORT_FIELD, PersonSocialRelationVOMeta.SORT_TYPE, PersonSocialRelationVOMeta.DATA_ORIGIN, PersonSocialRelationVOMeta.QUERY_LOGIC, PersonSocialRelationVOMeta.REQUEST_ACTION, PersonSocialRelationVOMeta.IDS })
    @SentinelResource(value = PersonSocialRelationServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.SAVE)
    public Result save(PersonSocialRelationVO personSocialRelationVO) {
        Result result = personSocialRelationService.save(personSocialRelationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取社会关系
     */
    @ApiOperation(value = "获取社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.GET_BY_ID)
    public Result<PersonSocialRelation> getById(String id) {
        Result<PersonSocialRelation> result = new Result<>();
        PersonSocialRelation personSocialRelation = personSocialRelationService.getById(id);
        // join 关联的对象
        personSocialRelationService.dao().fill(personSocialRelation).with("person").with("user").with(PersonSocialRelationMeta.SOCIAL_RELATION).with(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE).execute();
        result.success(true).data(personSocialRelation);
        return result;
    }

    /**
     * 批量获取社会关系 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.GET_BY_IDS)
    public Result<List<PersonSocialRelation>> getByIds(List<String> ids) {
        Result<List<PersonSocialRelation>> result = new Result<>();
        List<PersonSocialRelation> list = personSocialRelationService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询社会关系
     */
    @ApiOperation(value = "查询社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonSocialRelationVOMeta.PAGE_INDEX, PersonSocialRelationVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonSocialRelationServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.QUERY_LIST)
    public Result<List<PersonSocialRelation>> queryList(PersonSocialRelationVO sample) {
        Result<List<PersonSocialRelation>> result = new Result<>();
        List<PersonSocialRelation> list = personSocialRelationService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询社会关系
     */
    @ApiOperation(value = "分页查询社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_ID, value = "关联", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.PERSON_ID, value = "员工", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonSocialRelation>> queryPagedList(PersonSocialRelationVO sample) {
        sample.setEmployeeId(SessionUser.getCurrent().getActivatedEmployeeId());
        Result<PagedList<PersonSocialRelation>> result = new Result<>();
        PagedList<PersonSocialRelation> list = personSocialRelationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personSocialRelationService.dao().fill(list).with("user").with("person").with(PersonSocialRelationMeta.SOCIAL_RELATION).with(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE).execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonSocialRelation::getPerson);
        personSocialRelationService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     *     审批
     */
    @ApiOperation(value = "审批")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.APPROVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.APPROVE)
    public Result approve(List<String> ids, String act, String msg) {
        return personSocialRelationService.approve(ids, act, msg);
    }

    /**
     * 分页查询社会关系
     */
    @ApiOperation(value = "分页查询社会关系")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMPLOYEE_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL_TYPE, value = "关系类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.REL, value = "关系", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.WORK_COMPANY, value = "工作单位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.CONCAT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.EMERGENCY_CONTACT, value = "紧急联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonSocialRelationVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonSocialRelationServiceProxy.QUERY_DATA_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonSocialRelationServiceProxy.QUERY_DATA_PAGED_LIST)
    public Result<PagedList<PersonSocialRelation>> queryDataPagedList(PersonSocialRelationVO sample) {

        if("admin".equals(sample.getRole())||"view".equals(sample.getRole())){
            Logger.info("role:"+sample.getRole());
        }else if("approval".equals(sample.getRole())){
            String curId = SessionUser.getCurrent().getActivatedEmployeeId();
            String sql = "select 1 from sys_busi_role a,sys_busi_role_member b where a.id=b.role_id and a.deleted=0 and member_type='employee' and member_id=? and code='hr_person_certificate'";
            sample.setStatus(ApprovalStatusEnum.WAIT.code());
            if (personSocialRelationService.dao().queryRecord(sql, curId) == null) {
                sample.setId("-1");
            }
        }


        Result<PagedList<PersonSocialRelation>> result = new Result<>();
        PagedList<PersonSocialRelation> list = personSocialRelationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personSocialRelationService.dao().fill(list).with("user").with(PersonSocialRelationMeta.PERSON).with(PersonSocialRelationMeta.SOCIAL_RELATION).with(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE).execute();
        List<Employee> users = CollectorUtil.collectList(list, PersonSocialRelation::getPerson);
        personSocialRelationService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
