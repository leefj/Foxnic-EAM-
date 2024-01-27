package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_TPL_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.SalaryTplItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 计算项目
 * <p>计算项目 , 数据表 hr_salary_tpl_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-27 21:03:55
 * @sign 5B7A3F4D05F16B560014A4D9F5AC5B1C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_tpl_item")
@ApiModel(description = "计算项目 ; 计算项目 , 数据表 hr_salary_tpl_item 的PO类型")
public class SalaryTplItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_TPL_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "803380200090894336")
	private String id;
	
	/**
	 * 计算顺序：计算顺序
	*/
	@ApiModelProperty(required = false,value="计算顺序" , notes = "计算顺序" , example = "10")
	private Integer sort;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版" , example = "717722780455403520")
	private String tplId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "baseSalary")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 公式：公式
	*/
	@ApiModelProperty(required = false,value="公式" , notes = "公式" , example = "salary.baseSalary")
	private String expressionValue;
	
	/**
	 * 公式：公式
	*/
	@ApiModelProperty(required = false,value="公式" , notes = "公式")
	private String expressionShow;
	
	/**
	 * 包含公式：包含公式
	*/
	@ApiModelProperty(required = false,value="包含公式" , notes = "包含公式" , example = "yes")
	private String includeExpression;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-26 09:46:06")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-01-27 11:56:11")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "5")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * salaryColumn：salaryColumn
	*/
	@ApiModelProperty(required = false,value="salaryColumn" , notes = "salaryColumn")
	private SalaryColumn salaryColumn;
	
	/**
	 * salaryColumnCode：salaryColumnCode
	*/
	@ApiModelProperty(required = false,value="salaryColumnCode" , notes = "salaryColumnCode")
	private String salaryColumnCode;
	
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
	public SalaryTplItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 计算顺序<br>
	 * 计算顺序
	 * @return 计算顺序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 计算顺序
	 * @param sort 计算顺序
	 * @return 当前对象
	*/
	public SalaryTplItem setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模版
	 * @param tplId 模版
	 * @return 当前对象
	*/
	public SalaryTplItem setTplId(String tplId) {
		this.tplId=tplId;
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
	public SalaryTplItem setCode(String code) {
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
	public SalaryTplItem setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public SalaryTplItem setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 公式<br>
	 * 公式
	 * @return 公式
	*/
	public String getExpressionValue() {
		return expressionValue;
	}
	
	/**
	 * 设置 公式
	 * @param expressionValue 公式
	 * @return 当前对象
	*/
	public SalaryTplItem setExpressionValue(String expressionValue) {
		this.expressionValue=expressionValue;
		return this;
	}
	
	/**
	 * 获得 公式<br>
	 * 公式
	 * @return 公式
	*/
	public String getExpressionShow() {
		return expressionShow;
	}
	
	/**
	 * 设置 公式
	 * @param expressionShow 公式
	 * @return 当前对象
	*/
	public SalaryTplItem setExpressionShow(String expressionShow) {
		this.expressionShow=expressionShow;
		return this;
	}
	
	/**
	 * 获得 包含公式<br>
	 * 包含公式
	 * @return 包含公式
	*/
	public String getIncludeExpression() {
		return includeExpression;
	}
	
	/**
	 * 设置 包含公式
	 * @param includeExpression 包含公式
	 * @return 当前对象
	*/
	public SalaryTplItem setIncludeExpression(String includeExpression) {
		this.includeExpression=includeExpression;
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
	public SalaryTplItem setNotes(String notes) {
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
	public SalaryTplItem setCreateBy(String createBy) {
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
	public SalaryTplItem setCreateTime(Date createTime) {
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
	public SalaryTplItem setUpdateBy(String updateBy) {
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
	public SalaryTplItem setUpdateTime(Date updateTime) {
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
	public SalaryTplItem setDeleted(Integer deleted) {
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
	public SalaryTplItem setDeleted(Boolean deletedBool) {
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
	public SalaryTplItem setDeleteBy(String deleteBy) {
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
	public SalaryTplItem setDeleteTime(Date deleteTime) {
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
	public SalaryTplItem setVersion(Integer version) {
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
	public SalaryTplItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 salaryColumn<br>
	 * salaryColumn
	 * @return salaryColumn
	*/
	public SalaryColumn getSalaryColumn() {
		return salaryColumn;
	}
	
	/**
	 * 设置 salaryColumn
	 * @param salaryColumn salaryColumn
	 * @return 当前对象
	*/
	public SalaryTplItem setSalaryColumn(SalaryColumn salaryColumn) {
		this.salaryColumn=salaryColumn;
		return this;
	}
	
	/**
	 * 获得 salaryColumnCode<br>
	 * salaryColumnCode
	 * @return salaryColumnCode
	*/
	public String getSalaryColumnCode() {
		return salaryColumnCode;
	}
	
	/**
	 * 设置 salaryColumnCode
	 * @param salaryColumnCode salaryColumnCode
	 * @return 当前对象
	*/
	public SalaryTplItem setSalaryColumnCode(String salaryColumnCode) {
		this.salaryColumnCode=salaryColumnCode;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryTplItem , 转换好的 SalaryTplItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryTplItem , 转换好的 PoJo 对象
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
	public SalaryTplItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryTplItem duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryTplItemMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryTplItemMeta.$$proxy$$();
		inst.setExpressionValue(this.getExpressionValue());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setExpressionShow(this.getExpressionShow());
		inst.setCreateBy(this.getCreateBy());
		inst.setIncludeExpression(this.getIncludeExpression());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSalaryColumnCode(this.getSalaryColumnCode());
			inst.setSalaryColumn(this.getSalaryColumn());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryTplItem clone(boolean deep) {
		return EntityContext.clone(SalaryTplItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryTplItem
	 * @param salaryTplItemMap 包含实体信息的 Map 对象
	 * @return SalaryTplItem , 转换好的的 SalaryTplItem 对象
	*/
	@Transient
	public static SalaryTplItem createFrom(Map<String,Object> salaryTplItemMap) {
		if(salaryTplItemMap==null) return null;
		SalaryTplItem po = create();
		EntityContext.copyProperties(po,salaryTplItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryTplItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryTplItem , 转换好的的 SalaryTplItem 对象
	*/
	@Transient
	public static SalaryTplItem createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryTplItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryTplItem，等同于 new
	 * @return SalaryTplItem 对象
	*/
	@Transient
	public static SalaryTplItem create() {
		return new com.dt.platform.domain.hr.meta.SalaryTplItemMeta.$$proxy$$();
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
			this.setExpressionValue(DataParser.parse(String.class, map.get(SalaryTplItemMeta.EXPRESSION_VALUE)));
			this.setCode(DataParser.parse(String.class, map.get(SalaryTplItemMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryTplItemMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryTplItemMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(SalaryTplItemMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryTplItemMeta.VERSION)));
			this.setExpressionShow(DataParser.parse(String.class, map.get(SalaryTplItemMeta.EXPRESSION_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryTplItemMeta.CREATE_BY)));
			this.setIncludeExpression(DataParser.parse(String.class, map.get(SalaryTplItemMeta.INCLUDE_EXPRESSION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryTplItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryTplItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryTplItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryTplItemMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SalaryTplItemMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryTplItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryTplItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryTplItemMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(SalaryTplItemMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(SalaryTplItemMeta.STATUS)));
			// others
			this.setSalaryColumnCode(DataParser.parse(String.class, map.get(SalaryTplItemMeta.SALARY_COLUMN_CODE)));
			this.setSalaryColumn(DataParser.parse(SalaryColumn.class, map.get(SalaryTplItemMeta.SALARY_COLUMN)));
			return true;
		} else {
			try {
				this.setExpressionValue( (String)map.get(SalaryTplItemMeta.EXPRESSION_VALUE));
				this.setCode( (String)map.get(SalaryTplItemMeta.CODE));
				this.setNotes( (String)map.get(SalaryTplItemMeta.NOTES));
				this.setUpdateTime( (Date)map.get(SalaryTplItemMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(SalaryTplItemMeta.SORT));
				this.setVersion( (Integer)map.get(SalaryTplItemMeta.VERSION));
				this.setExpressionShow( (String)map.get(SalaryTplItemMeta.EXPRESSION_SHOW));
				this.setCreateBy( (String)map.get(SalaryTplItemMeta.CREATE_BY));
				this.setIncludeExpression( (String)map.get(SalaryTplItemMeta.INCLUDE_EXPRESSION));
				this.setDeleted( (Integer)map.get(SalaryTplItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryTplItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryTplItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryTplItemMeta.DELETE_TIME));
				this.setName( (String)map.get(SalaryTplItemMeta.NAME));
				this.setTenantId( (String)map.get(SalaryTplItemMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryTplItemMeta.DELETE_BY));
				this.setId( (String)map.get(SalaryTplItemMeta.ID));
				this.setTplId( (String)map.get(SalaryTplItemMeta.TPL_ID));
				this.setStatus( (String)map.get(SalaryTplItemMeta.STATUS));
				// others
				this.setSalaryColumnCode( (String)map.get(SalaryTplItemMeta.SALARY_COLUMN_CODE));
				this.setSalaryColumn( (SalaryColumn)map.get(SalaryTplItemMeta.SALARY_COLUMN));
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
			this.setExpressionValue(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.EXPRESSION_VALUE)));
			this.setCode(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryTplItemMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(SalaryTplItemMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryTplItemMeta.VERSION)));
			this.setExpressionShow(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.EXPRESSION_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.CREATE_BY)));
			this.setIncludeExpression(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.INCLUDE_EXPRESSION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryTplItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryTplItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryTplItemMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SalaryTplItemMeta.STATUS)));
			return true;
		} else {
			try {
				this.setExpressionValue( (String)r.getValue(SalaryTplItemMeta.EXPRESSION_VALUE));
				this.setCode( (String)r.getValue(SalaryTplItemMeta.CODE));
				this.setNotes( (String)r.getValue(SalaryTplItemMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(SalaryTplItemMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(SalaryTplItemMeta.SORT));
				this.setVersion( (Integer)r.getValue(SalaryTplItemMeta.VERSION));
				this.setExpressionShow( (String)r.getValue(SalaryTplItemMeta.EXPRESSION_SHOW));
				this.setCreateBy( (String)r.getValue(SalaryTplItemMeta.CREATE_BY));
				this.setIncludeExpression( (String)r.getValue(SalaryTplItemMeta.INCLUDE_EXPRESSION));
				this.setDeleted( (Integer)r.getValue(SalaryTplItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryTplItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryTplItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryTplItemMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SalaryTplItemMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryTplItemMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryTplItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(SalaryTplItemMeta.ID));
				this.setTplId( (String)r.getValue(SalaryTplItemMeta.TPL_ID));
				this.setStatus( (String)r.getValue(SalaryTplItemMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}