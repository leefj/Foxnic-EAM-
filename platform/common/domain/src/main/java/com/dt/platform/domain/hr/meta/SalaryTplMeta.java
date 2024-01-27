package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryTpl;
import java.util.Date;
import com.dt.platform.domain.hr.SalaryTplItem;
import java.util.List;
import com.dt.platform.domain.hr.SalaryCtl;
import com.dt.platform.domain.hr.SalaryIncomeTax;
import java.math.BigDecimal;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 01:12:48
 * @sign 56908A983DF9EAFB279FB1E32AC2789F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryTplMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 开始上月 , 类型: java.lang.Integer
	*/
	public static final String START_M_DAY="startMDay";
	
	/**
	 * 开始上月 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.Integer> START_M_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,START_M_DAY, java.lang.Integer.class, "开始上月", "开始上月", java.lang.Integer.class, null);
	
	/**
	 * 结束本月 , 类型: java.lang.Integer
	*/
	public static final String END_M_DAY="endMDay";
	
	/**
	 * 结束本月 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.Integer> END_M_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,END_M_DAY, java.lang.Integer.class, "结束本月", "结束本月", java.lang.Integer.class, null);
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,METHOD, java.lang.String.class, "计算公式", "计算公式", java.lang.String.class, null);
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final String METHOD_SCRIPT="methodScript";
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> METHOD_SCRIPT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,METHOD_SCRIPT, java.lang.String.class, "计算公式", "计算公式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * salaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final String SALARY_TPL_ITEM="salaryTplItem";
	
	/**
	 * salaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,com.dt.platform.domain.hr.SalaryTplItem> SALARY_TPL_ITEM_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,SALARY_TPL_ITEM, java.util.List.class, "salaryTplItem", "salaryTplItem", com.dt.platform.domain.hr.SalaryTplItem.class, null);
	
	/**
	 * validSalaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final String VALID_SALARY_TPL_ITEM="validSalaryTplItem";
	
	/**
	 * validSalaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,com.dt.platform.domain.hr.SalaryTplItem> VALID_SALARY_TPL_ITEM_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,VALID_SALARY_TPL_ITEM, java.util.List.class, "validSalaryTplItem", "validSalaryTplItem", com.dt.platform.domain.hr.SalaryTplItem.class, null);
	
	/**
	 * salaryCtl , 类型: com.dt.platform.domain.hr.SalaryCtl
	*/
	public static final String SALARY_CTL="salaryCtl";
	
	/**
	 * salaryCtl , 类型: com.dt.platform.domain.hr.SalaryCtl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,com.dt.platform.domain.hr.SalaryCtl> SALARY_CTL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,SALARY_CTL, com.dt.platform.domain.hr.SalaryCtl.class, "salaryCtl", "salaryCtl", com.dt.platform.domain.hr.SalaryCtl.class, null);
	
	/**
	 * salaryIncomeTaxList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryIncomeTax
	*/
	public static final String SALARY_INCOME_TAX_LIST="salaryIncomeTaxList";
	
	/**
	 * salaryIncomeTaxList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryIncomeTax
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,com.dt.platform.domain.hr.SalaryIncomeTax> SALARY_INCOME_TAX_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,SALARY_INCOME_TAX_LIST, java.util.List.class, "salaryIncomeTaxList", "salaryIncomeTaxList", com.dt.platform.domain.hr.SalaryIncomeTax.class, null);
	
	/**
	 * confNonConversionRatio , 类型: java.math.BigDecimal
	*/
	public static final String CONF_NON_CONVERSION_RATIO="confNonConversionRatio";
	
	/**
	 * confNonConversionRatio , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.math.BigDecimal> CONF_NON_CONVERSION_RATIO_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,CONF_NON_CONVERSION_RATIO, java.math.BigDecimal.class, "confNonConversionRatio", "confNonConversionRatio", java.math.BigDecimal.class, null);
	
	/**
	 * confCurMonth , 类型: java.lang.String
	*/
	public static final String CONF_CUR_MONTH="confCurMonth";
	
	/**
	 * confCurMonth , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTpl,java.lang.String> CONF_CUR_MONTH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTpl.class ,CONF_CUR_MONTH, java.lang.String.class, "confCurMonth", "confCurMonth", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , START_M_DAY , END_M_DAY , METHOD , METHOD_SCRIPT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SALARY_TPL_ITEM , VALID_SALARY_TPL_ITEM , SALARY_CTL , SALARY_INCOME_TAX_LIST , CONF_NON_CONVERSION_RATIO , CONF_CUR_MONTH };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryTpl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryTpl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public SalaryTpl setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SalaryTpl setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 开始上月
		 * @param startMDay 开始上月
		 * @return 当前对象
		*/
		public SalaryTpl setStartMDay(Integer startMDay) {
			super.change(START_M_DAY,super.getStartMDay(),startMDay);
			super.setStartMDay(startMDay);
			return this;
		}
		
		/**
		 * 设置 结束本月
		 * @param endMDay 结束本月
		 * @return 当前对象
		*/
		public SalaryTpl setEndMDay(Integer endMDay) {
			super.change(END_M_DAY,super.getEndMDay(),endMDay);
			super.setEndMDay(endMDay);
			return this;
		}
		
		/**
		 * 设置 计算公式
		 * @param method 计算公式
		 * @return 当前对象
		*/
		public SalaryTpl setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 计算公式
		 * @param methodScript 计算公式
		 * @return 当前对象
		*/
		public SalaryTpl setMethodScript(String methodScript) {
			super.change(METHOD_SCRIPT,super.getMethodScript(),methodScript);
			super.setMethodScript(methodScript);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryTpl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryTpl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryTpl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryTpl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryTpl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryTpl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryTpl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryTpl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SalaryTpl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryTpl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 salaryTplItem
		 * @param salaryTplItem salaryTplItem
		 * @return 当前对象
		*/
		public SalaryTpl setSalaryTplItem(List<SalaryTplItem> salaryTplItem) {
			super.change(SALARY_TPL_ITEM,super.getSalaryTplItem(),salaryTplItem);
			super.setSalaryTplItem(salaryTplItem);
			return this;
		}
		
		/**
		 * 设置 validSalaryTplItem
		 * @param validSalaryTplItem validSalaryTplItem
		 * @return 当前对象
		*/
		public SalaryTpl setValidSalaryTplItem(List<SalaryTplItem> validSalaryTplItem) {
			super.change(VALID_SALARY_TPL_ITEM,super.getValidSalaryTplItem(),validSalaryTplItem);
			super.setValidSalaryTplItem(validSalaryTplItem);
			return this;
		}
		
		/**
		 * 设置 salaryCtl
		 * @param salaryCtl salaryCtl
		 * @return 当前对象
		*/
		public SalaryTpl setSalaryCtl(SalaryCtl salaryCtl) {
			super.change(SALARY_CTL,super.getSalaryCtl(),salaryCtl);
			super.setSalaryCtl(salaryCtl);
			return this;
		}
		
		/**
		 * 设置 salaryIncomeTaxList
		 * @param salaryIncomeTaxList salaryIncomeTaxList
		 * @return 当前对象
		*/
		public SalaryTpl setSalaryIncomeTaxList(List<SalaryIncomeTax> salaryIncomeTaxList) {
			super.change(SALARY_INCOME_TAX_LIST,super.getSalaryIncomeTaxList(),salaryIncomeTaxList);
			super.setSalaryIncomeTaxList(salaryIncomeTaxList);
			return this;
		}
		
		/**
		 * 设置 confNonConversionRatio
		 * @param confNonConversionRatio confNonConversionRatio
		 * @return 当前对象
		*/
		public SalaryTpl setConfNonConversionRatio(BigDecimal confNonConversionRatio) {
			super.change(CONF_NON_CONVERSION_RATIO,super.getConfNonConversionRatio(),confNonConversionRatio);
			super.setConfNonConversionRatio(confNonConversionRatio);
			return this;
		}
		
		/**
		 * 设置 confCurMonth
		 * @param confCurMonth confCurMonth
		 * @return 当前对象
		*/
		public SalaryTpl setConfCurMonth(String confCurMonth) {
			super.change(CONF_CUR_MONTH,super.getConfCurMonth(),confCurMonth);
			super.setConfCurMonth(confCurMonth);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryTpl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryTpl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setStartMDay(this.getStartMDay());
			inst.setMethodScript(this.getMethodScript());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setMethod(this.getMethod());
			inst.setEndMDay(this.getEndMDay());
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
			if(all) {
				inst.setSalaryCtl(this.getSalaryCtl());
				inst.setConfCurMonth(this.getConfCurMonth());
				inst.setSalaryTplItem(this.getSalaryTplItem());
				inst.setSalaryIncomeTaxList(this.getSalaryIncomeTaxList());
				inst.setValidSalaryTplItem(this.getValidSalaryTplItem());
				inst.setConfNonConversionRatio(this.getConfNonConversionRatio());
			}
			inst.clearModifies();
			return inst;
		}

	}
}