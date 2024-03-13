package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentPlanMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核计划
 * <p>考核计划 , 数据表 hr_assessment_plan 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 15:10:35
 * @sign 6B52ACEDE926EC00131EA726BCDAF899
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_plan")
@ApiModel(description = "考核计划 ; 考核计划 , 数据表 hr_assessment_plan 的PO类型")
public class AssessmentPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号")
	private String businessCode;
	
	/**
	 * 考核名称：考核名称
	*/
	@ApiModelProperty(required = false,value="考核名称" , notes = "考核名称")
	private String name;
	
	/**
	 * 岗位：岗位
	*/
	@ApiModelProperty(required = false,value="岗位" , notes = "岗位")
	private String posId;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private String cycle;
	
	/**
	 * 考核方式：考核方式
	*/
	@ApiModelProperty(required = false,value="考核方式" , notes = "考核方式")
	private String method;
	
	/**
	 * 被考核人：被考核人
	*/
	@ApiModelProperty(required = false,value="被考核人" , notes = "被考核人")
	private String assesseeId;
	
	/**
	 * 考核人：考核人
	*/
	@ApiModelProperty(required = false,value="考核人" , notes = "考核人")
	private String assessorId;
	
	/**
	 * 二级考核人：二级考核人
	*/
	@ApiModelProperty(required = false,value="二级考核人" , notes = "二级考核人")
	private String assessorSecondId;
	
	/**
	 * 指标总权重：%）
	*/
	@ApiModelProperty(required = false,value="指标总权重" , notes = "%）")
	private BigDecimal totalWeight;
	
	/**
	 * 考勤模版：考勤模版
	*/
	@ApiModelProperty(required = false,value="考勤模版" , notes = "考勤模版")
	private String tplId;
	
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
	 * assessmentTpl：assessmentTpl
	*/
	@ApiModelProperty(required = false,value="assessmentTpl" , notes = "assessmentTpl")
	private AssessmentTpl assessmentTpl;
	
	/**
	 * assessmentIndicatorList：assessmentIndicator
	*/
	@ApiModelProperty(required = false,value="assessmentIndicatorList" , notes = "assessmentIndicator")
	private List<AssessmentIndicator> assessmentIndicatorList;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * buttonAction：buttonAction
	*/
	@ApiModelProperty(required = false,value="buttonAction" , notes = "buttonAction")
	private String buttonAction;
	
	/**
	 * assesseeUser：assesseeUser
	*/
	@ApiModelProperty(required = false,value="assesseeUser" , notes = "assesseeUser")
	private Person assesseeUser;
	
	/**
	 * assessorUser：assessorUser
	*/
	@ApiModelProperty(required = false,value="assessorUser" , notes = "assessorUser")
	private Person assessorUser;
	
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
	public AssessmentPlan setId(String id) {
		this.id=id;
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
	public AssessmentPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 编号
	 * @param businessCode 编号
	 * @return 当前对象
	*/
	public AssessmentPlan setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 考核名称<br>
	 * 考核名称
	 * @return 考核名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 考核名称
	 * @param name 考核名称
	 * @return 当前对象
	*/
	public AssessmentPlan setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 岗位<br>
	 * 岗位
	 * @return 岗位
	*/
	public String getPosId() {
		return posId;
	}
	
	/**
	 * 设置 岗位
	 * @param posId 岗位
	 * @return 当前对象
	*/
	public AssessmentPlan setPosId(String posId) {
		this.posId=posId;
		return this;
	}
	
	/**
	 * 获得 周期<br>
	 * 周期
	 * @return 周期
	*/
	public String getCycle() {
		return cycle;
	}
	
	/**
	 * 设置 周期
	 * @param cycle 周期
	 * @return 当前对象
	*/
	public AssessmentPlan setCycle(String cycle) {
		this.cycle=cycle;
		return this;
	}
	
	/**
	 * 获得 考核方式<br>
	 * 考核方式
	 * @return 考核方式
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 考核方式
	 * @param method 考核方式
	 * @return 当前对象
	*/
	public AssessmentPlan setMethod(String method) {
		this.method=method;
		return this;
	}
	
	/**
	 * 获得 被考核人<br>
	 * 被考核人
	 * @return 被考核人
	*/
	public String getAssesseeId() {
		return assesseeId;
	}
	
	/**
	 * 设置 被考核人
	 * @param assesseeId 被考核人
	 * @return 当前对象
	*/
	public AssessmentPlan setAssesseeId(String assesseeId) {
		this.assesseeId=assesseeId;
		return this;
	}
	
	/**
	 * 获得 考核人<br>
	 * 考核人
	 * @return 考核人
	*/
	public String getAssessorId() {
		return assessorId;
	}
	
	/**
	 * 设置 考核人
	 * @param assessorId 考核人
	 * @return 当前对象
	*/
	public AssessmentPlan setAssessorId(String assessorId) {
		this.assessorId=assessorId;
		return this;
	}
	
	/**
	 * 获得 二级考核人<br>
	 * 二级考核人
	 * @return 二级考核人
	*/
	public String getAssessorSecondId() {
		return assessorSecondId;
	}
	
	/**
	 * 设置 二级考核人
	 * @param assessorSecondId 二级考核人
	 * @return 当前对象
	*/
	public AssessmentPlan setAssessorSecondId(String assessorSecondId) {
		this.assessorSecondId=assessorSecondId;
		return this;
	}
	
	/**
	 * 获得 指标总权重<br>
	 * %）
	 * @return 指标总权重
	*/
	public BigDecimal getTotalWeight() {
		return totalWeight;
	}
	
	/**
	 * 设置 指标总权重
	 * @param totalWeight 指标总权重
	 * @return 当前对象
	*/
	public AssessmentPlan setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight=totalWeight;
		return this;
	}
	
	/**
	 * 获得 考勤模版<br>
	 * 考勤模版
	 * @return 考勤模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 考勤模版
	 * @param tplId 考勤模版
	 * @return 当前对象
	*/
	public AssessmentPlan setTplId(String tplId) {
		this.tplId=tplId;
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
	public AssessmentPlan setNotes(String notes) {
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
	public AssessmentPlan setCreateBy(String createBy) {
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
	public AssessmentPlan setCreateTime(Date createTime) {
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
	public AssessmentPlan setUpdateBy(String updateBy) {
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
	public AssessmentPlan setUpdateTime(Date updateTime) {
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
	public AssessmentPlan setDeleted(Integer deleted) {
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
	public AssessmentPlan setDeleted(Boolean deletedBool) {
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
	public AssessmentPlan setDeleteBy(String deleteBy) {
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
	public AssessmentPlan setDeleteTime(Date deleteTime) {
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
	public AssessmentPlan setVersion(Integer version) {
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
	public AssessmentPlan setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 assessmentTpl<br>
	 * assessmentTpl
	 * @return assessmentTpl
	*/
	public AssessmentTpl getAssessmentTpl() {
		return assessmentTpl;
	}
	
	/**
	 * 设置 assessmentTpl
	 * @param assessmentTpl assessmentTpl
	 * @return 当前对象
	*/
	public AssessmentPlan setAssessmentTpl(AssessmentTpl assessmentTpl) {
		this.assessmentTpl=assessmentTpl;
		return this;
	}
	
	/**
	 * 获得 assessmentIndicatorList<br>
	 * assessmentIndicator
	 * @return assessmentIndicatorList
	*/
	public List<AssessmentIndicator> getAssessmentIndicatorList() {
		return assessmentIndicatorList;
	}
	
	/**
	 * 设置 assessmentIndicatorList
	 * @param assessmentIndicatorList assessmentIndicatorList
	 * @return 当前对象
	*/
	public AssessmentPlan setAssessmentIndicatorList(List<AssessmentIndicator> assessmentIndicatorList) {
		this.assessmentIndicatorList=assessmentIndicatorList;
		return this;
	}
	
	/**
	 * 添加 assessmentIndicatorList
	 * @param assessmentIndicator assessmentIndicatorList
	 * @return 当前对象
	*/
	public AssessmentPlan addAssessmentIndicator(AssessmentIndicator... assessmentIndicator) {
		if(this.assessmentIndicatorList==null) assessmentIndicatorList=new ArrayList<>();
		this.assessmentIndicatorList.addAll(Arrays.asList(assessmentIndicator));
		return this;
	}
	
	/**
	 * 获得 selectedCode<br>
	 * selectedCode
	 * @return selectedCode
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 selectedCode
	 * @param selectedCode selectedCode
	 * @return 当前对象
	*/
	public AssessmentPlan setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 buttonAction<br>
	 * buttonAction
	 * @return buttonAction
	*/
	public String getButtonAction() {
		return buttonAction;
	}
	
	/**
	 * 设置 buttonAction
	 * @param buttonAction buttonAction
	 * @return 当前对象
	*/
	public AssessmentPlan setButtonAction(String buttonAction) {
		this.buttonAction=buttonAction;
		return this;
	}
	
	/**
	 * 获得 assesseeUser<br>
	 * assesseeUser
	 * @return assesseeUser
	*/
	public Person getAssesseeUser() {
		return assesseeUser;
	}
	
	/**
	 * 设置 assesseeUser
	 * @param assesseeUser assesseeUser
	 * @return 当前对象
	*/
	public AssessmentPlan setAssesseeUser(Person assesseeUser) {
		this.assesseeUser=assesseeUser;
		return this;
	}
	
	/**
	 * 获得 assessorUser<br>
	 * assessorUser
	 * @return assessorUser
	*/
	public Person getAssessorUser() {
		return assessorUser;
	}
	
	/**
	 * 设置 assessorUser
	 * @param assessorUser assessorUser
	 * @return 当前对象
	*/
	public AssessmentPlan setAssessorUser(Person assessorUser) {
		this.assessorUser=assessorUser;
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
	public AssessmentPlan setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public AssessmentPlan addHistoricProcess(ProcessInstance... historicProcess) {
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
	public AssessmentPlan setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public AssessmentPlan addCurrentProcess(ProcessInstance... currentProcess) {
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
	public AssessmentPlan setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentPlan , 转换好的 AssessmentPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentPlan , 转换好的 PoJo 对象
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
	public AssessmentPlan clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentPlan duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentPlanMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentPlanMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setAssessorSecondId(this.getAssessorSecondId());
		inst.setCycle(this.getCycle());
		inst.setVersion(this.getVersion());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setPosId(this.getPosId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setName(this.getName());
		inst.setTotalWeight(this.getTotalWeight());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssesseeUser(this.getAssesseeUser());
			inst.setAssessorUser(this.getAssessorUser());
			inst.setAssessmentIndicatorList(this.getAssessmentIndicatorList());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setAssessmentTpl(this.getAssessmentTpl());
			inst.setButtonAction(this.getButtonAction());
			inst.setSelectedCode(this.getSelectedCode());
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
	public AssessmentPlan clone(boolean deep) {
		return EntityContext.clone(AssessmentPlan.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentPlan
	 * @param assessmentPlanMap 包含实体信息的 Map 对象
	 * @return AssessmentPlan , 转换好的的 AssessmentPlan 对象
	*/
	@Transient
	public static AssessmentPlan createFrom(Map<String,Object> assessmentPlanMap) {
		if(assessmentPlanMap==null) return null;
		AssessmentPlan po = create();
		EntityContext.copyProperties(po,assessmentPlanMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentPlan , 转换好的的 AssessmentPlan 对象
	*/
	@Transient
	public static AssessmentPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentPlan po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentPlan，等同于 new
	 * @return AssessmentPlan 对象
	*/
	@Transient
	public static AssessmentPlan create() {
		return new com.dt.platform.domain.hr.meta.AssessmentPlanMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssessmentPlanMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, map.get(AssessmentPlanMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentPlanMeta.UPDATE_TIME)));
			this.setAssessorSecondId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.ASSESSOR_SECOND_ID)));
			this.setCycle(DataParser.parse(String.class, map.get(AssessmentPlanMeta.CYCLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentPlanMeta.VERSION)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.ASSESSEE_ID)));
			this.setPosId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.POS_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssessmentPlanMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentPlanMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentPlanMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentPlanMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.ASSESSOR_ID)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentPlanMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentPlanMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentPlanMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(AssessmentPlanMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentPlanMeta.STATUS)));
			// others
			this.setAssesseeUser(DataParser.parse(Person.class, map.get(AssessmentPlanMeta.ASSESSEE_USER)));
			this.setAssessorUser(DataParser.parse(Person.class, map.get(AssessmentPlanMeta.ASSESSOR_USER)));
			this.setAssessmentTpl(DataParser.parse(AssessmentTpl.class, map.get(AssessmentPlanMeta.ASSESSMENT_TPL)));
			this.setButtonAction(DataParser.parse(String.class, map.get(AssessmentPlanMeta.BUTTON_ACTION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssessmentPlanMeta.SELECTED_CODE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssessmentPlanMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssessmentPlanMeta.NOTES));
				this.setMethod( (String)map.get(AssessmentPlanMeta.METHOD));
				this.setUpdateTime( (Date)map.get(AssessmentPlanMeta.UPDATE_TIME));
				this.setAssessorSecondId( (String)map.get(AssessmentPlanMeta.ASSESSOR_SECOND_ID));
				this.setCycle( (String)map.get(AssessmentPlanMeta.CYCLE));
				this.setVersion( (Integer)map.get(AssessmentPlanMeta.VERSION));
				this.setAssesseeId( (String)map.get(AssessmentPlanMeta.ASSESSEE_ID));
				this.setPosId( (String)map.get(AssessmentPlanMeta.POS_ID));
				this.setBusinessCode( (String)map.get(AssessmentPlanMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssessmentPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentPlanMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentPlanMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentPlanMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentPlanMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentPlanMeta.ASSESSOR_ID));
				this.setName( (String)map.get(AssessmentPlanMeta.NAME));
				this.setTotalWeight( (BigDecimal)map.get(AssessmentPlanMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)map.get(AssessmentPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentPlanMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentPlanMeta.ID));
				this.setTplId( (String)map.get(AssessmentPlanMeta.TPL_ID));
				this.setStatus( (String)map.get(AssessmentPlanMeta.STATUS));
				// others
				this.setAssesseeUser( (Person)map.get(AssessmentPlanMeta.ASSESSEE_USER));
				this.setAssessorUser( (Person)map.get(AssessmentPlanMeta.ASSESSOR_USER));
				this.setAssessmentTpl( (AssessmentTpl)map.get(AssessmentPlanMeta.ASSESSMENT_TPL));
				this.setButtonAction( (String)map.get(AssessmentPlanMeta.BUTTON_ACTION));
				this.setSelectedCode( (String)map.get(AssessmentPlanMeta.SELECTED_CODE));
				this.setDefaultProcess( (ProcessInstance)map.get(AssessmentPlanMeta.DEFAULT_PROCESS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentPlanMeta.UPDATE_TIME)));
			this.setAssessorSecondId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.ASSESSOR_SECOND_ID)));
			this.setCycle(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.CYCLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentPlanMeta.VERSION)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.ASSESSEE_ID)));
			this.setPosId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.POS_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentPlanMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentPlanMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.ASSESSOR_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentPlanMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentPlanMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssessmentPlanMeta.NOTES));
				this.setMethod( (String)r.getValue(AssessmentPlanMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(AssessmentPlanMeta.UPDATE_TIME));
				this.setAssessorSecondId( (String)r.getValue(AssessmentPlanMeta.ASSESSOR_SECOND_ID));
				this.setCycle( (String)r.getValue(AssessmentPlanMeta.CYCLE));
				this.setVersion( (Integer)r.getValue(AssessmentPlanMeta.VERSION));
				this.setAssesseeId( (String)r.getValue(AssessmentPlanMeta.ASSESSEE_ID));
				this.setPosId( (String)r.getValue(AssessmentPlanMeta.POS_ID));
				this.setBusinessCode( (String)r.getValue(AssessmentPlanMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssessmentPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentPlanMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentPlanMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentPlanMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentPlanMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentPlanMeta.ASSESSOR_ID));
				this.setName( (String)r.getValue(AssessmentPlanMeta.NAME));
				this.setTotalWeight( (BigDecimal)r.getValue(AssessmentPlanMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)r.getValue(AssessmentPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentPlanMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentPlanMeta.ID));
				this.setTplId( (String)r.getValue(AssessmentPlanMeta.TPL_ID));
				this.setStatus( (String)r.getValue(AssessmentPlanMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}