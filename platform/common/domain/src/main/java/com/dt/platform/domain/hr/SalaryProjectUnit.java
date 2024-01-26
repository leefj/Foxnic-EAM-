package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_PROJECT_UNIT;
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
import com.dt.platform.domain.hr.meta.SalaryProjectUnitMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 计件项目
 * <p>计件项目 , 数据表 hr_salary_project_unit 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 14:49:34
 * @sign 75755DEF6C7B42A085965C759D07BAC9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_project_unit")
@ApiModel(description = "计件项目 ; 计件项目 , 数据表 hr_salary_project_unit 的PO类型")
public class SalaryProjectUnit extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_PROJECT_UNIT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "803273629130293248")
	private String id;
	
	/**
	 * 项目编码：项目编码
	*/
	@ApiModelProperty(required = false,value="项目编码" , notes = "项目编码" , example = "A01")
	private String code;
	
	/**
	 * 项目名称：项目名称
	*/
	@ApiModelProperty(required = false,value="项目名称" , notes = "项目名称" , example = "搬运费")
	private String name;
	
	/**
	 * 计件单价：计件单价
	*/
	@ApiModelProperty(required = false,value="计件单价" , notes = "计件单价" , example = "20.00")
	private BigDecimal money;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-26 02:42:37")
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
	public SalaryProjectUnit setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 项目编码<br>
	 * 项目编码
	 * @return 项目编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 项目编码
	 * @param code 项目编码
	 * @return 当前对象
	*/
	public SalaryProjectUnit setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 项目名称<br>
	 * 项目名称
	 * @return 项目名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 项目名称
	 * @param name 项目名称
	 * @return 当前对象
	*/
	public SalaryProjectUnit setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 计件单价<br>
	 * 计件单价
	 * @return 计件单价
	*/
	public BigDecimal getMoney() {
		return money;
	}
	
	/**
	 * 设置 计件单价
	 * @param money 计件单价
	 * @return 当前对象
	*/
	public SalaryProjectUnit setMoney(BigDecimal money) {
		this.money=money;
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
	public SalaryProjectUnit setNotes(String notes) {
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
	public SalaryProjectUnit setCreateBy(String createBy) {
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
	public SalaryProjectUnit setCreateTime(Date createTime) {
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
	public SalaryProjectUnit setUpdateBy(String updateBy) {
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
	public SalaryProjectUnit setUpdateTime(Date updateTime) {
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
	public SalaryProjectUnit setDeleted(Integer deleted) {
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
	public SalaryProjectUnit setDeleted(Boolean deletedBool) {
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
	public SalaryProjectUnit setDeleteBy(String deleteBy) {
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
	public SalaryProjectUnit setDeleteTime(Date deleteTime) {
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
	public SalaryProjectUnit setVersion(Integer version) {
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
	public SalaryProjectUnit setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryProjectUnit , 转换好的 SalaryProjectUnit 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryProjectUnit , 转换好的 PoJo 对象
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
	public SalaryProjectUnit clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryProjectUnit duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryProjectUnitMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryProjectUnitMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setMoney(this.getMoney());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryProjectUnit clone(boolean deep) {
		return EntityContext.clone(SalaryProjectUnit.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryProjectUnit
	 * @param salaryProjectUnitMap 包含实体信息的 Map 对象
	 * @return SalaryProjectUnit , 转换好的的 SalaryProjectUnit 对象
	*/
	@Transient
	public static SalaryProjectUnit createFrom(Map<String,Object> salaryProjectUnitMap) {
		if(salaryProjectUnitMap==null) return null;
		SalaryProjectUnit po = create();
		EntityContext.copyProperties(po,salaryProjectUnitMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryProjectUnit
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryProjectUnit , 转换好的的 SalaryProjectUnit 对象
	*/
	@Transient
	public static SalaryProjectUnit createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryProjectUnit po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryProjectUnit，等同于 new
	 * @return SalaryProjectUnit 对象
	*/
	@Transient
	public static SalaryProjectUnit create() {
		return new com.dt.platform.domain.hr.meta.SalaryProjectUnitMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryProjectUnitMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryProjectUnitMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryProjectUnitMeta.DELETED)));
			this.setMoney(DataParser.parse(BigDecimal.class, map.get(SalaryProjectUnitMeta.MONEY)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryProjectUnitMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryProjectUnitMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryProjectUnitMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(SalaryProjectUnitMeta.CODE));
				this.setNotes( (String)map.get(SalaryProjectUnitMeta.NOTES));
				this.setUpdateTime( (Date)map.get(SalaryProjectUnitMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(SalaryProjectUnitMeta.VERSION));
				this.setCreateBy( (String)map.get(SalaryProjectUnitMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryProjectUnitMeta.DELETED));
				this.setMoney( (BigDecimal)map.get(SalaryProjectUnitMeta.MONEY));
				this.setCreateTime( (Date)map.get(SalaryProjectUnitMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryProjectUnitMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryProjectUnitMeta.DELETE_TIME));
				this.setName( (String)map.get(SalaryProjectUnitMeta.NAME));
				this.setTenantId( (String)map.get(SalaryProjectUnitMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryProjectUnitMeta.DELETE_BY));
				this.setId( (String)map.get(SalaryProjectUnitMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryProjectUnitMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryProjectUnitMeta.DELETED)));
			this.setMoney(DataParser.parse(BigDecimal.class, r.getValue(SalaryProjectUnitMeta.MONEY)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryProjectUnitMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryProjectUnitMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(SalaryProjectUnitMeta.CODE));
				this.setNotes( (String)r.getValue(SalaryProjectUnitMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(SalaryProjectUnitMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(SalaryProjectUnitMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SalaryProjectUnitMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryProjectUnitMeta.DELETED));
				this.setMoney( (BigDecimal)r.getValue(SalaryProjectUnitMeta.MONEY));
				this.setCreateTime( (Date)r.getValue(SalaryProjectUnitMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryProjectUnitMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryProjectUnitMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SalaryProjectUnitMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryProjectUnitMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryProjectUnitMeta.DELETE_BY));
				this.setId( (String)r.getValue(SalaryProjectUnitMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}