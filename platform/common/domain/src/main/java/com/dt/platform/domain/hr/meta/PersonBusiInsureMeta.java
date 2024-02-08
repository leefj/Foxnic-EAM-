package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonBusiInsure;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonBusiInsureType;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-08 08:52:37
 * @sign 79EF666795C2DD537A7B022D1B937AA2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonBusiInsureMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PERSON_ID, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE_CODE="typeCode";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> TYPE_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,TYPE_CODE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 保险单号 , 类型: java.lang.String
	*/
	public static final String BILL_CODE="billCode";
	
	/**
	 * 保险单号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> BILL_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,BILL_CODE, java.lang.String.class, "保险单号", "保险单号", java.lang.String.class, null);
	
	/**
	 * 登记时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 登记时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,RCD_TIME, java.util.Date.class, "登记时间", "登记时间", java.util.Date.class, null);
	
	/**
	 * 保险金额 , 类型: java.math.BigDecimal
	*/
	public static final String PAY="pay";
	
	/**
	 * 保险金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.math.BigDecimal> PAY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PAY, java.math.BigDecimal.class, "保险金额", "保险金额", java.math.BigDecimal.class, null);
	
	/**
	 * 个人支付 , 类型: java.math.BigDecimal
	*/
	public static final String PERSON_PAY="personPay";
	
	/**
	 * 个人支付 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.math.BigDecimal> PERSON_PAY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PERSON_PAY, java.math.BigDecimal.class, "个人支付", "个人支付", java.math.BigDecimal.class, null);
	
	/**
	 * 公司支付 , 类型: java.math.BigDecimal
	*/
	public static final String COMPANY_PAY="companyPay";
	
	/**
	 * 公司支付 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.math.BigDecimal> COMPANY_PAY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,COMPANY_PAY, java.math.BigDecimal.class, "公司支付", "公司支付", java.math.BigDecimal.class, null);
	
	/**
	 * 生效时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 生效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,START_TIME, java.util.Date.class, "生效时间", "生效时间", java.util.Date.class, null);
	
	/**
	 * 失效时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 失效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.util.Date> END_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,END_TIME, java.util.Date.class, "失效时间", "失效时间", java.util.Date.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_IDS="fileIds";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> FILE_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,FILE_IDS, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * personBusiInsureType , 类型: com.dt.platform.domain.hr.PersonBusiInsureType
	*/
	public static final String PERSON_BUSI_INSURE_TYPE="personBusiInsureType";
	
	/**
	 * personBusiInsureType , 类型: com.dt.platform.domain.hr.PersonBusiInsureType
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,com.dt.platform.domain.hr.PersonBusiInsureType> PERSON_BUSI_INSURE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PERSON_BUSI_INSURE_TYPE, com.dt.platform.domain.hr.PersonBusiInsureType.class, "personBusiInsureType", "personBusiInsureType", com.dt.platform.domain.hr.PersonBusiInsureType.class, null);
	
	/**
	 * personJobNumber , 类型: java.lang.String
	*/
	public static final String PERSON_JOB_NUMBER="personJobNumber";
	
	/**
	 * personJobNumber , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> PERSON_JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PERSON_JOB_NUMBER, java.lang.String.class, "personJobNumber", "personJobNumber", java.lang.String.class, null);
	
	/**
	 * personCardNumber , 类型: java.lang.String
	*/
	public static final String PERSON_CARD_NUMBER="personCardNumber";
	
	/**
	 * personCardNumber , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonBusiInsure,java.lang.String> PERSON_CARD_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonBusiInsure.class ,PERSON_CARD_NUMBER, java.lang.String.class, "personCardNumber", "personCardNumber", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PERSON_ID , TYPE_CODE , BILL_CODE , RCD_TIME , PAY , PERSON_PAY , COMPANY_PAY , START_TIME , END_TIME , FILE_IDS , BATCH_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON , PERSON_BUSI_INSURE_TYPE , PERSON_JOB_NUMBER , PERSON_CARD_NUMBER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonBusiInsure {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonBusiInsure setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public PersonBusiInsure setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param personId 姓名
		 * @return 当前对象
		*/
		public PersonBusiInsure setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeCode 类型
		 * @return 当前对象
		*/
		public PersonBusiInsure setTypeCode(String typeCode) {
			super.change(TYPE_CODE,super.getTypeCode(),typeCode);
			super.setTypeCode(typeCode);
			return this;
		}
		
		/**
		 * 设置 保险单号
		 * @param billCode 保险单号
		 * @return 当前对象
		*/
		public PersonBusiInsure setBillCode(String billCode) {
			super.change(BILL_CODE,super.getBillCode(),billCode);
			super.setBillCode(billCode);
			return this;
		}
		
		/**
		 * 设置 登记时间
		 * @param rcdTime 登记时间
		 * @return 当前对象
		*/
		public PersonBusiInsure setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 保险金额
		 * @param pay 保险金额
		 * @return 当前对象
		*/
		public PersonBusiInsure setPay(BigDecimal pay) {
			super.change(PAY,super.getPay(),pay);
			super.setPay(pay);
			return this;
		}
		
		/**
		 * 设置 个人支付
		 * @param personPay 个人支付
		 * @return 当前对象
		*/
		public PersonBusiInsure setPersonPay(BigDecimal personPay) {
			super.change(PERSON_PAY,super.getPersonPay(),personPay);
			super.setPersonPay(personPay);
			return this;
		}
		
		/**
		 * 设置 公司支付
		 * @param companyPay 公司支付
		 * @return 当前对象
		*/
		public PersonBusiInsure setCompanyPay(BigDecimal companyPay) {
			super.change(COMPANY_PAY,super.getCompanyPay(),companyPay);
			super.setCompanyPay(companyPay);
			return this;
		}
		
		/**
		 * 设置 生效时间
		 * @param startTime 生效时间
		 * @return 当前对象
		*/
		public PersonBusiInsure setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 失效时间
		 * @param endTime 失效时间
		 * @return 当前对象
		*/
		public PersonBusiInsure setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileIds 附件
		 * @return 当前对象
		*/
		public PersonBusiInsure setFileIds(String fileIds) {
			super.change(FILE_IDS,super.getFileIds(),fileIds);
			super.setFileIds(fileIds);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public PersonBusiInsure setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonBusiInsure setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonBusiInsure setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonBusiInsure setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonBusiInsure setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonBusiInsure setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonBusiInsure setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonBusiInsure setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonBusiInsure setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonBusiInsure setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonBusiInsure setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonBusiInsure setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 personBusiInsureType
		 * @param personBusiInsureType personBusiInsureType
		 * @return 当前对象
		*/
		public PersonBusiInsure setPersonBusiInsureType(PersonBusiInsureType personBusiInsureType) {
			super.change(PERSON_BUSI_INSURE_TYPE,super.getPersonBusiInsureType(),personBusiInsureType);
			super.setPersonBusiInsureType(personBusiInsureType);
			return this;
		}
		
		/**
		 * 设置 personJobNumber
		 * @param personJobNumber personJobNumber
		 * @return 当前对象
		*/
		public PersonBusiInsure setPersonJobNumber(String personJobNumber) {
			super.change(PERSON_JOB_NUMBER,super.getPersonJobNumber(),personJobNumber);
			super.setPersonJobNumber(personJobNumber);
			return this;
		}
		
		/**
		 * 设置 personCardNumber
		 * @param personCardNumber personCardNumber
		 * @return 当前对象
		*/
		public PersonBusiInsure setPersonCardNumber(String personCardNumber) {
			super.change(PERSON_CARD_NUMBER,super.getPersonCardNumber(),personCardNumber);
			super.setPersonCardNumber(personCardNumber);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonBusiInsure clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonBusiInsure duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setBatchCode(this.getBatchCode());
			inst.setPay(this.getPay());
			inst.setPersonPay(this.getPersonPay());
			inst.setBillCode(this.getBillCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setTypeCode(this.getTypeCode());
			inst.setCompanyPay(this.getCompanyPay());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFileIds(this.getFileIds());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setStartTime(this.getStartTime());
			inst.setId(this.getId());
			inst.setEndTime(this.getEndTime());
			inst.setRcdTime(this.getRcdTime());
			if(all) {
				inst.setPersonBusiInsureType(this.getPersonBusiInsureType());
				inst.setPerson(this.getPerson());
				inst.setPersonCardNumber(this.getPersonCardNumber());
				inst.setPersonJobNumber(this.getPersonJobNumber());
			}
			inst.clearModifies();
			return inst;
		}

	}
}