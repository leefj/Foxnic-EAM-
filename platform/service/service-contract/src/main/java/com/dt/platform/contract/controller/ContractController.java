package com.dt.platform.contract.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractService;
import com.dt.platform.domain.contract.Contract;
import com.dt.platform.domain.contract.ContractVO;
import com.dt.platform.domain.contract.meta.ContractVOMeta;
import com.dt.platform.proxy.contract.ContractServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 合同表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-20 15:52:02
 * @version
 */
@InDoc
@Api(tags = "合同管理/合同")
@ApiSort(0)
@RestController("ContContractController")
public class ContractController extends SuperController {

    @Autowired
    private IContractService contractService;

    /**
     * 添加合同
     */
    @ApiOperation(value = "添加合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "522790511983984640"), @ApiImplicitParam(name = ContractVOMeta.TYPE, value = "合同类型", required = false, dataTypeClass = String.class, example = "main"), @ApiImplicitParam(name = ContractVOMeta.PARENT_ID, value = "上级合同ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_NO, value = "合同编号", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.TITLE, value = "合同抬头", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.DELIVERABLES, value = "交付物", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.DELIVERY_LOCATION, value = "交付地", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.AMOUNT, value = "合同金额", required = false, dataTypeClass = BigDecimal.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_STATUS, value = "合同状态", required = false, dataTypeClass = String.class, example = "not_signed"), @ApiImplicitParam(name = ContractVOMeta.SUMMARY, value = "摘要信息", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.SIGNING_DATE, value = "签订日期", required = false, dataTypeClass = Date.class, example = "2021-12-08 12:00:00"), @ApiImplicitParam(name = ContractVOMeta.EFFECTIVE_DATE, value = "生效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.END_DATE, value = "结束日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.EXPIRATION_DATE, value = "失效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.DEPARTMENT_ID, value = "归属部门ID", required = false, dataTypeClass = String.class, example = "503504809626697728"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_STATUS, value = "资金状态", required = false, dataTypeClass = String.class, example = "done"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_DIRECTION, value = "资金流向", required = false, dataTypeClass = String.class, example = "none"), @ApiImplicitParam(name = ContractVOMeta.CATALOG_CODE, value = "合同分类代码", required = false, dataTypeClass = String.class, example = "purchase") })
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ContractServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ContractVO contractVO) {
        Result result = contractService.insert(contractVO, false);
        return result;
    }

