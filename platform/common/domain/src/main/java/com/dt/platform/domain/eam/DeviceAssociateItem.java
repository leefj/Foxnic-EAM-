package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEVICE_ASSOCIATE_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.DeviceAssociateItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备件关联
 * <p>备件关联 , 数据表 eam_device_associate_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 07:28:18
 * @sign 17C47E1DE34742D098504FA4602BE37B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_device_associate_item")
@ApiModel(description = "备件关联 ; 备件关联 , 数据表 eam_device_associate_item 的PO类型")
public class DeviceAssociateItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEVICE_ASSOCIATE_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 关联：关联
	*/
	@ApiModelProperty(required = false,value="关联" , notes = "关联")
	private String associateId;
	
	/**
	 * 设备备件：设备备件
	*/
	@ApiModelProperty(required = false,value="设备备件" , notes = "设备备件")
	private String ownerId;
	
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
	public DeviceAssociateItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 关联<br>
	 * 关联
	 * @return 关联
	*/
	public String getAssociateId() {
		return associateId;
	}
	
	/**
	 * 设置 关联
	 * @param associateId 关联
	 * @return 当前对象
	*/
	public DeviceAssociateItem setAssociateId(String associateId) {
		this.associateId=associateId;
		return this;
	}
	
	/**
	 * 获得 设备备件<br>
	 * 设备备件
	 * @return 设备备件
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 设备备件
	 * @param ownerId 设备备件
	 * @return 当前对象
	*/
	public DeviceAssociateItem setOwnerId(String ownerId) {
		this.ownerId=ownerId;
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
	public DeviceAssociateItem setCreateBy(String createBy) {
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
	public DeviceAssociateItem setCreateTime(Date createTime) {
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
	public DeviceAssociateItem setUpdateBy(String updateBy) {
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
	public DeviceAssociateItem setUpdateTime(Date updateTime) {
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
	public DeviceAssociateItem setDeleted(Integer deleted) {
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
	public DeviceAssociateItem setDeleted(Boolean deletedBool) {
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
	public DeviceAssociateItem setDeleteBy(String deleteBy) {
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
	public DeviceAssociateItem setDeleteTime(Date deleteTime) {
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
	public DeviceAssociateItem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeviceAssociateItem , 转换好的 DeviceAssociateItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceAssociateItem , 转换好的 PoJo 对象
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
	public DeviceAssociateItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceAssociateItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceAssociateItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceAssociateItemMeta.$$proxy$$();
		inst.setAssociateId(this.getAssociateId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceAssociateItem clone(boolean deep) {
		return EntityContext.clone(DeviceAssociateItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceAssociateItem
	 * @param deviceAssociateItemMap 包含实体信息的 Map 对象
	 * @return DeviceAssociateItem , 转换好的的 DeviceAssociateItem 对象
	*/
	@Transient
	public static DeviceAssociateItem createFrom(Map<String,Object> deviceAssociateItemMap) {
		if(deviceAssociateItemMap==null) return null;
		DeviceAssociateItem po = create();
		EntityContext.copyProperties(po,deviceAssociateItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeviceAssociateItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceAssociateItem , 转换好的的 DeviceAssociateItem 对象
	*/
	@Transient
	public static DeviceAssociateItem createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceAssociateItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeviceAssociateItem，等同于 new
	 * @return DeviceAssociateItem 对象
	*/
	@Transient
	public static DeviceAssociateItem create() {
		return new com.dt.platform.domain.eam.meta.DeviceAssociateItemMeta.$$proxy$$();
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
			this.setAssociateId(DataParser.parse(String.class, map.get(DeviceAssociateItemMeta.ASSOCIATE_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceAssociateItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceAssociateItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceAssociateItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceAssociateItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceAssociateItemMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceAssociateItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceAssociateItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(DeviceAssociateItemMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(DeviceAssociateItemMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceAssociateItemMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setAssociateId( (String)map.get(DeviceAssociateItemMeta.ASSOCIATE_ID));
				this.setCreateBy( (String)map.get(DeviceAssociateItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceAssociateItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(DeviceAssociateItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeviceAssociateItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeviceAssociateItemMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DeviceAssociateItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(DeviceAssociateItemMeta.UPDATE_TIME));
				this.setId( (String)map.get(DeviceAssociateItemMeta.ID));
				this.setOwnerId( (String)map.get(DeviceAssociateItemMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(DeviceAssociateItemMeta.VERSION));
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
			this.setAssociateId(DataParser.parse(String.class, r.getValue(DeviceAssociateItemMeta.ASSOCIATE_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceAssociateItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceAssociateItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceAssociateItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceAssociateItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceAssociateItemMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceAssociateItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceAssociateItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceAssociateItemMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(DeviceAssociateItemMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceAssociateItemMeta.VERSION)));
			return true;
		} else {
			try {
				this.setAssociateId( (String)r.getValue(DeviceAssociateItemMeta.ASSOCIATE_ID));
				this.setCreateBy( (String)r.getValue(DeviceAssociateItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceAssociateItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DeviceAssociateItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeviceAssociateItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeviceAssociateItemMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DeviceAssociateItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(DeviceAssociateItemMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(DeviceAssociateItemMeta.ID));
				this.setOwnerId( (String)r.getValue(DeviceAssociateItemMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(DeviceAssociateItemMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}