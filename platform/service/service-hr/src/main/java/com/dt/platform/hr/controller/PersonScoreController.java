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


import com.dt.platform.proxy.hr.PersonScoreServiceProxy;
import com.dt.platform.domain.hr.meta.PersonScoreVOMeta;
import com.dt.platform.domain.hr.PersonScore;
import com.dt.platform.domain.hr.PersonScoreVO;
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
import com.dt.platform.domain.hr.meta.PersonScoreMeta;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonScoreService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 积分明细接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:36
*/

@InDoc
@Api(tags = "积分明细")
@RestController("HrPersonScoreController")
public class PersonScoreController extends SuperController {

	@Autowired
	private IPersonScoreService personScoreService;

	/**
	 * 添加积分明细
	*/
	@ApiOperation(value = "添加积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_TYPE_ID , value = "操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.SCORE , value = "积分" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonScoreServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.INSERT)
	public Result insert(PersonScoreVO personScoreVO) {
		
		Result result=personScoreService.insert(personScoreVO,false);
		return result;
	}



	/**
	 * 删除积分明细
	*/
	@ApiOperation(value = "删除积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonScoreServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personScoreService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personScoreService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除积分明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonScoreServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personScoreService.hasRefers(ids);
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
			Result result=personScoreService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personScoreService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新积分明细
	*/
	@ApiOperation(value = "更新积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_TYPE_ID , value = "操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.SCORE , value = "积分" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonScoreVOMeta.PAGE_INDEX , PersonScoreVOMeta.PAGE_SIZE , PersonScoreVOMeta.SEARCH_FIELD , PersonScoreVOMeta.FUZZY_FIELD , PersonScoreVOMeta.SEARCH_VALUE , PersonScoreVOMeta.DIRTY_FIELDS , PersonScoreVOMeta.SORT_FIELD , PersonScoreVOMeta.SORT_TYPE , PersonScoreVOMeta.DATA_ORIGIN , PersonScoreVOMeta.QUERY_LOGIC , PersonScoreVOMeta.REQUEST_ACTION , PersonScoreVOMeta.IDS } )
	@SentinelResource(value = PersonScoreServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.UPDATE)
	public Result update(PersonScoreVO personScoreVO) {
		
		Result result=personScoreService.update(personScoreVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存积分明细
	*/
	@ApiOperation(value = "保存积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_TYPE_ID , value = "操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.SCORE , value = "积分" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonScoreVOMeta.PAGE_INDEX , PersonScoreVOMeta.PAGE_SIZE , PersonScoreVOMeta.SEARCH_FIELD , PersonScoreVOMeta.FUZZY_FIELD , PersonScoreVOMeta.SEARCH_VALUE , PersonScoreVOMeta.DIRTY_FIELDS , PersonScoreVOMeta.SORT_FIELD , PersonScoreVOMeta.SORT_TYPE , PersonScoreVOMeta.DATA_ORIGIN , PersonScoreVOMeta.QUERY_LOGIC , PersonScoreVOMeta.REQUEST_ACTION , PersonScoreVOMeta.IDS } )
	@SentinelResource(value = PersonScoreServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.SAVE)
	public Result save(PersonScoreVO personScoreVO) {
		
		Result result=personScoreService.save(personScoreVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取积分明细
	*/
	@ApiOperation(value = "获取积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonScoreServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.GET_BY_ID)
	public Result<PersonScore> getById(String id) {
		
		Result<PersonScore> result=new Result<>();
		PersonScore personScore=personScoreService.getById(id);
		// join 关联的对象
		personScoreService.dao().fill(personScore)
			.with("person")
			.execute();
		result.success(true).data(personScore);
		return result;
	}


	/**
	 * 批量获取积分明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取积分明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonScoreVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonScoreServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.GET_BY_IDS)
	public Result<List<PersonScore>> getByIds(List<String> ids) {
		
		Result<List<PersonScore>> result=new Result<>();
		List<PersonScore> list=personScoreService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询积分明细
	*/
	@ApiOperation(value = "查询积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_TYPE_ID , value = "操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.SCORE , value = "积分" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonScoreVOMeta.PAGE_INDEX , PersonScoreVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonScoreServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.QUERY_LIST)
	public Result<List<PersonScore>> queryList(PersonScoreVO sample) {
		
		Result<List<PersonScore>> result=new Result<>();
		List<PersonScore> list=personScoreService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询积分明细
	*/
	@ApiOperation(value = "分页查询积分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonScoreVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_TYPE_ID , value = "操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.SCORE , value = "积分" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonScoreVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonScoreServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonScoreServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonScore>> queryPagedList(PersonScoreVO sample) {
		
		Result<PagedList<PersonScore>> result=new Result<>();
		PagedList<PersonScore> list=personScoreService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personScoreService.dao().fill(list)
			.with("person")
			.execute();
		result.success(true).data(list);
		return result;
	}





}