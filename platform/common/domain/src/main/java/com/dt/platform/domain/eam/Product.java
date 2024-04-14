package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.IotTables.IOT_PRODUCT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.ProductMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 产品管理
 * <p>产品管理 , 数据表 iot_product 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:38
 * @sign 61278CF1602725F6EE74921AF3E224D0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "iot_product")
@ApiModel(description = "产品管理 ; 产品管理 , 数据表 iot_product 的PO类型")
public class Product extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =IOT_PRODUCT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "829082363148369920")
	private String id;
	
	/**
	 * 产品Key：产品Key
	*/
	@ApiModelProperty(required = false,value="产品Key" , notes = "产品Key" , example = "key")
	private String productKey;
	
	/**
	 * 产品名称：产品名称
	*/
	@ApiModelProperty(required = false,value="产品名称" , notes = "产品名称" , example = "门")
	private String name;
	
	/**
	 * 品类：品类
	*/
	@ApiModelProperty(required = false,value="品类" , notes = "品类" , example = "mc")
	private String categoryId;
	
	/**
	 * 节点类型：节点类型
	*/
	@ApiModelProperty(required = false,value="节点类型" , notes = "节点类型" , example = "gateway")
	private String productType;
	
	/**
	 * 透传设备：透传设备
	*/
	@ApiModelProperty(required = false,value="透传设备" , notes = "透传设备" , example = "yes")
	private String productTransparent;
	
	/**
	 * 设备定位：设备定位
	*/
	@ApiModelProperty(required = false,value="设备定位" , notes = "设备定位" , example = "enable")
	private String locationStatus;
	
	/**
	 * 定位方式：定位方式
	*/
	@ApiModelProperty(required = false,value="定位方式" , notes = "定位方式" , example = "report")
	private String locationMethod;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片" , example = "829083060526907392")
	private String imageId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-04-06 07:57:19")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-04-06 08:00:07")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * category：category
	*/
	@ApiModelProperty(required = false,value="category" , notes = "category")
	private DictItem category;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * productFunctionEvent：productFunctionEvent
	*/
	@ApiModelProperty(required = false,value="productFunctionEvent" , notes = "productFunctionEvent")
	private List<ProductFunction> productFunctionEvent;
	
	/**
	 * productFunctionProperty：productFunctionProperty
	*/
	@ApiModelProperty(required = false,value="productFunctionProperty" , notes = "productFunctionProperty")
	private List<ProductFunction> productFunctionProperty;
	
	/**
	 * productFunctionService：productFunctionService
	*/
	@ApiModelProperty(required = false,value="productFunctionService" , notes = "productFunctionService")
	private List<ProductFunction> productFunctionService;
	
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
	public Product setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 产品Key<br>
	 * 产品Key
	 * @return 产品Key
	*/
	public String getProductKey() {
		return productKey;
	}
	
	/**
	 * 设置 产品Key
	 * @param productKey 产品Key
	 * @return 当前对象
	*/
	public Product setProductKey(String productKey) {
		this.productKey=productKey;
		return this;
	}
	
	/**
	 * 获得 产品名称<br>
	 * 产品名称
	 * @return 产品名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 产品名称
	 * @param name 产品名称
	 * @return 当前对象
	*/
	public Product setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 品类<br>
	 * 品类
	 * @return 品类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 品类
	 * @param categoryId 品类
	 * @return 当前对象
	*/
	public Product setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 节点类型<br>
	 * 节点类型
	 * @return 节点类型
	*/
	public String getProductType() {
		return productType;
	}
	
	/**
	 * 设置 节点类型
	 * @param productType 节点类型
	 * @return 当前对象
	*/
	public Product setProductType(String productType) {
		this.productType=productType;
		return this;
	}
	
	/**
	 * 获得 透传设备<br>
	 * 透传设备
	 * @return 透传设备
	*/
	public String getProductTransparent() {
		return productTransparent;
	}
	
	/**
	 * 设置 透传设备
	 * @param productTransparent 透传设备
	 * @return 当前对象
	*/
	public Product setProductTransparent(String productTransparent) {
		this.productTransparent=productTransparent;
		return this;
	}
	
	/**
	 * 获得 设备定位<br>
	 * 设备定位
	 * @return 设备定位
	*/
	public String getLocationStatus() {
		return locationStatus;
	}
	
	/**
	 * 设置 设备定位
	 * @param locationStatus 设备定位
	 * @return 当前对象
	*/
	public Product setLocationStatus(String locationStatus) {
		this.locationStatus=locationStatus;
		return this;
	}
	
	/**
	 * 获得 定位方式<br>
	 * 定位方式
	 * @return 定位方式
	*/
	public String getLocationMethod() {
		return locationMethod;
	}
	
	/**
	 * 设置 定位方式
	 * @param locationMethod 定位方式
	 * @return 当前对象
	*/
	public Product setLocationMethod(String locationMethod) {
		this.locationMethod=locationMethod;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getImageId() {
		return imageId;
	}
	
	/**
	 * 设置 图片
	 * @param imageId 图片
	 * @return 当前对象
	*/
	public Product setImageId(String imageId) {
		this.imageId=imageId;
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
	public Product setNotes(String notes) {
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
	public Product setCreateBy(String createBy) {
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
	public Product setCreateTime(Date createTime) {
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
	public Product setUpdateBy(String updateBy) {
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
	public Product setUpdateTime(Date updateTime) {
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
	public Product setDeleted(Integer deleted) {
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
	public Product setDeleted(Boolean deletedBool) {
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
	public Product setDeleteBy(String deleteBy) {
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
	public Product setDeleteTime(Date deleteTime) {
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
	public Product setVersion(Integer version) {
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
	public Product setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 category<br>
	 * category
	 * @return category
	*/
	public DictItem getCategory() {
		return category;
	}
	
	/**
	 * 设置 category
	 * @param category category
	 * @return 当前对象
	*/
	public Product setCategory(DictItem category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 selectedCode<br>
	 * selectedCode
	 * @return selectedCode
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 selectedCode
	 * @param selectedCode selectedCode
	 * @return 当前对象
	*/
	public Product setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 productFunctionEvent<br>
	 * productFunctionEvent
	 * @return productFunctionEvent
	*/
	public List<ProductFunction> getProductFunctionEvent() {
		return productFunctionEvent;
	}
	
	/**
	 * 设置 productFunctionEvent
	 * @param productFunctionEvent productFunctionEvent
	 * @return 当前对象
	*/
	public Product setProductFunctionEvent(List<ProductFunction> productFunctionEvent) {
		this.productFunctionEvent=productFunctionEvent;
		return this;
	}
	
	/**
	 * 添加 productFunctionEvent
	 * @param entity productFunctionEvent
	 * @return 当前对象
	*/
	public Product addProductFunctionEvent(ProductFunction... entity) {
		if(this.productFunctionEvent==null) productFunctionEvent=new ArrayList<>();
		this.productFunctionEvent.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 productFunctionProperty<br>
	 * productFunctionProperty
	 * @return productFunctionProperty
	*/
	public List<ProductFunction> getProductFunctionProperty() {
		return productFunctionProperty;
	}
	
	/**
	 * 设置 productFunctionProperty
	 * @param productFunctionProperty productFunctionProperty
	 * @return 当前对象
	*/
	public Product setProductFunctionProperty(List<ProductFunction> productFunctionProperty) {
		this.productFunctionProperty=productFunctionProperty;
		return this;
	}
	
	/**
	 * 添加 productFunctionProperty
	 * @param entity productFunctionProperty
	 * @return 当前对象
	*/
	public Product addProductFunctionProperty(ProductFunction... entity) {
		if(this.productFunctionProperty==null) productFunctionProperty=new ArrayList<>();
		this.productFunctionProperty.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 productFunctionService<br>
	 * productFunctionService
	 * @return productFunctionService
	*/
	public List<ProductFunction> getProductFunctionService() {
		return productFunctionService;
	}
	
	/**
	 * 设置 productFunctionService
	 * @param productFunctionService productFunctionService
	 * @return 当前对象
	*/
	public Product setProductFunctionService(List<ProductFunction> productFunctionService) {
		this.productFunctionService=productFunctionService;
		return this;
	}
	
	/**
	 * 添加 productFunctionService
	 * @param entity productFunctionService
	 * @return 当前对象
	*/
	public Product addProductFunctionService(ProductFunction... entity) {
		if(this.productFunctionService==null) productFunctionService=new ArrayList<>();
		this.productFunctionService.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Product , 转换好的 Product 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Product , 转换好的 PoJo 对象
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
	public Product clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Product duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.ProductMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.ProductMeta.$$proxy$$();
		inst.setImageId(this.getImageId());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setProductKey(this.getProductKey());
		inst.setVersion(this.getVersion());
		inst.setLocationStatus(this.getLocationStatus());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setProductTransparent(this.getProductTransparent());
		inst.setLocationMethod(this.getLocationMethod());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setCategoryId(this.getCategoryId());
		inst.setProductType(this.getProductType());
		if(all) {
			inst.setProductFunctionEvent(this.getProductFunctionEvent());
			inst.setProductFunctionService(this.getProductFunctionService());
			inst.setCategory(this.getCategory());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setProductFunctionProperty(this.getProductFunctionProperty());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Product clone(boolean deep) {
		return EntityContext.clone(Product.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Product
	 * @param productMap 包含实体信息的 Map 对象
	 * @return Product , 转换好的的 Product 对象
	*/
	@Transient
	public static Product createFrom(Map<String,Object> productMap) {
		if(productMap==null) return null;
		Product po = create();
		EntityContext.copyProperties(po,productMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Product
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Product , 转换好的的 Product 对象
	*/
	@Transient
	public static Product createFrom(Object pojo) {
		if(pojo==null) return null;
		Product po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Product，等同于 new
	 * @return Product 对象
	*/
	@Transient
	public static Product create() {
		return new com.dt.platform.domain.eam.meta.ProductMeta.$$proxy$$();
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
			this.setImageId(DataParser.parse(String.class, map.get(ProductMeta.IMAGE_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(ProductMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProductMeta.UPDATE_TIME)));
			this.setProductKey(DataParser.parse(String.class, map.get(ProductMeta.PRODUCT_KEY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProductMeta.VERSION)));
			this.setLocationStatus(DataParser.parse(String.class, map.get(ProductMeta.LOCATION_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProductMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProductMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProductMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProductMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProductMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ProductMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProductMeta.TENANT_ID)));
			this.setProductTransparent(DataParser.parse(String.class, map.get(ProductMeta.PRODUCT_TRANSPARENT)));
			this.setLocationMethod(DataParser.parse(String.class, map.get(ProductMeta.LOCATION_METHOD)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProductMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProductMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(ProductMeta.CATEGORY_ID)));
			this.setProductType(DataParser.parse(String.class, map.get(ProductMeta.PRODUCT_TYPE)));
			// others
			this.setCategory(DataParser.parse(DictItem.class, map.get(ProductMeta.CATEGORY)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(ProductMeta.SELECTED_CODE)));
			return true;
		} else {
			try {
				this.setImageId( (String)map.get(ProductMeta.IMAGE_ID));
				this.setNotes( (String)map.get(ProductMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ProductMeta.UPDATE_TIME));
				this.setProductKey( (String)map.get(ProductMeta.PRODUCT_KEY));
				this.setVersion( (Integer)map.get(ProductMeta.VERSION));
				this.setLocationStatus( (String)map.get(ProductMeta.LOCATION_STATUS));
				this.setCreateBy( (String)map.get(ProductMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProductMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProductMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProductMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProductMeta.DELETE_TIME));
				this.setName( (String)map.get(ProductMeta.NAME));
				this.setTenantId( (String)map.get(ProductMeta.TENANT_ID));
				this.setProductTransparent( (String)map.get(ProductMeta.PRODUCT_TRANSPARENT));
				this.setLocationMethod( (String)map.get(ProductMeta.LOCATION_METHOD));
				this.setDeleteBy( (String)map.get(ProductMeta.DELETE_BY));
				this.setId( (String)map.get(ProductMeta.ID));
				this.setCategoryId( (String)map.get(ProductMeta.CATEGORY_ID));
				this.setProductType( (String)map.get(ProductMeta.PRODUCT_TYPE));
				// others
				this.setCategory( (DictItem)map.get(ProductMeta.CATEGORY));
				this.setSelectedCode( (String)map.get(ProductMeta.SELECTED_CODE));
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
			this.setImageId(DataParser.parse(String.class, r.getValue(ProductMeta.IMAGE_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ProductMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProductMeta.UPDATE_TIME)));
			this.setProductKey(DataParser.parse(String.class, r.getValue(ProductMeta.PRODUCT_KEY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProductMeta.VERSION)));
			this.setLocationStatus(DataParser.parse(String.class, r.getValue(ProductMeta.LOCATION_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProductMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProductMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProductMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProductMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProductMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ProductMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProductMeta.TENANT_ID)));
			this.setProductTransparent(DataParser.parse(String.class, r.getValue(ProductMeta.PRODUCT_TRANSPARENT)));
			this.setLocationMethod(DataParser.parse(String.class, r.getValue(ProductMeta.LOCATION_METHOD)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProductMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProductMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(ProductMeta.CATEGORY_ID)));
			this.setProductType(DataParser.parse(String.class, r.getValue(ProductMeta.PRODUCT_TYPE)));
			return true;
		} else {
			try {
				this.setImageId( (String)r.getValue(ProductMeta.IMAGE_ID));
				this.setNotes( (String)r.getValue(ProductMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ProductMeta.UPDATE_TIME));
				this.setProductKey( (String)r.getValue(ProductMeta.PRODUCT_KEY));
				this.setVersion( (Integer)r.getValue(ProductMeta.VERSION));
				this.setLocationStatus( (String)r.getValue(ProductMeta.LOCATION_STATUS));
				this.setCreateBy( (String)r.getValue(ProductMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProductMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProductMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProductMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProductMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ProductMeta.NAME));
				this.setTenantId( (String)r.getValue(ProductMeta.TENANT_ID));
				this.setProductTransparent( (String)r.getValue(ProductMeta.PRODUCT_TRANSPARENT));
				this.setLocationMethod( (String)r.getValue(ProductMeta.LOCATION_METHOD));
				this.setDeleteBy( (String)r.getValue(ProductMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProductMeta.ID));
				this.setCategoryId( (String)r.getValue(ProductMeta.CATEGORY_ID));
				this.setProductType( (String)r.getValue(ProductMeta.PRODUCT_TYPE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}