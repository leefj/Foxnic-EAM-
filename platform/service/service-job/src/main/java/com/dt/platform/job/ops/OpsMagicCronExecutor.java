package com.dt.platform.job.ops;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.proxy.common.CommonServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.stereotype.Component;

@Component
public class OpsMagicCronExecutor implements JobExecutor {
    @Override
    public String getName() {
        return "OpsMagicCronExecutor";
    }

    @Override
    public Result execute(Object o, Job job, JSONObject jsonObject) {
        String url=jsonObject.getString("url");
        String reqType=jsonObject.getString("type");
        System.out.println("OpsMagicCronExecutor 执行 Job");
        if(StringUtil.isBlank(reqType)){
            reqType="GET";
        }
        Logger.info("OpsMagicCronExecutor 执行 Job ,url:"+url+",reqType:"+reqType);
        if(StringUtil.isBlank(url)){
            Logger.info(getName()+" 执行 Job ,url为空");
        }else{
            CommonServiceProxy.api().callMagicAPIService("execute", reqType, url, null);
        }
        return ErrorDesc.success();
    }
}
