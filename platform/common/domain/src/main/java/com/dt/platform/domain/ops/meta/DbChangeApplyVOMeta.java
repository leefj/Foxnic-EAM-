package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbChangeApplyVO;
import java.util.List;
import com.dt.platform.domain.ops.DbChangeApply;
import java.util.Date;
import com.dt.platform.domain.ops.DbInfoApply;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.DbApplyExecute;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 22:50:13
 * @sign 2C7DA3DDEA1402913D0BE1E6AD52BEC4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbChangeApplyVOMeta extends DbChangeApplyMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final String ITEM_CODE="itemCode";
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> ITEM_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,ITEM_CODE, java.lang.String.class, "关联工单", "关联工单", java.lang.String.class, null);
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final String ITEM_NAME="itemName";
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> ITEM_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,ITEM_NAME, java.lang.String.class, "关联工单", "关联工单", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_FULL_NAME="dbFullName";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DB_FULL_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_FULL_NAME, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_ID="dbId";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DB_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_ID, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 数据库IP , 类型: java.lang.String
	*/
	public static final String DB_IP="dbIp";
	
	/**
	 * 数据库IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DB_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_IP, java.lang.String.class, "数据库IP", "数据库IP", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_NAME="dbName";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DB_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_NAME, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 端口 , 类型: java.lang.String
	*/
	public static final String DB_PORT="dbPort";
	
	/**
	 * 端口 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DB_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_PORT, java.lang.String.class, "端口", "端口", java.lang.String.class, null);
	
	/**
	 * 数据库用户 , 类型: java.lang.String
	*/
	public static final String DB_USER="dbUser";
	
	/**
	 * 数据库用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DB_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_USER, java.lang.String.class, "数据库用户", "数据库用户", java.lang.String.class, null);
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,CONTENT, java.lang.String.class, "原因", "原因", java.lang.String.class, null);
	
	/**
	 * SQL文本 , 类型: java.lang.String
	*/
	public static final String SQL_AREA="sqlArea";
	
	/**
	 * SQL文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> SQL_AREA_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,SQL_AREA, java.lang.String.class, "SQL文本", "SQL文本", java.lang.String.class, null);
	
	/**
	 * 验证结果 , 类型: java.lang.String
	*/
	public static final String CHECK_RESULT="checkResult";
	
	/**
	 * 验证结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> CHECK_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,CHECK_RESULT, java.lang.String.class, "验证结果", "验证结果", java.lang.String.class, null);
	
	/**
	 * 回滚/备份 , 类型: java.lang.String
	*/
	public static final String RB_RESULT="rbResult";
	
	/**
	 * 回滚/备份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> RB_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,RB_RESULT, java.lang.String.class, "回滚/备份", "回滚/备份", java.lang.String.class, null);
	
	/**
	 * 推送工单 , 类型: java.lang.String
	*/
	public static final String PUSH_ORDER_STATUS="pushOrderStatus";
	
	/**
	 * 推送工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> PUSH_ORDER_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,PUSH_ORDER_STATUS, java.lang.String.class, "推送工单", "推送工单", java.lang.String.class, null);
	
	/**
	 * 返回信息 , 类型: java.lang.String
	*/
	public static final String PUSH_RESULT="pushResult";
	
	/**
	 * 返回信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> PUSH_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,PUSH_RESULT, java.lang.String.class, "返回信息", "返回信息", java.lang.String.class, null);
	
	/**
	 * 工单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 工单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,ORDER_ID, java.lang.String.class, "工单编号", "工单编号", java.lang.String.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String APPLY_USER_ID="applyUserId";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> APPLY_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,APPLY_USER_ID, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 关联系统 , 类型: java.lang.String
	*/
	public static final String ASSOCIATED_SYSTEM="associatedSystem";
	
	/**
	 * 关联系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> ASSOCIATED_SYSTEM_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,ASSOCIATED_SYSTEM, java.lang.String.class, "关联系统", "关联系统", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * dbInfoApply , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final String DB_INFO_APPLY="dbInfoApply";
	
	/**
	 * dbInfoApply , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,com.dt.platform.domain.ops.DbInfoApply> DB_INFO_APPLY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,DB_INFO_APPLY, com.dt.platform.domain.ops.DbInfoApply.class, "dbInfoApply", "dbInfoApply", com.dt.platform.domain.ops.DbInfoApply.class, null);
	
	/**
	 * applyUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String APPLY_USER="applyUser";
	
	/**
	 * applyUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,org.github.foxnic.web.domain.hrm.Employee> APPLY_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,APPLY_USER, org.github.foxnic.web.domain.hrm.Employee.class, "applyUser", "applyUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * requestOrder , 类型: com.dt.platform.domain.ops.DbApplyExecute
	*/
	public static final String REQUEST_ORDER="requestOrder";
	
	/**
	 * requestOrder , 类型: com.dt.platform.domain.ops.DbApplyExecute
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,com.dt.platform.domain.ops.DbApplyExecute> REQUEST_ORDER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,REQUEST_ORDER, com.dt.platform.domain.ops.DbApplyExecute.class, "requestOrder", "requestOrder", com.dt.platform.domain.ops.DbApplyExecute.class, null);
	
	/**
	 * buttonCheck , 类型: java.lang.String
	*/
	public static final String BUTTON_CHECK="buttonCheck";
	
	/**
	 * buttonCheck , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> BUTTON_CHECK_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,BUTTON_CHECK, java.lang.String.class, "buttonCheck", "buttonCheck", java.lang.String.class, null);
	
	/**
	 * buttonCheckDetail , 类型: java.lang.String
	*/
	public static final String BUTTON_CHECK_DETAIL="buttonCheckDetail";
	
	/**
	 * buttonCheckDetail , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> BUTTON_CHECK_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,BUTTON_CHECK_DETAIL, java.lang.String.class, "buttonCheckDetail", "buttonCheckDetail", java.lang.String.class, null);
	
	/**
	 * buttonRB , 类型: java.lang.String
	*/
	public static final String BUTTON_RB="buttonRB";
	
	/**
	 * buttonRB , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> BUTTON_RB_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,BUTTON_RB, java.lang.String.class, "buttonRB", "buttonRB", java.lang.String.class, null);
	
	/**
	 * buttonRBDetail , 类型: java.lang.String
	*/
	public static final String BUTTON_RB_DETAIL="buttonRBDetail";
	
	/**
	 * buttonRBDetail , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApplyVO,java.lang.String> BUTTON_RB_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApplyVO.class ,BUTTON_RB_DETAIL, java.lang.String.class, "buttonRBDetail", "buttonRBDetail", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , ITEM_CODE , ITEM_NAME , STATUS , DB_FULL_NAME , DB_ID , DB_IP , DB_NAME , DB_PORT , DB_USER , CONTENT , SQL_AREA , CHECK_RESULT , RB_RESULT , PUSH_ORDER_STATUS , PUSH_RESULT , ORDER_ID , APPLY_USER_ID , SELECTED_CODE , NOTES , ASSOCIATED_SYSTEM , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , CREATE_BY , CREATE_TIME , VERSION , TENANT_ID , DB_INFO_APPLY , APPLY_USER , REQUEST_ORDER , BUTTON_CHECK , BUTTON_CHECK_DETAIL , BUTTON_RB , BUTTON_RB_DETAIL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbChangeApplyVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public DbChangeApplyVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public DbChangeApplyVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public DbChangeApplyVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public DbChangeApplyVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public DbChangeApplyVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public DbChangeApplyVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public DbChangeApplyVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public DbChangeApplyVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public DbChangeApplyVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public DbChangeApplyVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public DbChangeApplyVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public DbChangeApplyVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbChangeApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 关联工单
		 * @param itemCode 关联工单
		 * @return 当前对象
		*/
		public DbChangeApply setItemCode(String itemCode) {
			super.change(ITEM_CODE,super.getItemCode(),itemCode);
			super.setItemCode(itemCode);
			return this;
		}
		
		/**
		 * 设置 关联工单
		 * @param itemName 关联工单
		 * @return 当前对象
		*/
		public DbChangeApply setItemName(String itemName) {
			super.change(ITEM_NAME,super.getItemName(),itemName);
			super.setItemName(itemName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public DbChangeApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbFullName 数据库
		 * @return 当前对象
		*/
		public DbChangeApply setDbFullName(String dbFullName) {
			super.change(DB_FULL_NAME,super.getDbFullName(),dbFullName);
			super.setDbFullName(dbFullName);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbId 数据库
		 * @return 当前对象
		*/
		public DbChangeApply setDbId(String dbId) {
			super.change(DB_ID,super.getDbId(),dbId);
			super.setDbId(dbId);
			return this;
		}
		
		/**
		 * 设置 数据库IP
		 * @param dbIp 数据库IP
		 * @return 当前对象
		*/
		public DbChangeApply setDbIp(String dbIp) {
			super.change(DB_IP,super.getDbIp(),dbIp);
			super.setDbIp(dbIp);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbName 数据库
		 * @return 当前对象
		*/
		public DbChangeApply setDbName(String dbName) {
			super.change(DB_NAME,super.getDbName(),dbName);
			super.setDbName(dbName);
			return this;
		}
		
		/**
		 * 设置 端口
		 * @param dbPort 端口
		 * @return 当前对象
		*/
		public DbChangeApply setDbPort(String dbPort) {
			super.change(DB_PORT,super.getDbPort(),dbPort);
			super.setDbPort(dbPort);
			return this;
		}
		
		/**
		 * 设置 数据库用户
		 * @param dbUser 数据库用户
		 * @return 当前对象
		*/
		public DbChangeApply setDbUser(String dbUser) {
			super.change(DB_USER,super.getDbUser(),dbUser);
			super.setDbUser(dbUser);
			return this;
		}
		
		/**
		 * 设置 原因
		 * @param content 原因
		 * @return 当前对象
		*/
		public DbChangeApply setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 SQL文本
		 * @param sqlArea SQL文本
		 * @return 当前对象
		*/
		public DbChangeApply setSqlArea(String sqlArea) {
			super.change(SQL_AREA,super.getSqlArea(),sqlArea);
			super.setSqlArea(sqlArea);
			return this;
		}
		
		/**
		 * 设置 验证结果
		 * @param checkResult 验证结果
		 * @return 当前对象
		*/
		public DbChangeApply setCheckResult(String checkResult) {
			super.change(CHECK_RESULT,super.getCheckResult(),checkResult);
			super.setCheckResult(checkResult);
			return this;
		}
		
		/**
		 * 设置 回滚/备份
		 * @param rbResult 回滚/备份
		 * @return 当前对象
		*/
		public DbChangeApply setRbResult(String rbResult) {
			super.change(RB_RESULT,super.getRbResult(),rbResult);
			super.setRbResult(rbResult);
			return this;
		}
		
		/**
		 * 设置 推送工单
		 * @param pushOrderStatus 推送工单
		 * @return 当前对象
		*/
		public DbChangeApply setPushOrderStatus(String pushOrderStatus) {
			super.change(PUSH_ORDER_STATUS,super.getPushOrderStatus(),pushOrderStatus);
			super.setPushOrderStatus(pushOrderStatus);
			return this;
		}
		
		/**
		 * 设置 返回信息
		 * @param pushResult 返回信息
		 * @return 当前对象
		*/
		public DbChangeApply setPushResult(String pushResult) {
			super.change(PUSH_RESULT,super.getPushResult(),pushResult);
			super.setPushResult(pushResult);
			return this;
		}
		
		/**
		 * 设置 工单编号
		 * @param orderId 工单编号
		 * @return 当前对象
		*/
		public DbChangeApply setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param applyUserId 申请人
		 * @return 当前对象
		*/
		public DbChangeApply setApplyUserId(String applyUserId) {
			super.change(APPLY_USER_ID,super.getApplyUserId(),applyUserId);
			super.setApplyUserId(applyUserId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public DbChangeApply setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbChangeApply setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 关联系统
		 * @param associatedSystem 关联系统
		 * @return 当前对象
		*/
		public DbChangeApply setAssociatedSystem(String associatedSystem) {
			super.change(ASSOCIATED_SYSTEM,super.getAssociatedSystem(),associatedSystem);
			super.setAssociatedSystem(associatedSystem);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbChangeApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbChangeApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbChangeApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbChangeApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbChangeApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbChangeApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbChangeApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbChangeApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DbChangeApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 dbInfoApply
		 * @param dbInfoApply dbInfoApply
		 * @return 当前对象
		*/
		public DbChangeApply setDbInfoApply(DbInfoApply dbInfoApply) {
			super.change(DB_INFO_APPLY,super.getDbInfoApply(),dbInfoApply);
			super.setDbInfoApply(dbInfoApply);
			return this;
		}
		
		/**
		 * 设置 applyUser
		 * @param applyUser applyUser
		 * @return 当前对象
		*/
		public DbChangeApply setApplyUser(Employee applyUser) {
			super.change(APPLY_USER,super.getApplyUser(),applyUser);
			super.setApplyUser(applyUser);
			return this;
		}
		
		/**
		 * 设置 requestOrder
		 * @param requestOrder requestOrder
		 * @return 当前对象
		*/
		public DbChangeApply setRequestOrder(DbApplyExecute requestOrder) {
			super.change(REQUEST_ORDER,super.getRequestOrder(),requestOrder);
			super.setRequestOrder(requestOrder);
			return this;
		}
		
		/**
		 * 设置 buttonCheck
		 * @param buttonCheck buttonCheck
		 * @return 当前对象
		*/
		public DbChangeApply setButtonCheck(String buttonCheck) {
			super.change(BUTTON_CHECK,super.getButtonCheck(),buttonCheck);
			super.setButtonCheck(buttonCheck);
			return this;
		}
		
		/**
		 * 设置 buttonCheckDetail
		 * @param buttonCheckDetail buttonCheckDetail
		 * @return 当前对象
		*/
		public DbChangeApply setButtonCheckDetail(String buttonCheckDetail) {
			super.change(BUTTON_CHECK_DETAIL,super.getButtonCheckDetail(),buttonCheckDetail);
			super.setButtonCheckDetail(buttonCheckDetail);
			return this;
		}
		
		/**
		 * 设置 buttonRB
		 * @param buttonRB buttonRB
		 * @return 当前对象
		*/
		public DbChangeApply setButtonRB(String buttonRB) {
			super.change(BUTTON_RB,super.getButtonRB(),buttonRB);
			super.setButtonRB(buttonRB);
			return this;
		}
		
		/**
		 * 设置 buttonRBDetail
		 * @param buttonRBDetail buttonRBDetail
		 * @return 当前对象
		*/
		public DbChangeApply setButtonRBDetail(String buttonRBDetail) {
			super.change(BUTTON_RB_DETAIL,super.getButtonRBDetail(),buttonRBDetail);
			super.setButtonRBDetail(buttonRBDetail);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbChangeApplyVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbChangeApplyVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setOrderId(this.getOrderId());
			inst.setItemCode(this.getItemCode());
			inst.setDbName(this.getDbName());
			inst.setDbFullName(this.getDbFullName());
			inst.setCheckResult(this.getCheckResult());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setApplyUserId(this.getApplyUserId());
			inst.setItemName(this.getItemName());
			inst.setPushOrderStatus(this.getPushOrderStatus());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDbId(this.getDbId());
			inst.setDbUser(this.getDbUser());
			inst.setId(this.getId());
			inst.setPushResult(this.getPushResult());
			inst.setSqlArea(this.getSqlArea());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setDbIp(this.getDbIp());
			inst.setVersion(this.getVersion());
			inst.setDbPort(this.getDbPort());
			inst.setAssociatedSystem(this.getAssociatedSystem());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCreateTime(this.getCreateTime());
			inst.setRbResult(this.getRbResult());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setButtonRBDetail(this.getButtonRBDetail());
				inst.setSearchField(this.getSearchField());
				inst.setDbInfoApply(this.getDbInfoApply());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setButtonCheck(this.getButtonCheck());
				inst.setPageSize(this.getPageSize());
				inst.setApplyUser(this.getApplyUser());
				inst.setRequestOrder(this.getRequestOrder());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setButtonCheckDetail(this.getButtonCheckDetail());
				inst.setButtonRB(this.getButtonRB());
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