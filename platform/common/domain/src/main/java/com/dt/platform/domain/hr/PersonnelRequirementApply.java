package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSONNEL_REQUIREMENT_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonnelRequirementApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员需求申请
 * <p>人员需求申请 , 数据表 hr_personnel_requirement_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 20:04:44
 * @sign BFFB80796D482941808242EB2F84FF3E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_personnel_requirement_apply")
@ApiModel(description = "人员需求申请 ; 人员需求申请 , 数据表 hr_personnel_requirement_apply 的PO类型")
public class PersonnelRequirementApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSONNEL_REQUIREMENT_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "812047416961269760")
	private String id;
	
	/**
	 * 流程编号：流程编号
	*/
	@ApiModelProperty(required = false,value="流程编号" , notes = "流程编号" , example = "EO202446191946363")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "incomplete")
	private String status;
	
	/**
	 * 征集主题：征集主题
	*/
	@ApiModelProperty(required = false,value="征集主题" , notes = "征集主题" , example = "adfasdfa")
	private String title;
	
	/**
	 * 需求部门：需求部门
	*/
	@ApiModelProperty(required = false,value="需求部门" , notes = "需求部门" , example = "788871090188320766")
	private String orgId;
	
	/**
	 * 薪酬范围：薪酬范围
	*/
	@ApiModelProperty(required = false,value="薪酬范围" , notes = "薪酬范围" , example = "sdf")
	private String salary;
	
	/**
	 * 需求岗位：需求岗位
	*/
	@ApiModelProperty(required = false,value="需求岗位" , notes = "需求岗位" , example = "12")
	private String pos;
	
	/**
	 * 需求人数：需求人数
	*/
	@ApiModelProperty(required = false,value="需求人数" , notes = "需求人数" , example = "12")
	private Integer personNumber;
	
	/**
	 * 招聘方式：招聘方式
	*/
	@ApiModelProperty(required = false,value="招聘方式" , notes = "招聘方式" , example = "sdaf")
	private String method;
	
	/**
	 * 开始日期：开始日期
	*/
	@ApiModelProperty(required = false,value="开始日期" , notes = "开始日期" , example = "2024-02-05 12:00:00")
	private Date sdate;
	
	/**
	 * 结束日期：结束日期
	*/
	@ApiModelProperty(required = false,value="结束日期" , notes = "结束日期" , example = "2024-02-07 12:00:00")
	private Date edate;
	
	/**
	 * 岗位要求：岗位要求
	*/
	@ApiModelProperty(required = false,value="岗位要求" , notes = "岗位要求" , example = "12")
	private String jobRequirement;
	
	/**
	 * 工作内容：工作内容
	*/
	@ApiModelProperty(required = false,value="工作内容" , notes = "工作内容" , example = "12")
	private String workContent;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String applyUserId;
	
	/**
	 * 选择流程：选择流程
	*/
	@ApiModelProperty(required = false,value="选择流程" , notes = "选择流程")
	private String processCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-19 07:46:31")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * organization：organization
	*/
	@ApiModelProperty(required = false,value="organization" , notes = "organization")
	private Organization organization;
	
	/**
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Employee person;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
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
	public PersonnelRequirementApply setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程编号<br>
	 * 流程编号
	 * @return 流程编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 流程编号
	 * @param businessCode 流程编号
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 征集主题<br>
	 * 征集主题
	 * @return 征集主题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 征集主题
	 * @param title 征集主题
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 需求部门<br>
	 * 需求部门
	 * @return 需求部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 需求部门
	 * @param orgId 需求部门
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 薪酬范围<br>
	 * 薪酬范围
	 * @return 薪酬范围
	*/
	public String getSalary() {
		return salary;
	}
	
	/**
	 * 设置 薪酬范围
	 * @param salary 薪酬范围
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setSalary(String salary) {
		this.salary=salary;
		return this;
	}
	
	/**
	 * 获得 需求岗位<br>
	 * 需求岗位
	 * @return 需求岗位
	*/
	public String getPos() {
		return pos;
	}
	
	/**
	 * 设置 需求岗位
	 * @param pos 需求岗位
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setPos(String pos) {
		this.pos=pos;
		return this;
	}
	
	/**
	 * 获得 需求人数<br>
	 * 需求人数
	 * @return 需求人数
	*/
	public Integer getPersonNumber() {
		return personNumber;
	}
	
	/**
	 * 设置 需求人数
	 * @param personNumber 需求人数
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setPersonNumber(Integer personNumber) {
		this.personNumber=personNumber;
		return this;
	}
	
	/**
	 * 获得 招聘方式<br>
	 * 招聘方式
	 * @return 招聘方式
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 招聘方式
	 * @param method 招聘方式
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setMethod(String method) {
		this.method=method;
		return this;
	}
	
	/**
	 * 获得 开始日期<br>
	 * 开始日期
	 * @return 开始日期
	*/
	public Date getSdate() {
		return sdate;
	}
	
	/**
	 * 设置 开始日期
	 * @param sdate 开始日期
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setSdate(Date sdate) {
		this.sdate=sdate;
		return this;
	}
	
	/**
	 * 获得 结束日期<br>
	 * 结束日期
	 * @return 结束日期
	*/
	public Date getEdate() {
		return edate;
	}
	
	/**
	 * 设置 结束日期
	 * @param edate 结束日期
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setEdate(Date edate) {
		this.edate=edate;
		return this;
	}
	
	/**
	 * 获得 岗位要求<br>
	 * 岗位要求
	 * @return 岗位要求
	*/
	public String getJobRequirement() {
		return jobRequirement;
	}
	
	/**
	 * 设置 岗位要求
	 * @param jobRequirement 岗位要求
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setJobRequirement(String jobRequirement) {
		this.jobRequirement=jobRequirement;
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
	public PersonnelRequirementApply setWorkContent(String workContent) {
		this.workContent=workContent;
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
	public PersonnelRequirementApply setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getApplyUserId() {
		return applyUserId;
	}
	
	/**
	 * 设置 申请人
	 * @param applyUserId 申请人
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setApplyUserId(String applyUserId) {
		this.applyUserId=applyUserId;
		return this;
	}
	
	/**
	 * 获得 选择流程<br>
	 * 选择流程
	 * @return 选择流程
	*/
	public String getProcessCode() {
		return processCode;
	}
	
	/**
	 * 设置 选择流程
	 * @param processCode 选择流程
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setProcessCode(String processCode) {
		this.processCode=processCode;
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
	public PersonnelRequirementApply setCreateBy(String createBy) {
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
	public PersonnelRequirementApply setCreateTime(Date createTime) {
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
	public PersonnelRequirementApply setUpdateBy(String updateBy) {
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
	public PersonnelRequirementApply setUpdateTime(Date updateTime) {
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
	public PersonnelRequirementApply setDeleted(Integer deleted) {
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
	public PersonnelRequirementApply setDeleted(Boolean deletedBool) {
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
	public PersonnelRequirementApply setDeleteBy(String deleteBy) {
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
	public PersonnelRequirementApply setDeleteTime(Date deleteTime) {
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
	public PersonnelRequirementApply setVersion(Integer version) {
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
	public PersonnelRequirementApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 organization<br>
	 * organization
	 * @return organization
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 organization
	 * @param organization organization
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setOrganization(Organization organization) {
		this.organization=organization;
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
	public PersonnelRequirementApply setPerson(Employee person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public PersonnelRequirementApply addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public PersonnelRequirementApply addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public PersonnelRequirementApply setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonnelRequirementApply , 转换好的 PersonnelRequirementApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonnelRequirementApply , 转换好的 PoJo 对象
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
	public PersonnelRequirementApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonnelRequirementApply duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonnelRequirementApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonnelRequirementApplyMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setWorkContent(this.getWorkContent());
		inst.setTitle(this.getTitle());
		inst.setSalary(this.getSalary());
		inst.setPersonNumber(this.getPersonNumber());
		inst.setOrgId(this.getOrgId());
		inst.setApplyUserId(this.getApplyUserId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setPos(this.getPos());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setSdate(this.getSdate());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEdate(this.getEdate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setProcessCode(this.getProcessCode());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		inst.setJobRequirement(this.getJobRequirement());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setOrganization(this.getOrganization());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonnelRequirementApply clone(boolean deep) {
		return EntityContext.clone(PersonnelRequirementApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonnelRequirementApply
	 * @param personnelRequirementApplyMap 包含实体信息的 Map 对象
	 * @return PersonnelRequirementApply , 转换好的的 PersonnelRequirementApply 对象
	*/
	@Transient
	public static PersonnelRequirementApply createFrom(Map<String,Object> personnelRequirementApplyMap) {
		if(personnelRequirementApplyMap==null) return null;
		PersonnelRequirementApply po = create();
		EntityContext.copyProperties(po,personnelRequirementApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonnelRequirementApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonnelRequirementApply , 转换好的的 PersonnelRequirementApply 对象
	*/
	@Transient
	public static PersonnelRequirementApply createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonnelRequirementApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonnelRequirementApply，等同于 new
	 * @return PersonnelRequirementApply 对象
	*/
	@Transient
	public static PersonnelRequirementApply create() {
		return new com.dt.platform.domain.hr.meta.PersonnelRequirementApplyMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.NOTES)));
			this.setWorkContent(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.WORK_CONTENT)));
			this.setTitle(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.TITLE)));
			this.setSalary(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.SALARY)));
			this.setPersonNumber(DataParser.parse(Integer.class, map.get(PersonnelRequirementApplyMeta.PERSON_NUMBER)));
			this.setOrgId(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.ORG_ID)));
			this.setApplyUserId(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.APPLY_USER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.BUSINESS_CODE)));
			this.setPos(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.ID)));
			this.setSdate(DataParser.parse(Date.class, map.get(PersonnelRequirementApplyMeta.SDATE)));
			this.setMethod(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonnelRequirementApplyMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(Date.class, map.get(PersonnelRequirementApplyMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonnelRequirementApplyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonnelRequirementApplyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonnelRequirementApplyMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonnelRequirementApplyMeta.DELETE_TIME)));
			this.setProcessCode(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.PROCESS_CODE)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, map.get(PersonnelRequirementApplyMeta.JOB_REQUIREMENT)));
			// others
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonnelRequirementApplyMeta.PERSON)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(PersonnelRequirementApplyMeta.ORGANIZATION)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PersonnelRequirementApplyMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(PersonnelRequirementApplyMeta.NOTES));
				this.setWorkContent( (String)map.get(PersonnelRequirementApplyMeta.WORK_CONTENT));
				this.setTitle( (String)map.get(PersonnelRequirementApplyMeta.TITLE));
				this.setSalary( (String)map.get(PersonnelRequirementApplyMeta.SALARY));
				this.setPersonNumber( (Integer)map.get(PersonnelRequirementApplyMeta.PERSON_NUMBER));
				this.setOrgId( (String)map.get(PersonnelRequirementApplyMeta.ORG_ID));
				this.setApplyUserId( (String)map.get(PersonnelRequirementApplyMeta.APPLY_USER_ID));
				this.setBusinessCode( (String)map.get(PersonnelRequirementApplyMeta.BUSINESS_CODE));
				this.setPos( (String)map.get(PersonnelRequirementApplyMeta.POS));
				this.setUpdateBy( (String)map.get(PersonnelRequirementApplyMeta.UPDATE_BY));
				this.setId( (String)map.get(PersonnelRequirementApplyMeta.ID));
				this.setSdate( (Date)map.get(PersonnelRequirementApplyMeta.SDATE));
				this.setMethod( (String)map.get(PersonnelRequirementApplyMeta.METHOD));
				this.setUpdateTime( (Date)map.get(PersonnelRequirementApplyMeta.UPDATE_TIME));
				this.setEdate( (Date)map.get(PersonnelRequirementApplyMeta.EDATE));
				this.setVersion( (Integer)map.get(PersonnelRequirementApplyMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonnelRequirementApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonnelRequirementApplyMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonnelRequirementApplyMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PersonnelRequirementApplyMeta.DELETE_TIME));
				this.setProcessCode( (String)map.get(PersonnelRequirementApplyMeta.PROCESS_CODE));
				this.setTenantId( (String)map.get(PersonnelRequirementApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonnelRequirementApplyMeta.DELETE_BY));
				this.setStatus( (String)map.get(PersonnelRequirementApplyMeta.STATUS));
				this.setJobRequirement( (String)map.get(PersonnelRequirementApplyMeta.JOB_REQUIREMENT));
				// others
				this.setPerson( (Employee)map.get(PersonnelRequirementApplyMeta.PERSON));
				this.setOrganization( (Organization)map.get(PersonnelRequirementApplyMeta.ORGANIZATION));
				this.setDefaultProcess( (ProcessInstance)map.get(PersonnelRequirementApplyMeta.DEFAULT_PROCESS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.NOTES)));
			this.setWorkContent(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.WORK_CONTENT)));
			this.setTitle(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.TITLE)));
			this.setSalary(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.SALARY)));
			this.setPersonNumber(DataParser.parse(Integer.class, r.getValue(PersonnelRequirementApplyMeta.PERSON_NUMBER)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.ORG_ID)));
			this.setApplyUserId(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.APPLY_USER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.BUSINESS_CODE)));
			this.setPos(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.ID)));
			this.setSdate(DataParser.parse(Date.class, r.getValue(PersonnelRequirementApplyMeta.SDATE)));
			this.setMethod(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonnelRequirementApplyMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(Date.class, r.getValue(PersonnelRequirementApplyMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonnelRequirementApplyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonnelRequirementApplyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonnelRequirementApplyMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonnelRequirementApplyMeta.DELETE_TIME)));
			this.setProcessCode(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.PROCESS_CODE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, r.getValue(PersonnelRequirementApplyMeta.JOB_REQUIREMENT)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(PersonnelRequirementApplyMeta.NOTES));
				this.setWorkContent( (String)r.getValue(PersonnelRequirementApplyMeta.WORK_CONTENT));
				this.setTitle( (String)r.getValue(PersonnelRequirementApplyMeta.TITLE));
				this.setSalary( (String)r.getValue(PersonnelRequirementApplyMeta.SALARY));
				this.setPersonNumber( (Integer)r.getValue(PersonnelRequirementApplyMeta.PERSON_NUMBER));
				this.setOrgId( (String)r.getValue(PersonnelRequirementApplyMeta.ORG_ID));
				this.setApplyUserId( (String)r.getValue(PersonnelRequirementApplyMeta.APPLY_USER_ID));
				this.setBusinessCode( (String)r.getValue(PersonnelRequirementApplyMeta.BUSINESS_CODE));
				this.setPos( (String)r.getValue(PersonnelRequirementApplyMeta.POS));
				this.setUpdateBy( (String)r.getValue(PersonnelRequirementApplyMeta.UPDATE_BY));
				this.setId( (String)r.getValue(PersonnelRequirementApplyMeta.ID));
				this.setSdate( (Date)r.getValue(PersonnelRequirementApplyMeta.SDATE));
				this.setMethod( (String)r.getValue(PersonnelRequirementApplyMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(PersonnelRequirementApplyMeta.UPDATE_TIME));
				this.setEdate( (Date)r.getValue(PersonnelRequirementApplyMeta.EDATE));
				this.setVersion( (Integer)r.getValue(PersonnelRequirementApplyMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonnelRequirementApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonnelRequirementApplyMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonnelRequirementApplyMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PersonnelRequirementApplyMeta.DELETE_TIME));
				this.setProcessCode( (String)r.getValue(PersonnelRequirementApplyMeta.PROCESS_CODE));
				this.setTenantId( (String)r.getValue(PersonnelRequirementApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonnelRequirementApplyMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(PersonnelRequirementApplyMeta.STATUS));
				this.setJobRequirement( (String)r.getValue(PersonnelRequirementApplyMeta.JOB_REQUIREMENT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}