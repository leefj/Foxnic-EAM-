package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_ALERT_METHOD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorAlertMethodMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 告警方式
 * <p>告警方式 , 数据表 ops_monitor_alert_method 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-02 14:21:28
 * @sign 838A4B019DDE12C6BD286BC583C3E16D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_alert_method")
@ApiModel(description = "告警方式 ; 告警方式 , 数据表 ops_monitor_alert_method 的PO类型")
public class MonitorAlertMethod extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_ALERT_METHOD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * name：name
	*/
	@ApiModelProperty(required = false,value="name" , notes = "name")
	private String name;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "shell")
	private String type;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 参数：参数
	*/
	@ApiModelProperty(required = false,value="参数" , notes = "参数" , example = "{}")
	private String ps;
	
	/**
	 * 命令：命令
	*/
	@ApiModelProperty(required = false,value="命令" , notes = "命令" , example = "sh /app/app/bin/opsAlert.sh  #<MOBILE>#   \"#<MSG>#\"")
	private String cmd;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "动作类型:#<ACTION># 告警等级:#<WARN_LEVEL># 告警节点:#<NODE># 触发器:#<TRIGGER_NAME># 规则描述:#<RULE_NAME># 告警内容:#<VALUE># 触发时间:#<WARN_TIME>#")
	private String body;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "sh /app/app/bin/opsAlert.sh  #<MOBILE>#  \"#<MSG>#\" 手机号:#<MOBILE># 告警内容:#<MSG>#")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-06-02 02:16:15")
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
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "13")
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
	public MonitorAlertMethod setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 name<br>
	 * name
	 * @return name
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 name
	 * @param name name
	 * @return 当前对象
	*/
	public MonitorAlertMethod setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public MonitorAlertMethod setType(String type) {
		this.type=type;
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
	public MonitorAlertMethod setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 参数<br>
	 * 参数
	 * @return 参数
	*/
	public String getPs() {
		return ps;
	}
	
	/**
	 * 设置 参数
	 * @param ps 参数
	 * @return 当前对象
	*/
	public MonitorAlertMethod setPs(String ps) {
		this.ps=ps;
		return this;
	}
	
	/**
	 * 获得 命令<br>
	 * 命令
	 * @return 命令
	*/
	public String getCmd() {
		return cmd;
	}
	
	/**
	 * 设置 命令
	 * @param cmd 命令
	 * @return 当前对象
	*/
	public MonitorAlertMethod setCmd(String cmd) {
		this.cmd=cmd;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getBody() {
		return body;
	}
	
	/**
	 * 设置 内容
	 * @param body 内容
	 * @return 当前对象
	*/
	public MonitorAlertMethod setBody(String body) {
		this.body=body;
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
	public MonitorAlertMethod setNotes(String notes) {
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
	public MonitorAlertMethod setCreateBy(String createBy) {
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
	public MonitorAlertMethod setCreateTime(Date createTime) {
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
	public MonitorAlertMethod setUpdateBy(String updateBy) {
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
	public MonitorAlertMethod setUpdateTime(Date updateTime) {
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
	public MonitorAlertMethod setDeleted(Integer deleted) {
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
	public MonitorAlertMethod setDeleted(Boolean deletedBool) {
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
	public MonitorAlertMethod setDeleteBy(String deleteBy) {
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
	public MonitorAlertMethod setDeleteTime(Date deleteTime) {
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
	public MonitorAlertMethod setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorAlertMethod , 转换好的 MonitorAlertMethod 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorAlertMethod , 转换好的 PoJo 对象
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
	public MonitorAlertMethod clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorAlertMethod duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorAlertMethodMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorAlertMethodMeta.$$proxy$$();
		inst.setPs(this.getPs());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setBody(this.getBody());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setCmd(this.getCmd());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlertMethod clone(boolean deep) {
		return EntityContext.clone(MonitorAlertMethod.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorAlertMethod
	 * @param monitorAlertMethodMap 包含实体信息的 Map 对象
	 * @return MonitorAlertMethod , 转换好的的 MonitorAlertMethod 对象
	*/
	@Transient
	public static MonitorAlertMethod createFrom(Map<String,Object> monitorAlertMethodMap) {
		if(monitorAlertMethodMap==null) return null;
		MonitorAlertMethod po = create();
		EntityContext.copyProperties(po,monitorAlertMethodMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorAlertMethod
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorAlertMethod , 转换好的的 MonitorAlertMethod 对象
	*/
	@Transient
	public static MonitorAlertMethod createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorAlertMethod po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorAlertMethod，等同于 new
	 * @return MonitorAlertMethod 对象
	*/
	@Transient
	public static MonitorAlertMethod create() {
		return new com.dt.platform.domain.ops.meta.MonitorAlertMethodMeta.$$proxy$$();
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
			this.setPs(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.PS)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorAlertMethodMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.TYPE)));
			this.setBody(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.BODY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorAlertMethodMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorAlertMethodMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorAlertMethodMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorAlertMethodMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.ID)));
			this.setCmd(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.CMD)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorAlertMethodMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setPs( (String)map.get(MonitorAlertMethodMeta.PS));
				this.setNotes( (String)map.get(MonitorAlertMethodMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MonitorAlertMethodMeta.UPDATE_TIME));
				this.setType( (String)map.get(MonitorAlertMethodMeta.TYPE));
				this.setBody( (String)map.get(MonitorAlertMethodMeta.BODY));
				this.setVersion( (Integer)map.get(MonitorAlertMethodMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorAlertMethodMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorAlertMethodMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorAlertMethodMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorAlertMethodMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorAlertMethodMeta.DELETE_TIME));
				this.setName( (String)map.get(MonitorAlertMethodMeta.NAME));
				this.setDeleteBy( (String)map.get(MonitorAlertMethodMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorAlertMethodMeta.ID));
				this.setCmd( (String)map.get(MonitorAlertMethodMeta.CMD));
				this.setStatus( (String)map.get(MonitorAlertMethodMeta.STATUS));
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
			this.setPs(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.PS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMethodMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.TYPE)));
			this.setBody(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.BODY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorAlertMethodMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorAlertMethodMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMethodMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorAlertMethodMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.ID)));
			this.setCmd(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.CMD)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorAlertMethodMeta.STATUS)));
			return true;
		} else {
			try {
				this.setPs( (String)r.getValue(MonitorAlertMethodMeta.PS));
				this.setNotes( (String)r.getValue(MonitorAlertMethodMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MonitorAlertMethodMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(MonitorAlertMethodMeta.TYPE));
				this.setBody( (String)r.getValue(MonitorAlertMethodMeta.BODY));
				this.setVersion( (Integer)r.getValue(MonitorAlertMethodMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorAlertMethodMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorAlertMethodMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorAlertMethodMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorAlertMethodMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorAlertMethodMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MonitorAlertMethodMeta.NAME));
				this.setDeleteBy( (String)r.getValue(MonitorAlertMethodMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorAlertMethodMeta.ID));
				this.setCmd( (String)r.getValue(MonitorAlertMethodMeta.CMD));
				this.setStatus( (String)r.getValue(MonitorAlertMethodMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}