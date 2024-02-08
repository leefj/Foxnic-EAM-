package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PerformanceLevel;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 16:04:59
 * @sign AD28231A05750238E4AC9870B42C8E14
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PerformanceLevelMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 等级编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 等级编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,CODE, java.lang.String.class, "等级编码", "等级编码", java.lang.String.class, null);
	
	/**
	 * 等级名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 等级名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,NAME, java.lang.String.class, "等级名称", "等级名称", java.lang.String.class, null);
	
	/**
	 * 成绩下限 , 类型: java.lang.String
	*/
	public static final String LOWER_LIMIT="lowerLimit";
	
	/**
	 * 成绩下限 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> LOWER_LIMIT_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,LOWER_LIMIT, java.lang.String.class, "成绩下限", "成绩下限", java.lang.String.class, null);
	
	/**
	 * 成绩上限 , 类型: java.lang.String
	*/
	public static final String UPPER_LIMIT="upperLimit";
	
	/**
	 * 成绩上限 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> UPPER_LIMIT_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,UPPER_LIMIT, java.lang.String.class, "成绩上限", "成绩上限", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PerformanceLevel,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PerformanceLevel.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , LOWER_LIMIT , UPPER_LIMIT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PerformanceLevel {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PerformanceLevel setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 等级编码
		 * @param code 等级编码
		 * @return 当前对象
		*/
		public PerformanceLevel setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 等级名称
		 * @param name 等级名称
		 * @return 当前对象
		*/
		public PerformanceLevel setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 成绩下限
		 * @param lowerLimit 成绩下限
		 * @return 当前对象
		*/
		public PerformanceLevel setLowerLimit(String lowerLimit) {
			super.change(LOWER_LIMIT,super.getLowerLimit(),lowerLimit);
			super.setLowerLimit(lowerLimit);
			return this;
		}
		
		/**
		 * 设置 成绩上限
		 * @param upperLimit 成绩上限
		 * @return 当前对象
		*/
		public PerformanceLevel setUpperLimit(String upperLimit) {
			super.change(UPPER_LIMIT,super.getUpperLimit(),upperLimit);
			super.setUpperLimit(upperLimit);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PerformanceLevel setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PerformanceLevel setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PerformanceLevel setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PerformanceLevel setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PerformanceLevel setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PerformanceLevel setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PerformanceLevel setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PerformanceLevel setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PerformanceLevel setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PerformanceLevel clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PerformanceLevel duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLowerLimit(this.getLowerLimit());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpperLimit(this.getUpperLimit());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}