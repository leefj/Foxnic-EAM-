package com.dt.platform.contract.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractPerformanceService;
import com.dt.platform.domain.contract.ContractPerformance;
import com.dt.platform.domain.contract.ContractPerformanceVO;
import com.dt.platform.domain.contract.meta.ContractPerformanceVOMeta;
import com.dt.platform.proxy.contract.ContractPerformanceServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
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
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 合同履行情况表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-28 14:20:20
 * @version
 */
@Api(tags = "合同履行情况")
@ApiSort(0)
@RestController("ContContractPerformanceController")
public class ContractPerformanceController extends SuperController {

    @Autowired
    private IContractPerformanceService contractPerformanceService;

    /**
     * 添加合同履行情况
     */
    @ApiOperation(value = "添加合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.CONTRACT_ID, value = "合同ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.TITLE, value = "概述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.DETAIL, value = "履约细节", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.PERFORMANCE_TIME, value = "履约时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ContractPerformanceServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ContractPerformanceVO contractPerformanceVO) {
        Result result = contractPerformanceService.insert(contractPerformanceVO, false);
        ContractPerformance performance = contractPerformanceService.getById(contractPerformanceVO.getId());
        return result.data(performance);
    }

    /**
     * 删除合同履行情况
     */
    @ApiOperation(value = "删除合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ContractPerformanceServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = contractPerformanceService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除合同履行情况 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ContractPerformanceServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = contractPerformanceService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新合同履行情况
     */
    @ApiOperation(value = "更新合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.CONTRACT_ID, value = "合同ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.TITLE, value = "概述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.DETAIL, value = "履约细节", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.PERFORMANCE_TIME, value = "履约时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ContractPerformanceVOMeta.PAGE_INDEX, ContractPerformanceVOMeta.PAGE_SIZE, ContractPerformanceVOMeta.SEARCH_FIELD, ContractPerformanceVOMeta.FUZZY_FIELD, ContractPerformanceVOMeta.SEARCH_VALUE, ContractPerformanceVOMeta.DIRTY_FIELDS, ContractPerformanceVOMeta.SORT_FIELD, ContractPerformanceVOMeta.SORT_TYPE, ContractPerformanceVOMeta.IDS })
    @SentinelResource(value = ContractPerformanceServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ContractPerformanceVO contractPerformanceVO) {
        Result result = contractPerformanceService.update(contractPerformanceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存合同履行情况
     */
    @ApiOperation(value = "保存合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.CONTRACT_ID, value = "合同ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.TITLE, value = "概述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.DETAIL, value = "履约细节", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.PERFORMANCE_TIME, value = "履约时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ContractPerformanceVOMeta.PAGE_INDEX, ContractPerformanceVOMeta.PAGE_SIZE, ContractPerformanceVOMeta.SEARCH_FIELD, ContractPerformanceVOMeta.FUZZY_FIELD, ContractPerformanceVOMeta.SEARCH_VALUE, ContractPerformanceVOMeta.DIRTY_FIELDS, ContractPerformanceVOMeta.SORT_FIELD, ContractPerformanceVOMeta.SORT_TYPE, ContractPerformanceVOMeta.IDS })
    @SentinelResource(value = ContractPerformanceServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ContractPerformanceVO contractPerformanceVO) {
        Result result = contractPerformanceService.save(contractPerformanceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取合同履行情况
     */
    @ApiOperation(value = "获取合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ContractPerformanceServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.GET_BY_ID)
    public Result<ContractPerformance> getById(String id) {
        Result<ContractPerformance> result = new Result<>();
        ContractPerformance contractPerformance = contractPerformanceService.getById(id);
        result.success(true).data(contractPerformance);
        return result;
    }

    /**
     * 批量获取合同履行情况 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ContractPerformanceServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.GET_BY_IDS)
    public Result<List<ContractPerformance>> getByIds(List<String> ids) {
        Result<List<ContractPerformance>> result = new Result<>();
        List<ContractPerformance> list = contractPerformanceService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询合同履行情况
     */
    @ApiOperation(value = "查询合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.CONTRACT_ID, value = "合同ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.TITLE, value = "概述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.DETAIL, value = "履约细节", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.PERFORMANCE_TIME, value = "履约时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ContractPerformanceVOMeta.PAGE_INDEX, ContractPerformanceVOMeta.PAGE_SIZE })
    @SentinelResource(value = ContractPerformanceServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.QUERY_LIST)
    public Result<List<ContractPerformance>> queryList(ContractPerformanceVO sample) {
        Result<List<ContractPerformance>> result = new Result<>();
        List<ContractPerformance> list = contractPerformanceService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询合同履行情况
     */
    @ApiOperation(value = "分页查询合同履行情况")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ContractPerformanceVOMeta.ID, value = "id", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.CONTRACT_ID, value = "合同ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.TITLE, value = "概述", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.DETAIL, value = "履约细节", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ContractPerformanceVOMeta.PERFORMANCE_TIME, value = "履约时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ContractPerformanceServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ContractPerformanceServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ContractPerformance>> queryPagedList(ContractPerformanceVO sample) {
        Result<PagedList<ContractPerformance>> result = new Result<>();
        PagedList<ContractPerformance> list = contractPerformanceService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
