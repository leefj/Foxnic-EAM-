package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.ProductVO;
import java.util.List;
import com.dt.platform.domain.eam.Product;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.ProductFunction;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:38
 * @sign 873674052A5576006C8B198330C0C88D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductVOMeta extends ProductMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 产品Key , 类型: java.lang.String
	*/
	public static final String PRODUCT_KEY="productKey";
	
	/**
	 * 产品Key , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> PRODUCT_KEY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PRODUCT_KEY, java.lang.String.class, "产品Key", "产品Key", java.lang.String.class, null);
	
	/**
	 * 产品名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 产品名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,NAME, java.lang.String.class, "产品名称", "产品名称", java.lang.String.class, null);
	
	/**
	 * 品类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 品类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,CATEGORY_ID, java.lang.String.class, "品类", "品类", java.lang.String.class, null);
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final String PRODUCT_TYPE="productType";
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> PRODUCT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PRODUCT_TYPE, java.lang.String.class, "节点类型", "节点类型", java.lang.String.class, null);
	
	/**
	 * 透传设备 , 类型: java.lang.String
	*/
	public static final String PRODUCT_TRANSPARENT="productTransparent";
	
	/**
	 * 透传设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> PRODUCT_TRANSPARENT_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PRODUCT_TRANSPARENT, java.lang.String.class, "透传设备", "透传设备", java.lang.String.class, null);
	
	/**
	 * 设备定位 , 类型: java.lang.String
	*/
	public static final String LOCATION_STATUS="locationStatus";
	
	/**
	 * 设备定位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> LOCATION_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,LOCATION_STATUS, java.lang.String.class, "设备定位", "设备定位", java.lang.String.class, null);
	
	/**
	 * 定位方式 , 类型: java.lang.String
	*/
	public static final String LOCATION_METHOD="locationMethod";
	
	/**
	 * 定位方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> LOCATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,LOCATION_METHOD, java.lang.String.class, "定位方式", "定位方式", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String IMAGE_ID="imageId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> IMAGE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,IMAGE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * category , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String CATEGORY="category";
	
	/**
	 * category , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,org.github.foxnic.web.domain.system.DictItem> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,CATEGORY, org.github.foxnic.web.domain.system.DictItem.class, "category", "category", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * productFunctionEvent , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final String PRODUCT_FUNCTION_EVENT="productFunctionEvent";
	
	/**
	 * productFunctionEvent , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,com.dt.platform.domain.eam.ProductFunction> PRODUCT_FUNCTION_EVENT_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PRODUCT_FUNCTION_EVENT, java.util.List.class, "productFunctionEvent", "productFunctionEvent", com.dt.platform.domain.eam.ProductFunction.class, null);
	
	/**
	 * productFunctionProperty , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final String PRODUCT_FUNCTION_PROPERTY="productFunctionProperty";
	
	/**
	 * productFunctionProperty , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,com.dt.platform.domain.eam.ProductFunction> PRODUCT_FUNCTION_PROPERTY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PRODUCT_FUNCTION_PROPERTY, java.util.List.class, "productFunctionProperty", "productFunctionProperty", com.dt.platform.domain.eam.ProductFunction.class, null);
	
	/**
	 * productFunctionService , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final String PRODUCT_FUNCTION_SERVICE="productFunctionService";
	
	/**
	 * productFunctionService , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductVO,com.dt.platform.domain.eam.ProductFunction> PRODUCT_FUNCTION_SERVICE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductVO.class ,PRODUCT_FUNCTION_SERVICE, java.util.List.class, "productFunctionService", "productFunctionService", com.dt.platform.domain.eam.ProductFunction.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , PRODUCT_KEY , NAME , CATEGORY_ID , PRODUCT_TYPE , PRODUCT_TRANSPARENT , LOCATION_STATUS , LOCATION_METHOD , IMAGE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CATEGORY , SELECTED_CODE , PRODUCT_FUNCTION_EVENT , PRODUCT_FUNCTION_PROPERTY , PRODUCT_FUNCTION_SERVICE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.ProductVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProductVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProductVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProductVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ProductVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProductVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ProductVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ProductVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ProductVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public ProductVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public ProductVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public ProductVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProductVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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
		public ProductVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProductVO duplicate(boolean all) {
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
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setSelectedCode(this.getSelectedCode());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setProductFunctionEvent(this.getProductFunctionEvent());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setProductFunctionService(this.getProductFunctionService());
				inst.setCategory(this.getCategory());
				inst.setSearchValue(this.getSearchValue());
				inst.setProductFunctionProperty(this.getProductFunctionProperty());
			}
			inst.clearModifies();
			return inst;
		}

	}
}