package com.dt.platform.eam.controller;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
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
import com.dt.platform.proxy.eam.RfidLabelServiceProxy;
import com.dt.platform.domain.eam.meta.RfidLabelVOMeta;
import com.dt.platform.domain.eam.RfidLabel;
import com.dt.platform.domain.eam.RfidLabelVO;
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
import com.dt.platform.domain.eam.meta.RfidLabelMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRfidLabelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * RFID标签接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 18:16:25
 */
@InDoc
@Api(tags = "RFID标签")
@RestController("EamRfidLabelController")
public class RfidLabelController extends SuperController {

    @Autowired
    private IRfidLabelService rfidLabelService;

    /**
     * 添加RFID标签
     */
    @ApiOperation(value = "添加RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.RELEASE_ID, value = "RFID发卡", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_CODE, value = "资产编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_TIME, value = "发卡时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_RESULT, value = "发卡结果", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.INSERT)
    public Result insert(RfidLabelVO rfidLabelVO) {
        Result result = rfidLabelService.insert(rfidLabelVO, false);
        return result;
    }

    /**
     * 删除RFID标签
     */
    @ApiOperation(value = "删除RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = rfidLabelService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = rfidLabelService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除RFID标签 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = rfidLabelService.hasRefers(ids);
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
            Result result = rfidLabelService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = rfidLabelService.deleteByIdsLogical(canDeleteIds);
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
     * 更新RFID标签
     */
    @ApiOperation(value = "更新RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.RELEASE_ID, value = "RFID发卡", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_CODE, value = "资产编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_TIME, value = "发卡时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_RESULT, value = "发卡结果", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { RfidLabelVOMeta.PAGE_INDEX, RfidLabelVOMeta.PAGE_SIZE, RfidLabelVOMeta.SEARCH_FIELD, RfidLabelVOMeta.FUZZY_FIELD, RfidLabelVOMeta.SEARCH_VALUE, RfidLabelVOMeta.DIRTY_FIELDS, RfidLabelVOMeta.SORT_FIELD, RfidLabelVOMeta.SORT_TYPE, RfidLabelVOMeta.DATA_ORIGIN, RfidLabelVOMeta.QUERY_LOGIC, RfidLabelVOMeta.REQUEST_ACTION, RfidLabelVOMeta.IDS })
    @SentinelResource(value = RfidLabelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.UPDATE)
    public Result update(RfidLabelVO rfidLabelVO) {
        Result result = rfidLabelService.update(rfidLabelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存RFID标签
     */
    @ApiOperation(value = "保存RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.RELEASE_ID, value = "RFID发卡", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_CODE, value = "资产编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_TIME, value = "发卡时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_RESULT, value = "发卡结果", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { RfidLabelVOMeta.PAGE_INDEX, RfidLabelVOMeta.PAGE_SIZE, RfidLabelVOMeta.SEARCH_FIELD, RfidLabelVOMeta.FUZZY_FIELD, RfidLabelVOMeta.SEARCH_VALUE, RfidLabelVOMeta.DIRTY_FIELDS, RfidLabelVOMeta.SORT_FIELD, RfidLabelVOMeta.SORT_TYPE, RfidLabelVOMeta.DATA_ORIGIN, RfidLabelVOMeta.QUERY_LOGIC, RfidLabelVOMeta.REQUEST_ACTION, RfidLabelVOMeta.IDS })
    @SentinelResource(value = RfidLabelServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.SAVE)
    public Result save(RfidLabelVO rfidLabelVO) {
        Result result = rfidLabelService.save(rfidLabelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取RFID标签
     */
    @ApiOperation(value = "获取RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.GET_BY_ID)
    public Result<RfidLabel> getById(String id) {
        Result<RfidLabel> result = new Result<>();
        RfidLabel rfidLabel = rfidLabelService.getById(id);
        result.success(true).data(rfidLabel);
        return result;
    }

    /**
     * 发卡
     */
    @ApiOperation(value = "发卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = RfidLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.RELEASE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.RELEASE)
    public Result release(String id) {
        return rfidLabelService.release(id);
    }

    /**
     * 批量获取RFID标签 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.GET_BY_IDS)
    public Result<List<RfidLabel>> getByIds(List<String> ids) {
        Result<List<RfidLabel>> result = new Result<>();
        List<RfidLabel> list = rfidLabelService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询RFID标签
     */
    @ApiOperation(value = "查询RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.RELEASE_ID, value = "RFID发卡", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_CODE, value = "资产编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_TIME, value = "发卡时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_RESULT, value = "发卡结果", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { RfidLabelVOMeta.PAGE_INDEX, RfidLabelVOMeta.PAGE_SIZE })
    @SentinelResource(value = RfidLabelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.QUERY_LIST)
    public Result<List<RfidLabel>> queryList(RfidLabelVO sample) {
        Result<List<RfidLabel>> result = new Result<>();
        List<RfidLabel> list = rfidLabelService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 识别RFID标签
     */
    @ApiOperation(value = "识别RFID标签")
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { RfidLabelVOMeta.PAGE_INDEX, RfidLabelVOMeta.PAGE_SIZE })
    @SentinelResource(value = RfidLabelServiceProxy.READ, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.READ)
    public Result<JSONArray>  rfidLabelService(String parms) {
       return rfidLabelService.read(parms);
    }

    /**
     * 分页查询RFID标签
     */
    @ApiOperation(value = "分页查询RFID标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = RfidLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.RELEASE_ID, value = "RFID发卡", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.ASSET_CODE, value = "资产编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_TIME, value = "发卡时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = RfidLabelVOMeta.OPER_RESULT, value = "发卡结果", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = RfidLabelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<RfidLabel>> queryPagedList(RfidLabelVO sample) {
        Result<PagedList<RfidLabel>> result = new Result<>();
        PagedList<RfidLabel> list = rfidLabelService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = RfidLabelServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(RfidLabelServiceProxy.EXPORT_EXCEL)
    public void exportExcel(RfidLabelVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = rfidLabelService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = RfidLabelServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(RfidLabelServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = rfidLabelService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = RfidLabelServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(RfidLabelServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
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
        List<ValidateResult> errors = rfidLabelService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
