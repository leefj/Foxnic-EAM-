package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.meta.SchedulePlanMeta;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.OrderBy;
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
import com.dt.platform.proxy.oa.NoticeServiceProxy;
import com.dt.platform.domain.oa.meta.NoticeVOMeta;
import com.dt.platform.domain.oa.Notice;
import com.dt.platform.domain.oa.NoticeVO;
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
import com.dt.platform.domain.oa.meta.NoticeMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.INoticeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 通知公告接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-11 13:29:35
 */
@InDoc
@Api(tags = "通知公告")
@RestController("OaNoticeController")
public class NoticeController extends SuperController {

    @Autowired
    private INoticeService noticeService;

    /**
     * 添加通知公告
     */
    @ApiOperation(value = "添加通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352"),
		@ApiImplicitParam(name = NoticeVOMeta.NUMBER, value = "文号", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = NoticeVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NoticeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = NoticeVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "notice"),
		@ApiImplicitParam(name = NoticeVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "<p>1212</p>"),
		@ApiImplicitParam(name = NoticeVOMeta.IFTOP, value = "是否置顶", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NoticeVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.VISUAL_RANGE, value = "可见范围", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.USER_ID, value = "发布人", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.INSERT)
    public Result insert(NoticeVO noticeVO) {
        Result result = noticeService.insert(noticeVO, false);
        return result;
    }

    /**
     * 删除通知公告
     */
    @ApiOperation(value = "删除通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = noticeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = noticeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除通知公告 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = noticeService.hasRefers(ids);
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
            Result result = noticeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = noticeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新通知公告
     */
    @ApiOperation(value = "更新通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352"),
		@ApiImplicitParam(name = NoticeVOMeta.NUMBER, value = "文号", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = NoticeVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NoticeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = NoticeVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "notice"),
		@ApiImplicitParam(name = NoticeVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "<p>1212</p>"),
		@ApiImplicitParam(name = NoticeVOMeta.IFTOP, value = "是否置顶", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NoticeVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.VISUAL_RANGE, value = "可见范围", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.USER_ID, value = "发布人", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NoticeVOMeta.PAGE_INDEX, NoticeVOMeta.PAGE_SIZE, NoticeVOMeta.SEARCH_FIELD, NoticeVOMeta.FUZZY_FIELD, NoticeVOMeta.SEARCH_VALUE, NoticeVOMeta.DIRTY_FIELDS, NoticeVOMeta.SORT_FIELD, NoticeVOMeta.SORT_TYPE, NoticeVOMeta.DATA_ORIGIN, NoticeVOMeta.QUERY_LOGIC, NoticeVOMeta.REQUEST_ACTION, NoticeVOMeta.IDS })
    @SentinelResource(value = NoticeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.UPDATE)
    public Result update(NoticeVO noticeVO) {
        Result result = noticeService.update(noticeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存通知公告
     */
    @ApiOperation(value = "保存通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352"),
		@ApiImplicitParam(name = NoticeVOMeta.NUMBER, value = "文号", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = NoticeVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NoticeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = NoticeVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "notice"),
		@ApiImplicitParam(name = NoticeVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "<p>1212</p>"),
		@ApiImplicitParam(name = NoticeVOMeta.IFTOP, value = "是否置顶", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NoticeVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.VISUAL_RANGE, value = "可见范围", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.USER_ID, value = "发布人", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NoticeVOMeta.PAGE_INDEX, NoticeVOMeta.PAGE_SIZE, NoticeVOMeta.SEARCH_FIELD, NoticeVOMeta.FUZZY_FIELD, NoticeVOMeta.SEARCH_VALUE, NoticeVOMeta.DIRTY_FIELDS, NoticeVOMeta.SORT_FIELD, NoticeVOMeta.SORT_TYPE, NoticeVOMeta.DATA_ORIGIN, NoticeVOMeta.QUERY_LOGIC, NoticeVOMeta.REQUEST_ACTION, NoticeVOMeta.IDS })
    @SentinelResource(value = NoticeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.SAVE)
    public Result save(NoticeVO noticeVO) {
        Result result = noticeService.save(noticeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取通知公告
     */
    @ApiOperation(value = "获取通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.GET_BY_ID)
    public Result<Notice> getById(String id) {
        Result<Notice> result = new Result<>();
        Notice notice = noticeService.getById(id);
        noticeService.dao().fill(notice).with(NoticeMeta.USER).execute();
        noticeService.dao().join(notice.getUser(), Person.class);
        result.success(true).data(notice);
        return result;
    }

    /**
     * 批量获取通知公告 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.GET_BY_IDS)
    public Result<List<Notice>> getByIds(List<String> ids) {
        Result<List<Notice>> result = new Result<>();
        List<Notice> list = noticeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询通知公告
     */
    @ApiOperation(value = "查询通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352"),
		@ApiImplicitParam(name = NoticeVOMeta.NUMBER, value = "文号", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = NoticeVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NoticeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = NoticeVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "notice"),
		@ApiImplicitParam(name = NoticeVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "<p>1212</p>"),
		@ApiImplicitParam(name = NoticeVOMeta.IFTOP, value = "是否置顶", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NoticeVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.VISUAL_RANGE, value = "可见范围", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.USER_ID, value = "发布人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NoticeVOMeta.PAGE_INDEX, NoticeVOMeta.PAGE_SIZE })
    @SentinelResource(value = NoticeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.QUERY_LIST)
    public Result<List<Notice>> queryList(NoticeVO sample) {
        Result<List<Notice>> result = new Result<>();
        List<Notice> list = noticeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询通知公告
     */
    @ApiOperation(value = "分页查询通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352"),
		@ApiImplicitParam(name = NoticeVOMeta.NUMBER, value = "文号", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = NoticeVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NoticeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = NoticeVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "notice"),
		@ApiImplicitParam(name = NoticeVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "<p>1212</p>"),
		@ApiImplicitParam(name = NoticeVOMeta.IFTOP, value = "是否置顶", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NoticeVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.VISUAL_RANGE, value = "可见范围", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NoticeVOMeta.USER_ID, value = "发布人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Notice>> queryPagedList(NoticeVO sample) {
        Result<PagedList<Notice>> result = new Result<>();
        PagedList<Notice> list = noticeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询通知公告
     */
    @ApiOperation(value = "分页查询通知公告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NoticeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "708211477789540352"),
		@ApiImplicitParam(name = NoticeVOMeta.NUMBER, value = "文号", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = NoticeVOMeta.TITLE, value = "标题", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NoticeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = NoticeVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "notice"),
		@ApiImplicitParam(name = NoticeVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "<p>1212</p>"),
		@ApiImplicitParam(name = NoticeVOMeta.IFTOP, value = "是否置顶", required = false, dataTypeClass = String.class, example = "N"),
		@ApiImplicitParam(name = NoticeVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NoticeServiceProxy.QUERY_PAGED_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NoticeServiceProxy.QUERY_PAGED_DATA)
    public Result<PagedList<Notice>> queryPagedData(NoticeVO sample) {
        Result<PagedList<Notice>> result = new Result<>();
        OrderBy order = new OrderBy();
        order.desc("iftop").descNL("create_time");
        PagedList<Notice> list = noticeService.queryPagedList(sample, order, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
