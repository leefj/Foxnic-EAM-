package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_TPL_TRIGGER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 触发器
 * <p>触发器 , 数据表 ops_monitor_tpl_trigger 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 23:10:37
 * @sign 4E4CD906BAD23ED934D64003FA44A950
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_tpl_trigger")
@ApiModel(description = "触发器 ; 触发器 , 数据表 ops_monitor_tpl_trigger 的PO类型")
public class MonitorTplTrigger extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_TPL_TRIGGER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "762392151718887424")
	private String id;
	
	/**
	 * 触发器：触发器
	*/
	@ApiModelProperty(required = false,value="触发器" , notes = "触发器" , example = "数据库连接数")
	private String name;
	
	/**
	 * 告警等级：告警等级
	*/
	@ApiModelProperty(required = false,value="告警等级" , notes = "告警等级" , example = "high")
	private String warnLevel;
	
	/**
	 * 规则描述：规则描述
	*/
	@ApiModelProperty(required = false,value="规则描述" , notes = "规则描述" , example = "数据库连接数大于10")
	private String ruleDesc;
	
	/**
	 * 规则：规则
	*/
	@ApiModelProperty(required = false,value="规则" , notes = "规则" , example = "cF:getLastValueDouble(node,\"db.connect_number\",0,\"0\")>10")
	private String rule;
	
	/**
	 * 告警值：告警值
	*/
	@ApiModelProperty(required = false,value="告警值" , notes = "告警值" , example = "cF:getLastValueString(node,\"db.connect_number\",0,\"0\")")
	private String contentValue;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版" , example = "tpl_db_mysql_zabbix")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-05 07:14:14")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-10-05 11:09:44")
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
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "8")
	private Integer version;
	
	/**
	 * 节点模版：节点模版
	*/
	@ApiModelProperty(required = false,value="节点模版" , notes = "节点模版")
	private MonitorTpl tpl;
	
	/**
	 * monitorNodeList：monitorNodeList
	*/
	@ApiModelProperty(required = false,value="monitorNodeList" , notes = "monitorNodeList")
	private List<MonitorNode> monitorNodeList;
	
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
	public MonitorTplTrigger setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 触发器<br>
	 * 触发器
	 * @return 触发器
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 触发器
	 * @param name 触发器
	 * @return 当前对象
	*/
	public MonitorTplTrigger setName(String name) {
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
	public MonitorTplTrigger setWarnLevel(String warnLevel) {
		this.warnLevel=warnLevel;
		return this;
	}
	
	/**
	 * 获得 规则描述<br>
	 * 规则描述
	 * @return 规则描述
	*/
	public String getRuleDesc() {
		return ruleDesc;
	}
	
	/**
	 * 设置 规则描述
	 * @param ruleDesc 规则描述
	 * @return 当前对象
	*/
	public MonitorTplTrigger setRuleDesc(String ruleDesc) {
		this.ruleDesc=ruleDesc;
		return this;
	}
	
	/**
	 * 获得 规则<br>
	 * 规则
	 * @return 规则
	*/
	public String getRule() {
		return rule;
	}
	
	/**
	 * 设置 规则
	 * @param rule 规则
	 * @return 当前对象
	*/
	public MonitorTplTrigger setRule(String rule) {
		this.rule=rule;
		return this;
	}
	
	/**
	 * 获得 告警值<br>
	 * 告警值
	 * @return 告警值
	*/
	public String getContentValue() {
		return contentValue;
	}
	
	/**
	 * 设置 告警值
	 * @param contentValue 告警值
	 * @return 当前对象
	*/
	public MonitorTplTrigger setContentValue(String contentValue) {
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
	public MonitorTplTrigger setStatus(String status) {
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
	public MonitorTplTrigger setMonitorTplCode(String monitorTplCode) {
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
	public MonitorTplTrigger setNotes(String notes) {
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
	public MonitorTplTrigger setCreateBy(String createBy) {
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
	public MonitorTplTrigger setCreateTime(Date createTime) {
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
	public MonitorTplTrigger setUpdateBy(String updateBy) {
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
	public MonitorTplTrigger setUpdateTime(Date updateTime) {
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
	public MonitorTplTrigger setDeleted(Integer deleted) {
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
	public MonitorTplTrigger setDeleted(Boolean deletedBool) {
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
	public MonitorTplTrigger setDeleteBy(String deleteBy) {
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
	public MonitorTplTrigger setDeleteTime(Date deleteTime) {
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
	public MonitorTplTrigger setVersion(Integer version) {
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
	public MonitorTplTrigger setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}
	
	/**
	 * 获得 monitorNodeList<br>
	 * monitorNodeList
	 * @return monitorNodeList
	*/
	public List<MonitorNode> getMonitorNodeList() {
		return monitorNodeList;
	}
	
	/**
	 * 设置 monitorNodeList
	 * @param monitorNodeList monitorNodeList
	 * @return 当前对象
	*/
	public MonitorTplTrigger setMonitorNodeList(List<MonitorNode> monitorNodeList) {
		this.monitorNodeList=monitorNodeList;
		return this;
	}
	
	/**
	 * 添加 monitorNodeList
	 * @param monitorNode monitorNodeList
	 * @return 当前对象
	*/
	public MonitorTplTrigger addMonitorNode(MonitorNode... monitorNode) {
		if(this.monitorNodeList==null) monitorNodeList=new ArrayList<>();
		this.monitorNodeList.addAll(Arrays.asList(monitorNode));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorTplTrigger , 转换好的 MonitorTplTrigger 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorTplTrigger , 转换好的 PoJo 对象
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
	public MonitorTplTrigger clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorTplTrigger duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setWarnLevel(this.getWarnLevel());
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
		inst.setRuleDesc(this.getRuleDesc());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMonitorNodeList(this.getMonitorNodeList());
			inst.setTpl(this.getTpl());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorTplTrigger clone(boolean deep) {
		return EntityContext.clone(MonitorTplTrigger.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorTplTrigger
	 * @param monitorTplTriggerMap 包含实体信息的 Map 对象
	 * @return MonitorTplTrigger , 转换好的的 MonitorTplTrigger 对象
	*/
	@Transient
	public static MonitorTplTrigger createFrom(Map<String,Object> monitorTplTriggerMap) {
		if(monitorTplTriggerMap==null) return null;
		MonitorTplTrigger po = create();
		EntityContext.copyProperties(po,monitorTplTriggerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorTplTrigger
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorTplTrigger , 转换好的的 MonitorTplTrigger 对象
	*/
	@Transient
	public static MonitorTplTrigger createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorTplTrigger po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorTplTrigger，等同于 new
	 * @return MonitorTplTrigger 对象
	*/
	@Transient
	public static MonitorTplTrigger create() {
		return new com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.WARN_LEVEL)));
			this.setRule(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.RULE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorTplTriggerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorTplTriggerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorTplTriggerMeta.DELETED)));
			this.setContentValue(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.CONTENT_VALUE)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorTplTriggerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorTplTriggerMeta.DELETE_TIME)));
			this.setRuleDesc(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.RULE_DESC)));
			this.setName(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorTplTriggerMeta.STATUS)));
			// others
			this.setTpl(DataParser.parse(MonitorTpl.class, map.get(MonitorTplTriggerMeta.TPL)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MonitorTplTriggerMeta.NOTES));
				this.setWarnLevel( (String)map.get(MonitorTplTriggerMeta.WARN_LEVEL));
				this.setRule( (String)map.get(MonitorTplTriggerMeta.RULE));
				this.setUpdateTime( (Date)map.get(MonitorTplTriggerMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MonitorTplTriggerMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorTplTriggerMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorTplTriggerMeta.DELETED));
				this.setContentValue( (String)map.get(MonitorTplTriggerMeta.CONTENT_VALUE));
				this.setMonitorTplCode( (String)map.get(MonitorTplTriggerMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)map.get(MonitorTplTriggerMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorTplTriggerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorTplTriggerMeta.DELETE_TIME));
				this.setRuleDesc( (String)map.get(MonitorTplTriggerMeta.RULE_DESC));
				this.setName( (String)map.get(MonitorTplTriggerMeta.NAME));
				this.setDeleteBy( (String)map.get(MonitorTplTriggerMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorTplTriggerMeta.ID));
				this.setStatus( (String)map.get(MonitorTplTriggerMeta.STATUS));
				// others
				this.setTpl( (MonitorTpl)map.get(MonitorTplTriggerMeta.TPL));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.WARN_LEVEL)));
			this.setRule(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.RULE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorTplTriggerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorTplTriggerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorTplTriggerMeta.DELETED)));
			this.setContentValue(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.CONTENT_VALUE)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorTplTriggerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorTplTriggerMeta.DELETE_TIME)));
			this.setRuleDesc(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.RULE_DESC)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorTplTriggerMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MonitorTplTriggerMeta.NOTES));
				this.setWarnLevel( (String)r.getValue(MonitorTplTriggerMeta.WARN_LEVEL));
				this.setRule( (String)r.getValue(MonitorTplTriggerMeta.RULE));
				this.setUpdateTime( (Date)r.getValue(MonitorTplTriggerMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MonitorTplTriggerMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorTplTriggerMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorTplTriggerMeta.DELETED));
				this.setContentValue( (String)r.getValue(MonitorTplTriggerMeta.CONTENT_VALUE));
				this.setMonitorTplCode( (String)r.getValue(MonitorTplTriggerMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)r.getValue(MonitorTplTriggerMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorTplTriggerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorTplTriggerMeta.DELETE_TIME));
				this.setRuleDesc( (String)r.getValue(MonitorTplTriggerMeta.RULE_DESC));
				this.setName( (String)r.getValue(MonitorTplTriggerMeta.NAME));
				this.setDeleteBy( (String)r.getValue(MonitorTplTriggerMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorTplTriggerMeta.ID));
				this.setStatus( (String)r.getValue(MonitorTplTriggerMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}