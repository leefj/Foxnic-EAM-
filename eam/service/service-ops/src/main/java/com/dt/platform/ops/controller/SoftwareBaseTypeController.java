package com.dt.platform.ops.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.ops.SoftwareBaseTypeServiceProxy;
import com.dt.platform.domain.ops.meta.SoftwareBaseTypeVOMeta;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.SoftwareBaseTypeVO;
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
import com.dt.platform.domain.ops.meta.SoftwareBaseTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ISoftwareBaseTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件基线类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-27 20:16:25
*/

@Api(tags = "软件基线类型")
@ApiSort(0)
@RestController("OpsSoftwareBaseTypeController")
public class SoftwareBaseTypeController extends SuperController {

	@Autowired
	private ISoftwareBaseTypeService softwareBaseTypeService;


	/**
	 * 添加软件基线类型
	*/
	@ApiOperation(value = "添加软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.INSERT)
	public Result insert(SoftwareBaseTypeVO softwareBaseTypeVO) {
		Result result=softwareBaseTypeService.insert(softwareBaseTypeVO,false);
		return result;
	}



	/**
	 * 删除软件基线类型
	*/
	@ApiOperation(value = "删除软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593841519329288192")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SoftwareBaseTypeVOMeta.ID)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=softwareBaseTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件基线类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SoftwareBaseTypeVOMeta.IDS)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=softwareBaseTypeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件基线类型
	*/
	@ApiOperation(value = "更新软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SoftwareBaseTypeVOMeta.PAGE_INDEX , SoftwareBaseTypeVOMeta.PAGE_SIZE , SoftwareBaseTypeVOMeta.SEARCH_FIELD , SoftwareBaseTypeVOMeta.FUZZY_FIELD , SoftwareBaseTypeVOMeta.SEARCH_VALUE , SoftwareBaseTypeVOMeta.DIRTY_FIELDS , SoftwareBaseTypeVOMeta.SORT_FIELD , SoftwareBaseTypeVOMeta.SORT_TYPE , SoftwareBaseTypeVOMeta.IDS } )
	@NotNull(name = SoftwareBaseTypeVOMeta.ID)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.UPDATE)
	public Result update(SoftwareBaseTypeVO softwareBaseTypeVO) {
		Result result=softwareBaseTypeService.update(softwareBaseTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件基线类型
	*/
	@ApiOperation(value = "保存软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SoftwareBaseTypeVOMeta.PAGE_INDEX , SoftwareBaseTypeVOMeta.PAGE_SIZE , SoftwareBaseTypeVOMeta.SEARCH_FIELD , SoftwareBaseTypeVOMeta.FUZZY_FIELD , SoftwareBaseTypeVOMeta.SEARCH_VALUE , SoftwareBaseTypeVOMeta.DIRTY_FIELDS , SoftwareBaseTypeVOMeta.SORT_FIELD , SoftwareBaseTypeVOMeta.SORT_TYPE , SoftwareBaseTypeVOMeta.IDS } )
	@NotNull(name = SoftwareBaseTypeVOMeta.ID)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.SAVE)
	public Result save(SoftwareBaseTypeVO softwareBaseTypeVO) {
		Result result=softwareBaseTypeService.save(softwareBaseTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件基线类型
	*/
	@ApiOperation(value = "获取软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SoftwareBaseTypeVOMeta.ID)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.GET_BY_ID)
	public Result<SoftwareBaseType> getById(String id) {
		Result<SoftwareBaseType> result=new Result<>();
		SoftwareBaseType softwareBaseType=softwareBaseTypeService.getById(id);
		result.success(true).data(softwareBaseType);
		return result;
	}


	/**
	 * 批量获取软件基线类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件基线类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SoftwareBaseTypeVOMeta.IDS)
		@SentinelResource(value = SoftwareBaseTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.GET_BY_IDS)
	public Result<List<SoftwareBaseType>> getByIds(List<String> ids) {
		Result<List<SoftwareBaseType>> result=new Result<>();
		List<SoftwareBaseType> list=softwareBaseTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件基线类型
	*/
	@ApiOperation(value = "查询软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SoftwareBaseTypeVOMeta.PAGE_INDEX , SoftwareBaseTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.QUERY_LIST)
	public Result<List<SoftwareBaseType>> queryList(SoftwareBaseTypeVO sample) {
		Result<List<SoftwareBaseType>> result=new Result<>();
		List<SoftwareBaseType> list=softwareBaseTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件基线类型
	*/
	@ApiOperation(value = "分页查询软件基线类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SoftwareBaseType>> queryPagedList(SoftwareBaseTypeVO sample) {
		Result<PagedList<SoftwareBaseType>> result=new Result<>();
		PagedList<SoftwareBaseType> list=softwareBaseTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SoftwareBaseTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SoftwareBaseTypeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=softwareBaseTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SoftwareBaseTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SoftwareBaseTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=softwareBaseTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = SoftwareBaseTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SoftwareBaseTypeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=softwareBaseTypeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}