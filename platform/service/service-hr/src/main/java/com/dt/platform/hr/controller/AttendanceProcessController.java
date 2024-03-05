package com.dt.platform.hr.controller;

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
import com.dt.platform.proxy.hr.AttendanceProcessServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceProcessVOMeta;
import com.dt.platform.domain.hr.AttendanceProcess;
import com.dt.platform.domain.hr.AttendanceProcessVO;
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
import com.dt.platform.domain.hr.meta.AttendanceProcessMeta;
import com.dt.platform.domain.hr.Person;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceProcessService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤跑批接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-25 15:10:10
 */
@InDoc
@Api(tags = "考勤跑批")
@RestController("HrAttendanceProcessController")
public class AttendanceProcessController extends SuperController {

    @Autowired
    private IAttendanceProcessService attendanceProcessService;

    /**
     * 添加考勤跑批
     */
    @ApiOperation(value = "添加考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.SDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.EDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IS_ALL_PERSON, value = "所有人员", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.INSERT)
    public Result insert(AttendanceProcessVO attendanceProcessVO) {
        Result result = attendanceProcessService.insert(attendanceProcessVO, false);
        return result;
    }

    /**
     * 删除考勤跑批
     */
    @ApiOperation(value = "删除考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = attendanceProcessService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = attendanceProcessService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除考勤跑批 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = attendanceProcessService.hasRefers(ids);
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
            Result result = attendanceProcessService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = attendanceProcessService.deleteByIdsLogical(canDeleteIds);
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
     * 更新考勤跑批
     */
    @ApiOperation(value = "更新考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.SDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.EDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IS_ALL_PERSON, value = "所有人员", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceProcessVOMeta.PAGE_INDEX, AttendanceProcessVOMeta.PAGE_SIZE, AttendanceProcessVOMeta.SEARCH_FIELD, AttendanceProcessVOMeta.FUZZY_FIELD, AttendanceProcessVOMeta.SEARCH_VALUE, AttendanceProcessVOMeta.DIRTY_FIELDS, AttendanceProcessVOMeta.SORT_FIELD, AttendanceProcessVOMeta.SORT_TYPE, AttendanceProcessVOMeta.DATA_ORIGIN, AttendanceProcessVOMeta.QUERY_LOGIC, AttendanceProcessVOMeta.REQUEST_ACTION, AttendanceProcessVOMeta.IDS })
    @SentinelResource(value = AttendanceProcessServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.UPDATE)
    public Result update(AttendanceProcessVO attendanceProcessVO) {
        Result result = attendanceProcessService.update(attendanceProcessVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存考勤跑批
     */
    @ApiOperation(value = "保存考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.SDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.EDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IS_ALL_PERSON, value = "所有人员", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AttendanceProcessVOMeta.PAGE_INDEX, AttendanceProcessVOMeta.PAGE_SIZE, AttendanceProcessVOMeta.SEARCH_FIELD, AttendanceProcessVOMeta.FUZZY_FIELD, AttendanceProcessVOMeta.SEARCH_VALUE, AttendanceProcessVOMeta.DIRTY_FIELDS, AttendanceProcessVOMeta.SORT_FIELD, AttendanceProcessVOMeta.SORT_TYPE, AttendanceProcessVOMeta.DATA_ORIGIN, AttendanceProcessVOMeta.QUERY_LOGIC, AttendanceProcessVOMeta.REQUEST_ACTION, AttendanceProcessVOMeta.IDS })
    @SentinelResource(value = AttendanceProcessServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.SAVE)
    public Result save(AttendanceProcessVO attendanceProcessVO) {
        Result result = attendanceProcessService.save(attendanceProcessVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取考勤跑批
     */
    @ApiOperation(value = "获取考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.GET_BY_ID)
    public Result<AttendanceProcess> getById(String id) {
        Result<AttendanceProcess> result = new Result<>();
        AttendanceProcess attendanceProcess = attendanceProcessService.getById(id);
        attendanceProcessService.dao().fill(attendanceProcess).with(AttendanceProcessMeta.PERSON_LIST).with(AttendanceProcessMeta.ORGANIZATION_LIST).execute();
        result.success(true).data(attendanceProcess);
        return result;
    }

    /**
     * 批量获取考勤跑批 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.GET_BY_IDS)
    public Result<List<AttendanceProcess>> getByIds(List<String> ids) {
        Result<List<AttendanceProcess>> result = new Result<>();
        List<AttendanceProcess> list = attendanceProcessService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 批量获取考勤跑批 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.PROCESS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.PROCESS)
    public Result process(String id) {
        return attendanceProcessService.process(id);
    }

    /**
     * 查询考勤跑批
     */
    @ApiOperation(value = "查询考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.SDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.EDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IS_ALL_PERSON, value = "所有人员", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceProcessVOMeta.PAGE_INDEX, AttendanceProcessVOMeta.PAGE_SIZE })
    @SentinelResource(value = AttendanceProcessServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.QUERY_LIST)
    public Result<List<AttendanceProcess>> queryList(AttendanceProcessVO sample) {
        Result<List<AttendanceProcess>> result = new Result<>();
        List<AttendanceProcess> list = attendanceProcessService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询考勤跑批
     */
    @ApiOperation(value = "分页查询考勤跑批")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceProcessVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.SDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.EDATE, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceProcessVOMeta.IS_ALL_PERSON, value = "所有人员", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceProcessServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceProcessServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AttendanceProcess>> queryPagedList(AttendanceProcessVO sample) {
        Result<PagedList<AttendanceProcess>> result = new Result<>();
        PagedList<AttendanceProcess> list = attendanceProcessService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        attendanceProcessService.dao().fill(list).with(AttendanceProcessMeta.PERSON_LIST).with(AttendanceProcessMeta.ORGANIZATION_LIST).execute();
        result.success(true).data(list);
        return result;
    }
}
