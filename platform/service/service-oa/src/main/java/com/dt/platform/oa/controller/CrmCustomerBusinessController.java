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
import com.dt.platform.proxy.oa.CrmCustomerBusinessServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerBusinessVOMeta;
import com.dt.platform.domain.oa.CrmCustomerBusiness;
import com.dt.platform.domain.oa.CrmCustomerBusinessVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerBusinessMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerBusinessService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商机接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 16:45:00
 */
@InDoc
@Api(tags = "商机")
@RestController("OaCrmCustomerBusinessController")
public class CrmCustomerBusinessController extends SuperController {

    @Autowired
    private ICrmCustomerBusinessService crmCustomerBusinessService;

    /**
     * 添加商机
     */
    @ApiOperation(value = "添加商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655603321733120"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.AMOUNT, value = "价格", required = false, dataTypeClass = BigDecimal.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.STAGE, value = "商机阶段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.INSERT)
    public Result insert(CrmCustomerBusinessVO crmCustomerBusinessVO) {
        Result result = crmCustomerBusinessService.insert(crmCustomerBusinessVO, false);
        return result;
    }

    /**
     * 删除商机
     */
    @ApiOperation(value = "删除商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655603321733120")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = crmCustomerBusinessService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = crmCustomerBusinessService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除商机 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = crmCustomerBusinessService.hasRefers(ids);
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
            Result result = crmCustomerBusinessService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = crmCustomerBusinessService.deleteByIdsLogical(canDeleteIds);
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
     * 更新商机
     */
    @ApiOperation(value = "更新商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655603321733120"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.AMOUNT, value = "价格", required = false, dataTypeClass = BigDecimal.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.STAGE, value = "商机阶段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerBusinessVOMeta.PAGE_INDEX, CrmCustomerBusinessVOMeta.PAGE_SIZE, CrmCustomerBusinessVOMeta.SEARCH_FIELD, CrmCustomerBusinessVOMeta.FUZZY_FIELD, CrmCustomerBusinessVOMeta.SEARCH_VALUE, CrmCustomerBusinessVOMeta.DIRTY_FIELDS, CrmCustomerBusinessVOMeta.SORT_FIELD, CrmCustomerBusinessVOMeta.SORT_TYPE, CrmCustomerBusinessVOMeta.DATA_ORIGIN, CrmCustomerBusinessVOMeta.QUERY_LOGIC, CrmCustomerBusinessVOMeta.REQUEST_ACTION, CrmCustomerBusinessVOMeta.IDS })
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.UPDATE)
    public Result update(CrmCustomerBusinessVO crmCustomerBusinessVO) {
        Result result = crmCustomerBusinessService.update(crmCustomerBusinessVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存商机
     */
    @ApiOperation(value = "保存商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655603321733120"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.AMOUNT, value = "价格", required = false, dataTypeClass = BigDecimal.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.STAGE, value = "商机阶段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CrmCustomerBusinessVOMeta.PAGE_INDEX, CrmCustomerBusinessVOMeta.PAGE_SIZE, CrmCustomerBusinessVOMeta.SEARCH_FIELD, CrmCustomerBusinessVOMeta.FUZZY_FIELD, CrmCustomerBusinessVOMeta.SEARCH_VALUE, CrmCustomerBusinessVOMeta.DIRTY_FIELDS, CrmCustomerBusinessVOMeta.SORT_FIELD, CrmCustomerBusinessVOMeta.SORT_TYPE, CrmCustomerBusinessVOMeta.DATA_ORIGIN, CrmCustomerBusinessVOMeta.QUERY_LOGIC, CrmCustomerBusinessVOMeta.REQUEST_ACTION, CrmCustomerBusinessVOMeta.IDS })
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.SAVE)
    public Result save(CrmCustomerBusinessVO crmCustomerBusinessVO) {
        Result result = crmCustomerBusinessService.save(crmCustomerBusinessVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取商机
     */
    @ApiOperation(value = "获取商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.GET_BY_ID)
    public Result<CrmCustomerBusiness> getById(String id) {
        Result<CrmCustomerBusiness> result = new Result<>();
        CrmCustomerBusiness crmCustomerBusiness = crmCustomerBusinessService.getById(id);
        // join 关联的对象
        crmCustomerBusinessService.dao().fill(crmCustomerBusiness).with("originator").with(CrmCustomerBusinessMeta.CRM_CUSTOMER).execute();
        crmCustomerBusinessService.dao().join(crmCustomerBusiness.getOriginator(), Person.class);
        result.success(true).data(crmCustomerBusiness);
        return result;
    }

    /**
     * 批量获取商机 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.GET_BY_IDS)
    public Result<List<CrmCustomerBusiness>> getByIds(List<String> ids) {
        Result<List<CrmCustomerBusiness>> result = new Result<>();
        List<CrmCustomerBusiness> list = crmCustomerBusinessService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询商机
     */
    @ApiOperation(value = "查询商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655603321733120"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.AMOUNT, value = "价格", required = false, dataTypeClass = BigDecimal.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.STAGE, value = "商机阶段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CrmCustomerBusinessVOMeta.PAGE_INDEX, CrmCustomerBusinessVOMeta.PAGE_SIZE })
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.QUERY_LIST)
    public Result<List<CrmCustomerBusiness>> queryList(CrmCustomerBusinessVO sample) {
        Result<List<CrmCustomerBusiness>> result = new Result<>();
        List<CrmCustomerBusiness> list = crmCustomerBusinessService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询商机
     */
    @ApiOperation(value = "分页查询商机")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "754655603321733120"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CUSTOMER_ID, value = "客户", required = false, dataTypeClass = String.class, example = "754655093655076864"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.AMOUNT, value = "价格", required = false, dataTypeClass = BigDecimal.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.STAGE, value = "商机阶段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CrmCustomerBusinessVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CrmCustomerBusinessServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CrmCustomerBusinessServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CrmCustomerBusiness>> queryPagedList(CrmCustomerBusinessVO sample) {
        Result<PagedList<CrmCustomerBusiness>> result = new Result<>();
        PagedList<CrmCustomerBusiness> list = crmCustomerBusinessService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        crmCustomerBusinessService.dao().fill(list).with("originator").with(CrmCustomerBusinessMeta.CRM_CUSTOMER).execute();
        List<Employee> employees = CollectorUtil.collectList(list, CrmCustomerBusiness::getOriginator);
        crmCustomerBusinessService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }
}
