package com.dt.platform.oa.controller;

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
import com.dt.platform.proxy.oa.CrmCustomerLeaderServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerLeaderVOMeta;
import com.dt.platform.domain.oa.CrmCustomerLeader;
import com.dt.platform.domain.oa.CrmCustomerLeaderVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerLeaderMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerLeaderService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 团队成员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 10:53:52
 */
@InDoc
@Api(tags = "团队成员")
@RestController("OaCrmCustomerLeaderController")
public class CrmCustomerLeaderController extends SuperController {

    @Autowired
    private ICrmCustomerLeaderService crmCustomerLeaderService;

    /**
     * 添加团队成员
     */
    @ApiOperation(value = "添加团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),

		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.CUSTOMER_IDS, value = "客户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.INSERT)
    public Result insert(CrmCustomerLeaderVO crmCustomerLeaderVO) {
        Result result = crmCustomerLeaderService.insert(crmCustomerLeaderVO, false);
        return result;
    }

    /**
     * 删除团队成员
     */
    @ApiOperation(value = "删除团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = crmCustomerLeaderService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = crmCustomerLeaderService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除团队成员 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = crmCustomerLeaderService.hasRefers(ids);
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
            Result result = crmCustomerLeaderService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = crmCustomerLeaderService.deleteByIdsLogical(canDeleteIds);
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
     * 更新团队成员
     */
    @ApiOperation(value = "更新团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),

		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.CUSTOMER_IDS, value = "客户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerLeaderVOMeta.PAGE_INDEX, CrmCustomerLeaderVOMeta.PAGE_SIZE, CrmCustomerLeaderVOMeta.SEARCH_FIELD, CrmCustomerLeaderVOMeta.FUZZY_FIELD, CrmCustomerLeaderVOMeta.SEARCH_VALUE, CrmCustomerLeaderVOMeta.DIRTY_FIELDS, CrmCustomerLeaderVOMeta.SORT_FIELD, CrmCustomerLeaderVOMeta.SORT_TYPE, CrmCustomerLeaderVOMeta.DATA_ORIGIN, CrmCustomerLeaderVOMeta.QUERY_LOGIC, CrmCustomerLeaderVOMeta.REQUEST_ACTION, CrmCustomerLeaderVOMeta.IDS })
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.UPDATE)
    public Result update(CrmCustomerLeaderVO crmCustomerLeaderVO) {
        Result result = crmCustomerLeaderService.update(crmCustomerLeaderVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存团队成员
     */
    @ApiOperation(value = "保存团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),

		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.CUSTOMER_IDS, value = "客户", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CrmCustomerLeaderVOMeta.PAGE_INDEX, CrmCustomerLeaderVOMeta.PAGE_SIZE, CrmCustomerLeaderVOMeta.SEARCH_FIELD, CrmCustomerLeaderVOMeta.FUZZY_FIELD, CrmCustomerLeaderVOMeta.SEARCH_VALUE, CrmCustomerLeaderVOMeta.DIRTY_FIELDS, CrmCustomerLeaderVOMeta.SORT_FIELD, CrmCustomerLeaderVOMeta.SORT_TYPE, CrmCustomerLeaderVOMeta.DATA_ORIGIN, CrmCustomerLeaderVOMeta.QUERY_LOGIC, CrmCustomerLeaderVOMeta.REQUEST_ACTION, CrmCustomerLeaderVOMeta.IDS })
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.SAVE)
    public Result save(CrmCustomerLeaderVO crmCustomerLeaderVO) {
        Result result = crmCustomerLeaderService.save(crmCustomerLeaderVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取团队成员
     */
    @ApiOperation(value = "获取团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.GET_BY_ID)
    public Result<CrmCustomerLeader> getById(String id) {
        Result<CrmCustomerLeader> result = new Result<>();
        CrmCustomerLeader crmCustomerLeader = crmCustomerLeaderService.getById(id);
        // join 关联的对象
//        crmCustomerLeaderService.dao().fill(crmCustomerLeader).with(CrmCustomerLeaderMeta.CRM_CUSTOMER).execute();
        result.success(true).data(crmCustomerLeader);
        return result;
    }

    /**
     * 批量获取团队成员 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.GET_BY_IDS)
    public Result<List<CrmCustomerLeader>> getByIds(List<String> ids) {
        Result<List<CrmCustomerLeader>> result = new Result<>();
        List<CrmCustomerLeader> list = crmCustomerLeaderService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询团队成员
     */
    @ApiOperation(value = "查询团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),

		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.CUSTOMER_IDS, value = "客户", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerLeaderVOMeta.PAGE_INDEX, CrmCustomerLeaderVOMeta.PAGE_SIZE })
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.QUERY_LIST)
    public Result<List<CrmCustomerLeader>> queryList(CrmCustomerLeaderVO sample) {
        Result<List<CrmCustomerLeader>> result = new Result<>();
        List<CrmCustomerLeader> list = crmCustomerLeaderService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询团队成员
     */
    @ApiOperation(value = "分页查询团队成员")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),

		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerLeaderVOMeta.CUSTOMER_IDS, value = "客户", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerLeaderServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerLeaderServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CrmCustomerLeader>> queryPagedList(CrmCustomerLeaderVO sample) {
        Result<PagedList<CrmCustomerLeader>> result = new Result<>();
        PagedList<CrmCustomerLeader> list = crmCustomerLeaderService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象

        result.success(true).data(list);
        return result;
    }
}
