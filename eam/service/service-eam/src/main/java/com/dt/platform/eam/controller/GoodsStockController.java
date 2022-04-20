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


import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import com.dt.platform.domain.eam.meta.GoodsStockVOMeta;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.GoodsStockVO;
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
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.Brand;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IGoodsStockService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存物品 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 13:15:09
*/

@Api(tags = "库存物品")
@ApiSort(0)
@RestController("EamGoodsStockController")
public class GoodsStockController extends SuperController {

	@Autowired
	private IGoodsStockService goodsStockService;


	/**
	 * 添加库存物品
	*/
	@ApiOperation(value = "添加库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568695656818933760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.DEFAULT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "122"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = GoodsStockServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.INSERT)
	public Result insert(GoodsStockVO goodsStockVO) {
		Result result=goodsStockService.insert(goodsStockVO,false);
		return result;
	}



	/**
	 * 删除库存物品
	*/
	@ApiOperation(value = "删除库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568695656818933760")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=goodsStockService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存物品 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = GoodsStockVOMeta.IDS)
	@SentinelResource(value = GoodsStockServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=goodsStockService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存物品
	*/
	@ApiOperation(value = "更新库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568695656818933760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.DEFAULT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "122"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE , GoodsStockVOMeta.SEARCH_FIELD , GoodsStockVOMeta.FUZZY_FIELD , GoodsStockVOMeta.SEARCH_VALUE , GoodsStockVOMeta.DIRTY_FIELDS , GoodsStockVOMeta.SORT_FIELD , GoodsStockVOMeta.SORT_TYPE , GoodsStockVOMeta.IDS } )
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.UPDATE)
	public Result update(GoodsStockVO goodsStockVO) {
		Result result=goodsStockService.update(goodsStockVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存物品
	*/
	@ApiOperation(value = "保存库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568695656818933760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.DEFAULT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "122"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE , GoodsStockVOMeta.SEARCH_FIELD , GoodsStockVOMeta.FUZZY_FIELD , GoodsStockVOMeta.SEARCH_VALUE , GoodsStockVOMeta.DIRTY_FIELDS , GoodsStockVOMeta.SORT_FIELD , GoodsStockVOMeta.SORT_TYPE , GoodsStockVOMeta.IDS } )
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.SAVE)
	public Result save(GoodsStockVO goodsStockVO) {
		Result result=goodsStockService.save(goodsStockVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存物品
	*/
	@ApiOperation(value = "获取库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.GET_BY_ID)
	public Result<GoodsStock> getById(String id) {
		Result<GoodsStock> result=new Result<>();
		GoodsStock goodsStock=goodsStockService.getById(id);
		// join 关联的对象
		goodsStockService.dao().fill(goodsStock)
			.with(GoodsMeta.CATEGORY)
			.with(GoodsStockMeta.BRAND)
			.with(GoodsMeta.MANUFACTURER)
			.execute();
		result.success(true).data(goodsStock);
		return result;
	}


	/**
	 * 批量获取库存物品 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存物品")
		@ApiImplicitParams({
				@ApiImplicitParam(name = GoodsStockVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = GoodsStockVOMeta.IDS)
		@SentinelResource(value = GoodsStockServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.GET_BY_IDS)
	public Result<List<GoodsStock>> getByIds(List<String> ids) {
		Result<List<GoodsStock>> result=new Result<>();
		List<GoodsStock> list=goodsStockService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存物品
	*/
	@ApiOperation(value = "查询库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568695656818933760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.DEFAULT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "122"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_LIST)
	public Result<List<GoodsStock>> queryList(GoodsStockVO sample) {
		Result<List<GoodsStock>> result=new Result<>();
		List<GoodsStock> list=goodsStockService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存物品
	*/
	@ApiOperation(value = "分页查询库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568695656818933760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.DEFAULT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "12"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "122"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<GoodsStock>> queryPagedList(GoodsStockVO sample) {
		Result<PagedList<GoodsStock>> result=new Result<>();
		PagedList<GoodsStock> list=goodsStockService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		goodsStockService.dao().fill(list)
			.with(GoodsMeta.CATEGORY)
			.with(GoodsStockMeta.BRAND)
			.with(GoodsMeta.MANUFACTURER)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = GoodsStockServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsStockServiceProxy.EXPORT_EXCEL)
	public void exportExcel(GoodsStockVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=goodsStockService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = GoodsStockServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsStockServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=goodsStockService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = GoodsStockServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsStockServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=goodsStockService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}