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


import com.dt.platform.proxy.hr.ScoreTplServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTplVOMeta;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.ScoreTplVO;
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
import com.dt.platform.domain.hr.meta.ScoreTplMeta;
import com.dt.platform.domain.hr.ScoreTplItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 评分模版接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 08:59:02
*/

@InDoc
@Api(tags = "评分模版")
@RestController("HrScoreTplController")
public class ScoreTplController extends SuperController {

	@Autowired
	private IScoreTplService scoreTplService;

	/**
	 * 添加评分模版
	*/
	@ApiOperation(value = "添加评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.INSERT)
	public Result insert(ScoreTplVO scoreTplVO) {
		
		Result result=scoreTplService.insert(scoreTplVO,false);
		return result;
	}



	/**
	 * 删除评分模版
	*/
	@ApiOperation(value = "删除评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809164670802853888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTplService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除评分模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTplService.hasRefers(ids);
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
			Result result=scoreTplService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTplService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新评分模版
	*/
	@ApiOperation(value = "更新评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTplVOMeta.PAGE_INDEX , ScoreTplVOMeta.PAGE_SIZE , ScoreTplVOMeta.SEARCH_FIELD , ScoreTplVOMeta.FUZZY_FIELD , ScoreTplVOMeta.SEARCH_VALUE , ScoreTplVOMeta.DIRTY_FIELDS , ScoreTplVOMeta.SORT_FIELD , ScoreTplVOMeta.SORT_TYPE , ScoreTplVOMeta.DATA_ORIGIN , ScoreTplVOMeta.QUERY_LOGIC , ScoreTplVOMeta.REQUEST_ACTION , ScoreTplVOMeta.IDS } )
	@SentinelResource(value = ScoreTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.UPDATE)
	public Result update(ScoreTplVO scoreTplVO) {
		
		Result result=scoreTplService.update(scoreTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存评分模版
	*/
	@ApiOperation(value = "保存评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTplVOMeta.PAGE_INDEX , ScoreTplVOMeta.PAGE_SIZE , ScoreTplVOMeta.SEARCH_FIELD , ScoreTplVOMeta.FUZZY_FIELD , ScoreTplVOMeta.SEARCH_VALUE , ScoreTplVOMeta.DIRTY_FIELDS , ScoreTplVOMeta.SORT_FIELD , ScoreTplVOMeta.SORT_TYPE , ScoreTplVOMeta.DATA_ORIGIN , ScoreTplVOMeta.QUERY_LOGIC , ScoreTplVOMeta.REQUEST_ACTION , ScoreTplVOMeta.IDS } )
	@SentinelResource(value = ScoreTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.SAVE)
	public Result save(ScoreTplVO scoreTplVO) {
		
		Result result=scoreTplService.save(scoreTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取评分模版
	*/
	@ApiOperation(value = "获取评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.GET_BY_ID)
	public Result<ScoreTpl> getById(String id) {
		
		Result<ScoreTpl> result=new Result<>();
		ScoreTpl scoreTpl=scoreTplService.getById(id);
		result.success(true).data(scoreTpl);
		return result;
	}


	/**
	 * 批量获取评分模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取评分模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTpl>> getByIds(List<String> ids) {
		
		Result<List<ScoreTpl>> result=new Result<>();
		List<ScoreTpl> list=scoreTplService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询评分模版
	*/
	@ApiOperation(value = "查询评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTplVOMeta.PAGE_INDEX , ScoreTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.QUERY_LIST)
	public Result<List<ScoreTpl>> queryList(ScoreTplVO sample) {
		
		Result<List<ScoreTpl>> result=new Result<>();
		List<ScoreTpl> list=scoreTplService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询评分模版
	*/
	@ApiOperation(value = "分页查询评分模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = ScoreTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "demo评分卷"),
		@ApiImplicitParam(name = ScoreTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTpl>> queryPagedList(ScoreTplVO sample) {
		
		Result<PagedList<ScoreTpl>> result=new Result<>();
		PagedList<ScoreTpl> list=scoreTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}