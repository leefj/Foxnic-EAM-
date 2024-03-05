package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentTaskDtl;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentIndicator;
import java.util.List;
import com.dt.platform.domain.hr.Position;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-02 16:13:18
 * @sign 062877CB0E2C53AA738542063CFC4257
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentTaskDtlMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSEE_ID="assesseeId";
	
	/**
	 * 被考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> ASSESSEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,ASSESSEE_ID, java.lang.String.class, "被考核人", "被考核人", java.lang.String.class, null);
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final String ASSESSOR_ID="assessorId";
	
	/**
	 * 考核人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> ASSESSOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,ASSESSOR_ID, java.lang.String.class, "考核人", "考核人", java.lang.String.class, null);
	
	/**
	 * 得分 , 类型: java.math.BigDecimal
	*/
	public static final String SCORE_VALUE="scoreValue";
	
	/**
	 * 得分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.math.BigDecimal> SCORE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,SCORE_VALUE, java.math.BigDecimal.class, "得分", "得分", java.math.BigDecimal.class, null);
	
	/**
	 * 综合评价 , 类型: java.lang.String
	*/
	public static final String EVALUATE_CONTENT="evaluateContent";
	
	/**
	 * 综合评价 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> EVALUATE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,EVALUATE_CONTENT, java.lang.String.class, "综合评价", "综合评价", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,RCD_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * assessmentIndicator , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final String ASSESSMENT_INDICATOR="assessmentIndicator";
	
	/**
	 * assessmentIndicator , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,com.dt.platform.domain.hr.AssessmentIndicator> ASSESSMENT_INDICATOR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,ASSESSMENT_INDICATOR, java.util.List.class, "assessmentIndicator", "assessmentIndicator", com.dt.platform.domain.hr.AssessmentIndicator.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * positionList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final String POSITION_LIST="positionList";
	
	/**
	 * positionList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,com.dt.platform.domain.hr.Position> POSITION_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,POSITION_LIST, java.util.List.class, "positionList", "positionList", com.dt.platform.domain.hr.Position.class, null);
	
	/**
	 * positionIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * positionIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentTaskDtl,java.lang.String> POSITION_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentTaskDtl.class ,POSITION_IDS, java.util.List.class, "positionIds", "positionIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , STATUS , ASSESSEE_ID , ASSESSOR_ID , SCORE_VALUE , EVALUATE_CONTENT , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSESSMENT_INDICATOR , SELECTED_CODE , POSITION_LIST , POSITION_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentTaskDtl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param taskId 任务
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 被考核人
		 * @param assesseeId 被考核人
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setAssesseeId(String assesseeId) {
			super.change(ASSESSEE_ID,super.getAssesseeId(),assesseeId);
			super.setAssesseeId(assesseeId);
			return this;
		}
		
		/**
		 * 设置 考核人
		 * @param assessorId 考核人
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setAssessorId(String assessorId) {
			super.change(ASSESSOR_ID,super.getAssessorId(),assessorId);
			super.setAssessorId(assessorId);
			return this;
		}
		
		/**
		 * 设置 得分
		 * @param scoreValue 得分
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setScoreValue(BigDecimal scoreValue) {
			super.change(SCORE_VALUE,super.getScoreValue(),scoreValue);
			super.setScoreValue(scoreValue);
			return this;
		}
		
		/**
		 * 设置 综合评价
		 * @param evaluateContent 综合评价
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setEvaluateContent(String evaluateContent) {
			super.change(EVALUATE_CONTENT,super.getEvaluateContent(),evaluateContent);
			super.setEvaluateContent(evaluateContent);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param rcdTime 操作时间
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 assessmentIndicator
		 * @param assessmentIndicator assessmentIndicator
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setAssessmentIndicator(List<AssessmentIndicator> assessmentIndicator) {
			super.change(ASSESSMENT_INDICATOR,super.getAssessmentIndicator(),assessmentIndicator);
			super.setAssessmentIndicator(assessmentIndicator);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 positionList
		 * @param positionList positionList
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setPositionList(List<Position> positionList) {
			super.change(POSITION_LIST,super.getPositionList(),positionList);
			super.setPositionList(positionList);
			return this;
		}
		
		/**
		 * 设置 positionIds
		 * @param positionIds positionIds
		 * @return 当前对象
		*/
		public AssessmentTaskDtl setPositionIds(List<String> positionIds) {
			super.change(POSITION_IDS,super.getPositionIds(),positionIds);
			super.setPositionIds(positionIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentTaskDtl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentTaskDtl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setEvaluateContent(this.getEvaluateContent());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setAssesseeId(this.getAssesseeId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssessorId(this.getAssessorId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			inst.setScoreValue(this.getScoreValue());
			inst.setRcdTime(this.getRcdTime());
			if(all) {
				inst.setPositionIds(this.getPositionIds());
				inst.setPositionList(this.getPositionList());
				inst.setSelectedCode(this.getSelectedCode());
				inst.setAssessmentIndicator(this.getAssessmentIndicator());
			}
			inst.clearModifies();
			return inst;
		}

	}
}