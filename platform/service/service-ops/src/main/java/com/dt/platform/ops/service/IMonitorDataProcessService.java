package com.dt.platform.ops.service;
import com.dt.platform.domain.ops.MonitorNode;
import com.github.foxnic.api.transter.Result;

public interface IMonitorDataProcessService {

    Result collectData();

    Result collectNodeData(MonitorNode node,String indicatorId,boolean isForce);

    Result clearNodeValueLastHistoryData();

}
