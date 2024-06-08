package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_NODE_TRIGGER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorNodeTriggerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 触发器
 * <p>触发器 , 数据表 ops_monitor_node_trigger 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-04 06:55:48
 * @sign 1EF1D813865A03F86D21424850A0DDF4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node_trigger")
@ApiModel(description = "触发器 ; 触发器 , 数据表 ops_monitor_node_trigger 的PO类型")
public class MonitorNodeTrigger extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE_TRIGGER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "850097923822714880")
	private String id;
	
	/**
	 * 触发器：触发器
	*/
	@ApiModelProperty(required = false,value="触发器" , notes = "触发器" , example = "849370866545328128")
	private String triggerId;
	
	/**
	 * 规则类型：动态，静态
	*/
	@ApiModelProperty(required = false,value="规则类型" , notes = "动态，静态" , example = "static")
	private String ruleType;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点" , example = "848718802559434752")
	private String nodeId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "物理内存使用率")
	private String name;
	
	/**
	 * 告警等级：告警等级
	*/
	@ApiModelProperty(required = false,value="告警等级" , notes = "告警等级" , example = "high")
	private String warnLevel;
	
	/**
	 * 告警规则：告警规则
	*/
	@ApiModelProperty(required = false,value="告警规则" , notes = "告警规则" , example = "cF:lastDouble(node,\"os.memory_used\",\"p_memory_used\",null,0,\"0\")>10")
	private String rule;
	
	/**
	 * 告警内容：告警内容
	*/
	@ApiModelProperty(required = false,value="告警内容" , notes = "告警内容" , example = "当前物理内存使用率:#<pMemoryUsed>#")
	private String contentValue;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版" , example = "tpl_host_linux_script")
	private String monitorTplCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-06-03 07:45:39")
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
	public MonitorNodeTrigger setId(String id) {
		this.id=id;
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
	public MonitorNodeTrigger setTriggerId(String triggerId) {
		this.triggerId=triggerId;
		return this;
	}
	
	/**
	 * 获得 规则类型<br>
	 * 动态，静态
	 * @return 规则类型
	*/
	public String getRuleType() {
		return ruleType;
	}
	
	/**
	 * 设置 规则类型
	 * @param ruleType 规则类型
	 * @return 当前对象
	*/
	public MonitorNodeTrigger setRuleType(String ruleType) {
		this.ruleType=ruleType;
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
	public MonitorNodeTrigger setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public MonitorNodeTrigger setName(String name) {
		this.name=name;
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
	public MonitorNodeTrigger setWarnLevel(String warnLevel) {
		this.warnLevel=warnLevel;
		return this;
	}
	
	/**
	 * 获得 告警规则<br>
	 * 告警规则
	 * @return 告警规则
	*/
	public String getRule() {
		return rule;
	}
	
	/**
	 * 设置 告警规则
	 * @param rule 告警规则
	 * @return 当前对象
	*/
	public MonitorNodeTrigger setRule(String rule) {
		this.rule=rule;
		return this;
	}
	
	/**
	 * 获得 告警内容<br>
	 * 告警内容
	 * @return 告警内容
	*/
	public String getContentValue() {
		return contentValue;
	}
	
	/**
	 * 设置 告警内容
	 * @param contentValue 告警内容
	 * @return 当前对象
	*/
	public MonitorNodeTrigger setContentValue(String contentValue) {
		this.contentValue=contentValue;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public MonitorNodeTrigger setStatus(String status) {
		this.status=status;
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
	public MonitorNodeTrigger setMonitorTplCode(String monitorTplCode) {
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
	public MonitorNodeTrigger setNotes(String notes) {
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
	public MonitorNodeTrigger setCreateBy(String createBy) {
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
	public MonitorNodeTrigger setCreateTime(Date createTime) {
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
	public MonitorNodeTrigger setUpdateBy(String updateBy) {
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
	public MonitorNodeTrigger setUpdateTime(Date updateTime) {
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
	public MonitorNodeTrigger setDeleted(Integer deleted) {
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
	public MonitorNodeTrigger setDeleted(Boolean deletedBool) {
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
	public MonitorNodeTrigger setDeleteBy(String deleteBy) {
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
	public MonitorNodeTrigger setDeleteTime(Date deleteTime) {
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
	public MonitorNodeTrigger setVersion(Integer version) {
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
	public MonitorNodeTrigger setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNodeTrigger , 转换好的 MonitorNodeTrigger 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeTrigger , 转换好的 PoJo 对象
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
	public MonitorNodeTrigger clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorNodeTrigger duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorNodeTriggerMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorNodeTriggerMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setWarnLevel(this.getWarnLevel());
		inst.setTriggerId(this.getTriggerId());
		inst.setRule(this.getRule());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setContentValue(this.getContentValue());
		inst.setMonitorTplCode(this.getMonitorTplCode());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRuleType(this.getRuleType());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setNodeId(this.getNodeId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setTpl(this.getTpl());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorNodeTrigger clone(boolean deep) {
		return EntityContext.clone(MonitorNodeTrigger.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorNodeTrigger
	 * @param monitorNodeTriggerMap 包含实体信息的 Map 对象
	 * @return MonitorNodeTrigger , 转换好的的 MonitorNodeTrigger 对象
	*/
	@Transient
	public static MonitorNodeTrigger createFrom(Map<String,Object> monitorNodeTriggerMap) {
		if(monitorNodeTriggerMap==null) return null;
		MonitorNodeTrigger po = create();
		EntityContext.copyProperties(po,monitorNodeTriggerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeTrigger
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeTrigger , 转换好的的 MonitorNodeTrigger 对象
	*/
	@Transient
	public static MonitorNodeTrigger createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeTrigger po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorNodeTrigger，等同于 new
	 * @return MonitorNodeTrigger 对象
	*/
	@Transient
	public static MonitorNodeTrigger create() {
		return new com.dt.platform.domain.ops.meta.MonitorNodeTriggerMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.WARN_LEVEL)));
			this.setTriggerId(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.TRIGGER_ID)));
			this.setRule(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.RULE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorNodeTriggerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorNodeTriggerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorNodeTriggerMeta.DELETED)));
			this.setContentValue(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.CONTENT_VALUE)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorNodeTriggerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorNodeTriggerMeta.DELETE_TIME)));
			this.setRuleType(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.RULE_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.NODE_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorNodeTriggerMeta.STATUS)));
			// others
			this.setTpl(DataParser.parse(MonitorTpl.class, map.get(MonitorNodeTriggerMeta.TPL)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MonitorNodeTriggerMeta.NOTES));
				this.setWarnLevel( (String)map.get(MonitorNodeTriggerMeta.WARN_LEVEL));
				this.setTriggerId( (String)map.get(MonitorNodeTriggerMeta.TRIGGER_ID));
				this.setRule( (String)map.get(MonitorNodeTriggerMeta.RULE));
				this.setUpdateTime( (Date)map.get(MonitorNodeTriggerMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MonitorNodeTriggerMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorNodeTriggerMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorNodeTriggerMeta.DELETED));
				this.setContentValue( (String)map.get(MonitorNodeTriggerMeta.CONTENT_VALUE));
				this.setMonitorTplCode( (String)map.get(MonitorNodeTriggerMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)map.get(MonitorNodeTriggerMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorNodeTriggerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorNodeTriggerMeta.DELETE_TIME));
				this.setRuleType( (String)map.get(MonitorNodeTriggerMeta.RULE_TYPE));
				this.setName( (String)map.get(MonitorNodeTriggerMeta.NAME));
				this.setDeleteBy( (String)map.get(MonitorNodeTriggerMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorNodeTriggerMeta.ID));
				this.setNodeId( (String)map.get(MonitorNodeTriggerMeta.NODE_ID));
				this.setStatus( (String)map.get(MonitorNodeTriggerMeta.STATUS));
				// others
				this.setTpl( (MonitorTpl)map.get(MonitorNodeTriggerMeta.TPL));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.WARN_LEVEL)));
			this.setTriggerId(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.TRIGGER_ID)));
			this.setRule(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.RULE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeTriggerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorNodeTriggerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorNodeTriggerMeta.DELETED)));
			this.setContentValue(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.CONTENT_VALUE)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeTriggerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorNodeTriggerMeta.DELETE_TIME)));
			this.setRuleType(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.RULE_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.NODE_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorNodeTriggerMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MonitorNodeTriggerMeta.NOTES));
				this.setWarnLevel( (String)r.getValue(MonitorNodeTriggerMeta.WARN_LEVEL));
				this.setTriggerId( (String)r.getValue(MonitorNodeTriggerMeta.TRIGGER_ID));
				this.setRule( (String)r.getValue(MonitorNodeTriggerMeta.RULE));
				this.setUpdateTime( (Date)r.getValue(MonitorNodeTriggerMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MonitorNodeTriggerMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorNodeTriggerMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorNodeTriggerMeta.DELETED));
				this.setContentValue( (String)r.getValue(MonitorNodeTriggerMeta.CONTENT_VALUE));
				this.setMonitorTplCode( (String)r.getValue(MonitorNodeTriggerMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)r.getValue(MonitorNodeTriggerMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorNodeTriggerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorNodeTriggerMeta.DELETE_TIME));
				this.setRuleType( (String)r.getValue(MonitorNodeTriggerMeta.RULE_TYPE));
				this.setName( (String)r.getValue(MonitorNodeTriggerMeta.NAME));
				this.setDeleteBy( (String)r.getValue(MonitorNodeTriggerMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorNodeTriggerMeta.ID));
				this.setNodeId( (String)r.getValue(MonitorNodeTriggerMeta.NODE_ID));
				this.setStatus( (String)r.getValue(MonitorNodeTriggerMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}