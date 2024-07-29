package com.dt.platform.common.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.INodeLoadService;
import com.dt.platform.domain.common.AutoModuleRoleVO;
import com.dt.platform.domain.common.NodeLoad;
import com.dt.platform.domain.common.NodeLoadVO;
import com.dt.platform.domain.common.meta.AutoModuleRoleVOMeta;
import com.dt.platform.domain.common.meta.NodeLoadVOMeta;
import com.dt.platform.proxy.common.AppSystemServiceProxy;
import com.dt.platform.proxy.common.AutoModuleRoleServiceProxy;
import com.dt.platform.proxy.common.NodeLoadServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 节点负载接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:37:38
 */
@InDoc
@Api(tags = "系统")
@RestController("AppSystemController")
public class AppSystemController extends SuperController {

    @SentinelResource(value = AppSystemServiceProxy.SSO_CHECK, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AppSystemServiceProxy.SSO_CHECK)
    public Result<JSONObject> ssoCheck(String clientName, String token) {
        Result<JSONObject> res=new Result<>();
        Logger.info("ssoCheck,clientName:"+clientName+",token:"+token);
        JSONObject data=new JSONObject();
        data.put("empNo","15728000002");
        res.data(data);
        res.success(true);
        return res;
    }

}
