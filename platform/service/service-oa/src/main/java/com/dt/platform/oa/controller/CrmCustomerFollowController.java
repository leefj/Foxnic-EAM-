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
import com.dt.platform.proxy.oa.CrmCustomerFollowServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerFollowVOMeta;
import com.dt.platform.domain.oa.CrmCustomerFollow;
import com.dt.platform.domain.oa.CrmCustomerFollowVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerFollowMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerFollowService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 跟进记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-15 14:16:05
 */
@InDoc
@Api(tags = "跟进记录")
@RestController("OaCrmCustomerFollowController")
public class CrmCustomerFollowController extends SuperController {

    @Autowired
    private ICrmCustomerFollowService crmCustomerFollowService;

    /**
     * 添加跟进记录
     */
    @ApiOperation(value = "添加跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerFollowServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.INSERT)
    public Result insert(CrmCustomerFollowVO crmCustomerFollowVO) {
        Result result = crmCustomerFollowService.insert(crmCustomerFollowVO, false);
        return result;
    }

    /**
     * 删除跟进记录
     */
    @ApiOperation(value = "删除跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerFollowServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = crmCustomerFollowService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = crmCustomerFollowService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除跟进记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerFollowServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = crmCustomerFollowService.hasRefers(ids);
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
            Result result = crmCustomerFollowService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = crmCustomerFollowService.deleteByIdsLogical(canDeleteIds);
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
     * 更新跟进记录
     */
    @ApiOperation(value = "更新跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerFollowVOMeta.PAGE_INDEX, CrmCustomerFollowVOMeta.PAGE_SIZE, CrmCustomerFollowVOMeta.SEARCH_FIELD, CrmCustomerFollowVOMeta.FUZZY_FIELD, CrmCustomerFollowVOMeta.SEARCH_VALUE, CrmCustomerFollowVOMeta.DIRTY_FIELDS, CrmCustomerFollowVOMeta.SORT_FIELD, CrmCustomerFollowVOMeta.SORT_TYPE, CrmCustomerFollowVOMeta.DATA_ORIGIN, CrmCustomerFollowVOMeta.QUERY_LOGIC, CrmCustomerFollowVOMeta.REQUEST_ACTION, CrmCustomerFollowVOMeta.IDS })
    @SentinelResource(value = CrmCustomerFollowServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.UPDATE)
    public Result update(CrmCustomerFollowVO crmCustomerFollowVO) {
        Result result = crmCustomerFollowService.update(crmCustomerFollowVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存跟进记录
     */
    @ApiOperation(value = "保存跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CrmCustomerFollowVOMeta.PAGE_INDEX, CrmCustomerFollowVOMeta.PAGE_SIZE, CrmCustomerFollowVOMeta.SEARCH_FIELD, CrmCustomerFollowVOMeta.FUZZY_FIELD, CrmCustomerFollowVOMeta.SEARCH_VALUE, CrmCustomerFollowVOMeta.DIRTY_FIELDS, CrmCustomerFollowVOMeta.SORT_FIELD, CrmCustomerFollowVOMeta.SORT_TYPE, CrmCustomerFollowVOMeta.DATA_ORIGIN, CrmCustomerFollowVOMeta.QUERY_LOGIC, CrmCustomerFollowVOMeta.REQUEST_ACTION, CrmCustomerFollowVOMeta.IDS })
    @SentinelResource(value = CrmCustomerFollowServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.SAVE)
    public Result save(CrmCustomerFollowVO crmCustomerFollowVO) {
        Result result = crmCustomerFollowService.save(crmCustomerFollowVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取跟进记录
     */
    @ApiOperation(value = "获取跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerFollowServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.GET_BY_ID)
    public Result<CrmCustomerFollow> getById(String id) {
        Result<CrmCustomerFollow> result = new Result<>();
        CrmCustomerFollow crmCustomerFollow = crmCustomerFollowService.getById(id);
        // join 关联的对象
        crmCustomerFollowService.dao().fill(crmCustomerFollow).with("originator").with(CrmCustomerFollowMeta.CRM_CUSTOMER).execute();

        crmCustomerFollowService.dao().join(crmCustomerFollow.getOriginator(), Person.class);
        result.success(true).data(crmCustomerFollow);
        return result;
    }

    /**
     * 批量获取跟进记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerFollowServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.GET_BY_IDS)
    public Result<List<CrmCustomerFollow>> getByIds(List<String> ids) {
        Result<List<CrmCustomerFollow>> result = new Result<>();
        List<CrmCustomerFollow> list = crmCustomerFollowService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询跟进记录
     */
    @ApiOperation(value = "查询跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerFollowVOMeta.PAGE_INDEX, CrmCustomerFollowVOMeta.PAGE_SIZE })
    @SentinelResource(value = CrmCustomerFollowServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.QUERY_LIST)
    public Result<List<CrmCustomerFollow>> queryList(CrmCustomerFollowVO sample) {
        Result<List<CrmCustomerFollow>> result = new Result<>();
        List<CrmCustomerFollow> list = crmCustomerFollowService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询跟进记录
     */
    @ApiOperation(value = "分页查询跟进记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.REC_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerFollowVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerFollowServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerFollowServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CrmCustomerFollow>> queryPagedList(CrmCustomerFollowVO sample) {
        Result<PagedList<CrmCustomerFollow>> result = new Result<>();
        PagedList<CrmCustomerFollow> list = crmCustomerFollowService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        crmCustomerFollowService.dao().fill(list).with("originator").with(CrmCustomerFollowMeta.CRM_CUSTOMER).execute();

        List<Employee> owners = CollectorUtil.collectList(list, CrmCustomerFollow::getOriginator);
        crmCustomerFollowService.dao().join(owners, Person.class);


        result.success(true).data(list);
        return result;
    }
}
