package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_BUSI_INSURE_TYPE;
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
import com.dt.platform.domain.hr.meta.PersonBusiInsureTypeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 商业保险类别
 * <p>商业保险类别 , 数据表 hr_person_busi_insure_type 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-06 13:12:19
 * @sign 35C165553AFF44AAFE426E32A5589131
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_busi_insure_type")
@ApiModel(description = "商业保险类别 ; 商业保险类别 , 数据表 hr_person_busi_insure_type 的PO类型")
public class PersonBusiInsureType extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_BUSI_INSURE_TYPE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "807203493323472896")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "类别A")
	private String name;
	
	/**
	 * 保险周期：保险周期
	*/
	@ApiModelProperty(required = false,value="保险周期" , notes = "保险周期" , example = "12.00")
	private BigDecimal recycle;
	
	/**
	 * 保险金额：保险金额
	*/
	@ApiModelProperty(required = false,value="保险金额" , notes = "保险金额" , example = "2000.00")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-06 10:58:30")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-06 10:58:43")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
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
	public PersonBusiInsureType setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public PersonBusiInsureType setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public PersonBusiInsureType setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 保险周期<br>
	 * 保险周期
	 * @return 保险周期
	*/
	public BigDecimal getRecycle() {
		return recycle;
	}
	
	/**
	 * 设置 保险周期
	 * @param recycle 保险周期
	 * @return 当前对象
	*/
	public PersonBusiInsureType setRecycle(BigDecimal recycle) {
		this.recycle=recycle;
		return this;
	}
	
	/**
	 * 获得 保险金额<br>
	 * 保险金额
	 * @return 保险金额
	*/
	public BigDecimal getMoney() {
		return money;
	}
	
	/**
	 * 设置 保险金额
	 * @param money 保险金额
	 * @return 当前对象
	*/
	public PersonBusiInsureType setMoney(BigDecimal money) {
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
	public PersonBusiInsureType setNotes(String notes) {
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
	public PersonBusiInsureType setCreateBy(String createBy) {
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
	public PersonBusiInsureType setCreateTime(Date createTime) {
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
	public PersonBusiInsureType setUpdateBy(String updateBy) {
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
	public PersonBusiInsureType setUpdateTime(Date updateTime) {
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
	public PersonBusiInsureType setDeleted(Integer deleted) {
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
	public PersonBusiInsureType setDeleted(Boolean deletedBool) {
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
	public PersonBusiInsureType setDeleteBy(String deleteBy) {
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
	public PersonBusiInsureType setDeleteTime(Date deleteTime) {
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
	public PersonBusiInsureType setVersion(Integer version) {
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
	public PersonBusiInsureType setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonBusiInsureType , 转换好的 PersonBusiInsureType 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonBusiInsureType , 转换好的 PoJo 对象
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
	public PersonBusiInsureType clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonBusiInsureType duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonBusiInsureTypeMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonBusiInsureTypeMeta.$$proxy$$();
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
		inst.setRecycle(this.getRecycle());
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
	public PersonBusiInsureType clone(boolean deep) {
		return EntityContext.clone(PersonBusiInsureType.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonBusiInsureType
	 * @param personBusiInsureTypeMap 包含实体信息的 Map 对象
	 * @return PersonBusiInsureType , 转换好的的 PersonBusiInsureType 对象
	*/
	@Transient
	public static PersonBusiInsureType createFrom(Map<String,Object> personBusiInsureTypeMap) {
		if(personBusiInsureTypeMap==null) return null;
		PersonBusiInsureType po = create();
		EntityContext.copyProperties(po,personBusiInsureTypeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonBusiInsureType
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonBusiInsureType , 转换好的的 PersonBusiInsureType 对象
	*/
	@Transient
	public static PersonBusiInsureType createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonBusiInsureType po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonBusiInsureType，等同于 new
	 * @return PersonBusiInsureType 对象
	*/
	@Transient
	public static PersonBusiInsureType create() {
		return new com.dt.platform.domain.hr.meta.PersonBusiInsureTypeMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonBusiInsureTypeMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonBusiInsureTypeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonBusiInsureTypeMeta.DELETED)));
			this.setMoney(DataParser.parse(BigDecimal.class, map.get(PersonBusiInsureTypeMeta.MONEY)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonBusiInsureTypeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonBusiInsureTypeMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.NAME)));
			this.setRecycle(DataParser.parse(BigDecimal.class, map.get(PersonBusiInsureTypeMeta.RECYCLE)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonBusiInsureTypeMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(PersonBusiInsureTypeMeta.CODE));
				this.setNotes( (String)map.get(PersonBusiInsureTypeMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PersonBusiInsureTypeMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonBusiInsureTypeMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonBusiInsureTypeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonBusiInsureTypeMeta.DELETED));
				this.setMoney( (BigDecimal)map.get(PersonBusiInsureTypeMeta.MONEY));
				this.setCreateTime( (Date)map.get(PersonBusiInsureTypeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonBusiInsureTypeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonBusiInsureTypeMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonBusiInsureTypeMeta.NAME));
				this.setRecycle( (BigDecimal)map.get(PersonBusiInsureTypeMeta.RECYCLE));
				this.setTenantId( (String)map.get(PersonBusiInsureTypeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonBusiInsureTypeMeta.DELETE_BY));
				this.setId( (String)map.get(PersonBusiInsureTypeMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureTypeMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonBusiInsureTypeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonBusiInsureTypeMeta.DELETED)));
			this.setMoney(DataParser.parse(BigDecimal.class, r.getValue(PersonBusiInsureTypeMeta.MONEY)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureTypeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureTypeMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.NAME)));
			this.setRecycle(DataParser.parse(BigDecimal.class, r.getValue(PersonBusiInsureTypeMeta.RECYCLE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonBusiInsureTypeMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(PersonBusiInsureTypeMeta.CODE));
				this.setNotes( (String)r.getValue(PersonBusiInsureTypeMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PersonBusiInsureTypeMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonBusiInsureTypeMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonBusiInsureTypeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonBusiInsureTypeMeta.DELETED));
				this.setMoney( (BigDecimal)r.getValue(PersonBusiInsureTypeMeta.MONEY));
				this.setCreateTime( (Date)r.getValue(PersonBusiInsureTypeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonBusiInsureTypeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonBusiInsureTypeMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonBusiInsureTypeMeta.NAME));
				this.setRecycle( (BigDecimal)r.getValue(PersonBusiInsureTypeMeta.RECYCLE));
				this.setTenantId( (String)r.getValue(PersonBusiInsureTypeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonBusiInsureTypeMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonBusiInsureTypeMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}