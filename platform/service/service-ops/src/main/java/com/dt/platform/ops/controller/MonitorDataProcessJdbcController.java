package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorDataProcessJdbcService;
import com.dt.platform.ops.service.IMonitorDataProcessZabbixServerService;
import com.dt.platform.proxy.ops.MonitorDataProcessJdbcServiceProxy;
import com.dt.platform.proxy.ops.MonitorDataProcessZabbixServerServiceProxy;
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


@Api(tags = "JDBC取数")
@ApiSort(0)
@RestController("MonitorDataProcessJdbcController")
public class MonitorDataProcessJdbcController extends SuperController {

    @Autowired
    IMonitorDataProcessJdbcService monitorDataProcessJdbcService;

    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "收集数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessJdbcServiceProxy.COLLECT_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessJdbcServiceProxy.COLLECT_DATA)
    public Result collectData() {
        return monitorDataProcessJdbcService.collectData();
    }


    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "清除数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessJdbcServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessJdbcServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA)
    public Result clearNodeValueLastHistoryData() {
        return monitorDataProcessJdbcService.clearNodeValueLastHistoryData();
    }


}
