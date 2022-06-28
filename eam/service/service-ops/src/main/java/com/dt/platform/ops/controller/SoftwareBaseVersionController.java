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


import com.dt.platform.proxy.ops.SoftwareBaseVersionServiceProxy;
import com.dt.platform.domain.ops.meta.SoftwareBaseVersionVOMeta;
import com.dt.platform.domain.ops.SoftwareBaseVersion;
import com.dt.platform.domain.ops.SoftwareBaseVersionVO;
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
import com.dt.platform.domain.ops.meta.SoftwareBaseVersionMeta;
import com.dt.platform.domain.ops.SoftwareBaseType;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ISoftwareBaseVersionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件基线版本 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-27 20:16:21
*/

@Api(tags = "软件基线版本")
@ApiSort(0)
@RestController("OpsSoftwareBaseVersionController")
public class SoftwareBaseVersionController extends SuperController {

	@Autowired
	private ISoftwareBaseVersionService softwareBaseVersionService;


	/**
	 * 添加软件基线版本
	*/
	@ApiOperation(value = "添加软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.INSERT)
	public Result insert(SoftwareBaseVersionVO softwareBaseVersionVO) {
		Result result=softwareBaseVersionService.insert(softwareBaseVersionVO,false);
		return result;
	}



	/**
	 * 删除软件基线版本
	*/
	@ApiOperation(value = "删除软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SoftwareBaseVersionVOMeta.ID)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=softwareBaseVersionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件基线版本 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SoftwareBaseVersionVOMeta.IDS)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=softwareBaseVersionService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件基线版本
	*/
	@ApiOperation(value = "更新软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SoftwareBaseVersionVOMeta.PAGE_INDEX , SoftwareBaseVersionVOMeta.PAGE_SIZE , SoftwareBaseVersionVOMeta.SEARCH_FIELD , SoftwareBaseVersionVOMeta.FUZZY_FIELD , SoftwareBaseVersionVOMeta.SEARCH_VALUE , SoftwareBaseVersionVOMeta.DIRTY_FIELDS , SoftwareBaseVersionVOMeta.SORT_FIELD , SoftwareBaseVersionVOMeta.SORT_TYPE , SoftwareBaseVersionVOMeta.IDS } )
	@NotNull(name = SoftwareBaseVersionVOMeta.ID)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.UPDATE)
	public Result update(SoftwareBaseVersionVO softwareBaseVersionVO) {
		Result result=softwareBaseVersionService.update(softwareBaseVersionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件基线版本
	*/
	@ApiOperation(value = "保存软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SoftwareBaseVersionVOMeta.PAGE_INDEX , SoftwareBaseVersionVOMeta.PAGE_SIZE , SoftwareBaseVersionVOMeta.SEARCH_FIELD , SoftwareBaseVersionVOMeta.FUZZY_FIELD , SoftwareBaseVersionVOMeta.SEARCH_VALUE , SoftwareBaseVersionVOMeta.DIRTY_FIELDS , SoftwareBaseVersionVOMeta.SORT_FIELD , SoftwareBaseVersionVOMeta.SORT_TYPE , SoftwareBaseVersionVOMeta.IDS } )
	@NotNull(name = SoftwareBaseVersionVOMeta.ID)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.SAVE)
	public Result save(SoftwareBaseVersionVO softwareBaseVersionVO) {
		Result result=softwareBaseVersionService.save(softwareBaseVersionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件基线版本
	*/
	@ApiOperation(value = "获取软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SoftwareBaseVersionVOMeta.ID)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.GET_BY_ID)
	public Result<SoftwareBaseVersion> getById(String id) {
		Result<SoftwareBaseVersion> result=new Result<>();
		SoftwareBaseVersion softwareBaseVersion=softwareBaseVersionService.getById(id);
		// join 关联的对象
		softwareBaseVersionService.dao().fill(softwareBaseVersion)
			.with(SoftwareBaseVersionMeta.SOFTWARE_BASE_TYPE)
			.execute();
		result.success(true).data(softwareBaseVersion);
		return result;
	}


	/**
	 * 批量获取软件基线版本 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件基线版本")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SoftwareBaseVersionVOMeta.IDS)
		@SentinelResource(value = SoftwareBaseVersionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.GET_BY_IDS)
	public Result<List<SoftwareBaseVersion>> getByIds(List<String> ids) {
		Result<List<SoftwareBaseVersion>> result=new Result<>();
		List<SoftwareBaseVersion> list=softwareBaseVersionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件基线版本
	*/
	@ApiOperation(value = "查询软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SoftwareBaseVersionVOMeta.PAGE_INDEX , SoftwareBaseVersionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.QUERY_LIST)
	public Result<List<SoftwareBaseVersion>> queryList(SoftwareBaseVersionVO sample) {
		Result<List<SoftwareBaseVersion>> result=new Result<>();
		List<SoftwareBaseVersion> list=softwareBaseVersionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件基线版本
	*/
	@ApiOperation(value = "分页查询软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SoftwareBaseVersion>> queryPagedList(SoftwareBaseVersionVO sample) {
		Result<PagedList<SoftwareBaseVersion>> result=new Result<>();
		PagedList<SoftwareBaseVersion> list=softwareBaseVersionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		softwareBaseVersionService.dao().fill(list)
			.with(SoftwareBaseVersionMeta.SOFTWARE_BASE_TYPE)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SoftwareBaseVersionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SoftwareBaseVersionVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=softwareBaseVersionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SoftwareBaseVersionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=softwareBaseVersionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = SoftwareBaseVersionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SoftwareBaseVersionServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=softwareBaseVersionService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}