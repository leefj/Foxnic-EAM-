package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.AutoTaskLog;
import java.util.Date;
import com.dt.platform.domain.ops.AutoTask;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoNode;
import com.dt.platform.domain.ops.AutoTaskMLog;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-02 18:13:23
 * @sign 28214DEF024BE9F8C42A648E1B1CD600
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoTaskLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 作业 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 作业 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,TASK_ID, java.lang.String.class, "作业", "作业", java.lang.String.class, null);
	
	/**
	 * 日志 , 类型: java.lang.String
	*/
	public static final String M_LOG_ID="mLogId";
	
	/**
	 * 日志 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> M_LOG_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,M_LOG_ID, java.lang.String.class, "日志", "日志", java.lang.String.class, null);
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final String ACTION_ID="actionId";
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> ACTION_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,ACTION_ID, java.lang.String.class, "动作", "动作", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String NODE_IP="nodeIp";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> NODE_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,NODE_IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String STIME="stime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.util.Date> STIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,STIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String ETIME="etime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.util.Date> ETIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,ETIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 记录结果 , 类型: java.lang.String
	*/
	public static final String RECORD_CONTENT="recordContent";
	
	/**
	 * 记录结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> RECORD_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,RECORD_CONTENT, java.lang.String.class, "记录结果", "记录结果", java.lang.String.class, null);
	
	/**
	 * 内容明细 , 类型: java.lang.String
	*/
	public static final String CONTENT_DETAIL="contentDetail";
	
	/**
	 * 内容明细 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> CONTENT_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,CONTENT_DETAIL, java.lang.String.class, "内容明细", "内容明细", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * task , 类型: com.dt.platform.domain.ops.AutoTask
	*/
	public static final String TASK="task";
	
	/**
	 * task , 类型: com.dt.platform.domain.ops.AutoTask
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,com.dt.platform.domain.ops.AutoTask> TASK_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,TASK, com.dt.platform.domain.ops.AutoTask.class, "task", "task", com.dt.platform.domain.ops.AutoTask.class, null);
	
	/**
	 * action , 类型: com.dt.platform.domain.ops.AutoAction
	*/
	public static final String ACTION="action";
	
	/**
	 * action , 类型: com.dt.platform.domain.ops.AutoAction
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,com.dt.platform.domain.ops.AutoAction> ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,ACTION, com.dt.platform.domain.ops.AutoAction.class, "action", "action", com.dt.platform.domain.ops.AutoAction.class, null);
	
	/**
	 * node , 类型: com.dt.platform.domain.ops.AutoNode
	*/
	public static final String NODE="node";
	
	/**
	 * node , 类型: com.dt.platform.domain.ops.AutoNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,com.dt.platform.domain.ops.AutoNode> NODE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,NODE, com.dt.platform.domain.ops.AutoNode.class, "node", "node", com.dt.platform.domain.ops.AutoNode.class, null);
	
	/**
	 * mLog , 类型: com.dt.platform.domain.ops.AutoTaskMLog
	*/
	public static final String M_LOG="mLog";
	
	/**
	 * mLog , 类型: com.dt.platform.domain.ops.AutoTaskMLog
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskLog,com.dt.platform.domain.ops.AutoTaskMLog> M_LOG_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskLog.class ,M_LOG, com.dt.platform.domain.ops.AutoTaskMLog.class, "mLog", "mLog", com.dt.platform.domain.ops.AutoTaskMLog.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , M_LOG_ID , ACTION_ID , NODE_IP , NODE_ID , STATUS , STIME , ETIME , RECORD_CONTENT , CONTENT_DETAIL , RECORD_TIME , NOTES , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CREATE_BY , CREATE_TIME , TASK , ACTION , NODE , M_LOG };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.AutoTaskLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoTaskLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 作业
		 * @param taskId 作业
		 * @return 当前对象
		*/
		public AutoTaskLog setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 日志
		 * @param mLogId 日志
		 * @return 当前对象
		*/
		public AutoTaskLog setMLogId(String mLogId) {
			super.change(M_LOG_ID,super.getMLogId(),mLogId);
			super.setMLogId(mLogId);
			return this;
		}
		
		/**
		 * 设置 动作
		 * @param actionId 动作
		 * @return 当前对象
		*/
		public AutoTaskLog setActionId(String actionId) {
			super.change(ACTION_ID,super.getActionId(),actionId);
			super.setActionId(actionId);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param nodeIp IP
		 * @return 当前对象
		*/
		public AutoTaskLog setNodeIp(String nodeIp) {
			super.change(NODE_IP,super.getNodeIp(),nodeIp);
			super.setNodeIp(nodeIp);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public AutoTaskLog setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AutoTaskLog setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param stime 开始时间
		 * @return 当前对象
		*/
		public AutoTaskLog setStime(Date stime) {
			super.change(STIME,super.getStime(),stime);
			super.setStime(stime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param etime 结束时间
		 * @return 当前对象
		*/
		public AutoTaskLog setEtime(Date etime) {
			super.change(ETIME,super.getEtime(),etime);
			super.setEtime(etime);
			return this;
		}
		
		/**
		 * 设置 记录结果
		 * @param recordContent 记录结果
		 * @return 当前对象
		*/
		public AutoTaskLog setRecordContent(String recordContent) {
			super.change(RECORD_CONTENT,super.getRecordContent(),recordContent);
			super.setRecordContent(recordContent);
			return this;
		}
		
		/**
		 * 设置 内容明细
		 * @param contentDetail 内容明细
		 * @return 当前对象
		*/
		public AutoTaskLog setContentDetail(String contentDetail) {
			super.change(CONTENT_DETAIL,super.getContentDetail(),contentDetail);
			super.setContentDetail(contentDetail);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public AutoTaskLog setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AutoTaskLog setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoTaskLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoTaskLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoTaskLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoTaskLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoTaskLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AutoTaskLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AutoTaskLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AutoTaskLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 task
		 * @param task task
		 * @return 当前对象
		*/
		public AutoTaskLog setTask(AutoTask task) {
			super.change(TASK,super.getTask(),task);
			super.setTask(task);
			return this;
		}
		
		/**
		 * 设置 action
		 * @param action action
		 * @return 当前对象
		*/
		public AutoTaskLog setAction(AutoAction action) {
			super.change(ACTION,super.getAction(),action);
			super.setAction(action);
			return this;
		}
		
		/**
		 * 设置 node
		 * @param node node
		 * @return 当前对象
		*/
		public AutoTaskLog setNode(AutoNode node) {
			super.change(NODE,super.getNode(),node);
			super.setNode(node);
			return this;
		}
		
		/**
		 * 设置 mLog
		 * @param mLog mLog
		 * @return 当前对象
		*/
		public AutoTaskLog setMLog(AutoTaskMLog mLog) {
			super.change(M_LOG,super.getMLog(),mLog);
			super.setMLog(mLog);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AutoTaskLog clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AutoTaskLog duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setNodeIp(this.getNodeIp());
			inst.setStime(this.getStime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setContentDetail(this.getContentDetail());
			inst.setVersion(this.getVersion());
			inst.setMLogId(this.getMLogId());
			inst.setCreateBy(this.getCreateBy());
			inst.setRecordTime(this.getRecordTime());
			inst.setDeleted(this.getDeleted());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCreateTime(this.getCreateTime());
			inst.setEtime(this.getEtime());
			inst.setActionId(this.getActionId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setNodeId(this.getNodeId());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			inst.setRecordContent(this.getRecordContent());
			if(all) {
				inst.setNode(this.getNode());
				inst.setTask(this.getTask());
				inst.setMLog(this.getMLog());
				inst.setAction(this.getAction());
			}
			inst.clearModifies();
			return inst;
		}

	}
}