package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.IotTables.IOT_VIRT_EQUIPMENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.VirtEquipmentMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 虚拟设备
 * <p>虚拟设备 , 数据表 iot_virt_equipment 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-06 19:37:42
 * @sign 299182F857231C24436F308B7606621B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "iot_virt_equipment")
@ApiModel(description = "虚拟设备 ; 虚拟设备 , 数据表 iot_virt_equipment 的PO类型")
public class VirtEquipment extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =IOT_VIRT_EQUIPMENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 所属产品：所属产品
	*/
	@ApiModelProperty(required = false,value="所属产品" , notes = "所属产品")
	private String ownerId;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 触发方式：触发方式
	*/
	@ApiModelProperty(required = false,value="触发方式" , notes = "触发方式")
	private String triggerType;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * crontab表达式：crontab表达式
	*/
	@ApiModelProperty(required = false,value="crontab表达式" , notes = "crontab表达式")
	private String crontabValue;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * iotProduct：iotProduct
	*/
	@ApiModelProperty(required = false,value="iotProduct" , notes = "iotProduct")
	private Product iotProduct;
	
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
	public VirtEquipment setId(String id) {
		this.id=id;
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
	public VirtEquipment setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 所属产品<br>
	 * 所属产品
	 * @return 所属产品
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属产品
	 * @param ownerId 所属产品
	 * @return 当前对象
	*/
	public VirtEquipment setOwnerId(String ownerId) {
		this.ownerId=ownerId;
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
	public VirtEquipment setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 触发方式<br>
	 * 触发方式
	 * @return 触发方式
	*/
	public String getTriggerType() {
		return triggerType;
	}
	
	/**
	 * 设置 触发方式
	 * @param triggerType 触发方式
	 * @return 当前对象
	*/
	public VirtEquipment setTriggerType(String triggerType) {
		this.triggerType=triggerType;
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
	public VirtEquipment setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 crontab表达式<br>
	 * crontab表达式
	 * @return crontab表达式
	*/
	public String getCrontabValue() {
		return crontabValue;
	}
	
	/**
	 * 设置 crontab表达式
	 * @param crontabValue crontab表达式
	 * @return 当前对象
	*/
	public VirtEquipment setCrontabValue(String crontabValue) {
		this.crontabValue=crontabValue;
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
	public VirtEquipment setNotes(String notes) {
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
	public VirtEquipment setCreateBy(String createBy) {
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
	public VirtEquipment setCreateTime(Date createTime) {
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
	public VirtEquipment setUpdateBy(String updateBy) {
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
	public VirtEquipment setUpdateTime(Date updateTime) {
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
	public VirtEquipment setDeleted(Integer deleted) {
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
	public VirtEquipment setDeleted(Boolean deletedBool) {
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
	public VirtEquipment setDeleteBy(String deleteBy) {
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
	public VirtEquipment setDeleteTime(Date deleteTime) {
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
	public VirtEquipment setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public VirtEquipment setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 iotProduct<br>
	 * iotProduct
	 * @return iotProduct
	*/
	public Product getIotProduct() {
		return iotProduct;
	}
	
	/**
	 * 设置 iotProduct
	 * @param iotProduct iotProduct
	 * @return 当前对象
	*/
	public VirtEquipment setIotProduct(Product iotProduct) {
		this.iotProduct=iotProduct;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return VirtEquipment , 转换好的 VirtEquipment 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VirtEquipment , 转换好的 PoJo 对象
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
	public VirtEquipment clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VirtEquipment duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.VirtEquipmentMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.VirtEquipmentMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setCrontabValue(this.getCrontabValue());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTriggerType(this.getTriggerType());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setIotProduct(this.getIotProduct());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public VirtEquipment clone(boolean deep) {
		return EntityContext.clone(VirtEquipment.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VirtEquipment
	 * @param virtEquipmentMap 包含实体信息的 Map 对象
	 * @return VirtEquipment , 转换好的的 VirtEquipment 对象
	*/
	@Transient
	public static VirtEquipment createFrom(Map<String,Object> virtEquipmentMap) {
		if(virtEquipmentMap==null) return null;
		VirtEquipment po = create();
		EntityContext.copyProperties(po,virtEquipmentMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 VirtEquipment
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VirtEquipment , 转换好的的 VirtEquipment 对象
	*/
	@Transient
	public static VirtEquipment createFrom(Object pojo) {
		if(pojo==null) return null;
		VirtEquipment po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 VirtEquipment，等同于 new
	 * @return VirtEquipment 对象
	*/
	@Transient
	public static VirtEquipment create() {
		return new com.dt.platform.domain.eam.meta.VirtEquipmentMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(VirtEquipmentMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VirtEquipmentMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(VirtEquipmentMeta.OWNER_ID)));
			this.setType(DataParser.parse(String.class, map.get(VirtEquipmentMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VirtEquipmentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(VirtEquipmentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VirtEquipmentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VirtEquipmentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VirtEquipmentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VirtEquipmentMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(VirtEquipmentMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(VirtEquipmentMeta.TENANT_ID)));
			this.setCrontabValue(DataParser.parse(String.class, map.get(VirtEquipmentMeta.CRONTAB_VALUE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VirtEquipmentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(VirtEquipmentMeta.ID)));
			this.setTriggerType(DataParser.parse(String.class, map.get(VirtEquipmentMeta.TRIGGER_TYPE)));
			this.setStatus(DataParser.parse(String.class, map.get(VirtEquipmentMeta.STATUS)));
			// others
			this.setIotProduct(DataParser.parse(Product.class, map.get(VirtEquipmentMeta.IOT_PRODUCT)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(VirtEquipmentMeta.NOTES));
				this.setUpdateTime( (Date)map.get(VirtEquipmentMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(VirtEquipmentMeta.OWNER_ID));
				this.setType( (String)map.get(VirtEquipmentMeta.TYPE));
				this.setVersion( (Integer)map.get(VirtEquipmentMeta.VERSION));
				this.setCreateBy( (String)map.get(VirtEquipmentMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VirtEquipmentMeta.DELETED));
				this.setCreateTime( (Date)map.get(VirtEquipmentMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(VirtEquipmentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(VirtEquipmentMeta.DELETE_TIME));
				this.setName( (String)map.get(VirtEquipmentMeta.NAME));
				this.setTenantId( (String)map.get(VirtEquipmentMeta.TENANT_ID));
				this.setCrontabValue( (String)map.get(VirtEquipmentMeta.CRONTAB_VALUE));
				this.setDeleteBy( (String)map.get(VirtEquipmentMeta.DELETE_BY));
				this.setId( (String)map.get(VirtEquipmentMeta.ID));
				this.setTriggerType( (String)map.get(VirtEquipmentMeta.TRIGGER_TYPE));
				this.setStatus( (String)map.get(VirtEquipmentMeta.STATUS));
				// others
				this.setIotProduct( (Product)map.get(VirtEquipmentMeta.IOT_PRODUCT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VirtEquipmentMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.OWNER_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VirtEquipmentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VirtEquipmentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VirtEquipmentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VirtEquipmentMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.TENANT_ID)));
			this.setCrontabValue(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.CRONTAB_VALUE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.ID)));
			this.setTriggerType(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.TRIGGER_TYPE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(VirtEquipmentMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(VirtEquipmentMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(VirtEquipmentMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(VirtEquipmentMeta.OWNER_ID));
				this.setType( (String)r.getValue(VirtEquipmentMeta.TYPE));
				this.setVersion( (Integer)r.getValue(VirtEquipmentMeta.VERSION));
				this.setCreateBy( (String)r.getValue(VirtEquipmentMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VirtEquipmentMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(VirtEquipmentMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(VirtEquipmentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(VirtEquipmentMeta.DELETE_TIME));
				this.setName( (String)r.getValue(VirtEquipmentMeta.NAME));
				this.setTenantId( (String)r.getValue(VirtEquipmentMeta.TENANT_ID));
				this.setCrontabValue( (String)r.getValue(VirtEquipmentMeta.CRONTAB_VALUE));
				this.setDeleteBy( (String)r.getValue(VirtEquipmentMeta.DELETE_BY));
				this.setId( (String)r.getValue(VirtEquipmentMeta.ID));
				this.setTriggerType( (String)r.getValue(VirtEquipmentMeta.TRIGGER_TYPE));
				this.setStatus( (String)r.getValue(VirtEquipmentMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}