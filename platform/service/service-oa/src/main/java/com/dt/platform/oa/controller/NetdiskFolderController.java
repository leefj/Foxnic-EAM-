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
import com.dt.platform.proxy.oa.NetdiskFolderServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskFolderVOMeta;
import com.dt.platform.domain.oa.NetdiskFolder;
import com.dt.platform.domain.oa.NetdiskFolderVO;
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
import com.dt.platform.domain.oa.meta.NetdiskFolderMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskFolderService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 文件夹接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 10:20:03
 */
@InDoc
@Api(tags = "文件夹")
@RestController("OaNetdiskFolderController")
public class NetdiskFolderController extends SuperController {

    @Autowired
    private INetdiskFolderService netdiskFolderService;

    /**
     * 添加文件夹
     */
    @ApiOperation(value = "添加文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.PARENT_ID, value = "父级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY, value = "文件路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY_NAME, value = "路径全名", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.INSERT)
    public Result insert(NetdiskFolderVO netdiskFolderVO) {
        Result result = netdiskFolderService.insert(netdiskFolderVO, false);
        return result;
    }

    /**
     * 删除文件夹
     */
    @ApiOperation(value = "删除文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskFolderService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskFolderService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 删除文件夹
     */
    @ApiOperation(value = "新建文件夹")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.CREATE_FOLDER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.CREATE_FOLDER)
    public Result createFolder(String parentId, String name) {
        return netdiskFolderService.createFolder(parentId, name);
    }

    /**
     * 批量删除文件夹 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskFolderService.hasRefers(ids);
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
            Result result = netdiskFolderService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskFolderService.deleteByIdsLogical(canDeleteIds);
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
     * 更新文件夹
     */
    @ApiOperation(value = "更新文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.PARENT_ID, value = "父级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY, value = "文件路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY_NAME, value = "路径全名", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskFolderVOMeta.PAGE_INDEX, NetdiskFolderVOMeta.PAGE_SIZE, NetdiskFolderVOMeta.SEARCH_FIELD, NetdiskFolderVOMeta.FUZZY_FIELD, NetdiskFolderVOMeta.SEARCH_VALUE, NetdiskFolderVOMeta.DIRTY_FIELDS, NetdiskFolderVOMeta.SORT_FIELD, NetdiskFolderVOMeta.SORT_TYPE, NetdiskFolderVOMeta.DATA_ORIGIN, NetdiskFolderVOMeta.QUERY_LOGIC, NetdiskFolderVOMeta.REQUEST_ACTION, NetdiskFolderVOMeta.IDS })
    @SentinelResource(value = NetdiskFolderServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.UPDATE)
    public Result update(NetdiskFolderVO netdiskFolderVO) {
        Result result = netdiskFolderService.update(netdiskFolderVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存文件夹
     */
    @ApiOperation(value = "保存文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.PARENT_ID, value = "父级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY, value = "文件路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY_NAME, value = "路径全名", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskFolderVOMeta.PAGE_INDEX, NetdiskFolderVOMeta.PAGE_SIZE, NetdiskFolderVOMeta.SEARCH_FIELD, NetdiskFolderVOMeta.FUZZY_FIELD, NetdiskFolderVOMeta.SEARCH_VALUE, NetdiskFolderVOMeta.DIRTY_FIELDS, NetdiskFolderVOMeta.SORT_FIELD, NetdiskFolderVOMeta.SORT_TYPE, NetdiskFolderVOMeta.DATA_ORIGIN, NetdiskFolderVOMeta.QUERY_LOGIC, NetdiskFolderVOMeta.REQUEST_ACTION, NetdiskFolderVOMeta.IDS })
    @SentinelResource(value = NetdiskFolderServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.SAVE)
    public Result save(NetdiskFolderVO netdiskFolderVO) {
        Result result = netdiskFolderService.save(netdiskFolderVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取文件夹
     */
    @ApiOperation(value = "获取文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.GET_BY_ID)
    public Result<NetdiskFolder> getById(String id) {
        Result<NetdiskFolder> result = new Result<>();
        NetdiskFolder netdiskFolder = netdiskFolderService.getById(id);
        result.success(true).data(netdiskFolder);
        return result;
    }

    /**
     * 批量获取文件夹 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskFolder>> getByIds(List<String> ids) {
        Result<List<NetdiskFolder>> result = new Result<>();
        List<NetdiskFolder> list = netdiskFolderService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询文件夹
     */
    @ApiOperation(value = "查询文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.PARENT_ID, value = "父级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY, value = "文件路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY_NAME, value = "路径全名", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskFolderVOMeta.PAGE_INDEX, NetdiskFolderVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskFolderServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.QUERY_LIST)
    public Result<List<NetdiskFolder>> queryList(NetdiskFolderVO sample) {
        Result<List<NetdiskFolder>> result = new Result<>();
        List<NetdiskFolder> list = netdiskFolderService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询文件夹
     */
    @ApiOperation(value = "分页查询文件夹")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.PARENT_ID, value = "父级", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY, value = "文件路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY_NAME, value = "路径全名", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskFolder>> queryPagedList(NetdiskFolderVO sample) {
        Result<PagedList<NetdiskFolder>> result = new Result<>();
        PagedList<NetdiskFolder> list = netdiskFolderService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }


    /**
     * 分页查询文件夹
     */
    @ApiOperation(value = "分页查询文件夹")
    @ApiImplicitParams({
            @ApiImplicitParam(name = NetdiskFolderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.PARENT_ID, value = "父级", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY, value = "文件路径", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class, example = "N"),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class, example = "N"),
            @ApiImplicitParam(name = NetdiskFolderVOMeta.HIERARCHY_NAME, value = "路径全名", required = false, dataTypeClass = String.class)
    })
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFolderServiceProxy.QUERY_MY_FOLDER_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFolderServiceProxy.QUERY_MY_FOLDER_PAGED_LIST)
    public Result<PagedList<NetdiskFolder>> queryMyFolderPagedList(NetdiskFolderVO sample) {
        Result<PagedList<NetdiskFolder>> result = new Result<>();
        PagedList<NetdiskFolder> list = netdiskFolderService.queryMyFolderPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }


}
