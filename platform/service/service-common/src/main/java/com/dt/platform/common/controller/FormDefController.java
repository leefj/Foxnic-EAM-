package com.dt.platform.common.controller;

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
import com.dt.platform.proxy.common.FormDefServiceProxy;
import com.dt.platform.domain.common.meta.FormDefVOMeta;
import com.dt.platform.domain.common.FormDef;
import com.dt.platform.domain.common.FormDefVO;
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
import com.dt.platform.domain.common.meta.FormDefMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IFormDefService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 表单定义接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 12:56:31
 */
@InDoc
@Api(tags = "表单定义")
@RestController("SysFormDefController")
public class FormDefController extends SuperController {

    @Autowired
    private IFormDefService formDefService;

    /**
     * 添加表单定义
     */
    @ApiOperation(value = "添加表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.FORM_ID, value = "表单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.DESIGNER_DATA, value = "定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.INSERT)
    public Result insert(FormDefVO formDefVO) {
        Result result = formDefService.insert(formDefVO, false);
        return result;
    }

    /**
     * 删除表单定义
     */
    @ApiOperation(value = "删除表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = formDefService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = formDefService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除表单定义 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = formDefService.hasRefers(ids);
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
            Result result = formDefService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = formDefService.deleteByIdsLogical(canDeleteIds);
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
     * 更新表单定义
     */
    @ApiOperation(value = "更新表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.FORM_ID, value = "表单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.DESIGNER_DATA, value = "定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { FormDefVOMeta.PAGE_INDEX, FormDefVOMeta.PAGE_SIZE, FormDefVOMeta.SEARCH_FIELD, FormDefVOMeta.FUZZY_FIELD, FormDefVOMeta.SEARCH_VALUE, FormDefVOMeta.DIRTY_FIELDS, FormDefVOMeta.SORT_FIELD, FormDefVOMeta.SORT_TYPE, FormDefVOMeta.DATA_ORIGIN, FormDefVOMeta.QUERY_LOGIC, FormDefVOMeta.REQUEST_ACTION, FormDefVOMeta.IDS })
    @SentinelResource(value = FormDefServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.UPDATE)
    public Result update(FormDefVO formDefVO) {
        Result result = formDefService.update(formDefVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存表单定义
     */
    @ApiOperation(value = "保存表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.FORM_ID, value = "表单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.DESIGNER_DATA, value = "定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { FormDefVOMeta.PAGE_INDEX, FormDefVOMeta.PAGE_SIZE, FormDefVOMeta.SEARCH_FIELD, FormDefVOMeta.FUZZY_FIELD, FormDefVOMeta.SEARCH_VALUE, FormDefVOMeta.DIRTY_FIELDS, FormDefVOMeta.SORT_FIELD, FormDefVOMeta.SORT_TYPE, FormDefVOMeta.DATA_ORIGIN, FormDefVOMeta.QUERY_LOGIC, FormDefVOMeta.REQUEST_ACTION, FormDefVOMeta.IDS })
    @SentinelResource(value = FormDefServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.SAVE)
    public Result save(FormDefVO formDefVO) {
        Result result = formDefService.save(formDefVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取表单定义
     */
    @ApiOperation(value = "获取表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.GET_BY_ID)
    public Result<FormDef> getById(String id) {
        Result<FormDef> result = new Result<>();
        FormDef formDef = formDefService.getById(id);
        result.success(true).data(formDef);
        return result;
    }

    /**
     * 批量获取表单定义 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.GET_BY_IDS)
    public Result<List<FormDef>> getByIds(List<String> ids) {
        Result<List<FormDef>> result = new Result<>();
        List<FormDef> list = formDefService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询表单定义
     */
    @ApiOperation(value = "查询表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.FORM_ID, value = "表单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.DESIGNER_DATA, value = "定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { FormDefVOMeta.PAGE_INDEX, FormDefVOMeta.PAGE_SIZE })
    @SentinelResource(value = FormDefServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.QUERY_LIST)
    public Result<List<FormDef>> queryList(FormDefVO sample) {
        Result<List<FormDef>> result = new Result<>();
        List<FormDef> list = formDefService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询表单定义
     */
    @ApiOperation(value = "分页查询表单定义")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.FORM_ID, value = "表单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.DESIGNER_DATA, value = "定义", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FormDefVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<FormDef>> queryPagedList(FormDefVO sample) {
        Result<PagedList<FormDef>> result = new Result<>();
        PagedList<FormDef> list = formDefService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 获取表单定义
     */
    @ApiOperation(value = "获取表单定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
    })
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.COPY_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.COPY_DATA)
    public Result copyData(String id) {
        return formDefService.copyData(id);
    }

    /**
     * 获取表单定义
     */
    @ApiOperation(value = "获取表单定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
    })
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = FormDefServiceProxy.APPLY, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.APPLY)
    public Result apply(String id) {
        return formDefService.apply(id);
    }


    /**
     * 更新表单定义
     */
    @ApiOperation(value = "更新表单定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = FormDefVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = FormDefVOMeta.FORM_ID, value = "表单", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = FormDefVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = FormDefVOMeta.DESIGNER_DATA, value = "定义", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = FormDefVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
    })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { FormDefVOMeta.PAGE_INDEX, FormDefVOMeta.PAGE_SIZE, FormDefVOMeta.SEARCH_FIELD, FormDefVOMeta.FUZZY_FIELD, FormDefVOMeta.SEARCH_VALUE, FormDefVOMeta.DIRTY_FIELDS, FormDefVOMeta.SORT_FIELD, FormDefVOMeta.SORT_TYPE, FormDefVOMeta.DATA_ORIGIN, FormDefVOMeta.QUERY_LOGIC, FormDefVOMeta.REQUEST_ACTION, FormDefVOMeta.IDS })
    @SentinelResource(value = FormDefServiceProxy.SAVE_FORM_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FormDefServiceProxy.SAVE_FORM_BY_ID)
    public Result saveFormById(FormDefVO formDefVO) {
        Result result = formDefService.saveFormById(formDefVO);
        return result;
    }

}
