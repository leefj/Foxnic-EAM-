package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_CYCLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentCycleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核周期
 * <p>考核周期 , 数据表 hr_assessment_cycle 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-28 10:48:35
 * @sign 7A590D91CEA43AEA05786C1E494D2B07
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_cycle")
@ApiModel(description = "考核周期 ; 考核周期 , 数据表 hr_assessment_cycle 的PO类型")
public class AssessmentCycle extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_CYCLE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 考核主题：考核主题
	*/
	@ApiModelProperty(required = false,value="考核主题" , notes = "考核主题")
	private String name;
	
	/**
	 * 考核说明：考核说明
	*/
	@ApiModelProperty(required = false,value="考核说明" , notes = "考核说明")
	private String info;
	
	/**
	 * 年份：年份
	*/
	@ApiModelProperty(required = false,value="年份" , notes = "年份")
	private String year;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date sdate;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date edate;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 提及人：提及人
	*/
	@ApiModelProperty(required = false,value="提及人" , notes = "提及人")
	private String rcdUserId;
	
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
	public AssessmentCycle setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 考核主题<br>
	 * 考核主题
	 * @return 考核主题
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 考核主题
	 * @param name 考核主题
	 * @return 当前对象
	*/
	public AssessmentCycle setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 考核说明<br>
	 * 考核说明
	 * @return 考核说明
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 考核说明
	 * @param info 考核说明
	 * @return 当前对象
	*/
	public AssessmentCycle setInfo(String info) {
		this.info=info;
		return this;
	}
	
	/**
	 * 获得 年份<br>
	 * 年份
	 * @return 年份
	*/
	public String getYear() {
		return year;
	}
	
	/**
	 * 设置 年份
	 * @param year 年份
	 * @return 当前对象
	*/
	public AssessmentCycle setYear(String year) {
		this.year=year;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getSdate() {
		return sdate;
	}
	
	/**
	 * 设置 开始时间
	 * @param sdate 开始时间
	 * @return 当前对象
	*/
	public AssessmentCycle setSdate(Date sdate) {
		this.sdate=sdate;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEdate() {
		return edate;
	}
	
	/**
	 * 设置 结束时间
	 * @param edate 结束时间
	 * @return 当前对象
	*/
	public AssessmentCycle setEdate(Date edate) {
		this.edate=edate;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public AssessmentCycle setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 提及人<br>
	 * 提及人
	 * @return 提及人
	*/
	public String getRcdUserId() {
		return rcdUserId;
	}
	
	/**
	 * 设置 提及人
	 * @param rcdUserId 提及人
	 * @return 当前对象
	*/
	public AssessmentCycle setRcdUserId(String rcdUserId) {
		this.rcdUserId=rcdUserId;
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
	public AssessmentCycle setCreateBy(String createBy) {
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
	public AssessmentCycle setCreateTime(Date createTime) {
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
	public AssessmentCycle setUpdateBy(String updateBy) {
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
	public AssessmentCycle setUpdateTime(Date updateTime) {
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
	public AssessmentCycle setDeleted(Integer deleted) {
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
	public AssessmentCycle setDeleted(Boolean deletedBool) {
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
	public AssessmentCycle setDeleteBy(String deleteBy) {
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
	public AssessmentCycle setDeleteTime(Date deleteTime) {
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
	public AssessmentCycle setVersion(Integer version) {
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
	public AssessmentCycle setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentCycle , 转换好的 AssessmentCycle 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentCycle , 转换好的 PoJo 对象
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
	public AssessmentCycle clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentCycle duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentCycleMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentCycleMeta.$$proxy$$();
		inst.setSdate(this.getSdate());
		inst.setYear(this.getYear());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setEdate(this.getEdate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setRcdUserId(this.getRcdUserId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setInfo(this.getInfo());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentCycle clone(boolean deep) {
		return EntityContext.clone(AssessmentCycle.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentCycle
	 * @param assessmentCycleMap 包含实体信息的 Map 对象
	 * @return AssessmentCycle , 转换好的的 AssessmentCycle 对象
	*/
	@Transient
	public static AssessmentCycle createFrom(Map<String,Object> assessmentCycleMap) {
		if(assessmentCycleMap==null) return null;
		AssessmentCycle po = create();
		EntityContext.copyProperties(po,assessmentCycleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentCycle
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentCycle , 转换好的的 AssessmentCycle 对象
	*/
	@Transient
	public static AssessmentCycle createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentCycle po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentCycle，等同于 new
	 * @return AssessmentCycle 对象
	*/
	@Transient
	public static AssessmentCycle create() {
		return new com.dt.platform.domain.hr.meta.AssessmentCycleMeta.$$proxy$$();
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
			this.setSdate(DataParser.parse(Date.class, map.get(AssessmentCycleMeta.SDATE)));
			this.setYear(DataParser.parse(String.class, map.get(AssessmentCycleMeta.YEAR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentCycleMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(AssessmentCycleMeta.LABEL)));
			this.setEdate(DataParser.parse(Date.class, map.get(AssessmentCycleMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentCycleMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentCycleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentCycleMeta.DELETED)));
			this.setRcdUserId(DataParser.parse(String.class, map.get(AssessmentCycleMeta.RCD_USER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentCycleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentCycleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentCycleMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentCycleMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentCycleMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentCycleMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentCycleMeta.ID)));
			this.setInfo(DataParser.parse(String.class, map.get(AssessmentCycleMeta.INFO)));
			// others
			return true;
		} else {
			try {
				this.setSdate( (Date)map.get(AssessmentCycleMeta.SDATE));
				this.setYear( (String)map.get(AssessmentCycleMeta.YEAR));
				this.setUpdateTime( (Date)map.get(AssessmentCycleMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(AssessmentCycleMeta.LABEL));
				this.setEdate( (Date)map.get(AssessmentCycleMeta.EDATE));
				this.setVersion( (Integer)map.get(AssessmentCycleMeta.VERSION));
				this.setCreateBy( (String)map.get(AssessmentCycleMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentCycleMeta.DELETED));
				this.setRcdUserId( (String)map.get(AssessmentCycleMeta.RCD_USER_ID));
				this.setCreateTime( (Date)map.get(AssessmentCycleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentCycleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentCycleMeta.DELETE_TIME));
				this.setName( (String)map.get(AssessmentCycleMeta.NAME));
				this.setTenantId( (String)map.get(AssessmentCycleMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentCycleMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentCycleMeta.ID));
				this.setInfo( (String)map.get(AssessmentCycleMeta.INFO));
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
			this.setSdate(DataParser.parse(Date.class, r.getValue(AssessmentCycleMeta.SDATE)));
			this.setYear(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.YEAR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentCycleMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.LABEL)));
			this.setEdate(DataParser.parse(Date.class, r.getValue(AssessmentCycleMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentCycleMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentCycleMeta.DELETED)));
			this.setRcdUserId(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.RCD_USER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentCycleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentCycleMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.ID)));
			this.setInfo(DataParser.parse(String.class, r.getValue(AssessmentCycleMeta.INFO)));
			return true;
		} else {
			try {
				this.setSdate( (Date)r.getValue(AssessmentCycleMeta.SDATE));
				this.setYear( (String)r.getValue(AssessmentCycleMeta.YEAR));
				this.setUpdateTime( (Date)r.getValue(AssessmentCycleMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(AssessmentCycleMeta.LABEL));
				this.setEdate( (Date)r.getValue(AssessmentCycleMeta.EDATE));
				this.setVersion( (Integer)r.getValue(AssessmentCycleMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssessmentCycleMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentCycleMeta.DELETED));
				this.setRcdUserId( (String)r.getValue(AssessmentCycleMeta.RCD_USER_ID));
				this.setCreateTime( (Date)r.getValue(AssessmentCycleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentCycleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentCycleMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssessmentCycleMeta.NAME));
				this.setTenantId( (String)r.getValue(AssessmentCycleMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentCycleMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentCycleMeta.ID));
				this.setInfo( (String)r.getValue(AssessmentCycleMeta.INFO));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}