package com.dt.platform.common.controller;

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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.dt.platform.proxy.common.BpmFormDataServiceProxy;
import com.dt.platform.domain.common.meta.BpmFormDataVOMeta;
import com.dt.platform.domain.common.BpmFormData;
import com.dt.platform.domain.common.BpmFormDataVO;
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
import com.dt.platform.domain.common.meta.BpmFormDataMeta;
import com.dt.platform.domain.common.FormData;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IBpmFormDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 流程表单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-25 16:11:26
*/

@InDoc
@Api(tags = "流程表单")
@RestController("SysBpmFormDataController")
public class BpmFormDataController extends SuperController implements BpmCallbackController{

	@Autowired
	private IBpmFormDataService bpmFormDataService;

	/**
	 * 添加流程表单
	*/
	@ApiOperation(value = "添加流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "714139812184981504"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_ID , value = "表单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "714139760699899904"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BpmFormDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.INSERT)
	public Result insert(BpmFormDataVO bpmFormDataVO) {
		
		Result result=bpmFormDataService.insert(bpmFormDataVO,false);
		return result;
	}



	/**
	 * 删除流程表单
	*/
	@ApiOperation(value = "删除流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "714139812184981504")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BpmFormDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  bpmFormDataService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=bpmFormDataService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除流程表单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = BpmFormDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = bpmFormDataService.hasRefers(ids);
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
			Result result=bpmFormDataService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=bpmFormDataService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新流程表单
	*/
	@ApiOperation(value = "更新流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "714139812184981504"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_ID , value = "表单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "714139760699899904"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BpmFormDataVOMeta.PAGE_INDEX , BpmFormDataVOMeta.PAGE_SIZE , BpmFormDataVOMeta.SEARCH_FIELD , BpmFormDataVOMeta.FUZZY_FIELD , BpmFormDataVOMeta.SEARCH_VALUE , BpmFormDataVOMeta.DIRTY_FIELDS , BpmFormDataVOMeta.SORT_FIELD , BpmFormDataVOMeta.SORT_TYPE , BpmFormDataVOMeta.DATA_ORIGIN , BpmFormDataVOMeta.QUERY_LOGIC , BpmFormDataVOMeta.REQUEST_ACTION , BpmFormDataVOMeta.IDS } )
	@SentinelResource(value = BpmFormDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.UPDATE)
	public Result update(BpmFormDataVO bpmFormDataVO) {
		
		Result result=bpmFormDataService.update(bpmFormDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存流程表单
	*/
	@ApiOperation(value = "保存流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "714139812184981504"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_ID , value = "表单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "714139760699899904"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BpmFormDataVOMeta.PAGE_INDEX , BpmFormDataVOMeta.PAGE_SIZE , BpmFormDataVOMeta.SEARCH_FIELD , BpmFormDataVOMeta.FUZZY_FIELD , BpmFormDataVOMeta.SEARCH_VALUE , BpmFormDataVOMeta.DIRTY_FIELDS , BpmFormDataVOMeta.SORT_FIELD , BpmFormDataVOMeta.SORT_TYPE , BpmFormDataVOMeta.DATA_ORIGIN , BpmFormDataVOMeta.QUERY_LOGIC , BpmFormDataVOMeta.REQUEST_ACTION , BpmFormDataVOMeta.IDS } )
	@SentinelResource(value = BpmFormDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.SAVE)
	public Result save(BpmFormDataVO bpmFormDataVO) {
		
		Result result=bpmFormDataService.save(bpmFormDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取流程表单
	*/
	@ApiOperation(value = "获取流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BpmFormDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.GET_BY_ID)
	public Result<BpmFormData> getById(String id) {
		
		Result<BpmFormData> result=new Result<>();
		BpmFormData bpmFormData=bpmFormDataService.getById(id);
		// 填充流程相关的属性
		bpmFormDataService.joinProcess(bpmFormData);
		result.success(true).data(bpmFormData);
		return result;
	}


	/**
	 * 批量获取流程表单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取流程表单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BpmFormDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = BpmFormDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.GET_BY_IDS)
	public Result<List<BpmFormData>> getByIds(List<String> ids) {
		
		Result<List<BpmFormData>> result=new Result<>();
		List<BpmFormData> list=bpmFormDataService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询流程表单
	*/
	@ApiOperation(value = "查询流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "714139812184981504"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_ID , value = "表单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "714139760699899904"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BpmFormDataVOMeta.PAGE_INDEX , BpmFormDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BpmFormDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.QUERY_LIST)
	public Result<List<BpmFormData>> queryList(BpmFormDataVO sample) {
		
		Result<List<BpmFormData>> result=new Result<>();
		List<BpmFormData> list=bpmFormDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询流程表单
	*/
	@ApiOperation(value = "分页查询流程表单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BpmFormDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "714139812184981504"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_ID , value = "表单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BpmFormDataVOMeta.FORM_DATA_ID , value = "数据" , required = false , dataTypeClass=String.class , example = "714139760699899904"),
		@ApiImplicitParam(name = BpmFormDataVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BpmFormDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BpmFormData>> queryPagedList(BpmFormDataVO sample) {
		
		Result<PagedList<BpmFormData>> result=new Result<>();
		PagedList<BpmFormData> list=bpmFormDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 填充流程相关的属性
		bpmFormDataService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = BpmFormDataServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BpmFormDataServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return bpmFormDataService.onProcessCallback(event);
	}



}