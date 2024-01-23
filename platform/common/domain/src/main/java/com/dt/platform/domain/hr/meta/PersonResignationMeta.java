package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonResignation;
import java.util.Date;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.Position;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:03
 * @sign 4F05A9D38238283327ECF06C6DC177DA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonResignationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,PERSON_ID, java.lang.String.class, "员工", "员工", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 离职日期 , 类型: java.util.Date
	*/
	public static final String RESIGNATION_DATE="resignationDate";
	
	/**
	 * 离职日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.util.Date> RESIGNATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,RESIGNATION_DATE, java.util.Date.class, "离职日期", "离职日期", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> NOTE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,OPER_USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * position , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * position , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonResignation,com.dt.platform.domain.hr.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonResignation.class ,POSITION, com.dt.platform.domain.hr.Position.class, "position", "position", com.dt.platform.domain.hr.Position.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PERSON_ID , CONTENT , RESIGNATION_DATE , NOTE , OPER_USER_ID , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON , POSITION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonResignation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonResignation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param personId 员工
		 * @return 当前对象
		*/
		public PersonResignation setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public PersonResignation setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 离职日期
		 * @param resignationDate 离职日期
		 * @return 当前对象
		*/
		public PersonResignation setResignationDate(Date resignationDate) {
			super.change(RESIGNATION_DATE,super.getResignationDate(),resignationDate);
			super.setResignationDate(resignationDate);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public PersonResignation setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUserId 操作人
		 * @return 当前对象
		*/
		public PersonResignation setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operTime 操作时间
		 * @return 当前对象
		*/
		public PersonResignation setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonResignation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonResignation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonResignation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonResignation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonResignation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonResignation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonResignation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonResignation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonResignation setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonResignation setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 position
		 * @param position position
		 * @return 当前对象
		*/
		public PersonResignation setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonResignation clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonResignation duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNote(this.getNote());
			inst.setOperUserId(this.getOperUserId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setResignationDate(this.getResignationDate());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setOperTime(this.getOperTime());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setPosition(this.getPosition());
			}
			inst.clearModifies();
			return inst;
		}

	}
}