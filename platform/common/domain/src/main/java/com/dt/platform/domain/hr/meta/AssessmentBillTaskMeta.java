package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentBillTask;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.hr.AssessmentTask;
import java.util.List;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentBillTaskDtl;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 13:15:01
 * @sign 40D0C176B40BE2F942BC14CDB7D72026
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentBillTaskMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> BILL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,BILL_ID, java.lang.String.class, "单据", "单据", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSOR_ID="assessorId";
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> ASSESSOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ASSESSOR_ID, java.lang.String.class, "考核人", "考核人", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,RCD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final String S_ORG_ID="sOrgId";
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> S_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,S_ORG_ID, java.lang.String.class, "sOrgId", "sOrgId", java.lang.String.class, null);
	
	/**
	 * assessor , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ASSESSOR="assessor";
	
	/**
	 * assessor , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,org.github.foxnic.web.domain.hrm.Employee> ASSESSOR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ASSESSOR, org.github.foxnic.web.domain.hrm.Employee.class, "assessor", "assessor", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final String ASSESSMENT_TASK="assessmentTask";
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,com.dt.platform.domain.hr.AssessmentTask> ASSESSMENT_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ASSESSMENT_TASK, com.dt.platform.domain.hr.AssessmentTask.class, "assessmentTask", "assessmentTask", com.dt.platform.domain.hr.AssessmentTask.class, null);
	
	/**
	 * assessmentDataTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final String ASSESSMENT_DATA_TASK="assessmentDataTask";
	
	/**
	 * assessmentDataTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,com.dt.platform.domain.hr.AssessmentTask> ASSESSMENT_DATA_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ASSESSMENT_DATA_TASK, com.dt.platform.domain.hr.AssessmentTask.class, "assessmentDataTask", "assessmentDataTask", com.dt.platform.domain.hr.AssessmentTask.class, null);
	
	/**
	 * withLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_LEADER_LIST="withLeaderList";
	
	/**
	 * withLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,org.github.foxnic.web.domain.hrm.Employee> WITH_LEADER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,WITH_LEADER_LIST, java.util.List.class, "withLeaderList", "withLeaderList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * withSecondLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_SECOND_LEADER_LIST="withSecondLeaderList";
	
	/**
	 * withSecondLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,org.github.foxnic.web.domain.hrm.Employee> WITH_SECOND_LEADER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,WITH_SECOND_LEADER_LIST, java.util.List.class, "withSecondLeaderList", "withSecondLeaderList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * withSameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_SAME_USER_LIST="withSameUserList";
	
	/**
	 * withSameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,org.github.foxnic.web.domain.hrm.Employee> WITH_SAME_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,WITH_SAME_USER_LIST, java.util.List.class, "withSameUserList", "withSameUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * assessmentBill , 类型: com.dt.platform.domain.hr.AssessmentBill
	*/
	public static final String ASSESSMENT_BILL="assessmentBill";
	
	/**
	 * assessmentBill , 类型: com.dt.platform.domain.hr.AssessmentBill
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,com.dt.platform.domain.hr.AssessmentBill> ASSESSMENT_BILL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ASSESSMENT_BILL, com.dt.platform.domain.hr.AssessmentBill.class, "assessmentBill", "assessmentBill", com.dt.platform.domain.hr.AssessmentBill.class, null);
	
	/**
	 * nameStr , 类型: java.lang.String
	*/
	public static final String NAME_STR="nameStr";
	
	/**
	 * nameStr , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> NAME_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,NAME_STR, java.lang.String.class, "nameStr", "nameStr", java.lang.String.class, null);
	
	/**
	 * stimeStr , 类型: java.lang.String
	*/
	public static final String STIME_STR="stimeStr";
	
	/**
	 * stimeStr , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> STIME_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,STIME_STR, java.lang.String.class, "stimeStr", "stimeStr", java.lang.String.class, null);
	
	/**
	 * etimeStr , 类型: java.lang.String
	*/
	public static final String ETIME_STR="etimeStr";
	
	/**
	 * etimeStr , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> ETIME_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ETIME_STR, java.lang.String.class, "etimeStr", "etimeStr", java.lang.String.class, null);
	
	/**
	 * sRole , 类型: java.lang.String
	*/
	public static final String S_ROLE="sRole";
	
	/**
	 * sRole , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,java.lang.String> S_ROLE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,S_ROLE, java.lang.String.class, "sRole", "sRole", java.lang.String.class, null);
	
	/**
	 * assessmentBillTaskDtlList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentBillTaskDtl
	*/
	public static final String ASSESSMENT_BILL_TASK_DTL_LIST="assessmentBillTaskDtlList";
	
	/**
	 * assessmentBillTaskDtlList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentBillTaskDtl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTask,com.dt.platform.domain.hr.AssessmentBillTaskDtl> ASSESSMENT_BILL_TASK_DTL_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTask.class ,ASSESSMENT_BILL_TASK_DTL_LIST, java.util.List.class, "assessmentBillTaskDtlList", "assessmentBillTaskDtlList", com.dt.platform.domain.hr.AssessmentBillTaskDtl.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BILL_ID , NAME , ASSESSOR_ID , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , S_ORG_ID , ASSESSOR , ASSESSMENT_TASK , ASSESSMENT_DATA_TASK , WITH_LEADER_LIST , WITH_SECOND_LEADER_LIST , WITH_SAME_USER_LIST , ASSESSMENT_BILL , NAME_STR , STIME_STR , ETIME_STR , S_ROLE , ASSESSMENT_BILL_TASK_DTL_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentBillTask {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentBillTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 单据
		 * @param billId 单据
		 * @return 当前对象
		*/
		public AssessmentBillTask setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AssessmentBillTask setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 考核人
		 * @param assessorId 考核人
		 * @return 当前对象
		*/
		public AssessmentBillTask setAssessorId(String assessorId) {
			super.change(ASSESSOR_ID,super.getAssessorId(),assessorId);
			super.setAssessorId(assessorId);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param rcdTime 记录时间
		 * @return 当前对象
		*/
		public AssessmentBillTask setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentBillTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentBillTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentBillTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentBillTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentBillTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentBillTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentBillTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentBillTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentBillTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 sOrgId
		 * @param sOrgId sOrgId
		 * @return 当前对象
		*/
		public AssessmentBillTask setSOrgId(String sOrgId) {
			super.change(S_ORG_ID,super.getSOrgId(),sOrgId);
			super.setSOrgId(sOrgId);
			return this;
		}
		
		/**
		 * 设置 assessor
		 * @param assessor assessor
		 * @return 当前对象
		*/
		public AssessmentBillTask setAssessor(Employee assessor) {
			super.change(ASSESSOR,super.getAssessor(),assessor);
			super.setAssessor(assessor);
			return this;
		}
		
		/**
		 * 设置 assessmentTask
		 * @param assessmentTask assessmentTask
		 * @return 当前对象
		*/
		public AssessmentBillTask setAssessmentTask(AssessmentTask assessmentTask) {
			super.change(ASSESSMENT_TASK,super.getAssessmentTask(),assessmentTask);
			super.setAssessmentTask(assessmentTask);
			return this;
		}
		
		/**
		 * 设置 assessmentDataTask
		 * @param assessmentDataTask assessmentDataTask
		 * @return 当前对象
		*/
		public AssessmentBillTask setAssessmentDataTask(AssessmentTask assessmentDataTask) {
			super.change(ASSESSMENT_DATA_TASK,super.getAssessmentDataTask(),assessmentDataTask);
			super.setAssessmentDataTask(assessmentDataTask);
			return this;
		}
		
		/**
		 * 设置 withLeaderList
		 * @param withLeaderList withLeaderList
		 * @return 当前对象
		*/
		public AssessmentBillTask setWithLeaderList(List<Employee> withLeaderList) {
			super.change(WITH_LEADER_LIST,super.getWithLeaderList(),withLeaderList);
			super.setWithLeaderList(withLeaderList);
			return this;
		}
		
		/**
		 * 设置 withSecondLeaderList
		 * @param withSecondLeaderList withSecondLeaderList
		 * @return 当前对象
		*/
		public AssessmentBillTask setWithSecondLeaderList(List<Employee> withSecondLeaderList) {
			super.change(WITH_SECOND_LEADER_LIST,super.getWithSecondLeaderList(),withSecondLeaderList);
			super.setWithSecondLeaderList(withSecondLeaderList);
			return this;
		}
		
		/**
		 * 设置 withSameUserList
		 * @param withSameUserList withSameUserList
		 * @return 当前对象
		*/
		public AssessmentBillTask setWithSameUserList(List<Employee> withSameUserList) {
			super.change(WITH_SAME_USER_LIST,super.getWithSameUserList(),withSameUserList);
			super.setWithSameUserList(withSameUserList);
			return this;
		}
		
		/**
		 * 设置 assessmentBill
		 * @param assessmentBill assessmentBill
		 * @return 当前对象
		*/
		public AssessmentBillTask setAssessmentBill(AssessmentBill assessmentBill) {
			super.change(ASSESSMENT_BILL,super.getAssessmentBill(),assessmentBill);
			super.setAssessmentBill(assessmentBill);
			return this;
		}
		
		/**
		 * 设置 nameStr
		 * @param nameStr nameStr
		 * @return 当前对象
		*/
		public AssessmentBillTask setNameStr(String nameStr) {
			super.change(NAME_STR,super.getNameStr(),nameStr);
			super.setNameStr(nameStr);
			return this;
		}
		
		/**
		 * 设置 stimeStr
		 * @param stimeStr stimeStr
		 * @return 当前对象
		*/
		public AssessmentBillTask setStimeStr(String stimeStr) {
			super.change(STIME_STR,super.getStimeStr(),stimeStr);
			super.setStimeStr(stimeStr);
			return this;
		}
		
		/**
		 * 设置 etimeStr
		 * @param etimeStr etimeStr
		 * @return 当前对象
		*/
		public AssessmentBillTask setEtimeStr(String etimeStr) {
			super.change(ETIME_STR,super.getEtimeStr(),etimeStr);
			super.setEtimeStr(etimeStr);
			return this;
		}
		
		/**
		 * 设置 sRole
		 * @param sRole sRole
		 * @return 当前对象
		*/
		public AssessmentBillTask setSRole(String sRole) {
			super.change(S_ROLE,super.getSRole(),sRole);
			super.setSRole(sRole);
			return this;
		}
		
		/**
		 * 设置 assessmentBillTaskDtlList
		 * @param assessmentBillTaskDtlList assessmentBillTaskDtlList
		 * @return 当前对象
		*/
		public AssessmentBillTask setAssessmentBillTaskDtlList(List<AssessmentBillTaskDtl> assessmentBillTaskDtlList) {
			super.change(ASSESSMENT_BILL_TASK_DTL_LIST,super.getAssessmentBillTaskDtlList(),assessmentBillTaskDtlList);
			super.setAssessmentBillTaskDtlList(assessmentBillTaskDtlList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentBillTask clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentBillTask duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssessorId(this.getAssessorId());
			inst.setBillId(this.getBillId());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setRcdTime(this.getRcdTime());
			if(all) {
				inst.setAssessmentBillTaskDtlList(this.getAssessmentBillTaskDtlList());
				inst.setNameStr(this.getNameStr());
				inst.setAssessor(this.getAssessor());
				inst.setWithSecondLeaderList(this.getWithSecondLeaderList());
				inst.setSOrgId(this.getSOrgId());
				inst.setAssessmentDataTask(this.getAssessmentDataTask());
				inst.setStimeStr(this.getStimeStr());
				inst.setSRole(this.getSRole());
				inst.setWithSameUserList(this.getWithSameUserList());
				inst.setAssessmentTask(this.getAssessmentTask());
				inst.setEtimeStr(this.getEtimeStr());
				inst.setAssessmentBill(this.getAssessmentBill());
				inst.setWithLeaderList(this.getWithLeaderList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}