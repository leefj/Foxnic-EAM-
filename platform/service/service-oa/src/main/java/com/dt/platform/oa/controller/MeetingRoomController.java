package com.dt.platform.oa.controller;

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


import com.dt.platform.proxy.oa.MeetingRoomServiceProxy;
import com.dt.platform.domain.oa.meta.MeetingRoomVOMeta;
import com.dt.platform.domain.oa.MeetingRoom;
import com.dt.platform.domain.oa.MeetingRoomVO;
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
import com.dt.platform.domain.oa.meta.MeetingRoomMeta;
import com.dt.platform.domain.oa.MeetingRoomPosition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IMeetingRoomService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 会议室接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 22:10:52
*/

@InDoc
@Api(tags = "会议室")
@RestController("OaMeetingRoomController")
public class MeetingRoomController extends SuperController {

	@Autowired
	private IMeetingRoomService meetingRoomService;

	/**
	 * 添加会议室
	*/
	@ApiOperation(value = "添加会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726536153796182016"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会议室一"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.PERSON_NUMBER , value = "容纳人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeetingRoomVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "available"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.INSERT)
	public Result insert(MeetingRoomVO meetingRoomVO) {
		
		Result result=meetingRoomService.insert(meetingRoomVO,false);
		return result;
	}



	/**
	 * 删除会议室
	*/
	@ApiOperation(value = "删除会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726536153796182016")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  meetingRoomService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=meetingRoomService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除会议室 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MeetingRoomServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = meetingRoomService.hasRefers(ids);
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
			Result result=meetingRoomService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=meetingRoomService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新会议室
	*/
	@ApiOperation(value = "更新会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726536153796182016"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会议室一"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.PERSON_NUMBER , value = "容纳人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeetingRoomVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "available"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MeetingRoomVOMeta.PAGE_INDEX , MeetingRoomVOMeta.PAGE_SIZE , MeetingRoomVOMeta.SEARCH_FIELD , MeetingRoomVOMeta.FUZZY_FIELD , MeetingRoomVOMeta.SEARCH_VALUE , MeetingRoomVOMeta.DIRTY_FIELDS , MeetingRoomVOMeta.SORT_FIELD , MeetingRoomVOMeta.SORT_TYPE , MeetingRoomVOMeta.DATA_ORIGIN , MeetingRoomVOMeta.QUERY_LOGIC , MeetingRoomVOMeta.REQUEST_ACTION , MeetingRoomVOMeta.IDS } )
	@SentinelResource(value = MeetingRoomServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.UPDATE)
	public Result update(MeetingRoomVO meetingRoomVO) {
		
		Result result=meetingRoomService.update(meetingRoomVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存会议室
	*/
	@ApiOperation(value = "保存会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726536153796182016"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会议室一"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.PERSON_NUMBER , value = "容纳人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeetingRoomVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "available"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MeetingRoomVOMeta.PAGE_INDEX , MeetingRoomVOMeta.PAGE_SIZE , MeetingRoomVOMeta.SEARCH_FIELD , MeetingRoomVOMeta.FUZZY_FIELD , MeetingRoomVOMeta.SEARCH_VALUE , MeetingRoomVOMeta.DIRTY_FIELDS , MeetingRoomVOMeta.SORT_FIELD , MeetingRoomVOMeta.SORT_TYPE , MeetingRoomVOMeta.DATA_ORIGIN , MeetingRoomVOMeta.QUERY_LOGIC , MeetingRoomVOMeta.REQUEST_ACTION , MeetingRoomVOMeta.IDS } )
	@SentinelResource(value = MeetingRoomServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.SAVE)
	public Result save(MeetingRoomVO meetingRoomVO) {
		
		Result result=meetingRoomService.save(meetingRoomVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取会议室
	*/
	@ApiOperation(value = "获取会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.GET_BY_ID)
	public Result<MeetingRoom> getById(String id) {
		
		Result<MeetingRoom> result=new Result<>();
		MeetingRoom meetingRoom=meetingRoomService.getById(id);
		// join 关联的对象
		meetingRoomService.dao().fill(meetingRoom)
			.with(MeetingRoomMeta.MEETING_ROOM_POSITION)
			.execute();
		result.success(true).data(meetingRoom);
		return result;
	}


	/**
	 * 批量获取会议室 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取会议室")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MeetingRoomVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MeetingRoomServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.GET_BY_IDS)
	public Result<List<MeetingRoom>> getByIds(List<String> ids) {
		
		Result<List<MeetingRoom>> result=new Result<>();
		List<MeetingRoom> list=meetingRoomService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询会议室
	*/
	@ApiOperation(value = "查询会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726536153796182016"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会议室一"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.PERSON_NUMBER , value = "容纳人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeetingRoomVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "available"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MeetingRoomVOMeta.PAGE_INDEX , MeetingRoomVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MeetingRoomServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.QUERY_LIST)
	public Result<List<MeetingRoom>> queryList(MeetingRoomVO sample) {
		
		Result<List<MeetingRoom>> result=new Result<>();
		List<MeetingRoom> list=meetingRoomService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询会议室
	*/
	@ApiOperation(value = "分页查询会议室")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726536153796182016"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会议室一"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.PERSON_NUMBER , value = "容纳人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeetingRoomVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "available"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MeetingRoom>> queryPagedList(MeetingRoomVO sample) {
		
		Result<PagedList<MeetingRoom>> result=new Result<>();
		PagedList<MeetingRoom> list=meetingRoomService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		meetingRoomService.dao().fill(list)
			.with(MeetingRoomMeta.MEETING_ROOM_POSITION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}