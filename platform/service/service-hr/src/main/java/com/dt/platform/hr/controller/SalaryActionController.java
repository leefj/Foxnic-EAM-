package com.dt.platform.hr.controller;

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
import com.dt.platform.proxy.hr.SalaryActionServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryActionVOMeta;
import com.dt.platform.domain.hr.SalaryAction;
import com.dt.platform.domain.hr.SalaryActionVO;
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
import com.dt.platform.domain.hr.meta.SalaryActionMeta;
import com.dt.platform.domain.hr.SalaryTpl;
import com.dt.platform.domain.hr.SalaryMonth;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryActionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 薪酬发放接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:19:31
 */
@InDoc
@Api(tags = "薪酬发放")
@RestController("HrSalaryActionController")
public class SalaryActionController extends SuperController {

    @Autowired
    private ISalaryActionService salaryActionService;

    /**
     * 添加薪酬发放
     */
    @ApiOperation(value = "添加薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717755396189585408"),
		@ApiImplicitParam(name = SalaryActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "123"),
		@ApiImplicitParam(name = SalaryActionVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "jj"),
		@ApiImplicitParam(name = SalaryActionVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.START, value = "开始日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.END, value = "结束日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.WITH_TPL, value = "跟随模版", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.INSERT)
    public Result insert(SalaryActionVO salaryActionVO) {
        Result result = salaryActionService.insert(salaryActionVO, false);
        return result;
    }

    /**
     * 删除薪酬发放
     */
    @ApiOperation(value = "删除薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717755396189585408")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = salaryActionService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = salaryActionService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除薪酬发放 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = salaryActionService.hasRefers(ids);
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
            Result result = salaryActionService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = salaryActionService.deleteByIdsLogical(canDeleteIds);
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
     * 更新薪酬发放
     */
    @ApiOperation(value = "更新薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717755396189585408"),
		@ApiImplicitParam(name = SalaryActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "123"),
		@ApiImplicitParam(name = SalaryActionVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "jj"),
		@ApiImplicitParam(name = SalaryActionVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.START, value = "开始日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.END, value = "结束日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.WITH_TPL, value = "跟随模版", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryActionVOMeta.PAGE_INDEX, SalaryActionVOMeta.PAGE_SIZE, SalaryActionVOMeta.SEARCH_FIELD, SalaryActionVOMeta.FUZZY_FIELD, SalaryActionVOMeta.SEARCH_VALUE, SalaryActionVOMeta.DIRTY_FIELDS, SalaryActionVOMeta.SORT_FIELD, SalaryActionVOMeta.SORT_TYPE, SalaryActionVOMeta.DATA_ORIGIN, SalaryActionVOMeta.QUERY_LOGIC, SalaryActionVOMeta.REQUEST_ACTION, SalaryActionVOMeta.IDS })
    @SentinelResource(value = SalaryActionServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.UPDATE)
    public Result update(SalaryActionVO salaryActionVO) {
        Result result = salaryActionService.update(salaryActionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存薪酬发放
     */
    @ApiOperation(value = "保存薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717755396189585408"),
		@ApiImplicitParam(name = SalaryActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "123"),
		@ApiImplicitParam(name = SalaryActionVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "jj"),
		@ApiImplicitParam(name = SalaryActionVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.START, value = "开始日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.END, value = "结束日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.WITH_TPL, value = "跟随模版", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { SalaryActionVOMeta.PAGE_INDEX, SalaryActionVOMeta.PAGE_SIZE, SalaryActionVOMeta.SEARCH_FIELD, SalaryActionVOMeta.FUZZY_FIELD, SalaryActionVOMeta.SEARCH_VALUE, SalaryActionVOMeta.DIRTY_FIELDS, SalaryActionVOMeta.SORT_FIELD, SalaryActionVOMeta.SORT_TYPE, SalaryActionVOMeta.DATA_ORIGIN, SalaryActionVOMeta.QUERY_LOGIC, SalaryActionVOMeta.REQUEST_ACTION, SalaryActionVOMeta.IDS })
    @SentinelResource(value = SalaryActionServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.SAVE)
    public Result save(SalaryActionVO salaryActionVO) {
        Result result = salaryActionService.save(salaryActionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取薪酬发放
     */
    @ApiOperation(value = "获取薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.GET_BY_ID)
    public Result<SalaryAction> getById(String id) {
        Result<SalaryAction> result = new Result<>();
        SalaryAction salaryAction = salaryActionService.getById(id);
        // join 关联的对象
        salaryActionService.dao().fill(salaryAction).with(SalaryActionMeta.SALARY_TPL).with(SalaryActionMeta.SALARY_MONTH).execute();
        result.success(true).data(salaryAction);
        return result;
    }

    /**
     * 获取薪酬发放
     */
    @ApiOperation(value = "获取薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.CALCULATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.CALCULATE)
    public Result calculate(String id) {
        return salaryActionService.calculate(id);
    }

    /**
     * 获取薪酬发放
     */
    @ApiOperation(value = "获取薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.CREATE_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.CREATE_DATA)
    public Result createData(String id) {
        return salaryActionService.createData(id);
    }

    /**
     * 批量获取薪酬发放 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.GET_BY_IDS)
    public Result<List<SalaryAction>> getByIds(List<String> ids) {
        Result<List<SalaryAction>> result = new Result<>();
        List<SalaryAction> list = salaryActionService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询薪酬发放
     */
    @ApiOperation(value = "查询薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717755396189585408"),
		@ApiImplicitParam(name = SalaryActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "123"),
		@ApiImplicitParam(name = SalaryActionVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "jj"),
		@ApiImplicitParam(name = SalaryActionVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.START, value = "开始日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.END, value = "结束日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.WITH_TPL, value = "跟随模版", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryActionVOMeta.PAGE_INDEX, SalaryActionVOMeta.PAGE_SIZE })
    @SentinelResource(value = SalaryActionServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.QUERY_LIST)
    public Result<List<SalaryAction>> queryList(SalaryActionVO sample) {
        Result<List<SalaryAction>> result = new Result<>();
        List<SalaryAction> list = salaryActionService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询薪酬发放
     */
    @ApiOperation(value = "分页查询薪酬发放")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "717755396189585408"),
		@ApiImplicitParam(name = SalaryActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "123"),
		@ApiImplicitParam(name = SalaryActionVOMeta.ACTION_MONTH, value = "月份", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "jj"),
		@ApiImplicitParam(name = SalaryActionVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryActionVOMeta.START, value = "开始日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.END, value = "结束日期", required = false, dataTypeClass = Date.class, example = ""),
		@ApiImplicitParam(name = SalaryActionVOMeta.WITH_TPL, value = "跟随模版", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryActionServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryActionServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SalaryAction>> queryPagedList(SalaryActionVO sample) {
        Result<PagedList<SalaryAction>> result = new Result<>();
        PagedList<SalaryAction> list = salaryActionService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryActionService.dao().fill(list).with(SalaryActionMeta.SALARY_TPL).with(SalaryActionMeta.SALARY_MONTH).execute();
        result.success(true).data(list);
        return result;
    }
}
