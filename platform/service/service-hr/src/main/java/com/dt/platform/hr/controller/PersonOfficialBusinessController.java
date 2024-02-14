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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.dt.platform.proxy.hr.PersonOfficialBusinessServiceProxy;
import com.dt.platform.domain.hr.meta.PersonOfficialBusinessVOMeta;
import com.dt.platform.domain.hr.PersonOfficialBusiness;
import com.dt.platform.domain.hr.PersonOfficialBusinessVO;
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
import com.dt.platform.domain.hr.meta.PersonOfficialBusinessMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonOfficialBusinessService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 出差申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:10:56
*/

@InDoc
@Api(tags = "出差申请")
@RestController("HrPersonOfficialBusinessController")
public class PersonOfficialBusinessController extends SuperController implements BpmCallbackController{

	@Autowired
	private IPersonOfficialBusinessService personOfficialBusinessService;

	/**
	 * 添加出差申请
	*/
	@ApiOperation(value = "添加出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LEAVE_DATE , value = "出差日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LOCATION , value = "地点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.DAYS , value = "天数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.MONEY , value = "申请费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.INSERT)
	public Result insert(PersonOfficialBusinessVO personOfficialBusinessVO) {
		
		Result result=personOfficialBusinessService.insert(personOfficialBusinessVO,false);
		return result;
	}



	/**
	 * 删除出差申请
	*/
	@ApiOperation(value = "删除出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personOfficialBusinessService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personOfficialBusinessService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除出差申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personOfficialBusinessService.hasRefers(ids);
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
			Result result=personOfficialBusinessService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personOfficialBusinessService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新出差申请
	*/
	@ApiOperation(value = "更新出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LEAVE_DATE , value = "出差日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LOCATION , value = "地点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.DAYS , value = "天数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.MONEY , value = "申请费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonOfficialBusinessVOMeta.PAGE_INDEX , PersonOfficialBusinessVOMeta.PAGE_SIZE , PersonOfficialBusinessVOMeta.SEARCH_FIELD , PersonOfficialBusinessVOMeta.FUZZY_FIELD , PersonOfficialBusinessVOMeta.SEARCH_VALUE , PersonOfficialBusinessVOMeta.DIRTY_FIELDS , PersonOfficialBusinessVOMeta.SORT_FIELD , PersonOfficialBusinessVOMeta.SORT_TYPE , PersonOfficialBusinessVOMeta.DATA_ORIGIN , PersonOfficialBusinessVOMeta.QUERY_LOGIC , PersonOfficialBusinessVOMeta.REQUEST_ACTION , PersonOfficialBusinessVOMeta.IDS } )
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.UPDATE)
	public Result update(PersonOfficialBusinessVO personOfficialBusinessVO) {
		
		Result result=personOfficialBusinessService.update(personOfficialBusinessVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存出差申请
	*/
	@ApiOperation(value = "保存出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LEAVE_DATE , value = "出差日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LOCATION , value = "地点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.DAYS , value = "天数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.MONEY , value = "申请费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonOfficialBusinessVOMeta.PAGE_INDEX , PersonOfficialBusinessVOMeta.PAGE_SIZE , PersonOfficialBusinessVOMeta.SEARCH_FIELD , PersonOfficialBusinessVOMeta.FUZZY_FIELD , PersonOfficialBusinessVOMeta.SEARCH_VALUE , PersonOfficialBusinessVOMeta.DIRTY_FIELDS , PersonOfficialBusinessVOMeta.SORT_FIELD , PersonOfficialBusinessVOMeta.SORT_TYPE , PersonOfficialBusinessVOMeta.DATA_ORIGIN , PersonOfficialBusinessVOMeta.QUERY_LOGIC , PersonOfficialBusinessVOMeta.REQUEST_ACTION , PersonOfficialBusinessVOMeta.IDS } )
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.SAVE)
	public Result save(PersonOfficialBusinessVO personOfficialBusinessVO) {
		
		Result result=personOfficialBusinessService.save(personOfficialBusinessVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取出差申请
	*/
	@ApiOperation(value = "获取出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.GET_BY_ID)
	public Result<PersonOfficialBusiness> getById(String id) {
		
		Result<PersonOfficialBusiness> result=new Result<>();
		PersonOfficialBusiness personOfficialBusiness=personOfficialBusinessService.getById(id);
		// join 关联的对象
		personOfficialBusinessService.dao().fill(personOfficialBusiness)
			.with("person")
			.execute();
		// 填充流程相关的属性
		personOfficialBusinessService.joinProcess(personOfficialBusiness);
		result.success(true).data(personOfficialBusiness);
		return result;
	}


	/**
	 * 批量获取出差申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取出差申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonOfficialBusinessServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.GET_BY_IDS)
	public Result<List<PersonOfficialBusiness>> getByIds(List<String> ids) {
		
		Result<List<PersonOfficialBusiness>> result=new Result<>();
		List<PersonOfficialBusiness> list=personOfficialBusinessService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询出差申请
	*/
	@ApiOperation(value = "查询出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LEAVE_DATE , value = "出差日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LOCATION , value = "地点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.DAYS , value = "天数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.MONEY , value = "申请费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonOfficialBusinessVOMeta.PAGE_INDEX , PersonOfficialBusinessVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.QUERY_LIST)
	public Result<List<PersonOfficialBusiness>> queryList(PersonOfficialBusinessVO sample) {
		
		Result<List<PersonOfficialBusiness>> result=new Result<>();
		List<PersonOfficialBusiness> list=personOfficialBusinessService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询出差申请
	*/
	@ApiOperation(value = "分页查询出差申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LEAVE_DATE , value = "出差日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.LOCATION , value = "地点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.DAYS , value = "天数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.MONEY , value = "申请费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonOfficialBusinessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonOfficialBusiness>> queryPagedList(PersonOfficialBusinessVO sample) {
		
		Result<PagedList<PersonOfficialBusiness>> result=new Result<>();
		PagedList<PersonOfficialBusiness> list=personOfficialBusinessService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personOfficialBusinessService.dao().fill(list)
			.with("person")
			.execute();
		// 填充流程相关的属性
		personOfficialBusinessService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = PersonOfficialBusinessServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonOfficialBusinessServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return personOfficialBusinessService.onProcessCallback(event);
	}



}