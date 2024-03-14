package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentTask;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.AssessmentIndicator;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.hr.Position;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-14 07:22:53
 * @sign 728ABCB3180826B97F77AD10809296D4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentTaskMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 模版,数据 , 类型: java.lang.String
	*/
	public static final String OWNER="owner";
	
	/**
	 * 所属 , 模版,数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> OWNER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,OWNER, java.lang.String.class, "所属", "模版,数据", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,TYPE, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 考核名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 考核名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,NAME, java.lang.String.class, "考核名称", "考核名称", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 周期 , 类型: java.lang.String
	*/
	public static final String CYCLE="cycle";
	
	/**
	 * 周期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> CYCLE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,CYCLE, java.lang.String.class, "周期", "周期", java.lang.String.class, null);
	
	/**
	 * 全部人员 , 类型: java.lang.String
	*/
	public static final String IS_ALL_PERSON="isAllPerson";
	
	/**
	 * 全部人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> IS_ALL_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,IS_ALL_PERSON, java.lang.String.class, "全部人员", "全部人员", java.lang.String.class, null);
	
	/**
	 * 考核方式 , 类型: java.lang.String
	*/
	public static final String ASSESSMEN_METHOD="assessmenMethod";
	
	/**
	 * 考核方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> ASSESSMEN_METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,ASSESSMEN_METHOD, java.lang.String.class, "考核方式", "考核方式", java.lang.String.class, null);
	
	/**
	 * 指标总权重 , %） , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_WEIGHT="totalWeight";
	
	/**
	 * 指标总权重 , %） , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.math.BigDecimal> TOTAL_WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,TOTAL_WEIGHT, java.math.BigDecimal.class, "指标总权重", "%）", java.math.BigDecimal.class, null);
	
	/**
	 * 自评评分 , 类型: java.lang.String
	*/
	public static final String HAS_SELF_ASSESSMENT="hasSelfAssessment";
	
	/**
	 * 自评评分 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> HAS_SELF_ASSESSMENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HAS_SELF_ASSESSMENT, java.lang.String.class, "自评评分", "自评评分", java.lang.String.class, null);
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final String SELF_WEIGTH="selfWeigth";
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.Integer> SELF_WEIGTH_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,SELF_WEIGTH, java.lang.Integer.class, "权重", "权重", java.lang.Integer.class, null);
	
	/**
	 * 互评分 , 类型: java.lang.String
	*/
	public static final String HAS_SAME_ASSESSMENT="hasSameAssessment";
	
	/**
	 * 互评分 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> HAS_SAME_ASSESSMENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HAS_SAME_ASSESSMENT, java.lang.String.class, "互评分", "互评分", java.lang.String.class, null);
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final String SAME_WEIGTH="sameWeigth";
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.Integer> SAME_WEIGTH_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,SAME_WEIGTH, java.lang.Integer.class, "权重", "权重", java.lang.Integer.class, null);
	
	/**
	 * 直接领导评分 , 类型: java.lang.String
	*/
	public static final String HAS_LEADER_ASSESSMENT="hasLeaderAssessment";
	
	/**
	 * 直接领导评分 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> HAS_LEADER_ASSESSMENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HAS_LEADER_ASSESSMENT, java.lang.String.class, "直接领导评分", "直接领导评分", java.lang.String.class, null);
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final String LEADER_WEIGTH="leaderWeigth";
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.Integer> LEADER_WEIGTH_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,LEADER_WEIGTH, java.lang.Integer.class, "权重", "权重", java.lang.Integer.class, null);
	
	/**
	 * 上上级领导评分 , 类型: java.lang.String
	*/
	public static final String HAS_SECOND_LEADER_ASSESSMENT="hasSecondLeaderAssessment";
	
	/**
	 * 上上级领导评分 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> HAS_SECOND_LEADER_ASSESSMENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HAS_SECOND_LEADER_ASSESSMENT, java.lang.String.class, "上上级领导评分", "上上级领导评分", java.lang.String.class, null);
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final String SECOND_WEIGHT="secondWeight";
	
	/**
	 * 权重 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.Integer> SECOND_WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,SECOND_WEIGHT, java.lang.Integer.class, "权重", "权重", java.lang.Integer.class, null);
	
	/**
	 * HR是否复核 , 类型: java.lang.String
	*/
	public static final String HAS_HR_CONFIRM="hasHrConfirm";
	
	/**
	 * HR是否复核 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> HAS_HR_CONFIRM_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HAS_HR_CONFIRM, java.lang.String.class, "HR是否复核", "HR是否复核", java.lang.String.class, null);
	
	/**
	 * HR复核人 , 类型: java.lang.String
	*/
	public static final String HR_USER_ID="hrUserId";
	
	/**
	 * HR复核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> HR_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HR_USER_ID, java.lang.String.class, "HR复核人", "HR复核人", java.lang.String.class, null);
	
	/**
	 * 绩效模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 绩效模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,TPL_ID, java.lang.String.class, "绩效模版", "绩效模版", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,SOURCE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * assessmentTpl , 类型: com.dt.platform.domain.hr.AssessmentTpl
	*/
	public static final String ASSESSMENT_TPL="assessmentTpl";
	
	/**
	 * assessmentTpl , 类型: com.dt.platform.domain.hr.AssessmentTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,com.dt.platform.domain.hr.AssessmentTpl> ASSESSMENT_TPL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,ASSESSMENT_TPL, com.dt.platform.domain.hr.AssessmentTpl.class, "assessmentTpl", "assessmentTpl", com.dt.platform.domain.hr.AssessmentTpl.class, null);
	
	/**
	 * assessmentIndicatorList , assessmentIndicator , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final String ASSESSMENT_INDICATOR_LIST="assessmentIndicatorList";
	
	/**
	 * assessmentIndicatorList , assessmentIndicator , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,com.dt.platform.domain.hr.AssessmentIndicator> ASSESSMENT_INDICATOR_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,ASSESSMENT_INDICATOR_LIST, java.util.List.class, "assessmentIndicatorList", "assessmentIndicator", com.dt.platform.domain.hr.AssessmentIndicator.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * organizationList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION_LIST="organizationList";
	
	/**
	 * organizationList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,ORGANIZATION_LIST, java.util.List.class, "organizationList", "organizationList", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * organizationIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ORGANIZATION_IDS="organizationIds";
	
	/**
	 * organizationIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> ORGANIZATION_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,ORGANIZATION_IDS, java.util.List.class, "organizationIds", "organizationIds", java.lang.String.class, null);
	
	/**
	 * positionList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final String POSITION_LIST="positionList";
	
	/**
	 * positionList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,com.dt.platform.domain.hr.Position> POSITION_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,POSITION_LIST, java.util.List.class, "positionList", "positionList", com.dt.platform.domain.hr.Position.class, null);
	
	/**
	 * positionIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * positionIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> POSITION_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,POSITION_IDS, java.util.List.class, "positionIds", "positionIds", java.lang.String.class, null);
	
	/**
	 * personList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PERSON_LIST="personList";
	
	/**
	 * personList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,org.github.foxnic.web.domain.hrm.Employee> PERSON_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,PERSON_LIST, java.util.List.class, "personList", "personList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * personIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PERSON_IDS="personIds";
	
	/**
	 * personIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> PERSON_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,PERSON_IDS, java.util.List.class, "personIds", "personIds", java.lang.String.class, null);
	
	/**
	 * hrUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String HR_USER="hrUser";
	
	/**
	 * hrUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,org.github.foxnic.web.domain.hrm.Employee> HR_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,HR_USER, org.github.foxnic.web.domain.hrm.Employee.class, "hrUser", "hrUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * excludePersonList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXCLUDE_PERSON_LIST="excludePersonList";
	
	/**
	 * excludePersonList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,org.github.foxnic.web.domain.hrm.Employee> EXCLUDE_PERSON_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,EXCLUDE_PERSON_LIST, java.util.List.class, "excludePersonList", "excludePersonList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * excludePersonIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String EXCLUDE_PERSON_IDS="excludePersonIds";
	
	/**
	 * excludePersonIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> EXCLUDE_PERSON_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,EXCLUDE_PERSON_IDS, java.util.List.class, "excludePersonIds", "excludePersonIds", java.lang.String.class, null);
	
	/**
	 * buttonAction , 类型: java.lang.String
	*/
	public static final String BUTTON_ACTION="buttonAction";
	
	/**
	 * buttonAction , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,java.lang.String> BUTTON_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,BUTTON_ACTION, java.lang.String.class, "buttonAction", "buttonAction", java.lang.String.class, null);
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTask,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTask.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "typeDict", "typeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER , TYPE , NAME , STATUS , CYCLE , IS_ALL_PERSON , ASSESSMEN_METHOD , TOTAL_WEIGHT , HAS_SELF_ASSESSMENT , SELF_WEIGTH , HAS_SAME_ASSESSMENT , SAME_WEIGTH , HAS_LEADER_ASSESSMENT , LEADER_WEIGTH , HAS_SECOND_LEADER_ASSESSMENT , SECOND_WEIGHT , HAS_HR_CONFIRM , HR_USER_ID , TPL_ID , SOURCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSESSMENT_TPL , ASSESSMENT_INDICATOR_LIST , SELECTED_CODE , ORGANIZATION_LIST , ORGANIZATION_IDS , POSITION_LIST , POSITION_IDS , PERSON_LIST , PERSON_IDS , HR_USER , EXCLUDE_PERSON_LIST , EXCLUDE_PERSON_IDS , BUTTON_ACTION , TYPE_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentTask {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param owner 所属
		 * @return 当前对象
		*/
		public AssessmentTask setOwner(String owner) {
			super.change(OWNER,super.getOwner(),owner);
			super.setOwner(owner);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param type 分类
		 * @return 当前对象
		*/
		public AssessmentTask setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 考核名称
		 * @param name 考核名称
		 * @return 当前对象
		*/
		public AssessmentTask setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 任务状态
		 * @param status 任务状态
		 * @return 当前对象
		*/
		public AssessmentTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 周期
		 * @param cycle 周期
		 * @return 当前对象
		*/
		public AssessmentTask setCycle(String cycle) {
			super.change(CYCLE,super.getCycle(),cycle);
			super.setCycle(cycle);
			return this;
		}
		
		/**
		 * 设置 全部人员
		 * @param isAllPerson 全部人员
		 * @return 当前对象
		*/
		public AssessmentTask setIsAllPerson(String isAllPerson) {
			super.change(IS_ALL_PERSON,super.getIsAllPerson(),isAllPerson);
			super.setIsAllPerson(isAllPerson);
			return this;
		}
		
		/**
		 * 设置 考核方式
		 * @param assessmenMethod 考核方式
		 * @return 当前对象
		*/
		public AssessmentTask setAssessmenMethod(String assessmenMethod) {
			super.change(ASSESSMEN_METHOD,super.getAssessmenMethod(),assessmenMethod);
			super.setAssessmenMethod(assessmenMethod);
			return this;
		}
		
		/**
		 * 设置 指标总权重
		 * @param totalWeight 指标总权重
		 * @return 当前对象
		*/
		public AssessmentTask setTotalWeight(BigDecimal totalWeight) {
			super.change(TOTAL_WEIGHT,super.getTotalWeight(),totalWeight);
			super.setTotalWeight(totalWeight);
			return this;
		}
		
		/**
		 * 设置 自评评分
		 * @param hasSelfAssessment 自评评分
		 * @return 当前对象
		*/
		public AssessmentTask setHasSelfAssessment(String hasSelfAssessment) {
			super.change(HAS_SELF_ASSESSMENT,super.getHasSelfAssessment(),hasSelfAssessment);
			super.setHasSelfAssessment(hasSelfAssessment);
			return this;
		}
		
		/**
		 * 设置 权重
		 * @param selfWeigth 权重
		 * @return 当前对象
		*/
		public AssessmentTask setSelfWeigth(Integer selfWeigth) {
			super.change(SELF_WEIGTH,super.getSelfWeigth(),selfWeigth);
			super.setSelfWeigth(selfWeigth);
			return this;
		}
		
		/**
		 * 设置 互评分
		 * @param hasSameAssessment 互评分
		 * @return 当前对象
		*/
		public AssessmentTask setHasSameAssessment(String hasSameAssessment) {
			super.change(HAS_SAME_ASSESSMENT,super.getHasSameAssessment(),hasSameAssessment);
			super.setHasSameAssessment(hasSameAssessment);
			return this;
		}
		
		/**
		 * 设置 权重
		 * @param sameWeigth 权重
		 * @return 当前对象
		*/
		public AssessmentTask setSameWeigth(Integer sameWeigth) {
			super.change(SAME_WEIGTH,super.getSameWeigth(),sameWeigth);
			super.setSameWeigth(sameWeigth);
			return this;
		}
		
		/**
		 * 设置 直接领导评分
		 * @param hasLeaderAssessment 直接领导评分
		 * @return 当前对象
		*/
		public AssessmentTask setHasLeaderAssessment(String hasLeaderAssessment) {
			super.change(HAS_LEADER_ASSESSMENT,super.getHasLeaderAssessment(),hasLeaderAssessment);
			super.setHasLeaderAssessment(hasLeaderAssessment);
			return this;
		}
		
		/**
		 * 设置 权重
		 * @param leaderWeigth 权重
		 * @return 当前对象
		*/
		public AssessmentTask setLeaderWeigth(Integer leaderWeigth) {
			super.change(LEADER_WEIGTH,super.getLeaderWeigth(),leaderWeigth);
			super.setLeaderWeigth(leaderWeigth);
			return this;
		}
		
		/**
		 * 设置 上上级领导评分
		 * @param hasSecondLeaderAssessment 上上级领导评分
		 * @return 当前对象
		*/
		public AssessmentTask setHasSecondLeaderAssessment(String hasSecondLeaderAssessment) {
			super.change(HAS_SECOND_LEADER_ASSESSMENT,super.getHasSecondLeaderAssessment(),hasSecondLeaderAssessment);
			super.setHasSecondLeaderAssessment(hasSecondLeaderAssessment);
			return this;
		}
		
		/**
		 * 设置 权重
		 * @param secondWeight 权重
		 * @return 当前对象
		*/
		public AssessmentTask setSecondWeight(Integer secondWeight) {
			super.change(SECOND_WEIGHT,super.getSecondWeight(),secondWeight);
			super.setSecondWeight(secondWeight);
			return this;
		}
		
		/**
		 * 设置 HR是否复核
		 * @param hasHrConfirm HR是否复核
		 * @return 当前对象
		*/
		public AssessmentTask setHasHrConfirm(String hasHrConfirm) {
			super.change(HAS_HR_CONFIRM,super.getHasHrConfirm(),hasHrConfirm);
			super.setHasHrConfirm(hasHrConfirm);
			return this;
		}
		
		/**
		 * 设置 HR复核人
		 * @param hrUserId HR复核人
		 * @return 当前对象
		*/
		public AssessmentTask setHrUserId(String hrUserId) {
			super.change(HR_USER_ID,super.getHrUserId(),hrUserId);
			super.setHrUserId(hrUserId);
			return this;
		}
		
		/**
		 * 设置 绩效模版
		 * @param tplId 绩效模版
		 * @return 当前对象
		*/
		public AssessmentTask setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public AssessmentTask setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssessmentTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 assessmentTpl
		 * @param assessmentTpl assessmentTpl
		 * @return 当前对象
		*/
		public AssessmentTask setAssessmentTpl(AssessmentTpl assessmentTpl) {
			super.change(ASSESSMENT_TPL,super.getAssessmentTpl(),assessmentTpl);
			super.setAssessmentTpl(assessmentTpl);
			return this;
		}
		
		/**
		 * 设置 assessmentIndicatorList
		 * @param assessmentIndicatorList assessmentIndicatorList
		 * @return 当前对象
		*/
		public AssessmentTask setAssessmentIndicatorList(List<AssessmentIndicator> assessmentIndicatorList) {
			super.change(ASSESSMENT_INDICATOR_LIST,super.getAssessmentIndicatorList(),assessmentIndicatorList);
			super.setAssessmentIndicatorList(assessmentIndicatorList);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public AssessmentTask setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 organizationList
		 * @param organizationList organizationList
		 * @return 当前对象
		*/
		public AssessmentTask setOrganizationList(List<Organization> organizationList) {
			super.change(ORGANIZATION_LIST,super.getOrganizationList(),organizationList);
			super.setOrganizationList(organizationList);
			return this;
		}
		
		/**
		 * 设置 organizationIds
		 * @param organizationIds organizationIds
		 * @return 当前对象
		*/
		public AssessmentTask setOrganizationIds(List<String> organizationIds) {
			super.change(ORGANIZATION_IDS,super.getOrganizationIds(),organizationIds);
			super.setOrganizationIds(organizationIds);
			return this;
		}
		
		/**
		 * 设置 positionList
		 * @param positionList positionList
		 * @return 当前对象
		*/
		public AssessmentTask setPositionList(List<Position> positionList) {
			super.change(POSITION_LIST,super.getPositionList(),positionList);
			super.setPositionList(positionList);
			return this;
		}
		
		/**
		 * 设置 positionIds
		 * @param positionIds positionIds
		 * @return 当前对象
		*/
		public AssessmentTask setPositionIds(List<String> positionIds) {
			super.change(POSITION_IDS,super.getPositionIds(),positionIds);
			super.setPositionIds(positionIds);
			return this;
		}
		
		/**
		 * 设置 personList
		 * @param personList personList
		 * @return 当前对象
		*/
		public AssessmentTask setPersonList(List<Employee> personList) {
			super.change(PERSON_LIST,super.getPersonList(),personList);
			super.setPersonList(personList);
			return this;
		}
		
		/**
		 * 设置 personIds
		 * @param personIds personIds
		 * @return 当前对象
		*/
		public AssessmentTask setPersonIds(List<String> personIds) {
			super.change(PERSON_IDS,super.getPersonIds(),personIds);
			super.setPersonIds(personIds);
			return this;
		}
		
		/**
		 * 设置 hrUser
		 * @param hrUser hrUser
		 * @return 当前对象
		*/
		public AssessmentTask setHrUser(Employee hrUser) {
			super.change(HR_USER,super.getHrUser(),hrUser);
			super.setHrUser(hrUser);
			return this;
		}
		
		/**
		 * 设置 excludePersonList
		 * @param excludePersonList excludePersonList
		 * @return 当前对象
		*/
		public AssessmentTask setExcludePersonList(List<Employee> excludePersonList) {
			super.change(EXCLUDE_PERSON_LIST,super.getExcludePersonList(),excludePersonList);
			super.setExcludePersonList(excludePersonList);
			return this;
		}
		
		/**
		 * 设置 excludePersonIds
		 * @param excludePersonIds excludePersonIds
		 * @return 当前对象
		*/
		public AssessmentTask setExcludePersonIds(List<String> excludePersonIds) {
			super.change(EXCLUDE_PERSON_IDS,super.getExcludePersonIds(),excludePersonIds);
			super.setExcludePersonIds(excludePersonIds);
			return this;
		}
		
		/**
		 * 设置 buttonAction
		 * @param buttonAction buttonAction
		 * @return 当前对象
		*/
		public AssessmentTask setButtonAction(String buttonAction) {
			super.change(BUTTON_ACTION,super.getButtonAction(),buttonAction);
			super.setButtonAction(buttonAction);
			return this;
		}
		
		/**
		 * 设置 typeDict
		 * @param typeDict typeDict
		 * @return 当前对象
		*/
		public AssessmentTask setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentTask clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentTask duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setLeaderWeigth(this.getLeaderWeigth());
			inst.setSource(this.getSource());
			inst.setType(this.getType());
			inst.setCycle(this.getCycle());
			inst.setSecondWeight(this.getSecondWeight());
			inst.setHasSelfAssessment(this.getHasSelfAssessment());
			inst.setHasLeaderAssessment(this.getHasLeaderAssessment());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setIsAllPerson(this.getIsAllPerson());
			inst.setOwner(this.getOwner());
			inst.setHrUserId(this.getHrUserId());
			inst.setSelfWeigth(this.getSelfWeigth());
			inst.setHasHrConfirm(this.getHasHrConfirm());
			inst.setHasSecondLeaderAssessment(this.getHasSecondLeaderAssessment());
			inst.setHasSameAssessment(this.getHasSameAssessment());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setAssessmenMethod(this.getAssessmenMethod());
			inst.setSameWeigth(this.getSameWeigth());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTotalWeight(this.getTotalWeight());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setTplId(this.getTplId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setPositionIds(this.getPositionIds());
				inst.setPositionList(this.getPositionList());
				inst.setPersonList(this.getPersonList());
				inst.setOrganizationList(this.getOrganizationList());
				inst.setSelectedCode(this.getSelectedCode());
				inst.setHrUser(this.getHrUser());
				inst.setAssessmentIndicatorList(this.getAssessmentIndicatorList());
				inst.setOrganizationIds(this.getOrganizationIds());
				inst.setExcludePersonIds(this.getExcludePersonIds());
				inst.setTypeDict(this.getTypeDict());
				inst.setPersonIds(this.getPersonIds());
				inst.setAssessmentTpl(this.getAssessmentTpl());
				inst.setButtonAction(this.getButtonAction());
				inst.setExcludePersonList(this.getExcludePersonList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}