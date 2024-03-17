package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_BILL_TASK_PAPER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核试卷
 * <p>考核试卷 , 数据表 hr_assessment_bill_task_paper 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-16 17:56:37
 * @sign F2D852A149AF59BA9667C0F9583ABA75
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_bill_task_paper")
@ApiModel(description = "考核试卷 ; 考核试卷 , 数据表 hr_assessment_bill_task_paper 的PO类型")
public class AssessmentBillTaskPaper extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_BILL_TASK_PAPER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "821414764633653248")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务" , example = "821414684258205696")
	private String billTaskDtlId;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务" , example = "820394780939780096")
	private String billId;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务" , example = "821414679543808000")
	private String billTaskId;
	
	/**
	 * 关系：关系
	*/
	@ApiModelProperty(required = false,value="关系" , notes = "关系" , example = "self")
	private String relationship;
	
	/**
	 * 考核人：考核人
	*/
	@ApiModelProperty(required = false,value="考核人" , notes = "考核人" , example = "590511680593592320")
	private String assessorId;
	
	/**
	 * 被考核人：被考核人
	*/
	@ApiModelProperty(required = false,value="被考核人" , notes = "被考核人" , example = "590511680593592320")
	private String assesseeId;
	
	/**
	 * 综合得分：综合得分
	*/
	@ApiModelProperty(required = false,value="综合得分" , notes = "综合得分" , example = "0.00")
	private BigDecimal scoreValue;
	
	/**
	 * 综合评价：综合评价
	*/
	@ApiModelProperty(required = false,value="综合评价" , notes = "综合评价")
	private String evaluateContent;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "821414484445757440")
	private String userMapId;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String content;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-16 04:09:01")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
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
	 * assessmentIndicatorValueList：assessmentIndicatorValueList
	*/
	@ApiModelProperty(required = false,value="assessmentIndicatorValueList" , notes = "assessmentIndicatorValueList")
	private List<AssessmentIndicatorValue> assessmentIndicatorValueList;
	
	/**
	 * assessmentBillTaskDtl：assessmentBillTaskDtl
	*/
	@ApiModelProperty(required = false,value="assessmentBillTaskDtl" , notes = "assessmentBillTaskDtl")
	private AssessmentBillTaskDtl assessmentBillTaskDtl;
	
	/**
	 * assessee：assessee
	*/
	@ApiModelProperty(required = false,value="assessee" , notes = "assessee")
	private Employee assessee;
	
	/**
	 * assessor：assessor
	*/
	@ApiModelProperty(required = false,value="assessor" , notes = "assessor")
	private Employee assessor;
	
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
	public AssessmentBillTaskPaper setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getBillTaskDtlId() {
		return billTaskDtlId;
	}
	
	/**
	 * 设置 任务
	 * @param billTaskDtlId 任务
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setBillTaskDtlId(String billTaskDtlId) {
		this.billTaskDtlId=billTaskDtlId;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getBillId() {
		return billId;
	}
	
	/**
	 * 设置 任务
	 * @param billId 任务
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setBillId(String billId) {
		this.billId=billId;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getBillTaskId() {
		return billTaskId;
	}
	
	/**
	 * 设置 任务
	 * @param billTaskId 任务
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setBillTaskId(String billTaskId) {
		this.billTaskId=billTaskId;
		return this;
	}
	
	/**
	 * 获得 关系<br>
	 * 关系
	 * @return 关系
	*/
	public String getRelationship() {
		return relationship;
	}
	
	/**
	 * 设置 关系
	 * @param relationship 关系
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setRelationship(String relationship) {
		this.relationship=relationship;
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
	public AssessmentBillTaskPaper setAssessorId(String assessorId) {
		this.assessorId=assessorId;
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
	public AssessmentBillTaskPaper setAssesseeId(String assesseeId) {
		this.assesseeId=assesseeId;
		return this;
	}
	
	/**
	 * 获得 综合得分<br>
	 * 综合得分
	 * @return 综合得分
	*/
	public BigDecimal getScoreValue() {
		return scoreValue;
	}
	
	/**
	 * 设置 综合得分
	 * @param scoreValue 综合得分
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setScoreValue(BigDecimal scoreValue) {
		this.scoreValue=scoreValue;
		return this;
	}
	
	/**
	 * 获得 综合评价<br>
	 * 综合评价
	 * @return 综合评价
	*/
	public String getEvaluateContent() {
		return evaluateContent;
	}
	
	/**
	 * 设置 综合评价
	 * @param evaluateContent 综合评价
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setEvaluateContent(String evaluateContent) {
		this.evaluateContent=evaluateContent;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserMapId() {
		return userMapId;
	}
	
	/**
	 * 设置 用户
	 * @param userMapId 用户
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setUserMapId(String userMapId) {
		this.userMapId=userMapId;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 说明
	 * @param content 说明
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setContent(String content) {
		this.content=content;
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
	public AssessmentBillTaskPaper setCreateBy(String createBy) {
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
	public AssessmentBillTaskPaper setCreateTime(Date createTime) {
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
	public AssessmentBillTaskPaper setUpdateBy(String updateBy) {
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
	public AssessmentBillTaskPaper setUpdateTime(Date updateTime) {
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
	public AssessmentBillTaskPaper setDeleted(Integer deleted) {
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
	public AssessmentBillTaskPaper setDeleted(Boolean deletedBool) {
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
	public AssessmentBillTaskPaper setDeleteBy(String deleteBy) {
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
	public AssessmentBillTaskPaper setDeleteTime(Date deleteTime) {
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
	public AssessmentBillTaskPaper setVersion(Integer version) {
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
	public AssessmentBillTaskPaper setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 assessmentIndicatorValueList<br>
	 * assessmentIndicatorValueList
	 * @return assessmentIndicatorValueList
	*/
	public List<AssessmentIndicatorValue> getAssessmentIndicatorValueList() {
		return assessmentIndicatorValueList;
	}
	
	/**
	 * 设置 assessmentIndicatorValueList
	 * @param assessmentIndicatorValueList assessmentIndicatorValueList
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setAssessmentIndicatorValueList(List<AssessmentIndicatorValue> assessmentIndicatorValueList) {
		this.assessmentIndicatorValueList=assessmentIndicatorValueList;
		return this;
	}
	
	/**
	 * 添加 assessmentIndicatorValueList
	 * @param assessmentIndicatorValue assessmentIndicatorValueList
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper addAssessmentIndicatorValue(AssessmentIndicatorValue... assessmentIndicatorValue) {
		if(this.assessmentIndicatorValueList==null) assessmentIndicatorValueList=new ArrayList<>();
		this.assessmentIndicatorValueList.addAll(Arrays.asList(assessmentIndicatorValue));
		return this;
	}
	
	/**
	 * 获得 assessmentBillTaskDtl<br>
	 * assessmentBillTaskDtl
	 * @return assessmentBillTaskDtl
	*/
	public AssessmentBillTaskDtl getAssessmentBillTaskDtl() {
		return assessmentBillTaskDtl;
	}
	
	/**
	 * 设置 assessmentBillTaskDtl
	 * @param assessmentBillTaskDtl assessmentBillTaskDtl
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setAssessmentBillTaskDtl(AssessmentBillTaskDtl assessmentBillTaskDtl) {
		this.assessmentBillTaskDtl=assessmentBillTaskDtl;
		return this;
	}
	
	/**
	 * 获得 assessee<br>
	 * assessee
	 * @return assessee
	*/
	public Employee getAssessee() {
		return assessee;
	}
	
	/**
	 * 设置 assessee
	 * @param assessee assessee
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setAssessee(Employee assessee) {
		this.assessee=assessee;
		return this;
	}
	
	/**
	 * 获得 assessor<br>
	 * assessor
	 * @return assessor
	*/
	public Employee getAssessor() {
		return assessor;
	}
	
	/**
	 * 设置 assessor
	 * @param assessor assessor
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaper setAssessor(Employee assessor) {
		this.assessor=assessor;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentBillTaskPaper , 转换好的 AssessmentBillTaskPaper 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillTaskPaper , 转换好的 PoJo 对象
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
	public AssessmentBillTaskPaper clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillTaskPaper duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperMeta.$$proxy$$();
		inst.setEvaluateContent(this.getEvaluateContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setBillTaskDtlId(this.getBillTaskDtlId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBillTaskId(this.getBillTaskId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setBillId(this.getBillId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUserMapId(this.getUserMapId());
		inst.setId(this.getId());
		inst.setRelationship(this.getRelationship());
		inst.setScoreValue(this.getScoreValue());
		if(all) {
			inst.setAssessmentIndicatorValueList(this.getAssessmentIndicatorValueList());
			inst.setAssessee(this.getAssessee());
			inst.setAssessor(this.getAssessor());
			inst.setAssessmentBillTaskDtl(this.getAssessmentBillTaskDtl());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillTaskPaper clone(boolean deep) {
		return EntityContext.clone(AssessmentBillTaskPaper.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillTaskPaper
	 * @param assessmentBillTaskPaperMap 包含实体信息的 Map 对象
	 * @return AssessmentBillTaskPaper , 转换好的的 AssessmentBillTaskPaper 对象
	*/
	@Transient
	public static AssessmentBillTaskPaper createFrom(Map<String,Object> assessmentBillTaskPaperMap) {
		if(assessmentBillTaskPaperMap==null) return null;
		AssessmentBillTaskPaper po = create();
		EntityContext.copyProperties(po,assessmentBillTaskPaperMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillTaskPaper
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillTaskPaper , 转换好的的 AssessmentBillTaskPaper 对象
	*/
	@Transient
	public static AssessmentBillTaskPaper createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillTaskPaper po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentBillTaskPaper，等同于 new
	 * @return AssessmentBillTaskPaper 对象
	*/
	@Transient
	public static AssessmentBillTaskPaper create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperMeta.$$proxy$$();
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
			this.setEvaluateContent(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.EVALUATE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskPaperMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillTaskPaperMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.CONTENT)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.ASSESSEE_ID)));
			this.setBillTaskDtlId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.BILL_TASK_DTL_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillTaskPaperMeta.DELETED)));
			this.setBillTaskId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.BILL_TASK_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskPaperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskPaperMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.BILL_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.DELETE_BY)));
			this.setUserMapId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.USER_MAP_ID)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperMeta.RELATIONSHIP)));
			this.setScoreValue(DataParser.parse(BigDecimal.class, map.get(AssessmentBillTaskPaperMeta.SCORE_VALUE)));
			// others
			this.setAssessee(DataParser.parse(Employee.class, map.get(AssessmentBillTaskPaperMeta.ASSESSEE)));
			this.setAssessor(DataParser.parse(Employee.class, map.get(AssessmentBillTaskPaperMeta.ASSESSOR)));
			this.setAssessmentBillTaskDtl(DataParser.parse(AssessmentBillTaskDtl.class, map.get(AssessmentBillTaskPaperMeta.ASSESSMENT_BILL_TASK_DTL)));
			return true;
		} else {
			try {
				this.setEvaluateContent( (String)map.get(AssessmentBillTaskPaperMeta.EVALUATE_CONTENT));
				this.setUpdateTime( (Date)map.get(AssessmentBillTaskPaperMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentBillTaskPaperMeta.VERSION));
				this.setContent( (String)map.get(AssessmentBillTaskPaperMeta.CONTENT));
				this.setAssesseeId( (String)map.get(AssessmentBillTaskPaperMeta.ASSESSEE_ID));
				this.setBillTaskDtlId( (String)map.get(AssessmentBillTaskPaperMeta.BILL_TASK_DTL_ID));
				this.setCreateBy( (String)map.get(AssessmentBillTaskPaperMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillTaskPaperMeta.DELETED));
				this.setBillTaskId( (String)map.get(AssessmentBillTaskPaperMeta.BILL_TASK_ID));
				this.setCreateTime( (Date)map.get(AssessmentBillTaskPaperMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillTaskPaperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillTaskPaperMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentBillTaskPaperMeta.ASSESSOR_ID));
				this.setBillId( (String)map.get(AssessmentBillTaskPaperMeta.BILL_ID));
				this.setTenantId( (String)map.get(AssessmentBillTaskPaperMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillTaskPaperMeta.DELETE_BY));
				this.setUserMapId( (String)map.get(AssessmentBillTaskPaperMeta.USER_MAP_ID));
				this.setId( (String)map.get(AssessmentBillTaskPaperMeta.ID));
				this.setRelationship( (String)map.get(AssessmentBillTaskPaperMeta.RELATIONSHIP));
				this.setScoreValue( (BigDecimal)map.get(AssessmentBillTaskPaperMeta.SCORE_VALUE));
				// others
				this.setAssessee( (Employee)map.get(AssessmentBillTaskPaperMeta.ASSESSEE));
				this.setAssessor( (Employee)map.get(AssessmentBillTaskPaperMeta.ASSESSOR));
				this.setAssessmentBillTaskDtl( (AssessmentBillTaskDtl)map.get(AssessmentBillTaskPaperMeta.ASSESSMENT_BILL_TASK_DTL));
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
			this.setEvaluateContent(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.EVALUATE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskPaperMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskPaperMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.CONTENT)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.ASSESSEE_ID)));
			this.setBillTaskDtlId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.BILL_TASK_DTL_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskPaperMeta.DELETED)));
			this.setBillTaskId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.BILL_TASK_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskPaperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskPaperMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.BILL_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.DELETE_BY)));
			this.setUserMapId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.USER_MAP_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperMeta.RELATIONSHIP)));
			this.setScoreValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentBillTaskPaperMeta.SCORE_VALUE)));
			return true;
		} else {
			try {
				this.setEvaluateContent( (String)r.getValue(AssessmentBillTaskPaperMeta.EVALUATE_CONTENT));
				this.setUpdateTime( (Date)r.getValue(AssessmentBillTaskPaperMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentBillTaskPaperMeta.VERSION));
				this.setContent( (String)r.getValue(AssessmentBillTaskPaperMeta.CONTENT));
				this.setAssesseeId( (String)r.getValue(AssessmentBillTaskPaperMeta.ASSESSEE_ID));
				this.setBillTaskDtlId( (String)r.getValue(AssessmentBillTaskPaperMeta.BILL_TASK_DTL_ID));
				this.setCreateBy( (String)r.getValue(AssessmentBillTaskPaperMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillTaskPaperMeta.DELETED));
				this.setBillTaskId( (String)r.getValue(AssessmentBillTaskPaperMeta.BILL_TASK_ID));
				this.setCreateTime( (Date)r.getValue(AssessmentBillTaskPaperMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillTaskPaperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillTaskPaperMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentBillTaskPaperMeta.ASSESSOR_ID));
				this.setBillId( (String)r.getValue(AssessmentBillTaskPaperMeta.BILL_ID));
				this.setTenantId( (String)r.getValue(AssessmentBillTaskPaperMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillTaskPaperMeta.DELETE_BY));
				this.setUserMapId( (String)r.getValue(AssessmentBillTaskPaperMeta.USER_MAP_ID));
				this.setId( (String)r.getValue(AssessmentBillTaskPaperMeta.ID));
				this.setRelationship( (String)r.getValue(AssessmentBillTaskPaperMeta.RELATIONSHIP));
				this.setScoreValue( (BigDecimal)r.getValue(AssessmentBillTaskPaperMeta.SCORE_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}