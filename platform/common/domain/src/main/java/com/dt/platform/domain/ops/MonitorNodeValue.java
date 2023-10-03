package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_NODE_VALUE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorNodeValueMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 节点数值
 * <p>节点数值 , 数据表 ops_monitor_node_value 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-02 18:25:18
 * @sign 3DD4F672BD9AAE520F5B607D64BA6AC2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node_value")
@ApiModel(description = "节点数值 ; 节点数值 , 数据表 ops_monitor_node_value 的PO类型")
public class MonitorNodeValue extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE_VALUE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "545950298741407744")
	private String id;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点" , example = "2571f8e4-89a4-11ec-bf3e-00163e1b60a7")
	private String nodeId;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版" , example = "tpl_host_linux_script")
	private String monitorTplCode;
	
	/**
	 * 结果状态：结果状态
	*/
	@ApiModelProperty(required = false,value="结果状态" , notes = "结果状态" , example = "sucess")
	private String resultStatus;
	
	/**
	 * 结果内容：结果内容
	*/
	@ApiModelProperty(required = false,value="结果内容" , notes = "结果内容" , example = "执行成功")
	private String resultMessage;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标" , example = "os.arch")
	private String indicatorCode;
	
	/**
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称")
	private String hostname;
	
	/**
	 * 系统时间：系统时间
	*/
	@ApiModelProperty(required = false,value="系统时间" , notes = "系统时间")
	private String osDatetime;
	
	/**
	 * 启动时间：启动时间
	*/
	@ApiModelProperty(required = false,value="启动时间" , notes = "启动时间")
	private Date boottime;
	
	/**
	 * 系统：系统
	*/
	@ApiModelProperty(required = false,value="系统" , notes = "系统")
	private String osVerion;
	
	/**
	 * 架构：架构
	*/
	@ApiModelProperty(required = false,value="架构" , notes = "架构" , example = "x86_64")
	private String arch;
	
	/**
	 * CPU数量：CPU数量
	*/
	@ApiModelProperty(required = false,value="CPU数量" , notes = "CPU数量")
	private Integer cpuNumber;
	
	/**
	 * CPU主频：CPU主频
	*/
	@ApiModelProperty(required = false,value="CPU主频" , notes = "CPU主频")
	private BigDecimal cpuFree;
	
	/**
	 * cpuSys：cpuSys
	*/
	@ApiModelProperty(required = false,value="cpuSys" , notes = "cpuSys")
	private BigDecimal cpuSys;
	
	/**
	 * cpuUser：cpuUser
	*/
	@ApiModelProperty(required = false,value="cpuUser" , notes = "cpuUser")
	private BigDecimal cpuUser;
	
	/**
	 * cpuWait：cpuWait
	*/
	@ApiModelProperty(required = false,value="cpuWait" , notes = "cpuWait" , example = "0.31")
	private BigDecimal cpuWait;
	
	/**
	 * CPU空闲旅：CPU空闲旅
	*/
	@ApiModelProperty(required = false,value="CPU空闲旅" , notes = "CPU空闲旅")
	private BigDecimal cpuIdle;
	
	/**
	 * CPU使用率：CPU使用率
	*/
	@ApiModelProperty(required = false,value="CPU使用率" , notes = "CPU使用率")
	private BigDecimal cpuUsed;
	
	/**
	 * 系统负载：系统负载
	*/
	@ApiModelProperty(required = false,value="系统负载" , notes = "系统负载")
	private BigDecimal osLoad;
	
	/**
	 * 系统负载5：系统负载5
	*/
	@ApiModelProperty(required = false,value="系统负载5" , notes = "系统负载5")
	private BigDecimal osLoad5;
	
	/**
	 * 系统负载15：系统负载15
	*/
	@ApiModelProperty(required = false,value="系统负载15" , notes = "系统负载15")
	private BigDecimal osLoad15;
	
	/**
	 * 上行流量：上行流量
	*/
	@ApiModelProperty(required = false,value="上行流量" , notes = "上行流量")
	private BigDecimal networkFlowUp;
	
	/**
	 * 下流量：下流量
	*/
	@ApiModelProperty(required = false,value="下流量" , notes = "下流量")
	private BigDecimal networkFlowDown;
	
	/**
	 * 连接数：连接数
	*/
	@ApiModelProperty(required = false,value="连接数" , notes = "连接数" , example = "0")
	private Integer processCnt;
	
	/**
	 * 物理内存：M)
	*/
	@ApiModelProperty(required = false,value="物理内存" , notes = "M)")
	private Long pMemorySize;
	
	/**
	 * 虚拟内存：M)
	*/
	@ApiModelProperty(required = false,value="虚拟内存" , notes = "M)")
	private Long vMemorySize;
	
	/**
	 * 物理内存使用率：物理内存使用率
	*/
	@ApiModelProperty(required = false,value="物理内存使用率" , notes = "物理内存使用率" , example = "0.00")
	private BigDecimal pMemoryUsed;
	
	/**
	 * 虚拟内存使用率：虚拟内存使用率
	*/
	@ApiModelProperty(required = false,value="虚拟内存使用率" , notes = "虚拟内存使用率" , example = "0.00")
	private BigDecimal vMemoryUsed;
	
	/**
	 * 数据库状态：数据库状态
	*/
	@ApiModelProperty(required = false,value="数据库状态" , notes = "数据库状态")
	private Integer dbStatus;
	
	/**
	 * 数据库大小：数据库大小
	*/
	@ApiModelProperty(required = false,value="数据库大小" , notes = "数据库大小")
	private Long dbSize;
	
	/**
	 * 数据库连接数：数据库连接数
	*/
	@ApiModelProperty(required = false,value="数据库连接数" , notes = "数据库连接数")
	private Integer dbConnectNumber;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = false,value="版本" , notes = "版本")
	private String nodeVersion;
	
	/**
	 * 信息：信息
	*/
	@ApiModelProperty(required = false,value="信息" , notes = "信息")
	private String info;
	
	/**
	 * 标签1：标签1
	*/
	@ApiModelProperty(required = false,value="标签1" , notes = "标签1")
	private String label1;
	
	/**
	 * 标签2：标签2
	*/
	@ApiModelProperty(required = false,value="标签2" , notes = "标签2")
	private String label2;
	
	/**
	 * 标签3：标签3
	*/
	@ApiModelProperty(required = false,value="标签3" , notes = "标签3")
	private String label3;
	
	/**
	 * 编码1：编码1
	*/
	@ApiModelProperty(required = false,value="编码1" , notes = "编码1")
	private String code1;
	
	/**
	 * 编码2：编码2
	*/
	@ApiModelProperty(required = false,value="编码2" , notes = "编码2")
	private String code2;
	
	/**
	 * 编码3：编码3
	*/
	@ApiModelProperty(required = false,value="编码3" , notes = "编码3")
	private String code3;
	
	/**
	 * 数值1：数值1
	*/
	@ApiModelProperty(required = false,value="数值1" , notes = "数值1")
	private BigDecimal valueNumber1;
	
	/**
	 * 数值2：数值2
	*/
	@ApiModelProperty(required = false,value="数值2" , notes = "数值2")
	private BigDecimal valueNumber2;
	
	/**
	 * 数值3：数值3
	*/
	@ApiModelProperty(required = false,value="数值3" , notes = "数值3")
	private BigDecimal valueNumber3;
	
	/**
	 * 字符串1：字符串1
	*/
	@ApiModelProperty(required = false,value="字符串1" , notes = "字符串1")
	private String valueStr1;
	
	/**
	 * 字符串2：字符串2
	*/
	@ApiModelProperty(required = false,value="字符串2" , notes = "字符串2")
	private String valueStr2;
	
	/**
	 * 字符串3：字符串3
	*/
	@ApiModelProperty(required = false,value="字符串3" , notes = "字符串3")
	private String valueStr3;
	
	/**
	 * 字符串1：字符串1
	*/
	@ApiModelProperty(required = false,value="字符串1" , notes = "字符串1")
	private String valueBstr1;
	
	/**
	 * 整数1：整数1
	*/
	@ApiModelProperty(required = false,value="整数1" , notes = "整数1")
	private Long valueInt1;
	
	/**
	 * 整数2：整数2
	*/
	@ApiModelProperty(required = false,value="整数2" , notes = "整数2")
	private Long valueInt2;
	
	/**
	 * 整数3：整数3
	*/
	@ApiModelProperty(required = false,value="整数3" , notes = "整数3")
	private Long valueInt3;
	
	/**
	 * 标签列1：标签列1
	*/
	@ApiModelProperty(required = false,value="标签列1" , notes = "标签列1")
	private String listLabel1;
	
	/**
	 * 标签列2：标签列2
	*/
	@ApiModelProperty(required = false,value="标签列2" , notes = "标签列2")
	private String listLabel2;
	
	/**
	 * 标签列3：标签列3
	*/
	@ApiModelProperty(required = false,value="标签列3" , notes = "标签列3")
	private String listLabel3;
	
	/**
	 * 编码列1：编码列1
	*/
	@ApiModelProperty(required = false,value="编码列1" , notes = "编码列1")
	private String listCode1;
	
	/**
	 * 编码列2：编码列2
	*/
	@ApiModelProperty(required = false,value="编码列2" , notes = "编码列2")
	private String listCode2;
	
	/**
	 * 编码列3：编码列3
	*/
	@ApiModelProperty(required = false,value="编码列3" , notes = "编码列3")
	private String listCode3;
	
	/**
	 * 数值列1：数值列1
	*/
	@ApiModelProperty(required = false,value="数值列1" , notes = "数值列1")
	private BigDecimal listValueNumber1;
	
	/**
	 * 数值列2：数值列2
	*/
	@ApiModelProperty(required = false,value="数值列2" , notes = "数值列2")
	private BigDecimal listValueNumber2;
	
	/**
	 * 数值列3：数值列3
	*/
	@ApiModelProperty(required = false,value="数值列3" , notes = "数值列3")
	private BigDecimal listValueNumber3;
	
	/**
	 * 字符串列1：字符串列1
	*/
	@ApiModelProperty(required = false,value="字符串列1" , notes = "字符串列1")
	private String listValueStr1;
	
	/**
	 * 字符串列2：字符串列2
	*/
	@ApiModelProperty(required = false,value="字符串列2" , notes = "字符串列2")
	private String listValueStr2;
	
	/**
	 * 字符串列3：字符串列3
	*/
	@ApiModelProperty(required = false,value="字符串列3" , notes = "字符串列3")
	private String listValueStr3;
	
	/**
	 * 整数列1：整数列1
	*/
	@ApiModelProperty(required = false,value="整数列1" , notes = "整数列1")
	private Long listValueInt1;
	
	/**
	 * 整数列2：整数列2
	*/
	@ApiModelProperty(required = false,value="整数列2" , notes = "整数列2")
	private Long listValueInt2;
	
	/**
	 * 整数列3：整数列3
	*/
	@ApiModelProperty(required = false,value="整数列3" , notes = "整数列3")
	private Long listValueInt3;
	
	/**
	 * 唯一标识：唯一标识
	*/
	@ApiModelProperty(required = false,value="唯一标识" , notes = "唯一标识")
	private String uid;
	
	/**
	 * 是否连接：是否连接
	*/
	@ApiModelProperty(required = false,value="是否连接" , notes = "是否连接" , example = "1")
	private Integer isConnected;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2022-02-15 12:51:34")
	private Date recordTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public MonitorNodeValue setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 节点<br>
	 * 节点
	 * @return 节点
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点
	 * @param nodeId 节点
	 * @return 当前对象
	*/
	public MonitorNodeValue setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 监控模版<br>
	 * 监控模版
	 * @return 监控模版
	*/
	public String getMonitorTplCode() {
		return monitorTplCode;
	}
	
	/**
	 * 设置 监控模版
	 * @param monitorTplCode 监控模版
	 * @return 当前对象
	*/
	public MonitorNodeValue setMonitorTplCode(String monitorTplCode) {
		this.monitorTplCode=monitorTplCode;
		return this;
	}
	
	/**
	 * 获得 结果状态<br>
	 * 结果状态
	 * @return 结果状态
	*/
	public String getResultStatus() {
		return resultStatus;
	}
	
	/**
	 * 设置 结果状态
	 * @param resultStatus 结果状态
	 * @return 当前对象
	*/
	public MonitorNodeValue setResultStatus(String resultStatus) {
		this.resultStatus=resultStatus;
		return this;
	}
	
	/**
	 * 获得 结果内容<br>
	 * 结果内容
	 * @return 结果内容
	*/
	public String getResultMessage() {
		return resultMessage;
	}
	
	/**
	 * 设置 结果内容
	 * @param resultMessage 结果内容
	 * @return 当前对象
	*/
	public MonitorNodeValue setResultMessage(String resultMessage) {
		this.resultMessage=resultMessage;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public String getIndicatorCode() {
		return indicatorCode;
	}
	
	/**
	 * 设置 指标
	 * @param indicatorCode 指标
	 * @return 当前对象
	*/
	public MonitorNodeValue setIndicatorCode(String indicatorCode) {
		this.indicatorCode=indicatorCode;
		return this;
	}
	
	/**
	 * 获得 主机名称<br>
	 * 主机名称
	 * @return 主机名称
	*/
	public String getHostname() {
		return hostname;
	}
	
	/**
	 * 设置 主机名称
	 * @param hostname 主机名称
	 * @return 当前对象
	*/
	public MonitorNodeValue setHostname(String hostname) {
		this.hostname=hostname;
		return this;
	}
	
	/**
	 * 获得 系统时间<br>
	 * 系统时间
	 * @return 系统时间
	*/
	public String getOsDatetime() {
		return osDatetime;
	}
	
	/**
	 * 设置 系统时间
	 * @param osDatetime 系统时间
	 * @return 当前对象
	*/
	public MonitorNodeValue setOsDatetime(String osDatetime) {
		this.osDatetime=osDatetime;
		return this;
	}
	
	/**
	 * 获得 启动时间<br>
	 * 启动时间
	 * @return 启动时间
	*/
	public Date getBoottime() {
		return boottime;
	}
	
	/**
	 * 设置 启动时间
	 * @param boottime 启动时间
	 * @return 当前对象
	*/
	public MonitorNodeValue setBoottime(Date boottime) {
		this.boottime=boottime;
		return this;
	}
	
	/**
	 * 获得 系统<br>
	 * 系统
	 * @return 系统
	*/
	public String getOsVerion() {
		return osVerion;
	}
	
	/**
	 * 设置 系统
	 * @param osVerion 系统
	 * @return 当前对象
	*/
	public MonitorNodeValue setOsVerion(String osVerion) {
		this.osVerion=osVerion;
		return this;
	}
	
	/**
	 * 获得 架构<br>
	 * 架构
	 * @return 架构
	*/
	public String getArch() {
		return arch;
	}
	
	/**
	 * 设置 架构
	 * @param arch 架构
	 * @return 当前对象
	*/
	public MonitorNodeValue setArch(String arch) {
		this.arch=arch;
		return this;
	}
	
	/**
	 * 获得 CPU数量<br>
	 * CPU数量
	 * @return CPU数量
	*/
	public Integer getCpuNumber() {
		return cpuNumber;
	}
	
	/**
	 * 设置 CPU数量
	 * @param cpuNumber CPU数量
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuNumber(Integer cpuNumber) {
		this.cpuNumber=cpuNumber;
		return this;
	}
	
	/**
	 * 获得 CPU主频<br>
	 * CPU主频
	 * @return CPU主频
	*/
	public BigDecimal getCpuFree() {
		return cpuFree;
	}
	
	/**
	 * 设置 CPU主频
	 * @param cpuFree CPU主频
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuFree(BigDecimal cpuFree) {
		this.cpuFree=cpuFree;
		return this;
	}
	
	/**
	 * 获得 cpuSys<br>
	 * cpuSys
	 * @return cpuSys
	*/
	public BigDecimal getCpuSys() {
		return cpuSys;
	}
	
	/**
	 * 设置 cpuSys
	 * @param cpuSys cpuSys
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuSys(BigDecimal cpuSys) {
		this.cpuSys=cpuSys;
		return this;
	}
	
	/**
	 * 获得 cpuUser<br>
	 * cpuUser
	 * @return cpuUser
	*/
	public BigDecimal getCpuUser() {
		return cpuUser;
	}
	
	/**
	 * 设置 cpuUser
	 * @param cpuUser cpuUser
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuUser(BigDecimal cpuUser) {
		this.cpuUser=cpuUser;
		return this;
	}
	
	/**
	 * 获得 cpuWait<br>
	 * cpuWait
	 * @return cpuWait
	*/
	public BigDecimal getCpuWait() {
		return cpuWait;
	}
	
	/**
	 * 设置 cpuWait
	 * @param cpuWait cpuWait
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuWait(BigDecimal cpuWait) {
		this.cpuWait=cpuWait;
		return this;
	}
	
	/**
	 * 获得 CPU空闲旅<br>
	 * CPU空闲旅
	 * @return CPU空闲旅
	*/
	public BigDecimal getCpuIdle() {
		return cpuIdle;
	}
	
	/**
	 * 设置 CPU空闲旅
	 * @param cpuIdle CPU空闲旅
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuIdle(BigDecimal cpuIdle) {
		this.cpuIdle=cpuIdle;
		return this;
	}
	
	/**
	 * 获得 CPU使用率<br>
	 * CPU使用率
	 * @return CPU使用率
	*/
	public BigDecimal getCpuUsed() {
		return cpuUsed;
	}
	
	/**
	 * 设置 CPU使用率
	 * @param cpuUsed CPU使用率
	 * @return 当前对象
	*/
	public MonitorNodeValue setCpuUsed(BigDecimal cpuUsed) {
		this.cpuUsed=cpuUsed;
		return this;
	}
	
	/**
	 * 获得 系统负载<br>
	 * 系统负载
	 * @return 系统负载
	*/
	public BigDecimal getOsLoad() {
		return osLoad;
	}
	
	/**
	 * 设置 系统负载
	 * @param osLoad 系统负载
	 * @return 当前对象
	*/
	public MonitorNodeValue setOsLoad(BigDecimal osLoad) {
		this.osLoad=osLoad;
		return this;
	}
	
	/**
	 * 获得 系统负载5<br>
	 * 系统负载5
	 * @return 系统负载5
	*/
	public BigDecimal getOsLoad5() {
		return osLoad5;
	}
	
	/**
	 * 设置 系统负载5
	 * @param osLoad5 系统负载5
	 * @return 当前对象
	*/
	public MonitorNodeValue setOsLoad5(BigDecimal osLoad5) {
		this.osLoad5=osLoad5;
		return this;
	}
	
	/**
	 * 获得 系统负载15<br>
	 * 系统负载15
	 * @return 系统负载15
	*/
	public BigDecimal getOsLoad15() {
		return osLoad15;
	}
	
	/**
	 * 设置 系统负载15
	 * @param osLoad15 系统负载15
	 * @return 当前对象
	*/
	public MonitorNodeValue setOsLoad15(BigDecimal osLoad15) {
		this.osLoad15=osLoad15;
		return this;
	}
	
	/**
	 * 获得 上行流量<br>
	 * 上行流量
	 * @return 上行流量
	*/
	public BigDecimal getNetworkFlowUp() {
		return networkFlowUp;
	}
	
	/**
	 * 设置 上行流量
	 * @param networkFlowUp 上行流量
	 * @return 当前对象
	*/
	public MonitorNodeValue setNetworkFlowUp(BigDecimal networkFlowUp) {
		this.networkFlowUp=networkFlowUp;
		return this;
	}
	
	/**
	 * 获得 下流量<br>
	 * 下流量
	 * @return 下流量
	*/
	public BigDecimal getNetworkFlowDown() {
		return networkFlowDown;
	}
	
	/**
	 * 设置 下流量
	 * @param networkFlowDown 下流量
	 * @return 当前对象
	*/
	public MonitorNodeValue setNetworkFlowDown(BigDecimal networkFlowDown) {
		this.networkFlowDown=networkFlowDown;
		return this;
	}
	
	/**
	 * 获得 连接数<br>
	 * 连接数
	 * @return 连接数
	*/
	public Integer getProcessCnt() {
		return processCnt;
	}
	
	/**
	 * 设置 连接数
	 * @param processCnt 连接数
	 * @return 当前对象
	*/
	public MonitorNodeValue setProcessCnt(Integer processCnt) {
		this.processCnt=processCnt;
		return this;
	}
	
	/**
	 * 获得 物理内存<br>
	 * M)
	 * @return 物理内存
	*/
	public Long getPMemorySize() {
		return pMemorySize;
	}
	
	/**
	 * 设置 物理内存
	 * @param pMemorySize 物理内存
	 * @return 当前对象
	*/
	public MonitorNodeValue setPMemorySize(Long pMemorySize) {
		this.pMemorySize=pMemorySize;
		return this;
	}
	
	/**
	 * 获得 虚拟内存<br>
	 * M)
	 * @return 虚拟内存
	*/
	public Long getVMemorySize() {
		return vMemorySize;
	}
	
	/**
	 * 设置 虚拟内存
	 * @param vMemorySize 虚拟内存
	 * @return 当前对象
	*/
	public MonitorNodeValue setVMemorySize(Long vMemorySize) {
		this.vMemorySize=vMemorySize;
		return this;
	}
	
	/**
	 * 获得 物理内存使用率<br>
	 * 物理内存使用率
	 * @return 物理内存使用率
	*/
	public BigDecimal getPMemoryUsed() {
		return pMemoryUsed;
	}
	
	/**
	 * 设置 物理内存使用率
	 * @param pMemoryUsed 物理内存使用率
	 * @return 当前对象
	*/
	public MonitorNodeValue setPMemoryUsed(BigDecimal pMemoryUsed) {
		this.pMemoryUsed=pMemoryUsed;
		return this;
	}
	
	/**
	 * 获得 虚拟内存使用率<br>
	 * 虚拟内存使用率
	 * @return 虚拟内存使用率
	*/
	public BigDecimal getVMemoryUsed() {
		return vMemoryUsed;
	}
	
	/**
	 * 设置 虚拟内存使用率
	 * @param vMemoryUsed 虚拟内存使用率
	 * @return 当前对象
	*/
	public MonitorNodeValue setVMemoryUsed(BigDecimal vMemoryUsed) {
		this.vMemoryUsed=vMemoryUsed;
		return this;
	}
	
	/**
	 * 获得 数据库状态<br>
	 * 数据库状态
	 * @return 数据库状态
	*/
	public Integer getDbStatus() {
		return dbStatus;
	}
	
	/**
	 * 设置 数据库状态
	 * @param dbStatus 数据库状态
	 * @return 当前对象
	*/
	public MonitorNodeValue setDbStatus(Integer dbStatus) {
		this.dbStatus=dbStatus;
		return this;
	}
	
	/**
	 * 获得 数据库大小<br>
	 * 数据库大小
	 * @return 数据库大小
	*/
	public Long getDbSize() {
		return dbSize;
	}
	
	/**
	 * 设置 数据库大小
	 * @param dbSize 数据库大小
	 * @return 当前对象
	*/
	public MonitorNodeValue setDbSize(Long dbSize) {
		this.dbSize=dbSize;
		return this;
	}
	
	/**
	 * 获得 数据库连接数<br>
	 * 数据库连接数
	 * @return 数据库连接数
	*/
	public Integer getDbConnectNumber() {
		return dbConnectNumber;
	}
	
	/**
	 * 设置 数据库连接数
	 * @param dbConnectNumber 数据库连接数
	 * @return 当前对象
	*/
	public MonitorNodeValue setDbConnectNumber(Integer dbConnectNumber) {
		this.dbConnectNumber=dbConnectNumber;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public String getNodeVersion() {
		return nodeVersion;
	}
	
	/**
	 * 设置 版本
	 * @param nodeVersion 版本
	 * @return 当前对象
	*/
	public MonitorNodeValue setNodeVersion(String nodeVersion) {
		this.nodeVersion=nodeVersion;
		return this;
	}
	
	/**
	 * 获得 信息<br>
	 * 信息
	 * @return 信息
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 信息
	 * @param info 信息
	 * @return 当前对象
	*/
	public MonitorNodeValue setInfo(String info) {
		this.info=info;
		return this;
	}
	
	/**
	 * 获得 标签1<br>
	 * 标签1
	 * @return 标签1
	*/
	public String getLabel1() {
		return label1;
	}
	
	/**
	 * 设置 标签1
	 * @param label1 标签1
	 * @return 当前对象
	*/
	public MonitorNodeValue setLabel1(String label1) {
		this.label1=label1;
		return this;
	}
	
	/**
	 * 获得 标签2<br>
	 * 标签2
	 * @return 标签2
	*/
	public String getLabel2() {
		return label2;
	}
	
	/**
	 * 设置 标签2
	 * @param label2 标签2
	 * @return 当前对象
	*/
	public MonitorNodeValue setLabel2(String label2) {
		this.label2=label2;
		return this;
	}
	
	/**
	 * 获得 标签3<br>
	 * 标签3
	 * @return 标签3
	*/
	public String getLabel3() {
		return label3;
	}
	
	/**
	 * 设置 标签3
	 * @param label3 标签3
	 * @return 当前对象
	*/
	public MonitorNodeValue setLabel3(String label3) {
		this.label3=label3;
		return this;
	}
	
	/**
	 * 获得 编码1<br>
	 * 编码1
	 * @return 编码1
	*/
	public String getCode1() {
		return code1;
	}
	
	/**
	 * 设置 编码1
	 * @param code1 编码1
	 * @return 当前对象
	*/
	public MonitorNodeValue setCode1(String code1) {
		this.code1=code1;
		return this;
	}
	
	/**
	 * 获得 编码2<br>
	 * 编码2
	 * @return 编码2
	*/
	public String getCode2() {
		return code2;
	}
	
	/**
	 * 设置 编码2
	 * @param code2 编码2
	 * @return 当前对象
	*/
	public MonitorNodeValue setCode2(String code2) {
		this.code2=code2;
		return this;
	}
	
	/**
	 * 获得 编码3<br>
	 * 编码3
	 * @return 编码3
	*/
	public String getCode3() {
		return code3;
	}
	
	/**
	 * 设置 编码3
	 * @param code3 编码3
	 * @return 当前对象
	*/
	public MonitorNodeValue setCode3(String code3) {
		this.code3=code3;
		return this;
	}
	
	/**
	 * 获得 数值1<br>
	 * 数值1
	 * @return 数值1
	*/
	public BigDecimal getValueNumber1() {
		return valueNumber1;
	}
	
	/**
	 * 设置 数值1
	 * @param valueNumber1 数值1
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueNumber1(BigDecimal valueNumber1) {
		this.valueNumber1=valueNumber1;
		return this;
	}
	
	/**
	 * 获得 数值2<br>
	 * 数值2
	 * @return 数值2
	*/
	public BigDecimal getValueNumber2() {
		return valueNumber2;
	}
	
	/**
	 * 设置 数值2
	 * @param valueNumber2 数值2
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueNumber2(BigDecimal valueNumber2) {
		this.valueNumber2=valueNumber2;
		return this;
	}
	
	/**
	 * 获得 数值3<br>
	 * 数值3
	 * @return 数值3
	*/
	public BigDecimal getValueNumber3() {
		return valueNumber3;
	}
	
	/**
	 * 设置 数值3
	 * @param valueNumber3 数值3
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueNumber3(BigDecimal valueNumber3) {
		this.valueNumber3=valueNumber3;
		return this;
	}
	
	/**
	 * 获得 字符串1<br>
	 * 字符串1
	 * @return 字符串1
	*/
	public String getValueStr1() {
		return valueStr1;
	}
	
	/**
	 * 设置 字符串1
	 * @param valueStr1 字符串1
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueStr1(String valueStr1) {
		this.valueStr1=valueStr1;
		return this;
	}
	
	/**
	 * 获得 字符串2<br>
	 * 字符串2
	 * @return 字符串2
	*/
	public String getValueStr2() {
		return valueStr2;
	}
	
	/**
	 * 设置 字符串2
	 * @param valueStr2 字符串2
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueStr2(String valueStr2) {
		this.valueStr2=valueStr2;
		return this;
	}
	
	/**
	 * 获得 字符串3<br>
	 * 字符串3
	 * @return 字符串3
	*/
	public String getValueStr3() {
		return valueStr3;
	}
	
	/**
	 * 设置 字符串3
	 * @param valueStr3 字符串3
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueStr3(String valueStr3) {
		this.valueStr3=valueStr3;
		return this;
	}
	
	/**
	 * 获得 字符串1<br>
	 * 字符串1
	 * @return 字符串1
	*/
	public String getValueBstr1() {
		return valueBstr1;
	}
	
	/**
	 * 设置 字符串1
	 * @param valueBstr1 字符串1
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueBstr1(String valueBstr1) {
		this.valueBstr1=valueBstr1;
		return this;
	}
	
	/**
	 * 获得 整数1<br>
	 * 整数1
	 * @return 整数1
	*/
	public Long getValueInt1() {
		return valueInt1;
	}
	
	/**
	 * 设置 整数1
	 * @param valueInt1 整数1
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueInt1(Long valueInt1) {
		this.valueInt1=valueInt1;
		return this;
	}
	
	/**
	 * 获得 整数2<br>
	 * 整数2
	 * @return 整数2
	*/
	public Long getValueInt2() {
		return valueInt2;
	}
	
	/**
	 * 设置 整数2
	 * @param valueInt2 整数2
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueInt2(Long valueInt2) {
		this.valueInt2=valueInt2;
		return this;
	}
	
	/**
	 * 获得 整数3<br>
	 * 整数3
	 * @return 整数3
	*/
	public Long getValueInt3() {
		return valueInt3;
	}
	
	/**
	 * 设置 整数3
	 * @param valueInt3 整数3
	 * @return 当前对象
	*/
	public MonitorNodeValue setValueInt3(Long valueInt3) {
		this.valueInt3=valueInt3;
		return this;
	}
	
	/**
	 * 获得 标签列1<br>
	 * 标签列1
	 * @return 标签列1
	*/
	public String getListLabel1() {
		return listLabel1;
	}
	
	/**
	 * 设置 标签列1
	 * @param listLabel1 标签列1
	 * @return 当前对象
	*/
	public MonitorNodeValue setListLabel1(String listLabel1) {
		this.listLabel1=listLabel1;
		return this;
	}
	
	/**
	 * 获得 标签列2<br>
	 * 标签列2
	 * @return 标签列2
	*/
	public String getListLabel2() {
		return listLabel2;
	}
	
	/**
	 * 设置 标签列2
	 * @param listLabel2 标签列2
	 * @return 当前对象
	*/
	public MonitorNodeValue setListLabel2(String listLabel2) {
		this.listLabel2=listLabel2;
		return this;
	}
	
	/**
	 * 获得 标签列3<br>
	 * 标签列3
	 * @return 标签列3
	*/
	public String getListLabel3() {
		return listLabel3;
	}
	
	/**
	 * 设置 标签列3
	 * @param listLabel3 标签列3
	 * @return 当前对象
	*/
	public MonitorNodeValue setListLabel3(String listLabel3) {
		this.listLabel3=listLabel3;
		return this;
	}
	
	/**
	 * 获得 编码列1<br>
	 * 编码列1
	 * @return 编码列1
	*/
	public String getListCode1() {
		return listCode1;
	}
	
	/**
	 * 设置 编码列1
	 * @param listCode1 编码列1
	 * @return 当前对象
	*/
	public MonitorNodeValue setListCode1(String listCode1) {
		this.listCode1=listCode1;
		return this;
	}
	
	/**
	 * 获得 编码列2<br>
	 * 编码列2
	 * @return 编码列2
	*/
	public String getListCode2() {
		return listCode2;
	}
	
	/**
	 * 设置 编码列2
	 * @param listCode2 编码列2
	 * @return 当前对象
	*/
	public MonitorNodeValue setListCode2(String listCode2) {
		this.listCode2=listCode2;
		return this;
	}
	
	/**
	 * 获得 编码列3<br>
	 * 编码列3
	 * @return 编码列3
	*/
	public String getListCode3() {
		return listCode3;
	}
	
	/**
	 * 设置 编码列3
	 * @param listCode3 编码列3
	 * @return 当前对象
	*/
	public MonitorNodeValue setListCode3(String listCode3) {
		this.listCode3=listCode3;
		return this;
	}
	
	/**
	 * 获得 数值列1<br>
	 * 数值列1
	 * @return 数值列1
	*/
	public BigDecimal getListValueNumber1() {
		return listValueNumber1;
	}
	
	/**
	 * 设置 数值列1
	 * @param listValueNumber1 数值列1
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueNumber1(BigDecimal listValueNumber1) {
		this.listValueNumber1=listValueNumber1;
		return this;
	}
	
	/**
	 * 获得 数值列2<br>
	 * 数值列2
	 * @return 数值列2
	*/
	public BigDecimal getListValueNumber2() {
		return listValueNumber2;
	}
	
	/**
	 * 设置 数值列2
	 * @param listValueNumber2 数值列2
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueNumber2(BigDecimal listValueNumber2) {
		this.listValueNumber2=listValueNumber2;
		return this;
	}
	
	/**
	 * 获得 数值列3<br>
	 * 数值列3
	 * @return 数值列3
	*/
	public BigDecimal getListValueNumber3() {
		return listValueNumber3;
	}
	
	/**
	 * 设置 数值列3
	 * @param listValueNumber3 数值列3
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueNumber3(BigDecimal listValueNumber3) {
		this.listValueNumber3=listValueNumber3;
		return this;
	}
	
	/**
	 * 获得 字符串列1<br>
	 * 字符串列1
	 * @return 字符串列1
	*/
	public String getListValueStr1() {
		return listValueStr1;
	}
	
	/**
	 * 设置 字符串列1
	 * @param listValueStr1 字符串列1
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueStr1(String listValueStr1) {
		this.listValueStr1=listValueStr1;
		return this;
	}
	
	/**
	 * 获得 字符串列2<br>
	 * 字符串列2
	 * @return 字符串列2
	*/
	public String getListValueStr2() {
		return listValueStr2;
	}
	
	/**
	 * 设置 字符串列2
	 * @param listValueStr2 字符串列2
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueStr2(String listValueStr2) {
		this.listValueStr2=listValueStr2;
		return this;
	}
	
	/**
	 * 获得 字符串列3<br>
	 * 字符串列3
	 * @return 字符串列3
	*/
	public String getListValueStr3() {
		return listValueStr3;
	}
	
	/**
	 * 设置 字符串列3
	 * @param listValueStr3 字符串列3
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueStr3(String listValueStr3) {
		this.listValueStr3=listValueStr3;
		return this;
	}
	
	/**
	 * 获得 整数列1<br>
	 * 整数列1
	 * @return 整数列1
	*/
	public Long getListValueInt1() {
		return listValueInt1;
	}
	
	/**
	 * 设置 整数列1
	 * @param listValueInt1 整数列1
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueInt1(Long listValueInt1) {
		this.listValueInt1=listValueInt1;
		return this;
	}
	
	/**
	 * 获得 整数列2<br>
	 * 整数列2
	 * @return 整数列2
	*/
	public Long getListValueInt2() {
		return listValueInt2;
	}
	
	/**
	 * 设置 整数列2
	 * @param listValueInt2 整数列2
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueInt2(Long listValueInt2) {
		this.listValueInt2=listValueInt2;
		return this;
	}
	
	/**
	 * 获得 整数列3<br>
	 * 整数列3
	 * @return 整数列3
	*/
	public Long getListValueInt3() {
		return listValueInt3;
	}
	
	/**
	 * 设置 整数列3
	 * @param listValueInt3 整数列3
	 * @return 当前对象
	*/
	public MonitorNodeValue setListValueInt3(Long listValueInt3) {
		this.listValueInt3=listValueInt3;
		return this;
	}
	
	/**
	 * 获得 唯一标识<br>
	 * 唯一标识
	 * @return 唯一标识
	*/
	public String getUid() {
		return uid;
	}
	
	/**
	 * 设置 唯一标识
	 * @param uid 唯一标识
	 * @return 当前对象
	*/
	public MonitorNodeValue setUid(String uid) {
		this.uid=uid;
		return this;
	}
	
	/**
	 * 获得 是否连接<br>
	 * 是否连接
	 * @return 是否连接
	*/
	public Integer getIsConnected() {
		return isConnected;
	}
	
	/**
	 * 设置 是否连接
	 * @param isConnected 是否连接
	 * @return 当前对象
	*/
	public MonitorNodeValue setIsConnected(Integer isConnected) {
		this.isConnected=isConnected;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public MonitorNodeValue setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public MonitorNodeValue setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public MonitorNodeValue setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public MonitorNodeValue setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public MonitorNodeValue setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public MonitorNodeValue setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public MonitorNodeValue setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public MonitorNodeValue setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public MonitorNodeValue setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorNodeValue setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNodeValue , 转换好的 MonitorNodeValue 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeValue , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorNodeValue clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorNodeValue duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorNodeValueMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorNodeValueMeta.$$proxy$$();
		inst.setPMemorySize(this.getPMemorySize());
		inst.setOsLoad15(this.getOsLoad15());
		inst.setOsLoad(this.getOsLoad());
		inst.setCpuFree(this.getCpuFree());
		inst.setHostname(this.getHostname());
		inst.setDbConnectNumber(this.getDbConnectNumber());
		inst.setMonitorTplCode(this.getMonitorTplCode());
		inst.setListCode3(this.getListCode3());
		inst.setListCode2(this.getListCode2());
		inst.setId(this.getId());
		inst.setListCode1(this.getListCode1());
		inst.setOsVerion(this.getOsVerion());
		inst.setInfo(this.getInfo());
		inst.setValueBstr1(this.getValueBstr1());
		inst.setOsDatetime(this.getOsDatetime());
		inst.setCpuIdle(this.getCpuIdle());
		inst.setNodeVersion(this.getNodeVersion());
		inst.setVersion(this.getVersion());
		inst.setDbSize(this.getDbSize());
		inst.setVMemorySize(this.getVMemorySize());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBoottime(this.getBoottime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setNodeId(this.getNodeId());
		inst.setNetworkFlowDown(this.getNetworkFlowDown());
		inst.setListLabel2(this.getListLabel2());
		inst.setListValueStr3(this.getListValueStr3());
		inst.setCode3(this.getCode3());
		inst.setListLabel3(this.getListLabel3());
		inst.setListValueStr2(this.getListValueStr2());
		inst.setCode2(this.getCode2());
		inst.setCode1(this.getCode1());
		inst.setCpuUsed(this.getCpuUsed());
		inst.setListValueInt1(this.getListValueInt1());
		inst.setValueNumber2(this.getValueNumber2());
		inst.setListValueStr1(this.getListValueStr1());
		inst.setListValueInt2(this.getListValueInt2());
		inst.setValueNumber3(this.getValueNumber3());
		inst.setListLabel1(this.getListLabel1());
		inst.setListValueInt3(this.getListValueInt3());
		inst.setIsConnected(this.getIsConnected());
		inst.setValueNumber1(this.getValueNumber1());
		inst.setUid(this.getUid());
		inst.setCpuUser(this.getCpuUser());
		inst.setProcessCnt(this.getProcessCnt());
		inst.setCpuSys(this.getCpuSys());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setNetworkFlowUp(this.getNetworkFlowUp());
		inst.setDbStatus(this.getDbStatus());
		inst.setPMemoryUsed(this.getPMemoryUsed());
		inst.setCpuNumber(this.getCpuNumber());
		inst.setValueInt3(this.getValueInt3());
		inst.setValueInt2(this.getValueInt2());
		inst.setValueInt1(this.getValueInt1());
		inst.setListValueNumber2(this.getListValueNumber2());
		inst.setListValueNumber3(this.getListValueNumber3());
		inst.setListValueNumber1(this.getListValueNumber1());
		inst.setIndicatorCode(this.getIndicatorCode());
		inst.setValueStr3(this.getValueStr3());
		inst.setValueStr2(this.getValueStr2());
		inst.setValueStr1(this.getValueStr1());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setResultMessage(this.getResultMessage());
		inst.setLabel1(this.getLabel1());
		inst.setLabel2(this.getLabel2());
		inst.setLabel3(this.getLabel3());
		inst.setResultStatus(this.getResultStatus());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setOsLoad5(this.getOsLoad5());
		inst.setVMemoryUsed(this.getVMemoryUsed());
		inst.setArch(this.getArch());
		inst.setCpuWait(this.getCpuWait());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorNodeValue clone(boolean deep) {
		return EntityContext.clone(MonitorNodeValue.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorNodeValue
	 * @param monitorNodeValueMap 包含实体信息的 Map 对象
	 * @return MonitorNodeValue , 转换好的的 MonitorNodeValue 对象
	*/
	@Transient
	public static MonitorNodeValue createFrom(Map<String,Object> monitorNodeValueMap) {
		if(monitorNodeValueMap==null) return null;
		MonitorNodeValue po = create();
		EntityContext.copyProperties(po,monitorNodeValueMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeValue
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeValue , 转换好的的 MonitorNodeValue 对象
	*/
	@Transient
	public static MonitorNodeValue createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeValue po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorNodeValue，等同于 new
	 * @return MonitorNodeValue 对象
	*/
	@Transient
	public static MonitorNodeValue create() {
		return new com.dt.platform.domain.ops.meta.MonitorNodeValueMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setPMemorySize(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.P_MEMORY_SIZE)));
			this.setOsLoad15(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.OS_LOAD15)));
			this.setOsLoad(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.OS_LOAD)));
			this.setCpuFree(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.CPU_FREE)));
			this.setHostname(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.HOSTNAME)));
			this.setDbConnectNumber(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.DB_CONNECT_NUMBER)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.MONITOR_TPL_CODE)));
			this.setListCode3(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_CODE3)));
			this.setListCode2(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_CODE2)));
			this.setId(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.ID)));
			this.setListCode1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_CODE1)));
			this.setOsVerion(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.OS_VERION)));
			this.setInfo(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.INFO)));
			this.setValueBstr1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.VALUE_BSTR1)));
			this.setOsDatetime(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.OS_DATETIME)));
			this.setCpuIdle(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.CPU_IDLE)));
			this.setNodeVersion(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.NODE_VERSION)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.VERSION)));
			this.setDbSize(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.DB_SIZE)));
			this.setVMemorySize(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.V_MEMORY_SIZE)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorNodeValueMeta.DELETE_TIME)));
			this.setBoottime(DataParser.parse(Date.class, map.get(MonitorNodeValueMeta.BOOTTIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.DELETE_BY)));
			this.setNodeId(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.NODE_ID)));
			this.setNetworkFlowDown(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.NETWORK_FLOW_DOWN)));
			this.setListLabel2(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_LABEL2)));
			this.setListValueStr3(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_VALUE_STR3)));
			this.setCode3(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.CODE3)));
			this.setListLabel3(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_LABEL3)));
			this.setListValueStr2(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_VALUE_STR2)));
			this.setCode2(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.CODE2)));
			this.setCode1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.CODE1)));
			this.setCpuUsed(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.CPU_USED)));
			this.setListValueInt1(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.LIST_VALUE_INT1)));
			this.setValueNumber2(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.VALUE_NUMBER2)));
			this.setListValueStr1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_VALUE_STR1)));
			this.setListValueInt2(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.LIST_VALUE_INT2)));
			this.setValueNumber3(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.VALUE_NUMBER3)));
			this.setListLabel1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LIST_LABEL1)));
			this.setListValueInt3(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.LIST_VALUE_INT3)));
			this.setIsConnected(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.IS_CONNECTED)));
			this.setValueNumber1(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.VALUE_NUMBER1)));
			this.setUid(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.UID)));
			this.setCpuUser(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.CPU_USER)));
			this.setProcessCnt(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.PROCESS_CNT)));
			this.setCpuSys(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.CPU_SYS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.UPDATE_BY)));
			this.setNetworkFlowUp(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.NETWORK_FLOW_UP)));
			this.setDbStatus(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.DB_STATUS)));
			this.setPMemoryUsed(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.P_MEMORY_USED)));
			this.setCpuNumber(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.CPU_NUMBER)));
			this.setValueInt3(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.VALUE_INT3)));
			this.setValueInt2(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.VALUE_INT2)));
			this.setValueInt1(DataParser.parse(Long.class, map.get(MonitorNodeValueMeta.VALUE_INT1)));
			this.setListValueNumber2(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.LIST_VALUE_NUMBER2)));
			this.setListValueNumber3(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.LIST_VALUE_NUMBER3)));
			this.setListValueNumber1(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.LIST_VALUE_NUMBER1)));
			this.setIndicatorCode(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.INDICATOR_CODE)));
			this.setValueStr3(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.VALUE_STR3)));
			this.setValueStr2(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.VALUE_STR2)));
			this.setValueStr1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.VALUE_STR1)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorNodeValueMeta.UPDATE_TIME)));
			this.setResultMessage(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.RESULT_MESSAGE)));
			this.setLabel1(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LABEL1)));
			this.setLabel2(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.LABEL3)));
			this.setResultStatus(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.RESULT_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(MonitorNodeValueMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorNodeValueMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorNodeValueMeta.CREATE_TIME)));
			this.setOsLoad5(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.OS_LOAD5)));
			this.setVMemoryUsed(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.V_MEMORY_USED)));
			this.setArch(DataParser.parse(String.class, map.get(MonitorNodeValueMeta.ARCH)));
			this.setCpuWait(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueMeta.CPU_WAIT)));
			// others
			return true;
		} else {
			try {
				this.setPMemorySize( (Long)map.get(MonitorNodeValueMeta.P_MEMORY_SIZE));
				this.setOsLoad15( (BigDecimal)map.get(MonitorNodeValueMeta.OS_LOAD15));
				this.setOsLoad( (BigDecimal)map.get(MonitorNodeValueMeta.OS_LOAD));
				this.setCpuFree( (BigDecimal)map.get(MonitorNodeValueMeta.CPU_FREE));
				this.setHostname( (String)map.get(MonitorNodeValueMeta.HOSTNAME));
				this.setDbConnectNumber( (Integer)map.get(MonitorNodeValueMeta.DB_CONNECT_NUMBER));
				this.setMonitorTplCode( (String)map.get(MonitorNodeValueMeta.MONITOR_TPL_CODE));
				this.setListCode3( (String)map.get(MonitorNodeValueMeta.LIST_CODE3));
				this.setListCode2( (String)map.get(MonitorNodeValueMeta.LIST_CODE2));
				this.setId( (String)map.get(MonitorNodeValueMeta.ID));
				this.setListCode1( (String)map.get(MonitorNodeValueMeta.LIST_CODE1));
				this.setOsVerion( (String)map.get(MonitorNodeValueMeta.OS_VERION));
				this.setInfo( (String)map.get(MonitorNodeValueMeta.INFO));
				this.setValueBstr1( (String)map.get(MonitorNodeValueMeta.VALUE_BSTR1));
				this.setOsDatetime( (String)map.get(MonitorNodeValueMeta.OS_DATETIME));
				this.setCpuIdle( (BigDecimal)map.get(MonitorNodeValueMeta.CPU_IDLE));
				this.setNodeVersion( (String)map.get(MonitorNodeValueMeta.NODE_VERSION));
				this.setVersion( (Integer)map.get(MonitorNodeValueMeta.VERSION));
				this.setDbSize( (Long)map.get(MonitorNodeValueMeta.DB_SIZE));
				this.setVMemorySize( (Long)map.get(MonitorNodeValueMeta.V_MEMORY_SIZE));
				this.setDeleteTime( (Date)map.get(MonitorNodeValueMeta.DELETE_TIME));
				this.setBoottime( (Date)map.get(MonitorNodeValueMeta.BOOTTIME));
				this.setDeleteBy( (String)map.get(MonitorNodeValueMeta.DELETE_BY));
				this.setNodeId( (String)map.get(MonitorNodeValueMeta.NODE_ID));
				this.setNetworkFlowDown( (BigDecimal)map.get(MonitorNodeValueMeta.NETWORK_FLOW_DOWN));
				this.setListLabel2( (String)map.get(MonitorNodeValueMeta.LIST_LABEL2));
				this.setListValueStr3( (String)map.get(MonitorNodeValueMeta.LIST_VALUE_STR3));
				this.setCode3( (String)map.get(MonitorNodeValueMeta.CODE3));
				this.setListLabel3( (String)map.get(MonitorNodeValueMeta.LIST_LABEL3));
				this.setListValueStr2( (String)map.get(MonitorNodeValueMeta.LIST_VALUE_STR2));
				this.setCode2( (String)map.get(MonitorNodeValueMeta.CODE2));
				this.setCode1( (String)map.get(MonitorNodeValueMeta.CODE1));
				this.setCpuUsed( (BigDecimal)map.get(MonitorNodeValueMeta.CPU_USED));
				this.setListValueInt1( (Long)map.get(MonitorNodeValueMeta.LIST_VALUE_INT1));
				this.setValueNumber2( (BigDecimal)map.get(MonitorNodeValueMeta.VALUE_NUMBER2));
				this.setListValueStr1( (String)map.get(MonitorNodeValueMeta.LIST_VALUE_STR1));
				this.setListValueInt2( (Long)map.get(MonitorNodeValueMeta.LIST_VALUE_INT2));
				this.setValueNumber3( (BigDecimal)map.get(MonitorNodeValueMeta.VALUE_NUMBER3));
				this.setListLabel1( (String)map.get(MonitorNodeValueMeta.LIST_LABEL1));
				this.setListValueInt3( (Long)map.get(MonitorNodeValueMeta.LIST_VALUE_INT3));
				this.setIsConnected( (Integer)map.get(MonitorNodeValueMeta.IS_CONNECTED));
				this.setValueNumber1( (BigDecimal)map.get(MonitorNodeValueMeta.VALUE_NUMBER1));
				this.setUid( (String)map.get(MonitorNodeValueMeta.UID));
				this.setCpuUser( (BigDecimal)map.get(MonitorNodeValueMeta.CPU_USER));
				this.setProcessCnt( (Integer)map.get(MonitorNodeValueMeta.PROCESS_CNT));
				this.setCpuSys( (BigDecimal)map.get(MonitorNodeValueMeta.CPU_SYS));
				this.setUpdateBy( (String)map.get(MonitorNodeValueMeta.UPDATE_BY));
				this.setNetworkFlowUp( (BigDecimal)map.get(MonitorNodeValueMeta.NETWORK_FLOW_UP));
				this.setDbStatus( (Integer)map.get(MonitorNodeValueMeta.DB_STATUS));
				this.setPMemoryUsed( (BigDecimal)map.get(MonitorNodeValueMeta.P_MEMORY_USED));
				this.setCpuNumber( (Integer)map.get(MonitorNodeValueMeta.CPU_NUMBER));
				this.setValueInt3( (Long)map.get(MonitorNodeValueMeta.VALUE_INT3));
				this.setValueInt2( (Long)map.get(MonitorNodeValueMeta.VALUE_INT2));
				this.setValueInt1( (Long)map.get(MonitorNodeValueMeta.VALUE_INT1));
				this.setListValueNumber2( (BigDecimal)map.get(MonitorNodeValueMeta.LIST_VALUE_NUMBER2));
				this.setListValueNumber3( (BigDecimal)map.get(MonitorNodeValueMeta.LIST_VALUE_NUMBER3));
				this.setListValueNumber1( (BigDecimal)map.get(MonitorNodeValueMeta.LIST_VALUE_NUMBER1));
				this.setIndicatorCode( (String)map.get(MonitorNodeValueMeta.INDICATOR_CODE));
				this.setValueStr3( (String)map.get(MonitorNodeValueMeta.VALUE_STR3));
				this.setValueStr2( (String)map.get(MonitorNodeValueMeta.VALUE_STR2));
				this.setValueStr1( (String)map.get(MonitorNodeValueMeta.VALUE_STR1));
				this.setUpdateTime( (Date)map.get(MonitorNodeValueMeta.UPDATE_TIME));
				this.setResultMessage( (String)map.get(MonitorNodeValueMeta.RESULT_MESSAGE));
				this.setLabel1( (String)map.get(MonitorNodeValueMeta.LABEL1));
				this.setLabel2( (String)map.get(MonitorNodeValueMeta.LABEL2));
				this.setLabel3( (String)map.get(MonitorNodeValueMeta.LABEL3));
				this.setResultStatus( (String)map.get(MonitorNodeValueMeta.RESULT_STATUS));
				this.setCreateBy( (String)map.get(MonitorNodeValueMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(MonitorNodeValueMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(MonitorNodeValueMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorNodeValueMeta.CREATE_TIME));
				this.setOsLoad5( (BigDecimal)map.get(MonitorNodeValueMeta.OS_LOAD5));
				this.setVMemoryUsed( (BigDecimal)map.get(MonitorNodeValueMeta.V_MEMORY_USED));
				this.setArch( (String)map.get(MonitorNodeValueMeta.ARCH));
				this.setCpuWait( (BigDecimal)map.get(MonitorNodeValueMeta.CPU_WAIT));
				// others
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setPMemorySize(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.P_MEMORY_SIZE)));
			this.setOsLoad15(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.OS_LOAD15)));
			this.setOsLoad(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.OS_LOAD)));
			this.setCpuFree(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.CPU_FREE)));
			this.setHostname(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.HOSTNAME)));
			this.setDbConnectNumber(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.DB_CONNECT_NUMBER)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.MONITOR_TPL_CODE)));
			this.setListCode3(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_CODE3)));
			this.setListCode2(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_CODE2)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.ID)));
			this.setListCode1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_CODE1)));
			this.setOsVerion(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.OS_VERION)));
			this.setInfo(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.INFO)));
			this.setValueBstr1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.VALUE_BSTR1)));
			this.setOsDatetime(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.OS_DATETIME)));
			this.setCpuIdle(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.CPU_IDLE)));
			this.setNodeVersion(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.NODE_VERSION)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.VERSION)));
			this.setDbSize(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.DB_SIZE)));
			this.setVMemorySize(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.V_MEMORY_SIZE)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueMeta.DELETE_TIME)));
			this.setBoottime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueMeta.BOOTTIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.DELETE_BY)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.NODE_ID)));
			this.setNetworkFlowDown(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.NETWORK_FLOW_DOWN)));
			this.setListLabel2(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_LABEL2)));
			this.setListValueStr3(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_STR3)));
			this.setCode3(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.CODE3)));
			this.setListLabel3(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_LABEL3)));
			this.setListValueStr2(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_STR2)));
			this.setCode2(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.CODE2)));
			this.setCode1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.CODE1)));
			this.setCpuUsed(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.CPU_USED)));
			this.setListValueInt1(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_INT1)));
			this.setValueNumber2(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.VALUE_NUMBER2)));
			this.setListValueStr1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_STR1)));
			this.setListValueInt2(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_INT2)));
			this.setValueNumber3(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.VALUE_NUMBER3)));
			this.setListLabel1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LIST_LABEL1)));
			this.setListValueInt3(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_INT3)));
			this.setIsConnected(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.IS_CONNECTED)));
			this.setValueNumber1(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.VALUE_NUMBER1)));
			this.setUid(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.UID)));
			this.setCpuUser(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.CPU_USER)));
			this.setProcessCnt(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.PROCESS_CNT)));
			this.setCpuSys(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.CPU_SYS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.UPDATE_BY)));
			this.setNetworkFlowUp(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.NETWORK_FLOW_UP)));
			this.setDbStatus(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.DB_STATUS)));
			this.setPMemoryUsed(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.P_MEMORY_USED)));
			this.setCpuNumber(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.CPU_NUMBER)));
			this.setValueInt3(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.VALUE_INT3)));
			this.setValueInt2(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.VALUE_INT2)));
			this.setValueInt1(DataParser.parse(Long.class, r.getValue(MonitorNodeValueMeta.VALUE_INT1)));
			this.setListValueNumber2(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_NUMBER2)));
			this.setListValueNumber3(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_NUMBER3)));
			this.setListValueNumber1(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.LIST_VALUE_NUMBER1)));
			this.setIndicatorCode(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.INDICATOR_CODE)));
			this.setValueStr3(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.VALUE_STR3)));
			this.setValueStr2(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.VALUE_STR2)));
			this.setValueStr1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.VALUE_STR1)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueMeta.UPDATE_TIME)));
			this.setResultMessage(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.RESULT_MESSAGE)));
			this.setLabel1(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LABEL1)));
			this.setLabel2(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.LABEL3)));
			this.setResultStatus(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.RESULT_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueMeta.CREATE_TIME)));
			this.setOsLoad5(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.OS_LOAD5)));
			this.setVMemoryUsed(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.V_MEMORY_USED)));
			this.setArch(DataParser.parse(String.class, r.getValue(MonitorNodeValueMeta.ARCH)));
			this.setCpuWait(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueMeta.CPU_WAIT)));
			return true;
		} else {
			try {
				this.setPMemorySize( (Long)r.getValue(MonitorNodeValueMeta.P_MEMORY_SIZE));
				this.setOsLoad15( (BigDecimal)r.getValue(MonitorNodeValueMeta.OS_LOAD15));
				this.setOsLoad( (BigDecimal)r.getValue(MonitorNodeValueMeta.OS_LOAD));
				this.setCpuFree( (BigDecimal)r.getValue(MonitorNodeValueMeta.CPU_FREE));
				this.setHostname( (String)r.getValue(MonitorNodeValueMeta.HOSTNAME));
				this.setDbConnectNumber( (Integer)r.getValue(MonitorNodeValueMeta.DB_CONNECT_NUMBER));
				this.setMonitorTplCode( (String)r.getValue(MonitorNodeValueMeta.MONITOR_TPL_CODE));
				this.setListCode3( (String)r.getValue(MonitorNodeValueMeta.LIST_CODE3));
				this.setListCode2( (String)r.getValue(MonitorNodeValueMeta.LIST_CODE2));
				this.setId( (String)r.getValue(MonitorNodeValueMeta.ID));
				this.setListCode1( (String)r.getValue(MonitorNodeValueMeta.LIST_CODE1));
				this.setOsVerion( (String)r.getValue(MonitorNodeValueMeta.OS_VERION));
				this.setInfo( (String)r.getValue(MonitorNodeValueMeta.INFO));
				this.setValueBstr1( (String)r.getValue(MonitorNodeValueMeta.VALUE_BSTR1));
				this.setOsDatetime( (String)r.getValue(MonitorNodeValueMeta.OS_DATETIME));
				this.setCpuIdle( (BigDecimal)r.getValue(MonitorNodeValueMeta.CPU_IDLE));
				this.setNodeVersion( (String)r.getValue(MonitorNodeValueMeta.NODE_VERSION));
				this.setVersion( (Integer)r.getValue(MonitorNodeValueMeta.VERSION));
				this.setDbSize( (Long)r.getValue(MonitorNodeValueMeta.DB_SIZE));
				this.setVMemorySize( (Long)r.getValue(MonitorNodeValueMeta.V_MEMORY_SIZE));
				this.setDeleteTime( (Date)r.getValue(MonitorNodeValueMeta.DELETE_TIME));
				this.setBoottime( (Date)r.getValue(MonitorNodeValueMeta.BOOTTIME));
				this.setDeleteBy( (String)r.getValue(MonitorNodeValueMeta.DELETE_BY));
				this.setNodeId( (String)r.getValue(MonitorNodeValueMeta.NODE_ID));
				this.setNetworkFlowDown( (BigDecimal)r.getValue(MonitorNodeValueMeta.NETWORK_FLOW_DOWN));
				this.setListLabel2( (String)r.getValue(MonitorNodeValueMeta.LIST_LABEL2));
				this.setListValueStr3( (String)r.getValue(MonitorNodeValueMeta.LIST_VALUE_STR3));
				this.setCode3( (String)r.getValue(MonitorNodeValueMeta.CODE3));
				this.setListLabel3( (String)r.getValue(MonitorNodeValueMeta.LIST_LABEL3));
				this.setListValueStr2( (String)r.getValue(MonitorNodeValueMeta.LIST_VALUE_STR2));
				this.setCode2( (String)r.getValue(MonitorNodeValueMeta.CODE2));
				this.setCode1( (String)r.getValue(MonitorNodeValueMeta.CODE1));
				this.setCpuUsed( (BigDecimal)r.getValue(MonitorNodeValueMeta.CPU_USED));
				this.setListValueInt1( (Long)r.getValue(MonitorNodeValueMeta.LIST_VALUE_INT1));
				this.setValueNumber2( (BigDecimal)r.getValue(MonitorNodeValueMeta.VALUE_NUMBER2));
				this.setListValueStr1( (String)r.getValue(MonitorNodeValueMeta.LIST_VALUE_STR1));
				this.setListValueInt2( (Long)r.getValue(MonitorNodeValueMeta.LIST_VALUE_INT2));
				this.setValueNumber3( (BigDecimal)r.getValue(MonitorNodeValueMeta.VALUE_NUMBER3));
				this.setListLabel1( (String)r.getValue(MonitorNodeValueMeta.LIST_LABEL1));
				this.setListValueInt3( (Long)r.getValue(MonitorNodeValueMeta.LIST_VALUE_INT3));
				this.setIsConnected( (Integer)r.getValue(MonitorNodeValueMeta.IS_CONNECTED));
				this.setValueNumber1( (BigDecimal)r.getValue(MonitorNodeValueMeta.VALUE_NUMBER1));
				this.setUid( (String)r.getValue(MonitorNodeValueMeta.UID));
				this.setCpuUser( (BigDecimal)r.getValue(MonitorNodeValueMeta.CPU_USER));
				this.setProcessCnt( (Integer)r.getValue(MonitorNodeValueMeta.PROCESS_CNT));
				this.setCpuSys( (BigDecimal)r.getValue(MonitorNodeValueMeta.CPU_SYS));
				this.setUpdateBy( (String)r.getValue(MonitorNodeValueMeta.UPDATE_BY));
				this.setNetworkFlowUp( (BigDecimal)r.getValue(MonitorNodeValueMeta.NETWORK_FLOW_UP));
				this.setDbStatus( (Integer)r.getValue(MonitorNodeValueMeta.DB_STATUS));
				this.setPMemoryUsed( (BigDecimal)r.getValue(MonitorNodeValueMeta.P_MEMORY_USED));
				this.setCpuNumber( (Integer)r.getValue(MonitorNodeValueMeta.CPU_NUMBER));
				this.setValueInt3( (Long)r.getValue(MonitorNodeValueMeta.VALUE_INT3));
				this.setValueInt2( (Long)r.getValue(MonitorNodeValueMeta.VALUE_INT2));
				this.setValueInt1( (Long)r.getValue(MonitorNodeValueMeta.VALUE_INT1));
				this.setListValueNumber2( (BigDecimal)r.getValue(MonitorNodeValueMeta.LIST_VALUE_NUMBER2));
				this.setListValueNumber3( (BigDecimal)r.getValue(MonitorNodeValueMeta.LIST_VALUE_NUMBER3));
				this.setListValueNumber1( (BigDecimal)r.getValue(MonitorNodeValueMeta.LIST_VALUE_NUMBER1));
				this.setIndicatorCode( (String)r.getValue(MonitorNodeValueMeta.INDICATOR_CODE));
				this.setValueStr3( (String)r.getValue(MonitorNodeValueMeta.VALUE_STR3));
				this.setValueStr2( (String)r.getValue(MonitorNodeValueMeta.VALUE_STR2));
				this.setValueStr1( (String)r.getValue(MonitorNodeValueMeta.VALUE_STR1));
				this.setUpdateTime( (Date)r.getValue(MonitorNodeValueMeta.UPDATE_TIME));
				this.setResultMessage( (String)r.getValue(MonitorNodeValueMeta.RESULT_MESSAGE));
				this.setLabel1( (String)r.getValue(MonitorNodeValueMeta.LABEL1));
				this.setLabel2( (String)r.getValue(MonitorNodeValueMeta.LABEL2));
				this.setLabel3( (String)r.getValue(MonitorNodeValueMeta.LABEL3));
				this.setResultStatus( (String)r.getValue(MonitorNodeValueMeta.RESULT_STATUS));
				this.setCreateBy( (String)r.getValue(MonitorNodeValueMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(MonitorNodeValueMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(MonitorNodeValueMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorNodeValueMeta.CREATE_TIME));
				this.setOsLoad5( (BigDecimal)r.getValue(MonitorNodeValueMeta.OS_LOAD5));
				this.setVMemoryUsed( (BigDecimal)r.getValue(MonitorNodeValueMeta.V_MEMORY_USED));
				this.setArch( (String)r.getValue(MonitorNodeValueMeta.ARCH));
				this.setCpuWait( (BigDecimal)r.getValue(MonitorNodeValueMeta.CPU_WAIT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}