package com.dt.platform.common.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ITestService;
import com.dt.platform.domain.common.Test;
import com.dt.platform.domain.common.TestVO;
import com.dt.platform.domain.common.meta.TestVOMeta;
import com.dt.platform.proxy.common.TestServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
@RestController("CustUserController")
public class UserController extends SuperController {





}