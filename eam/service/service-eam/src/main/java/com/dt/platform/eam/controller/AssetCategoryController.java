package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetCategoryService;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Api(tags = "资产分类查询")
@ApiSort(0)
@RestController("EAMAssetCategoryController")
public class AssetCategoryController  extends SuperController{

    @Autowired
    private IAssetCategoryService assetCategoryService;


    @ApiOperation(value = "资产分类查询")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetCategoryServiceProxy.QUERY_NODES , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetCategoryServiceProxy.QUERY_NODES)
    public Result<List<ZTreeNode>> queryNodes(CatalogVO categoryV0) {
        Result result=new Result<List<ZTreeNode>>();
        result.success(true).data(assetCategoryService.queryNodes(categoryV0));
        return result;
    }

    @ApiOperation(value = "根据ID查询分类CODE")
    @ApiOperationSupport(order=2)
    @SentinelResource(value = AssetCategoryServiceProxy.QUERY_NODE_ID_BY_CODE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetCategoryServiceProxy.QUERY_NODE_ID_BY_CODE)
    public Result<String> queryNodeIdByCode(String code) {
        Result result=new Result<String>();
        result.success(true).data(assetCategoryService.queryNodeIdByCode(code));
        return result;
    }




}

