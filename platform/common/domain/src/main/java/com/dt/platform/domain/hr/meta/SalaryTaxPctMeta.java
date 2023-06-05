package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryTaxPct;
import java.math.BigDecimal;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:41:55
 * @sign 209B807E9904EDD648668DBD8CFE5845
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryTaxPctMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 最小 , 类型: java.lang.String
	*/
	public static final String MIN="min";
	
	/**
	 * 最小 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> MIN_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,MIN, java.lang.String.class, "最小", "最小", java.lang.String.class, null);
	
	/**
	 * 最小包含 , 类型: java.lang.String
	*/
	public static final String MIN_INCLUDE="minInclude";
	
	/**
	 * 最小包含 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> MIN_INCLUDE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,MIN_INCLUDE, java.lang.String.class, "最小包含", "最小包含", java.lang.String.class, null);
	
	/**
	 * 最大 , 类型: java.math.BigDecimal
	*/
	public static final String MAX="max";
	
	/**
	 * 最大 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.math.BigDecimal> MAX_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,MAX, java.math.BigDecimal.class, "最大", "最大", java.math.BigDecimal.class, null);
	
	/**
	 * 最大包含 , 类型: java.lang.String
	*/
	public static final String MAX_INCLUDE="maxInclude";
	
	/**
	 * 最大包含 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> MAX_INCLUDE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,MAX_INCLUDE, java.lang.String.class, "最大包含", "最大包含", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,SORT, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTaxPct,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTaxPct.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , MIN , MIN_INCLUDE , MAX , MAX_INCLUDE , NOTES , SORT , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryTaxPct {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryTaxPct setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SalaryTaxPct setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 最小
		 * @param min 最小
		 * @return 当前对象
		*/
		public SalaryTaxPct setMin(String min) {
			super.change(MIN,super.getMin(),min);
			super.setMin(min);
			return this;
		}
		
		/**
		 * 设置 最小包含
		 * @param minInclude 最小包含
		 * @return 当前对象
		*/
		public SalaryTaxPct setMinInclude(String minInclude) {
			super.change(MIN_INCLUDE,super.getMinInclude(),minInclude);
			super.setMinInclude(minInclude);
			return this;
		}
		
		/**
		 * 设置 最大
		 * @param max 最大
		 * @return 当前对象
		*/
		public SalaryTaxPct setMax(BigDecimal max) {
			super.change(MAX,super.getMax(),max);
			super.setMax(max);
			return this;
		}
		
		/**
		 * 设置 最大包含
		 * @param maxInclude 最大包含
		 * @return 当前对象
		*/
		public SalaryTaxPct setMaxInclude(String maxInclude) {
			super.change(MAX_INCLUDE,super.getMaxInclude(),maxInclude);
			super.setMaxInclude(maxInclude);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryTaxPct setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sort 顺序
		 * @return 当前对象
		*/
		public SalaryTaxPct setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryTaxPct setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryTaxPct clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryTaxPct duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setMin(this.getMin());
			inst.setNotes(this.getNotes());
			inst.setMax(this.getMax());
			inst.setMaxInclude(this.getMaxInclude());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setId(this.getId());
			inst.setSort(this.getSort());
			inst.setMinInclude(this.getMinInclude());
			inst.clearModifies();
			return inst;
		}

	}
}