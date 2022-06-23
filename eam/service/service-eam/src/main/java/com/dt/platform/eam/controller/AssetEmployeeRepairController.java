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


import com.dt.platform.proxy.eam.AssetEmployeeRepairServiceProxy;
import com.dt.platform.domain.eam.meta.AssetEmployeeRepairVOMeta;
import com.dt.platform.domain.eam.AssetEmployeeRepair;
import com.dt.platform.domain.eam.AssetEmployeeRepairVO;
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
import com.dt.platform.domain.eam.meta.AssetEmployeeRepairMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetEmployeeRepairService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产报修 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-23 10:10:53
*/

@Api(tags = "资产报修")
@ApiSort(0)
@RestController("EamAssetEmployeeRepairController")
public class AssetEmployeeRepairController extends SuperController {

	@Autowired
	private IAssetEmployeeRepairService assetEmployeeRepairService;


	/**
	 * 添加资产报修
	*/
	@ApiOperation(value = "添加资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT , value = "故障原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.INSERT)
	public Result insert(AssetEmployeeRepairVO assetEmployeeRepairVO) {
		Result result=assetEmployeeRepairService.insert(assetEmployeeRepairVO,false);
		return result;
	}



	/**
	 * 删除资产报修
	*/
	@ApiOperation(value = "删除资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetEmployeeRepairVOMeta.ID)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetEmployeeRepairService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产报修 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetEmployeeRepairVOMeta.IDS)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetEmployeeRepairService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产报修
	*/
	@ApiOperation(value = "更新资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT , value = "故障原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetEmployeeRepairVOMeta.PAGE_INDEX , AssetEmployeeRepairVOMeta.PAGE_SIZE , AssetEmployeeRepairVOMeta.SEARCH_FIELD , AssetEmployeeRepairVOMeta.FUZZY_FIELD , AssetEmployeeRepairVOMeta.SEARCH_VALUE , AssetEmployeeRepairVOMeta.DIRTY_FIELDS , AssetEmployeeRepairVOMeta.SORT_FIELD , AssetEmployeeRepairVOMeta.SORT_TYPE , AssetEmployeeRepairVOMeta.IDS } )
	@NotNull(name = AssetEmployeeRepairVOMeta.ID)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.UPDATE)
	public Result update(AssetEmployeeRepairVO assetEmployeeRepairVO) {
		Result result=assetEmployeeRepairService.update(assetEmployeeRepairVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产报修
	*/
	@ApiOperation(value = "保存资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT , value = "故障原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetEmployeeRepairVOMeta.PAGE_INDEX , AssetEmployeeRepairVOMeta.PAGE_SIZE , AssetEmployeeRepairVOMeta.SEARCH_FIELD , AssetEmployeeRepairVOMeta.FUZZY_FIELD , AssetEmployeeRepairVOMeta.SEARCH_VALUE , AssetEmployeeRepairVOMeta.DIRTY_FIELDS , AssetEmployeeRepairVOMeta.SORT_FIELD , AssetEmployeeRepairVOMeta.SORT_TYPE , AssetEmployeeRepairVOMeta.IDS } )
	@NotNull(name = AssetEmployeeRepairVOMeta.ID)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.SAVE)
	public Result save(AssetEmployeeRepairVO assetEmployeeRepairVO) {
		Result result=assetEmployeeRepairService.save(assetEmployeeRepairVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产报修
	*/
	@ApiOperation(value = "获取资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetEmployeeRepairVOMeta.ID)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.GET_BY_ID)
	public Result<AssetEmployeeRepair> getById(String id) {
		Result<AssetEmployeeRepair> result=new Result<>();
		AssetEmployeeRepair assetEmployeeRepair=assetEmployeeRepairService.getById(id);
		// join 关联的对象
		assetEmployeeRepairService.dao().fill(assetEmployeeRepair)
			.with("organization")
			.with("originator")
			.execute();
		result.success(true).data(assetEmployeeRepair);
		return result;
	}


	/**
	 * 批量获取资产报修 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产报修")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetEmployeeRepairVOMeta.IDS)
		@SentinelResource(value = AssetEmployeeRepairServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.GET_BY_IDS)
	public Result<List<AssetEmployeeRepair>> getByIds(List<String> ids) {
		Result<List<AssetEmployeeRepair>> result=new Result<>();
		List<AssetEmployeeRepair> list=assetEmployeeRepairService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产报修
	*/
	@ApiOperation(value = "查询资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT , value = "故障原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetEmployeeRepairVOMeta.PAGE_INDEX , AssetEmployeeRepairVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.QUERY_LIST)
	public Result<List<AssetEmployeeRepair>> queryList(AssetEmployeeRepairVO sample) {
		Result<List<AssetEmployeeRepair>> result=new Result<>();
		List<AssetEmployeeRepair> list=assetEmployeeRepairService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产报修
	*/
	@ApiOperation(value = "分页查询资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT , value = "故障原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeRepairServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetEmployeeRepair>> queryPagedList(AssetEmployeeRepairVO sample) {
		Result<PagedList<AssetEmployeeRepair>> result=new Result<>();
		PagedList<AssetEmployeeRepair> list=assetEmployeeRepairService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetEmployeeRepairService.dao().fill(list)
			.with("organization")
			.with("originator")
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeRepairServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetEmployeeRepairVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetEmployeeRepairService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetEmployeeRepairServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeRepairServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetEmployeeRepairService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetEmployeeRepairServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeRepairServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetEmployeeRepairService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}