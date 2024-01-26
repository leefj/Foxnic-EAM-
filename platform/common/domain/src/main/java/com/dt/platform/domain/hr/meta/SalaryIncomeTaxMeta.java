package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryIncomeTax;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 07:40:19
 * @sign E87EBF703B853EFE2C62468CF035599F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryIncomeTaxMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 级别 , 类型: java.lang.String
	*/
	public static final String VALUE_LEVEL="valueLevel";
	
	/**
	 * 级别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> VALUE_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,VALUE_LEVEL, java.lang.String.class, "级别", "级别", java.lang.String.class, null);
	
	/**
	 * 起始金额 , 类型: java.math.BigDecimal
	*/
	public static final String START="start";
	
	/**
	 * 起始金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.math.BigDecimal> START_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,START, java.math.BigDecimal.class, "起始金额", "起始金额", java.math.BigDecimal.class, null);
	
	/**
	 * 结束金额 , 类型: java.math.BigDecimal
	*/
	public static final String END="end";
	
	/**
	 * 结束金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.math.BigDecimal> END_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,END, java.math.BigDecimal.class, "结束金额", "结束金额", java.math.BigDecimal.class, null);
	
	/**
	 * 税率 , 类型: java.math.BigDecimal
	*/
	public static final String TAX="tax";
	
	/**
	 * 税率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.math.BigDecimal> TAX_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,TAX, java.math.BigDecimal.class, "税率", "税率", java.math.BigDecimal.class, null);
	
	/**
	 * 速扣 , 类型: java.math.BigDecimal
	*/
	public static final String QUICK_DEDUCT="quickDeduct";
	
	/**
	 * 速扣 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.math.BigDecimal> QUICK_DEDUCT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,QUICK_DEDUCT, java.math.BigDecimal.class, "速扣", "速扣", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryIncomeTax,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryIncomeTax.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , VALUE_LEVEL , START , END , TAX , QUICK_DEDUCT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryIncomeTax {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryIncomeTax setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 级别
		 * @param valueLevel 级别
		 * @return 当前对象
		*/
		public SalaryIncomeTax setValueLevel(String valueLevel) {
			super.change(VALUE_LEVEL,super.getValueLevel(),valueLevel);
			super.setValueLevel(valueLevel);
			return this;
		}
		
		/**
		 * 设置 起始金额
		 * @param start 起始金额
		 * @return 当前对象
		*/
		public SalaryIncomeTax setStart(BigDecimal start) {
			super.change(START,super.getStart(),start);
			super.setStart(start);
			return this;
		}
		
		/**
		 * 设置 结束金额
		 * @param end 结束金额
		 * @return 当前对象
		*/
		public SalaryIncomeTax setEnd(BigDecimal end) {
			super.change(END,super.getEnd(),end);
			super.setEnd(end);
			return this;
		}
		
		/**
		 * 设置 税率
		 * @param tax 税率
		 * @return 当前对象
		*/
		public SalaryIncomeTax setTax(BigDecimal tax) {
			super.change(TAX,super.getTax(),tax);
			super.setTax(tax);
			return this;
		}
		
		/**
		 * 设置 速扣
		 * @param quickDeduct 速扣
		 * @return 当前对象
		*/
		public SalaryIncomeTax setQuickDeduct(BigDecimal quickDeduct) {
			super.change(QUICK_DEDUCT,super.getQuickDeduct(),quickDeduct);
			super.setQuickDeduct(quickDeduct);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryIncomeTax setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryIncomeTax setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryIncomeTax setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryIncomeTax setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryIncomeTax setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryIncomeTax setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryIncomeTax setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryIncomeTax setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SalaryIncomeTax setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryIncomeTax setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryIncomeTax clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryIncomeTax duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setStart(this.getStart());
			inst.setTax(this.getTax());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setValueLevel(this.getValueLevel());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setEnd(this.getEnd());
			inst.setId(this.getId());
			inst.setQuickDeduct(this.getQuickDeduct());
			inst.clearModifies();
			return inst;
		}

	}
}