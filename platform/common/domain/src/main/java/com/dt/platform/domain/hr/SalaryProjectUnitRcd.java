package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_PROJECT_UNIT_RCD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 计件项目记录
 * <p>计件项目记录 , 数据表 hr_salary_project_unit_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-01 13:54:32
 * @sign CE79F266A1D34590FC9D699992E3F0E0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_project_unit_rcd")
@ApiModel(description = "计件项目记录 ; 计件项目记录 , 数据表 hr_salary_project_unit_rcd 的PO类型")
public class SalaryProjectUnitRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_PROJECT_UNIT_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "805372918040100864")
	private String id;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "801565609459449857")
	private String personId;
	
	/**
	 * 工号：工号
	*/
	@ApiModelProperty(required = false,value="工号" , notes = "工号" , example = "801565609459449856")
	private String jobNumber;
	
	/**
	 * 项目编码：项目编码
	*/
	@ApiModelProperty(required = false,value="项目编码" , notes = "项目编码" , example = "T_001")
	private String projectCode;
	
	/**
	 * 项目名称：项目名称
	*/
	@ApiModelProperty(required = false,value="项目名称" , notes = "项目名称" , example = "运输费")
	private String projectName;
	
	/**
	 * 项目单价：项目单价
	*/
	@ApiModelProperty(required = false,value="项目单价" , notes = "项目单价" , example = "200.00")
	private BigDecimal projectUnitPrice;
	
	/**
	 * 完成数量：完成数量
	*/
	@ApiModelProperty(required = false,value="完成数量" , notes = "完成数量" , example = "2.00")
	private BigDecimal finishNumber;
	
	/**
	 * 总价：总价
	*/
	@ApiModelProperty(required = false,value="总价" , notes = "总价" , example = "2012.00")
	private BigDecimal totalPrice;
	
	/**
	 * 记录日期：记录日期
	*/
	@ApiModelProperty(required = false,value="记录日期" , notes = "记录日期" , example = "2024-02-12 12:00:00")
	private Date rcdDate;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号" , example = "ac")
	private String batchCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-01 09:44:27")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-01 09:44:34")
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
	 * project：project
	*/
	@ApiModelProperty(required = false,value="project" , notes = "project")
	private SalaryProjectUnit project;
	
	/**
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Person person;
	
	/**
	 * projectCodeValue：projectCodeValue
	*/
	@ApiModelProperty(required = false,value="projectCodeValue" , notes = "projectCodeValue")
	private String projectCodeValue;
	
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
	public SalaryProjectUnitRcd setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 姓名
	 * @param personId 姓名
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setPersonId(String personId) {
		this.personId=personId;
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
	public SalaryProjectUnitRcd setJobNumber(String jobNumber) {
		this.jobNumber=jobNumber;
		return this;
	}
	
	/**
	 * 获得 项目编码<br>
	 * 项目编码
	 * @return 项目编码
	*/
	public String getProjectCode() {
		return projectCode;
	}
	
	/**
	 * 设置 项目编码
	 * @param projectCode 项目编码
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setProjectCode(String projectCode) {
		this.projectCode=projectCode;
		return this;
	}
	
	/**
	 * 获得 项目名称<br>
	 * 项目名称
	 * @return 项目名称
	*/
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * 设置 项目名称
	 * @param projectName 项目名称
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setProjectName(String projectName) {
		this.projectName=projectName;
		return this;
	}
	
	/**
	 * 获得 项目单价<br>
	 * 项目单价
	 * @return 项目单价
	*/
	public BigDecimal getProjectUnitPrice() {
		return projectUnitPrice;
	}
	
	/**
	 * 设置 项目单价
	 * @param projectUnitPrice 项目单价
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setProjectUnitPrice(BigDecimal projectUnitPrice) {
		this.projectUnitPrice=projectUnitPrice;
		return this;
	}
	
	/**
	 * 获得 完成数量<br>
	 * 完成数量
	 * @return 完成数量
	*/
	public BigDecimal getFinishNumber() {
		return finishNumber;
	}
	
	/**
	 * 设置 完成数量
	 * @param finishNumber 完成数量
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setFinishNumber(BigDecimal finishNumber) {
		this.finishNumber=finishNumber;
		return this;
	}
	
	/**
	 * 获得 总价<br>
	 * 总价
	 * @return 总价
	*/
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * 设置 总价
	 * @param totalPrice 总价
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice=totalPrice;
		return this;
	}
	
	/**
	 * 获得 记录日期<br>
	 * 记录日期
	 * @return 记录日期
	*/
	public Date getRcdDate() {
		return rcdDate;
	}
	
	/**
	 * 设置 记录日期
	 * @param rcdDate 记录日期
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setRcdDate(Date rcdDate) {
		this.rcdDate=rcdDate;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 批次号
	 * @return 批次号
	*/
	public String getBatchCode() {
		return batchCode;
	}
	
	/**
	 * 设置 批次号
	 * @param batchCode 批次号
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setBatchCode(String batchCode) {
		this.batchCode=batchCode;
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
	public SalaryProjectUnitRcd setNotes(String notes) {
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
	public SalaryProjectUnitRcd setFileIds(String fileIds) {
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
	public SalaryProjectUnitRcd setCreateBy(String createBy) {
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
	public SalaryProjectUnitRcd setCreateTime(Date createTime) {
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
	public SalaryProjectUnitRcd setUpdateBy(String updateBy) {
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
	public SalaryProjectUnitRcd setUpdateTime(Date updateTime) {
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
	public SalaryProjectUnitRcd setDeleted(Integer deleted) {
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
	public SalaryProjectUnitRcd setDeleted(Boolean deletedBool) {
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
	public SalaryProjectUnitRcd setDeleteBy(String deleteBy) {
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
	public SalaryProjectUnitRcd setDeleteTime(Date deleteTime) {
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
	public SalaryProjectUnitRcd setVersion(Integer version) {
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
	public SalaryProjectUnitRcd setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 project<br>
	 * project
	 * @return project
	*/
	public SalaryProjectUnit getProject() {
		return project;
	}
	
	/**
	 * 设置 project
	 * @param project project
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setProject(SalaryProjectUnit project) {
		this.project=project;
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
	public SalaryProjectUnitRcd setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 projectCodeValue<br>
	 * projectCodeValue
	 * @return projectCodeValue
	*/
	public String getProjectCodeValue() {
		return projectCodeValue;
	}
	
	/**
	 * 设置 projectCodeValue
	 * @param projectCodeValue projectCodeValue
	 * @return 当前对象
	*/
	public SalaryProjectUnitRcd setProjectCodeValue(String projectCodeValue) {
		this.projectCodeValue=projectCodeValue;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryProjectUnitRcd , 转换好的 SalaryProjectUnitRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryProjectUnitRcd , 转换好的 PoJo 对象
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
	public SalaryProjectUnitRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryProjectUnitRcd duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setTotalPrice(this.getTotalPrice());
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
		inst.setRcdDate(this.getRcdDate());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setProjectUnitPrice(this.getProjectUnitPrice());
		inst.setProjectName(this.getProjectName());
		inst.setJobNumber(this.getJobNumber());
		inst.setFinishNumber(this.getFinishNumber());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setProjectCodeValue(this.getProjectCodeValue());
			inst.setProject(this.getProject());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryProjectUnitRcd clone(boolean deep) {
		return EntityContext.clone(SalaryProjectUnitRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryProjectUnitRcd
	 * @param salaryProjectUnitRcdMap 包含实体信息的 Map 对象
	 * @return SalaryProjectUnitRcd , 转换好的的 SalaryProjectUnitRcd 对象
	*/
	@Transient
	public static SalaryProjectUnitRcd createFrom(Map<String,Object> salaryProjectUnitRcdMap) {
		if(salaryProjectUnitRcdMap==null) return null;
		SalaryProjectUnitRcd po = create();
		EntityContext.copyProperties(po,salaryProjectUnitRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryProjectUnitRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryProjectUnitRcd , 转换好的的 SalaryProjectUnitRcd 对象
	*/
	@Transient
	public static SalaryProjectUnitRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryProjectUnitRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryProjectUnitRcd，等同于 new
	 * @return SalaryProjectUnitRcd 对象
	*/
	@Transient
	public static SalaryProjectUnitRcd create() {
		return new com.dt.platform.domain.hr.meta.SalaryProjectUnitRcdMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.NOTES)));
			this.setTotalPrice(DataParser.parse(BigDecimal.class, map.get(SalaryProjectUnitRcdMeta.TOTAL_PRICE)));
			this.setBatchCode(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryProjectUnitRcdMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryProjectUnitRcdMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryProjectUnitRcdMeta.DELETED)));
			this.setProjectCode(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.PROJECT_CODE)));
			this.setFileIds(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryProjectUnitRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryProjectUnitRcdMeta.DELETE_TIME)));
			this.setRcdDate(DataParser.parse(Date.class, map.get(SalaryProjectUnitRcdMeta.RCD_DATE)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.ID)));
			this.setProjectUnitPrice(DataParser.parse(BigDecimal.class, map.get(SalaryProjectUnitRcdMeta.PROJECT_UNIT_PRICE)));
			this.setProjectName(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.PROJECT_NAME)));
			this.setJobNumber(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.JOB_NUMBER)));
			this.setFinishNumber(DataParser.parse(BigDecimal.class, map.get(SalaryProjectUnitRcdMeta.FINISH_NUMBER)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(SalaryProjectUnitRcdMeta.PERSON)));
			this.setProjectCodeValue(DataParser.parse(String.class, map.get(SalaryProjectUnitRcdMeta.PROJECT_CODE_VALUE)));
			this.setProject(DataParser.parse(SalaryProjectUnit.class, map.get(SalaryProjectUnitRcdMeta.PROJECT)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SalaryProjectUnitRcdMeta.NOTES));
				this.setTotalPrice( (BigDecimal)map.get(SalaryProjectUnitRcdMeta.TOTAL_PRICE));
				this.setBatchCode( (String)map.get(SalaryProjectUnitRcdMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(SalaryProjectUnitRcdMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(SalaryProjectUnitRcdMeta.VERSION));
				this.setCreateBy( (String)map.get(SalaryProjectUnitRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryProjectUnitRcdMeta.DELETED));
				this.setProjectCode( (String)map.get(SalaryProjectUnitRcdMeta.PROJECT_CODE));
				this.setFileIds( (String)map.get(SalaryProjectUnitRcdMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(SalaryProjectUnitRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryProjectUnitRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryProjectUnitRcdMeta.DELETE_TIME));
				this.setRcdDate( (Date)map.get(SalaryProjectUnitRcdMeta.RCD_DATE));
				this.setTenantId( (String)map.get(SalaryProjectUnitRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryProjectUnitRcdMeta.DELETE_BY));
				this.setPersonId( (String)map.get(SalaryProjectUnitRcdMeta.PERSON_ID));
				this.setId( (String)map.get(SalaryProjectUnitRcdMeta.ID));
				this.setProjectUnitPrice( (BigDecimal)map.get(SalaryProjectUnitRcdMeta.PROJECT_UNIT_PRICE));
				this.setProjectName( (String)map.get(SalaryProjectUnitRcdMeta.PROJECT_NAME));
				this.setJobNumber( (String)map.get(SalaryProjectUnitRcdMeta.JOB_NUMBER));
				this.setFinishNumber( (BigDecimal)map.get(SalaryProjectUnitRcdMeta.FINISH_NUMBER));
				// others
				this.setPerson( (Person)map.get(SalaryProjectUnitRcdMeta.PERSON));
				this.setProjectCodeValue( (String)map.get(SalaryProjectUnitRcdMeta.PROJECT_CODE_VALUE));
				this.setProject( (SalaryProjectUnit)map.get(SalaryProjectUnitRcdMeta.PROJECT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.NOTES)));
			this.setTotalPrice(DataParser.parse(BigDecimal.class, r.getValue(SalaryProjectUnitRcdMeta.TOTAL_PRICE)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitRcdMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryProjectUnitRcdMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryProjectUnitRcdMeta.DELETED)));
			this.setProjectCode(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.PROJECT_CODE)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitRcdMeta.DELETE_TIME)));
			this.setRcdDate(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitRcdMeta.RCD_DATE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.ID)));
			this.setProjectUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(SalaryProjectUnitRcdMeta.PROJECT_UNIT_PRICE)));
			this.setProjectName(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.PROJECT_NAME)));
			this.setJobNumber(DataParser.parse(String.class, r.getValue(SalaryProjectUnitRcdMeta.JOB_NUMBER)));
			this.setFinishNumber(DataParser.parse(BigDecimal.class, r.getValue(SalaryProjectUnitRcdMeta.FINISH_NUMBER)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SalaryProjectUnitRcdMeta.NOTES));
				this.setTotalPrice( (BigDecimal)r.getValue(SalaryProjectUnitRcdMeta.TOTAL_PRICE));
				this.setBatchCode( (String)r.getValue(SalaryProjectUnitRcdMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(SalaryProjectUnitRcdMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(SalaryProjectUnitRcdMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SalaryProjectUnitRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryProjectUnitRcdMeta.DELETED));
				this.setProjectCode( (String)r.getValue(SalaryProjectUnitRcdMeta.PROJECT_CODE));
				this.setFileIds( (String)r.getValue(SalaryProjectUnitRcdMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(SalaryProjectUnitRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryProjectUnitRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryProjectUnitRcdMeta.DELETE_TIME));
				this.setRcdDate( (Date)r.getValue(SalaryProjectUnitRcdMeta.RCD_DATE));
				this.setTenantId( (String)r.getValue(SalaryProjectUnitRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryProjectUnitRcdMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(SalaryProjectUnitRcdMeta.PERSON_ID));
				this.setId( (String)r.getValue(SalaryProjectUnitRcdMeta.ID));
				this.setProjectUnitPrice( (BigDecimal)r.getValue(SalaryProjectUnitRcdMeta.PROJECT_UNIT_PRICE));
				this.setProjectName( (String)r.getValue(SalaryProjectUnitRcdMeta.PROJECT_NAME));
				this.setJobNumber( (String)r.getValue(SalaryProjectUnitRcdMeta.JOB_NUMBER));
				this.setFinishNumber( (BigDecimal)r.getValue(SalaryProjectUnitRcdMeta.FINISH_NUMBER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}