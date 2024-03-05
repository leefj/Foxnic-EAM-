package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_GOODS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 物品档案
 * <p>物品档案 , 数据表 eam_goods 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-21 10:02:51
 * @sign A38B13F7C8ED2288C20CAEF1D5231F0A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_goods")
@ApiModel(description = "物品档案 ; 物品档案 , 数据表 eam_goods 的PO类型")
public class Goods extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_GOODS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 物品名称：物品名称
	*/
	@ApiModelProperty(required = false,value="物品名称" , notes = "物品名称")
	private String name;
	
	/**
	 * 规格型号：规格型号
	*/
	@ApiModelProperty(required = false,value="规格型号" , notes = "规格型号")
	private String model;
	
	/**
	 * 厂商：厂商
	*/
	@ApiModelProperty(required = false,value="厂商" , notes = "厂商")
	private String manufacturerId;
	
	/**
	 * 计量单位：计量单位
	*/
	@ApiModelProperty(required = false,value="计量单位" , notes = "计量单位")
	private String unit;
	
	/**
	 * 参考单价：参考单价
	*/
	@ApiModelProperty(required = false,value="参考单价" , notes = "参考单价")
	private BigDecimal referencePrice;
	
	/**
	 * 物品图片：物品图片
	*/
	@ApiModelProperty(required = false,value="物品图片" , notes = "物品图片")
	private String pictureId;
	
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
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Category category;
	
	/**
	 * 生产厂商：生产厂商
	*/
	@ApiModelProperty(required = false,value="生产厂商" , notes = "生产厂商")
	private Manufacturer manufacturer;
	
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
	public Goods setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public Goods setCategoryId(String categoryId) {
		this.categoryId=categoryId;
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
	public Goods setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 物品名称<br>
	 * 物品名称
	 * @return 物品名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 物品名称
	 * @param name 物品名称
	 * @return 当前对象
	*/
	public Goods setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 规格型号<br>
	 * 规格型号
	 * @return 规格型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 规格型号
	 * @param model 规格型号
	 * @return 当前对象
	*/
	public Goods setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 厂商<br>
	 * 厂商
	 * @return 厂商
	*/
	public String getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * 设置 厂商
	 * @param manufacturerId 厂商
	 * @return 当前对象
	*/
	public Goods setManufacturerId(String manufacturerId) {
		this.manufacturerId=manufacturerId;
		return this;
	}
	
	/**
	 * 获得 计量单位<br>
	 * 计量单位
	 * @return 计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 计量单位
	 * @param unit 计量单位
	 * @return 当前对象
	*/
	public Goods setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 参考单价<br>
	 * 参考单价
	 * @return 参考单价
	*/
	public BigDecimal getReferencePrice() {
		return referencePrice;
	}
	
	/**
	 * 设置 参考单价
	 * @param referencePrice 参考单价
	 * @return 当前对象
	*/
	public Goods setReferencePrice(BigDecimal referencePrice) {
		this.referencePrice=referencePrice;
		return this;
	}
	
	/**
	 * 获得 物品图片<br>
	 * 物品图片
	 * @return 物品图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 物品图片
	 * @param pictureId 物品图片
	 * @return 当前对象
	*/
	public Goods setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public Goods setNotes(String notes) {
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
	public Goods setCreateBy(String createBy) {
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
	public Goods setCreateTime(Date createTime) {
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
	public Goods setUpdateBy(String updateBy) {
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
	public Goods setUpdateTime(Date updateTime) {
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
	public Goods setDeleted(Integer deleted) {
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
	public Goods setDeleted(Boolean deletedBool) {
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
	public Goods setDeleteBy(String deleteBy) {
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
	public Goods setDeleteTime(Date deleteTime) {
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
	public Goods setVersion(Integer version) {
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
	public Goods setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Category getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public Goods setCategory(Category category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 生产厂商<br>
	 * 生产厂商
	 * @return 生产厂商
	*/
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * 设置 生产厂商
	 * @param manufacturer 生产厂商
	 * @return 当前对象
	*/
	public Goods setManufacturer(Manufacturer manufacturer) {
		this.manufacturer=manufacturer;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Goods , 转换好的 Goods 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Goods , 转换好的 PoJo 对象
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
	public Goods clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Goods duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.GoodsMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.GoodsMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setManufacturerId(this.getManufacturerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setUnit(this.getUnit());
		inst.setReferencePrice(this.getReferencePrice());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setCategoryId(this.getCategoryId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setCategory(this.getCategory());
			inst.setManufacturer(this.getManufacturer());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Goods clone(boolean deep) {
		return EntityContext.clone(Goods.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Goods
	 * @param goodsMap 包含实体信息的 Map 对象
	 * @return Goods , 转换好的的 Goods 对象
	*/
	@Transient
	public static Goods createFrom(Map<String,Object> goodsMap) {
		if(goodsMap==null) return null;
		Goods po = create();
		EntityContext.copyProperties(po,goodsMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Goods
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Goods , 转换好的的 Goods 对象
	*/
	@Transient
	public static Goods createFrom(Object pojo) {
		if(pojo==null) return null;
		Goods po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Goods，等同于 new
	 * @return Goods 对象
	*/
	@Transient
	public static Goods create() {
		return new com.dt.platform.domain.eam.meta.GoodsMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(GoodsMeta.NOTES)));
			this.setManufacturerId(DataParser.parse(String.class, map.get(GoodsMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(GoodsMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(GoodsMeta.VERSION)));
			this.setUnit(DataParser.parse(String.class, map.get(GoodsMeta.UNIT)));
			this.setReferencePrice(DataParser.parse(BigDecimal.class, map.get(GoodsMeta.REFERENCE_PRICE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(GoodsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(GoodsMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(GoodsMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(GoodsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(GoodsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(GoodsMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(GoodsMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(GoodsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(GoodsMeta.DELETE_BY)));
			this.setModel(DataParser.parse(String.class, map.get(GoodsMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(GoodsMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(GoodsMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(GoodsMeta.STATUS)));
			// others
			this.setCategory(DataParser.parse(Category.class, map.get(GoodsMeta.CATEGORY)));
			this.setManufacturer(DataParser.parse(Manufacturer.class, map.get(GoodsMeta.MANUFACTURER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(GoodsMeta.NOTES));
				this.setManufacturerId( (String)map.get(GoodsMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)map.get(GoodsMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(GoodsMeta.VERSION));
				this.setUnit( (String)map.get(GoodsMeta.UNIT));
				this.setReferencePrice( (BigDecimal)map.get(GoodsMeta.REFERENCE_PRICE));
				this.setCreateBy( (String)map.get(GoodsMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(GoodsMeta.DELETED));
				this.setPictureId( (String)map.get(GoodsMeta.PICTURE_ID));
				this.setCreateTime( (Date)map.get(GoodsMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(GoodsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(GoodsMeta.DELETE_TIME));
				this.setName( (String)map.get(GoodsMeta.NAME));
				this.setTenantId( (String)map.get(GoodsMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(GoodsMeta.DELETE_BY));
				this.setModel( (String)map.get(GoodsMeta.MODEL));
				this.setId( (String)map.get(GoodsMeta.ID));
				this.setCategoryId( (String)map.get(GoodsMeta.CATEGORY_ID));
				this.setStatus( (String)map.get(GoodsMeta.STATUS));
				// others
				this.setCategory( (Category)map.get(GoodsMeta.CATEGORY));
				this.setManufacturer( (Manufacturer)map.get(GoodsMeta.MANUFACTURER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(GoodsMeta.NOTES)));
			this.setManufacturerId(DataParser.parse(String.class, r.getValue(GoodsMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(GoodsMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(GoodsMeta.VERSION)));
			this.setUnit(DataParser.parse(String.class, r.getValue(GoodsMeta.UNIT)));
			this.setReferencePrice(DataParser.parse(BigDecimal.class, r.getValue(GoodsMeta.REFERENCE_PRICE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(GoodsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(GoodsMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(GoodsMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(GoodsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(GoodsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(GoodsMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(GoodsMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(GoodsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(GoodsMeta.DELETE_BY)));
			this.setModel(DataParser.parse(String.class, r.getValue(GoodsMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(GoodsMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(GoodsMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(GoodsMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(GoodsMeta.NOTES));
				this.setManufacturerId( (String)r.getValue(GoodsMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)r.getValue(GoodsMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(GoodsMeta.VERSION));
				this.setUnit( (String)r.getValue(GoodsMeta.UNIT));
				this.setReferencePrice( (BigDecimal)r.getValue(GoodsMeta.REFERENCE_PRICE));
				this.setCreateBy( (String)r.getValue(GoodsMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(GoodsMeta.DELETED));
				this.setPictureId( (String)r.getValue(GoodsMeta.PICTURE_ID));
				this.setCreateTime( (Date)r.getValue(GoodsMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(GoodsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(GoodsMeta.DELETE_TIME));
				this.setName( (String)r.getValue(GoodsMeta.NAME));
				this.setTenantId( (String)r.getValue(GoodsMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(GoodsMeta.DELETE_BY));
				this.setModel( (String)r.getValue(GoodsMeta.MODEL));
				this.setId( (String)r.getValue(GoodsMeta.ID));
				this.setCategoryId( (String)r.getValue(GoodsMeta.CATEGORY_ID));
				this.setStatus( (String)r.getValue(GoodsMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}