package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryColumn;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 15:51:03
 * @sign FE169EE20105409A92444448B43AC13A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryColumnMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 字段 , 类型: java.lang.String
	*/
	public static final String COL_CODE="colCode";
	
	/**
	 * 字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> COL_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,COL_CODE, java.lang.String.class, "字段", "字段", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String COL_NAME="colName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> COL_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,COL_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 实体,表字段,常量 , 类型: java.lang.String
	*/
	public static final String COL_TYPE="colType";
	
	/**
	 * 类型 , 实体,表字段,常量 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> COL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,COL_TYPE, java.lang.String.class, "类型", "实体,表字段,常量", java.lang.String.class, null);
	
	/**
	 * 值 , 类型: java.math.BigDecimal
	*/
	public static final String COL_VALUE="colValue";
	
	/**
	 * 值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.math.BigDecimal> COL_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,COL_VALUE, java.math.BigDecimal.class, "值", "值", java.math.BigDecimal.class, null);
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final String DS_SOURCE="dsSource";
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> DS_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,DS_SOURCE, java.lang.String.class, "数据来源", "数据来源", java.lang.String.class, null);
	
	/**
	 * 计算方式 , 类型: java.lang.String
	*/
	public static final String CAL_METHOD="calMethod";
	
	/**
	 * 计算方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> CAL_METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,CAL_METHOD, java.lang.String.class, "计算方式", "计算方式", java.lang.String.class, null);
	
	/**
	 * 业务分类 , 类型: java.lang.String
	*/
	public static final String BUSI_TYPE="busiType";
	
	/**
	 * 业务分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> BUSI_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,BUSI_TYPE, java.lang.String.class, "业务分类", "业务分类", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryColumn,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryColumn.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , COL_CODE , COL_NAME , COL_TYPE , COL_VALUE , DS_SOURCE , CAL_METHOD , BUSI_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryColumn {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryColumn setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 字段
		 * @param colCode 字段
		 * @return 当前对象
		*/
		public SalaryColumn setColCode(String colCode) {
			super.change(COL_CODE,super.getColCode(),colCode);
			super.setColCode(colCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param colName 名称
		 * @return 当前对象
		*/
		public SalaryColumn setColName(String colName) {
			super.change(COL_NAME,super.getColName(),colName);
			super.setColName(colName);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param colType 类型
		 * @return 当前对象
		*/
		public SalaryColumn setColType(String colType) {
			super.change(COL_TYPE,super.getColType(),colType);
			super.setColType(colType);
			return this;
		}
		
		/**
		 * 设置 值
		 * @param colValue 值
		 * @return 当前对象
		*/
		public SalaryColumn setColValue(BigDecimal colValue) {
			super.change(COL_VALUE,super.getColValue(),colValue);
			super.setColValue(colValue);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dsSource 数据来源
		 * @return 当前对象
		*/
		public SalaryColumn setDsSource(String dsSource) {
			super.change(DS_SOURCE,super.getDsSource(),dsSource);
			super.setDsSource(dsSource);
			return this;
		}
		
		/**
		 * 设置 计算方式
		 * @param calMethod 计算方式
		 * @return 当前对象
		*/
		public SalaryColumn setCalMethod(String calMethod) {
			super.change(CAL_METHOD,super.getCalMethod(),calMethod);
			super.setCalMethod(calMethod);
			return this;
		}
		
		/**
		 * 设置 业务分类
		 * @param busiType 业务分类
		 * @return 当前对象
		*/
		public SalaryColumn setBusiType(String busiType) {
			super.change(BUSI_TYPE,super.getBusiType(),busiType);
			super.setBusiType(busiType);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryColumn setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryColumn setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryColumn setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryColumn setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryColumn setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryColumn setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryColumn setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryColumn setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SalaryColumn setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryColumn setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryColumn clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryColumn duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setColName(this.getColName());
			inst.setNotes(this.getNotes());
			inst.setColCode(this.getColCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setColValue(this.getColValue());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setColType(this.getColType());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setBusiType(this.getBusiType());
			inst.setId(this.getId());
			inst.setCalMethod(this.getCalMethod());
			inst.setDsSource(this.getDsSource());
			inst.clearModifies();
			return inst;
		}

	}
}