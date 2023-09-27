package com.dt.platform.oa.controller;

import java.util.*;
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
import com.dt.platform.proxy.oa.NetdiskRecycleServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskRecycleVOMeta;
import com.dt.platform.domain.oa.NetdiskRecycle;
import com.dt.platform.domain.oa.NetdiskRecycleVO;
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
import com.dt.platform.domain.oa.meta.NetdiskRecycleMeta;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskRecycleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 回收站接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 20:48:14
 */
@InDoc
@Api(tags = "回收站")
@RestController("OaNetdiskRecycleController")
public class NetdiskRecycleController extends SuperController {

    @Autowired
    private INetdiskRecycleService netdiskRecycleService;

    /**
     * 添加回收站
     */
    @ApiOperation(value = "添加回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.DEL_TIME, value = "删除时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_ID, value = "FD", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.INSERT)
    public Result insert(NetdiskRecycleVO netdiskRecycleVO) {
        Result result = netdiskRecycleService.insert(netdiskRecycleVO, false);
        return result;
    }

    /**
     * 删除回收站
     */
    @ApiOperation(value = "删除回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskRecycleService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskRecycleService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除回收站 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskRecycleService.hasRefers(ids);
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
            Result result = netdiskRecycleService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskRecycleService.deleteByIdsLogical(canDeleteIds);
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
     * 更新回收站
     */
    @ApiOperation(value = "更新回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = NetdiskRecycleVOMeta.DEL_TIME, value = "删除时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_ID, value = "FD", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskRecycleVOMeta.PAGE_INDEX, NetdiskRecycleVOMeta.PAGE_SIZE, NetdiskRecycleVOMeta.SEARCH_FIELD, NetdiskRecycleVOMeta.FUZZY_FIELD, NetdiskRecycleVOMeta.SEARCH_VALUE, NetdiskRecycleVOMeta.DIRTY_FIELDS, NetdiskRecycleVOMeta.SORT_FIELD, NetdiskRecycleVOMeta.SORT_TYPE, NetdiskRecycleVOMeta.DATA_ORIGIN, NetdiskRecycleVOMeta.QUERY_LOGIC, NetdiskRecycleVOMeta.REQUEST_ACTION, NetdiskRecycleVOMeta.IDS })
    @SentinelResource(value = NetdiskRecycleServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.UPDATE)
    public Result update(NetdiskRecycleVO netdiskRecycleVO) {
        Result result = netdiskRecycleService.update(netdiskRecycleVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存回收站
     */
    @ApiOperation(value = "保存回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = NetdiskRecycleVOMeta.DEL_TIME, value = "删除时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_ID, value = "FD", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskRecycleVOMeta.PAGE_INDEX, NetdiskRecycleVOMeta.PAGE_SIZE, NetdiskRecycleVOMeta.SEARCH_FIELD, NetdiskRecycleVOMeta.FUZZY_FIELD, NetdiskRecycleVOMeta.SEARCH_VALUE, NetdiskRecycleVOMeta.DIRTY_FIELDS, NetdiskRecycleVOMeta.SORT_FIELD, NetdiskRecycleVOMeta.SORT_TYPE, NetdiskRecycleVOMeta.DATA_ORIGIN, NetdiskRecycleVOMeta.QUERY_LOGIC, NetdiskRecycleVOMeta.REQUEST_ACTION, NetdiskRecycleVOMeta.IDS })
    @SentinelResource(value = NetdiskRecycleServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.SAVE)
    public Result save(NetdiskRecycleVO netdiskRecycleVO) {
        Result result = netdiskRecycleService.save(netdiskRecycleVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取回收站
     */
    @ApiOperation(value = "获取回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.GET_BY_ID)
    public Result<NetdiskRecycle> getById(String id) {
        Result<NetdiskRecycle> result = new Result<>();
        NetdiskRecycle netdiskRecycle = netdiskRecycleService.getById(id);
        // join 关联的对象
        netdiskRecycleService.dao().fill(netdiskRecycle).with("ownerUser").execute();
        result.success(true).data(netdiskRecycle);
        return result;
    }

    /**
     * 批量获取回收站 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskRecycle>> getByIds(List<String> ids) {
        Result<List<NetdiskRecycle>> result = new Result<>();
        List<NetdiskRecycle> list = netdiskRecycleService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 批量获取回收站 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取回收站")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskRecycleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.CLEAR_RECYCLE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.CLEAR_RECYCLE)
    public Result clearRecycle() {
        return netdiskRecycleService.clearRecycle();
    }

    /**
     * 批量获取回收站 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取回收站")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskRecycleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.CLEAR_RECYCLE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.CLEAR_RECYCLE_BY_IDS)
    public Result clearRecycleByIds(List<String> ids) {
        return netdiskRecycleService.clearRecycleByIds(ids);
    }



    @ApiOperation(value = "还原")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskRecycleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @SentinelResource(value = NetdiskRecycleServiceProxy.RESTORE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.RESTORE)
    public Result restore(List<String> ids) {
        return netdiskRecycleService.restore(ids);
    }

    /**
     * 查询回收站
     */
    @ApiOperation(value = "查询回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = NetdiskRecycleVOMeta.DEL_TIME, value = "删除时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_ID, value = "FD", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskRecycleVOMeta.PAGE_INDEX, NetdiskRecycleVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskRecycleServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.QUERY_LIST)
    public Result<List<NetdiskRecycle>> queryList(NetdiskRecycleVO sample) {
        Result<List<NetdiskRecycle>> result = new Result<>();
        List<NetdiskRecycle> list = netdiskRecycleService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询回收站
     */
    @ApiOperation(value = "分页查询回收站")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		 @ApiImplicitParam(name = NetdiskRecycleVOMeta.DEL_TIME, value = "删除时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_ID, value = "FD", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskRecycleVOMeta.FD_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskRecycleServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskRecycleServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskRecycle>> queryPagedList(NetdiskRecycleVO sample) {
        Result<PagedList<NetdiskRecycle>> result = new Result<>();
        sample.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
        PagedList<NetdiskRecycle> list = netdiskRecycleService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        netdiskRecycleService.dao().fill(list).with("ownerUser").with(NetdiskRecycleMeta.NETDISK_ORIGIN_FILE).with(NetdiskRecycleMeta.NETDISK_FILE).with(NetdiskRecycleMeta.NETDISK_FOLDER).execute();
        result.success(true).data(list);
        return result;
    }
}
