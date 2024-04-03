package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_EXECUTE_USER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbExecuteUserMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库人员
 * <p>数据库人员 , 数据表 ops_db_execute_user 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 21:12:52
 * @sign A6A6312B8013B51F93609BC0EC2B99E1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_execute_user")
@ApiModel(description = "数据库人员 ; 数据库人员 , 数据表 ops_db_execute_user 的PO类型")
public class DbExecuteUser extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_EXECUTE_USER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String userId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * dbInfoApplyForYqList：dbInfoApplyForYqList
	*/
	@ApiModelProperty(required = false,value="dbInfoApplyForYqList" , notes = "dbInfoApplyForYqList")
	private List<DbInfoApply> dbInfoApplyForYqList;
	
	/**
	 * dbInfoApplyForYqIds：dbInfoApplyForYqIds
	*/
	@ApiModelProperty(required = false,value="dbInfoApplyForYqIds" , notes = "dbInfoApplyForYqIds")
	private List<String> dbInfoApplyForYqIds;
	
	/**
	 * dbInfoApplyForBbList：dbInfoApplyForBbList
	*/
	@ApiModelProperty(required = false,value="dbInfoApplyForBbList" , notes = "dbInfoApplyForBbList")
	private List<DbInfoApply> dbInfoApplyForBbList;
	
	/**
	 * dbInfoApplyForBbIds：dbInfoApplyForBbIds
	*/
	@ApiModelProperty(required = false,value="dbInfoApplyForBbIds" , notes = "dbInfoApplyForBbIds")
	private List<String> dbInfoApplyForBbIds;
	
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
	public DbExecuteUser setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 操作人
	 * @param userId 操作人
	 * @return 当前对象
	*/
	public DbExecuteUser setUserId(String userId) {
		this.userId=userId;
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
	public DbExecuteUser setNotes(String notes) {
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
	public DbExecuteUser setUpdateBy(String updateBy) {
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
	public DbExecuteUser setUpdateTime(Date updateTime) {
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
	public DbExecuteUser setDeleted(Integer deleted) {
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
	public DbExecuteUser setDeleted(Boolean deletedBool) {
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
	public DbExecuteUser setDeleteBy(String deleteBy) {
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
	public DbExecuteUser setDeleteTime(Date deleteTime) {
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
	public DbExecuteUser setCreateBy(String createBy) {
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
	public DbExecuteUser setCreateTime(Date createTime) {
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
	public DbExecuteUser setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 dbInfoApplyForYqList<br>
	 * dbInfoApplyForYqList
	 * @return dbInfoApplyForYqList
	*/
	public List<DbInfoApply> getDbInfoApplyForYqList() {
		return dbInfoApplyForYqList;
	}
	
	/**
	 * 设置 dbInfoApplyForYqList
	 * @param dbInfoApplyForYqList dbInfoApplyForYqList
	 * @return 当前对象
	*/
	public DbExecuteUser setDbInfoApplyForYqList(List<DbInfoApply> dbInfoApplyForYqList) {
		this.dbInfoApplyForYqList=dbInfoApplyForYqList;
		return this;
	}
	
	/**
	 * 添加 dbInfoApplyForYqList
	 * @param dbInfoApplyForYq dbInfoApplyForYqList
	 * @return 当前对象
	*/
	public DbExecuteUser addDbInfoApplyForYq(DbInfoApply... dbInfoApplyForYq) {
		if(this.dbInfoApplyForYqList==null) dbInfoApplyForYqList=new ArrayList<>();
		this.dbInfoApplyForYqList.addAll(Arrays.asList(dbInfoApplyForYq));
		return this;
	}
	
	/**
	 * 获得 dbInfoApplyForYqIds<br>
	 * dbInfoApplyForYqIds
	 * @return dbInfoApplyForYqIds
	*/
	public List<String> getDbInfoApplyForYqIds() {
		return dbInfoApplyForYqIds;
	}
	
	/**
	 * 设置 dbInfoApplyForYqIds
	 * @param dbInfoApplyForYqIds dbInfoApplyForYqIds
	 * @return 当前对象
	*/
	public DbExecuteUser setDbInfoApplyForYqIds(List<String> dbInfoApplyForYqIds) {
		this.dbInfoApplyForYqIds=dbInfoApplyForYqIds;
		return this;
	}
	
	/**
	 * 添加 dbInfoApplyForYqIds
	 * @param dbInfoApplyForYqId dbInfoApplyForYqIds
	 * @return 当前对象
	*/
	public DbExecuteUser addDbInfoApplyForYqId(String... dbInfoApplyForYqId) {
		if(this.dbInfoApplyForYqIds==null) dbInfoApplyForYqIds=new ArrayList<>();
		this.dbInfoApplyForYqIds.addAll(Arrays.asList(dbInfoApplyForYqId));
		return this;
	}
	
	/**
	 * 获得 dbInfoApplyForBbList<br>
	 * dbInfoApplyForBbList
	 * @return dbInfoApplyForBbList
	*/
	public List<DbInfoApply> getDbInfoApplyForBbList() {
		return dbInfoApplyForBbList;
	}
	
	/**
	 * 设置 dbInfoApplyForBbList
	 * @param dbInfoApplyForBbList dbInfoApplyForBbList
	 * @return 当前对象
	*/
	public DbExecuteUser setDbInfoApplyForBbList(List<DbInfoApply> dbInfoApplyForBbList) {
		this.dbInfoApplyForBbList=dbInfoApplyForBbList;
		return this;
	}
	
	/**
	 * 添加 dbInfoApplyForBbList
	 * @param dbInfoApplyForBb dbInfoApplyForBbList
	 * @return 当前对象
	*/
	public DbExecuteUser addDbInfoApplyForBb(DbInfoApply... dbInfoApplyForBb) {
		if(this.dbInfoApplyForBbList==null) dbInfoApplyForBbList=new ArrayList<>();
		this.dbInfoApplyForBbList.addAll(Arrays.asList(dbInfoApplyForBb));
		return this;
	}
	
	/**
	 * 获得 dbInfoApplyForBbIds<br>
	 * dbInfoApplyForBbIds
	 * @return dbInfoApplyForBbIds
	*/
	public List<String> getDbInfoApplyForBbIds() {
		return dbInfoApplyForBbIds;
	}
	
	/**
	 * 设置 dbInfoApplyForBbIds
	 * @param dbInfoApplyForBbIds dbInfoApplyForBbIds
	 * @return 当前对象
	*/
	public DbExecuteUser setDbInfoApplyForBbIds(List<String> dbInfoApplyForBbIds) {
		this.dbInfoApplyForBbIds=dbInfoApplyForBbIds;
		return this;
	}
	
	/**
	 * 添加 dbInfoApplyForBbIds
	 * @param dbInfoApplyForBbId dbInfoApplyForBbIds
	 * @return 当前对象
	*/
	public DbExecuteUser addDbInfoApplyForBbId(String... dbInfoApplyForBbId) {
		if(this.dbInfoApplyForBbIds==null) dbInfoApplyForBbIds=new ArrayList<>();
		this.dbInfoApplyForBbIds.addAll(Arrays.asList(dbInfoApplyForBbId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbExecuteUser , 转换好的 DbExecuteUser 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbExecuteUser , 转换好的 PoJo 对象
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
	public DbExecuteUser clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbExecuteUser duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbExecuteUserMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbExecuteUserMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setDbInfoApplyForBbIds(this.getDbInfoApplyForBbIds());
			inst.setDbInfoApplyForYqIds(this.getDbInfoApplyForYqIds());
			inst.setDbInfoApplyForBbList(this.getDbInfoApplyForBbList());
			inst.setDbInfoApplyForYqList(this.getDbInfoApplyForYqList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbExecuteUser clone(boolean deep) {
		return EntityContext.clone(DbExecuteUser.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbExecuteUser
	 * @param dbExecuteUserMap 包含实体信息的 Map 对象
	 * @return DbExecuteUser , 转换好的的 DbExecuteUser 对象
	*/
	@Transient
	public static DbExecuteUser createFrom(Map<String,Object> dbExecuteUserMap) {
		if(dbExecuteUserMap==null) return null;
		DbExecuteUser po = create();
		EntityContext.copyProperties(po,dbExecuteUserMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbExecuteUser
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbExecuteUser , 转换好的的 DbExecuteUser 对象
	*/
	@Transient
	public static DbExecuteUser createFrom(Object pojo) {
		if(pojo==null) return null;
		DbExecuteUser po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbExecuteUser，等同于 new
	 * @return DbExecuteUser 对象
	*/
	@Transient
	public static DbExecuteUser create() {
		return new com.dt.platform.domain.ops.meta.DbExecuteUserMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(DbExecuteUserMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, map.get(DbExecuteUserMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbExecuteUserMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbExecuteUserMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbExecuteUserMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbExecuteUserMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbExecuteUserMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbExecuteUserMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(DbExecuteUserMeta.ID)));
			this.setUserId(DataParser.parse(String.class, map.get(DbExecuteUserMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbExecuteUserMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(DbExecuteUserMeta.CREATE_BY));
				this.setNotes( (String)map.get(DbExecuteUserMeta.NOTES));
				this.setDeleted( (Integer)map.get(DbExecuteUserMeta.DELETED));
				this.setUpdateBy( (String)map.get(DbExecuteUserMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbExecuteUserMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbExecuteUserMeta.CREATE_TIME));
				this.setDeleteBy( (String)map.get(DbExecuteUserMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(DbExecuteUserMeta.UPDATE_TIME));
				this.setId( (String)map.get(DbExecuteUserMeta.ID));
				this.setUserId( (String)map.get(DbExecuteUserMeta.USER_ID));
				this.setVersion( (Integer)map.get(DbExecuteUserMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbExecuteUserMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(DbExecuteUserMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbExecuteUserMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbExecuteUserMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbExecuteUserMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbExecuteUserMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbExecuteUserMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbExecuteUserMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(DbExecuteUserMeta.ID)));
			this.setUserId(DataParser.parse(String.class, r.getValue(DbExecuteUserMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbExecuteUserMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(DbExecuteUserMeta.CREATE_BY));
				this.setNotes( (String)r.getValue(DbExecuteUserMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(DbExecuteUserMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(DbExecuteUserMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbExecuteUserMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbExecuteUserMeta.CREATE_TIME));
				this.setDeleteBy( (String)r.getValue(DbExecuteUserMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(DbExecuteUserMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(DbExecuteUserMeta.ID));
				this.setUserId( (String)r.getValue(DbExecuteUserMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(DbExecuteUserMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}