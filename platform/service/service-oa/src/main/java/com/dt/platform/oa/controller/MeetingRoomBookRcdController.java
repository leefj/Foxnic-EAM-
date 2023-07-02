package com.dt.platform.oa.controller;

import java.util.*;


import com.alibaba.fastjson.JSONArray;
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


import com.dt.platform.proxy.oa.MeetingRoomBookRcdServiceProxy;
import com.dt.platform.domain.oa.meta.MeetingRoomBookRcdVOMeta;
import com.dt.platform.domain.oa.MeetingRoomBookRcd;
import com.dt.platform.domain.oa.MeetingRoomBookRcdVO;
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
import com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta;
import com.dt.platform.domain.oa.MeetingRoom;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IMeetingRoomBookRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 会议室预定接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 21:40:41
*/

@InDoc
@Api(tags = "会议室预定")
@RestController("OaMeetingRoomBookRcdController")
public class MeetingRoomBookRcdController extends SuperController {

	@Autowired
	private IMeetingRoomBookRcdService meetingRoomBookRcdService;

	/**
	 * 添加会议室预定
	*/
	@ApiOperation(value = "添加会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ROOM_ID , value = "会议室" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ORG_ID , value = "预定部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.BOOKER_ID , value = "预定人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.USER_ID , value = "发起人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.INSERT)
	public Result insert(MeetingRoomBookRcdVO meetingRoomBookRcdVO) {
		
		Result result=meetingRoomBookRcdService.insert(meetingRoomBookRcdVO,false);
		return result;
	}



	/**
	 * 删除会议室预定
	*/
	@ApiOperation(value = "删除会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  meetingRoomBookRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=meetingRoomBookRcdService.deleteByIdLogical(id);
		return result;
	}




