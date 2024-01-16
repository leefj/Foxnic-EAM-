package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_SOCIAL_RELATION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonSocialRelationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 社会关系
 * <p>社会关系 , 数据表 hr_person_social_relation 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-16 12:47:26
 * @sign 2E5232051932D88B591E61466F30D948
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_social_relation")
@ApiModel(description = "社会关系 ; 社会关系 , 数据表 hr_person_social_relation 的PO类型")
public class PersonSocialRelation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_SOCIAL_RELATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "798975703323246592")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "finish")
	private String status;
	
	/**
	 * 员工：员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "员工" , example = "799379402461806592")
	private String personId;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员" , example = "E001")
	private String employeeId;
	
	/**
	 * 关系类型：关系类型
	*/
	@ApiModelProperty(required = false,value="关系类型" , notes = "关系类型" , example = "family_members")
	private String relType;
	
	/**
	 * 关系：关系
	*/
	@ApiModelProperty(required = false,value="关系" , notes = "关系" , example = "fq")
	private String rel;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "12121")
	private String name;
	
	/**
	 * 工作单位：工作单位
	*/
	@ApiModelProperty(required = false,value="工作单位" , notes = "工作单位" , example = "1212")
	private String workCompany;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式" , example = "1212")
	private String concat;
	
	/**
	 * 紧急联系人：紧急联系人
	*/
	@ApiModelProperty(required = false,value="紧急联系人" , notes = "紧急联系人" , example = "no")
	private String emergencyContact;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-14 06:04:12")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-01-14 06:19:54")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2024-01-14 06:19:54")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 关联：关联
	*/
	@ApiModelProperty(required = false,value="关联" , notes = "关联")
	private String relId;
	
	/**
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Employee person;
	
	/**
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Person user;
	
	/**
	 * role：role
	*/
	@ApiModelProperty(required = false,value="role" , notes = "role")
	private String role;
	
	/**
	 * socialRelation：socialRelation
	*/
	@ApiModelProperty(required = false,value="socialRelation" , notes = "socialRelation")
	private DictItem socialRelation;
	
	/**
	 * socialRelationType：socialRelationType
	*/
	@ApiModelProperty(required = false,value="socialRelationType" , notes = "socialRelationType")
	private DictItem socialRelationType;
	
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
	public PersonSocialRelation setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public PersonSocialRelation setStatus(String status) {
		this.status=status;
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
	public PersonSocialRelation setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * 设置 人员
	 * @param employeeId 人员
	 * @return 当前对象
	*/
	public PersonSocialRelation setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 获得 关系类型<br>
	 * 关系类型
	 * @return 关系类型
	*/
	public String getRelType() {
		return relType;
	}
	
	/**
	 * 设置 关系类型
	 * @param relType 关系类型
	 * @return 当前对象
	*/
	public PersonSocialRelation setRelType(String relType) {
		this.relType=relType;
		return this;
	}
	
	/**
	 * 获得 关系<br>
	 * 关系
	 * @return 关系
	*/
	public String getRel() {
		return rel;
	}
	
	/**
	 * 设置 关系
	 * @param rel 关系
	 * @return 当前对象
	*/
	public PersonSocialRelation setRel(String rel) {
		this.rel=rel;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 姓名
	 * @param name 姓名
	 * @return 当前对象
	*/
	public PersonSocialRelation setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 工作单位<br>
	 * 工作单位
	 * @return 工作单位
	*/
	public String getWorkCompany() {
		return workCompany;
	}
	
	/**
	 * 设置 工作单位
	 * @param workCompany 工作单位
	 * @return 当前对象
	*/
	public PersonSocialRelation setWorkCompany(String workCompany) {
		this.workCompany=workCompany;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getConcat() {
		return concat;
	}
	
	/**
	 * 设置 联系方式
	 * @param concat 联系方式
	 * @return 当前对象
	*/
	public PersonSocialRelation setConcat(String concat) {
		this.concat=concat;
		return this;
	}
	
	/**
	 * 获得 紧急联系人<br>
	 * 紧急联系人
	 * @return 紧急联系人
	*/
	public String getEmergencyContact() {
		return emergencyContact;
	}
	
	/**
	 * 设置 紧急联系人
	 * @param emergencyContact 紧急联系人
	 * @return 当前对象
	*/
	public PersonSocialRelation setEmergencyContact(String emergencyContact) {
		this.emergencyContact=emergencyContact;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public PersonSocialRelation setNotes(String notes) {
		this.notes=notes;
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
	public PersonSocialRelation setCreateBy(String createBy) {
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
	public PersonSocialRelation setCreateTime(Date createTime) {
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
	public PersonSocialRelation setUpdateBy(String updateBy) {
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
	public PersonSocialRelation setUpdateTime(Date updateTime) {
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
	public PersonSocialRelation setDeleted(Integer deleted) {
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
	public PersonSocialRelation setDeleted(Boolean deletedBool) {
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
	public PersonSocialRelation setDeleteBy(String deleteBy) {
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
	public PersonSocialRelation setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public PersonSocialRelation setVersion(Integer version) {
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
	public PersonSocialRelation setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 关联<br>
	 * 关联
	 * @return 关联
	*/
	public String getRelId() {
		return relId;
	}
	
	/**
	 * 设置 关联
	 * @param relId 关联
	 * @return 当前对象
	*/
	public PersonSocialRelation setRelId(String relId) {
		this.relId=relId;
		return this;
	}
	
	/**
	 * 获得 person<br>
	 * person
	 * @return person
	*/
	public Employee getPerson() {
		return person;
	}
	
	/**
	 * 设置 person
	 * @param person person
	 * @return 当前对象
	*/
	public PersonSocialRelation setPerson(Employee person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 user<br>
	 * user
	 * @return user
	*/
	public Person getUser() {
		return user;
	}
	
	/**
	 * 设置 user
	 * @param user user
	 * @return 当前对象
	*/
	public PersonSocialRelation setUser(Person user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 role<br>
	 * role
	 * @return role
	*/
	public String getRole() {
		return role;
	}
	
	/**
	 * 设置 role
	 * @param role role
	 * @return 当前对象
	*/
	public PersonSocialRelation setRole(String role) {
		this.role=role;
		return this;
	}
	
	/**
	 * 获得 socialRelation<br>
	 * socialRelation
	 * @return socialRelation
	*/
	public DictItem getSocialRelation() {
		return socialRelation;
	}
	
	/**
	 * 设置 socialRelation
	 * @param socialRelation socialRelation
	 * @return 当前对象
	*/
	public PersonSocialRelation setSocialRelation(DictItem socialRelation) {
		this.socialRelation=socialRelation;
		return this;
	}
	
	/**
	 * 获得 socialRelationType<br>
	 * socialRelationType
	 * @return socialRelationType
	*/
	public DictItem getSocialRelationType() {
		return socialRelationType;
	}
	
	/**
	 * 设置 socialRelationType
	 * @param socialRelationType socialRelationType
	 * @return 当前对象
	*/
	public PersonSocialRelation setSocialRelationType(DictItem socialRelationType) {
		this.socialRelationType=socialRelationType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonSocialRelation , 转换好的 PersonSocialRelation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonSocialRelation , 转换好的 PoJo 对象
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
	public PersonSocialRelation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonSocialRelation duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonSocialRelationMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonSocialRelationMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonSocialRelation clone(boolean deep) {
		return EntityContext.clone(PersonSocialRelation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonSocialRelation
	 * @param personSocialRelationMap 包含实体信息的 Map 对象
	 * @return PersonSocialRelation , 转换好的的 PersonSocialRelation 对象
	*/
	@Transient
	public static PersonSocialRelation createFrom(Map<String,Object> personSocialRelationMap) {
		if(personSocialRelationMap==null) return null;
		PersonSocialRelation po = create();
		EntityContext.copyProperties(po,personSocialRelationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonSocialRelation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonSocialRelation , 转换好的的 PersonSocialRelation 对象
	*/
	@Transient
	public static PersonSocialRelation createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonSocialRelation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonSocialRelation，等同于 new
	 * @return PersonSocialRelation 对象
	*/
	@Transient
	public static PersonSocialRelation create() {
		return new com.dt.platform.domain.hr.meta.PersonSocialRelationMeta.$$proxy$$();
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
			this.setRelId(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.REL_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.NOTES)));
			this.setEmergencyContact(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.EMERGENCY_CONTACT)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.EMPLOYEE_ID)));
			this.setRelType(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.REL_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonSocialRelationMeta.UPDATE_TIME)));
			this.setConcat(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.CONCAT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonSocialRelationMeta.VERSION)));
			this.setWorkCompany(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.WORK_COMPANY)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonSocialRelationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonSocialRelationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonSocialRelationMeta.DELETE_TIME)));
			this.setRel(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.REL)));
			this.setName(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.STATUS)));
			// others
			this.setRole(DataParser.parse(String.class, map.get(PersonSocialRelationMeta.ROLE)));
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonSocialRelationMeta.PERSON)));
			this.setSocialRelationType(DataParser.parse(DictItem.class, map.get(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE)));
			this.setSocialRelation(DataParser.parse(DictItem.class, map.get(PersonSocialRelationMeta.SOCIAL_RELATION)));
			this.setUser(DataParser.parse(Person.class, map.get(PersonSocialRelationMeta.USER)));
			return true;
		} else {
			try {
				this.setRelId( (String)map.get(PersonSocialRelationMeta.REL_ID));
				this.setNotes( (String)map.get(PersonSocialRelationMeta.NOTES));
				this.setEmergencyContact( (String)map.get(PersonSocialRelationMeta.EMERGENCY_CONTACT));
				this.setEmployeeId( (String)map.get(PersonSocialRelationMeta.EMPLOYEE_ID));
				this.setRelType( (String)map.get(PersonSocialRelationMeta.REL_TYPE));
				this.setUpdateTime( (Date)map.get(PersonSocialRelationMeta.UPDATE_TIME));
				this.setConcat( (String)map.get(PersonSocialRelationMeta.CONCAT));
				this.setVersion( (Integer)map.get(PersonSocialRelationMeta.VERSION));
				this.setWorkCompany( (String)map.get(PersonSocialRelationMeta.WORK_COMPANY));
				this.setCreateBy( (String)map.get(PersonSocialRelationMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonSocialRelationMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonSocialRelationMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonSocialRelationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonSocialRelationMeta.DELETE_TIME));
				this.setRel( (String)map.get(PersonSocialRelationMeta.REL));
				this.setName( (String)map.get(PersonSocialRelationMeta.NAME));
				this.setTenantId( (String)map.get(PersonSocialRelationMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonSocialRelationMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonSocialRelationMeta.PERSON_ID));
				this.setId( (String)map.get(PersonSocialRelationMeta.ID));
				this.setStatus( (String)map.get(PersonSocialRelationMeta.STATUS));
				// others
				this.setRole( (String)map.get(PersonSocialRelationMeta.ROLE));
				this.setPerson( (Employee)map.get(PersonSocialRelationMeta.PERSON));
				this.setSocialRelationType( (DictItem)map.get(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE));
				this.setSocialRelation( (DictItem)map.get(PersonSocialRelationMeta.SOCIAL_RELATION));
				this.setUser( (Person)map.get(PersonSocialRelationMeta.USER));
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
			this.setRelId(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.REL_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.NOTES)));
			this.setEmergencyContact(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.EMERGENCY_CONTACT)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.EMPLOYEE_ID)));
			this.setRelType(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.REL_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonSocialRelationMeta.UPDATE_TIME)));
			this.setConcat(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.CONCAT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonSocialRelationMeta.VERSION)));
			this.setWorkCompany(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.WORK_COMPANY)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonSocialRelationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonSocialRelationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonSocialRelationMeta.DELETE_TIME)));
			this.setRel(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.REL)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonSocialRelationMeta.STATUS)));
			return true;
		} else {
			try {
				this.setRelId( (String)r.getValue(PersonSocialRelationMeta.REL_ID));
				this.setNotes( (String)r.getValue(PersonSocialRelationMeta.NOTES));
				this.setEmergencyContact( (String)r.getValue(PersonSocialRelationMeta.EMERGENCY_CONTACT));
				this.setEmployeeId( (String)r.getValue(PersonSocialRelationMeta.EMPLOYEE_ID));
				this.setRelType( (String)r.getValue(PersonSocialRelationMeta.REL_TYPE));
				this.setUpdateTime( (Date)r.getValue(PersonSocialRelationMeta.UPDATE_TIME));
				this.setConcat( (String)r.getValue(PersonSocialRelationMeta.CONCAT));
				this.setVersion( (Integer)r.getValue(PersonSocialRelationMeta.VERSION));
				this.setWorkCompany( (String)r.getValue(PersonSocialRelationMeta.WORK_COMPANY));
				this.setCreateBy( (String)r.getValue(PersonSocialRelationMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonSocialRelationMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonSocialRelationMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonSocialRelationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonSocialRelationMeta.DELETE_TIME));
				this.setRel( (String)r.getValue(PersonSocialRelationMeta.REL));
				this.setName( (String)r.getValue(PersonSocialRelationMeta.NAME));
				this.setTenantId( (String)r.getValue(PersonSocialRelationMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonSocialRelationMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonSocialRelationMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonSocialRelationMeta.ID));
				this.setStatus( (String)r.getValue(PersonSocialRelationMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}