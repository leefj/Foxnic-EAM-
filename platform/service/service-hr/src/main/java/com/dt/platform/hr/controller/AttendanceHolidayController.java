package com.dt.platform.hr.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.domain.hr.SalaryProjectUnitRcd;
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
import com.dt.platform.proxy.hr.AttendanceHolidayServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceHolidayVOMeta;
import com.dt.platform.domain.hr.AttendanceHoliday;
import com.dt.platform.domain.hr.AttendanceHolidayVO;
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
import com.dt.platform.domain.hr.meta.AttendanceHolidayMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceHolidayService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 休假管理接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 21:08:53
 */
@InDoc
@Api(tags = "休假管理")
@RestController("HrAttendanceHolidayController")
public class AttendanceHolidayController extends SuperController {

    @Autowired
    private IAttendanceHolidayService attendanceHolidayService;

    /**
     * 添加休假管理
     */
    @ApiOperation(value = "添加休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DATE, value = "休假日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_TYPE, value = "休假类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DAYS, value = "休假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.NOTES, value = "休假备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceHolidayServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.INSERT)
    public Result insert(AttendanceHolidayVO attendanceHolidayVO) {
        Result result = attendanceHolidayService.insert(attendanceHolidayVO, false);
        return result;
    }

    /**
     * 删除休假管理
     */
    @ApiOperation(value = "删除休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceHolidayServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = attendanceHolidayService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = attendanceHolidayService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除休假管理 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceHolidayServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = attendanceHolidayService.hasRefers(ids);
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
            Result result = attendanceHolidayService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = attendanceHolidayService.deleteByIdsLogical(canDeleteIds);
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
     * 更新休假管理
     */
    @ApiOperation(value = "更新休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DATE, value = "休假日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_TYPE, value = "休假类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DAYS, value = "休假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.NOTES, value = "休假备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceHolidayVOMeta.PAGE_INDEX, AttendanceHolidayVOMeta.PAGE_SIZE, AttendanceHolidayVOMeta.SEARCH_FIELD, AttendanceHolidayVOMeta.FUZZY_FIELD, AttendanceHolidayVOMeta.SEARCH_VALUE, AttendanceHolidayVOMeta.DIRTY_FIELDS, AttendanceHolidayVOMeta.SORT_FIELD, AttendanceHolidayVOMeta.SORT_TYPE, AttendanceHolidayVOMeta.DATA_ORIGIN, AttendanceHolidayVOMeta.QUERY_LOGIC, AttendanceHolidayVOMeta.REQUEST_ACTION, AttendanceHolidayVOMeta.IDS })
    @SentinelResource(value = AttendanceHolidayServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.UPDATE)
    public Result update(AttendanceHolidayVO attendanceHolidayVO) {
        Result result = attendanceHolidayService.update(attendanceHolidayVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存休假管理
     */
    @ApiOperation(value = "保存休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DATE, value = "休假日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_TYPE, value = "休假类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DAYS, value = "休假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.NOTES, value = "休假备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AttendanceHolidayVOMeta.PAGE_INDEX, AttendanceHolidayVOMeta.PAGE_SIZE, AttendanceHolidayVOMeta.SEARCH_FIELD, AttendanceHolidayVOMeta.FUZZY_FIELD, AttendanceHolidayVOMeta.SEARCH_VALUE, AttendanceHolidayVOMeta.DIRTY_FIELDS, AttendanceHolidayVOMeta.SORT_FIELD, AttendanceHolidayVOMeta.SORT_TYPE, AttendanceHolidayVOMeta.DATA_ORIGIN, AttendanceHolidayVOMeta.QUERY_LOGIC, AttendanceHolidayVOMeta.REQUEST_ACTION, AttendanceHolidayVOMeta.IDS })
    @SentinelResource(value = AttendanceHolidayServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.SAVE)
    public Result save(AttendanceHolidayVO attendanceHolidayVO) {
        Result result = attendanceHolidayService.save(attendanceHolidayVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取休假管理
     */
    @ApiOperation(value = "获取休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceHolidayServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.GET_BY_ID)
    public Result<AttendanceHoliday> getById(String id) {
        Result<AttendanceHoliday> result = new Result<>();
        AttendanceHoliday attendanceHoliday = attendanceHolidayService.getById(id);
        // join 关联的对象
        attendanceHolidayService.dao().fill(attendanceHoliday).with(AttendanceHolidayMeta.TYPE_DICT).with(AttendanceHolidayMeta.PERSON).execute();
        result.success(true).data(attendanceHoliday);
        return result;
    }

    /**
     * 批量获取休假管理 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceHolidayServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.GET_BY_IDS)
    public Result<List<AttendanceHoliday>> getByIds(List<String> ids) {
        Result<List<AttendanceHoliday>> result = new Result<>();
        List<AttendanceHoliday> list = attendanceHolidayService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询休假管理
     */
    @ApiOperation(value = "查询休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DATE, value = "休假日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_TYPE, value = "休假类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DAYS, value = "休假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.NOTES, value = "休假备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AttendanceHolidayVOMeta.PAGE_INDEX, AttendanceHolidayVOMeta.PAGE_SIZE })
    @SentinelResource(value = AttendanceHolidayServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.QUERY_LIST)
    public Result<List<AttendanceHoliday>> queryList(AttendanceHolidayVO sample) {
        Result<List<AttendanceHoliday>> result = new Result<>();
        List<AttendanceHoliday> list = attendanceHolidayService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询休假管理
     */
    @ApiOperation(value = "分页查询休假管理")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.PERSON_ID, value = "人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DATE, value = "休假日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_TYPE, value = "休假类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_S_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_E_TIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.ACTION_DAYS, value = "休假天数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.NOTES, value = "休假备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AttendanceHolidayVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AttendanceHolidayServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AttendanceHoliday>> queryPagedList(AttendanceHolidayVO sample) {
        Result<PagedList<AttendanceHoliday>> result = new Result<>();
        ConditionExpr expr=new ConditionExpr();
        expr.and("1=1");
        if(!StringUtil.isBlank(sample.getSOrgId())){
            expr.and("person_id in (select id from hr_person where org_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+sample.getSOrgId()+"/%' or id=?)))",sample.getSOrgId());
        }

        if(!StringUtil.isBlank(sample.getPersonJobNumber())){
            expr.and("person_id in (select id from hr_person where job_number=?)",sample.getPersonJobNumber());
        }

        PagedList<AttendanceHoliday> list = attendanceHolidayService.queryPagedList(sample, expr,sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        attendanceHolidayService.dao().fill(list).with(AttendanceHolidayMeta.TYPE_DICT).with(AttendanceHolidayMeta.PERSON).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AttendanceHolidayServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AttendanceHolidayServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AttendanceHolidayVO sample, HttpServletResponse response) throws Exception {
        String code = "hr_attendance_holiday";
        InputStream inputstream = attendanceHolidayService.buildExcelTemplate(code);
        try {
            File f = TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_" + code + ".xls");
            List<AttendanceHoliday> list = attendanceHolidayService.queryList(sample);
            attendanceHolidayService.dao().fill(list).with(AttendanceHolidayMeta.PERSON).with(AttendanceHolidayMeta.TYPE_DICT).execute();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                AttendanceHoliday item = list.get(i);
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
            DownloadUtil.writeToOutput(response, workbook, "休假.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AttendanceHolidayServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AttendanceHolidayServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = attendanceHolidayService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = AttendanceHolidayServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AttendanceHolidayServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = "hr_attendance_holiday";
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
        List<ValidateResult> errors = attendanceHolidayService.importExcel(input, 0, code);
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
