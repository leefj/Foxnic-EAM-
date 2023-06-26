package com.dt.platform.common.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.apache.commons.io.IOUtils;
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
import com.dt.platform.proxy.common.UserImportServiceProxy;
import com.dt.platform.domain.common.meta.UserImportVOMeta;
import com.dt.platform.domain.common.UserImport;
import com.dt.platform.domain.common.UserImportVO;
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
import com.dt.platform.domain.common.meta.UserImportMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IUserImportService;
import com.github.foxnic.api.validate.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 员工导入接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 14:16:24
 */
@InDoc
@Api(tags = "员工导入")
@RestController("SysUserImportController")
public class UserImportController extends SuperController {

    @Autowired
    private IUserImportService userImportService;

    /**
     * 添加员工导入
     */
    @ApiOperation(value = "添加员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_CODE, value = "导入批次", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_STATUS, value = "导入状态", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_NAME, value = "组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST, value = "主岗", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ID_CARD, value = "身份证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_MSG, value = "导入结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_ID, value = "组织ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST_ID, value = "主岗ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX_CODE, value = "性别编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS_CODE, value = "状态编码", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.INSERT)
    public Result insert(UserImportVO userImportVO) {
        Result result = userImportService.insert(userImportVO, false);
        return result;
    }

    /**
     * 删除员工导入
     */
    @ApiOperation(value = "删除员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = userImportService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = userImportService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除员工导入 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = userImportService.hasRefers(ids);
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
            Result result = userImportService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = userImportService.deleteByIdsLogical(canDeleteIds);
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
     * 更新员工导入
     */
    @ApiOperation(value = "更新员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_CODE, value = "导入批次", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_STATUS, value = "导入状态", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_NAME, value = "组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST, value = "主岗", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ID_CARD, value = "身份证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_MSG, value = "导入结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_ID, value = "组织ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST_ID, value = "主岗ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX_CODE, value = "性别编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS_CODE, value = "状态编码", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { UserImportVOMeta.PAGE_INDEX, UserImportVOMeta.PAGE_SIZE, UserImportVOMeta.SEARCH_FIELD, UserImportVOMeta.FUZZY_FIELD, UserImportVOMeta.SEARCH_VALUE, UserImportVOMeta.DIRTY_FIELDS, UserImportVOMeta.SORT_FIELD, UserImportVOMeta.SORT_TYPE, UserImportVOMeta.DATA_ORIGIN, UserImportVOMeta.QUERY_LOGIC, UserImportVOMeta.REQUEST_ACTION, UserImportVOMeta.IDS })
    @SentinelResource(value = UserImportServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.UPDATE)
    public Result update(UserImportVO userImportVO) {
        Result result = userImportService.update(userImportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存员工导入
     */
    @ApiOperation(value = "保存员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_CODE, value = "导入批次", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_STATUS, value = "导入状态", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_NAME, value = "组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST, value = "主岗", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ID_CARD, value = "身份证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_MSG, value = "导入结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_ID, value = "组织ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST_ID, value = "主岗ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX_CODE, value = "性别编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS_CODE, value = "状态编码", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { UserImportVOMeta.PAGE_INDEX, UserImportVOMeta.PAGE_SIZE, UserImportVOMeta.SEARCH_FIELD, UserImportVOMeta.FUZZY_FIELD, UserImportVOMeta.SEARCH_VALUE, UserImportVOMeta.DIRTY_FIELDS, UserImportVOMeta.SORT_FIELD, UserImportVOMeta.SORT_TYPE, UserImportVOMeta.DATA_ORIGIN, UserImportVOMeta.QUERY_LOGIC, UserImportVOMeta.REQUEST_ACTION, UserImportVOMeta.IDS })
    @SentinelResource(value = UserImportServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.SAVE)
    public Result save(UserImportVO userImportVO) {
        Result result = userImportService.save(userImportVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取员工导入
     */
    @ApiOperation(value = "获取员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.GET_BY_ID)
    public Result<UserImport> getById(String id) {
        Result<UserImport> result = new Result<>();
        UserImport userImport = userImportService.getById(id);
        result.success(true).data(userImport);
        return result;
    }

    /**
     * 批量获取员工导入 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.GET_BY_IDS)
    public Result<List<UserImport>> getByIds(List<String> ids) {
        Result<List<UserImport>> result = new Result<>();
        List<UserImport> list = userImportService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 批量获取员工导入 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取员工导入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键清单", required = true, dataTypeClass = List.class, example = "1")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.IMPORT_EMPLOYEE_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.IMPORT_EMPLOYEE_BY_ID)
    public Result importEmployeeById(String id) {
        return userImportService.importEmployeeById(id);
    }

    /**
     * 查询员工导入
     */
    @ApiOperation(value = "查询员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_CODE, value = "导入批次", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_STATUS, value = "导入状态", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_NAME, value = "组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST, value = "主岗", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ID_CARD, value = "身份证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_MSG, value = "导入结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_ID, value = "组织ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST_ID, value = "主岗ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX_CODE, value = "性别编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS_CODE, value = "状态编码", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { UserImportVOMeta.PAGE_INDEX, UserImportVOMeta.PAGE_SIZE })
    @SentinelResource(value = UserImportServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.QUERY_LIST)
    public Result<List<UserImport>> queryList(UserImportVO sample) {
        Result<List<UserImport>> result = new Result<>();
        List<UserImport> list = userImportService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询员工导入
     */
    @ApiOperation(value = "分页查询员工导入")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserImportVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_CODE, value = "导入批次", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_OPER_TIME, value = "操作时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_STATUS, value = "导入状态", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = UserImportVOMeta.USER_NAME, value = "姓名", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX, value = "性别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_NAME, value = "组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST, value = "主岗", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ID_CARD, value = "身份证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.ACTION_MSG, value = "导入结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.COMPANY_ID, value = "组织ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.MASTER_POST_ID, value = "主岗ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.SEX_CODE, value = "性别编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserImportVOMeta.STATUS_CODE, value = "状态编码", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserImportServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserImportServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<UserImport>> queryPagedList(UserImportVO sample) {
        Result<PagedList<UserImport>> result = new Result<>();
        PagedList<UserImport> list = userImportService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    @SentinelResource(value = UserImportServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(UserImportServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = userImportService.importExcel(input, 0);
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

    /**
     * 导出 Excel
     */
    @SentinelResource(value = UserImportServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(UserImportServiceProxy.EXPORT_EXCEL)
    public void exportExcel(UserImportVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            InputStream inputstream = userImportService.buildExcelTemplate();
            if (inputstream == null) {
                return;
            }
            File f = userImportService.saveTempFile(inputstream, "tmp_user_upload.xls");
            Map<String, Object> map = new HashMap<>();
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            DownloadUtil.writeToOutput(response, workbook, "用户导入模版.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }
}
