package com.dt.platform.oa.controller;

import java.util.*;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsVOMeta;
import com.dt.platform.proxy.oa.CrmCustomerLeadsServiceProxy;
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
import com.dt.platform.proxy.oa.CrmCustomerServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerVOMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import com.dt.platform.domain.oa.CrmCustomerVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.oa.CrmCustomerIndustry;
import com.dt.platform.domain.oa.CrmCustomerIntentional;
import com.dt.platform.domain.oa.CrmCustomerLevel;
import com.dt.platform.domain.oa.CrmCustomerSource;
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 客户接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:49
 */
@InDoc
@Api(tags = "客户")
@RestController("OaCrmCustomerController")
public class CrmCustomerController extends SuperController {

    @Autowired
    private ICrmCustomerService crmCustomerService;

    /**
     * 添加客户
     */
    @ApiOperation(value = "添加客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CODE, value = "客户编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586966688780517376"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.PROFILE, value = "客户介绍", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.TRANSACTION_STATUS, value = "成交状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ROLE_POS, value = "客户位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.INSERT)
    public Result insert(CrmCustomerVO crmCustomerVO) {
        Result result = crmCustomerService.insert(crmCustomerVO, false);
        return result;
    }

    /**
     * 删除客户
     */
    @ApiOperation(value = "删除客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655093655076864")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = crmCustomerService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = crmCustomerService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除客户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = crmCustomerService.hasRefers(ids);
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
            Result result = crmCustomerService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = crmCustomerService.deleteByIdsLogical(canDeleteIds);
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
     * 更新客户
     */
    @ApiOperation(value = "更新客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CODE, value = "客户编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586966688780517376"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.PROFILE, value = "客户介绍", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.TRANSACTION_STATUS, value = "成交状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ROLE_POS, value = "客户位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerVOMeta.PAGE_INDEX, CrmCustomerVOMeta.PAGE_SIZE, CrmCustomerVOMeta.SEARCH_FIELD, CrmCustomerVOMeta.FUZZY_FIELD, CrmCustomerVOMeta.SEARCH_VALUE, CrmCustomerVOMeta.DIRTY_FIELDS, CrmCustomerVOMeta.SORT_FIELD, CrmCustomerVOMeta.SORT_TYPE, CrmCustomerVOMeta.DATA_ORIGIN, CrmCustomerVOMeta.QUERY_LOGIC, CrmCustomerVOMeta.REQUEST_ACTION, CrmCustomerVOMeta.IDS })
    @SentinelResource(value = CrmCustomerServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.UPDATE)
    public Result update(CrmCustomerVO crmCustomerVO) {
        Result result = crmCustomerService.update(crmCustomerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存客户
     */
    @ApiOperation(value = "保存客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CODE, value = "客户编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586966688780517376"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.PROFILE, value = "客户介绍", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.TRANSACTION_STATUS, value = "成交状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ROLE_POS, value = "客户位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CrmCustomerVOMeta.PAGE_INDEX, CrmCustomerVOMeta.PAGE_SIZE, CrmCustomerVOMeta.SEARCH_FIELD, CrmCustomerVOMeta.FUZZY_FIELD, CrmCustomerVOMeta.SEARCH_VALUE, CrmCustomerVOMeta.DIRTY_FIELDS, CrmCustomerVOMeta.SORT_FIELD, CrmCustomerVOMeta.SORT_TYPE, CrmCustomerVOMeta.DATA_ORIGIN, CrmCustomerVOMeta.QUERY_LOGIC, CrmCustomerVOMeta.REQUEST_ACTION, CrmCustomerVOMeta.IDS })
    @SentinelResource(value = CrmCustomerServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.SAVE)
    public Result save(CrmCustomerVO crmCustomerVO) {
        Result result = crmCustomerService.save(crmCustomerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 锁定
     */
    @ApiOperation(value = "锁定")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.LOCK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.LOCK)
    public Result lock(String customerId) {
        return crmCustomerService.lock(customerId);
    }

    /**
     * 解锁
     */
    @ApiOperation(value = "解锁")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.UNLOCK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.UNLOCK)
    public Result unlock(String customerId) {
        return crmCustomerService.unlock(customerId);
    }

    /**
     * 成交
     */
    @ApiOperation(value = "成交")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.DEAL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.DEAL)
    public Result deal(String customerId) {
        return crmCustomerService.deal(customerId);
    }

    /**
     * 领用
     */
    @ApiOperation(value = "领用")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.COLLECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.COLLECT)
    public Result collect(String customerId) {
        return crmCustomerService.collect(customerId);
    }

    /**
     * 转入公海
     */
    @ApiOperation(value = "转入公海")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.TO_OPEN_SEA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.TO_OPEN_SEA)
    public Result toOpenSea(String customerId) {
        return crmCustomerService.toOpenSea(customerId);
    }

    /**
     * 转入无效
     */
    @ApiOperation(value = "转入无效")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.TO_INVALID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.TO_INVALID)
    public Result toValid(String customerId) {
        return crmCustomerService.toValid(customerId);
    }

    /**
     * 转移
     */
    @ApiOperation(value = "转移")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.TRANSFER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.TRANSFER)
    public Result transfer(String customerId, String userId) {
        return crmCustomerService.transfer(customerId, userId);
    }

