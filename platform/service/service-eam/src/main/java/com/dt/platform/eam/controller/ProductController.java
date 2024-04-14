package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.ProductServiceProxy;
import com.dt.platform.domain.eam.meta.ProductVOMeta;
import com.dt.platform.domain.eam.Product;
import com.dt.platform.domain.eam.ProductVO;
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
import com.dt.platform.domain.eam.meta.ProductMeta;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.ProductFunction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IProductService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 产品管理接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:38
*/

@InDoc
@Api(tags = "产品管理")
@RestController("IotProductController")
public class ProductController extends SuperController {

	@Autowired
	private IProductService productService;

	/**
	 * 添加产品管理
	*/
	@ApiOperation(value = "添加产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_KEY , value = "产品Key" , required = false , dataTypeClass=String.class , example = "key"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "产品名称" , required = false , dataTypeClass=String.class , example = "门"),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY_ID , value = "品类" , required = false , dataTypeClass=String.class , example = "mc"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TYPE , value = "节点类型" , required = false , dataTypeClass=String.class , example = "gateway"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TRANSPARENT , value = "透传设备" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_STATUS , value = "设备定位" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_METHOD , value = "定位方式" , required = false , dataTypeClass=String.class , example = "report"),
		@ApiImplicitParam(name = ProductVOMeta.IMAGE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "829083060526907392"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.INSERT)
	public Result insert(ProductVO productVO) {
		
		Result result=productService.insert(productVO,false);
		return result;
	}



	/**
	 * 删除产品管理
	*/
	@ApiOperation(value = "删除产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082363148369920")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  productService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=productService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除产品管理 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ProductServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = productService.hasRefers(ids);
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
			Result result=productService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=productService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新产品管理
	*/
	@ApiOperation(value = "更新产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_KEY , value = "产品Key" , required = false , dataTypeClass=String.class , example = "key"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "产品名称" , required = false , dataTypeClass=String.class , example = "门"),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY_ID , value = "品类" , required = false , dataTypeClass=String.class , example = "mc"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TYPE , value = "节点类型" , required = false , dataTypeClass=String.class , example = "gateway"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TRANSPARENT , value = "透传设备" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_STATUS , value = "设备定位" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_METHOD , value = "定位方式" , required = false , dataTypeClass=String.class , example = "report"),
		@ApiImplicitParam(name = ProductVOMeta.IMAGE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "829083060526907392"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE , ProductVOMeta.SEARCH_FIELD , ProductVOMeta.FUZZY_FIELD , ProductVOMeta.SEARCH_VALUE , ProductVOMeta.DIRTY_FIELDS , ProductVOMeta.SORT_FIELD , ProductVOMeta.SORT_TYPE , ProductVOMeta.DATA_ORIGIN , ProductVOMeta.QUERY_LOGIC , ProductVOMeta.REQUEST_ACTION , ProductVOMeta.IDS } )
	@SentinelResource(value = ProductServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.UPDATE)
	public Result update(ProductVO productVO) {
		
		Result result=productService.update(productVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存产品管理
	*/
	@ApiOperation(value = "保存产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_KEY , value = "产品Key" , required = false , dataTypeClass=String.class , example = "key"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "产品名称" , required = false , dataTypeClass=String.class , example = "门"),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY_ID , value = "品类" , required = false , dataTypeClass=String.class , example = "mc"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TYPE , value = "节点类型" , required = false , dataTypeClass=String.class , example = "gateway"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TRANSPARENT , value = "透传设备" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_STATUS , value = "设备定位" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_METHOD , value = "定位方式" , required = false , dataTypeClass=String.class , example = "report"),
		@ApiImplicitParam(name = ProductVOMeta.IMAGE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "829083060526907392"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE , ProductVOMeta.SEARCH_FIELD , ProductVOMeta.FUZZY_FIELD , ProductVOMeta.SEARCH_VALUE , ProductVOMeta.DIRTY_FIELDS , ProductVOMeta.SORT_FIELD , ProductVOMeta.SORT_TYPE , ProductVOMeta.DATA_ORIGIN , ProductVOMeta.QUERY_LOGIC , ProductVOMeta.REQUEST_ACTION , ProductVOMeta.IDS } )
	@SentinelResource(value = ProductServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.SAVE)
	public Result save(ProductVO productVO) {
		
		Result result=productService.save(productVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取产品管理
	*/
	@ApiOperation(value = "获取产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.GET_BY_ID)
	public Result<Product> getById(String id) {
		
		Result<Product> result=new Result<>();
		Product product=productService.getById(id);
		// join 关联的对象
		productService.dao().fill(product)
			.with(ProductMeta.CATEGORY)
			.execute();
		result.success(true).data(product);
		return result;
	}


	/**
	 * 批量获取产品管理 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取产品管理")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ProductVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ProductServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.GET_BY_IDS)
	public Result<List<Product>> getByIds(List<String> ids) {
		
		Result<List<Product>> result=new Result<>();
		List<Product> list=productService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询产品管理
	*/
	@ApiOperation(value = "查询产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_KEY , value = "产品Key" , required = false , dataTypeClass=String.class , example = "key"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "产品名称" , required = false , dataTypeClass=String.class , example = "门"),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY_ID , value = "品类" , required = false , dataTypeClass=String.class , example = "mc"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TYPE , value = "节点类型" , required = false , dataTypeClass=String.class , example = "gateway"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TRANSPARENT , value = "透传设备" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_STATUS , value = "设备定位" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_METHOD , value = "定位方式" , required = false , dataTypeClass=String.class , example = "report"),
		@ApiImplicitParam(name = ProductVOMeta.IMAGE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "829083060526907392"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ProductServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.QUERY_LIST)
	public Result<List<Product>> queryList(ProductVO sample) {
		
		Result<List<Product>> result=new Result<>();
		List<Product> list=productService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询产品管理
	*/
	@ApiOperation(value = "分页查询产品管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "829082363148369920"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_KEY , value = "产品Key" , required = false , dataTypeClass=String.class , example = "key"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "产品名称" , required = false , dataTypeClass=String.class , example = "门"),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY_ID , value = "品类" , required = false , dataTypeClass=String.class , example = "mc"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TYPE , value = "节点类型" , required = false , dataTypeClass=String.class , example = "gateway"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_TRANSPARENT , value = "透传设备" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_STATUS , value = "设备定位" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ProductVOMeta.LOCATION_METHOD , value = "定位方式" , required = false , dataTypeClass=String.class , example = "report"),
		@ApiImplicitParam(name = ProductVOMeta.IMAGE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "829083060526907392"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Product>> queryPagedList(ProductVO sample) {
		
		Result<PagedList<Product>> result=new Result<>();
		PagedList<Product> list=productService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		productService.dao().fill(list)
			.with(ProductMeta.CATEGORY)
			.execute();
		result.success(true).data(list);
		return result;
	}





}