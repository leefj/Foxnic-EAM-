package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_MATERIAL_RESOURCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.MaterialResourceMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 素材资源
 * <p>素材资源 , 数据表 sys_material_resource 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-02 15:29:00
 * @sign C8997168E6B2089B9CB5F5D280F385CE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_material_resource")
@ApiModel(description = "素材资源 ; 素材资源 , 数据表 sys_material_resource 的PO类型")
public class MaterialResource extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_MATERIAL_RESOURCE.$TABLE;
	
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
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 访问地址：访问地址
	*/
	@ApiModelProperty(required = false,value="访问地址" , notes = "访问地址")
	private String accessUrl;
	
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
	public MaterialResource setId(String id) {
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
	public MaterialResource setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public MaterialResource setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 访问地址<br>
	 * 访问地址
	 * @return 访问地址
	*/
	public String getAccessUrl() {
		return accessUrl;
	}
	
	/**
	 * 设置 访问地址
	 * @param accessUrl 访问地址
	 * @return 当前对象
	*/
	public MaterialResource setAccessUrl(String accessUrl) {
		this.accessUrl=accessUrl;
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
	public MaterialResource setNotes(String notes) {
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
	public MaterialResource setCreateBy(String createBy) {
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
	public MaterialResource setCreateTime(Date createTime) {
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
	public MaterialResource setUpdateBy(String updateBy) {
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
	public MaterialResource setUpdateTime(Date updateTime) {
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
	public MaterialResource setDeleted(Integer deleted) {
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
	public MaterialResource setDeleted(Boolean deletedBool) {
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
	public MaterialResource setDeleteBy(String deleteBy) {
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
	public MaterialResource setDeleteTime(Date deleteTime) {
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
	public MaterialResource setVersion(Integer version) {
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
	public MaterialResource setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaterialResource , 转换好的 MaterialResource 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaterialResource , 转换好的 PoJo 对象
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
	public MaterialResource clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaterialResource duplicate(boolean all) {
		com.dt.platform.domain.common.meta.MaterialResourceMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.MaterialResourceMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setAccessUrl(this.getAccessUrl());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MaterialResource clone(boolean deep) {
		return EntityContext.clone(MaterialResource.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaterialResource
	 * @param materialResourceMap 包含实体信息的 Map 对象
	 * @return MaterialResource , 转换好的的 MaterialResource 对象
	*/
	@Transient
	public static MaterialResource createFrom(Map<String,Object> materialResourceMap) {
		if(materialResourceMap==null) return null;
		MaterialResource po = create();
		EntityContext.copyProperties(po,materialResourceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaterialResource
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaterialResource , 转换好的的 MaterialResource 对象
	*/
	@Transient
	public static MaterialResource createFrom(Object pojo) {
		if(pojo==null) return null;
		MaterialResource po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MaterialResource，等同于 new
	 * @return MaterialResource 对象
	*/
	@Transient
	public static MaterialResource create() {
		return new com.dt.platform.domain.common.meta.MaterialResourceMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MaterialResourceMeta.NOTES)));
			this.setAccessUrl(DataParser.parse(String.class, map.get(MaterialResourceMeta.ACCESS_URL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaterialResourceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaterialResourceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaterialResourceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaterialResourceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaterialResourceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaterialResourceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaterialResourceMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MaterialResourceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaterialResourceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaterialResourceMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MaterialResourceMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(MaterialResourceMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MaterialResourceMeta.NOTES));
				this.setAccessUrl( (String)map.get(MaterialResourceMeta.ACCESS_URL));
				this.setUpdateTime( (Date)map.get(MaterialResourceMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MaterialResourceMeta.VERSION));
				this.setCreateBy( (String)map.get(MaterialResourceMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaterialResourceMeta.DELETED));
				this.setCreateTime( (Date)map.get(MaterialResourceMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MaterialResourceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MaterialResourceMeta.DELETE_TIME));
				this.setName( (String)map.get(MaterialResourceMeta.NAME));
				this.setTenantId( (String)map.get(MaterialResourceMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MaterialResourceMeta.DELETE_BY));
				this.setId( (String)map.get(MaterialResourceMeta.ID));
				this.setFileId( (String)map.get(MaterialResourceMeta.FILE_ID));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.NOTES)));
			this.setAccessUrl(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.ACCESS_URL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaterialResourceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaterialResourceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaterialResourceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaterialResourceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaterialResourceMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(MaterialResourceMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MaterialResourceMeta.NOTES));
				this.setAccessUrl( (String)r.getValue(MaterialResourceMeta.ACCESS_URL));
				this.setUpdateTime( (Date)r.getValue(MaterialResourceMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MaterialResourceMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MaterialResourceMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaterialResourceMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MaterialResourceMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MaterialResourceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MaterialResourceMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MaterialResourceMeta.NAME));
				this.setTenantId( (String)r.getValue(MaterialResourceMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MaterialResourceMeta.DELETE_BY));
				this.setId( (String)r.getValue(MaterialResourceMeta.ID));
				this.setFileId( (String)r.getValue(MaterialResourceMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}