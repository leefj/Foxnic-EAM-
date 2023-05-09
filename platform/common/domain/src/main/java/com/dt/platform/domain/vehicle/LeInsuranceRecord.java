package com.dt.platform.domain.vehicle;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_VEHICLE_INSURANCE_RECORD;
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
import com.dt.platform.domain.vehicle.meta.LeInsuranceRecordMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆保险记录
 * <p>车辆保险记录 , 数据表 oa_vehicle_insurance_record 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:49:00
 * @sign BDDA194730226FC43041E1BCCF455590
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_vehicle_insurance_record")
@ApiModel(description = "车辆保险记录 ; 车辆保险记录 , 数据表 oa_vehicle_insurance_record 的PO类型")
public class LeInsuranceRecord extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_VEHICLE_INSURANCE_RECORD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 保险公司：保险公司
	*/
	@ApiModelProperty(required = false,value="保险公司" , notes = "保险公司")
	private String companyId;
	
	/**
	 * 保险公司：保险公司
	*/
	@ApiModelProperty(required = false,value="保险公司" , notes = "保险公司")
	private String companyName;
	
	/**
	 * 保险类型：保险类型
	*/
	@ApiModelProperty(required = false,value="保险类型" , notes = "保险类型")
	private String insuranceType;
	
	/**
	 * 费用：费用
	*/
	@ApiModelProperty(required = false,value="费用" , notes = "费用")
	private BigDecimal cost;
	
	/**
	 * 处理人：处理人
	*/
	@ApiModelProperty(required = false,value="处理人" , notes = "处理人")
	private String handlerName;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String handlerContact;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
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
	public LeInsuranceRecord setId(String id) {
		this.id=id;
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
	public LeInsuranceRecord setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 保险公司<br>
	 * 保险公司
	 * @return 保险公司
	*/
	public String getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 保险公司
	 * @param companyId 保险公司
	 * @return 当前对象
	*/
	public LeInsuranceRecord setCompanyId(String companyId) {
		this.companyId=companyId;
		return this;
	}
	
	/**
	 * 获得 保险公司<br>
	 * 保险公司
	 * @return 保险公司
	*/
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * 设置 保险公司
	 * @param companyName 保险公司
	 * @return 当前对象
	*/
	public LeInsuranceRecord setCompanyName(String companyName) {
		this.companyName=companyName;
		return this;
	}
	
	/**
	 * 获得 保险类型<br>
	 * 保险类型
	 * @return 保险类型
	*/
	public String getInsuranceType() {
		return insuranceType;
	}
	
	/**
	 * 设置 保险类型
	 * @param insuranceType 保险类型
	 * @return 当前对象
	*/
	public LeInsuranceRecord setInsuranceType(String insuranceType) {
		this.insuranceType=insuranceType;
		return this;
	}
	
	/**
	 * 获得 费用<br>
	 * 费用
	 * @return 费用
	*/
	public BigDecimal getCost() {
		return cost;
	}
	
	/**
	 * 设置 费用
	 * @param cost 费用
	 * @return 当前对象
	*/
	public LeInsuranceRecord setCost(BigDecimal cost) {
		this.cost=cost;
		return this;
	}
	
	/**
	 * 获得 处理人<br>
	 * 处理人
	 * @return 处理人
	*/
	public String getHandlerName() {
		return handlerName;
	}
	
	/**
	 * 设置 处理人
	 * @param handlerName 处理人
	 * @return 当前对象
	*/
	public LeInsuranceRecord setHandlerName(String handlerName) {
		this.handlerName=handlerName;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getHandlerContact() {
		return handlerContact;
	}
	
	/**
	 * 设置 联系方式
	 * @param handlerContact 联系方式
	 * @return 当前对象
	*/
	public LeInsuranceRecord setHandlerContact(String handlerContact) {
		this.handlerContact=handlerContact;
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
	public LeInsuranceRecord setNotes(String notes) {
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
	public LeInsuranceRecord setCreateBy(String createBy) {
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
	public LeInsuranceRecord setCreateTime(Date createTime) {
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
	public LeInsuranceRecord setUpdateBy(String updateBy) {
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
	public LeInsuranceRecord setUpdateTime(Date updateTime) {
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
	public LeInsuranceRecord setDeleted(Integer deleted) {
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
	public LeInsuranceRecord setDeleted(Boolean deletedBool) {
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
	public LeInsuranceRecord setDeleteBy(String deleteBy) {
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
	public LeInsuranceRecord setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public LeInsuranceRecord setVersion(Integer version) {
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
	public LeInsuranceRecord setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return LeInsuranceRecord , 转换好的 LeInsuranceRecord 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return LeInsuranceRecord , 转换好的 PoJo 对象
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
	public LeInsuranceRecord clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public LeInsuranceRecord duplicate(boolean all) {
		com.dt.platform.domain.vehicle.meta.LeInsuranceRecordMeta.$$proxy$$ inst = new com.dt.platform.domain.vehicle.meta.LeInsuranceRecordMeta.$$proxy$$();
		inst.setCost(this.getCost());
		inst.setNotes(this.getNotes());
		inst.setCompanyName(this.getCompanyName());
		inst.setHandlerName(this.getHandlerName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setInsuranceType(this.getInsuranceType());
		inst.setHandlerContact(this.getHandlerContact());
		inst.setVersion(this.getVersion());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
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
	public LeInsuranceRecord clone(boolean deep) {
		return EntityContext.clone(LeInsuranceRecord.class,this,deep);
	}

	/**
	 * 将 Map 转换成 LeInsuranceRecord
	 * @param leInsuranceRecordMap 包含实体信息的 Map 对象
	 * @return LeInsuranceRecord , 转换好的的 LeInsuranceRecord 对象
	*/
	@Transient
	public static LeInsuranceRecord createFrom(Map<String,Object> leInsuranceRecordMap) {
		if(leInsuranceRecordMap==null) return null;
		LeInsuranceRecord po = create();
		EntityContext.copyProperties(po,leInsuranceRecordMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 LeInsuranceRecord
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return LeInsuranceRecord , 转换好的的 LeInsuranceRecord 对象
	*/
	@Transient
	public static LeInsuranceRecord createFrom(Object pojo) {
		if(pojo==null) return null;
		LeInsuranceRecord po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 LeInsuranceRecord，等同于 new
	 * @return LeInsuranceRecord 对象
	*/
	@Transient
	public static LeInsuranceRecord create() {
		return new com.dt.platform.domain.vehicle.meta.LeInsuranceRecordMeta.$$proxy$$();
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
			this.setCost(DataParser.parse(BigDecimal.class, map.get(LeInsuranceRecordMeta.COST)));
			this.setNotes(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.NOTES)));
			this.setCompanyName(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.COMPANY_NAME)));
			this.setHandlerName(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.HANDLER_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(LeInsuranceRecordMeta.UPDATE_TIME)));
			this.setInsuranceType(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.INSURANCE_TYPE)));
			this.setHandlerContact(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.HANDLER_CONTACT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(LeInsuranceRecordMeta.VERSION)));
			this.setCompanyId(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(LeInsuranceRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(LeInsuranceRecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(LeInsuranceRecordMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(LeInsuranceRecordMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCost( (BigDecimal)map.get(LeInsuranceRecordMeta.COST));
				this.setNotes( (String)map.get(LeInsuranceRecordMeta.NOTES));
				this.setCompanyName( (String)map.get(LeInsuranceRecordMeta.COMPANY_NAME));
				this.setHandlerName( (String)map.get(LeInsuranceRecordMeta.HANDLER_NAME));
				this.setUpdateTime( (Date)map.get(LeInsuranceRecordMeta.UPDATE_TIME));
				this.setInsuranceType( (String)map.get(LeInsuranceRecordMeta.INSURANCE_TYPE));
				this.setHandlerContact( (String)map.get(LeInsuranceRecordMeta.HANDLER_CONTACT));
				this.setVersion( (Integer)map.get(LeInsuranceRecordMeta.VERSION));
				this.setCompanyId( (String)map.get(LeInsuranceRecordMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(LeInsuranceRecordMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(LeInsuranceRecordMeta.DELETED));
				this.setCreateTime( (Date)map.get(LeInsuranceRecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(LeInsuranceRecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(LeInsuranceRecordMeta.DELETE_TIME));
				this.setName( (String)map.get(LeInsuranceRecordMeta.NAME));
				this.setTenantId( (String)map.get(LeInsuranceRecordMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(LeInsuranceRecordMeta.DELETE_BY));
				this.setId( (String)map.get(LeInsuranceRecordMeta.ID));
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
			this.setCost(DataParser.parse(BigDecimal.class, r.getValue(LeInsuranceRecordMeta.COST)));
			this.setNotes(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.NOTES)));
			this.setCompanyName(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.COMPANY_NAME)));
			this.setHandlerName(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.HANDLER_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(LeInsuranceRecordMeta.UPDATE_TIME)));
			this.setInsuranceType(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.INSURANCE_TYPE)));
			this.setHandlerContact(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.HANDLER_CONTACT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(LeInsuranceRecordMeta.VERSION)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(LeInsuranceRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(LeInsuranceRecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(LeInsuranceRecordMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(LeInsuranceRecordMeta.ID)));
			return true;
		} else {
			try {
				this.setCost( (BigDecimal)r.getValue(LeInsuranceRecordMeta.COST));
				this.setNotes( (String)r.getValue(LeInsuranceRecordMeta.NOTES));
				this.setCompanyName( (String)r.getValue(LeInsuranceRecordMeta.COMPANY_NAME));
				this.setHandlerName( (String)r.getValue(LeInsuranceRecordMeta.HANDLER_NAME));
				this.setUpdateTime( (Date)r.getValue(LeInsuranceRecordMeta.UPDATE_TIME));
				this.setInsuranceType( (String)r.getValue(LeInsuranceRecordMeta.INSURANCE_TYPE));
				this.setHandlerContact( (String)r.getValue(LeInsuranceRecordMeta.HANDLER_CONTACT));
				this.setVersion( (Integer)r.getValue(LeInsuranceRecordMeta.VERSION));
				this.setCompanyId( (String)r.getValue(LeInsuranceRecordMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(LeInsuranceRecordMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(LeInsuranceRecordMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(LeInsuranceRecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(LeInsuranceRecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(LeInsuranceRecordMeta.DELETE_TIME));
				this.setName( (String)r.getValue(LeInsuranceRecordMeta.NAME));
				this.setTenantId( (String)r.getValue(LeInsuranceRecordMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(LeInsuranceRecordMeta.DELETE_BY));
				this.setId( (String)r.getValue(LeInsuranceRecordMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}