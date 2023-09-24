package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.CrmCustomer;
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta;
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
import com.dt.platform.proxy.oa.NetdiskOriginFileServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskOriginFileVOMeta;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.domain.oa.NetdiskOriginFileVO;
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
import com.dt.platform.domain.oa.meta.NetdiskOriginFileMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskOriginFileService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 源文件接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 15:18:14
 */
@InDoc
@Api(tags = "源文件")
@RestController("OaNetdiskOriginFileController")
public class NetdiskOriginFileController extends SuperController {

    @Autowired
    private INetdiskOriginFileService netdiskOriginFileService;

    /**
     * 添加源文件
     */
    @ApiOperation(value = "添加源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LOCATION, value = "路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MEDIA_TYPE, value = "媒体类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.EXT_VALUE, value = "扩展类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_TYPE, value = "存储类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ENCRYPTED, value = "是否加密", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.USER_ID, value = "所属用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_STORE_ID, value = "存储地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_COUNT, value = "下载次数", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MD5_VALUE, value = "MD5", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.REFERENCE_COUNT, value = "引用次数", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_URL, value = "下载地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LAST_VISIT_TIME, value = "上次访问时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskOriginFileServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.INSERT)
    public Result insert(NetdiskOriginFileVO netdiskOriginFileVO) {
        Result result = netdiskOriginFileService.insert(netdiskOriginFileVO, false);
        return result;
    }

    /**
     * 删除源文件
     */
    @ApiOperation(value = "删除源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskOriginFileServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskOriginFileService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskOriginFileService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除源文件 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskOriginFileServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskOriginFileService.hasRefers(ids);
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
            Result result = netdiskOriginFileService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskOriginFileService.deleteByIdsLogical(canDeleteIds);
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
     * 更新源文件
     */
    @ApiOperation(value = "更新源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LOCATION, value = "路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MEDIA_TYPE, value = "媒体类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.EXT_VALUE, value = "扩展类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_TYPE, value = "存储类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ENCRYPTED, value = "是否加密", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.USER_ID, value = "所属用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_STORE_ID, value = "存储地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_COUNT, value = "下载次数", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MD5_VALUE, value = "MD5", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.REFERENCE_COUNT, value = "引用次数", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_URL, value = "下载地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LAST_VISIT_TIME, value = "上次访问时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskOriginFileVOMeta.PAGE_INDEX, NetdiskOriginFileVOMeta.PAGE_SIZE, NetdiskOriginFileVOMeta.SEARCH_FIELD, NetdiskOriginFileVOMeta.FUZZY_FIELD, NetdiskOriginFileVOMeta.SEARCH_VALUE, NetdiskOriginFileVOMeta.DIRTY_FIELDS, NetdiskOriginFileVOMeta.SORT_FIELD, NetdiskOriginFileVOMeta.SORT_TYPE, NetdiskOriginFileVOMeta.DATA_ORIGIN, NetdiskOriginFileVOMeta.QUERY_LOGIC, NetdiskOriginFileVOMeta.REQUEST_ACTION, NetdiskOriginFileVOMeta.IDS })
    @SentinelResource(value = NetdiskOriginFileServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.UPDATE)
    public Result update(NetdiskOriginFileVO netdiskOriginFileVO) {
        Result result = netdiskOriginFileService.update(netdiskOriginFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存源文件
     */
    @ApiOperation(value = "保存源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LOCATION, value = "路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MEDIA_TYPE, value = "媒体类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.EXT_VALUE, value = "扩展类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_TYPE, value = "存储类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ENCRYPTED, value = "是否加密", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.USER_ID, value = "所属用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_STORE_ID, value = "存储地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_COUNT, value = "下载次数", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MD5_VALUE, value = "MD5", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.REFERENCE_COUNT, value = "引用次数", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_URL, value = "下载地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LAST_VISIT_TIME, value = "上次访问时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskOriginFileVOMeta.PAGE_INDEX, NetdiskOriginFileVOMeta.PAGE_SIZE, NetdiskOriginFileVOMeta.SEARCH_FIELD, NetdiskOriginFileVOMeta.FUZZY_FIELD, NetdiskOriginFileVOMeta.SEARCH_VALUE, NetdiskOriginFileVOMeta.DIRTY_FIELDS, NetdiskOriginFileVOMeta.SORT_FIELD, NetdiskOriginFileVOMeta.SORT_TYPE, NetdiskOriginFileVOMeta.DATA_ORIGIN, NetdiskOriginFileVOMeta.QUERY_LOGIC, NetdiskOriginFileVOMeta.REQUEST_ACTION, NetdiskOriginFileVOMeta.IDS })
    @SentinelResource(value = NetdiskOriginFileServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.SAVE)
    public Result save(NetdiskOriginFileVO netdiskOriginFileVO) {
        Result result = netdiskOriginFileService.save(netdiskOriginFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取源文件
     */
    @ApiOperation(value = "获取源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskOriginFileServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.GET_BY_ID)
    public Result<NetdiskOriginFile> getById(String id) {
        Result<NetdiskOriginFile> result = new Result<>();
        NetdiskOriginFile netdiskOriginFile = netdiskOriginFileService.getById(id);
        // join 关联的对象
        netdiskOriginFileService.dao().fill(netdiskOriginFile).with("ownerUser").execute();
        result.success(true).data(netdiskOriginFile);
        return result;
    }

    /**
     * 批量获取源文件 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskOriginFileServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskOriginFile>> getByIds(List<String> ids) {
        Result<List<NetdiskOriginFile>> result = new Result<>();
        List<NetdiskOriginFile> list = netdiskOriginFileService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询源文件
     */
    @ApiOperation(value = "查询源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LOCATION, value = "路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MEDIA_TYPE, value = "媒体类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.EXT_VALUE, value = "扩展类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_TYPE, value = "存储类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ENCRYPTED, value = "是否加密", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.USER_ID, value = "所属用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_STORE_ID, value = "存储地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_COUNT, value = "下载次数", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MD5_VALUE, value = "MD5", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.REFERENCE_COUNT, value = "引用次数", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_URL, value = "下载地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LAST_VISIT_TIME, value = "上次访问时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskOriginFileVOMeta.PAGE_INDEX, NetdiskOriginFileVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskOriginFileServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.QUERY_LIST)
    public Result<List<NetdiskOriginFile>> queryList(NetdiskOriginFileVO sample) {
        Result<List<NetdiskOriginFile>> result = new Result<>();
        List<NetdiskOriginFile> list = netdiskOriginFileService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询源文件
     */
    @ApiOperation(value = "分页查询源文件")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LOCATION, value = "路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MEDIA_TYPE, value = "媒体类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.EXT_VALUE, value = "扩展类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_TYPE, value = "存储类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.ENCRYPTED, value = "是否加密", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.USER_ID, value = "所属用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.STORAGE_STORE_ID, value = "存储地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_COUNT, value = "下载次数", required = false, dataTypeClass = Long.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.MD5_VALUE, value = "MD5", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.REFERENCE_COUNT, value = "引用次数", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.DOWNLOAD_URL, value = "下载地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskOriginFileVOMeta.LAST_VISIT_TIME, value = "上次访问时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskOriginFileServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskOriginFileServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskOriginFile>> queryPagedList(NetdiskOriginFileVO sample) {
        Result<PagedList<NetdiskOriginFile>> result = new Result<>();
        PagedList<NetdiskOriginFile> list = netdiskOriginFileService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        netdiskOriginFileService.dao().fill(list).with("ownerUser").execute();
        List<Employee> owners = CollectorUtil.collectList(list, NetdiskOriginFile::getOwnerUser);
        netdiskOriginFileService.dao().join(owners, Person.class);
        result.success(true).data(list);
        return result;
    }
}
