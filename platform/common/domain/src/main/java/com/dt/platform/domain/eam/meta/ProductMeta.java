package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Product;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.ProductFunction;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:38
 * @sign 61278CF1602725F6EE74921AF3E224D0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 产品Key , 类型: java.lang.String
	*/
	public static final String PRODUCT_KEY="productKey";
	
	/**
	 * 产品Key , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> PRODUCT_KEY_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,PRODUCT_KEY, java.lang.String.class, "产品Key", "产品Key", java.lang.String.class, null);
	
	/**
	 * 产品名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 产品名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,NAME, java.lang.String.class, "产品名称", "产品名称", java.lang.String.class, null);
	
	/**
	 * 品类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 品类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,CATEGORY_ID, java.lang.String.class, "品类", "品类", java.lang.String.class, null);
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final String PRODUCT_TYPE="productType";
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> PRODUCT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,PRODUCT_TYPE, java.lang.String.class, "节点类型", "节点类型", java.lang.String.class, null);
	
	/**
	 * 透传设备 , 类型: java.lang.String
	*/
	public static final String PRODUCT_TRANSPARENT="productTransparent";
	
	/**
	 * 透传设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> PRODUCT_TRANSPARENT_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,PRODUCT_TRANSPARENT, java.lang.String.class, "透传设备", "透传设备", java.lang.String.class, null);
	
	/**
	 * 设备定位 , 类型: java.lang.String
	*/
	public static final String LOCATION_STATUS="locationStatus";
	
	/**
	 * 设备定位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> LOCATION_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,LOCATION_STATUS, java.lang.String.class, "设备定位", "设备定位", java.lang.String.class, null);
	
	/**
	 * 定位方式 , 类型: java.lang.String
	*/
	public static final String LOCATION_METHOD="locationMethod";
	
	/**
	 * 定位方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> LOCATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,LOCATION_METHOD, java.lang.String.class, "定位方式", "定位方式", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String IMAGE_ID="imageId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> IMAGE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,IMAGE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * category , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String CATEGORY="category";
	
	/**
	 * category , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,org.github.foxnic.web.domain.system.DictItem> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,CATEGORY, org.github.foxnic.web.domain.system.DictItem.class, "category", "category", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * productFunctionEvent , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final String PRODUCT_FUNCTION_EVENT="productFunctionEvent";
	
	/**
	 * productFunctionEvent , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,com.dt.platform.domain.eam.ProductFunction> PRODUCT_FUNCTION_EVENT_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,PRODUCT_FUNCTION_EVENT, java.util.List.class, "productFunctionEvent", "productFunctionEvent", com.dt.platform.domain.eam.ProductFunction.class, null);
	
	/**
	 * productFunctionProperty , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final String PRODUCT_FUNCTION_PROPERTY="productFunctionProperty";
	
	/**
	 * productFunctionProperty , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,com.dt.platform.domain.eam.ProductFunction> PRODUCT_FUNCTION_PROPERTY_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,PRODUCT_FUNCTION_PROPERTY, java.util.List.class, "productFunctionProperty", "productFunctionProperty", com.dt.platform.domain.eam.ProductFunction.class, null);
	
	/**
	 * productFunctionService , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final String PRODUCT_FUNCTION_SERVICE="productFunctionService";
	
	/**
	 * productFunctionService , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Product,com.dt.platform.domain.eam.ProductFunction> PRODUCT_FUNCTION_SERVICE_PROP = new BeanProperty(com.dt.platform.domain.eam.Product.class ,PRODUCT_FUNCTION_SERVICE, java.util.List.class, "productFunctionService", "productFunctionService", com.dt.platform.domain.eam.ProductFunction.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PRODUCT_KEY , NAME , CATEGORY_ID , PRODUCT_TYPE , PRODUCT_TRANSPARENT , LOCATION_STATUS , LOCATION_METHOD , IMAGE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CATEGORY , SELECTED_CODE , PRODUCT_FUNCTION_EVENT , PRODUCT_FUNCTION_PROPERTY , PRODUCT_FUNCTION_SERVICE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.Product {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Product setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 产品Key
		 * @param productKey 产品Key
		 * @return 当前对象
		*/
		public Product setProductKey(String productKey) {
			super.change(PRODUCT_KEY,super.getProductKey(),productKey);
			super.setProductKey(productKey);
			return this;
		}
		
		/**
		 * 设置 产品名称
		 * @param name 产品名称
		 * @return 当前对象
		*/
		public Product setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 品类
		 * @param categoryId 品类
		 * @return 当前对象
		*/
		public Product setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param productType 节点类型
		 * @return 当前对象
		*/
		public Product setProductType(String productType) {
			super.change(PRODUCT_TYPE,super.getProductType(),productType);
			super.setProductType(productType);
			return this;
		}
		
		/**
		 * 设置 透传设备
		 * @param productTransparent 透传设备
		 * @return 当前对象
		*/
		public Product setProductTransparent(String productTransparent) {
			super.change(PRODUCT_TRANSPARENT,super.getProductTransparent(),productTransparent);
			super.setProductTransparent(productTransparent);
			return this;
		}
		
		/**
		 * 设置 设备定位
		 * @param locationStatus 设备定位
		 * @return 当前对象
		*/
		public Product setLocationStatus(String locationStatus) {
			super.change(LOCATION_STATUS,super.getLocationStatus(),locationStatus);
			super.setLocationStatus(locationStatus);
			return this;
		}
		
		/**
		 * 设置 定位方式
		 * @param locationMethod 定位方式
		 * @return 当前对象
		*/
		public Product setLocationMethod(String locationMethod) {
			super.change(LOCATION_METHOD,super.getLocationMethod(),locationMethod);
			super.setLocationMethod(locationMethod);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param imageId 图片
		 * @return 当前对象
		*/
		public Product setImageId(String imageId) {
			super.change(IMAGE_ID,super.getImageId(),imageId);
			super.setImageId(imageId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Product setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Product setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Product setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Product setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Product setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Product setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Product setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Product setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Product setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Product setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 category
		 * @param category category
		 * @return 当前对象
		*/
		public Product setCategory(DictItem category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public Product setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 productFunctionEvent
		 * @param productFunctionEvent productFunctionEvent
		 * @return 当前对象
		*/
		public Product setProductFunctionEvent(List<ProductFunction> productFunctionEvent) {
			super.change(PRODUCT_FUNCTION_EVENT,super.getProductFunctionEvent(),productFunctionEvent);
			super.setProductFunctionEvent(productFunctionEvent);
			return this;
		}
		
		/**
		 * 设置 productFunctionProperty
		 * @param productFunctionProperty productFunctionProperty
		 * @return 当前对象
		*/
		public Product setProductFunctionProperty(List<ProductFunction> productFunctionProperty) {
			super.change(PRODUCT_FUNCTION_PROPERTY,super.getProductFunctionProperty(),productFunctionProperty);
			super.setProductFunctionProperty(productFunctionProperty);
			return this;
		}
		
		/**
		 * 设置 productFunctionService
		 * @param productFunctionService productFunctionService
		 * @return 当前对象
		*/
		public Product setProductFunctionService(List<ProductFunction> productFunctionService) {
			super.change(PRODUCT_FUNCTION_SERVICE,super.getProductFunctionService(),productFunctionService);
			super.setProductFunctionService(productFunctionService);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}