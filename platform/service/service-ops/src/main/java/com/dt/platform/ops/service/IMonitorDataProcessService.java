package com.dt.platform.ops.service;
import com.github.foxnic.api.transter.Result;

public interface IMonitorDataProcessService {

    Result collectData();

    Result clearNodeValueLastHistoryData();

}
