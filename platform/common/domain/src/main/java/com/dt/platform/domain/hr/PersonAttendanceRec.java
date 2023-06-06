package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_ATTENDANCE_REC;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonAttendanceRecMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员考勤
 * <p>人员考勤 , 数据表 hr_person_attendance_rec 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 10:58:36
 * @sign 2D7C82CFE0FC3D04F84055D86C88EF62
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_attendance_rec")
@ApiModel(description = "人员考勤 ; 人员考勤 , 数据表 hr_person_attendance_rec 的PO类型")
public class PersonAttendanceRec extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_ATTENDANCE_REC.$TABLE;
	
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
	private String employeeId;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String personId;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名")
	private String userName;
	
	/**
	 * 工号：工号
	*/
	@ApiModelProperty(required = false,value="工号" , notes = "工号")
	private String jobNumber;
	
	/**
	 * 加班：天)
	*/
	@ApiModelProperty(required = false,value="加班" , notes = "天)")
	private BigDecimal jbCnt;
	
	/**
	 * 年假：天)
	*/
	@ApiModelProperty(required = false,value="年假" , notes = "天)")
	private BigDecimal njCnt;
	
	/**
	 * 事假：天)
	*/
	@ApiModelProperty(required = false,value="事假" , notes = "天)")
	private BigDecimal sjCnt;
	
	/**
	 * 其他假：天)
	*/
	@ApiModelProperty(required = false,value="其他假" , notes = "天)")
	private BigDecimal otherCnt;
	
	/**
	 * 出差：天)
	*/
	@ApiModelProperty(required = false,value="出差" , notes = "天)")
	private BigDecimal ccOut;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
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
	 * employee：employee
	*/
	@ApiModelProperty(required = false,value="employee" , notes = "employee")
	private Employee employee;
	
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
	public PersonAttendanceRec setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 员工
	 * @return 员工
	*/
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * 设置 员工
	 * @param employeeId 员工
	 * @return 当前对象
	*/
	public PersonAttendanceRec setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 人员
	 * @param personId 人员
	 * @return 当前对象
	*/
	public PersonAttendanceRec setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 姓名
	 * @param userName 姓名
	 * @return 当前对象
	*/
	public PersonAttendanceRec setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 工号<br>
	 * 工号
	 * @return 工号
	*/
	public String getJobNumber() {
		return jobNumber;
	}
	
	/**
	 * 设置 工号
	 * @param jobNumber 工号
	 * @return 当前对象
	*/
	public PersonAttendanceRec setJobNumber(String jobNumber) {
		this.jobNumber=jobNumber;
		return this;
	}
	
	/**
	 * 获得 加班<br>
	 * 天)
	 * @return 加班
	*/
	public BigDecimal getJbCnt() {
		return jbCnt;
	}
	
	/**
	 * 设置 加班
	 * @param jbCnt 加班
	 * @return 当前对象
	*/
	public PersonAttendanceRec setJbCnt(BigDecimal jbCnt) {
		this.jbCnt=jbCnt;
		return this;
	}
	
	/**
	 * 获得 年假<br>
	 * 天)
	 * @return 年假
	*/
	public BigDecimal getNjCnt() {
		return njCnt;
	}
	
	/**
	 * 设置 年假
	 * @param njCnt 年假
	 * @return 当前对象
	*/
	public PersonAttendanceRec setNjCnt(BigDecimal njCnt) {
		this.njCnt=njCnt;
		return this;
	}
	
	/**
	 * 获得 事假<br>
	 * 天)
	 * @return 事假
	*/
	public BigDecimal getSjCnt() {
		return sjCnt;
	}
	
	/**
	 * 设置 事假
	 * @param sjCnt 事假
	 * @return 当前对象
	*/
	public PersonAttendanceRec setSjCnt(BigDecimal sjCnt) {
		this.sjCnt=sjCnt;
		return this;
	}
	
	/**
	 * 获得 其他假<br>
	 * 天)
	 * @return 其他假
	*/
	public BigDecimal getOtherCnt() {
		return otherCnt;
	}
	
	/**
	 * 设置 其他假
	 * @param otherCnt 其他假
	 * @return 当前对象
	*/
	public PersonAttendanceRec setOtherCnt(BigDecimal otherCnt) {
		this.otherCnt=otherCnt;
		return this;
	}
	
	/**
	 * 获得 出差<br>
	 * 天)
	 * @return 出差
	*/
	public BigDecimal getCcOut() {
		return ccOut;
	}
	
	/**
	 * 设置 出差
	 * @param ccOut 出差
	 * @return 当前对象
	*/
	public PersonAttendanceRec setCcOut(BigDecimal ccOut) {
		this.ccOut=ccOut;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecTime() {
		return recTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recTime 记录时间
	 * @return 当前对象
	*/
	public PersonAttendanceRec setRecTime(Date recTime) {
		this.recTime=recTime;
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
	public PersonAttendanceRec setNotes(String notes) {
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
	public PersonAttendanceRec setCreateBy(String createBy) {
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
	public PersonAttendanceRec setCreateTime(Date createTime) {
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
	public PersonAttendanceRec setUpdateBy(String updateBy) {
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
	public PersonAttendanceRec setUpdateTime(Date updateTime) {
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
	public PersonAttendanceRec setDeleted(Integer deleted) {
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
	public PersonAttendanceRec setDeleted(Boolean deletedBool) {
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
	public PersonAttendanceRec setDeleteBy(String deleteBy) {
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
	public PersonAttendanceRec setDeleteTime(Date deleteTime) {
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
	public PersonAttendanceRec setVersion(Integer version) {
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
	public PersonAttendanceRec setTenantId(String tenantId) {
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
	public PersonAttendanceRec setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 employee<br>
	 * employee
	 * @return employee
	*/
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * 设置 employee
	 * @param employee employee
	 * @return 当前对象
	*/
	public PersonAttendanceRec setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonAttendanceRec , 转换好的 PersonAttendanceRec 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonAttendanceRec , 转换好的 PoJo 对象
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
	public PersonAttendanceRec clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonAttendanceRec duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonAttendanceRecMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonAttendanceRecMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setRecTime(this.getRecTime());
		inst.setOtherCnt(this.getOtherCnt());
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserName(this.getUserName());
		inst.setVersion(this.getVersion());
		inst.setCcOut(this.getCcOut());
		inst.setJbCnt(this.getJbCnt());
		inst.setNjCnt(this.getNjCnt());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setSjCnt(this.getSjCnt());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setJobNumber(this.getJobNumber());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setEmployee(this.getEmployee());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonAttendanceRec clone(boolean deep) {
		return EntityContext.clone(PersonAttendanceRec.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonAttendanceRec
	 * @param personAttendanceRecMap 包含实体信息的 Map 对象
	 * @return PersonAttendanceRec , 转换好的的 PersonAttendanceRec 对象
	*/
	@Transient
	public static PersonAttendanceRec createFrom(Map<String,Object> personAttendanceRecMap) {
		if(personAttendanceRecMap==null) return null;
		PersonAttendanceRec po = create();
		EntityContext.copyProperties(po,personAttendanceRecMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonAttendanceRec
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonAttendanceRec , 转换好的的 PersonAttendanceRec 对象
	*/
	@Transient
	public static PersonAttendanceRec createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonAttendanceRec po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonAttendanceRec，等同于 new
	 * @return PersonAttendanceRec 对象
	*/
	@Transient
	public static PersonAttendanceRec create() {
		return new com.dt.platform.domain.hr.meta.PersonAttendanceRecMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.NOTES)));
			this.setRecTime(DataParser.parse(Date.class, map.get(PersonAttendanceRecMeta.REC_TIME)));
			this.setOtherCnt(DataParser.parse(BigDecimal.class, map.get(PersonAttendanceRecMeta.OTHER_CNT)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonAttendanceRecMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonAttendanceRecMeta.VERSION)));
			this.setCcOut(DataParser.parse(BigDecimal.class, map.get(PersonAttendanceRecMeta.CC_OUT)));
			this.setJbCnt(DataParser.parse(BigDecimal.class, map.get(PersonAttendanceRecMeta.JB_CNT)));
			this.setNjCnt(DataParser.parse(BigDecimal.class, map.get(PersonAttendanceRecMeta.NJ_CNT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonAttendanceRecMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonAttendanceRecMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonAttendanceRecMeta.DELETE_TIME)));
			this.setSjCnt(DataParser.parse(BigDecimal.class, map.get(PersonAttendanceRecMeta.SJ_CNT)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.ID)));
			this.setJobNumber(DataParser.parse(String.class, map.get(PersonAttendanceRecMeta.JOB_NUMBER)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(PersonAttendanceRecMeta.PERSON)));
			this.setEmployee(DataParser.parse(Employee.class, map.get(PersonAttendanceRecMeta.EMPLOYEE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(PersonAttendanceRecMeta.NOTES));
				this.setRecTime( (Date)map.get(PersonAttendanceRecMeta.REC_TIME));
				this.setOtherCnt( (BigDecimal)map.get(PersonAttendanceRecMeta.OTHER_CNT));
				this.setEmployeeId( (String)map.get(PersonAttendanceRecMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(PersonAttendanceRecMeta.UPDATE_TIME));
				this.setUserName( (String)map.get(PersonAttendanceRecMeta.USER_NAME));
				this.setVersion( (Integer)map.get(PersonAttendanceRecMeta.VERSION));
				this.setCcOut( (BigDecimal)map.get(PersonAttendanceRecMeta.CC_OUT));
				this.setJbCnt( (BigDecimal)map.get(PersonAttendanceRecMeta.JB_CNT));
				this.setNjCnt( (BigDecimal)map.get(PersonAttendanceRecMeta.NJ_CNT));
				this.setCreateBy( (String)map.get(PersonAttendanceRecMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonAttendanceRecMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonAttendanceRecMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonAttendanceRecMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonAttendanceRecMeta.DELETE_TIME));
				this.setSjCnt( (BigDecimal)map.get(PersonAttendanceRecMeta.SJ_CNT));
				this.setTenantId( (String)map.get(PersonAttendanceRecMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonAttendanceRecMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonAttendanceRecMeta.PERSON_ID));
				this.setId( (String)map.get(PersonAttendanceRecMeta.ID));
				this.setJobNumber( (String)map.get(PersonAttendanceRecMeta.JOB_NUMBER));
				// others
				this.setPerson( (Person)map.get(PersonAttendanceRecMeta.PERSON));
				this.setEmployee( (Employee)map.get(PersonAttendanceRecMeta.EMPLOYEE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.NOTES)));
			this.setRecTime(DataParser.parse(Date.class, r.getValue(PersonAttendanceRecMeta.REC_TIME)));
			this.setOtherCnt(DataParser.parse(BigDecimal.class, r.getValue(PersonAttendanceRecMeta.OTHER_CNT)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonAttendanceRecMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonAttendanceRecMeta.VERSION)));
			this.setCcOut(DataParser.parse(BigDecimal.class, r.getValue(PersonAttendanceRecMeta.CC_OUT)));
			this.setJbCnt(DataParser.parse(BigDecimal.class, r.getValue(PersonAttendanceRecMeta.JB_CNT)));
			this.setNjCnt(DataParser.parse(BigDecimal.class, r.getValue(PersonAttendanceRecMeta.NJ_CNT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonAttendanceRecMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonAttendanceRecMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonAttendanceRecMeta.DELETE_TIME)));
			this.setSjCnt(DataParser.parse(BigDecimal.class, r.getValue(PersonAttendanceRecMeta.SJ_CNT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.ID)));
			this.setJobNumber(DataParser.parse(String.class, r.getValue(PersonAttendanceRecMeta.JOB_NUMBER)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(PersonAttendanceRecMeta.NOTES));
				this.setRecTime( (Date)r.getValue(PersonAttendanceRecMeta.REC_TIME));
				this.setOtherCnt( (BigDecimal)r.getValue(PersonAttendanceRecMeta.OTHER_CNT));
				this.setEmployeeId( (String)r.getValue(PersonAttendanceRecMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(PersonAttendanceRecMeta.UPDATE_TIME));
				this.setUserName( (String)r.getValue(PersonAttendanceRecMeta.USER_NAME));
				this.setVersion( (Integer)r.getValue(PersonAttendanceRecMeta.VERSION));
				this.setCcOut( (BigDecimal)r.getValue(PersonAttendanceRecMeta.CC_OUT));
				this.setJbCnt( (BigDecimal)r.getValue(PersonAttendanceRecMeta.JB_CNT));
				this.setNjCnt( (BigDecimal)r.getValue(PersonAttendanceRecMeta.NJ_CNT));
				this.setCreateBy( (String)r.getValue(PersonAttendanceRecMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonAttendanceRecMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonAttendanceRecMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonAttendanceRecMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonAttendanceRecMeta.DELETE_TIME));
				this.setSjCnt( (BigDecimal)r.getValue(PersonAttendanceRecMeta.SJ_CNT));
				this.setTenantId( (String)r.getValue(PersonAttendanceRecMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonAttendanceRecMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonAttendanceRecMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonAttendanceRecMeta.ID));
				this.setJobNumber( (String)r.getValue(PersonAttendanceRecMeta.JOB_NUMBER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}