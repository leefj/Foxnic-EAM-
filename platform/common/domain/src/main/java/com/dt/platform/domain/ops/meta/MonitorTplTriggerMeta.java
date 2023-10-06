package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTplTrigger;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorNode;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-06 09:32:58
 * @sign E7BE4C086BD5CE9615C4FD8F58A5A34E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplTriggerMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,NAME, java.lang.String.class, "触发器", "触发器", java.lang.String.class, null);
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final String WARN_LEVEL="warnLevel";
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> WARN_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,WARN_LEVEL, java.lang.String.class, "告警等级", "告警等级", java.lang.String.class, null);
	
	/**
	 * 规则 , 类型: java.lang.String
	*/
	public static final String RULE="rule";
	
	/**
	 * 规则 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> RULE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,RULE, java.lang.String.class, "规则", "规则", java.lang.String.class, null);
	
	/**
	 * 告警值 , 类型: java.lang.String
	*/
	public static final String CONTENT_VALUE="contentValue";
	
	/**
	 * 告警值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> CONTENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,CONTENT_VALUE, java.lang.String.class, "告警值", "告警值", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * monitorNodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final String MONITOR_NODE_LIST="monitorNodeList";
	
	/**
	 * monitorNodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTrigger,com.dt.platform.domain.ops.MonitorNode> MONITOR_NODE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTrigger.class ,MONITOR_NODE_LIST, java.util.List.class, "monitorNodeList", "monitorNodeList", com.dt.platform.domain.ops.MonitorNode.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , WARN_LEVEL , RULE , CONTENT_VALUE , STATUS , MONITOR_TPL_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL , MONITOR_NODE_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTplTrigger {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTplTrigger setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 触发器
		 * @param name 触发器
		 * @return 当前对象
		*/
		public MonitorTplTrigger setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 告警等级
		 * @param warnLevel 告警等级
		 * @return 当前对象
		*/
		public MonitorTplTrigger setWarnLevel(String warnLevel) {
			super.change(WARN_LEVEL,super.getWarnLevel(),warnLevel);
			super.setWarnLevel(warnLevel);
			return this;
		}
		
		/**
		 * 设置 规则
		 * @param rule 规则
		 * @return 当前对象
		*/
		public MonitorTplTrigger setRule(String rule) {
			super.change(RULE,super.getRule(),rule);
			super.setRule(rule);
			return this;
		}
		
		/**
		 * 设置 告警值
		 * @param contentValue 告警值
		 * @return 当前对象
		*/
		public MonitorTplTrigger setContentValue(String contentValue) {
			super.change(CONTENT_VALUE,super.getContentValue(),contentValue);
			super.setContentValue(contentValue);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorTplTrigger setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorTplTrigger setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorTplTrigger setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTplTrigger setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTplTrigger setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTplTrigger setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTplTrigger setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTplTrigger setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTplTrigger setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTplTrigger setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTplTrigger setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorTplTrigger setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
		
		/**
		 * 设置 monitorNodeList
		 * @param monitorNodeList monitorNodeList
		 * @return 当前对象
		*/
		public MonitorTplTrigger setMonitorNodeList(List<MonitorNode> monitorNodeList) {
			super.change(MONITOR_NODE_LIST,super.getMonitorNodeList(),monitorNodeList);
			super.setMonitorNodeList(monitorNodeList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MonitorTplTrigger clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MonitorTplTrigger duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setWarnLevel(this.getWarnLevel());
			inst.setRule(this.getRule());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setContentValue(this.getContentValue());
			inst.setMonitorTplCode(this.getMonitorTplCode());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setMonitorNodeList(this.getMonitorNodeList());
				inst.setTpl(this.getTpl());
			}
			inst.clearModifies();
			return inst;
		}

	}
}