package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.PurchaseOrderVO;
import java.util.List;
import com.dt.platform.domain.eam.PurchaseOrder;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.Asset;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 18:07:27
 * @sign B5D9DF0441DF846DFA5B4828D9E8B868
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PurchaseOrderVOMeta extends PurchaseOrderMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编码", "业务编码", java.lang.String.class, null);
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,CODE, java.lang.String.class, "物品编码", "物品编码", java.lang.String.class, null);
	
	/**
	 * 物品名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 物品名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,NAME, java.lang.String.class, "物品名称", "物品名称", java.lang.String.class, null);
	
	/**
	 * 物品档案 , 类型: java.lang.String
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 物品档案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> GOODS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,GOODS_ID, java.lang.String.class, "物品档案", "物品档案", java.lang.String.class, null);
	
	/**
	 * 物品类型 , 类型: java.lang.String
	*/
	public static final String GOODS_TYPE="goodsType";
	
	/**
	 * 物品类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> GOODS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,GOODS_TYPE, java.lang.String.class, "物品类型", "物品类型", java.lang.String.class, null);
	
	/**
	 * 存放类型 , 类型: java.lang.String
	*/
	public static final String STORAGE_TYPE="storageType";
	
	/**
	 * 存放类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> STORAGE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,STORAGE_TYPE, java.lang.String.class, "存放类型", "存放类型", java.lang.String.class, null);
	
	/**
	 * 采购数量 , 类型: java.lang.Integer
	*/
	public static final String PURCHASE_NUMBER="purchaseNumber";
	
	/**
	 * 采购数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.Integer> PURCHASE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,PURCHASE_NUMBER, java.lang.Integer.class, "采购数量", "采购数量", java.lang.Integer.class, null);
	
	/**
	 * 采购单价 , 类型: java.math.BigDecimal
	*/
	public static final String UNIT_PRICE="unitPrice";
	
	/**
	 * 采购单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.math.BigDecimal> UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,UNIT_PRICE, java.math.BigDecimal.class, "采购单价", "采购单价", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 采购单 , 类型: java.lang.String
	*/
	public static final String APPLY_ID="applyId";
	
	/**
	 * 采购单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> APPLY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,APPLY_ID, java.lang.String.class, "采购单", "采购单", java.lang.String.class, null);
	
	/**
	 * 验收单 , 类型: java.lang.String
	*/
	public static final String CHECK_ID="checkId";
	
	/**
	 * 验收单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> CHECK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,CHECK_ID, java.lang.String.class, "验收单", "验收单", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 购买申请 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PURCHASE_APPLY="purchaseApply";
	
	/**
	 * 购买申请 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,org.github.foxnic.web.domain.hrm.Employee> PURCHASE_APPLY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,PURCHASE_APPLY, org.github.foxnic.web.domain.hrm.Employee.class, "购买申请", "购买申请", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 验收单 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PURCHASE_CHECK="purchaseCheck";
	
	/**
	 * 验收单 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,org.github.foxnic.web.domain.hrm.Employee> PURCHASE_CHECK_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,PURCHASE_CHECK, org.github.foxnic.web.domain.hrm.Employee.class, "验收单", "验收单", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * goods , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOODS="goods";
	
	/**
	 * goods , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,com.dt.platform.domain.eam.GoodsStock> GOODS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,GOODS, com.dt.platform.domain.eam.GoodsStock.class, "goods", "goods", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseOrderVO,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseOrderVO.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , BUSINESS_CODE , CODE , NAME , GOODS_ID , GOODS_TYPE , STORAGE_TYPE , PURCHASE_NUMBER , UNIT_PRICE , NOTES , APPLY_ID , CHECK_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , PURCHASE_APPLY , PURCHASE_CHECK , ORIGINATOR , GOODS , ASSET_LIST , ASSET_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.PurchaseOrderVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public PurchaseOrderVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public PurchaseOrderVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public PurchaseOrderVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public PurchaseOrderVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public PurchaseOrderVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public PurchaseOrderVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public PurchaseOrderVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public PurchaseOrderVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public PurchaseOrderVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public PurchaseOrderVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public PurchaseOrderVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public PurchaseOrderVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PurchaseOrder setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编码
		 * @param businessCode 业务编码
		 * @return 当前对象
		*/
		public PurchaseOrder setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 物品编码
		 * @param code 物品编码
		 * @return 当前对象
		*/
		public PurchaseOrder setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 物品名称
		 * @param name 物品名称
		 * @return 当前对象
		*/
		public PurchaseOrder setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 物品档案
		 * @param goodsId 物品档案
		 * @return 当前对象
		*/
		public PurchaseOrder setGoodsId(String goodsId) {
			super.change(GOODS_ID,super.getGoodsId(),goodsId);
			super.setGoodsId(goodsId);
			return this;
		}
		
		/**
		 * 设置 物品类型
		 * @param goodsType 物品类型
		 * @return 当前对象
		*/
		public PurchaseOrder setGoodsType(String goodsType) {
			super.change(GOODS_TYPE,super.getGoodsType(),goodsType);
			super.setGoodsType(goodsType);
			return this;
		}
		
		/**
		 * 设置 存放类型
		 * @param storageType 存放类型
		 * @return 当前对象
		*/
		public PurchaseOrder setStorageType(String storageType) {
			super.change(STORAGE_TYPE,super.getStorageType(),storageType);
			super.setStorageType(storageType);
			return this;
		}
		
		/**
		 * 设置 采购数量
		 * @param purchaseNumber 采购数量
		 * @return 当前对象
		*/
		public PurchaseOrder setPurchaseNumber(Integer purchaseNumber) {
			super.change(PURCHASE_NUMBER,super.getPurchaseNumber(),purchaseNumber);
			super.setPurchaseNumber(purchaseNumber);
			return this;
		}
		
		/**
		 * 设置 采购单价
		 * @param unitPrice 采购单价
		 * @return 当前对象
		*/
		public PurchaseOrder setUnitPrice(BigDecimal unitPrice) {
			super.change(UNIT_PRICE,super.getUnitPrice(),unitPrice);
			super.setUnitPrice(unitPrice);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PurchaseOrder setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 采购单
		 * @param applyId 采购单
		 * @return 当前对象
		*/
		public PurchaseOrder setApplyId(String applyId) {
			super.change(APPLY_ID,super.getApplyId(),applyId);
			super.setApplyId(applyId);
			return this;
		}
		
		/**
		 * 设置 验收单
		 * @param checkId 验收单
		 * @return 当前对象
		*/
		public PurchaseOrder setCheckId(String checkId) {
			super.change(CHECK_ID,super.getCheckId(),checkId);
			super.setCheckId(checkId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public PurchaseOrder setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PurchaseOrder setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PurchaseOrder setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PurchaseOrder setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PurchaseOrder setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PurchaseOrder setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PurchaseOrder setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PurchaseOrder setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PurchaseOrder setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PurchaseOrder setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public PurchaseOrder setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 购买申请
		 * @param purchaseApply 购买申请
		 * @return 当前对象
		*/
		public PurchaseOrder setPurchaseApply(Employee purchaseApply) {
			super.change(PURCHASE_APPLY,super.getPurchaseApply(),purchaseApply);
			super.setPurchaseApply(purchaseApply);
			return this;
		}
		
		/**
		 * 设置 验收单
		 * @param purchaseCheck 验收单
		 * @return 当前对象
		*/
		public PurchaseOrder setPurchaseCheck(Employee purchaseCheck) {
			super.change(PURCHASE_CHECK,super.getPurchaseCheck(),purchaseCheck);
			super.setPurchaseCheck(purchaseCheck);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public PurchaseOrder setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 goods
		 * @param goods goods
		 * @return 当前对象
		*/
		public PurchaseOrder setGoods(GoodsStock goods) {
			super.change(GOODS,super.getGoods(),goods);
			super.setGoods(goods);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public PurchaseOrder setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public PurchaseOrder setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PurchaseOrderVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PurchaseOrderVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUnitPrice(this.getUnitPrice());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setGoodsId(this.getGoodsId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setGoodsType(this.getGoodsType());
			inst.setApplyId(this.getApplyId());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setStorageType(this.getStorageType());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setCheckId(this.getCheckId());
			inst.setPurchaseNumber(this.getPurchaseNumber());
			if(all) {
				inst.setPurchaseCheck(this.getPurchaseCheck());
				inst.setPurchaseApply(this.getPurchaseApply());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setGoods(this.getGoods());
				inst.setAssetIds(this.getAssetIds());
				inst.setOriginator(this.getOriginator());
				inst.setAssetList(this.getAssetList());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}