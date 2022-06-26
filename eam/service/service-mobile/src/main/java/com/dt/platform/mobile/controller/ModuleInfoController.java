package com.dt.platform.mobile.controller;


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


import com.dt.platform.proxy.mobile.ModuleInfoServiceProxy;
import com.dt.platform.domain.mobile.meta.ModuleInfoVOMeta;
import com.dt.platform.domain.mobile.ModuleInfo;
import com.dt.platform.domain.mobile.ModuleInfoVO;
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
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.dt.platform.domain.mobile.ModuleGroup;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.mobile.service.IModuleInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 移动端模块 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-24 19:28:56
*/

@Api(tags = "移动端模块")
@ApiSort(0)
@RestController("AppModuleInfoController")
public class ModuleInfoController extends SuperController {

	@Autowired
	private IModuleInfoService moduleInfoService;


	/**
	 * 添加移动端模块
	*/
	@ApiOperation(value = "添加移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME , value = "图标" , required = false , dataTypeClass=String.class , example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH , value = "路径" , required = false , dataTypeClass=String.class , example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ModuleInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.INSERT)
	public Result insert(ModuleInfoVO moduleInfoVO) {
		Result result=moduleInfoService.insert(moduleInfoVO,false);
		return result;
	}



	/**
	 * 删除移动端模块
	*/
	@ApiOperation(value = "删除移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ModuleInfoVOMeta.ID)
	@SentinelResource(value = ModuleInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=moduleInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除移动端模块 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ModuleInfoVOMeta.IDS)
	@SentinelResource(value = ModuleInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=moduleInfoService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新移动端模块
	*/
	@ApiOperation(value = "更新移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME , value = "图标" , required = false , dataTypeClass=String.class , example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH , value = "路径" , required = false , dataTypeClass=String.class , example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ModuleInfoVOMeta.PAGE_INDEX , ModuleInfoVOMeta.PAGE_SIZE , ModuleInfoVOMeta.SEARCH_FIELD , ModuleInfoVOMeta.FUZZY_FIELD , ModuleInfoVOMeta.SEARCH_VALUE , ModuleInfoVOMeta.DIRTY_FIELDS , ModuleInfoVOMeta.SORT_FIELD , ModuleInfoVOMeta.SORT_TYPE , ModuleInfoVOMeta.IDS } )
	@NotNull(name = ModuleInfoVOMeta.ID)
	@SentinelResource(value = ModuleInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.UPDATE)
	public Result update(ModuleInfoVO moduleInfoVO) {
		Result result=moduleInfoService.update(moduleInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存移动端模块
	*/
	@ApiOperation(value = "保存移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME , value = "图标" , required = false , dataTypeClass=String.class , example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH , value = "路径" , required = false , dataTypeClass=String.class , example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ModuleInfoVOMeta.PAGE_INDEX , ModuleInfoVOMeta.PAGE_SIZE , ModuleInfoVOMeta.SEARCH_FIELD , ModuleInfoVOMeta.FUZZY_FIELD , ModuleInfoVOMeta.SEARCH_VALUE , ModuleInfoVOMeta.DIRTY_FIELDS , ModuleInfoVOMeta.SORT_FIELD , ModuleInfoVOMeta.SORT_TYPE , ModuleInfoVOMeta.IDS } )
	@NotNull(name = ModuleInfoVOMeta.ID)
	@SentinelResource(value = ModuleInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.SAVE)
	public Result save(ModuleInfoVO moduleInfoVO) {
		Result result=moduleInfoService.save(moduleInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取移动端模块
	*/
	@ApiOperation(value = "获取移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ModuleInfoVOMeta.ID)
	@SentinelResource(value = ModuleInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.GET_BY_ID)
	public Result<ModuleInfo> getById(String id) {
		Result<ModuleInfo> result=new Result<>();
		ModuleInfo moduleInfo=moduleInfoService.getById(id);
		// join 关联的对象
		moduleInfoService.dao().fill(moduleInfo)
			.with(ModuleInfoMeta.MODULE_GROUP)
			.execute();
		result.success(true).data(moduleInfo);
		return result;
	}


	/**
	 * 批量获取移动端模块 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取移动端模块")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ModuleInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ModuleInfoVOMeta.IDS)
		@SentinelResource(value = ModuleInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.GET_BY_IDS)
	public Result<List<ModuleInfo>> getByIds(List<String> ids) {
		Result<List<ModuleInfo>> result=new Result<>();
		List<ModuleInfo> list=moduleInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询移动端模块
	*/
	@ApiOperation(value = "查询移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME , value = "图标" , required = false , dataTypeClass=String.class , example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH , value = "路径" , required = false , dataTypeClass=String.class , example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ModuleInfoVOMeta.PAGE_INDEX , ModuleInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ModuleInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.QUERY_LIST)
	public Result<List<ModuleInfo>> queryList(ModuleInfoVO sample) {
		Result<List<ModuleInfo>> result=new Result<>();
		List<ModuleInfo> list=moduleInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询移动端模块
	*/
	@ApiOperation(value = "分页查询移动端模块")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID , value = "分组" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME , value = "图标" , required = false , dataTypeClass=String.class , example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH , value = "路径" , required = false , dataTypeClass=String.class , example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ModuleInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ModuleInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ModuleInfo>> queryPagedList(ModuleInfoVO sample) {
		Result<PagedList<ModuleInfo>> result=new Result<>();
		PagedList<ModuleInfo> list=moduleInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		moduleInfoService.dao().fill(list)
			.with(ModuleInfoMeta.MODULE_GROUP)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ModuleInfoServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ModuleInfoServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ModuleInfoVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=moduleInfoService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ModuleInfoServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ModuleInfoServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=moduleInfoService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = ModuleInfoServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ModuleInfoServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=moduleInfoService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}