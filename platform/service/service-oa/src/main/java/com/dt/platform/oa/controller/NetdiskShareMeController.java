package com.dt.platform.oa.controller;

import java.util.*;
import com.dt.platform.domain.oa.*;
import com.dt.platform.domain.oa.meta.NetdiskMyShareMeta;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.domain.hrm.Person;
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
import com.dt.platform.proxy.oa.NetdiskShareMeServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskShareMeVOMeta;
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
import com.dt.platform.domain.oa.meta.NetdiskShareMeMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskShareMeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 分享给我接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:21:05
 */
@InDoc
@Api(tags = "分享给我")
@RestController("OaNetdiskShareMeController")
public class NetdiskShareMeController extends SuperController {

    @Autowired
    private INetdiskShareMeService netdiskShareMeService;

    /**
     * 添加分享给我
     */
    @ApiOperation(value = "添加分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.OWNER_USER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.SHARE_ID, value = "分享", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_TYPE, value = "文件类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskShareMeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.INSERT)
    public Result insert(NetdiskShareMeVO netdiskShareMeVO) {
        Result result = netdiskShareMeService.insert(netdiskShareMeVO, false);
        return result;
    }

    /**
     * 删除分享给我
     */
    @ApiOperation(value = "删除分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskShareMeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskShareMeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskShareMeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除分享给我 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskShareMeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskShareMeService.hasRefers(ids);
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
            Result result = netdiskShareMeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskShareMeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新分享给我
     */
    @ApiOperation(value = "更新分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.OWNER_USER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.SHARE_ID, value = "分享", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_TYPE, value = "文件类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskShareMeVOMeta.PAGE_INDEX, NetdiskShareMeVOMeta.PAGE_SIZE, NetdiskShareMeVOMeta.SEARCH_FIELD, NetdiskShareMeVOMeta.FUZZY_FIELD, NetdiskShareMeVOMeta.SEARCH_VALUE, NetdiskShareMeVOMeta.DIRTY_FIELDS, NetdiskShareMeVOMeta.SORT_FIELD, NetdiskShareMeVOMeta.SORT_TYPE, NetdiskShareMeVOMeta.DATA_ORIGIN, NetdiskShareMeVOMeta.QUERY_LOGIC, NetdiskShareMeVOMeta.REQUEST_ACTION, NetdiskShareMeVOMeta.IDS })
    @SentinelResource(value = NetdiskShareMeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.UPDATE)
    public Result update(NetdiskShareMeVO netdiskShareMeVO) {
        Result result = netdiskShareMeService.update(netdiskShareMeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存分享给我
     */
    @ApiOperation(value = "保存分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.OWNER_USER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.SHARE_ID, value = "分享", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_TYPE, value = "文件类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskShareMeVOMeta.PAGE_INDEX, NetdiskShareMeVOMeta.PAGE_SIZE, NetdiskShareMeVOMeta.SEARCH_FIELD, NetdiskShareMeVOMeta.FUZZY_FIELD, NetdiskShareMeVOMeta.SEARCH_VALUE, NetdiskShareMeVOMeta.DIRTY_FIELDS, NetdiskShareMeVOMeta.SORT_FIELD, NetdiskShareMeVOMeta.SORT_TYPE, NetdiskShareMeVOMeta.DATA_ORIGIN, NetdiskShareMeVOMeta.QUERY_LOGIC, NetdiskShareMeVOMeta.REQUEST_ACTION, NetdiskShareMeVOMeta.IDS })
    @SentinelResource(value = NetdiskShareMeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.SAVE)
    public Result save(NetdiskShareMeVO netdiskShareMeVO) {
        Result result = netdiskShareMeService.save(netdiskShareMeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取分享给我
     */
    @ApiOperation(value = "获取分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskShareMeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.GET_BY_ID)
    public Result<NetdiskShareMe> getById(String id) {
        Result<NetdiskShareMe> result = new Result<>();
        NetdiskShareMe netdiskShareMe = netdiskShareMeService.getById(id);
        // join 关联的对象
        netdiskShareMeService.dao().fill(netdiskShareMe).with("ownerUser").execute();
        result.success(true).data(netdiskShareMe);
        return result;
    }

    /**
     * 批量获取分享给我 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskShareMeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskShareMe>> getByIds(List<String> ids) {
        Result<List<NetdiskShareMe>> result = new Result<>();
        List<NetdiskShareMe> list = netdiskShareMeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询分享给我
     */
    @ApiOperation(value = "查询分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.OWNER_USER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.SHARE_ID, value = "分享", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_TYPE, value = "文件类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskShareMeVOMeta.PAGE_INDEX, NetdiskShareMeVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskShareMeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.QUERY_LIST)
    public Result<List<NetdiskShareMe>> queryList(NetdiskShareMeVO sample) {
        Result<List<NetdiskShareMe>> result = new Result<>();
        List<NetdiskShareMe> list = netdiskShareMeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询分享给我
     */
    @ApiOperation(value = "分页查询分享给我")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.OWNER_USER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.SHARE_ID, value = "分享", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskShareMeVOMeta.FD_TYPE, value = "文件类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskShareMeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskShareMeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskShareMe>> queryPagedList(NetdiskShareMeVO sample) {
        Result<PagedList<NetdiskShareMe>> result = new Result<>();
        sample.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
        ConditionExpr expr = new ConditionExpr();
        expr.and("file_id not in (select fd_id from oa_netdisk_recycle where deleted=0)");
        PagedList<NetdiskShareMe> list = netdiskShareMeService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        netdiskShareMeService.dao().fill(list).with("ownerUser").with(NetdiskShareMeMeta.NETDISK_FILE).with(NetdiskShareMeMeta.NETDISK_ORIGIN_FILE).execute();
        List<Employee> owners = CollectorUtil.collectList(list, NetdiskShareMe::getOwnerUser);
        netdiskShareMeService.dao().join(owners, Person.class);
        result.success(true).data(list);
        return result;
    }
}