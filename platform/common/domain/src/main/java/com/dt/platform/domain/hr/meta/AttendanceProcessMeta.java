package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceProcess;
import java.util.Date;
import com.dt.platform.domain.hr.Person;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-26 09:26:55
 * @sign 2182BA6100C450EF9E6B9E76520C5E10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceProcessMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 所有人员 , 类型: java.lang.String
	*/
	public static final String IS_ALL_PERSON="isAllPerson";
	
	/**
	 * 所有人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> IS_ALL_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,IS_ALL_PERSON, java.lang.String.class, "所有人员", "所有人员", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String SDATE="sdate";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.util.Date> SDATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,SDATE, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String EDATE="edate";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.util.Date> EDATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,EDATE, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * personList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON_LIST="personList";
	
	/**
	 * personList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,com.dt.platform.domain.hr.Person> PERSON_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,PERSON_LIST, java.util.List.class, "personList", "personList", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * personIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PERSON_IDS="personIds";
	
	/**
	 * personIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> PERSON_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,PERSON_IDS, java.util.List.class, "personIds", "personIds", java.lang.String.class, null);
	
	/**
	 * organizationList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION_LIST="organizationList";
	
	/**
	 * organizationList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,ORGANIZATION_LIST, java.util.List.class, "organizationList", "organizationList", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * organizationIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ORGANIZATION_IDS="organizationIds";
	
	/**
	 * organizationIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceProcess,java.lang.String> ORGANIZATION_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceProcess.class ,ORGANIZATION_IDS, java.util.List.class, "organizationIds", "organizationIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , IS_ALL_PERSON , SDATE , EDATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON_LIST , PERSON_IDS , ORGANIZATION_LIST , ORGANIZATION_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceProcess {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceProcess setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AttendanceProcess setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 所有人员
		 * @param isAllPerson 所有人员
		 * @return 当前对象
		*/
		public AttendanceProcess setIsAllPerson(String isAllPerson) {
			super.change(IS_ALL_PERSON,super.getIsAllPerson(),isAllPerson);
			super.setIsAllPerson(isAllPerson);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param sdate 开始时间
		 * @return 当前对象
		*/
		public AttendanceProcess setSdate(Date sdate) {
			super.change(SDATE,super.getSdate(),sdate);
			super.setSdate(sdate);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param edate 开始时间
		 * @return 当前对象
		*/
		public AttendanceProcess setEdate(Date edate) {
			super.change(EDATE,super.getEdate(),edate);
			super.setEdate(edate);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AttendanceProcess setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceProcess setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceProcess setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceProcess setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceProcess setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceProcess setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceProcess setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceProcess setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceProcess setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceProcess setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 personList
		 * @param personList personList
		 * @return 当前对象
		*/
		public AttendanceProcess setPersonList(List<Person> personList) {
			super.change(PERSON_LIST,super.getPersonList(),personList);
			super.setPersonList(personList);
			return this;
		}
		
		/**
		 * 设置 personIds
		 * @param personIds personIds
		 * @return 当前对象
		*/
		public AttendanceProcess setPersonIds(List<String> personIds) {
			super.change(PERSON_IDS,super.getPersonIds(),personIds);
			super.setPersonIds(personIds);
			return this;
		}
		
		/**
		 * 设置 organizationList
		 * @param organizationList organizationList
		 * @return 当前对象
		*/
		public AttendanceProcess setOrganizationList(List<Organization> organizationList) {
			super.change(ORGANIZATION_LIST,super.getOrganizationList(),organizationList);
			super.setOrganizationList(organizationList);
			return this;
		}
		
		/**
		 * 设置 organizationIds
		 * @param organizationIds organizationIds
		 * @return 当前对象
		*/
		public AttendanceProcess setOrganizationIds(List<String> organizationIds) {
			super.change(ORGANIZATION_IDS,super.getOrganizationIds(),organizationIds);
			super.setOrganizationIds(organizationIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceProcess clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceProcess duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSdate(this.getSdate());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setEdate(this.getEdate());
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
			inst.setIsAllPerson(this.getIsAllPerson());
			if(all) {
				inst.setPersonList(this.getPersonList());
				inst.setOrganizationIds(this.getOrganizationIds());
				inst.setOrganizationList(this.getOrganizationList());
				inst.setPersonIds(this.getPersonIds());
			}
			inst.clearModifies();
			return inst;
		}

	}
}