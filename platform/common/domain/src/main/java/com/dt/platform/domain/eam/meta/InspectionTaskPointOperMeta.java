package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionTaskPointOper;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.InspectionProcessAction;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 14:18:27
 * @sign E3E5DF4735C56797BDEB4C9E7E90E333
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionTaskPointOperMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final String IS_POINT_STATUS="isPointStatus";
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> IS_POINT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,IS_POINT_STATUS, java.lang.String.class, "巡检状态", "巡检状态", java.lang.String.class, null);
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final String POINT_STATUS="pointStatus";
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> POINT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,POINT_STATUS, java.lang.String.class, "巡检状态", "巡检状态", java.lang.String.class, null);
	
	/**
	 * 处理动作 , 类型: java.lang.String
	*/
	public static final String IS_ACTION_LABEL="isActionLabel";
	
	/**
	 * 处理动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> IS_ACTION_LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,IS_ACTION_LABEL, java.lang.String.class, "处理动作", "处理动作", java.lang.String.class, null);
	
	/**
	 * 处理动作 , 类型: java.lang.String
	*/
	public static final String ACTION_LABEL="actionLabel";
	
	/**
	 * 处理动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> ACTION_LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,ACTION_LABEL, java.lang.String.class, "处理动作", "处理动作", java.lang.String.class, null);
	
	/**
	 * 巡检人 , 类型: java.lang.String
	*/
	public static final String IS_INSPECTOR_ID="isInspectorId";
	
	/**
	 * 巡检人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> IS_INSPECTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,IS_INSPECTOR_ID, java.lang.String.class, "巡检人", "巡检人", java.lang.String.class, null);
	
	/**
	 * 巡检人 , 类型: java.lang.String
	*/
	public static final String INSPECTOR_ID="inspectorId";
	
	/**
	 * 巡检人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> INSPECTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,INSPECTOR_ID, java.lang.String.class, "巡检人", "巡检人", java.lang.String.class, null);
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final String IS_CONTENT="isContent";
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> IS_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,IS_CONTENT, java.lang.String.class, "巡检结果", "巡检结果", java.lang.String.class, null);
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,CONTENT, java.lang.String.class, "巡检结果", "巡检结果", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,OPER_USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 巡检人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String INSPECTOR="inspector";
	
	/**
	 * 巡检人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,org.github.foxnic.web.domain.hrm.Employee> INSPECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,INSPECTOR, org.github.foxnic.web.domain.hrm.Employee.class, "巡检人", "巡检人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 操作人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * 操作人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "操作人", "操作人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * inspectionProcessAction , 类型: com.dt.platform.domain.eam.InspectionProcessAction
	*/
	public static final String INSPECTION_PROCESS_ACTION="inspectionProcessAction";
	
	/**
	 * inspectionProcessAction , 类型: com.dt.platform.domain.eam.InspectionProcessAction
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointOper,com.dt.platform.domain.eam.InspectionProcessAction> INSPECTION_PROCESS_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointOper.class ,INSPECTION_PROCESS_ACTION, com.dt.platform.domain.eam.InspectionProcessAction.class, "inspectionProcessAction", "inspectionProcessAction", com.dt.platform.domain.eam.InspectionProcessAction.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , IS_POINT_STATUS , POINT_STATUS , IS_ACTION_LABEL , ACTION_LABEL , IS_INSPECTOR_ID , INSPECTOR_ID , IS_CONTENT , CONTENT , OPER_USER_ID , OPER_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , INSPECTOR , OPER_USER , INSPECTION_PROCESS_ACTION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionTaskPointOper {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param taskId 任务
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 巡检状态
		 * @param isPointStatus 巡检状态
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setIsPointStatus(String isPointStatus) {
			super.change(IS_POINT_STATUS,super.getIsPointStatus(),isPointStatus);
			super.setIsPointStatus(isPointStatus);
			return this;
		}
		
		/**
		 * 设置 巡检状态
		 * @param pointStatus 巡检状态
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setPointStatus(String pointStatus) {
			super.change(POINT_STATUS,super.getPointStatus(),pointStatus);
			super.setPointStatus(pointStatus);
			return this;
		}
		
		/**
		 * 设置 处理动作
		 * @param isActionLabel 处理动作
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setIsActionLabel(String isActionLabel) {
			super.change(IS_ACTION_LABEL,super.getIsActionLabel(),isActionLabel);
			super.setIsActionLabel(isActionLabel);
			return this;
		}
		
		/**
		 * 设置 处理动作
		 * @param actionLabel 处理动作
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setActionLabel(String actionLabel) {
			super.change(ACTION_LABEL,super.getActionLabel(),actionLabel);
			super.setActionLabel(actionLabel);
			return this;
		}
		
		/**
		 * 设置 巡检人
		 * @param isInspectorId 巡检人
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setIsInspectorId(String isInspectorId) {
			super.change(IS_INSPECTOR_ID,super.getIsInspectorId(),isInspectorId);
			super.setIsInspectorId(isInspectorId);
			return this;
		}
		
		/**
		 * 设置 巡检人
		 * @param inspectorId 巡检人
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setInspectorId(String inspectorId) {
			super.change(INSPECTOR_ID,super.getInspectorId(),inspectorId);
			super.setInspectorId(inspectorId);
			return this;
		}
		
		/**
		 * 设置 巡检结果
		 * @param isContent 巡检结果
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setIsContent(String isContent) {
			super.change(IS_CONTENT,super.getIsContent(),isContent);
			super.setIsContent(isContent);
			return this;
		}
		
		/**
		 * 设置 巡检结果
		 * @param content 巡检结果
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUserId 操作人
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operTime 操作时间
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 巡检人
		 * @param inspector 巡检人
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setInspector(Employee inspector) {
			super.change(INSPECTOR,super.getInspector(),inspector);
			super.setInspector(inspector);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUser 操作人
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}
		
		/**
		 * 设置 inspectionProcessAction
		 * @param inspectionProcessAction inspectionProcessAction
		 * @return 当前对象
		*/
		public InspectionTaskPointOper setInspectionProcessAction(InspectionProcessAction inspectionProcessAction) {
			super.change(INSPECTION_PROCESS_ACTION,super.getInspectionProcessAction(),inspectionProcessAction);
			super.setInspectionProcessAction(inspectionProcessAction);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InspectionTaskPointOper clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InspectionTaskPointOper duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOperUserId(this.getOperUserId());
			inst.setNotes(this.getNotes());
			inst.setIsInspectorId(this.getIsInspectorId());
			inst.setIsContent(this.getIsContent());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setIsPointStatus(this.getIsPointStatus());
			inst.setInspectorId(this.getInspectorId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setActionLabel(this.getActionLabel());
			inst.setIsActionLabel(this.getIsActionLabel());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setPointStatus(this.getPointStatus());
			inst.setTaskId(this.getTaskId());
			inst.setOperTime(this.getOperTime());
			if(all) {
				inst.setInspectionProcessAction(this.getInspectionProcessAction());
				inst.setInspector(this.getInspector());
				inst.setOperUser(this.getOperUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}