package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.IotTables.IOT_PRODUCT_FUNCTION_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.ProductFunctionItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 内容
 * <p>内容 , 数据表 iot_product_function_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:30
 * @sign 12413D310E8DCE97D61C8D1368219939
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "iot_product_function_item")
@ApiModel(description = "内容 ; 内容 , 数据表 iot_product_function_item 的PO类型")
public class ProductFunctionItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =IOT_PRODUCT_FUNCTION_ITEM.$TABLE;
	
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
	 * 类型：input,output
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "input,output")
	private String type;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 标识符：标识符
	*/
	@ApiModelProperty(required = false,value="标识符" , notes = "标识符")
	private String identifier;
	
	/**
	 * 描述：描述
	*/
	@ApiModelProperty(required = false,value="描述" , notes = "描述")
	private String functionDesc;
	
	/**
	 * 单位：单位
	*/
	@ApiModelProperty(required = false,value="单位" , notes = "单位")
	private String functionUnit;
	
	/**
	 * 数据类型：数据类型
	*/
	@ApiModelProperty(required = false,value="数据类型" , notes = "数据类型")
	private String dataType;
	
	/**
	 * 内容定义：内容定义
	*/
	@ApiModelProperty(required = false,value="内容定义" , notes = "内容定义")
	private String dataValue;
	
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
	public ProductFunctionItem setId(String id) {
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
	public ProductFunctionItem setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * input,output
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
	public ProductFunctionItem setType(String type) {
		this.type=type;
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
	public ProductFunctionItem setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 标识符<br>
	 * 标识符
	 * @return 标识符
	*/
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * 设置 标识符
	 * @param identifier 标识符
	 * @return 当前对象
	*/
	public ProductFunctionItem setIdentifier(String identifier) {
		this.identifier=identifier;
		return this;
	}
	
	/**
	 * 获得 描述<br>
	 * 描述
	 * @return 描述
	*/
	public String getFunctionDesc() {
		return functionDesc;
	}
	
	/**
	 * 设置 描述
	 * @param functionDesc 描述
	 * @return 当前对象
	*/
	public ProductFunctionItem setFunctionDesc(String functionDesc) {
		this.functionDesc=functionDesc;
		return this;
	}
	
	/**
	 * 获得 单位<br>
	 * 单位
	 * @return 单位
	*/
	public String getFunctionUnit() {
		return functionUnit;
	}
	
	/**
	 * 设置 单位
	 * @param functionUnit 单位
	 * @return 当前对象
	*/
	public ProductFunctionItem setFunctionUnit(String functionUnit) {
		this.functionUnit=functionUnit;
		return this;
	}
	
	/**
	 * 获得 数据类型<br>
	 * 数据类型
	 * @return 数据类型
	*/
	public String getDataType() {
		return dataType;
	}
	
	/**
	 * 设置 数据类型
	 * @param dataType 数据类型
	 * @return 当前对象
	*/
	public ProductFunctionItem setDataType(String dataType) {
		this.dataType=dataType;
		return this;
	}
	
	/**
	 * 获得 内容定义<br>
	 * 内容定义
	 * @return 内容定义
	*/
	public String getDataValue() {
		return dataValue;
	}
	
	/**
	 * 设置 内容定义
	 * @param dataValue 内容定义
	 * @return 当前对象
	*/
	public ProductFunctionItem setDataValue(String dataValue) {
		this.dataValue=dataValue;
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
	public ProductFunctionItem setCreateBy(String createBy) {
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
	public ProductFunctionItem setCreateTime(Date createTime) {
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
	public ProductFunctionItem setUpdateBy(String updateBy) {
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
	public ProductFunctionItem setUpdateTime(Date updateTime) {
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
	public ProductFunctionItem setDeleted(Integer deleted) {
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
	public ProductFunctionItem setDeleted(Boolean deletedBool) {
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
	public ProductFunctionItem setDeleteBy(String deleteBy) {
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
	public ProductFunctionItem setDeleteTime(Date deleteTime) {
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
	public ProductFunctionItem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProductFunctionItem , 转换好的 ProductFunctionItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProductFunctionItem , 转换好的 PoJo 对象
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
	public ProductFunctionItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProductFunctionItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.ProductFunctionItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.ProductFunctionItemMeta.$$proxy$$();
		inst.setIdentifier(this.getIdentifier());
		inst.setDataType(this.getDataType());
		inst.setDataValue(this.getDataValue());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setFunctionDesc(this.getFunctionDesc());
		inst.setOwnerId(this.getOwnerId());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFunctionUnit(this.getFunctionUnit());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProductFunctionItem clone(boolean deep) {
		return EntityContext.clone(ProductFunctionItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProductFunctionItem
	 * @param productFunctionItemMap 包含实体信息的 Map 对象
	 * @return ProductFunctionItem , 转换好的的 ProductFunctionItem 对象
	*/
	@Transient
	public static ProductFunctionItem createFrom(Map<String,Object> productFunctionItemMap) {
		if(productFunctionItemMap==null) return null;
		ProductFunctionItem po = create();
		EntityContext.copyProperties(po,productFunctionItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProductFunctionItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProductFunctionItem , 转换好的的 ProductFunctionItem 对象
	*/
	@Transient
	public static ProductFunctionItem createFrom(Object pojo) {
		if(pojo==null) return null;
		ProductFunctionItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProductFunctionItem，等同于 new
	 * @return ProductFunctionItem 对象
	*/
	@Transient
	public static ProductFunctionItem create() {
		return new com.dt.platform.domain.eam.meta.ProductFunctionItemMeta.$$proxy$$();
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
			this.setIdentifier(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.IDENTIFIER)));
			this.setDataType(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.DATA_TYPE)));
			this.setDataValue(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.DATA_VALUE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProductFunctionItemMeta.UPDATE_TIME)));
			this.setFunctionDesc(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.FUNCTION_DESC)));
			this.setOwnerId(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.OWNER_ID)));
			this.setType(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProductFunctionItemMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProductFunctionItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProductFunctionItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProductFunctionItemMeta.DELETE_TIME)));
			this.setFunctionUnit(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.FUNCTION_UNIT)));
			this.setName(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProductFunctionItemMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setIdentifier( (String)map.get(ProductFunctionItemMeta.IDENTIFIER));
				this.setDataType( (String)map.get(ProductFunctionItemMeta.DATA_TYPE));
				this.setDataValue( (String)map.get(ProductFunctionItemMeta.DATA_VALUE));
				this.setUpdateTime( (Date)map.get(ProductFunctionItemMeta.UPDATE_TIME));
				this.setFunctionDesc( (String)map.get(ProductFunctionItemMeta.FUNCTION_DESC));
				this.setOwnerId( (String)map.get(ProductFunctionItemMeta.OWNER_ID));
				this.setType( (String)map.get(ProductFunctionItemMeta.TYPE));
				this.setVersion( (Integer)map.get(ProductFunctionItemMeta.VERSION));
				this.setCreateBy( (String)map.get(ProductFunctionItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProductFunctionItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProductFunctionItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProductFunctionItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProductFunctionItemMeta.DELETE_TIME));
				this.setFunctionUnit( (String)map.get(ProductFunctionItemMeta.FUNCTION_UNIT));
				this.setName( (String)map.get(ProductFunctionItemMeta.NAME));
				this.setDeleteBy( (String)map.get(ProductFunctionItemMeta.DELETE_BY));
				this.setId( (String)map.get(ProductFunctionItemMeta.ID));
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
			this.setIdentifier(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.IDENTIFIER)));
			this.setDataType(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.DATA_TYPE)));
			this.setDataValue(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.DATA_VALUE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProductFunctionItemMeta.UPDATE_TIME)));
			this.setFunctionDesc(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.FUNCTION_DESC)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.OWNER_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProductFunctionItemMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProductFunctionItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProductFunctionItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProductFunctionItemMeta.DELETE_TIME)));
			this.setFunctionUnit(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.FUNCTION_UNIT)));
			this.setName(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProductFunctionItemMeta.ID)));
			return true;
		} else {
			try {
				this.setIdentifier( (String)r.getValue(ProductFunctionItemMeta.IDENTIFIER));
				this.setDataType( (String)r.getValue(ProductFunctionItemMeta.DATA_TYPE));
				this.setDataValue( (String)r.getValue(ProductFunctionItemMeta.DATA_VALUE));
				this.setUpdateTime( (Date)r.getValue(ProductFunctionItemMeta.UPDATE_TIME));
				this.setFunctionDesc( (String)r.getValue(ProductFunctionItemMeta.FUNCTION_DESC));
				this.setOwnerId( (String)r.getValue(ProductFunctionItemMeta.OWNER_ID));
				this.setType( (String)r.getValue(ProductFunctionItemMeta.TYPE));
				this.setVersion( (Integer)r.getValue(ProductFunctionItemMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ProductFunctionItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProductFunctionItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProductFunctionItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProductFunctionItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProductFunctionItemMeta.DELETE_TIME));
				this.setFunctionUnit( (String)r.getValue(ProductFunctionItemMeta.FUNCTION_UNIT));
				this.setName( (String)r.getValue(ProductFunctionItemMeta.NAME));
				this.setDeleteBy( (String)r.getValue(ProductFunctionItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProductFunctionItemMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}