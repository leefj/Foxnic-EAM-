package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.*;
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
import com.dt.platform.proxy.oa.NetdiskMyShareServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskMyShareVOMeta;
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
import com.dt.platform.domain.oa.meta.NetdiskMyShareMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskMyShareService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 我的分享接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:20:31
 */
@InDoc
@Api(tags = "我的分享")
@RestController("OaNetdiskMyShareController")
public class NetdiskMyShareController extends SuperController {

    @Autowired
    private INetdiskMyShareService netdiskMyShareService;

    /**
     * 添加我的分享
     */
    @ApiOperation(value = "添加我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_URL, value = "链接", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_TIME, value = "过期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_METHOD, value = "过期方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.INSERT)
    public Result insert(NetdiskMyShareVO netdiskMyShareVO) {
        Result result = netdiskMyShareService.insert(netdiskMyShareVO, false);
        return result;
    }

    /**
     * 删除我的分享
     */
    @ApiOperation(value = "删除我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskMyShareService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskMyShareService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除我的分享 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskMyShareService.hasRefers(ids);
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
            Result result = netdiskMyShareService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskMyShareService.deleteByIdsLogical(canDeleteIds);
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
     * 更新我的分享
     */
    @ApiOperation(value = "更新我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_URL, value = "链接", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_TIME, value = "过期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_METHOD, value = "过期方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskMyShareVOMeta.PAGE_INDEX, NetdiskMyShareVOMeta.PAGE_SIZE, NetdiskMyShareVOMeta.SEARCH_FIELD, NetdiskMyShareVOMeta.FUZZY_FIELD, NetdiskMyShareVOMeta.SEARCH_VALUE, NetdiskMyShareVOMeta.DIRTY_FIELDS, NetdiskMyShareVOMeta.SORT_FIELD, NetdiskMyShareVOMeta.SORT_TYPE, NetdiskMyShareVOMeta.DATA_ORIGIN, NetdiskMyShareVOMeta.QUERY_LOGIC, NetdiskMyShareVOMeta.REQUEST_ACTION, NetdiskMyShareVOMeta.IDS })
    @SentinelResource(value = NetdiskMyShareServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.UPDATE)
    public Result update(NetdiskMyShareVO netdiskMyShareVO) {
        Result result = netdiskMyShareService.update(netdiskMyShareVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存我的分享
     */
    @ApiOperation(value = "保存我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_URL, value = "链接", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_TIME, value = "过期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_METHOD, value = "过期方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskMyShareVOMeta.PAGE_INDEX, NetdiskMyShareVOMeta.PAGE_SIZE, NetdiskMyShareVOMeta.SEARCH_FIELD, NetdiskMyShareVOMeta.FUZZY_FIELD, NetdiskMyShareVOMeta.SEARCH_VALUE, NetdiskMyShareVOMeta.DIRTY_FIELDS, NetdiskMyShareVOMeta.SORT_FIELD, NetdiskMyShareVOMeta.SORT_TYPE, NetdiskMyShareVOMeta.DATA_ORIGIN, NetdiskMyShareVOMeta.QUERY_LOGIC, NetdiskMyShareVOMeta.REQUEST_ACTION, NetdiskMyShareVOMeta.IDS })
    @SentinelResource(value = NetdiskMyShareServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.SAVE)
    public Result save(NetdiskMyShareVO netdiskMyShareVO) {
        Result result = netdiskMyShareService.save(netdiskMyShareVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取我的分享
     */
    @ApiOperation(value = "获取我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.GET_BY_ID)
    public Result<NetdiskMyShare> getById(String id) {
        Result<NetdiskMyShare> result = new Result<>();
        NetdiskMyShare netdiskMyShare = netdiskMyShareService.getById(id);
        // join 关联的对象
        netdiskMyShareService.dao().fill(netdiskMyShare).with("ownerUser").execute();
        result.success(true).data(netdiskMyShare);
        return result;
    }

    /**
     * 取消
     */
    @ApiOperation(value = "取消")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
    })
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.CANCEL)
    public Result cancel(String id) {
        return netdiskMyShareService.cancel(id);
    }

    /**
     * 移除成员
     */
    @ApiOperation(value = "移除成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
    })
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.REMOVE_SHARE_MEMBER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.REMOVE_SHARE_MEMBER)
    public Result removeShareMember(List<String> ids) {
        return netdiskMyShareService.removeShareMember(ids);
    }

    /**
     * 批量获取我的分享 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskMyShare>> getByIds(List<String> ids) {
        Result<List<NetdiskMyShare>> result = new Result<>();
        List<NetdiskMyShare> list = netdiskMyShareService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询我的分享
     */
    @ApiOperation(value = "查询我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_URL, value = "链接", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_TIME, value = "过期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_METHOD, value = "过期方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskMyShareVOMeta.PAGE_INDEX, NetdiskMyShareVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskMyShareServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.QUERY_LIST)
    public Result<List<NetdiskMyShare>> queryList(NetdiskMyShareVO sample) {
        Result<List<NetdiskMyShare>> result = new Result<>();
        List<NetdiskMyShare> list = netdiskMyShareService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询我的分享
     */
    @ApiOperation(value = "分页查询我的分享")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.FILE_URL, value = "链接", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_TIME, value = "过期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.EXPIRATION_METHOD, value = "过期方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskMyShareVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskMyShare>> queryPagedList(NetdiskMyShareVO sample) {
        Result<PagedList<NetdiskMyShare>> result = new Result<>();
        ConditionExpr expr =new ConditionExpr();
        expr.and("file_id not in (select fd_id from oa_netdisk_recycle where deleted=0 and user_id=?)", SessionUser.getCurrent().getActivatedEmployeeId());
        PagedList<NetdiskMyShare> list = netdiskMyShareService.queryPagedList(sample,expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        netdiskMyShareService.dao().fill(list).with("ownerUser").with(NetdiskMyShareMeta.NETDISK_FILE).with(NetdiskMyShareMeta.NETDISK_ORIGIN_FILE).execute();
        result.success(true).data(list);
        return result;
    }


    @ApiOperation(value = "成员成员")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskMyShareServiceProxy.QUERY_SHARE_MEMBER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskMyShareServiceProxy.QUERY_SHARE_MEMBER)
    public Result<PagedList<NetdiskShareMe>> queryShareMember(NetdiskShareMeVO netdiskShareMeVO) {
        Result<PagedList<NetdiskShareMe>> result = new Result<>();
        PagedList<NetdiskShareMe> list = netdiskMyShareService.queryShareMember(netdiskShareMeVO, netdiskShareMeVO.getPageSize(), netdiskShareMeVO.getPageIndex());
        // join 关联的对象
        netdiskMyShareService.dao().fill(list).with("user").with(NetdiskMyShareMeta.NETDISK_FILE).with(NetdiskMyShareMeta.NETDISK_ORIGIN_FILE).execute();
        List<Employee> owners = CollectorUtil.collectList(list, NetdiskShareMe::getUser);
        netdiskMyShareService.dao().join(owners, Person.class);
        result.success(true).data(list);
        return result;
    }
}
