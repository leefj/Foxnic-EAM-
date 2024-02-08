package com.dt.platform.hr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.domain.hr.*;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
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
import com.dt.platform.proxy.hr.PersonBusiInsureServiceProxy;
import com.dt.platform.domain.hr.meta.PersonBusiInsureVOMeta;
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
import com.dt.platform.domain.hr.meta.PersonBusiInsureMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonBusiInsureService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商业保险接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-06 21:03:03
 */
@InDoc
@Api(tags = "商业保险")
@RestController("HrPersonBusiInsureController")
public class PersonBusiInsureController extends SuperController {

    @Autowired
    private IPersonBusiInsureService personBusiInsureService;

    /**
     * 添加商业保险
     */
    @ApiOperation(value = "添加商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.TYPE_CODE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BILL_CODE, value = "保险单号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.RCD_TIME, value = "登记时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PAY, value = "保险金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_PAY, value = "个人支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.COMPANY_PAY, value = "公司支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.START_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.END_TIME, value = "失效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonBusiInsureServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.INSERT)
    public Result insert(PersonBusiInsureVO personBusiInsureVO) {
        Result result = personBusiInsureService.insert(personBusiInsureVO, false);
        return result;
    }

    /**
     * 删除商业保险
     */
    @ApiOperation(value = "删除商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonBusiInsureServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personBusiInsureService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personBusiInsureService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除商业保险 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonBusiInsureServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personBusiInsureService.hasRefers(ids);
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
            Result result = personBusiInsureService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personBusiInsureService.deleteByIdsLogical(canDeleteIds);
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
     * 更新商业保险
     */
    @ApiOperation(value = "更新商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.TYPE_CODE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BILL_CODE, value = "保险单号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.RCD_TIME, value = "登记时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PAY, value = "保险金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_PAY, value = "个人支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.COMPANY_PAY, value = "公司支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.START_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.END_TIME, value = "失效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonBusiInsureVOMeta.PAGE_INDEX, PersonBusiInsureVOMeta.PAGE_SIZE, PersonBusiInsureVOMeta.SEARCH_FIELD, PersonBusiInsureVOMeta.FUZZY_FIELD, PersonBusiInsureVOMeta.SEARCH_VALUE, PersonBusiInsureVOMeta.DIRTY_FIELDS, PersonBusiInsureVOMeta.SORT_FIELD, PersonBusiInsureVOMeta.SORT_TYPE, PersonBusiInsureVOMeta.DATA_ORIGIN, PersonBusiInsureVOMeta.QUERY_LOGIC, PersonBusiInsureVOMeta.REQUEST_ACTION, PersonBusiInsureVOMeta.IDS })
    @SentinelResource(value = PersonBusiInsureServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.UPDATE)
    public Result update(PersonBusiInsureVO personBusiInsureVO) {
        Result result = personBusiInsureService.update(personBusiInsureVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存商业保险
     */
    @ApiOperation(value = "保存商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.TYPE_CODE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BILL_CODE, value = "保险单号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.RCD_TIME, value = "登记时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PAY, value = "保险金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_PAY, value = "个人支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.COMPANY_PAY, value = "公司支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.START_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.END_TIME, value = "失效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonBusiInsureVOMeta.PAGE_INDEX, PersonBusiInsureVOMeta.PAGE_SIZE, PersonBusiInsureVOMeta.SEARCH_FIELD, PersonBusiInsureVOMeta.FUZZY_FIELD, PersonBusiInsureVOMeta.SEARCH_VALUE, PersonBusiInsureVOMeta.DIRTY_FIELDS, PersonBusiInsureVOMeta.SORT_FIELD, PersonBusiInsureVOMeta.SORT_TYPE, PersonBusiInsureVOMeta.DATA_ORIGIN, PersonBusiInsureVOMeta.QUERY_LOGIC, PersonBusiInsureVOMeta.REQUEST_ACTION, PersonBusiInsureVOMeta.IDS })
    @SentinelResource(value = PersonBusiInsureServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.SAVE)
    public Result save(PersonBusiInsureVO personBusiInsureVO) {
        Result result = personBusiInsureService.save(personBusiInsureVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取商业保险
     */
    @ApiOperation(value = "获取商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonBusiInsureServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.GET_BY_ID)
    public Result<PersonBusiInsure> getById(String id) {
        Result<PersonBusiInsure> result = new Result<>();
        PersonBusiInsure personBusiInsure = personBusiInsureService.getById(id);
        // join 关联的对象
        personBusiInsureService.dao().fill(personBusiInsure).with("person").with(PersonBusiInsureMeta.PERSON).with(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE).execute();
        result.success(true).data(personBusiInsure);
        return result;
    }

    /**
     * 批量获取商业保险 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonBusiInsureServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.GET_BY_IDS)
    public Result<List<PersonBusiInsure>> getByIds(List<String> ids) {
        Result<List<PersonBusiInsure>> result = new Result<>();
        List<PersonBusiInsure> list = personBusiInsureService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询商业保险
     */
    @ApiOperation(value = "查询商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.TYPE_CODE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BILL_CODE, value = "保险单号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.RCD_TIME, value = "登记时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PAY, value = "保险金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_PAY, value = "个人支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.COMPANY_PAY, value = "公司支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.START_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.END_TIME, value = "失效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonBusiInsureVOMeta.PAGE_INDEX, PersonBusiInsureVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonBusiInsureServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.QUERY_LIST)
    public Result<List<PersonBusiInsure>> queryList(PersonBusiInsureVO sample) {
        Result<List<PersonBusiInsure>> result = new Result<>();
        List<PersonBusiInsure> list = personBusiInsureService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询商业保险
     */
    @ApiOperation(value = "分页查询商业保险")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_ID, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.TYPE_CODE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BILL_CODE, value = "保险单号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.RCD_TIME, value = "登记时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PAY, value = "保险金额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.PERSON_PAY, value = "个人支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.COMPANY_PAY, value = "公司支付", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.START_TIME, value = "生效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.END_TIME, value = "失效时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.FILE_IDS, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.UPDATE_BY, value = "修改人ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonBusiInsureVOMeta.BATCH_CODE, value = "批次号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonBusiInsureServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonBusiInsure>> queryPagedList(PersonBusiInsureVO sample) {
        Result<PagedList<PersonBusiInsure>> result = new Result<>();
        PagedList<PersonBusiInsure> list = personBusiInsureService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personBusiInsureService.dao().fill(list).with("person").with(PersonBusiInsureMeta.PERSON).with(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = PersonBusiInsureServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(PersonBusiInsureServiceProxy.EXPORT_EXCEL)
    public void exportExcel(PersonBusiInsureVO sample, HttpServletResponse response) throws Exception {
        String code = "hr_person_busi_insure";
        InputStream inputstream = personBusiInsureService.buildExcelTemplate(code);
        try {
            File f = TplFileServiceProxy.api().saveTempFile(inputstream, "tmp_" + code + ".xls");
            // PersonBusiInsureVO q=new PersonBusiInsureVO();
            // q.setBatchCode(sample.getBatchCode());
            List<PersonBusiInsure> list = personBusiInsureService.queryList(sample);
            personBusiInsureService.dao().fill(list).with(PersonBusiInsureMeta.PERSON).with(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE).execute();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                PersonBusiInsure item = list.get(i);
                Map<String, Object> assetMap = BeanUtil.toMap(item);
                if (!StringUtil.isBlank(item.getPerson())) {
                    assetMap.put("userName", item.getPerson().getName());
                    assetMap.put("jobNumber", item.getPerson().getJobNumber());
                }
                if (!StringUtil.isBlank(item.getPersonBusiInsureType())) {
                    assetMap.put("typeName", item.getPersonBusiInsureType().getName());
                }
                if (!StringUtil.isBlank(item.getRcdTime())) {
                    assetMap.put("rcdTimeName", sdf.format(item.getRcdTime()));
                }
                if (!StringUtil.isBlank(item.getStartTime())) {
                    assetMap.put("startTimeName", sdf.format(item.getStartTime()));
                }
                if (!StringUtil.isBlank(item.getEndTime())) {
                    assetMap.put("endTimeName", sdf.format(item.getEndTime()));
                }
                listMap.add(assetMap);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("dataList", listMap);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            DownloadUtil.writeToOutput(response, workbook, "商业保险.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = PersonBusiInsureServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(PersonBusiInsureServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = personBusiInsureService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = PersonBusiInsureServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonBusiInsureServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = "hr_person_busi_insure";
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
        List<ValidateResult> errors = personBusiInsureService.importExcel(input, 0, true);
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
