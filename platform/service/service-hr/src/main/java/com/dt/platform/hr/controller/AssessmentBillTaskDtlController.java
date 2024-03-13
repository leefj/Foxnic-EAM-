package com.dt.platform.hr.controller;

import java.util.*;

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


import com.dt.platform.proxy.hr.AssessmentBillTaskDtlServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlVOMeta;
import com.dt.platform.domain.hr.AssessmentBillTaskDtl;
import com.dt.platform.domain.hr.AssessmentBillTaskDtlVO;
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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentBillTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentBillTaskDtlService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务明细单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 13:29:03
*/

@InDoc
@Api(tags = "任务明细单")
@RestController("HrAssessmentBillTaskDtlController")
public class AssessmentBillTaskDtlController extends SuperController {

	@Autowired
	private IAssessmentBillTaskDtlService assessmentBillTaskDtlService;

	/**
	 * 添加任务明细单
	*/
	@ApiOperation(value = "添加任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "819858163200163840"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.BILL_TASK_ID , value = "单据" , required = false , dataTypeClass=String.class , example = "819286495167774720"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "wait"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "self"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class , example = "2024-03-12 09:03:38"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.INSERT)
	public Result insert(AssessmentBillTaskDtlVO assessmentBillTaskDtlVO) {
		
		Result result=assessmentBillTaskDtlService.insert(assessmentBillTaskDtlVO,false);
		return result;
	}



	/**
	 * 删除任务明细单
	*/
	@ApiOperation(value = "删除任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "819858163200163840")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assessmentBillTaskDtlService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assessmentBillTaskDtlService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务明细单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assessmentBillTaskDtlService.hasRefers(ids);
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
			Result result=assessmentBillTaskDtlService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assessmentBillTaskDtlService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务明细单
	*/
	@ApiOperation(value = "更新任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "819858163200163840"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.BILL_TASK_ID , value = "单据" , required = false , dataTypeClass=String.class , example = "819286495167774720"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "wait"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "self"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class , example = "2024-03-12 09:03:38"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentBillTaskDtlVOMeta.PAGE_INDEX , AssessmentBillTaskDtlVOMeta.PAGE_SIZE , AssessmentBillTaskDtlVOMeta.SEARCH_FIELD , AssessmentBillTaskDtlVOMeta.FUZZY_FIELD , AssessmentBillTaskDtlVOMeta.SEARCH_VALUE , AssessmentBillTaskDtlVOMeta.DIRTY_FIELDS , AssessmentBillTaskDtlVOMeta.SORT_FIELD , AssessmentBillTaskDtlVOMeta.SORT_TYPE , AssessmentBillTaskDtlVOMeta.DATA_ORIGIN , AssessmentBillTaskDtlVOMeta.QUERY_LOGIC , AssessmentBillTaskDtlVOMeta.REQUEST_ACTION , AssessmentBillTaskDtlVOMeta.IDS } )
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.UPDATE)
	public Result update(AssessmentBillTaskDtlVO assessmentBillTaskDtlVO) {
		
		Result result=assessmentBillTaskDtlService.update(assessmentBillTaskDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务明细单
	*/
	@ApiOperation(value = "保存任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "819858163200163840"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.BILL_TASK_ID , value = "单据" , required = false , dataTypeClass=String.class , example = "819286495167774720"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "wait"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "self"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class , example = "2024-03-12 09:03:38"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssessmentBillTaskDtlVOMeta.PAGE_INDEX , AssessmentBillTaskDtlVOMeta.PAGE_SIZE , AssessmentBillTaskDtlVOMeta.SEARCH_FIELD , AssessmentBillTaskDtlVOMeta.FUZZY_FIELD , AssessmentBillTaskDtlVOMeta.SEARCH_VALUE , AssessmentBillTaskDtlVOMeta.DIRTY_FIELDS , AssessmentBillTaskDtlVOMeta.SORT_FIELD , AssessmentBillTaskDtlVOMeta.SORT_TYPE , AssessmentBillTaskDtlVOMeta.DATA_ORIGIN , AssessmentBillTaskDtlVOMeta.QUERY_LOGIC , AssessmentBillTaskDtlVOMeta.REQUEST_ACTION , AssessmentBillTaskDtlVOMeta.IDS } )
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.SAVE)
	public Result save(AssessmentBillTaskDtlVO assessmentBillTaskDtlVO) {
		
		Result result=assessmentBillTaskDtlService.save(assessmentBillTaskDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务明细单
	*/
	@ApiOperation(value = "获取任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.GET_BY_ID)
	public Result<AssessmentBillTaskDtl> getById(String id) {
		
		Result<AssessmentBillTaskDtl> result=new Result<>();
		AssessmentBillTaskDtl assessmentBillTaskDtl=assessmentBillTaskDtlService.getById(id);
		// join 关联的对象
		assessmentBillTaskDtlService.dao().fill(assessmentBillTaskDtl)
			.with(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL_TASK)
			.execute();
		result.success(true).data(assessmentBillTaskDtl);
		return result;
	}

	/**
	 * 获取任务明细单
	 */
	@ApiOperation(value = "获取任务明细单")
	@ApiImplicitParams({
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.SUBMIT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.SUBMIT)
	public Result submit(String id) {
		return assessmentBillTaskDtlService.submit(id);
	}




	/**
	 * 批量获取任务明细单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务明细单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.GET_BY_IDS)
	public Result<List<AssessmentBillTaskDtl>> getByIds(List<String> ids) {
		
		Result<List<AssessmentBillTaskDtl>> result=new Result<>();
		List<AssessmentBillTaskDtl> list=assessmentBillTaskDtlService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务明细单
	*/
	@ApiOperation(value = "查询任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "819858163200163840"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.BILL_TASK_ID , value = "单据" , required = false , dataTypeClass=String.class , example = "819286495167774720"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "wait"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "self"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class , example = "2024-03-12 09:03:38"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentBillTaskDtlVOMeta.PAGE_INDEX , AssessmentBillTaskDtlVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.QUERY_LIST)
	public Result<List<AssessmentBillTaskDtl>> queryList(AssessmentBillTaskDtlVO sample) {
		
		Result<List<AssessmentBillTaskDtl>> result=new Result<>();
		List<AssessmentBillTaskDtl> list=assessmentBillTaskDtlService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务明细单
	*/
	@ApiOperation(value = "分页查询任务明细单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "819858163200163840"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.BILL_TASK_ID , value = "单据" , required = false , dataTypeClass=String.class , example = "819286495167774720"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "wait"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "self"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class , example = "2024-03-12 09:03:38"),
		@ApiImplicitParam(name = AssessmentBillTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskDtlServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskDtlServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssessmentBillTaskDtl>> queryPagedList(AssessmentBillTaskDtlVO sample) {
		
		Result<PagedList<AssessmentBillTaskDtl>> result=new Result<>();
		PagedList<AssessmentBillTaskDtl> list=assessmentBillTaskDtlService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assessmentBillTaskDtlService.dao().fill(list)
			.with(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL_TASK)
				.with(AssessmentBillTaskDtlMeta.WITH_LEADER_LIST)
				.with(AssessmentBillTaskDtlMeta.WITH_SAME_USER_LIST)
				.with(AssessmentBillTaskDtlMeta.WITH_SECOND_LEADER_LIST)
				.with(AssessmentBillTaskDtlMeta.WITH_SELF_USER)
			.execute();


		List<Employee> selfList = CollectorUtil.collectList(list, AssessmentBillTaskDtl::getWithSelfUser);
		assessmentBillTaskDtlService.dao().join(selfList, Person.class);

		List<List<Employee>> leaderListList = CollectorUtil.collectList(list, AssessmentBillTaskDtl::getWithLeaderList);
		List<Employee> leaderList = leaderListList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
		assessmentBillTaskDtlService.dao().join(leaderList, Person.class);

		List<List<Employee>> secondLeaderListList = CollectorUtil.collectList(list, AssessmentBillTaskDtl::getWithSecondLeaderList);
		List<Employee> secondLeaderList = secondLeaderListList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
		assessmentBillTaskDtlService.dao().join(secondLeaderList, Person.class);

		List<List<Employee>> sameUserListList = CollectorUtil.collectList(list, AssessmentBillTaskDtl::getWithSameUserList);
		List<Employee> sameUserList = sameUserListList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
		assessmentBillTaskDtlService.dao().join(sameUserList, Person.class);


		result.success(true).data(list);
		return result;
	}





}