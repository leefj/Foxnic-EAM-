package com.dt.platform.oa.controller;

import java.util.*;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.oa.meta.NoticeMeta;
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
import com.dt.platform.proxy.oa.WorkRptServiceProxy;
import com.dt.platform.domain.oa.meta.WorkRptVOMeta;
import com.dt.platform.domain.oa.WorkRpt;
import com.dt.platform.domain.oa.WorkRptVO;
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
import com.dt.platform.domain.oa.meta.WorkRptMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IWorkRptService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 工作报告接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-26 09:51:15
 */
@InDoc
@Api(tags = "工作报告")
@RestController("OaWorkRptController")
public class WorkRptController extends SuperController {

    @Autowired
    private IWorkRptService workRptService;

    /**
     * 添加工作报告
     */
    @ApiOperation(value = "添加工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.CONTENT, value = "本周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.NEXT_CONTENT, value = "下周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.OTHER, value = "其他事项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.USER_ID, value = "报告人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.RECEIVER_ID, value = "接收人", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WorkRptServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.INSERT)
    public Result insert(WorkRptVO workRptVO) {
        Result result = workRptService.insert(workRptVO, false);
        return result;
    }

    /**
     * 删除工作报告
     */
    @ApiOperation(value = "删除工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WorkRptServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = workRptService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = workRptService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除工作报告 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WorkRptServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = workRptService.hasRefers(ids);
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
            Result result = workRptService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = workRptService.deleteByIdsLogical(canDeleteIds);
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
     * 更新工作报告
     */
    @ApiOperation(value = "更新工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.CONTENT, value = "本周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.NEXT_CONTENT, value = "下周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.OTHER, value = "其他事项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.USER_ID, value = "报告人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.RECEIVER_ID, value = "接收人", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { WorkRptVOMeta.PAGE_INDEX, WorkRptVOMeta.PAGE_SIZE, WorkRptVOMeta.SEARCH_FIELD, WorkRptVOMeta.FUZZY_FIELD, WorkRptVOMeta.SEARCH_VALUE, WorkRptVOMeta.DIRTY_FIELDS, WorkRptVOMeta.SORT_FIELD, WorkRptVOMeta.SORT_TYPE, WorkRptVOMeta.DATA_ORIGIN, WorkRptVOMeta.QUERY_LOGIC, WorkRptVOMeta.REQUEST_ACTION, WorkRptVOMeta.IDS })
    @SentinelResource(value = WorkRptServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.UPDATE)
    public Result update(WorkRptVO workRptVO) {
        Result result = workRptService.update(workRptVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存工作报告
     */
    @ApiOperation(value = "保存工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.CONTENT, value = "本周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.NEXT_CONTENT, value = "下周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.OTHER, value = "其他事项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.USER_ID, value = "报告人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.RECEIVER_ID, value = "接收人", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { WorkRptVOMeta.PAGE_INDEX, WorkRptVOMeta.PAGE_SIZE, WorkRptVOMeta.SEARCH_FIELD, WorkRptVOMeta.FUZZY_FIELD, WorkRptVOMeta.SEARCH_VALUE, WorkRptVOMeta.DIRTY_FIELDS, WorkRptVOMeta.SORT_FIELD, WorkRptVOMeta.SORT_TYPE, WorkRptVOMeta.DATA_ORIGIN, WorkRptVOMeta.QUERY_LOGIC, WorkRptVOMeta.REQUEST_ACTION, WorkRptVOMeta.IDS })
    @SentinelResource(value = WorkRptServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.SAVE)
    public Result save(WorkRptVO workRptVO) {
        Result result = workRptService.save(workRptVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取工作报告
     */
    @ApiOperation(value = "获取工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WorkRptServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.GET_BY_ID)
    public Result<WorkRpt> getById(String id) {
        Result<WorkRpt> result = new Result<>();
        WorkRpt workRpt = workRptService.getById(id);
        // join 关联的对象
        workRptService.dao().fill(workRpt).with("reportUser").with("receiver").execute();
        result.success(true).data(workRpt);
        workRptService.dao().join(workRpt.getReceiver(), Person.class);
        workRptService.dao().join(workRpt.getReportUser(), Person.class);
        return result;
    }

    /**
     * 批量获取工作报告 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WorkRptServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.GET_BY_IDS)
    public Result<List<WorkRpt>> getByIds(List<String> ids) {
        Result<List<WorkRpt>> result = new Result<>();
        List<WorkRpt> list = workRptService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询工作报告
     */
    @ApiOperation(value = "查询工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.CONTENT, value = "本周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.NEXT_CONTENT, value = "下周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.OTHER, value = "其他事项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.USER_ID, value = "报告人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.RECEIVER_ID, value = "接收人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { WorkRptVOMeta.PAGE_INDEX, WorkRptVOMeta.PAGE_SIZE })
    @SentinelResource(value = WorkRptServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.QUERY_LIST)
    public Result<List<WorkRpt>> queryList(WorkRptVO sample) {
        Result<List<WorkRpt>> result = new Result<>();
        List<WorkRpt> list = workRptService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询工作报告
     */
    @ApiOperation(value = "分页查询工作报告")
    @ApiImplicitParams({
		@ApiImplicitParam(name = WorkRptVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.F_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.T_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = WorkRptVOMeta.CONTENT, value = "本周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.NEXT_CONTENT, value = "下周", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.OTHER, value = "其他事项", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.USER_ID, value = "报告人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = WorkRptVOMeta.RECEIVER_ID, value = "接收人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = WorkRptServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(WorkRptServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<WorkRpt>> queryPagedList(WorkRptVO sample) {
        Result<PagedList<WorkRpt>> result = new Result<>();
        PagedList<WorkRpt> list = workRptService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        workRptService.dao().fill(list).with("reportUser").with("receiver").execute();
        result.success(true).data(list);
        List<Employee> rptList = CollectorUtil.collectList(list, WorkRpt::getReportUser);
        List<Employee> receList = CollectorUtil.collectList(list, WorkRpt::getReceiver);
        workRptService.dao().join(rptList, Person.class);
        workRptService.dao().join(receList, Person.class);
        return result;
    }
}
