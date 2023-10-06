package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_ALERT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorAlertMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 监控告警
 * <p>监控告警 , 数据表 ops_monitor_alert 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-06 09:23:02
 * @sign E4E5F72A11835EED1424178582CF5C76
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_alert")
@ApiModel(description = "监控告警 ; 监控告警 , 数据表 ops_monitor_alert 的PO类型")
public class MonitorAlert extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_ALERT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "762451881111846912")
	private String id;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点" , example = "761202990320189440")
	private String nodeId;
	
	/**
	 * 处理状态：处理状态
	*/
	@ApiModelProperty(required = false,value="处理状态" , notes = "处理状态" , example = "not_confirm")
	private String status;
	
	/**
	 * 告警等级：告警等级
	*/
	@ApiModelProperty(required = false,value="告警等级" , notes = "告警等级" , example = "high")
	private String warnLevel;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点" , example = "Demo_MySQL(121.43.103.102)")
	private String nodeShowName;
	
	/**
	 * 触发器：触发器
	*/
	@ApiModelProperty(required = false,value="触发器" , notes = "触发器" , example = "762392151718887424")
	private String triggerId;
	
	/**
	 * 触发器：触发器
	*/
	@ApiModelProperty(required = false,value="触发器" , notes = "触发器" , example = "数据库连接数")
	private String triggerName;
	
	/**
	 * 规则描述：规则描述
	*/
	@ApiModelProperty(required = false,value="规则描述" , notes = "规则描述" , example = "数据库连接数大于10")
	private String triggerRuleDesc;
	
	/**
	 * 监控数值：监控数值
	*/
	@ApiModelProperty(required = false,value="监控数值" , notes = "监控数值" , example = "82")
	private String alertValue;
	
	/**
	 * 告警时间：告警时间
	*/
	@ApiModelProperty(required = false,value="告警时间" , notes = "告警时间" , example = "2023-10-05 11:11:34")
	private Date warnTime;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间")
	private Date handledTime;
	
	/**
	 * 处理人：处理人
	*/
	@ApiModelProperty(required = false,value="处理人" , notes = "处理人")
	private String userId;
	
	/**
	 * 处理内容：处理内容
	*/
	@ApiModelProperty(required = false,value="处理内容" , notes = "处理内容")
	private String processMessage;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版")
	private String monitorTplCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-05 11:11:34")
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
	 * 节点模版：节点模版
	*/
	@ApiModelProperty(required = false,value="节点模版" , notes = "节点模版")
	private MonitorTpl tpl;
	
	/**
	 * monitorTplTrigger：monitorTplTrigger
	*/
	@ApiModelProperty(required = false,value="monitorTplTrigger" , notes = "monitorTplTrigger")
	private List<MonitorTplTrigger> monitorTplTrigger;
	
	/**
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Employee user;
	
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
	public MonitorAlert setId(String id) {
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
	public MonitorAlert setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 处理状态<br>
	 * 处理状态
	 * @return 处理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 处理状态
	 * @param status 处理状态
	 * @return 当前对象
	*/
	public MonitorAlert setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 告警等级<br>
	 * 告警等级
	 * @return 告警等级
	*/
	public String getWarnLevel() {
		return warnLevel;
	}
	
	/**
	 * 设置 告警等级
	 * @param warnLevel 告警等级
	 * @return 当前对象
	*/
	public MonitorAlert setWarnLevel(String warnLevel) {
		this.warnLevel=warnLevel;
		return this;
	}
	
	/**
	 * 获得 节点<br>
	 * 节点
	 * @return 节点
	*/
	public String getNodeShowName() {
		return nodeShowName;
	}
	
	/**
	 * 设置 节点
	 * @param nodeShowName 节点
	 * @return 当前对象
	*/
	public MonitorAlert setNodeShowName(String nodeShowName) {
		this.nodeShowName=nodeShowName;
		return this;
	}
	
	/**
	 * 获得 触发器<br>
	 * 触发器
	 * @return 触发器
	*/
	public String getTriggerId() {
		return triggerId;
	}
	
	/**
	 * 设置 触发器
	 * @param triggerId 触发器
	 * @return 当前对象
	*/
	public MonitorAlert setTriggerId(String triggerId) {
		this.triggerId=triggerId;
		return this;
	}
	
	/**
	 * 获得 触发器<br>
	 * 触发器
	 * @return 触发器
	*/
	public String getTriggerName() {
		return triggerName;
	}
	
	/**
	 * 设置 触发器
	 * @param triggerName 触发器
	 * @return 当前对象
	*/
	public MonitorAlert setTriggerName(String triggerName) {
		this.triggerName=triggerName;
		return this;
	}
	
	/**
	 * 获得 规则描述<br>
	 * 规则描述
	 * @return 规则描述
	*/
	public String getTriggerRuleDesc() {
		return triggerRuleDesc;
	}
	
	/**
	 * 设置 规则描述
	 * @param triggerRuleDesc 规则描述
	 * @return 当前对象
	*/
	public MonitorAlert setTriggerRuleDesc(String triggerRuleDesc) {
		this.triggerRuleDesc=triggerRuleDesc;
		return this;
	}
	
	/**
	 * 获得 监控数值<br>
	 * 监控数值
	 * @return 监控数值
	*/
	public String getAlertValue() {
		return alertValue;
	}
	
	/**
	 * 设置 监控数值
	 * @param alertValue 监控数值
	 * @return 当前对象
	*/
	public MonitorAlert setAlertValue(String alertValue) {
		this.alertValue=alertValue;
		return this;
	}
	
	/**
	 * 获得 告警时间<br>
	 * 告警时间
	 * @return 告警时间
	*/
	public Date getWarnTime() {
		return warnTime;
	}
	
	/**
	 * 设置 告警时间
	 * @param warnTime 告警时间
	 * @return 当前对象
	*/
	public MonitorAlert setWarnTime(Date warnTime) {
		this.warnTime=warnTime;
		return this;
	}
	
	/**
	 * 获得 处理时间<br>
	 * 处理时间
	 * @return 处理时间
	*/
	public Date getHandledTime() {
		return handledTime;
	}
	
	/**
	 * 设置 处理时间
	 * @param handledTime 处理时间
	 * @return 当前对象
	*/
	public MonitorAlert setHandledTime(Date handledTime) {
		this.handledTime=handledTime;
		return this;
	}
	
	/**
	 * 获得 处理人<br>
	 * 处理人
	 * @return 处理人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 处理人
	 * @param userId 处理人
	 * @return 当前对象
	*/
	public MonitorAlert setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 处理内容<br>
	 * 处理内容
	 * @return 处理内容
	*/
	public String getProcessMessage() {
		return processMessage;
	}
	
	/**
	 * 设置 处理内容
	 * @param processMessage 处理内容
	 * @return 当前对象
	*/
	public MonitorAlert setProcessMessage(String processMessage) {
		this.processMessage=processMessage;
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
	public MonitorAlert setMonitorTplCode(String monitorTplCode) {
		this.monitorTplCode=monitorTplCode;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public MonitorAlert setNotes(String notes) {
		this.notes=notes;
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
	public MonitorAlert setCreateBy(String createBy) {
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
	public MonitorAlert setCreateTime(Date createTime) {
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
	public MonitorAlert setUpdateBy(String updateBy) {
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
	public MonitorAlert setUpdateTime(Date updateTime) {
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
	public MonitorAlert setDeleted(Integer deleted) {
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
	public MonitorAlert setDeleted(Boolean deletedBool) {
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
	public MonitorAlert setDeleteBy(String deleteBy) {
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
	public MonitorAlert setDeleteTime(Date deleteTime) {
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
	public MonitorAlert setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 节点模版<br>
	 * 节点模版
	 * @return 节点模版
	*/
	public MonitorTpl getTpl() {
		return tpl;
	}
	
	/**
	 * 设置 节点模版
	 * @param tpl 节点模版
	 * @return 当前对象
	*/
	public MonitorAlert setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}
	
	/**
	 * 获得 monitorTplTrigger<br>
	 * monitorTplTrigger
	 * @return monitorTplTrigger
	*/
	public List<MonitorTplTrigger> getMonitorTplTrigger() {
		return monitorTplTrigger;
	}
	
	/**
	 * 设置 monitorTplTrigger
	 * @param monitorTplTrigger monitorTplTrigger
	 * @return 当前对象
	*/
	public MonitorAlert setMonitorTplTrigger(List<MonitorTplTrigger> monitorTplTrigger) {
		this.monitorTplTrigger=monitorTplTrigger;
		return this;
	}
	
	/**
	 * 添加 monitorTplTrigger
	 * @param entity monitorTplTrigger
	 * @return 当前对象
	*/
	public MonitorAlert addMonitorTplTrigger(MonitorTplTrigger... entity) {
		if(this.monitorTplTrigger==null) monitorTplTrigger=new ArrayList<>();
		this.monitorTplTrigger.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 user<br>
	 * user
	 * @return user
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 user
	 * @param user user
	 * @return 当前对象
	*/
	public MonitorAlert setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorAlert , 转换好的 MonitorAlert 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorAlert , 转换好的 PoJo 对象
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
	public MonitorAlert clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorAlert duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorAlertMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorAlertMeta.$$proxy$$();
		inst.setProcessMessage(this.getProcessMessage());
		inst.setNotes(this.getNotes());
		inst.setWarnLevel(this.getWarnLevel());
		inst.setTriggerName(this.getTriggerName());
		inst.setTriggerId(this.getTriggerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setHandledTime(this.getHandledTime());
		inst.setWarnTime(this.getWarnTime());
		inst.setMonitorTplCode(this.getMonitorTplCode());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTriggerRuleDesc(this.getTriggerRuleDesc());
		inst.setNodeShowName(this.getNodeShowName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setNodeId(this.getNodeId());
		inst.setAlertValue(this.getAlertValue());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setTpl(this.getTpl());
			inst.setMonitorTplTrigger(this.getMonitorTplTrigger());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlert clone(boolean deep) {
		return EntityContext.clone(MonitorAlert.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorAlert
	 * @param monitorAlertMap 包含实体信息的 Map 对象
	 * @return MonitorAlert , 转换好的的 MonitorAlert 对象
	*/
	@Transient
	public static MonitorAlert createFrom(Map<String,Object> monitorAlertMap) {
		if(monitorAlertMap==null) return null;
		MonitorAlert po = create();
		EntityContext.copyProperties(po,monitorAlertMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorAlert
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorAlert , 转换好的的 MonitorAlert 对象
	*/
	@Transient
	public static MonitorAlert createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorAlert po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorAlert，等同于 new
	 * @return MonitorAlert 对象
	*/
	@Transient
	public static MonitorAlert create() {
		return new com.dt.platform.domain.ops.meta.MonitorAlertMeta.$$proxy$$();
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
			this.setProcessMessage(DataParser.parse(String.class, map.get(MonitorAlertMeta.PROCESS_MESSAGE)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorAlertMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, map.get(MonitorAlertMeta.WARN_LEVEL)));
			this.setTriggerName(DataParser.parse(String.class, map.get(MonitorAlertMeta.TRIGGER_NAME)));
			this.setTriggerId(DataParser.parse(String.class, map.get(MonitorAlertMeta.TRIGGER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorAlertMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(MonitorAlertMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorAlertMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorAlertMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorAlertMeta.DELETED)));
			this.setHandledTime(DataParser.parse(Date.class, map.get(MonitorAlertMeta.HANDLED_TIME)));
			this.setWarnTime(DataParser.parse(Date.class, map.get(MonitorAlertMeta.WARN_TIME)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorAlertMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorAlertMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorAlertMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorAlertMeta.DELETE_TIME)));
			this.setTriggerRuleDesc(DataParser.parse(String.class, map.get(MonitorAlertMeta.TRIGGER_RULE_DESC)));
			this.setNodeShowName(DataParser.parse(String.class, map.get(MonitorAlertMeta.NODE_SHOW_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorAlertMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorAlertMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, map.get(MonitorAlertMeta.NODE_ID)));
			this.setAlertValue(DataParser.parse(String.class, map.get(MonitorAlertMeta.ALERT_VALUE)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorAlertMeta.STATUS)));
			// others
			this.setTpl(DataParser.parse(MonitorTpl.class, map.get(MonitorAlertMeta.TPL)));
			this.setUser(DataParser.parse(Employee.class, map.get(MonitorAlertMeta.USER)));
			return true;
		} else {
			try {
				this.setProcessMessage( (String)map.get(MonitorAlertMeta.PROCESS_MESSAGE));
				this.setNotes( (String)map.get(MonitorAlertMeta.NOTES));
				this.setWarnLevel( (String)map.get(MonitorAlertMeta.WARN_LEVEL));
				this.setTriggerName( (String)map.get(MonitorAlertMeta.TRIGGER_NAME));
				this.setTriggerId( (String)map.get(MonitorAlertMeta.TRIGGER_ID));
				this.setUpdateTime( (Date)map.get(MonitorAlertMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(MonitorAlertMeta.USER_ID));
				this.setVersion( (Integer)map.get(MonitorAlertMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorAlertMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorAlertMeta.DELETED));
				this.setHandledTime( (Date)map.get(MonitorAlertMeta.HANDLED_TIME));
				this.setWarnTime( (Date)map.get(MonitorAlertMeta.WARN_TIME));
				this.setMonitorTplCode( (String)map.get(MonitorAlertMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)map.get(MonitorAlertMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorAlertMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorAlertMeta.DELETE_TIME));
				this.setTriggerRuleDesc( (String)map.get(MonitorAlertMeta.TRIGGER_RULE_DESC));
				this.setNodeShowName( (String)map.get(MonitorAlertMeta.NODE_SHOW_NAME));
				this.setDeleteBy( (String)map.get(MonitorAlertMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorAlertMeta.ID));
				this.setNodeId( (String)map.get(MonitorAlertMeta.NODE_ID));
				this.setAlertValue( (String)map.get(MonitorAlertMeta.ALERT_VALUE));
				this.setStatus( (String)map.get(MonitorAlertMeta.STATUS));
				// others
				this.setTpl( (MonitorTpl)map.get(MonitorAlertMeta.TPL));
				this.setUser( (Employee)map.get(MonitorAlertMeta.USER));
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
			this.setProcessMessage(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.PROCESS_MESSAGE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.WARN_LEVEL)));
			this.setTriggerName(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.TRIGGER_NAME)));
			this.setTriggerId(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.TRIGGER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorAlertMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorAlertMeta.DELETED)));
			this.setHandledTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMeta.HANDLED_TIME)));
			this.setWarnTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMeta.WARN_TIME)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMeta.DELETE_TIME)));
			this.setTriggerRuleDesc(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.TRIGGER_RULE_DESC)));
			this.setNodeShowName(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.NODE_SHOW_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.NODE_ID)));
			this.setAlertValue(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.ALERT_VALUE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorAlertMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcessMessage( (String)r.getValue(MonitorAlertMeta.PROCESS_MESSAGE));
				this.setNotes( (String)r.getValue(MonitorAlertMeta.NOTES));
				this.setWarnLevel( (String)r.getValue(MonitorAlertMeta.WARN_LEVEL));
				this.setTriggerName( (String)r.getValue(MonitorAlertMeta.TRIGGER_NAME));
				this.setTriggerId( (String)r.getValue(MonitorAlertMeta.TRIGGER_ID));
				this.setUpdateTime( (Date)r.getValue(MonitorAlertMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(MonitorAlertMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(MonitorAlertMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorAlertMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorAlertMeta.DELETED));
				this.setHandledTime( (Date)r.getValue(MonitorAlertMeta.HANDLED_TIME));
				this.setWarnTime( (Date)r.getValue(MonitorAlertMeta.WARN_TIME));
				this.setMonitorTplCode( (String)r.getValue(MonitorAlertMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)r.getValue(MonitorAlertMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorAlertMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorAlertMeta.DELETE_TIME));
				this.setTriggerRuleDesc( (String)r.getValue(MonitorAlertMeta.TRIGGER_RULE_DESC));
				this.setNodeShowName( (String)r.getValue(MonitorAlertMeta.NODE_SHOW_NAME));
				this.setDeleteBy( (String)r.getValue(MonitorAlertMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorAlertMeta.ID));
				this.setNodeId( (String)r.getValue(MonitorAlertMeta.NODE_ID));
				this.setAlertValue( (String)r.getValue(MonitorAlertMeta.ALERT_VALUE));
				this.setStatus( (String)r.getValue(MonitorAlertMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}