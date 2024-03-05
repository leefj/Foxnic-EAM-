package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核任务
 * <p>考核任务 , 数据表 hr_assessment_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-02 19:40:25
 * @sign 2247B2F097AA83F2840257359BF3CF32
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_task")
@ApiModel(description = "考核任务 ; 考核任务 , 数据表 hr_assessment_task 的PO类型")
public class AssessmentTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "816383435982503936")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String owner;
	
	/**
	 * 考核状态：考核状态
	*/
	@ApiModelProperty(required = false,value="考核状态" , notes = "考核状态")
	private String status;
	
	/**
	 * 考核名称：考核名称
	*/
	@ApiModelProperty(required = false,value="考核名称" , notes = "考核名称" , example = "12")
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
	 * 全部人员：全部人员
	*/
	@ApiModelProperty(required = false,value="全部人员" , notes = "全部人员")
	private String isAllPerson;
	
	/**
	 * 同级评分人：同级评分人
	*/
	@ApiModelProperty(required = false,value="同级评分人" , notes = "同级评分人")
	private String sameLevelUserId;
	
	/**
	 * 考核方式：考核方式
	*/
	@ApiModelProperty(required = false,value="考核方式" , notes = "考核方式")
	private String assessmenMethod;
	
	/**
	 * 指标总权重：%）
	*/
	@ApiModelProperty(required = false,value="指标总权重" , notes = "%）" , example = "12.00")
	private BigDecimal totalWeight;
	
	/**
	 * 自评：自评
	*/
	@ApiModelProperty(required = false,value="自评" , notes = "自评")
	private String hasSelfAssessment;
	
	/**
	 * 同级评分：同级评分
	*/
	@ApiModelProperty(required = false,value="同级评分" , notes = "同级评分")
	private String hasSameAssessment;
	
	/**
	 * 直接领导评分：直接领导评分
	*/
	@ApiModelProperty(required = false,value="直接领导评分" , notes = "直接领导评分")
	private String hasLeaderAssessment;
	
	/**
	 * 领导评分：领导评分
	*/
	@ApiModelProperty(required = false,value="领导评分" , notes = "领导评分")
	private String hasSecondLeaderAssessment;
	
	/**
	 * HR复核：HR复核
	*/
	@ApiModelProperty(required = false,value="HR复核" , notes = "HR复核")
	private String hasHrConfirm;
	
	/**
	 * 绩效模版：绩效模版
	*/
	@ApiModelProperty(required = false,value="绩效模版" , notes = "绩效模版")
	private String tplId;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String source;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "12")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-02 06:56:19")
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
	 * assessmentTpl：assessmentTpl
	*/
	@ApiModelProperty(required = false,value="assessmentTpl" , notes = "assessmentTpl")
	private AssessmentTpl assessmentTpl;
	
	/**
	 * assessmentIndicator：assessmentIndicator
	*/
	@ApiModelProperty(required = false,value="assessmentIndicator" , notes = "assessmentIndicator")
	private List<AssessmentIndicator> assessmentIndicator;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * organizationList：organizationList
	*/
	@ApiModelProperty(required = false,value="organizationList" , notes = "organizationList")
	private List<Organization> organizationList;
	
	/**
	 * organizationIds：organizationIds
	*/
	@ApiModelProperty(required = false,value="organizationIds" , notes = "organizationIds")
	private List<String> organizationIds;
	
	/**
	 * personList：personList
	*/
	@ApiModelProperty(required = false,value="personList" , notes = "personList")
	private List<Person> personList;
	
	/**
	 * personIds：personIds
	*/
	@ApiModelProperty(required = false,value="personIds" , notes = "personIds")
	private List<String> personIds;
	
	/**
	 * excludePersonList：excludePersonList
	*/
	@ApiModelProperty(required = false,value="excludePersonList" , notes = "excludePersonList")
	private List<Person> excludePersonList;
	
	/**
	 * excludePersonIds：excludePersonIds
	*/
	@ApiModelProperty(required = false,value="excludePersonIds" , notes = "excludePersonIds")
	private List<String> excludePersonIds;
	
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
	public AssessmentTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 设置 所属
	 * @param owner 所属
	 * @return 当前对象
	*/
	public AssessmentTask setOwner(String owner) {
		this.owner=owner;
		return this;
	}
	
	/**
	 * 获得 考核状态<br>
	 * 考核状态
	 * @return 考核状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 考核状态
	 * @param status 考核状态
	 * @return 当前对象
	*/
	public AssessmentTask setStatus(String status) {
		this.status=status;
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
	public AssessmentTask setName(String name) {
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
	public AssessmentTask setPosId(String posId) {
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
	public AssessmentTask setCycle(String cycle) {
		this.cycle=cycle;
		return this;
	}
	
	/**
	 * 获得 全部人员<br>
	 * 全部人员
	 * @return 全部人员
	*/
	public String getIsAllPerson() {
		return isAllPerson;
	}
	
	/**
	 * 设置 全部人员
	 * @param isAllPerson 全部人员
	 * @return 当前对象
	*/
	public AssessmentTask setIsAllPerson(String isAllPerson) {
		this.isAllPerson=isAllPerson;
		return this;
	}
	
	/**
	 * 获得 同级评分人<br>
	 * 同级评分人
	 * @return 同级评分人
	*/
	public String getSameLevelUserId() {
		return sameLevelUserId;
	}
	
	/**
	 * 设置 同级评分人
	 * @param sameLevelUserId 同级评分人
	 * @return 当前对象
	*/
	public AssessmentTask setSameLevelUserId(String sameLevelUserId) {
		this.sameLevelUserId=sameLevelUserId;
		return this;
	}
	
	/**
	 * 获得 考核方式<br>
	 * 考核方式
	 * @return 考核方式
	*/
	public String getAssessmenMethod() {
		return assessmenMethod;
	}
	
	/**
	 * 设置 考核方式
	 * @param assessmenMethod 考核方式
	 * @return 当前对象
	*/
	public AssessmentTask setAssessmenMethod(String assessmenMethod) {
		this.assessmenMethod=assessmenMethod;
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
	public AssessmentTask setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight=totalWeight;
		return this;
	}
	
	/**
	 * 获得 自评<br>
	 * 自评
	 * @return 自评
	*/
	public String getHasSelfAssessment() {
		return hasSelfAssessment;
	}
	
	/**
	 * 设置 自评
	 * @param hasSelfAssessment 自评
	 * @return 当前对象
	*/
	public AssessmentTask setHasSelfAssessment(String hasSelfAssessment) {
		this.hasSelfAssessment=hasSelfAssessment;
		return this;
	}
	
	/**
	 * 获得 同级评分<br>
	 * 同级评分
	 * @return 同级评分
	*/
	public String getHasSameAssessment() {
		return hasSameAssessment;
	}
	
	/**
	 * 设置 同级评分
	 * @param hasSameAssessment 同级评分
	 * @return 当前对象
	*/
	public AssessmentTask setHasSameAssessment(String hasSameAssessment) {
		this.hasSameAssessment=hasSameAssessment;
		return this;
	}
	
	/**
	 * 获得 直接领导评分<br>
	 * 直接领导评分
	 * @return 直接领导评分
	*/
	public String getHasLeaderAssessment() {
		return hasLeaderAssessment;
	}
	
	/**
	 * 设置 直接领导评分
	 * @param hasLeaderAssessment 直接领导评分
	 * @return 当前对象
	*/
	public AssessmentTask setHasLeaderAssessment(String hasLeaderAssessment) {
		this.hasLeaderAssessment=hasLeaderAssessment;
		return this;
	}
	
	/**
	 * 获得 领导评分<br>
	 * 领导评分
	 * @return 领导评分
	*/
	public String getHasSecondLeaderAssessment() {
		return hasSecondLeaderAssessment;
	}
	
	/**
	 * 设置 领导评分
	 * @param hasSecondLeaderAssessment 领导评分
	 * @return 当前对象
	*/
	public AssessmentTask setHasSecondLeaderAssessment(String hasSecondLeaderAssessment) {
		this.hasSecondLeaderAssessment=hasSecondLeaderAssessment;
		return this;
	}
	
	/**
	 * 获得 HR复核<br>
	 * HR复核
	 * @return HR复核
	*/
	public String getHasHrConfirm() {
		return hasHrConfirm;
	}
	
	/**
	 * 设置 HR复核
	 * @param hasHrConfirm HR复核
	 * @return 当前对象
	*/
	public AssessmentTask setHasHrConfirm(String hasHrConfirm) {
		this.hasHrConfirm=hasHrConfirm;
		return this;
	}
	
	/**
	 * 获得 绩效模版<br>
	 * 绩效模版
	 * @return 绩效模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 绩效模版
	 * @param tplId 绩效模版
	 * @return 当前对象
	*/
	public AssessmentTask setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public AssessmentTask setSource(String source) {
		this.source=source;
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
	public AssessmentTask setNotes(String notes) {
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
	public AssessmentTask setCreateBy(String createBy) {
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
	public AssessmentTask setCreateTime(Date createTime) {
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
	public AssessmentTask setUpdateBy(String updateBy) {
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
	public AssessmentTask setUpdateTime(Date updateTime) {
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
	public AssessmentTask setDeleted(Integer deleted) {
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
	public AssessmentTask setDeleted(Boolean deletedBool) {
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
	public AssessmentTask setDeleteBy(String deleteBy) {
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
	public AssessmentTask setDeleteTime(Date deleteTime) {
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
	public AssessmentTask setVersion(Integer version) {
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
	public AssessmentTask setTenantId(String tenantId) {
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
	public AssessmentTask setAssessmentTpl(AssessmentTpl assessmentTpl) {
		this.assessmentTpl=assessmentTpl;
		return this;
	}
	
	/**
	 * 获得 assessmentIndicator<br>
	 * assessmentIndicator
	 * @return assessmentIndicator
	*/
	public List<AssessmentIndicator> getAssessmentIndicator() {
		return assessmentIndicator;
	}
	
	/**
	 * 设置 assessmentIndicator
	 * @param assessmentIndicator assessmentIndicator
	 * @return 当前对象
	*/
	public AssessmentTask setAssessmentIndicator(List<AssessmentIndicator> assessmentIndicator) {
		this.assessmentIndicator=assessmentIndicator;
		return this;
	}
	
	/**
	 * 添加 assessmentIndicator
	 * @param entity assessmentIndicator
	 * @return 当前对象
	*/
	public AssessmentTask addAssessmentIndicator(AssessmentIndicator... entity) {
		if(this.assessmentIndicator==null) assessmentIndicator=new ArrayList<>();
		this.assessmentIndicator.addAll(Arrays.asList(entity));
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
	public AssessmentTask setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 organizationList<br>
	 * organizationList
	 * @return organizationList
	*/
	public List<Organization> getOrganizationList() {
		return organizationList;
	}
	
	/**
	 * 设置 organizationList
	 * @param organizationList organizationList
	 * @return 当前对象
	*/
	public AssessmentTask setOrganizationList(List<Organization> organizationList) {
		this.organizationList=organizationList;
		return this;
	}
	
	/**
	 * 添加 organizationList
	 * @param organization organizationList
	 * @return 当前对象
	*/
	public AssessmentTask addOrganization(Organization... organization) {
		if(this.organizationList==null) organizationList=new ArrayList<>();
		this.organizationList.addAll(Arrays.asList(organization));
		return this;
	}
	
	/**
	 * 获得 organizationIds<br>
	 * organizationIds
	 * @return organizationIds
	*/
	public List<String> getOrganizationIds() {
		return organizationIds;
	}
	
	/**
	 * 设置 organizationIds
	 * @param organizationIds organizationIds
	 * @return 当前对象
	*/
	public AssessmentTask setOrganizationIds(List<String> organizationIds) {
		this.organizationIds=organizationIds;
		return this;
	}
	
	/**
	 * 添加 organizationIds
	 * @param organizationId organizationIds
	 * @return 当前对象
	*/
	public AssessmentTask addOrganizationId(String... organizationId) {
		if(this.organizationIds==null) organizationIds=new ArrayList<>();
		this.organizationIds.addAll(Arrays.asList(organizationId));
		return this;
	}
	
	/**
	 * 获得 personList<br>
	 * personList
	 * @return personList
	*/
	public List<Person> getPersonList() {
		return personList;
	}
	
	/**
	 * 设置 personList
	 * @param personList personList
	 * @return 当前对象
	*/
	public AssessmentTask setPersonList(List<Person> personList) {
		this.personList=personList;
		return this;
	}
	
	/**
	 * 添加 personList
	 * @param person personList
	 * @return 当前对象
	*/
	public AssessmentTask addPerson(Person... person) {
		if(this.personList==null) personList=new ArrayList<>();
		this.personList.addAll(Arrays.asList(person));
		return this;
	}
	
	/**
	 * 获得 personIds<br>
	 * personIds
	 * @return personIds
	*/
	public List<String> getPersonIds() {
		return personIds;
	}
	
	/**
	 * 设置 personIds
	 * @param personIds personIds
	 * @return 当前对象
	*/
	public AssessmentTask setPersonIds(List<String> personIds) {
		this.personIds=personIds;
		return this;
	}
	
	/**
	 * 添加 personIds
	 * @param personId personIds
	 * @return 当前对象
	*/
	public AssessmentTask addPersonId(String... personId) {
		if(this.personIds==null) personIds=new ArrayList<>();
		this.personIds.addAll(Arrays.asList(personId));
		return this;
	}
	
	/**
	 * 获得 excludePersonList<br>
	 * excludePersonList
	 * @return excludePersonList
	*/
	public List<Person> getExcludePersonList() {
		return excludePersonList;
	}
	
	/**
	 * 设置 excludePersonList
	 * @param excludePersonList excludePersonList
	 * @return 当前对象
	*/
	public AssessmentTask setExcludePersonList(List<Person> excludePersonList) {
		this.excludePersonList=excludePersonList;
		return this;
	}
	
	/**
	 * 添加 excludePersonList
	 * @param excludePerson excludePersonList
	 * @return 当前对象
	*/
	public AssessmentTask addExcludePerson(Person... excludePerson) {
		if(this.excludePersonList==null) excludePersonList=new ArrayList<>();
		this.excludePersonList.addAll(Arrays.asList(excludePerson));
		return this;
	}
	
	/**
	 * 获得 excludePersonIds<br>
	 * excludePersonIds
	 * @return excludePersonIds
	*/
	public List<String> getExcludePersonIds() {
		return excludePersonIds;
	}
	
	/**
	 * 设置 excludePersonIds
	 * @param excludePersonIds excludePersonIds
	 * @return 当前对象
	*/
	public AssessmentTask setExcludePersonIds(List<String> excludePersonIds) {
		this.excludePersonIds=excludePersonIds;
		return this;
	}
	
	/**
	 * 添加 excludePersonIds
	 * @param excludePersonId excludePersonIds
	 * @return 当前对象
	*/
	public AssessmentTask addExcludePersonId(String... excludePersonId) {
		if(this.excludePersonIds==null) excludePersonIds=new ArrayList<>();
		this.excludePersonIds.addAll(Arrays.asList(excludePersonId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentTask , 转换好的 AssessmentTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentTask , 转换好的 PoJo 对象
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
	public AssessmentTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentTask duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentTaskMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setSource(this.getSource());
		inst.setCycle(this.getCycle());
		inst.setSameLevelUserId(this.getSameLevelUserId());
		inst.setHasSelfAssessment(this.getHasSelfAssessment());
		inst.setPosId(this.getPosId());
		inst.setHasLeaderAssessment(this.getHasLeaderAssessment());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setIsAllPerson(this.getIsAllPerson());
		inst.setOwner(this.getOwner());
		inst.setHasHrConfirm(this.getHasHrConfirm());
		inst.setHasSecondLeaderAssessment(this.getHasSecondLeaderAssessment());
		inst.setHasSameAssessment(this.getHasSameAssessment());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setAssessmenMethod(this.getAssessmenMethod());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTotalWeight(this.getTotalWeight());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPersonList(this.getPersonList());
			inst.setOrganizationIds(this.getOrganizationIds());
			inst.setExcludePersonIds(this.getExcludePersonIds());
			inst.setOrganizationList(this.getOrganizationList());
			inst.setPersonIds(this.getPersonIds());
			inst.setAssessmentTpl(this.getAssessmentTpl());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setAssessmentIndicator(this.getAssessmentIndicator());
			inst.setExcludePersonList(this.getExcludePersonList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentTask clone(boolean deep) {
		return EntityContext.clone(AssessmentTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentTask
	 * @param assessmentTaskMap 包含实体信息的 Map 对象
	 * @return AssessmentTask , 转换好的的 AssessmentTask 对象
	*/
	@Transient
	public static AssessmentTask createFrom(Map<String,Object> assessmentTaskMap) {
		if(assessmentTaskMap==null) return null;
		AssessmentTask po = create();
		EntityContext.copyProperties(po,assessmentTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentTask , 转换好的的 AssessmentTask 对象
	*/
	@Transient
	public static AssessmentTask createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentTask，等同于 new
	 * @return AssessmentTask 对象
	*/
	@Transient
	public static AssessmentTask create() {
		return new com.dt.platform.domain.hr.meta.AssessmentTaskMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssessmentTaskMeta.NOTES)));
			this.setSource(DataParser.parse(String.class, map.get(AssessmentTaskMeta.SOURCE)));
			this.setCycle(DataParser.parse(String.class, map.get(AssessmentTaskMeta.CYCLE)));
			this.setSameLevelUserId(DataParser.parse(String.class, map.get(AssessmentTaskMeta.SAME_LEVEL_USER_ID)));
			this.setHasSelfAssessment(DataParser.parse(String.class, map.get(AssessmentTaskMeta.HAS_SELF_ASSESSMENT)));
			this.setPosId(DataParser.parse(String.class, map.get(AssessmentTaskMeta.POS_ID)));
			this.setHasLeaderAssessment(DataParser.parse(String.class, map.get(AssessmentTaskMeta.HAS_LEADER_ASSESSMENT)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentTaskMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentTaskMeta.ID)));
			this.setIsAllPerson(DataParser.parse(String.class, map.get(AssessmentTaskMeta.IS_ALL_PERSON)));
			this.setOwner(DataParser.parse(String.class, map.get(AssessmentTaskMeta.OWNER)));
			this.setHasHrConfirm(DataParser.parse(String.class, map.get(AssessmentTaskMeta.HAS_HR_CONFIRM)));
			this.setHasSecondLeaderAssessment(DataParser.parse(String.class, map.get(AssessmentTaskMeta.HAS_SECOND_LEADER_ASSESSMENT)));
			this.setHasSameAssessment(DataParser.parse(String.class, map.get(AssessmentTaskMeta.HAS_SAME_ASSESSMENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentTaskMeta.VERSION)));
			this.setAssessmenMethod(DataParser.parse(String.class, map.get(AssessmentTaskMeta.ASSESSMEN_METHOD)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentTaskMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentTaskMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentTaskMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentTaskMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentTaskMeta.DELETE_BY)));
			this.setTplId(DataParser.parse(String.class, map.get(AssessmentTaskMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentTaskMeta.STATUS)));
			// others
			this.setAssessmentTpl(DataParser.parse(AssessmentTpl.class, map.get(AssessmentTaskMeta.ASSESSMENT_TPL)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssessmentTaskMeta.SELECTED_CODE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssessmentTaskMeta.NOTES));
				this.setSource( (String)map.get(AssessmentTaskMeta.SOURCE));
				this.setCycle( (String)map.get(AssessmentTaskMeta.CYCLE));
				this.setSameLevelUserId( (String)map.get(AssessmentTaskMeta.SAME_LEVEL_USER_ID));
				this.setHasSelfAssessment( (String)map.get(AssessmentTaskMeta.HAS_SELF_ASSESSMENT));
				this.setPosId( (String)map.get(AssessmentTaskMeta.POS_ID));
				this.setHasLeaderAssessment( (String)map.get(AssessmentTaskMeta.HAS_LEADER_ASSESSMENT));
				this.setUpdateBy( (String)map.get(AssessmentTaskMeta.UPDATE_BY));
				this.setId( (String)map.get(AssessmentTaskMeta.ID));
				this.setIsAllPerson( (String)map.get(AssessmentTaskMeta.IS_ALL_PERSON));
				this.setOwner( (String)map.get(AssessmentTaskMeta.OWNER));
				this.setHasHrConfirm( (String)map.get(AssessmentTaskMeta.HAS_HR_CONFIRM));
				this.setHasSecondLeaderAssessment( (String)map.get(AssessmentTaskMeta.HAS_SECOND_LEADER_ASSESSMENT));
				this.setHasSameAssessment( (String)map.get(AssessmentTaskMeta.HAS_SAME_ASSESSMENT));
				this.setUpdateTime( (Date)map.get(AssessmentTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentTaskMeta.VERSION));
				this.setAssessmenMethod( (String)map.get(AssessmentTaskMeta.ASSESSMEN_METHOD));
				this.setCreateBy( (String)map.get(AssessmentTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentTaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentTaskMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssessmentTaskMeta.DELETE_TIME));
				this.setName( (String)map.get(AssessmentTaskMeta.NAME));
				this.setTotalWeight( (BigDecimal)map.get(AssessmentTaskMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)map.get(AssessmentTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentTaskMeta.DELETE_BY));
				this.setTplId( (String)map.get(AssessmentTaskMeta.TPL_ID));
				this.setStatus( (String)map.get(AssessmentTaskMeta.STATUS));
				// others
				this.setAssessmentTpl( (AssessmentTpl)map.get(AssessmentTaskMeta.ASSESSMENT_TPL));
				this.setSelectedCode( (String)map.get(AssessmentTaskMeta.SELECTED_CODE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.NOTES)));
			this.setSource(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.SOURCE)));
			this.setCycle(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.CYCLE)));
			this.setSameLevelUserId(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.SAME_LEVEL_USER_ID)));
			this.setHasSelfAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.HAS_SELF_ASSESSMENT)));
			this.setPosId(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.POS_ID)));
			this.setHasLeaderAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.HAS_LEADER_ASSESSMENT)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.ID)));
			this.setIsAllPerson(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.IS_ALL_PERSON)));
			this.setOwner(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.OWNER)));
			this.setHasHrConfirm(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.HAS_HR_CONFIRM)));
			this.setHasSecondLeaderAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.HAS_SECOND_LEADER_ASSESSMENT)));
			this.setHasSameAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.HAS_SAME_ASSESSMENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentTaskMeta.VERSION)));
			this.setAssessmenMethod(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.ASSESSMEN_METHOD)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentTaskMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.DELETE_BY)));
			this.setTplId(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentTaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssessmentTaskMeta.NOTES));
				this.setSource( (String)r.getValue(AssessmentTaskMeta.SOURCE));
				this.setCycle( (String)r.getValue(AssessmentTaskMeta.CYCLE));
				this.setSameLevelUserId( (String)r.getValue(AssessmentTaskMeta.SAME_LEVEL_USER_ID));
				this.setHasSelfAssessment( (String)r.getValue(AssessmentTaskMeta.HAS_SELF_ASSESSMENT));
				this.setPosId( (String)r.getValue(AssessmentTaskMeta.POS_ID));
				this.setHasLeaderAssessment( (String)r.getValue(AssessmentTaskMeta.HAS_LEADER_ASSESSMENT));
				this.setUpdateBy( (String)r.getValue(AssessmentTaskMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssessmentTaskMeta.ID));
				this.setIsAllPerson( (String)r.getValue(AssessmentTaskMeta.IS_ALL_PERSON));
				this.setOwner( (String)r.getValue(AssessmentTaskMeta.OWNER));
				this.setHasHrConfirm( (String)r.getValue(AssessmentTaskMeta.HAS_HR_CONFIRM));
				this.setHasSecondLeaderAssessment( (String)r.getValue(AssessmentTaskMeta.HAS_SECOND_LEADER_ASSESSMENT));
				this.setHasSameAssessment( (String)r.getValue(AssessmentTaskMeta.HAS_SAME_ASSESSMENT));
				this.setUpdateTime( (Date)r.getValue(AssessmentTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentTaskMeta.VERSION));
				this.setAssessmenMethod( (String)r.getValue(AssessmentTaskMeta.ASSESSMEN_METHOD));
				this.setCreateBy( (String)r.getValue(AssessmentTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentTaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentTaskMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssessmentTaskMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssessmentTaskMeta.NAME));
				this.setTotalWeight( (BigDecimal)r.getValue(AssessmentTaskMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)r.getValue(AssessmentTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentTaskMeta.DELETE_BY));
				this.setTplId( (String)r.getValue(AssessmentTaskMeta.TPL_ID));
				this.setStatus( (String)r.getValue(AssessmentTaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}