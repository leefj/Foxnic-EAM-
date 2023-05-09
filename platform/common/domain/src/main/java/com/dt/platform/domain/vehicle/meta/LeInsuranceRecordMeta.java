package com.dt.platform.domain.vehicle.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.vehicle.LeInsuranceRecord;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:49:00
 * @sign BDDA194730226FC43041E1BCCF455590
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LeInsuranceRecordMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,COMPANY_ID, java.lang.String.class, "保险公司", "保险公司", java.lang.String.class, null);
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final String COMPANY_NAME="companyName";
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> COMPANY_NAME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,COMPANY_NAME, java.lang.String.class, "保险公司", "保险公司", java.lang.String.class, null);
	
	/**
	 * 保险类型 , 类型: java.lang.String
	*/
	public static final String INSURANCE_TYPE="insuranceType";
	
	/**
	 * 保险类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> INSURANCE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,INSURANCE_TYPE, java.lang.String.class, "保险类型", "保险类型", java.lang.String.class, null);
	
	/**
	 * 费用 , 类型: java.math.BigDecimal
	*/
	public static final String COST="cost";
	
	/**
	 * 费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.math.BigDecimal> COST_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,COST, java.math.BigDecimal.class, "费用", "费用", java.math.BigDecimal.class, null);
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final String HANDLER_NAME="handlerName";
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> HANDLER_NAME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,HANDLER_NAME, java.lang.String.class, "处理人", "处理人", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String HANDLER_CONTACT="handlerContact";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> HANDLER_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,HANDLER_CONTACT, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeInsuranceRecord,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeInsuranceRecord.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , COMPANY_ID , COMPANY_NAME , INSURANCE_TYPE , COST , HANDLER_NAME , HANDLER_CONTACT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.vehicle.LeInsuranceRecord {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public LeInsuranceRecord setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public LeInsuranceRecord setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 保险公司
		 * @param companyId 保险公司
		 * @return 当前对象
		*/
		public LeInsuranceRecord setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 保险公司
		 * @param companyName 保险公司
		 * @return 当前对象
		*/
		public LeInsuranceRecord setCompanyName(String companyName) {
			super.change(COMPANY_NAME,super.getCompanyName(),companyName);
			super.setCompanyName(companyName);
			return this;
		}
		
		/**
		 * 设置 保险类型
		 * @param insuranceType 保险类型
		 * @return 当前对象
		*/
		public LeInsuranceRecord setInsuranceType(String insuranceType) {
			super.change(INSURANCE_TYPE,super.getInsuranceType(),insuranceType);
			super.setInsuranceType(insuranceType);
			return this;
		}
		
		/**
		 * 设置 费用
		 * @param cost 费用
		 * @return 当前对象
		*/
		public LeInsuranceRecord setCost(BigDecimal cost) {
			super.change(COST,super.getCost(),cost);
			super.setCost(cost);
			return this;
		}
		
		/**
		 * 设置 处理人
		 * @param handlerName 处理人
		 * @return 当前对象
		*/
		public LeInsuranceRecord setHandlerName(String handlerName) {
			super.change(HANDLER_NAME,super.getHandlerName(),handlerName);
			super.setHandlerName(handlerName);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param handlerContact 联系方式
		 * @return 当前对象
		*/
		public LeInsuranceRecord setHandlerContact(String handlerContact) {
			super.change(HANDLER_CONTACT,super.getHandlerContact(),handlerContact);
			super.setHandlerContact(handlerContact);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public LeInsuranceRecord setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public LeInsuranceRecord setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public LeInsuranceRecord setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public LeInsuranceRecord setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public LeInsuranceRecord setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public LeInsuranceRecord setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public LeInsuranceRecord setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public LeInsuranceRecord setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public LeInsuranceRecord setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public LeInsuranceRecord setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public LeInsuranceRecord clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public LeInsuranceRecord duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCost(this.getCost());
			inst.setNotes(this.getNotes());
			inst.setCompanyName(this.getCompanyName());
			inst.setHandlerName(this.getHandlerName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setInsuranceType(this.getInsuranceType());
			inst.setHandlerContact(this.getHandlerContact());
			inst.setVersion(this.getVersion());
			inst.setCompanyId(this.getCompanyId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}