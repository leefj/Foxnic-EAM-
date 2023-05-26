package com.dt.platform.oa.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.oa.BannerServiceProxy;
import com.dt.platform.domain.oa.meta.BannerVOMeta;
import com.dt.platform.domain.oa.Banner;
import com.dt.platform.domain.oa.BannerVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.oa.meta.BannerMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IBannerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 横幅接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 13:13:20
*/

@InDoc
@Api(tags = "横幅")
@RestController("OaBannerController")
public class BannerController extends SuperController {

	@Autowired
	private IBannerService bannerService;

	/**
	 * 添加横幅
	*/
	@ApiOperation(value = "添加横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "708057333552381952"),
		@ApiImplicitParam(name = BannerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = BannerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BannerVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "714460675434348545"),
		@ApiImplicitParam(name = BannerVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class , example = "/business/oa/portal/banner.png"),
		@ApiImplicitParam(name = BannerVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BannerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.INSERT)
	public Result insert(BannerVO bannerVO) {
		
		Result result=bannerService.insert(bannerVO,false);
		return result;
	}



	/**
	 * 删除横幅
	*/
	@ApiOperation(value = "删除横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "708057333552381952")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BannerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  bannerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=bannerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除横幅 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = BannerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = bannerService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=bannerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=bannerService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新横幅
	*/
	@ApiOperation(value = "更新横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "708057333552381952"),
		@ApiImplicitParam(name = BannerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = BannerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BannerVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "714460675434348545"),
		@ApiImplicitParam(name = BannerVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class , example = "/business/oa/portal/banner.png"),
		@ApiImplicitParam(name = BannerVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BannerVOMeta.PAGE_INDEX , BannerVOMeta.PAGE_SIZE , BannerVOMeta.SEARCH_FIELD , BannerVOMeta.FUZZY_FIELD , BannerVOMeta.SEARCH_VALUE , BannerVOMeta.DIRTY_FIELDS , BannerVOMeta.SORT_FIELD , BannerVOMeta.SORT_TYPE , BannerVOMeta.DATA_ORIGIN , BannerVOMeta.QUERY_LOGIC , BannerVOMeta.REQUEST_ACTION , BannerVOMeta.IDS } )
	@SentinelResource(value = BannerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.UPDATE)
	public Result update(BannerVO bannerVO) {
		
		Result result=bannerService.update(bannerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存横幅
	*/
	@ApiOperation(value = "保存横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "708057333552381952"),
		@ApiImplicitParam(name = BannerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = BannerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BannerVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "714460675434348545"),
		@ApiImplicitParam(name = BannerVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class , example = "/business/oa/portal/banner.png"),
		@ApiImplicitParam(name = BannerVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BannerVOMeta.PAGE_INDEX , BannerVOMeta.PAGE_SIZE , BannerVOMeta.SEARCH_FIELD , BannerVOMeta.FUZZY_FIELD , BannerVOMeta.SEARCH_VALUE , BannerVOMeta.DIRTY_FIELDS , BannerVOMeta.SORT_FIELD , BannerVOMeta.SORT_TYPE , BannerVOMeta.DATA_ORIGIN , BannerVOMeta.QUERY_LOGIC , BannerVOMeta.REQUEST_ACTION , BannerVOMeta.IDS } )
	@SentinelResource(value = BannerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.SAVE)
	public Result save(BannerVO bannerVO) {
		
		Result result=bannerService.save(bannerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取横幅
	*/
	@ApiOperation(value = "获取横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BannerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.GET_BY_ID)
	public Result<Banner> getById(String id) {
		
		Result<Banner> result=new Result<>();
		Banner banner=bannerService.getById(id);
		result.success(true).data(banner);
		return result;
	}


	/**
	 * 批量获取横幅 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取横幅")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BannerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = BannerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.GET_BY_IDS)
	public Result<List<Banner>> getByIds(List<String> ids) {
		
		Result<List<Banner>> result=new Result<>();
		List<Banner> list=bannerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询横幅
	*/
	@ApiOperation(value = "查询横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "708057333552381952"),
		@ApiImplicitParam(name = BannerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = BannerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BannerVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "714460675434348545"),
		@ApiImplicitParam(name = BannerVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class , example = "/business/oa/portal/banner.png"),
		@ApiImplicitParam(name = BannerVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BannerVOMeta.PAGE_INDEX , BannerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BannerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.QUERY_LIST)
	public Result<List<Banner>> queryList(BannerVO sample) {
		
		Result<List<Banner>> result=new Result<>();
		List<Banner> list=bannerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询横幅
	*/
	@ApiOperation(value = "分页查询横幅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BannerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "708057333552381952"),
		@ApiImplicitParam(name = BannerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = BannerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BannerVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "714460675434348545"),
		@ApiImplicitParam(name = BannerVOMeta.URL , value = "地址" , required = false , dataTypeClass=String.class , example = "/business/oa/portal/banner.png"),
		@ApiImplicitParam(name = BannerVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BannerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BannerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Banner>> queryPagedList(BannerVO sample) {
		
		Result<PagedList<Banner>> result=new Result<>();
		PagedList<Banner> list=bannerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}