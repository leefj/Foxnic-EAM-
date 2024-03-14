package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentBillTaskDtl;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentBillTask;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-14 21:33:43
 * @sign 485DADC1467D320F7DFC22833169E46F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentBillTaskDtlMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> BILL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,BILL_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final String BILL_TASK_ID="billTaskId";
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> BILL_TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,BILL_TASK_ID, java.lang.String.class, "单据", "单据", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 考核方式 , 类型: java.lang.String
	*/
	public static final String RELATIONSHIP="relationship";
	
	/**
	 * 考核方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> RELATIONSHIP_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,RELATIONSHIP, java.lang.String.class, "考核方式", "考核方式", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,RCD_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * assessor , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ASSESSOR="assessor";
	
	/**
	 * assessor , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,org.github.foxnic.web.domain.hrm.Employee> ASSESSOR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,ASSESSOR, org.github.foxnic.web.domain.hrm.Employee.class, "assessor", "assessor", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * assessmentBill , 类型: com.dt.platform.domain.hr.AssessmentBill
	*/
	public static final String ASSESSMENT_BILL="assessmentBill";
	
	/**
	 * assessmentBill , 类型: com.dt.platform.domain.hr.AssessmentBill
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,com.dt.platform.domain.hr.AssessmentBill> ASSESSMENT_BILL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,ASSESSMENT_BILL, com.dt.platform.domain.hr.AssessmentBill.class, "assessmentBill", "assessmentBill", com.dt.platform.domain.hr.AssessmentBill.class, null);
	
	/**
	 * AssessmentBillTask , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final String ASSESSMENT_BILL_TASK="AssessmentBillTask";
	
	/**
	 * AssessmentBillTask , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,com.dt.platform.domain.hr.AssessmentBillTask> ASSESSMENT_BILL_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,ASSESSMENT_BILL_TASK, com.dt.platform.domain.hr.AssessmentBillTask.class, "AssessmentBillTask", "AssessmentBillTask", com.dt.platform.domain.hr.AssessmentBillTask.class, null);
	
	/**
	 * assesseeStr , 类型: java.lang.String
	*/
	public static final String ASSESSEE_STR="assesseeStr";
	
	/**
	 * assesseeStr , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> ASSESSEE_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,ASSESSEE_STR, java.lang.String.class, "assesseeStr", "assesseeStr", java.lang.String.class, null);
	
	/**
	 * assessorStr , 类型: java.lang.String
	*/
	public static final String ASSESSOR_STR="assessorStr";
	
	/**
	 * assessorStr , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,java.lang.String> ASSESSOR_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,ASSESSOR_STR, java.lang.String.class, "assessorStr", "assessorStr", java.lang.String.class, null);
	
	/**
	 * withSelfUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_SELF_USER="withSelfUser";
	
	/**
	 * withSelfUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,org.github.foxnic.web.domain.hrm.Employee> WITH_SELF_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,WITH_SELF_USER, org.github.foxnic.web.domain.hrm.Employee.class, "withSelfUser", "withSelfUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * withLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_LEADER_LIST="withLeaderList";
	
	/**
	 * withLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,org.github.foxnic.web.domain.hrm.Employee> WITH_LEADER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,WITH_LEADER_LIST, java.util.List.class, "withLeaderList", "withLeaderList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * withSecondLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_SECOND_LEADER_LIST="withSecondLeaderList";
	
	/**
	 * withSecondLeaderList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,org.github.foxnic.web.domain.hrm.Employee> WITH_SECOND_LEADER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,WITH_SECOND_LEADER_LIST, java.util.List.class, "withSecondLeaderList", "withSecondLeaderList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * withSameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String WITH_SAME_USER_LIST="withSameUserList";
	
	/**
	 * withSameUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskDtl,org.github.foxnic.web.domain.hrm.Employee> WITH_SAME_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskDtl.class ,WITH_SAME_USER_LIST, java.util.List.class, "withSameUserList", "withSameUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BILL_ID , BILL_TASK_ID , STATUS , RELATIONSHIP , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSESSOR , ASSESSMENT_BILL , ASSESSMENT_BILL_TASK , ASSESSEE_STR , ASSESSOR_STR , WITH_SELF_USER , WITH_LEADER_LIST , WITH_SECOND_LEADER_LIST , WITH_SAME_USER_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentBillTaskDtl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param billId 任务
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
		
		/**
		 * 设置 单据
		 * @param billTaskId 单据
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setBillTaskId(String billTaskId) {
			super.change(BILL_TASK_ID,super.getBillTaskId(),billTaskId);
			super.setBillTaskId(billTaskId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 考核方式
		 * @param relationship 考核方式
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setRelationship(String relationship) {
			super.change(RELATIONSHIP,super.getRelationship(),relationship);
			super.setRelationship(relationship);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param rcdTime 操作时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 assessor
		 * @param assessor assessor
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setAssessor(Employee assessor) {
			super.change(ASSESSOR,super.getAssessor(),assessor);
			super.setAssessor(assessor);
			return this;
		}
		
		/**
		 * 设置 assessmentBill
		 * @param assessmentBill assessmentBill
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setAssessmentBill(AssessmentBill assessmentBill) {
			super.change(ASSESSMENT_BILL,super.getAssessmentBill(),assessmentBill);
			super.setAssessmentBill(assessmentBill);
			return this;
		}
		
		/**
		 * 设置 AssessmentBillTask
		 * @param AssessmentBillTask AssessmentBillTask
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setAssessmentBillTask(AssessmentBillTask AssessmentBillTask) {
			super.change(ASSESSMENT_BILL_TASK,super.getAssessmentBillTask(),AssessmentBillTask);
			super.setAssessmentBillTask(AssessmentBillTask);
			return this;
		}
		
		/**
		 * 设置 assesseeStr
		 * @param assesseeStr assesseeStr
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setAssesseeStr(String assesseeStr) {
			super.change(ASSESSEE_STR,super.getAssesseeStr(),assesseeStr);
			super.setAssesseeStr(assesseeStr);
			return this;
		}
		
		/**
		 * 设置 assessorStr
		 * @param assessorStr assessorStr
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setAssessorStr(String assessorStr) {
			super.change(ASSESSOR_STR,super.getAssessorStr(),assessorStr);
			super.setAssessorStr(assessorStr);
			return this;
		}
		
		/**
		 * 设置 withSelfUser
		 * @param withSelfUser withSelfUser
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setWithSelfUser(Employee withSelfUser) {
			super.change(WITH_SELF_USER,super.getWithSelfUser(),withSelfUser);
			super.setWithSelfUser(withSelfUser);
			return this;
		}
		
		/**
		 * 设置 withLeaderList
		 * @param withLeaderList withLeaderList
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setWithLeaderList(List<Employee> withLeaderList) {
			super.change(WITH_LEADER_LIST,super.getWithLeaderList(),withLeaderList);
			super.setWithLeaderList(withLeaderList);
			return this;
		}
		
		/**
		 * 设置 withSecondLeaderList
		 * @param withSecondLeaderList withSecondLeaderList
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setWithSecondLeaderList(List<Employee> withSecondLeaderList) {
			super.change(WITH_SECOND_LEADER_LIST,super.getWithSecondLeaderList(),withSecondLeaderList);
			super.setWithSecondLeaderList(withSecondLeaderList);
			return this;
		}
		
		/**
		 * 设置 withSameUserList
		 * @param withSameUserList withSameUserList
		 * @return 当前对象
		*/
		public AssessmentBillTaskDtl setWithSameUserList(List<Employee> withSameUserList) {
			super.change(WITH_SAME_USER_LIST,super.getWithSameUserList(),withSameUserList);
			super.setWithSameUserList(withSameUserList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentBillTaskDtl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentBillTaskDtl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setBillTaskId(this.getBillTaskId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setBillId(this.getBillId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setRelationship(this.getRelationship());
			inst.setStatus(this.getStatus());
			inst.setRcdTime(this.getRcdTime());
			if(all) {
				inst.setWithSelfUser(this.getWithSelfUser());
				inst.setAssessmentBillTask(this.getAssessmentBillTask());
				inst.setWithSameUserList(this.getWithSameUserList());
				inst.setAssessor(this.getAssessor());
				inst.setWithSecondLeaderList(this.getWithSecondLeaderList());
				inst.setAssessmentBill(this.getAssessmentBill());
				inst.setWithLeaderList(this.getWithLeaderList());
				inst.setAssesseeStr(this.getAssesseeStr());
				inst.setAssessorStr(this.getAssessorStr());
			}
			inst.clearModifies();
			return inst;
		}

	}
}