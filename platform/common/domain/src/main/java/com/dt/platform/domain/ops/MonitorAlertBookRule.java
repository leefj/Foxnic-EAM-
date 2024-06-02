package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_ALERT_BOOK_RULE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorAlertBookRuleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 订阅规则
 * <p>订阅规则 , 数据表 ops_monitor_alert_book_rule 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 07:08:52
 * @sign BB2E2C62A5DA12950A9159E4A22B9C48
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_alert_book_rule")
@ApiModel(description = "订阅规则 ; 订阅规则 , 数据表 ops_monitor_alert_book_rule 的PO类型")
public class MonitorAlertBookRule extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_ALERT_BOOK_RULE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类型：严重程度alert_level,节点分组node_group,节点node,发送用户to_user
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "严重程度alert_level,节点分组node_group,节点node,发送用户to_user")
	private String type;
	
	/**
	 * 订阅：订阅
	*/
	@ApiModelProperty(required = false,value="订阅" , notes = "订阅")
	private String bookId;
	
	/**
	 * 数据：数据
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "数据")
	private String value;
	
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
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
	public MonitorAlertBookRule setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 严重程度alert_level,节点分组node_group,节点node,发送用户to_user
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
	public MonitorAlertBookRule setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 订阅<br>
	 * 订阅
	 * @return 订阅
	*/
	public String getBookId() {
		return bookId;
	}
	
	/**
	 * 设置 订阅
	 * @param bookId 订阅
	 * @return 当前对象
	*/
	public MonitorAlertBookRule setBookId(String bookId) {
		this.bookId=bookId;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 数据
	 * @return 数据
	*/
	public String getValue() {
		return value;
	}
	
	/**
	 * 设置 数据
	 * @param value 数据
	 * @return 当前对象
	*/
	public MonitorAlertBookRule setValue(String value) {
		this.value=value;
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
	public MonitorAlertBookRule setCreateBy(String createBy) {
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
	public MonitorAlertBookRule setCreateTime(Date createTime) {
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
	public MonitorAlertBookRule setUpdateBy(String updateBy) {
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
	public MonitorAlertBookRule setUpdateTime(Date updateTime) {
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
	public MonitorAlertBookRule setDeleted(Integer deleted) {
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
	public MonitorAlertBookRule setDeleted(Boolean deletedBool) {
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
	public MonitorAlertBookRule setDeleteBy(String deleteBy) {
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
	public MonitorAlertBookRule setDeleteTime(Date deleteTime) {
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
	public MonitorAlertBookRule setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorAlertBookRule , 转换好的 MonitorAlertBookRule 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorAlertBookRule , 转换好的 PoJo 对象
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
	public MonitorAlertBookRule clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorAlertBookRule duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorAlertBookRuleMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorAlertBookRuleMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setType(this.getType());
		inst.setValue(this.getValue());
		inst.setVersion(this.getVersion());
		inst.setBookId(this.getBookId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlertBookRule clone(boolean deep) {
		return EntityContext.clone(MonitorAlertBookRule.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorAlertBookRule
	 * @param monitorAlertBookRuleMap 包含实体信息的 Map 对象
	 * @return MonitorAlertBookRule , 转换好的的 MonitorAlertBookRule 对象
	*/
	@Transient
	public static MonitorAlertBookRule createFrom(Map<String,Object> monitorAlertBookRuleMap) {
		if(monitorAlertBookRuleMap==null) return null;
		MonitorAlertBookRule po = create();
		EntityContext.copyProperties(po,monitorAlertBookRuleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorAlertBookRule
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorAlertBookRule , 转换好的的 MonitorAlertBookRule 对象
	*/
	@Transient
	public static MonitorAlertBookRule createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorAlertBookRule po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorAlertBookRule，等同于 new
	 * @return MonitorAlertBookRule 对象
	*/
	@Transient
	public static MonitorAlertBookRule create() {
		return new com.dt.platform.domain.ops.meta.MonitorAlertBookRuleMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorAlertBookRuleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorAlertBookRuleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorAlertBookRuleMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorAlertBookRuleMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.ID)));
			this.setType(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.TYPE)));
			this.setValue(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.VALUE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorAlertBookRuleMeta.VERSION)));
			this.setBookId(DataParser.parse(String.class, map.get(MonitorAlertBookRuleMeta.BOOK_ID)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(MonitorAlertBookRuleMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorAlertBookRuleMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorAlertBookRuleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorAlertBookRuleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorAlertBookRuleMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(MonitorAlertBookRuleMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(MonitorAlertBookRuleMeta.UPDATE_TIME));
				this.setId( (String)map.get(MonitorAlertBookRuleMeta.ID));
				this.setType( (String)map.get(MonitorAlertBookRuleMeta.TYPE));
				this.setValue( (String)map.get(MonitorAlertBookRuleMeta.VALUE));
				this.setVersion( (Integer)map.get(MonitorAlertBookRuleMeta.VERSION));
				this.setBookId( (String)map.get(MonitorAlertBookRuleMeta.BOOK_ID));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorAlertBookRuleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertBookRuleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorAlertBookRuleMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertBookRuleMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.ID)));
			this.setType(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.TYPE)));
			this.setValue(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.VALUE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorAlertBookRuleMeta.VERSION)));
			this.setBookId(DataParser.parse(String.class, r.getValue(MonitorAlertBookRuleMeta.BOOK_ID)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(MonitorAlertBookRuleMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorAlertBookRuleMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorAlertBookRuleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorAlertBookRuleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorAlertBookRuleMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(MonitorAlertBookRuleMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(MonitorAlertBookRuleMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(MonitorAlertBookRuleMeta.ID));
				this.setType( (String)r.getValue(MonitorAlertBookRuleMeta.TYPE));
				this.setValue( (String)r.getValue(MonitorAlertBookRuleMeta.VALUE));
				this.setVersion( (Integer)r.getValue(MonitorAlertBookRuleMeta.VERSION));
				this.setBookId( (String)r.getValue(MonitorAlertBookRuleMeta.BOOK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}