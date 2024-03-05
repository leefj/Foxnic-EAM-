package com.dt.platform.job.hr;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.proxy.hr.AttendanceDataServiceProxy;
import com.dt.platform.proxy.ops.MonitorDataProcessCalculateServerServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class AttendanceDataProcessExecutor implements JobExecutor {
    @Override
    public String getName() {
        return "AttendanceDataProcessExecutor";
    }

    @Override
    public Result execute(Object o, Job job, JSONObject jsonObject) {
        Logger.info("AttendanceDataProcessExecutor 执行 Job ");
        Logger.info("jsonObject:"+jsonObject.toJSONString());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        int value=jsonObject.getInteger("time");
        calendar.add(Calendar.DAY_OF_MONTH,value);
        Date date=calendar.getTime();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        AttendanceDataServiceProxy.api().processSourceData(f.format(date),null);
        return ErrorDesc.success();
    }
}
