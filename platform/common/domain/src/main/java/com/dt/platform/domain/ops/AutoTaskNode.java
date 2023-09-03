package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_TASK_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoTaskNodeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 作业节点
 * <p>作业节点 , 数据表 ops_auto_task_node 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:23:00
 * @sign C685C47B1239C1B2025A6AE96ED281C0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_task_node")
@ApiModel(description = "作业节点 ; 作业节点 , 数据表 ops_auto_task_node 的PO类型")
public class AutoTaskNode extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_TASK_NODE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 作业：作业
	*/
	@ApiModelProperty(required = false,value="作业" , notes = "作业")
	private String taskId;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点")
	private String nodeId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public AutoTaskNode setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 作业<br>
	 * 作业
	 * @return 作业
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 作业
	 * @param taskId 作业
	 * @return 当前对象
	*/
	public AutoTaskNode setTaskId(String taskId) {
		this.taskId=taskId;
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
	public AutoTaskNode setNodeId(String nodeId) {
		this.nodeId=nodeId;
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
	public AutoTaskNode setNotes(String notes) {
		this.notes=notes;
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
	public AutoTaskNode setUpdateBy(String updateBy) {
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
	public AutoTaskNode setUpdateTime(Date updateTime) {
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
	public AutoTaskNode setDeleted(Integer deleted) {
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
	public AutoTaskNode setDeleted(Boolean deletedBool) {
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
	public AutoTaskNode setDeleteBy(String deleteBy) {
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
	public AutoTaskNode setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public AutoTaskNode setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoTaskNode , 转换好的 AutoTaskNode 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskNode , 转换好的 PoJo 对象
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
	public AutoTaskNode clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTaskNode duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskNodeMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskNodeMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setNodeId(this.getNodeId());
		inst.setVersion(this.getVersion());
		inst.setTaskId(this.getTaskId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTaskNode clone(boolean deep) {
		return EntityContext.clone(AutoTaskNode.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskNode
	 * @param autoTaskNodeMap 包含实体信息的 Map 对象
	 * @return AutoTaskNode , 转换好的的 AutoTaskNode 对象
	*/
	@Transient
	public static AutoTaskNode createFrom(Map<String,Object> autoTaskNodeMap) {
		if(autoTaskNodeMap==null) return null;
		AutoTaskNode po = create();
		EntityContext.copyProperties(po,autoTaskNodeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskNode
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskNode , 转换好的的 AutoTaskNode 对象
	*/
	@Transient
	public static AutoTaskNode createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskNode po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoTaskNode，等同于 new
	 * @return AutoTaskNode 对象
	*/
	@Transient
	public static AutoTaskNode create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskNodeMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoTaskNodeMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskNodeMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskNodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskNodeMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskNodeMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskNodeMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskNodeMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, map.get(AutoTaskNodeMeta.NODE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskNodeMeta.VERSION)));
			this.setTaskId(DataParser.parse(String.class, map.get(AutoTaskNodeMeta.TASK_ID)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoTaskNodeMeta.NOTES));
				this.setDeleted( (Integer)map.get(AutoTaskNodeMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskNodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskNodeMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(AutoTaskNodeMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoTaskNodeMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoTaskNodeMeta.ID));
				this.setNodeId( (String)map.get(AutoTaskNodeMeta.NODE_ID));
				this.setVersion( (Integer)map.get(AutoTaskNodeMeta.VERSION));
				this.setTaskId( (String)map.get(AutoTaskNodeMeta.TASK_ID));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoTaskNodeMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskNodeMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskNodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskNodeMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskNodeMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskNodeMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskNodeMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(AutoTaskNodeMeta.NODE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskNodeMeta.VERSION)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(AutoTaskNodeMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoTaskNodeMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(AutoTaskNodeMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskNodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskNodeMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(AutoTaskNodeMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoTaskNodeMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoTaskNodeMeta.ID));
				this.setNodeId( (String)r.getValue(AutoTaskNodeMeta.NODE_ID));
				this.setVersion( (Integer)r.getValue(AutoTaskNodeMeta.VERSION));
				this.setTaskId( (String)r.getValue(AutoTaskNodeMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}