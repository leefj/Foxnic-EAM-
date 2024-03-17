package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentBillTaskPaper;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import java.util.List;
import com.dt.platform.domain.hr.AssessmentBillTaskDtl;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-16 17:56:37
 * @sign F2D852A149AF59BA9667C0F9583ABA75
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentBillTaskPaperMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String BILL_TASK_DTL_ID="billTaskDtlId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> BILL_TASK_DTL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,BILL_TASK_DTL_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> BILL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,BILL_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String BILL_TASK_ID="billTaskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> BILL_TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,BILL_TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 关系 , 类型: java.lang.String
	*/
	public static final String RELATIONSHIP="relationship";
	
	/**
	 * 关系 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> RELATIONSHIP_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,RELATIONSHIP, java.lang.String.class, "关系", "关系", java.lang.String.class, null);
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSOR_ID="assessorId";
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> ASSESSOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ASSESSOR_ID, java.lang.String.class, "考核人", "考核人", java.lang.String.class, null);
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSEE_ID="assesseeId";
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> ASSESSEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ASSESSEE_ID, java.lang.String.class, "被考核人", "被考核人", java.lang.String.class, null);
	
	/**
	 * 综合得分 , 类型: java.math.BigDecimal
	*/
	public static final String SCORE_VALUE="scoreValue";
	
	/**
	 * 综合得分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.math.BigDecimal> SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,SCORE_VALUE, java.math.BigDecimal.class, "综合得分", "综合得分", java.math.BigDecimal.class, null);
	
	/**
	 * 综合评价 , 类型: java.lang.String
	*/
	public static final String EVALUATE_CONTENT="evaluateContent";
	
	/**
	 * 综合评价 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> EVALUATE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,EVALUATE_CONTENT, java.lang.String.class, "综合评价", "综合评价", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_MAP_ID="userMapId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> USER_MAP_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,USER_MAP_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,CONTENT, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * assessmentIndicatorValueList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String ASSESSMENT_INDICATOR_VALUE_LIST="assessmentIndicatorValueList";
	
	/**
	 * assessmentIndicatorValueList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,com.dt.platform.domain.hr.AssessmentIndicatorValue> ASSESSMENT_INDICATOR_VALUE_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ASSESSMENT_INDICATOR_VALUE_LIST, java.util.List.class, "assessmentIndicatorValueList", "assessmentIndicatorValueList", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * assessmentBillTaskDtl , 类型: com.dt.platform.domain.hr.AssessmentBillTaskDtl
	*/
	public static final String ASSESSMENT_BILL_TASK_DTL="assessmentBillTaskDtl";
	
	/**
	 * assessmentBillTaskDtl , 类型: com.dt.platform.domain.hr.AssessmentBillTaskDtl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,com.dt.platform.domain.hr.AssessmentBillTaskDtl> ASSESSMENT_BILL_TASK_DTL_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ASSESSMENT_BILL_TASK_DTL, com.dt.platform.domain.hr.AssessmentBillTaskDtl.class, "assessmentBillTaskDtl", "assessmentBillTaskDtl", com.dt.platform.domain.hr.AssessmentBillTaskDtl.class, null);
	
	/**
	 * assessee , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ASSESSEE="assessee";
	
	/**
	 * assessee , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,org.github.foxnic.web.domain.hrm.Employee> ASSESSEE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ASSESSEE, org.github.foxnic.web.domain.hrm.Employee.class, "assessee", "assessee", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * assessor , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ASSESSOR="assessor";
	
	/**
	 * assessor , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBillTaskPaper,org.github.foxnic.web.domain.hrm.Employee> ASSESSOR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBillTaskPaper.class ,ASSESSOR, org.github.foxnic.web.domain.hrm.Employee.class, "assessor", "assessor", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BILL_TASK_DTL_ID , BILL_ID , BILL_TASK_ID , RELATIONSHIP , ASSESSOR_ID , ASSESSEE_ID , SCORE_VALUE , EVALUATE_CONTENT , USER_MAP_ID , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSESSMENT_INDICATOR_VALUE_LIST , ASSESSMENT_BILL_TASK_DTL , ASSESSEE , ASSESSOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentBillTaskPaper {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param billTaskDtlId 任务
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setBillTaskDtlId(String billTaskDtlId) {
			super.change(BILL_TASK_DTL_ID,super.getBillTaskDtlId(),billTaskDtlId);
			super.setBillTaskDtlId(billTaskDtlId);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param billId 任务
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param billTaskId 任务
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setBillTaskId(String billTaskId) {
			super.change(BILL_TASK_ID,super.getBillTaskId(),billTaskId);
			super.setBillTaskId(billTaskId);
			return this;
		}
		
		/**
		 * 设置 关系
		 * @param relationship 关系
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setRelationship(String relationship) {
			super.change(RELATIONSHIP,super.getRelationship(),relationship);
			super.setRelationship(relationship);
			return this;
		}
		
		/**
		 * 设置 考核人
		 * @param assessorId 考核人
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setAssessorId(String assessorId) {
			super.change(ASSESSOR_ID,super.getAssessorId(),assessorId);
			super.setAssessorId(assessorId);
			return this;
		}
		
		/**
		 * 设置 被考核人
		 * @param assesseeId 被考核人
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setAssesseeId(String assesseeId) {
			super.change(ASSESSEE_ID,super.getAssesseeId(),assesseeId);
			super.setAssesseeId(assesseeId);
			return this;
		}
		
		/**
		 * 设置 综合得分
		 * @param scoreValue 综合得分
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setScoreValue(BigDecimal scoreValue) {
			super.change(SCORE_VALUE,super.getScoreValue(),scoreValue);
			super.setScoreValue(scoreValue);
			return this;
		}
		
		/**
		 * 设置 综合评价
		 * @param evaluateContent 综合评价
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setEvaluateContent(String evaluateContent) {
			super.change(EVALUATE_CONTENT,super.getEvaluateContent(),evaluateContent);
			super.setEvaluateContent(evaluateContent);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userMapId 用户
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setUserMapId(String userMapId) {
			super.change(USER_MAP_ID,super.getUserMapId(),userMapId);
			super.setUserMapId(userMapId);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param content 说明
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 assessmentIndicatorValueList
		 * @param assessmentIndicatorValueList assessmentIndicatorValueList
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setAssessmentIndicatorValueList(List<AssessmentIndicatorValue> assessmentIndicatorValueList) {
			super.change(ASSESSMENT_INDICATOR_VALUE_LIST,super.getAssessmentIndicatorValueList(),assessmentIndicatorValueList);
			super.setAssessmentIndicatorValueList(assessmentIndicatorValueList);
			return this;
		}
		
		/**
		 * 设置 assessmentBillTaskDtl
		 * @param assessmentBillTaskDtl assessmentBillTaskDtl
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setAssessmentBillTaskDtl(AssessmentBillTaskDtl assessmentBillTaskDtl) {
			super.change(ASSESSMENT_BILL_TASK_DTL,super.getAssessmentBillTaskDtl(),assessmentBillTaskDtl);
			super.setAssessmentBillTaskDtl(assessmentBillTaskDtl);
			return this;
		}
		
		/**
		 * 设置 assessee
		 * @param assessee assessee
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setAssessee(Employee assessee) {
			super.change(ASSESSEE,super.getAssessee(),assessee);
			super.setAssessee(assessee);
			return this;
		}
		
		/**
		 * 设置 assessor
		 * @param assessor assessor
		 * @return 当前对象
		*/
		public AssessmentBillTaskPaper setAssessor(Employee assessor) {
			super.change(ASSESSOR,super.getAssessor(),assessor);
			super.setAssessor(assessor);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentBillTaskPaper clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentBillTaskPaper duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setEvaluateContent(this.getEvaluateContent());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setAssesseeId(this.getAssesseeId());
			inst.setBillTaskDtlId(this.getBillTaskDtlId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setBillTaskId(this.getBillTaskId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssessorId(this.getAssessorId());
			inst.setBillId(this.getBillId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUserMapId(this.getUserMapId());
			inst.setId(this.getId());
			inst.setRelationship(this.getRelationship());
			inst.setScoreValue(this.getScoreValue());
			if(all) {
				inst.setAssessmentIndicatorValueList(this.getAssessmentIndicatorValueList());
				inst.setAssessee(this.getAssessee());
				inst.setAssessor(this.getAssessor());
				inst.setAssessmentBillTaskDtl(this.getAssessmentBillTaskDtl());
			}
			inst.clearModifies();
			return inst;
		}

	}
}