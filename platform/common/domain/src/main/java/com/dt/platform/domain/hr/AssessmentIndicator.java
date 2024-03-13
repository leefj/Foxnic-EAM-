package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_INDICATOR;
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
import com.dt.platform.domain.hr.meta.AssessmentIndicatorMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核指标
 * <p>考核指标 , 数据表 hr_assessment_indicator 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 20:35:52
 * @sign 4655835F77559C83E4A00A190DB1A387
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_indicator")
@ApiModel(description = "考核指标 ; 考核指标 , 数据表 hr_assessment_indicator 的PO类型")
public class AssessmentIndicator extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_INDICATOR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "815601864019017728")
	private String id;
	
	/**
	 * 归属：tpl,inst
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "tpl,inst")
	private String owner;
	
	/**
	 * 考核主题：考核主题
	*/
	@ApiModelProperty(required = false,value="考核主题" , notes = "考核主题" , example = "815575524477763584")
	private String assessmentId;
	
	/**
	 * 指标库：指标库
	*/
	@ApiModelProperty(required = false,value="指标库" , notes = "指标库")
	private String tplIndicatorId;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类")
	private String groupname;
	
	/**
	 * 指标名称：指标名称
	*/
	@ApiModelProperty(required = false,value="指标名称" , notes = "指标名称" , example = "项目完成率")
	private String name;
	
	/**
	 * 权重：%)
	*/
	@ApiModelProperty(required = false,value="权重" , notes = "%)" , example = "75.00")
	private BigDecimal weight;
	
	/**
	 * 最小评分值：最小评分值
	*/
	@ApiModelProperty(required = false,value="最小评分值" , notes = "最小评分值" , example = "0.00")
	private BigDecimal targetMinValue;
	
	/**
	 * 最大评分值：最大评分值
	*/
	@ApiModelProperty(required = false,value="最大评分值" , notes = "最大评分值" , example = "100.00")
	private BigDecimal targetMaxValue;
	
	/**
	 * 默认评分值：默认评分值
	*/
	@ApiModelProperty(required = false,value="默认评分值" , notes = "默认评分值" , example = "80.00")
	private BigDecimal defaultValue;
	
	/**
	 * 定性/定量指标：定性/定量指标
	*/
	@ApiModelProperty(required = false,value="定性/定量指标" , notes = "定性/定量指标")
	private String property;
	
	/**
	 * 计量单位：计量单位
	*/
	@ApiModelProperty(required = false,value="计量单位" , notes = "计量单位")
	private String unit;
	
	/**
	 * 指标定义：指标定义
	*/
	@ApiModelProperty(required = false,value="指标定义" , notes = "指标定义")
	private String def;
	
	/**
	 * 评分标准：评分标准
	*/
	@ApiModelProperty(required = false,value="评分标准" , notes = "评分标准")
	private String scoringBase;
	
	/**
	 * 评分依据：评分依据
	*/
	@ApiModelProperty(required = false,value="评分依据" , notes = "评分依据")
	private String scoringBy;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sn;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-29 03:10:38")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-29 03:12:19")
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
	 * selfAssessmentValue：selfAssessmentValue
	*/
	@ApiModelProperty(required = false,value="selfAssessmentValue" , notes = "selfAssessmentValue")
	private AssessmentIndicatorValue selfAssessmentValue;
	
	/**
	 * leaderAssessmentValue：leaderAssessmentValue
	*/
	@ApiModelProperty(required = false,value="leaderAssessmentValue" , notes = "leaderAssessmentValue")
	private AssessmentIndicatorValue leaderAssessmentValue;
	
	/**
	 * sameAssessmentValue：sameAssessmentValue
	*/
	@ApiModelProperty(required = false,value="sameAssessmentValue" , notes = "sameAssessmentValue")
	private List<AssessmentIndicatorValue> sameAssessmentValue;
	
	/**
	 * indicatorLib：indicatorLib
	*/
	@ApiModelProperty(required = false,value="indicatorLib" , notes = "indicatorLib")
	private List<IndicatorLib> indicatorLib;
	
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
	public AssessmentIndicator setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * tpl,inst
	 * @return 归属
	*/
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 设置 归属
	 * @param owner 归属
	 * @return 当前对象
	*/
	public AssessmentIndicator setOwner(String owner) {
		this.owner=owner;
		return this;
	}
	
	/**
	 * 获得 考核主题<br>
	 * 考核主题
	 * @return 考核主题
	*/
	public String getAssessmentId() {
		return assessmentId;
	}
	
	/**
	 * 设置 考核主题
	 * @param assessmentId 考核主题
	 * @return 当前对象
	*/
	public AssessmentIndicator setAssessmentId(String assessmentId) {
		this.assessmentId=assessmentId;
		return this;
	}
	
	/**
	 * 获得 指标库<br>
	 * 指标库
	 * @return 指标库
	*/
	public String getTplIndicatorId() {
		return tplIndicatorId;
	}
	
	/**
	 * 设置 指标库
	 * @param tplIndicatorId 指标库
	 * @return 当前对象
	*/
	public AssessmentIndicator setTplIndicatorId(String tplIndicatorId) {
		this.tplIndicatorId=tplIndicatorId;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getGroupname() {
		return groupname;
	}
	
	/**
	 * 设置 分类
	 * @param groupname 分类
	 * @return 当前对象
	*/
	public AssessmentIndicator setGroupname(String groupname) {
		this.groupname=groupname;
		return this;
	}
	
	/**
	 * 获得 指标名称<br>
	 * 指标名称
	 * @return 指标名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 指标名称
	 * @param name 指标名称
	 * @return 当前对象
	*/
	public AssessmentIndicator setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 权重<br>
	 * %)
	 * @return 权重
	*/
	public BigDecimal getWeight() {
		return weight;
	}
	
	/**
	 * 设置 权重
	 * @param weight 权重
	 * @return 当前对象
	*/
	public AssessmentIndicator setWeight(BigDecimal weight) {
		this.weight=weight;
		return this;
	}
	
	/**
	 * 获得 最小评分值<br>
	 * 最小评分值
	 * @return 最小评分值
	*/
	public BigDecimal getTargetMinValue() {
		return targetMinValue;
	}
	
	/**
	 * 设置 最小评分值
	 * @param targetMinValue 最小评分值
	 * @return 当前对象
	*/
	public AssessmentIndicator setTargetMinValue(BigDecimal targetMinValue) {
		this.targetMinValue=targetMinValue;
		return this;
	}
	
	/**
	 * 获得 最大评分值<br>
	 * 最大评分值
	 * @return 最大评分值
	*/
	public BigDecimal getTargetMaxValue() {
		return targetMaxValue;
	}
	
	/**
	 * 设置 最大评分值
	 * @param targetMaxValue 最大评分值
	 * @return 当前对象
	*/
	public AssessmentIndicator setTargetMaxValue(BigDecimal targetMaxValue) {
		this.targetMaxValue=targetMaxValue;
		return this;
	}
	
	/**
	 * 获得 默认评分值<br>
	 * 默认评分值
	 * @return 默认评分值
	*/
	public BigDecimal getDefaultValue() {
		return defaultValue;
	}
	
	/**
	 * 设置 默认评分值
	 * @param defaultValue 默认评分值
	 * @return 当前对象
	*/
	public AssessmentIndicator setDefaultValue(BigDecimal defaultValue) {
		this.defaultValue=defaultValue;
		return this;
	}
	
	/**
	 * 获得 定性/定量指标<br>
	 * 定性/定量指标
	 * @return 定性/定量指标
	*/
	public String getProperty() {
		return property;
	}
	
	/**
	 * 设置 定性/定量指标
	 * @param property 定性/定量指标
	 * @return 当前对象
	*/
	public AssessmentIndicator setProperty(String property) {
		this.property=property;
		return this;
	}
	
	/**
	 * 获得 计量单位<br>
	 * 计量单位
	 * @return 计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 计量单位
	 * @param unit 计量单位
	 * @return 当前对象
	*/
	public AssessmentIndicator setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 指标定义<br>
	 * 指标定义
	 * @return 指标定义
	*/
	public String getDef() {
		return def;
	}
	
	/**
	 * 设置 指标定义
	 * @param def 指标定义
	 * @return 当前对象
	*/
	public AssessmentIndicator setDef(String def) {
		this.def=def;
		return this;
	}
	
	/**
	 * 获得 评分标准<br>
	 * 评分标准
	 * @return 评分标准
	*/
	public String getScoringBase() {
		return scoringBase;
	}
	
	/**
	 * 设置 评分标准
	 * @param scoringBase 评分标准
	 * @return 当前对象
	*/
	public AssessmentIndicator setScoringBase(String scoringBase) {
		this.scoringBase=scoringBase;
		return this;
	}
	
	/**
	 * 获得 评分依据<br>
	 * 评分依据
	 * @return 评分依据
	*/
	public String getScoringBy() {
		return scoringBy;
	}
	
	/**
	 * 设置 评分依据
	 * @param scoringBy 评分依据
	 * @return 当前对象
	*/
	public AssessmentIndicator setScoringBy(String scoringBy) {
		this.scoringBy=scoringBy;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSn() {
		return sn;
	}
	
	/**
	 * 设置 排序
	 * @param sn 排序
	 * @return 当前对象
	*/
	public AssessmentIndicator setSn(Integer sn) {
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
	public AssessmentIndicator setCreateBy(String createBy) {
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
	public AssessmentIndicator setCreateTime(Date createTime) {
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
	public AssessmentIndicator setUpdateBy(String updateBy) {
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
	public AssessmentIndicator setUpdateTime(Date updateTime) {
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
	public AssessmentIndicator setDeleted(Integer deleted) {
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
	public AssessmentIndicator setDeleted(Boolean deletedBool) {
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
	public AssessmentIndicator setDeleteBy(String deleteBy) {
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
	public AssessmentIndicator setDeleteTime(Date deleteTime) {
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
	public AssessmentIndicator setVersion(Integer version) {
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
	public AssessmentIndicator setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 selfAssessmentValue<br>
	 * selfAssessmentValue
	 * @return selfAssessmentValue
	*/
	public AssessmentIndicatorValue getSelfAssessmentValue() {
		return selfAssessmentValue;
	}
	
	/**
	 * 设置 selfAssessmentValue
	 * @param selfAssessmentValue selfAssessmentValue
	 * @return 当前对象
	*/
	public AssessmentIndicator setSelfAssessmentValue(AssessmentIndicatorValue selfAssessmentValue) {
		this.selfAssessmentValue=selfAssessmentValue;
		return this;
	}
	
	/**
	 * 获得 leaderAssessmentValue<br>
	 * leaderAssessmentValue
	 * @return leaderAssessmentValue
	*/
	public AssessmentIndicatorValue getLeaderAssessmentValue() {
		return leaderAssessmentValue;
	}
	
	/**
	 * 设置 leaderAssessmentValue
	 * @param leaderAssessmentValue leaderAssessmentValue
	 * @return 当前对象
	*/
	public AssessmentIndicator setLeaderAssessmentValue(AssessmentIndicatorValue leaderAssessmentValue) {
		this.leaderAssessmentValue=leaderAssessmentValue;
		return this;
	}
	
	/**
	 * 获得 sameAssessmentValue<br>
	 * sameAssessmentValue
	 * @return sameAssessmentValue
	*/
	public List<AssessmentIndicatorValue> getSameAssessmentValue() {
		return sameAssessmentValue;
	}
	
	/**
	 * 设置 sameAssessmentValue
	 * @param sameAssessmentValue sameAssessmentValue
	 * @return 当前对象
	*/
	public AssessmentIndicator setSameAssessmentValue(List<AssessmentIndicatorValue> sameAssessmentValue) {
		this.sameAssessmentValue=sameAssessmentValue;
		return this;
	}
	
	/**
	 * 添加 sameAssessmentValue
	 * @param entity sameAssessmentValue
	 * @return 当前对象
	*/
	public AssessmentIndicator addSameAssessmentValue(AssessmentIndicatorValue... entity) {
		if(this.sameAssessmentValue==null) sameAssessmentValue=new ArrayList<>();
		this.sameAssessmentValue.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 indicatorLib<br>
	 * indicatorLib
	 * @return indicatorLib
	*/
	public List<IndicatorLib> getIndicatorLib() {
		return indicatorLib;
	}
	
	/**
	 * 设置 indicatorLib
	 * @param indicatorLib indicatorLib
	 * @return 当前对象
	*/
	public AssessmentIndicator setIndicatorLib(List<IndicatorLib> indicatorLib) {
		this.indicatorLib=indicatorLib;
		return this;
	}
	
	/**
	 * 添加 indicatorLib
	 * @param entity indicatorLib
	 * @return 当前对象
	*/
	public AssessmentIndicator addIndicatorLib(IndicatorLib... entity) {
		if(this.indicatorLib==null) indicatorLib=new ArrayList<>();
		this.indicatorLib.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentIndicator , 转换好的 AssessmentIndicator 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentIndicator , 转换好的 PoJo 对象
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
	public AssessmentIndicator clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentIndicator duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentIndicatorMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentIndicatorMeta.$$proxy$$();
		inst.setScoringBase(this.getScoringBase());
		inst.setDef(this.getDef());
		inst.setDefaultValue(this.getDefaultValue());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setProperty(this.getProperty());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setAssessmentId(this.getAssessmentId());
		inst.setOwner(this.getOwner());
		inst.setWeight(this.getWeight());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setGroupname(this.getGroupname());
		inst.setVersion(this.getVersion());
		inst.setScoringBy(this.getScoringBy());
		inst.setUnit(this.getUnit());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTargetMinValue(this.getTargetMinValue());
		inst.setName(this.getName());
		inst.setTargetMaxValue(this.getTargetMaxValue());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTplIndicatorId(this.getTplIndicatorId());
		if(all) {
			inst.setIndicatorLib(this.getIndicatorLib());
			inst.setSelfAssessmentValue(this.getSelfAssessmentValue());
			inst.setLeaderAssessmentValue(this.getLeaderAssessmentValue());
			inst.setSameAssessmentValue(this.getSameAssessmentValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentIndicator clone(boolean deep) {
		return EntityContext.clone(AssessmentIndicator.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentIndicator
	 * @param assessmentIndicatorMap 包含实体信息的 Map 对象
	 * @return AssessmentIndicator , 转换好的的 AssessmentIndicator 对象
	*/
	@Transient
	public static AssessmentIndicator createFrom(Map<String,Object> assessmentIndicatorMap) {
		if(assessmentIndicatorMap==null) return null;
		AssessmentIndicator po = create();
		EntityContext.copyProperties(po,assessmentIndicatorMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentIndicator
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentIndicator , 转换好的的 AssessmentIndicator 对象
	*/
	@Transient
	public static AssessmentIndicator createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentIndicator po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentIndicator，等同于 new
	 * @return AssessmentIndicator 对象
	*/
	@Transient
	public static AssessmentIndicator create() {
		return new com.dt.platform.domain.hr.meta.AssessmentIndicatorMeta.$$proxy$$();
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
			this.setScoringBase(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.SCORING_BASE)));
			this.setDef(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.DEF)));
			this.setDefaultValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorMeta.DEFAULT_VALUE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.UPDATE_BY)));
			this.setProperty(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.PROPERTY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, map.get(AssessmentIndicatorMeta.SN)));
			this.setAssessmentId(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.ASSESSMENT_ID)));
			this.setOwner(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.OWNER)));
			this.setWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorMeta.WEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorMeta.UPDATE_TIME)));
			this.setGroupname(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.GROUPNAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentIndicatorMeta.VERSION)));
			this.setScoringBy(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.SCORING_BY)));
			this.setUnit(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentIndicatorMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorMeta.DELETE_TIME)));
			this.setTargetMinValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorMeta.TARGET_MIN_VALUE)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.NAME)));
			this.setTargetMaxValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorMeta.TARGET_MAX_VALUE)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.DELETE_BY)));
			this.setTplIndicatorId(DataParser.parse(String.class, map.get(AssessmentIndicatorMeta.TPL_INDICATOR_ID)));
			// others
			this.setSelfAssessmentValue(DataParser.parse(AssessmentIndicatorValue.class, map.get(AssessmentIndicatorMeta.SELF_ASSESSMENT_VALUE)));
			this.setLeaderAssessmentValue(DataParser.parse(AssessmentIndicatorValue.class, map.get(AssessmentIndicatorMeta.LEADER_ASSESSMENT_VALUE)));
			return true;
		} else {
			try {
				this.setScoringBase( (String)map.get(AssessmentIndicatorMeta.SCORING_BASE));
				this.setDef( (String)map.get(AssessmentIndicatorMeta.DEF));
				this.setDefaultValue( (BigDecimal)map.get(AssessmentIndicatorMeta.DEFAULT_VALUE));
				this.setUpdateBy( (String)map.get(AssessmentIndicatorMeta.UPDATE_BY));
				this.setProperty( (String)map.get(AssessmentIndicatorMeta.PROPERTY));
				this.setId( (String)map.get(AssessmentIndicatorMeta.ID));
				this.setSn( (Integer)map.get(AssessmentIndicatorMeta.SN));
				this.setAssessmentId( (String)map.get(AssessmentIndicatorMeta.ASSESSMENT_ID));
				this.setOwner( (String)map.get(AssessmentIndicatorMeta.OWNER));
				this.setWeight( (BigDecimal)map.get(AssessmentIndicatorMeta.WEIGHT));
				this.setUpdateTime( (Date)map.get(AssessmentIndicatorMeta.UPDATE_TIME));
				this.setGroupname( (String)map.get(AssessmentIndicatorMeta.GROUPNAME));
				this.setVersion( (Integer)map.get(AssessmentIndicatorMeta.VERSION));
				this.setScoringBy( (String)map.get(AssessmentIndicatorMeta.SCORING_BY));
				this.setUnit( (String)map.get(AssessmentIndicatorMeta.UNIT));
				this.setCreateBy( (String)map.get(AssessmentIndicatorMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentIndicatorMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentIndicatorMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssessmentIndicatorMeta.DELETE_TIME));
				this.setTargetMinValue( (BigDecimal)map.get(AssessmentIndicatorMeta.TARGET_MIN_VALUE));
				this.setName( (String)map.get(AssessmentIndicatorMeta.NAME));
				this.setTargetMaxValue( (BigDecimal)map.get(AssessmentIndicatorMeta.TARGET_MAX_VALUE));
				this.setTenantId( (String)map.get(AssessmentIndicatorMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentIndicatorMeta.DELETE_BY));
				this.setTplIndicatorId( (String)map.get(AssessmentIndicatorMeta.TPL_INDICATOR_ID));
				// others
				this.setSelfAssessmentValue( (AssessmentIndicatorValue)map.get(AssessmentIndicatorMeta.SELF_ASSESSMENT_VALUE));
				this.setLeaderAssessmentValue( (AssessmentIndicatorValue)map.get(AssessmentIndicatorMeta.LEADER_ASSESSMENT_VALUE));
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
			this.setScoringBase(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.SCORING_BASE)));
			this.setDef(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.DEF)));
			this.setDefaultValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorMeta.DEFAULT_VALUE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.UPDATE_BY)));
			this.setProperty(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.PROPERTY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorMeta.SN)));
			this.setAssessmentId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.ASSESSMENT_ID)));
			this.setOwner(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.OWNER)));
			this.setWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorMeta.WEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorMeta.UPDATE_TIME)));
			this.setGroupname(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.GROUPNAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorMeta.VERSION)));
			this.setScoringBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.SCORING_BY)));
			this.setUnit(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorMeta.DELETE_TIME)));
			this.setTargetMinValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorMeta.TARGET_MIN_VALUE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.NAME)));
			this.setTargetMaxValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorMeta.TARGET_MAX_VALUE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.DELETE_BY)));
			this.setTplIndicatorId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorMeta.TPL_INDICATOR_ID)));
			return true;
		} else {
			try {
				this.setScoringBase( (String)r.getValue(AssessmentIndicatorMeta.SCORING_BASE));
				this.setDef( (String)r.getValue(AssessmentIndicatorMeta.DEF));
				this.setDefaultValue( (BigDecimal)r.getValue(AssessmentIndicatorMeta.DEFAULT_VALUE));
				this.setUpdateBy( (String)r.getValue(AssessmentIndicatorMeta.UPDATE_BY));
				this.setProperty( (String)r.getValue(AssessmentIndicatorMeta.PROPERTY));
				this.setId( (String)r.getValue(AssessmentIndicatorMeta.ID));
				this.setSn( (Integer)r.getValue(AssessmentIndicatorMeta.SN));
				this.setAssessmentId( (String)r.getValue(AssessmentIndicatorMeta.ASSESSMENT_ID));
				this.setOwner( (String)r.getValue(AssessmentIndicatorMeta.OWNER));
				this.setWeight( (BigDecimal)r.getValue(AssessmentIndicatorMeta.WEIGHT));
				this.setUpdateTime( (Date)r.getValue(AssessmentIndicatorMeta.UPDATE_TIME));
				this.setGroupname( (String)r.getValue(AssessmentIndicatorMeta.GROUPNAME));
				this.setVersion( (Integer)r.getValue(AssessmentIndicatorMeta.VERSION));
				this.setScoringBy( (String)r.getValue(AssessmentIndicatorMeta.SCORING_BY));
				this.setUnit( (String)r.getValue(AssessmentIndicatorMeta.UNIT));
				this.setCreateBy( (String)r.getValue(AssessmentIndicatorMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentIndicatorMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentIndicatorMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssessmentIndicatorMeta.DELETE_TIME));
				this.setTargetMinValue( (BigDecimal)r.getValue(AssessmentIndicatorMeta.TARGET_MIN_VALUE));
				this.setName( (String)r.getValue(AssessmentIndicatorMeta.NAME));
				this.setTargetMaxValue( (BigDecimal)r.getValue(AssessmentIndicatorMeta.TARGET_MAX_VALUE));
				this.setTenantId( (String)r.getValue(AssessmentIndicatorMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentIndicatorMeta.DELETE_BY));
				this.setTplIndicatorId( (String)r.getValue(AssessmentIndicatorMeta.TPL_INDICATOR_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}