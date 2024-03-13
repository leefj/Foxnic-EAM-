package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentBillUserMapVO;
import java.util.List;
import com.dt.platform.domain.hr.AssessmentBillUserMap;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentTask;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.hr.AssessmentBillTask;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 10:58:35
 * @sign B486CF9E3D70862C082CD0236C42FB8A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentBillUserMapVOMeta extends AssessmentBillUserMapMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> BILL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,BILL_ID, java.lang.String.class, "单据", "单据", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,ORG_ID, java.lang.String.class, "部门", "部门", java.lang.String.class, null);
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSEE_ID="assesseeId";
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> ASSESSEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,ASSESSEE_ID, java.lang.String.class, "被考核人", "被考核人", java.lang.String.class, null);
	
	/**
	 * 直属领导 , 类型: java.lang.String
	*/
	public static final String LEADER_ID="leaderId";
	
	/**
	 * 直属领导 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> LEADER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,LEADER_ID, java.lang.String.class, "直属领导", "直属领导", java.lang.String.class, null);
	
	/**
	 * 上上级领导 , 类型: java.lang.String
	*/
	public static final String SECOND_LEADER_ID="secondLeaderId";
	
	/**
	 * 上上级领导 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SECOND_LEADER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SECOND_LEADER_ID, java.lang.String.class, "上上级领导", "上上级领导", java.lang.String.class, null);
	
	/**
	 * HR复核人 , 类型: java.lang.String
	*/
	public static final String HR_USER_ID="hrUserId";
	
	/**
	 * HR复核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> HR_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,HR_USER_ID, java.lang.String.class, "HR复核人", "HR复核人", java.lang.String.class, null);
	
	/**
	 * 生成状态 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 生成状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,RESULT, java.lang.String.class, "生成状态", "生成状态", java.lang.String.class, null);
	
	/**
	 * 生成结果 , 类型: java.lang.String
	*/
	public static final String MESSAGE="message";
	
	/**
	 * 生成结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> MESSAGE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,MESSAGE, java.lang.String.class, "生成结果", "生成结果", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final String ASSESSMENT_TASK="assessmentTask";
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,com.dt.platform.domain.hr.AssessmentTask> ASSESSMENT_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,ASSESSMENT_TASK, com.dt.platform.domain.hr.AssessmentTask.class, "assessmentTask", "assessmentTask", com.dt.platform.domain.hr.AssessmentTask.class, null);
	
	/**
	 * assesseeUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ASSESSEE_USER="assesseeUser";
	
	/**
	 * assesseeUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> ASSESSEE_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,ASSESSEE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "assesseeUser", "assesseeUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SAME_USER_LIST="sameUserList";
	
	/**
	 * sameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> SAME_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_LIST, java.util.List.class, "sameUserList", "sameUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SAME_USER_IDS="sameUserIds";
	
	/**
	 * sameUserIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SAME_USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_IDS, java.util.List.class, "sameUserIds", "sameUserIds", java.lang.String.class, null);
	
	/**
	 * leaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String LEADER_USER="leaderUser";
	
	/**
	 * leaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> LEADER_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,LEADER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "leaderUser", "leaderUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * secondLeaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SECOND_LEADER_USER="secondLeaderUser";
	
	/**
	 * secondLeaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> SECOND_LEADER_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SECOND_LEADER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "secondLeaderUser", "secondLeaderUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * hrUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String HR_USER="hrUser";
	
	/**
	 * hrUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> HR_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,HR_USER, org.github.foxnic.web.domain.hrm.Employee.class, "hrUser", "hrUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserListRel , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SAME_USER_LIST_REL="sameUserListRel";
	
	/**
	 * sameUserListRel , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> SAME_USER_LIST_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_LIST_REL, java.util.List.class, "sameUserListRel", "sameUserListRel", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserIdsRel , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SAME_USER_IDS_REL="sameUserIdsRel";
	
	/**
	 * sameUserIdsRel , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SAME_USER_IDS_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_IDS_REL, java.util.List.class, "sameUserIdsRel", "sameUserIdsRel", java.lang.String.class, null);
	
	/**
	 * leaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String LEADER_USER_REL="leaderUserRel";
	
	/**
	 * leaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> LEADER_USER_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,LEADER_USER_REL, org.github.foxnic.web.domain.hrm.Employee.class, "leaderUserRel", "leaderUserRel", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * leaderUserIdRel , 类型: java.lang.String
	*/
	public static final String LEADER_USER_ID_REL="leaderUserIdRel";
	
	/**
	 * leaderUserIdRel , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> LEADER_USER_ID_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,LEADER_USER_ID_REL, java.lang.String.class, "leaderUserIdRel", "leaderUserIdRel", java.lang.String.class, null);
	
	/**
	 * secondLeaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SECOND_LEADER_USER_REL="secondLeaderUserRel";
	
	/**
	 * secondLeaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,org.github.foxnic.web.domain.hrm.Employee> SECOND_LEADER_USER_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SECOND_LEADER_USER_REL, org.github.foxnic.web.domain.hrm.Employee.class, "secondLeaderUserRel", "secondLeaderUserRel", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * secondLeaderUserIdRel , 类型: java.lang.String
	*/
	public static final String SECOND_LEADER_USER_ID_REL="secondLeaderUserIdRel";
	
	/**
	 * secondLeaderUserIdRel , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SECOND_LEADER_USER_ID_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SECOND_LEADER_USER_ID_REL, java.lang.String.class, "secondLeaderUserIdRel", "secondLeaderUserIdRel", java.lang.String.class, null);
	
	/**
	 * assessmentBillTaskList , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final String ASSESSMENT_BILL_TASK_LIST="assessmentBillTaskList";
	
	/**
	 * assessmentBillTaskList , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,com.dt.platform.domain.hr.AssessmentBillTask> ASSESSMENT_BILL_TASK_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,ASSESSMENT_BILL_TASK_LIST, com.dt.platform.domain.hr.AssessmentBillTask.class, "assessmentBillTaskList", "assessmentBillTaskList", com.dt.platform.domain.hr.AssessmentBillTask.class, null);
	
	/**
	 * selfScoreValue , 类型: java.lang.String
	*/
	public static final String SELF_SCORE_VALUE="selfScoreValue";
	
	/**
	 * selfScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SELF_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SELF_SCORE_VALUE, java.lang.String.class, "selfScoreValue", "selfScoreValue", java.lang.String.class, null);
	
	/**
	 * sameUserAvgScoreValue , 类型: java.lang.String
	*/
	public static final String SAME_USER_AVG_SCORE_VALUE="sameUserAvgScoreValue";
	
	/**
	 * sameUserAvgScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SAME_USER_AVG_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_AVG_SCORE_VALUE, java.lang.String.class, "sameUserAvgScoreValue", "sameUserAvgScoreValue", java.lang.String.class, null);
	
	/**
	 * sameUserNeedCount , 类型: java.lang.String
	*/
	public static final String SAME_USER_NEED_COUNT="sameUserNeedCount";
	
	/**
	 * sameUserNeedCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SAME_USER_NEED_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_NEED_COUNT, java.lang.String.class, "sameUserNeedCount", "sameUserNeedCount", java.lang.String.class, null);
	
	/**
	 * sameUserFinishCount , 类型: java.lang.String
	*/
	public static final String SAME_USER_FINISH_COUNT="sameUserFinishCount";
	
	/**
	 * sameUserFinishCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SAME_USER_FINISH_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SAME_USER_FINISH_COUNT, java.lang.String.class, "sameUserFinishCount", "sameUserFinishCount", java.lang.String.class, null);
	
	/**
	 * leaderScoreValue , sameUserScoreValue , 类型: java.lang.String
	*/
	public static final String LEADER_SCORE_VALUE="leaderScoreValue";
	
	/**
	 * leaderScoreValue , sameUserScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> LEADER_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,LEADER_SCORE_VALUE, java.lang.String.class, "leaderScoreValue", "sameUserScoreValue", java.lang.String.class, null);
	
	/**
	 * secondLeaderScoreValue , 类型: java.lang.String
	*/
	public static final String SECOND_LEADER_SCORE_VALUE="secondLeaderScoreValue";
	
	/**
	 * secondLeaderScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> SECOND_LEADER_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,SECOND_LEADER_SCORE_VALUE, java.lang.String.class, "secondLeaderScoreValue", "secondLeaderScoreValue", java.lang.String.class, null);
	
	/**
	 * ifHrConfirm , 类型: java.lang.String
	*/
	public static final String IF_HR_CONFIRM="ifHrConfirm";
	
	/**
	 * ifHrConfirm , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> IF_HR_CONFIRM_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,IF_HR_CONFIRM, java.lang.String.class, "ifHrConfirm", "ifHrConfirm", java.lang.String.class, null);
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final String S_ORG_ID="sOrgId";
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMapVO,java.lang.String> S_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMapVO.class ,S_ORG_ID, java.lang.String.class, "sOrgId", "sOrgId", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , BILL_ID , STATUS , ORG_ID , ASSESSEE_ID , LEADER_ID , SECOND_LEADER_ID , HR_USER_ID , RESULT , MESSAGE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSESSMENT_TASK , ASSESSEE_USER , SAME_USER_LIST , SAME_USER_IDS , LEADER_USER , SECOND_LEADER_USER , HR_USER , SAME_USER_LIST_REL , SAME_USER_IDS_REL , LEADER_USER_REL , LEADER_USER_ID_REL , SECOND_LEADER_USER_REL , SECOND_LEADER_USER_ID_REL , ASSESSMENT_BILL_TASK_LIST , SELF_SCORE_VALUE , SAME_USER_AVG_SCORE_VALUE , SAME_USER_NEED_COUNT , SAME_USER_FINISH_COUNT , LEADER_SCORE_VALUE , SECOND_LEADER_SCORE_VALUE , IF_HR_CONFIRM , S_ORG_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentBillUserMapVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssessmentBillUserMapVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 单据
		 * @param billId 单据
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 部门
		 * @param orgId 部门
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 被考核人
		 * @param assesseeId 被考核人
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setAssesseeId(String assesseeId) {
			super.change(ASSESSEE_ID,super.getAssesseeId(),assesseeId);
			super.setAssesseeId(assesseeId);
			return this;
		}
		
		/**
		 * 设置 直属领导
		 * @param leaderId 直属领导
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderId(String leaderId) {
			super.change(LEADER_ID,super.getLeaderId(),leaderId);
			super.setLeaderId(leaderId);
			return this;
		}
		
		/**
		 * 设置 上上级领导
		 * @param secondLeaderId 上上级领导
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderId(String secondLeaderId) {
			super.change(SECOND_LEADER_ID,super.getSecondLeaderId(),secondLeaderId);
			super.setSecondLeaderId(secondLeaderId);
			return this;
		}
		
		/**
		 * 设置 HR复核人
		 * @param hrUserId HR复核人
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setHrUserId(String hrUserId) {
			super.change(HR_USER_ID,super.getHrUserId(),hrUserId);
			super.setHrUserId(hrUserId);
			return this;
		}
		
		/**
		 * 设置 生成状态
		 * @param result 生成状态
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 生成结果
		 * @param message 生成结果
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setMessage(String message) {
			super.change(MESSAGE,super.getMessage(),message);
			super.setMessage(message);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 assessmentTask
		 * @param assessmentTask assessmentTask
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setAssessmentTask(AssessmentTask assessmentTask) {
			super.change(ASSESSMENT_TASK,super.getAssessmentTask(),assessmentTask);
			super.setAssessmentTask(assessmentTask);
			return this;
		}
		
		/**
		 * 设置 assesseeUser
		 * @param assesseeUser assesseeUser
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setAssesseeUser(Employee assesseeUser) {
			super.change(ASSESSEE_USER,super.getAssesseeUser(),assesseeUser);
			super.setAssesseeUser(assesseeUser);
			return this;
		}
		
		/**
		 * 设置 sameUserList
		 * @param sameUserList sameUserList
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserList(List<Employee> sameUserList) {
			super.change(SAME_USER_LIST,super.getSameUserList(),sameUserList);
			super.setSameUserList(sameUserList);
			return this;
		}
		
		/**
		 * 设置 sameUserIds
		 * @param sameUserIds sameUserIds
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserIds(List<String> sameUserIds) {
			super.change(SAME_USER_IDS,super.getSameUserIds(),sameUserIds);
			super.setSameUserIds(sameUserIds);
			return this;
		}
		
		/**
		 * 设置 leaderUser
		 * @param leaderUser leaderUser
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderUser(Employee leaderUser) {
			super.change(LEADER_USER,super.getLeaderUser(),leaderUser);
			super.setLeaderUser(leaderUser);
			return this;
		}
		
		/**
		 * 设置 secondLeaderUser
		 * @param secondLeaderUser secondLeaderUser
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderUser(Employee secondLeaderUser) {
			super.change(SECOND_LEADER_USER,super.getSecondLeaderUser(),secondLeaderUser);
			super.setSecondLeaderUser(secondLeaderUser);
			return this;
		}
		
		/**
		 * 设置 hrUser
		 * @param hrUser hrUser
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setHrUser(Employee hrUser) {
			super.change(HR_USER,super.getHrUser(),hrUser);
			super.setHrUser(hrUser);
			return this;
		}
		
		/**
		 * 设置 sameUserListRel
		 * @param sameUserListRel sameUserListRel
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserListRel(List<Employee> sameUserListRel) {
			super.change(SAME_USER_LIST_REL,super.getSameUserListRel(),sameUserListRel);
			super.setSameUserListRel(sameUserListRel);
			return this;
		}
		
		/**
		 * 设置 sameUserIdsRel
		 * @param sameUserIdsRel sameUserIdsRel
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserIdsRel(List<String> sameUserIdsRel) {
			super.change(SAME_USER_IDS_REL,super.getSameUserIdsRel(),sameUserIdsRel);
			super.setSameUserIdsRel(sameUserIdsRel);
			return this;
		}
		
		/**
		 * 设置 leaderUserRel
		 * @param leaderUserRel leaderUserRel
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderUserRel(Employee leaderUserRel) {
			super.change(LEADER_USER_REL,super.getLeaderUserRel(),leaderUserRel);
			super.setLeaderUserRel(leaderUserRel);
			return this;
		}
		
		/**
		 * 设置 leaderUserIdRel
		 * @param leaderUserIdRel leaderUserIdRel
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderUserIdRel(String leaderUserIdRel) {
			super.change(LEADER_USER_ID_REL,super.getLeaderUserIdRel(),leaderUserIdRel);
			super.setLeaderUserIdRel(leaderUserIdRel);
			return this;
		}
		
		/**
		 * 设置 secondLeaderUserRel
		 * @param secondLeaderUserRel secondLeaderUserRel
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderUserRel(Employee secondLeaderUserRel) {
			super.change(SECOND_LEADER_USER_REL,super.getSecondLeaderUserRel(),secondLeaderUserRel);
			super.setSecondLeaderUserRel(secondLeaderUserRel);
			return this;
		}
		
		/**
		 * 设置 secondLeaderUserIdRel
		 * @param secondLeaderUserIdRel secondLeaderUserIdRel
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderUserIdRel(String secondLeaderUserIdRel) {
			super.change(SECOND_LEADER_USER_ID_REL,super.getSecondLeaderUserIdRel(),secondLeaderUserIdRel);
			super.setSecondLeaderUserIdRel(secondLeaderUserIdRel);
			return this;
		}
		
		/**
		 * 设置 assessmentBillTaskList
		 * @param assessmentBillTaskList assessmentBillTaskList
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setAssessmentBillTaskList(AssessmentBillTask assessmentBillTaskList) {
			super.change(ASSESSMENT_BILL_TASK_LIST,super.getAssessmentBillTaskList(),assessmentBillTaskList);
			super.setAssessmentBillTaskList(assessmentBillTaskList);
			return this;
		}
		
		/**
		 * 设置 selfScoreValue
		 * @param selfScoreValue selfScoreValue
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSelfScoreValue(String selfScoreValue) {
			super.change(SELF_SCORE_VALUE,super.getSelfScoreValue(),selfScoreValue);
			super.setSelfScoreValue(selfScoreValue);
			return this;
		}
		
		/**
		 * 设置 sameUserAvgScoreValue
		 * @param sameUserAvgScoreValue sameUserAvgScoreValue
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserAvgScoreValue(String sameUserAvgScoreValue) {
			super.change(SAME_USER_AVG_SCORE_VALUE,super.getSameUserAvgScoreValue(),sameUserAvgScoreValue);
			super.setSameUserAvgScoreValue(sameUserAvgScoreValue);
			return this;
		}
		
		/**
		 * 设置 sameUserNeedCount
		 * @param sameUserNeedCount sameUserNeedCount
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserNeedCount(String sameUserNeedCount) {
			super.change(SAME_USER_NEED_COUNT,super.getSameUserNeedCount(),sameUserNeedCount);
			super.setSameUserNeedCount(sameUserNeedCount);
			return this;
		}
		
		/**
		 * 设置 sameUserFinishCount
		 * @param sameUserFinishCount sameUserFinishCount
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameUserFinishCount(String sameUserFinishCount) {
			super.change(SAME_USER_FINISH_COUNT,super.getSameUserFinishCount(),sameUserFinishCount);
			super.setSameUserFinishCount(sameUserFinishCount);
			return this;
		}
		
		/**
		 * 设置 leaderScoreValue
		 * @param leaderScoreValue leaderScoreValue
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderScoreValue(String leaderScoreValue) {
			super.change(LEADER_SCORE_VALUE,super.getLeaderScoreValue(),leaderScoreValue);
			super.setLeaderScoreValue(leaderScoreValue);
			return this;
		}
		
		/**
		 * 设置 secondLeaderScoreValue
		 * @param secondLeaderScoreValue secondLeaderScoreValue
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderScoreValue(String secondLeaderScoreValue) {
			super.change(SECOND_LEADER_SCORE_VALUE,super.getSecondLeaderScoreValue(),secondLeaderScoreValue);
			super.setSecondLeaderScoreValue(secondLeaderScoreValue);
			return this;
		}
		
		/**
		 * 设置 ifHrConfirm
		 * @param ifHrConfirm ifHrConfirm
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIfHrConfirm(String ifHrConfirm) {
			super.change(IF_HR_CONFIRM,super.getIfHrConfirm(),ifHrConfirm);
			super.setIfHrConfirm(ifHrConfirm);
			return this;
		}
		
		/**
		 * 设置 sOrgId
		 * @param sOrgId sOrgId
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSOrgId(String sOrgId) {
			super.change(S_ORG_ID,super.getSOrgId(),sOrgId);
			super.setSOrgId(sOrgId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentBillUserMapVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentBillUserMapVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setHrUserId(this.getHrUserId());
			inst.setSecondLeaderId(this.getSecondLeaderId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMessage(this.getMessage());
			inst.setVersion(this.getVersion());
			inst.setOrgId(this.getOrgId());
			inst.setLeaderId(this.getLeaderId());
			inst.setAssesseeId(this.getAssesseeId());
			inst.setResult(this.getResult());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setBillId(this.getBillId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAssesseeUser(this.getAssesseeUser());
				inst.setSearchField(this.getSearchField());
				inst.setSameUserNeedCount(this.getSameUserNeedCount());
				inst.setSameUserFinishCount(this.getSameUserFinishCount());
				inst.setIfHrConfirm(this.getIfHrConfirm());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setSecondLeaderUserRel(this.getSecondLeaderUserRel());
				inst.setLeaderUserIdRel(this.getLeaderUserIdRel());
				inst.setHrUser(this.getHrUser());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setSameUserIdsRel(this.getSameUserIdsRel());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSameUserIds(this.getSameUserIds());
				inst.setAssessmentBillTaskList(this.getAssessmentBillTaskList());
				inst.setLeaderScoreValue(this.getLeaderScoreValue());
				inst.setSecondLeaderScoreValue(this.getSecondLeaderScoreValue());
				inst.setSameUserList(this.getSameUserList());
				inst.setSameUserAvgScoreValue(this.getSameUserAvgScoreValue());
				inst.setRequestAction(this.getRequestAction());
				inst.setSecondLeaderUser(this.getSecondLeaderUser());
				inst.setSOrgId(this.getSOrgId());
				inst.setLeaderUserRel(this.getLeaderUserRel());
				inst.setSecondLeaderUserIdRel(this.getSecondLeaderUserIdRel());
				inst.setLeaderUser(this.getLeaderUser());
				inst.setSameUserListRel(this.getSameUserListRel());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setIds(this.getIds());
				inst.setAssessmentTask(this.getAssessmentTask());
				inst.setSearchValue(this.getSearchValue());
				inst.setSelfScoreValue(this.getSelfScoreValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}