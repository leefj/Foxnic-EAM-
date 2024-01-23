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


import com.dt.platform.proxy.hr.PersonTransferServiceProxy;
import com.dt.platform.domain.hr.meta.PersonTransferVOMeta;
import com.dt.platform.domain.hr.PersonTransfer;
import com.dt.platform.domain.hr.PersonTransferVO;
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
import com.dt.platform.domain.hr.meta.PersonTransferMeta;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.Position;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonTransferService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 员工调动接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-23 20:08:38
*/

@InDoc
@Api(tags = "员工调动")
@RestController("HrPersonTransferController")
public class PersonTransferController extends SuperController {

	@Autowired
	private IPersonTransferService personTransferService;

	/**
	 * 添加员工调动
	*/
	@ApiOperation(value = "添加员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801816370407800832"),
		@ApiImplicitParam(name = PersonTransferVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class , example = "2024-01-10 12:00:00"),
		@ApiImplicitParam(name = PersonTransferVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonTransferVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonTransferVOMeta.POSITION_CODE , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = PersonTransferVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.INSERT)
	public Result insert(PersonTransferVO personTransferVO) {
		
		Result result=personTransferService.insert(personTransferVO,false);
		return result;
	}



	/**
	 * 删除员工调动
	*/
	@ApiOperation(value = "删除员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801816370407800832")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personTransferService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personTransferService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除员工调动 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonTransferServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personTransferService.hasRefers(ids);
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
			Result result=personTransferService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personTransferService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新员工调动
	*/
	@ApiOperation(value = "更新员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801816370407800832"),
		@ApiImplicitParam(name = PersonTransferVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class , example = "2024-01-10 12:00:00"),
		@ApiImplicitParam(name = PersonTransferVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonTransferVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonTransferVOMeta.POSITION_CODE , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = PersonTransferVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonTransferVOMeta.PAGE_INDEX , PersonTransferVOMeta.PAGE_SIZE , PersonTransferVOMeta.SEARCH_FIELD , PersonTransferVOMeta.FUZZY_FIELD , PersonTransferVOMeta.SEARCH_VALUE , PersonTransferVOMeta.DIRTY_FIELDS , PersonTransferVOMeta.SORT_FIELD , PersonTransferVOMeta.SORT_TYPE , PersonTransferVOMeta.DATA_ORIGIN , PersonTransferVOMeta.QUERY_LOGIC , PersonTransferVOMeta.REQUEST_ACTION , PersonTransferVOMeta.IDS } )
	@SentinelResource(value = PersonTransferServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.UPDATE)
	public Result update(PersonTransferVO personTransferVO) {
		
		Result result=personTransferService.update(personTransferVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存员工调动
	*/
	@ApiOperation(value = "保存员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801816370407800832"),
		@ApiImplicitParam(name = PersonTransferVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class , example = "2024-01-10 12:00:00"),
		@ApiImplicitParam(name = PersonTransferVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonTransferVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonTransferVOMeta.POSITION_CODE , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = PersonTransferVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonTransferVOMeta.PAGE_INDEX , PersonTransferVOMeta.PAGE_SIZE , PersonTransferVOMeta.SEARCH_FIELD , PersonTransferVOMeta.FUZZY_FIELD , PersonTransferVOMeta.SEARCH_VALUE , PersonTransferVOMeta.DIRTY_FIELDS , PersonTransferVOMeta.SORT_FIELD , PersonTransferVOMeta.SORT_TYPE , PersonTransferVOMeta.DATA_ORIGIN , PersonTransferVOMeta.QUERY_LOGIC , PersonTransferVOMeta.REQUEST_ACTION , PersonTransferVOMeta.IDS } )
	@SentinelResource(value = PersonTransferServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.SAVE)
	public Result save(PersonTransferVO personTransferVO) {
		
		Result result=personTransferService.save(personTransferVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取员工调动
	*/
	@ApiOperation(value = "获取员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.GET_BY_ID)
	public Result<PersonTransfer> getById(String id) {
		
		Result<PersonTransfer> result=new Result<>();
		PersonTransfer personTransfer=personTransferService.getById(id);
		// join 关联的对象
		personTransferService.dao().fill(personTransfer)
			.with("organization")
			.with(PersonTransferMeta.PERSON_LIST)
			.with(PersonTransferMeta.POSITION)
			.execute();
		result.success(true).data(personTransfer);
		return result;
	}



	@ApiOperation(value = "确认")
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferServiceProxy.ACTION_SURE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.ACTION_SURE)
	public Result sure(String id) {
		return personTransferService.sure(id);
	}

	@ApiOperation(value = "取消")
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferServiceProxy.ACTION_CANCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.ACTION_CANCEL)
	public Result cancel(String id) {
		return personTransferService.cancel(id);
	}

	/**
	 * 批量获取员工调动 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取员工调动")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonTransferVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonTransferServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.GET_BY_IDS)
	public Result<List<PersonTransfer>> getByIds(List<String> ids) {
		
		Result<List<PersonTransfer>> result=new Result<>();
		List<PersonTransfer> list=personTransferService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询员工调动
	*/
	@ApiOperation(value = "查询员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801816370407800832"),
		@ApiImplicitParam(name = PersonTransferVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class , example = "2024-01-10 12:00:00"),
		@ApiImplicitParam(name = PersonTransferVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonTransferVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonTransferVOMeta.POSITION_CODE , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = PersonTransferVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonTransferVOMeta.PAGE_INDEX , PersonTransferVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonTransferServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.QUERY_LIST)
	public Result<List<PersonTransfer>> queryList(PersonTransferVO sample) {
		
		Result<List<PersonTransfer>> result=new Result<>();
		List<PersonTransfer> list=personTransferService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询员工调动
	*/
	@ApiOperation(value = "分页查询员工调动")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonTransferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "801816370407800832"),
		@ApiImplicitParam(name = PersonTransferVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.TRANSFER_DATE , value = "调动日期" , required = false , dataTypeClass=Date.class , example = "2024-01-10 12:00:00"),
		@ApiImplicitParam(name = PersonTransferVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PersonTransferVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class , example = "788871090188320766"),
		@ApiImplicitParam(name = PersonTransferVOMeta.POSITION_CODE , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = PersonTransferVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonTransferVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonTransferServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonTransferServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonTransfer>> queryPagedList(PersonTransferVO sample) {
		
		Result<PagedList<PersonTransfer>> result=new Result<>();
		PagedList<PersonTransfer> list=personTransferService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personTransferService.dao().fill(list)
			.with("organization")
			.with(PersonTransferMeta.PERSON_LIST)
			.with(PersonTransferMeta.POSITION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}