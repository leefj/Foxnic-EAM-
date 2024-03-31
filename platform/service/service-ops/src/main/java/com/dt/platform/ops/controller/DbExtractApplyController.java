package com.dt.platform.ops.controller;

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


import com.dt.platform.proxy.ops.DbExtractApplyServiceProxy;
import com.dt.platform.domain.ops.meta.DbExtractApplyVOMeta;
import com.dt.platform.domain.ops.DbExtractApply;
import com.dt.platform.domain.ops.DbExtractApplyVO;
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
import com.dt.platform.domain.ops.meta.DbExtractApplyMeta;
import com.dt.platform.domain.ops.DbInfoApply;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.DbApplyExecute;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbExtractApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库提取申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 18:45:09
*/

@InDoc
@Api(tags = "数据库提取申请")
@RestController("OpsDbExtractApplyController")
public class DbExtractApplyController extends SuperController {

	@Autowired
	private IDbExtractApplyService dbExtractApplyService;

	/**
	 * 添加数据库提取申请
	*/
	@ApiOperation(value = "添加数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_CODE , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_NAME , value = "关联工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_FULL_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_IP , value = "数据库IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_PORT , value = "端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_USER , value = "数据库用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA , value = "SQL文本1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA2 , value = "SQL文本2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA3 , value = "SQL文本3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA4 , value = "SQL文本4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA5 , value = "SQL文本5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CHECK_RESULT , value = "验证结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_ORDER_STATUS , value = "推送工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_RESULT , value = "返回信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ORDER_ID , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ASSOCIATED_SYSTEM , value = "关联系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExtractApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.INSERT)
	public Result insert(DbExtractApplyVO dbExtractApplyVO) {
		
		Result result=dbExtractApplyService.insert(dbExtractApplyVO,false);
		return result;
	}



