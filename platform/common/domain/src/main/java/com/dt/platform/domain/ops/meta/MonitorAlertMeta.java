package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorAlert;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplTrigger;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 23:25:19
 * @sign E4E5F72A11835EED1424178582CF5C76
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorAlertMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,STATUS, java.lang.String.class, "处理状态", "处理状态", java.lang.String.class, null);
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final String WARN_LEVEL="warnLevel";
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> WARN_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,WARN_LEVEL, java.lang.String.class, "告警等级", "告警等级", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_SHOW_NAME="nodeShowName";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> NODE_SHOW_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,NODE_SHOW_NAME, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final String TRIGGER_ID="triggerId";
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> TRIGGER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,TRIGGER_ID, java.lang.String.class, "触发器", "触发器", java.lang.String.class, null);
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final String TRIGGER_NAME="triggerName";
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> TRIGGER_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,TRIGGER_NAME, java.lang.String.class, "触发器", "触发器", java.lang.String.class, null);
	
	/**
	 * 规则描述 , 类型: java.lang.String
	*/
	public static final String TRIGGER_RULE_DESC="triggerRuleDesc";
	
	/**
	 * 规则描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> TRIGGER_RULE_DESC_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,TRIGGER_RULE_DESC, java.lang.String.class, "规则描述", "规则描述", java.lang.String.class, null);
	
	/**
	 * 监控数值 , 类型: java.lang.String
	*/
	public static final String ALERT_VALUE="alertValue";
	
	/**
	 * 监控数值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> ALERT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,ALERT_VALUE, java.lang.String.class, "监控数值", "监控数值", java.lang.String.class, null);
	
	/**
	 * 告警时间 , 类型: java.util.Date
	*/
	public static final String WARN_TIME="warnTime";
	
	/**
	 * 告警时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.util.Date> WARN_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,WARN_TIME, java.util.Date.class, "告警时间", "告警时间", java.util.Date.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String HANDLED_TIME="handledTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.util.Date> HANDLED_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,HANDLED_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,USER_ID, java.lang.String.class, "处理人", "处理人", java.lang.String.class, null);
	
	/**
	 * 处理内容 , 类型: java.lang.String
	*/
	public static final String PROCESS_MESSAGE="processMessage";
	
	/**
	 * 处理内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> PROCESS_MESSAGE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,PROCESS_MESSAGE, java.lang.String.class, "处理内容", "处理内容", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * monitorTplTrigger , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplTrigger
	*/
	public static final String MONITOR_TPL_TRIGGER="monitorTplTrigger";
	
	/**
	 * monitorTplTrigger , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplTrigger
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,com.dt.platform.domain.ops.MonitorTplTrigger> MONITOR_TPL_TRIGGER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,MONITOR_TPL_TRIGGER, java.util.List.class, "monitorTplTrigger", "monitorTplTrigger", com.dt.platform.domain.ops.MonitorTplTrigger.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlert,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlert.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NODE_ID , STATUS , WARN_LEVEL , NODE_SHOW_NAME , TRIGGER_ID , TRIGGER_NAME , TRIGGER_RULE_DESC , ALERT_VALUE , WARN_TIME , HANDLED_TIME , USER_ID , PROCESS_MESSAGE , MONITOR_TPL_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL , MONITOR_TPL_TRIGGER , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorAlert {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorAlert setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public MonitorAlert setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 处理状态
		 * @param status 处理状态
		 * @return 当前对象
		*/
		public MonitorAlert setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 告警等级
		 * @param warnLevel 告警等级
		 * @return 当前对象
		*/
		public MonitorAlert setWarnLevel(String warnLevel) {
			super.change(WARN_LEVEL,super.getWarnLevel(),warnLevel);
			super.setWarnLevel(warnLevel);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeShowName 节点
		 * @return 当前对象
		*/
		public MonitorAlert setNodeShowName(String nodeShowName) {
			super.change(NODE_SHOW_NAME,super.getNodeShowName(),nodeShowName);
			super.setNodeShowName(nodeShowName);
			return this;
		}
		
		/**
		 * 设置 触发器
		 * @param triggerId 触发器
		 * @return 当前对象
		*/
		public MonitorAlert setTriggerId(String triggerId) {
			super.change(TRIGGER_ID,super.getTriggerId(),triggerId);
			super.setTriggerId(triggerId);
			return this;
		}
		
		/**
		 * 设置 触发器
		 * @param triggerName 触发器
		 * @return 当前对象
		*/
		public MonitorAlert setTriggerName(String triggerName) {
			super.change(TRIGGER_NAME,super.getTriggerName(),triggerName);
			super.setTriggerName(triggerName);
			return this;
		}
		
		/**
		 * 设置 规则描述
		 * @param triggerRuleDesc 规则描述
		 * @return 当前对象
		*/
		public MonitorAlert setTriggerRuleDesc(String triggerRuleDesc) {
			super.change(TRIGGER_RULE_DESC,super.getTriggerRuleDesc(),triggerRuleDesc);
			super.setTriggerRuleDesc(triggerRuleDesc);
			return this;
		}
		
		/**
		 * 设置 监控数值
		 * @param alertValue 监控数值
		 * @return 当前对象
		*/
		public MonitorAlert setAlertValue(String alertValue) {
			super.change(ALERT_VALUE,super.getAlertValue(),alertValue);
			super.setAlertValue(alertValue);
			return this;
		}
		
		/**
		 * 设置 告警时间
		 * @param warnTime 告警时间
		 * @return 当前对象
		*/
		public MonitorAlert setWarnTime(Date warnTime) {
			super.change(WARN_TIME,super.getWarnTime(),warnTime);
			super.setWarnTime(warnTime);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param handledTime 处理时间
		 * @return 当前对象
		*/
		public MonitorAlert setHandledTime(Date handledTime) {
			super.change(HANDLED_TIME,super.getHandledTime(),handledTime);
			super.setHandledTime(handledTime);
			return this;
		}
		
		/**
		 * 设置 处理人
		 * @param userId 处理人
		 * @return 当前对象
		*/
		public MonitorAlert setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 处理内容
		 * @param processMessage 处理内容
		 * @return 当前对象
		*/
		public MonitorAlert setProcessMessage(String processMessage) {
			super.change(PROCESS_MESSAGE,super.getProcessMessage(),processMessage);
			super.setProcessMessage(processMessage);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorAlert setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorAlert setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorAlert setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorAlert setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorAlert setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorAlert setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorAlert setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorAlert setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorAlert setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorAlert setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorAlert setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
		
		/**
		 * 设置 monitorTplTrigger
		 * @param monitorTplTrigger monitorTplTrigger
		 * @return 当前对象
		*/
		public MonitorAlert setMonitorTplTrigger(List<MonitorTplTrigger> monitorTplTrigger) {
			super.change(MONITOR_TPL_TRIGGER,super.getMonitorTplTrigger(),monitorTplTrigger);
			super.setMonitorTplTrigger(monitorTplTrigger);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public MonitorAlert setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MonitorAlert clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MonitorAlert duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcessMessage(this.getProcessMessage());
			inst.setNotes(this.getNotes());
			inst.setWarnLevel(this.getWarnLevel());
			inst.setTriggerName(this.getTriggerName());
			inst.setTriggerId(this.getTriggerId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setHandledTime(this.getHandledTime());
			inst.setWarnTime(this.getWarnTime());
			inst.setMonitorTplCode(this.getMonitorTplCode());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTriggerRuleDesc(this.getTriggerRuleDesc());
			inst.setNodeShowName(this.getNodeShowName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setNodeId(this.getNodeId());
			inst.setAlertValue(this.getAlertValue());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setTpl(this.getTpl());
				inst.setMonitorTplTrigger(this.getMonitorTplTrigger());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}