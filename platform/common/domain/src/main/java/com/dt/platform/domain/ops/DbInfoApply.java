package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_INFO_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbInfoApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 变更数据库
 * <p>变更数据库 , 数据表 ops_db_info_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 17:57:36
 * @sign 323CA524DE76C673121F39F41E7E8A82
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_info_apply")
@ApiModel(description = "变更数据库 ; 变更数据库 , 数据表 ops_db_info_apply 的PO类型")
public class DbInfoApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_INFO_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "826842666317643776")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "12")
	private String code;
	
	/**
	 * 数据库全名：数据库全名
	*/
	@ApiModelProperty(required = false,value="数据库全名" , notes = "数据库全名" , example = "12")
	private String dbFullName;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库" , example = "12")
	private String dbName;
	
	/**
	 * 数据库IP：数据库IP
	*/
	@ApiModelProperty(required = false,value="数据库IP" , notes = "数据库IP" , example = "12")
	private String dbIp;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口" , example = "12")
	private String dbPort;
	
	/**
	 * 关联系统：关联系统
	*/
	@ApiModelProperty(required = false,value="关联系统" , notes = "关联系统")
	private String associatedSystem;
	
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
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-31 03:37:34")
	private Date createTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * dataRange：dataRange
	*/
	@ApiModelProperty(required = false,value="dataRange" , notes = "dataRange")
	private String dataRange;
	
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
	public DbInfoApply setId(String id) {
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
	public DbInfoApply setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 数据库全名<br>
	 * 数据库全名
	 * @return 数据库全名
	*/
	public String getDbFullName() {
		return dbFullName;
	}
	
	/**
	 * 设置 数据库全名
	 * @param dbFullName 数据库全名
	 * @return 当前对象
	*/
	public DbInfoApply setDbFullName(String dbFullName) {
		this.dbFullName=dbFullName;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbName() {
		return dbName;
	}
	
	/**
	 * 设置 数据库
	 * @param dbName 数据库
	 * @return 当前对象
	*/
	public DbInfoApply setDbName(String dbName) {
		this.dbName=dbName;
		return this;
	}
	
	/**
	 * 获得 数据库IP<br>
	 * 数据库IP
	 * @return 数据库IP
	*/
	public String getDbIp() {
		return dbIp;
	}
	
	/**
	 * 设置 数据库IP
	 * @param dbIp 数据库IP
	 * @return 当前对象
	*/
	public DbInfoApply setDbIp(String dbIp) {
		this.dbIp=dbIp;
		return this;
	}
	
	/**
	 * 获得 端口<br>
	 * 端口
	 * @return 端口
	*/
	public String getDbPort() {
		return dbPort;
	}
	
	/**
	 * 设置 端口
	 * @param dbPort 端口
	 * @return 当前对象
	*/
	public DbInfoApply setDbPort(String dbPort) {
		this.dbPort=dbPort;
		return this;
	}
	
	/**
	 * 获得 关联系统<br>
	 * 关联系统
	 * @return 关联系统
	*/
	public String getAssociatedSystem() {
		return associatedSystem;
	}
	
	/**
	 * 设置 关联系统
	 * @param associatedSystem 关联系统
	 * @return 当前对象
	*/
	public DbInfoApply setAssociatedSystem(String associatedSystem) {
		this.associatedSystem=associatedSystem;
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
	public DbInfoApply setUpdateBy(String updateBy) {
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
	public DbInfoApply setUpdateTime(Date updateTime) {
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
	public DbInfoApply setDeleted(Integer deleted) {
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
	public DbInfoApply setDeleted(Boolean deletedBool) {
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
	public DbInfoApply setDeleteBy(String deleteBy) {
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
	public DbInfoApply setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public DbInfoApply setCreateBy(String createBy) {
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
	public DbInfoApply setCreateTime(Date createTime) {
		this.createTime=createTime;
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
	public DbInfoApply setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 dataRange<br>
	 * dataRange
	 * @return dataRange
	*/
	public String getDataRange() {
		return dataRange;
	}
	
	/**
	 * 设置 dataRange
	 * @param dataRange dataRange
	 * @return 当前对象
	*/
	public DbInfoApply setDataRange(String dataRange) {
		this.dataRange=dataRange;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbInfoApply , 转换好的 DbInfoApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbInfoApply , 转换好的 PoJo 对象
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
	public DbInfoApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbInfoApply duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbInfoApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbInfoApplyMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setDbName(this.getDbName());
		inst.setDbFullName(this.getDbFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDbIp(this.getDbIp());
		inst.setVersion(this.getVersion());
		inst.setDbPort(this.getDbPort());
		inst.setAssociatedSystem(this.getAssociatedSystem());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setDataRange(this.getDataRange());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbInfoApply clone(boolean deep) {
		return EntityContext.clone(DbInfoApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbInfoApply
	 * @param dbInfoApplyMap 包含实体信息的 Map 对象
	 * @return DbInfoApply , 转换好的的 DbInfoApply 对象
	*/
	@Transient
	public static DbInfoApply createFrom(Map<String,Object> dbInfoApplyMap) {
		if(dbInfoApplyMap==null) return null;
		DbInfoApply po = create();
		EntityContext.copyProperties(po,dbInfoApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbInfoApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbInfoApply , 转换好的的 DbInfoApply 对象
	*/
	@Transient
	public static DbInfoApply createFrom(Object pojo) {
		if(pojo==null) return null;
		DbInfoApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbInfoApply，等同于 new
	 * @return DbInfoApply 对象
	*/
	@Transient
	public static DbInfoApply create() {
		return new com.dt.platform.domain.ops.meta.DbInfoApplyMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(DbInfoApplyMeta.CODE)));
			this.setDbName(DataParser.parse(String.class, map.get(DbInfoApplyMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, map.get(DbInfoApplyMeta.DB_FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbInfoApplyMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, map.get(DbInfoApplyMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbInfoApplyMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, map.get(DbInfoApplyMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, map.get(DbInfoApplyMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbInfoApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbInfoApplyMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbInfoApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbInfoApplyMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbInfoApplyMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbInfoApplyMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbInfoApplyMeta.ID)));
			// others
			this.setDataRange(DataParser.parse(String.class, map.get(DbInfoApplyMeta.DATA_RANGE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(DbInfoApplyMeta.CODE));
				this.setDbName( (String)map.get(DbInfoApplyMeta.DB_NAME));
				this.setDbFullName( (String)map.get(DbInfoApplyMeta.DB_FULL_NAME));
				this.setUpdateTime( (Date)map.get(DbInfoApplyMeta.UPDATE_TIME));
				this.setDbIp( (String)map.get(DbInfoApplyMeta.DB_IP));
				this.setVersion( (Integer)map.get(DbInfoApplyMeta.VERSION));
				this.setDbPort( (String)map.get(DbInfoApplyMeta.DB_PORT));
				this.setAssociatedSystem( (String)map.get(DbInfoApplyMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)map.get(DbInfoApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbInfoApplyMeta.DELETED));
				this.setUpdateBy( (String)map.get(DbInfoApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbInfoApplyMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbInfoApplyMeta.CREATE_TIME));
				this.setDeleteBy( (String)map.get(DbInfoApplyMeta.DELETE_BY));
				this.setId( (String)map.get(DbInfoApplyMeta.ID));
				// others
				this.setDataRange( (String)map.get(DbInfoApplyMeta.DATA_RANGE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.CODE)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.DB_FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbInfoApplyMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbInfoApplyMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbInfoApplyMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbInfoApplyMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbInfoApplyMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbInfoApplyMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(DbInfoApplyMeta.CODE));
				this.setDbName( (String)r.getValue(DbInfoApplyMeta.DB_NAME));
				this.setDbFullName( (String)r.getValue(DbInfoApplyMeta.DB_FULL_NAME));
				this.setUpdateTime( (Date)r.getValue(DbInfoApplyMeta.UPDATE_TIME));
				this.setDbIp( (String)r.getValue(DbInfoApplyMeta.DB_IP));
				this.setVersion( (Integer)r.getValue(DbInfoApplyMeta.VERSION));
				this.setDbPort( (String)r.getValue(DbInfoApplyMeta.DB_PORT));
				this.setAssociatedSystem( (String)r.getValue(DbInfoApplyMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)r.getValue(DbInfoApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbInfoApplyMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(DbInfoApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbInfoApplyMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbInfoApplyMeta.CREATE_TIME));
				this.setDeleteBy( (String)r.getValue(DbInfoApplyMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbInfoApplyMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}