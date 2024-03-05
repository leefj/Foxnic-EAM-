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
 * @since 2024-02-28 10:43:18
 * @sign A2F85344F9CF6991DB519981D75E8C94
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
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标")
	private String indicatorId;
	
	/**
	 * 评分人类型：评分人类型
	*/
	@ApiModelProperty(required = false,value="评分人类型" , notes = "评分人类型")
	private String owner;
	
	/**
	 * 评分人：评分人
	*/
	@ApiModelProperty(required = false,value="评分人" , notes = "评分人")
	private String userId;
	
	/**
	 * 评分：评分
	*/
	@ApiModelProperty(required = false,value="评分" , notes = "评分")
	private BigDecimal value;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String content;
	
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
	 * 获得 评分人类型<br>
	 * 评分人类型
	 * @return 评分人类型
	*/
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 设置 评分人类型
	 * @param owner 评分人类型
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setOwner(String owner) {
		this.owner=owner;
		return this;
	}
	
	/**
	 * 获得 评分人<br>
	 * 评分人
	 * @return 评分人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 评分人
	 * @param userId 评分人
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 评分<br>
	 * 评分
	 * @return 评分
	*/
	public BigDecimal getValue() {
		return value;
	}
	
	/**
	 * 设置 评分
	 * @param value 评分
	 * @return 当前对象
	*/
	public AssessmentIndicatorValue setValue(BigDecimal value) {
		this.value=value;
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
	public AssessmentIndicatorValue setContent(String content) {
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
		inst.setOwner(this.getOwner());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
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
		inst.setValue(this.getValue());
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
			this.setOwner(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.OWNER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorValueMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(AssessmentIndicatorValueMeta.USER_ID)));
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
			this.setValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorValueMeta.VALUE)));
			// others
			return true;
		} else {
			try {
				this.setOwner( (String)map.get(AssessmentIndicatorValueMeta.OWNER));
				this.setUpdateTime( (Date)map.get(AssessmentIndicatorValueMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(AssessmentIndicatorValueMeta.USER_ID));
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
				this.setValue( (BigDecimal)map.get(AssessmentIndicatorValueMeta.VALUE));
				// others
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
			this.setOwner(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.OWNER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorValueMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorValueMeta.USER_ID)));
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
			this.setValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorValueMeta.VALUE)));
			return true;
		} else {
			try {
				this.setOwner( (String)r.getValue(AssessmentIndicatorValueMeta.OWNER));
				this.setUpdateTime( (Date)r.getValue(AssessmentIndicatorValueMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(AssessmentIndicatorValueMeta.USER_ID));
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
				this.setValue( (BigDecimal)r.getValue(AssessmentIndicatorValueMeta.VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}