    /**
     * 转移
     */
    @ApiOperation(value = "转移")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.BATCH_TRANSFER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.BATCH_TRANSFER)
    public Result batchTransfer(String customerIds, String userId) {
        return crmCustomerService.batchTransfer(customerIds, userId);
    }

    /**
     * 分配
     */
    @ApiOperation(value = "分配")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.BATCH_ALLOCATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.BATCH_ALLOCATE)
    public Result batchAllocate(String customerIds, String userId) {
        return crmCustomerService.batchAllocate(customerIds, userId);
    }

    /**
     * 取消关注
     */
    @ApiOperation(value = "取消关注")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.CARE_CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.CARE_CANCEL)
    public Result careCancel(String customerId) {
        return crmCustomerService.careCancel(customerId);
    }

    /**
     * 关注
     */
    @ApiOperation(value = "关注")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.CARE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.CARE)
    public Result care(String customerId) {
        return crmCustomerService.care(customerId);
    }

    /**
     * 转移
     */
    @ApiOperation(value = "分配")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.ALLOCATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.ALLOCATE)
    public Result allocate(String customerId, String userId) {
        return crmCustomerService.allocate(customerId, userId);
    }

    /**
     * 添加用户
     */
    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeadsVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.ADD_USERS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.ADD_USERS)
    public Result addUsers(String customerId, String userIds) {
        return crmCustomerService.addUsers(customerId, userIds);
    }

    /**
     * 获取客户
     */
    @ApiOperation(value = "获取客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.GET_BY_ID)
    public Result<CrmCustomer> getById(String id) {
        Result<CrmCustomer> result = new Result<>();
        CrmCustomer crmCustomer = crmCustomerService.getById(id);
        // join 关联的对象
        crmCustomerService.dao().fill(crmCustomer).with("owner").with("originator").with(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL).execute();
        crmCustomerService.dao().join(crmCustomer.getOriginator(), Person.class);
        crmCustomerService.dao().join(crmCustomer.getOwner(), Person.class);
        result.success(true).data(crmCustomer);
        return result;
    }

    /**
     * 批量获取客户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.GET_BY_IDS)
    public Result<List<CrmCustomer>> getByIds(List<String> ids) {
        Result<List<CrmCustomer>> result = new Result<>();
        List<CrmCustomer> list = crmCustomerService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询客户
     */
    @ApiOperation(value = "查询客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CODE, value = "客户编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586966688780517376"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.PROFILE, value = "客户介绍", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.TRANSACTION_STATUS, value = "成交状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ROLE_POS, value = "客户位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerVOMeta.PAGE_INDEX, CrmCustomerVOMeta.PAGE_SIZE })
    @SentinelResource(value = CrmCustomerServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.QUERY_LIST)
    public Result<List<CrmCustomer>> queryList(CrmCustomerVO sample) {
        Result<List<CrmCustomer>> result = new Result<>();
        List<CrmCustomer> list = crmCustomerService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询客户
     */
    @ApiOperation(value = "分页查询客户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CODE, value = "客户编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NAME, value = "客户名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LEVEL, value = "客户等级", required = false, dataTypeClass = String.class, example = "754282729792602112"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.OWNER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586966688780517376"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INTENTIONAL_STATE, value = "意向状态", required = false, dataTypeClass = String.class, example = "754291688482013184"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.INDUSTRY_ID, value = "所在行业", required = false, dataTypeClass = String.class, example = "754282104157634561"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.WEBSITE, value = "网址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.PROFILE, value = "客户介绍", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.SOURCE_ID, value = "客户来源", required = false, dataTypeClass = String.class, example = "754282314632003585"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ADDRESS, value = "客户地址", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.RECENT_FOLLOW_TIME, value = "最近跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NEXT_FOLLOW_TIME, value = "下次跟进", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.TRANSACTION_STATUS, value = "成交状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.LOCKED, value = "是否锁定", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.ROLE_POS, value = "客户位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerVOMeta.CONTACT_INFO, value = "联系方式", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CrmCustomer>> queryPagedList(CrmCustomerVO sample) {
        Result<PagedList<CrmCustomer>> result = new Result<>();
        PagedList<CrmCustomer> list = crmCustomerService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        crmCustomerService.dao().fill(list).with("owner").with("originator").with(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY).with(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL).execute();
        List<Employee> employees = CollectorUtil.collectList(list, CrmCustomer::getOriginator);
        crmCustomerService.dao().join(employees, Person.class);
        List<Employee> owners = CollectorUtil.collectList(list, CrmCustomer::getOwner);
        crmCustomerService.dao().join(owners, Person.class);
        result.success(true).data(list);
        return result;
    }
}
