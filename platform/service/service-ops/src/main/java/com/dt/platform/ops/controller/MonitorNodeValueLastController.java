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


import com.dt.platform.proxy.ops.MonitorNodeValueLastServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeValueLastVOMeta;
import com.dt.platform.domain.ops.MonitorNodeValueLast;
import com.dt.platform.domain.ops.MonitorNodeValueLastVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeValueLastMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeValueLastService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点数值最新接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-02 18:25:42
*/

@InDoc
@Api(tags = "节点数值最新")
@RestController("OpsMonitorNodeValueLastController")
public class MonitorNodeValueLastController extends SuperController {

	@Autowired
	private IMonitorNodeValueLastService monitorNodeValueLastService;

	/**
	 * 添加节点数值最新
	*/
	@ApiOperation(value = "添加节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "761164814062977024"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "ee07abf6-89a3-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class , example = "sucess"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class , example = "执行成功"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.arch"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class , example = "x86_64 "),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_STATUS , value = "数据库状态" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_SIZE , value = "数据库大小" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_CONNECT_NUMBER , value = "数据库连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_BSTR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-10-02 09:57:13"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.INSERT)
	public Result insert(MonitorNodeValueLastVO monitorNodeValueLastVO) {
		
		Result result=monitorNodeValueLastService.insert(monitorNodeValueLastVO,false);
		return result;
	}



	/**
	 * 删除节点数值最新
	*/
	@ApiOperation(value = "删除节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "761164814062977024")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  monitorNodeValueLastService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=monitorNodeValueLastService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点数值最新 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = monitorNodeValueLastService.hasRefers(ids);
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
			Result result=monitorNodeValueLastService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=monitorNodeValueLastService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新节点数值最新
	*/
	@ApiOperation(value = "更新节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "761164814062977024"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "ee07abf6-89a3-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class , example = "sucess"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class , example = "执行成功"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.arch"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class , example = "x86_64 "),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_STATUS , value = "数据库状态" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_SIZE , value = "数据库大小" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_CONNECT_NUMBER , value = "数据库连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_BSTR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-10-02 09:57:13"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorNodeValueLastVOMeta.PAGE_INDEX , MonitorNodeValueLastVOMeta.PAGE_SIZE , MonitorNodeValueLastVOMeta.SEARCH_FIELD , MonitorNodeValueLastVOMeta.FUZZY_FIELD , MonitorNodeValueLastVOMeta.SEARCH_VALUE , MonitorNodeValueLastVOMeta.DIRTY_FIELDS , MonitorNodeValueLastVOMeta.SORT_FIELD , MonitorNodeValueLastVOMeta.SORT_TYPE , MonitorNodeValueLastVOMeta.DATA_ORIGIN , MonitorNodeValueLastVOMeta.QUERY_LOGIC , MonitorNodeValueLastVOMeta.REQUEST_ACTION , MonitorNodeValueLastVOMeta.IDS } )
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.UPDATE)
	public Result update(MonitorNodeValueLastVO monitorNodeValueLastVO) {
		
		Result result=monitorNodeValueLastService.update(monitorNodeValueLastVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点数值最新
	*/
	@ApiOperation(value = "保存节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "761164814062977024"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "ee07abf6-89a3-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class , example = "sucess"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class , example = "执行成功"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.arch"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class , example = "x86_64 "),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_STATUS , value = "数据库状态" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_SIZE , value = "数据库大小" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_CONNECT_NUMBER , value = "数据库连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_BSTR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-10-02 09:57:13"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeValueLastVOMeta.PAGE_INDEX , MonitorNodeValueLastVOMeta.PAGE_SIZE , MonitorNodeValueLastVOMeta.SEARCH_FIELD , MonitorNodeValueLastVOMeta.FUZZY_FIELD , MonitorNodeValueLastVOMeta.SEARCH_VALUE , MonitorNodeValueLastVOMeta.DIRTY_FIELDS , MonitorNodeValueLastVOMeta.SORT_FIELD , MonitorNodeValueLastVOMeta.SORT_TYPE , MonitorNodeValueLastVOMeta.DATA_ORIGIN , MonitorNodeValueLastVOMeta.QUERY_LOGIC , MonitorNodeValueLastVOMeta.REQUEST_ACTION , MonitorNodeValueLastVOMeta.IDS } )
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.SAVE)
	public Result save(MonitorNodeValueLastVO monitorNodeValueLastVO) {
		
		Result result=monitorNodeValueLastService.save(monitorNodeValueLastVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点数值最新
	*/
	@ApiOperation(value = "获取节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.GET_BY_ID)
	public Result<MonitorNodeValueLast> getById(String id) {
		
		Result<MonitorNodeValueLast> result=new Result<>();
		MonitorNodeValueLast monitorNodeValueLast=monitorNodeValueLastService.getById(id);
		result.success(true).data(monitorNodeValueLast);
		return result;
	}


	/**
	 * 批量获取节点数值最新 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点数值最新")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MonitorNodeValueLastServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeValueLast>> getByIds(List<String> ids) {
		
		Result<List<MonitorNodeValueLast>> result=new Result<>();
		List<MonitorNodeValueLast> list=monitorNodeValueLastService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点数值最新
	*/
	@ApiOperation(value = "查询节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "761164814062977024"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "ee07abf6-89a3-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class , example = "sucess"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class , example = "执行成功"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.arch"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class , example = "x86_64 "),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_STATUS , value = "数据库状态" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_SIZE , value = "数据库大小" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_CONNECT_NUMBER , value = "数据库连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_BSTR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-10-02 09:57:13"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorNodeValueLastVOMeta.PAGE_INDEX , MonitorNodeValueLastVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeValueLast>> queryList(MonitorNodeValueLastVO sample) {
		
		Result<List<MonitorNodeValueLast>> result=new Result<>();
		List<MonitorNodeValueLast> list=monitorNodeValueLastService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点数值最新
	*/
	@ApiOperation(value = "分页查询节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "761164814062977024"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "ee07abf6-89a3-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class , example = "sucess"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class , example = "执行成功"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.arch"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class , example = "x86_64 "),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_STATUS , value = "数据库状态" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_SIZE , value = "数据库大小" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.DB_CONNECT_NUMBER , value = "数据库连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_BSTR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-10-02 09:57:13"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeValueLast>> queryPagedList(MonitorNodeValueLastVO sample) {
		
		Result<PagedList<MonitorNodeValueLast>> result=new Result<>();
		PagedList<MonitorNodeValueLast> list=monitorNodeValueLastService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}