package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_ACTION_SCRIPT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoActionScriptMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行脚本
 * <p>执行脚本 , 数据表 ops_auto_action_script 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 07:58:11
 * @sign 645723D685E8CBCC6C32E4A730EFBE1A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_action_script")
@ApiModel(description = "执行脚本 ; 执行脚本 , 数据表 ops_auto_action_script 的PO类型")
public class AutoActionScript extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_ACTION_SCRIPT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "613733471919013888")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "b.java")
	private String name;
	
	/**
	 * 文件名称：文件名称
	*/
	@ApiModelProperty(required = false,value="文件名称" , notes = "文件名称" , example = "b.java")
	private String fileName;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "614434136450400257")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-08-24 08:30:09")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2022-08-24 08:30:09")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "3")
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
	public AutoActionScript setId(String id) {
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
	public AutoActionScript setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 文件名称<br>
	 * 文件名称
	 * @return 文件名称
	*/
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * 设置 文件名称
	 * @param fileName 文件名称
	 * @return 当前对象
	*/
	public AutoActionScript setFileName(String fileName) {
		this.fileName=fileName;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 文件
	 * @param fileId 文件
	 * @return 当前对象
	*/
	public AutoActionScript setFileId(String fileId) {
		this.fileId=fileId;
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
	public AutoActionScript setNotes(String notes) {
		this.notes=notes;
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
	public AutoActionScript setUpdateBy(String updateBy) {
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
	public AutoActionScript setUpdateTime(Date updateTime) {
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
	public AutoActionScript setDeleted(Integer deleted) {
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
	public AutoActionScript setDeleted(Boolean deletedBool) {
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
	public AutoActionScript setDeleteBy(String deleteBy) {
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
	public AutoActionScript setDeleteTime(Date deleteTime) {
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
	public AutoActionScript setVersion(Integer version) {
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
	public AutoActionScript setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoActionScript , 转换好的 AutoActionScript 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoActionScript , 转换好的 PoJo 对象
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
	public AutoActionScript clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoActionScript duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoActionScriptMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoActionScriptMeta.$$proxy$$();
		inst.setFileName(this.getFileName());
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.setFileId(this.getFileId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoActionScript clone(boolean deep) {
		return EntityContext.clone(AutoActionScript.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoActionScript
	 * @param autoActionScriptMap 包含实体信息的 Map 对象
	 * @return AutoActionScript , 转换好的的 AutoActionScript 对象
	*/
	@Transient
	public static AutoActionScript createFrom(Map<String,Object> autoActionScriptMap) {
		if(autoActionScriptMap==null) return null;
		AutoActionScript po = create();
		EntityContext.copyProperties(po,autoActionScriptMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoActionScript
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoActionScript , 转换好的的 AutoActionScript 对象
	*/
	@Transient
	public static AutoActionScript createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoActionScript po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoActionScript，等同于 new
	 * @return AutoActionScript 对象
	*/
	@Transient
	public static AutoActionScript create() {
		return new com.dt.platform.domain.ops.meta.AutoActionScriptMeta.$$proxy$$();
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
			this.setFileName(DataParser.parse(String.class, map.get(AutoActionScriptMeta.FILE_NAME)));
			this.setNotes(DataParser.parse(String.class, map.get(AutoActionScriptMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoActionScriptMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoActionScriptMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoActionScriptMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AutoActionScriptMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AutoActionScriptMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoActionScriptMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoActionScriptMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoActionScriptMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoActionScriptMeta.VERSION)));
			this.setFileId(DataParser.parse(String.class, map.get(AutoActionScriptMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setFileName( (String)map.get(AutoActionScriptMeta.FILE_NAME));
				this.setNotes( (String)map.get(AutoActionScriptMeta.NOTES));
				this.setDeleted( (Integer)map.get(AutoActionScriptMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoActionScriptMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoActionScriptMeta.DELETE_TIME));
				this.setName( (String)map.get(AutoActionScriptMeta.NAME));
				this.setTenantId( (String)map.get(AutoActionScriptMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AutoActionScriptMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoActionScriptMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoActionScriptMeta.ID));
				this.setVersion( (Integer)map.get(AutoActionScriptMeta.VERSION));
				this.setFileId( (String)map.get(AutoActionScriptMeta.FILE_ID));
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
			this.setFileName(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.FILE_NAME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoActionScriptMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoActionScriptMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoActionScriptMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoActionScriptMeta.VERSION)));
			this.setFileId(DataParser.parse(String.class, r.getValue(AutoActionScriptMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setFileName( (String)r.getValue(AutoActionScriptMeta.FILE_NAME));
				this.setNotes( (String)r.getValue(AutoActionScriptMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(AutoActionScriptMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoActionScriptMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoActionScriptMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AutoActionScriptMeta.NAME));
				this.setTenantId( (String)r.getValue(AutoActionScriptMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AutoActionScriptMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoActionScriptMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoActionScriptMeta.ID));
				this.setVersion( (Integer)r.getValue(AutoActionScriptMeta.VERSION));
				this.setFileId( (String)r.getValue(AutoActionScriptMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}