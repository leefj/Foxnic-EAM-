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


import com.dt.platform.proxy.hr.ScoreTplItemServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTplItemVOMeta;
import com.dt.platform.domain.hr.ScoreTplItem;
import com.dt.platform.domain.hr.ScoreTplItemVO;
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
import com.dt.platform.domain.hr.meta.ScoreTplItemMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.ScoreIndicator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTplItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 评分项目接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 12:57:42
*/

@InDoc
@Api(tags = "评分项目")
@RestController("HrScoreTplItemController")
public class ScoreTplItemController extends SuperController {

	@Autowired
	private IScoreTplItemService scoreTplItemService;

	/**
	 * 添加评分项目
	*/
	@ApiOperation(value = "添加评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809712898338193408"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "number"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_NAME , value = "题目" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.GROUP_ID , value = "指标" , required = false , dataTypeClass=String.class , example = "809523698477301760"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class , example = "10"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.INSERT)
	public Result insert(ScoreTplItemVO scoreTplItemVO) {
		
		Result result=scoreTplItemService.insert(scoreTplItemVO,false);
		return result;
	}



	/**
	 * 删除评分项目
	*/
	@ApiOperation(value = "删除评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809712898338193408")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTplItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTplItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除评分项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTplItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTplItemService.hasRefers(ids);
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
			Result result=scoreTplItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTplItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新评分项目
	*/
	@ApiOperation(value = "更新评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809712898338193408"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "number"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_NAME , value = "题目" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.GROUP_ID , value = "指标" , required = false , dataTypeClass=String.class , example = "809523698477301760"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class , example = "10"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTplItemVOMeta.PAGE_INDEX , ScoreTplItemVOMeta.PAGE_SIZE , ScoreTplItemVOMeta.SEARCH_FIELD , ScoreTplItemVOMeta.FUZZY_FIELD , ScoreTplItemVOMeta.SEARCH_VALUE , ScoreTplItemVOMeta.DIRTY_FIELDS , ScoreTplItemVOMeta.SORT_FIELD , ScoreTplItemVOMeta.SORT_TYPE , ScoreTplItemVOMeta.DATA_ORIGIN , ScoreTplItemVOMeta.QUERY_LOGIC , ScoreTplItemVOMeta.REQUEST_ACTION , ScoreTplItemVOMeta.IDS } )
	@SentinelResource(value = ScoreTplItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.UPDATE)
	public Result update(ScoreTplItemVO scoreTplItemVO) {
		
		Result result=scoreTplItemService.update(scoreTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存评分项目
	*/
	@ApiOperation(value = "保存评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809712898338193408"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "number"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_NAME , value = "题目" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.GROUP_ID , value = "指标" , required = false , dataTypeClass=String.class , example = "809523698477301760"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class , example = "10"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTplItemVOMeta.PAGE_INDEX , ScoreTplItemVOMeta.PAGE_SIZE , ScoreTplItemVOMeta.SEARCH_FIELD , ScoreTplItemVOMeta.FUZZY_FIELD , ScoreTplItemVOMeta.SEARCH_VALUE , ScoreTplItemVOMeta.DIRTY_FIELDS , ScoreTplItemVOMeta.SORT_FIELD , ScoreTplItemVOMeta.SORT_TYPE , ScoreTplItemVOMeta.DATA_ORIGIN , ScoreTplItemVOMeta.QUERY_LOGIC , ScoreTplItemVOMeta.REQUEST_ACTION , ScoreTplItemVOMeta.IDS } )
	@SentinelResource(value = ScoreTplItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.SAVE)
	public Result save(ScoreTplItemVO scoreTplItemVO) {
		
		Result result=scoreTplItemService.save(scoreTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取评分项目
	*/
	@ApiOperation(value = "获取评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.GET_BY_ID)
	public Result<ScoreTplItem> getById(String id) {
		
		Result<ScoreTplItem> result=new Result<>();
		ScoreTplItem scoreTplItem=scoreTplItemService.getById(id);
		// join 关联的对象
		scoreTplItemService.dao().fill(scoreTplItem)
			.with(ScoreTplItemMeta.SCORE_INDICATOR)
			.execute();
		result.success(true).data(scoreTplItem);
		return result;
	}


	/**
	 * 批量获取评分项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取评分项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTplItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTplItem>> getByIds(List<String> ids) {
		
		Result<List<ScoreTplItem>> result=new Result<>();
		List<ScoreTplItem> list=scoreTplItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询评分项目
	*/
	@ApiOperation(value = "查询评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809712898338193408"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "number"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_NAME , value = "题目" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.GROUP_ID , value = "指标" , required = false , dataTypeClass=String.class , example = "809523698477301760"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class , example = "10"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTplItemVOMeta.PAGE_INDEX , ScoreTplItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTplItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.QUERY_LIST)
	public Result<List<ScoreTplItem>> queryList(ScoreTplItemVO sample) {
		
		Result<List<ScoreTplItem>> result=new Result<>();
		List<ScoreTplItem> list=scoreTplItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询评分项目
	*/
	@ApiOperation(value = "分页查询评分项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809712898338193408"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "number"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.ITEM_NAME , value = "题目" , required = false , dataTypeClass=String.class , example = "12121212"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.GROUP_ID , value = "指标" , required = false , dataTypeClass=String.class , example = "809523698477301760"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class , example = "10"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTplItem>> queryPagedList(ScoreTplItemVO sample) {
		
		Result<PagedList<ScoreTplItem>> result=new Result<>();
		PagedList<ScoreTplItem> list=scoreTplItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		scoreTplItemService.dao().fill(list)
			.with(ScoreTplItemMeta.SCORE_INDICATOR)
			.execute();
		result.success(true).data(list);
		return result;
	}





}