package com.dt.platform.eam.controller;


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


import com.dt.platform.proxy.eam.AssetEmployeeApplyServiceProxy;
import com.dt.platform.domain.eam.meta.AssetEmployeeApplyVOMeta;
import com.dt.platform.domain.eam.AssetEmployeeApply;
import com.dt.platform.domain.eam.AssetEmployeeApplyVO;
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
import com.dt.platform.domain.eam.meta.AssetEmployeeApplyMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetEmployeeApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 领用申请 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-23 15:52:11
*/

@Api(tags = "领用申请")
@ApiSort(0)
@RestController("EamAssetEmployeeApplyController")
public class AssetEmployeeApplyController extends SuperController {

	@Autowired
	private IAssetEmployeeApplyService assetEmployeeApplyService;


	/**
	 * 添加领用申请
	*/
	@ApiOperation(value = "添加领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.APPLY_COUNT , value = "申请数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.INSERT)
	public Result insert(AssetEmployeeApplyVO assetEmployeeApplyVO) {
		Result result=assetEmployeeApplyService.insert(assetEmployeeApplyVO,false);
		return result;
	}



	/**
	 * 删除领用申请
	*/
	@ApiOperation(value = "删除领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetEmployeeApplyVOMeta.ID)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetEmployeeApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除领用申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetEmployeeApplyVOMeta.IDS)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetEmployeeApplyService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新领用申请
	*/
	@ApiOperation(value = "更新领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.APPLY_COUNT , value = "申请数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetEmployeeApplyVOMeta.PAGE_INDEX , AssetEmployeeApplyVOMeta.PAGE_SIZE , AssetEmployeeApplyVOMeta.SEARCH_FIELD , AssetEmployeeApplyVOMeta.FUZZY_FIELD , AssetEmployeeApplyVOMeta.SEARCH_VALUE , AssetEmployeeApplyVOMeta.DIRTY_FIELDS , AssetEmployeeApplyVOMeta.SORT_FIELD , AssetEmployeeApplyVOMeta.SORT_TYPE , AssetEmployeeApplyVOMeta.IDS } )
	@NotNull(name = AssetEmployeeApplyVOMeta.ID)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.UPDATE)
	public Result update(AssetEmployeeApplyVO assetEmployeeApplyVO) {
		Result result=assetEmployeeApplyService.update(assetEmployeeApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存领用申请
	*/
	@ApiOperation(value = "保存领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.APPLY_COUNT , value = "申请数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetEmployeeApplyVOMeta.PAGE_INDEX , AssetEmployeeApplyVOMeta.PAGE_SIZE , AssetEmployeeApplyVOMeta.SEARCH_FIELD , AssetEmployeeApplyVOMeta.FUZZY_FIELD , AssetEmployeeApplyVOMeta.SEARCH_VALUE , AssetEmployeeApplyVOMeta.DIRTY_FIELDS , AssetEmployeeApplyVOMeta.SORT_FIELD , AssetEmployeeApplyVOMeta.SORT_TYPE , AssetEmployeeApplyVOMeta.IDS } )
	@NotNull(name = AssetEmployeeApplyVOMeta.ID)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.SAVE)
	public Result save(AssetEmployeeApplyVO assetEmployeeApplyVO) {
		Result result=assetEmployeeApplyService.save(assetEmployeeApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取领用申请
	*/
	@ApiOperation(value = "获取领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetEmployeeApplyVOMeta.ID)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.GET_BY_ID)
	public Result<AssetEmployeeApply> getById(String id) {
		Result<AssetEmployeeApply> result=new Result<>();
		AssetEmployeeApply assetEmployeeApply=assetEmployeeApplyService.getById(id);
		// join 关联的对象
		assetEmployeeApplyService.dao().fill(assetEmployeeApply)
			.with("organization")
			.with("originator")
			.execute();
		result.success(true).data(assetEmployeeApply);
		return result;
	}


	/**
	 * 批量获取领用申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取领用申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetEmployeeApplyVOMeta.IDS)
		@SentinelResource(value = AssetEmployeeApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.GET_BY_IDS)
	public Result<List<AssetEmployeeApply>> getByIds(List<String> ids) {
		Result<List<AssetEmployeeApply>> result=new Result<>();
		List<AssetEmployeeApply> list=assetEmployeeApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询领用申请
	*/
	@ApiOperation(value = "查询领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.APPLY_COUNT , value = "申请数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetEmployeeApplyVOMeta.PAGE_INDEX , AssetEmployeeApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.QUERY_LIST)
	public Result<List<AssetEmployeeApply>> queryList(AssetEmployeeApplyVO sample) {
		Result<List<AssetEmployeeApply>> result=new Result<>();
		List<AssetEmployeeApply> list=assetEmployeeApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询领用申请
	*/
	@ApiOperation(value = "分页查询领用申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.APPLY_COUNT , value = "申请数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetEmployeeApply>> queryPagedList(AssetEmployeeApplyVO sample) {
		Result<PagedList<AssetEmployeeApply>> result=new Result<>();
		PagedList<AssetEmployeeApply> list=assetEmployeeApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetEmployeeApplyService.dao().fill(list)
			.with("organization")
			.with("originator")
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeApplyServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetEmployeeApplyVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetEmployeeApplyService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetEmployeeApplyServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeApplyServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetEmployeeApplyService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetEmployeeApplyServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeApplyServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetEmployeeApplyService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}