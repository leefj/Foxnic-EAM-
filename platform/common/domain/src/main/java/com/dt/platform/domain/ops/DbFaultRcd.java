package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_FAULT_RCD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbFaultRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库故障
 * <p>数据库故障 , 数据表 ops_db_fault_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-11 09:33:42
 * @sign 0CE6B8C486D426CFF7202AEF00C3D782
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_fault_rcd")
@ApiModel(description = "数据库故障 ; 数据库故障 , 数据表 ops_db_fault_rcd 的PO类型")
public class DbFaultRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_FAULT_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "718961003030642688")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "jk")
	private String name;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbInstanceId;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因" , example = "手工")
	private String reason;
	
	/**
	 * 处理：处理
	*/
	@ApiModelProperty(required = false,value="处理" , notes = "处理")
	private String process;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2023-06-22 12:00:00")
	private Date rcdDate;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件")
	private String fileId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-07 10:54:21")
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
	public DbFaultRcd setId(String id) {
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
	public DbFaultRcd setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbInstanceId() {
		return dbInstanceId;
	}
	
	/**
	 * 设置 数据库
	 * @param dbInstanceId 数据库
	 * @return 当前对象
	*/
	public DbFaultRcd setDbInstanceId(String dbInstanceId) {
		this.dbInstanceId=dbInstanceId;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 原因
	 * @return 原因
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 原因
	 * @param reason 原因
	 * @return 当前对象
	*/
	public DbFaultRcd setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 处理<br>
	 * 处理
	 * @return 处理
	*/
	public String getProcess() {
		return process;
	}
	
	/**
	 * 设置 处理
	 * @param process 处理
	 * @return 当前对象
	*/
	public DbFaultRcd setProcess(String process) {
		this.process=process;
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
	public DbFaultRcd setRcdDate(Date rcdDate) {
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
	public DbFaultRcd setFileId(String fileId) {
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
	public DbFaultRcd setNotes(String notes) {
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
	public DbFaultRcd setCreateBy(String createBy) {
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
	public DbFaultRcd setCreateTime(Date createTime) {
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
	public DbFaultRcd setUpdateBy(String updateBy) {
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
	public DbFaultRcd setUpdateTime(Date updateTime) {
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
	public DbFaultRcd setDeleted(Integer deleted) {
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
	public DbFaultRcd setDeleted(Boolean deletedBool) {
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
	public DbFaultRcd setDeleteBy(String deleteBy) {
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
	public DbFaultRcd setDeleteTime(Date deleteTime) {
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
	public DbFaultRcd setVersion(Integer version) {
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
	public DbFaultRcd setTenantId(String tenantId) {
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
	public DbFaultRcd setDbInstance(DbInstance dbInstance) {
		this.dbInstance=dbInstance;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbFaultRcd , 转换好的 DbFaultRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbFaultRcd , 转换好的 PoJo 对象
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
	public DbFaultRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbFaultRcd duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbFaultRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbFaultRcdMeta.$$proxy$$();
		inst.setReason(this.getReason());
		inst.setProcess(this.getProcess());
		inst.setNotes(this.getNotes());
		inst.setDbInstanceId(this.getDbInstanceId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
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
	public DbFaultRcd clone(boolean deep) {
		return EntityContext.clone(DbFaultRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbFaultRcd
	 * @param dbFaultRcdMap 包含实体信息的 Map 对象
	 * @return DbFaultRcd , 转换好的的 DbFaultRcd 对象
	*/
	@Transient
	public static DbFaultRcd createFrom(Map<String,Object> dbFaultRcdMap) {
		if(dbFaultRcdMap==null) return null;
		DbFaultRcd po = create();
		EntityContext.copyProperties(po,dbFaultRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbFaultRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbFaultRcd , 转换好的的 DbFaultRcd 对象
	*/
	@Transient
	public static DbFaultRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		DbFaultRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbFaultRcd，等同于 new
	 * @return DbFaultRcd 对象
	*/
	@Transient
	public static DbFaultRcd create() {
		return new com.dt.platform.domain.ops.meta.DbFaultRcdMeta.$$proxy$$();
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
			this.setReason(DataParser.parse(String.class, map.get(DbFaultRcdMeta.REASON)));
			this.setProcess(DataParser.parse(String.class, map.get(DbFaultRcdMeta.PROCESS)));
			this.setNotes(DataParser.parse(String.class, map.get(DbFaultRcdMeta.NOTES)));
			this.setDbInstanceId(DataParser.parse(String.class, map.get(DbFaultRcdMeta.DB_INSTANCE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbFaultRcdMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbFaultRcdMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbFaultRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbFaultRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbFaultRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbFaultRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbFaultRcdMeta.DELETE_TIME)));
			this.setRcdDate(DataParser.parse(Date.class, map.get(DbFaultRcdMeta.RCD_DATE)));
			this.setName(DataParser.parse(String.class, map.get(DbFaultRcdMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DbFaultRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbFaultRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbFaultRcdMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(DbFaultRcdMeta.FILE_ID)));
			// others
			this.setDbInstance(DataParser.parse(DbInstance.class, map.get(DbFaultRcdMeta.DB_INSTANCE)));
			return true;
		} else {
			try {
				this.setReason( (String)map.get(DbFaultRcdMeta.REASON));
				this.setProcess( (String)map.get(DbFaultRcdMeta.PROCESS));
				this.setNotes( (String)map.get(DbFaultRcdMeta.NOTES));
				this.setDbInstanceId( (String)map.get(DbFaultRcdMeta.DB_INSTANCE_ID));
				this.setUpdateTime( (Date)map.get(DbFaultRcdMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DbFaultRcdMeta.VERSION));
				this.setCreateBy( (String)map.get(DbFaultRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbFaultRcdMeta.DELETED));
				this.setCreateTime( (Date)map.get(DbFaultRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DbFaultRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbFaultRcdMeta.DELETE_TIME));
				this.setRcdDate( (Date)map.get(DbFaultRcdMeta.RCD_DATE));
				this.setName( (String)map.get(DbFaultRcdMeta.NAME));
				this.setTenantId( (String)map.get(DbFaultRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DbFaultRcdMeta.DELETE_BY));
				this.setId( (String)map.get(DbFaultRcdMeta.ID));
				this.setFileId( (String)map.get(DbFaultRcdMeta.FILE_ID));
				// others
				this.setDbInstance( (DbInstance)map.get(DbFaultRcdMeta.DB_INSTANCE));
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
			this.setReason(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.REASON)));
			this.setProcess(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.PROCESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.NOTES)));
			this.setDbInstanceId(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.DB_INSTANCE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbFaultRcdMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbFaultRcdMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbFaultRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbFaultRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbFaultRcdMeta.DELETE_TIME)));
			this.setRcdDate(DataParser.parse(Date.class, r.getValue(DbFaultRcdMeta.RCD_DATE)));
			this.setName(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(DbFaultRcdMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(DbFaultRcdMeta.REASON));
				this.setProcess( (String)r.getValue(DbFaultRcdMeta.PROCESS));
				this.setNotes( (String)r.getValue(DbFaultRcdMeta.NOTES));
				this.setDbInstanceId( (String)r.getValue(DbFaultRcdMeta.DB_INSTANCE_ID));
				this.setUpdateTime( (Date)r.getValue(DbFaultRcdMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DbFaultRcdMeta.VERSION));
				this.setCreateBy( (String)r.getValue(DbFaultRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbFaultRcdMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DbFaultRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DbFaultRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbFaultRcdMeta.DELETE_TIME));
				this.setRcdDate( (Date)r.getValue(DbFaultRcdMeta.RCD_DATE));
				this.setName( (String)r.getValue(DbFaultRcdMeta.NAME));
				this.setTenantId( (String)r.getValue(DbFaultRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DbFaultRcdMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbFaultRcdMeta.ID));
				this.setFileId( (String)r.getValue(DbFaultRcdMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}