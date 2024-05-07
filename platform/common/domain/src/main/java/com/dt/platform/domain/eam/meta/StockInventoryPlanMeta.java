package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.StockInventoryPlan;
import java.util.Date;
import com.dt.platform.domain.eam.StockInventoryTask;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-05 17:18:50
 * @sign 2956D4D171E14C03F97FA2C57E475E31
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class StockInventoryPlanMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 计划名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 计划名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,NAME, java.lang.String.class, "计划名称", "计划名称", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,OWNER_CODE, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 启用状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 启用状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,STATUS, java.lang.String.class, "启用状态", "启用状态", java.lang.String.class, null);
	
	/**
	 * 计划类型 , 类型: java.lang.String
	*/
	public static final String PLAN_TYPE="planType";
	
	/**
	 * 计划类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> PLAN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,PLAN_TYPE, java.lang.String.class, "计划类型", "计划类型", java.lang.String.class, null);
	
	/**
	 * 模板 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模板 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,TPL_ID, java.lang.String.class, "模板", "模板", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 盘点任务 , 类型: com.dt.platform.domain.eam.StockInventoryTask
	*/
	public static final String INVENTORY_TASK="inventoryTask";
	
	/**
	 * 盘点任务 , 类型: com.dt.platform.domain.eam.StockInventoryTask
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,com.dt.platform.domain.eam.StockInventoryTask> INVENTORY_TASK_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,INVENTORY_TASK, com.dt.platform.domain.eam.StockInventoryTask.class, "盘点任务", "盘点任务", com.dt.platform.domain.eam.StockInventoryTask.class, null);
	
	/**
	 * 盘点类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INVENTORY_PLAN_TYPE="inventoryPlanType";
	
	/**
	 * 盘点类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.StockInventoryPlan,org.github.foxnic.web.domain.system.DictItem> INVENTORY_PLAN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.StockInventoryPlan.class ,INVENTORY_PLAN_TYPE, org.github.foxnic.web.domain.system.DictItem.class, "盘点类型", "盘点类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , OWNER_CODE , STATUS , PLAN_TYPE , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , INVENTORY_TASK , INVENTORY_PLAN_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.StockInventoryPlan {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public StockInventoryPlan setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 计划名称
		 * @param name 计划名称
		 * @return 当前对象
		*/
		public StockInventoryPlan setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerCode 归属
		 * @return 当前对象
		*/
		public StockInventoryPlan setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 启用状态
		 * @param status 启用状态
		 * @return 当前对象
		*/
		public StockInventoryPlan setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 计划类型
		 * @param planType 计划类型
		 * @return 当前对象
		*/
		public StockInventoryPlan setPlanType(String planType) {
			super.change(PLAN_TYPE,super.getPlanType(),planType);
			super.setPlanType(planType);
			return this;
		}
		
		/**
		 * 设置 模板
		 * @param tplId 模板
		 * @return 当前对象
		*/
		public StockInventoryPlan setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public StockInventoryPlan setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public StockInventoryPlan setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public StockInventoryPlan setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public StockInventoryPlan setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public StockInventoryPlan setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public StockInventoryPlan setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public StockInventoryPlan setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public StockInventoryPlan setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public StockInventoryPlan setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public StockInventoryPlan setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 盘点任务
		 * @param inventoryTask 盘点任务
		 * @return 当前对象
		*/
		public StockInventoryPlan setInventoryTask(StockInventoryTask inventoryTask) {
			super.change(INVENTORY_TASK,super.getInventoryTask(),inventoryTask);
			super.setInventoryTask(inventoryTask);
			return this;
		}
		
		/**
		 * 设置 盘点类型
		 * @param inventoryPlanType 盘点类型
		 * @return 当前对象
		*/
		public StockInventoryPlan setInventoryPlanType(DictItem inventoryPlanType) {
			super.change(INVENTORY_PLAN_TYPE,super.getInventoryPlanType(),inventoryPlanType);
			super.setInventoryPlanType(inventoryPlanType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public StockInventoryPlan clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public StockInventoryPlan duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setPlanType(this.getPlanType());
			inst.setNotes(this.getNotes());
			inst.setOwnerCode(this.getOwnerCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTplId(this.getTplId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setInventoryTask(this.getInventoryTask());
				inst.setInventoryPlanType(this.getInventoryPlanType());
			}
			inst.clearModifies();
			return inst;
		}

	}
}