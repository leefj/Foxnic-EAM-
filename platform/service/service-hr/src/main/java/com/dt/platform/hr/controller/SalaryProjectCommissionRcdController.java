package com.dt.platform.hr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.domain.hr.*;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.hr.SalaryDetailServiceProxy;
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
import com.dt.platform.proxy.hr.SalaryProjectCommissionRcdServiceProxy;
import com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdVOMeta;
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
import com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdMeta;
import java.math.BigDecimal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ISalaryProjectCommissionRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 项目提成记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 19:52:22
 */
@InDoc
@Api(tags = "项目提成记录")
@RestController("HrSalaryProjectCommissionRcdController")
public class SalaryProjectCommissionRcdController extends SuperController {

    @Autowired
    private ISalaryProjectCommissionRcdService salaryProjectCommissionRcdService;

    /**
     * 添加项目提成记录
     */
    @ApiOperation(value = "添加项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
	//	@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_ECOMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE, value = "业务量", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY, value = "提成金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.INSERT)
    public Result insert(SalaryProjectCommissionRcdVO salaryProjectCommissionRcdVO) {
        Result result = salaryProjectCommissionRcdService.insert(salaryProjectCommissionRcdVO, false);
        return result;
    }

    /**
     * 删除项目提成记录
     */
    @ApiOperation(value = "删除项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = salaryProjectCommissionRcdService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = salaryProjectCommissionRcdService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除项目提成记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = salaryProjectCommissionRcdService.hasRefers(ids);
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
            Result result = salaryProjectCommissionRcdService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = salaryProjectCommissionRcdService.deleteByIdsLogical(canDeleteIds);
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
     * 更新项目提成记录
     */
    @ApiOperation(value = "更新项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
	//	@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_ECOMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE, value = "业务量", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY, value = "提成金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryProjectCommissionRcdVOMeta.PAGE_INDEX, SalaryProjectCommissionRcdVOMeta.PAGE_SIZE, SalaryProjectCommissionRcdVOMeta.SEARCH_FIELD, SalaryProjectCommissionRcdVOMeta.FUZZY_FIELD, SalaryProjectCommissionRcdVOMeta.SEARCH_VALUE, SalaryProjectCommissionRcdVOMeta.DIRTY_FIELDS, SalaryProjectCommissionRcdVOMeta.SORT_FIELD, SalaryProjectCommissionRcdVOMeta.SORT_TYPE, SalaryProjectCommissionRcdVOMeta.DATA_ORIGIN, SalaryProjectCommissionRcdVOMeta.QUERY_LOGIC, SalaryProjectCommissionRcdVOMeta.REQUEST_ACTION, SalaryProjectCommissionRcdVOMeta.IDS })
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.UPDATE)
    public Result update(SalaryProjectCommissionRcdVO salaryProjectCommissionRcdVO) {
        Result result = salaryProjectCommissionRcdService.update(salaryProjectCommissionRcdVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存项目提成记录
     */
    @ApiOperation(value = "保存项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
		//@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_ECOMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE, value = "业务量", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY, value = "提成金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { SalaryProjectCommissionRcdVOMeta.PAGE_INDEX, SalaryProjectCommissionRcdVOMeta.PAGE_SIZE, SalaryProjectCommissionRcdVOMeta.SEARCH_FIELD, SalaryProjectCommissionRcdVOMeta.FUZZY_FIELD, SalaryProjectCommissionRcdVOMeta.SEARCH_VALUE, SalaryProjectCommissionRcdVOMeta.DIRTY_FIELDS, SalaryProjectCommissionRcdVOMeta.SORT_FIELD, SalaryProjectCommissionRcdVOMeta.SORT_TYPE, SalaryProjectCommissionRcdVOMeta.DATA_ORIGIN, SalaryProjectCommissionRcdVOMeta.QUERY_LOGIC, SalaryProjectCommissionRcdVOMeta.REQUEST_ACTION, SalaryProjectCommissionRcdVOMeta.IDS })
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.SAVE)
    public Result save(SalaryProjectCommissionRcdVO salaryProjectCommissionRcdVO) {
        Result result = salaryProjectCommissionRcdService.save(salaryProjectCommissionRcdVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取项目提成记录
     */
    @ApiOperation(value = "获取项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.GET_BY_ID)
    public Result<SalaryProjectCommissionRcd> getById(String id) {
        Result<SalaryProjectCommissionRcd> result = new Result<>();
        SalaryProjectCommissionRcd salaryProjectCommissionRcd = salaryProjectCommissionRcdService.getById(id);
        // join 关联的对象
        salaryProjectCommissionRcdService.dao().fill(salaryProjectCommissionRcd).with(SalaryProjectCommissionRcdMeta.PROJECT).with(SalaryProjectCommissionRcdMeta.PERSON).execute();
        result.success(true).data(salaryProjectCommissionRcd);
        return result;
    }

    /**
     * 批量获取项目提成记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.GET_BY_IDS)
    public Result<List<SalaryProjectCommissionRcd>> getByIds(List<String> ids) {
        Result<List<SalaryProjectCommissionRcd>> result = new Result<>();
        List<SalaryProjectCommissionRcd> list = salaryProjectCommissionRcdService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询项目提成记录
     */
    @ApiOperation(value = "查询项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
	//	@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_ECOMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE, value = "业务量", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY, value = "提成金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { SalaryProjectCommissionRcdVOMeta.PAGE_INDEX, SalaryProjectCommissionRcdVOMeta.PAGE_SIZE })
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.QUERY_LIST)
    public Result<List<SalaryProjectCommissionRcd>> queryList(SalaryProjectCommissionRcdVO sample) {
        Result<List<SalaryProjectCommissionRcd>> result = new Result<>();
        List<SalaryProjectCommissionRcd> list = salaryProjectCommissionRcdService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询项目提成记录
     */
    @ApiOperation(value = "分页查询项目提成记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.JOB_NUMBER, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_CODE, value = "项目编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_NAME, value = "项目名称", required = false, dataTypeClass = String.class),
	//@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_ECOMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE, value = "业务量", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY, value = "提成金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.RCD_DATE, value = "记录日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO, value = "提成比例", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SalaryProjectCommissionRcd>> queryPagedList(SalaryProjectCommissionRcdVO sample) {
        Result<PagedList<SalaryProjectCommissionRcd>> result = new Result<>();
        PagedList<SalaryProjectCommissionRcd> list = salaryProjectCommissionRcdService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        salaryProjectCommissionRcdService.dao().fill(list).with(SalaryProjectCommissionRcdMeta.PROJECT).with(SalaryProjectCommissionRcdMeta.PERSON).execute();
        result.success(true).data(list);
        return result;
    }


    /**
     * 导出 Excel
     * */
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.EXPORT_EXCEL)
    public void exportExcel(SalaryProjectCommissionRcdVO sample, HttpServletResponse response, String code) throws Exception {
        code="hr_salary_commission";
        InputStream inputstream = salaryProjectCommissionRcdService.buildExcelTemplate(code);
        try{
            File f =   TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_"+code+".xls");
            SalaryProjectCommissionRcdVO q=new SalaryProjectCommissionRcdVO();
            q.setBatchCode(sample.getBatchCode());
            List<SalaryProjectCommissionRcd> list= salaryProjectCommissionRcdService.queryList(q);
            salaryProjectCommissionRcdService.dao().fill(list).with(SalaryProjectCommissionRcdMeta.PERSON).execute();
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(int i=0;i<list.size();i++){
                SalaryProjectCommissionRcd item=list.get(i);
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
            DownloadUtil.writeToOutput(response, workbook, "提成工资.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response,e);
        }
    }

    /**
     * 导出 Excel 模板
     * */
    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try{
            //生成 Excel 模版
            ExcelWriter ew=salaryProjectCommissionRcdService.exportExcelTemplate();
            //下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response,e);
        }
    }

    @SentinelResource(value = SalaryProjectCommissionRcdServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(SalaryProjectCommissionRcdServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response, String code) throws Exception {
        code="hr_salary_commission";
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

        List<ValidateResult> errors = salaryProjectCommissionRcdService.importExcel(input, 0, code);
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
