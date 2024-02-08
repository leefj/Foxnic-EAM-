package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERFORMANCE_LEVEL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PerformanceLevelMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核等级
 * <p>考核等级 , 数据表 hr_performance_level 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 16:04:59
 * @sign AD28231A05750238E4AC9870B42C8E14
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_performance_level")
@ApiModel(description = "考核等级 ; 考核等级 , 数据表 hr_performance_level 的PO类型")
public class PerformanceLevel extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERFORMANCE_LEVEL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 等级编码：等级编码
	*/
	@ApiModelProperty(required = false,value="等级编码" , notes = "等级编码")
	private String code;
	
	/**
	 * 等级名称：等级名称
	*/
	@ApiModelProperty(required = false,value="等级名称" , notes = "等级名称")
	private String name;
	
	/**
	 * 成绩下限：成绩下限
	*/
	@ApiModelProperty(required = false,value="成绩下限" , notes = "成绩下限")
	private String lowerLimit;
	
	/**
	 * 成绩上限：成绩上限
	*/
	@ApiModelProperty(required = false,value="成绩上限" , notes = "成绩上限")
	private String upperLimit;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public PerformanceLevel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 等级编码<br>
	 * 等级编码
	 * @return 等级编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 等级编码
	 * @param code 等级编码
	 * @return 当前对象
	*/
	public PerformanceLevel setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 等级名称<br>
	 * 等级名称
	 * @return 等级名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 等级名称
	 * @param name 等级名称
	 * @return 当前对象
	*/
	public PerformanceLevel setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 成绩下限<br>
	 * 成绩下限
	 * @return 成绩下限
	*/
	public String getLowerLimit() {
		return lowerLimit;
	}
	
	/**
	 * 设置 成绩下限
	 * @param lowerLimit 成绩下限
	 * @return 当前对象
	*/
	public PerformanceLevel setLowerLimit(String lowerLimit) {
		this.lowerLimit=lowerLimit;
		return this;
	}
	
	/**
	 * 获得 成绩上限<br>
	 * 成绩上限
	 * @return 成绩上限
	*/
	public String getUpperLimit() {
		return upperLimit;
	}
	
	/**
	 * 设置 成绩上限
	 * @param upperLimit 成绩上限
	 * @return 当前对象
	*/
	public PerformanceLevel setUpperLimit(String upperLimit) {
		this.upperLimit=upperLimit;
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
	public PerformanceLevel setCreateBy(String createBy) {
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
	public PerformanceLevel setCreateTime(Date createTime) {
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
	public PerformanceLevel setUpdateBy(String updateBy) {
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
	public PerformanceLevel setUpdateTime(Date updateTime) {
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
	public PerformanceLevel setDeleted(Integer deleted) {
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
	public PerformanceLevel setDeleted(Boolean deletedBool) {
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
	public PerformanceLevel setDeleteBy(String deleteBy) {
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
	public PerformanceLevel setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public PerformanceLevel setVersion(Integer version) {
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
	public PerformanceLevel setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PerformanceLevel , 转换好的 PerformanceLevel 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PerformanceLevel , 转换好的 PoJo 对象
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
	public PerformanceLevel clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PerformanceLevel duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PerformanceLevelMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PerformanceLevelMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLowerLimit(this.getLowerLimit());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpperLimit(this.getUpperLimit());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PerformanceLevel clone(boolean deep) {
		return EntityContext.clone(PerformanceLevel.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PerformanceLevel
	 * @param performanceLevelMap 包含实体信息的 Map 对象
	 * @return PerformanceLevel , 转换好的的 PerformanceLevel 对象
	*/
	@Transient
	public static PerformanceLevel createFrom(Map<String,Object> performanceLevelMap) {
		if(performanceLevelMap==null) return null;
		PerformanceLevel po = create();
		EntityContext.copyProperties(po,performanceLevelMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PerformanceLevel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PerformanceLevel , 转换好的的 PerformanceLevel 对象
	*/
	@Transient
	public static PerformanceLevel createFrom(Object pojo) {
		if(pojo==null) return null;
		PerformanceLevel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PerformanceLevel，等同于 new
	 * @return PerformanceLevel 对象
	*/
	@Transient
	public static PerformanceLevel create() {
		return new com.dt.platform.domain.hr.meta.PerformanceLevelMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(PerformanceLevelMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PerformanceLevelMeta.UPDATE_TIME)));
			this.setLowerLimit(DataParser.parse(String.class, map.get(PerformanceLevelMeta.LOWER_LIMIT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PerformanceLevelMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PerformanceLevelMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PerformanceLevelMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PerformanceLevelMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PerformanceLevelMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PerformanceLevelMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PerformanceLevelMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PerformanceLevelMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PerformanceLevelMeta.DELETE_BY)));
			this.setUpperLimit(DataParser.parse(String.class, map.get(PerformanceLevelMeta.UPPER_LIMIT)));
			this.setId(DataParser.parse(String.class, map.get(PerformanceLevelMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(PerformanceLevelMeta.CODE));
				this.setUpdateTime( (Date)map.get(PerformanceLevelMeta.UPDATE_TIME));
				this.setLowerLimit( (String)map.get(PerformanceLevelMeta.LOWER_LIMIT));
				this.setVersion( (Integer)map.get(PerformanceLevelMeta.VERSION));
				this.setCreateBy( (String)map.get(PerformanceLevelMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PerformanceLevelMeta.DELETED));
				this.setCreateTime( (Date)map.get(PerformanceLevelMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PerformanceLevelMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PerformanceLevelMeta.DELETE_TIME));
				this.setName( (String)map.get(PerformanceLevelMeta.NAME));
				this.setTenantId( (String)map.get(PerformanceLevelMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PerformanceLevelMeta.DELETE_BY));
				this.setUpperLimit( (String)map.get(PerformanceLevelMeta.UPPER_LIMIT));
				this.setId( (String)map.get(PerformanceLevelMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PerformanceLevelMeta.UPDATE_TIME)));
			this.setLowerLimit(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.LOWER_LIMIT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PerformanceLevelMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PerformanceLevelMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PerformanceLevelMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PerformanceLevelMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.DELETE_BY)));
			this.setUpperLimit(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.UPPER_LIMIT)));
			this.setId(DataParser.parse(String.class, r.getValue(PerformanceLevelMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(PerformanceLevelMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(PerformanceLevelMeta.UPDATE_TIME));
				this.setLowerLimit( (String)r.getValue(PerformanceLevelMeta.LOWER_LIMIT));
				this.setVersion( (Integer)r.getValue(PerformanceLevelMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PerformanceLevelMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PerformanceLevelMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PerformanceLevelMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PerformanceLevelMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PerformanceLevelMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PerformanceLevelMeta.NAME));
				this.setTenantId( (String)r.getValue(PerformanceLevelMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PerformanceLevelMeta.DELETE_BY));
				this.setUpperLimit( (String)r.getValue(PerformanceLevelMeta.UPPER_LIMIT));
				this.setId( (String)r.getValue(PerformanceLevelMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}