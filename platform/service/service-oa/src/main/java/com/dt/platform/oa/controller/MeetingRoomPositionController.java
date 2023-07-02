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


import com.dt.platform.proxy.oa.MeetingRoomPositionServiceProxy;
import com.dt.platform.domain.oa.meta.MeetingRoomPositionVOMeta;
import com.dt.platform.domain.oa.MeetingRoomPosition;
import com.dt.platform.domain.oa.MeetingRoomPositionVO;
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
import com.dt.platform.domain.oa.meta.MeetingRoomPositionMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IMeetingRoomPositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 会议室位置接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 23:01:15
*/

@InDoc
@Api(tags = "会议室位置")
@RestController("OaMeetingRoomPositionController")
public class MeetingRoomPositionController extends SuperController {

	@Autowired
	private IMeetingRoomPositionService meetingRoomPositionService;

	/**
	 * 添加会议室位置
	*/
	@ApiOperation(value = "添加会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一楼"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomPositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.INSERT)
	public Result insert(MeetingRoomPositionVO meetingRoomPositionVO) {
		
		Result result=meetingRoomPositionService.insert(meetingRoomPositionVO,false);
		return result;
	}



	/**
	 * 删除会议室位置
	*/
	@ApiOperation(value = "删除会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726535420753477632")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomPositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  meetingRoomPositionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=meetingRoomPositionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除会议室位置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MeetingRoomPositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = meetingRoomPositionService.hasRefers(ids);
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
			Result result=meetingRoomPositionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=meetingRoomPositionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新会议室位置
	*/
	@ApiOperation(value = "更新会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一楼"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MeetingRoomPositionVOMeta.PAGE_INDEX , MeetingRoomPositionVOMeta.PAGE_SIZE , MeetingRoomPositionVOMeta.SEARCH_FIELD , MeetingRoomPositionVOMeta.FUZZY_FIELD , MeetingRoomPositionVOMeta.SEARCH_VALUE , MeetingRoomPositionVOMeta.DIRTY_FIELDS , MeetingRoomPositionVOMeta.SORT_FIELD , MeetingRoomPositionVOMeta.SORT_TYPE , MeetingRoomPositionVOMeta.DATA_ORIGIN , MeetingRoomPositionVOMeta.QUERY_LOGIC , MeetingRoomPositionVOMeta.REQUEST_ACTION , MeetingRoomPositionVOMeta.IDS } )
	@SentinelResource(value = MeetingRoomPositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.UPDATE)
	public Result update(MeetingRoomPositionVO meetingRoomPositionVO) {
		
		Result result=meetingRoomPositionService.update(meetingRoomPositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存会议室位置
	*/
	@ApiOperation(value = "保存会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一楼"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MeetingRoomPositionVOMeta.PAGE_INDEX , MeetingRoomPositionVOMeta.PAGE_SIZE , MeetingRoomPositionVOMeta.SEARCH_FIELD , MeetingRoomPositionVOMeta.FUZZY_FIELD , MeetingRoomPositionVOMeta.SEARCH_VALUE , MeetingRoomPositionVOMeta.DIRTY_FIELDS , MeetingRoomPositionVOMeta.SORT_FIELD , MeetingRoomPositionVOMeta.SORT_TYPE , MeetingRoomPositionVOMeta.DATA_ORIGIN , MeetingRoomPositionVOMeta.QUERY_LOGIC , MeetingRoomPositionVOMeta.REQUEST_ACTION , MeetingRoomPositionVOMeta.IDS } )
	@SentinelResource(value = MeetingRoomPositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.SAVE)
	public Result save(MeetingRoomPositionVO meetingRoomPositionVO) {
		
		Result result=meetingRoomPositionService.save(meetingRoomPositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取会议室位置
	*/
	@ApiOperation(value = "获取会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomPositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.GET_BY_ID)
	public Result<MeetingRoomPosition> getById(String id) {
		
		Result<MeetingRoomPosition> result=new Result<>();
		MeetingRoomPosition meetingRoomPosition=meetingRoomPositionService.getById(id);
		result.success(true).data(meetingRoomPosition);
		return result;
	}


	/**
	 * 批量获取会议室位置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取会议室位置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MeetingRoomPositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MeetingRoomPositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.GET_BY_IDS)
	public Result<List<MeetingRoomPosition>> getByIds(List<String> ids) {
		
		Result<List<MeetingRoomPosition>> result=new Result<>();
		List<MeetingRoomPosition> list=meetingRoomPositionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询会议室位置
	*/
	@ApiOperation(value = "查询会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一楼"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MeetingRoomPositionVOMeta.PAGE_INDEX , MeetingRoomPositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MeetingRoomPositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.QUERY_LIST)
	public Result<List<MeetingRoomPosition>> queryList(MeetingRoomPositionVO sample) {
		
		Result<List<MeetingRoomPosition>> result=new Result<>();
		List<MeetingRoomPosition> list=meetingRoomPositionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询会议室位置
	*/
	@ApiOperation(value = "分页查询会议室位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "726535420753477632"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一楼"),
		@ApiImplicitParam(name = MeetingRoomPositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MeetingRoomPositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MeetingRoomPositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MeetingRoomPosition>> queryPagedList(MeetingRoomPositionVO sample) {
		
		Result<PagedList<MeetingRoomPosition>> result=new Result<>();
		PagedList<MeetingRoomPosition> list=meetingRoomPositionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}