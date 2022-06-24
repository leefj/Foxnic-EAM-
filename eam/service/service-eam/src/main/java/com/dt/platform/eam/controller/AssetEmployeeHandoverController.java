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


import com.dt.platform.proxy.eam.AssetEmployeeHandoverServiceProxy;
import com.dt.platform.domain.eam.meta.AssetEmployeeHandoverVOMeta;
import com.dt.platform.domain.eam.AssetEmployeeHandover;
import com.dt.platform.domain.eam.AssetEmployeeHandoverVO;
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
import com.dt.platform.domain.eam.meta.AssetEmployeeHandoverMeta;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetEmployeeHandoverService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产交接 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-23 15:53:04
*/

@Api(tags = "资产交接")
@ApiSort(0)
@RestController("EamAssetEmployeeHandoverController")
public class AssetEmployeeHandoverController extends SuperController {

	@Autowired
	private IAssetEmployeeHandoverService assetEmployeeHandoverService;


	/**
	 * 添加资产交接
	*/
	@ApiOperation(value = "添加资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID , value = "交接部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.INSERT)
	public Result insert(AssetEmployeeHandoverVO assetEmployeeHandoverVO) {
		Result result=assetEmployeeHandoverService.insert(assetEmployeeHandoverVO,false);
		return result;
	}



	/**
	 * 删除资产交接
	*/
	@ApiOperation(value = "删除资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetEmployeeHandoverVOMeta.ID)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetEmployeeHandoverService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产交接 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetEmployeeHandoverVOMeta.IDS)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetEmployeeHandoverService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产交接
	*/
	@ApiOperation(value = "更新资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID , value = "交接部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetEmployeeHandoverVOMeta.PAGE_INDEX , AssetEmployeeHandoverVOMeta.PAGE_SIZE , AssetEmployeeHandoverVOMeta.SEARCH_FIELD , AssetEmployeeHandoverVOMeta.FUZZY_FIELD , AssetEmployeeHandoverVOMeta.SEARCH_VALUE , AssetEmployeeHandoverVOMeta.DIRTY_FIELDS , AssetEmployeeHandoverVOMeta.SORT_FIELD , AssetEmployeeHandoverVOMeta.SORT_TYPE , AssetEmployeeHandoverVOMeta.IDS } )
	@NotNull(name = AssetEmployeeHandoverVOMeta.ID)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.UPDATE)
	public Result update(AssetEmployeeHandoverVO assetEmployeeHandoverVO) {
		Result result=assetEmployeeHandoverService.update(assetEmployeeHandoverVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产交接
	*/
	@ApiOperation(value = "保存资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID , value = "交接部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetEmployeeHandoverVOMeta.PAGE_INDEX , AssetEmployeeHandoverVOMeta.PAGE_SIZE , AssetEmployeeHandoverVOMeta.SEARCH_FIELD , AssetEmployeeHandoverVOMeta.FUZZY_FIELD , AssetEmployeeHandoverVOMeta.SEARCH_VALUE , AssetEmployeeHandoverVOMeta.DIRTY_FIELDS , AssetEmployeeHandoverVOMeta.SORT_FIELD , AssetEmployeeHandoverVOMeta.SORT_TYPE , AssetEmployeeHandoverVOMeta.IDS } )
	@NotNull(name = AssetEmployeeHandoverVOMeta.ID)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.SAVE)
	public Result save(AssetEmployeeHandoverVO assetEmployeeHandoverVO) {
		Result result=assetEmployeeHandoverService.save(assetEmployeeHandoverVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产交接
	*/
	@ApiOperation(value = "获取资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetEmployeeHandoverVOMeta.ID)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.GET_BY_ID)
	public Result<AssetEmployeeHandover> getById(String id) {
		Result<AssetEmployeeHandover> result=new Result<>();
		AssetEmployeeHandover assetEmployeeHandover=assetEmployeeHandoverService.getById(id);
		// join 关联的对象
		assetEmployeeHandoverService.dao().fill(assetEmployeeHandover)
			.with("organization")
			.with("receiveOrganization")
			.with("originator")
			.with("receiverUser")
			.execute();
		result.success(true).data(assetEmployeeHandover);
		return result;
	}


	/**
	 * 批量获取资产交接 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产交接")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetEmployeeHandoverVOMeta.IDS)
		@SentinelResource(value = AssetEmployeeHandoverServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.GET_BY_IDS)
	public Result<List<AssetEmployeeHandover>> getByIds(List<String> ids) {
		Result<List<AssetEmployeeHandover>> result=new Result<>();
		List<AssetEmployeeHandover> list=assetEmployeeHandoverService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产交接
	*/
	@ApiOperation(value = "查询资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID , value = "交接部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetEmployeeHandoverVOMeta.PAGE_INDEX , AssetEmployeeHandoverVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.QUERY_LIST)
	public Result<List<AssetEmployeeHandover>> queryList(AssetEmployeeHandoverVO sample) {
		Result<List<AssetEmployeeHandover>> result=new Result<>();
		List<AssetEmployeeHandover> list=assetEmployeeHandoverService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产交接
	*/
	@ApiOperation(value = "分页查询资产交接")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID , value = "交接部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID , value = "交接人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetEmployeeHandoverServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetEmployeeHandover>> queryPagedList(AssetEmployeeHandoverVO sample) {
		Result<PagedList<AssetEmployeeHandover>> result=new Result<>();
		PagedList<AssetEmployeeHandover> list=assetEmployeeHandoverService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetEmployeeHandoverService.dao().fill(list)
			.with("organization")
			.with("receiveOrganization")
			.with("originator")
			.with("receiverUser")
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetEmployeeHandoverVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetEmployeeHandoverService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetEmployeeHandoverService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetEmployeeHandoverServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetEmployeeHandoverServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetEmployeeHandoverService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}