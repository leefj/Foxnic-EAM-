package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorDataProcessCalculateService;
import com.dt.platform.proxy.ops.MonitorDataProcessCalculateServerServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "计算取数")
@ApiSort(0)
@RestController("MonitorDataProcessCalcuateController")
public class MonitorDataProcessCalcuateController extends SuperController {

    @Autowired
    IMonitorDataProcessCalculateService monitorDataProcessCalculateService;

    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "收集数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessCalculateServerServiceProxy.COLLECT_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessCalculateServerServiceProxy.COLLECT_DATA)
    public Result collectData() {
        return monitorDataProcessCalculateService.collectData();
    }


    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "清除数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessCalculateServerServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessCalculateServerServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA)
    public Result clearNodeValueLastHistoryData() {
        return monitorDataProcessCalculateService.clearNodeValueLastHistoryData();
    }


}
