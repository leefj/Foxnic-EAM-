package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryCtl;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-27 18:33:33
 * @sign 18568B51DF1F010C9C60053650E60715
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryCtlMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 是否参与 , 类型: java.lang.String
	*/
	public static final String VALUE_EN="valueEn";
	
	/**
	 * 是否参与 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> VALUE_EN_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,VALUE_EN, java.lang.String.class, "是否参与", "是否参与", java.lang.String.class, null);
	
	/**
	 * 字符串数值 , 类型: java.lang.String
	*/
	public static final String VALUE_STR="valueStr";
	
	/**
	 * 字符串数值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> VALUE_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,VALUE_STR, java.lang.String.class, "字符串数值", "字符串数值", java.lang.String.class, null);
	
	/**
	 * 浮点数值 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_D="valueD";
	
	/**
	 * 浮点数值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> VALUE_D_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,VALUE_D, java.math.BigDecimal.class, "浮点数值", "浮点数值", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * deductionBase , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCTION_BASE="deductionBase";
	
	/**
	 * deductionBase , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> DEDUCTION_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,DEDUCTION_BASE, java.math.BigDecimal.class, "deductionBase", "deductionBase", java.math.BigDecimal.class, null);
	
	/**
	 * nonConversionRatio , 类型: java.math.BigDecimal
	*/
	public static final String NON_CONVERSION_RATIO="nonConversionRatio";
	
	/**
	 * nonConversionRatio , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> NON_CONVERSION_RATIO_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,NON_CONVERSION_RATIO, java.math.BigDecimal.class, "nonConversionRatio", "nonConversionRatio", java.math.BigDecimal.class, null);
	
	/**
	 * isHighTemperatureMonth , 类型: java.lang.String
	*/
	public static final String IS_HIGH_TEMPERATURE_MONTH="isHighTemperatureMonth";
	
	/**
	 * isHighTemperatureMonth , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.lang.String> IS_HIGH_TEMPERATURE_MONTH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,IS_HIGH_TEMPERATURE_MONTH, java.lang.String.class, "isHighTemperatureMonth", "isHighTemperatureMonth", java.lang.String.class, null);
	
	/**
	 * welfareZfgjjPerson , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_PERSON="welfareZfgjjPerson";
	
	/**
	 * welfareZfgjjPerson , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> WELFARE_ZFGJJ_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,WELFARE_ZFGJJ_PERSON, java.math.BigDecimal.class, "welfareZfgjjPerson", "welfareZfgjjPerson", java.math.BigDecimal.class, null);
	
	/**
	 * welfaerYlbxPerson , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_PERSON="welfaerYlbxPerson";
	
	/**
	 * welfaerYlbxPerson , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> WELFAER_YLBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,WELFAER_YLBX_PERSON, java.math.BigDecimal.class, "welfaerYlbxPerson", "welfaerYlbxPerson", java.math.BigDecimal.class, null);
	
	/**
	 * welfaeryrbxPerson , 类型: java.math.BigDecimal
	*/
	public static final String WELFAERYRBX_PERSON="welfaeryrbxPerson";
	
	/**
	 * welfaeryrbxPerson , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> WELFAERYRBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,WELFAERYRBX_PERSON, java.math.BigDecimal.class, "welfaeryrbxPerson", "welfaeryrbxPerson", java.math.BigDecimal.class, null);
	
	/**
	 * welfaerSyebxPerson , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_PERSON="welfaerSyebxPerson";
	
	/**
	 * welfaerSyebxPerson , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> WELFAER_SYEBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,WELFAER_SYEBX_PERSON, java.math.BigDecimal.class, "welfaerSyebxPerson", "welfaerSyebxPerson", java.math.BigDecimal.class, null);
	
	/**
	 * welfaerGsbxPerson , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_PERSON="welfaerGsbxPerson";
	
	/**
	 * welfaerGsbxPerson , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> WELFAER_GSBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,WELFAER_GSBX_PERSON, java.math.BigDecimal.class, "welfaerGsbxPerson", "welfaerGsbxPerson", java.math.BigDecimal.class, null);
	
	/**
	 * welfaerSybxPerson , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_PERSON="welfaerSybxPerson";
	
	/**
	 * welfaerSybxPerson , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryCtl,java.math.BigDecimal> WELFAER_SYBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryCtl.class ,WELFAER_SYBX_PERSON, java.math.BigDecimal.class, "welfaerSybxPerson", "welfaerSybxPerson", java.math.BigDecimal.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , TYPE , VALUE_EN , VALUE_STR , VALUE_D , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , DEDUCTION_BASE , NON_CONVERSION_RATIO , IS_HIGH_TEMPERATURE_MONTH , WELFARE_ZFGJJ_PERSON , WELFAER_YLBX_PERSON , WELFAERYRBX_PERSON , WELFAER_SYEBX_PERSON , WELFAER_GSBX_PERSON , WELFAER_SYBX_PERSON };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryCtl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryCtl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public SalaryCtl setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SalaryCtl setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public SalaryCtl setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 是否参与
		 * @param valueEn 是否参与
		 * @return 当前对象
		*/
		public SalaryCtl setValueEn(String valueEn) {
			super.change(VALUE_EN,super.getValueEn(),valueEn);
			super.setValueEn(valueEn);
			return this;
		}
		
		/**
		 * 设置 字符串数值
		 * @param valueStr 字符串数值
		 * @return 当前对象
		*/
		public SalaryCtl setValueStr(String valueStr) {
			super.change(VALUE_STR,super.getValueStr(),valueStr);
			super.setValueStr(valueStr);
			return this;
		}
		
		/**
		 * 设置 浮点数值
		 * @param valueD 浮点数值
		 * @return 当前对象
		*/
		public SalaryCtl setValueD(BigDecimal valueD) {
			super.change(VALUE_D,super.getValueD(),valueD);
			super.setValueD(valueD);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryCtl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryCtl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryCtl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryCtl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryCtl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryCtl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryCtl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryCtl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SalaryCtl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryCtl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 deductionBase
		 * @param deductionBase deductionBase
		 * @return 当前对象
		*/
		public SalaryCtl setDeductionBase(BigDecimal deductionBase) {
			super.change(DEDUCTION_BASE,super.getDeductionBase(),deductionBase);
			super.setDeductionBase(deductionBase);
			return this;
		}
		
		/**
		 * 设置 nonConversionRatio
		 * @param nonConversionRatio nonConversionRatio
		 * @return 当前对象
		*/
		public SalaryCtl setNonConversionRatio(BigDecimal nonConversionRatio) {
			super.change(NON_CONVERSION_RATIO,super.getNonConversionRatio(),nonConversionRatio);
			super.setNonConversionRatio(nonConversionRatio);
			return this;
		}
		
		/**
		 * 设置 isHighTemperatureMonth
		 * @param isHighTemperatureMonth isHighTemperatureMonth
		 * @return 当前对象
		*/
		public SalaryCtl setIsHighTemperatureMonth(String isHighTemperatureMonth) {
			super.change(IS_HIGH_TEMPERATURE_MONTH,super.getIsHighTemperatureMonth(),isHighTemperatureMonth);
			super.setIsHighTemperatureMonth(isHighTemperatureMonth);
			return this;
		}
		
		/**
		 * 设置 welfareZfgjjPerson
		 * @param welfareZfgjjPerson welfareZfgjjPerson
		 * @return 当前对象
		*/
		public SalaryCtl setWelfareZfgjjPerson(BigDecimal welfareZfgjjPerson) {
			super.change(WELFARE_ZFGJJ_PERSON,super.getWelfareZfgjjPerson(),welfareZfgjjPerson);
			super.setWelfareZfgjjPerson(welfareZfgjjPerson);
			return this;
		}
		
		/**
		 * 设置 welfaerYlbxPerson
		 * @param welfaerYlbxPerson welfaerYlbxPerson
		 * @return 当前对象
		*/
		public SalaryCtl setWelfaerYlbxPerson(BigDecimal welfaerYlbxPerson) {
			super.change(WELFAER_YLBX_PERSON,super.getWelfaerYlbxPerson(),welfaerYlbxPerson);
			super.setWelfaerYlbxPerson(welfaerYlbxPerson);
			return this;
		}
		
		/**
		 * 设置 welfaeryrbxPerson
		 * @param welfaeryrbxPerson welfaeryrbxPerson
		 * @return 当前对象
		*/
		public SalaryCtl setWelfaeryrbxPerson(BigDecimal welfaeryrbxPerson) {
			super.change(WELFAERYRBX_PERSON,super.getWelfaeryrbxPerson(),welfaeryrbxPerson);
			super.setWelfaeryrbxPerson(welfaeryrbxPerson);
			return this;
		}
		
		/**
		 * 设置 welfaerSyebxPerson
		 * @param welfaerSyebxPerson welfaerSyebxPerson
		 * @return 当前对象
		*/
		public SalaryCtl setWelfaerSyebxPerson(BigDecimal welfaerSyebxPerson) {
			super.change(WELFAER_SYEBX_PERSON,super.getWelfaerSyebxPerson(),welfaerSyebxPerson);
			super.setWelfaerSyebxPerson(welfaerSyebxPerson);
			return this;
		}
		
		/**
		 * 设置 welfaerGsbxPerson
		 * @param welfaerGsbxPerson welfaerGsbxPerson
		 * @return 当前对象
		*/
		public SalaryCtl setWelfaerGsbxPerson(BigDecimal welfaerGsbxPerson) {
			super.change(WELFAER_GSBX_PERSON,super.getWelfaerGsbxPerson(),welfaerGsbxPerson);
			super.setWelfaerGsbxPerson(welfaerGsbxPerson);
			return this;
		}
		
		/**
		 * 设置 welfaerSybxPerson
		 * @param welfaerSybxPerson welfaerSybxPerson
		 * @return 当前对象
		*/
		public SalaryCtl setWelfaerSybxPerson(BigDecimal welfaerSybxPerson) {
			super.change(WELFAER_SYBX_PERSON,super.getWelfaerSybxPerson(),welfaerSybxPerson);
			super.setWelfaerSybxPerson(welfaerSybxPerson);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryCtl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryCtl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setValueStr(this.getValueStr());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setValueEn(this.getValueEn());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setValueD(this.getValueD());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setIsHighTemperatureMonth(this.getIsHighTemperatureMonth());
				inst.setWelfaerSyebxPerson(this.getWelfaerSyebxPerson());
				inst.setWelfaerSybxPerson(this.getWelfaerSybxPerson());
				inst.setNonConversionRatio(this.getNonConversionRatio());
				inst.setWelfaerGsbxPerson(this.getWelfaerGsbxPerson());
				inst.setDeductionBase(this.getDeductionBase());
				inst.setWelfaeryrbxPerson(this.getWelfaeryrbxPerson());
				inst.setWelfaerYlbxPerson(this.getWelfaerYlbxPerson());
				inst.setWelfareZfgjjPerson(this.getWelfareZfgjjPerson());
			}
			inst.clearModifies();
			return inst;
		}

	}
}