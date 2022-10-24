package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelVO;
import com.dt.platform.domain.ops.meta.CmdbModelVOMeta;
import com.dt.platform.ops.service.ICmdbModelService;
import com.dt.platform.proxy.ops.CmdbModelServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
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
 * 配置库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
 */
@InDoc
@Api(tags = "null/配置库")
@RestController("OpsCmdbController")
public class CmdbController extends SuperController {

    @Autowired
    private ICmdbModelService cmdbModelService;






}
