package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorAlertLog;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 23:36:27
 * @sign CCF23258E52C6A2E6181ABB5EC2E334E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorAlertLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 通知方式 , 类型: java.lang.String
	*/
	public static final String ALERT_METHOD="alertMethod";
	
	/**
	 * 通知方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> ALERT_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,ALERT_METHOD, java.lang.String.class, "通知方式", "通知方式", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String MSG="msg";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> MSG_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,MSG, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,RCD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 通知结果 , 类型: java.lang.String
	*/
	public static final String ACTION_RESULT_STATUS="actionResultStatus";
	
	/**
	 * 通知结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> ACTION_RESULT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,ACTION_RESULT_STATUS, java.lang.String.class, "通知结果", "通知结果", java.lang.String.class, null);
	
	/**
	 * 结果明细 , 类型: java.lang.String
	*/
	public static final String ACTION_RESULT="actionResult";
	
	/**
	 * 结果明细 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> ACTION_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,ACTION_RESULT, java.lang.String.class, "结果明细", "结果明细", java.lang.String.class, null);
	
	/**
	 * 告警事件 , 类型: java.lang.String
	*/
	public static final String ALERT_ID="alertId";
	
	/**
	 * 告警事件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> ALERT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,ALERT_ID, java.lang.String.class, "告警事件", "告警事件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * monitorAlertMethod , 类型: com.dt.platform.domain.ops.MonitorAlertMethod
	*/
	public static final String MONITOR_ALERT_METHOD="monitorAlertMethod";
	
	/**
	 * monitorAlertMethod , 类型: com.dt.platform.domain.ops.MonitorAlertMethod
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,com.dt.platform.domain.ops.MonitorAlertMethod> MONITOR_ALERT_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,MONITOR_ALERT_METHOD, com.dt.platform.domain.ops.MonitorAlertMethod.class, "monitorAlertMethod", "monitorAlertMethod", com.dt.platform.domain.ops.MonitorAlertMethod.class, null);
	
	/**
	 * sendUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SEND_USER="sendUser";
	
	/**
	 * sendUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertLog,org.github.foxnic.web.domain.hrm.Employee> SEND_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertLog.class ,SEND_USER, org.github.foxnic.web.domain.hrm.Employee.class, "sendUser", "sendUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER_ID , ALERT_METHOD , MSG , RCD_TIME , ACTION_RESULT_STATUS , ACTION_RESULT , ALERT_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , MONITOR_ALERT_METHOD , SEND_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorAlertLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorAlertLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public MonitorAlertLog setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 通知方式
		 * @param alertMethod 通知方式
		 * @return 当前对象
		*/
		public MonitorAlertLog setAlertMethod(String alertMethod) {
			super.change(ALERT_METHOD,super.getAlertMethod(),alertMethod);
			super.setAlertMethod(alertMethod);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param msg 内容
		 * @return 当前对象
		*/
		public MonitorAlertLog setMsg(String msg) {
			super.change(MSG,super.getMsg(),msg);
			super.setMsg(msg);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param rcdTime 记录时间
		 * @return 当前对象
		*/
		public MonitorAlertLog setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 通知结果
		 * @param actionResultStatus 通知结果
		 * @return 当前对象
		*/
		public MonitorAlertLog setActionResultStatus(String actionResultStatus) {
			super.change(ACTION_RESULT_STATUS,super.getActionResultStatus(),actionResultStatus);
			super.setActionResultStatus(actionResultStatus);
			return this;
		}
		
		/**
		 * 设置 结果明细
		 * @param actionResult 结果明细
		 * @return 当前对象
		*/
		public MonitorAlertLog setActionResult(String actionResult) {
			super.change(ACTION_RESULT,super.getActionResult(),actionResult);
			super.setActionResult(actionResult);
			return this;
		}
		
		/**
		 * 设置 告警事件
		 * @param alertId 告警事件
		 * @return 当前对象
		*/
		public MonitorAlertLog setAlertId(String alertId) {
			super.change(ALERT_ID,super.getAlertId(),alertId);
			super.setAlertId(alertId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorAlertLog setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorAlertLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorAlertLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorAlertLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorAlertLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorAlertLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorAlertLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorAlertLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorAlertLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 monitorAlertMethod
		 * @param monitorAlertMethod monitorAlertMethod
		 * @return 当前对象
		*/
		public MonitorAlertLog setMonitorAlertMethod(MonitorAlertMethod monitorAlertMethod) {
			super.change(MONITOR_ALERT_METHOD,super.getMonitorAlertMethod(),monitorAlertMethod);
			super.setMonitorAlertMethod(monitorAlertMethod);
			return this;
		}
		
		/**
		 * 设置 sendUser
		 * @param sendUser sendUser
		 * @return 当前对象
		*/
		public MonitorAlertLog setSendUser(Employee sendUser) {
			super.change(SEND_USER,super.getSendUser(),sendUser);
			super.setSendUser(sendUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MonitorAlertLog clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MonitorAlertLog duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setMsg(this.getMsg());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setActionResult(this.getActionResult());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setActionResultStatus(this.getActionResultStatus());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setAlertMethod(this.getAlertMethod());
			inst.setAlertId(this.getAlertId());
			inst.setRcdTime(this.getRcdTime());
			if(all) {
				inst.setMonitorAlertMethod(this.getMonitorAlertMethod());
				inst.setSendUser(this.getSendUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}