package com.dt.platform.ops.service.impl;

import com.dt.platform.constants.enums.ops.MonitorMethodEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("MonitorDataProcessZabbixServerService")
public class MonitorDataProcessZabbixServerServiceImpl implements IMonitorDataProcessZabbixServerService {


    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }


    @Autowired
    private IMonitorNodeService monitorNodeService;

    @Autowired
    private IMonitorTplService monitorTplService;

    @Autowired
    private IMonitorNodeValueService monitorNodeValueService;

    @Autowired
    private IMonitorTplIndicatorService monitorTplIndicatorService;



    @Override
    public Result collectData() {
        return ErrorDesc.success();
    }

    @Override
    public Result collectNodeData(MonitorNode node,String indicatorId,boolean isForce) {
        return ErrorDesc.success();
    }
    @Override
    public Result clearNodeValueLastHistoryData() {
        return ErrorDesc.success();
    }
}
