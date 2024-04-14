package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.VirtEquipment;
import java.util.Date;
import com.dt.platform.domain.eam.Product;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-06 19:37:42
 * @sign 299182F857231C24436F308B7606621B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VirtEquipmentMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 所属产品 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属产品 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,OWNER_ID, java.lang.String.class, "所属产品", "所属产品", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 触发方式 , 类型: java.lang.String
	*/
	public static final String TRIGGER_TYPE="triggerType";
	
	/**
	 * 触发方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> TRIGGER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,TRIGGER_TYPE, java.lang.String.class, "触发方式", "触发方式", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * crontab表达式 , 类型: java.lang.String
	*/
	public static final String CRONTAB_VALUE="crontabValue";
	
	/**
	 * crontab表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> CRONTAB_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,CRONTAB_VALUE, java.lang.String.class, "crontab表达式", "crontab表达式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * iotProduct , 类型: com.dt.platform.domain.eam.Product
	*/
	public static final String IOT_PRODUCT="iotProduct";
	
	/**
	 * iotProduct , 类型: com.dt.platform.domain.eam.Product
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.VirtEquipment,com.dt.platform.domain.eam.Product> IOT_PRODUCT_PROP = new BeanProperty(com.dt.platform.domain.eam.VirtEquipment.class ,IOT_PRODUCT, com.dt.platform.domain.eam.Product.class, "iotProduct", "iotProduct", com.dt.platform.domain.eam.Product.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , OWNER_ID , TYPE , TRIGGER_TYPE , STATUS , CRONTAB_VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , IOT_PRODUCT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.VirtEquipment {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public VirtEquipment setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public VirtEquipment setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 所属产品
		 * @param ownerId 所属产品
		 * @return 当前对象
		*/
		public VirtEquipment setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public VirtEquipment setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 触发方式
		 * @param triggerType 触发方式
		 * @return 当前对象
		*/
		public VirtEquipment setTriggerType(String triggerType) {
			super.change(TRIGGER_TYPE,super.getTriggerType(),triggerType);
			super.setTriggerType(triggerType);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public VirtEquipment setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 crontab表达式
		 * @param crontabValue crontab表达式
		 * @return 当前对象
		*/
		public VirtEquipment setCrontabValue(String crontabValue) {
			super.change(CRONTAB_VALUE,super.getCrontabValue(),crontabValue);
			super.setCrontabValue(crontabValue);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public VirtEquipment setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VirtEquipment setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VirtEquipment setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VirtEquipment setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VirtEquipment setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VirtEquipment setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VirtEquipment setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VirtEquipment setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public VirtEquipment setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public VirtEquipment setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 iotProduct
		 * @param iotProduct iotProduct
		 * @return 当前对象
		*/
		public VirtEquipment setIotProduct(Product iotProduct) {
			super.change(IOT_PRODUCT,super.getIotProduct(),iotProduct);
			super.setIotProduct(iotProduct);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public VirtEquipment clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public VirtEquipment duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setOwnerId(this.getOwnerId());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setCrontabValue(this.getCrontabValue());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTriggerType(this.getTriggerType());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setIotProduct(this.getIotProduct());
			}
			inst.clearModifies();
			return inst;
		}

	}
}