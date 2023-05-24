package com.dt.platform.common.controller;

import java.util.*;

import com.dt.platform.domain.common.*;
import com.dt.platform.domain.common.meta.FormDataVOMeta;
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


import com.dt.platform.proxy.common.FormInfoServiceProxy;
import com.dt.platform.domain.common.meta.FormInfoVOMeta;
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
import com.dt.platform.domain.common.meta.FormInfoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IFormInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 表单信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 09:06:10
*/

@InDoc
@Api(tags = "表单信息")
@RestController("SysFormInfoController")
public class FormInfoController extends SuperController {

	@Autowired
	private IFormInfoService formInfoService;

	/**
	 * 添加表单信息
	*/
	@ApiOperation(value = "添加表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "712591748785766400"),
		@ApiImplicitParam(name = FormInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.CATALOG_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单测试"),
		@ApiImplicitParam(name = FormInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = FormInfoVOMeta.ROUTE , value = "路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),

	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.INSERT)
	public Result insert(FormInfoVO formInfoVO) {
		
		Result result=formInfoService.insert(formInfoVO,false);
		return result;
	}



	/**
	 * 删除表单信息
	*/
	@ApiOperation(value = "删除表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "712591748785766400")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  formInfoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=formInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除表单信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = FormInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = formInfoService.hasRefers(ids);
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
			Result result=formInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=formInfoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新表单信息
	*/
	@ApiOperation(value = "更新表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "712591748785766400"),
		@ApiImplicitParam(name = FormInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.CATALOG_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单测试"),
		@ApiImplicitParam(name = FormInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = FormInfoVOMeta.ROUTE , value = "路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),

	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormInfoVOMeta.PAGE_INDEX , FormInfoVOMeta.PAGE_SIZE , FormInfoVOMeta.SEARCH_FIELD , FormInfoVOMeta.FUZZY_FIELD , FormInfoVOMeta.SEARCH_VALUE , FormInfoVOMeta.DIRTY_FIELDS , FormInfoVOMeta.SORT_FIELD , FormInfoVOMeta.SORT_TYPE , FormInfoVOMeta.DATA_ORIGIN , FormInfoVOMeta.QUERY_LOGIC , FormInfoVOMeta.REQUEST_ACTION , FormInfoVOMeta.IDS } )
	@SentinelResource(value = FormInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.UPDATE)
	public Result update(FormInfoVO formInfoVO) {
		
		Result result=formInfoService.update(formInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存表单信息
	*/
	@ApiOperation(value = "保存表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "712591748785766400"),
		@ApiImplicitParam(name = FormInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.CATALOG_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单测试"),
		@ApiImplicitParam(name = FormInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = FormInfoVOMeta.ROUTE , value = "路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),

	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FormInfoVOMeta.PAGE_INDEX , FormInfoVOMeta.PAGE_SIZE , FormInfoVOMeta.SEARCH_FIELD , FormInfoVOMeta.FUZZY_FIELD , FormInfoVOMeta.SEARCH_VALUE , FormInfoVOMeta.DIRTY_FIELDS , FormInfoVOMeta.SORT_FIELD , FormInfoVOMeta.SORT_TYPE , FormInfoVOMeta.DATA_ORIGIN , FormInfoVOMeta.QUERY_LOGIC , FormInfoVOMeta.REQUEST_ACTION , FormInfoVOMeta.IDS } )
	@SentinelResource(value = FormInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.SAVE)
	public Result save(FormInfoVO formInfoVO) {
		
		Result result=formInfoService.save(formInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取表单信息
	*/
	@ApiOperation(value = "获取表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.GET_BY_ID)
	public Result<FormInfo> getById(String id) {
		
		Result<FormInfo> result=new Result<>();
		FormInfo formInfo=formInfoService.getById(id);
		// join 关联的对象
		formInfoService.dao().fill(formInfo)
			.with(FormInfoMeta.FORM_CATEGORY)
			.execute();
		result.success(true).data(formInfo);
		return result;
	}


	/**
	 * 批量获取表单信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取表单信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FormInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = FormInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.GET_BY_IDS)
	public Result<List<FormInfo>> getByIds(List<String> ids) {
		
		Result<List<FormInfo>> result=new Result<>();
		List<FormInfo> list=formInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询表单信息
	*/
	@ApiOperation(value = "查询表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "712591748785766400"),
		@ApiImplicitParam(name = FormInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.CATALOG_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单测试"),
		@ApiImplicitParam(name = FormInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = FormInfoVOMeta.ROUTE , value = "路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FormInfoVOMeta.PAGE_INDEX , FormInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FormInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.QUERY_LIST)
	public Result<List<FormInfo>> queryList(FormInfoVO sample) {
		
		Result<List<FormInfo>> result=new Result<>();
		List<FormInfo> list=formInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询表单信息
	*/
	@ApiOperation(value = "分页查询表单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "712591748785766400"),
		@ApiImplicitParam(name = FormInfoVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.CATALOG_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单测试"),
		@ApiImplicitParam(name = FormInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = FormInfoVOMeta.ROUTE , value = "路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FormInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<FormInfo>> queryPagedList(FormInfoVO sample) {
		
		Result<PagedList<FormInfo>> result=new Result<>();
		PagedList<FormInfo> list=formInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		formInfoService.dao().fill(list)
			.with(FormInfoMeta.FORM_CATEGORY)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 获取表单信息
	 */
	@ApiOperation(value = "获取表单信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.COPY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.COPY_DATA)
	public Result copyData(String id) {

		return formInfoService.copyData(id);
	}




	/**
	 * 创建Form<br>
	 *
	 */
	@ApiOperation(value = "创建Form")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键清单" , required = true , dataTypeClass=List.class , example = "value")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.CREATE_FORM, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.CREATE_FORM)
	public Result<FormData> createForm(String id) {
		return formInfoService.createForm(id);
	}


	/**
	 * 创建Form<br>
	 *
	 */
	@ApiOperation(value = "创建Form")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FormInfoVOMeta.ID , value = "主键清单" , required = true , dataTypeClass=List.class , example = "value")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.CREATE_FORM_BY_CODE, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.CREATE_FORM_BY_CODE)
	public Result<FormData> createFormByCode(String id) {
		return formInfoService.createFormByCode(id);
	}

	/**
	 * 保存Form<br>
	 *
	 */
	@ApiOperation(value = "保存Form")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = FormDataVOMeta.OWNER_ID , value = "业务归属" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = FormDataVOMeta.DEF_ID , value = "表单定义" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = FormDataVOMeta.FORM_ID , value = "表单" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = FormDataVOMeta.DESIGNER_DATA , value = "设计" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = FormDataVOMeta.DATA , value = "数据" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = FormDataVOMeta.FORM_STATUS , value = "表单状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FormInfoServiceProxy.SAVE_FORM_DATA, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FormInfoServiceProxy.SAVE_FORM_DATA)
	public Result saveFormData(FormDataVO formDataVO) {
		return formInfoService.saveFormData(formDataVO);
	}




}