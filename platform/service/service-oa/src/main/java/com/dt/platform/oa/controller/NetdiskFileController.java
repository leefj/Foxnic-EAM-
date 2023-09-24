package com.dt.platform.oa.controller;

import java.util.*;
import com.dt.platform.domain.oa.meta.NetdiskFolderMeta;
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
import com.dt.platform.proxy.oa.NetdiskFileServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskFileVOMeta;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskFileVO;
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
import com.dt.platform.domain.oa.meta.NetdiskFileMeta;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.domain.oa.NetdiskFolder;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskFileService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 文件接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:19:48
 */
@InDoc
@Api(tags = "文件")
@RestController("OaNetdiskFileController")
public class NetdiskFileController extends SuperController {

    @Autowired
    private INetdiskFileService netdiskFileService;

    /**
     * 添加文件
     */
    @ApiOperation(value = "添加文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.ORIGIN_FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FOLDER_ID, value = "文件夹", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = String.class, example = "12M"),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.INSERT)
    public Result insert(NetdiskFileVO netdiskFileVO) {
        Result result = netdiskFileService.insert(netdiskFileVO, false);
        return result;
    }

    /**
     * 删除文件
     */
    @ApiOperation(value = "删除文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskFileService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskFileService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除文件 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskFileService.hasRefers(ids);
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
            Result result = netdiskFileService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskFileService.deleteByIdsLogical(canDeleteIds);
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
     * 更新文件
     */
    @ApiOperation(value = "更新文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.ORIGIN_FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FOLDER_ID, value = "文件夹", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = String.class, example = "12M"),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskFileVOMeta.PAGE_INDEX, NetdiskFileVOMeta.PAGE_SIZE, NetdiskFileVOMeta.SEARCH_FIELD, NetdiskFileVOMeta.FUZZY_FIELD, NetdiskFileVOMeta.SEARCH_VALUE, NetdiskFileVOMeta.DIRTY_FIELDS, NetdiskFileVOMeta.SORT_FIELD, NetdiskFileVOMeta.SORT_TYPE, NetdiskFileVOMeta.DATA_ORIGIN, NetdiskFileVOMeta.QUERY_LOGIC, NetdiskFileVOMeta.REQUEST_ACTION, NetdiskFileVOMeta.IDS })
    @SentinelResource(value = NetdiskFileServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.UPDATE)
    public Result update(NetdiskFileVO netdiskFileVO) {
        Result result = netdiskFileService.update(netdiskFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存文件
     */
    @ApiOperation(value = "保存文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.ORIGIN_FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FOLDER_ID, value = "文件夹", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = String.class, example = "12M"),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskFileVOMeta.PAGE_INDEX, NetdiskFileVOMeta.PAGE_SIZE, NetdiskFileVOMeta.SEARCH_FIELD, NetdiskFileVOMeta.FUZZY_FIELD, NetdiskFileVOMeta.SEARCH_VALUE, NetdiskFileVOMeta.DIRTY_FIELDS, NetdiskFileVOMeta.SORT_FIELD, NetdiskFileVOMeta.SORT_TYPE, NetdiskFileVOMeta.DATA_ORIGIN, NetdiskFileVOMeta.QUERY_LOGIC, NetdiskFileVOMeta.REQUEST_ACTION, NetdiskFileVOMeta.IDS })
    @SentinelResource(value = NetdiskFileServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.SAVE)
    public Result save(NetdiskFileVO netdiskFileVO) {
        Result result = netdiskFileService.save(netdiskFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取文件
     */
    @ApiOperation(value = "获取文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.GET_BY_ID)
    public Result<NetdiskFile> getById(String id) {
        Result<NetdiskFile> result = new Result<>();
        NetdiskFile netdiskFile = netdiskFileService.getById(id);
        // join 关联的对象
        netdiskFileService.dao().fill(netdiskFile).with("ownerUser").execute();
        result.success(true).data(netdiskFile);
        return result;
    }

    /**
     * 批量获取文件 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.UPLOAD_FILES_INFO, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.UPLOAD_FILES_INFO)
    public Result uploadFilesInfo(String fileIds, String fdId) {
        return netdiskFileService.uploadFilesInfo(fileIds, fdId);
    }

    @ApiOperation(value = "批量获取文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskFile>> getByIds(List<String> ids) {
        Result<List<NetdiskFile>> result = new Result<>();
        List<NetdiskFile> list = netdiskFileService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询文件
     */
    @ApiOperation(value = "查询文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.ORIGIN_FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FOLDER_ID, value = "文件夹", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = String.class, example = "12M"),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskFileVOMeta.PAGE_INDEX, NetdiskFileVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskFileServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.QUERY_LIST)
    public Result<List<NetdiskFile>> queryList(NetdiskFileVO sample) {
        Result<List<NetdiskFile>> result = new Result<>();
        List<NetdiskFile> list = netdiskFileService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询文件
     */
    @ApiOperation(value = "分页查询文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.ORIGIN_FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FOLDER_ID, value = "文件夹", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = String.class, example = "12M"),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IS_FAVOURITE, value = "是否收藏", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.IN_RECYCLE, value = "回收站", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskFileVOMeta.FILE_TYPE, value = "类型", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskFileServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskFileServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskFile>> queryPagedList(NetdiskFileVO sample) {
        Result<PagedList<NetdiskFile>> result = new Result<>();
        sample.setInRecycle("N");
        sample.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
        PagedList<NetdiskFile> list = netdiskFileService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        netdiskFileService.dao().fill(list).with("ownerUser").with(NetdiskFileMeta.NETDISK_ORIGIN_FILE).execute();
        result.success(true).data(list);
        return result;
    }
}
