package com.dt.platform.hr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdMeta;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectCommissionRcdServiceProxy;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.hr.SalaryProjectTimeRcdServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryProjectTimeRcdVOMeta;
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
import com.dt.platform.domain.hr.meta.SalaryProjectTimeRcdMeta;
import java.math.BigDecimal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryProjectTimeRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 计时项目记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 19:52:49
 */
@InDoc
@Api(tags = "计时项目记录")
@RestController("HrSalaryProjectTimeRcdController")
public class SalaryProjectTimeRcdController extends SuperController {

    @Autowired
    private ISalaryProjectTimeRcdService salaryProjectTimeRcdService;

    /**
     * 添加计时项目记录
     */
    @ApiOperation(value = "添加计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_UNIT_PRICE, value = "计时单价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FINISH_HOUR, value = "小时", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.TOTAL_PRICE, value = "总价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.INSERT)
    public Result insert(SalaryProjectTimeRcdVO salaryProjectTimeRcdVO) {
        Result result = salaryProjectTimeRcdService.insert(salaryProjectTimeRcdVO, false);
        return result;
    }

    /**
     * 删除计时项目记录
     */
    @ApiOperation(value = "删除计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = salaryProjectTimeRcdService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = salaryProjectTimeRcdService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除计时项目记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = salaryProjectTimeRcdService.hasRefers(ids);
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
            Result result = salaryProjectTimeRcdService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = salaryProjectTimeRcdService.deleteByIdsLogical(canDeleteIds);
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
     * 更新计时项目记录
     */
    @ApiOperation(value = "更新计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_UNIT_PRICE, value = "计时单价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FINISH_HOUR, value = "小时", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.TOTAL_PRICE, value = "总价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryProjectTimeRcdVOMeta.PAGE_INDEX, SalaryProjectTimeRcdVOMeta.PAGE_SIZE, SalaryProjectTimeRcdVOMeta.SEARCH_FIELD, SalaryProjectTimeRcdVOMeta.FUZZY_FIELD, SalaryProjectTimeRcdVOMeta.SEARCH_VALUE, SalaryProjectTimeRcdVOMeta.DIRTY_FIELDS, SalaryProjectTimeRcdVOMeta.SORT_FIELD, SalaryProjectTimeRcdVOMeta.SORT_TYPE, SalaryProjectTimeRcdVOMeta.DATA_ORIGIN, SalaryProjectTimeRcdVOMeta.QUERY_LOGIC, SalaryProjectTimeRcdVOMeta.REQUEST_ACTION, SalaryProjectTimeRcdVOMeta.IDS })
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.UPDATE)
    public Result update(SalaryProjectTimeRcdVO salaryProjectTimeRcdVO) {
        Result result = salaryProjectTimeRcdService.update(salaryProjectTimeRcdVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存计时项目记录
     */
    @ApiOperation(value = "保存计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_UNIT_PRICE, value = "计时单价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FINISH_HOUR, value = "小时", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.TOTAL_PRICE, value = "总价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { SalaryProjectTimeRcdVOMeta.PAGE_INDEX, SalaryProjectTimeRcdVOMeta.PAGE_SIZE, SalaryProjectTimeRcdVOMeta.SEARCH_FIELD, SalaryProjectTimeRcdVOMeta.FUZZY_FIELD, SalaryProjectTimeRcdVOMeta.SEARCH_VALUE, SalaryProjectTimeRcdVOMeta.DIRTY_FIELDS, SalaryProjectTimeRcdVOMeta.SORT_FIELD, SalaryProjectTimeRcdVOMeta.SORT_TYPE, SalaryProjectTimeRcdVOMeta.DATA_ORIGIN, SalaryProjectTimeRcdVOMeta.QUERY_LOGIC, SalaryProjectTimeRcdVOMeta.REQUEST_ACTION, SalaryProjectTimeRcdVOMeta.IDS })
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.SAVE)
    public Result save(SalaryProjectTimeRcdVO salaryProjectTimeRcdVO) {
        Result result = salaryProjectTimeRcdService.save(salaryProjectTimeRcdVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取计时项目记录
     */
    @ApiOperation(value = "获取计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.GET_BY_ID)
    public Result<SalaryProjectTimeRcd> getById(String id) {
        Result<SalaryProjectTimeRcd> result = new Result<>();
        SalaryProjectTimeRcd salaryProjectTimeRcd = salaryProjectTimeRcdService.getById(id);
        // join 关联的对象
        salaryProjectTimeRcdService.dao().fill(salaryProjectTimeRcd).with(SalaryProjectTimeRcdMeta.PROJECT).with(SalaryProjectTimeRcdMeta.PERSON).execute();
        result.success(true).data(salaryProjectTimeRcd);
        return result;
    }

    /**
     * 批量获取计时项目记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.GET_BY_IDS)
    public Result<List<SalaryProjectTimeRcd>> getByIds(List<String> ids) {
        Result<List<SalaryProjectTimeRcd>> result = new Result<>();
        List<SalaryProjectTimeRcd> list = salaryProjectTimeRcdService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询计时项目记录
     */
    @ApiOperation(value = "查询计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_UNIT_PRICE, value = "计时单价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FINISH_HOUR, value = "小时", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.TOTAL_PRICE, value = "总价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryProjectTimeRcdVOMeta.PAGE_INDEX, SalaryProjectTimeRcdVOMeta.PAGE_SIZE })
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.QUERY_LIST)
    public Result<List<SalaryProjectTimeRcd>> queryList(SalaryProjectTimeRcdVO sample) {
        Result<List<SalaryProjectTimeRcd>> result = new Result<>();
        List<SalaryProjectTimeRcd> list = salaryProjectTimeRcdService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询计时项目记录
     */
    @ApiOperation(value = "分页查询计时项目记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.PROJECT_UNIT_PRICE, value = "计时单价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FINISH_HOUR, value = "小时", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.TOTAL_PRICE, value = "总价", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectTimeRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectTimeRcdServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SalaryProjectTimeRcd>> queryPagedList(SalaryProjectTimeRcdVO sample) {
        Result<PagedList<SalaryProjectTimeRcd>> result = new Result<>();
        PagedList<SalaryProjectTimeRcd> list = salaryProjectTimeRcdService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryProjectTimeRcdService.dao().fill(list).with(SalaryProjectTimeRcdMeta.PROJECT).with(SalaryProjectTimeRcdMeta.PERSON).execute();
        result.success(true).data(list);
        return result;
    }


    /**
     * 导出 Excel
     * */
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.EXPORT_EXCEL)
    public void exportExcel(SalaryProjectTimeRcdVO sample, HttpServletResponse response, String code) throws Exception {
        code="hr_salary_time";
        InputStream inputstream = salaryProjectTimeRcdService.buildExcelTemplate(code);
        try{
            File f =   TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_"+code+".xls");
            SalaryProjectTimeRcdVO q=new SalaryProjectTimeRcdVO();
            q.setBatchCode(sample.getBatchCode());
            List<SalaryProjectTimeRcd> list= salaryProjectTimeRcdService.queryList(q);
            salaryProjectTimeRcdService.dao().fill(list).with(SalaryProjectTimeRcdMeta.PERSON).execute();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            for(int i=0;i<list.size();i++){
                SalaryProjectTimeRcd item=list.get(i);
                Map<String, Object> assetMap= BeanUtil.toMap(item);
                if(!StringUtil.isBlank(item.getPerson())){
                    assetMap.put("userName",item.getPerson().getName());
                }
                if(!StringUtil.isBlank(item.getRcdDate())){
                    assetMap.put("rcdDateName",sdf.format(item.getRcdDate()));
                }
                listMap.add(assetMap);
            }
            Map<String,Object> map=new HashMap<>();
            map.put("dataList", listMap);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            DownloadUtil.writeToOutput(response, workbook, "计时工资.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response,e);
        }
    }

    /**
     * 导出 Excel 模板
     * */
    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try{
            //生成 Excel 模版
            ExcelWriter ew=salaryProjectTimeRcdService.exportExcelTemplate();
            //下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response,e);
        }
    }

    @SentinelResource(value = SalaryProjectTimeRcdServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(SalaryProjectTimeRcdServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response, String code) throws Exception {
        code="hr_salary_time";
        //获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input=null;
        for (MultipartFile mf : map.values()) {
            input=StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if(input==null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = salaryProjectTimeRcdService.importExcel(input, 0, code);
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
