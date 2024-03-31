package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonEducation;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.Person;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-26 21:45:00
 * @sign 2A9E10901BEC16F41AB8662F1F2D18E9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonEducationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,PERSON_ID, java.lang.String.class, "员工", "员工", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,EMPLOYEE_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 学历 , 类型: java.lang.String
	*/
	public static final String EDUCATION="education";
	
	/**
	 * 学历 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> EDUCATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,EDUCATION, java.lang.String.class, "学历", "学历", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String S_TIME="sTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.util.Date> S_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,S_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String E_TIME="eTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.util.Date> E_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,E_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 毕业院校 , 类型: java.lang.String
	*/
	public static final String EDUCATIONAL_INSTITUTIONS="educationalInstitutions";
	
	/**
	 * 毕业院校 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> EDUCATIONAL_INSTITUTIONS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,EDUCATIONAL_INSTITUTIONS, java.lang.String.class, "毕业院校", "毕业院校", java.lang.String.class, null);
	
	/**
	 * 所学专业 , 类型: java.lang.String
	*/
	public static final String MAJOY_STUDIED="majoyStudied";
	
	/**
	 * 所学专业 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> MAJOY_STUDIED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,MAJOY_STUDIED, java.lang.String.class, "所学专业", "所学专业", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_IDS="fileIds";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> FILE_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,FILE_IDS, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 关联 , 类型: java.lang.String
	*/
	public static final String REL_ID="relId";
	
	/**
	 * 关联 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> REL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,REL_ID, java.lang.String.class, "关联", "关联", java.lang.String.class, null);
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,org.github.foxnic.web.domain.hrm.Employee> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,PERSON, org.github.foxnic.web.domain.hrm.Employee.class, "person", "person", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * educationInfo , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String EDUCATION_INFO="educationInfo";
	
	/**
	 * educationInfo , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,org.github.foxnic.web.domain.system.DictItem> EDUCATION_INFO_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,EDUCATION_INFO, org.github.foxnic.web.domain.system.DictItem.class, "educationInfo", "educationInfo", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * user , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,com.dt.platform.domain.hr.Person> USER_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,USER, com.dt.platform.domain.hr.Person.class, "user", "user", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * role , 类型: java.lang.String
	*/
	public static final String ROLE="role";
	
	/**
	 * role , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonEducation,java.lang.String> ROLE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonEducation.class ,ROLE, java.lang.String.class, "role", "role", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , PERSON_ID , EMPLOYEE_ID , EDUCATION , S_TIME , E_TIME , EDUCATIONAL_INSTITUTIONS , MAJOY_STUDIED , NOTES , FILE_IDS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID , PERSON , EDUCATION_INFO , USER , ROLE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonEducation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonEducation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PersonEducation setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param personId 员工
		 * @return 当前对象
		*/
		public PersonEducation setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param employeeId 人员
		 * @return 当前对象
		*/
		public PersonEducation setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 学历
		 * @param education 学历
		 * @return 当前对象
		*/
		public PersonEducation setEducation(String education) {
			super.change(EDUCATION,super.getEducation(),education);
			super.setEducation(education);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param sTime 开始时间
		 * @return 当前对象
		*/
		public PersonEducation setSTime(Date sTime) {
			super.change(S_TIME,super.getSTime(),sTime);
			super.setSTime(sTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param eTime 结束时间
		 * @return 当前对象
		*/
		public PersonEducation setETime(Date eTime) {
			super.change(E_TIME,super.getETime(),eTime);
			super.setETime(eTime);
			return this;
		}
		
		/**
		 * 设置 毕业院校
		 * @param educationalInstitutions 毕业院校
		 * @return 当前对象
		*/
		public PersonEducation setEducationalInstitutions(String educationalInstitutions) {
			super.change(EDUCATIONAL_INSTITUTIONS,super.getEducationalInstitutions(),educationalInstitutions);
			super.setEducationalInstitutions(educationalInstitutions);
			return this;
		}
		
		/**
		 * 设置 所学专业
		 * @param majoyStudied 所学专业
		 * @return 当前对象
		*/
		public PersonEducation setMajoyStudied(String majoyStudied) {
			super.change(MAJOY_STUDIED,super.getMajoyStudied(),majoyStudied);
			super.setMajoyStudied(majoyStudied);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonEducation setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileIds 附件
		 * @return 当前对象
		*/
		public PersonEducation setFileIds(String fileIds) {
			super.change(FILE_IDS,super.getFileIds(),fileIds);
			super.setFileIds(fileIds);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonEducation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonEducation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonEducation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonEducation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonEducation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonEducation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonEducation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public PersonEducation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonEducation setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 关联
		 * @param relId 关联
		 * @return 当前对象
		*/
		public PersonEducation setRelId(String relId) {
			super.change(REL_ID,super.getRelId(),relId);
			super.setRelId(relId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonEducation setPerson(Employee person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 educationInfo
		 * @param educationInfo educationInfo
		 * @return 当前对象
		*/
		public PersonEducation setEducationInfo(DictItem educationInfo) {
			super.change(EDUCATION_INFO,super.getEducationInfo(),educationInfo);
			super.setEducationInfo(educationInfo);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public PersonEducation setUser(Person user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 role
		 * @param role role
		 * @return 当前对象
		*/
		public PersonEducation setRole(String role) {
			super.change(ROLE,super.getRole(),role);
			super.setRole(role);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonEducation clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonEducation duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setEducationalInstitutions(this.getEducationalInstitutions());
			inst.setRelId(this.getRelId());
			inst.setEducation(this.getEducation());
			inst.setNotes(this.getNotes());
			inst.setETime(this.getETime());
			inst.setEmployeeId(this.getEmployeeId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFileIds(this.getFileIds());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setSTime(this.getSTime());
			inst.setMajoyStudied(this.getMajoyStudied());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setRole(this.getRole());
				inst.setEducationInfo(this.getEducationInfo());
				inst.setPerson(this.getPerson());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}