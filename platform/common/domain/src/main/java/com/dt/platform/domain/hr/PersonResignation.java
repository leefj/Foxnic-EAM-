package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_RESIGNATION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonResignationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工离职
 * <p>员工离职 , 数据表 hr_person_resignation 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:03
 * @sign 4F05A9D38238283327ECF06C6DC177DA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_resignation")
@ApiModel(description = "员工离职 ; 员工离职 , 数据表 hr_person_resignation 的PO类型")
public class PersonResignation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_RESIGNATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 员工：员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "员工")
	private String personId;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 离职日期：离职日期
	*/
	@ApiModelProperty(required = false,value="离职日期" , notes = "离职日期")
	private Date resignationDate;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Person person;
	
	/**
	 * position：position
	*/
	@ApiModelProperty(required = false,value="position" , notes = "position")
	private Position position;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public PersonResignation setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 员工
	 * @return 员工
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 员工
	 * @param personId 员工
	 * @return 当前对象
	*/
	public PersonResignation setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public PersonResignation setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 离职日期<br>
	 * 离职日期
	 * @return 离职日期
	*/
	public Date getResignationDate() {
		return resignationDate;
	}
	
	/**
	 * 设置 离职日期
	 * @param resignationDate 离职日期
	 * @return 当前对象
	*/
	public PersonResignation setResignationDate(Date resignationDate) {
		this.resignationDate=resignationDate;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public PersonResignation setNote(String note) {
		this.note=note;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param operUserId 操作人
	 * @return 当前对象
	*/
	public PersonResignation setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public PersonResignation setOperTime(Date operTime) {
		this.operTime=operTime;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public PersonResignation setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public PersonResignation setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public PersonResignation setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public PersonResignation setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public PersonResignation setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public PersonResignation setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public PersonResignation setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public PersonResignation setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public PersonResignation setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public PersonResignation setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 person<br>
	 * person
	 * @return person
	*/
	public Person getPerson() {
		return person;
	}
	
	/**
	 * 设置 person
	 * @param person person
	 * @return 当前对象
	*/
	public PersonResignation setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 position<br>
	 * position
	 * @return position
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 position
	 * @param position position
	 * @return 当前对象
	*/
	public PersonResignation setPosition(Position position) {
		this.position=position;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonResignation , 转换好的 PersonResignation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonResignation , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		com.dt.platform.domain.hr.meta.PersonResignationMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonResignationMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonResignation clone(boolean deep) {
		return EntityContext.clone(PersonResignation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonResignation
	 * @param personResignationMap 包含实体信息的 Map 对象
	 * @return PersonResignation , 转换好的的 PersonResignation 对象
	*/
	@Transient
	public static PersonResignation createFrom(Map<String,Object> personResignationMap) {
		if(personResignationMap==null) return null;
		PersonResignation po = create();
		EntityContext.copyProperties(po,personResignationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonResignation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonResignation , 转换好的的 PersonResignation 对象
	*/
	@Transient
	public static PersonResignation createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonResignation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonResignation，等同于 new
	 * @return PersonResignation 对象
	*/
	@Transient
	public static PersonResignation create() {
		return new com.dt.platform.domain.hr.meta.PersonResignationMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setNote(DataParser.parse(String.class, map.get(PersonResignationMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonResignationMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonResignationMeta.UPDATE_TIME)));
			this.setResignationDate(DataParser.parse(Date.class, map.get(PersonResignationMeta.RESIGNATION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonResignationMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonResignationMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonResignationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonResignationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonResignationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonResignationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonResignationMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonResignationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonResignationMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonResignationMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonResignationMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(PersonResignationMeta.OPER_TIME)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(PersonResignationMeta.PERSON)));
			this.setPosition(DataParser.parse(Position.class, map.get(PersonResignationMeta.POSITION)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonResignationMeta.NOTE));
				this.setOperUserId( (String)map.get(PersonResignationMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(PersonResignationMeta.UPDATE_TIME));
				this.setResignationDate( (Date)map.get(PersonResignationMeta.RESIGNATION_DATE));
				this.setVersion( (Integer)map.get(PersonResignationMeta.VERSION));
				this.setContent( (String)map.get(PersonResignationMeta.CONTENT));
				this.setCreateBy( (String)map.get(PersonResignationMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonResignationMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonResignationMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonResignationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonResignationMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonResignationMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonResignationMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonResignationMeta.PERSON_ID));
				this.setId( (String)map.get(PersonResignationMeta.ID));
				this.setOperTime( (Date)map.get(PersonResignationMeta.OPER_TIME));
				// others
				this.setPerson( (Person)map.get(PersonResignationMeta.PERSON));
				this.setPosition( (Position)map.get(PersonResignationMeta.POSITION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setNote(DataParser.parse(String.class, r.getValue(PersonResignationMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonResignationMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonResignationMeta.UPDATE_TIME)));
			this.setResignationDate(DataParser.parse(Date.class, r.getValue(PersonResignationMeta.RESIGNATION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonResignationMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonResignationMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonResignationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonResignationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonResignationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonResignationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonResignationMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonResignationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonResignationMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonResignationMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonResignationMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(PersonResignationMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonResignationMeta.NOTE));
				this.setOperUserId( (String)r.getValue(PersonResignationMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(PersonResignationMeta.UPDATE_TIME));
				this.setResignationDate( (Date)r.getValue(PersonResignationMeta.RESIGNATION_DATE));
				this.setVersion( (Integer)r.getValue(PersonResignationMeta.VERSION));
				this.setContent( (String)r.getValue(PersonResignationMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(PersonResignationMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonResignationMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonResignationMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonResignationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonResignationMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonResignationMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonResignationMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonResignationMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonResignationMeta.ID));
				this.setOperTime( (Date)r.getValue(PersonResignationMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}