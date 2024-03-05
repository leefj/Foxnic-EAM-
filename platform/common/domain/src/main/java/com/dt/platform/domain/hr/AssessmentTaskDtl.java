package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_TASK_DTL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentTaskDtlMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核任务单
 * <p>考核任务单 , 数据表 hr_assessment_task_dtl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-02 16:13:18
 * @sign 062877CB0E2C53AA738542063CFC4257
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_task_dtl")
@ApiModel(description = "考核任务单 ; 考核任务单 , 数据表 hr_assessment_task_dtl 的PO类型")
public class AssessmentTaskDtl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_TASK_DTL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String taskId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
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
	 * 得分：得分
	*/
	@ApiModelProperty(required = false,value="得分" , notes = "得分")
	private BigDecimal scoreValue;
	
	/**
	 * 综合评价：综合评价
	*/
	@ApiModelProperty(required = false,value="综合评价" , notes = "综合评价")
	private String evaluateContent;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date rcdTime;
	
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
	 * positionList：positionList
	*/
	@ApiModelProperty(required = false,value="positionList" , notes = "positionList")
	private List<Position> positionList;
	
	/**
	 * positionIds：positionIds
	*/
	@ApiModelProperty(required = false,value="positionIds" , notes = "positionIds")
	private List<String> positionIds;
	
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
	public AssessmentTaskDtl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public AssessmentTaskDtl setTaskId(String taskId) {
		this.taskId=taskId;
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
	public AssessmentTaskDtl setStatus(String status) {
		this.status=status;
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
	public AssessmentTaskDtl setAssesseeId(String assesseeId) {
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
	public AssessmentTaskDtl setAssessorId(String assessorId) {
		this.assessorId=assessorId;
		return this;
	}
	
	/**
	 * 获得 得分<br>
	 * 得分
	 * @return 得分
	*/
	public BigDecimal getScoreValue() {
		return scoreValue;
	}
	
	/**
	 * 设置 得分
	 * @param scoreValue 得分
	 * @return 当前对象
	*/
	public AssessmentTaskDtl setScoreValue(BigDecimal scoreValue) {
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
	public AssessmentTaskDtl setEvaluateContent(String evaluateContent) {
		this.evaluateContent=evaluateContent;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param rcdTime 操作时间
	 * @return 当前对象
	*/
	public AssessmentTaskDtl setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
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
	public AssessmentTaskDtl setCreateBy(String createBy) {
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
	public AssessmentTaskDtl setCreateTime(Date createTime) {
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
	public AssessmentTaskDtl setUpdateBy(String updateBy) {
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
	public AssessmentTaskDtl setUpdateTime(Date updateTime) {
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
	public AssessmentTaskDtl setDeleted(Integer deleted) {
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
	public AssessmentTaskDtl setDeleted(Boolean deletedBool) {
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
	public AssessmentTaskDtl setDeleteBy(String deleteBy) {
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
	public AssessmentTaskDtl setDeleteTime(Date deleteTime) {
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
	public AssessmentTaskDtl setVersion(Integer version) {
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
	public AssessmentTaskDtl setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssessmentTaskDtl setAssessmentIndicator(List<AssessmentIndicator> assessmentIndicator) {
		this.assessmentIndicator=assessmentIndicator;
		return this;
	}
	
	/**
	 * 添加 assessmentIndicator
	 * @param entity assessmentIndicator
	 * @return 当前对象
	*/
	public AssessmentTaskDtl addAssessmentIndicator(AssessmentIndicator... entity) {
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
	public AssessmentTaskDtl setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 positionList<br>
	 * positionList
	 * @return positionList
	*/
	public List<Position> getPositionList() {
		return positionList;
	}
	
	/**
	 * 设置 positionList
	 * @param positionList positionList
	 * @return 当前对象
	*/
	public AssessmentTaskDtl setPositionList(List<Position> positionList) {
		this.positionList=positionList;
		return this;
	}
	
	/**
	 * 添加 positionList
	 * @param position positionList
	 * @return 当前对象
	*/
	public AssessmentTaskDtl addPosition(Position... position) {
		if(this.positionList==null) positionList=new ArrayList<>();
		this.positionList.addAll(Arrays.asList(position));
		return this;
	}
	
	/**
	 * 获得 positionIds<br>
	 * positionIds
	 * @return positionIds
	*/
	public List<String> getPositionIds() {
		return positionIds;
	}
	
	/**
	 * 设置 positionIds
	 * @param positionIds positionIds
	 * @return 当前对象
	*/
	public AssessmentTaskDtl setPositionIds(List<String> positionIds) {
		this.positionIds=positionIds;
		return this;
	}
	
	/**
	 * 添加 positionIds
	 * @param positionId positionIds
	 * @return 当前对象
	*/
	public AssessmentTaskDtl addPositionId(String... positionId) {
		if(this.positionIds==null) positionIds=new ArrayList<>();
		this.positionIds.addAll(Arrays.asList(positionId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentTaskDtl , 转换好的 AssessmentTaskDtl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentTaskDtl , 转换好的 PoJo 对象
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
	public AssessmentTaskDtl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentTaskDtl duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentTaskDtlMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentTaskDtlMeta.$$proxy$$();
		inst.setEvaluateContent(this.getEvaluateContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		inst.setScoreValue(this.getScoreValue());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setPositionIds(this.getPositionIds());
			inst.setPositionList(this.getPositionList());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setAssessmentIndicator(this.getAssessmentIndicator());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentTaskDtl clone(boolean deep) {
		return EntityContext.clone(AssessmentTaskDtl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentTaskDtl
	 * @param assessmentTaskDtlMap 包含实体信息的 Map 对象
	 * @return AssessmentTaskDtl , 转换好的的 AssessmentTaskDtl 对象
	*/
	@Transient
	public static AssessmentTaskDtl createFrom(Map<String,Object> assessmentTaskDtlMap) {
		if(assessmentTaskDtlMap==null) return null;
		AssessmentTaskDtl po = create();
		EntityContext.copyProperties(po,assessmentTaskDtlMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentTaskDtl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentTaskDtl , 转换好的的 AssessmentTaskDtl 对象
	*/
	@Transient
	public static AssessmentTaskDtl createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentTaskDtl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentTaskDtl，等同于 new
	 * @return AssessmentTaskDtl 对象
	*/
	@Transient
	public static AssessmentTaskDtl create() {
		return new com.dt.platform.domain.hr.meta.AssessmentTaskDtlMeta.$$proxy$$();
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
			this.setEvaluateContent(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.EVALUATE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentTaskDtlMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentTaskDtlMeta.VERSION)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.ASSESSEE_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentTaskDtlMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentTaskDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentTaskDtlMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.ASSESSOR_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.STATUS)));
			this.setScoreValue(DataParser.parse(BigDecimal.class, map.get(AssessmentTaskDtlMeta.SCORE_VALUE)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(AssessmentTaskDtlMeta.RCD_TIME)));
			// others
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssessmentTaskDtlMeta.SELECTED_CODE)));
			return true;
		} else {
			try {
				this.setEvaluateContent( (String)map.get(AssessmentTaskDtlMeta.EVALUATE_CONTENT));
				this.setUpdateTime( (Date)map.get(AssessmentTaskDtlMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentTaskDtlMeta.VERSION));
				this.setAssesseeId( (String)map.get(AssessmentTaskDtlMeta.ASSESSEE_ID));
				this.setCreateBy( (String)map.get(AssessmentTaskDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentTaskDtlMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentTaskDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentTaskDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentTaskDtlMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentTaskDtlMeta.ASSESSOR_ID));
				this.setTenantId( (String)map.get(AssessmentTaskDtlMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentTaskDtlMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentTaskDtlMeta.ID));
				this.setTaskId( (String)map.get(AssessmentTaskDtlMeta.TASK_ID));
				this.setStatus( (String)map.get(AssessmentTaskDtlMeta.STATUS));
				this.setScoreValue( (BigDecimal)map.get(AssessmentTaskDtlMeta.SCORE_VALUE));
				this.setRcdTime( (Date)map.get(AssessmentTaskDtlMeta.RCD_TIME));
				// others
				this.setSelectedCode( (String)map.get(AssessmentTaskDtlMeta.SELECTED_CODE));
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
			this.setEvaluateContent(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.EVALUATE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskDtlMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentTaskDtlMeta.VERSION)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.ASSESSEE_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentTaskDtlMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskDtlMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.ASSESSOR_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentTaskDtlMeta.STATUS)));
			this.setScoreValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentTaskDtlMeta.SCORE_VALUE)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskDtlMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setEvaluateContent( (String)r.getValue(AssessmentTaskDtlMeta.EVALUATE_CONTENT));
				this.setUpdateTime( (Date)r.getValue(AssessmentTaskDtlMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentTaskDtlMeta.VERSION));
				this.setAssesseeId( (String)r.getValue(AssessmentTaskDtlMeta.ASSESSEE_ID));
				this.setCreateBy( (String)r.getValue(AssessmentTaskDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentTaskDtlMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentTaskDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentTaskDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentTaskDtlMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentTaskDtlMeta.ASSESSOR_ID));
				this.setTenantId( (String)r.getValue(AssessmentTaskDtlMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentTaskDtlMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentTaskDtlMeta.ID));
				this.setTaskId( (String)r.getValue(AssessmentTaskDtlMeta.TASK_ID));
				this.setStatus( (String)r.getValue(AssessmentTaskDtlMeta.STATUS));
				this.setScoreValue( (BigDecimal)r.getValue(AssessmentTaskDtlMeta.SCORE_VALUE));
				this.setRcdTime( (Date)r.getValue(AssessmentTaskDtlMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}