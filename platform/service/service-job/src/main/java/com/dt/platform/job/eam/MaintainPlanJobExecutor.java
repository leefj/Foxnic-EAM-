package com.dt.platform.job.eam;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.proxy.eam.InspectionPlanServiceProxy;
import com.dt.platform.proxy.eam.MaintainPlanServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.stereotype.Component;

@Component
public class MaintainPlanJobExecutor implements JobExecutor {

    @Override
    public String getName() {
        return "MaintainPlanJobExecutor";
    }

    @Override
    public Result execute(Object o, Job job, JSONObject jsonObject) {
        Logger.info("MaintainPlanJobExecutor 执行 Job ");
        return MaintainPlanServiceProxy.api().execute();
    }

}