	/**
	 * 取消会议室预定
	 */
	@ApiOperation(value = "取消会议室预定")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.CANCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.CANCEL)
	public Result cancel(String id) {
		return meetingRoomBookRcdService.cancel(id);
	}

	/**
	 * 完成会议室预定
	 */
	@ApiOperation(value = "完成会议室预定")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.FINISH , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.FINISH)
	public Result finish(String id) {
		return meetingRoomBookRcdService.finish(id);
	}


	/**
	 * 确认会议室预定
	 */
	@ApiOperation(value = "确认会议室预定")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.SURE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.SURE)
	public Result sure(String id) {
		return meetingRoomBookRcdService.sure(id);
	}


	/**
	 * 批量删除会议室预定 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = meetingRoomBookRcdService.hasRefers(ids);
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
			Result result=meetingRoomBookRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=meetingRoomBookRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新会议室预定
	*/
	@ApiOperation(value = "更新会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ROOM_ID , value = "会议室" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ORG_ID , value = "预定部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.BOOKER_ID , value = "预定人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.USER_ID , value = "发起人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MeetingRoomBookRcdVOMeta.PAGE_INDEX , MeetingRoomBookRcdVOMeta.PAGE_SIZE , MeetingRoomBookRcdVOMeta.SEARCH_FIELD , MeetingRoomBookRcdVOMeta.FUZZY_FIELD , MeetingRoomBookRcdVOMeta.SEARCH_VALUE , MeetingRoomBookRcdVOMeta.DIRTY_FIELDS , MeetingRoomBookRcdVOMeta.SORT_FIELD , MeetingRoomBookRcdVOMeta.SORT_TYPE , MeetingRoomBookRcdVOMeta.DATA_ORIGIN , MeetingRoomBookRcdVOMeta.QUERY_LOGIC , MeetingRoomBookRcdVOMeta.REQUEST_ACTION , MeetingRoomBookRcdVOMeta.IDS } )
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.UPDATE)
	public Result update(MeetingRoomBookRcdVO meetingRoomBookRcdVO) {
		
		Result result=meetingRoomBookRcdService.update(meetingRoomBookRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存会议室预定
	*/
	@ApiOperation(value = "保存会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ROOM_ID , value = "会议室" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ORG_ID , value = "预定部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.BOOKER_ID , value = "预定人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.USER_ID , value = "发起人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MeetingRoomBookRcdVOMeta.PAGE_INDEX , MeetingRoomBookRcdVOMeta.PAGE_SIZE , MeetingRoomBookRcdVOMeta.SEARCH_FIELD , MeetingRoomBookRcdVOMeta.FUZZY_FIELD , MeetingRoomBookRcdVOMeta.SEARCH_VALUE , MeetingRoomBookRcdVOMeta.DIRTY_FIELDS , MeetingRoomBookRcdVOMeta.SORT_FIELD , MeetingRoomBookRcdVOMeta.SORT_TYPE , MeetingRoomBookRcdVOMeta.DATA_ORIGIN , MeetingRoomBookRcdVOMeta.QUERY_LOGIC , MeetingRoomBookRcdVOMeta.REQUEST_ACTION , MeetingRoomBookRcdVOMeta.IDS } )
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.SAVE)
	public Result save(MeetingRoomBookRcdVO meetingRoomBookRcdVO) {
		
		Result result=meetingRoomBookRcdService.save(meetingRoomBookRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取会议室预定
	*/
	@ApiOperation(value = "获取会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.GET_BY_ID)
	public Result<MeetingRoomBookRcd> getById(String id) {
		
		Result<MeetingRoomBookRcd> result=new Result<>();
		MeetingRoomBookRcd meetingRoomBookRcd=meetingRoomBookRcdService.getById(id);
		// join 关联的对象
		meetingRoomBookRcdService.dao().fill(meetingRoomBookRcd)
			.with("booker")
			.with("org")
			.with(MeetingRoomBookRcdMeta.MEETING_ROOM)
			.execute();

		meetingRoomBookRcdService.dao().join(meetingRoomBookRcd.getBooker(), Person.class);

		result.success(true).data(meetingRoomBookRcd);
		return result;
	}

	/**
	 * 获取会议室预定
	 */
	@ApiOperation(value = "获取会议室预定")
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.QUERY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.QUERY_DATA)
	public Result<JSONArray> queryData(String roomId, String startStr, String endStr) {
		return meetingRoomBookRcdService.queryData(roomId,startStr,endStr);
	}



	/**
	 * 批量获取会议室预定 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取会议室预定")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MeetingRoomBookRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.GET_BY_IDS)
	public Result<List<MeetingRoomBookRcd>> getByIds(List<String> ids) {
		
		Result<List<MeetingRoomBookRcd>> result=new Result<>();
		List<MeetingRoomBookRcd> list=meetingRoomBookRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询会议室预定
	*/
	@ApiOperation(value = "查询会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ROOM_ID , value = "会议室" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ORG_ID , value = "预定部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.BOOKER_ID , value = "预定人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.USER_ID , value = "发起人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MeetingRoomBookRcdVOMeta.PAGE_INDEX , MeetingRoomBookRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.QUERY_LIST)
	public Result<List<MeetingRoomBookRcd>> queryList(MeetingRoomBookRcdVO sample) {
		
		Result<List<MeetingRoomBookRcd>> result=new Result<>();
		List<MeetingRoomBookRcd> list=meetingRoomBookRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询会议室预定
	*/
	@ApiOperation(value = "分页查询会议室预定")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ROOM_ID , value = "会议室" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.ORG_ID , value = "预定部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.BOOKER_ID , value = "预定人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeetingRoomBookRcdVOMeta.USER_ID , value = "发起人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomBookRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomBookRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MeetingRoomBookRcd>> queryPagedList(MeetingRoomBookRcdVO sample) {
		
		Result<PagedList<MeetingRoomBookRcd>> result=new Result<>();
		PagedList<MeetingRoomBookRcd> list=meetingRoomBookRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		meetingRoomBookRcdService.dao().fill(list)
			.with("booker")
			.with("org")
			.with(MeetingRoomBookRcdMeta.MEETING_ROOM)
			.execute();
		result.success(true).data(list);

		List<Employee> bookerList = CollectorUtil.collectList(list, MeetingRoomBookRcd::getBooker);
		meetingRoomBookRcdService.dao().join(bookerList, Person.class);

		return result;
	}





}