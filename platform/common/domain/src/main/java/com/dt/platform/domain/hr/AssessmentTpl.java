package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_TPL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentTplMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核模版
 * <p>考核模版 , 数据表 hr_assessment_tpl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 21:32:45
 * @sign 1F01E8FA93F5623B45986E56B197E55E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_tpl")
@ApiModel(description = "考核模版 ; 考核模版 , 数据表 hr_assessment_tpl 的PO类型")
public class AssessmentTpl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_TPL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "815575524477763584")
	private String id;
	
	/**
	 * 模版名称：模版名称
	*/
	@ApiModelProperty(required = false,value="模版名称" , notes = "模版名称" , example = "科技项目绩效模版")
	private String name;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类")
	private String type;
	
	/**
	 * 部门：部门
	*/
	@ApiModelProperty(required = false,value="部门" , notes = "部门" , example = "788871090188320768,788871143518896128")
	private String orgId;
	
	/**
	 * 指标总权重：%）
	*/
	@ApiModelProperty(required = false,value="指标总权重" , notes = "%）" , example = "100.00")
	private BigDecimal totalWeight;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "科技项目绩效模版")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-29 01:25:58")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-03-02 04:51:08")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "11")
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
	private List<AssessmentIndicator> assessmentIndicator;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * typeDict：typeDict
	*/
	@ApiModelProperty(required = false,value="typeDict" , notes = "typeDict")
	private DictItem typeDict;
	
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
	public AssessmentTpl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模版名称<br>
	 * 模版名称
	 * @return 模版名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 模版名称
	 * @param name 模版名称
	 * @return 当前对象
	*/
	public AssessmentTpl setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 分类
	 * @param type 分类
	 * @return 当前对象
	*/
	public AssessmentTpl setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 部门<br>
	 * 部门
	 * @return 部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 部门
	 * @param orgId 部门
	 * @return 当前对象
	*/
	public AssessmentTpl setOrgId(String orgId) {
		this.orgId=orgId;
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
	public AssessmentTpl setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight=totalWeight;
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
	public AssessmentTpl setNotes(String notes) {
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
	public AssessmentTpl setCreateBy(String createBy) {
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
	public AssessmentTpl setCreateTime(Date createTime) {
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
	public AssessmentTpl setUpdateBy(String updateBy) {
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
	public AssessmentTpl setUpdateTime(Date updateTime) {
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
	public AssessmentTpl setDeleted(Integer deleted) {
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
	public AssessmentTpl setDeleted(Boolean deletedBool) {
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
	public AssessmentTpl setDeleteBy(String deleteBy) {
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
	public AssessmentTpl setDeleteTime(Date deleteTime) {
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
	public AssessmentTpl setVersion(Integer version) {
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
	public AssessmentTpl setTenantId(String tenantId) {
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
	public AssessmentTpl setAssessmentIndicator(List<AssessmentIndicator> assessmentIndicator) {
		this.assessmentIndicator=assessmentIndicator;
		return this;
	}
	
	/**
	 * 添加 assessmentIndicator
	 * @param entity assessmentIndicator
	 * @return 当前对象
	*/
	public AssessmentTpl addAssessmentIndicator(AssessmentIndicator... entity) {
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
	public AssessmentTpl setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 typeDict<br>
	 * typeDict
	 * @return typeDict
	*/
	public DictItem getTypeDict() {
		return typeDict;
	}
	
	/**
	 * 设置 typeDict
	 * @param typeDict typeDict
	 * @return 当前对象
	*/
	public AssessmentTpl setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
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
	public AssessmentTpl setPositionList(List<Position> positionList) {
		this.positionList=positionList;
		return this;
	}
	
	/**
	 * 添加 positionList
	 * @param position positionList
	 * @return 当前对象
	*/
	public AssessmentTpl addPosition(Position... position) {
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
	public AssessmentTpl setPositionIds(List<String> positionIds) {
		this.positionIds=positionIds;
		return this;
	}
	
	/**
	 * 添加 positionIds
	 * @param positionId positionIds
	 * @return 当前对象
	*/
	public AssessmentTpl addPositionId(String... positionId) {
		if(this.positionIds==null) positionIds=new ArrayList<>();
		this.positionIds.addAll(Arrays.asList(positionId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentTpl , 转换好的 AssessmentTpl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentTpl , 转换好的 PoJo 对象
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
	public AssessmentTpl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentTpl duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentTplMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentTplMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTotalWeight(this.getTotalWeight());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setPositionIds(this.getPositionIds());
			inst.setPositionList(this.getPositionList());
			inst.setTypeDict(this.getTypeDict());
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
	public AssessmentTpl clone(boolean deep) {
		return EntityContext.clone(AssessmentTpl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentTpl
	 * @param assessmentTplMap 包含实体信息的 Map 对象
	 * @return AssessmentTpl , 转换好的的 AssessmentTpl 对象
	*/
	@Transient
	public static AssessmentTpl createFrom(Map<String,Object> assessmentTplMap) {
		if(assessmentTplMap==null) return null;
		AssessmentTpl po = create();
		EntityContext.copyProperties(po,assessmentTplMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentTpl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentTpl , 转换好的的 AssessmentTpl 对象
	*/
	@Transient
	public static AssessmentTpl createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentTpl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentTpl，等同于 new
	 * @return AssessmentTpl 对象
	*/
	@Transient
	public static AssessmentTpl create() {
		return new com.dt.platform.domain.hr.meta.AssessmentTplMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssessmentTplMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentTplMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(AssessmentTplMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentTplMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(AssessmentTplMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentTplMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentTplMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentTplMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentTplMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentTplMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentTplMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentTplMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentTplMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentTplMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentTplMeta.ID)));
			// others
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(AssessmentTplMeta.TYPE_DICT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssessmentTplMeta.SELECTED_CODE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssessmentTplMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssessmentTplMeta.UPDATE_TIME));
				this.setType( (String)map.get(AssessmentTplMeta.TYPE));
				this.setVersion( (Integer)map.get(AssessmentTplMeta.VERSION));
				this.setOrgId( (String)map.get(AssessmentTplMeta.ORG_ID));
				this.setCreateBy( (String)map.get(AssessmentTplMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentTplMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentTplMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentTplMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentTplMeta.DELETE_TIME));
				this.setName( (String)map.get(AssessmentTplMeta.NAME));
				this.setTotalWeight( (BigDecimal)map.get(AssessmentTplMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)map.get(AssessmentTplMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentTplMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentTplMeta.ID));
				// others
				this.setTypeDict( (DictItem)map.get(AssessmentTplMeta.TYPE_DICT));
				this.setSelectedCode( (String)map.get(AssessmentTplMeta.SELECTED_CODE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentTplMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentTplMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentTplMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentTplMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentTplMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentTplMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentTplMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssessmentTplMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssessmentTplMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(AssessmentTplMeta.TYPE));
				this.setVersion( (Integer)r.getValue(AssessmentTplMeta.VERSION));
				this.setOrgId( (String)r.getValue(AssessmentTplMeta.ORG_ID));
				this.setCreateBy( (String)r.getValue(AssessmentTplMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentTplMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentTplMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentTplMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentTplMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssessmentTplMeta.NAME));
				this.setTotalWeight( (BigDecimal)r.getValue(AssessmentTplMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)r.getValue(AssessmentTplMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentTplMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentTplMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}