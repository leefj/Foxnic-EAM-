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
import com.dt.platform.proxy.oa.CrmCustomerReviewServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerReviewVOMeta;
import com.dt.platform.domain.oa.CrmCustomerReview;
import com.dt.platform.domain.oa.CrmCustomerReviewVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerReviewMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerReviewService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 回访接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 10:54:09
 */
@InDoc
@Api(tags = "回访")
@RestController("OaCrmCustomerReviewController")
public class CrmCustomerReviewController extends SuperController {

    @Autowired
    private ICrmCustomerReviewService crmCustomerReviewService;

    /**
     * 添加回访
     */
    @ApiOperation(value = "添加回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655516394782720"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_USER_ID, value = "回访人", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_DATE, value = "回访时间", required = false, dataTypeClass = Date.class, example = "2023-09-19 12:00:00"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.METHOD_ID, value = "回访形式", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.SATISFACTION_ID, value = "客户满意度", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerReviewServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.INSERT)
    public Result insert(CrmCustomerReviewVO crmCustomerReviewVO) {
        Result result = crmCustomerReviewService.insert(crmCustomerReviewVO, false);
        return result;
    }

    /**
     * 删除回访
     */
    @ApiOperation(value = "删除回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655516394782720")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerReviewServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = crmCustomerReviewService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = crmCustomerReviewService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除回访 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerReviewServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = crmCustomerReviewService.hasRefers(ids);
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
            Result result = crmCustomerReviewService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = crmCustomerReviewService.deleteByIdsLogical(canDeleteIds);
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
     * 更新回访
     */
    @ApiOperation(value = "更新回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655516394782720"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_USER_ID, value = "回访人", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_DATE, value = "回访时间", required = false, dataTypeClass = Date.class, example = "2023-09-19 12:00:00"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.METHOD_ID, value = "回访形式", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.SATISFACTION_ID, value = "客户满意度", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerReviewVOMeta.PAGE_INDEX, CrmCustomerReviewVOMeta.PAGE_SIZE, CrmCustomerReviewVOMeta.SEARCH_FIELD, CrmCustomerReviewVOMeta.FUZZY_FIELD, CrmCustomerReviewVOMeta.SEARCH_VALUE, CrmCustomerReviewVOMeta.DIRTY_FIELDS, CrmCustomerReviewVOMeta.SORT_FIELD, CrmCustomerReviewVOMeta.SORT_TYPE, CrmCustomerReviewVOMeta.DATA_ORIGIN, CrmCustomerReviewVOMeta.QUERY_LOGIC, CrmCustomerReviewVOMeta.REQUEST_ACTION, CrmCustomerReviewVOMeta.IDS })
    @SentinelResource(value = CrmCustomerReviewServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.UPDATE)
    public Result update(CrmCustomerReviewVO crmCustomerReviewVO) {
        Result result = crmCustomerReviewService.update(crmCustomerReviewVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存回访
     */
    @ApiOperation(value = "保存回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655516394782720"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_USER_ID, value = "回访人", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_DATE, value = "回访时间", required = false, dataTypeClass = Date.class, example = "2023-09-19 12:00:00"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.METHOD_ID, value = "回访形式", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.SATISFACTION_ID, value = "客户满意度", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CrmCustomerReviewVOMeta.PAGE_INDEX, CrmCustomerReviewVOMeta.PAGE_SIZE, CrmCustomerReviewVOMeta.SEARCH_FIELD, CrmCustomerReviewVOMeta.FUZZY_FIELD, CrmCustomerReviewVOMeta.SEARCH_VALUE, CrmCustomerReviewVOMeta.DIRTY_FIELDS, CrmCustomerReviewVOMeta.SORT_FIELD, CrmCustomerReviewVOMeta.SORT_TYPE, CrmCustomerReviewVOMeta.DATA_ORIGIN, CrmCustomerReviewVOMeta.QUERY_LOGIC, CrmCustomerReviewVOMeta.REQUEST_ACTION, CrmCustomerReviewVOMeta.IDS })
    @SentinelResource(value = CrmCustomerReviewServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.SAVE)
    public Result save(CrmCustomerReviewVO crmCustomerReviewVO) {
        Result result = crmCustomerReviewService.save(crmCustomerReviewVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取回访
     */
    @ApiOperation(value = "获取回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerReviewServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.GET_BY_ID)
    public Result<CrmCustomerReview> getById(String id) {
        Result<CrmCustomerReview> result = new Result<>();
        CrmCustomerReview crmCustomerReview = crmCustomerReviewService.getById(id);
        // join 关联的对象
        crmCustomerReviewService.dao().fill(crmCustomerReview).with("originator").with("reviewUser").with(CrmCustomerReviewMeta.CRM_CUSTOMER).with(CrmCustomerReviewMeta.REVIEW_METHOD).with(CrmCustomerReviewMeta.SATISFACTION).execute();
        crmCustomerReviewService.dao().join(crmCustomerReview.getOriginator(), Person.class);
        crmCustomerReviewService.dao().join(crmCustomerReview.getReviewUser(), Person.class);
        result.success(true).data(crmCustomerReview);
        return result;
    }

    /**
     * 批量获取回访 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerReviewServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.GET_BY_IDS)
    public Result<List<CrmCustomerReview>> getByIds(List<String> ids) {
        Result<List<CrmCustomerReview>> result = new Result<>();
        List<CrmCustomerReview> list = crmCustomerReviewService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询回访
     */
    @ApiOperation(value = "查询回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655516394782720"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_USER_ID, value = "回访人", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_DATE, value = "回访时间", required = false, dataTypeClass = Date.class, example = "2023-09-19 12:00:00"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.METHOD_ID, value = "回访形式", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.SATISFACTION_ID, value = "客户满意度", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerReviewVOMeta.PAGE_INDEX, CrmCustomerReviewVOMeta.PAGE_SIZE })
    @SentinelResource(value = CrmCustomerReviewServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.QUERY_LIST)
    public Result<List<CrmCustomerReview>> queryList(CrmCustomerReviewVO sample) {
        Result<List<CrmCustomerReview>> result = new Result<>();
        List<CrmCustomerReview> list = crmCustomerReviewService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询回访
     */
    @ApiOperation(value = "分页查询回访")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655516394782720"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_USER_ID, value = "回访人", required = false, dataTypeClass = String.class, example = "581798649571311616"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.REVIEW_DATE, value = "回访时间", required = false, dataTypeClass = Date.class, example = "2023-09-19 12:00:00"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.METHOD_ID, value = "回访形式", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.SATISFACTION_ID, value = "客户满意度", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerReviewVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerReviewServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerReviewServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CrmCustomerReview>> queryPagedList(CrmCustomerReviewVO sample) {
        Result<PagedList<CrmCustomerReview>> result = new Result<>();
        PagedList<CrmCustomerReview> list = crmCustomerReviewService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        crmCustomerReviewService.dao().fill(list).with("originator").with("reviewUser").with(CrmCustomerReviewMeta.CRM_CUSTOMER).with(CrmCustomerReviewMeta.REVIEW_METHOD).with(CrmCustomerReviewMeta.SATISFACTION).execute();
        List<Employee> employees = CollectorUtil.collectList(list, CrmCustomerReview::getOriginator);
        crmCustomerReviewService.dao().join(employees, Person.class);
        List<Employee> owners = CollectorUtil.collectList(list, CrmCustomerReview::getReviewUser);
        crmCustomerReviewService.dao().join(owners, Person.class);
        result.success(true).data(list);
        return result;
    }
}
