package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetStockGoodsOutVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetStockGoodsOut;
import java.util.Date;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 11:16:21
 * @sign 0C0A781202DE6AE5613049D067FC053C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetStockGoodsOutVOMeta extends AssetStockGoodsOutMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 库存所属 , 类型: java.lang.String
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * 库存所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> OWNER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,OWNER_TYPE, java.lang.String.class, "库存所属", "库存所属", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 出库所属 , 类型: java.lang.String
	*/
	public static final String STOCK_TYPE="stockType";
	
	/**
	 * 出库所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> STOCK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,STOCK_TYPE, java.lang.String.class, "出库所属", "出库所属", java.lang.String.class, null);
	
	/**
	 * 领用公司 , 类型: java.lang.String
	*/
	public static final String USE_OWN_COMPANY_ID="useOwnCompanyId";
	
	/**
	 * 领用公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> USE_OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,USE_OWN_COMPANY_ID, java.lang.String.class, "领用公司", "领用公司", java.lang.String.class, null);
	
	/**
	 * 领用部门 , 类型: java.lang.String
	*/
	public static final String USE_ORGANIZATION_ID="useOrganizationId";
	
	/**
	 * 领用部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> USE_ORGANIZATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,USE_ORGANIZATION_ID, java.lang.String.class, "领用部门", "领用部门", java.lang.String.class, null);
	
	/**
	 * 领用人员 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 领用人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,USE_USER_ID, java.lang.String.class, "领用人员", "领用人员", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_ID="warehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> WAREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,WAREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 出库位置 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 出库位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,POSITION_DETAIL, java.lang.String.class, "出库位置", "出库位置", java.lang.String.class, null);
	
	/**
	 * 出库日期 , 类型: java.util.Date
	*/
	public static final String COLLECTION_DATE="collectionDate";
	
	/**
	 * 出库日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.util.Date> COLLECTION_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,COLLECTION_DATE, java.util.Date.class, "出库日期", "出库日期", java.util.Date.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 出库说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 出库说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CONTENT, java.lang.String.class, "出库说明", "出库说明", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 清单台账 , 类型: java.lang.String
	*/
	public static final String TO_BOOK="toBook";
	
	/**
	 * 清单台账 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> TO_BOOK_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,TO_BOOK, java.lang.String.class, "清单台账", "清单台账", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> CHS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> CHS_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> CHS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CHS_VERSION, java.lang.String.class, "变更版本号", "变更版本号", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHANGE_INSTANCE_ID="changeInstanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> CHANGE_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,CHANGE_INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_ID="latestApproverId";
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> LATEST_APPROVER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,LATEST_APPROVER_ID, java.lang.String.class, "最后审批人账户ID", "最后审批人账户ID", java.lang.String.class, null);
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_NAME="latestApproverName";
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> LATEST_APPROVER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,LATEST_APPROVER_NAME, java.lang.String.class, "最后审批人姓名", "最后审批人姓名", java.lang.String.class, null);
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_IDS="nextApproverIds";
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> NEXT_APPROVER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,NEXT_APPROVER_IDS, java.lang.String.class, "下一节点审批人", "下一节点审批人", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_NAMES="nextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> NEXT_APPROVER_NAMES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_OPINION="approvalOpinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> APPROVAL_OPINION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,APPROVAL_OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 物品 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOODS_LIST="goodsList";
	
	/**
	 * 物品 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,com.dt.platform.domain.eam.GoodsStock> GOODS_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,GOODS_LIST, java.util.List.class, "物品", "物品", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 物品 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String GOODS_IDS="goodsIds";
	
	/**
	 * 物品 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,java.lang.String> GOODS_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,GOODS_IDS, java.util.List.class, "物品", "物品", java.lang.String.class, null);
	
	/**
	 * 出库类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String STOCK_TYPE_DICT="stockTypeDict";
	
	/**
	 * 出库类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,org.github.foxnic.web.domain.system.DictItem> STOCK_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,STOCK_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "出库类型", "出库类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_OWN_COMPANY="useOwnCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,org.github.foxnic.web.domain.hrm.Organization> USE_OWN_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,USE_OWN_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,WAREHOUSE, com.dt.platform.domain.eam.Warehouse.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsOutVO,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsOutVO.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "领用人", "领用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , BUSINESS_CODE , PROC_ID , STATUS , OWNER_TYPE , NAME , STOCK_TYPE , USE_OWN_COMPANY_ID , USE_ORGANIZATION_ID , USE_USER_ID , WAREHOUSE_ID , POSITION_DETAIL , COLLECTION_DATE , BUSINESS_DATE , CONTENT , ORIGINATOR_ID , TO_BOOK , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , GOODS_LIST , GOODS_IDS , STOCK_TYPE_DICT , USE_OWN_COMPANY , USE_ORGANIZATION , WAREHOUSE , ORIGINATOR , USE_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetStockGoodsOutVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetStockGoodsOutVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 库存所属
		 * @param ownerType 库存所属
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 出库所属
		 * @param stockType 出库所属
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setStockType(String stockType) {
			super.change(STOCK_TYPE,super.getStockType(),stockType);
			super.setStockType(stockType);
			return this;
		}
		
		/**
		 * 设置 领用公司
		 * @param useOwnCompanyId 领用公司
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUseOwnCompanyId(String useOwnCompanyId) {
			super.change(USE_OWN_COMPANY_ID,super.getUseOwnCompanyId(),useOwnCompanyId);
			super.setUseOwnCompanyId(useOwnCompanyId);
			return this;
		}
		
		/**
		 * 设置 领用部门
		 * @param useOrganizationId 领用部门
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUseOrganizationId(String useOrganizationId) {
			super.change(USE_ORGANIZATION_ID,super.getUseOrganizationId(),useOrganizationId);
			super.setUseOrganizationId(useOrganizationId);
			return this;
		}
		
		/**
		 * 设置 领用人员
		 * @param useUserId 领用人员
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseId 仓库
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setWarehouseId(String warehouseId) {
			super.change(WAREHOUSE_ID,super.getWarehouseId(),warehouseId);
			super.setWarehouseId(warehouseId);
			return this;
		}
		
		/**
		 * 设置 出库位置
		 * @param positionDetail 出库位置
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 出库日期
		 * @param collectionDate 出库日期
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setCollectionDate(Date collectionDate) {
			super.change(COLLECTION_DATE,super.getCollectionDate(),collectionDate);
			super.setCollectionDate(collectionDate);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 出库说明
		 * @param content 出库说明
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 清单台账
		 * @param toBook 清单台账
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setToBook(String toBook) {
			super.change(TO_BOOK,super.getToBook(),toBook);
			super.setToBook(toBook);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setChsVersion(String chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param changeInstanceId 变更ID
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setChangeInstanceId(String changeInstanceId) {
			super.change(CHANGE_INSTANCE_ID,super.getChangeInstanceId(),changeInstanceId);
			super.setChangeInstanceId(changeInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param summary 流程概要
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 最后审批人账户ID
		 * @param latestApproverId 最后审批人账户ID
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setLatestApproverId(String latestApproverId) {
			super.change(LATEST_APPROVER_ID,super.getLatestApproverId(),latestApproverId);
			super.setLatestApproverId(latestApproverId);
			return this;
		}
		
		/**
		 * 设置 最后审批人姓名
		 * @param latestApproverName 最后审批人姓名
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setLatestApproverName(String latestApproverName) {
			super.change(LATEST_APPROVER_NAME,super.getLatestApproverName(),latestApproverName);
			super.setLatestApproverName(latestApproverName);
			return this;
		}
		
		/**
		 * 设置 下一节点审批人
		 * @param nextApproverIds 下一节点审批人
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setNextApproverIds(String nextApproverIds) {
			super.change(NEXT_APPROVER_IDS,super.getNextApproverIds(),nextApproverIds);
			super.setNextApproverIds(nextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setNextApproverNames(String nextApproverNames) {
			super.change(NEXT_APPROVER_NAMES,super.getNextApproverNames(),nextApproverNames);
			super.setNextApproverNames(nextApproverNames);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalOpinion 审批意见
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setApprovalOpinion(String approvalOpinion) {
			super.change(APPROVAL_OPINION,super.getApprovalOpinion(),approvalOpinion);
			super.setApprovalOpinion(approvalOpinion);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodsList 物品
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setGoodsList(List<GoodsStock> goodsList) {
			super.change(GOODS_LIST,super.getGoodsList(),goodsList);
			super.setGoodsList(goodsList);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodsIds 物品
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setGoodsIds(List<String> goodsIds) {
			super.change(GOODS_IDS,super.getGoodsIds(),goodsIds);
			super.setGoodsIds(goodsIds);
			return this;
		}
		
		/**
		 * 设置 出库类型
		 * @param stockTypeDict 出库类型
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setStockTypeDict(DictItem stockTypeDict) {
			super.change(STOCK_TYPE_DICT,super.getStockTypeDict(),stockTypeDict);
			super.setStockTypeDict(stockTypeDict);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param useOwnCompany 所属公司
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUseOwnCompany(Organization useOwnCompany) {
			super.change(USE_OWN_COMPANY,super.getUseOwnCompany(),useOwnCompany);
			super.setUseOwnCompany(useOwnCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouse 仓库
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setWarehouse(Warehouse warehouse) {
			super.change(WAREHOUSE,super.getWarehouse(),warehouse);
			super.setWarehouse(warehouse);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 领用人
		 * @param useUser 领用人
		 * @return 当前对象
		*/
		public AssetStockGoodsOut setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetStockGoodsOutVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetStockGoodsOutVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOwnerType(this.getOwnerType());
			inst.setChsVersion(this.getChsVersion());
			inst.setProcId(this.getProcId());
			inst.setLatestApproverName(this.getLatestApproverName());
			inst.setChangeInstanceId(this.getChangeInstanceId());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setNextApproverIds(this.getNextApproverIds());
			inst.setApprovalOpinion(this.getApprovalOpinion());
			inst.setChsStatus(this.getChsStatus());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setAttachId(this.getAttachId());
			inst.setSummary(this.getSummary());
			inst.setNextApproverNames(this.getNextApproverNames());
			inst.setLatestApproverId(this.getLatestApproverId());
			inst.setStockType(this.getStockType());
			inst.setUseOrganizationId(this.getUseOrganizationId());
			inst.setToBook(this.getToBook());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setCollectionDate(this.getCollectionDate());
			inst.setVersion(this.getVersion());
			inst.setPositionDetail(this.getPositionDetail());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setWarehouseId(this.getWarehouseId());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setChsType(this.getChsType());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUseUserId(this.getUseUserId());
			inst.setStatus(this.getStatus());
			inst.setUseOwnCompanyId(this.getUseOwnCompanyId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setGoodsList(this.getGoodsList());
				inst.setPageSize(this.getPageSize());
				inst.setOriginator(this.getOriginator());
				inst.setWarehouse(this.getWarehouse());
				inst.setStockTypeDict(this.getStockTypeDict());
				inst.setGoodsIds(this.getGoodsIds());
				inst.setUseOrganization(this.getUseOrganization());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setUseOwnCompany(this.getUseOwnCompany());
				inst.setUseUser(this.getUseUser());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}