package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.Notice;
import com.github.foxnic.sql.expr.OrderBy;
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


import com.dt.platform.proxy.oa.DownloadFileServiceProxy;
import com.dt.platform.domain.oa.meta.DownloadFileVOMeta;
import com.dt.platform.domain.oa.DownloadFile;
import com.dt.platform.domain.oa.DownloadFileVO;
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
import com.dt.platform.domain.oa.meta.DownloadFileMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IDownloadFileService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 常用下载接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-15 11:59:36
*/

@InDoc
@Api(tags = "常用下载")
@RestController("OaDownloadFileController")
public class DownloadFileController extends SuperController {

	@Autowired
	private IDownloadFileService downloadFileService;

	/**
	 * 添加常用下载
	*/
	@ApiOperation(value = "添加常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.DOWNLOAD_COUNT , value = "下载次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadFileServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.INSERT)
	public Result insert(DownloadFileVO downloadFileVO) {
		
		Result result=downloadFileService.insert(downloadFileVO,false);
		return result;
	}



	/**
	 * 删除常用下载
	*/
	@ApiOperation(value = "删除常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadFileServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  downloadFileService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=downloadFileService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除常用下载 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DownloadFileServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = downloadFileService.hasRefers(ids);
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
			Result result=downloadFileService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=downloadFileService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新常用下载
	*/
	@ApiOperation(value = "更新常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.DOWNLOAD_COUNT , value = "下载次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DownloadFileVOMeta.PAGE_INDEX , DownloadFileVOMeta.PAGE_SIZE , DownloadFileVOMeta.SEARCH_FIELD , DownloadFileVOMeta.FUZZY_FIELD , DownloadFileVOMeta.SEARCH_VALUE , DownloadFileVOMeta.DIRTY_FIELDS , DownloadFileVOMeta.SORT_FIELD , DownloadFileVOMeta.SORT_TYPE , DownloadFileVOMeta.DATA_ORIGIN , DownloadFileVOMeta.QUERY_LOGIC , DownloadFileVOMeta.REQUEST_ACTION , DownloadFileVOMeta.IDS } )
	@SentinelResource(value = DownloadFileServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.UPDATE)
	public Result update(DownloadFileVO downloadFileVO) {
		
		Result result=downloadFileService.update(downloadFileVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存常用下载
	*/
	@ApiOperation(value = "保存常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.DOWNLOAD_COUNT , value = "下载次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DownloadFileVOMeta.PAGE_INDEX , DownloadFileVOMeta.PAGE_SIZE , DownloadFileVOMeta.SEARCH_FIELD , DownloadFileVOMeta.FUZZY_FIELD , DownloadFileVOMeta.SEARCH_VALUE , DownloadFileVOMeta.DIRTY_FIELDS , DownloadFileVOMeta.SORT_FIELD , DownloadFileVOMeta.SORT_TYPE , DownloadFileVOMeta.DATA_ORIGIN , DownloadFileVOMeta.QUERY_LOGIC , DownloadFileVOMeta.REQUEST_ACTION , DownloadFileVOMeta.IDS } )
	@SentinelResource(value = DownloadFileServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.SAVE)
	public Result save(DownloadFileVO downloadFileVO) {
		
		Result result=downloadFileService.save(downloadFileVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取常用下载
	*/
	@ApiOperation(value = "获取常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadFileServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.GET_BY_ID)
	public Result<DownloadFile> getById(String id) {
		
		Result<DownloadFile> result=new Result<>();
		DownloadFile downloadFile=downloadFileService.getById(id);
		result.success(true).data(downloadFile);
		return result;
	}


	/**
	 * 批量获取常用下载 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取常用下载")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DownloadFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DownloadFileServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.GET_BY_IDS)
	public Result<List<DownloadFile>> getByIds(List<String> ids) {
		
		Result<List<DownloadFile>> result=new Result<>();
		List<DownloadFile> list=downloadFileService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询常用下载
	*/
	@ApiOperation(value = "查询常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.DOWNLOAD_COUNT , value = "下载次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DownloadFileVOMeta.PAGE_INDEX , DownloadFileVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DownloadFileServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.QUERY_LIST)
	public Result<List<DownloadFile>> queryList(DownloadFileVO sample) {
		
		Result<List<DownloadFile>> result=new Result<>();
		List<DownloadFile> list=downloadFileService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询常用下载
	*/
	@ApiOperation(value = "分页查询常用下载")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.DOWNLOAD_COUNT , value = "下载次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DownloadFileVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadFileServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DownloadFile>> queryPagedList(DownloadFileVO sample) {
		
		Result<PagedList<DownloadFile>> result=new Result<>();
		PagedList<DownloadFile> list=downloadFileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 分页查询常用下载
	 */
	@ApiOperation(value = "分页查询常用下载")
	@ApiImplicitParams({
			@ApiImplicitParam(name = DownloadFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = DownloadFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = DownloadFileVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = DownloadFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = DownloadFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = DownloadFileVOMeta.DOWNLOAD_COUNT , value = "下载次数" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = DownloadFileVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadFileServiceProxy.QUERY_PAGED_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadFileServiceProxy.QUERY_PAGED_DATA)
	public Result<PagedList<DownloadFile>> queryPagedData(DownloadFileVO sample) {
		Result<PagedList<DownloadFile>> result=new Result<>();
		OrderBy order=new OrderBy();
		order.desc("sort").descNL("create_time");
		PagedList<DownloadFile> list=downloadFileService.queryPagedList(sample,order,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}

}