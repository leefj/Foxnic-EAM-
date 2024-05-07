package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.StockInventoryAssetVO;
import java.util.List;
import com.dt.platform.domain.eam.StockInventoryAsset;
import java.util.Date;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-06 09:57:49
 * @sign 122BA0D299360FE1BF7BF7CF5A5B94D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class StockInventoryAssetVOMeta extends StockInventoryAssetMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final String INVENTORY_STATUS="inventoryStatus";
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> INVENTORY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,INVENTORY_STATUS, java.lang.String.class, "盘点状态", "盘点状态", java.lang.String.class, null);
	
	/**
	 * 盘点备注 , 类型: java.lang.String
	*/
	public static final String INVENTORY_NOTES="inventoryNotes";
	
	/**
	 * 盘点备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> INVENTORY_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,INVENTORY_NOTES, java.lang.String.class, "盘点备注", "盘点备注", java.lang.String.class, null);
	
	/**
	 * 差异数量 , 类型: java.lang.Integer
	*/
	public static final String ASSET_NUMBER="assetNumber";
	
	/**
	 * 差异数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.Integer> ASSET_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,ASSET_NUMBER, java.lang.Integer.class, "差异数量", "差异数量", java.lang.Integer.class, null);
	
	/**
	 * 盘点人员 , 类型: java.lang.String
	*/
	public static final String OPER_ID="operId";
	
	/**
	 * 盘点人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> OPER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,OPER_ID, java.lang.String.class, "盘点人员", "盘点人员", java.lang.String.class, null);
	
	/**
	 * 盘点时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 盘点时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,OPER_TIME, java.util.Date.class, "盘点时间", "盘点时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * goodsStockAsset , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOODS_STOCK_ASSET="goodsStockAsset";
	
	/**
	 * goodsStockAsset , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,com.dt.platform.domain.eam.GoodsStock> GOODS_STOCK_ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,GOODS_STOCK_ASSET, com.dt.platform.domain.eam.GoodsStock.class, "goodsStockAsset", "goodsStockAsset", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "操作人员", "操作人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * withGoodsStockType , 类型: java.lang.String
	*/
	public static final String WITH_GOODS_STOCK_TYPE="withGoodsStockType";
	
	/**
	 * withGoodsStockType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_GOODS_STOCK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_GOODS_STOCK_TYPE, java.lang.String.class, "withGoodsStockType", "withGoodsStockType", java.lang.String.class, null);
	
	/**
	 * withWarehouse , 类型: java.lang.String
	*/
	public static final String WITH_WAREHOUSE="withWarehouse";
	
	/**
	 * withWarehouse , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_WAREHOUSE, java.lang.String.class, "withWarehouse", "withWarehouse", java.lang.String.class, null);
	
	/**
	 * withPosition , 类型: java.lang.String
	*/
	public static final String WITH_POSITION="withPosition";
	
	/**
	 * withPosition , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_POSITION, java.lang.String.class, "withPosition", "withPosition", java.lang.String.class, null);
	
	/**
	 * withName , 类型: java.lang.String
	*/
	public static final String WITH_NAME="withName";
	
	/**
	 * withName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_NAME, java.lang.String.class, "withName", "withName", java.lang.String.class, null);
	
	/**
	 * withCode , 类型: java.lang.String
	*/
	public static final String WITH_CODE="withCode";
	
	/**
	 * withCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_CODE, java.lang.String.class, "withCode", "withCode", java.lang.String.class, null);
	
	/**
	 * withModel , 类型: java.lang.String
	*/
	public static final String WITH_MODEL="withModel";
	
	/**
	 * withModel , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_MODEL, java.lang.String.class, "withModel", "withModel", java.lang.String.class, null);
	
	/**
	 * withBrand , 类型: java.lang.String
	*/
	public static final String WITH_BRAND="withBrand";
	
	/**
	 * withBrand , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_BRAND_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_BRAND, java.lang.String.class, "withBrand", "withBrand", java.lang.String.class, null);
	
	/**
	 * withManufacturer , 类型: java.lang.String
	*/
	public static final String WITH_MANUFACTURER="withManufacturer";
	
	/**
	 * withManufacturer , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_MANUFACTURER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_MANUFACTURER, java.lang.String.class, "withManufacturer", "withManufacturer", java.lang.String.class, null);
	
	/**
	 * withNumber , 类型: java.lang.String
	*/
	public static final String WITH_NUMBER="withNumber";
	
	/**
	 * withNumber , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryAssetVO,java.lang.String> WITH_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryAssetVO.class ,WITH_NUMBER, java.lang.String.class, "withNumber", "withNumber", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , TASK_ID , ASSET_ID , INVENTORY_STATUS , INVENTORY_NOTES , ASSET_NUMBER , OPER_ID , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , GOODS_STOCK_ASSET , OPER_USER , WITH_GOODS_STOCK_TYPE , WITH_WAREHOUSE , WITH_POSITION , WITH_NAME , WITH_CODE , WITH_MODEL , WITH_BRAND , WITH_MANUFACTURER , WITH_NUMBER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.StockInventoryAssetVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public StockInventoryAssetVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public StockInventoryAsset setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param taskId 任务
		 * @return 当前对象
		*/
		public StockInventoryAsset setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public StockInventoryAsset setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 盘点状态
		 * @param inventoryStatus 盘点状态
		 * @return 当前对象
		*/
		public StockInventoryAsset setInventoryStatus(String inventoryStatus) {
			super.change(INVENTORY_STATUS,super.getInventoryStatus(),inventoryStatus);
			super.setInventoryStatus(inventoryStatus);
			return this;
		}
		
		/**
		 * 设置 盘点备注
		 * @param inventoryNotes 盘点备注
		 * @return 当前对象
		*/
		public StockInventoryAsset setInventoryNotes(String inventoryNotes) {
			super.change(INVENTORY_NOTES,super.getInventoryNotes(),inventoryNotes);
			super.setInventoryNotes(inventoryNotes);
			return this;
		}
		
		/**
		 * 设置 差异数量
		 * @param assetNumber 差异数量
		 * @return 当前对象
		*/
		public StockInventoryAsset setAssetNumber(Integer assetNumber) {
			super.change(ASSET_NUMBER,super.getAssetNumber(),assetNumber);
			super.setAssetNumber(assetNumber);
			return this;
		}
		
		/**
		 * 设置 盘点人员
		 * @param operId 盘点人员
		 * @return 当前对象
		*/
		public StockInventoryAsset setOperId(String operId) {
			super.change(OPER_ID,super.getOperId(),operId);
			super.setOperId(operId);
			return this;
		}
		
		/**
		 * 设置 盘点时间
		 * @param operTime 盘点时间
		 * @return 当前对象
		*/
		public StockInventoryAsset setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public StockInventoryAsset setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public StockInventoryAsset setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public StockInventoryAsset setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public StockInventoryAsset setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public StockInventoryAsset setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public StockInventoryAsset setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public StockInventoryAsset setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public StockInventoryAsset setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 goodsStockAsset
		 * @param goodsStockAsset goodsStockAsset
		 * @return 当前对象
		*/
		public StockInventoryAsset setGoodsStockAsset(GoodsStock goodsStockAsset) {
			super.change(GOODS_STOCK_ASSET,super.getGoodsStockAsset(),goodsStockAsset);
			super.setGoodsStockAsset(goodsStockAsset);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUser 操作人员
		 * @return 当前对象
		*/
		public StockInventoryAsset setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}
		
		/**
		 * 设置 withGoodsStockType
		 * @param withGoodsStockType withGoodsStockType
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithGoodsStockType(String withGoodsStockType) {
			super.change(WITH_GOODS_STOCK_TYPE,super.getWithGoodsStockType(),withGoodsStockType);
			super.setWithGoodsStockType(withGoodsStockType);
			return this;
		}
		
		/**
		 * 设置 withWarehouse
		 * @param withWarehouse withWarehouse
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithWarehouse(String withWarehouse) {
			super.change(WITH_WAREHOUSE,super.getWithWarehouse(),withWarehouse);
			super.setWithWarehouse(withWarehouse);
			return this;
		}
		
		/**
		 * 设置 withPosition
		 * @param withPosition withPosition
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithPosition(String withPosition) {
			super.change(WITH_POSITION,super.getWithPosition(),withPosition);
			super.setWithPosition(withPosition);
			return this;
		}
		
		/**
		 * 设置 withName
		 * @param withName withName
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithName(String withName) {
			super.change(WITH_NAME,super.getWithName(),withName);
			super.setWithName(withName);
			return this;
		}
		
		/**
		 * 设置 withCode
		 * @param withCode withCode
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithCode(String withCode) {
			super.change(WITH_CODE,super.getWithCode(),withCode);
			super.setWithCode(withCode);
			return this;
		}
		
		/**
		 * 设置 withModel
		 * @param withModel withModel
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithModel(String withModel) {
			super.change(WITH_MODEL,super.getWithModel(),withModel);
			super.setWithModel(withModel);
			return this;
		}
		
		/**
		 * 设置 withBrand
		 * @param withBrand withBrand
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithBrand(String withBrand) {
			super.change(WITH_BRAND,super.getWithBrand(),withBrand);
			super.setWithBrand(withBrand);
			return this;
		}
		
		/**
		 * 设置 withManufacturer
		 * @param withManufacturer withManufacturer
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithManufacturer(String withManufacturer) {
			super.change(WITH_MANUFACTURER,super.getWithManufacturer(),withManufacturer);
			super.setWithManufacturer(withManufacturer);
			return this;
		}
		
		/**
		 * 设置 withNumber
		 * @param withNumber withNumber
		 * @return 当前对象
		*/
		public StockInventoryAsset setWithNumber(String withNumber) {
			super.change(WITH_NUMBER,super.getWithNumber(),withNumber);
			super.setWithNumber(withNumber);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public StockInventoryAssetVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public StockInventoryAssetVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setInventoryStatus(this.getInventoryStatus());
			inst.setOperId(this.getOperId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setInventoryNotes(this.getInventoryNotes());
			inst.setCreateBy(this.getCreateBy());
			inst.setAssetNumber(this.getAssetNumber());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssetId(this.getAssetId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTaskId(this.getTaskId());
			inst.setOperTime(this.getOperTime());
			if(all) {
				inst.setWithWarehouse(this.getWithWarehouse());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setWithModel(this.getWithModel());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setWithManufacturer(this.getWithManufacturer());
				inst.setPageSize(this.getPageSize());
				inst.setWithGoodsStockType(this.getWithGoodsStockType());
				inst.setWithBrand(this.getWithBrand());
				inst.setWithNumber(this.getWithNumber());
				inst.setWithPosition(this.getWithPosition());
				inst.setGoodsStockAsset(this.getGoodsStockAsset());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setWithCode(this.getWithCode());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setWithName(this.getWithName());
				inst.setSearchValue(this.getSearchValue());
				inst.setOperUser(this.getOperUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}