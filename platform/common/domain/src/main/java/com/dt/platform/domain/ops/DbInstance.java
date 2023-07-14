package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库实例
 * <p>数据库实例 , 数据表 ops_db_instance 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:45:51
 * @sign E71AA9FA09EB3A39910E9918848CD5E3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_instance")
@ApiModel(description = "数据库实例 ; 数据库实例 , 数据表 ops_db_instance 的PO类型")
public class DbInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_INSTANCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 主机编号：主机编号
	*/
	@ApiModelProperty(required = false,value="主机编号" , notes = "主机编号")
	private String hostId;
	
	/**
	 * 数据库编号：数据库编号
	*/
	@ApiModelProperty(required = false,value="数据库编号" , notes = "数据库编号")
	private String databaseId;
	
	/**
	 * 实例名称：实例名称
	*/
	@ApiModelProperty(required = false,value="实例名称" , notes = "实例名称")
	private String name;
	
	/**
	 * 日志模式：日志模式
	*/
	@ApiModelProperty(required = false,value="日志模式" , notes = "日志模式")
	private String logMethod;
	
	/**
	 * 备份策略：备份策略
	*/
	@ApiModelProperty(required = false,value="备份策略" , notes = "备份策略")
	private String backupStrategy;
	
	/**
	 * 备份类型：备份类型
	*/
	@ApiModelProperty(required = false,value="备份类型" , notes = "备份类型")
	private String backupType;
	
	/**
	 * 备份保留时长：备份保留时长
	*/
	@ApiModelProperty(required = false,value="备份保留时长" , notes = "备份保留时长")
	private String backupDatakeep;
	
	/**
	 * 备份状态：备份状态
	*/
	@ApiModelProperty(required = false,value="备份状态" , notes = "备份状态")
	private String backupStatus;
	
	/**
	 * 备份方式：备份方式
	*/
	@ApiModelProperty(required = false,value="备份方式" , notes = "备份方式")
	private String backupMethod;
	
	/**
	 * 上次备份：上次备份
	*/
	@ApiModelProperty(required = false,value="上次备份" , notes = "上次备份")
	private Date backupTime;
	
	/**
	 * 备份大小：备份大小
	*/
	@ApiModelProperty(required = false,value="备份大小" , notes = "备份大小")
	private BigDecimal backupSize;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labels;
	
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
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
	 * 所在位置：所在位置
	*/
	@ApiModelProperty(required = false,value="所在位置" , notes = "所在位置")
	private Host host;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private ServiceInfo database;
	
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
	public DbInstance setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 主机编号<br>
	 * 主机编号
	 * @return 主机编号
	*/
	public String getHostId() {
		return hostId;
	}
	
	/**
	 * 设置 主机编号
	 * @param hostId 主机编号
	 * @return 当前对象
	*/
	public DbInstance setHostId(String hostId) {
		this.hostId=hostId;
		return this;
	}
	
	/**
	 * 获得 数据库编号<br>
	 * 数据库编号
	 * @return 数据库编号
	*/
	public String getDatabaseId() {
		return databaseId;
	}
	
	/**
	 * 设置 数据库编号
	 * @param databaseId 数据库编号
	 * @return 当前对象
	*/
	public DbInstance setDatabaseId(String databaseId) {
		this.databaseId=databaseId;
		return this;
	}
	
	/**
	 * 获得 实例名称<br>
	 * 实例名称
	 * @return 实例名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 实例名称
	 * @param name 实例名称
	 * @return 当前对象
	*/
	public DbInstance setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 日志模式<br>
	 * 日志模式
	 * @return 日志模式
	*/
	public String getLogMethod() {
		return logMethod;
	}
	
	/**
	 * 设置 日志模式
	 * @param logMethod 日志模式
	 * @return 当前对象
	*/
	public DbInstance setLogMethod(String logMethod) {
		this.logMethod=logMethod;
		return this;
	}
	
	/**
	 * 获得 备份策略<br>
	 * 备份策略
	 * @return 备份策略
	*/
	public String getBackupStrategy() {
		return backupStrategy;
	}
	
	/**
	 * 设置 备份策略
	 * @param backupStrategy 备份策略
	 * @return 当前对象
	*/
	public DbInstance setBackupStrategy(String backupStrategy) {
		this.backupStrategy=backupStrategy;
		return this;
	}
	
	/**
	 * 获得 备份类型<br>
	 * 备份类型
	 * @return 备份类型
	*/
	public String getBackupType() {
		return backupType;
	}
	
	/**
	 * 设置 备份类型
	 * @param backupType 备份类型
	 * @return 当前对象
	*/
	public DbInstance setBackupType(String backupType) {
		this.backupType=backupType;
		return this;
	}
	
	/**
	 * 获得 备份保留时长<br>
	 * 备份保留时长
	 * @return 备份保留时长
	*/
	public String getBackupDatakeep() {
		return backupDatakeep;
	}
	
	/**
	 * 设置 备份保留时长
	 * @param backupDatakeep 备份保留时长
	 * @return 当前对象
	*/
	public DbInstance setBackupDatakeep(String backupDatakeep) {
		this.backupDatakeep=backupDatakeep;
		return this;
	}
	
	/**
	 * 获得 备份状态<br>
	 * 备份状态
	 * @return 备份状态
	*/
	public String getBackupStatus() {
		return backupStatus;
	}
	
	/**
	 * 设置 备份状态
	 * @param backupStatus 备份状态
	 * @return 当前对象
	*/
	public DbInstance setBackupStatus(String backupStatus) {
		this.backupStatus=backupStatus;
		return this;
	}
	
	/**
	 * 获得 备份方式<br>
	 * 备份方式
	 * @return 备份方式
	*/
	public String getBackupMethod() {
		return backupMethod;
	}
	
	/**
	 * 设置 备份方式
	 * @param backupMethod 备份方式
	 * @return 当前对象
	*/
	public DbInstance setBackupMethod(String backupMethod) {
		this.backupMethod=backupMethod;
		return this;
	}
	
	/**
	 * 获得 上次备份<br>
	 * 上次备份
	 * @return 上次备份
	*/
	public Date getBackupTime() {
		return backupTime;
	}
	
	/**
	 * 设置 上次备份
	 * @param backupTime 上次备份
	 * @return 当前对象
	*/
	public DbInstance setBackupTime(Date backupTime) {
		this.backupTime=backupTime;
		return this;
	}
	
	/**
	 * 获得 备份大小<br>
	 * 备份大小
	 * @return 备份大小
	*/
	public BigDecimal getBackupSize() {
		return backupSize;
	}
	
	/**
	 * 设置 备份大小
	 * @param backupSize 备份大小
	 * @return 当前对象
	*/
	public DbInstance setBackupSize(BigDecimal backupSize) {
		this.backupSize=backupSize;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabels() {
		return labels;
	}
	
	/**
	 * 设置 标签
	 * @param labels 标签
	 * @return 当前对象
	*/
	public DbInstance setLabels(String labels) {
		this.labels=labels;
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
	public DbInstance setNotes(String notes) {
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
	public DbInstance setCreateBy(String createBy) {
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
	public DbInstance setCreateTime(Date createTime) {
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
	public DbInstance setUpdateBy(String updateBy) {
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
	public DbInstance setUpdateTime(Date updateTime) {
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
	public DbInstance setDeleted(Integer deleted) {
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
	public DbInstance setDeleted(Boolean deletedBool) {
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
	public DbInstance setDeleteBy(String deleteBy) {
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
	public DbInstance setDeleteTime(Date deleteTime) {
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
	public DbInstance setVersion(Integer version) {
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
	public DbInstance setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 所在位置<br>
	 * 所在位置
	 * @return 所在位置
	*/
	public Host getHost() {
		return host;
	}
	
	/**
	 * 设置 所在位置
	 * @param host 所在位置
	 * @return 当前对象
	*/
	public DbInstance setHost(Host host) {
		this.host=host;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public ServiceInfo getDatabase() {
		return database;
	}
	
	/**
	 * 设置 数据库
	 * @param database 数据库
	 * @return 当前对象
	*/
	public DbInstance setDatabase(ServiceInfo database) {
		this.database=database;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbInstance , 转换好的 DbInstance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbInstance , 转换好的 PoJo 对象
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
	public DbInstance clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbInstance duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbInstanceMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbInstanceMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setLogMethod(this.getLogMethod());
		inst.setHostId(this.getHostId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setBackupDatakeep(this.getBackupDatakeep());
		inst.setBackupType(this.getBackupType());
		inst.setLabels(this.getLabels());
		inst.setBackupSize(this.getBackupSize());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBackupStrategy(this.getBackupStrategy());
		inst.setBackupStatus(this.getBackupStatus());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setBackupMethod(this.getBackupMethod());
		inst.setDatabaseId(this.getDatabaseId());
		inst.setBackupTime(this.getBackupTime());
		if(all) {
			inst.setDatabase(this.getDatabase());
			inst.setHost(this.getHost());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbInstance clone(boolean deep) {
		return EntityContext.clone(DbInstance.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbInstance
	 * @param dbInstanceMap 包含实体信息的 Map 对象
	 * @return DbInstance , 转换好的的 DbInstance 对象
	*/
	@Transient
	public static DbInstance createFrom(Map<String,Object> dbInstanceMap) {
		if(dbInstanceMap==null) return null;
		DbInstance po = create();
		EntityContext.copyProperties(po,dbInstanceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbInstance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbInstance , 转换好的的 DbInstance 对象
	*/
	@Transient
	public static DbInstance createFrom(Object pojo) {
		if(pojo==null) return null;
		DbInstance po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbInstance，等同于 new
	 * @return DbInstance 对象
	*/
	@Transient
	public static DbInstance create() {
		return new com.dt.platform.domain.ops.meta.DbInstanceMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbInstanceMeta.NOTES)));
			this.setLogMethod(DataParser.parse(String.class, map.get(DbInstanceMeta.LOG_METHOD)));
			this.setHostId(DataParser.parse(String.class, map.get(DbInstanceMeta.HOST_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbInstanceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbInstanceMeta.VERSION)));
			this.setBackupDatakeep(DataParser.parse(String.class, map.get(DbInstanceMeta.BACKUP_DATAKEEP)));
			this.setBackupType(DataParser.parse(String.class, map.get(DbInstanceMeta.BACKUP_TYPE)));
			this.setLabels(DataParser.parse(String.class, map.get(DbInstanceMeta.LABELS)));
			this.setBackupSize(DataParser.parse(BigDecimal.class, map.get(DbInstanceMeta.BACKUP_SIZE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbInstanceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbInstanceMeta.DELETED)));
			this.setBackupStrategy(DataParser.parse(String.class, map.get(DbInstanceMeta.BACKUP_STRATEGY)));
			this.setBackupStatus(DataParser.parse(String.class, map.get(DbInstanceMeta.BACKUP_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbInstanceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbInstanceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbInstanceMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(DbInstanceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DbInstanceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbInstanceMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbInstanceMeta.ID)));
			this.setBackupMethod(DataParser.parse(String.class, map.get(DbInstanceMeta.BACKUP_METHOD)));
			this.setDatabaseId(DataParser.parse(String.class, map.get(DbInstanceMeta.DATABASE_ID)));
			this.setBackupTime(DataParser.parse(Date.class, map.get(DbInstanceMeta.BACKUP_TIME)));
			// others
			this.setDatabase(DataParser.parse(ServiceInfo.class, map.get(DbInstanceMeta.DATABASE)));
			this.setHost(DataParser.parse(Host.class, map.get(DbInstanceMeta.HOST)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbInstanceMeta.NOTES));
				this.setLogMethod( (String)map.get(DbInstanceMeta.LOG_METHOD));
				this.setHostId( (String)map.get(DbInstanceMeta.HOST_ID));
				this.setUpdateTime( (Date)map.get(DbInstanceMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DbInstanceMeta.VERSION));
				this.setBackupDatakeep( (String)map.get(DbInstanceMeta.BACKUP_DATAKEEP));
				this.setBackupType( (String)map.get(DbInstanceMeta.BACKUP_TYPE));
				this.setLabels( (String)map.get(DbInstanceMeta.LABELS));
				this.setBackupSize( (BigDecimal)map.get(DbInstanceMeta.BACKUP_SIZE));
				this.setCreateBy( (String)map.get(DbInstanceMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbInstanceMeta.DELETED));
				this.setBackupStrategy( (String)map.get(DbInstanceMeta.BACKUP_STRATEGY));
				this.setBackupStatus( (String)map.get(DbInstanceMeta.BACKUP_STATUS));
				this.setCreateTime( (Date)map.get(DbInstanceMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DbInstanceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbInstanceMeta.DELETE_TIME));
				this.setName( (String)map.get(DbInstanceMeta.NAME));
				this.setTenantId( (String)map.get(DbInstanceMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DbInstanceMeta.DELETE_BY));
				this.setId( (String)map.get(DbInstanceMeta.ID));
				this.setBackupMethod( (String)map.get(DbInstanceMeta.BACKUP_METHOD));
				this.setDatabaseId( (String)map.get(DbInstanceMeta.DATABASE_ID));
				this.setBackupTime( (Date)map.get(DbInstanceMeta.BACKUP_TIME));
				// others
				this.setDatabase( (ServiceInfo)map.get(DbInstanceMeta.DATABASE));
				this.setHost( (Host)map.get(DbInstanceMeta.HOST));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbInstanceMeta.NOTES)));
			this.setLogMethod(DataParser.parse(String.class, r.getValue(DbInstanceMeta.LOG_METHOD)));
			this.setHostId(DataParser.parse(String.class, r.getValue(DbInstanceMeta.HOST_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbInstanceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbInstanceMeta.VERSION)));
			this.setBackupDatakeep(DataParser.parse(String.class, r.getValue(DbInstanceMeta.BACKUP_DATAKEEP)));
			this.setBackupType(DataParser.parse(String.class, r.getValue(DbInstanceMeta.BACKUP_TYPE)));
			this.setLabels(DataParser.parse(String.class, r.getValue(DbInstanceMeta.LABELS)));
			this.setBackupSize(DataParser.parse(BigDecimal.class, r.getValue(DbInstanceMeta.BACKUP_SIZE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbInstanceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbInstanceMeta.DELETED)));
			this.setBackupStrategy(DataParser.parse(String.class, r.getValue(DbInstanceMeta.BACKUP_STRATEGY)));
			this.setBackupStatus(DataParser.parse(String.class, r.getValue(DbInstanceMeta.BACKUP_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbInstanceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbInstanceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbInstanceMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(DbInstanceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DbInstanceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbInstanceMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbInstanceMeta.ID)));
			this.setBackupMethod(DataParser.parse(String.class, r.getValue(DbInstanceMeta.BACKUP_METHOD)));
			this.setDatabaseId(DataParser.parse(String.class, r.getValue(DbInstanceMeta.DATABASE_ID)));
			this.setBackupTime(DataParser.parse(Date.class, r.getValue(DbInstanceMeta.BACKUP_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbInstanceMeta.NOTES));
				this.setLogMethod( (String)r.getValue(DbInstanceMeta.LOG_METHOD));
				this.setHostId( (String)r.getValue(DbInstanceMeta.HOST_ID));
				this.setUpdateTime( (Date)r.getValue(DbInstanceMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DbInstanceMeta.VERSION));
				this.setBackupDatakeep( (String)r.getValue(DbInstanceMeta.BACKUP_DATAKEEP));
				this.setBackupType( (String)r.getValue(DbInstanceMeta.BACKUP_TYPE));
				this.setLabels( (String)r.getValue(DbInstanceMeta.LABELS));
				this.setBackupSize( (BigDecimal)r.getValue(DbInstanceMeta.BACKUP_SIZE));
				this.setCreateBy( (String)r.getValue(DbInstanceMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbInstanceMeta.DELETED));
				this.setBackupStrategy( (String)r.getValue(DbInstanceMeta.BACKUP_STRATEGY));
				this.setBackupStatus( (String)r.getValue(DbInstanceMeta.BACKUP_STATUS));
				this.setCreateTime( (Date)r.getValue(DbInstanceMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DbInstanceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbInstanceMeta.DELETE_TIME));
				this.setName( (String)r.getValue(DbInstanceMeta.NAME));
				this.setTenantId( (String)r.getValue(DbInstanceMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DbInstanceMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbInstanceMeta.ID));
				this.setBackupMethod( (String)r.getValue(DbInstanceMeta.BACKUP_METHOD));
				this.setDatabaseId( (String)r.getValue(DbInstanceMeta.DATABASE_ID));
				this.setBackupTime( (Date)r.getValue(DbInstanceMeta.BACKUP_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}