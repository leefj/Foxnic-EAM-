package com.dt.platform.common.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.ICommonService;
import com.dt.platform.proxy.common.CommonServiceProxy;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * <p>
 * 车辆保险公司接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:27:09
*/

@InDoc
@Api(tags = "用户")
@RestController("commonController2")
public class CommonController extends SuperController {

    @Autowired
    private ICommonService commonService;


    /**
     * 获取当前用户
     */
    @ApiOperation(value = "获取当前用户")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CommonServiceProxy.CURRENT_USER_INFO, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CommonServiceProxy.CURRENT_USER_INFO)
    public Result<JSONObject> queryCurrentUserInfo() {
        return commonService.queryCurrentUserInfo();
    }


//    /**
//     * 获取当前用户
//     */
//    @ApiOperation(value = "获取当前用户")
//    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
//    @SentinelResource(value = CommonServiceProxy.ALERT_NOTICE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
//    @PostMapping(CommonServiceProxy.ALERT_NOTICE)
//    public Result alertNotice(String ct,String url) {
//        return commonService.alertNotice(ct,url);
//    }
//


    /**
     * 获取当前用户
     */
    @ApiOperation(value = "magic-api")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CommonServiceProxy.CALL_MAGIC_API_SERVICE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CommonServiceProxy.CALL_MAGIC_API_SERVICE)
    public Result<Object> callMagicAPIService(String execType, String reqType, String path, Map<String, Object> params) {
        Logger.info("callMagicAPIService: {} , {} , {}", execType, reqType, path);
        Result<Object> result = new Result<>();
        result.success(true);
        result.data(commonService.callMagicAPIService( execType,  reqType,  path, params));
        return result;
    }


}