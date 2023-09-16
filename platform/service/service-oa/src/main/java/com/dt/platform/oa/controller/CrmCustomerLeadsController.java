package com.dt.platform.oa.controller;

import java.util.*;
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
import com.dt.platform.proxy.oa.CrmCustomerLeadsServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsVOMeta;
import com.dt.platform.domain.oa.CrmCustomerLeads;
import com.dt.platform.domain.oa.CrmCustomerLeadsVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.oa.CrmCustomerIndustry;
import com.dt.platform.domain.oa.CrmCustomerIntentional;
import com.dt.platform.domain.oa.CrmCustomerLevel;
import com.dt.platform.domain.oa.CrmCustomerSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerLeadsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 线索接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:39
 */
@InDoc
@Api(tags = "线索")
@RestController("OaCrmCustomerLeadsController")
public class CrmCustomerLeadsController extends SuperController {

    @Autowired
    private ICrmCustomerLeadsService crmCustomerLeadsService;

    /**
     * 添加线索
     */
    @ApiOperation(value = "添加线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655419074347008"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.INSERT)
    public Result insert(CrmCustomerLeadsVO crmCustomerLeadsVO) {
        Result result = crmCustomerLeadsService.insert(crmCustomerLeadsVO, false);
        return result;
    }

    /**
     * 删除线索
     */
    @ApiOperation(value = "删除线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655419074347008")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = crmCustomerLeadsService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = crmCustomerLeadsService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除线索 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = crmCustomerLeadsService.hasRefers(ids);
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
            Result result = crmCustomerLeadsService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = crmCustomerLeadsService.deleteByIdsLogical(canDeleteIds);
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
     * 更新线索
     */
    @ApiOperation(value = "更新线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655419074347008"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerLeadsVOMeta.PAGE_INDEX, CrmCustomerLeadsVOMeta.PAGE_SIZE, CrmCustomerLeadsVOMeta.SEARCH_FIELD, CrmCustomerLeadsVOMeta.FUZZY_FIELD, CrmCustomerLeadsVOMeta.SEARCH_VALUE, CrmCustomerLeadsVOMeta.DIRTY_FIELDS, CrmCustomerLeadsVOMeta.SORT_FIELD, CrmCustomerLeadsVOMeta.SORT_TYPE, CrmCustomerLeadsVOMeta.DATA_ORIGIN, CrmCustomerLeadsVOMeta.QUERY_LOGIC, CrmCustomerLeadsVOMeta.REQUEST_ACTION, CrmCustomerLeadsVOMeta.IDS })
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.UPDATE)
    public Result update(CrmCustomerLeadsVO crmCustomerLeadsVO) {
        Result result = crmCustomerLeadsService.update(crmCustomerLeadsVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存线索
     */
    @ApiOperation(value = "保存线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655419074347008"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CrmCustomerLeadsVOMeta.PAGE_INDEX, CrmCustomerLeadsVOMeta.PAGE_SIZE, CrmCustomerLeadsVOMeta.SEARCH_FIELD, CrmCustomerLeadsVOMeta.FUZZY_FIELD, CrmCustomerLeadsVOMeta.SEARCH_VALUE, CrmCustomerLeadsVOMeta.DIRTY_FIELDS, CrmCustomerLeadsVOMeta.SORT_FIELD, CrmCustomerLeadsVOMeta.SORT_TYPE, CrmCustomerLeadsVOMeta.DATA_ORIGIN, CrmCustomerLeadsVOMeta.QUERY_LOGIC, CrmCustomerLeadsVOMeta.REQUEST_ACTION, CrmCustomerLeadsVOMeta.IDS })
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.SAVE)
    public Result save(CrmCustomerLeadsVO crmCustomerLeadsVO) {
        Result result = crmCustomerLeadsService.save(crmCustomerLeadsVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取线索
     */
    @ApiOperation(value = "获取线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.GET_BY_ID)
    public Result<CrmCustomerLeads> getById(String id) {
        Result<CrmCustomerLeads> result = new Result<>();
        CrmCustomerLeads crmCustomerLeads = crmCustomerLeadsService.getById(id);
        // join 关联的对象
        crmCustomerLeadsService.dao().fill(crmCustomerLeads).with("owner").with("originator").with(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL).execute();
        crmCustomerLeadsService.dao().join(crmCustomerLeads.getOriginator(), Person.class);
        crmCustomerLeadsService.dao().join(crmCustomerLeads.getOwner(), Person.class);
        result.success(true).data(crmCustomerLeads);
        return result;
    }

    /**
     * 转换客户
     */
    @ApiOperation(value = "转换客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.CONVERT_TO_CUSTOMER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.CONVERT_TO_CUSTOMER)
    public Result convertToCustomer(String id) {
        return crmCustomerLeadsService.convertToCustomer(id);
    }

    /**
     * 批量获取线索 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.GET_BY_IDS)
    public Result<List<CrmCustomerLeads>> getByIds(List<String> ids) {
        Result<List<CrmCustomerLeads>> result = new Result<>();
        List<CrmCustomerLeads> list = crmCustomerLeadsService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询线索
     */
    @ApiOperation(value = "查询线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655419074347008"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerLeadsVOMeta.PAGE_INDEX, CrmCustomerLeadsVOMeta.PAGE_SIZE })
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.QUERY_LIST)
    public Result<List<CrmCustomerLeads>> queryList(CrmCustomerLeadsVO sample) {
        Result<List<CrmCustomerLeads>> result = new Result<>();
        List<CrmCustomerLeads> list = crmCustomerLeadsService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询线索
     */
    @ApiOperation(value = "分页查询线索")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655419074347008"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeadsServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeadsServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CrmCustomerLeads>> queryPagedList(CrmCustomerLeadsVO sample) {
        Result<PagedList<CrmCustomerLeads>> result = new Result<>();
        PagedList<CrmCustomerLeads> list = crmCustomerLeadsService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        crmCustomerLeadsService.dao().fill(list).with("owner").with("originator").with(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL).execute();
        result.success(true).data(list);
        List<Employee> employees = CollectorUtil.collectList(list, CrmCustomerLeads::getOriginator);
        crmCustomerLeadsService.dao().join(employees, Person.class);
        List<Employee> owners = CollectorUtil.collectList(list, CrmCustomerLeads::getOwner);
        crmCustomerLeadsService.dao().join(owners, Person.class);
        return result;
    }
}
