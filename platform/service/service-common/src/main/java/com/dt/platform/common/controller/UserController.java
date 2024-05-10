package com.dt.platform.common.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.IUserImportService;
import com.dt.platform.common.service.IUserService;
import com.dt.platform.proxy.common.UserServiceProxy;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 车辆保险公司接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:27:09
*/

@InDoc
@Api(tags = "用户")
@RestController("CustUserController")
public class UserController extends SuperController {

    @Autowired
    private IUserService userService;


    /**
     * 获取当前用户
     */
    @ApiOperation(value = "获取当前用户")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = UserServiceProxy.CURRENT_USER_INFO, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(UserServiceProxy.CURRENT_USER_INFO)
    public Result<JSONObject> queryCurrentUserInfo() {
        return userService.queryCurrentUserInfo();
    }
}