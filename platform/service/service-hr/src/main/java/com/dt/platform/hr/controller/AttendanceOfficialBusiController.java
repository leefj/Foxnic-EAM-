package com.dt.platform.hr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.domain.hr.AttendanceHoliday;
import com.dt.platform.domain.hr.meta.AttendanceHolidayMeta;
import com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.poi.ss.usermodel.Workbook;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dt.platform.proxy.hr.AttendanceOfficialBusiServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceOfficialBusiVOMeta;
import com.dt.platform.domain.hr.AttendanceOfficialBusi;
import com.dt.platform.domain.hr.AttendanceOfficialBusiVO;
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
import com.dt.platform.domain.hr.meta.AttendanceOfficialBusiMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceOfficialBusiService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 出差管理接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 21:09:06
 */
@InDoc
@Api(tags = "出差管理")
@RestController("HrAttendanceOfficialBusiController")
public class AttendanceOfficialBusiController extends SuperController {

    @Autowired
    private IAttendanceOfficialBusiService attendanceOfficialBusiService;

    /**
     * 添加出差管理
     */
    @ApiOperation(value = "添加出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DATE, value = "出差日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_TYPE, value = "出差类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DAYS, value = "出差天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.NOTES, value = "出差备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.INSERT)
    public Result insert(AttendanceOfficialBusiVO attendanceOfficialBusiVO) {
        Result result = attendanceOfficialBusiService.insert(attendanceOfficialBusiVO, false);
        return result;
    }

    /**
     * 删除出差管理
     */
    @ApiOperation(value = "删除出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = attendanceOfficialBusiService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = attendanceOfficialBusiService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除出差管理 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = attendanceOfficialBusiService.hasRefers(ids);
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
            Result result = attendanceOfficialBusiService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = attendanceOfficialBusiService.deleteByIdsLogical(canDeleteIds);
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
     * 更新出差管理
     */
    @ApiOperation(value = "更新出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DATE, value = "出差日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_TYPE, value = "出差类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DAYS, value = "出差天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.NOTES, value = "出差备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceOfficialBusiVOMeta.PAGE_INDEX, AttendanceOfficialBusiVOMeta.PAGE_SIZE, AttendanceOfficialBusiVOMeta.SEARCH_FIELD, AttendanceOfficialBusiVOMeta.FUZZY_FIELD, AttendanceOfficialBusiVOMeta.SEARCH_VALUE, AttendanceOfficialBusiVOMeta.DIRTY_FIELDS, AttendanceOfficialBusiVOMeta.SORT_FIELD, AttendanceOfficialBusiVOMeta.SORT_TYPE, AttendanceOfficialBusiVOMeta.DATA_ORIGIN, AttendanceOfficialBusiVOMeta.QUERY_LOGIC, AttendanceOfficialBusiVOMeta.REQUEST_ACTION, AttendanceOfficialBusiVOMeta.IDS })
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.UPDATE)
    public Result update(AttendanceOfficialBusiVO attendanceOfficialBusiVO) {
        Result result = attendanceOfficialBusiService.update(attendanceOfficialBusiVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存出差管理
     */
    @ApiOperation(value = "保存出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DATE, value = "出差日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_TYPE, value = "出差类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DAYS, value = "出差天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.NOTES, value = "出差备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AttendanceOfficialBusiVOMeta.PAGE_INDEX, AttendanceOfficialBusiVOMeta.PAGE_SIZE, AttendanceOfficialBusiVOMeta.SEARCH_FIELD, AttendanceOfficialBusiVOMeta.FUZZY_FIELD, AttendanceOfficialBusiVOMeta.SEARCH_VALUE, AttendanceOfficialBusiVOMeta.DIRTY_FIELDS, AttendanceOfficialBusiVOMeta.SORT_FIELD, AttendanceOfficialBusiVOMeta.SORT_TYPE, AttendanceOfficialBusiVOMeta.DATA_ORIGIN, AttendanceOfficialBusiVOMeta.QUERY_LOGIC, AttendanceOfficialBusiVOMeta.REQUEST_ACTION, AttendanceOfficialBusiVOMeta.IDS })
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.SAVE)
    public Result save(AttendanceOfficialBusiVO attendanceOfficialBusiVO) {
        Result result = attendanceOfficialBusiService.save(attendanceOfficialBusiVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取出差管理
     */
    @ApiOperation(value = "获取出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.GET_BY_ID)
    public Result<AttendanceOfficialBusi> getById(String id) {
        Result<AttendanceOfficialBusi> result = new Result<>();
        AttendanceOfficialBusi attendanceOfficialBusi = attendanceOfficialBusiService.getById(id);
        // join 关联的对象
        attendanceOfficialBusiService.dao().fill(attendanceOfficialBusi).with(AttendanceOfficialBusiMeta.TYPE_DICT).with(AttendanceOfficialBusiMeta.PERSON).execute();
        result.success(true).data(attendanceOfficialBusi);
        return result;
    }

    /**
     * 批量获取出差管理 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.GET_BY_IDS)
    public Result<List<AttendanceOfficialBusi>> getByIds(List<String> ids) {
        Result<List<AttendanceOfficialBusi>> result = new Result<>();
        List<AttendanceOfficialBusi> list = attendanceOfficialBusiService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询出差管理
     */
    @ApiOperation(value = "查询出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DATE, value = "出差日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_TYPE, value = "出差类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DAYS, value = "出差天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.NOTES, value = "出差备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceOfficialBusiVOMeta.PAGE_INDEX, AttendanceOfficialBusiVOMeta.PAGE_SIZE })
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.QUERY_LIST)
    public Result<List<AttendanceOfficialBusi>> queryList(AttendanceOfficialBusiVO sample) {
        Result<List<AttendanceOfficialBusi>> result = new Result<>();
        List<AttendanceOfficialBusi> list = attendanceOfficialBusiService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询出差管理
     */
    @ApiOperation(value = "分页查询出差管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DATE, value = "出差日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_TYPE, value = "出差类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.ACTION_DAYS, value = "出差天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.NOTES, value = "出差备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceOfficialBusiVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AttendanceOfficialBusi>> queryPagedList(AttendanceOfficialBusiVO sample) {
        Result<PagedList<AttendanceOfficialBusi>> result = new Result<>();
        ConditionExpr expr=new ConditionExpr();
        expr.and("1=1");
        if(!StringUtil.isBlank(sample.getSOrgId())){
            expr.and("person_id in (select id from hr_person where org_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+sample.getSOrgId()+"/%' or id=?)))",sample.getSOrgId());
        }

        if(!StringUtil.isBlank(sample.getPersonJobNumber())){
            expr.and("person_id in (select id from hr_person where job_number=?)",sample.getPersonJobNumber());
        }

        PagedList<AttendanceOfficialBusi> list = attendanceOfficialBusiService.queryPagedList(sample,expr, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        attendanceOfficialBusiService.dao().fill(list).with(AttendanceOfficialBusiMeta.TYPE_DICT).with(AttendanceOfficialBusiMeta.PERSON).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AttendanceOfficialBusiServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AttendanceOfficialBusiVO sample, HttpServletResponse response) throws Exception {
        String code = "hr_attendance_official_busi";
        InputStream inputstream = attendanceOfficialBusiService.buildExcelTemplate(code);
        try {
            File f = TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_" + code + ".xls");
            List<AttendanceOfficialBusi> list = attendanceOfficialBusiService.queryList(sample);
            attendanceOfficialBusiService.dao().fill(list).with(AttendanceOfficialBusiMeta.PERSON).with(AttendanceOfficialBusiMeta.TYPE_DICT).execute();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                AttendanceOfficialBusi item = list.get(i);
                Map<String, Object> assetMap = BeanUtil.toMap(item);
                if (!StringUtil.isBlank(item.getPerson())) {
                    assetMap.put("userName", item.getPerson().getName());
                    assetMap.put("jobNumber", item.getPerson().getJobNumber());
                }
                if (!StringUtil.isBlank(item.getTypeDict())) {
                    assetMap.put("actionType", item.getTypeDict().getLabel());
                }
                if (!StringUtil.isBlank(item.getActionDate())) {
                    assetMap.put("actionDate", sdf.format(item.getActionDate()));
                }
                if (!StringUtil.isBlank(item.getActionSTime())) {
                    assetMap.put("actionSTime", sdf2.format(item.getActionSTime()));
                }
                if (!StringUtil.isBlank(item.getActionETime())) {
                    assetMap.put("actionETime", sdf2.format(item.getActionETime()));
                }
                listMap.add(assetMap);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("dataList", listMap);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            DownloadUtil.writeToOutput(response, workbook, "出差.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AttendanceOfficialBusiServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = attendanceOfficialBusiService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = AttendanceOfficialBusiServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceOfficialBusiServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = "hr_attendance_official_busi";
        // 获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input = null;
        for (MultipartFile mf : map.values()) {
            input = StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if (input == null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = attendanceOfficialBusiService.importExcel(input, 0, code);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            Logger.info("import Result:");
            String msg = "导入失败";
            for (int i = 0; i < errors.size(); i++) {
                Logger.info(i + ":" + errors.get(i).message);
                msg = errors.get(i).message;
            }
            return ErrorDesc.failure().message(msg).data(errors);
        }
    }
}
