package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_CTL;
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
import com.dt.platform.domain.hr.meta.SalaryCtlMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬控制
 * <p>薪酬控制 , 数据表 hr_salary_ctl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 10:15:33
 * @sign 4AD2424713E187366348D5C611373103
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_ctl")
@ApiModel(description = "薪酬控制 ; 薪酬控制 , 数据表 hr_salary_ctl 的PO类型")
public class SalaryCtl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_CTL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "high_temperature_salary")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "high_temperature_salary")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "高温补贴月份")
	private String name;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "type_str")
	private String type;
	
	/**
	 * 是否参与：是否参与
	*/
	@ApiModelProperty(required = false,value="是否参与" , notes = "是否参与" , example = "1")
	private String valueEn;
	
	/**
	 * 字符串数值：字符串数值
	*/
	@ApiModelProperty(required = false,value="字符串数值" , notes = "字符串数值" , example = "[\"07\",\"08\",\"09\"]")
	private String valueStr;
	
	/**
	 * 浮点数值：浮点数值
	*/
	@ApiModelProperty(required = false,value="浮点数值" , notes = "浮点数值" , example = "0.00")
	private BigDecimal valueD;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-06-05 10:12:36")
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
	public SalaryCtl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编号
	 * @param code 编号
	 * @return 当前对象
	*/
	public SalaryCtl setCode(String code) {
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
	public SalaryCtl setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public SalaryCtl setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 是否参与<br>
	 * 是否参与
	 * @return 是否参与
	*/
	public String getValueEn() {
		return valueEn;
	}
	
	/**
	 * 设置 是否参与
	 * @param valueEn 是否参与
	 * @return 当前对象
	*/
	public SalaryCtl setValueEn(String valueEn) {
		this.valueEn=valueEn;
		return this;
	}
	
	/**
	 * 获得 字符串数值<br>
	 * 字符串数值
	 * @return 字符串数值
	*/
	public String getValueStr() {
		return valueStr;
	}
	
	/**
	 * 设置 字符串数值
	 * @param valueStr 字符串数值
	 * @return 当前对象
	*/
	public SalaryCtl setValueStr(String valueStr) {
		this.valueStr=valueStr;
		return this;
	}
	
	/**
	 * 获得 浮点数值<br>
	 * 浮点数值
	 * @return 浮点数值
	*/
	public BigDecimal getValueD() {
		return valueD;
	}
	
	/**
	 * 设置 浮点数值
	 * @param valueD 浮点数值
	 * @return 当前对象
	*/
	public SalaryCtl setValueD(BigDecimal valueD) {
		this.valueD=valueD;
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
	public SalaryCtl setNotes(String notes) {
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
	public SalaryCtl setCreateBy(String createBy) {
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
	public SalaryCtl setCreateTime(Date createTime) {
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
	public SalaryCtl setUpdateBy(String updateBy) {
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
	public SalaryCtl setUpdateTime(Date updateTime) {
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
	public SalaryCtl setDeleted(Integer deleted) {
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
	public SalaryCtl setDeleted(Boolean deletedBool) {
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
	public SalaryCtl setDeleteBy(String deleteBy) {
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
	public SalaryCtl setDeleteTime(Date deleteTime) {
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
	public SalaryCtl setVersion(Integer version) {
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
	public SalaryCtl setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryCtl , 转换好的 SalaryCtl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryCtl , 转换好的 PoJo 对象
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
	public SalaryCtl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryCtl duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryCtlMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryCtlMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setValueStr(this.getValueStr());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setValueEn(this.getValueEn());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setValueD(this.getValueD());
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
	public SalaryCtl clone(boolean deep) {
		return EntityContext.clone(SalaryCtl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryCtl
	 * @param salaryCtlMap 包含实体信息的 Map 对象
	 * @return SalaryCtl , 转换好的的 SalaryCtl 对象
	*/
	@Transient
	public static SalaryCtl createFrom(Map<String,Object> salaryCtlMap) {
		if(salaryCtlMap==null) return null;
		SalaryCtl po = create();
		EntityContext.copyProperties(po,salaryCtlMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryCtl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryCtl , 转换好的的 SalaryCtl 对象
	*/
	@Transient
	public static SalaryCtl createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryCtl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryCtl，等同于 new
	 * @return SalaryCtl 对象
	*/
	@Transient
	public static SalaryCtl create() {
		return new com.dt.platform.domain.hr.meta.SalaryCtlMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(SalaryCtlMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryCtlMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryCtlMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(SalaryCtlMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryCtlMeta.VERSION)));
			this.setValueStr(DataParser.parse(String.class, map.get(SalaryCtlMeta.VALUE_STR)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryCtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryCtlMeta.DELETED)));
			this.setValueEn(DataParser.parse(String.class, map.get(SalaryCtlMeta.VALUE_EN)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryCtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryCtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryCtlMeta.DELETE_TIME)));
			this.setValueD(DataParser.parse(BigDecimal.class, map.get(SalaryCtlMeta.VALUE_D)));
			this.setName(DataParser.parse(String.class, map.get(SalaryCtlMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryCtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryCtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryCtlMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(SalaryCtlMeta.CODE));
				this.setNotes( (String)map.get(SalaryCtlMeta.NOTES));
				this.setUpdateTime( (Date)map.get(SalaryCtlMeta.UPDATE_TIME));
				this.setType( (String)map.get(SalaryCtlMeta.TYPE));
				this.setVersion( (Integer)map.get(SalaryCtlMeta.VERSION));
				this.setValueStr( (String)map.get(SalaryCtlMeta.VALUE_STR));
				this.setCreateBy( (String)map.get(SalaryCtlMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryCtlMeta.DELETED));
				this.setValueEn( (String)map.get(SalaryCtlMeta.VALUE_EN));
				this.setCreateTime( (Date)map.get(SalaryCtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryCtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryCtlMeta.DELETE_TIME));
				this.setValueD( (BigDecimal)map.get(SalaryCtlMeta.VALUE_D));
				this.setName( (String)map.get(SalaryCtlMeta.NAME));
				this.setTenantId( (String)map.get(SalaryCtlMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryCtlMeta.DELETE_BY));
				this.setId( (String)map.get(SalaryCtlMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryCtlMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryCtlMeta.VERSION)));
			this.setValueStr(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.VALUE_STR)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryCtlMeta.DELETED)));
			this.setValueEn(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.VALUE_EN)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryCtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryCtlMeta.DELETE_TIME)));
			this.setValueD(DataParser.parse(BigDecimal.class, r.getValue(SalaryCtlMeta.VALUE_D)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryCtlMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(SalaryCtlMeta.CODE));
				this.setNotes( (String)r.getValue(SalaryCtlMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(SalaryCtlMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(SalaryCtlMeta.TYPE));
				this.setVersion( (Integer)r.getValue(SalaryCtlMeta.VERSION));
				this.setValueStr( (String)r.getValue(SalaryCtlMeta.VALUE_STR));
				this.setCreateBy( (String)r.getValue(SalaryCtlMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryCtlMeta.DELETED));
				this.setValueEn( (String)r.getValue(SalaryCtlMeta.VALUE_EN));
				this.setCreateTime( (Date)r.getValue(SalaryCtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryCtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryCtlMeta.DELETE_TIME));
				this.setValueD( (BigDecimal)r.getValue(SalaryCtlMeta.VALUE_D));
				this.setName( (String)r.getValue(SalaryCtlMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryCtlMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryCtlMeta.DELETE_BY));
				this.setId( (String)r.getValue(SalaryCtlMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}