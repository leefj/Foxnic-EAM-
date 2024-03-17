package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_INDICATOR_VALUE;
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
import com.dt.platform.domain.hr.meta.AssessmentIndicatorValueMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核结果
 * <p>考核结果 , 数据表 hr_assessment_indicator_value 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-15 18:11:48
 * @sign 4D73E285831145B4E430AA30FAF126A1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_indicator_value")
@ApiModel(description = "考核结果 ; 考核结果 , 数据表 hr_assessment_indicator_value 的PO类型")
public class AssessmentIndicatorValue extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_INDICATOR_VALUE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "820258554597343233")
	private String id;
	
	/**
	 * 评分表：评分表
	*/
	@ApiModelProperty(required = false,value="评分表" , notes = "评分表" , example = "820258554597343232")
	private String taskPaperId;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标" , example = "818930287911108608")
	private String indicatorId;
	
	/**
	 * 得分：得分
	*/
	@ApiModelProperty(required = false,value="得分" , notes = "得分")
	private BigDecimal value;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 顺序：顺序
	*/
	@ApiModelProperty(required = false,value="顺序" , notes = "顺序" , example = "1")
	private Integer sn;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-13 11:34:39")
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
	 * assessmentIndicator：assessmentIndicator
	*/
	@ApiModelProperty(required = false,value="assessmentIndicator" , notes = "assessmentIndicator")
	private AssessmentIndicator assessmentIndicator;
	
	/**
	 * IndicatorGroupName：IndicatorGroupName
	*/
	@ApiModelProperty(required = false,value="IndicatorGroupName" , notes = "IndicatorGroupName")
	private String IndicatorGroupName;
	
	/**
	 * IndicatorName：IndicatorName
	*/
	@ApiModelProperty(required = false,value="IndicatorName" , notes = "IndicatorName")
	private String IndicatorName;
	
	/**
	 * IndicatorScoringBase：IndicatorScoringBase
	*/
	@ApiModelProperty(required = false,value="IndicatorScoringBase" , notes = "IndicatorScoringBase")
	private String IndicatorScoringBase;
	
	/**
	 * IndicatorDef：IndicatorDef
	*/
	@ApiModelProperty(required = false,value="IndicatorDef" , notes = "IndicatorDef")
	private String IndicatorDef;
	
	/**
	 * IndicatorMinValue：IndicatorMinValue
	*/
	@ApiModelProperty(required = false,value="IndicatorMinValue" , notes = "IndicatorMinValue")
	private String IndicatorMinValue;
	
	/**
	 * IndicatorMaxValue：IndicatorMaxValue
	*/
	@ApiModelProperty(required = false,value="IndicatorMaxValue" , notes = "IndicatorMaxValue")
	private String IndicatorMaxValue;
	
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
	public AssessmentIndicatorValue setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 评分表<br>
	 * 评分表
	 * @return 评分表
	*/
	public String getTaskPaperId() {
		return taskPaperId;
	}
	
	/**
	 * 设置 评分表
	 * @param taskPaperId 评分表
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setTaskPaperId(String taskPaperId) {
		this.taskPaperId=taskPaperId;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public String getIndicatorId() {
		return indicatorId;
	}
	
	/**
	 * 设置 指标
	 * @param indicatorId 指标
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorId(String indicatorId) {
		this.indicatorId=indicatorId;
		return this;
	}
	
	/**
	 * 获得 得分<br>
	 * 得分
	 * @return 得分
	*/
	public BigDecimal getValue() {
		return value;
	}
	
	/**
	 * 设置 得分
	 * @param value 得分
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setValue(BigDecimal value) {
		this.value=value;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 顺序<br>
	 * 顺序
	 * @return 顺序
	*/
	public Integer getSn() {
		return sn;
	}
	
	/**
	 * 设置 顺序
	 * @param sn 顺序
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setSn(Integer sn) {
		this.sn=sn;
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
	public AssessmentIndicatorValue setCreateBy(String createBy) {
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
	public AssessmentIndicatorValue setCreateTime(Date createTime) {
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
	public AssessmentIndicatorValue setUpdateBy(String updateBy) {
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
	public AssessmentIndicatorValue setUpdateTime(Date updateTime) {
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
	public AssessmentIndicatorValue setDeleted(Integer deleted) {
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
	public AssessmentIndicatorValue setDeleted(Boolean deletedBool) {
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
	public AssessmentIndicatorValue setDeleteBy(String deleteBy) {
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
	public AssessmentIndicatorValue setDeleteTime(Date deleteTime) {
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
	public AssessmentIndicatorValue setVersion(Integer version) {
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
	public AssessmentIndicatorValue setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 assessmentIndicator<br>
	 * assessmentIndicator
	 * @return assessmentIndicator
	*/
	public AssessmentIndicator getAssessmentIndicator() {
		return assessmentIndicator;
	}
	
	/**
	 * 设置 assessmentIndicator
	 * @param assessmentIndicator assessmentIndicator
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setAssessmentIndicator(AssessmentIndicator assessmentIndicator) {
		this.assessmentIndicator=assessmentIndicator;
		return this;
	}
	
	/**
	 * 获得 IndicatorGroupName<br>
	 * IndicatorGroupName
	 * @return IndicatorGroupName
	*/
	public String getIndicatorGroupName() {
		return IndicatorGroupName;
	}
	
	/**
	 * 设置 IndicatorGroupName
	 * @param IndicatorGroupName IndicatorGroupName
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorGroupName(String IndicatorGroupName) {
		this.IndicatorGroupName=IndicatorGroupName;
		return this;
	}
	
	/**
	 * 获得 IndicatorName<br>
	 * IndicatorName
	 * @return IndicatorName
	*/
	public String getIndicatorName() {
		return IndicatorName;
	}
	
	/**
	 * 设置 IndicatorName
	 * @param IndicatorName IndicatorName
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorName(String IndicatorName) {
		this.IndicatorName=IndicatorName;
		return this;
	}
	
	/**
	 * 获得 IndicatorScoringBase<br>
	 * IndicatorScoringBase
	 * @return IndicatorScoringBase
	*/
	public String getIndicatorScoringBase() {
		return IndicatorScoringBase;
	}
	
	/**
	 * 设置 IndicatorScoringBase
	 * @param IndicatorScoringBase IndicatorScoringBase
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorScoringBase(String IndicatorScoringBase) {
		this.IndicatorScoringBase=IndicatorScoringBase;
		return this;
	}
	
	/**
	 * 获得 IndicatorDef<br>
	 * IndicatorDef
	 * @return IndicatorDef
	*/
	public String getIndicatorDef() {
		return IndicatorDef;
	}
	
	/**
	 * 设置 IndicatorDef
	 * @param IndicatorDef IndicatorDef
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorDef(String IndicatorDef) {
		this.IndicatorDef=IndicatorDef;
		return this;
	}
	
	/**
	 * 获得 IndicatorMinValue<br>
	 * IndicatorMinValue
	 * @return IndicatorMinValue
	*/
	public String getIndicatorMinValue() {
		return IndicatorMinValue;
	}
	
	/**
	 * 设置 IndicatorMinValue
	 * @param IndicatorMinValue IndicatorMinValue
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorMinValue(String IndicatorMinValue) {
		this.IndicatorMinValue=IndicatorMinValue;
		return this;
	}
	
	/**
	 * 获得 IndicatorMaxValue<br>
	 * IndicatorMaxValue
	 * @return IndicatorMaxValue
	*/
	public String getIndicatorMaxValue() {
		return IndicatorMaxValue;
	}
	
	/**
	 * 设置 IndicatorMaxValue
	 * @param IndicatorMaxValue IndicatorMaxValue
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setIndicatorMaxValue(String IndicatorMaxValue) {
		this.IndicatorMaxValue=IndicatorMaxValue;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentIndicatorValue , 转换好的 AssessmentIndicatorValue 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentIndicatorValue , 转换好的 PoJo 对象
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
	public AssessmentIndicatorValue clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentIndicatorValue duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentIndicatorValueMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentIndicatorValueMeta.$$proxy$$();
		inst.setTaskPaperId(this.getTaskPaperId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setIndicatorId(this.getIndicatorId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setValue(this.getValue());
		if(all) {
			inst.setIndicatorName(this.getIndicatorName());
			inst.setIndicatorMaxValue(this.getIndicatorMaxValue());
			inst.setIndicatorDef(this.getIndicatorDef());
			inst.setIndicatorGroupName(this.getIndicatorGroupName());
			inst.setIndicatorScoringBase(this.getIndicatorScoringBase());
			inst.setAssessmentIndicator(this.getAssessmentIndicator());
			inst.setIndicatorMinValue(this.getIndicatorMinValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentIndicatorValue clone(boolean deep) {
		return EntityContext.clone(AssessmentIndicatorValue.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentIndicatorValue
	 * @param assessmentIndicatorValueMap 包含实体信息的 Map 对象
	 * @return AssessmentIndicatorValue , 转换好的的 AssessmentIndicatorValue 对象
	*/
	@Transient
	public static AssessmentIndicatorValue createFrom(Map<String,Object> assessmentIndicatorValueMap) {
		if(assessmentIndicatorValueMap==null) return null;
		AssessmentIndicatorValue po = create();
		EntityContext.copyProperties(po,assessmentIndicatorValueMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentIndicatorValue
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentIndicatorValue , 转换好的的 AssessmentIndicatorValue 对象
	*/
	@Transient
	public static AssessmentIndicatorValue createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentIndicatorValue po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentIndicatorValue，等同于 new
	 * @return AssessmentIndicatorValue 对象
	*/
	@Transient
	public static AssessmentIndicatorValue create() {
		return new com.dt.platform.domain.hr.meta.AssessmentIndicatorValueMeta.$$proxy$$();
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
			this.setTaskPaperId(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.TASK_PAPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorValueMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentIndicatorValueMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.CONTENT)));
			this.setIndicatorId(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentIndicatorValueMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorValueMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorValueMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, map.get(AssessmentIndicatorValueMeta.SN)));
			this.setValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorValueMeta.VALUE)));
			// others
			this.setIndicatorName(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_NAME)));
			this.setIndicatorMaxValue(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_MAX_VALUE)));
			this.setIndicatorDef(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_DEF)));
			this.setIndicatorGroupName(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_GROUP_NAME)));
			this.setIndicatorScoringBase(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_SCORING_BASE)));
			this.setAssessmentIndicator(DataParser.parse(AssessmentIndicator.class, map.get(AssessmentIndicatorValueMeta.ASSESSMENT_INDICATOR)));
			this.setIndicatorMinValue(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.INDICATOR_MIN_VALUE)));
			return true;
		} else {
			try {
				this.setTaskPaperId( (String)map.get(AssessmentIndicatorValueMeta.TASK_PAPER_ID));
				this.setUpdateTime( (Date)map.get(AssessmentIndicatorValueMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentIndicatorValueMeta.VERSION));
				this.setContent( (String)map.get(AssessmentIndicatorValueMeta.CONTENT));
				this.setIndicatorId( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_ID));
				this.setCreateBy( (String)map.get(AssessmentIndicatorValueMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentIndicatorValueMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentIndicatorValueMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentIndicatorValueMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentIndicatorValueMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssessmentIndicatorValueMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentIndicatorValueMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentIndicatorValueMeta.ID));
				this.setSn( (Integer)map.get(AssessmentIndicatorValueMeta.SN));
				this.setValue( (BigDecimal)map.get(AssessmentIndicatorValueMeta.VALUE));
				// others
				this.setIndicatorName( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_NAME));
				this.setIndicatorMaxValue( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_MAX_VALUE));
				this.setIndicatorDef( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_DEF));
				this.setIndicatorGroupName( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_GROUP_NAME));
				this.setIndicatorScoringBase( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_SCORING_BASE));
				this.setAssessmentIndicator( (AssessmentIndicator)map.get(AssessmentIndicatorValueMeta.ASSESSMENT_INDICATOR));
				this.setIndicatorMinValue( (String)map.get(AssessmentIndicatorValueMeta.INDICATOR_MIN_VALUE));
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
			this.setTaskPaperId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.TASK_PAPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorValueMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorValueMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.CONTENT)));
			this.setIndicatorId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.INDICATOR_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorValueMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorValueMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorValueMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorValueMeta.SN)));
			this.setValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorValueMeta.VALUE)));
			return true;
		} else {
			try {
				this.setTaskPaperId( (String)r.getValue(AssessmentIndicatorValueMeta.TASK_PAPER_ID));
				this.setUpdateTime( (Date)r.getValue(AssessmentIndicatorValueMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentIndicatorValueMeta.VERSION));
				this.setContent( (String)r.getValue(AssessmentIndicatorValueMeta.CONTENT));
				this.setIndicatorId( (String)r.getValue(AssessmentIndicatorValueMeta.INDICATOR_ID));
				this.setCreateBy( (String)r.getValue(AssessmentIndicatorValueMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentIndicatorValueMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentIndicatorValueMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentIndicatorValueMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentIndicatorValueMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssessmentIndicatorValueMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentIndicatorValueMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentIndicatorValueMeta.ID));
				this.setSn( (Integer)r.getValue(AssessmentIndicatorValueMeta.SN));
				this.setValue( (BigDecimal)r.getValue(AssessmentIndicatorValueMeta.VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}