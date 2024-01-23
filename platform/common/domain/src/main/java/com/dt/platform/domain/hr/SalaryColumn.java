package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_COLUMN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.SalaryColumnMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬字段
 * <p>薪酬字段 , 数据表 hr_salary_column 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 14:09:25
 * @sign 8CFBCCD665B72F40068AFA492AB44F3A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_column")
@ApiModel(description = "薪酬字段 ; 薪酬字段 , 数据表 hr_salary_column 的PO类型")
public class SalaryColumn extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_COLUMN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 字段：字段
	*/
	@ApiModelProperty(required = false,value="字段" , notes = "字段")
	private String colCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String colName;
	
	/**
	 * 类型：实体,表字段,常量
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "实体,表字段,常量")
	private String colType;
	
	/**
	 * 数据来源：数据来源
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "数据来源")
	private String dsSource;
	
	/**
	 * 计算方式：计算方式
	*/
	@ApiModelProperty(required = false,value="计算方式" , notes = "计算方式")
	private String calMethod;
	
	/**
	 * 业务分类：业务分类
	*/
	@ApiModelProperty(required = false,value="业务分类" , notes = "业务分类")
	private String busiType;
	
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
	public SalaryColumn setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 字段<br>
	 * 字段
	 * @return 字段
	*/
	public String getColCode() {
		return colCode;
	}
	
	/**
	 * 设置 字段
	 * @param colCode 字段
	 * @return 当前对象
	*/
	public SalaryColumn setColCode(String colCode) {
		this.colCode=colCode;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getColName() {
		return colName;
	}
	
	/**
	 * 设置 名称
	 * @param colName 名称
	 * @return 当前对象
	*/
	public SalaryColumn setColName(String colName) {
		this.colName=colName;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 实体,表字段,常量
	 * @return 类型
	*/
	public String getColType() {
		return colType;
	}
	
	/**
	 * 设置 类型
	 * @param colType 类型
	 * @return 当前对象
	*/
	public SalaryColumn setColType(String colType) {
		this.colType=colType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 数据来源
	 * @return 数据来源
	*/
	public String getDsSource() {
		return dsSource;
	}
	
	/**
	 * 设置 数据来源
	 * @param dsSource 数据来源
	 * @return 当前对象
	*/
	public SalaryColumn setDsSource(String dsSource) {
		this.dsSource=dsSource;
		return this;
	}
	
	/**
	 * 获得 计算方式<br>
	 * 计算方式
	 * @return 计算方式
	*/
	public String getCalMethod() {
		return calMethod;
	}
	
	/**
	 * 设置 计算方式
	 * @param calMethod 计算方式
	 * @return 当前对象
	*/
	public SalaryColumn setCalMethod(String calMethod) {
		this.calMethod=calMethod;
		return this;
	}
	
	/**
	 * 获得 业务分类<br>
	 * 业务分类
	 * @return 业务分类
	*/
	public String getBusiType() {
		return busiType;
	}
	
	/**
	 * 设置 业务分类
	 * @param busiType 业务分类
	 * @return 当前对象
	*/
	public SalaryColumn setBusiType(String busiType) {
		this.busiType=busiType;
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
	public SalaryColumn setNotes(String notes) {
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
	public SalaryColumn setCreateBy(String createBy) {
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
	public SalaryColumn setCreateTime(Date createTime) {
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
	public SalaryColumn setUpdateBy(String updateBy) {
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
	public SalaryColumn setUpdateTime(Date updateTime) {
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
	public SalaryColumn setDeleted(Integer deleted) {
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
	public SalaryColumn setDeleted(Boolean deletedBool) {
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
	public SalaryColumn setDeleteBy(String deleteBy) {
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
	public SalaryColumn setDeleteTime(Date deleteTime) {
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
	public SalaryColumn setVersion(Integer version) {
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
	public SalaryColumn setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryColumn , 转换好的 SalaryColumn 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryColumn , 转换好的 PoJo 对象
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
	public SalaryColumn clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryColumn duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryColumnMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryColumnMeta.$$proxy$$();
		inst.setColName(this.getColName());
		inst.setNotes(this.getNotes());
		inst.setColCode(this.getColCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setColType(this.getColType());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setBusiType(this.getBusiType());
		inst.setId(this.getId());
		inst.setCalMethod(this.getCalMethod());
		inst.setDsSource(this.getDsSource());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryColumn clone(boolean deep) {
		return EntityContext.clone(SalaryColumn.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryColumn
	 * @param salaryColumnMap 包含实体信息的 Map 对象
	 * @return SalaryColumn , 转换好的的 SalaryColumn 对象
	*/
	@Transient
	public static SalaryColumn createFrom(Map<String,Object> salaryColumnMap) {
		if(salaryColumnMap==null) return null;
		SalaryColumn po = create();
		EntityContext.copyProperties(po,salaryColumnMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryColumn
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryColumn , 转换好的的 SalaryColumn 对象
	*/
	@Transient
	public static SalaryColumn createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryColumn po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryColumn，等同于 new
	 * @return SalaryColumn 对象
	*/
	@Transient
	public static SalaryColumn create() {
		return new com.dt.platform.domain.hr.meta.SalaryColumnMeta.$$proxy$$();
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
			this.setColName(DataParser.parse(String.class, map.get(SalaryColumnMeta.COL_NAME)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryColumnMeta.NOTES)));
			this.setColCode(DataParser.parse(String.class, map.get(SalaryColumnMeta.COL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryColumnMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryColumnMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryColumnMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryColumnMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryColumnMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryColumnMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryColumnMeta.DELETE_TIME)));
			this.setColType(DataParser.parse(String.class, map.get(SalaryColumnMeta.COL_TYPE)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryColumnMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryColumnMeta.DELETE_BY)));
			this.setBusiType(DataParser.parse(String.class, map.get(SalaryColumnMeta.BUSI_TYPE)));
			this.setId(DataParser.parse(String.class, map.get(SalaryColumnMeta.ID)));
			this.setCalMethod(DataParser.parse(String.class, map.get(SalaryColumnMeta.CAL_METHOD)));
			this.setDsSource(DataParser.parse(String.class, map.get(SalaryColumnMeta.DS_SOURCE)));
			// others
			return true;
		} else {
			try {
				this.setColName( (String)map.get(SalaryColumnMeta.COL_NAME));
				this.setNotes( (String)map.get(SalaryColumnMeta.NOTES));
				this.setColCode( (String)map.get(SalaryColumnMeta.COL_CODE));
				this.setUpdateTime( (Date)map.get(SalaryColumnMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(SalaryColumnMeta.VERSION));
				this.setCreateBy( (String)map.get(SalaryColumnMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryColumnMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryColumnMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryColumnMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryColumnMeta.DELETE_TIME));
				this.setColType( (String)map.get(SalaryColumnMeta.COL_TYPE));
				this.setTenantId( (String)map.get(SalaryColumnMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryColumnMeta.DELETE_BY));
				this.setBusiType( (String)map.get(SalaryColumnMeta.BUSI_TYPE));
				this.setId( (String)map.get(SalaryColumnMeta.ID));
				this.setCalMethod( (String)map.get(SalaryColumnMeta.CAL_METHOD));
				this.setDsSource( (String)map.get(SalaryColumnMeta.DS_SOURCE));
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
			this.setColName(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.COL_NAME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.NOTES)));
			this.setColCode(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.COL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryColumnMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryColumnMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryColumnMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryColumnMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryColumnMeta.DELETE_TIME)));
			this.setColType(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.COL_TYPE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.DELETE_BY)));
			this.setBusiType(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.BUSI_TYPE)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.ID)));
			this.setCalMethod(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.CAL_METHOD)));
			this.setDsSource(DataParser.parse(String.class, r.getValue(SalaryColumnMeta.DS_SOURCE)));
			return true;
		} else {
			try {
				this.setColName( (String)r.getValue(SalaryColumnMeta.COL_NAME));
				this.setNotes( (String)r.getValue(SalaryColumnMeta.NOTES));
				this.setColCode( (String)r.getValue(SalaryColumnMeta.COL_CODE));
				this.setUpdateTime( (Date)r.getValue(SalaryColumnMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(SalaryColumnMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SalaryColumnMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryColumnMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryColumnMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryColumnMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryColumnMeta.DELETE_TIME));
				this.setColType( (String)r.getValue(SalaryColumnMeta.COL_TYPE));
				this.setTenantId( (String)r.getValue(SalaryColumnMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryColumnMeta.DELETE_BY));
				this.setBusiType( (String)r.getValue(SalaryColumnMeta.BUSI_TYPE));
				this.setId( (String)r.getValue(SalaryColumnMeta.ID));
				this.setCalMethod( (String)r.getValue(SalaryColumnMeta.CAL_METHOD));
				this.setDsSource( (String)r.getValue(SalaryColumnMeta.DS_SOURCE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}