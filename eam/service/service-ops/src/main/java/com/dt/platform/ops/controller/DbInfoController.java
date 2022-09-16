package com.dt.platform.ops.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.ops.DbInfoServiceProxy;
import com.dt.platform.domain.ops.meta.DbInfoVOMeta;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.DbInfoVO;
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
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.DbBackupInfo;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.ops.meta.HostMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-13 20:38:43
*/

@Api(tags = "数据库")
@ApiSort(0)
@RestController("OpsDbInfoController")
public class DbInfoController extends SuperController {

	@Autowired
	private IDbInfoService dbInfoService;


	/**
	 * 添加数据库
	*/
	@ApiOperation(value = "添加数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "620984665599115264"),
		@ApiImplicitParam(name = DbInfoVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "607860248228663296"),
		@ApiImplicitParam(name = DbInfoVOMeta.TYPE_ID , value = "数据库类型" , required = false , dataTypeClass=String.class , example = "495613594017202176"),
		@ApiImplicitParam(name = DbInfoVOMeta.NAME , value = "数据库名" , required = false , dataTypeClass=String.class , example = "cw3"),
		@ApiImplicitParam(name = DbInfoVOMeta.STATUS , value = "数据库状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "backup"),
		@ApiImplicitParam(name = DbInfoVOMeta.DEPLOY_MODE , value = "部署模式" , required = false , dataTypeClass=String.class , example = "single"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class , example = "无"),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_SIZE , value = "大小(M)" , required = false , dataTypeClass=BigDecimal.class , example = "10923.00"),
		@ApiImplicitParam(name = DbInfoVOMeta.LOG_METHOD , value = "日志模式" , required = false , dataTypeClass=String.class , example = "no_arch"),
		@ApiImplicitParam(name = DbInfoVOMeta.ADMIN_USER_LIST , value = "管理员账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.APP_USER_LIST , value = "应用账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.OTHER_USER_LIST , value = "其他账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.VOUCHER_STR , value = "凭证信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_PORT , value = "连接端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = DbInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1662883885000"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = DbInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.INSERT)
	public Result insert(DbInfoVO dbInfoVO) {
		Result result=dbInfoService.insert(dbInfoVO,false);
		return result;
	}



	/**
	 * 删除数据库
	*/
	@ApiOperation(value = "删除数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "620984665599115264")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = DbInfoVOMeta.ID)
	@SentinelResource(value = DbInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = dbInfoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=dbInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = DbInfoVOMeta.IDS)
	@SentinelResource(value = DbInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = dbInfoService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=dbInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbInfoService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新数据库
	*/
	@ApiOperation(value = "更新数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "620984665599115264"),
		@ApiImplicitParam(name = DbInfoVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "607860248228663296"),
		@ApiImplicitParam(name = DbInfoVOMeta.TYPE_ID , value = "数据库类型" , required = false , dataTypeClass=String.class , example = "495613594017202176"),
		@ApiImplicitParam(name = DbInfoVOMeta.NAME , value = "数据库名" , required = false , dataTypeClass=String.class , example = "cw3"),
		@ApiImplicitParam(name = DbInfoVOMeta.STATUS , value = "数据库状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "backup"),
		@ApiImplicitParam(name = DbInfoVOMeta.DEPLOY_MODE , value = "部署模式" , required = false , dataTypeClass=String.class , example = "single"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class , example = "无"),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_SIZE , value = "大小(M)" , required = false , dataTypeClass=BigDecimal.class , example = "10923.00"),
		@ApiImplicitParam(name = DbInfoVOMeta.LOG_METHOD , value = "日志模式" , required = false , dataTypeClass=String.class , example = "no_arch"),
		@ApiImplicitParam(name = DbInfoVOMeta.ADMIN_USER_LIST , value = "管理员账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.APP_USER_LIST , value = "应用账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.OTHER_USER_LIST , value = "其他账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.VOUCHER_STR , value = "凭证信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_PORT , value = "连接端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = DbInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1662883885000"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { DbInfoVOMeta.PAGE_INDEX , DbInfoVOMeta.PAGE_SIZE , DbInfoVOMeta.SEARCH_FIELD , DbInfoVOMeta.FUZZY_FIELD , DbInfoVOMeta.SEARCH_VALUE , DbInfoVOMeta.DIRTY_FIELDS , DbInfoVOMeta.SORT_FIELD , DbInfoVOMeta.SORT_TYPE , DbInfoVOMeta.IDS } )
	@SentinelResource(value = DbInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.UPDATE)
	public Result update(DbInfoVO dbInfoVO) {
		Result result=dbInfoService.update(dbInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库
	*/
	@ApiOperation(value = "保存数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "620984665599115264"),
		@ApiImplicitParam(name = DbInfoVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "607860248228663296"),
		@ApiImplicitParam(name = DbInfoVOMeta.TYPE_ID , value = "数据库类型" , required = false , dataTypeClass=String.class , example = "495613594017202176"),
		@ApiImplicitParam(name = DbInfoVOMeta.NAME , value = "数据库名" , required = false , dataTypeClass=String.class , example = "cw3"),
		@ApiImplicitParam(name = DbInfoVOMeta.STATUS , value = "数据库状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "backup"),
		@ApiImplicitParam(name = DbInfoVOMeta.DEPLOY_MODE , value = "部署模式" , required = false , dataTypeClass=String.class , example = "single"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class , example = "无"),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_SIZE , value = "大小(M)" , required = false , dataTypeClass=BigDecimal.class , example = "10923.00"),
		@ApiImplicitParam(name = DbInfoVOMeta.LOG_METHOD , value = "日志模式" , required = false , dataTypeClass=String.class , example = "no_arch"),
		@ApiImplicitParam(name = DbInfoVOMeta.ADMIN_USER_LIST , value = "管理员账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.APP_USER_LIST , value = "应用账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.OTHER_USER_LIST , value = "其他账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.VOUCHER_STR , value = "凭证信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_PORT , value = "连接端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = DbInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1662883885000"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbInfoVOMeta.PAGE_INDEX , DbInfoVOMeta.PAGE_SIZE , DbInfoVOMeta.SEARCH_FIELD , DbInfoVOMeta.FUZZY_FIELD , DbInfoVOMeta.SEARCH_VALUE , DbInfoVOMeta.DIRTY_FIELDS , DbInfoVOMeta.SORT_FIELD , DbInfoVOMeta.SORT_TYPE , DbInfoVOMeta.IDS } )
	@NotNull(name = DbInfoVOMeta.ID)
	@SentinelResource(value = DbInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.SAVE)
	public Result save(DbInfoVO dbInfoVO) {
		Result result=dbInfoService.save(dbInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库
	*/
	@ApiOperation(value = "获取数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = DbInfoVOMeta.ID)
	@SentinelResource(value = DbInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.GET_BY_ID)
	public Result<DbInfo> getById(String id) {
		Result<DbInfo> result=new Result<>();
		DbInfo dbInfo=dbInfoService.getById(id);
		// join 关联的对象
		dbInfoService.dao().fill(dbInfo)
			.with(DbInfoMeta.HOST)
			.with(DbInfoMeta.HOST)
			.with(DbInfoMeta.TYPE)
			.with(DbInfoMeta.DEPLOY_MODE_DICT)
			.execute();
		result.success(true).data(dbInfo);
		return result;
	}


	/**
	 * 批量获取数据库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = DbInfoVOMeta.IDS)
		@SentinelResource(value = DbInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.GET_BY_IDS)
	public Result<List<DbInfo>> getByIds(List<String> ids) {
		Result<List<DbInfo>> result=new Result<>();
		List<DbInfo> list=dbInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库
	*/
	@ApiOperation(value = "查询数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "620984665599115264"),
		@ApiImplicitParam(name = DbInfoVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "607860248228663296"),
		@ApiImplicitParam(name = DbInfoVOMeta.TYPE_ID , value = "数据库类型" , required = false , dataTypeClass=String.class , example = "495613594017202176"),
		@ApiImplicitParam(name = DbInfoVOMeta.NAME , value = "数据库名" , required = false , dataTypeClass=String.class , example = "cw3"),
		@ApiImplicitParam(name = DbInfoVOMeta.STATUS , value = "数据库状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "backup"),
		@ApiImplicitParam(name = DbInfoVOMeta.DEPLOY_MODE , value = "部署模式" , required = false , dataTypeClass=String.class , example = "single"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class , example = "无"),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_SIZE , value = "大小(M)" , required = false , dataTypeClass=BigDecimal.class , example = "10923.00"),
		@ApiImplicitParam(name = DbInfoVOMeta.LOG_METHOD , value = "日志模式" , required = false , dataTypeClass=String.class , example = "no_arch"),
		@ApiImplicitParam(name = DbInfoVOMeta.ADMIN_USER_LIST , value = "管理员账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.APP_USER_LIST , value = "应用账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.OTHER_USER_LIST , value = "其他账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.VOUCHER_STR , value = "凭证信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_PORT , value = "连接端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = DbInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1662883885000"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbInfoVOMeta.PAGE_INDEX , DbInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.QUERY_LIST)
	public Result<List<DbInfo>> queryList(DbInfoVO sample) {
		Result<List<DbInfo>> result=new Result<>();
		List<DbInfo> list=dbInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库
	*/
	@ApiOperation(value = "分页查询数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "620984665599115264"),
		@ApiImplicitParam(name = DbInfoVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "607860248228663296"),
		@ApiImplicitParam(name = DbInfoVOMeta.TYPE_ID , value = "数据库类型" , required = false , dataTypeClass=String.class , example = "495613594017202176"),
		@ApiImplicitParam(name = DbInfoVOMeta.NAME , value = "数据库名" , required = false , dataTypeClass=String.class , example = "cw3"),
		@ApiImplicitParam(name = DbInfoVOMeta.STATUS , value = "数据库状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "backup"),
		@ApiImplicitParam(name = DbInfoVOMeta.DEPLOY_MODE , value = "部署模式" , required = false , dataTypeClass=String.class , example = "single"),
		@ApiImplicitParam(name = DbInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class , example = "无"),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_SIZE , value = "大小(M)" , required = false , dataTypeClass=BigDecimal.class , example = "10923.00"),
		@ApiImplicitParam(name = DbInfoVOMeta.LOG_METHOD , value = "日志模式" , required = false , dataTypeClass=String.class , example = "no_arch"),
		@ApiImplicitParam(name = DbInfoVOMeta.ADMIN_USER_LIST , value = "管理员账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.APP_USER_LIST , value = "应用账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.OTHER_USER_LIST , value = "其他账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.VOUCHER_STR , value = "凭证信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.DB_PORT , value = "连接端口" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = DbInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1662883885000"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = DbInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbInfo>> queryPagedList(DbInfoVO sample) {
		Result<PagedList<DbInfo>> result=new Result<>();
		PagedList<DbInfo> list=dbInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbInfoService.dao().fill(list)
			.with(DbInfoMeta.HOST)
			.with(DbInfoMeta.HOST)
			.with(DbInfoMeta.TYPE)
			.with(DbInfoMeta.DEPLOY_MODE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}






}