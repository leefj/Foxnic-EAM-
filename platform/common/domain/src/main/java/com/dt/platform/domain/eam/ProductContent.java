package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.IotTables.IOT_PRODUCT_CONTENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.ProductContentMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 设备内容
 * <p>设备内容 , 数据表 iot_product_content 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:37:34
 * @sign 8357274DAB254DF15C5BDE2FAC696DF8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "iot_product_content")
@ApiModel(description = "设备内容 ; 设备内容 , 数据表 iot_product_content 的PO类型")
public class ProductContent extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =IOT_PRODUCT_CONTENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 产品：产品
	*/
	@ApiModelProperty(required = false,value="产品" , notes = "产品")
	private String ownerId;
	
	/**
	 * 配置：配置
	*/
	@ApiModelProperty(required = false,value="配置" , notes = "配置")
	private String conf;
	
	/**
	 * TSL：TSL
	*/
	@ApiModelProperty(required = false,value="TSL" , notes = "TSL")
	private String tsl;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
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
	public ProductContent setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 产品<br>
	 * 产品
	 * @return 产品
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 产品
	 * @param ownerId 产品
	 * @return 当前对象
	*/
	public ProductContent setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 配置<br>
	 * 配置
	 * @return 配置
	*/
	public String getConf() {
		return conf;
	}
	
	/**
	 * 设置 配置
	 * @param conf 配置
	 * @return 当前对象
	*/
	public ProductContent setConf(String conf) {
		this.conf=conf;
		return this;
	}
	
	/**
	 * 获得 TSL<br>
	 * TSL
	 * @return TSL
	*/
	public String getTsl() {
		return tsl;
	}
	
	/**
	 * 设置 TSL
	 * @param tsl TSL
	 * @return 当前对象
	*/
	public ProductContent setTsl(String tsl) {
		this.tsl=tsl;
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
	public ProductContent setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public ProductContent setContent(String content) {
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
	public ProductContent setCreateBy(String createBy) {
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
	public ProductContent setCreateTime(Date createTime) {
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
	public ProductContent setUpdateBy(String updateBy) {
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
	public ProductContent setUpdateTime(Date updateTime) {
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
	public ProductContent setDeleted(Integer deleted) {
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
	public ProductContent setDeleted(Boolean deletedBool) {
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
	public ProductContent setDeleteBy(String deleteBy) {
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
	public ProductContent setDeleteTime(Date deleteTime) {
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
	public ProductContent setVersion(Integer version) {
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
	public ProductContent setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProductContent , 转换好的 ProductContent 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProductContent , 转换好的 PoJo 对象
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
	public ProductContent clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProductContent duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.ProductContentMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.ProductContentMeta.$$proxy$$();
		inst.setConf(this.getConf());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setTsl(this.getTsl());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProductContent clone(boolean deep) {
		return EntityContext.clone(ProductContent.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProductContent
	 * @param productContentMap 包含实体信息的 Map 对象
	 * @return ProductContent , 转换好的的 ProductContent 对象
	*/
	@Transient
	public static ProductContent createFrom(Map<String,Object> productContentMap) {
		if(productContentMap==null) return null;
		ProductContent po = create();
		EntityContext.copyProperties(po,productContentMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProductContent
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProductContent , 转换好的的 ProductContent 对象
	*/
	@Transient
	public static ProductContent createFrom(Object pojo) {
		if(pojo==null) return null;
		ProductContent po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProductContent，等同于 new
	 * @return ProductContent 对象
	*/
	@Transient
	public static ProductContent create() {
		return new com.dt.platform.domain.eam.meta.ProductContentMeta.$$proxy$$();
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
			this.setConf(DataParser.parse(String.class, map.get(ProductContentMeta.CONF)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProductContentMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(ProductContentMeta.OWNER_ID)));
			this.setTsl(DataParser.parse(String.class, map.get(ProductContentMeta.TSL)));
			this.setType(DataParser.parse(String.class, map.get(ProductContentMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProductContentMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(ProductContentMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProductContentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProductContentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProductContentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProductContentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProductContentMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProductContentMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProductContentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProductContentMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setConf( (String)map.get(ProductContentMeta.CONF));
				this.setUpdateTime( (Date)map.get(ProductContentMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(ProductContentMeta.OWNER_ID));
				this.setTsl( (String)map.get(ProductContentMeta.TSL));
				this.setType( (String)map.get(ProductContentMeta.TYPE));
				this.setVersion( (Integer)map.get(ProductContentMeta.VERSION));
				this.setContent( (String)map.get(ProductContentMeta.CONTENT));
				this.setCreateBy( (String)map.get(ProductContentMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProductContentMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProductContentMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProductContentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProductContentMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ProductContentMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProductContentMeta.DELETE_BY));
				this.setId( (String)map.get(ProductContentMeta.ID));
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
			this.setConf(DataParser.parse(String.class, r.getValue(ProductContentMeta.CONF)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProductContentMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(ProductContentMeta.OWNER_ID)));
			this.setTsl(DataParser.parse(String.class, r.getValue(ProductContentMeta.TSL)));
			this.setType(DataParser.parse(String.class, r.getValue(ProductContentMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProductContentMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(ProductContentMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProductContentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProductContentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProductContentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProductContentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProductContentMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProductContentMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProductContentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProductContentMeta.ID)));
			return true;
		} else {
			try {
				this.setConf( (String)r.getValue(ProductContentMeta.CONF));
				this.setUpdateTime( (Date)r.getValue(ProductContentMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(ProductContentMeta.OWNER_ID));
				this.setTsl( (String)r.getValue(ProductContentMeta.TSL));
				this.setType( (String)r.getValue(ProductContentMeta.TYPE));
				this.setVersion( (Integer)r.getValue(ProductContentMeta.VERSION));
				this.setContent( (String)r.getValue(ProductContentMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(ProductContentMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProductContentMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProductContentMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProductContentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProductContentMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ProductContentMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProductContentMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProductContentMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}