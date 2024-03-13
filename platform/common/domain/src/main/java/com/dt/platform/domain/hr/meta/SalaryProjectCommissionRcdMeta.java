package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryProjectCommissionRcd;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.SalaryProjectCommission;
import com.dt.platform.domain.hr.Person;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-01 20:32:22
 * @sign 0FD8B0CF96D4B99D4BEC16A39191F0A5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryProjectCommissionRcdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PERSON_ID, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String JOB_NUMBER="jobNumber";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,JOB_NUMBER, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 项目编码 , 类型: java.lang.String
	*/
	public static final String PROJECT_CODE="projectCode";
	
	/**
	 * 项目编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> PROJECT_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PROJECT_CODE, java.lang.String.class, "项目编码", "项目编码", java.lang.String.class, null);
	
	/**
	 * 项目名称 , 类型: java.lang.String
	*/
	public static final String PROJECT_NAME="projectName";
	
	/**
	 * 项目名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> PROJECT_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PROJECT_NAME, java.lang.String.class, "项目名称", "项目名称", java.lang.String.class, null);
	
	/**
	 * 提成比例 , 类型: java.lang.String
	*/
	public static final String PROJECT_COMMISSION_RATIO="projectCommissionRatio";
	
	/**
	 * 提成比例 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> PROJECT_COMMISSION_RATIO_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PROJECT_COMMISSION_RATIO, java.lang.String.class, "提成比例", "提成比例", java.lang.String.class, null);
	
	/**
	 * 业务量 , 类型: java.math.BigDecimal
	*/
	public static final String BUSINESS_VALUE="businessValue";
	
	/**
	 * 业务量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.math.BigDecimal> BUSINESS_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,BUSINESS_VALUE, java.math.BigDecimal.class, "业务量", "业务量", java.math.BigDecimal.class, null);
	
	/**
	 * 提成金额 , 类型: java.math.BigDecimal
	*/
	public static final String COMMISSION_SALARY="commissionSalary";
	
	/**
	 * 提成金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.math.BigDecimal> COMMISSION_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,COMMISSION_SALARY, java.math.BigDecimal.class, "提成金额", "提成金额", java.math.BigDecimal.class, null);
	
	/**
	 * 记录日期 , 类型: java.util.Date
	*/
	public static final String RCD_DATE="rcdDate";
	
	/**
	 * 记录日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.util.Date> RCD_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,RCD_DATE, java.util.Date.class, "记录日期", "记录日期", java.util.Date.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_IDS="fileIds";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> FILE_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,FILE_IDS, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * project , 类型: com.dt.platform.domain.hr.SalaryProjectCommission
	*/
	public static final String PROJECT="project";
	
	/**
	 * project , 类型: com.dt.platform.domain.hr.SalaryProjectCommission
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,com.dt.platform.domain.hr.SalaryProjectCommission> PROJECT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PROJECT, com.dt.platform.domain.hr.SalaryProjectCommission.class, "project", "project", com.dt.platform.domain.hr.SalaryProjectCommission.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * projectCodeValue , 类型: java.lang.String
	*/
	public static final String PROJECT_CODE_VALUE="projectCodeValue";
	
	/**
	 * projectCodeValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryProjectCommissionRcd,java.lang.String> PROJECT_CODE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryProjectCommissionRcd.class ,PROJECT_CODE_VALUE, java.lang.String.class, "projectCodeValue", "projectCodeValue", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PERSON_ID , JOB_NUMBER , PROJECT_CODE , PROJECT_NAME , PROJECT_COMMISSION_RATIO , BUSINESS_VALUE , COMMISSION_SALARY , RCD_DATE , BATCH_CODE , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PROJECT , PERSON , PROJECT_CODE_VALUE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryProjectCommissionRcd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param personId 姓名
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param jobNumber 工号
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setJobNumber(String jobNumber) {
			super.change(JOB_NUMBER,super.getJobNumber(),jobNumber);
			super.setJobNumber(jobNumber);
			return this;
		}
		
		/**
		 * 设置 项目编码
		 * @param projectCode 项目编码
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setProjectCode(String projectCode) {
			super.change(PROJECT_CODE,super.getProjectCode(),projectCode);
			super.setProjectCode(projectCode);
			return this;
		}
		
		/**
		 * 设置 项目名称
		 * @param projectName 项目名称
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setProjectName(String projectName) {
			super.change(PROJECT_NAME,super.getProjectName(),projectName);
			super.setProjectName(projectName);
			return this;
		}
		
		/**
		 * 设置 提成比例
		 * @param projectCommissionRatio 提成比例
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setProjectCommissionRatio(String projectCommissionRatio) {
			super.change(PROJECT_COMMISSION_RATIO,super.getProjectCommissionRatio(),projectCommissionRatio);
			super.setProjectCommissionRatio(projectCommissionRatio);
			return this;
		}
		
		/**
		 * 设置 业务量
		 * @param businessValue 业务量
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setBusinessValue(BigDecimal businessValue) {
			super.change(BUSINESS_VALUE,super.getBusinessValue(),businessValue);
			super.setBusinessValue(businessValue);
			return this;
		}
		
		/**
		 * 设置 提成金额
		 * @param commissionSalary 提成金额
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setCommissionSalary(BigDecimal commissionSalary) {
			super.change(COMMISSION_SALARY,super.getCommissionSalary(),commissionSalary);
			super.setCommissionSalary(commissionSalary);
			return this;
		}
		
		/**
		 * 设置 记录日期
		 * @param rcdDate 记录日期
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setRcdDate(Date rcdDate) {
			super.change(RCD_DATE,super.getRcdDate(),rcdDate);
			super.setRcdDate(rcdDate);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileIds 附件
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setFileIds(String fileIds) {
			super.change(FILE_IDS,super.getFileIds(),fileIds);
			super.setFileIds(fileIds);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 project
		 * @param project project
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setProject(SalaryProjectCommission project) {
			super.change(PROJECT,super.getProject(),project);
			super.setProject(project);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 projectCodeValue
		 * @param projectCodeValue projectCodeValue
		 * @return 当前对象
		*/
		public SalaryProjectCommissionRcd setProjectCodeValue(String projectCodeValue) {
			super.change(PROJECT_CODE_VALUE,super.getProjectCodeValue(),projectCodeValue);
			super.setProjectCodeValue(projectCodeValue);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryProjectCommissionRcd clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryProjectCommissionRcd duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setBatchCode(this.getBatchCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setProjectCode(this.getProjectCode());
			inst.setFileIds(this.getFileIds());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setProjectCommissionRatio(this.getProjectCommissionRatio());
			inst.setRcdDate(this.getRcdDate());
			inst.setBusinessValue(this.getBusinessValue());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setProjectName(this.getProjectName());
			inst.setCommissionSalary(this.getCommissionSalary());
			inst.setJobNumber(this.getJobNumber());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setProjectCodeValue(this.getProjectCodeValue());
				inst.setProject(this.getProject());
			}
			inst.clearModifies();
			return inst;
		}

	}
}