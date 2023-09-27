package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
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
import com.dt.platform.proxy.oa.NetdiskResourceLimitServiceProxy;
import com.dt.platform.domain.oa.meta.NetdiskResourceLimitVOMeta;
import com.dt.platform.domain.oa.NetdiskResourceLimit;
import com.dt.platform.domain.oa.NetdiskResourceLimitVO;
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
import com.dt.platform.domain.oa.meta.NetdiskResourceLimitMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INetdiskResourceLimitService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资源限制接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-27 15:59:06
 */
@InDoc
@Api(tags = "资源限制")
@RestController("OaNetdiskResourceLimitController")
public class NetdiskResourceLimitController extends SuperController {

    @Autowired
    private INetdiskResourceLimitService netdiskResourceLimitService;

    /**
     * 添加资源限制
     */
    @ApiOperation(value = "添加资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CAPACITY_SIZE_M, value = "最大容量", required = false, dataTypeClass = Long.class, example = "5"),
		 @ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_MAX_SIZE_M, value = "上传大小", required = false, dataTypeClass = Long.class, example = "1024"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class, example = "*"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_VIDEO_VALID, value = "视频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_MUSIC_VALID, value = "音频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_PHOTO_VALID, value = "图片预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_DOC_VALID, value = "文档预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CURRENT_SIZE_B, value = "当前容量", required = false, dataTypeClass = Long.class, example = "0")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.INSERT)
    public Result insert(NetdiskResourceLimitVO netdiskResourceLimitVO) {
        Result result = netdiskResourceLimitService.insert(netdiskResourceLimitVO, false);
        return result;
    }

    /**
     * 删除资源限制
     */
    @ApiOperation(value = "删除资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = netdiskResourceLimitService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = netdiskResourceLimitService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资源限制 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = netdiskResourceLimitService.hasRefers(ids);
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
            Result result = netdiskResourceLimitService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = netdiskResourceLimitService.deleteByIdsLogical(canDeleteIds);
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
     * 更新资源限制
     */
    @ApiOperation(value = "更新资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CAPACITY_SIZE_M, value = "最大容量", required = false, dataTypeClass = Long.class, example = "5"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_MAX_SIZE_M, value = "上传大小", required = false, dataTypeClass = Long.class, example = "1024"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class, example = "*"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_VIDEO_VALID, value = "视频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_MUSIC_VALID, value = "音频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_PHOTO_VALID, value = "图片预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_DOC_VALID, value = "文档预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CURRENT_SIZE_B, value = "当前容量", required = false, dataTypeClass = Long.class, example = "0")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskResourceLimitVOMeta.PAGE_INDEX, NetdiskResourceLimitVOMeta.PAGE_SIZE, NetdiskResourceLimitVOMeta.SEARCH_FIELD, NetdiskResourceLimitVOMeta.FUZZY_FIELD, NetdiskResourceLimitVOMeta.SEARCH_VALUE, NetdiskResourceLimitVOMeta.DIRTY_FIELDS, NetdiskResourceLimitVOMeta.SORT_FIELD, NetdiskResourceLimitVOMeta.SORT_TYPE, NetdiskResourceLimitVOMeta.DATA_ORIGIN, NetdiskResourceLimitVOMeta.QUERY_LOGIC, NetdiskResourceLimitVOMeta.REQUEST_ACTION, NetdiskResourceLimitVOMeta.IDS })
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.UPDATE)
    public Result update(NetdiskResourceLimitVO netdiskResourceLimitVO) {
        Result result = netdiskResourceLimitService.update(netdiskResourceLimitVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资源限制
     */
    @ApiOperation(value = "保存资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CAPACITY_SIZE_M, value = "最大容量", required = false, dataTypeClass = Long.class, example = "5"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_MAX_SIZE_M, value = "上传大小", required = false, dataTypeClass = Long.class, example = "1024"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class, example = "*"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_VIDEO_VALID, value = "视频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_MUSIC_VALID, value = "音频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_PHOTO_VALID, value = "图片预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_DOC_VALID, value = "文档预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CURRENT_SIZE_B, value = "当前容量", required = false, dataTypeClass = Long.class, example = "0")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NetdiskResourceLimitVOMeta.PAGE_INDEX, NetdiskResourceLimitVOMeta.PAGE_SIZE, NetdiskResourceLimitVOMeta.SEARCH_FIELD, NetdiskResourceLimitVOMeta.FUZZY_FIELD, NetdiskResourceLimitVOMeta.SEARCH_VALUE, NetdiskResourceLimitVOMeta.DIRTY_FIELDS, NetdiskResourceLimitVOMeta.SORT_FIELD, NetdiskResourceLimitVOMeta.SORT_TYPE, NetdiskResourceLimitVOMeta.DATA_ORIGIN, NetdiskResourceLimitVOMeta.QUERY_LOGIC, NetdiskResourceLimitVOMeta.REQUEST_ACTION, NetdiskResourceLimitVOMeta.IDS })
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.SAVE)
    public Result save(NetdiskResourceLimitVO netdiskResourceLimitVO) {
        Result result = netdiskResourceLimitService.save(netdiskResourceLimitVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资源限制
     */
    @ApiOperation(value = "获取资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.GET_BY_ID)
    public Result<NetdiskResourceLimit> getById(String id) {
        Result<NetdiskResourceLimit> result = new Result<>();
        NetdiskResourceLimit netdiskResourceLimit = netdiskResourceLimitService.getById(id);
        // join 关联的对象
        netdiskResourceLimitService.dao().fill(netdiskResourceLimit).with("user").execute();
        result.success(true).data(netdiskResourceLimit);
        return result;
    }

    /**
     * 批量获取资源限制 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.GET_BY_IDS)
    public Result<List<NetdiskResourceLimit>> getByIds(List<String> ids) {
        Result<List<NetdiskResourceLimit>> result = new Result<>();
        List<NetdiskResourceLimit> list = netdiskResourceLimitService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 重新计算 <br>
     */
    @ApiOperation(value = "重新计算")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.RECALCULATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.RECALCULATE)
    public Result recalculate() {
      return netdiskResourceLimitService.recalculate();
    }


    /**
     * 查询资源限制
     */
    @ApiOperation(value = "查询资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CAPACITY_SIZE_M, value = "最大容量", required = false, dataTypeClass = Long.class, example = "5"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_MAX_SIZE_M, value = "上传大小", required = false, dataTypeClass = Long.class, example = "1024"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class, example = "*"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_VIDEO_VALID, value = "视频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_MUSIC_VALID, value = "音频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_PHOTO_VALID, value = "图片预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_DOC_VALID, value = "文档预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CURRENT_SIZE_B, value = "当前容量", required = false, dataTypeClass = Long.class, example = "0")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NetdiskResourceLimitVOMeta.PAGE_INDEX, NetdiskResourceLimitVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.QUERY_LIST)
    public Result<List<NetdiskResourceLimit>> queryList(NetdiskResourceLimitVO sample) {
        Result<List<NetdiskResourceLimit>> result = new Result<>();
        List<NetdiskResourceLimit> list = netdiskResourceLimitService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资源限制
     */
    @ApiOperation(value = "分页查询资源限制")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CAPACITY_SIZE_M, value = "最大容量", required = false, dataTypeClass = Long.class, example = "5"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_MAX_SIZE_M, value = "上传大小", required = false, dataTypeClass = Long.class, example = "1024"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.UPLOAD_FILE_TYPE, value = "文件类型", required = false, dataTypeClass = String.class, example = "*"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_VIDEO_VALID, value = "视频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.PLAY_MUSIC_VALID, value = "音频播放", required = false, dataTypeClass = String.class, example = "Y"),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_PHOTO_VALID, value = "图片预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.VIEW_DOC_VALID, value = "文档预览", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetdiskResourceLimitVOMeta.CURRENT_SIZE_B, value = "当前容量", required = false, dataTypeClass = Long.class, example = "0")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetdiskResourceLimit>> queryPagedList(NetdiskResourceLimitVO sample) {
        Result<PagedList<NetdiskResourceLimit>> result = new Result<>();
        PagedList<NetdiskResourceLimit> list = netdiskResourceLimitService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        netdiskResourceLimitService.dao().fill(list).with("user").execute();
        List<Employee> owners = CollectorUtil.collectList(list, NetdiskResourceLimit::getUser);
        netdiskResourceLimitService.dao().join(owners, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资源限制
     */
    @ApiOperation(value = "分页查询资源限制")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NetdiskResourceLimitServiceProxy.GET_MY_RESOURCE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetdiskResourceLimitServiceProxy.GET_MY_RESOURCE)
    public Result<NetdiskResourceLimit> queryMyResource() {
        Result<NetdiskResourceLimit> result = new Result<>();
        result.data(netdiskResourceLimitService.getMyResource());
        result.success(true);
        return result;
    }
}
