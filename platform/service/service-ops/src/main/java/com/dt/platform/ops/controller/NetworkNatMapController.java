package com.dt.platform.ops.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dt.platform.proxy.ops.NetworkNatMapServiceProxy;
import com.dt.platform.domain.ops.meta.NetworkNatMapVOMeta;
import com.dt.platform.domain.ops.NetworkNatMap;
import com.dt.platform.domain.ops.NetworkNatMapVO;
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
import com.dt.platform.domain.ops.meta.NetworkNatMapMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.INetworkNatMapService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 地址映射接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 09:03:13
*/

@InDoc
@Api(tags = "地址映射")
@RestController("OpsNetworkNatMapController")
public class NetworkNatMapController extends SuperController {

	@Autowired
	private INetworkNatMapService networkNatMapService;

	/**
	 * 添加地址映射
	*/
	@ApiOperation(value = "添加地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "741944038617251840"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAT_IPV4 , value = "nat地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.SOURCE_IPV4 , value = "源地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetworkNatMapServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.INSERT)
	public Result insert(NetworkNatMapVO networkNatMapVO) {
		
		Result result=networkNatMapService.insert(networkNatMapVO,false);
		return result;
	}



	/**
	 * 删除地址映射
	*/
	@ApiOperation(value = "删除地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "741944038617251840")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetworkNatMapServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  networkNatMapService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=networkNatMapService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除地址映射 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = NetworkNatMapServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = networkNatMapService.hasRefers(ids);
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
			Result result=networkNatMapService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=networkNatMapService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新地址映射
	*/
	@ApiOperation(value = "更新地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "741944038617251840"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAT_IPV4 , value = "nat地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.SOURCE_IPV4 , value = "源地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetworkNatMapVOMeta.PAGE_INDEX , NetworkNatMapVOMeta.PAGE_SIZE , NetworkNatMapVOMeta.SEARCH_FIELD , NetworkNatMapVOMeta.FUZZY_FIELD , NetworkNatMapVOMeta.SEARCH_VALUE , NetworkNatMapVOMeta.DIRTY_FIELDS , NetworkNatMapVOMeta.SORT_FIELD , NetworkNatMapVOMeta.SORT_TYPE , NetworkNatMapVOMeta.DATA_ORIGIN , NetworkNatMapVOMeta.QUERY_LOGIC , NetworkNatMapVOMeta.REQUEST_ACTION , NetworkNatMapVOMeta.IDS } )
	@SentinelResource(value = NetworkNatMapServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.UPDATE)
	public Result update(NetworkNatMapVO networkNatMapVO) {
		
		Result result=networkNatMapService.update(networkNatMapVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存地址映射
	*/
	@ApiOperation(value = "保存地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "741944038617251840"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAT_IPV4 , value = "nat地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.SOURCE_IPV4 , value = "源地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NetworkNatMapVOMeta.PAGE_INDEX , NetworkNatMapVOMeta.PAGE_SIZE , NetworkNatMapVOMeta.SEARCH_FIELD , NetworkNatMapVOMeta.FUZZY_FIELD , NetworkNatMapVOMeta.SEARCH_VALUE , NetworkNatMapVOMeta.DIRTY_FIELDS , NetworkNatMapVOMeta.SORT_FIELD , NetworkNatMapVOMeta.SORT_TYPE , NetworkNatMapVOMeta.DATA_ORIGIN , NetworkNatMapVOMeta.QUERY_LOGIC , NetworkNatMapVOMeta.REQUEST_ACTION , NetworkNatMapVOMeta.IDS } )
	@SentinelResource(value = NetworkNatMapServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.SAVE)
	public Result save(NetworkNatMapVO networkNatMapVO) {
		
		Result result=networkNatMapService.save(networkNatMapVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取地址映射
	*/
	@ApiOperation(value = "获取地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetworkNatMapServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.GET_BY_ID)
	public Result<NetworkNatMap> getById(String id) {
		
		Result<NetworkNatMap> result=new Result<>();
		NetworkNatMap networkNatMap=networkNatMapService.getById(id);
		result.success(true).data(networkNatMap);
		return result;
	}


	/**
	 * 批量获取地址映射 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取地址映射")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NetworkNatMapVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = NetworkNatMapServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.GET_BY_IDS)
	public Result<List<NetworkNatMap>> getByIds(List<String> ids) {
		
		Result<List<NetworkNatMap>> result=new Result<>();
		List<NetworkNatMap> list=networkNatMapService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询地址映射
	*/
	@ApiOperation(value = "查询地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "741944038617251840"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAT_IPV4 , value = "nat地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.SOURCE_IPV4 , value = "源地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { NetworkNatMapVOMeta.PAGE_INDEX , NetworkNatMapVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NetworkNatMapServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.QUERY_LIST)
	public Result<List<NetworkNatMap>> queryList(NetworkNatMapVO sample) {
		
		Result<List<NetworkNatMap>> result=new Result<>();
		List<NetworkNatMap> list=networkNatMapService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询地址映射
	*/
	@ApiOperation(value = "分页查询地址映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NetworkNatMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "741944038617251840"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NAT_IPV4 , value = "nat地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.SOURCE_IPV4 , value = "源地址" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = NetworkNatMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = NetworkNatMapServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<NetworkNatMap>> queryPagedList(NetworkNatMapVO sample) {
		
		Result<PagedList<NetworkNatMap>> result=new Result<>();
		PagedList<NetworkNatMap> list=networkNatMapService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = NetworkNatMapServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NetworkNatMapServiceProxy.EXPORT_EXCEL)
	public void exportExcel(NetworkNatMapVO  sample,HttpServletResponse response) throws Exception {
		
		try{
			//生成 Excel 数据
			ExcelWriter ew=networkNatMapService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}

	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = NetworkNatMapServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NetworkNatMapServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		
		try{
			//生成 Excel 模版
			ExcelWriter ew=networkNatMapService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}

	@SentinelResource(value = NetworkNatMapServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NetworkNatMapServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors=networkNatMapService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}
}