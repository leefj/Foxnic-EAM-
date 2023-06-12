package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.VehicleMaintenanceVO;
import java.util.List;
import com.dt.platform.domain.oa.VehicleMaintenance;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.oa.VehicleInfo;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:04:49
 * @sign 53A40A5E3DC21C11F48DC3C208F2BFD6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VehicleMaintenanceVOMeta extends VehicleMaintenanceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final String REPAIR_STATUS="repairStatus";
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> REPAIR_STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,REPAIR_STATUS, java.lang.String.class, "维修状态", "维修状态", java.lang.String.class, null);
	
	/**
	 * 报修类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 报修类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,TYPE, java.lang.String.class, "报修类型", "报修类型", java.lang.String.class, null);
	
	/**
	 * 计划完成日期 , 类型: java.util.Date
	*/
	public static final String PLAN_FINISH_DATE="planFinishDate";
	
	/**
	 * 计划完成日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.util.Date> PLAN_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,PLAN_FINISH_DATE, java.util.Date.class, "计划完成日期", "计划完成日期", java.util.Date.class, null);
	
	/**
	 * 实际完成日期 , 类型: java.util.Date
	*/
	public static final String ACTUAL_FINISH_DATE="actualFinishDate";
	
	/**
	 * 实际完成日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.util.Date> ACTUAL_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,ACTUAL_FINISH_DATE, java.util.Date.class, "实际完成日期", "实际完成日期", java.util.Date.class, null);
	
	/**
	 * 费用 , 类型: java.math.BigDecimal
	*/
	public static final String COST="cost";
	
	/**
	 * 费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.math.BigDecimal> COST_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,COST, java.math.BigDecimal.class, "费用", "费用", java.math.BigDecimal.class, null);
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,CONTENT, java.lang.String.class, "报修内容", "报修内容", java.lang.String.class, null);
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final String REPORT_USER_ID="reportUserId";
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> REPORT_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,REPORT_USER_ID, java.lang.String.class, "报修人", "报修人", java.lang.String.class, null);
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final String REPORT_USER_NAME="reportUserName";
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> REPORT_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,REPORT_USER_NAME, java.lang.String.class, "报修人", "报修人", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 车辆 , 类型: java.lang.String
	*/
	public static final String VEHICLE_ID="vehicleId";
	
	/**
	 * 车辆 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> VEHICLE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,VEHICLE_ID, java.lang.String.class, "车辆", "车辆", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 车辆 , 类型: com.dt.platform.domain.oa.VehicleInfo
	*/
	public static final String VEHICLE_INFO="vehicleInfo";
	
	/**
	 * 车辆 , 类型: com.dt.platform.domain.oa.VehicleInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,com.dt.platform.domain.oa.VehicleInfo> VEHICLE_INFO_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,VEHICLE_INFO, com.dt.platform.domain.oa.VehicleInfo.class, "车辆", "车辆", com.dt.platform.domain.oa.VehicleInfo.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 报修类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTENANCE_DICT="maintenanceDict";
	
	/**
	 * 报修类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleMaintenanceVO,org.github.foxnic.web.domain.system.DictItem> MAINTENANCE_DICT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleMaintenanceVO.class ,MAINTENANCE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "报修类型", "报修类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , BUSINESS_CODE , STATUS , PROC_ID , NAME , REPAIR_STATUS , TYPE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , COST , CONTENT , REPORT_USER_ID , REPORT_USER_NAME , PICTURE_ID , VEHICLE_ID , ORIGINATOR_ID , BUSINESS_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , VEHICLE_INFO , ORIGINATOR , MAINTENANCE_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.VehicleMaintenanceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public VehicleMaintenanceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public VehicleMaintenance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public VehicleMaintenance setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public VehicleMaintenance setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public VehicleMaintenance setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public VehicleMaintenance setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 维修状态
		 * @param repairStatus 维修状态
		 * @return 当前对象
		*/
		public VehicleMaintenance setRepairStatus(String repairStatus) {
			super.change(REPAIR_STATUS,super.getRepairStatus(),repairStatus);
			super.setRepairStatus(repairStatus);
			return this;
		}
		
		/**
		 * 设置 报修类型
		 * @param type 报修类型
		 * @return 当前对象
		*/
		public VehicleMaintenance setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 计划完成日期
		 * @param planFinishDate 计划完成日期
		 * @return 当前对象
		*/
		public VehicleMaintenance setPlanFinishDate(Date planFinishDate) {
			super.change(PLAN_FINISH_DATE,super.getPlanFinishDate(),planFinishDate);
			super.setPlanFinishDate(planFinishDate);
			return this;
		}
		
		/**
		 * 设置 实际完成日期
		 * @param actualFinishDate 实际完成日期
		 * @return 当前对象
		*/
		public VehicleMaintenance setActualFinishDate(Date actualFinishDate) {
			super.change(ACTUAL_FINISH_DATE,super.getActualFinishDate(),actualFinishDate);
			super.setActualFinishDate(actualFinishDate);
			return this;
		}
		
		/**
		 * 设置 费用
		 * @param cost 费用
		 * @return 当前对象
		*/
		public VehicleMaintenance setCost(BigDecimal cost) {
			super.change(COST,super.getCost(),cost);
			super.setCost(cost);
			return this;
		}
		
		/**
		 * 设置 报修内容
		 * @param content 报修内容
		 * @return 当前对象
		*/
		public VehicleMaintenance setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 报修人
		 * @param reportUserId 报修人
		 * @return 当前对象
		*/
		public VehicleMaintenance setReportUserId(String reportUserId) {
			super.change(REPORT_USER_ID,super.getReportUserId(),reportUserId);
			super.setReportUserId(reportUserId);
			return this;
		}
		
		/**
		 * 设置 报修人
		 * @param reportUserName 报修人
		 * @return 当前对象
		*/
		public VehicleMaintenance setReportUserName(String reportUserName) {
			super.change(REPORT_USER_NAME,super.getReportUserName(),reportUserName);
			super.setReportUserName(reportUserName);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public VehicleMaintenance setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 车辆
		 * @param vehicleId 车辆
		 * @return 当前对象
		*/
		public VehicleMaintenance setVehicleId(String vehicleId) {
			super.change(VEHICLE_ID,super.getVehicleId(),vehicleId);
			super.setVehicleId(vehicleId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public VehicleMaintenance setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public VehicleMaintenance setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VehicleMaintenance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VehicleMaintenance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VehicleMaintenance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VehicleMaintenance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VehicleMaintenance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VehicleMaintenance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VehicleMaintenance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public VehicleMaintenance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public VehicleMaintenance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public VehicleMaintenance setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 车辆
		 * @param vehicleInfo 车辆
		 * @return 当前对象
		*/
		public VehicleMaintenance setVehicleInfo(VehicleInfo vehicleInfo) {
			super.change(VEHICLE_INFO,super.getVehicleInfo(),vehicleInfo);
			super.setVehicleInfo(vehicleInfo);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public VehicleMaintenance setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 报修类型
		 * @param maintenanceDict 报修类型
		 * @return 当前对象
		*/
		public VehicleMaintenance setMaintenanceDict(DictItem maintenanceDict) {
			super.change(MAINTENANCE_DICT,super.getMaintenanceDict(),maintenanceDict);
			super.setMaintenanceDict(maintenanceDict);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public VehicleMaintenanceVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public VehicleMaintenanceVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcId(this.getProcId());
			inst.setReportUserName(this.getReportUserName());
			inst.setType(this.getType());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setPictureId(this.getPictureId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setReportUserId(this.getReportUserId());
			inst.setId(this.getId());
			inst.setVehicleId(this.getVehicleId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setCost(this.getCost());
			inst.setRepairStatus(this.getRepairStatus());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setActualFinishDate(this.getActualFinishDate());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPlanFinishDate(this.getPlanFinishDate());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setMaintenanceDict(this.getMaintenanceDict());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setVehicleInfo(this.getVehicleInfo());
				inst.setPageSize(this.getPageSize());
				inst.setOriginator(this.getOriginator());
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