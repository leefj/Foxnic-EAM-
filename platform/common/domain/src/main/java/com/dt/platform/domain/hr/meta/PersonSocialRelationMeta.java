package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonSocialRelation;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.hr.Person;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-16 12:47:26
 * @sign 2E5232051932D88B591E61466F30D948
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonSocialRelationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,PERSON_ID, java.lang.String.class, "员工", "员工", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,EMPLOYEE_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 关系类型 , 类型: java.lang.String
	*/
	public static final String REL_TYPE="relType";
	
	/**
	 * 关系类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> REL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,REL_TYPE, java.lang.String.class, "关系类型", "关系类型", java.lang.String.class, null);
	
	/**
	 * 关系 , 类型: java.lang.String
	*/
	public static final String REL="rel";
	
	/**
	 * 关系 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> REL_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,REL, java.lang.String.class, "关系", "关系", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 工作单位 , 类型: java.lang.String
	*/
	public static final String WORK_COMPANY="workCompany";
	
	/**
	 * 工作单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> WORK_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,WORK_COMPANY, java.lang.String.class, "工作单位", "工作单位", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONCAT="concat";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> CONCAT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,CONCAT, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 紧急联系人 , 类型: java.lang.String
	*/
	public static final String EMERGENCY_CONTACT="emergencyContact";
	
	/**
	 * 紧急联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> EMERGENCY_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,EMERGENCY_CONTACT, java.lang.String.class, "紧急联系人", "紧急联系人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 关联 , 类型: java.lang.String
	*/
	public static final String REL_ID="relId";
	
	/**
	 * 关联 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> REL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,REL_ID, java.lang.String.class, "关联", "关联", java.lang.String.class, null);
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,org.github.foxnic.web.domain.hrm.Employee> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,PERSON, org.github.foxnic.web.domain.hrm.Employee.class, "person", "person", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * user , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,com.dt.platform.domain.hr.Person> USER_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,USER, com.dt.platform.domain.hr.Person.class, "user", "user", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * role , 类型: java.lang.String
	*/
	public static final String ROLE="role";
	
	/**
	 * role , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,java.lang.String> ROLE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,ROLE, java.lang.String.class, "role", "role", java.lang.String.class, null);
	
	/**
	 * socialRelation , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOCIAL_RELATION="socialRelation";
	
	/**
	 * socialRelation , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,org.github.foxnic.web.domain.system.DictItem> SOCIAL_RELATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,SOCIAL_RELATION, org.github.foxnic.web.domain.system.DictItem.class, "socialRelation", "socialRelation", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * socialRelationType , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOCIAL_RELATION_TYPE="socialRelationType";
	
	/**
	 * socialRelationType , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonSocialRelation,org.github.foxnic.web.domain.system.DictItem> SOCIAL_RELATION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonSocialRelation.class ,SOCIAL_RELATION_TYPE, org.github.foxnic.web.domain.system.DictItem.class, "socialRelationType", "socialRelationType", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , PERSON_ID , EMPLOYEE_ID , REL_TYPE , REL , NAME , WORK_COMPANY , CONCAT , EMERGENCY_CONTACT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REL_ID , PERSON , USER , ROLE , SOCIAL_RELATION , SOCIAL_RELATION_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonSocialRelation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonSocialRelation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PersonSocialRelation setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param personId 员工
		 * @return 当前对象
		*/
		public PersonSocialRelation setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param employeeId 人员
		 * @return 当前对象
		*/
		public PersonSocialRelation setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 关系类型
		 * @param relType 关系类型
		 * @return 当前对象
		*/
		public PersonSocialRelation setRelType(String relType) {
			super.change(REL_TYPE,super.getRelType(),relType);
			super.setRelType(relType);
			return this;
		}
		
		/**
		 * 设置 关系
		 * @param rel 关系
		 * @return 当前对象
		*/
		public PersonSocialRelation setRel(String rel) {
			super.change(REL,super.getRel(),rel);
			super.setRel(rel);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param name 姓名
		 * @return 当前对象
		*/
		public PersonSocialRelation setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 工作单位
		 * @param workCompany 工作单位
		 * @return 当前对象
		*/
		public PersonSocialRelation setWorkCompany(String workCompany) {
			super.change(WORK_COMPANY,super.getWorkCompany(),workCompany);
			super.setWorkCompany(workCompany);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param concat 联系方式
		 * @return 当前对象
		*/
		public PersonSocialRelation setConcat(String concat) {
			super.change(CONCAT,super.getConcat(),concat);
			super.setConcat(concat);
			return this;
		}
		
		/**
		 * 设置 紧急联系人
		 * @param emergencyContact 紧急联系人
		 * @return 当前对象
		*/
		public PersonSocialRelation setEmergencyContact(String emergencyContact) {
			super.change(EMERGENCY_CONTACT,super.getEmergencyContact(),emergencyContact);
			super.setEmergencyContact(emergencyContact);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonSocialRelation setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonSocialRelation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonSocialRelation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonSocialRelation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonSocialRelation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonSocialRelation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonSocialRelation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonSocialRelation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public PersonSocialRelation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonSocialRelation setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 关联
		 * @param relId 关联
		 * @return 当前对象
		*/
		public PersonSocialRelation setRelId(String relId) {
			super.change(REL_ID,super.getRelId(),relId);
			super.setRelId(relId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonSocialRelation setPerson(Employee person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public PersonSocialRelation setUser(Person user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 role
		 * @param role role
		 * @return 当前对象
		*/
		public PersonSocialRelation setRole(String role) {
			super.change(ROLE,super.getRole(),role);
			super.setRole(role);
			return this;
		}
		
		/**
		 * 设置 socialRelation
		 * @param socialRelation socialRelation
		 * @return 当前对象
		*/
		public PersonSocialRelation setSocialRelation(DictItem socialRelation) {
			super.change(SOCIAL_RELATION,super.getSocialRelation(),socialRelation);
			super.setSocialRelation(socialRelation);
			return this;
		}
		
		/**
		 * 设置 socialRelationType
		 * @param socialRelationType socialRelationType
		 * @return 当前对象
		*/
		public PersonSocialRelation setSocialRelationType(DictItem socialRelationType) {
			super.change(SOCIAL_RELATION_TYPE,super.getSocialRelationType(),socialRelationType);
			super.setSocialRelationType(socialRelationType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonSocialRelation clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonSocialRelation duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRelId(this.getRelId());
			inst.setNotes(this.getNotes());
			inst.setEmergencyContact(this.getEmergencyContact());
			inst.setEmployeeId(this.getEmployeeId());
			inst.setRelType(this.getRelType());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setConcat(this.getConcat());
			inst.setVersion(this.getVersion());
			inst.setWorkCompany(this.getWorkCompany());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setRel(this.getRel());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setRole(this.getRole());
				inst.setPerson(this.getPerson());
				inst.setSocialRelationType(this.getSocialRelationType());
				inst.setSocialRelation(this.getSocialRelation());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}