package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentBill;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentTask;
import com.dt.platform.domain.hr.AssessmentBillTask;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 10:56:23
 * @sign C171DFB2B86B882DBDC4D060513F38AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentBillMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 考核 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 考核 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,TASK_ID, java.lang.String.class, "考核", "考核", java.lang.String.class, null);
	
	/**
	 * 考核任务 , 类型: java.lang.String
	*/
	public static final String TASK_DATA_ID="taskDataId";
	
	/**
	 * 考核任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> TASK_DATA_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,TASK_DATA_ID, java.lang.String.class, "考核任务", "考核任务", java.lang.String.class, null);
	
	/**
	 * 考核名称 , 类型: java.lang.String
	*/
	public static final String TASK_NAME="taskName";
	
	/**
	 * 考核名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> TASK_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,TASK_NAME, java.lang.String.class, "考核名称", "考核名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 待下发，考评中，考评结束，取消 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 待下发，考评中，考评结束，取消 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,STATUS, java.lang.String.class, "状态", "待下发，考评中，考评结束，取消", java.lang.String.class, null);
	
	/**
	 * 是否可见 , 类型: java.lang.String
	*/
	public static final String IS_SHOW="isShow";
	
	/**
	 * 是否可见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> IS_SHOW_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,IS_SHOW, java.lang.String.class, "是否可见", "是否可见", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String STIME="stime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.util.Date> STIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,STIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String ETIME="etime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.util.Date> ETIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,ETIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final String ASSESSMENT_TASK="assessmentTask";
	
	/**
	 * assessmentTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,com.dt.platform.domain.hr.AssessmentTask> ASSESSMENT_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,ASSESSMENT_TASK, com.dt.platform.domain.hr.AssessmentTask.class, "assessmentTask", "assessmentTask", com.dt.platform.domain.hr.AssessmentTask.class, null);
	
	/**
	 * assessmentDataTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final String ASSESSMENT_DATA_TASK="assessmentDataTask";
	
	/**
	 * assessmentDataTask , 类型: com.dt.platform.domain.hr.AssessmentTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,com.dt.platform.domain.hr.AssessmentTask> ASSESSMENT_DATA_TASK_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,ASSESSMENT_DATA_TASK, com.dt.platform.domain.hr.AssessmentTask.class, "assessmentDataTask", "assessmentDataTask", com.dt.platform.domain.hr.AssessmentTask.class, null);
	
	/**
	 * assessmentBillTaskList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final String ASSESSMENT_BILL_TASK_LIST="assessmentBillTaskList";
	
	/**
	 * assessmentBillTaskList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentBillTask
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentBill,com.dt.platform.domain.hr.AssessmentBillTask> ASSESSMENT_BILL_TASK_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentBill.class ,ASSESSMENT_BILL_TASK_LIST, java.util.List.class, "assessmentBillTaskList", "assessmentBillTaskList", com.dt.platform.domain.hr.AssessmentBillTask.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , TASK_DATA_ID , TASK_NAME , STATUS , IS_SHOW , STIME , ETIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSESSMENT_TASK , ASSESSMENT_DATA_TASK , ASSESSMENT_BILL_TASK_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentBill {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentBill setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 考核
		 * @param taskId 考核
		 * @return 当前对象
		*/
		public AssessmentBill setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 考核任务
		 * @param taskDataId 考核任务
		 * @return 当前对象
		*/
		public AssessmentBill setTaskDataId(String taskDataId) {
			super.change(TASK_DATA_ID,super.getTaskDataId(),taskDataId);
			super.setTaskDataId(taskDataId);
			return this;
		}
		
		/**
		 * 设置 考核名称
		 * @param taskName 考核名称
		 * @return 当前对象
		*/
		public AssessmentBill setTaskName(String taskName) {
			super.change(TASK_NAME,super.getTaskName(),taskName);
			super.setTaskName(taskName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AssessmentBill setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 是否可见
		 * @param isShow 是否可见
		 * @return 当前对象
		*/
		public AssessmentBill setIsShow(String isShow) {
			super.change(IS_SHOW,super.getIsShow(),isShow);
			super.setIsShow(isShow);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param stime 开始时间
		 * @return 当前对象
		*/
		public AssessmentBill setStime(Date stime) {
			super.change(STIME,super.getStime(),stime);
			super.setStime(stime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param etime 结束时间
		 * @return 当前对象
		*/
		public AssessmentBill setEtime(Date etime) {
			super.change(ETIME,super.getEtime(),etime);
			super.setEtime(etime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssessmentBill setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentBill setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentBill setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentBill setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentBill setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentBill setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentBill setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentBill setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentBill setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 assessmentTask
		 * @param assessmentTask assessmentTask
		 * @return 当前对象
		*/
		public AssessmentBill setAssessmentTask(AssessmentTask assessmentTask) {
			super.change(ASSESSMENT_TASK,super.getAssessmentTask(),assessmentTask);
			super.setAssessmentTask(assessmentTask);
			return this;
		}
		
		/**
		 * 设置 assessmentDataTask
		 * @param assessmentDataTask assessmentDataTask
		 * @return 当前对象
		*/
		public AssessmentBill setAssessmentDataTask(AssessmentTask assessmentDataTask) {
			super.change(ASSESSMENT_DATA_TASK,super.getAssessmentDataTask(),assessmentDataTask);
			super.setAssessmentDataTask(assessmentDataTask);
			return this;
		}
		
		/**
		 * 设置 assessmentBillTaskList
		 * @param assessmentBillTaskList assessmentBillTaskList
		 * @return 当前对象
		*/
		public AssessmentBill setAssessmentBillTaskList(List<AssessmentBillTask> assessmentBillTaskList) {
			super.change(ASSESSMENT_BILL_TASK_LIST,super.getAssessmentBillTaskList(),assessmentBillTaskList);
			super.setAssessmentBillTaskList(assessmentBillTaskList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentBill clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentBill duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setTaskDataId(this.getTaskDataId());
			inst.setStime(this.getStime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setIsShow(this.getIsShow());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setEtime(this.getEtime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setTaskName(this.getTaskName());
			inst.setId(this.getId());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAssessmentDataTask(this.getAssessmentDataTask());
				inst.setAssessmentTask(this.getAssessmentTask());
				inst.setAssessmentBillTaskList(this.getAssessmentBillTaskList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}