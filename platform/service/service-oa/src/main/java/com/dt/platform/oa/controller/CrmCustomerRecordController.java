package com.dt.platform.oa.controller;

import java.util.*;

import com.dt.platform.domain.oa.CrmCustomerFollow;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.oa.CrmCustomerRecordServiceProxy;
import com.dt.platform.domain.oa.meta.CrmCustomerRecordVOMeta;
import com.dt.platform.domain.oa.CrmCustomerRecord;
import com.dt.platform.domain.oa.CrmCustomerRecordVO;
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
import com.dt.platform.domain.oa.meta.CrmCustomerRecordMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.ICrmCustomerRecordService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 历史记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-15 14:15:26
*/

@InDoc
@Api(tags = "历史记录")
@RestController("OaCrmCustomerRecordController")
public class CrmCustomerRecordController extends SuperController {

	@Autowired
	private ICrmCustomerRecordService crmCustomerRecordService;

	/**
	 * 添加历史记录
	*/
	@ApiOperation(value = "添加历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerRecordServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.INSERT)
	public Result insert(CrmCustomerRecordVO crmCustomerRecordVO) {
		
		Result result=crmCustomerRecordService.insert(crmCustomerRecordVO,false);
		return result;
	}



	/**
	 * 删除历史记录
	*/
	@ApiOperation(value = "删除历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerRecordServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  crmCustomerRecordService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=crmCustomerRecordService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除历史记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CrmCustomerRecordServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = crmCustomerRecordService.hasRefers(ids);
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
			Result result=crmCustomerRecordService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=crmCustomerRecordService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新历史记录
	*/
	@ApiOperation(value = "更新历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerRecordVOMeta.PAGE_INDEX , CrmCustomerRecordVOMeta.PAGE_SIZE , CrmCustomerRecordVOMeta.SEARCH_FIELD , CrmCustomerRecordVOMeta.FUZZY_FIELD , CrmCustomerRecordVOMeta.SEARCH_VALUE , CrmCustomerRecordVOMeta.DIRTY_FIELDS , CrmCustomerRecordVOMeta.SORT_FIELD , CrmCustomerRecordVOMeta.SORT_TYPE , CrmCustomerRecordVOMeta.DATA_ORIGIN , CrmCustomerRecordVOMeta.QUERY_LOGIC , CrmCustomerRecordVOMeta.REQUEST_ACTION , CrmCustomerRecordVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerRecordServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.UPDATE)
	public Result update(CrmCustomerRecordVO crmCustomerRecordVO) {
		
		Result result=crmCustomerRecordService.update(crmCustomerRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存历史记录
	*/
	@ApiOperation(value = "保存历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CrmCustomerRecordVOMeta.PAGE_INDEX , CrmCustomerRecordVOMeta.PAGE_SIZE , CrmCustomerRecordVOMeta.SEARCH_FIELD , CrmCustomerRecordVOMeta.FUZZY_FIELD , CrmCustomerRecordVOMeta.SEARCH_VALUE , CrmCustomerRecordVOMeta.DIRTY_FIELDS , CrmCustomerRecordVOMeta.SORT_FIELD , CrmCustomerRecordVOMeta.SORT_TYPE , CrmCustomerRecordVOMeta.DATA_ORIGIN , CrmCustomerRecordVOMeta.QUERY_LOGIC , CrmCustomerRecordVOMeta.REQUEST_ACTION , CrmCustomerRecordVOMeta.IDS } )
	@SentinelResource(value = CrmCustomerRecordServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.SAVE)
	public Result save(CrmCustomerRecordVO crmCustomerRecordVO) {
		
		Result result=crmCustomerRecordService.save(crmCustomerRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取历史记录
	*/
	@ApiOperation(value = "获取历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerRecordServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.GET_BY_ID)
	public Result<CrmCustomerRecord> getById(String id) {
		
		Result<CrmCustomerRecord> result=new Result<>();
		CrmCustomerRecord crmCustomerRecord=crmCustomerRecordService.getById(id);
		// join 关联的对象
		crmCustomerRecordService.dao().fill(crmCustomerRecord)
			.with("originator")
			.with(CrmCustomerRecordMeta.CRM_CUSTOMER)

			.execute();

		crmCustomerRecordService.dao().join(crmCustomerRecord.getOriginator(), Person.class);

		result.success(true).data(crmCustomerRecord);
		return result;
	}


	/**
	 * 批量获取历史记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取历史记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CrmCustomerRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CrmCustomerRecordServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.GET_BY_IDS)
	public Result<List<CrmCustomerRecord>> getByIds(List<String> ids) {
		
		Result<List<CrmCustomerRecord>> result=new Result<>();
		List<CrmCustomerRecord> list=crmCustomerRecordService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询历史记录
	*/
	@ApiOperation(value = "查询历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CrmCustomerRecordVOMeta.PAGE_INDEX , CrmCustomerRecordVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CrmCustomerRecordServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.QUERY_LIST)
	public Result<List<CrmCustomerRecord>> queryList(CrmCustomerRecordVO sample) {
		
		Result<List<CrmCustomerRecord>> result=new Result<>();
		List<CrmCustomerRecord> list=crmCustomerRecordService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询历史记录
	*/
	@ApiOperation(value = "分页查询历史记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CUSTOMER_ID , value = "客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CrmCustomerRecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CrmCustomerRecordServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CrmCustomerRecordServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CrmCustomerRecord>> queryPagedList(CrmCustomerRecordVO sample) {
		
		Result<PagedList<CrmCustomerRecord>> result=new Result<>();
		PagedList<CrmCustomerRecord> list=crmCustomerRecordService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		crmCustomerRecordService.dao().fill(list)
			.with("originator")
			.with(CrmCustomerRecordMeta.CRM_CUSTOMER)
			.execute();

		List<Employee> owners = CollectorUtil.collectList(list, CrmCustomerRecord::getOriginator);
		crmCustomerRecordService.dao().join(owners, Person.class);


		result.success(true).data(list);
		return result;
	}





}