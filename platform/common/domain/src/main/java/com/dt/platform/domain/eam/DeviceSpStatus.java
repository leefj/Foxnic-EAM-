package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEVICE_SP_STATUS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.DeviceSpStatusMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 修改状态
 * <p>修改状态 , 数据表 eam_device_sp_status 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 11:18:48
 * @sign 2DA69D704D277379306E309E10307AB2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_device_sp_status")
@ApiModel(description = "修改状态 ; 修改状态 , 数据表 eam_device_sp_status 的PO类型")
public class DeviceSpStatus extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEVICE_SP_STATUS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 备件：备件
	*/
	@ApiModelProperty(required = false,value="备件" , notes = "备件")
	private String spId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因")
	private String content;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version")
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
	public DeviceSpStatus setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 备件<br>
	 * 备件
	 * @return 备件
	*/
	public String getSpId() {
		return spId;
	}
	
	/**
	 * 设置 备件
	 * @param spId 备件
	 * @return 当前对象
	*/
	public DeviceSpStatus setSpId(String spId) {
		this.spId=spId;
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
	public DeviceSpStatus setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 原因
	 * @return 原因
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 原因
	 * @param content 原因
	 * @return 当前对象
	*/
	public DeviceSpStatus setContent(String content) {
		this.content=content;
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
	public DeviceSpStatus setCreateBy(String createBy) {
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
	public DeviceSpStatus setCreateTime(Date createTime) {
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
	public DeviceSpStatus setUpdateBy(String updateBy) {
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
	public DeviceSpStatus setUpdateTime(Date updateTime) {
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
	public DeviceSpStatus setDeleted(Integer deleted) {
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
	public DeviceSpStatus setDeleted(Boolean deletedBool) {
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
	public DeviceSpStatus setDeleteBy(String deleteBy) {
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
	public DeviceSpStatus setDeleteTime(Date deleteTime) {
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
	public DeviceSpStatus setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeviceSpStatus , 转换好的 DeviceSpStatus 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceSpStatus , 转换好的 PoJo 对象
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
	public DeviceSpStatus clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceSpStatus duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceSpStatusMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceSpStatusMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setSpId(this.getSpId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceSpStatus clone(boolean deep) {
		return EntityContext.clone(DeviceSpStatus.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceSpStatus
	 * @param deviceSpStatusMap 包含实体信息的 Map 对象
	 * @return DeviceSpStatus , 转换好的的 DeviceSpStatus 对象
	*/
	@Transient
	public static DeviceSpStatus createFrom(Map<String,Object> deviceSpStatusMap) {
		if(deviceSpStatusMap==null) return null;
		DeviceSpStatus po = create();
		EntityContext.copyProperties(po,deviceSpStatusMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeviceSpStatus
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceSpStatus , 转换好的的 DeviceSpStatus 对象
	*/
	@Transient
	public static DeviceSpStatus createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceSpStatus po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeviceSpStatus，等同于 new
	 * @return DeviceSpStatus 对象
	*/
	@Transient
	public static DeviceSpStatus create() {
		return new com.dt.platform.domain.eam.meta.DeviceSpStatusMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceSpStatusMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceSpStatusMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceSpStatusMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceSpStatusMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.ID)));
			this.setSpId(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.SP_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceSpStatusMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.CONTENT)));
			this.setStatus(DataParser.parse(String.class, map.get(DeviceSpStatusMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(DeviceSpStatusMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceSpStatusMeta.DELETED));
				this.setCreateTime( (Date)map.get(DeviceSpStatusMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeviceSpStatusMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeviceSpStatusMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DeviceSpStatusMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(DeviceSpStatusMeta.UPDATE_TIME));
				this.setId( (String)map.get(DeviceSpStatusMeta.ID));
				this.setSpId( (String)map.get(DeviceSpStatusMeta.SP_ID));
				this.setVersion( (Integer)map.get(DeviceSpStatusMeta.VERSION));
				this.setContent( (String)map.get(DeviceSpStatusMeta.CONTENT));
				this.setStatus( (String)map.get(DeviceSpStatusMeta.STATUS));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceSpStatusMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceSpStatusMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceSpStatusMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceSpStatusMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.ID)));
			this.setSpId(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.SP_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceSpStatusMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.CONTENT)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DeviceSpStatusMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(DeviceSpStatusMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceSpStatusMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DeviceSpStatusMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeviceSpStatusMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeviceSpStatusMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DeviceSpStatusMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(DeviceSpStatusMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(DeviceSpStatusMeta.ID));
				this.setSpId( (String)r.getValue(DeviceSpStatusMeta.SP_ID));
				this.setVersion( (Integer)r.getValue(DeviceSpStatusMeta.VERSION));
				this.setContent( (String)r.getValue(DeviceSpStatusMeta.CONTENT));
				this.setStatus( (String)r.getValue(DeviceSpStatusMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}