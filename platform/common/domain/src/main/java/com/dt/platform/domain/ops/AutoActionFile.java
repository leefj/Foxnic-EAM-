package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_ACTION_FILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoActionFileMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行介质
 * <p>执行介质 , 数据表 ops_auto_action_file 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:03:41
 * @sign 115C174B2455DF83C7BCC803B6FC154E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_action_file")
@ApiModel(description = "执行介质 ; 执行介质 , 数据表 ops_auto_action_file 的PO类型")
public class AutoActionFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_ACTION_FILE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "613759342629355520")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "12")
	private String name;
	
	/**
	 * 文件名称：文件名称
	*/
	@ApiModelProperty(required = false,value="文件名称" , notes = "文件名称" , example = "12")
	private String fileName;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "613759333934563328")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-08-23 12:22:06")
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
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2022-08-23 12:22:06")
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
	public AutoActionFile setId(String id) {
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
	public AutoActionFile setName(String name) {
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
	public AutoActionFile setFileName(String fileName) {
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
	public AutoActionFile setFileId(String fileId) {
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
	public AutoActionFile setNotes(String notes) {
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
	public AutoActionFile setUpdateBy(String updateBy) {
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
	public AutoActionFile setUpdateTime(Date updateTime) {
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
	public AutoActionFile setDeleted(Integer deleted) {
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
	public AutoActionFile setDeleted(Boolean deletedBool) {
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
	public AutoActionFile setDeleteBy(String deleteBy) {
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
	public AutoActionFile setDeleteTime(Date deleteTime) {
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
	public AutoActionFile setVersion(Integer version) {
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
	public AutoActionFile setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AutoActionFile setCreateBy(String createBy) {
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
	public AutoActionFile setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoActionFile , 转换好的 AutoActionFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoActionFile , 转换好的 PoJo 对象
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
	public AutoActionFile clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoActionFile duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoActionFileMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoActionFileMeta.$$proxy$$();
		inst.setFileName(this.getFileName());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
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
	public AutoActionFile clone(boolean deep) {
		return EntityContext.clone(AutoActionFile.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoActionFile
	 * @param autoActionFileMap 包含实体信息的 Map 对象
	 * @return AutoActionFile , 转换好的的 AutoActionFile 对象
	*/
	@Transient
	public static AutoActionFile createFrom(Map<String,Object> autoActionFileMap) {
		if(autoActionFileMap==null) return null;
		AutoActionFile po = create();
		EntityContext.copyProperties(po,autoActionFileMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoActionFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoActionFile , 转换好的的 AutoActionFile 对象
	*/
	@Transient
	public static AutoActionFile createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoActionFile po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoActionFile，等同于 new
	 * @return AutoActionFile 对象
	*/
	@Transient
	public static AutoActionFile create() {
		return new com.dt.platform.domain.ops.meta.AutoActionFileMeta.$$proxy$$();
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
			this.setFileName(DataParser.parse(String.class, map.get(AutoActionFileMeta.FILE_NAME)));
			this.setNotes(DataParser.parse(String.class, map.get(AutoActionFileMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoActionFileMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoActionFileMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoActionFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoActionFileMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoActionFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoActionFileMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoActionFileMeta.CREATE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AutoActionFileMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AutoActionFileMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoActionFileMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoActionFileMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(AutoActionFileMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setFileName( (String)map.get(AutoActionFileMeta.FILE_NAME));
				this.setNotes( (String)map.get(AutoActionFileMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AutoActionFileMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AutoActionFileMeta.VERSION));
				this.setCreateBy( (String)map.get(AutoActionFileMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoActionFileMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoActionFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoActionFileMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoActionFileMeta.CREATE_TIME));
				this.setName( (String)map.get(AutoActionFileMeta.NAME));
				this.setTenantId( (String)map.get(AutoActionFileMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AutoActionFileMeta.DELETE_BY));
				this.setId( (String)map.get(AutoActionFileMeta.ID));
				this.setFileId( (String)map.get(AutoActionFileMeta.FILE_ID));
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
			this.setFileName(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.FILE_NAME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoActionFileMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoActionFileMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoActionFileMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoActionFileMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoActionFileMeta.CREATE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(AutoActionFileMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setFileName( (String)r.getValue(AutoActionFileMeta.FILE_NAME));
				this.setNotes( (String)r.getValue(AutoActionFileMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AutoActionFileMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AutoActionFileMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AutoActionFileMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoActionFileMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoActionFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoActionFileMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoActionFileMeta.CREATE_TIME));
				this.setName( (String)r.getValue(AutoActionFileMeta.NAME));
				this.setTenantId( (String)r.getValue(AutoActionFileMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AutoActionFileMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoActionFileMeta.ID));
				this.setFileId( (String)r.getValue(AutoActionFileMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}