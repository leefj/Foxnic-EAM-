package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.StockInventoryTaskVO;
import java.util.List;
import com.dt.platform.domain.eam.StockInventoryTask;
import java.util.Date;
import com.dt.platform.domain.eam.StockInventoryAsset;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.pcm.Catalog;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-06 16:10:12
 * @sign CBA1C5C32949B6A8C943CFFEC83BA13C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class StockInventoryTaskVOMeta extends StockInventoryTaskMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编码", "业务编码", java.lang.String.class, null);
	
	/**
	 * 业务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 业务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,STATUS, java.lang.String.class, "业务状态", "业务状态", java.lang.String.class, null);
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,NAME, java.lang.String.class, "盘点名称", "盘点名称", java.lang.String.class, null);
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final String INVENTORY_STATUS="inventoryStatus";
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> INVENTORY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_STATUS, java.lang.String.class, "盘点状态", "盘点状态", java.lang.String.class, null);
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final String DATA_STATUS="dataStatus";
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> DATA_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DATA_STATUS, java.lang.String.class, "数据状态", "数据状态", java.lang.String.class, null);
	
	/**
	 * 盘点开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 盘点开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,START_TIME, java.util.Date.class, "盘点开始时间", "盘点开始时间", java.util.Date.class, null);
	
	/**
	 * 盘点结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 盘点结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.util.Date> FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,FINISH_TIME, java.util.Date.class, "盘点结束时间", "盘点结束时间", java.util.Date.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String DIRECTOR_ID="directorId";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> DIRECTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DIRECTOR_ID, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,PLAN_ID, java.lang.String.class, "计划编号", "计划编号", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,OWNER_CODE, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 盘点资产数据 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.StockInventoryAsset
	*/
	public static final String INVENTORY_ASSET_INFO_LIST="inventoryAssetInfoList";
	
	/**
	 * 盘点资产数据 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.StockInventoryAsset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,com.dt.platform.domain.eam.StockInventoryAsset> INVENTORY_ASSET_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_ASSET_INFO_LIST, java.util.List.class, "盘点资产数据", "盘点资产数据", com.dt.platform.domain.eam.StockInventoryAsset.class, null);
	
	/**
	 * 待盘点 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_NOT_COUNTED="inventoryAssetCountByNotCounted";
	
	/**
	 * 待盘点 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_NOT_COUNTED_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_ASSET_COUNT_BY_NOT_COUNTED, java.lang.Integer.class, "待盘点", "待盘点", java.lang.Integer.class, null);
	
	/**
	 * 已盘点 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_COUNTED="inventoryAssetCountByCounted";
	
	/**
	 * 已盘点 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_COUNTED_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_ASSET_COUNT_BY_COUNTED, java.lang.Integer.class, "已盘点", "已盘点", java.lang.Integer.class, null);
	
	/**
	 * 盘亏 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_LOSS="inventoryAssetCountByLoss";
	
	/**
	 * 盘亏 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_LOSS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_ASSET_COUNT_BY_LOSS, java.lang.Integer.class, "盘亏", "盘亏", java.lang.Integer.class, null);
	
	/**
	 * 盘盈 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_SURPLUS="inventoryAssetCountBySurplus";
	
	/**
	 * 盘盈 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_SURPLUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_ASSET_COUNT_BY_SURPLUS, java.lang.Integer.class, "盘盈", "盘盈", java.lang.Integer.class, null);
	
	/**
	 * 异常 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_EXCEPTION="inventoryAssetCountByException";
	
	/**
	 * 异常 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_EXCEPTION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_ASSET_COUNT_BY_EXCEPTION, java.lang.Integer.class, "异常", "异常", java.lang.Integer.class, null);
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String INVENTORY_USER_LIST="inventoryUserList";
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,org.github.foxnic.web.domain.hrm.Employee> INVENTORY_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_USER_LIST, java.util.List.class, "盘点人员", "盘点人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_USER_IDS="inventoryUserIds";
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> INVENTORY_USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,INVENTORY_USER_IDS, java.util.List.class, "盘点人员列表", "盘点人员列表", java.lang.String.class, null);
	
	/**
	 * director , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String DIRECTOR="director";
	
	/**
	 * director , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,org.github.foxnic.web.domain.hrm.Employee> DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,DIRECTOR, org.github.foxnic.web.domain.hrm.Employee.class, "director", "director", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 仓库 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE_LIST="warehouseList";
	
	/**
	 * 仓库 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,WAREHOUSE_LIST, java.util.List.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 仓库Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_IDS="warehouseIds";
	
	/**
	 * 仓库Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> WAREHOUSE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,WAREHOUSE_IDS, java.util.List.class, "仓库Ids", "仓库Ids", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY_LIST="categoryList";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,CATEGORY_LIST, java.util.List.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CATEGORY_IDS="categoryIds";
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> CATEGORY_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,CATEGORY_IDS, java.util.List.class, "资产分类Ids", "资产分类Ids", java.lang.String.class, null);
	
	/**
	 * searchQuerySource , 类型: java.lang.String
	*/
	public static final String SEARCH_QUERY_SOURCE="searchQuerySource";
	
	/**
	 * searchQuerySource , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryTaskVO,java.lang.String> SEARCH_QUERY_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryTaskVO.class ,SEARCH_QUERY_SOURCE, java.lang.String.class, "searchQuerySource", "searchQuerySource", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , TYPE , BUSINESS_CODE , STATUS , NAME , INVENTORY_STATUS , DATA_STATUS , START_TIME , FINISH_TIME , DIRECTOR_ID , ORIGINATOR_ID , BUSINESS_DATE , NOTES , PLAN_ID , OWNER_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , INVENTORY_ASSET_INFO_LIST , INVENTORY_ASSET_COUNT_BY_NOT_COUNTED , INVENTORY_ASSET_COUNT_BY_COUNTED , INVENTORY_ASSET_COUNT_BY_LOSS , INVENTORY_ASSET_COUNT_BY_SURPLUS , INVENTORY_ASSET_COUNT_BY_EXCEPTION , INVENTORY_USER_LIST , INVENTORY_USER_IDS , DIRECTOR , ORIGINATOR , WAREHOUSE_LIST , WAREHOUSE_IDS , CATEGORY_LIST , CATEGORY_IDS , SEARCH_QUERY_SOURCE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.StockInventoryTaskVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public StockInventoryTaskVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public StockInventoryTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public StockInventoryTask setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 业务编码
		 * @param businessCode 业务编码
		 * @return 当前对象
		*/
		public StockInventoryTask setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 业务状态
		 * @param status 业务状态
		 * @return 当前对象
		*/
		public StockInventoryTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 盘点名称
		 * @param name 盘点名称
		 * @return 当前对象
		*/
		public StockInventoryTask setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 盘点状态
		 * @param inventoryStatus 盘点状态
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryStatus(String inventoryStatus) {
			super.change(INVENTORY_STATUS,super.getInventoryStatus(),inventoryStatus);
			super.setInventoryStatus(inventoryStatus);
			return this;
		}
		
		/**
		 * 设置 数据状态
		 * @param dataStatus 数据状态
		 * @return 当前对象
		*/
		public StockInventoryTask setDataStatus(String dataStatus) {
			super.change(DATA_STATUS,super.getDataStatus(),dataStatus);
			super.setDataStatus(dataStatus);
			return this;
		}
		
		/**
		 * 设置 盘点开始时间
		 * @param startTime 盘点开始时间
		 * @return 当前对象
		*/
		public StockInventoryTask setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 盘点结束时间
		 * @param finishTime 盘点结束时间
		 * @return 当前对象
		*/
		public StockInventoryTask setFinishTime(Date finishTime) {
			super.change(FINISH_TIME,super.getFinishTime(),finishTime);
			super.setFinishTime(finishTime);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param directorId 负责人
		 * @return 当前对象
		*/
		public StockInventoryTask setDirectorId(String directorId) {
			super.change(DIRECTOR_ID,super.getDirectorId(),directorId);
			super.setDirectorId(directorId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public StockInventoryTask setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public StockInventoryTask setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public StockInventoryTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 计划编号
		 * @param planId 计划编号
		 * @return 当前对象
		*/
		public StockInventoryTask setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerCode 所属
		 * @return 当前对象
		*/
		public StockInventoryTask setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public StockInventoryTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public StockInventoryTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public StockInventoryTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public StockInventoryTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public StockInventoryTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public StockInventoryTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public StockInventoryTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public StockInventoryTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public StockInventoryTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 盘点资产数据
		 * @param inventoryAssetInfoList 盘点资产数据
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryAssetInfoList(List<StockInventoryAsset> inventoryAssetInfoList) {
			super.change(INVENTORY_ASSET_INFO_LIST,super.getInventoryAssetInfoList(),inventoryAssetInfoList);
			super.setInventoryAssetInfoList(inventoryAssetInfoList);
			return this;
		}
		
		/**
		 * 设置 待盘点
		 * @param inventoryAssetCountByNotCounted 待盘点
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryAssetCountByNotCounted(Integer inventoryAssetCountByNotCounted) {
			super.change(INVENTORY_ASSET_COUNT_BY_NOT_COUNTED,super.getInventoryAssetCountByNotCounted(),inventoryAssetCountByNotCounted);
			super.setInventoryAssetCountByNotCounted(inventoryAssetCountByNotCounted);
			return this;
		}
		
		/**
		 * 设置 已盘点
		 * @param inventoryAssetCountByCounted 已盘点
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryAssetCountByCounted(Integer inventoryAssetCountByCounted) {
			super.change(INVENTORY_ASSET_COUNT_BY_COUNTED,super.getInventoryAssetCountByCounted(),inventoryAssetCountByCounted);
			super.setInventoryAssetCountByCounted(inventoryAssetCountByCounted);
			return this;
		}
		
		/**
		 * 设置 盘亏
		 * @param inventoryAssetCountByLoss 盘亏
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryAssetCountByLoss(Integer inventoryAssetCountByLoss) {
			super.change(INVENTORY_ASSET_COUNT_BY_LOSS,super.getInventoryAssetCountByLoss(),inventoryAssetCountByLoss);
			super.setInventoryAssetCountByLoss(inventoryAssetCountByLoss);
			return this;
		}
		
		/**
		 * 设置 盘盈
		 * @param inventoryAssetCountBySurplus 盘盈
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryAssetCountBySurplus(Integer inventoryAssetCountBySurplus) {
			super.change(INVENTORY_ASSET_COUNT_BY_SURPLUS,super.getInventoryAssetCountBySurplus(),inventoryAssetCountBySurplus);
			super.setInventoryAssetCountBySurplus(inventoryAssetCountBySurplus);
			return this;
		}
		
		/**
		 * 设置 异常
		 * @param inventoryAssetCountByException 异常
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryAssetCountByException(Integer inventoryAssetCountByException) {
			super.change(INVENTORY_ASSET_COUNT_BY_EXCEPTION,super.getInventoryAssetCountByException(),inventoryAssetCountByException);
			super.setInventoryAssetCountByException(inventoryAssetCountByException);
			return this;
		}
		
		/**
		 * 设置 盘点人员
		 * @param inventoryUserList 盘点人员
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryUserList(List<Employee> inventoryUserList) {
			super.change(INVENTORY_USER_LIST,super.getInventoryUserList(),inventoryUserList);
			super.setInventoryUserList(inventoryUserList);
			return this;
		}
		
		/**
		 * 设置 盘点人员列表
		 * @param inventoryUserIds 盘点人员列表
		 * @return 当前对象
		*/
		public StockInventoryTask setInventoryUserIds(List<String> inventoryUserIds) {
			super.change(INVENTORY_USER_IDS,super.getInventoryUserIds(),inventoryUserIds);
			super.setInventoryUserIds(inventoryUserIds);
			return this;
		}
		
		/**
		 * 设置 director
		 * @param director director
		 * @return 当前对象
		*/
		public StockInventoryTask setDirector(Employee director) {
			super.change(DIRECTOR,super.getDirector(),director);
			super.setDirector(director);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public StockInventoryTask setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseList 仓库
		 * @return 当前对象
		*/
		public StockInventoryTask setWarehouseList(List<Warehouse> warehouseList) {
			super.change(WAREHOUSE_LIST,super.getWarehouseList(),warehouseList);
			super.setWarehouseList(warehouseList);
			return this;
		}
		
		/**
		 * 设置 仓库Ids
		 * @param warehouseIds 仓库Ids
		 * @return 当前对象
		*/
		public StockInventoryTask setWarehouseIds(List<String> warehouseIds) {
			super.change(WAREHOUSE_IDS,super.getWarehouseIds(),warehouseIds);
			super.setWarehouseIds(warehouseIds);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryList 资产分类
		 * @return 当前对象
		*/
		public StockInventoryTask setCategoryList(List<Catalog> categoryList) {
			super.change(CATEGORY_LIST,super.getCategoryList(),categoryList);
			super.setCategoryList(categoryList);
			return this;
		}
		
		/**
		 * 设置 资产分类Ids
		 * @param categoryIds 资产分类Ids
		 * @return 当前对象
		*/
		public StockInventoryTask setCategoryIds(List<String> categoryIds) {
			super.change(CATEGORY_IDS,super.getCategoryIds(),categoryIds);
			super.setCategoryIds(categoryIds);
			return this;
		}
		
		/**
		 * 设置 searchQuerySource
		 * @param searchQuerySource searchQuerySource
		 * @return 当前对象
		*/
		public StockInventoryTask setSearchQuerySource(String searchQuerySource) {
			super.change(SEARCH_QUERY_SOURCE,super.getSearchQuerySource(),searchQuerySource);
			super.setSearchQuerySource(searchQuerySource);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public StockInventoryTaskVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public StockInventoryTaskVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFinishTime(this.getFinishTime());
			inst.setNotes(this.getNotes());
			inst.setDirectorId(this.getDirectorId());
			inst.setOwnerCode(this.getOwnerCode());
			inst.setInventoryStatus(this.getInventoryStatus());
			inst.setDataStatus(this.getDataStatus());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStartTime(this.getStartTime());
			inst.setPlanId(this.getPlanId());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setInventoryUserIds(this.getInventoryUserIds());
				inst.setSearchField(this.getSearchField());
				inst.setInventoryAssetCountByLoss(this.getInventoryAssetCountByLoss());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setInventoryAssetCountByException(this.getInventoryAssetCountByException());
				inst.setPageSize(this.getPageSize());
				inst.setInventoryAssetCountByCounted(this.getInventoryAssetCountByCounted());
				inst.setOriginator(this.getOriginator());
				inst.setInventoryAssetInfoList(this.getInventoryAssetInfoList());
				inst.setInventoryAssetCountByNotCounted(this.getInventoryAssetCountByNotCounted());
				inst.setInventoryAssetCountBySurplus(this.getInventoryAssetCountBySurplus());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setCategoryList(this.getCategoryList());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setWarehouseIds(this.getWarehouseIds());
				inst.setWarehouseList(this.getWarehouseList());
				inst.setRequestAction(this.getRequestAction());
				inst.setDirector(this.getDirector());
				inst.setSearchQuerySource(this.getSearchQuerySource());
				inst.setCategoryIds(this.getCategoryIds());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setInventoryUserList(this.getInventoryUserList());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}