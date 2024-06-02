package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorAlertBook;
import java.util.Date;
import org.github.foxnic.web.domain.system.BusiRole;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNode;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-02 14:21:56
 * @sign 1ACF8BAD6D4E20FA076C8F1A33FCAD10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorAlertBookMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 全部对象 , 类型: java.lang.String
	*/
	public static final String MONITOR_IS_ALL="monitorIsAll";
	
	/**
	 * 全部对象 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> MONITOR_IS_ALL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,MONITOR_IS_ALL, java.lang.String.class, "全部对象", "全部对象", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final String USER_GROUP_LIST="userGroupList";
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,org.github.foxnic.web.domain.system.BusiRole> USER_GROUP_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,USER_GROUP_LIST, java.util.List.class, "人员群组", "人员群组", org.github.foxnic.web.domain.system.BusiRole.class, null);
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String USER_GROUP_IDS="userGroupIds";
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> USER_GROUP_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,USER_GROUP_IDS, java.util.List.class, "人员群组", "人员群组", java.lang.String.class, null);
	
	/**
	 * userGroupUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER_GROUP_USER_LIST="userGroupUserList";
	
	/**
	 * userGroupUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,org.github.foxnic.web.domain.hrm.Employee> USER_GROUP_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,USER_GROUP_USER_LIST, java.util.List.class, "userGroupUserList", "userGroupUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER_LIST="userList";
	
	/**
	 * 人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,org.github.foxnic.web.domain.hrm.Employee> USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,USER_LIST, java.util.List.class, "人员", "人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 人员 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String USER_IDS="userIds";
	
	/**
	 * 人员 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,USER_IDS, java.util.List.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * nodeGroupList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeGroup
	*/
	public static final String NODE_GROUP_LIST="nodeGroupList";
	
	/**
	 * nodeGroupList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,com.dt.platform.domain.ops.MonitorNodeGroup> NODE_GROUP_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,NODE_GROUP_LIST, java.util.List.class, "nodeGroupList", "nodeGroupList", com.dt.platform.domain.ops.MonitorNodeGroup.class, null);
	
	/**
	 * nodeGroupIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String NODE_GROUP_IDS="nodeGroupIds";
	
	/**
	 * nodeGroupIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> NODE_GROUP_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,NODE_GROUP_IDS, java.util.List.class, "nodeGroupIds", "nodeGroupIds", java.lang.String.class, null);
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final String NODE_LIST="nodeList";
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,com.dt.platform.domain.ops.MonitorNode> NODE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,NODE_LIST, java.util.List.class, "nodeList", "nodeList", com.dt.platform.domain.ops.MonitorNode.class, null);
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String NODE_IDS="nodeIds";
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> NODE_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,NODE_IDS, java.util.List.class, "nodeIds", "nodeIds", java.lang.String.class, null);
	
	/**
	 * levelList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String LEVEL_LIST="levelList";
	
	/**
	 * levelList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,org.github.foxnic.web.domain.system.DictItem> LEVEL_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,LEVEL_LIST, java.util.List.class, "levelList", "levelList", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * levelIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String LEVEL_IDS="levelIds";
	
	/**
	 * levelIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> LEVEL_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,LEVEL_IDS, java.util.List.class, "levelIds", "levelIds", java.lang.String.class, null);
	
	/**
	 * alertMethodList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorAlertMethod
	*/
	public static final String ALERT_METHOD_LIST="alertMethodList";
	
	/**
	 * alertMethodList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorAlertMethod
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,com.dt.platform.domain.ops.MonitorAlertMethod> ALERT_METHOD_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,ALERT_METHOD_LIST, java.util.List.class, "alertMethodList", "alertMethodList", com.dt.platform.domain.ops.MonitorAlertMethod.class, null);
	
	/**
	 * alertMethodIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ALERT_METHOD_IDS="alertMethodIds";
	
	/**
	 * alertMethodIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBook,java.lang.String> ALERT_METHOD_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBook.class ,ALERT_METHOD_IDS, java.util.List.class, "alertMethodIds", "alertMethodIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , STATUS , MONITOR_IS_ALL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER_GROUP_LIST , USER_GROUP_IDS , USER_GROUP_USER_LIST , USER_LIST , USER_IDS , NODE_GROUP_LIST , NODE_GROUP_IDS , NODE_LIST , NODE_IDS , LEVEL_LIST , LEVEL_IDS , ALERT_METHOD_LIST , ALERT_METHOD_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorAlertBook {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorAlertBook setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorAlertBook setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorAlertBook setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 全部对象
		 * @param monitorIsAll 全部对象
		 * @return 当前对象
		*/
		public MonitorAlertBook setMonitorIsAll(String monitorIsAll) {
			super.change(MONITOR_IS_ALL,super.getMonitorIsAll(),monitorIsAll);
			super.setMonitorIsAll(monitorIsAll);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorAlertBook setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorAlertBook setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorAlertBook setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorAlertBook setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorAlertBook setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorAlertBook setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorAlertBook setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorAlertBook setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorAlertBook setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 人员群组
		 * @param userGroupList 人员群组
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserGroupList(List<BusiRole> userGroupList) {
			super.change(USER_GROUP_LIST,super.getUserGroupList(),userGroupList);
			super.setUserGroupList(userGroupList);
			return this;
		}
		
		/**
		 * 设置 人员群组
		 * @param userGroupIds 人员群组
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserGroupIds(List<String> userGroupIds) {
			super.change(USER_GROUP_IDS,super.getUserGroupIds(),userGroupIds);
			super.setUserGroupIds(userGroupIds);
			return this;
		}
		
		/**
		 * 设置 userGroupUserList
		 * @param userGroupUserList userGroupUserList
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserGroupUserList(List<Employee> userGroupUserList) {
			super.change(USER_GROUP_USER_LIST,super.getUserGroupUserList(),userGroupUserList);
			super.setUserGroupUserList(userGroupUserList);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param userList 人员
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserList(List<Employee> userList) {
			super.change(USER_LIST,super.getUserList(),userList);
			super.setUserList(userList);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param userIds 人员
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserIds(List<String> userIds) {
			super.change(USER_IDS,super.getUserIds(),userIds);
			super.setUserIds(userIds);
			return this;
		}
		
		/**
		 * 设置 nodeGroupList
		 * @param nodeGroupList nodeGroupList
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeGroupList(List<MonitorNodeGroup> nodeGroupList) {
			super.change(NODE_GROUP_LIST,super.getNodeGroupList(),nodeGroupList);
			super.setNodeGroupList(nodeGroupList);
			return this;
		}
		
		/**
		 * 设置 nodeGroupIds
		 * @param nodeGroupIds nodeGroupIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeGroupIds(List<String> nodeGroupIds) {
			super.change(NODE_GROUP_IDS,super.getNodeGroupIds(),nodeGroupIds);
			super.setNodeGroupIds(nodeGroupIds);
			return this;
		}
		
		/**
		 * 设置 nodeList
		 * @param nodeList nodeList
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeList(List<MonitorNode> nodeList) {
			super.change(NODE_LIST,super.getNodeList(),nodeList);
			super.setNodeList(nodeList);
			return this;
		}
		
		/**
		 * 设置 nodeIds
		 * @param nodeIds nodeIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeIds(List<String> nodeIds) {
			super.change(NODE_IDS,super.getNodeIds(),nodeIds);
			super.setNodeIds(nodeIds);
			return this;
		}
		
		/**
		 * 设置 levelList
		 * @param levelList levelList
		 * @return 当前对象
		*/
		public MonitorAlertBook setLevelList(List<DictItem> levelList) {
			super.change(LEVEL_LIST,super.getLevelList(),levelList);
			super.setLevelList(levelList);
			return this;
		}
		
		/**
		 * 设置 levelIds
		 * @param levelIds levelIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setLevelIds(List<String> levelIds) {
			super.change(LEVEL_IDS,super.getLevelIds(),levelIds);
			super.setLevelIds(levelIds);
			return this;
		}
		
		/**
		 * 设置 alertMethodList
		 * @param alertMethodList alertMethodList
		 * @return 当前对象
		*/
		public MonitorAlertBook setAlertMethodList(List<MonitorAlertMethod> alertMethodList) {
			super.change(ALERT_METHOD_LIST,super.getAlertMethodList(),alertMethodList);
			super.setAlertMethodList(alertMethodList);
			return this;
		}
		
		/**
		 * 设置 alertMethodIds
		 * @param alertMethodIds alertMethodIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setAlertMethodIds(List<String> alertMethodIds) {
			super.change(ALERT_METHOD_IDS,super.getAlertMethodIds(),alertMethodIds);
			super.setAlertMethodIds(alertMethodIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MonitorAlertBook clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MonitorAlertBook duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setMonitorIsAll(this.getMonitorIsAll());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAlertMethodList(this.getAlertMethodList());
				inst.setLevelIds(this.getLevelIds());
				inst.setLevelList(this.getLevelList());
				inst.setUserGroupIds(this.getUserGroupIds());
				inst.setNodeGroupIds(this.getNodeGroupIds());
				inst.setNodeList(this.getNodeList());
				inst.setNodeIds(this.getNodeIds());
				inst.setUserGroupUserList(this.getUserGroupUserList());
				inst.setUserList(this.getUserList());
				inst.setUserIds(this.getUserIds());
				inst.setNodeGroupList(this.getNodeGroupList());
				inst.setUserGroupList(this.getUserGroupList());
				inst.setAlertMethodIds(this.getAlertMethodIds());
			}
			inst.clearModifies();
			return inst;
		}

	}
}