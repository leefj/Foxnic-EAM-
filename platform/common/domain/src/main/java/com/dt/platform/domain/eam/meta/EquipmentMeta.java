package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Equipment;
import java.util.Date;
import com.dt.platform.domain.eam.Product;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:36:19
 * @sign 4E96E2AE1EEA0110E5E5DB789C090EEA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EquipmentMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 产品 , 类型: java.lang.String
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 产品 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> PRODUCT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,PRODUCT_ID, java.lang.String.class, "产品", "产品", java.lang.String.class, null);
	
	/**
	 * 设备DN , 类型: java.lang.String
	*/
	public static final String DN="dn";
	
	/**
	 * 设备DN , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> DN_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,DN, java.lang.String.class, "设备DN", "设备DN", java.lang.String.class, null);
	
	/**
	 * 设备编码 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_CODE="equipmentCode";
	
	/**
	 * 设备编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> EQUIPMENT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,EQUIPMENT_CODE, java.lang.String.class, "设备编码", "设备编码", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final String GROUP_CODE="groupCode";
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> GROUP_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,GROUP_CODE, java.lang.String.class, "分组", "分组", java.lang.String.class, null);
	
	/**
	 * 设备密钥 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_KEY="equipmentKey";
	
	/**
	 * 设备密钥 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> EQUIPMENT_KEY_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,EQUIPMENT_KEY, java.lang.String.class, "设备密钥", "设备密钥", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * iotProduct , 类型: com.dt.platform.domain.eam.Product
	*/
	public static final String IOT_PRODUCT="iotProduct";
	
	/**
	 * iotProduct , 类型: com.dt.platform.domain.eam.Product
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,com.dt.platform.domain.eam.Product> IOT_PRODUCT_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,IOT_PRODUCT, com.dt.platform.domain.eam.Product.class, "iotProduct", "iotProduct", com.dt.platform.domain.eam.Product.class, null);
	
	/**
	 * group , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String GROUP="group";
	
	/**
	 * group , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Equipment,org.github.foxnic.web.domain.system.DictItem> GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.Equipment.class ,GROUP, org.github.foxnic.web.domain.system.DictItem.class, "group", "group", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PRODUCT_ID , DN , EQUIPMENT_CODE , STATUS , GROUP_CODE , EQUIPMENT_KEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , IOT_PRODUCT , GROUP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.Equipment {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Equipment setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 产品
		 * @param productId 产品
		 * @return 当前对象
		*/
		public Equipment setProductId(String productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 设备DN
		 * @param dn 设备DN
		 * @return 当前对象
		*/
		public Equipment setDn(String dn) {
			super.change(DN,super.getDn(),dn);
			super.setDn(dn);
			return this;
		}
		
		/**
		 * 设置 设备编码
		 * @param equipmentCode 设备编码
		 * @return 当前对象
		*/
		public Equipment setEquipmentCode(String equipmentCode) {
			super.change(EQUIPMENT_CODE,super.getEquipmentCode(),equipmentCode);
			super.setEquipmentCode(equipmentCode);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Equipment setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 分组
		 * @param groupCode 分组
		 * @return 当前对象
		*/
		public Equipment setGroupCode(String groupCode) {
			super.change(GROUP_CODE,super.getGroupCode(),groupCode);
			super.setGroupCode(groupCode);
			return this;
		}
		
		/**
		 * 设置 设备密钥
		 * @param equipmentKey 设备密钥
		 * @return 当前对象
		*/
		public Equipment setEquipmentKey(String equipmentKey) {
			super.change(EQUIPMENT_KEY,super.getEquipmentKey(),equipmentKey);
			super.setEquipmentKey(equipmentKey);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Equipment setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Equipment setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Equipment setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Equipment setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Equipment setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Equipment setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Equipment setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Equipment setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Equipment setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Equipment setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 iotProduct
		 * @param iotProduct iotProduct
		 * @return 当前对象
		*/
		public Equipment setIotProduct(Product iotProduct) {
			super.change(IOT_PRODUCT,super.getIotProduct(),iotProduct);
			super.setIotProduct(iotProduct);
			return this;
		}
		
		/**
		 * 设置 group
		 * @param group group
		 * @return 当前对象
		*/
		public Equipment setGroup(DictItem group) {
			super.change(GROUP,super.getGroup(),group);
			super.setGroup(group);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Equipment clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Equipment duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setEquipmentKey(this.getEquipmentKey());
			inst.setNotes(this.getNotes());
			inst.setProductId(this.getProductId());
			inst.setEquipmentCode(this.getEquipmentCode());
			inst.setDn(this.getDn());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			inst.setGroupCode(this.getGroupCode());
			if(all) {
				inst.setIotProduct(this.getIotProduct());
				inst.setGroup(this.getGroup());
			}
			inst.clearModifies();
			return inst;
		}

	}
}