	/**
	 * 删除数据库提取申请
	*/
	@ApiOperation(value = "删除数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExtractApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbExtractApplyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbExtractApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库提取申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbExtractApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbExtractApplyService.hasRefers(ids);
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
			Result result=dbExtractApplyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbExtractApplyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库提取申请
	*/
	@ApiOperation(value = "更新数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_CODE , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_NAME , value = "关联工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_FULL_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_IP , value = "数据库IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_PORT , value = "端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_USER , value = "数据库用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA , value = "SQL文本1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA2 , value = "SQL文本2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA3 , value = "SQL文本3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA4 , value = "SQL文本4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA5 , value = "SQL文本5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CHECK_RESULT , value = "验证结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_ORDER_STATUS , value = "推送工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_RESULT , value = "返回信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ORDER_ID , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ASSOCIATED_SYSTEM , value = "关联系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbExtractApplyVOMeta.PAGE_INDEX , DbExtractApplyVOMeta.PAGE_SIZE , DbExtractApplyVOMeta.SEARCH_FIELD , DbExtractApplyVOMeta.FUZZY_FIELD , DbExtractApplyVOMeta.SEARCH_VALUE , DbExtractApplyVOMeta.DIRTY_FIELDS , DbExtractApplyVOMeta.SORT_FIELD , DbExtractApplyVOMeta.SORT_TYPE , DbExtractApplyVOMeta.DATA_ORIGIN , DbExtractApplyVOMeta.QUERY_LOGIC , DbExtractApplyVOMeta.REQUEST_ACTION , DbExtractApplyVOMeta.IDS } )
	@SentinelResource(value = DbExtractApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.UPDATE)
	public Result update(DbExtractApplyVO dbExtractApplyVO) {
		
		Result result=dbExtractApplyService.update(dbExtractApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库提取申请
	*/
	@ApiOperation(value = "保存数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_CODE , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_NAME , value = "关联工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_FULL_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_IP , value = "数据库IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_PORT , value = "端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_USER , value = "数据库用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA , value = "SQL文本1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA2 , value = "SQL文本2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA3 , value = "SQL文本3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA4 , value = "SQL文本4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA5 , value = "SQL文本5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CHECK_RESULT , value = "验证结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_ORDER_STATUS , value = "推送工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_RESULT , value = "返回信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ORDER_ID , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ASSOCIATED_SYSTEM , value = "关联系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbExtractApplyVOMeta.PAGE_INDEX , DbExtractApplyVOMeta.PAGE_SIZE , DbExtractApplyVOMeta.SEARCH_FIELD , DbExtractApplyVOMeta.FUZZY_FIELD , DbExtractApplyVOMeta.SEARCH_VALUE , DbExtractApplyVOMeta.DIRTY_FIELDS , DbExtractApplyVOMeta.SORT_FIELD , DbExtractApplyVOMeta.SORT_TYPE , DbExtractApplyVOMeta.DATA_ORIGIN , DbExtractApplyVOMeta.QUERY_LOGIC , DbExtractApplyVOMeta.REQUEST_ACTION , DbExtractApplyVOMeta.IDS } )
	@SentinelResource(value = DbExtractApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.SAVE)
	public Result save(DbExtractApplyVO dbExtractApplyVO) {
		
		Result result=dbExtractApplyService.save(dbExtractApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库提取申请
	*/
	@ApiOperation(value = "获取数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExtractApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.GET_BY_ID)
	public Result<DbExtractApply> getById(String id) {
		
		Result<DbExtractApply> result=new Result<>();
		DbExtractApply dbExtractApply=dbExtractApplyService.getById(id);
		// join 关联的对象
		dbExtractApplyService.dao().fill(dbExtractApply)
			.with("applyUser")
			.with(DbExtractApplyMeta.DB_INFO_APPLY)
			.with(DbExtractApplyMeta.REQUEST_ORDER)
			.execute();
		result.success(true).data(dbExtractApply);
		return result;
	}


	/**
	 * 批量获取数据库提取申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库提取申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbExtractApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbExtractApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.GET_BY_IDS)
	public Result<List<DbExtractApply>> getByIds(List<String> ids) {
		
		Result<List<DbExtractApply>> result=new Result<>();
		List<DbExtractApply> list=dbExtractApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库提取申请
	*/
	@ApiOperation(value = "查询数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_CODE , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_NAME , value = "关联工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_FULL_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_IP , value = "数据库IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_PORT , value = "端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_USER , value = "数据库用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA , value = "SQL文本1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA2 , value = "SQL文本2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA3 , value = "SQL文本3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA4 , value = "SQL文本4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA5 , value = "SQL文本5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CHECK_RESULT , value = "验证结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_ORDER_STATUS , value = "推送工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_RESULT , value = "返回信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ORDER_ID , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ASSOCIATED_SYSTEM , value = "关联系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbExtractApplyVOMeta.PAGE_INDEX , DbExtractApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbExtractApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.QUERY_LIST)
	public Result<List<DbExtractApply>> queryList(DbExtractApplyVO sample) {
		
		Result<List<DbExtractApply>> result=new Result<>();
		List<DbExtractApply> list=dbExtractApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库提取申请
	*/
	@ApiOperation(value = "分页查询数据库提取申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_CODE , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ITEM_NAME , value = "关联工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_FULL_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_IP , value = "数据库IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_NAME , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_PORT , value = "端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.DB_USER , value = "数据库用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA , value = "SQL文本1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA2 , value = "SQL文本2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA3 , value = "SQL文本3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA4 , value = "SQL文本4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SQL_AREA5 , value = "SQL文本5" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.CHECK_RESULT , value = "验证结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_ORDER_STATUS , value = "推送工单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.PUSH_RESULT , value = "返回信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ORDER_ID , value = "工单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.ASSOCIATED_SYSTEM , value = "关联系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExtractApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExtractApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExtractApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbExtractApply>> queryPagedList(DbExtractApplyVO sample) {
		
		Result<PagedList<DbExtractApply>> result=new Result<>();
		PagedList<DbExtractApply> list=dbExtractApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbExtractApplyService.dao().fill(list)
			.with("applyUser")
			.with(DbExtractApplyMeta.DB_INFO_APPLY)
			.with(DbExtractApplyMeta.REQUEST_ORDER)
			.execute();
		result.success(true).data(list);
		return result;
	}





}