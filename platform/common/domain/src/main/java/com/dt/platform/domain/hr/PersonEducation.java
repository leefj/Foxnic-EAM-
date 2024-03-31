package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_EDUCATION;
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
import com.dt.platform.domain.hr.meta.PersonEducationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 教育信息
 * <p>教育信息 , 数据表 hr_person_education 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-26 21:45:00
 * @sign 2A9E10901BEC16F41AB8662F1F2D18E9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_education")
@ApiModel(description = "教育信息 ; 教育信息 , 数据表 hr_person_education 的PO类型")
public class PersonEducation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_EDUCATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "798976921462374400")
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
	 * 学历：学历
	*/
	@ApiModelProperty(required = false,value="学历" , notes = "学历" , example = "gz")
	private String education;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2018-12-10 12:00:00")
	private Date sTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2021-12-17 12:00:00")
	private Date eTime;
	
	/**
	 * 毕业院校：毕业院校
	*/
	@ApiModelProperty(required = false,value="毕业院校" , notes = "毕业院校" , example = "12345")
	private String educationalInstitutions;
	
	/**
	 * 所学专业：所学专业
	*/
	@ApiModelProperty(required = false,value="所学专业" , notes = "所学专业" , example = "1234rty")
	private String majoyStudied;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "的撒发12121212121212")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileIds;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-14 06:09:02")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-01-15 12:43:13")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "6")
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
	 * educationInfo：educationInfo
	*/
	@ApiModelProperty(required = false,value="educationInfo" , notes = "educationInfo")
	private DictItem educationInfo;
	
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
	public PersonEducation setId(String id) {
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
	public PersonEducation setStatus(String status) {
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
	public PersonEducation setPersonId(String personId) {
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
	public PersonEducation setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 获得 学历<br>
	 * 学历
	 * @return 学历
	*/
	public String getEducation() {
		return education;
	}
	
	/**
	 * 设置 学历
	 * @param education 学历
	 * @return 当前对象
	*/
	public PersonEducation setEducation(String education) {
		this.education=education;
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
	public PersonEducation setSTime(Date sTime) {
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
	public PersonEducation setETime(Date eTime) {
		this.eTime=eTime;
		return this;
	}
	
	/**
	 * 获得 毕业院校<br>
	 * 毕业院校
	 * @return 毕业院校
	*/
	public String getEducationalInstitutions() {
		return educationalInstitutions;
	}
	
	/**
	 * 设置 毕业院校
	 * @param educationalInstitutions 毕业院校
	 * @return 当前对象
	*/
	public PersonEducation setEducationalInstitutions(String educationalInstitutions) {
		this.educationalInstitutions=educationalInstitutions;
		return this;
	}
	
	/**
	 * 获得 所学专业<br>
	 * 所学专业
	 * @return 所学专业
	*/
	public String getMajoyStudied() {
		return majoyStudied;
	}
	
	/**
	 * 设置 所学专业
	 * @param majoyStudied 所学专业
	 * @return 当前对象
	*/
	public PersonEducation setMajoyStudied(String majoyStudied) {
		this.majoyStudied=majoyStudied;
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
	public PersonEducation setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileIds() {
		return fileIds;
	}
	
	/**
	 * 设置 附件
	 * @param fileIds 附件
	 * @return 当前对象
	*/
	public PersonEducation setFileIds(String fileIds) {
		this.fileIds=fileIds;
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
	public PersonEducation setCreateBy(String createBy) {
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
	public PersonEducation setCreateTime(Date createTime) {
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
	public PersonEducation setUpdateBy(String updateBy) {
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
	public PersonEducation setUpdateTime(Date updateTime) {
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
	public PersonEducation setDeleted(Integer deleted) {
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
	public PersonEducation setDeleted(Boolean deletedBool) {
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
	public PersonEducation setDeleteBy(String deleteBy) {
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
	public PersonEducation setDeleteTime(Date deleteTime) {
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
	public PersonEducation setVersion(Integer version) {
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
	public PersonEducation setTenantId(String tenantId) {
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
	public PersonEducation setRelId(String relId) {
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
	public PersonEducation setPerson(Employee person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 educationInfo<br>
	 * educationInfo
	 * @return educationInfo
	*/
	public DictItem getEducationInfo() {
		return educationInfo;
	}
	
	/**
	 * 设置 educationInfo
	 * @param educationInfo educationInfo
	 * @return 当前对象
	*/
	public PersonEducation setEducationInfo(DictItem educationInfo) {
		this.educationInfo=educationInfo;
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
	public PersonEducation setUser(Person user) {
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
	public PersonEducation setRole(String role) {
		this.role=role;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonEducation , 转换好的 PersonEducation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonEducation , 转换好的 PoJo 对象
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
	public PersonEducation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonEducation duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonEducationMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonEducationMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonEducation clone(boolean deep) {
		return EntityContext.clone(PersonEducation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonEducation
	 * @param personEducationMap 包含实体信息的 Map 对象
	 * @return PersonEducation , 转换好的的 PersonEducation 对象
	*/
	@Transient
	public static PersonEducation createFrom(Map<String,Object> personEducationMap) {
		if(personEducationMap==null) return null;
		PersonEducation po = create();
		EntityContext.copyProperties(po,personEducationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonEducation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonEducation , 转换好的的 PersonEducation 对象
	*/
	@Transient
	public static PersonEducation createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonEducation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonEducation，等同于 new
	 * @return PersonEducation 对象
	*/
	@Transient
	public static PersonEducation create() {
		return new com.dt.platform.domain.hr.meta.PersonEducationMeta.$$proxy$$();
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
			this.setEducationalInstitutions(DataParser.parse(String.class, map.get(PersonEducationMeta.EDUCATIONAL_INSTITUTIONS)));
			this.setRelId(DataParser.parse(String.class, map.get(PersonEducationMeta.REL_ID)));
			this.setEducation(DataParser.parse(String.class, map.get(PersonEducationMeta.EDUCATION)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonEducationMeta.NOTES)));
			this.setETime(DataParser.parse(Date.class, map.get(PersonEducationMeta.E_TIME)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(PersonEducationMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonEducationMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonEducationMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonEducationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonEducationMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(PersonEducationMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonEducationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonEducationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonEducationMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonEducationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonEducationMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonEducationMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonEducationMeta.ID)));
			this.setSTime(DataParser.parse(Date.class, map.get(PersonEducationMeta.S_TIME)));
			this.setMajoyStudied(DataParser.parse(String.class, map.get(PersonEducationMeta.MAJOY_STUDIED)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonEducationMeta.STATUS)));
			// others
			this.setRole(DataParser.parse(String.class, map.get(PersonEducationMeta.ROLE)));
			this.setEducationInfo(DataParser.parse(DictItem.class, map.get(PersonEducationMeta.EDUCATION_INFO)));
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonEducationMeta.PERSON)));
			this.setUser(DataParser.parse(Person.class, map.get(PersonEducationMeta.USER)));
			return true;
		} else {
			try {
				this.setEducationalInstitutions( (String)map.get(PersonEducationMeta.EDUCATIONAL_INSTITUTIONS));
				this.setRelId( (String)map.get(PersonEducationMeta.REL_ID));
				this.setEducation( (String)map.get(PersonEducationMeta.EDUCATION));
				this.setNotes( (String)map.get(PersonEducationMeta.NOTES));
				this.setETime( (Date)map.get(PersonEducationMeta.E_TIME));
				this.setEmployeeId( (String)map.get(PersonEducationMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(PersonEducationMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonEducationMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonEducationMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonEducationMeta.DELETED));
				this.setFileIds( (String)map.get(PersonEducationMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(PersonEducationMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonEducationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonEducationMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonEducationMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonEducationMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonEducationMeta.PERSON_ID));
				this.setId( (String)map.get(PersonEducationMeta.ID));
				this.setSTime( (Date)map.get(PersonEducationMeta.S_TIME));
				this.setMajoyStudied( (String)map.get(PersonEducationMeta.MAJOY_STUDIED));
				this.setStatus( (String)map.get(PersonEducationMeta.STATUS));
				// others
				this.setRole( (String)map.get(PersonEducationMeta.ROLE));
				this.setEducationInfo( (DictItem)map.get(PersonEducationMeta.EDUCATION_INFO));
				this.setPerson( (Employee)map.get(PersonEducationMeta.PERSON));
				this.setUser( (Person)map.get(PersonEducationMeta.USER));
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
			this.setEducationalInstitutions(DataParser.parse(String.class, r.getValue(PersonEducationMeta.EDUCATIONAL_INSTITUTIONS)));
			this.setRelId(DataParser.parse(String.class, r.getValue(PersonEducationMeta.REL_ID)));
			this.setEducation(DataParser.parse(String.class, r.getValue(PersonEducationMeta.EDUCATION)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonEducationMeta.NOTES)));
			this.setETime(DataParser.parse(Date.class, r.getValue(PersonEducationMeta.E_TIME)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(PersonEducationMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonEducationMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonEducationMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonEducationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonEducationMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(PersonEducationMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonEducationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonEducationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonEducationMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonEducationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonEducationMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonEducationMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonEducationMeta.ID)));
			this.setSTime(DataParser.parse(Date.class, r.getValue(PersonEducationMeta.S_TIME)));
			this.setMajoyStudied(DataParser.parse(String.class, r.getValue(PersonEducationMeta.MAJOY_STUDIED)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonEducationMeta.STATUS)));
			return true;
		} else {
			try {
				this.setEducationalInstitutions( (String)r.getValue(PersonEducationMeta.EDUCATIONAL_INSTITUTIONS));
				this.setRelId( (String)r.getValue(PersonEducationMeta.REL_ID));
				this.setEducation( (String)r.getValue(PersonEducationMeta.EDUCATION));
				this.setNotes( (String)r.getValue(PersonEducationMeta.NOTES));
				this.setETime( (Date)r.getValue(PersonEducationMeta.E_TIME));
				this.setEmployeeId( (String)r.getValue(PersonEducationMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(PersonEducationMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonEducationMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonEducationMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonEducationMeta.DELETED));
				this.setFileIds( (String)r.getValue(PersonEducationMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(PersonEducationMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonEducationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonEducationMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonEducationMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonEducationMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonEducationMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonEducationMeta.ID));
				this.setSTime( (Date)r.getValue(PersonEducationMeta.S_TIME));
				this.setMajoyStudied( (String)r.getValue(PersonEducationMeta.MAJOY_STUDIED));
				this.setStatus( (String)r.getValue(PersonEducationMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}