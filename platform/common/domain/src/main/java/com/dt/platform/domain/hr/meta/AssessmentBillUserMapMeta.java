package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentBillUserMap;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentTask;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.dt.platform.domain.hr.AssessmentBillTask;
import com.dt.platform.domain.hr.AssessmentBillTaskPaper;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-16 19:51:39
 * @sign 1D2C501277C137B24F46D65AEC1637F5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentBillUserMapMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> BILL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,BILL_ID, java.lang.String.class, "单据", "单据", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,ORG_ID, java.lang.String.class, "部门", "部门", java.lang.String.class, null);
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSEE_ID="assesseeId";
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> ASSESSEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,ASSESSEE_ID, java.lang.String.class, "被考核人", "被考核人", java.lang.String.class, null);
	
	/**
	 * 直属领导 , 类型: java.lang.String
	*/
	public static final String LEADER_ID="leaderId";
	
	/**
	 * 直属领导 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> LEADER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_ID, java.lang.String.class, "直属领导", "直属领导", java.lang.String.class, null);
	
	/**
	 * 上上级领导 , 类型: java.lang.String
	*/
	public static final String SECOND_LEADER_ID="secondLeaderId";
	
	/**
	 * 上上级领导 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SECOND_LEADER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_ID, java.lang.String.class, "上上级领导", "上上级领导", java.lang.String.class, null);
	
	/**
	 * HR复核人 , 类型: java.lang.String
	*/
	public static final String HR_USER_ID="hrUserId";
	
	/**
	 * HR复核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> HR_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,HR_USER_ID, java.lang.String.class, "HR复核人", "HR复核人", java.lang.String.class, null);
	
	/**
	 * 自评分 , 类型: java.math.BigDecimal
	*/
	public static final String SELF_SCORE="selfScore";
	
	/**
	 * 自评分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.math.BigDecimal> SELF_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SELF_SCORE, java.math.BigDecimal.class, "自评分", "自评分", java.math.BigDecimal.class, null);
	
	/**
	 * 互评分 , 类型: java.math.BigDecimal
	*/
	public static final String SAME_SCORE="sameScore";
	
	/**
	 * 互评分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.math.BigDecimal> SAME_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_SCORE, java.math.BigDecimal.class, "互评分", "互评分", java.math.BigDecimal.class, null);
	
	/**
	 * 直属领导评分 , 类型: java.math.BigDecimal
	*/
	public static final String LEADER_SCORE="leaderScore";
	
	/**
	 * 直属领导评分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.math.BigDecimal> LEADER_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_SCORE, java.math.BigDecimal.class, "直属领导评分", "直属领导评分", java.math.BigDecimal.class, null);
	
	/**
	 * 上上级别领导评分 , 类型: java.math.BigDecimal
	*/
	public static final String SECOND_LEADER_SCORE="secondLeaderScore";
	
	/**
	 * 上上级别领导评分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.math.BigDecimal> SECOND_LEADER_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_SCORE, java.math.BigDecimal.class, "上上级别领导评分", "上上级别领导评分", java.math.BigDecimal.class, null);
	
	/**
	 * 复核情况 , 类型: java.lang.String
	*/
	public static final String IS_CONFIRM="isConfirm";
	
	/**
	 * 复核情况 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> IS_CONFIRM_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,IS_CONFIRM, java.lang.String.class, "复核情况", "复核情况", java.lang.String.class, null);
	
	/**
	 * 生成状态 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 生成状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,RESULT, java.lang.String.class, "生成状态", "生成状态", java.lang.String.class, null);
	
	/**
	 * 生成结果 , 类型: java.lang.String
	*/
	public static final String MESSAGE="message";
	
	/**
	 * 生成结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> MESSAGE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,MESSAGE, java.lang.String.class, "生成结果", "生成结果", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final String ASSESSMENT_TASK="assessmentTask";
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentTask> ASSESSMENT_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,ASSESSMENT_TASK, com.dt.platform.domain.hr.AssessmentTask.class, "assessmentTask", "assessmentTask", com.dt.platform.domain.hr.AssessmentTask.class, null);
	
	/**
	 * assesseeUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ASSESSEE_USER="assesseeUser";
	
	/**
	 * assesseeUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> ASSESSEE_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,ASSESSEE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "assesseeUser", "assesseeUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SAME_USER_LIST="sameUserList";
	
	/**
	 * sameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> SAME_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_LIST, java.util.List.class, "sameUserList", "sameUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SAME_USER_IDS="sameUserIds";
	
	/**
	 * sameUserIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SAME_USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_IDS, java.util.List.class, "sameUserIds", "sameUserIds", java.lang.String.class, null);
	
	/**
	 * leaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String LEADER_USER="leaderUser";
	
	/**
	 * leaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> LEADER_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "leaderUser", "leaderUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * secondLeaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SECOND_LEADER_USER="secondLeaderUser";
	
	/**
	 * secondLeaderUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> SECOND_LEADER_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "secondLeaderUser", "secondLeaderUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * hrUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String HR_USER="hrUser";
	
	/**
	 * hrUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> HR_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,HR_USER, org.github.foxnic.web.domain.hrm.Employee.class, "hrUser", "hrUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserListRel , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SAME_USER_LIST_REL="sameUserListRel";
	
	/**
	 * sameUserListRel , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> SAME_USER_LIST_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_LIST_REL, java.util.List.class, "sameUserListRel", "sameUserListRel", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * sameUserIdsRel , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SAME_USER_IDS_REL="sameUserIdsRel";
	
	/**
	 * sameUserIdsRel , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SAME_USER_IDS_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_IDS_REL, java.util.List.class, "sameUserIdsRel", "sameUserIdsRel", java.lang.String.class, null);
	
	/**
	 * leaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String LEADER_USER_REL="leaderUserRel";
	
	/**
	 * leaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> LEADER_USER_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_USER_REL, org.github.foxnic.web.domain.hrm.Employee.class, "leaderUserRel", "leaderUserRel", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * leaderUserIdRel , 类型: java.lang.String
	*/
	public static final String LEADER_USER_ID_REL="leaderUserIdRel";
	
	/**
	 * leaderUserIdRel , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> LEADER_USER_ID_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_USER_ID_REL, java.lang.String.class, "leaderUserIdRel", "leaderUserIdRel", java.lang.String.class, null);
	
	/**
	 * secondLeaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SECOND_LEADER_USER_REL="secondLeaderUserRel";
	
	/**
	 * secondLeaderUserRel , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,org.github.foxnic.web.domain.hrm.Employee> SECOND_LEADER_USER_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_USER_REL, org.github.foxnic.web.domain.hrm.Employee.class, "secondLeaderUserRel", "secondLeaderUserRel", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * secondLeaderUserIdRel , 类型: java.lang.String
	*/
	public static final String SECOND_LEADER_USER_ID_REL="secondLeaderUserIdRel";
	
	/**
	 * secondLeaderUserIdRel , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SECOND_LEADER_USER_ID_REL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_USER_ID_REL, java.lang.String.class, "secondLeaderUserIdRel", "secondLeaderUserIdRel", java.lang.String.class, null);
	
	/**
	 * assessmentBillTaskList , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final String ASSESSMENT_BILL_TASK_LIST="assessmentBillTaskList";
	
	/**
	 * assessmentBillTaskList , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentBillTask> ASSESSMENT_BILL_TASK_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,ASSESSMENT_BILL_TASK_LIST, com.dt.platform.domain.hr.AssessmentBillTask.class, "assessmentBillTaskList", "assessmentBillTaskList", com.dt.platform.domain.hr.AssessmentBillTask.class, null);
	
	/**
	 * incompletePaper , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final String INCOMPLETE_PAPER="incompletePaper";
	
	/**
	 * incompletePaper , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentBillTaskPaper> INCOMPLETE_PAPER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,INCOMPLETE_PAPER, java.util.List.class, "incompletePaper", "incompletePaper", com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, null);
	
	/**
	 * incompleteSelfPaperCount , 类型: java.lang.String
	*/
	public static final String INCOMPLETE_SELF_PAPER_COUNT="incompleteSelfPaperCount";
	
	/**
	 * incompleteSelfPaperCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> INCOMPLETE_SELF_PAPER_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,INCOMPLETE_SELF_PAPER_COUNT, java.lang.String.class, "incompleteSelfPaperCount", "incompleteSelfPaperCount", java.lang.String.class, null);
	
	/**
	 * incompleteSamePaperCount , 类型: java.lang.String
	*/
	public static final String INCOMPLETE_SAME_PAPER_COUNT="incompleteSamePaperCount";
	
	/**
	 * incompleteSamePaperCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> INCOMPLETE_SAME_PAPER_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,INCOMPLETE_SAME_PAPER_COUNT, java.lang.String.class, "incompleteSamePaperCount", "incompleteSamePaperCount", java.lang.String.class, null);
	
	/**
	 * incompleteLeaderPaperCount , 类型: java.lang.String
	*/
	public static final String INCOMPLETE_LEADER_PAPER_COUNT="incompleteLeaderPaperCount";
	
	/**
	 * incompleteLeaderPaperCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> INCOMPLETE_LEADER_PAPER_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,INCOMPLETE_LEADER_PAPER_COUNT, java.lang.String.class, "incompleteLeaderPaperCount", "incompleteLeaderPaperCount", java.lang.String.class, null);
	
	/**
	 * incompleteSecondLeaderPaperCount , 类型: java.lang.String
	*/
	public static final String INCOMPLETE_SECOND_LEADER_PAPER_COUNT="incompleteSecondLeaderPaperCount";
	
	/**
	 * incompleteSecondLeaderPaperCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> INCOMPLETE_SECOND_LEADER_PAPER_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,INCOMPLETE_SECOND_LEADER_PAPER_COUNT, java.lang.String.class, "incompleteSecondLeaderPaperCount", "incompleteSecondLeaderPaperCount", java.lang.String.class, null);
	
	/**
	 * selfScorePaper , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final String SELF_SCORE_PAPER="selfScorePaper";
	
	/**
	 * selfScorePaper , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentBillTaskPaper> SELF_SCORE_PAPER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SELF_SCORE_PAPER, com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, "selfScorePaper", "selfScorePaper", com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, null);
	
	/**
	 * sameScorePaperList , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final String SAME_SCORE_PAPER_LIST="sameScorePaperList";
	
	/**
	 * sameScorePaperList , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentBillTaskPaper> SAME_SCORE_PAPER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_SCORE_PAPER_LIST, com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, "sameScorePaperList", "sameScorePaperList", com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, null);
	
	/**
	 * leaderScorePaper , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final String LEADER_SCORE_PAPER="leaderScorePaper";
	
	/**
	 * leaderScorePaper , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentBillTaskPaper> LEADER_SCORE_PAPER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_SCORE_PAPER, com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, "leaderScorePaper", "leaderScorePaper", com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, null);
	
	/**
	 * secondLeaderScorePaper , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final String SECOND_LEADER_SCORE_PAPER="secondLeaderScorePaper";
	
	/**
	 * secondLeaderScorePaper , 类型: com.dt.platform.domain.hr.AssessmentBillTaskPaper
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,com.dt.platform.domain.hr.AssessmentBillTaskPaper> SECOND_LEADER_SCORE_PAPER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_SCORE_PAPER, com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, "secondLeaderScorePaper", "secondLeaderScorePaper", com.dt.platform.domain.hr.AssessmentBillTaskPaper.class, null);
	
	/**
	 * sameUserAvgScoreValue , 类型: java.lang.String
	*/
	public static final String SAME_USER_AVG_SCORE_VALUE="sameUserAvgScoreValue";
	
	/**
	 * sameUserAvgScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SAME_USER_AVG_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_AVG_SCORE_VALUE, java.lang.String.class, "sameUserAvgScoreValue", "sameUserAvgScoreValue", java.lang.String.class, null);
	
	/**
	 * sameUserNeedCount , 类型: java.lang.String
	*/
	public static final String SAME_USER_NEED_COUNT="sameUserNeedCount";
	
	/**
	 * sameUserNeedCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SAME_USER_NEED_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_NEED_COUNT, java.lang.String.class, "sameUserNeedCount", "sameUserNeedCount", java.lang.String.class, null);
	
	/**
	 * sameUserFinishCount , 类型: java.lang.String
	*/
	public static final String SAME_USER_FINISH_COUNT="sameUserFinishCount";
	
	/**
	 * sameUserFinishCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SAME_USER_FINISH_COUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_USER_FINISH_COUNT, java.lang.String.class, "sameUserFinishCount", "sameUserFinishCount", java.lang.String.class, null);
	
	/**
	 * sameScoreValue , 类型: java.lang.String
	*/
	public static final String SAME_SCORE_VALUE="sameScoreValue";
	
	/**
	 * sameScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SAME_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SAME_SCORE_VALUE, java.lang.String.class, "sameScoreValue", "sameScoreValue", java.lang.String.class, null);
	
	/**
	 * selfScoreValue , 类型: java.lang.String
	*/
	public static final String SELF_SCORE_VALUE="selfScoreValue";
	
	/**
	 * selfScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SELF_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SELF_SCORE_VALUE, java.lang.String.class, "selfScoreValue", "selfScoreValue", java.lang.String.class, null);
	
	/**
	 * leaderScoreValue , sameUserScoreValue , 类型: java.lang.String
	*/
	public static final String LEADER_SCORE_VALUE="leaderScoreValue";
	
	/**
	 * leaderScoreValue , sameUserScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> LEADER_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,LEADER_SCORE_VALUE, java.lang.String.class, "leaderScoreValue", "sameUserScoreValue", java.lang.String.class, null);
	
	/**
	 * secondLeaderScoreValue , 类型: java.lang.String
	*/
	public static final String SECOND_LEADER_SCORE_VALUE="secondLeaderScoreValue";
	
	/**
	 * secondLeaderScoreValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> SECOND_LEADER_SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,SECOND_LEADER_SCORE_VALUE, java.lang.String.class, "secondLeaderScoreValue", "secondLeaderScoreValue", java.lang.String.class, null);
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final String S_ORG_ID="sOrgId";
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillUserMap,java.lang.String> S_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillUserMap.class ,S_ORG_ID, java.lang.String.class, "sOrgId", "sOrgId", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BILL_ID , STATUS , ORG_ID , ASSESSEE_ID , LEADER_ID , SECOND_LEADER_ID , HR_USER_ID , SELF_SCORE , SAME_SCORE , LEADER_SCORE , SECOND_LEADER_SCORE , IS_CONFIRM , RESULT , MESSAGE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSESSMENT_TASK , ASSESSEE_USER , SAME_USER_LIST , SAME_USER_IDS , LEADER_USER , SECOND_LEADER_USER , HR_USER , SAME_USER_LIST_REL , SAME_USER_IDS_REL , LEADER_USER_REL , LEADER_USER_ID_REL , SECOND_LEADER_USER_REL , SECOND_LEADER_USER_ID_REL , ASSESSMENT_BILL_TASK_LIST , INCOMPLETE_PAPER , INCOMPLETE_SELF_PAPER_COUNT , INCOMPLETE_SAME_PAPER_COUNT , INCOMPLETE_LEADER_PAPER_COUNT , INCOMPLETE_SECOND_LEADER_PAPER_COUNT , SELF_SCORE_PAPER , SAME_SCORE_PAPER_LIST , LEADER_SCORE_PAPER , SECOND_LEADER_SCORE_PAPER , SAME_USER_AVG_SCORE_VALUE , SAME_USER_NEED_COUNT , SAME_USER_FINISH_COUNT , SAME_SCORE_VALUE , SELF_SCORE_VALUE , LEADER_SCORE_VALUE , SECOND_LEADER_SCORE_VALUE , S_ORG_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentBillUserMap {

		private static final long serialVersionUID = 1L;

		
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
		 * 设置 自评分
		 * @param selfScore 自评分
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSelfScore(BigDecimal selfScore) {
			super.change(SELF_SCORE,super.getSelfScore(),selfScore);
			super.setSelfScore(selfScore);
			return this;
		}
		
		/**
		 * 设置 互评分
		 * @param sameScore 互评分
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameScore(BigDecimal sameScore) {
			super.change(SAME_SCORE,super.getSameScore(),sameScore);
			super.setSameScore(sameScore);
			return this;
		}
		
		/**
		 * 设置 直属领导评分
		 * @param leaderScore 直属领导评分
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderScore(BigDecimal leaderScore) {
			super.change(LEADER_SCORE,super.getLeaderScore(),leaderScore);
			super.setLeaderScore(leaderScore);
			return this;
		}
		
		/**
		 * 设置 上上级别领导评分
		 * @param secondLeaderScore 上上级别领导评分
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderScore(BigDecimal secondLeaderScore) {
			super.change(SECOND_LEADER_SCORE,super.getSecondLeaderScore(),secondLeaderScore);
			super.setSecondLeaderScore(secondLeaderScore);
			return this;
		}
		
		/**
		 * 设置 复核情况
		 * @param isConfirm 复核情况
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIsConfirm(String isConfirm) {
			super.change(IS_CONFIRM,super.getIsConfirm(),isConfirm);
			super.setIsConfirm(isConfirm);
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
		 * 设置 incompletePaper
		 * @param incompletePaper incompletePaper
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIncompletePaper(List<AssessmentBillTaskPaper> incompletePaper) {
			super.change(INCOMPLETE_PAPER,super.getIncompletePaper(),incompletePaper);
			super.setIncompletePaper(incompletePaper);
			return this;
		}
		
		/**
		 * 设置 incompleteSelfPaperCount
		 * @param incompleteSelfPaperCount incompleteSelfPaperCount
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIncompleteSelfPaperCount(String incompleteSelfPaperCount) {
			super.change(INCOMPLETE_SELF_PAPER_COUNT,super.getIncompleteSelfPaperCount(),incompleteSelfPaperCount);
			super.setIncompleteSelfPaperCount(incompleteSelfPaperCount);
			return this;
		}
		
		/**
		 * 设置 incompleteSamePaperCount
		 * @param incompleteSamePaperCount incompleteSamePaperCount
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIncompleteSamePaperCount(String incompleteSamePaperCount) {
			super.change(INCOMPLETE_SAME_PAPER_COUNT,super.getIncompleteSamePaperCount(),incompleteSamePaperCount);
			super.setIncompleteSamePaperCount(incompleteSamePaperCount);
			return this;
		}
		
		/**
		 * 设置 incompleteLeaderPaperCount
		 * @param incompleteLeaderPaperCount incompleteLeaderPaperCount
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIncompleteLeaderPaperCount(String incompleteLeaderPaperCount) {
			super.change(INCOMPLETE_LEADER_PAPER_COUNT,super.getIncompleteLeaderPaperCount(),incompleteLeaderPaperCount);
			super.setIncompleteLeaderPaperCount(incompleteLeaderPaperCount);
			return this;
		}
		
		/**
		 * 设置 incompleteSecondLeaderPaperCount
		 * @param incompleteSecondLeaderPaperCount incompleteSecondLeaderPaperCount
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setIncompleteSecondLeaderPaperCount(String incompleteSecondLeaderPaperCount) {
			super.change(INCOMPLETE_SECOND_LEADER_PAPER_COUNT,super.getIncompleteSecondLeaderPaperCount(),incompleteSecondLeaderPaperCount);
			super.setIncompleteSecondLeaderPaperCount(incompleteSecondLeaderPaperCount);
			return this;
		}
		
		/**
		 * 设置 selfScorePaper
		 * @param selfScorePaper selfScorePaper
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSelfScorePaper(AssessmentBillTaskPaper selfScorePaper) {
			super.change(SELF_SCORE_PAPER,super.getSelfScorePaper(),selfScorePaper);
			super.setSelfScorePaper(selfScorePaper);
			return this;
		}
		
		/**
		 * 设置 sameScorePaperList
		 * @param sameScorePaperList sameScorePaperList
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameScorePaperList(AssessmentBillTaskPaper sameScorePaperList) {
			super.change(SAME_SCORE_PAPER_LIST,super.getSameScorePaperList(),sameScorePaperList);
			super.setSameScorePaperList(sameScorePaperList);
			return this;
		}
		
		/**
		 * 设置 leaderScorePaper
		 * @param leaderScorePaper leaderScorePaper
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setLeaderScorePaper(AssessmentBillTaskPaper leaderScorePaper) {
			super.change(LEADER_SCORE_PAPER,super.getLeaderScorePaper(),leaderScorePaper);
			super.setLeaderScorePaper(leaderScorePaper);
			return this;
		}
		
		/**
		 * 设置 secondLeaderScorePaper
		 * @param secondLeaderScorePaper secondLeaderScorePaper
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSecondLeaderScorePaper(AssessmentBillTaskPaper secondLeaderScorePaper) {
			super.change(SECOND_LEADER_SCORE_PAPER,super.getSecondLeaderScorePaper(),secondLeaderScorePaper);
			super.setSecondLeaderScorePaper(secondLeaderScorePaper);
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
		 * 设置 sameScoreValue
		 * @param sameScoreValue sameScoreValue
		 * @return 当前对象
		*/
		public AssessmentBillUserMap setSameScoreValue(String sameScoreValue) {
			super.change(SAME_SCORE_VALUE,super.getSameScoreValue(),sameScoreValue);
			super.setSameScoreValue(sameScoreValue);
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
		public AssessmentBillUserMap clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentBillUserMap duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setHrUserId(this.getHrUserId());
			inst.setSelfScore(this.getSelfScore());
			inst.setSecondLeaderScore(this.getSecondLeaderScore());
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
			inst.setIsConfirm(this.getIsConfirm());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setBillId(this.getBillId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSameScore(this.getSameScore());
			inst.setStatus(this.getStatus());
			inst.setLeaderScore(this.getLeaderScore());
			if(all) {
				inst.setAssesseeUser(this.getAssesseeUser());
				inst.setSelfScorePaper(this.getSelfScorePaper());
				inst.setSameUserNeedCount(this.getSameUserNeedCount());
				inst.setSameUserFinishCount(this.getSameUserFinishCount());
				inst.setIncompleteSecondLeaderPaperCount(this.getIncompleteSecondLeaderPaperCount());
				inst.setSecondLeaderUserRel(this.getSecondLeaderUserRel());
				inst.setLeaderUserIdRel(this.getLeaderUserIdRel());
				inst.setSameScoreValue(this.getSameScoreValue());
				inst.setHrUser(this.getHrUser());
				inst.setSameUserIdsRel(this.getSameUserIdsRel());
				inst.setSecondLeaderScorePaper(this.getSecondLeaderScorePaper());
				inst.setSameUserIds(this.getSameUserIds());
				inst.setAssessmentBillTaskList(this.getAssessmentBillTaskList());
				inst.setLeaderScoreValue(this.getLeaderScoreValue());
				inst.setIncompleteSamePaperCount(this.getIncompleteSamePaperCount());
				inst.setLeaderScorePaper(this.getLeaderScorePaper());
				inst.setSecondLeaderScoreValue(this.getSecondLeaderScoreValue());
				inst.setSameUserList(this.getSameUserList());
				inst.setSameUserAvgScoreValue(this.getSameUserAvgScoreValue());
				inst.setSecondLeaderUser(this.getSecondLeaderUser());
				inst.setSOrgId(this.getSOrgId());
				inst.setLeaderUserRel(this.getLeaderUserRel());
				inst.setSecondLeaderUserIdRel(this.getSecondLeaderUserIdRel());
				inst.setSameScorePaperList(this.getSameScorePaperList());
				inst.setIncompleteLeaderPaperCount(this.getIncompleteLeaderPaperCount());
				inst.setLeaderUser(this.getLeaderUser());
				inst.setSameUserListRel(this.getSameUserListRel());
				inst.setIncompleteSelfPaperCount(this.getIncompleteSelfPaperCount());
				inst.setIncompletePaper(this.getIncompletePaper());
				inst.setAssessmentTask(this.getAssessmentTask());
				inst.setSelfScoreValue(this.getSelfScoreValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}