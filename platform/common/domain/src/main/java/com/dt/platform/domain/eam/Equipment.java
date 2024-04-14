package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.IotTables.IOT_EQUIPMENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.EquipmentMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 设备列
 * <p>设备列 , 数据表 iot_equipment 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:36:19
 * @sign 4E96E2AE1EEA0110E5E5DB789C090EEA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "iot_equipment")
@ApiModel(description = "设备列 ; 设备列 , 数据表 iot_equipment 的PO类型")
public class Equipment extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =IOT_EQUIPMENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "829082820319117312")
	private String id;
	
	/**
	 * 产品：产品
	*/
	@ApiModelProperty(required = false,value="产品" , notes = "产品" , example = "829082363148369920")
	private String productId;
	
	/**
	 * 设备DN：设备DN
	*/
	@ApiModelProperty(required = false,value="设备DN" , notes = "设备DN" , example = "123456")
	private String dn;
	
	/**
	 * 设备编码：设备编码
	*/
	@ApiModelProperty(required = false,value="设备编码" , notes = "设备编码")
	private String equipmentCode;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 分组：分组
	*/
	@ApiModelProperty(required = false,value="分组" , notes = "分组" , example = "group1")
	private String groupCode;
	
	/**
	 * 设备密钥：设备密钥
	*/
	@ApiModelProperty(required = false,value="设备密钥" , notes = "设备密钥" , example = "设备")
	private String equipmentKey;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-04-06 07:59:08")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * iotProduct：iotProduct
	*/
	@ApiModelProperty(required = false,value="iotProduct" , notes = "iotProduct")
	private Product iotProduct;
	
	/**
	 * group：group
	*/
	@ApiModelProperty(required = false,value="group" , notes = "group")
	private DictItem group;
	
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
	public Equipment setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 产品<br>
	 * 产品
	 * @return 产品
	*/
	public String getProductId() {
		return productId;
	}
	
	/**
	 * 设置 产品
	 * @param productId 产品
	 * @return 当前对象
	*/
	public Equipment setProductId(String productId) {
		this.productId=productId;
		return this;
	}
	
	/**
	 * 获得 设备DN<br>
	 * 设备DN
	 * @return 设备DN
	*/
	public String getDn() {
		return dn;
	}
	
	/**
	 * 设置 设备DN
	 * @param dn 设备DN
	 * @return 当前对象
	*/
	public Equipment setDn(String dn) {
		this.dn=dn;
		return this;
	}
	
	/**
	 * 获得 设备编码<br>
	 * 设备编码
	 * @return 设备编码
	*/
	public String getEquipmentCode() {
		return equipmentCode;
	}
	
	/**
	 * 设置 设备编码
	 * @param equipmentCode 设备编码
	 * @return 当前对象
	*/
	public Equipment setEquipmentCode(String equipmentCode) {
		this.equipmentCode=equipmentCode;
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
	public Equipment setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 分组<br>
	 * 分组
	 * @return 分组
	*/
	public String getGroupCode() {
		return groupCode;
	}
	
	/**
	 * 设置 分组
	 * @param groupCode 分组
	 * @return 当前对象
	*/
	public Equipment setGroupCode(String groupCode) {
		this.groupCode=groupCode;
		return this;
	}
	
	/**
	 * 获得 设备密钥<br>
	 * 设备密钥
	 * @return 设备密钥
	*/
	public String getEquipmentKey() {
		return equipmentKey;
	}
	
	/**
	 * 设置 设备密钥
	 * @param equipmentKey 设备密钥
	 * @return 当前对象
	*/
	public Equipment setEquipmentKey(String equipmentKey) {
		this.equipmentKey=equipmentKey;
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
	public Equipment setNotes(String notes) {
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
	public Equipment setCreateBy(String createBy) {
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
	public Equipment setCreateTime(Date createTime) {
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
	public Equipment setUpdateBy(String updateBy) {
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
	public Equipment setUpdateTime(Date updateTime) {
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
	public Equipment setDeleted(Integer deleted) {
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
	public Equipment setDeleted(Boolean deletedBool) {
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
	public Equipment setDeleteBy(String deleteBy) {
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
	public Equipment setDeleteTime(Date deleteTime) {
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
	public Equipment setVersion(Integer version) {
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
	public Equipment setTenantId(String tenantId) {
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
	public Equipment setIotProduct(Product iotProduct) {
		this.iotProduct=iotProduct;
		return this;
	}
	
	/**
	 * 获得 group<br>
	 * group
	 * @return group
	*/
	public DictItem getGroup() {
		return group;
	}
	
	/**
	 * 设置 group
	 * @param group group
	 * @return 当前对象
	*/
	public Equipment setGroup(DictItem group) {
		this.group=group;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Equipment , 转换好的 Equipment 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Equipment , 转换好的 PoJo 对象
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
	public Equipment clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Equipment duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.EquipmentMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.EquipmentMeta.$$proxy$$();
		inst.setEquipmentKey(this.getEquipmentKey());
		inst.setNotes(this.getNotes());
		inst.setProductId(this.getProductId());
		inst.setEquipmentCode(this.getEquipmentCode());
		inst.setDn(this.getDn());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setGroupCode(this.getGroupCode());
		if(all) {
			inst.setIotProduct(this.getIotProduct());
			inst.setGroup(this.getGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Equipment clone(boolean deep) {
		return EntityContext.clone(Equipment.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Equipment
	 * @param equipmentMap 包含实体信息的 Map 对象
	 * @return Equipment , 转换好的的 Equipment 对象
	*/
	@Transient
	public static Equipment createFrom(Map<String,Object> equipmentMap) {
		if(equipmentMap==null) return null;
		Equipment po = create();
		EntityContext.copyProperties(po,equipmentMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Equipment
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Equipment , 转换好的的 Equipment 对象
	*/
	@Transient
	public static Equipment createFrom(Object pojo) {
		if(pojo==null) return null;
		Equipment po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Equipment，等同于 new
	 * @return Equipment 对象
	*/
	@Transient
	public static Equipment create() {
		return new com.dt.platform.domain.eam.meta.EquipmentMeta.$$proxy$$();
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
			this.setEquipmentKey(DataParser.parse(String.class, map.get(EquipmentMeta.EQUIPMENT_KEY)));
			this.setNotes(DataParser.parse(String.class, map.get(EquipmentMeta.NOTES)));
			this.setProductId(DataParser.parse(String.class, map.get(EquipmentMeta.PRODUCT_ID)));
			this.setEquipmentCode(DataParser.parse(String.class, map.get(EquipmentMeta.EQUIPMENT_CODE)));
			this.setDn(DataParser.parse(String.class, map.get(EquipmentMeta.DN)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(EquipmentMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(EquipmentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(EquipmentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(EquipmentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(EquipmentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(EquipmentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(EquipmentMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(EquipmentMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(EquipmentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(EquipmentMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(EquipmentMeta.STATUS)));
			this.setGroupCode(DataParser.parse(String.class, map.get(EquipmentMeta.GROUP_CODE)));
			// others
			this.setIotProduct(DataParser.parse(Product.class, map.get(EquipmentMeta.IOT_PRODUCT)));
			this.setGroup(DataParser.parse(DictItem.class, map.get(EquipmentMeta.GROUP)));
			return true;
		} else {
			try {
				this.setEquipmentKey( (String)map.get(EquipmentMeta.EQUIPMENT_KEY));
				this.setNotes( (String)map.get(EquipmentMeta.NOTES));
				this.setProductId( (String)map.get(EquipmentMeta.PRODUCT_ID));
				this.setEquipmentCode( (String)map.get(EquipmentMeta.EQUIPMENT_CODE));
				this.setDn( (String)map.get(EquipmentMeta.DN));
				this.setUpdateTime( (Date)map.get(EquipmentMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(EquipmentMeta.VERSION));
				this.setCreateBy( (String)map.get(EquipmentMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(EquipmentMeta.DELETED));
				this.setCreateTime( (Date)map.get(EquipmentMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(EquipmentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(EquipmentMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(EquipmentMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(EquipmentMeta.DELETE_BY));
				this.setId( (String)map.get(EquipmentMeta.ID));
				this.setStatus( (String)map.get(EquipmentMeta.STATUS));
				this.setGroupCode( (String)map.get(EquipmentMeta.GROUP_CODE));
				// others
				this.setIotProduct( (Product)map.get(EquipmentMeta.IOT_PRODUCT));
				this.setGroup( (DictItem)map.get(EquipmentMeta.GROUP));
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
			this.setEquipmentKey(DataParser.parse(String.class, r.getValue(EquipmentMeta.EQUIPMENT_KEY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(EquipmentMeta.NOTES)));
			this.setProductId(DataParser.parse(String.class, r.getValue(EquipmentMeta.PRODUCT_ID)));
			this.setEquipmentCode(DataParser.parse(String.class, r.getValue(EquipmentMeta.EQUIPMENT_CODE)));
			this.setDn(DataParser.parse(String.class, r.getValue(EquipmentMeta.DN)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(EquipmentMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(EquipmentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(EquipmentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(EquipmentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(EquipmentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(EquipmentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(EquipmentMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(EquipmentMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(EquipmentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(EquipmentMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(EquipmentMeta.STATUS)));
			this.setGroupCode(DataParser.parse(String.class, r.getValue(EquipmentMeta.GROUP_CODE)));
			return true;
		} else {
			try {
				this.setEquipmentKey( (String)r.getValue(EquipmentMeta.EQUIPMENT_KEY));
				this.setNotes( (String)r.getValue(EquipmentMeta.NOTES));
				this.setProductId( (String)r.getValue(EquipmentMeta.PRODUCT_ID));
				this.setEquipmentCode( (String)r.getValue(EquipmentMeta.EQUIPMENT_CODE));
				this.setDn( (String)r.getValue(EquipmentMeta.DN));
				this.setUpdateTime( (Date)r.getValue(EquipmentMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(EquipmentMeta.VERSION));
				this.setCreateBy( (String)r.getValue(EquipmentMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(EquipmentMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(EquipmentMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(EquipmentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(EquipmentMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(EquipmentMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(EquipmentMeta.DELETE_BY));
				this.setId( (String)r.getValue(EquipmentMeta.ID));
				this.setStatus( (String)r.getValue(EquipmentMeta.STATUS));
				this.setGroupCode( (String)r.getValue(EquipmentMeta.GROUP_CODE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}