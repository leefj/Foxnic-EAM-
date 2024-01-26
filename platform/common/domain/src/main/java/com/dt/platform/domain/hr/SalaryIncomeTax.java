package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_INCOME_TAX;
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
import com.dt.platform.domain.hr.meta.SalaryIncomeTaxMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 所得税设置
 * <p>所得税设置 , 数据表 hr_salary_income_tax 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 07:40:19
 * @sign E87EBF703B853EFE2C62468CF035599F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_income_tax")
@ApiModel(description = "所得税设置 ; 所得税设置 , 数据表 hr_salary_income_tax 的PO类型")
public class SalaryIncomeTax extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_INCOME_TAX.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 级别：级别
	*/
	@ApiModelProperty(required = false,value="级别" , notes = "级别")
	private String valueLevel;
	
	/**
	 * 起始金额：起始金额
	*/
	@ApiModelProperty(required = false,value="起始金额" , notes = "起始金额")
	private BigDecimal start;
	
	/**
	 * 结束金额：结束金额
	*/
	@ApiModelProperty(required = false,value="结束金额" , notes = "结束金额")
	private BigDecimal end;
	
	/**
	 * 税率：税率
	*/
	@ApiModelProperty(required = false,value="税率" , notes = "税率")
	private BigDecimal tax;
	
	/**
	 * 速扣：速扣
	*/
	@ApiModelProperty(required = false,value="速扣" , notes = "速扣")
	private BigDecimal quickDeduct;
	
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
	public SalaryIncomeTax setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 级别<br>
	 * 级别
	 * @return 级别
	*/
	public String getValueLevel() {
		return valueLevel;
	}
	
	/**
	 * 设置 级别
	 * @param valueLevel 级别
	 * @return 当前对象
	*/
	public SalaryIncomeTax setValueLevel(String valueLevel) {
		this.valueLevel=valueLevel;
		return this;
	}
	
	/**
	 * 获得 起始金额<br>
	 * 起始金额
	 * @return 起始金额
	*/
	public BigDecimal getStart() {
		return start;
	}
	
	/**
	 * 设置 起始金额
	 * @param start 起始金额
	 * @return 当前对象
	*/
	public SalaryIncomeTax setStart(BigDecimal start) {
		this.start=start;
		return this;
	}
	
	/**
	 * 获得 结束金额<br>
	 * 结束金额
	 * @return 结束金额
	*/
	public BigDecimal getEnd() {
		return end;
	}
	
	/**
	 * 设置 结束金额
	 * @param end 结束金额
	 * @return 当前对象
	*/
	public SalaryIncomeTax setEnd(BigDecimal end) {
		this.end=end;
		return this;
	}
	
	/**
	 * 获得 税率<br>
	 * 税率
	 * @return 税率
	*/
	public BigDecimal getTax() {
		return tax;
	}
	
	/**
	 * 设置 税率
	 * @param tax 税率
	 * @return 当前对象
	*/
	public SalaryIncomeTax setTax(BigDecimal tax) {
		this.tax=tax;
		return this;
	}
	
	/**
	 * 获得 速扣<br>
	 * 速扣
	 * @return 速扣
	*/
	public BigDecimal getQuickDeduct() {
		return quickDeduct;
	}
	
	/**
	 * 设置 速扣
	 * @param quickDeduct 速扣
	 * @return 当前对象
	*/
	public SalaryIncomeTax setQuickDeduct(BigDecimal quickDeduct) {
		this.quickDeduct=quickDeduct;
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
	public SalaryIncomeTax setNotes(String notes) {
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
	public SalaryIncomeTax setCreateBy(String createBy) {
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
	public SalaryIncomeTax setCreateTime(Date createTime) {
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
	public SalaryIncomeTax setUpdateBy(String updateBy) {
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
	public SalaryIncomeTax setUpdateTime(Date updateTime) {
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
	public SalaryIncomeTax setDeleted(Integer deleted) {
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
	public SalaryIncomeTax setDeleted(Boolean deletedBool) {
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
	public SalaryIncomeTax setDeleteBy(String deleteBy) {
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
	public SalaryIncomeTax setDeleteTime(Date deleteTime) {
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
	public SalaryIncomeTax setVersion(Integer version) {
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
	public SalaryIncomeTax setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryIncomeTax , 转换好的 SalaryIncomeTax 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryIncomeTax , 转换好的 PoJo 对象
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
	public SalaryIncomeTax clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryIncomeTax duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryIncomeTaxMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryIncomeTaxMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setStart(this.getStart());
		inst.setTax(this.getTax());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setValueLevel(this.getValueLevel());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setEnd(this.getEnd());
		inst.setId(this.getId());
		inst.setQuickDeduct(this.getQuickDeduct());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryIncomeTax clone(boolean deep) {
		return EntityContext.clone(SalaryIncomeTax.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryIncomeTax
	 * @param salaryIncomeTaxMap 包含实体信息的 Map 对象
	 * @return SalaryIncomeTax , 转换好的的 SalaryIncomeTax 对象
	*/
	@Transient
	public static SalaryIncomeTax createFrom(Map<String,Object> salaryIncomeTaxMap) {
		if(salaryIncomeTaxMap==null) return null;
		SalaryIncomeTax po = create();
		EntityContext.copyProperties(po,salaryIncomeTaxMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryIncomeTax
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryIncomeTax , 转换好的的 SalaryIncomeTax 对象
	*/
	@Transient
	public static SalaryIncomeTax createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryIncomeTax po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryIncomeTax，等同于 new
	 * @return SalaryIncomeTax 对象
	*/
	@Transient
	public static SalaryIncomeTax create() {
		return new com.dt.platform.domain.hr.meta.SalaryIncomeTaxMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.NOTES)));
			this.setStart(DataParser.parse(BigDecimal.class, map.get(SalaryIncomeTaxMeta.START)));
			this.setTax(DataParser.parse(BigDecimal.class, map.get(SalaryIncomeTaxMeta.TAX)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryIncomeTaxMeta.UPDATE_TIME)));
			this.setValueLevel(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.VALUE_LEVEL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryIncomeTaxMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryIncomeTaxMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryIncomeTaxMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryIncomeTaxMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.DELETE_BY)));
			this.setEnd(DataParser.parse(BigDecimal.class, map.get(SalaryIncomeTaxMeta.END)));
			this.setId(DataParser.parse(String.class, map.get(SalaryIncomeTaxMeta.ID)));
			this.setQuickDeduct(DataParser.parse(BigDecimal.class, map.get(SalaryIncomeTaxMeta.QUICK_DEDUCT)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SalaryIncomeTaxMeta.NOTES));
				this.setStart( (BigDecimal)map.get(SalaryIncomeTaxMeta.START));
				this.setTax( (BigDecimal)map.get(SalaryIncomeTaxMeta.TAX));
				this.setUpdateTime( (Date)map.get(SalaryIncomeTaxMeta.UPDATE_TIME));
				this.setValueLevel( (String)map.get(SalaryIncomeTaxMeta.VALUE_LEVEL));
				this.setVersion( (Integer)map.get(SalaryIncomeTaxMeta.VERSION));
				this.setCreateBy( (String)map.get(SalaryIncomeTaxMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryIncomeTaxMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryIncomeTaxMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryIncomeTaxMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryIncomeTaxMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(SalaryIncomeTaxMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryIncomeTaxMeta.DELETE_BY));
				this.setEnd( (BigDecimal)map.get(SalaryIncomeTaxMeta.END));
				this.setId( (String)map.get(SalaryIncomeTaxMeta.ID));
				this.setQuickDeduct( (BigDecimal)map.get(SalaryIncomeTaxMeta.QUICK_DEDUCT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.NOTES)));
			this.setStart(DataParser.parse(BigDecimal.class, r.getValue(SalaryIncomeTaxMeta.START)));
			this.setTax(DataParser.parse(BigDecimal.class, r.getValue(SalaryIncomeTaxMeta.TAX)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryIncomeTaxMeta.UPDATE_TIME)));
			this.setValueLevel(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.VALUE_LEVEL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryIncomeTaxMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryIncomeTaxMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryIncomeTaxMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryIncomeTaxMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.DELETE_BY)));
			this.setEnd(DataParser.parse(BigDecimal.class, r.getValue(SalaryIncomeTaxMeta.END)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryIncomeTaxMeta.ID)));
			this.setQuickDeduct(DataParser.parse(BigDecimal.class, r.getValue(SalaryIncomeTaxMeta.QUICK_DEDUCT)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SalaryIncomeTaxMeta.NOTES));
				this.setStart( (BigDecimal)r.getValue(SalaryIncomeTaxMeta.START));
				this.setTax( (BigDecimal)r.getValue(SalaryIncomeTaxMeta.TAX));
				this.setUpdateTime( (Date)r.getValue(SalaryIncomeTaxMeta.UPDATE_TIME));
				this.setValueLevel( (String)r.getValue(SalaryIncomeTaxMeta.VALUE_LEVEL));
				this.setVersion( (Integer)r.getValue(SalaryIncomeTaxMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SalaryIncomeTaxMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryIncomeTaxMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryIncomeTaxMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryIncomeTaxMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryIncomeTaxMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(SalaryIncomeTaxMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryIncomeTaxMeta.DELETE_BY));
				this.setEnd( (BigDecimal)r.getValue(SalaryIncomeTaxMeta.END));
				this.setId( (String)r.getValue(SalaryIncomeTaxMeta.ID));
				this.setQuickDeduct( (BigDecimal)r.getValue(SalaryIncomeTaxMeta.QUICK_DEDUCT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}