package com.dt.platform.common.controller;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
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


import com.dt.platform.proxy.common.ScreenDsDataServiceProxy;
import com.dt.platform.domain.common.meta.ScreenDsDataVOMeta;
import com.dt.platform.domain.common.ScreenDsData;
import com.dt.platform.domain.common.ScreenDsDataVO;
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
import com.dt.platform.domain.common.meta.ScreenDsDataMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IScreenDsDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据源接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-27 13:03:15
*/

@InDoc
@Api(tags = "数据源")
@RestController("SysScreenDsDataController")
public class ScreenDsDataController extends SuperController {

	@Autowired
	private IScreenDsDataService screenDsDataService;

	/**
	 * 添加数据源
	*/
	@ApiOperation(value = "添加数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.DS_CODE , value = "数据源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.SQL_TEXT , value = "SQL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.INSERT)
	public Result insert(ScreenDsDataVO screenDsDataVO) {
		
		Result result=screenDsDataService.insert(screenDsDataVO,false);
		return result;
	}



	/**
	 * 删除数据源
	*/
	@ApiOperation(value = "删除数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  screenDsDataService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=screenDsDataService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据源 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScreenDsDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = screenDsDataService.hasRefers(ids);
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
			Result result=screenDsDataService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=screenDsDataService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据源
	*/
	@ApiOperation(value = "更新数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.DS_CODE , value = "数据源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.SQL_TEXT , value = "SQL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenDsDataVOMeta.PAGE_INDEX , ScreenDsDataVOMeta.PAGE_SIZE , ScreenDsDataVOMeta.SEARCH_FIELD , ScreenDsDataVOMeta.FUZZY_FIELD , ScreenDsDataVOMeta.SEARCH_VALUE , ScreenDsDataVOMeta.DIRTY_FIELDS , ScreenDsDataVOMeta.SORT_FIELD , ScreenDsDataVOMeta.SORT_TYPE , ScreenDsDataVOMeta.DATA_ORIGIN , ScreenDsDataVOMeta.QUERY_LOGIC , ScreenDsDataVOMeta.REQUEST_ACTION , ScreenDsDataVOMeta.IDS } )
	@SentinelResource(value = ScreenDsDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.UPDATE)
	public Result update(ScreenDsDataVO screenDsDataVO) {
		
		Result result=screenDsDataService.update(screenDsDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据源
	*/
	@ApiOperation(value = "保存数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.DS_CODE , value = "数据源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.SQL_TEXT , value = "SQL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScreenDsDataVOMeta.PAGE_INDEX , ScreenDsDataVOMeta.PAGE_SIZE , ScreenDsDataVOMeta.SEARCH_FIELD , ScreenDsDataVOMeta.FUZZY_FIELD , ScreenDsDataVOMeta.SEARCH_VALUE , ScreenDsDataVOMeta.DIRTY_FIELDS , ScreenDsDataVOMeta.SORT_FIELD , ScreenDsDataVOMeta.SORT_TYPE , ScreenDsDataVOMeta.DATA_ORIGIN , ScreenDsDataVOMeta.QUERY_LOGIC , ScreenDsDataVOMeta.REQUEST_ACTION , ScreenDsDataVOMeta.IDS } )
	@SentinelResource(value = ScreenDsDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.SAVE)
	public Result save(ScreenDsDataVO screenDsDataVO) {
		
		Result result=screenDsDataService.save(screenDsDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据源
	*/
	@ApiOperation(value = "获取数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.GET_BY_ID)
	public Result<ScreenDsData> getById(String id) {
		
		Result<ScreenDsData> result=new Result<>();
		ScreenDsData screenDsData=screenDsDataService.getById(id);
		result.success(true).data(screenDsData);
		return result;
	}

	@ApiOperation(value = "获取数据源")
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsDataServiceProxy.QUERY_DATA_BY_CODE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.QUERY_DATA_BY_CODE)
	public Result<JSONArray> queryDataByCode(String code) {
		Result<JSONArray> result=new Result<>();
		JSONArray data= screenDsDataService.queryDataByCode(code);
		result.success(true).data(data);
		return result;
	}

	/**
	 * 批量获取数据源 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据源")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScreenDsDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScreenDsDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.GET_BY_IDS)
	public Result<List<ScreenDsData>> getByIds(List<String> ids) {
		
		Result<List<ScreenDsData>> result=new Result<>();
		List<ScreenDsData> list=screenDsDataService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据源
	*/
	@ApiOperation(value = "查询数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.DS_CODE , value = "数据源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.SQL_TEXT , value = "SQL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenDsDataVOMeta.PAGE_INDEX , ScreenDsDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScreenDsDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.QUERY_LIST)
	public Result<List<ScreenDsData>> queryList(ScreenDsDataVO sample) {
		
		Result<List<ScreenDsData>> result=new Result<>();
		List<ScreenDsData> list=screenDsDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据源
	*/
	@ApiOperation(value = "分页查询数据源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.DS_CODE , value = "数据源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.SQL_TEXT , value = "SQL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsDataVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScreenDsData>> queryPagedList(ScreenDsDataVO sample) {
		
		Result<PagedList<ScreenDsData>> result=new Result<>();
		PagedList<ScreenDsData> list=screenDsDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}