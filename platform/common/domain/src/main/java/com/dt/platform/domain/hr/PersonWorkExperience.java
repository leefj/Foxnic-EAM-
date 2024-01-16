package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_WORK_EXPERIENCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonWorkExperienceMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 工作经历
 * <p>工作经历 , 数据表 hr_person_work_experience 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-16 12:47:53
 * @sign 536DEF6CB594343B186EBBB34B271447
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_work_experience")
@ApiModel(description = "工作经历 ; 工作经历 , 数据表 hr_person_work_experience 的PO类型")
public class PersonWorkExperience extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_WORK_EXPERIENCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "798977388758171649")
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
	 * 公司名称：公司名称
	*/
	@ApiModelProperty(required = false,value="公司名称" , notes = "公司名称" , example = "rty")
	private String name;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-12-05 12:00:00")
	private Date sTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date eTime;
	
	/**
	 * 岗位：岗位
	*/
	@ApiModelProperty(required = false,value="岗位" , notes = "岗位" , example = "hyui")
	private String post;
	
	/**
	 * 工作内容：工作内容
	*/
	@ApiModelProperty(required = false,value="工作内容" , notes = "工作内容" , example = "ghj")
	private String workContent;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-14 06:10:54")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-01-15 07:54:45")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	public PersonWorkExperience setId(String id) {
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
	public PersonWorkExperience setStatus(String status) {
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
	public PersonWorkExperience setPersonId(String personId) {
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
	public PersonWorkExperience setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 获得 公司名称<br>
	 * 公司名称
	 * @return 公司名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 公司名称
	 * @param name 公司名称
	 * @return 当前对象
	*/
	public PersonWorkExperience setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getSTime() {
		return sTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param sTime 开始时间
	 * @return 当前对象
	*/
	public PersonWorkExperience setSTime(Date sTime) {
		this.sTime=sTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getETime() {
		return eTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param eTime 结束时间
	 * @return 当前对象
	*/
	public PersonWorkExperience setETime(Date eTime) {
		this.eTime=eTime;
		return this;
	}
	
	/**
	 * 获得 岗位<br>
	 * 岗位
	 * @return 岗位
	*/
	public String getPost() {
		return post;
	}
	
	/**
	 * 设置 岗位
	 * @param post 岗位
	 * @return 当前对象
	*/
	public PersonWorkExperience setPost(String post) {
		this.post=post;
		return this;
	}
	
	/**
	 * 获得 工作内容<br>
	 * 工作内容
	 * @return 工作内容
	*/
	public String getWorkContent() {
		return workContent;
	}
	
	/**
	 * 设置 工作内容
	 * @param workContent 工作内容
	 * @return 当前对象
	*/
	public PersonWorkExperience setWorkContent(String workContent) {
		this.workContent=workContent;
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
	public PersonWorkExperience setCreateBy(String createBy) {
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
	public PersonWorkExperience setCreateTime(Date createTime) {
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
	public PersonWorkExperience setUpdateBy(String updateBy) {
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
	public PersonWorkExperience setUpdateTime(Date updateTime) {
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
	public PersonWorkExperience setDeleted(Integer deleted) {
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
	public PersonWorkExperience setDeleted(Boolean deletedBool) {
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
	public PersonWorkExperience setDeleteBy(String deleteBy) {
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
	public PersonWorkExperience setDeleteTime(Date deleteTime) {
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
	public PersonWorkExperience setVersion(Integer version) {
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
	public PersonWorkExperience setTenantId(String tenantId) {
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
	public PersonWorkExperience setRelId(String relId) {
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
	public PersonWorkExperience setPerson(Employee person) {
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
	public PersonWorkExperience setUser(Person user) {
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
	public PersonWorkExperience setRole(String role) {
		this.role=role;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonWorkExperience , 转换好的 PersonWorkExperience 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonWorkExperience , 转换好的 PoJo 对象
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
	public PersonWorkExperience clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonWorkExperience duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonWorkExperienceMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonWorkExperienceMeta.$$proxy$$();
		inst.setRelId(this.getRelId());
		inst.setETime(this.getETime());
		inst.setWorkContent(this.getWorkContent());
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPost(this.getPost());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setSTime(this.getSTime());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setRole(this.getRole());
			inst.setPerson(this.getPerson());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonWorkExperience clone(boolean deep) {
		return EntityContext.clone(PersonWorkExperience.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonWorkExperience
	 * @param personWorkExperienceMap 包含实体信息的 Map 对象
	 * @return PersonWorkExperience , 转换好的的 PersonWorkExperience 对象
	*/
	@Transient
	public static PersonWorkExperience createFrom(Map<String,Object> personWorkExperienceMap) {
		if(personWorkExperienceMap==null) return null;
		PersonWorkExperience po = create();
		EntityContext.copyProperties(po,personWorkExperienceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonWorkExperience
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonWorkExperience , 转换好的的 PersonWorkExperience 对象
	*/
	@Transient
	public static PersonWorkExperience createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonWorkExperience po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonWorkExperience，等同于 new
	 * @return PersonWorkExperience 对象
	*/
	@Transient
	public static PersonWorkExperience create() {
		return new com.dt.platform.domain.hr.meta.PersonWorkExperienceMeta.$$proxy$$();
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
			this.setRelId(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.REL_ID)));
			this.setETime(DataParser.parse(Date.class, map.get(PersonWorkExperienceMeta.E_TIME)));
			this.setWorkContent(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.WORK_CONTENT)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonWorkExperienceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonWorkExperienceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonWorkExperienceMeta.DELETED)));
			this.setPost(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.POST)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonWorkExperienceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonWorkExperienceMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.ID)));
			this.setSTime(DataParser.parse(Date.class, map.get(PersonWorkExperienceMeta.S_TIME)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.STATUS)));
			// others
			this.setRole(DataParser.parse(String.class, map.get(PersonWorkExperienceMeta.ROLE)));
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonWorkExperienceMeta.PERSON)));
			this.setUser(DataParser.parse(Person.class, map.get(PersonWorkExperienceMeta.USER)));
			return true;
		} else {
			try {
				this.setRelId( (String)map.get(PersonWorkExperienceMeta.REL_ID));
				this.setETime( (Date)map.get(PersonWorkExperienceMeta.E_TIME));
				this.setWorkContent( (String)map.get(PersonWorkExperienceMeta.WORK_CONTENT));
				this.setEmployeeId( (String)map.get(PersonWorkExperienceMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(PersonWorkExperienceMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonWorkExperienceMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonWorkExperienceMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonWorkExperienceMeta.DELETED));
				this.setPost( (String)map.get(PersonWorkExperienceMeta.POST));
				this.setCreateTime( (Date)map.get(PersonWorkExperienceMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonWorkExperienceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonWorkExperienceMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonWorkExperienceMeta.NAME));
				this.setTenantId( (String)map.get(PersonWorkExperienceMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonWorkExperienceMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonWorkExperienceMeta.PERSON_ID));
				this.setId( (String)map.get(PersonWorkExperienceMeta.ID));
				this.setSTime( (Date)map.get(PersonWorkExperienceMeta.S_TIME));
				this.setStatus( (String)map.get(PersonWorkExperienceMeta.STATUS));
				// others
				this.setRole( (String)map.get(PersonWorkExperienceMeta.ROLE));
				this.setPerson( (Employee)map.get(PersonWorkExperienceMeta.PERSON));
				this.setUser( (Person)map.get(PersonWorkExperienceMeta.USER));
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
			this.setRelId(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.REL_ID)));
			this.setETime(DataParser.parse(Date.class, r.getValue(PersonWorkExperienceMeta.E_TIME)));
			this.setWorkContent(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.WORK_CONTENT)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonWorkExperienceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonWorkExperienceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonWorkExperienceMeta.DELETED)));
			this.setPost(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.POST)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonWorkExperienceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonWorkExperienceMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.ID)));
			this.setSTime(DataParser.parse(Date.class, r.getValue(PersonWorkExperienceMeta.S_TIME)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonWorkExperienceMeta.STATUS)));
			return true;
		} else {
			try {
				this.setRelId( (String)r.getValue(PersonWorkExperienceMeta.REL_ID));
				this.setETime( (Date)r.getValue(PersonWorkExperienceMeta.E_TIME));
				this.setWorkContent( (String)r.getValue(PersonWorkExperienceMeta.WORK_CONTENT));
				this.setEmployeeId( (String)r.getValue(PersonWorkExperienceMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(PersonWorkExperienceMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonWorkExperienceMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonWorkExperienceMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonWorkExperienceMeta.DELETED));
				this.setPost( (String)r.getValue(PersonWorkExperienceMeta.POST));
				this.setCreateTime( (Date)r.getValue(PersonWorkExperienceMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonWorkExperienceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonWorkExperienceMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonWorkExperienceMeta.NAME));
				this.setTenantId( (String)r.getValue(PersonWorkExperienceMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonWorkExperienceMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonWorkExperienceMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonWorkExperienceMeta.ID));
				this.setSTime( (Date)r.getValue(PersonWorkExperienceMeta.S_TIME));
				this.setStatus( (String)r.getValue(PersonWorkExperienceMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}