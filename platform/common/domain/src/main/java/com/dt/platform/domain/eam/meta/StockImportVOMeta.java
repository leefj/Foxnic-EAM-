package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.StockImportVO;
import java.util.List;
import com.dt.platform.domain.eam.StockImport;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.AssetStockGoodsOut;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Position;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-01 20:35:29
 * @sign E04154305FED710D37506752839F9191
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class StockImportVOMeta extends StockImportMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 库存单 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 库存单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,ORDER_ID, java.lang.String.class, "库存单", "库存单", java.lang.String.class, null);
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_CODE="orderCode";
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> ORDER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,ORDER_CODE, java.lang.String.class, "订单编号", "订单编号", java.lang.String.class, null);
	
	/**
	 * 订单名称 , 类型: java.lang.String
	*/
	public static final String ORDER_NAME="orderName";
	
	/**
	 * 订单名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> ORDER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,ORDER_NAME, java.lang.String.class, "订单名称", "订单名称", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,USE_ORG_ID, java.lang.String.class, "使用部门", "使用部门", java.lang.String.class, null);
	
	/**
	 * 管理人 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 管理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,MANAGER_ID, java.lang.String.class, "管理人", "管理人", java.lang.String.class, null);
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,USE_USER_ID, java.lang.String.class, "使用人", "使用人", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,POSITION_ID, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 采购日期 , 类型: java.lang.String
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 采购日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,PURCHASE_DATE, java.lang.String.class, "采购日期", "采购日期", java.lang.String.class, null);
	
	/**
	 * 资产备注 , 类型: java.lang.String
	*/
	public static final String ASSET_NOTES="assetNotes";
	
	/**
	 * 资产备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> ASSET_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,ASSET_NOTES, java.lang.String.class, "资产备注", "资产备注", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,OPER_USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 导入类型 , 类型: java.lang.String
	*/
	public static final String IMPORT_TO_TYPE="importToType";
	
	/**
	 * 导入类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> IMPORT_TO_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,IMPORT_TO_TYPE, java.lang.String.class, "导入类型", "导入类型", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "操作人员", "操作人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * stockGoodsOut , 类型: com.dt.platform.domain.eam.AssetStockGoodsOut
	*/
	public static final String STOCK_GOODS_OUT="stockGoodsOut";
	
	/**
	 * stockGoodsOut , 类型: com.dt.platform.domain.eam.AssetStockGoodsOut
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,com.dt.platform.domain.eam.AssetStockGoodsOut> STOCK_GOODS_OUT_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,STOCK_GOODS_OUT, com.dt.platform.domain.eam.AssetStockGoodsOut.class, "stockGoodsOut", "stockGoodsOut", com.dt.platform.domain.eam.AssetStockGoodsOut.class, null);
	
	/**
	 * assetList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * assetList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,ASSET_LIST, java.util.List.class, "assetList", "assetList", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 使用人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "使用人员", "使用人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 管理人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 管理人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "管理人员", "管理人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,POSITION, com.dt.platform.domain.eam.Position.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 填充数据 , 类型: java.lang.String
	*/
	public static final String FILL="fill";
	
	/**
	 * 填充数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockImportVO,java.lang.String> FILL_PROP = new BeanProperty(com.dt.platform.domain.eam.StockImportVO.class ,FILL, java.lang.String.class, "填充数据", "填充数据", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , STATUS , ORDER_ID , ORDER_CODE , ORDER_NAME , OWN_COMPANY_ID , USE_ORG_ID , MANAGER_ID , USE_USER_ID , POSITION_ID , PURCHASE_DATE , ASSET_NOTES , NOTES , OPER_USER_ID , IMPORT_TO_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , OPER_USER , STOCK_GOODS_OUT , ASSET_LIST , SELECTED_CODE , OWNER_COMPANY , USE_ORGANIZATION , USE_USER , MANAGER , POSITION , FILL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.StockImportVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public StockImportVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public StockImportVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public StockImportVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public StockImportVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public StockImportVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public StockImportVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public StockImportVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public StockImportVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public StockImportVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public StockImportVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public StockImportVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public StockImportVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public StockImport setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public StockImport setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public StockImport setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 库存单
		 * @param orderId 库存单
		 * @return 当前对象
		*/
		public StockImport setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 订单编号
		 * @param orderCode 订单编号
		 * @return 当前对象
		*/
		public StockImport setOrderCode(String orderCode) {
			super.change(ORDER_CODE,super.getOrderCode(),orderCode);
			super.setOrderCode(orderCode);
			return this;
		}
		
		/**
		 * 设置 订单名称
		 * @param orderName 订单名称
		 * @return 当前对象
		*/
		public StockImport setOrderName(String orderName) {
			super.change(ORDER_NAME,super.getOrderName(),orderName);
			super.setOrderName(orderName);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public StockImport setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 使用部门
		 * @param useOrgId 使用部门
		 * @return 当前对象
		*/
		public StockImport setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 管理人
		 * @param managerId 管理人
		 * @return 当前对象
		*/
		public StockImport setManagerId(String managerId) {
			super.change(MANAGER_ID,super.getManagerId(),managerId);
			super.setManagerId(managerId);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param useUserId 使用人
		 * @return 当前对象
		*/
		public StockImport setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param positionId 存放位置
		 * @return 当前对象
		*/
		public StockImport setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 采购日期
		 * @param purchaseDate 采购日期
		 * @return 当前对象
		*/
		public StockImport setPurchaseDate(String purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
			return this;
		}
		
		/**
		 * 设置 资产备注
		 * @param assetNotes 资产备注
		 * @return 当前对象
		*/
		public StockImport setAssetNotes(String assetNotes) {
			super.change(ASSET_NOTES,super.getAssetNotes(),assetNotes);
			super.setAssetNotes(assetNotes);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public StockImport setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUserId 操作人
		 * @return 当前对象
		*/
		public StockImport setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 导入类型
		 * @param importToType 导入类型
		 * @return 当前对象
		*/
		public StockImport setImportToType(String importToType) {
			super.change(IMPORT_TO_TYPE,super.getImportToType(),importToType);
			super.setImportToType(importToType);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public StockImport setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public StockImport setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public StockImport setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public StockImport setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public StockImport setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public StockImport setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public StockImport setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public StockImport setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public StockImport setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUser 操作人员
		 * @return 当前对象
		*/
		public StockImport setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}
		
		/**
		 * 设置 stockGoodsOut
		 * @param stockGoodsOut stockGoodsOut
		 * @return 当前对象
		*/
		public StockImport setStockGoodsOut(AssetStockGoodsOut stockGoodsOut) {
			super.change(STOCK_GOODS_OUT,super.getStockGoodsOut(),stockGoodsOut);
			super.setStockGoodsOut(stockGoodsOut);
			return this;
		}
		
		/**
		 * 设置 assetList
		 * @param assetList assetList
		 * @return 当前对象
		*/
		public StockImport setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public StockImport setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public StockImport setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public StockImport setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 使用人员
		 * @param useUser 使用人员
		 * @return 当前对象
		*/
		public StockImport setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}
		
		/**
		 * 设置 管理人员
		 * @param manager 管理人员
		 * @return 当前对象
		*/
		public StockImport setManager(Employee manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public StockImport setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 填充数据
		 * @param fill 填充数据
		 * @return 当前对象
		*/
		public StockImport setFill(String fill) {
			super.change(FILL,super.getFill(),fill);
			super.setFill(fill);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public StockImportVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public StockImportVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOperUserId(this.getOperUserId());
			inst.setPurchaseDate(this.getPurchaseDate());
			inst.setNotes(this.getNotes());
			inst.setOrderId(this.getOrderId());
			inst.setAssetNotes(this.getAssetNotes());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setOrderName(this.getOrderName());
			inst.setImportToType(this.getImportToType());
			inst.setUseOrgId(this.getUseOrgId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setManagerId(this.getManagerId());
			inst.setVersion(this.getVersion());
			inst.setOwnCompanyId(this.getOwnCompanyId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPositionId(this.getPositionId());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setOrderCode(this.getOrderCode());
			inst.setUseUserId(this.getUseUserId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setOwnerCompany(this.getOwnerCompany());
				inst.setStockGoodsOut(this.getStockGoodsOut());
				inst.setSearchField(this.getSearchField());
				inst.setManager(this.getManager());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setAssetList(this.getAssetList());
				inst.setFill(this.getFill());
				inst.setSelectedCode(this.getSelectedCode());
				inst.setUseOrganization(this.getUseOrganization());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setPosition(this.getPosition());
				inst.setUseUser(this.getUseUser());
				inst.setSearchValue(this.getSearchValue());
				inst.setOperUser(this.getOperUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}