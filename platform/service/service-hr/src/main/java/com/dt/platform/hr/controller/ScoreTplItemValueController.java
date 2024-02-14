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


import com.dt.platform.proxy.hr.ScoreTplItemValueServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTplItemValueVOMeta;
import com.dt.platform.domain.hr.ScoreTplItemValue;
import com.dt.platform.domain.hr.ScoreTplItemValueVO;
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
import com.dt.platform.domain.hr.meta.ScoreTplItemValueMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTplItemValueService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 评分明细接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-11 23:55:07
*/

@InDoc
@Api(tags = "评分明细")
@RestController("HrScoreTplItemValueController")
public class ScoreTplItemValueController extends SuperController {

	@Autowired
	private IScoreTplItemValueService scoreTplItemValueService;

	/**
	 * 添加评分明细
	*/
	@ApiOperation(value = "添加评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TASK_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ITEM_ID , value = "评分项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_NAME , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_ID , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_NAME , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemValueServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.INSERT)
	public Result insert(ScoreTplItemValueVO scoreTplItemValueVO) {
		
		Result result=scoreTplItemValueService.insert(scoreTplItemValueVO,false);
		return result;
	}



	/**
	 * 删除评分明细
	*/
	@ApiOperation(value = "删除评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemValueServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTplItemValueService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTplItemValueService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除评分明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTplItemValueServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTplItemValueService.hasRefers(ids);
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
			Result result=scoreTplItemValueService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTplItemValueService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新评分明细
	*/
	@ApiOperation(value = "更新评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TASK_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ITEM_ID , value = "评分项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_NAME , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_ID , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_NAME , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTplItemValueVOMeta.PAGE_INDEX , ScoreTplItemValueVOMeta.PAGE_SIZE , ScoreTplItemValueVOMeta.SEARCH_FIELD , ScoreTplItemValueVOMeta.FUZZY_FIELD , ScoreTplItemValueVOMeta.SEARCH_VALUE , ScoreTplItemValueVOMeta.DIRTY_FIELDS , ScoreTplItemValueVOMeta.SORT_FIELD , ScoreTplItemValueVOMeta.SORT_TYPE , ScoreTplItemValueVOMeta.DATA_ORIGIN , ScoreTplItemValueVOMeta.QUERY_LOGIC , ScoreTplItemValueVOMeta.REQUEST_ACTION , ScoreTplItemValueVOMeta.IDS } )
	@SentinelResource(value = ScoreTplItemValueServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.UPDATE)
	public Result update(ScoreTplItemValueVO scoreTplItemValueVO) {
		
		Result result=scoreTplItemValueService.update(scoreTplItemValueVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存评分明细
	*/
	@ApiOperation(value = "保存评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TASK_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ITEM_ID , value = "评分项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_NAME , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_ID , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_NAME , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTplItemValueVOMeta.PAGE_INDEX , ScoreTplItemValueVOMeta.PAGE_SIZE , ScoreTplItemValueVOMeta.SEARCH_FIELD , ScoreTplItemValueVOMeta.FUZZY_FIELD , ScoreTplItemValueVOMeta.SEARCH_VALUE , ScoreTplItemValueVOMeta.DIRTY_FIELDS , ScoreTplItemValueVOMeta.SORT_FIELD , ScoreTplItemValueVOMeta.SORT_TYPE , ScoreTplItemValueVOMeta.DATA_ORIGIN , ScoreTplItemValueVOMeta.QUERY_LOGIC , ScoreTplItemValueVOMeta.REQUEST_ACTION , ScoreTplItemValueVOMeta.IDS } )
	@SentinelResource(value = ScoreTplItemValueServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.SAVE)
	public Result save(ScoreTplItemValueVO scoreTplItemValueVO) {
		
		Result result=scoreTplItemValueService.save(scoreTplItemValueVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取评分明细
	*/
	@ApiOperation(value = "获取评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemValueServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.GET_BY_ID)
	public Result<ScoreTplItemValue> getById(String id) {
		
		Result<ScoreTplItemValue> result=new Result<>();
		ScoreTplItemValue scoreTplItemValue=scoreTplItemValueService.getById(id);
		// join 关联的对象
		scoreTplItemValueService.dao().fill(scoreTplItemValue)
			.with(ScoreTplItemValueMeta.GROUP_ID)
			.execute();
		result.success(true).data(scoreTplItemValue);
		return result;
	}


	/**
	 * 批量获取评分明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取评分明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTplItemValueVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTplItemValueServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTplItemValue>> getByIds(List<String> ids) {
		
		Result<List<ScoreTplItemValue>> result=new Result<>();
		List<ScoreTplItemValue> list=scoreTplItemValueService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询评分明细
	*/
	@ApiOperation(value = "查询评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TASK_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ITEM_ID , value = "评分项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_NAME , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_ID , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_NAME , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTplItemValueVOMeta.PAGE_INDEX , ScoreTplItemValueVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTplItemValueServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.QUERY_LIST)
	public Result<List<ScoreTplItemValue>> queryList(ScoreTplItemValueVO sample) {
		
		Result<List<ScoreTplItemValue>> result=new Result<>();
		List<ScoreTplItemValue> list=scoreTplItemValueService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询评分明细
	*/
	@ApiOperation(value = "分页查询评分明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TASK_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.TPL_ITEM_ID , value = "评分项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.ITEM_NAME , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_ID , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.GROUP_NAME , value = "评分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MIN_SCORE , value = "最小分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.MAX_SCORE , value = "最大分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.DEF_SCORE , value = "默认分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.SN , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTplItemValueVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTplItemValueServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTplItemValueServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTplItemValue>> queryPagedList(ScoreTplItemValueVO sample) {
		
		Result<PagedList<ScoreTplItemValue>> result=new Result<>();
		PagedList<ScoreTplItemValue> list=scoreTplItemValueService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		scoreTplItemValueService.dao().fill(list)
			.with(ScoreTplItemValueMeta.GROUP_ID)
			.execute();
		result.success(true).data(list);
		return result;
	}





}