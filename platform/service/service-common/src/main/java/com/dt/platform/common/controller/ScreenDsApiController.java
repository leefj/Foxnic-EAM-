package com.dt.platform.common.controller;

import java.util.*;
import com.alibaba.fastjson.JSONObject;
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
import com.dt.platform.proxy.common.ScreenDsApiServiceProxy;
import com.dt.platform.domain.common.meta.ScreenDsApiVOMeta;
import com.dt.platform.domain.common.ScreenDsApi;
import com.dt.platform.domain.common.ScreenDsApiVO;
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
import com.dt.platform.domain.common.meta.ScreenDsApiMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IScreenDsApiService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * API接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:47:30
 */
@InDoc
@Api(tags = "API")
@RestController("SysScreenDsApiController")
public class ScreenDsApiController extends SuperController {

    @Autowired
    private IScreenDsApiService screenDsApiService;

    /**
     * 添加API
     */
    @ApiOperation(value = "添加API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.REQ_TYPE, value = "请求方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.HEADER, value = "请求头", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.BODY, value = "请求体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.PARAM, value = "参数", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.INSERT)
    public Result insert(ScreenDsApiVO screenDsApiVO) {
        Result result = screenDsApiService.insert(screenDsApiVO, false);
        return result;
    }

    /**
     * 删除API
     */
    @ApiOperation(value = "删除API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = screenDsApiService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = screenDsApiService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 测试
     */
    @ApiOperation(value = "查询数据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.QUERY_DATA_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.QUERY_DATA_BY_ID)
    public Result<JSONObject> queryDataById(String id) {
        return screenDsApiService.queryDataById(id);
    }

    /**
     * 批量删除API <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = screenDsApiService.hasRefers(ids);
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
            Result result = screenDsApiService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = screenDsApiService.deleteByIdsLogical(canDeleteIds);
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
     * 更新API
     */
    @ApiOperation(value = "更新API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.REQ_TYPE, value = "请求方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.HEADER, value = "请求头", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.BODY, value = "请求体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.PARAM, value = "参数", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { ScreenDsApiVOMeta.PAGE_INDEX, ScreenDsApiVOMeta.PAGE_SIZE, ScreenDsApiVOMeta.SEARCH_FIELD, ScreenDsApiVOMeta.FUZZY_FIELD, ScreenDsApiVOMeta.SEARCH_VALUE, ScreenDsApiVOMeta.DIRTY_FIELDS, ScreenDsApiVOMeta.SORT_FIELD, ScreenDsApiVOMeta.SORT_TYPE, ScreenDsApiVOMeta.DATA_ORIGIN, ScreenDsApiVOMeta.QUERY_LOGIC, ScreenDsApiVOMeta.REQUEST_ACTION, ScreenDsApiVOMeta.IDS })
    @SentinelResource(value = ScreenDsApiServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.UPDATE)
    public Result update(ScreenDsApiVO screenDsApiVO) {
        Result result = screenDsApiService.update(screenDsApiVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存API
     */
    @ApiOperation(value = "保存API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.REQ_TYPE, value = "请求方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.HEADER, value = "请求头", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.BODY, value = "请求体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.PARAM, value = "参数", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { ScreenDsApiVOMeta.PAGE_INDEX, ScreenDsApiVOMeta.PAGE_SIZE, ScreenDsApiVOMeta.SEARCH_FIELD, ScreenDsApiVOMeta.FUZZY_FIELD, ScreenDsApiVOMeta.SEARCH_VALUE, ScreenDsApiVOMeta.DIRTY_FIELDS, ScreenDsApiVOMeta.SORT_FIELD, ScreenDsApiVOMeta.SORT_TYPE, ScreenDsApiVOMeta.DATA_ORIGIN, ScreenDsApiVOMeta.QUERY_LOGIC, ScreenDsApiVOMeta.REQUEST_ACTION, ScreenDsApiVOMeta.IDS })
    @SentinelResource(value = ScreenDsApiServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.SAVE)
    public Result save(ScreenDsApiVO screenDsApiVO) {
        Result result = screenDsApiService.save(screenDsApiVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取API
     */
    @ApiOperation(value = "获取API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.GET_BY_ID)
    public Result<ScreenDsApi> getById(String id) {
        Result<ScreenDsApi> result = new Result<>();
        ScreenDsApi screenDsApi = screenDsApiService.getById(id);
        result.success(true).data(screenDsApi);
        return result;
    }

    /**
     * 批量获取API <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.GET_BY_IDS)
    public Result<List<ScreenDsApi>> getByIds(List<String> ids) {
        Result<List<ScreenDsApi>> result = new Result<>();
        List<ScreenDsApi> list = screenDsApiService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询API
     */
    @ApiOperation(value = "查询API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.REQ_TYPE, value = "请求方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.HEADER, value = "请求头", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.BODY, value = "请求体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.PARAM, value = "参数", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { ScreenDsApiVOMeta.PAGE_INDEX, ScreenDsApiVOMeta.PAGE_SIZE })
    @SentinelResource(value = ScreenDsApiServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.QUERY_LIST)
    public Result<List<ScreenDsApi>> queryList(ScreenDsApiVO sample) {
        Result<List<ScreenDsApi>> result = new Result<>();
        List<ScreenDsApi> list = screenDsApiService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询API
     */
    @ApiOperation(value = "分页查询API")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsApiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.REQ_TYPE, value = "请求方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.HEADER, value = "请求头", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.BODY, value = "请求体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ScreenDsApiVOMeta.PARAM, value = "参数", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = ScreenDsApiServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ScreenDsApiServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ScreenDsApi>> queryPagedList(ScreenDsApiVO sample) {
        Result<PagedList<ScreenDsApi>> result = new Result<>();
        PagedList<ScreenDsApi> list = screenDsApiService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
