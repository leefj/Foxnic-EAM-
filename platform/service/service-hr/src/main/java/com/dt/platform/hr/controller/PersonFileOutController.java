package com.dt.platform.hr.controller;

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


import com.dt.platform.proxy.hr.PersonFileOutServiceProxy;
import com.dt.platform.domain.hr.meta.PersonFileOutVOMeta;
import com.dt.platform.domain.hr.PersonFileOut;
import com.dt.platform.domain.hr.PersonFileOutVO;
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
import com.dt.platform.domain.hr.meta.PersonFileOutMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonFileOutService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 档案调出接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 21:13:26
*/

@InDoc
@Api(tags = "档案调出")
@RestController("HrPersonFileOutController")
public class PersonFileOutController extends SuperController {

	@Autowired
	private IPersonFileOutService personFileOutService;

	/**
	 * 添加档案调出
	*/
	@ApiOperation(value = "添加档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717468232000208896"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.FILE_ID , value = "档案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.OUT_DATE , value = "调出时间" , required = false , dataTypeClass=String.class , example = "2023-00-29"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileOutServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.INSERT)
	public Result insert(PersonFileOutVO personFileOutVO) {
		
		Result result=personFileOutService.insert(personFileOutVO,false);
		return result;
	}



	/**
	 * 删除档案调出
	*/
	@ApiOperation(value = "删除档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717468232000208896")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileOutServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personFileOutService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personFileOutService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除档案调出 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonFileOutServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personFileOutService.hasRefers(ids);
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
			Result result=personFileOutService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personFileOutService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新档案调出
	*/
	@ApiOperation(value = "更新档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717468232000208896"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.FILE_ID , value = "档案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.OUT_DATE , value = "调出时间" , required = false , dataTypeClass=String.class , example = "2023-00-29"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonFileOutVOMeta.PAGE_INDEX , PersonFileOutVOMeta.PAGE_SIZE , PersonFileOutVOMeta.SEARCH_FIELD , PersonFileOutVOMeta.FUZZY_FIELD , PersonFileOutVOMeta.SEARCH_VALUE , PersonFileOutVOMeta.DIRTY_FIELDS , PersonFileOutVOMeta.SORT_FIELD , PersonFileOutVOMeta.SORT_TYPE , PersonFileOutVOMeta.DATA_ORIGIN , PersonFileOutVOMeta.QUERY_LOGIC , PersonFileOutVOMeta.REQUEST_ACTION , PersonFileOutVOMeta.IDS } )
	@SentinelResource(value = PersonFileOutServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.UPDATE)
	public Result update(PersonFileOutVO personFileOutVO) {
		
		Result result=personFileOutService.update(personFileOutVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存档案调出
	*/
	@ApiOperation(value = "保存档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717468232000208896"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.FILE_ID , value = "档案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.OUT_DATE , value = "调出时间" , required = false , dataTypeClass=String.class , example = "2023-00-29"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonFileOutVOMeta.PAGE_INDEX , PersonFileOutVOMeta.PAGE_SIZE , PersonFileOutVOMeta.SEARCH_FIELD , PersonFileOutVOMeta.FUZZY_FIELD , PersonFileOutVOMeta.SEARCH_VALUE , PersonFileOutVOMeta.DIRTY_FIELDS , PersonFileOutVOMeta.SORT_FIELD , PersonFileOutVOMeta.SORT_TYPE , PersonFileOutVOMeta.DATA_ORIGIN , PersonFileOutVOMeta.QUERY_LOGIC , PersonFileOutVOMeta.REQUEST_ACTION , PersonFileOutVOMeta.IDS } )
	@SentinelResource(value = PersonFileOutServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.SAVE)
	public Result save(PersonFileOutVO personFileOutVO) {
		
		Result result=personFileOutService.save(personFileOutVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取档案调出
	*/
	@ApiOperation(value = "获取档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileOutServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.GET_BY_ID)
	public Result<PersonFileOut> getById(String id) {
		
		Result<PersonFileOut> result=new Result<>();
		PersonFileOut personFileOut=personFileOutService.getById(id);
		result.success(true).data(personFileOut);
		return result;
	}

	/**
	 * 获取档案调出
	 */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileOutServiceProxy.CONFIRM , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.CONFIRM)
	public Result confirm(String id) {
		return personFileOutService.confirm(id);
	}


	/**
	 * 批量获取档案调出 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取档案调出")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonFileOutVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonFileOutServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.GET_BY_IDS)
	public Result<List<PersonFileOut>> getByIds(List<String> ids) {
		
		Result<List<PersonFileOut>> result=new Result<>();
		List<PersonFileOut> list=personFileOutService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询档案调出
	*/
	@ApiOperation(value = "查询档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717468232000208896"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.FILE_ID , value = "档案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.OUT_DATE , value = "调出时间" , required = false , dataTypeClass=String.class , example = "2023-00-29"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonFileOutVOMeta.PAGE_INDEX , PersonFileOutVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonFileOutServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.QUERY_LIST)
	public Result<List<PersonFileOut>> queryList(PersonFileOutVO sample) {
		
		Result<List<PersonFileOut>> result=new Result<>();
		List<PersonFileOut> list=personFileOutService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询档案调出
	*/
	@ApiOperation(value = "分页查询档案调出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "717468232000208896"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.FILE_ID , value = "档案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileOutVOMeta.OUT_DATE , value = "调出时间" , required = false , dataTypeClass=String.class , example = "2023-00-29"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonFileOutVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileOutServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileOutServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonFileOut>> queryPagedList(PersonFileOutVO sample) {
		
		Result<PagedList<PersonFileOut>> result=new Result<>();
		PagedList<PersonFileOut> list=personFileOutService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}