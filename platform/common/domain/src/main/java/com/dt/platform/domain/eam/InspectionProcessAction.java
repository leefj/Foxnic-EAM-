package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_PROCESS_ACTION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.InspectionProcessActionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 处理方式
 * <p>处理方式 , 数据表 eam_inspection_process_action 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-05 21:56:22
 * @sign 6BF7BA7503D86FBC7281176E34876BB5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_process_action")
@ApiModel(description = "处理方式 ; 处理方式 , 数据表 eam_inspection_process_action 的PO类型")
public class InspectionProcessAction extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_PROCESS_ACTION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "817515581463855104")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "scrap")
	private String code;
	
	/**
	 * 方式：方式
	*/
	@ApiModelProperty(required = false,value="方式" , notes = "方式" , example = "报废")
	private String name;
	
	/**
	 * 处理类：处理类
	*/
	@ApiModelProperty(required = false,value="处理类" , notes = "处理类" , example = "0")
	private String classValue;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-05 09:55:03")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
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
	public InspectionProcessAction setId(String id) {
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
	public InspectionProcessAction setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 方式<br>
	 * 方式
	 * @return 方式
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 方式
	 * @param name 方式
	 * @return 当前对象
	*/
	public InspectionProcessAction setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 处理类<br>
	 * 处理类
	 * @return 处理类
	*/
	public String getClassValue() {
		return classValue;
	}
	
	/**
	 * 设置 处理类
	 * @param classValue 处理类
	 * @return 当前对象
	*/
	public InspectionProcessAction setClassValue(String classValue) {
		this.classValue=classValue;
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
	public InspectionProcessAction setNotes(String notes) {
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
	public InspectionProcessAction setCreateBy(String createBy) {
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
	public InspectionProcessAction setCreateTime(Date createTime) {
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
	public InspectionProcessAction setUpdateBy(String updateBy) {
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
	public InspectionProcessAction setUpdateTime(Date updateTime) {
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
	public InspectionProcessAction setDeleted(Integer deleted) {
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
	public InspectionProcessAction setDeleted(Boolean deletedBool) {
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
	public InspectionProcessAction setDeleteBy(String deleteBy) {
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
	public InspectionProcessAction setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public InspectionProcessAction setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public InspectionProcessAction setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionProcessAction , 转换好的 InspectionProcessAction 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionProcessAction , 转换好的 PoJo 对象
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
	public InspectionProcessAction clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionProcessAction duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionProcessActionMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionProcessActionMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setClassValue(this.getClassValue());
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
	public InspectionProcessAction clone(boolean deep) {
		return EntityContext.clone(InspectionProcessAction.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionProcessAction
	 * @param inspectionProcessActionMap 包含实体信息的 Map 对象
	 * @return InspectionProcessAction , 转换好的的 InspectionProcessAction 对象
	*/
	@Transient
	public static InspectionProcessAction createFrom(Map<String,Object> inspectionProcessActionMap) {
		if(inspectionProcessActionMap==null) return null;
		InspectionProcessAction po = create();
		EntityContext.copyProperties(po,inspectionProcessActionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionProcessAction
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionProcessAction , 转换好的的 InspectionProcessAction 对象
	*/
	@Transient
	public static InspectionProcessAction createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionProcessAction po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionProcessAction，等同于 new
	 * @return InspectionProcessAction 对象
	*/
	@Transient
	public static InspectionProcessAction create() {
		return new com.dt.platform.domain.eam.meta.InspectionProcessActionMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionProcessActionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionProcessActionMeta.VERSION)));
			this.setClassValue(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.CLASS_VALUE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionProcessActionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionProcessActionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionProcessActionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InspectionProcessActionMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(InspectionProcessActionMeta.CODE));
				this.setNotes( (String)map.get(InspectionProcessActionMeta.NOTES));
				this.setUpdateTime( (Date)map.get(InspectionProcessActionMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(InspectionProcessActionMeta.VERSION));
				this.setClassValue( (String)map.get(InspectionProcessActionMeta.CLASS_VALUE));
				this.setCreateBy( (String)map.get(InspectionProcessActionMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionProcessActionMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionProcessActionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InspectionProcessActionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InspectionProcessActionMeta.DELETE_TIME));
				this.setName( (String)map.get(InspectionProcessActionMeta.NAME));
				this.setTenantId( (String)map.get(InspectionProcessActionMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionProcessActionMeta.DELETE_BY));
				this.setId( (String)map.get(InspectionProcessActionMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionProcessActionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionProcessActionMeta.VERSION)));
			this.setClassValue(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.CLASS_VALUE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionProcessActionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionProcessActionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionProcessActionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionProcessActionMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(InspectionProcessActionMeta.CODE));
				this.setNotes( (String)r.getValue(InspectionProcessActionMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(InspectionProcessActionMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(InspectionProcessActionMeta.VERSION));
				this.setClassValue( (String)r.getValue(InspectionProcessActionMeta.CLASS_VALUE));
				this.setCreateBy( (String)r.getValue(InspectionProcessActionMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionProcessActionMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionProcessActionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InspectionProcessActionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InspectionProcessActionMeta.DELETE_TIME));
				this.setName( (String)r.getValue(InspectionProcessActionMeta.NAME));
				this.setTenantId( (String)r.getValue(InspectionProcessActionMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionProcessActionMeta.DELETE_BY));
				this.setId( (String)r.getValue(InspectionProcessActionMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}