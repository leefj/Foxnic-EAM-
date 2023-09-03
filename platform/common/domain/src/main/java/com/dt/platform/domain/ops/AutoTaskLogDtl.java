package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_TASK_LOG_DTL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoTaskLogDtlMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 明细日志
 * <p>明细日志 , 数据表 ops_auto_task_log_dtl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:48:22
 * @sign FAF6F226D5EB9EDCF597EAFA1516EAE2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_task_log_dtl")
@ApiModel(description = "明细日志 ; 明细日志 , 数据表 ops_auto_task_log_dtl 的PO类型")
public class AutoTaskLogDtl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_TASK_LOG_DTL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerId;
	
	/**
	 * 序列：序列
	*/
	@ApiModelProperty(required = false,value="序列" , notes = "序列")
	private Integer ind;
	
	/**
	 * 记录：记录
	*/
	@ApiModelProperty(required = false,value="记录" , notes = "记录")
	private String content;
	
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
	public AutoTaskLogDtl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public AutoTaskLogDtl setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 序列<br>
	 * 序列
	 * @return 序列
	*/
	public Integer getInd() {
		return ind;
	}
	
	/**
	 * 设置 序列
	 * @param ind 序列
	 * @return 当前对象
	*/
	public AutoTaskLogDtl setInd(Integer ind) {
		this.ind=ind;
		return this;
	}
	
	/**
	 * 获得 记录<br>
	 * 记录
	 * @return 记录
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 记录
	 * @param content 记录
	 * @return 当前对象
	*/
	public AutoTaskLogDtl setContent(String content) {
		this.content=content;
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
	public AutoTaskLogDtl setUpdateBy(String updateBy) {
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
	public AutoTaskLogDtl setUpdateTime(Date updateTime) {
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
	public AutoTaskLogDtl setDeleted(Integer deleted) {
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
	public AutoTaskLogDtl setDeleted(Boolean deletedBool) {
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
	public AutoTaskLogDtl setDeleteBy(String deleteBy) {
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
	public AutoTaskLogDtl setDeleteTime(Date deleteTime) {
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
	public AutoTaskLogDtl setVersion(Integer version) {
		this.version=version;
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
	public AutoTaskLogDtl setCreateBy(String createBy) {
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
	public AutoTaskLogDtl setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoTaskLogDtl , 转换好的 AutoTaskLogDtl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskLogDtl , 转换好的 PoJo 对象
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
	public AutoTaskLogDtl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTaskLogDtl duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskLogDtlMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskLogDtlMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setInd(this.getInd());
		inst.setContent(this.getContent());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTaskLogDtl clone(boolean deep) {
		return EntityContext.clone(AutoTaskLogDtl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskLogDtl
	 * @param autoTaskLogDtlMap 包含实体信息的 Map 对象
	 * @return AutoTaskLogDtl , 转换好的的 AutoTaskLogDtl 对象
	*/
	@Transient
	public static AutoTaskLogDtl createFrom(Map<String,Object> autoTaskLogDtlMap) {
		if(autoTaskLogDtlMap==null) return null;
		AutoTaskLogDtl po = create();
		EntityContext.copyProperties(po,autoTaskLogDtlMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskLogDtl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskLogDtl , 转换好的的 AutoTaskLogDtl 对象
	*/
	@Transient
	public static AutoTaskLogDtl createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskLogDtl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoTaskLogDtl，等同于 new
	 * @return AutoTaskLogDtl 对象
	*/
	@Transient
	public static AutoTaskLogDtl create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskLogDtlMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoTaskLogDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskLogDtlMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskLogDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskLogDtlMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoTaskLogDtlMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskLogDtlMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskLogDtlMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskLogDtlMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(AutoTaskLogDtlMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskLogDtlMeta.VERSION)));
			this.setInd(DataParser.parse(Integer.class, map.get(AutoTaskLogDtlMeta.IND)));
			this.setContent(DataParser.parse(String.class, map.get(AutoTaskLogDtlMeta.CONTENT)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(AutoTaskLogDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoTaskLogDtlMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskLogDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskLogDtlMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoTaskLogDtlMeta.CREATE_TIME));
				this.setDeleteBy( (String)map.get(AutoTaskLogDtlMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoTaskLogDtlMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoTaskLogDtlMeta.ID));
				this.setOwnerId( (String)map.get(AutoTaskLogDtlMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(AutoTaskLogDtlMeta.VERSION));
				this.setInd( (Integer)map.get(AutoTaskLogDtlMeta.IND));
				this.setContent( (String)map.get(AutoTaskLogDtlMeta.CONTENT));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoTaskLogDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskLogDtlMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskLogDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogDtlMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogDtlMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskLogDtlMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogDtlMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskLogDtlMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(AutoTaskLogDtlMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskLogDtlMeta.VERSION)));
			this.setInd(DataParser.parse(Integer.class, r.getValue(AutoTaskLogDtlMeta.IND)));
			this.setContent(DataParser.parse(String.class, r.getValue(AutoTaskLogDtlMeta.CONTENT)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(AutoTaskLogDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoTaskLogDtlMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskLogDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskLogDtlMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoTaskLogDtlMeta.CREATE_TIME));
				this.setDeleteBy( (String)r.getValue(AutoTaskLogDtlMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoTaskLogDtlMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoTaskLogDtlMeta.ID));
				this.setOwnerId( (String)r.getValue(AutoTaskLogDtlMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(AutoTaskLogDtlMeta.VERSION));
				this.setInd( (Integer)r.getValue(AutoTaskLogDtlMeta.IND));
				this.setContent( (String)r.getValue(AutoTaskLogDtlMeta.CONTENT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}