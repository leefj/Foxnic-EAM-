package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.RepairOrderTransfer;
import java.util.Date;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.RepairOrder;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.RepairGroup;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-18 09:29:35
 * @sign 51AB7062A27618BCD8AF9780F10CFB07
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RepairOrderTransferMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 维修工单 , 类型: java.lang.String
	*/
	public static final String ORDER_ACT_ID="orderActId";
	
	/**
	 * 维修工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> ORDER_ACT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,ORDER_ACT_ID, java.lang.String.class, "维修工单", "维修工单", java.lang.String.class, null);
	
	/**
	 * 申请工单 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 申请工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,ORDER_ID, java.lang.String.class, "申请工单", "申请工单", java.lang.String.class, null);
	
	/**
	 * 维修班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 维修班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,GROUP_ID, java.lang.String.class, "维修班组", "维修班组", java.lang.String.class, null);
	
	/**
	 * 维修人员 , 类型: java.lang.String
	*/
	public static final String EXECUTOR_ID="executorId";
	
	/**
	 * 维修人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> EXECUTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,EXECUTOR_ID, java.lang.String.class, "维修人员", "维修人员", java.lang.String.class, null);
	
	/**
	 * 规则 , 类型: java.lang.String
	*/
	public static final String RULE="rule";
	
	/**
	 * 规则 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> RULE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,RULE, java.lang.String.class, "规则", "规则", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 维修工单 , 类型: com.dt.platform.domain.eam.RepairOrderAct
	*/
	public static final String ORDER_ACT="orderAct";
	
	/**
	 * 维修工单 , 类型: com.dt.platform.domain.eam.RepairOrderAct
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,com.dt.platform.domain.eam.RepairOrderAct> ORDER_ACT_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,ORDER_ACT, com.dt.platform.domain.eam.RepairOrderAct.class, "维修工单", "维修工单", com.dt.platform.domain.eam.RepairOrderAct.class, null);
	
	/**
	 * 维修申请 , 类型: com.dt.platform.domain.eam.RepairOrder
	*/
	public static final String ORDER="order";
	
	/**
	 * 维修申请 , 类型: com.dt.platform.domain.eam.RepairOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,com.dt.platform.domain.eam.RepairOrder> ORDER_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,ORDER, com.dt.platform.domain.eam.RepairOrder.class, "维修申请", "维修申请", com.dt.platform.domain.eam.RepairOrder.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,org.github.foxnic.web.domain.hrm.Employee> EXECUTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,EXECUTOR, org.github.foxnic.web.domain.hrm.Employee.class, "执行人", "执行人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 维修班组 , 类型: com.dt.platform.domain.eam.RepairGroup
	*/
	public static final String REPAIR_GROUP="repairGroup";
	
	/**
	 * 维修班组 , 类型: com.dt.platform.domain.eam.RepairGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderTransfer,com.dt.platform.domain.eam.RepairGroup> REPAIR_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderTransfer.class ,REPAIR_GROUP, com.dt.platform.domain.eam.RepairGroup.class, "维修班组", "维修班组", com.dt.platform.domain.eam.RepairGroup.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_ACT_ID , ORDER_ID , GROUP_ID , EXECUTOR_ID , RULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORDER_ACT , ORDER , ORIGINATOR , EXECUTOR , REPAIR_GROUP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.RepairOrderTransfer {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RepairOrderTransfer setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 维修工单
		 * @param orderActId 维修工单
		 * @return 当前对象
		*/
		public RepairOrderTransfer setOrderActId(String orderActId) {
			super.change(ORDER_ACT_ID,super.getOrderActId(),orderActId);
			super.setOrderActId(orderActId);
			return this;
		}
		
		/**
		 * 设置 申请工单
		 * @param orderId 申请工单
		 * @return 当前对象
		*/
		public RepairOrderTransfer setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 维修班组
		 * @param groupId 维修班组
		 * @return 当前对象
		*/
		public RepairOrderTransfer setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 维修人员
		 * @param executorId 维修人员
		 * @return 当前对象
		*/
		public RepairOrderTransfer setExecutorId(String executorId) {
			super.change(EXECUTOR_ID,super.getExecutorId(),executorId);
			super.setExecutorId(executorId);
			return this;
		}
		
		/**
		 * 设置 规则
		 * @param rule 规则
		 * @return 当前对象
		*/
		public RepairOrderTransfer setRule(String rule) {
			super.change(RULE,super.getRule(),rule);
			super.setRule(rule);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public RepairOrderTransfer setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RepairOrderTransfer setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RepairOrderTransfer setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RepairOrderTransfer setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RepairOrderTransfer setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RepairOrderTransfer setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RepairOrderTransfer setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RepairOrderTransfer setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public RepairOrderTransfer setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public RepairOrderTransfer setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 维修工单
		 * @param orderAct 维修工单
		 * @return 当前对象
		*/
		public RepairOrderTransfer setOrderAct(RepairOrderAct orderAct) {
			super.change(ORDER_ACT,super.getOrderAct(),orderAct);
			super.setOrderAct(orderAct);
			return this;
		}
		
		/**
		 * 设置 维修申请
		 * @param order 维修申请
		 * @return 当前对象
		*/
		public RepairOrderTransfer setOrder(RepairOrder order) {
			super.change(ORDER,super.getOrder(),order);
			super.setOrder(order);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public RepairOrderTransfer setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executor 执行人
		 * @return 当前对象
		*/
		public RepairOrderTransfer setExecutor(Employee executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
		}
		
		/**
		 * 设置 维修班组
		 * @param repairGroup 维修班组
		 * @return 当前对象
		*/
		public RepairOrderTransfer setRepairGroup(RepairGroup repairGroup) {
			super.change(REPAIR_GROUP,super.getRepairGroup(),repairGroup);
			super.setRepairGroup(repairGroup);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public RepairOrderTransfer clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public RepairOrderTransfer duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setOrderId(this.getOrderId());
			inst.setExecutorId(this.getExecutorId());
			inst.setGroupId(this.getGroupId());
			inst.setRule(this.getRule());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setOrderActId(this.getOrderActId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setOrderAct(this.getOrderAct());
				inst.setExecutor(this.getExecutor());
				inst.setRepairGroup(this.getRepairGroup());
				inst.setOriginator(this.getOriginator());
				inst.setOrder(this.getOrder());
			}
			inst.clearModifies();
			return inst;
		}

	}
}