package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_APPLY_FILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbApplyFileMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 附件
 * <p>附件 , 数据表 ops_db_apply_file 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-29 22:49:32
 * @sign 9CCF4E144879493F14EFF77FE3288BCF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_apply_file")
@ApiModel(description = "附件 ; 附件 , 数据表 ops_db_apply_file 的PO类型")
public class DbApplyFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_APPLY_FILE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerId;
	
	/**
	 * SQL文件：SQL文件
	*/
	@ApiModelProperty(required = false,value="SQL文件" , notes = "SQL文件")
	private String fileId;
	
	/**
	 * 执行顺序：执行顺序
	*/
	@ApiModelProperty(required = false,value="执行顺序" , notes = "执行顺序")
	private Integer sn;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public DbApplyFile setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public DbApplyFile setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 SQL文件<br>
	 * SQL文件
	 * @return SQL文件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 SQL文件
	 * @param fileId SQL文件
	 * @return 当前对象
	*/
	public DbApplyFile setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 执行顺序<br>
	 * 执行顺序
	 * @return 执行顺序
	*/
	public Integer getSn() {
		return sn;
	}
	
	/**
	 * 设置 执行顺序
	 * @param sn 执行顺序
	 * @return 当前对象
	*/
	public DbApplyFile setSn(Integer sn) {
		this.sn=sn;
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
	public DbApplyFile setUpdateBy(String updateBy) {
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
	public DbApplyFile setUpdateTime(Date updateTime) {
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
	public DbApplyFile setDeleted(Integer deleted) {
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
	public DbApplyFile setDeleted(Boolean deletedBool) {
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
	public DbApplyFile setDeleteBy(String deleteBy) {
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
	public DbApplyFile setDeleteTime(Date deleteTime) {
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
	public DbApplyFile setCreateBy(String createBy) {
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
	public DbApplyFile setCreateTime(Date createTime) {
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
	public DbApplyFile setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbApplyFile , 转换好的 DbApplyFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbApplyFile , 转换好的 PoJo 对象
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
	public DbApplyFile clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbApplyFile duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbApplyFileMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbApplyFileMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setFileId(this.getFileId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbApplyFile clone(boolean deep) {
		return EntityContext.clone(DbApplyFile.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbApplyFile
	 * @param dbApplyFileMap 包含实体信息的 Map 对象
	 * @return DbApplyFile , 转换好的的 DbApplyFile 对象
	*/
	@Transient
	public static DbApplyFile createFrom(Map<String,Object> dbApplyFileMap) {
		if(dbApplyFileMap==null) return null;
		DbApplyFile po = create();
		EntityContext.copyProperties(po,dbApplyFileMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbApplyFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbApplyFile , 转换好的的 DbApplyFile 对象
	*/
	@Transient
	public static DbApplyFile createFrom(Object pojo) {
		if(pojo==null) return null;
		DbApplyFile po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbApplyFile，等同于 new
	 * @return DbApplyFile 对象
	*/
	@Transient
	public static DbApplyFile create() {
		return new com.dt.platform.domain.ops.meta.DbApplyFileMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(DbApplyFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbApplyFileMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbApplyFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbApplyFileMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbApplyFileMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbApplyFileMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbApplyFileMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(DbApplyFileMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, map.get(DbApplyFileMeta.SN)));
			this.setOwnerId(DataParser.parse(String.class, map.get(DbApplyFileMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbApplyFileMeta.VERSION)));
			this.setFileId(DataParser.parse(String.class, map.get(DbApplyFileMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(DbApplyFileMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbApplyFileMeta.DELETED));
				this.setUpdateBy( (String)map.get(DbApplyFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbApplyFileMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbApplyFileMeta.CREATE_TIME));
				this.setDeleteBy( (String)map.get(DbApplyFileMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(DbApplyFileMeta.UPDATE_TIME));
				this.setId( (String)map.get(DbApplyFileMeta.ID));
				this.setSn( (Integer)map.get(DbApplyFileMeta.SN));
				this.setOwnerId( (String)map.get(DbApplyFileMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(DbApplyFileMeta.VERSION));
				this.setFileId( (String)map.get(DbApplyFileMeta.FILE_ID));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbApplyFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbApplyFileMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbApplyFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbApplyFileMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbApplyFileMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbApplyFileMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbApplyFileMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(DbApplyFileMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, r.getValue(DbApplyFileMeta.SN)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(DbApplyFileMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbApplyFileMeta.VERSION)));
			this.setFileId(DataParser.parse(String.class, r.getValue(DbApplyFileMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(DbApplyFileMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbApplyFileMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(DbApplyFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbApplyFileMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbApplyFileMeta.CREATE_TIME));
				this.setDeleteBy( (String)r.getValue(DbApplyFileMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(DbApplyFileMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(DbApplyFileMeta.ID));
				this.setSn( (Integer)r.getValue(DbApplyFileMeta.SN));
				this.setOwnerId( (String)r.getValue(DbApplyFileMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(DbApplyFileMeta.VERSION));
				this.setFileId( (String)r.getValue(DbApplyFileMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}