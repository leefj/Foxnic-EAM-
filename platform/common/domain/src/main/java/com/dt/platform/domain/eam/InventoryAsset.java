package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_ASSET;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 盘点明细
 * <p>盘点明细 , 数据表 eam_inventory_asset 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-27 21:25:01
 * @sign 3C83C53E95140B59045FF70787CCF338
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory_asset")
@ApiModel(description = "盘点明细 ; 盘点明细 , 数据表 eam_inventory_asset 的PO类型")
public class InventoryAsset extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY_ASSET.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "2f319998-55ec-11ed-8950-00163e1b60a7")
	private String id;
	
	/**
	 * 盘点：盘点
	*/
	@ApiModelProperty(required = false,value="盘点" , notes = "盘点" , example = "638099539131105280")
	private String inventoryId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "not_counted")
	private String status;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产" , example = "572681223449608192")
	private String assetId;
	
	/**
	 * 员工：员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "员工")
	private String operEmplId;
	
	/**
	 * 盘盈动作：盘盈动作
	*/
	@ApiModelProperty(required = false,value="盘盈动作" , notes = "盘盈动作")
	private String assetPlusActionType;
	
	/**
	 * 盘亏动作：盘亏动作
	*/
	@ApiModelProperty(required = false,value="盘亏动作" , notes = "盘亏动作")
	private String assetLossActionType;
	
	/**
	 * 数据来源：数据来源
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "数据来源")
	private String source;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operDate;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private Employee operater;
	
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
	public InventoryAsset setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 盘点<br>
	 * 盘点
	 * @return 盘点
	*/
	public String getInventoryId() {
		return inventoryId;
	}
	
	/**
	 * 设置 盘点
	 * @param inventoryId 盘点
	 * @return 当前对象
	*/
	public InventoryAsset setInventoryId(String inventoryId) {
		this.inventoryId=inventoryId;
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
	public InventoryAsset setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产
	 * @param assetId 资产
	 * @return 当前对象
	*/
	public InventoryAsset setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 员工
	 * @return 员工
	*/
	public String getOperEmplId() {
		return operEmplId;
	}
	
	/**
	 * 设置 员工
	 * @param operEmplId 员工
	 * @return 当前对象
	*/
	public InventoryAsset setOperEmplId(String operEmplId) {
		this.operEmplId=operEmplId;
		return this;
	}
	
	/**
	 * 获得 盘盈动作<br>
	 * 盘盈动作
	 * @return 盘盈动作
	*/
	public String getAssetPlusActionType() {
		return assetPlusActionType;
	}
	
	/**
	 * 设置 盘盈动作
	 * @param assetPlusActionType 盘盈动作
	 * @return 当前对象
	*/
	public InventoryAsset setAssetPlusActionType(String assetPlusActionType) {
		this.assetPlusActionType=assetPlusActionType;
		return this;
	}
	
	/**
	 * 获得 盘亏动作<br>
	 * 盘亏动作
	 * @return 盘亏动作
	*/
	public String getAssetLossActionType() {
		return assetLossActionType;
	}
	
	/**
	 * 设置 盘亏动作
	 * @param assetLossActionType 盘亏动作
	 * @return 当前对象
	*/
	public InventoryAsset setAssetLossActionType(String assetLossActionType) {
		this.assetLossActionType=assetLossActionType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 数据来源
	 * @return 数据来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 数据来源
	 * @param source 数据来源
	 * @return 当前对象
	*/
	public InventoryAsset setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperDate() {
		return operDate;
	}
	
	/**
	 * 设置 操作时间
	 * @param operDate 操作时间
	 * @return 当前对象
	*/
	public InventoryAsset setOperDate(Date operDate) {
		this.operDate=operDate;
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
	public InventoryAsset setNotes(String notes) {
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
	public InventoryAsset setCreateBy(String createBy) {
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
	public InventoryAsset setCreateTime(Date createTime) {
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
	public InventoryAsset setUpdateBy(String updateBy) {
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
	public InventoryAsset setUpdateTime(Date updateTime) {
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
	public InventoryAsset setDeleted(Integer deleted) {
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
	public InventoryAsset setDeleted(Boolean deletedBool) {
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
	public InventoryAsset setDeleteBy(String deleteBy) {
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
	public InventoryAsset setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public InventoryAsset setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public InventoryAsset setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public Employee getOperater() {
		return operater;
	}
	
	/**
	 * 设置 操作人员
	 * @param operater 操作人员
	 * @return 当前对象
	*/
	public InventoryAsset setOperater(Employee operater) {
		this.operater=operater;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InventoryAsset , 转换好的 InventoryAsset 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryAsset , 转换好的 PoJo 对象
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
	public InventoryAsset clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InventoryAsset duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InventoryAssetMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InventoryAssetMeta.$$proxy$$();
		inst.setAssetLossActionType(this.getAssetLossActionType());
		inst.setOperDate(this.getOperDate());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSource(this.getSource());
		inst.setVersion(this.getVersion());
		inst.setAssetPlusActionType(this.getAssetPlusActionType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setOperEmplId(this.getOperEmplId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setInventoryId(this.getInventoryId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOperater(this.getOperater());
			inst.setAsset(this.getAsset());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InventoryAsset clone(boolean deep) {
		return EntityContext.clone(InventoryAsset.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InventoryAsset
	 * @param inventoryAssetMap 包含实体信息的 Map 对象
	 * @return InventoryAsset , 转换好的的 InventoryAsset 对象
	*/
	@Transient
	public static InventoryAsset createFrom(Map<String,Object> inventoryAssetMap) {
		if(inventoryAssetMap==null) return null;
		InventoryAsset po = create();
		EntityContext.copyProperties(po,inventoryAssetMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InventoryAsset
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryAsset , 转换好的的 InventoryAsset 对象
	*/
	@Transient
	public static InventoryAsset createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryAsset po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InventoryAsset，等同于 new
	 * @return InventoryAsset 对象
	*/
	@Transient
	public static InventoryAsset create() {
		return new com.dt.platform.domain.eam.meta.InventoryAssetMeta.$$proxy$$();
	}
}