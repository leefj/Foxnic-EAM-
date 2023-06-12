package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_INSPECTION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbInspectionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库巡检
 * <p>数据库巡检 , 数据表 ops_db_inspection 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-11 09:33:49
 * @sign 4A452D3749B101C733FA761E6DA0C747
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_inspection")
@ApiModel(description = "数据库巡检 ; 数据库巡检 , 数据表 ops_db_inspection 的PO类型")
public class DbInspection extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_INSPECTION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "720207508114767872")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "阿斯顿发")
	private String name;
	
	/**
	 * 巡检方：巡检方
	*/
	@ApiModelProperty(required = false,value="巡检方" , notes = "巡检方" , example = "阿道夫")
	private String actionUser;
	
	/**
	 * 巡检结果：巡检结果
	*/
	@ApiModelProperty(required = false,value="巡检结果" , notes = "巡检结果" , example = "阿道夫")
	private String result;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2023-06-07 12:00:00")
	private Date rcdDate;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "720207503857549313")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "阿道夫")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-11 09:27:31")
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * dbInstance：dbInstance
	*/
	@ApiModelProperty(required = false,value="dbInstance" , notes = "dbInstance")
	private DbInstance dbInstance;
	
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
	public DbInspection setId(String id) {
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
	public DbInspection setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 巡检方<br>
	 * 巡检方
	 * @return 巡检方
	*/
	public String getActionUser() {
		return actionUser;
	}
	
	/**
	 * 设置 巡检方
	 * @param actionUser 巡检方
	 * @return 当前对象
	*/
	public DbInspection setActionUser(String actionUser) {
		this.actionUser=actionUser;
		return this;
	}
	
	/**
	 * 获得 巡检结果<br>
	 * 巡检结果
	 * @return 巡检结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 巡检结果
	 * @param result 巡检结果
	 * @return 当前对象
	*/
	public DbInspection setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRcdDate() {
		return rcdDate;
	}
	
	/**
	 * 设置 记录时间
	 * @param rcdDate 记录时间
	 * @return 当前对象
	*/
	public DbInspection setRcdDate(Date rcdDate) {
		this.rcdDate=rcdDate;
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
	public DbInspection setFileId(String fileId) {
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
	public DbInspection setNotes(String notes) {
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
	public DbInspection setCreateBy(String createBy) {
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
	public DbInspection setCreateTime(Date createTime) {
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
	public DbInspection setUpdateBy(String updateBy) {
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
	public DbInspection setUpdateTime(Date updateTime) {
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
	public DbInspection setDeleted(Integer deleted) {
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
	public DbInspection setDeleted(Boolean deletedBool) {
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
	public DbInspection setDeleteBy(String deleteBy) {
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
	public DbInspection setDeleteTime(Date deleteTime) {
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
	public DbInspection setVersion(Integer version) {
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
	public DbInspection setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 dbInstance<br>
	 * dbInstance
	 * @return dbInstance
	*/
	public DbInstance getDbInstance() {
		return dbInstance;
	}
	
	/**
	 * 设置 dbInstance
	 * @param dbInstance dbInstance
	 * @return 当前对象
	*/
	public DbInspection setDbInstance(DbInstance dbInstance) {
		this.dbInstance=dbInstance;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbInspection , 转换好的 DbInspection 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbInspection , 转换好的 PoJo 对象
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
	public DbInspection clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbInspection duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbInspectionMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbInspectionMeta.$$proxy$$();
		inst.setActionUser(this.getActionUser());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setResult(this.getResult());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRcdDate(this.getRcdDate());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setDbInstance(this.getDbInstance());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbInspection clone(boolean deep) {
		return EntityContext.clone(DbInspection.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbInspection
	 * @param dbInspectionMap 包含实体信息的 Map 对象
	 * @return DbInspection , 转换好的的 DbInspection 对象
	*/
	@Transient
	public static DbInspection createFrom(Map<String,Object> dbInspectionMap) {
		if(dbInspectionMap==null) return null;
		DbInspection po = create();
		EntityContext.copyProperties(po,dbInspectionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbInspection
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbInspection , 转换好的的 DbInspection 对象
	*/
	@Transient
	public static DbInspection createFrom(Object pojo) {
		if(pojo==null) return null;
		DbInspection po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbInspection，等同于 new
	 * @return DbInspection 对象
	*/
	@Transient
	public static DbInspection create() {
		return new com.dt.platform.domain.ops.meta.DbInspectionMeta.$$proxy$$();
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
			this.setActionUser(DataParser.parse(String.class, map.get(DbInspectionMeta.ACTION_USER)));
			this.setNotes(DataParser.parse(String.class, map.get(DbInspectionMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbInspectionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbInspectionMeta.VERSION)));
			this.setResult(DataParser.parse(String.class, map.get(DbInspectionMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbInspectionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbInspectionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbInspectionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbInspectionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbInspectionMeta.DELETE_TIME)));
			this.setRcdDate(DataParser.parse(Date.class, map.get(DbInspectionMeta.RCD_DATE)));
			this.setName(DataParser.parse(String.class, map.get(DbInspectionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DbInspectionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbInspectionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbInspectionMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(DbInspectionMeta.FILE_ID)));
			// others
			this.setDbInstance(DataParser.parse(DbInstance.class, map.get(DbInspectionMeta.DB_INSTANCE)));
			return true;
		} else {
			try {
				this.setActionUser( (String)map.get(DbInspectionMeta.ACTION_USER));
				this.setNotes( (String)map.get(DbInspectionMeta.NOTES));
				this.setUpdateTime( (Date)map.get(DbInspectionMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DbInspectionMeta.VERSION));
				this.setResult( (String)map.get(DbInspectionMeta.RESULT));
				this.setCreateBy( (String)map.get(DbInspectionMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbInspectionMeta.DELETED));
				this.setCreateTime( (Date)map.get(DbInspectionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DbInspectionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbInspectionMeta.DELETE_TIME));
				this.setRcdDate( (Date)map.get(DbInspectionMeta.RCD_DATE));
				this.setName( (String)map.get(DbInspectionMeta.NAME));
				this.setTenantId( (String)map.get(DbInspectionMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DbInspectionMeta.DELETE_BY));
				this.setId( (String)map.get(DbInspectionMeta.ID));
				this.setFileId( (String)map.get(DbInspectionMeta.FILE_ID));
				// others
				this.setDbInstance( (DbInstance)map.get(DbInspectionMeta.DB_INSTANCE));
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
			this.setActionUser(DataParser.parse(String.class, r.getValue(DbInspectionMeta.ACTION_USER)));
			this.setNotes(DataParser.parse(String.class, r.getValue(DbInspectionMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbInspectionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbInspectionMeta.VERSION)));
			this.setResult(DataParser.parse(String.class, r.getValue(DbInspectionMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbInspectionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbInspectionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbInspectionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbInspectionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbInspectionMeta.DELETE_TIME)));
			this.setRcdDate(DataParser.parse(Date.class, r.getValue(DbInspectionMeta.RCD_DATE)));
			this.setName(DataParser.parse(String.class, r.getValue(DbInspectionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DbInspectionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbInspectionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbInspectionMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(DbInspectionMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setActionUser( (String)r.getValue(DbInspectionMeta.ACTION_USER));
				this.setNotes( (String)r.getValue(DbInspectionMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(DbInspectionMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DbInspectionMeta.VERSION));
				this.setResult( (String)r.getValue(DbInspectionMeta.RESULT));
				this.setCreateBy( (String)r.getValue(DbInspectionMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbInspectionMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DbInspectionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DbInspectionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbInspectionMeta.DELETE_TIME));
				this.setRcdDate( (Date)r.getValue(DbInspectionMeta.RCD_DATE));
				this.setName( (String)r.getValue(DbInspectionMeta.NAME));
				this.setTenantId( (String)r.getValue(DbInspectionMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DbInspectionMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbInspectionMeta.ID));
				this.setFileId( (String)r.getValue(DbInspectionMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}