    /**
     * 删除合同
     */
    @ApiOperation(value = "删除合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "522790511983984640") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ContractServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = contractService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除合同 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ContractServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = contractService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新合同
     */
    @ApiOperation(value = "更新合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "522790511983984640"), @ApiImplicitParam(name = ContractVOMeta.TYPE, value = "合同类型", required = false, dataTypeClass = String.class, example = "main"), @ApiImplicitParam(name = ContractVOMeta.PARENT_ID, value = "上级合同ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_NO, value = "合同编号", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.TITLE, value = "合同抬头", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.DELIVERABLES, value = "交付物", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.DELIVERY_LOCATION, value = "交付地", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.AMOUNT, value = "合同金额", required = false, dataTypeClass = BigDecimal.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_STATUS, value = "合同状态", required = false, dataTypeClass = String.class, example = "not_signed"), @ApiImplicitParam(name = ContractVOMeta.SUMMARY, value = "摘要信息", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.SIGNING_DATE, value = "签订日期", required = false, dataTypeClass = Date.class, example = "2021-12-08 12:00:00"), @ApiImplicitParam(name = ContractVOMeta.EFFECTIVE_DATE, value = "生效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.END_DATE, value = "结束日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.EXPIRATION_DATE, value = "失效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.DEPARTMENT_ID, value = "归属部门ID", required = false, dataTypeClass = String.class, example = "503504809626697728"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_STATUS, value = "资金状态", required = false, dataTypeClass = String.class, example = "done"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_DIRECTION, value = "资金流向", required = false, dataTypeClass = String.class, example = "none"), @ApiImplicitParam(name = ContractVOMeta.CATALOG_CODE, value = "合同分类代码", required = false, dataTypeClass = String.class, example = "purchase") })
    @ApiOperationSupport(order = 4, ignoreParameters = { ContractVOMeta.PAGE_INDEX, ContractVOMeta.PAGE_SIZE, ContractVOMeta.SEARCH_FIELD, ContractVOMeta.FUZZY_FIELD, ContractVOMeta.SEARCH_VALUE, ContractVOMeta.DIRTY_FIELDS, ContractVOMeta.SORT_FIELD, ContractVOMeta.SORT_TYPE, ContractVOMeta.IDS })
    @SentinelResource(value = ContractServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ContractVO contractVO) {
        Result result = contractService.update(contractVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        Contract contract = contractService.getById(contractVO.getId());
        result.data(contract);
        return result;
    }

    /**
     * 保存合同
     */
    @ApiOperation(value = "保存合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "522790511983984640"), @ApiImplicitParam(name = ContractVOMeta.TYPE, value = "合同类型", required = false, dataTypeClass = String.class, example = "main"), @ApiImplicitParam(name = ContractVOMeta.PARENT_ID, value = "上级合同ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_NO, value = "合同编号", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.TITLE, value = "合同抬头", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.DELIVERABLES, value = "交付物", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.DELIVERY_LOCATION, value = "交付地", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.AMOUNT, value = "合同金额", required = false, dataTypeClass = BigDecimal.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_STATUS, value = "合同状态", required = false, dataTypeClass = String.class, example = "not_signed"), @ApiImplicitParam(name = ContractVOMeta.SUMMARY, value = "摘要信息", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.SIGNING_DATE, value = "签订日期", required = false, dataTypeClass = Date.class, example = "2021-12-08 12:00:00"), @ApiImplicitParam(name = ContractVOMeta.EFFECTIVE_DATE, value = "生效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.END_DATE, value = "结束日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.EXPIRATION_DATE, value = "失效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.DEPARTMENT_ID, value = "归属部门ID", required = false, dataTypeClass = String.class, example = "503504809626697728"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_STATUS, value = "资金状态", required = false, dataTypeClass = String.class, example = "done"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_DIRECTION, value = "资金流向", required = false, dataTypeClass = String.class, example = "none"), @ApiImplicitParam(name = ContractVOMeta.CATALOG_CODE, value = "合同分类代码", required = false, dataTypeClass = String.class, example = "purchase") })
    @ApiOperationSupport(order = 5, ignoreParameters = { ContractVOMeta.PAGE_INDEX, ContractVOMeta.PAGE_SIZE, ContractVOMeta.SEARCH_FIELD, ContractVOMeta.FUZZY_FIELD, ContractVOMeta.SEARCH_VALUE, ContractVOMeta.DIRTY_FIELDS, ContractVOMeta.SORT_FIELD, ContractVOMeta.SORT_TYPE, ContractVOMeta.IDS })
    @SentinelResource(value = ContractServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ContractVO contractVO) {
        Result result = contractService.save(contractVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取合同
     */
    @ApiOperation(value = "获取合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ContractServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.GET_BY_ID)
    public Result<Contract> getById(String id) {
        Result<Contract> result = new Result<>();
        Contract contract = contractService.getById(id);
        result.success(true).data(contract);
        return result;
    }

    /**
     * 批量获取合同 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ContractServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.GET_BY_IDS)
    public Result<List<Contract>> getByIds(List<String> ids) {
        Result<List<Contract>> result = new Result<>();
        List<Contract> list = contractService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询合同
     */
    @ApiOperation(value = "查询合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "522790511983984640"), @ApiImplicitParam(name = ContractVOMeta.TYPE, value = "合同类型", required = false, dataTypeClass = String.class, example = "main"), @ApiImplicitParam(name = ContractVOMeta.PARENT_ID, value = "上级合同ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_NO, value = "合同编号", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.TITLE, value = "合同抬头", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.DELIVERABLES, value = "交付物", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.DELIVERY_LOCATION, value = "交付地", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.AMOUNT, value = "合同金额", required = false, dataTypeClass = BigDecimal.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_STATUS, value = "合同状态", required = false, dataTypeClass = String.class, example = "not_signed"), @ApiImplicitParam(name = ContractVOMeta.SUMMARY, value = "摘要信息", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.SIGNING_DATE, value = "签订日期", required = false, dataTypeClass = Date.class, example = "2021-12-08 12:00:00"), @ApiImplicitParam(name = ContractVOMeta.EFFECTIVE_DATE, value = "生效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.END_DATE, value = "结束日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.EXPIRATION_DATE, value = "失效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.DEPARTMENT_ID, value = "归属部门ID", required = false, dataTypeClass = String.class, example = "503504809626697728"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_STATUS, value = "资金状态", required = false, dataTypeClass = String.class, example = "done"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_DIRECTION, value = "资金流向", required = false, dataTypeClass = String.class, example = "none"), @ApiImplicitParam(name = ContractVOMeta.CATALOG_CODE, value = "合同分类代码", required = false, dataTypeClass = String.class, example = "purchase") })
    @ApiOperationSupport(order = 5, ignoreParameters = { ContractVOMeta.PAGE_INDEX, ContractVOMeta.PAGE_SIZE })
    @SentinelResource(value = ContractServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.QUERY_LIST)
    public Result<List<Contract>> queryList(ContractVO sample) {
        Result<List<Contract>> result = new Result<>();
        List<Contract> list = contractService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询合同
     */
    @ApiOperation(value = "分页查询合同")
    @ApiImplicitParams({ @ApiImplicitParam(name = ContractVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "522790511983984640"), @ApiImplicitParam(name = ContractVOMeta.TYPE, value = "合同类型", required = false, dataTypeClass = String.class, example = "main"), @ApiImplicitParam(name = ContractVOMeta.PARENT_ID, value = "上级合同ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_NO, value = "合同编号", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.TITLE, value = "合同抬头", required = false, dataTypeClass = String.class, example = "11"), @ApiImplicitParam(name = ContractVOMeta.DELIVERABLES, value = "交付物", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.DELIVERY_LOCATION, value = "交付地", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.AMOUNT, value = "合同金额", required = false, dataTypeClass = BigDecimal.class), @ApiImplicitParam(name = ContractVOMeta.CONTRACT_STATUS, value = "合同状态", required = false, dataTypeClass = String.class, example = "not_signed"), @ApiImplicitParam(name = ContractVOMeta.SUMMARY, value = "摘要信息", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = ContractVOMeta.SIGNING_DATE, value = "签订日期", required = false, dataTypeClass = Date.class, example = "2021-12-08 12:00:00"), @ApiImplicitParam(name = ContractVOMeta.EFFECTIVE_DATE, value = "生效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.END_DATE, value = "结束日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.EXPIRATION_DATE, value = "失效日期", required = false, dataTypeClass = Date.class), @ApiImplicitParam(name = ContractVOMeta.DEPARTMENT_ID, value = "归属部门ID", required = false, dataTypeClass = String.class, example = "503504809626697728"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_STATUS, value = "资金状态", required = false, dataTypeClass = String.class, example = "done"), @ApiImplicitParam(name = ContractVOMeta.FUNDING_DIRECTION, value = "资金流向", required = false, dataTypeClass = String.class, example = "none"), @ApiImplicitParam(name = ContractVOMeta.CATALOG_CODE, value = "合同分类代码", required = false, dataTypeClass = String.class, example = "purchase") })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ContractServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Contract>> queryPagedList(ContractVO sample) {
        Result<PagedList<Contract>> result = new Result<>();
        PagedList<Contract> list = contractService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
