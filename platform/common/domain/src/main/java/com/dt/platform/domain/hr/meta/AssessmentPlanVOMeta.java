package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentPlanVO;
import java.util.List;
import com.dt.platform.domain.hr.AssessmentPlan;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.AssessmentIndicator;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 15:10:35
 * @sign 6C64A7624E90FE86529E9455D952E103
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentPlanVOMeta extends AssessmentPlanMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,BUSINESS_CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 考核名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 考核名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,NAME, java.lang.String.class, "考核名称", "考核名称", java.lang.String.class, null);
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final String POS_ID="posId";
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> POS_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,POS_ID, java.lang.String.class, "岗位", "岗位", java.lang.String.class, null);
	
	/**
	 * 周期 , 类型: java.lang.String
	*/
	public static final String CYCLE="cycle";
	
	/**
	 * 周期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> CYCLE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,CYCLE, java.lang.String.class, "周期", "周期", java.lang.String.class, null);
	
	/**
	 * 考核方式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 考核方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,METHOD, java.lang.String.class, "考核方式", "考核方式", java.lang.String.class, null);
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSEE_ID="assesseeId";
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> ASSESSEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSEE_ID, java.lang.String.class, "被考核人", "被考核人", java.lang.String.class, null);
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSOR_ID="assessorId";
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> ASSESSOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSOR_ID, java.lang.String.class, "考核人", "考核人", java.lang.String.class, null);
	
	/**
	 * 二级考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSOR_SECOND_ID="assessorSecondId";
	
	/**
	 * 二级考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> ASSESSOR_SECOND_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSOR_SECOND_ID, java.lang.String.class, "二级考核人", "二级考核人", java.lang.String.class, null);
	
	/**
	 * 指标总权重 , %） , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_WEIGHT="totalWeight";
	
	/**
	 * 指标总权重 , %） , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.math.BigDecimal> TOTAL_WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,TOTAL_WEIGHT, java.math.BigDecimal.class, "指标总权重", "%）", java.math.BigDecimal.class, null);
	
	/**
	 * 考勤模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 考勤模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,TPL_ID, java.lang.String.class, "考勤模版", "考勤模版", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * assessmentTpl , 类型: com.dt.platform.domain.hr.AssessmentTpl
	*/
	public static final String ASSESSMENT_TPL="assessmentTpl";
	
	/**
	 * assessmentTpl , 类型: com.dt.platform.domain.hr.AssessmentTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,com.dt.platform.domain.hr.AssessmentTpl> ASSESSMENT_TPL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSMENT_TPL, com.dt.platform.domain.hr.AssessmentTpl.class, "assessmentTpl", "assessmentTpl", com.dt.platform.domain.hr.AssessmentTpl.class, null);
	
	/**
	 * assessmentIndicatorList , assessmentIndicator , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final String ASSESSMENT_INDICATOR_LIST="assessmentIndicatorList";
	
	/**
	 * assessmentIndicatorList , assessmentIndicator , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,com.dt.platform.domain.hr.AssessmentIndicator> ASSESSMENT_INDICATOR_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSMENT_INDICATOR_LIST, java.util.List.class, "assessmentIndicatorList", "assessmentIndicator", com.dt.platform.domain.hr.AssessmentIndicator.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * buttonAction , 类型: java.lang.String
	*/
	public static final String BUTTON_ACTION="buttonAction";
	
	/**
	 * buttonAction , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,java.lang.String> BUTTON_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,BUTTON_ACTION, java.lang.String.class, "buttonAction", "buttonAction", java.lang.String.class, null);
	
	/**
	 * assesseeUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String ASSESSEE_USER="assesseeUser";
	
	/**
	 * assesseeUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,org.github.foxnic.web.domain.hrm.Person> ASSESSEE_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSEE_USER, org.github.foxnic.web.domain.hrm.Person.class, "assesseeUser", "assesseeUser", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * assessorUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String ASSESSOR_USER="assessorUser";
	
	/**
	 * assessorUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,org.github.foxnic.web.domain.hrm.Person> ASSESSOR_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,ASSESSOR_USER, org.github.foxnic.web.domain.hrm.Person.class, "assessorUser", "assessorUser", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentPlanVO,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentPlanVO.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , STATUS , BUSINESS_CODE , NAME , POS_ID , CYCLE , METHOD , ASSESSEE_ID , ASSESSOR_ID , ASSESSOR_SECOND_ID , TOTAL_WEIGHT , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSESSMENT_TPL , ASSESSMENT_INDICATOR_LIST , SELECTED_CODE , BUTTON_ACTION , ASSESSEE_USER , ASSESSOR_USER , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentPlanVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssessmentPlanVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssessmentPlanVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssessmentPlanVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssessmentPlanVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssessmentPlanVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssessmentPlanVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssessmentPlanVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssessmentPlanVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AssessmentPlanVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AssessmentPlanVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AssessmentPlanVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssessmentPlanVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentPlan setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssessmentPlan setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param businessCode 编号
		 * @return 当前对象
		*/
		public AssessmentPlan setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 考核名称
		 * @param name 考核名称
		 * @return 当前对象
		*/
		public AssessmentPlan setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 岗位
		 * @param posId 岗位
		 * @return 当前对象
		*/
		public AssessmentPlan setPosId(String posId) {
			super.change(POS_ID,super.getPosId(),posId);
			super.setPosId(posId);
			return this;
		}
		
		/**
		 * 设置 周期
		 * @param cycle 周期
		 * @return 当前对象
		*/
		public AssessmentPlan setCycle(String cycle) {
			super.change(CYCLE,super.getCycle(),cycle);
			super.setCycle(cycle);
			return this;
		}
		
		/**
		 * 设置 考核方式
		 * @param method 考核方式
		 * @return 当前对象
		*/
		public AssessmentPlan setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 被考核人
		 * @param assesseeId 被考核人
		 * @return 当前对象
		*/
		public AssessmentPlan setAssesseeId(String assesseeId) {
			super.change(ASSESSEE_ID,super.getAssesseeId(),assesseeId);
			super.setAssesseeId(assesseeId);
			return this;
		}
		
		/**
		 * 设置 考核人
		 * @param assessorId 考核人
		 * @return 当前对象
		*/
		public AssessmentPlan setAssessorId(String assessorId) {
			super.change(ASSESSOR_ID,super.getAssessorId(),assessorId);
			super.setAssessorId(assessorId);
			return this;
		}
		
		/**
		 * 设置 二级考核人
		 * @param assessorSecondId 二级考核人
		 * @return 当前对象
		*/
		public AssessmentPlan setAssessorSecondId(String assessorSecondId) {
			super.change(ASSESSOR_SECOND_ID,super.getAssessorSecondId(),assessorSecondId);
			super.setAssessorSecondId(assessorSecondId);
			return this;
		}
		
		/**
		 * 设置 指标总权重
		 * @param totalWeight 指标总权重
		 * @return 当前对象
		*/
		public AssessmentPlan setTotalWeight(BigDecimal totalWeight) {
			super.change(TOTAL_WEIGHT,super.getTotalWeight(),totalWeight);
			super.setTotalWeight(totalWeight);
			return this;
		}
		
		/**
		 * 设置 考勤模版
		 * @param tplId 考勤模版
		 * @return 当前对象
		*/
		public AssessmentPlan setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssessmentPlan setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentPlan setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentPlan setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentPlan setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentPlan setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentPlan setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentPlan setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentPlan setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentPlan setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentPlan setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 assessmentTpl
		 * @param assessmentTpl assessmentTpl
		 * @return 当前对象
		*/
		public AssessmentPlan setAssessmentTpl(AssessmentTpl assessmentTpl) {
			super.change(ASSESSMENT_TPL,super.getAssessmentTpl(),assessmentTpl);
			super.setAssessmentTpl(assessmentTpl);
			return this;
		}
		
		/**
		 * 设置 assessmentIndicatorList
		 * @param assessmentIndicatorList assessmentIndicatorList
		 * @return 当前对象
		*/
		public AssessmentPlan setAssessmentIndicatorList(List<AssessmentIndicator> assessmentIndicatorList) {
			super.change(ASSESSMENT_INDICATOR_LIST,super.getAssessmentIndicatorList(),assessmentIndicatorList);
			super.setAssessmentIndicatorList(assessmentIndicatorList);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public AssessmentPlan setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 buttonAction
		 * @param buttonAction buttonAction
		 * @return 当前对象
		*/
		public AssessmentPlan setButtonAction(String buttonAction) {
			super.change(BUTTON_ACTION,super.getButtonAction(),buttonAction);
			super.setButtonAction(buttonAction);
			return this;
		}
		
		/**
		 * 设置 assesseeUser
		 * @param assesseeUser assesseeUser
		 * @return 当前对象
		*/
		public AssessmentPlan setAssesseeUser(Person assesseeUser) {
			super.change(ASSESSEE_USER,super.getAssesseeUser(),assesseeUser);
			super.setAssesseeUser(assesseeUser);
			return this;
		}
		
		/**
		 * 设置 assessorUser
		 * @param assessorUser assessorUser
		 * @return 当前对象
		*/
		public AssessmentPlan setAssessorUser(Person assessorUser) {
			super.change(ASSESSOR_USER,super.getAssessorUser(),assessorUser);
			super.setAssessorUser(assessorUser);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public AssessmentPlan setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public AssessmentPlan setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public AssessmentPlan setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentPlanVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentPlanVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setMethod(this.getMethod());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setAssessorSecondId(this.getAssessorSecondId());
			inst.setCycle(this.getCycle());
			inst.setVersion(this.getVersion());
			inst.setAssesseeId(this.getAssesseeId());
			inst.setPosId(this.getPosId());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssessorId(this.getAssessorId());
			inst.setName(this.getName());
			inst.setTotalWeight(this.getTotalWeight());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTplId(this.getTplId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAssesseeUser(this.getAssesseeUser());
				inst.setSearchField(this.getSearchField());
				inst.setAssessorUser(this.getAssessorUser());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setHistoricProcessList(this.getHistoricProcessList());
				inst.setSelectedCode(this.getSelectedCode());
				inst.setCurrentProcessList(this.getCurrentProcessList());
				inst.setDefaultProcess(this.getDefaultProcess());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setAssessmentIndicatorList(this.getAssessmentIndicatorList());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setAssessmentTpl(this.getAssessmentTpl());
				inst.setButtonAction(this.getButtonAction());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}